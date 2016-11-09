package com.example.cjeon.interactionandengagement.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cjeon.interactionandengagement.R;

import java.util.Random;

public class SwipeViewFragment extends Fragment {
    public static final String ARG_OBJECT = "object";
    private static final int[] COLORS = {
            R.color.AliceBlue, R.color.AntiqueWhite, R.color.Aqua, R.color.Beige,
            R.color.BlanchedAlmond, R.color.YellowGreen, R.color.Wheat,
            R.color.Tan, R.color.Teal, R.color.IndianRed, R.color.LightSkyBlue
    };

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_swipe_view, container, false);
        Bundle args = getArguments();
        int color = COLORS[new Random().nextInt(COLORS.length)];
        rootView.setBackgroundColor(ContextCompat.getColor(getContext(), color));
        ((TextView) rootView.findViewById(R.id.textView1)).setText(Integer.toString(args.getInt(ARG_OBJECT)));
        ((TextView) rootView.findViewById(R.id.textView2)).setText(Integer.toString(args.getInt(ARG_OBJECT)));
        return rootView;
    }

}