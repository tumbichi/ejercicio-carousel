package com.pity.carousels_toolbox.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity <TPresenter extends IBasePresenter> extends AppCompatActivity
        implements IBaseActivity {

    public TPresenter mPresenter;


    public abstract TPresenter createBasePresenter(final Context context);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mPresenter == null) {
            mPresenter = createBasePresenter(this);
        }

        if (mPresenter != null) {
            mPresenter.onCreate(savedInstanceState);

        }

    }

}