package com.revastt.moviecatalogue.ui.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.revastt.moviecatalogue.R;
import com.revastt.moviecatalogue.ui.favorite.FavoriteFragment;
import com.revastt.moviecatalogue.ui.movie.MovieFragment;
import com.revastt.moviecatalogue.ui.tv.TvFragment;

public class HomeActivity extends AppCompatActivity {
	private final String SELECTED_MENU = "selected_menu";
	private BottomNavigationView navView;
	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
		Fragment fragment = null;
		if (item.getItemId() == R.id.action_movie) {
			fragment = MovieFragment.newInstance();
		} else if (item.getItemId() == R.id.action_tv) {
			fragment = TvFragment.newInstance();
		}else if (item.getItemId() == R.id.action_favorite) {
			fragment = FavoriteFragment.newInstance();
		}

		if (fragment != null) {
			getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.container, fragment).commit();
		}
		return true;
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		navView = findViewById(R.id.nav_view);
		navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

		if (savedInstanceState != null) {
			savedInstanceState.getInt(SELECTED_MENU);
		} else {
			navView.setSelectedItemId(R.id.action_movie);
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(SELECTED_MENU, navView.getSelectedItemId());
	}

	@Override
	public void onBackPressed() {

		int seletedItemId = navView.getSelectedItemId();
		if (R.id.action_movie != seletedItemId) {
			navView.setSelectedItemId(R.id.action_movie);
		} else {
			super.onBackPressed();
		}
	}

}