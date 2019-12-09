package com.revastt.moviecatalogue.ui.favorite.favtv;

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
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.revastt.moviecatalogue.R;
import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.viewmodel.ViewModelFactory;


public class FavTv extends Fragment implements FavoritTvFragmentCallback {
	private FavTvPagedAdapter adapter;
	private RecyclerView rvMovies;
	private ProgressBar progressBar;
	private FavTvViewModel viewModel;
	private ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
		@Override
		public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
			// Aksi di bawah digunakan untuk melakukan swap ke kenan dan ke kiri
			return makeMovementFlags(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
		}

		@Override
		public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
			return true;
		}

		@Override
		public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
			if (getView() != null) {
				// Sebelum melakukan penghapusan, course harus mendapatkan posisi dari item yang di swipe
				int swipedPosition = viewHolder.getAdapterPosition();

				// Kemudian memanggil CourseEntity sesuai posisi ketika diswipe
				FavTvEntity courseEntity = adapter.getItemById(swipedPosition);

				// Melakukan setBookmark untuk menghapus bookmark dari list course
				viewModel.deleteMovie(courseEntity);

				// Memanggil Snackbar untuk melakukan pengecekan, apakah benar melakukan penghapusan bookmark
				Snackbar snackbar = Snackbar.make(getView(), R.string.message_undo, Snackbar.LENGTH_LONG);

				// Mengembalikan item yang terhapus
				snackbar.setAction(R.string.message_ok, v -> viewModel.setFav(courseEntity));

				// Menampilkan snackbar
				snackbar.show();
			}
		}
	});


	@NonNull
	private static FavTvViewModel obtainViewModel(FragmentActivity activity) {
		// Use a Factory to inject dependencies into the ViewModel
		ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
		return ViewModelProviders.of(activity, factory).get(FavTvViewModel .class);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.favorite_main, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		rvMovies = view.findViewById(R.id.rv_fav);
		progressBar = view.findViewById(R.id.progress_bar);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (getActivity() != null) {
			viewModel = obtainViewModel(getActivity());

			adapter = new FavTvPagedAdapter(this);

			viewModel.getTvPaged().observe(this, courses -> {
				if (courses != null) {
					switch (courses.status) {
						case LOADING:
							progressBar.setVisibility(View.VISIBLE);
							break;
						case SUCCESS:
							progressBar.setVisibility(View.GONE);
							adapter.submitList(courses.data);
							adapter.notifyDataSetChanged();
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
			rvMovies.setAdapter(adapter);

			//Memberikan aksi untuk swipe
			itemTouchHelper.attachToRecyclerView(rvMovies);
		}
	}
	@Override
	public void onShareClick(FavTvEntity movieEntity) {
		if (getActivity() != null) {
			String mimeType = "text/plain";
			ShareCompat.IntentBuilder
					.from(getActivity())
					.setType(mimeType)
					.setChooserTitle("Bagikan aplikasi ini sekarang.")
					.setText("Segera dapatkan informasi film terbaru "+movieEntity.getName())
					.startChooser();
		}
	}

	@Override
	public void onDelete(FavTvEntity movieEntity) {
		viewModel.deleteMovie(movieEntity);
	}
}
