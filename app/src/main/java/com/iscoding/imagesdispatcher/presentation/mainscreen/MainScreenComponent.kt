package com.iscoding.imagesdispatcher.presentation.mainscreen

import com.arkivanov.decompose.ComponentContext

class MainScreenComponent (
    componentContext: ComponentContext,
    val onNavigateToNetworkImages: () -> Unit,
    val onNavigateToStorageImages: () -> Unit,
    val onNavigateToResourcesImages: () -> Unit,
): ComponentContext by componentContext {

    fun navegateToNetworkImages() {
        onNavigateToNetworkImages()
    }

    fun navigateToResourcesImages() {
        onNavigateToResourcesImages()
    }

    fun navigateToStorageImages() {
        onNavigateToStorageImages()
    }
}