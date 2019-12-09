package com.revastt.moviecatalogue.di;

import android.app.Application;

import com.revastt.moviecatalogue.data.MovieRepository;
import com.revastt.moviecatalogue.data.local.LocalRepository;
import com.revastt.moviecatalogue.data.local.room.MovieDatabase;
import com.revastt.moviecatalogue.data.remote.RemoteRepository;
import com.revastt.moviecatalogue.utils.AppExecutors;

public class Injection {
	public static MovieRepository provideRepository(Application application) {

		MovieDatabase database = MovieDatabase.getInstance(application);

		LocalRepository localRepository = LocalRepository.getInstance(database.academyDao());
		RemoteRepository remoteRepository = RemoteRepository.getInstance();
		AppExecutors appExecutors = new AppExecutors();

		return MovieRepository.getInstance(localRepository, remoteRepository, appExecutors);
	}
}
