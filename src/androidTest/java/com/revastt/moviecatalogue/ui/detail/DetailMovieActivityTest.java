package com.revastt.moviecatalogue.ui.detail;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.revastt.moviecatalogue.R;
import com.revastt.moviecatalogue.data.remote.response.MovieDetail;
import com.revastt.moviecatalogue.utils.EspressoIdlingResource;
import com.revastt.moviecatalogue.utils.FakeDataDummy;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailMovieActivityTest {

	private MovieDetail dummyMv = FakeDataDummy.generateDummyMovieDetail().get(0);

	@Rule
	public ActivityTestRule<DetailMovieActivity> activityRule = new ActivityTestRule<DetailMovieActivity>(DetailMovieActivity.class) {
		@Override
		protected Intent getActivityIntent() {
			Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
			Intent result = new Intent(targetContext, DetailMovieActivity.class);
			result.putExtra(DetailMovieActivity.DATA_MOVIE, dummyMv.getId());
			return result;
		}
	};
	@Before
	public void setUp() {
		IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());

	}
	@After
	public void tearDown() {
		IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
	}
	@Test
	public void loadMovies() {

		onView(withId(R.id.movies_item_title)).check(matches(withText(dummyMv.getTitle())));
		onView(withId(R.id.movies_item_title)).check(matches(isDisplayed()));
		onView(withId(R.id.movies_item_release)).check(matches(withText(dummyMv.getReleaseDate())));
		onView(withId(R.id.movies_item_release)).check(matches(isDisplayed()));
		onView(withId(R.id.movies_item_overview)).check(matches(withText(dummyMv.getOverview())));
		onView(withId(R.id.movies_item_overview)).check(matches(isDisplayed()));
		onView(withId(R.id.movies_item_rating)).check(matches(withText(String.valueOf(dummyMv.getVoteAverage()))));
		onView(withId(R.id.movies_item_rating)).check(matches(isDisplayed()));
	}


}

