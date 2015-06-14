package com.c4q.activity;

import nyc.c4q.R;
import nyc.c4q.c4q.Unit1AssessmentActivity;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class DeckardEspressoTest extends ActivityInstrumentationTestCase2<Unit1AssessmentActivity> {

    public DeckardEspressoTest() {
        super(Unit1AssessmentActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testActivityShouldHaveText() throws InterruptedException {
        onView(withId(R.id.text)).check(matches(withText("Hello Espresso!")));
    }
}
