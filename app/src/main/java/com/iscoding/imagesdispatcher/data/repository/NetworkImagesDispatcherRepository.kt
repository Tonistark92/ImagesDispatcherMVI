package com.iscoding.imagesdispatcher.data.repository

import com.iscoding.imagesdispatcher.domain.repository.ImagesDispatcherRepository

class NetworkImagesDispatcherRepository : ImagesDispatcherRepository {
    override suspend fun getImages(): List<Any> {
        return listOf(
            "https://cdn.pixabay.com/photo/2015/10/18/18/07/android-994910_1280.jpg",
            "https://cdn.pixabay.com/photo/2017/08/30/18/39/android-2698158_1280.jpg",

            "https://cdn.pixabay.com/photo/2017/08/30/18/39/android-2698158_1280.jpg",
            "https://media.istockphoto.com/id/1496672997/photo/human-like-robot.jpg?s=2048x2048&w=is&k=20&c=gePXvedUOu8BvnEL-7Kit2WfesnmmJuu1RxvGVrHFdw=",

            "https://cdn.pixabay.com/photo/2018/05/08/21/27/android-3383992_1280.png",
            "https://media.istockphoto.com/id/1496672997/photo/human-like-robot.jpg?s=2048x2048&w=is&k=20&c=gePXvedUOu8BvnEL-7Kit2WfesnmmJuu1RxvGVrHFdw=",
            "https://cdn.pixabay.com/photo/2015/10/18/18/07/android-994910_1280.jpg",

            )
    }
}