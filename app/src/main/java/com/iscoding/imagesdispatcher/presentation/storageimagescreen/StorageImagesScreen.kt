package com.iscoding.imagesdispatcher.presentation.storageimagescreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.arkivanov.mvikotlin.extensions.coroutines.states
import com.iscoding.imagesdispatcher.presentation.resourcesimagescreen.mvi.ResourcesImagesScreenState
import com.iscoding.imagesdispatcher.presentation.storageimagescreen.mvi.StorageImagesScreenState

@Composable
fun StorageImagesScreen(component: StorageImagesScreenComponent) {
    val state: StorageImagesScreenState by component.store.states.collectAsState(initial = StorageImagesScreenState())
    Log.d("ISLAM", "state: ${state.data.size}")
    Log.d("ISLAM", "state: ${state.data.toString()}")
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        if (state.data.isNotEmpty()) {

            LazyColumn {
                items(state.data.size) {

                    val painter = rememberAsyncImagePainter(model = state.data[it])

                    Image(
                        painter  = painter,
                        contentDescription = null,
                        modifier = Modifier.size(200.dp))
                }
            }
        }
    }
}