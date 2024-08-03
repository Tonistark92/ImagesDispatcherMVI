package com.iscoding.imagesdispatcher.presentation.resourcesimagescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.iscoding.imagesdispatcher.presentation.navigation.MainScreenComponent
import com.iscoding.imagesdispatcher.presentation.navigation.ResourcesImagesScreenComponent

@Composable
fun ResourcesImagesScreen(component: ResourcesImagesScreenComponent) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Resources Images Screen")
    }
}