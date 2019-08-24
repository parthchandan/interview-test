package com.test.interview.data.rest;


import io.reactivex.Single;

import com.test.interview.data.model.AboutCananda;
import retrofit2.http.GET;

public interface ImageRepositoryService {

    @GET("s/2iodh4vg0eortkl/facts.json")
    Single<AboutCananda> getImageItems();
}
