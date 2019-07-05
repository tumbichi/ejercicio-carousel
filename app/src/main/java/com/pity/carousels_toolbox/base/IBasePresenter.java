package com.pity.carousels_toolbox.base;


import android.os.Bundle;

public interface IBasePresenter<TView extends IBaseActivity> {

    void onTakeView(TView view);

    void onCreate(Bundle savedState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();




}
