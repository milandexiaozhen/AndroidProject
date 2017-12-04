package test.com.adnroidproject;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class SateLLiteMenuActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
//        ButterKnife.bind(this)
        ViewPager vp = (ViewPager) findViewById(R.id.main_vp);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.main_tab_layout);
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            list.add(String.valueOf(i));
        }

        vp.setAdapter(new MyAdapter(getSupportFragmentManager(), list));
        tabLayout.setupWithViewPager(vp);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
//                Log.e("pageselect", String.valueOf(position));

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }
    public class MyAdapter extends FragmentPagerAdapter {
        private List<String> list;

        public MyAdapter(FragmentManager fm, List<String> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return BlankFragment.newInstance(list.get(position));
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return list.get(position);
        }
    }


}
