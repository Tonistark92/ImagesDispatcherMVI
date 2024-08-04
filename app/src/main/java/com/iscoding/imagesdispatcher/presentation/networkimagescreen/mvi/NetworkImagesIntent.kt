package com.iscoding.imagesdispatcher.presentation.networkimagescreen.mvi

sealed class NetworkImagesScreenIntent {
    data object LoadData : NetworkImagesScreenIntent()
}
internal sealed interface Action {
    object LoadInitialData : Action
}
