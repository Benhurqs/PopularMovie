package benhurqs.com.popularmovies.movieList.domain.entities;

import java.util.Arrays;

import benhurqs.com.popularmovies.commons.domain.usecases.UseCase;

/**
 * Created by Benhur on 19/02/17.
 */

public class MovieList implements UseCase.ResponseValue {
    public int page;
    public int total_results;
    public int total_pages;
    public Movie[] results;

    @Override
    public String toString() {
        return "MovieList{" +
                "page=" + page +
                ", total_results=" + total_results +
                ", total_pages=" + total_pages +
                ", results=" + Arrays.toString(results) +
                '}';
    }
}
