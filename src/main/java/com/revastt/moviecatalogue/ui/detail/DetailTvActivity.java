package com.revastt.moviecatalogue.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.request.RequestOptions;
import com.revastt.moviecatalogue.R;
import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.data.local.entity.TvEntity;
import com.revastt.moviecatalogue.data.remote.config.ConfigApi;
import com.revastt.moviecatalogue.utils.GlideApp;
import com.revastt.moviecatalogue.viewmodel.ViewModelFactory;


public class DetailTvActivity extends AppCompatActivity {
	public static final String DATA_TV = "data";
	TextView txtTitle,txtRelease, txtOverview, txtRating;
	ImageView imgPhoto,imageBack,btnFav;
	DetailTvViewModel viewModel;
	Toolbar toolbar;
	ProgressBar progressBar;
	NestedScrollView nestedScrollView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_movie);

		viewModel = obtainViewModel(this);
		nestedScrollView=findViewById(R.id.movie_details);
		progressBar=findViewById(R.id.progress_bar);
		txtTitle = findViewById(R.id.movies_item_title);
		txtRelease = findViewById(R.id.movies_item_release);
		txtOverview = findViewById(R.id.movies_item_overview);
		txtRating = findViewById(R.id.movies_item_rating);
		imgPhoto = findViewById(R.id.img_item_photo);
		imageBack=findViewById(R.id.image_movie_backdrop);
		toolbar = findViewById(R.id.toolbar);
		btnFav=findViewById(R.id.Fav);


		progressBar.setVisibility(View.VISIBLE);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			int id = extras.getInt(DATA_TV, 0);
			if (id != 0) {
				viewModel.setId(id);

			}
		}


		viewModel.tv.observe(this, tvEntityResource -> {
			if (tvEntityResource != null) {

				switch (tvEntityResource.status) {
					case LOADING:
						progressBar.setVisibility(View.VISIBLE);
						break;
					case SUCCESS:
						if (tvEntityResource.data != null) {
							progressBar.setVisibility(View.GONE);
							getData(tvEntityResource.data);

							btnFav.setOnClickListener(v -> {
								FavTvEntity Fav = new FavTvEntity(
										tvEntityResource.data.getPosterPath(),
										tvEntityResource.data.getName(),
										tvEntityResource.data.getFirstAirDate(),
										tvEntityResource.data.getId(),
										tvEntityResource.data.getVoteAverage(),
										tvEntityResource.data.getOverview(),
										tvEntityResource.data.getBackdropPath()
								);

								viewModel.setFav(Fav);
								Toast.makeText(this,tvEntityResource.data.getName()+"  Ditambahkam ke favorit",Toast.LENGTH_LONG).show();
							});
						}
						break;
					case ERROR:
						progressBar.setVisibility(View.GONE);
						Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
						break;
				}

			}
		});
	}


	private void getData(TvEntity movieDetail) {

		toolbar.setTitle(movieDetail.getName());
		setSupportActionBar(toolbar);
		if (getSupportActionBar() != null) {
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		}
		toolbar.setNavigationOnClickListener(v -> finish());

		txtTitle.setText(movieDetail.getName());
		txtRelease.setText(movieDetail.getFirstAirDate());
		txtOverview.setText(movieDetail.getOverview());
		txtRating.setText(String.valueOf(movieDetail.getVoteAverage()));
		GlideApp.with(this)
				.load(ConfigApi.POSTER_URL+movieDetail.getPosterPath())
				.apply(RequestOptions.placeholderOf(R.drawable.load).error(R.drawable.ic_error))
				.into(imgPhoto);
		GlideApp.with(this)
				.load(ConfigApi.IMAGE_BACK_URL+movieDetail.getBackdropPath())
				.apply(RequestOptions.placeholderOf(R.drawable.load).error(R.drawable.ic_error))
				.into(imageBack);


	}
	@NonNull
	private static DetailTvViewModel obtainViewModel(AppCompatActivity activity) {
		// Use a Factory to inject dependencies into the ViewModel
		ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

		return ViewModelProviders.of(activity, factory).get(DetailTvViewModel.class);
	}
}
