package com.revastt.moviecatalogue.ui.tv;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revastt.moviecatalogue.R;
import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.data.local.entity.TvEntity;
import com.revastt.moviecatalogue.viewmodel.ViewModelFactory;
import com.revastt.moviecatalogue.vo.Resource;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment implements FragmentCallBackTv {
	private RecyclerView rvMovies;
	private ProgressBar progressBar;
	private TvAdapter tvAdapter;
	private TvViewModel viewModel;


	public TvFragment() {
		// Required empty public constructor
	}

	public static Fragment newInstance() {
		return new TvFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_movie, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		rvMovies = view.findViewById(R.id.rv_movies);
		progressBar = view.findViewById(R.id.progress_bar);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		tvAdapter = new TvAdapter(getActivity(),this);
		if (getActivity() != null) {

			viewModel = obtainViewModel(getActivity());

			progressBar.setVisibility(View.VISIBLE);
			viewModel.setUsername();
			viewModel.movie.observe(this, (Resource<List<TvEntity>> courses) -> {
				if (courses != null) {
					switch (courses.status) {
						case LOADING:
							progressBar.setVisibility(View.VISIBLE);
							break;
						case SUCCESS:
							progressBar.setVisibility(View.GONE);
							tvAdapter.setListMovie(courses.data);
							tvAdapter.notifyDataSetChanged();
							break;
						case ERROR:
							progressBar.setVisibility(View.GONE);
							Toast.makeText(getContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
							break;

					}
				}
			});

			rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
			rvMovies.setHasFixedSize(true);
			rvMovies.setAdapter(tvAdapter);

		
		}
	}

	@NonNull
	private static TvViewModel obtainViewModel(FragmentActivity activity) {
		// Use a Factory to inject dependencies into the ViewModel
		ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
		return ViewModelProviders.of(activity, factory).get(TvViewModel.class);
	}

	@Override
	public void onShareClick(TvEntity movieEntity) {
		if (getActivity() != null) {
			String mimeType = "text/plain";
			ShareCompat.IntentBuilder
					.from(getActivity())
					.setType(mimeType)
					.setChooserTitle("Bagikan aplikasi ini sekarang.")
					.setText("Movie Catalogue " +movieEntity.getName())
					.startChooser();
		}
	}

	@Override
	public void onSaveFav(FavTvEntity movieEntity) {
		if (getActivity() != null) {
			viewModel.setFav(movieEntity);
			Toast.makeText(getActivity(),movieEntity.getName()+" ditambahkan ke Favorite",Toast.LENGTH_LONG).show();
		}
	}
}
