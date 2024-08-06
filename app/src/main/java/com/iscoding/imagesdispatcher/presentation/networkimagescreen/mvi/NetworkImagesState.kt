package com.iscoding.imagesdispatcher.presentation.networkimagescreen.mvi

data class NetworkImagesScreenState(
    val data: List<Any> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
sealed class NetworkImagesScreenResult {
    data class DataLoaded(val data: List<Any>) : NetworkImagesScreenResult()
    data class Error(val message: String) : NetworkImagesScreenResult()
    data class Loading(val isLoading: Boolean) : NetworkImagesScreenResult()
}