package org.daidai.abstrusewriting;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioGroup;

import org.daidai.abstrusewriting.fragments.DiscoverFragment;
import org.daidai.abstrusewriting.fragments.HomePageFragment;
import org.daidai.abstrusewriting.fragments.PersonalFragment;
import org.daidai.abstrusewriting.fragments.SubscriptionFragment;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private Fragment mHomePageFragment;
    private Fragment mSubscriptionFragment;
    private Fragment mDiscoverFragment;
    private Fragment mPersonalFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        translucentStatusBar();


        RadioGroup radioGroup= (RadioGroup) findViewById(R.id.main_tab_bar);
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(this);
        }

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag("homepage");

        if (fragment != null) {
            mHomePageFragment = (HomePageFragment)fragment;
        }else{
            mHomePageFragment=new HomePageFragment();
        }

        fragment = manager.findFragmentByTag("subscription");
        if (fragment != null) {
            mSubscriptionFragment = (SubscriptionFragment)fragment;
        }else{
            mSubscriptionFragment=new SubscriptionFragment();
        }

        fragment=manager.findFragmentByTag("discover");
        if (fragment != null) {
            mDiscoverFragment = (DiscoverFragment)fragment;
        }else{
            mDiscoverFragment=new DiscoverFragment();
        }


        fragment=manager.findFragmentByTag("personal");
        if (fragment != null) {
            mPersonalFragment = (PersonalFragment)fragment;
        }else{
            mPersonalFragment=new PersonalFragment();
        }

        radioGroup.check(R.id.main_tab_item_homepage);

    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tx = manager.beginTransaction();
        switch (checkedId) {
            case R.id.main_tab_item_homepage:
                tx.replace(R.id.main_fragmet_container,mHomePageFragment,"homepage");
                break;
            case R.id.main_tab_item_subscription:
                tx.replace(R.id.main_fragmet_container,mSubscriptionFragment,"subscription");

                break;
            case R.id.main_tab_item_discover:
                tx.replace(R.id.main_fragmet_container,mDiscoverFragment,"discover");

            case R.id.main_tab_item_personal:
                tx.replace(R.id.main_fragmet_container,mPersonalFragment,"personal");
                break;
        }

        tx.commit();
    }




    /**
     * 手机状态栏透明化:代码实现（还可以在style中设置）
     *
     *
     */
    private void translucentStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }
}
