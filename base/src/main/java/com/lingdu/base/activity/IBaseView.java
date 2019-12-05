package com.lingdu.base.activity;


public interface IBaseView {
    void showContent();

    void showLoading();

    void onRefreshEmpty();

    void onRefreshFailure(String message);
}
