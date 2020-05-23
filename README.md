# Insider Events
Brings all the happenning events in your city at your finger tips :D

### Tech
* Kotlin
* MVVM Architecture
* Live Data
* Rx
* Retrofit2 (with Logging interceptor)
* Glide
* Constraint Layout

### Architecture:
* The app takes advantage of ___MVVM architecture___ with ___Kotlin___ being the primary language
* ___Activity, ViewModel, Repository, LiveData____ are the basic building blocks of this architecture
* All the UI related work like showing alert dialog, starting a new activity, showing the progress bar, etc is done in the Activity. 
* Business logic is written in the ViewModel. Also the observable fields can be kept in the ViewModel which will be observed from the XML when we use data binding. 
* All API calls, DB calls, File operation happen from within the repository.
* It's a 1 way reference flow from Activity -> View Model -> Repository. For ViewModel/Repository to communicate back in the chain we use live data which is observed by the activity.

### App screenshots:
![Image description](https://github.com/rohegde7/Insider-Events/blob/master/screenshots/Screenshot%202020-05-23%20at%206.59.44%20AM.png)
![Image description](https://github.com/rohegde7/Insider-Events/blob/master/screenshots/Screenshot%202020-05-23%20at%206.51.13%20AM.png)
![Image description](https://github.com/rohegde7/Insider-Events/blob/master/screenshots/Screenshot%202020-05-23%20at%206.53.11%20AM.png)
