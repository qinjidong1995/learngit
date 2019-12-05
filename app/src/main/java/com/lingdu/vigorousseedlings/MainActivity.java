package com.lingdu.vigorousseedlings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.lingdu.base.activity.MvvmActivity;
import com.lingdu.base.viewmodel.MvvmBaseViewModel;
import com.lingdu.vigorousseedlings.databinding.ActivityMainBinding;

public class MainActivity extends MvvmActivity<ActivityMainBinding, MvvmBaseViewModel> {
    private Fragment mHomeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CCResult result = CC.obtainBuilder("Home").setActionName("getHomeFragment")
                .build().call();
        mHomeFragment = (Fragment)result.getDataMap().get("fragment");
        fromFragment = mHomeFragment;

        viewDataBinding.bottomView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragCategory = null;
                // init corresponding fragment
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        fragCategory = mHomeFragment;
                        break;
                    case R.id.menu_categories:
                        fragCategory = mHomeFragment;
                        break;
                    case R.id.menu_services:
                        fragCategory = mHomeFragment;
                        break;
                    case R.id.menu_account:
                        fragCategory = mHomeFragment;
                        break;
                }
                //Set bottom menu selected item text in toolbar
                ActionBar actionBar = getSupportActionBar();
                if (actionBar != null) {
                    actionBar.setTitle(item.getTitle());
                }
                switchFragment(fromFragment, fragCategory);
                fromFragment = fragCategory;
                return true;
            }
        });
        viewDataBinding.bottomView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, mHomeFragment);
        transaction.commit();
    }

    @Override
    protected void onRetryBtnClick() {
        //jhahaaa
    }

    @Override
    protected MvvmBaseViewModel getViewModel() {
        return null;
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    Fragment fromFragment;

    private void switchFragment(Fragment from, Fragment to) {
        if (from != to) {
            FragmentManager manger = getSupportFragmentManager();
            FragmentTransaction transaction = manger.beginTransaction();
            if (!to.isAdded()) {
                if (from != null) {
                    transaction.hide(from);
                }
                if (to != null) {
                    transaction.add(R.id.container, to).commit();
                }

            } else {
                if (from != null) {
                    transaction.hide(from);
                }
                if (to != null) {
                    transaction.show(to).commit();
                }

            }
        }
    }
}
