# Image Dispatcher App

## Overview

The app features three main functionalities:

1. **Fetch and Display Network Images**
2. **Fetch and Display Images from External Storage**
3. **Fetch and Display Images from App Resources**

The application libraries to manage its architecture and functionalities:

- **Coil** for efficient image loading.
- **Decompose** for managing navigation between screens.
- **MVIKotlin** for implementing the Model-View-Intent (MVI) architecture.

## Resources
 **[Decompose Docs](https://arkivanov.github.io/Decompose/getting-started/quick-start/)** 
 **[Kotlin MVI](https://arkivanov.github.io/MVIKotlin/)** 
 **[Coil](https://coil-kt.github.io/coil/)** 
 **[Mr Philip ](https://www.youtube.com/watch?v=g4XSWQ7QT8g)** 


## Features

### 1. Network Images

- Fetch images from the network.
- Display them using Coil for smooth image loading.

### 2. Storage Images

- Access images stored in external storage.
- Filter images by format (e.g., JPEG, SVG) and display them in the app.

### 3. Resource Images

- Load and display images that are bundled with the app's resources.

## Libraries Used

### Coil

Coil is used for efficient image loading and caching. It provides a simple API for loading images from various sources into `ImageView` components.

### Decompose

Decompose is used for navigation between different screens in the app. It helps manage screen transitions and maintain the state of each screen.

### MVIKotlin

MVIKotlin is used to implement the MVI architecture, ensuring a clear separation between the view, business logic, and state management. It helps manage complex state changes and user interactions.

## Project Structure

### Navigation

- **RootComponent**: Manages navigation between different screens.
- **NetworkImagesScreenComponent**: Handles network image screen logic and state.
- **StorageImagesScreenComponent**: Manages external storage image screen logic.
- **ResourcesImagesScreenComponent**: Handles resource image screen logic.

### MVI Components

- **NetworkImagesScreenStoreFactory**: Provides instances of `NetworkImagesScreenStore` for managing state and intents related to network images.
- **StorageImagesScreenStoreFactory**: Provides instances of `StorageImagesScreenStore` for managing state and intents related to storage images.
- **ResourcesImagesScreenStoreFactory**: Provides instances of `ResourcesImagesScreenStore` for managing state and intents related to resource images.

### Repository

- **ImagesDispatcherRepository**: Interface for accessing images from different sources.
- **NetworkImagesDispatcherRepository**: Implementation for fetching network images.
- **StorageImagesDispatcherRepository**: Implementation for accessing images from external storage.
- **ResourcesImagesDispatcherRepository**: Implementation for loading images from app resources.

## Getting Started

1. **Clone the repository**:

    ```bash
    git clone https://github.com/yourusername/imagedispatcherapp.git
    cd imagedispatcherapp
    ```

2. **Open the project in Android Studio**.

3. **Build and Run**:

    - Ensure you have the necessary permissions for accessing external storage.
    - Run the app on an emulator or physical device.

