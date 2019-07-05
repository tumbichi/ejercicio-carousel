package com.pity.carousels_toolbox.models;

import android.net.Uri;

public class CarouselItemModel {
    private String title;
    private Uri imageUrl;
    private Uri videoUrl;

    public CarouselItemModel(String title, Uri imageUrl, Uri videoUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
    }

    public String getTitle() {
        return title;
    }

    public Uri getImageUrl() {
        return imageUrl;
    }

    public Uri getVideoUrl() {
        return videoUrl;
    }
}
