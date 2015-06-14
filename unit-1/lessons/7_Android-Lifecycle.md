## The Android Lifecycle

#### Objective

Students will be able to understand the Android Activity Lifecycle and how to use lifecycle methods.

#### Do Now (Morning)

Finish working on [yesterday's exercises](https://github.com/shurane/unit-1-android-resource-exercises).
If you're done, help someone who isn't finished.

#### Github Workshop

Next Saturday there will be a more in-depth Github workshop. The goal of this week's workshop is to ensure
all students are able to submit homework.

#### Code Review

[Code Review Rubric](https://github.com/accesscode-2-1/user-manual/blob/master/code-review-rubric.md)

#### Review of Android Resource Exercises

#### Do Now (Afternoon)

Download [ActivityLifecycle.zip](http://developer.android.com/training/basics/activity-lifecycle/index.html) and
play with/look at the sample app.

#### Tech Industry Chat

#### Android LifeCycle

An Activity is an Android object that represents one single task a user can do. The Activity Lifecycle methods are called depending on the current state of the Activity. This is not controlled by the application developer. The developer is given some guarantees (for example, that `onCreate` is called before `onStart`) but besides that must write these methods with all sorts of user interactions in mind. These are the lifecycle methods:
* `onCreate` is called when the Activity is first created - performs any necessary setup
* `onStart` and `onResume` are called when the Activity is first made visible.
* `onResume` is called anytime an Activity is made visible
* `onPause` is called anytime an Activity is made only partially visible
* `onStop` is called when an Activity is no longer visible to the user - can be followed by either `onRestart` or `onDestroy`.
* `onRestart` is called when a stopped Activity becomes active again.
* `onDestroy` is called to Destroy an Acivity.

The system may also kill an Activity. When this happens, any state about the activity is passed in a [`Bundle`](http://developer.android.com/reference/android/os/Bundle.html). Information about the View hierarchy is typically saved by `onSaveInstanceState`. You can implement this method in order to save more information about the current Activity state using key-value pairs. You can then restore state either in `onCreate` or in `onRestoreInstanceState`, which is called after `onStart` when restoring the Activity.

###### Exercise: Activity LifeCycle Callbacks
* Create a new blank Android Studio project (select the "Add No Activity" option in the New Project Wizard)
* Create a new Activity.
* In the Project View, right click on the main package (it should be something like `com.yourname.lifecycleexcercise`).
* Select `New` --> `Blank Activity`.
* A window will pop up in which you can change the name of the Activity, layout, etc.  Make sure that you select the `Launcher Activity` option.  Leave all the other fields as is and press the `Finish` button.
* Delete the `onCreateOptionsMenu` and `onOptionsItemSelected` methods.
* Override the following methods: `onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onRestart`, `onDestroy`.
* In each of the overridden methods from step #4, place the following statement at the end of the method: ```Log.d("MainActivity", "[name of method]");``` i.e., in the onCreate method you would write: ```Log.d("MainActivity", "onCreate");```

1. Start the app for the first time by pressing the Run button in Android Studio and watch the log output in the `Devices | logcat` view - note down the order in which the lifecycle methods are executed.
2. Exit the app by pressing the back button to exit the app - note down the order in which the lifecycle methods are executed.
3. Start the app by pressing the app's icon in the Launcher (Launcher is sometimes referred to as the Desktop) - note down the order in which the lifecycle methods are executed.  (It should go through the same lifecycle events as in #1).
4. Exit the app by pressing the home button on your device. - note down the order in which the lifecycle methods are executed.
5. Start the app again by accessing it from the Recent Apps screen - note down the order in which the lifecycle methods are executed
6. Exit the app by pressing the home button on your device.  It should go through the same lifecycle events as in #4.
7. Start the app using any method (from the Launcher or from the Recent Apps screen).
8. Rotate the device - note down the order in which the lifecycle methods are executed.

###### Exercise: Saving and Restoring State

The goal of this excericse is to learn how to save and restore instance state in an activity's Bundle.

1. Modify the TextView in activity_main.xml
1. Open the activity_main.xml file
1. Add the following attribute to the <TextView> element:
```android:id="@+id/the_textview" ```

1. Add an EditText view in activity_main.xml
1. Open activity_main.xml
1. Add the following code underneath the <TextView> element:
     ```
       <EditText
        android:id="@+id/the_edittext"
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:layout_below="@id/the_textview"
        />
    ```

1. Run the app.
1. Type in some text into the EditText field.
1. Rotate the screen.
1. After the activity destroys and recreates itself, notice that the EditText still contains the same text as it had before it was rotated.

Explanation : this happens because the activity automatically saves and restores state on any views that have an `id` attribute in the backing XML layout file for that activity.

1. Create a instance variable in MainActivity to hold a reference to the TextView
1. Open MainActivity.java
1. Under the class declaration, add the following line: ``` private TextView theTextView; ```
1. At the end of the `onCreate` method, add the following lines:
``` 
theTextView = (TextView) findViewById(R.id.random_num);
SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
String timeString = format.format(new Date());
theTextView.setText(timeString);
``` 
1. Run the app.
1. Type some text into the EditText.
1. Take note of the time that is displayed on the screen
1. Rotate the screen.
1. Notice that after rotation, the text in the EditText view is the same but the time in the TextView is different

Explanation - in order to save and restore state on data that was generated dynamically, you must do the following : * override the `onSaveInstanceState(Bundle outState)` method
* save the state of any vars you want to preserve into the outState Bundle
* restore state from the bundle in the `onCreate()` method.

Further exercise: Modify the code in MainActivity so that it saves the time into the Activity's bundle and restores it in `onCreate(Bundle savedInstanceState)` if savedInstanceState is not null.

#### Assessment

[Exit Ticket](https://docs.google.com/a/c4q.nyc/forms/d/1a-gfjjsn35N-C6wrQU9y02vHoYLFaEfjUgD7J91n3rM/edit)

#### Resources

Android docs: [Managing the Activity Lifecycle](http://developer.android.com/training/basics/activity-lifecycle/index.html), [Activity](http://developer.android.com/reference/android/app/Activity.html)

Udacity: Developing Android Apps Lesson 4 incl. [Why We Need An Activity Lifecyle](https://www.youtube.com/watch?v=-zr5QLH4Qy4), [The Android Activity Lifecycle](https://www.youtube.com/watch?v=85MppyLJHz0), [Active and Visible Lifetimes](https://www.youtube.com/watch?v=88rJq9HyGLI). [Maintaining State](https://www.youtube.com/watch?v=KE1hwhltOu8)

Textbook: Activities and Their Lifecycles
