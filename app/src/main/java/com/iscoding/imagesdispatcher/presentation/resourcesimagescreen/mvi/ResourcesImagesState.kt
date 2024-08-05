package com.iscoding.imagesdispatcher.presentation.resourcesimagescreen.mvi

data class ResourcesImagesScreenState(
    val data: List<Any> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
sealed class ResourcesImagesScreenResult {
    data class DataLoaded(val data: List<Any>) : ResourcesImagesScreenResult()
    data class Error(val message: String) : ResourcesImagesScreenResult()
}