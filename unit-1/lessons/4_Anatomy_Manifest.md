# Anatomy of the Android Manifest

#### Pre-work

Please read about [Application Fundamentals](http://developer.android.com/guide/components/fundamentals.html).

#### Objective

Students will understand the Android Manifest file and be able to use explicit and implicit intents to control activity flow.

#### Do Now

[Coding Bat - Words Without](http://codingbat.com/prob/p183407)

#### Lesson

##### XML

[Intro to XML](http://www.w3schools.com/xml/xml_whatis.asp)

[W3 Schools XML Tutoial](http://www.w3schools.com/xml/)

[A Really, Really Good Introduction to XML](http://www.sitepoint.com/really-good-introduction-xml/)

##### The Manifest

The [Android Manifest](http://developer.android.com/guide/topics/manifest/manifest-intro.html) file gives information about your project to the Android system. Let's go through each piece of this file to figure out what's going on.

```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.amyquispe.myapplication" >

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:theme="@style/AppTheme" >
        <activity
            android:name=".MainActivity"
            android:label="@string/app_name" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

`<?xml version="1.0" encoding="utf-8"?>`: The version of XML being used is 1.0, and the character encoding is UTF-8.

`<manifest xmlns:android="http://schemas.android.com/apk/res/android" package="com.example.amyquispe.myapplication" >`: Opening tag for the manifest file. `xmlns` stands for XML namespace. This defines the Android namespace. The package name is a unique name for the Java package your application uses. This name defines your application and cannot be changed once your app is shipped to the playstore. See also: [Manifest Element](http://developer.android.com/guide/topics/manifest/manifest-element.html).

`<application android:allowBackup="true" android:icon="@mipmap/ic_launcher" android:label="@string/app_name" android:theme="@style/AppTheme" >`: Allows the application to be participate in backup, sets the icon to an image in the resources, sets displayed app name to a string in the resources, and sets a theme for the application. See also: [Application Element](http://developer.android.com/guide/topics/manifest/application-element.html).

`<activity android:name=".MainActivity" android:label="@string/app_name" >`: Defines an activity with its classname and the user-facing name for this [Activity](http://developer.android.com/reference/android/app/Activity.html). See also: [Activity Element](http://developer.android.com/guide/topics/manifest/activity-element.html).

`<intent-filter>`: Specifies what actions the activity can respond to. See also: [Intent Filter Element](http://developer.android.com/guide/topics/manifest/intent-filter-element.html).

`<action android:name="android.intent.action.MAIN" />`: Makes the MainActivity class the main entry point for the application.

`<category android:name="android.intent.category.LAUNCHER" />`: Makes this Activity appear in the launcher as a top-level application.

The manifest file is also used to specify [permissions](http://developer.android.com/guide/topics/manifest/manifest-intro.html#perms) that the app needs to run.

[Intents and Intent Filters](http://developer.android.com/guide/components/intents-filters.html)

##### Explicit Intents

> Exercise: Create an Android Project with multiple activities that communicate with each other using explicit intents and handles results.

##### Implicit Intents

> Exercise: Create an Android Project that sends an email using implicit intents.

#### Assessment

#### Support Materials

Textbook: Introducing Gradle and the Manifest (skip over the Gradle sections and go straight to The Rest of the Manifest), Tutorial #8 - Setting Up An Activity, and Intents, Intent Filters.
Udacity Videos: [Intents Framework](https://www.youtube.com/watch?v=4hxipkwWy2A), [Intents as Envelopes](https://www.youtube.com/watch?v=95AARxHoupA), [Launching Implicit Intents](https://www.youtube.com/watch?t=24&v=3isPsDwox4s), [Broadcast Intents](https://www.youtube.com/watch?t=20&v=dvwjBQ5blnY), [Intent Filters](https://www.youtube.com/watch?v=CXm5TWDXN1Q)
