package com.iscoding.imagesdispatcher.data.repository

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.iscoding.imagesdispatcher.R
import com.iscoding.imagesdispatcher.domain.repository.ImagesDispatcherRepository
import kotlin.reflect.KClass

class ResourcesImagesDispatcherRepository(private val context: Context) : ImagesDispatcherRepository {
    override suspend fun getImages(): List<Any> {
      return  loadImagesFromResources(context)
    }

    fun loadImagesFromResources(context: Context): List<ResourceImage> {
        val resourceImages = listOf(
           R.drawable.image1
        )

        val images = mutableListOf<ResourceImage>()

        for (resId in resourceImages) {
            val drawable = ResourcesCompat.getDrawable(context.resources, resId, null)
            val name = context.resources.getResourceEntryName(resId)
            images.add(ResourceImage(name, drawable))
        }

        return images
    }


}
data class ResourceImage(
    val name: String,
    val drawable: Drawable?
)


//fun loadImagesFromResources(context: Context): List<ResourceImage> {
//    val drawablesClass: KClass<*> = R.drawable::class
//    val fields = drawablesClass.java.declaredFields
//
//    val images = mutableListOf<ResourceImage>()
//
//    for (field in fields) {
//        try {
//            val resourceId = field.getInt(null)
//            val resourceName = field.name
//            val extension = resourceName.substringAfterLast('.')
//
//            if (extension == "svg" || extension == "jpg" || extension == "jpeg") {
//                val drawable = ResourcesCompat.getDrawable(context.resources, resourceId, null)
//                images.add(ResourceImage(resourceName, drawable))
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }
//
//    return images
//}