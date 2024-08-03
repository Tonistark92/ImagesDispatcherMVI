package com.iscoding.imagesdispatcher.presentation.storageimagescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.iscoding.imagesdispatcher.presentation.navigation.MainScreenComponent
import com.iscoding.imagesdispatcher.presentation.navigation.StorageImagesScreenComponent

@Composable
fun StorageImagesScreen(component: StorageImagesScreenComponent) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Storage Images Screen")
    }
}