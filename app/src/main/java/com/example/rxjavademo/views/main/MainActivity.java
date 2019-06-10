package com.example.rxjavademo.views.main;

import android.os.Bundle;
import androidx.fragment.app.FragmentStatePagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.rxjavademo.R;
import com.example.rxjavademo.views.dashboard.DashBoardFragment;
import com.example.rxjavademo.views.food.FoodFragment;
import com.example.rxjavademo.views.news.NewsFragment;
import com.example.rxjavademo.views.order.OrderFragment;
import com.example.rxjavademo.views.store.StoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.nav_view)
    BottomNavigationView mBottomNavigationView;
    @BindView(R.id.mainViewPager)
    MainParentViewsPager mViewPager;

    private NewsFragment mNewsFragment;
    private DashBoardFragment mDashBoardFragment;
    private OrderFragment mOrderFragment;
    private StoreFragment mStoreFragment;
    private FoodFragment mFoodFragment;

    private MainParentViewsAdapter mMainParentViewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mMainParentViewsAdapter = new MainParentViewsAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        initUI();
    }

    private void initUI() {

        int quantityFragments = 5;
        mViewPager.setOffscreenPageLimit(quantityFragments);
        mViewPager.setPagingEnabled(false);

        createFragments();

        addFragmentsToMain();

        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void createFragments() {

        mNewsFragment = new NewsFragment();
        mDashBoardFragment = new DashBoardFragment();
        mOrderFragment = new OrderFragment();
        mStoreFragment = new StoreFragment();
        mFoodFragment = new FoodFragment();
    }

    private void addFragmentsToMain() {

        mMainParentViewsAdapter.addFragment(mNewsFragment);
        mMainParentViewsAdapter.addFragment(mDashBoardFragment);
        mMainParentViewsAdapter.addFragment(mOrderFragment);
        mMainParentViewsAdapter.addFragment(mStoreFragment);
        mMainParentViewsAdapter.addFragment(mFoodFragment);
        mViewPager.setAdapter(mMainParentViewsAdapter);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        int positionFragment;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                positionFragment = 0;
                setCurrentItem(positionFragment);
                return true;
            case R.id.navigation_dashboard:
                positionFragment = 1;
                setCurrentItem(positionFragment);
                return true;
            case R.id.navigation_notifications:
                positionFragment = 2;
                setCurrentItem(positionFragment);
                return true;
            case R.id.navigation_order:
                positionFragment = 3;
                setCurrentItem(positionFragment);
                return true;
            case R.id.navigation_food:
                positionFragment = 4;
                setCurrentItem(positionFragment);
                return true;
        }
        return false;
    };

    private void setCurrentItem(int position) {
        mViewPager.setCurrentItem(position);
    }
}
