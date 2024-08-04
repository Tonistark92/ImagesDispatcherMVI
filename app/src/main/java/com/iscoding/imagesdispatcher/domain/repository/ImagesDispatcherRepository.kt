package com.iscoding.imagesdispatcher.domain.repository

interface ImagesDispatcherRepository {

   suspend fun getImages(): List<Any>
}