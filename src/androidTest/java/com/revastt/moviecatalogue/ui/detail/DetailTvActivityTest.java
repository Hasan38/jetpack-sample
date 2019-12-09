package com.revastt.moviecatalogue.ui.detail;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.revastt.moviecatalogue.R;
import com.revastt.moviecatalogue.data.local.entity.TvEntity;
import com.revastt.moviecatalogue.data.remote.response.TvDetail;
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

public class DetailTvActivityTest {

	private TvDetail dummyTv = FakeDataDummy.generateDummyTvDetail().get(0);

	@Rule
	public ActivityTestRule<DetailTvActivity> activityRule = new ActivityTestRule<DetailTvActivity>(DetailTvActivity.class) {
		@Override
		protected Intent getActivityIntent() {
			Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
			Intent result = new Intent(targetContext, DetailTvActivity.class);
			result.putExtra(DetailTvActivity.DATA_TV, dummyTv.getId());
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
	public void loadTv() {
		onView(withId(R.id.movie_details)).check(matches(isDisplayed()));
		onView(withId(R.id.movies_item_title)).check(matches(withText(dummyTv.getName())));
		onView(withId(R.id.movies_item_title)).check(matches(isDisplayed()));
		onView(withId(R.id.movies_item_release)).check(matches(withText(dummyTv.getFirstAirDate())));
		onView(withId(R.id.movies_item_release)).check(matches(isDisplayed()));
		onView(withId(R.id.movies_item_overview)).check(matches(withText(dummyTv.getOverview())));
		onView(withId(R.id.movies_item_overview)).check(matches(isDisplayed()));
		onView(withId(R.id.movies_item_rating)).check(matches(withText(String.valueOf(dummyTv.getVoteAverage()))));
		onView(withId(R.id.movies_item_rating)).check(matches(isDisplayed()));
	}


}

