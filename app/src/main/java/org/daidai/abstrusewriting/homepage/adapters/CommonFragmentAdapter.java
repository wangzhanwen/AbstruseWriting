package org.daidai.abstrusewriting.homepage.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.daidai.abstrusewriting.fragments.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */
public class CommonFragmentAdapter extends FragmentPagerAdapter{
    private List<BaseFragment> mFragments;

    public CommonFragmentAdapter(FragmentManager fm, List<BaseFragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment ret=null;
        if (mFragments != null) {
            ret=mFragments.get(position);
        }

        return ret;
    }

    @Override
    public int getCount() {
        int ret=0;
        if (mFragments != null) {
            ret=mFragments.size();
        }

        return ret;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getFragmentTitle();
    }
}
