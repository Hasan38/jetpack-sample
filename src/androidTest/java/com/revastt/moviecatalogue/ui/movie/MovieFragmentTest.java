package com.revastt.moviecatalogue.ui.movie;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import com.revastt.moviecatalogue.R;
import com.revastt.moviecatalogue.testing.SingleFragmentActivity;
import com.revastt.moviecatalogue.utils.EspressoIdlingResource;
import com.revastt.moviecatalogue.utils.RecyclerViewItemCountAssertion;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


public class MovieFragmentTest {
	@Rule
	public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
	private MovieFragment mvFragment = new MovieFragment();

	@Before
	public void setUp() {
		IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
		activityRule.getActivity().setFragment(mvFragment);
	}
	@After
	public void tearDown() {
		IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
	}
	@Test
	public void loadMovies() {

		onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
		onView(withId(R.id.rv_movies)).check(new RecyclerViewItemCountAssertion(20));
	}

}