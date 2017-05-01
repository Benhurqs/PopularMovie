package benhurqs.com.popularmovies.commons.domain.entities;

/**
 * Created by Benhur on 01/05/17.
 */

public class MovieDetail {


    /**
     * {
     "adult": false,
     "backdrop_path": "/6bbZ6XyvgfjhQwbplnUh1LSj1ky.jpg",
     "belongs_to_collection": null,
     "budget": 3300000,
     "genres": [
     {
     "id": 18,
     "name": "Drama"
     },
     {
     "id": 10402,
     "name": "Music"
     }
     ],
     "homepage": "http://sonyclassics.com/whiplash/",
     "id": 244786,
     "imdb_id": "tt2582802",
     "original_language": "en",
     "original_title": "Whiplash",
     "overview": "Under the direction of a ruthless instructor, a talented young drummer begins to pursue perfection at any cost, even his humanity.",
     "popularity": 17.110271,
     "poster_path": "/lIv1QinFqz4dlp5U4lQ6HaiskOZ.jpg",
     "production_companies": [
     {
     "name": "Bold Films",
     "id": 2266
     },
     {
     "name": "Blumhouse Productions",
     "id": 3172
     },
     {
     "name": "Right of Way Films",
     "id": 32157
     }
     ],
     "production_countries": [
     {
     "iso_3166_1": "US",
     "name": "United States of America"
     }
     ],
     "release_date": "2014-10-10",
     "revenue": 48982041,
     "runtime": 105,
     "spoken_languages": [
     {
     "iso_639_1": "en",
     "name": "English"
     }
     ],
     "status": "Released",
     "tagline": "The road to greatness can take you to the edge.",
     "title": "Whiplash",
     "video": false,
     "vote_average": 8.3,
     "vote_count": 2753
     }
     */

    public boolean adult;
    public String backdrop_path;
    public long budget;
    public DefaultObj[] genres;
    public String homepage;
    public int id;
    public String imdb_id;
    public String original_language;
    public String original_title;
    public String overview;
    public float popularity;
    public String poster_path;
    public DefaultObj[] production_companies;
    public String release_date;
    public long revenue;
    public long runtime;
    public float vote_average;
    public long vote_count;

    public String genres(){
        return convert2String(genres);
    }

    public String production(){
        return convert2String(production_companies);
    }

    private String convert2String(DefaultObj[] list){
        String objConcat = "";
        for(DefaultObj obj : list){
            if(objConcat != null  && !objConcat.isEmpty()){
                objConcat = objConcat.concat(" | ");
            }

            objConcat = objConcat.concat(obj.name);
        }

        return objConcat;
    }
}
