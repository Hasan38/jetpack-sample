package com.revastt.moviecatalogue.data.remote.paging;



public class GetMovieHelper {/*extends PageKeyedDataSource<Long, MoviesResult> {

	/*private ApiInterface dataService;

	@Override
	public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull final LoadInitialCallback<Long, MoviesResult> callback) {

		dataService = RetrofitBuilder.builder().create(ApiInterface.class);
		Call data = dataService.getMovies(1);
		data.enqueue(new Callback () {
			@Override
			public void onResponse(Call call, Response response) {
				Movies movies = (Movies) response.body();
				callback.onResult(movies.getResults(),null,(long)2);
			}

			@Override
			public void onFailure(Call  call, Throwable t) {

			}
		});

	}

	@Override
	public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, MoviesResult> callback) {

	}

	@Override
	public void loadAfter(@NonNull final LoadParams<Long> params, @NonNull final LoadCallback<Long, MoviesResult> callback) {


		dataService = RetrofitBuilder.builder().create(ApiInterface.class);
		Call data = dataService.getMovies(params.key);
		data.enqueue(new Callback () {
			@Override
			public void onResponse(Call call, Response response) {
				Movies movies = (Movies) response.body();
				callback.onResult(movies.getResults(), params.key+1);
			}

			@Override
			public void onFailure(Call call, Throwable t) {

			}
		});


	}*/
}