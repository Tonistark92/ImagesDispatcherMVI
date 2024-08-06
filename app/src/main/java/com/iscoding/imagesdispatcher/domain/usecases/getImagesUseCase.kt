package com.iscoding.imagesdispatcher.domain.usecases

import com.iscoding.imagesdispatcher.domain.repository.ImagesDispatcherRepository


class GetImagesUseCase  constructor(
    private val repository: ImagesDispatcherRepository
) {
    suspend operator fun invoke() = repository.getImages()
}