package test.com.adnroidproject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import org.achartengine.GraphicalView;

import java.util.ArrayList;
import java.util.List;

import common.AchartengineView;
import common.bean.AchartengineDotsData;
import common.bean.AchartengineLineData;
import common.bean.AchartengineModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AchartengineActivity extends BaseActivity {

    @BindView(R.id.analysis_pic)
    ViewPager analysisPic;
    protected ArrayList<GraphicalView>mGraphicalView = new ArrayList<GraphicalView>();
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achartengine);
        mContext=AchartengineActivity.this;
        ButterKnife.bind(this);
        GraphicalView vScroeView  = AchartengineView.DisPlayView(mContext, getData(), true);
        vScroeView.setTag(String.format(getResources().getString(R.string.analysis_student_scroe), "a"));
        mGraphicalView.add(vScroeView);

        analysisPic.setAdapter(new AchartengineAdapter());

    }


    private class AchartengineAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mGraphicalView.size();
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            if(arg1 == 0){
            }

            ((ViewPager) arg0).addView(mGraphicalView.get(arg1));

            return mGraphicalView.get(arg1);
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {

        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {

        }

        @Override
        public void finishUpdate(View arg0) {

        }
    }

    private AchartengineModel getData(){
        AchartengineModel mAchartengineMod=new AchartengineModel();
        mAchartengineMod.setBackgroundColor(getResources().getColor(R.color.analysis_pic_bg));
        mAchartengineMod.setyMax(50.0);
        mAchartengineMod.setyMin(0.0);
        List<AchartengineLineData> values = new ArrayList<AchartengineLineData>();
        AchartengineLineData mAchartengineLineData = new AchartengineLineData();
        mAchartengineLineData.setFillpoint(true);
        List<AchartengineDotsData> valueDots = new ArrayList<AchartengineDotsData>();
        for(int i=0;i<10;i++){
            AchartengineDotsData mAchartengineDotsData =new AchartengineDotsData();
            mAchartengineDotsData.setX(i+1);
            mAchartengineDotsData.setY(i + 15);
            mAchartengineDotsData.setxTitle(String.valueOf(i));
            valueDots.add(mAchartengineDotsData);
        }
        mAchartengineLineData.setDots(valueDots);
        mAchartengineLineData.setLineColor(AchartengineActivity.this.getResources().getColor(R.color.analysis_color_avg));
        mAchartengineLineData.setLineName("");
        values.add(mAchartengineLineData);
        mAchartengineMod.setLines(values);
        values.add(mAchartengineLineData);
        return mAchartengineMod;
    }

}
