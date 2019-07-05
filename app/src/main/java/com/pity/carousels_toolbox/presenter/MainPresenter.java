package com.pity.carousels_toolbox.presenter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.pity.carousels_toolbox.base.BasePresenter;
import com.pity.carousels_toolbox.base.IBaseActivity;
import com.pity.carousels_toolbox.models.CarouselItemModel;
import com.pity.carousels_toolbox.models.CarouselModel;
import com.pity.carousels_toolbox.views.IMainView;
import com.pity.carousels_toolbox.views.MainView;

import java.util.ArrayList;

public class MainPresenter extends BasePresenter<IMainView> implements IMainPresenter {

    private CarouselModel mCarouselThumb;
    private CarouselModel mCarouselPoster;

    public MainPresenter(Context context, MainView view) {
        super(context);
        mView = view;
    }

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        initCarouselItems();
    }




    private void initCarouselItems(){

        mCarouselThumb = new CarouselModel("Carousel thumb", "thumb", new ArrayList<CarouselItemModel>());
        mCarouselPoster = new CarouselModel("Carousel poster", "poster", new ArrayList<CarouselItemModel>());

        mCarouselThumb.getItemsCorousel().add(new CarouselItemModel("La Playa", Uri.parse("http://placeimg.com/640/480/any"),
                Uri.parse("http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4") ));

        mCarouselThumb.getItemsCorousel().add(new CarouselItemModel("Peligro En Bangkok", Uri.parse("http://placeimg.com/640/480/any"), null ));
        mCarouselThumb.getItemsCorousel().add(new CarouselItemModel("Todos Contra John", Uri.parse("http://placeimg.com/640/480/any"), null ));
        mCarouselThumb.getItemsCorousel().add(new CarouselItemModel("Quisiera ser millonario", Uri.parse("http://placeimg.com/640/480/any"), null ));

        mCarouselPoster.getItemsCorousel().add(new CarouselItemModel("La playa", Uri.parse("http://placeimg.com/320/480/any"),
                Uri.parse("http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4") ));

        mCarouselPoster.getItemsCorousel().add(new CarouselItemModel("Peligro En Bangkok", Uri.parse("http://placeimg.com/320/480/any"), null ));
        mCarouselPoster.getItemsCorousel().add(new CarouselItemModel("Todos Contra John", Uri.parse("http://placeimg.com/320/480/any"), null ));
        mCarouselPoster.getItemsCorousel().add(new CarouselItemModel("Quisiera ser millonario", Uri.parse("http://placeimg.com/320/480/any"), null ));
    }

    @Override
    public CarouselModel getCarousel(String type) {
        if (type.equals("poster")){
            return mCarouselPoster;
        }else{
            return mCarouselThumb;
        }
    }

    @Override
    public void addItem() {
        mCarouselPoster.getItemsCorousel().add(new CarouselItemModel("Title", Uri.parse("http://placeimg.com/320/480/any"), null));
        mCarouselThumb.getItemsCorousel().add(new CarouselItemModel("Title", Uri.parse("http://placeimg.com/640/480/any"), null));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mView.isCarouselThumbVisible()){
            mView.setIconThumb(item);
            mView.showCarouselPoster();
            mView.setCarouselTitle(mCarouselPoster.getTitle());
            return true;
        }else{
            mView.setIconPoster(item);
            mView.showCarouselThumb();
            mView.setCarouselTitle(mCarouselThumb.getTitle());
            return true;
        }
    }

    @Override
    public void onClickItemThumb(int itemPosition) {
        CarouselItemModel itemClicked = mCarouselThumb.getItemsCorousel().get(itemPosition);

        if (itemClicked.getVideoUrl() != null){
            mView.toast( "Titulo: " + itemClicked.getTitle());
            mView.navigateToVideoPlayerWith(itemClicked.getVideoUrl());
        }else mView.toast("Video no disponible");
    }

    @Override
    public void onClickItemPoster(int itemPosition) {
        CarouselItemModel itemClicked = mCarouselPoster.getItemsCorousel().get(itemPosition);

        if (itemClicked.getVideoUrl() != null) {
            mView.toast("Titulo: " + itemClicked.getTitle());
            mView.navigateToVideoPlayerWith(itemClicked.getVideoUrl());
        }else mView.toast("Video no disponible");

    }
}
