package com.pity.carousels_toolbox.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pity.carousels_toolbox.R;
import com.pity.carousels_toolbox.adapters.CarouselAdapter;
import com.pity.carousels_toolbox.base.BaseActivity;
import com.pity.carousels_toolbox.models.CarouselItemModel;
import com.pity.carousels_toolbox.presenter.IMainPresenter;
import com.pity.carousels_toolbox.presenter.MainPresenter;


public class MainView extends BaseActivity<IMainPresenter>
        implements IMainView, View.OnClickListener{



    private RecyclerView recyclerViewThumb;
    private RecyclerView recyclerViewPoster;
    private CarouselAdapter mAdapterThumb;
    private CarouselAdapter mAdapterPoster;

    private TextView textView;
    private FloatingActionButton fab;

    private final int ICON_THUMB = R.drawable.icon_thumb;
    private final int ICON_POSTER = R.drawable.icon_poster;


    @Override
    public IMainPresenter createBasePresenter(Context context) {
        return new MainPresenter(context, this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCarouselView();

    }



    private void initCarouselView(){

        recyclerViewThumb = findViewById(R.id.recycler_view_thumb);
        recyclerViewPoster = findViewById(R.id.recycler_view_poster);
        textView = findViewById(R.id.main_text_view_title);
        fab = findViewById(R.id.floatingActionButton);

        LinearLayoutManager layoutManagerThumb = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerPoster = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        mAdapterThumb  = new CarouselAdapter(this, mPresenter.getCarousel("thumb").getItemsCorousel(), R.layout.item_carousel_thumb, this);
        mAdapterPoster = new CarouselAdapter(this, mPresenter.getCarousel("poster").getItemsCorousel(), R.layout.item_carousel_poster, this);



        recyclerViewThumb.setLayoutManager(layoutManagerThumb);
        recyclerViewPoster.setLayoutManager(layoutManagerPoster);

        recyclerViewThumb.setAdapter(mAdapterThumb);
        recyclerViewPoster.setAdapter(mAdapterPoster);

        textView.setText(mPresenter.getCarousel("thumb").getTitle());
        setOnClickFabListener();
    }

    private void setOnClickFabListener(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addItem();

                mAdapterPoster.notifyDataSetChanged();
                mAdapterThumb.notifyDataSetChanged();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean isCarouselThumbVisible(){
        return recyclerViewThumb.getVisibility() == View.VISIBLE;
    }

    @Override
    public void setIconThumb(MenuItem item) {
        item.setIcon(ICON_THUMB);
    }

    @Override
    public void setIconPoster(MenuItem item) {
        item.setIcon(ICON_POSTER);
    }

    @Override
    public void showCarouselThumb() {
        recyclerViewPoster.setVisibility(View.GONE);
        recyclerViewThumb.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCarouselPoster() {
        recyclerViewThumb.setVisibility(View.GONE);
        recyclerViewPoster.setVisibility(View.VISIBLE);
    }

    @Override
    public void setCarouselTitle(String title) {
        textView.setText(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.item_change_view){
           return mPresenter.onOptionsItemSelected(item);
        }else{
            return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onClick(View v) {
        if (recyclerViewThumb.getVisibility() == View.VISIBLE) {

            int itemPosition = recyclerViewThumb.getChildLayoutPosition(v);

            mPresenter.onClickItemThumb(itemPosition);



        }else{

            int itemPosition = recyclerViewPoster.getChildLayoutPosition(v);
            mPresenter.onClickItemPoster(itemPosition);
        }
    }

    @Override
    public void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateToVideoPlayerWith(Uri videoUrl){
        Intent videoPlayerIntent = new Intent(MainView.this, VideoPlayerView.class);
        videoPlayerIntent.setData(videoUrl);
        startActivity(videoPlayerIntent);
    }

}
