package id.ac.ui.cs.mobileprogramming.nabilafv.helloworld;

import android.content.Context;

import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {


    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testInitialView() {
        onView(withId(R.id.textWorld)).check(ViewAssertions.matches(withText("Hello World!")));
        onView(withId(R.id.button)).check(matches(isDisplayed()));
    }

    @Test
    public void testChangeMessageOnce(){
        onView(withId(R.id.button)).perform((click()));
        onView(withId(R.id.textWorld)).check(ViewAssertions.matches(withText("Bye World!")));
    }

    @Test
    public void testChangeMessageTwice(){
        onView(withId(R.id.button)).perform((click()));
        onView(withId(R.id.textWorld)).check(ViewAssertions.matches(withText("Bye World!")));
        onView(withId(R.id.button)).perform((click()));
        onView(withId(R.id.textWorld)).check(ViewAssertions.matches(withText("Hello World!")));
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("id.ac.ui.cs.mobileprogramming.nabilafv.helloworld", appContext.getPackageName());
    }
}