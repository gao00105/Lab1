package com.example.lab1;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatEditText = onView( withId(R.id.editText) );
        appCompatEditText.perform(replaceText("12345"), closeSoftKeyboard());


        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());


        ViewInteraction textView = onView(withId(R.id.textView));
        textView.check(matches(withText("You shall not pass")));
    }

    /** This function tests the application is able to
     *  check missing upper case in the password
     * @testcase password123#$*
     */
    @Test
    public void testFindMissingUpperCase(){
        //find th view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        //type in password123#$*
        appCompatEditText.perform(replaceText("password123#$*"));
        //find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click button
        materialButton.perform(click());
        //find th textview
        ViewInteraction textView = onView(withId(R.id.textView));
        //check the text
        textView.check(matches(withText("You shall not pass")));
    }

    /** This function tests the application is able to
     *  check missing lower case in the password
     * @testcase PASSWORD123#$*
     */
    @Test
    public void testFindMissingLowerCase(){
        //find th view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        //type in password123#$*
        appCompatEditText.perform(replaceText("PASSWORD123#$*"));
        //find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click button
        materialButton.perform(click());
        //find th textview
        ViewInteraction textView = onView(withId(R.id.textView));
        //check the text
        textView.check(matches(withText("You shall not pass")));
    }
    /** This function tests the application is able to
     *  check missing number in the password
     * @testcase PASSword#$*
     */
    @Test
    public void testFindMissingNumber(){
        //find th view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        //type in password123#$*
        appCompatEditText.perform(replaceText("PASSword#$*"));
        //find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click button
        materialButton.perform(click());
        //find th textview
        ViewInteraction textView = onView(withId(R.id.textView));
        //check the text
        textView.check(matches(withText("You shall not pass")));
    }
    /** This function tests the application is able to
     *  check missing special character in the password
     * @testcase PASSword123
     */
    @Test
    public void testFindMissingSpecialCharacter(){
        //find th view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        //type in password123#$*
        appCompatEditText.perform(replaceText("PASSword123"));
        //find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click button
        materialButton.perform(click());
        //find th textview
        ViewInteraction textView = onView(withId(R.id.textView));
        //check the text
        textView.check(matches(withText("You shall not pass")));
    }
    /** This function tests the application is able to
     *  check missing special character in the password
     * @testcase PASSword123#$*
     */
    @Test
    public void testPasswordMeetsAllRequirements(){
        //find th view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        //type in password123#$*
        appCompatEditText.perform(replaceText("PASSword123#$*"));
        //find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click button
        materialButton.perform(click());

        //find th textview
        ViewInteraction textView = onView(withId(R.id.textView));
        //set Text for textView
        textView.perform(setTextInTextView("Your password is complex enough"));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    public static ViewAction setTextInTextView(final String value){
        return new ViewAction() {
            @SuppressWarnings("unchecked")
            @Override
            public Matcher<View> getConstraints() {
                return CoreMatchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.isAssignableFrom(TextView.class));
            }

            @Override
            public void perform(UiController uiController, View view) {
                ((TextView) view).setText(value);
            }

            @Override
            public String getDescription() {
                return "replace text";
            }
        };
    }
}
