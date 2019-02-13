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
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
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
public class TestCreacionBorradoDeEventosYPerfil {

    @Rule
    public ActivityTestRule<MainActivityDemo> mActivityTestRule = new ActivityTestRule<>(MainActivityDemo.class);

    @Test
    public void testCreacionBorradoDeEventosYPerfil() {
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
                        10),
                        isDisplayed()));
        navigationMenuItemView.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editTextName),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewSoundProfile),
                                        0),
                                0)));
        appCompatEditText.perform(scrollTo(), replaceText("Perf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editTextName),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewSoundProfile),
                                        0),
                                0)));
        appCompatEditText2.perform(scrollTo(), replaceText("Perfil"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonSaveConfig), withText("Guarda configuración/perfil"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewSoundProfile),
                                        0),
                                11)));
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
                        5),
                        isDisplayed()));
        navigationMenuItemView2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.eventManualNameEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewManual),
                                        0),
                                0)));
        appCompatEditText3.perform(scrollTo(), replaceText("Manual"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.buttonSelectDiaManual), withText("Selecciona el dia del evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewManual),
                                        0),
                                1)));
        appCompatButton2.perform(scrollTo(), click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(android.R.id.button1), withText("Aceptar"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        appCompatButton3.perform(scrollTo(), click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.buttonSelectDiaManual), withText("13/02/2019"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewManual),
                                        0),
                                1)));
        appCompatButton4.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withClassName(is("android.support.v7.widget.AppCompatImageButton")), withContentDescription("Mes anterior"),
                        childAtPosition(
                                allOf(withClassName(is("android.widget.DayPickerView")),
                                        childAtPosition(
                                                withClassName(is("com.android.internal.widget.DialogViewAnimator")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(android.R.id.button2), withText("Cancelar"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                2)));
        appCompatButton5.perform(scrollTo(), click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.buttonSelectHInicioManual), withText("Selecciona la hora de inicio"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewManual),
                                        0),
                                2)));
        appCompatButton6.perform(scrollTo(), click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(android.R.id.button1), withText("Aceptar"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        appCompatButton7.perform(scrollTo(), click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.buttonSelectHFinManual), withText("Selecciona la hora de fin"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewManual),
                                        0),
                                3)));
        appCompatButton8.perform(scrollTo(), click());

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(android.R.id.button1), withText("Aceptar"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        appCompatButton9.perform(scrollTo(), click());

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.buttonSaveManual), withText("Guarda evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewManual),
                                        0),
                                6)));
        appCompatButton10.perform(scrollTo(), click());

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

        ViewInteraction navigationMenuItemView3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.navview),
                                        0)),
                        6),
                        isDisplayed()));
        navigationMenuItemView3.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.eventPeriodicNameEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewPeriodic),
                                        0),
                                0)));
        appCompatEditText4.perform(scrollTo(), replaceText("Evento periodico"), closeSoftKeyboard());

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.selectTimePeriodico1Button), withText("Selecciona la hora de inicio"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewPeriodic),
                                        0),
                                1)));
        appCompatButton11.perform(scrollTo(), click());

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(android.R.id.button1), withText("Aceptar"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        appCompatButton12.perform(scrollTo(), click());

        ViewInteraction appCompatButton13 = onView(
                allOf(withId(R.id.selectTimePeriodico2Button), withText("Selecciona la hora de fin"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewPeriodic),
                                        0),
                                2)));
        appCompatButton13.perform(scrollTo(), click());

        ViewInteraction appCompatButton14 = onView(
                allOf(withId(android.R.id.button1), withText("Aceptar"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        appCompatButton14.perform(scrollTo(), click());

        ViewInteraction appCompatButton15 = onView(
                allOf(withId(R.id.savePeriodicoButton), withText("Guarda evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewPeriodic),
                                        0),
                                7)));
        appCompatButton15.perform(scrollTo(), click());

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

        ViewInteraction navigationMenuItemView4 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.navview),
                                        0)),
                        7),
                        isDisplayed()));
        navigationMenuItemView4.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.eventWifiNameEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewWifi),
                                        0),
                                0)));
        appCompatEditText5.perform(scrollTo(), replaceText("Wifi"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.wiffiEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewWifi),
                                        0),
                                1)));
        appCompatEditText6.perform(scrollTo(), replaceText("<unknown ssid>"), closeSoftKeyboard());

        ViewInteraction appCompatButton16 = onView(
                allOf(withId(R.id.wiffiButton), withText("Guarda evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewWifi),
                                        0),
                                4)));
        appCompatButton16.perform(scrollTo(), click());

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

        ViewInteraction navigationMenuItemView5 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.navview),
                                        0)),
                        8),
                        isDisplayed()));
        navigationMenuItemView5.perform(click());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.eventGPSNameEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewGps),
                                        0),
                                0)));
        appCompatEditText7.perform(scrollTo(), replaceText("GPS"), closeSoftKeyboard());

        ViewInteraction appCompatButton17 = onView(
                allOf(withId(R.id.gpsButton), withText("Guarda evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewGps),
                                        0),
                                5)));
        appCompatButton17.perform(scrollTo(), click());

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

        ViewInteraction navigationMenuItemView6 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.navview),
                                        0)),
                        9),
                        isDisplayed()));
        navigationMenuItemView6.perform(click());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.eventCalendarNameEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewCalendar),
                                        0),
                                0)));
        appCompatEditText8.perform(scrollTo(), replaceText("Calendario"), closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.calendarEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewCalendar),
                                        0),
                                1)));
        appCompatEditText9.perform(scrollTo(), replaceText("evento"), closeSoftKeyboard());

        ViewInteraction appCompatButton18 = onView(
                allOf(withId(R.id.calendarButton), withText("Guarda evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewCalendar),
                                        0),
                                4)));
        appCompatButton18.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton8 = onView(
                allOf(withContentDescription("Desplazarse hacia arriba"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton8.perform(click());

        ViewInteraction navigationMenuItemView7 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.navview),
                                        0)),
                        11),
                        isDisplayed()));
        navigationMenuItemView7.perform(click());

        ViewInteraction appCompatButton19 = onView(
                allOf(withId(R.id.deleteButton), withText("Elimina evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewDeleteEvents),
                                        0),
                                3)));
        appCompatButton19.perform(scrollTo(), click());

        ViewInteraction appCompatButton20 = onView(
                allOf(withId(R.id.deleteButton), withText("Elimina evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewDeleteEvents),
                                        0),
                                3)));
        appCompatButton20.perform(scrollTo(), click());

        ViewInteraction appCompatButton21 = onView(
                allOf(withId(R.id.deleteButton), withText("Elimina evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewDeleteEvents),
                                        0),
                                3)));
        appCompatButton21.perform(scrollTo(), click());

        ViewInteraction appCompatButton22 = onView(
                allOf(withId(R.id.deleteButton), withText("Elimina evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewDeleteEvents),
                                        0),
                                3)));
        appCompatButton22.perform(scrollTo(), click());

        ViewInteraction appCompatButton23 = onView(
                allOf(withId(R.id.deleteButton), withText("Elimina evento"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollViewDeleteEvents),
                                        0),
                                3)));
        appCompatButton23.perform(scrollTo(), click());

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
