package id.ac.ui.cs.mobileprogramming.nabilafv.helloworld;

import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = 21)
public class MainActivityTest {

    MainActivity mainActivity;
    TextView text;
    Button changeTextButton;

    @Before
    public void setUp() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        text = (TextView) mainActivity.findViewById(R.id.textWorld);
        changeTextButton = (Button) mainActivity.findViewById(R.id.button);
    }

    @Test
    public void testInitialMessage() {
        assertEquals("Hello World!", text.getText().toString());
    }

    @Test
    public void testClickButtonOnce() {
        changeTextButton.performClick();
        assertEquals("Bye World!", text.getText().toString());
    }

    @Test
    public void testClickButtonTwice() {
        changeTextButton.performClick();
        assertEquals("Bye World!", text.getText().toString());
        changeTextButton.performClick();
        assertEquals("Hello World!", text.getText().toString());
    }
}