package com.example.demo.entity;

import java.util.ArrayList;

public class film {
    private String _id;
    private ArrayList<person> directors;
    private ArrayList<String> genres;
    private String season_count;
    private rate rating;
    private ArrayList<String> pubdate;
    private ArrayList<String> countries;
    private String lens_id;
    private ArrayList<person> casts;
    private String title;
    private String site;
    private String poster;
    private String summary;
    private ArrayList<String> languages;
    private String episodes;
    private ArrayList<person> writers;
    private String imdb;
    private String year;
    private String duration;
    private String douban_site;
    private ArrayList<String> aka;

    public film(String _id, String title) {
        this._id = _id;
        this.title = title;
    }

    public film() {
    }

    public film(ArrayList<String> genres, ArrayList<String> countries) {
        this.genres = genres;
        this.countries = countries;
    }

    public film(String _id, ArrayList<String> genres, rate rating, ArrayList<String> pubdate, String title, ArrayList<String> aka,String poster) {
        this._id = _id;
        this.genres = genres;
        this.rating = rating;
        this.pubdate = pubdate;
        this.title = title;
        this.poster=poster;
        this.aka = aka;
    }

    public film(String _id, ArrayList<person> directors, ArrayList<String> genres, String season_count, rate rating, ArrayList<String> pubdate, ArrayList<String> countries, String lens_id, ArrayList<person> casts, String title, String site, String poster, String summary, ArrayList<String> languages, String episodes, ArrayList<person> writers, String imdb, String year, String duration, String douban_site, ArrayList<String> aka) {
        this._id = _id;
        this.directors = directors;
        this.genres = genres;
        this.season_count = season_count;
        this.rating = rating;
        this.pubdate = pubdate;
        this.countries = countries;
        this.lens_id = lens_id;
        this.casts = casts;
        this.title = title;
        this.site = site;
        this.poster = poster;
        this.summary = summary;
        this.languages = languages;
        this.episodes = episodes;
        this.writers = writers;
        this.imdb = imdb;
        this.year = year;
        this.duration = duration;
        this.douban_site = douban_site;
        this.aka = aka;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public ArrayList<person> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<person> directors) {
        this.directors = directors;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public String getSeason_count() {
        return season_count;
    }

    public void setSeason_count(String season_count) {
        this.season_count = season_count;
    }

    public rate getRating() {
        return rating;
    }

    public void setRating(rate rating) {
        this.rating = rating;
    }

    public ArrayList<String> getPubdate() {
        return pubdate;
    }

    public void setPubdate(ArrayList<String> pubdate) {
        this.pubdate = pubdate;
    }

    public ArrayList<String> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<String> countries) {
        this.countries = countries;
    }

    public String getLens_id() {
        return lens_id;
    }

    public void setLens_id(String lens_id) {
        this.lens_id = lens_id;
    }

    public ArrayList<person> getCasts() {
        return casts;
    }

    public void setCasts(ArrayList<person> casts) {
        this.casts = casts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    public ArrayList<person> getWriters() {
        return writers;
    }

    public void setWriters(ArrayList<person> writers) {
        this.writers = writers;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public ArrayList<String> getAka() {
        return aka;
    }

    public void setAka(ArrayList<String> aka) {
        this.aka = aka;
    }
}
