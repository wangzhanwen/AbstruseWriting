package org.daidai.abstrusewriting.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.daidai.abstrusewriting.R;
import org.daidai.abstrusewriting.homepage.adapters.CommonFragmentAdapter;
import org.daidai.abstrusewriting.homepage.fragments.AnchorFragment;
import org.daidai.abstrusewriting.homepage.fragments.ClassifyFragment;
import org.daidai.abstrusewriting.homepage.fragments.HotFragment;
import org.daidai.abstrusewriting.homepage.fragments.RecommandFragment;
import org.daidai.abstrusewriting.homepage.fragments.TopFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends BaseFragment implements TabLayout.OnTabSelectedListener {


    private View ret;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    public HomePageFragment() {
        // Required empty public constructor
    }

    @Override
    public String getFragmentTitle() {
        return "HomePageFragment";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ret = inflater.inflate(R.layout.fragment_home_page, container, false);
        mToolbar = (Toolbar) ret.findViewById(R.id.homepage_tool_bar);
        AppCompatActivity activity= (AppCompatActivity)getActivity();
        activity.setSupportActionBar(mToolbar);
        setHasOptionsMenu(true);

        ActionBar actionBar = activity.getSupportActionBar();
        //actionBar.setIcon(android.R.drawable.ic_menu_info_details);
        if (actionBar != null) {
            //actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator();
            actionBar.setDisplayShowTitleEnabled(false);

        }



        mTabLayout = (TabLayout) ret.findViewById(R.id.homepage_tablayout);
        mViewPager = (ViewPager) ret.findViewById(R.id.homepage_viewpager);

        TabLayout.Tab tab = mTabLayout.newTab();
        tab.setText("推荐");
        mTabLayout.addTab(tab);

        tab=mTabLayout.newTab();
        tab.setText("热门");
        mTabLayout.addTab(tab);

        tab=mTabLayout.newTab();
        tab.setText("分类");
        mTabLayout.addTab(tab);

        tab=mTabLayout.newTab();
        tab.setText("榜单");
        mTabLayout.addTab(tab);

        tab=mTabLayout.newTab();
        tab.setText("主播");
        mTabLayout.addTab(tab);

        List<BaseFragment> fragments=new ArrayList<>();
        fragments.add(new RecommandFragment());
        fragments.add(new HotFragment());
        fragments.add(new ClassifyFragment());
        fragments.add(new TopFragment());
        fragments.add(new AnchorFragment());

        CommonFragmentAdapter adapter=new CommonFragmentAdapter(
                activity.getSupportFragmentManager(),
                fragments
        );
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(mTabLayout)
        );
        mTabLayout.addOnTabSelectedListener(this);


        return ret;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
