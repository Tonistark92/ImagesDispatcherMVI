package com.iscoding.imagesdispatcher.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.addCallback
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.mvikotlin.extensions.coroutines.states
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.iscoding.imagesdispatcher.presentation.common.ui.theme.ImagesDispatcherTheme
import com.iscoding.imagesdispatcher.presentation.mainscreen.App
import com.iscoding.imagesdispatcher.presentation.navigation.RootComponent
import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope
import org.koin.mp.KoinPlatform.getKoin

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootComponent: RootComponent by rootScope.inject {
            parametersOf(
                DefaultComponentContext(
                    this.lifecycle
                )
            )
        }

        onBackPressedDispatcher.addCallback(this) {
            if(rootComponent.childStack.value.backStack.isEmpty()) {
                finish()
            } else {
                rootComponent.onBackClicked(rootComponent.childStack.value.backStack.size - 1)
            }

        }

        setContent {


            ImagesDispatcherTheme {
                App(rootComponent)
            }
        }
    }
}

private val rootScope: Scope by lazy {
    getKoin().getOrCreateScope<RootComponent>(RootComponent::class.simpleName!!)
}

// that screen for learnings purposes