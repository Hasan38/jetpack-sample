package com.revastt.moviecatalogue.ui.favorite;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.revastt.moviecatalogue.R;
import com.revastt.moviecatalogue.ui.favorite.favmovie.FavMovie;
import com.revastt.moviecatalogue.ui.favorite.favtv.FavTv;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}
	public FavoriteFragment() {
		// Required empty public constructor
	}

	public static Fragment newInstance() {
		return new FavoriteFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_favorite,container, false);
		// Setting ViewPager for each Tabs
		ViewPager viewPager = view.findViewById(R.id.viewpager);
		setupViewPager(viewPager);
		// Set Tabs inside Toolbar
		TabLayout tabs = view.findViewById(R.id.result_tabs);
		tabs.setupWithViewPager(viewPager);


		return view;

	}


	// Add Fragments to Tabs
	private void setupViewPager(ViewPager viewPager) {


		Adapter adapter = new Adapter(getChildFragmentManager());
		adapter.addFragment(new FavMovie(), "Movie");
		adapter.addFragment(new FavTv(), "Tv");

		viewPager.setAdapter(adapter);



	}

	static class Adapter extends FragmentPagerAdapter {
		private final List<Fragment> mFragmentList = new ArrayList<>();
		private final List<String> mFragmentTitleList = new ArrayList<>();

		public Adapter(FragmentManager manager) {
			super(manager);
		}

		@Override
		public Fragment getItem(int position) {
			return mFragmentList.get(position);
		}

		@Override
		public int getCount() {
			return mFragmentList.size();
		}

		public void addFragment(Fragment fragment, String title) {
			mFragmentList.add(fragment);
			mFragmentTitleList.add(title);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mFragmentTitleList.get(position);
		}
	}



}