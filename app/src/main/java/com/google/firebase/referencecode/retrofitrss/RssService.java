package com.google.firebase.referencecode.retrofitrss;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RssService
{
    @GET("feed") Call<RssFeed> getFeed();
}