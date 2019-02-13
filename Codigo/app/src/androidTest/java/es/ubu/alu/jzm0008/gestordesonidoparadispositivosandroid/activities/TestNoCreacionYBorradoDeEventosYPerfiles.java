package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities;


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

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TestNoCreacionYBorradoDeEventosYPerfiles {

    @Rule
    public ActivityTestRule<MainActivityDemo> mActivityTestRule = new ActivityTestRule<>(MainActivityDemo.class);

    @Test
    public void testNoCreacionYBorradoDeEventosYPerfiles() {
        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Desplazarse hacia arriba"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction navigationMenuItemView = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.navview),
                                        0)),
                        5),
                        isDisplayed()));
        navigationMenuItemView.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonSaveManual), withText("Guarda evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewManual),
                                        0),
                                6)));
        appCompatButton.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("Desplazarse hacia arriba"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction navigationMenuItemView2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.navview),
                                        0)),
                        6),
                        isDisplayed()));
        navigationMenuItemView2.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.savePeriodicoButton), withText("Guarda evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewPeriodic),
                                        0),
                                7)));
        appCompatButton2.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withContentDescription("Desplazarse hacia arriba"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction navigationMenuItemView3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.navview),
                                        0)),
                        7),
                        isDisplayed()));
        navigationMenuItemView3.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.wiffiButton), withText("Guarda evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewWifi),
                                        0),
                                4)));
        appCompatButton3.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withContentDescription("Desplazarse hacia arriba"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        ViewInteraction navigationMenuItemView4 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.navview),
                                        0)),
                        8),
                        isDisplayed()));
        navigationMenuItemView4.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.gpsButton), withText("Guarda evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewGps),
                                        0),
                                5)));
        appCompatButton4.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton5 = onView(
                allOf(withContentDescription("Desplazarse hacia arriba"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton5.perform(click());

        ViewInteraction navigationMenuItemView5 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.navview),
                                        0)),
                        9),
                        isDisplayed()));
        navigationMenuItemView5.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.calendarButton), withText("Guarda evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewCalendar),
                                        0),
                                4)));
        appCompatButton5.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton6 = onView(
                allOf(withContentDescription("Desplazarse hacia arriba"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton6.perform(click());

        ViewInteraction navigationMenuItemView6 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.navview),
                                        0)),
                        10),
                        isDisplayed()));
        navigationMenuItemView6.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.buttonSaveConfig), withText("Guarda configuración/perfil"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewSoundProfile),
                                        0),
                                11)));
        appCompatButton6.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton7 = onView(
                allOf(withContentDescription("Desplazarse hacia arriba"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton7.perform(click());

        ViewInteraction navigationMenuItemView7 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.navview),
                                        0)),
                        11),
                        isDisplayed()));
        navigationMenuItemView7.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.deleteButton), withText("Elimina evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewDeleteEvents),
                                        0),
                                3)));
        appCompatButton7.perform(scrollTo(), click());

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
}
