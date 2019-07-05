package com.pity.carousels_toolbox.views;

import android.net.Uri;
import android.view.MenuItem;
import android.view.View;


import com.pity.carousels_toolbox.base.IBaseActivity;

public interface IMainView extends IBaseActivity {
    void toast(String msg);
    void navigateToVideoPlayerWith(Uri videoUrl);
    boolean isCarouselThumbVisible();
    void setIconThumb(MenuItem item);
    void setIconPoster(MenuItem item);
    void showCarouselThumb();
    void showCarouselPoster();
    void setCarouselTitle(String title);

}
