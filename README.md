# Tech-news-works
Tech-news-works is a sample news reading app, built with
[Jetpack Compose](https://developer.android.com/jetpack/compose). The goal of the sample is to
showcase some skills for a particular app challenge.

To try out this sample app:
* Use the latest stable version of [Android Studio](https://developer.android.com/studio). 
* Clone the repository and import it.
* Add local.properties with the API_KEY.

## Screenshots

## Features

This sample contains three screens: login with biometric (if possible), a list of top headlines, 
and a detail page for headlines.

### Biometrics

Package [`com.example.technewsworks.ui.screens.biometric`][1]

This screen shows how to check if the device has a biometrics and if it’s configured in the device.

See how to:

* Use `Column` to arrange the contents of the UI.
* Use Android biometric authentication dialog.
* Define the types of authentication that your app supports.
* Check that biometric authentication is available.
* Display the biometric prompt.
* Use default Material's `Typography` and `ColorScheme` to style the text.

[1]: app/src/main/java/com/example/technewsworks/ui/screens/biometric

### Top headlines list

Package [`com.example.technewsworks.ui.screens.home`][2]

This screen shows how to create different custom Composable functions and combine them in a list
that scrolls vertically.

See how to:

* Use `Row`s and `Column`s to arrange the contents of the UI.
* Use Paging for load and display pages of data from network.
* Use Glide for download and chace images.
* Use default Material's `Typography` and `ColorScheme` to style the text.

[2]: app/src/main/java/com/example/technewsworks/ui/screens/home

### News detail

Package [`com.example.technewsworks.ui.screens.news`][3]

This screen simple shows the news detail.

[3]: app/src/main/java/com/example/technewsworks/ui/screens/news

### Data

The data is from a specific source (BBC news). However could be replaced for a static FakeNews, 
held in the [`com.example.technewsworks.data.datasource.mock`][4] package.

[4]: app/src/main/java/com/example/technewsworks/data/datasource/mock