package com.iscoding.imagesdispatcher.presentation.networkimagescreen

import com.arkivanov.decompose.ComponentContext
import com.iscoding.imagesdispatcher.presentation.networkimagescreen.mvi.NetworkImagesScreenIntent
import com.iscoding.imagesdispatcher.presentation.networkimagescreen.mvi.NetworkImagesScreenStoreFactory

class NetworkImagesScreenComponent(
    componentContext: ComponentContext,
    storeFactory: NetworkImagesScreenStoreFactory
): ComponentContext by componentContext {

    var store = storeFactory.create()

    fun onLoadNetworkImages() {
        store.accept(NetworkImagesScreenIntent.LoadData)

    }

}