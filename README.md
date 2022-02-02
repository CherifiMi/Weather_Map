<h1 align="center"> Weather_Map</h1>

<p align="center">  
  
  🌏 This app gives you daily data about the weather in your location, tacks the longitude and latitude from the weather Api and sends it to the mapBox Api to give you a map of your location
</p>
</br>

![Frame 1](https://user-images.githubusercontent.com/98290339/152137886-25cbf7b3-367c-493e-8f28-863eefbd0445.png)

### Ui made in [Figma](https://www.figma.com/file/mtCF10n9wphsv1JdKG00uQ/Ux-and-shi?node-id=28%3A1101)

## Tech stack & Open-source libraries

- Minimum SDK level 27
- [Hilt](https://dagger.dev/hilt/) for dependency injection.
- Architecture
    - MVVM Architecture (View - ViewBinding - ViewModel - Model)
    - Repository Pattern (Local/Remote)

- [View binding](https://developer.android.com/topic/libraries/view-binding) to bind data :)
- [Retrofit](https://github.com/square/retrofit) the get the data from the api
- [Coroutines](https://developer.android.com/kotlin/coroutines) to handel the api requests
- [Lifecycle](https://developer.android.com/guide/fragments/lifecycle)
- [Coil](https://github.com/coil-kt/coil) for loading the Map images from [the MapBox Api](https://mapbox.com/)

## What I Learned
- using themes
- using retrofit to get the data from the open weather api 
- using coil to load an image from a url

## Open Api
- [MapBox Api](https://mapbox.com/) for getting the map
- Weather Map uses the [Open Weather Api](http://api.openweathermap.org/data/2.5/weather?q=london&APPID=be2793fc36a6181ecb9eb1166eb1253c) to get:
  - temperature
  - users coordination
  - humidity
  - wind speed
  - sunrise time

## Final app

https://user-images.githubusercontent.com/98290339/151687550-c433d710-d386-4134-aef3-b3e950bb3a55.mp4

