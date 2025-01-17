package com.iscoding.imagesdispatcher.di

import android.content.Context
import com.iscoding.imagesdispatcher.data.repository.NetworkImagesDispatcherRepository
import com.iscoding.imagesdispatcher.data.repository.ResourcesImagesDispatcherRepository
import com.iscoding.imagesdispatcher.data.repository.StorageImagesDispatcherRepository
import com.iscoding.imagesdispatcher.domain.repository.ImagesDispatcherRepository
import com.iscoding.imagesdispatcher.domain.usecases.GetImagesUseCase
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkQualifier = named("Network")
val resourcesQualifier = named("Resources")
val storageQualifier = named("Storage")
val repositoryModule = module  {

    single<ImagesDispatcherRepository>(networkQualifier) { NetworkImagesDispatcherRepository() }
    single<ImagesDispatcherRepository>(resourcesQualifier) { ResourcesImagesDispatcherRepository(get<Context>()) }
    single<ImagesDispatcherRepository>(storageQualifier) { StorageImagesDispatcherRepository(get<Context>()) }

    factory(named("Network")) { GetImagesUseCase(get(networkQualifier)) }
    factory(named("Resources")) { GetImagesUseCase(get(resourcesQualifier)) }
    factory(named("Storage")) { GetImagesUseCase(get(storageQualifier)) }



}