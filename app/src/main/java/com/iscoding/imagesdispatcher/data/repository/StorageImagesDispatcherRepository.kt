package com.iscoding.imagesdispatcher.data.repository

import android.content.ContentUris
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import com.iscoding.imagesdispatcher.domain.repository.ImagesDispatcherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StorageImagesDispatcherRepository (private val context: Context): ImagesDispatcherRepository {
    override suspend fun getImages(): List<Any> {
    return    loadPhotosFromExternalStorage(context)
    }

    suspend fun loadPhotosFromExternalStorage(context: Context): List<Uri> {
        return withContext(Dispatchers.Default) {
            val collection = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
            } else {
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            }

            val projection = arrayOf(
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.WIDTH,
                MediaStore.Images.Media.HEIGHT
            )

            val selection = "${MediaStore.Images.Media.MIME_TYPE}=? OR ${MediaStore.Images.Media.MIME_TYPE}=?"
            val selectionArgs = arrayOf(
                "image/jpeg",
                "image/svg+xml"
            )

            val photos = mutableListOf<Uri>()

            context.contentResolver.query(
                collection,
                projection,
                selection,
                selectionArgs,
                "${MediaStore.Images.Media.DATE_ADDED} DESC"
            )?.use { cursor ->
                val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
                val displayNameColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
                val widthColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.WIDTH)
                val heightColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.HEIGHT)

                while (cursor.moveToNext()) {
                    val id = cursor.getLong(idColumn)
                    val displayName = cursor.getString(displayNameColumn)
                    val width = cursor.getInt(widthColumn)
                    val height = cursor.getInt(heightColumn)
                    val contentUri = ContentUris.withAppendedId(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        id
                    )
                    photos.add(contentUri)
                }
            }

            photos.toList()
        }
    }
}

 data class SharedStoragePhoto(
    val id: Long,
    val displayName: String,
    val width: Int,
    val height: Int,
    val contentUri: Uri
)

