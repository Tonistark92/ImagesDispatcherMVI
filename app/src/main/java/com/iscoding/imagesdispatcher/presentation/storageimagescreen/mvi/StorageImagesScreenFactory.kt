package com.iscoding.imagesdispatcher.presentation.storageimagescreen.mvi

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


interface StorageImagesScreenStore :
    Store<StorageImagesScreenIntent, StorageImagesScreenState, Nothing>

class StorageImagesScreenStoreFactory(
    private val storeFactory: StoreFactory,
    private val getImagesUseCase: GetImagesUseCase

) {
    fun create(): StorageImagesScreenStore =
        object : StorageImagesScreenStore, Store<StorageImagesScreenIntent,StorageImagesScreenState, Nothing> by storeFactory.create(
            name = "StorageImagesScreenStore",
            initialState = StorageImagesScreenState(),
            bootstrapper = SimpleBootstrapper(Action.LoadInitialData),
            executorFactory = { StorageImagesScreenExecutor(getImagesUseCase) },
            reducer = StorageImagesScreenReducer()
        ) {}

    private class StorageImagesScreenExecutor(
        private val getImagesUseCase: GetImagesUseCase


    ) : CoroutineExecutor<StorageImagesScreenIntent, Action, StorageImagesScreenState, StorageImagesScreenResult, Nothing>() {
        override fun executeAction(action: Action, getState: () -> StorageImagesScreenState) {
            when (action) {
                is Action.LoadInitialData -> {
                    scope.launch {
                        try {
                            val data = getImagesUseCase()
                            dispatch(StorageImagesScreenResult.Loading(true))
                            delay(2000)
                            dispatch(StorageImagesScreenResult.DataLoaded(data))

                            dispatch(StorageImagesScreenResult.Loading(false))

                        } catch (e: Exception) {
                            dispatch(StorageImagesScreenResult.Error(e.message ?: "Unknown error"))
                        }
                    }
                }
            }
        }
        override fun executeIntent(intent: StorageImagesScreenIntent, getState: () -> StorageImagesScreenState) {
            when (intent) {
                is StorageImagesScreenIntent.LoadData ->scope.launch {
                    try {
                        val data = getImagesUseCase()
                        dispatch(StorageImagesScreenResult.Loading(true))
                        delay(2000)
                        dispatch(StorageImagesScreenResult.DataLoaded(data))

                        dispatch(StorageImagesScreenResult.Loading(false))
                    } catch (e: Exception) {
                        dispatch(StorageImagesScreenResult.Error(e.message ?: "Unknown error"))
                    }
                }

            }
        }
    }

    private class StorageImagesScreenReducer :
        Reducer<StorageImagesScreenState, StorageImagesScreenResult> {
        override fun StorageImagesScreenState.reduce(msg: StorageImagesScreenResult): StorageImagesScreenState {
            return when (msg) {
                is StorageImagesScreenResult.DataLoaded -> copy(data = msg.data, isLoading = false)
                is StorageImagesScreenResult.Error -> copy(error = msg.message, isLoading = false)
                is StorageImagesScreenResult.Loading -> copy( isLoading = msg.isLoading)
            }
        }
    }
}