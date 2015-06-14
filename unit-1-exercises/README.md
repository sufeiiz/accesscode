### Exercises for Access Code

Based off of https://github.com/robolectric/deckard-gradle

Make sure to enable [Unit Testing](https://sites.google.com/a/android.com/tools/tech-docs/unit-testing-support) in Android Studio. Then right click and run `Unit1ExerciseTests.java`

#### Pass the following tests

##### `test01ActivityExists()`
Tests if main Activity exists.

##### `test02AddTextViewToLayout()`
Tests if a TextView called with the id "text" has been added to a layout.

##### `test03SetTextViewValueToTODO()`
Tests if the TextView with the id "text" contains the string, "Help, I'm stuck in an Android Factory!"

##### `test04AddImageViewToLayout()`
Tests if an ImageView with the id "image" has been added to a layout.

##### `test05SetImageViewToHelloGreen()`
Tests if an ImageView with the id "image" uses the drawable "hello_green.png".

##### `test06EditTextActivityExists()`
Tests if EditTextAcitivity class exists.

##### `test07EditTextActivityLayoutExists()`
Tests if layout for EditTextActivity exists.

##### `test08EditTextActivityTextViewCounterExists()`
Tests if TextView `R.id.counter` displays the number of times a button has been clicked exists in main activity.

##### `test09EditTextActivityButtonExists()`
Tests if Button with `click!` text is created after the TextView `R.id.counter`. Every time `R.id.button` is clicked, `R.id.counter` should be incremented by 1.

### Bonus #1 -- try implementing the following exercises as well as the tests.

##### `testCounterSavesState()`
Tests if the Activity saves and restores the state of the counter in `OnSaveInstanceState` and `onRestoreInstanceState`.

##### `testSocialActivityExists()`
Tests if SocialActivity class exists.

##### `testSocialActivityLayoutExists()`
Tests if a layout exists for the SocialActivity Class.

##### `testSocialActivityRespondsToIntent()`
Tests if SocialActivity responds to the `ACTION_SEND` Intent.

##### `testSocialShareButtonExists()`
Tests if the Main Activity has a button for social sharing with id `R.id.social`.

#### Bonus #2
Write your own unit tests, and then implement features to pass those tests.
Take a look at [Robolectric](http://robolectric.org/) for documentation of the testing framework. Feel free to take a look at some of our own tests in [unit-1-exercises](https://github.com/shurane/unit-1-exercises/tree/master/src/test/java/com/example/activity/Unit1ExerciseTests.java).
