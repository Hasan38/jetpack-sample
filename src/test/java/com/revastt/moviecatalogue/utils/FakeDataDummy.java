package com.revastt.moviecatalogue.utils;

import com.revastt.moviecatalogue.R;
import com.revastt.moviecatalogue.data.local.entity.FavMovieEntity;
import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.data.local.entity.MovieEntity;
import com.revastt.moviecatalogue.data.local.entity.TvEntity;
import com.revastt.moviecatalogue.data.remote.response.MovieDetail;
import com.revastt.moviecatalogue.data.remote.response.TvDetail;

import java.util.ArrayList;
import java.util.List;

public class FakeDataDummy {

	public static ArrayList<MovieEntity> generateDummyMovie() {


		ArrayList<MovieEntity> movie = new ArrayList<>();

		movie.add(new MovieEntity(
				"/tBuabjEqxzoUBHfbyNbd8ulgy5j.jpg", 420809, "Maleficent: Mistress of Evil", 7.3,"Maleficent and her goddaughter Aurora begin to question the complex family ties that bind them as they are pulled in different directions by impending nuptials, unexpected allies, and dark new forces at play.",  "2019-10-16","/skvI4rYFrKXS73BJxWGH54Omlvv.jpg"));
		movie.add(new MovieEntity(
				"/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg",
				3,
				"Bird Box",
				6.4,
				"More than two decades have passed since Sarah Connor prevented Judgment Day, changed the future, and re-wrote the fate of the human race. Dani Ramos is living a simple life in Mexico City with her brother and father when a highly advanced and deadly new Terminator – a Rev-9 – travels back through time to hunt and kill her. Dani's survival depends on her joining forces with two warriors: Grace, an enhanced super-soldier from the future, and a battle-hardened Sarah Connor. As the Rev-9 ruthlessly destroys everything and everyone in its path on the hunt for Dani, the three are led to a T-800 from Sarah’s past that may be their last best hope.",  "July 24, 2006","/a6cDxdwaQIFjSkXf7uskg78ZyTq.jpg"));
		movie.add(new MovieEntity(
				"/vn94LlNrbUWIZZyAdmvUepFBeaY.jpg", 449924, "Ip Man 4: The Finale", 5.8,"Ip Man 4 is an upcoming Hong Kong biographical martial arts film directed by Wilson Yip and produced by Raymond Wong. It is the fourth in the Ip Man film series based on the life of the Wing Chun grandmaster of the same name and features Donnie Yen reprising the role. The film began production in April 2018 and ended in July the same year.",  "2019-12-20","/ekP6EVxL81lZ4ivcqPsoZ72rY0h.jpg"));
		movie.add(new MovieEntity(
				"/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg", 475557, "Joker", 8.5,"During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",  "2019-10-02","/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg"));

		return movie;
	}
	public static ArrayList<MovieDetail> generateDummyMovieDetail() {

		ArrayList<MovieDetail> movie1 = new ArrayList<>();

		movie1.add(new MovieDetail(
				"/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg", 475557, "Joker", 8.5,"During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",  "2019-10-04","/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg"));
		movie1.add(new MovieDetail(
				"/tBuabjEqxzoUBHfbyNbd8ulgy5j.jpg", 420809, "Maleficent: Mistress of Evil", 7.3,"Maleficent and her goddaughter Aurora begin to question the complex family ties that bind them as they are pulled in different directions by impending nuptials, unexpected allies, and dark new forces at play.",  "2019-10-18","/skvI4rYFrKXS73BJxWGH54Omlvv.jpg"));
		movie1.add(new MovieDetail(
				"/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg",
				3,
				"Bird Box",
				6.4,
				"More than two decades have passed since Sarah Connor prevented Judgment Day, changed the future, and re-wrote the fate of the human race. Dani Ramos is living a simple life in Mexico City with her brother and father when a highly advanced and deadly new Terminator – a Rev-9 – travels back through time to hunt and kill her. Dani's survival depends on her joining forces with two warriors: Grace, an enhanced super-soldier from the future, and a battle-hardened Sarah Connor. As the Rev-9 ruthlessly destroys everything and everyone in its path on the hunt for Dani, the three are led to a T-800 from Sarah’s past that may be their last best hope.",  "July 24, 2006","/a6cDxdwaQIFjSkXf7uskg78ZyTq.jpg"));
		movie1.add(new MovieDetail(
				"/vn94LlNrbUWIZZyAdmvUepFBeaY.jpg", 449924, "Ip Man 4: The Finale", 5.8,"Ip Man 4 is an upcoming Hong Kong biographical martial arts film directed by Wilson Yip and produced by Raymond Wong. It is the fourth in the Ip Man film series based on the life of the Wing Chun grandmaster of the same name and features Donnie Yen reprising the role. The film began production in April 2018 and ended in July the same year.",  "2019-12-20","/ekP6EVxL81lZ4ivcqPsoZ72rY0h.jpg"));

		return movie1;
	}

	public static ArrayList<TvEntity> generateDummyTv() {

		ArrayList<TvEntity> tv = new ArrayList<>();

		tv.add(new TvEntity("/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg", "The Flash","2000-05-31",60735,6.7,  "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.","/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"));

		tv.add(new TvEntity("/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg","Arrow","2012-10-10",1412,5.8,  "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.","/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"));

		return tv;
	}

	public static MovieEntity generateRemoteMovieDetail(Integer movieId) {

		MovieEntity movie= new MovieEntity(
				"/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg", movieId, "Joker", 8.5,"During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",  "2019-10-04","/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg");


		return movie;
	}

	public static TvEntity generateDummyTvDetail(Integer tvId) {

		TvEntity tv = new TvEntity("/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg","Arrow","2012-10-10",tvId,5.8,  "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.","/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg");
		return tv;
	}

	public static List<TvDetail> generateDummyDetailTv(Integer tvId) {
		ArrayList<TvDetail> tv = new ArrayList<>();

		tv.add(new TvDetail(String.valueOf(R.drawable.poster_arrow_tv),tvId,"Arrow",5.5,"Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.","October 10, 2012",String.valueOf(R.drawable.poster_arrow_tv)));
		tv.add(new TvDetail(String.valueOf(R.drawable.poster_fairytail_tv), tvId,"Fairy Tail",6.5, "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.","October 10, 2012",String.valueOf(R.drawable.poster_fairytail_tv)));
		tv.add(new TvDetail(String.valueOf(R.drawable.poster_family_guy_tv),tvId,"Family Guy",6.3, "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.","October 10, 2012",String.valueOf(R.drawable.poster_family_guy_tv)));
		tv.add(new TvDetail(String.valueOf(R.drawable.poster_flash_tv),tvId,"The Flash",7.5, "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.","October 10, 2012",String.valueOf(R.drawable.poster_flash_tv)));
		tv.add(new TvDetail(String.valueOf(R.drawable.poster_god_tv),tvId,"Game of Thrones",5.8, "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.","October 10, 2012",String.valueOf(R.drawable.poster_god_tv)));
		tv.add(new TvDetail(String.valueOf(R.drawable.poster_gotham_tv),tvId,"Gotham",6.2, "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.","October 10, 2012",String.valueOf(R.drawable.poster_gotham_tv)));
		tv.add(new TvDetail(String.valueOf(R.drawable.poster_grey_anatomy_tv),tvId,"Greys Anatomy",5.3, "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.","October 10, 2012",String.valueOf(R.drawable.poster_grey_anatomy_tv)));
		tv.add(new TvDetail(String.valueOf(R.drawable.poster_hanna_tv),tvId,"Hanna",5.5, "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.","October 10, 2012",String.valueOf(R.drawable.poster_hanna_tv)));
		tv.add(new TvDetail(String.valueOf(R.drawable.poster_iron_fist_tv),tvId,"Marvels Iron First",7.5, "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.","October 10, 2012",String.valueOf(R.drawable.poster_iron_fist_tv)));
		tv.add(new TvDetail(String.valueOf(R.drawable.poster_naruto_shipudden_tv),tvId,"Naruto Shippuden",7.5, "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.","October 10, 2012",String.valueOf(R.drawable.poster_naruto_shipudden_tv)));



		return tv;
	}

	public static ArrayList<FavMovieEntity> generateDummyMovieFav() {


		ArrayList<FavMovieEntity> movie = new ArrayList<>();

		movie.add(new FavMovieEntity(
				"/tBuabjEqxzoUBHfbyNbd8ulgy5j.jpg", 420809, "Maleficent: Mistress of Evil", 7.3,"Maleficent and her goddaughter Aurora begin to question the complex family ties that bind them as they are pulled in different directions by impending nuptials, unexpected allies, and dark new forces at play.",  "2019-10-16","/skvI4rYFrKXS73BJxWGH54Omlvv.jpg"));
		movie.add(new FavMovieEntity(
				"/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg",
				3,
				"Bird Box",
				6.4,
				"More than two decades have passed since Sarah Connor prevented Judgment Day, changed the future, and re-wrote the fate of the human race. Dani Ramos is living a simple life in Mexico City with her brother and father when a highly advanced and deadly new Terminator – a Rev-9 – travels back through time to hunt and kill her. Dani's survival depends on her joining forces with two warriors: Grace, an enhanced super-soldier from the future, and a battle-hardened Sarah Connor. As the Rev-9 ruthlessly destroys everything and everyone in its path on the hunt for Dani, the three are led to a T-800 from Sarah’s past that may be their last best hope.",  "July 24, 2006","/a6cDxdwaQIFjSkXf7uskg78ZyTq.jpg"));
		movie.add(new FavMovieEntity(
				"/vn94LlNrbUWIZZyAdmvUepFBeaY.jpg", 449924, "Ip Man 4: The Finale", 5.8,"Ip Man 4 is an upcoming Hong Kong biographical martial arts film directed by Wilson Yip and produced by Raymond Wong. It is the fourth in the Ip Man film series based on the life of the Wing Chun grandmaster of the same name and features Donnie Yen reprising the role. The film began production in April 2018 and ended in July the same year.",  "2019-12-20","/ekP6EVxL81lZ4ivcqPsoZ72rY0h.jpg"));
		movie.add(new FavMovieEntity(
				"/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg", 475557, "Joker", 8.5,"During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",  "2019-10-02","/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg"));

		return movie;
	}
	public static ArrayList<FavTvEntity> generateDummyTvFav() {


		ArrayList<FavTvEntity> tv = new ArrayList<>();

		tv.add(new FavTvEntity("/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg", "The Flash","2000-05-31",60735,6.7,  "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.","/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"));

		tv.add(new FavTvEntity("/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg","Arrow","2012-10-10",1412,5.8,  "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.","/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"));

		return tv;

	}
}