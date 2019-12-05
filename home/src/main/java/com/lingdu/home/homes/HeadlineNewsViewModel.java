package com.lingdu.home.homes;


import com.lingdu.base.activity.IBaseView;
import com.lingdu.base.model.BaseModel;
import com.lingdu.base.viewmodel.MvvmBaseViewModel;

import java.util.ArrayList;
import java.util .List;


public class HeadlineNewsViewModel extends MvvmBaseViewModel<HeadlineNewsViewModel.IMainView, ChannelsModel> implements BaseModel.IModelListener<ArrayList<String>> {
    public ArrayList<String> channels = new ArrayList<>();
    public HeadlineNewsViewModel(){
//        model = new ChannelsModel();
//        model.register(this);
    }

    public void refresh(){
        //model.getCachedDataAndLoad();
    }

    @Override
    public void onLoadFinish(BaseModel model, ArrayList<String> data) {
//        if(model instanceof ChannelsModel){
//            if(getPageView() != null && data instanceof List) {
//                channels.clear();
//                channels.addAll(data);
//                getPageView().onChannelsLoaded(channels);
//            }
//        }
    }

    @Override
    public void onLoadFail(BaseModel model, String prompt) {
    }


    public interface IMainView extends IBaseView {
        void onChannelsLoaded(ArrayList<String> channels);
    }
}
