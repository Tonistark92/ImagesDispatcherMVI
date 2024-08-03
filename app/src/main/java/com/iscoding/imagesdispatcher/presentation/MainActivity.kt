package com.iscoding.imagesdispatcher.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.retainedComponent
import com.arkivanov.mvikotlin.extensions.coroutines.states
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.iscoding.imagesdispatcher.presentation.common.ui.theme.ImagesDispatcherTheme
import com.iscoding.imagesdispatcher.presentation.navigation.RootComponent

class MainActivity : ComponentActivity() {
    private lateinit var store: CounterStore
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val root = retainedComponent {
            RootComponent(it)
        }
        setContent {
            val storeFactory = DefaultStoreFactory()
            store = CounterStoreFactory(storeFactory).create()

            ImagesDispatcherTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) {
//                    CounterScreen(store)
//                }
                App(root)
            }
        }
    }
}


// CounterScreen.kt
@Composable
fun CounterScreen(store: CounterStore) {
    val state by store.states.collectAsState(initial = CounterState())

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Count: ${state.count}")

        Row {
            Button(onClick = { store.accept(CounterIntent.Increment) }) {
                Text(text = "Increment")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { store.accept(CounterIntent.Decrement) }) {
                Text(text = "Decrement")
            }
        }
    }
}