package test.com.adnroidproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import common.MyView;
import common.WaveView;

/**
 * Created by gaokun on 2017/11/1.
 */
    public class BlankFragment extends Fragment {
    private WaveView waveView;

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(String text) {

        Bundle args = new Bundle();
        args.putString("text", text);
        BlankFragment fragment = new BlankFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView text = (TextView) view.findViewById(R.id.fg_text);

        String str = getArguments().getString("text");
        text.setText(str);
        waveView = (WaveView) view.findViewById(R.id.waveView);
        MyView myView= (MyView) view.findViewById(R.id.myView);
        if(str.equals("1")){

            waveView.setVisibility(View.VISIBLE);
            waveView.startAnimation();
        }
        else  if(str.equals("2")){
        myView.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(waveView!=null) {
            waveView.stopAnimation();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(waveView!=null) {
            waveView.pauseAnimation();
        }
    }
}