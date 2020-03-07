package test21.asit.pl.tabtest;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import test21.asit.pl.tabtest.ui.main.SectionsPagerAdapter;

public class TabActivity extends AppCompatActivity {

    ArrayList<Machine> machines;
    private ViewPager viewPager;
    private TabLayout tabs;
    private Context mContext;
    private SectionsPagerAdapter sectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        mContext = this;

        machines = new ArrayList<Machine>();


        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), machines);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pageSelected(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        loadMachines();

    }

    private void pageSelected(int position) {

        viewPager.getAdapter().notifyDataSetChanged();
        viewPager.setCurrentItem(position);

        TabLayout.Tab tab = tabs.getTabAt(position);
        tab.select();


    }

    private void loadMachines() {

        machines.clear();
        for(int i=0; i< 17; i++){
            machines.add(new Machine("Machine " + String.valueOf(i+1) ));
        }
        sectionsPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadMachines();
    }
}