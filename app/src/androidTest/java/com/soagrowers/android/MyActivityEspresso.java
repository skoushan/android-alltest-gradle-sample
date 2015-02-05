package com.soagrowers.android;

import android.test.ActivityInstrumentationTestCase2;

import com.squareup.spoon.Spoon;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MyActivityEspresso extends ActivityInstrumentationTestCase2<MyActivity>{

    public MyActivityEspresso() {
        super(MyActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testMyActivityAppearsAsExpectedInitially() {
        onView(withId(R.id.my_hello_text_view)).check(matches(isDisplayed()));
        onView(withId(R.id.clickMeBtn)).check(matches(isDisplayed()));
    }

    public void testClickingClickMeButtonChangesHelloWorldText() {
        onView(withId(R.id.my_hello_text_view)).check(matches(withText(R.string.hello_world)));
        Spoon.screenshot(getActivity(), "initial_state");
        onView(withId(R.id.clickMeBtn)).perform(click());
        onView(withId(R.id.my_hello_text_view)).check(matches(withText(R.string.ok_thanks)));
        Spoon.screenshot(getActivity(), "final_state");
    }
}
