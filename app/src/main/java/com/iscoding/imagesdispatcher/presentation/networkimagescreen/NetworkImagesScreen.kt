package com.iscoding.imagesdispatcher.presentation.networkimagescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.iscoding.imagesdispatcher.presentation.navigation.MainScreenComponent
import com.iscoding.imagesdispatcher.presentation.navigation.NetworkImagesScreenComponent

@Composable
fun NetworkImagesScreen(component: NetworkImagesScreenComponent) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Network Images Screen")
    }
}