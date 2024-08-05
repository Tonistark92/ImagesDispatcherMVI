package com.iscoding.imagesdispatcher.presentation.storageimagescreen.mvi

data class StorageImagesScreenState(
    val data: List<Any> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
sealed class StorageImagesScreenResult {
    data class DataLoaded(val data: List<Any>) : StorageImagesScreenResult()
    data class Error(val message: String) : StorageImagesScreenResult()
}