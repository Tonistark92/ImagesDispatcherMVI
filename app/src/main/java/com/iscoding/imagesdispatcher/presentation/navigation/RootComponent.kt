package com.iscoding.imagesdispatcher.presentation.navigation

import android.util.Log
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pushNew
import com.iscoding.imagesdispatcher.presentation.mainscreen.MainScreenComponent
import com.iscoding.imagesdispatcher.presentation.networkimagescreen.NetworkImagesScreenComponent
import com.iscoding.imagesdispatcher.presentation.networkimagescreen.mvi.NetworkImagesScreenStoreFactory
import com.iscoding.imagesdispatcher.presentation.resourcesimagescreen.ResourcesImagesScreenComponent
import com.iscoding.imagesdispatcher.presentation.storageimagescreen.StorageImagesScreenComponent
import kotlinx.serialization.Serializable

class RootComponent(
    componentContext: ComponentContext,
    private val networkImagesScreenStoreFactory: NetworkImagesScreenStoreFactory,
) : ComponentContext by componentContext {

    private val navigation = StackNavigation<Configuration>()
    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.MainScreen,
        handleBackButton = true,
        childFactory = ::createChild
    )

    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Child {
        return when (config) {
            Configuration.NetworkImagesScreen -> Child.NetworkImagesScreen(
                NetworkImagesScreenComponent(componentContext = context,networkImagesScreenStoreFactory,)
            )

            Configuration.ResourcesImagesScreen -> Child.ResourcesImagesScreen(
                ResourcesImagesScreenComponent(componentContext = context)
            )

            Configuration.MainScreen -> Child.MainScreen(MainScreenComponent(componentContext = context,
                onNavigateToNetworkImages = {
                    Log.d("ISLAM", "onNavigateToNetworkImages")
                    navigation.pushNew(Configuration.NetworkImagesScreen)
                },
                onNavigateToStorageImages = {
                    navigation.pushNew(Configuration.StorageImagesScreen)
                    Log.d("ISLAM", "onNavigateToStorageImageS")

                },
                onNavigateToResourcesImages = {
                    navigation.pushNew(Configuration.ResourcesImagesScreen)
                    Log.d("ISLAM", "onNavigateToResourcesImages")

                }
                ))

            Configuration.StorageImagesScreen -> Child.StorageImagesScreen(
                StorageImagesScreenComponent(componentContext = context)
            )
        }
    }

    sealed class Child {
        data class NetworkImagesScreen(val component: NetworkImagesScreenComponent) : Child()
        data class ResourcesImagesScreen(val component: ResourcesImagesScreenComponent) : Child()
        data class StorageImagesScreen(val component: StorageImagesScreenComponent) : Child()
        data class MainScreen(val component: MainScreenComponent) : Child()
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object NetworkImagesScreen : Configuration()

        @Serializable
        data object ResourcesImagesScreen : Configuration()

        @Serializable
        data object StorageImagesScreen : Configuration()

        @Serializable
        data object MainScreen : Configuration()

    }
}