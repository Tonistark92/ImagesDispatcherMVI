package com.iscoding.imagesdispatcher.presentation.storageimagescreen.mvi

sealed class StorageImagesScreenIntent {
    data object LoadData : StorageImagesScreenIntent()
}
internal sealed interface Action {
    data object LoadInitialData : Action
}
