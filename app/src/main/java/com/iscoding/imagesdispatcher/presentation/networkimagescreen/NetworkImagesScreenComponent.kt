package com.iscoding.imagesdispatcher.presentation.networkimagescreen

import com.arkivanov.decompose.ComponentContext
import com.iscoding.imagesdispatcher.presentation.networkimagescreen.mvi.NetworkImagesScreenIntent
import com.iscoding.imagesdispatcher.presentation.networkimagescreen.mvi.NetworkImagesScreenStoreFactory

class NetworkImagesScreenComponent(
    componentContext: ComponentContext,
    networkImagesScreenstoreFactory: NetworkImagesScreenStoreFactory
): ComponentContext by componentContext {

    var store = networkImagesScreenstoreFactory.create()

    fun onLoadNetworkImages() {
        store.accept(NetworkImagesScreenIntent.LoadData)

    }

}