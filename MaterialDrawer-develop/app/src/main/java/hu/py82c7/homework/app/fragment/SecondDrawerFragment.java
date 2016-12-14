package hu.py82c7.homework.app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import hu.py82c7.homework.Drawer;
import hu.py82c7.homework.DrawerBuilder;


/**
 * A simple {@link Fragment} subclass.
 * This is just a demo fragment with a long scrollable view of editTexts. Don't see this as a reference for anything
 */
public class SecondDrawerFragment extends Fragment {
    private static final String KEY_TITLE = "title";

    private Drawer result;

    public SecondDrawerFragment() {
        // Required empty public constructor
    }

    public static SecondDrawerFragment newInstance(String title) {
        SecondDrawerFragment f = new SecondDrawerFragment();

        Bundle args = new Bundle();

        args.putString(KEY_TITLE, title);
        f.setArguments(args);

        return (f);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // don't look at this layout it's just a listView to show how to handle the keyboard
        View view = inflater.inflate(hu.py82c7.homework.app.R.layout.fragment_simple_sample, container, false);

        result = new DrawerBuilder()
                .withActivity(getActivity())
                .withRootView((ViewGroup) view.findViewById(hu.py82c7.homework.app.R.id.rootView))
                .withDisplayBelowStatusBar(false)
                .withSavedInstance(savedInstanceState)
                .buildForFragment();

        TextView textView = (TextView) view.findViewById(hu.py82c7.homework.app.R.id.title);
        textView.setText(getArguments().getString(KEY_TITLE));

        result.getDrawerLayout().setFitsSystemWindows(false);
        result.getSlider().setFitsSystemWindows(false);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }
}
