package com.iscoding.imagesdispatcher.presentation.resourcesimagescreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.arkivanov.mvikotlin.extensions.coroutines.states
import com.iscoding.imagesdispatcher.presentation.networkimagescreen.mvi.NetworkImagesScreenState
import com.iscoding.imagesdispatcher.presentation.resourcesimagescreen.mvi.ResourcesImagesScreenState

@Composable
fun ResourcesImagesScreen(component: ResourcesImagesScreenComponent) {
    val state: ResourcesImagesScreenState by component.store.states.collectAsState(initial = ResourcesImagesScreenState())
    Box(modifier =Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (state.isLoading) {
            CircularProgressIndicator()
        }
        if (state.error?.isNotEmpty() == true) {
            Text(text = state.error!!)
        }
        if (state.data.isNotEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {


                LazyColumn {
                    items(state.data.size) {
                        val painter = rememberAsyncImagePainter(model = state.data[it])
                        Log.d("ISLAM", "END DATA: ${state.data[it]}")

                        Image(
                            painter  = painter,
                            contentDescription = null,
                            modifier = Modifier.size(200.dp)

                        )
                    }
                }
            }
        }
    }

}