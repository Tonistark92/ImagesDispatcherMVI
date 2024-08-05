package com.iscoding.imagesdispatcher.presentation.storageimagescreen

import com.arkivanov.decompose.ComponentContext
import com.iscoding.imagesdispatcher.presentation.storageimagescreen.mvi.StorageImagesScreenIntent
import com.iscoding.imagesdispatcher.presentation.storageimagescreen.mvi.StorageImagesScreenStoreFactory

class StorageImagesScreenComponent (
    componentContext: ComponentContext,
    private val storageImagesScreenStoreFactory: StorageImagesScreenStoreFactory,
    ): ComponentContext by componentContext {

    var store = storageImagesScreenStoreFactory.create()

    fun onLoadStorageImages() {
        store.accept(StorageImagesScreenIntent.LoadData)

    }
    }