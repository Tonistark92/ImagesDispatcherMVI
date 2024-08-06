package com.iscoding.imagesdispatcher.data.repository

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.util.TypedValue
import androidx.core.content.res.ResourcesCompat
import com.iscoding.imagesdispatcher.R
import com.iscoding.imagesdispatcher.domain.repository.ImagesDispatcherRepository
import kotlin.reflect.KClass

class ResourcesImagesDispatcherRepository(private val context: Context) : ImagesDispatcherRepository {
    override suspend fun getImages(): List<Any> {
      return  loadImagesFromResources2(context)
    }

    @SuppressLint("DiscouragedApi")
    fun loadImagesFromResources2(context: Context): List<Int> {
        Log.d("ISLAM", "repo: is called")
        val resources = context.resources
        val packageName = context.packageName
        val drawableClass = R.drawable::class.java

        val images = mutableListOf<Int>()

        for (field in drawableClass.fields) {
            val resourceName = field.name
            val value = TypedValue()
            val resId = context.resources.getIdentifier(resourceName, "drawable", context.packageName)
            context.resources.getValue(resId, value, true)
            Log.d("ISLAM", "repo: Type is ${value.string.toString()}")
            if (value.string.toString().endsWith(".xml") || value.string.toString().endsWith(".jpg") || value.string.toString().endsWith(".jpeg")) {

//                val drawable = ResourcesCompat.getDrawable(context.resources, resId, null)
                Log.d("ISLAM", "repo: ID is ${resId}")
//                Log.d("ISLAM", "repo: drawable is ${drawable.toString()}")

                images.add(resId)
            }
        }
        Log.d("ISLAM", "repo: ${images.toString()}")

        return images

    }

}
// if want to load images from resources with name and drawable
data class ResourceImage(
    val name: String,
    val drawable: Drawable?
)


