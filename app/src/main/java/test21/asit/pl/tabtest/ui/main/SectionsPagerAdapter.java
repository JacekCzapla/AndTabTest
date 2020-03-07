package test21.asit.pl.tabtest.ui.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;

import test21.asit.pl.tabtest.Machine;
import test21.asit.pl.tabtest.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    //@StringRes
    //private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};

    private final Context mContext;
    private ArrayList<Machine> machines;

    public SectionsPagerAdapter(Context context, FragmentManager fm, ArrayList<Machine> machines) {
        super(fm);
        mContext = context;
        if(machines == null)
            this.machines = new ArrayList<Machine>();
        else
            this.machines = machines;
    }

    @Override
    public Fragment getItem(int position) {

        Machine m = machines.get(position);
        PlaceholderFragment fr = PlaceholderFragment.newInstance(position, m.Name);
        return fr;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return  machines.get(position).Name;

    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return machines.size();
    }

    @Override
    public int getItemPosition(Object object){

        return PagerAdapter.POSITION_NONE;
    }
}