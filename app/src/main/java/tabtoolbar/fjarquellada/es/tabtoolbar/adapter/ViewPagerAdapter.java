package tabtoolbar.fjarquellada.es.tabtoolbar.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import tabtoolbar.fjarquellada.es.tabtoolbar.fragment.FormFragment;
import tabtoolbar.fjarquellada.es.tabtoolbar.fragment.ListFragment;

import static tabtoolbar.fjarquellada.es.tabtoolbar.activity.MainActivity.PERSON_FORM_FRAGMENT;
import static tabtoolbar.fjarquellada.es.tabtoolbar.activity.MainActivity.PERSON_LIST_FRAGMENT;

/**
 * Created by francisco on 31/3/18.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private int numberOfTabs;


    public ViewPagerAdapter(FragmentManager fm, Context context, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case PERSON_FORM_FRAGMENT:
                return new FormFragment();
            case PERSON_LIST_FRAGMENT:
                return new ListFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
