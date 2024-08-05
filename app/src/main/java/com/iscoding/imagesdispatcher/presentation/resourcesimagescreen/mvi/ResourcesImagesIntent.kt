package com.iscoding.imagesdispatcher.presentation.resourcesimagescreen.mvi

sealed class ResourcesImagesScreenIntent {
    data object LoadData : ResourcesImagesScreenIntent()
}
internal sealed interface Action {
    data object LoadInitialData : Action
}
