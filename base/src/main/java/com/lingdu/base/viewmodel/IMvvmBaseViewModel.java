package com.lingdu.base.viewmodel;


public interface IMvvmBaseViewModel<V> {

    void attachUI(V view);

    V getPageView();

    boolean isUIAttached();

    void detachUI();
}
