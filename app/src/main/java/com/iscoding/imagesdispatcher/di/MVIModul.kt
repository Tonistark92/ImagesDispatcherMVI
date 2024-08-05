package com.iscoding.imagesdispatcher.di

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.iscoding.imagesdispatcher.data.repository.NetworkImagesDispatcherRepository
import com.iscoding.imagesdispatcher.presentation.networkimagescreen.mvi.NetworkImagesScreenStoreFactory
import com.iscoding.imagesdispatcher.presentation.resourcesimagescreen.mvi.ResourcesImagesScreenStoreFactory
import com.iscoding.imagesdispatcher.presentation.storageimagescreen.mvi.StorageImagesScreenStoreFactory
import org.koin.dsl.module

val mviModule = module {
    single<StoreFactory> { DefaultStoreFactory() }
    single {
        NetworkImagesScreenStoreFactory(
            storeFactory = get(),
            repository = get(networkQualifier)
        )
    }
    single {
        ResourcesImagesScreenStoreFactory(
            storeFactory = get(), repository = get(
                resourcesQualifier
            )
        )
    }
    single {
        StorageImagesScreenStoreFactory(
            storeFactory = get(), repository = get(
                storageQualifier
            )
        )
    }

//    // Provide StoreFactory
//    single { DefaultStoreFactory() }
//
//    // Provide NetworkImagesScreenStoreFactory
//    factory { (storeFactory: DefaultStoreFactory) ->
//        NetworkImagesScreenStoreFactory(storeFactory)
//    }
}