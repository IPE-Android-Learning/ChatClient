package hk.ust.cse.comp107x.chatclient;


import android.test.ActivityInstrumentationTestCase2;
import org.junit.Before;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.core.IsAnything.anything;

/**
 * Created by muppala on 8/6/16.
 */
public class ChatClientTest extends ActivityInstrumentationTestCase2<ChatClient> {

    private ChatClient chatClient;

    public ChatClientTest() {
        super(ChatClient.class);
    }


    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(getInstrumentation());
        chatClient = getActivity();
    }

    public void testChangeText() {
        // Type text and then press the button.
        // Type text and then press the button.
        onView(withId(R.id.editTxtMEssage))
                .perform(typeText("This is a test"), closeSoftKeyboard());
        onView(withId(R.id.btnSend)).perform(click());

        onView(withId(R.id.txtViewMessage))
                .check(matches(withText("This is a test")));
    }

}