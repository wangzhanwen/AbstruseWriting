package org.daidai.abstrusewriting.fragments;

import android.support.v4.app.Fragment;



/**
 * Created by Administrator on 2016/10/9.
 * 首页的 Fragment 父类
 * 定义通用的属性和行为
 */
public abstract class BaseFragment extends Fragment {
    public BaseFragment() {
    }

    public abstract String getFragmentTitle();

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();

    }
}
