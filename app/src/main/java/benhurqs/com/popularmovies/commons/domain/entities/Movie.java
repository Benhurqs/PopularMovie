package benhurqs.com.popularmovies.commons.domain.entities;

import java.util.Arrays;

/**
 * Created by Benhur on 19/02/17.
 */

public class Movie {

    /**
     *
     {
     "poster_path": "/xq1Ugd62d23K2knRUx6xxuALTZB.jpg",
     "adult": false,
     "overview": "Two strangers find themselves linked in a bizarre way. When a connection forms, will distance be the only thing to keep them apart?",
     "release_date": "2016-08-26",
     "genre_ids": [
     16,
     18,
     14,
     10749
     ],
     "id": 372058,
     "original_title": "君の名は。",
     "original_language": "ja",
     "title": "Your Name.",
     "backdrop_path": "/7OMAfDJikBxItZBIug0NJig5DHD.jpg",
     "popularity": 6.646871,
     "vote_count": 212,
     "video": false,
     "vote_average": 8.5
     },
     */

    public String poster_path;
    public boolean adult;
    public String overview;
    public String release_date;
    public long[] genre_ids;
    public long id;
    public String original_title;
    public String original_language;
    public String title;
    public String backdrop_path;
    public float popularity;
    public long vote_count;
    public boolean video;
    public float vote_average;

    @Override
    public String toString() {
        return "Movie{" +
                "poster_path='" + poster_path + '\'' +
                ", adult=" + adult +
                ", overview='" + overview + '\'' +
                ", release_date='" + release_date + '\'' +
                ", genre_ids=" + Arrays.toString(genre_ids) +
                ", id=" + id +
                ", original_title='" + original_title + '\'' +
                ", original_language='" + original_language + '\'' +
                ", title='" + title + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", popularity=" + popularity +
                ", vote_count=" + vote_count +
                ", video=" + video +
                ", vote_average=" + vote_average +
                '}';
    }
}
