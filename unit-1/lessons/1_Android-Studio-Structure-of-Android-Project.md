#Android Studio and the Structure of an Android Project

####Objective

Students will become familiar with the project structure of a gradle Android Project
and know how to use basic Android Studio features.

####Pre-work

[Download Android Studio and run Hello World.]
(https://github.com/accesscode-2-1/unit-1/blob/master/lessons/week-0/0_Android-Prework.md)

####Do Now

Write a program that takes in a number from 0 to 100,
representing a student’s grade, and prints out the letter grade. 

* 100   = A+
* 90-99 = A
* 80-89 = B
* 70-79 = C
* 60-69 = D
* 0-59 = F

####Lesson

##### What is Android?
##### Android Studio
Android Studio is based off IntelliJ, but created specifically for Android Development. Although you'll very commonly see Eclipse online when looking for help, Android Studio is becoming more popular. Using this should be very similar to IntelliJ, including similar shortcuts, and the advice you find online for IntelliJ will often be transferable (except for gradle problems.

> Exercise: Create a new Android Project of any type.

##### Introduction to an Android project
* Gradle Scripts: Thes
* Manifests: This is where the information that the system must have to run the Android Project lives.
* Java: This is where your Java code for the project lives.
* Res: These are the resources files. Here's where static information lives.

##### Exploring Android Studio panels:
* Project (android view vs project view)
* Android console (logcat, memory, cpu)
* Structure
* TODO

#####SDK Manager

The SDK manager allows you to install other libraries you might need, for example HAXM, Android Wear,
or earlier versions of Android.

#####AVD manager

This is where you can manage virtual devices and create new ones.

#####Managing virtual devices from the command line

> Exercise: [Managing AVD from the Command Line](https://developer.android.com/tools/devices/managing-avds-cmdline.html)

#####Module settings

> Exercise: Use your Do Now and create an Android app that does the same thing. Include a 
[text field](http://developer.android.com/reference/android/widget/EditText.html) for user
input and a [button](http://developer.android.com/reference/android/widget/Button.html) to submit. The output should be a
[text view](http://developer.android.com/reference/android/widget/TextView.html)
of the letter. If you wish, you can try to make the
letter different colors based on the grade. For a bonus challenge, add a notification that notifies the user of the grade when the submit button is pressed. The app should look like this.

> ![](http://i.imgur.com/RgszB8z.png).

####Assessment

[Exit ticket](https://docs.google.com/a/c4q.nyc/forms/d/1HieXNBgrNRTCiZRPfOgCdCxSW3hY1ZYNMMiBzNefj2s/viewform)

####Support materials

* [Slides](https://docs.google.com/presentation/d/1jyr6z24BY3Vz3fZtAb7wW4_rn52yZhpr9AgbHujPOAA/edit#slide=id.gae49e002c_0_108)
* Video coming soon!
* Reading: Android and Projects, Tutorial #2 - Creating a Stub Project,
Getting Around Android Studio, Contents of Android Projects
