package com.iscoding.imagesdispatcher.presentation.networkimagescreen.mvi
/// ***********

//that was for test only

/// *********
//import android.app.Notification
//import com.arkivanov.mvikotlin.core.store.Reducer
//import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
//import com.arkivanov.mvikotlin.core.store.Store
//import com.arkivanov.mvikotlin.core.store.StoreFactory
//import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
//import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
//import com.iscoding.imagesdispatcher.domain.repository.ImagesDispatcherRepository
//import kotlinx.coroutines.launch
//import org.koin.java.KoinJavaComponent.inject
//
//data class NetworkImagesScreenState(
//    val data: List<String> = emptyList(),
//    val isLoading: Boolean = false,
//    val error: String? = null
//)
//sealed class NetworkImagesScreenIntent {
//    data object LoadData : NetworkImagesScreenIntent()
//}
//internal sealed interface Action {
//    object LoadInitialData : Action
//}
//
//sealed class NetworkImagesScreenResult {
//    data class DataLoaded(val data: List<String>) : NetworkImagesScreenResult()
//    data class Error(val message: String) : NetworkImagesScreenResult()
//}
//interface NetworkImagesScreenStore : Store<NetworkImagesScreenIntent, NetworkImagesScreenState, Nothing>
//
//class NetworkImagesScreenStoreFactory(
//    private val storeFactory: StoreFactory,
//private val repository: ImagesDispatcherRepository
//) {
//    fun create(): NetworkImagesScreenStore =
//        object : NetworkImagesScreenStore, Store<NetworkImagesScreenIntent, NetworkImagesScreenState, Nothing> by storeFactory.create(
//            name = "NetworkImagesScreenStore",
//            initialState = NetworkImagesScreenState(),
//            bootstrapper = SimpleBootstrapper(Action.LoadInitialData),
//            executorFactory = { NetworkImagesScreenSExecutor(repository) },
//            reducer = ScreenAReducer()
//        ) {}
//
//    private class NetworkImagesScreenSExecutor(
//        private val repository: ImagesDispatcherRepository
//
//    ) : CoroutineExecutor<NetworkImagesScreenIntent, Action, NetworkImagesScreenState, NetworkImagesScreenResult, Nothing>() {
//        override fun executeAction(action: Action, getState: () -> NetworkImagesScreenState) {
//            when (action) {
//                is Action.LoadInitialData -> {
//                    scope.launch {
//                        try {
//                            val data = repository.getImages()
//                            dispatch(NetworkImagesScreenResult.DataLoaded(data))
//                        } catch (e: Exception) {
//                            dispatch(NetworkImagesScreenResult.Error(e.message ?: "Unknown error"))
//                        }
//                    }
//                }
//            }
//        }
//        override fun executeIntent(intent: NetworkImagesScreenIntent, getState: () -> NetworkImagesScreenState) {
//            when (intent) {
//                is NetworkImagesScreenIntent.LoadData ->scope.launch {
//                    try {
//                        val data = repository.getImages()
//                        dispatch(NetworkImagesScreenResult.DataLoaded(data))
//                    } catch (e: Exception) {
//                        dispatch(NetworkImagesScreenResult.Error(e.message ?: "Unknown error"))
//                    }
//                }
//
//            }
//        }
//    }
////    private class BootstrapperImpl : CoroutineBootstrapper<Action>() {
////        override fun invoke() {
////            scope.launch {
////                val sum = withContext(Dispatchers.Default) { (1L..1000000.toLong()).sum() }
////                dispatch(Action.SetValue(sum))
////            }
////        }
////    }
//
//    private class ScreenAReducer : Reducer<NetworkImagesScreenState, NetworkImagesScreenResult> {
//        override fun NetworkImagesScreenState.reduce(msg: NetworkImagesScreenResult): NetworkImagesScreenState {
//            return when (msg) {
//                is NetworkImagesScreenResult.DataLoaded -> copy(data = msg.data, isLoading = false)
//                is NetworkImagesScreenResult.Error -> copy(error = msg.message, isLoading = false)
//            }
//        }
//    }
//
//}
