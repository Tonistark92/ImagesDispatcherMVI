package com.iscoding.imagesdispatcher.di

import com.arkivanov.decompose.ComponentContext
import com.iscoding.imagesdispatcher.presentation.mainscreen.MainScreenComponent
import com.iscoding.imagesdispatcher.presentation.networkimagescreen.NetworkImagesScreenComponent
import com.iscoding.imagesdispatcher.presentation.resourcesimagescreen.ResourcesImagesScreenComponent
import com.iscoding.imagesdispatcher.presentation.navigation.RootComponent
import com.iscoding.imagesdispatcher.presentation.storageimagescreen.StorageImagesScreenComponent
import org.koin.core.qualifier.named
import org.koin.dsl.module

val navigationModule = module {
//    factory { (componentContext: ComponentContext) ->
//        RootComponent(componentContext)
//    }
    scope(named<RootComponent>()) {
        scoped { (componentContext: ComponentContext) ->
            RootComponent(componentContext, get(), get () , get())
        }
    }
    factory { (componentContext: ComponentContext) ->
        NetworkImagesScreenComponent(componentContext,get())
    }
    factory { (componentContext: ComponentContext) ->
        ResourcesImagesScreenComponent(componentContext ,get())
    }
    factory { (componentContext: ComponentContext) ->
        StorageImagesScreenComponent(componentContext, get())
    }
    factory { (componentContext: ComponentContext, onNavigateToNetworkImages: () -> Unit, onNavigateToStorageImages: () -> Unit, onNavigateToResourcesImages: () -> Unit) ->
        MainScreenComponent(componentContext, onNavigateToNetworkImages, onNavigateToStorageImages, onNavigateToResourcesImages)
    }
}