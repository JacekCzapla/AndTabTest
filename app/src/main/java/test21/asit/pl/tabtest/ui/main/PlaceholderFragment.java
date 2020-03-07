package test21.asit.pl.tabtest.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;

import org.joda.time.DateTime;

import test21.asit.pl.tabtest.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_SECTION_NAME = "section_name";

    private PageViewModel pageViewModel;

    private String machineName;

    TextView label;

    public static PlaceholderFragment newInstance(int index, String machineName) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        fragment.machineName = machineName;
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        bundle.putString(ARG_SECTION_NAME, machineName);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
            machineName = getArguments().getString(ARG_SECTION_NAME);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tab, container, false);

        label = root.findViewById(R.id.section_label);

//        pageViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        getData();

        return root;
    }

    private void getData() {

        DateTime d = DateTime.now();
        label.setText(machineName+ "\r\n" + String.valueOf(d));// format("hh:mm:ss", d));// +", id:n"+ String.valueOf(machId) + ", nr: "+machNr + ", "+d.toString());
//        soias.clear();
//
//        soias.addAll(res);
//
//        mAdapter.notifyDataSetChanged();
    }
}