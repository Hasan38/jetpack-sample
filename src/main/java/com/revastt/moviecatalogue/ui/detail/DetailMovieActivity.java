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
import com.revastt.moviecatalogue.data.local.entity.FavMovieEntity;
import com.revastt.moviecatalogue.data.local.entity.MovieEntity;
import com.revastt.moviecatalogue.data.remote.config.ConfigApi;
import com.revastt.moviecatalogue.utils.GlideApp;
import com.revastt.moviecatalogue.viewmodel.ViewModelFactory;

public class DetailMovieActivity extends AppCompatActivity {
	public static final String DATA_MOVIE = "data";
	TextView txtTitle,txtRelease, txtOverview, txtRating;
	ImageView imgPhoto,imageBack,btnFav;
	DetailMovieViewModel viewModel;
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
			int id = extras.getInt(DATA_MOVIE, 0);
			if (id != 0) {
				viewModel.setId(id);

			}
		}


		viewModel.movie.observe(this, movieEntityResource -> {
			if (movieEntityResource != null) {

				switch (movieEntityResource.status) {
					case LOADING:
						progressBar.setVisibility(View.VISIBLE);
						break;
					case SUCCESS:
						if (movieEntityResource.data != null) {
							progressBar.setVisibility(View.GONE);
							getData(movieEntityResource.data);

							btnFav.setOnClickListener(v -> {
								FavMovieEntity Fav = new FavMovieEntity(
										movieEntityResource.data.getPosterPath(),
										movieEntityResource.data.getId(),
										movieEntityResource.data.getTitle(),
										movieEntityResource.data.getVoteAverage(),
										movieEntityResource.data.getOverview(),
										movieEntityResource.data.getReleaseDate(),
										movieEntityResource.data.getBackdropPath()
								);

								viewModel.setFav(Fav);
								Toast.makeText(this,movieEntityResource.data.getTitle()+"  Ditambahkam ke favorit",Toast.LENGTH_LONG).show();
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


	private void getData(MovieEntity movieDetail) {

		toolbar.setTitle(movieDetail.getTitle());
		setSupportActionBar(toolbar);
		if (getSupportActionBar() != null) {
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		}
		toolbar.setNavigationOnClickListener(v -> finish());

		txtTitle.setText(movieDetail.getTitle());
		txtRelease.setText(movieDetail.getReleaseDate());
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
	private static DetailMovieViewModel obtainViewModel(AppCompatActivity activity) {
		// Use a Factory to inject dependencies into the ViewModel
		ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

		return ViewModelProviders.of(activity, factory).get(DetailMovieViewModel.class);
	}
}
