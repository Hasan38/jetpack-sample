package com.revastt.moviecatalogue.data.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.revastt.moviecatalogue.data.local.entity.FavMovieEntity;
import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.data.local.entity.MovieEntity;
import com.revastt.moviecatalogue.data.local.entity.TvEntity;

@Database(entities = {MovieEntity.class, TvEntity.class, FavMovieEntity.class, FavTvEntity.class},
		version = 1,
		exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {

	private static final Object sLock = new Object();
	private static MovieDatabase INSTANCE;

	public static MovieDatabase getInstance(Context context) {
		synchronized (sLock) {
			if (INSTANCE == null) {
				INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
						MovieDatabase.class, "movie.db")
						.build();
			}
			return INSTANCE;
		}
	}

	public abstract MovieDao academyDao();

}