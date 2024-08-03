package com.iscoding.imagesdispatcher.presentation.networkimagescreen.mvi

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import kotlinx.coroutines.launch

data class NetworkImagesScreenState(
    val data: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
sealed class NetworkImagesScreenIntent {
    data object LoadData : NetworkImagesScreenIntent()
}

sealed class NetworkImagesScreenResult {
    data class DataLoaded(val data: List<String>) : NetworkImagesScreenResult()
    data class Error(val message: String) : NetworkImagesScreenResult()
}
interface NetworkImagesScreenStore : Store<NetworkImagesScreenIntent, NetworkImagesScreenState, Nothing>

class NetworkImagesScreenStoreFactory(
    private val storeFactory: StoreFactory,
//    private val repository: DataRepository
) {
    fun create(): NetworkImagesScreenStore =
        object : NetworkImagesScreenStore, Store<NetworkImagesScreenIntent, NetworkImagesScreenState, Nothing> by storeFactory.create(
            name = "ScreenAStore",
            initialState = NetworkImagesScreenState(),
            bootstrapper = SimpleBootstrapper(Unit),
            executorFactory = { NetworkImagesScreenSExecutor() },
            reducer = ScreenAReducer()
        ) {}

    private class NetworkImagesScreenSExecutor(
//        private val repository: DataRepository
    ) : CoroutineExecutor<NetworkImagesScreenIntent, Unit, NetworkImagesScreenState, NetworkImagesScreenResult, Nothing>() {
        override fun executeIntent(intent: NetworkImagesScreenIntent, getState: () -> NetworkImagesScreenState) {
            when (intent) {
                is NetworkImagesScreenIntent.LoadData ->scope.launch {
                    try {
//                        val data = repository.getData()
                        dispatch(NetworkImagesScreenResult.DataLoaded(listOf()))
                    } catch (e: Exception) {
                        dispatch(NetworkImagesScreenResult.Error(e.message ?: "Unknown error"))
                    }
                }
            }
        }
    }

    private class ScreenAReducer : Reducer<NetworkImagesScreenState, NetworkImagesScreenResult> {
        override fun NetworkImagesScreenState.reduce(msg: NetworkImagesScreenResult): NetworkImagesScreenState {
            return when (msg) {
                is NetworkImagesScreenResult.DataLoaded -> copy(data = msg.data, isLoading = false)
                is NetworkImagesScreenResult.Error -> copy(error = msg.message, isLoading = false)
            }
        }
    }
}