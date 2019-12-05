package com.lingdu.base.fragment;


import com.lingdu.base.activity.IBaseView;

public interface IBasePagingView extends IBaseView {

    void onLoadMoreFailure(String message);

    void onLoadMoreEmpty();
}
