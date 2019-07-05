package com.pity.carousels_toolbox.presenter;

import android.view.MenuItem;

import com.pity.carousels_toolbox.base.IBasePresenter;
import com.pity.carousels_toolbox.models.CarouselModel;
import com.pity.carousels_toolbox.views.IMainView;

public interface IMainPresenter extends IBasePresenter<IMainView> {

    CarouselModel getCarousel(String type);
    void addItem();
    boolean onOptionsItemSelected(MenuItem item);
    void onClickItemThumb(int itemPosition);
    void onClickItemPoster(int itemPosition);

}
