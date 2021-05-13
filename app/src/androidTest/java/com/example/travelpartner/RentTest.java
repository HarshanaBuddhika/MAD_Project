package com.example.travelpartner;

import androidx.test.espresso.intent.rule.IntentsTestRule;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class RentTest {

    @Rule
    public IntentsTestRule<Rent> intentsTestRule = new IntentsTestRule<>(Rent.class);

    @Test
    public void testIntentSearchRent(){
        onView(withId(R.id.btn_SearchARent)).perform(click());
        intended(hasComponent(Post_Rent.class.getName()));
    }

    @Test
    public void testIntentAddRent(){
        onView(withId(R.id.btn_AddARent)).perform(click());
        intended(hasComponent(Add_Rent.class.getName()));
    }
}