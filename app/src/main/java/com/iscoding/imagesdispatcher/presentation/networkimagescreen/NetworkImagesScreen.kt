package com.iscoding.imagesdispatcher.presentation.networkimagescreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.arkivanov.mvikotlin.extensions.coroutines.states
import com.iscoding.imagesdispatcher.presentation.networkimagescreen.mvi.NetworkImagesScreenState

@Composable
fun NetworkImagesScreen(component: NetworkImagesScreenComponent) {
    val state: NetworkImagesScreenState by component.store.states.collectAsState(initial = NetworkImagesScreenState())
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // before apply the bootstrap
//        Button(onClick = { component.onNavigateToStorageImages() }) {
//            Text(text = "Click me")
//
//        }
        if (state.data.isNotEmpty()) {
            LazyColumn {
                items(state.data.size) {
                    AsyncImage(
                        model = state.data[it],
                        contentDescription = null,
                        modifier = Modifier.size(200.dp)

                    )
                }
            }
        }

    }
}