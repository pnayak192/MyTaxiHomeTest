package com.hometest.pknayak.pratyushhometest;

import android.os.Build;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import android.support.test.runner.AndroidJUnit4;
import android.view.Gravity;
import android.widget.EditText;

import com.hometest.pknayak.pratyushhometest.activities.AuthenticationActivity;
import com.hometest.pknayak.pratyushhometest.activities.MainActivity;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.Runner;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.HashMap;
import java.util.Map;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.CoreMatchers.allOf;



@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyTaxiTest {
    @Rule
    public final ActivityRule<MainActivity> main = new ActivityRule<>(MainActivity.class);

    public static final String driver = "sa";
    public static final String driverName = "Sarah Scott";

    @Before
    // To grant Location Pop Up Permission
    public void grantPhonePermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getInstrumentation().getUiAutomation().executeShellCommand(
                    "pm grant " + getTargetContext().getPackageName()
                            + " android.permission.ACCESS_FINE_LOCATION");
        }

    }

    @Test
    public void myTaxiLoginAndCallDriver() throws InterruptedException {
        // Saving Valid Credentials in a map
        Map<String, String> validCredentials = new HashMap<String, String>();
        validCredentials.put("Username", "crazydog335");
        validCredentials.put("Password", "venture");
        // Checking if mytaxi demo is already logged in with an account, then logout
        isLoggedIn();
        // Calling Login method
        login(validCredentials.get("Username"), validCredentials.get("Password"));
        Thread.sleep(5000);
        // Checking Main menu Caption
        onView(withText("mytaxi demo")).check(matches(isDisplayed()));
        // Searching for Driver.
        onView(withId(R.id.textSearch)).perform(click());
        Thread.sleep(3000);
        onView(isAssignableFrom(EditText.class)).perform(typeText(driver));
        Thread.sleep(3000);
        // Selecting the required DriverName
        onView(withText(driverName))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
        Thread.sleep(2000);
        onView(withId(R.id.fab)).check(matches(isEnabled()))
                .perform(click());
    }

    private void login(String username, String password) {
        // Passing Username
        onView(withId(R.id.edt_username)).perform(click()).perform(typeText(username), clearText());
        onView(withId(R.id.edt_username)).perform(typeText(username));
        // Passing password
        onView(withId(R.id.edt_password)).perform(click()).perform(typeText(password));
        // Closing softKeyboard
        Espresso.closeSoftKeyboard();
        // Click on Login Button
        onView(withId(R.id.btn_login)).perform(click());
    }

    private void logout() throws InterruptedException {
        // Opening DrawerAction
        onView(withId(R.id.drawer_layout)).check(matches(isClosed(Gravity.LEFT)))
                .perform(DrawerActions.open());
        Thread.sleep(3000);
        // Logging out
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_logout));
    }

    private void isLoggedIn() throws InterruptedException {
        try {
            onView(withId(R.id.edt_username)).perform(click());

        } catch (NoMatchingViewException e) {
            logout();
        }
    }
}
