package com.iscoding.imagesdispatcher.presentation.resourcesimagescreen.mvi

import android.util.Log
import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.iscoding.imagesdispatcher.domain.repository.ImagesDispatcherRepository
import com.iscoding.imagesdispatcher.domain.usecases.GetImagesUseCase
import com.iscoding.imagesdispatcher.presentation.networkimagescreen.mvi.Action
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

interface ResourcesImagesScreenStore :
    Store<ResourcesImagesScreenIntent, ResourcesImagesScreenState, Nothing>

class ResourcesImagesScreenStoreFactory(
    private val storeFactory: StoreFactory,
    private val getImagesUseCase: GetImagesUseCase

) {
    fun create(): ResourcesImagesScreenStore =
        object : ResourcesImagesScreenStore, Store<ResourcesImagesScreenIntent, ResourcesImagesScreenState, Nothing> by storeFactory.create(
            name = "ResourcesImagesScreenStore",
            initialState = ResourcesImagesScreenState(),
            bootstrapper = SimpleBootstrapper(Action.LoadInitialData),
            executorFactory = { ResourcesImagesScreenExecutor(getImagesUseCase) },
            reducer = ResourcesImagesScreenReducer()
        ) {}

    private class ResourcesImagesScreenExecutor(
        private val getImagesUseCase: GetImagesUseCase


    ) : CoroutineExecutor<ResourcesImagesScreenIntent, Action, ResourcesImagesScreenState, ResourcesImagesScreenResult, Nothing>() {
        override fun executeAction(action: Action, getState: () -> ResourcesImagesScreenState) {
            when (action) {
                is Action.LoadInitialData -> {
                    scope.launch {
                        try {
                            val data = getImagesUseCase()

                            dispatch(ResourcesImagesScreenResult.Loading(true))
                            delay(2000)

                            dispatch(ResourcesImagesScreenResult.DataLoaded(data))
                            dispatch(ResourcesImagesScreenResult.Loading(false))

                        } catch (e: Exception) {
                            dispatch(ResourcesImagesScreenResult.Error(e.message ?: "Unknown error"))
                        }
                    }
                }
            }
        }
        override fun executeIntent(intent: ResourcesImagesScreenIntent, getState: () -> ResourcesImagesScreenState) {
            when (intent) {
                is ResourcesImagesScreenIntent.LoadData ->scope.launch {
                    try {
                        val data = getImagesUseCase()
                        dispatch(ResourcesImagesScreenResult.Loading(true))
                        delay(2000)

                        dispatch(ResourcesImagesScreenResult.DataLoaded(data))
                        dispatch(ResourcesImagesScreenResult.Loading(false))
                    } catch (e: Exception) {
                        dispatch(ResourcesImagesScreenResult.Error(e.message ?: "Unknown error"))
                    }
                }

            }
        }
    }

    private class ResourcesImagesScreenReducer : Reducer<ResourcesImagesScreenState, ResourcesImagesScreenResult> {
        override fun ResourcesImagesScreenState.reduce(msg: ResourcesImagesScreenResult): ResourcesImagesScreenState {
            return when (msg) {
                is ResourcesImagesScreenResult.DataLoaded -> copy(data = msg.data, isLoading = false)
                is ResourcesImagesScreenResult.Error -> copy(error = msg.message, isLoading = false)
                is ResourcesImagesScreenResult.Loading -> copy( isLoading = msg.isLoading)
            }
        }
    }
}