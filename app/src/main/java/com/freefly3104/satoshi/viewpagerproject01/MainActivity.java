package com.freefly3104.satoshi.viewpagerproject01;

import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    private static final String TAG = "OnPageChangeListener";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_IDLE:
                        Log.d(TAG, "onPageScrollStateChanged" +
                                " state: SCROLL_STATE_IDLE");
                        Toast.makeText(MainActivity.this, "onPageScrollStateChanged" +
                                " state: SCROLL_STATE_IDLE", Toast.LENGTH_SHORT).show();
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        Log.d(TAG, "onPageScrollStateChanged" +
                                " state: SCROLL_STATE_SETTLING");
                        Toast.makeText(MainActivity.this, "onPageScrollStateChanged" +
                                " state: SCROLL_STATE_SETTLING", Toast.LENGTH_SHORT).show();
                        break;
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        Log.d(TAG, "onPageScrollStateChanged" +
                                " state: SCROLL_STATE_DRAGGING");
                        Toast.makeText(MainActivity.this, "onPageScrollStateChanged" +
                                " state: SCROLL_STATE_DRAGGING", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Log.d(TAG, "onPageScrollStateChanged" +
                                " state: default");
                        Toast.makeText(MainActivity.this, "onPageScrollStateChanged" +
                                " state: default", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            @Override
            public void onPageScrolled(int position,
                                       float positionOffset, int positionOffsetPixels) {
                Log.d(TAG, "onPageScrolled" +
                            " position: " + position +
                            ", positionOffset: " + positionOffset +
                            ", positionOffsetPixels: " + positionOffsetPixels);
            }
            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected" + " position: " + position);
                Toast.makeText(MainActivity.this, "onPageSelected position=" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            // return PlaceholderFragment.newInstance(position + 1);
            switch(position){
                case 0: return new Fragment0();
                case 1: return new Fragment1();
                default: return new Fragment2();
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

}
