package benhurqs.com.popularmovies.movieList.presentation;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import benhurqs.com.popularmovies.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

//@LargeTest
//@RunWith(AndroidJUnit4.class)
public class HomeActivityTest {
//
//    @Rule
//    public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<>(HomeActivity.class);
//
//    @Test
//    public void homeActivityTest() {
//        ViewInteraction appCompatButton = onView(
//                allOf(withText("send top"),
//                        withParent(allOf(withId(R.id.activity_home),
//                                withParent(withId(android.R.id.content)))),
//                        isDisplayed()));
//        appCompatButton.perform(click());
//
//        ViewInteraction appCompatButton2 = onView(
//                allOf(withText("send popular"),
//                        withParent(allOf(withId(R.id.activity_home),
//                                withParent(withId(android.R.id.content)))),
//                        isDisplayed()));
//        appCompatButton2.perform(click());
//
//        ViewInteraction appCompatButton3 = onView(
//                allOf(withText("get movie"),
//                        withParent(allOf(withId(R.id.activity_home),
//                                withParent(withId(android.R.id.content)))),
//                        isDisplayed()));
//        appCompatButton3.perform(click());
//
//        ViewInteraction textView = onView(
//                allOf(withId(R.id.txt_name), withText("Your Name."),
//                        childAtPosition(
//                                allOf(withId(R.id.activity_home),
//                                        childAtPosition(
//                                                withId(android.R.id.content),
//                                                0)),
//                                0),
//                        isDisplayed()));
//        textView.check(matches(withText("Your Name.")));
//
//    }
//
//    private static Matcher<View> childAtPosition(
//            final Matcher<View> parentMatcher, final int position) {
//
//        return new TypeSafeMatcher<View>() {
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("Child at position " + position + " in parent ");
//                parentMatcher.describeTo(description);
//            }
//
//            @Override
//            public boolean matchesSafely(View view) {
//                ViewParent parent = view.getParent();
//                return parent instanceof ViewGroup && parentMatcher.matches(parent)
//                        && view.equals(((ViewGroup) parent).getChildAt(position));
//            }
//        };
//    }
}
