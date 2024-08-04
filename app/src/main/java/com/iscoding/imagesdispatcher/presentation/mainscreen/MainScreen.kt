package com.iscoding.imagesdispatcher.presentation.mainscreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.iscoding.imagesdispatcher.presentation.navigation.RootComponent
import com.iscoding.imagesdispatcher.presentation.networkimagescreen.NetworkImagesScreen
import com.iscoding.imagesdispatcher.presentation.resourcesimagescreen.ResourcesImagesScreen
import com.iscoding.imagesdispatcher.presentation.storageimagescreen.StorageImagesScreen

@Composable
fun App(root: RootComponent) {
    MaterialTheme {
        val childStack by root.childStack.subscribeAsState()
        Children(
            stack = childStack,
            animation = stackAnimation(slide())
        ) { child ->
            when(val instance = child.instance) {
                is RootComponent.Child.MainScreen -> MainScreen(instance.component)
                is RootComponent.Child.NetworkImagesScreen -> NetworkImagesScreen(instance.component)
                is RootComponent.Child.StorageImagesScreen -> StorageImagesScreen(instance.component)
                is RootComponent.Child.ResourcesImagesScreen -> ResourcesImagesScreen(instance.component)
            }
        }
    }
}

@Composable
fun MainScreen(component: MainScreenComponent) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = { component.navegateToNetworkImages()
            Log.d("ISLAM", "onNavigateToNetworkImages Screen")
        }) {
            Text(text = "Go To Network Images")
        }
        Button(onClick = { component.navigateToResourcesImages()
            Log.d("ISLAM", "onNavigateToResourcesImages Screen")
        }) {
            Text(text = "Go To Resources Images")
        }
        Button(onClick = {component.navigateToStorageImages()
            Log.d("ISLAM", "onNavigateToStorageImages Screen")
        }) {
            Text(text = "Go To Storage Images")
        }

    }

}