package com.mytaxi.android_demo;

import android.content.Context;
import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.DrawerMatchers;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;


import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION);

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    // @Test
    public void test1_UseAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.mytaxi.android_demo", appContext.getPackageName());
    }

    @Test
    public void test2_UserLogin() throws Exception {

        String username = "whiteelephant261";
        String password = "video";
        //Enter Username
        Espresso.onView(ViewMatchers.withId(R.id.edt_username)).perform(typeText(username));
        //Enter Password
        Espresso.onView(ViewMatchers.withId(R.id.edt_password)).perform(typeText(password));
        Espresso.onView(ViewMatchers.withId(R.id.btn_login)).perform(click());
        Thread.sleep(10000);
        //DrawerActions.openDrawer(R.id.drawer_layout);
        Espresso.onView(ViewMatchers.withId(R.id.drawer_layout)).perform(DrawerActions.open());

        // Check that the number is displayed in the UI.
        Espresso.onView(ViewMatchers.withId(R.id.nav_username))
                .check(ViewAssertions.matches(ViewMatchers.withText(username)));


    }

}
