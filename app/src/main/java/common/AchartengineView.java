package common;

import android.content.Context;
import android.graphics.Paint.Align;
import android.view.WindowManager;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.util.List;

import common.bean.AchartengineDotsData;
import common.bean.AchartengineLineData;
import common.bean.AchartengineModel;
import test.com.adnroidproject.R;
/**
 * Created by vtg on 2017/5/22.
 */
public class AchartengineView {
    private static int POSITION = 7;
    private static int LINESIZE = 2;

    public static GraphicalView DisPlayView(Context context,AchartengineModel mAchartengineModel,boolean displayValues){
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        renderer.setAxisTitleTextSize(16);//设置轴标题文字的大小
        renderer.setChartTitleTextSize(40);//设置整个图表标题文字的大小	40

        //获取屏幕信息		小屏手机字体变小一点
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        if(width <=480){
            renderer.setLabelsTextSize(10);
        }else{
            renderer.setLabelsTextSize(15);//设置轴刻度文字的大小
        }
        renderer.setLegendTextSize(15);///设置图例文字大小
        renderer.setPointSize(5f);//设置点的大小(图上显示的点的大小和图例中点的大小都会被设置)
        renderer.setMargins(new int[] { 20, 40, 20, 20 });//设置图表的外边框(上/左/下/右)	{ 20, 30, 15, 20 }
        renderer.setXLabels(0);//设置x轴显示12个点,根据setChartSettings的最大值和最小值自动计算点的间隔
        renderer.setYLabels(7);//设置y轴显示10个点,根据setChartSettings的最大值和最小值自动计算点的间隔
        renderer.setShowGrid(true);//是否显示网格
        renderer.setXLabelsPadding(150);			//设置底部标签的距离
//        renderer.setXLabelsAngle(-45f);		//设置倾斜度
        renderer.setXLabelsColor(context.getResources().getColor(R.color.analysis_name));			//设置X轴的字体颜色
        renderer.setAxesColor(context.getResources().getColor(R.color.analysis_rank));				//设置轴线的颜色
        renderer.setYLabelsColor(0, context.getResources().getColor(R.color.analysis_name));
        renderer.setPanEnabled(false, false);//设置滑动,这边是横向可以滑动,竖向不可滑动
        renderer.setZoomEnabled(false,false);		//不能缩放

        if(mAchartengineModel.getmBoolean()){
            renderer.setYLabelsPadding(30f);
//        	renderer.setYLabels(0);
            int count2 = renderer.getYLabels();
            for (int m = 0; m < count2; m++) {
                if(m >0)
                    renderer.addYTextLabel(m*20, m*20+"%");
                else
                    renderer.addYTextLabel(m*20, m*20+"");

            }
        }
        renderer.setExternalZoomEnabled(false);			//设置是否可以缩放
//        renderer.setPanEnabled(true, false);//设置滑动,这边是横向可以滑动,竖向不可滑动
//        renderer.setXLabelsAlign(Align.CENTER);//刻度线与刻度标注之间的相对位置关系
        renderer.setYLabelsAlign(Align.RIGHT);	//刻度线与刻度标注之间的相对位置关系
//        renderer.setZoomButtonsVisible(true);//是否显示放大缩小按钮
        renderer.setFitLegend(true);			// 调整合适的位置
        renderer.setChartTitle(mAchartengineModel.getTitle());
        renderer.setXTitle(mAchartengineModel.getxTitle());
        renderer.setXLabelsAlign(Align.CENTER);
        renderer.setYTitle(mAchartengineModel.getyTitle());
        renderer.setXAxisMin(mAchartengineModel.getxMin());
        renderer.setXAxisMax(mAchartengineModel.getxMax());
        if(mAchartengineModel.getyMin() > mAchartengineModel.getyMax()){
            renderer.setYAxisMin(mAchartengineModel.getyMin());
            renderer.setYAxisMax(mAchartengineModel.getyMax()-mAchartengineModel.getyMin()/6);
        }else{
            renderer.setYAxisMin(mAchartengineModel.getyMin());
            renderer.setYAxisMax(mAchartengineModel.getyMax()+mAchartengineModel.getyMax()/6);
        }

        renderer.setAxesColor(mAchartengineModel.getxColor());
        renderer.setLabelsColor(mAchartengineModel.getxColor());			//getyColor
        //设置图表背景色
        renderer.setApplyBackgroundColor(true);
        renderer.setBackgroundColor(mAchartengineModel.getBackgroundColor());
        renderer.setMarginsColor(mAchartengineModel.getBackgroundColor());	//周边的颜色
        //数据交接
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        List<AchartengineLineData> lineList = mAchartengineModel.getLines();
        int lineSize = lineList.size();
        for (int i = 0; i < lineList.size(); i++) {
            XYSeriesRenderer r = new XYSeriesRenderer();
            r.setColor(lineList.get(i).getLineColor());//设置颜色
            r.setPointStyle(lineList.get(i).getLinePointStyle());
            if(displayValues && lineSize < LINESIZE){
                r.setDisplayChartValues(true);				//将点的值显示出来
//			      r.setChartValuesTextAlign(Align.RIGHT);
                r.setDisplayChartValuesDistance(25);
//			      if(mAchartengineModel.getyMin() > mAchartengineModel.getyMax()){
//			    	  r.setChartValuesSpacing(-30);//显示的点的值与图的距离
//			      }else{
                r.setChartValuesSpacing(12);
//			      }
                r.setChartValuesTextSize(20);//点的值的文字大小
            }
            renderer.addSeriesRenderer(r);
//		      renderer.setDisplayValues(true);
            //设置实心点
            int length = renderer.getSeriesRendererCount();
            for (int j = 0; j < length; j++) {
                ((XYSeriesRenderer) renderer.getSeriesRendererAt(j)).setFillPoints(true);//设置图上的点为实心
            }
            XYSeries series = new XYSeries(lineList.get(i).getLineName(), 0); //这里注意与TimeSeries区别
            List<AchartengineDotsData> mDots = lineList.get(i).getDots();
//		      int m = 0;
            for(int k =0; k<mDots.size(); k++){
                String mTitle = mDots.get(k).getxTitle();
                String mSubString = getSubString(mTitle, POSITION, "/n");
                renderer.addTextLabel(k+1, mSubString);
                if(mDots.get(k).getY() >= 0 ){	//去点
                    series.add(mDots.get(k).getX(), mDots.get(k).getY());
//		    		  m++;
                }
//		    	  if(m <2 && (k ==(mDots.size()-1))){
//		    		  series.add(mDots.get(k).getX(), 0);
//		    	  }
            }
            dataset.addSeries(series);
        }
//		if(mAchartengineModel.getmBoolean()){
//			setYAxisValues(dataset, renderer);
//		}
        GraphicalView mView = ChartFactory.getLineChartView(context, dataset, renderer);

        return mView;




    }


    private static void setYAxisValues(XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        renderer.setPanEnabled(false, false);//设置滑动,这边是横向可以滑动,竖向不可滑动
        renderer.setYLabels(0);

        int count = renderer.getYLabels();
//        int count = renderer.getScalesCount();
        for (int m = 0; m < count; m++) {
            renderer.addYTextLabel(m*20, m*20+"%");

        }
//		Double maxd = 0.0d;
//		for (int i = 0; i < dataset.getSeriesCount(); i++) {
//			if (dataset.getSeriesAt(i).getMaxY() > maxd) {
//				maxd = dataset.getSeriesAt(i).getMaxY();
//			}
//		}
////		DecimalFormat formatter = new DecimalFormat(".00");
//		for (double i = 0; i < maxd; i = i + (maxd / 3)) {
//			renderer.addYTextLabel(i, i+"%");
//		}
//		renderer.addYTextLabel(maxd * 0.99, maxd * 0.99+"%");
    }




    public static GraphicalView DisPlayViewBarChart(Context context,AchartengineModel mAchartengineModel) {
        XYMultipleSeriesRenderer renderer = buildBarRenderer();//调用AbstractDemoChart中的方法构建renderer.
        setChartSettings(renderer, mAchartengineModel);//调用AbstractDemoChart中的方法设置renderer的一些属性.
        renderer.setXLabels(0);//X轴的近似坐标数
        renderer.setYLabels(5);//Y轴的近似坐标数
        renderer.setXLabelsAlign(Align.CENTER);//刻度线与X轴坐标文字左侧对齐
        renderer.setYLabelsAlign(Align.LEFT);//Y轴与Y轴坐标文字左对齐
        renderer.setPanEnabled(false, false);//允许左右拖动,但不允许上下拖动.
        // renderer.setZoomEnabled(false);
        renderer.setZoomRate(1f);//放大的倍率
        renderer.setBarSpacing(0.5f);//柱子间宽度
        renderer.setYLabelsPadding(5);
        renderer.setXLabelsPadding(50);			//设置底部标签的距离


        //设置图表背景色
        renderer.setApplyBackgroundColor(true);
        renderer.setBackgroundColor(mAchartengineModel.getBackgroundColor());
        renderer.setMarginsColor(mAchartengineModel.getBackgroundColor());	//周边的颜色
        renderer.setYLabelsAlign(Align.RIGHT);

        renderer.setXLabelsColor(context.getResources().getColor(R.color.analysis_name));			//设置X轴的字体颜色
        renderer.setAxesColor(context.getResources().getColor(R.color.analysis_rank));				//设置轴线的颜色
        renderer.setYLabelsColor(0, context.getResources().getColor(R.color.analysis_name));

        //数据交接
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        List<AchartengineLineData> lineList = mAchartengineModel.getLines();
        for (int i = 0; i < lineList.size(); i++) {

            XYSeriesRenderer r = new XYSeriesRenderer();
            r.setColor(lineList.get(i).getLineColor());//设置颜色
            r.setPointStyle(lineList.get(i).getLinePointStyle());
            renderer.addSeriesRenderer(r);
            CategorySeries series = new CategorySeries(lineList.get(i).getLineName()); //这里注意与TimeSeries区别
            List<AchartengineDotsData> mDots = lineList.get(i).getDots();
            for(int k =0; k<mDots.size(); k++){
                String mTitle = mDots.get(k).getxTitle();
                String mSubString = getSubString(mTitle, POSITION, "/n");
                renderer.addTextLabel(k+1, mSubString);
                series.add(mDots.get(k).getY());
            }

            dataset.addSeries(series.toXYSeries());
            renderer.getSeriesRendererAt(i).setDisplayChartValues(true);
        }
        return  ChartFactory.getBarChartView(context, dataset, renderer, Type.STACKED);
    }


    /**
     * 构建XYMultipleSeriesRenderer,适用于柱状图.
     *
     * //@param colors 每个序列的颜色
     * @return XYMultipleSeriesRenderer
     */
    protected static XYMultipleSeriesRenderer buildBarRenderer() {
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        renderer.setAxisTitleTextSize(16);
        renderer.setChartTitleTextSize(40);
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(15);
        return renderer;
    }




    /**
     * 设置renderer的一些属性.
     *
     * @param renderer 要设置的renderer
//     * @param title 图表标题
//     * @param xTitle X轴标题
//     * @param yTitle Y轴标题
//     * @param xMin X轴最小值
//     * @param xMax X轴最大值
//     * @param yMin Y轴最小值
//     * @param yMax Y轴最大值
//     * @param axesColor X轴颜色
//     * @param labelsColor Y轴颜色
     */
    protected static void setChartSettings(XYMultipleSeriesRenderer renderer, AchartengineModel mAchartengineModel) {
        renderer.setChartTitle(mAchartengineModel.getTitle());
        renderer.setXTitle(mAchartengineModel.getxTitle());
        renderer.setYTitle(mAchartengineModel.getyTitle());
        renderer.setXAxisMin(mAchartengineModel.getxMin());
        renderer.setXAxisMax(mAchartengineModel.getxMax());
        renderer.setYAxisMin(mAchartengineModel.getyMin());
        renderer.setYAxisMax(mAchartengineModel.getyMax());
        renderer.setAxesColor(mAchartengineModel.getxColor());
        renderer.setLabelsColor(mAchartengineModel.getyColor());
    }



    /**
     * 在字符串的任意位置插入字符
     * @param mString
     * @return
     */
    private static String getSubString(String mString,int position, String mark){

        if(mString.length() >20){
            mString = mString.substring(0, 20);
        }


        if(mString.length() >POSITION){
            StringBuffer newString = new StringBuffer();
            char[] mArray = mString.toCharArray();
            for (int m = 0; m < mArray.length; m++) {
                if(m !=0){
                    if((m+1)%position == 0){
                        newString.append("\n");
                    }
                }
                newString.append(mArray[m]);
            }


//			 String newString = mString.substring(0, position) + mark + mString.substring(position, mString.length());
            return newString.toString();
        }else{
            return mString;
        }
    }
}
