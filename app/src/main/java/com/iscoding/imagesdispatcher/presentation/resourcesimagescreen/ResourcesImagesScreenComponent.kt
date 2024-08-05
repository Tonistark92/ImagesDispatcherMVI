package com.iscoding.imagesdispatcher.presentation.resourcesimagescreen

import com.arkivanov.decompose.ComponentContext
import com.iscoding.imagesdispatcher.presentation.networkimagescreen.mvi.NetworkImagesScreenIntent
import com.iscoding.imagesdispatcher.presentation.resourcesimagescreen.mvi.ResourcesImagesScreenIntent
import com.iscoding.imagesdispatcher.presentation.resourcesimagescreen.mvi.ResourcesImagesScreenStoreFactory

class ResourcesImagesScreenComponent (
    componentContext: ComponentContext,
    private val resourcesImagesScreenStoreFactory: ResourcesImagesScreenStoreFactory,
    ): ComponentContext by componentContext {

    var store = resourcesImagesScreenStoreFactory.create()

    fun onLoadResourcesImages() {
        store.accept(ResourcesImagesScreenIntent.LoadData)

    }
    }