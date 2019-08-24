package com.test.interview.data.rest;

import javax.inject.Inject;

import io.reactivex.Single;

import com.test.interview.data.model.AboutCananda;

public class ImageRepository {

    private final ImageRepositoryService imageRepositoryService;

    @Inject
    public ImageRepository(ImageRepositoryService imageRepositoryService) {
        this.imageRepositoryService = imageRepositoryService;
    }

    public Single<AboutCananda> getImageItem() {
        return imageRepositoryService.getImageItems();
    }
}
