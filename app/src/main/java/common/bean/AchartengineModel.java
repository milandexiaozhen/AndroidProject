package common.bean;

import android.graphics.Color;

import java.util.List;

/**
 * Created by vtg on 2017/5/22.
 */
public class AchartengineModel {
    private String title;		//图表的名称
    private String xTitle;		//x轴名称
    private String yTitle;		//y轴名称
    private Boolean mBoolean = false;	//判断是否是比率
    private Double xMin	=	0.5;		//X轴最小值
    private Double xMax =	6.0;		//X轴最大值			5.5-0.5 =5
    private Double yMin =	0.0;		//Y轴最小值
    private Double yMax = 	100.0;		//Y轴最大值
    private int xColor = Color.LTGRAY;			//X轴颜色
    private int yColor = Color.LTGRAY;			//Y轴颜色

    private List<AchartengineLineData> lines;			//多条线
    private int BackgroundColor = test.com.adnroidproject.R.color.analysis_pic_bg;			//背景色



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBackgroundColor() {
        return BackgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        BackgroundColor = backgroundColor;
    }

    public String getxTitle() {
        return xTitle;
    }

    public void setxTitle(String xTitle) {
        this.xTitle = xTitle;
    }

    public String getyTitle() {
        return yTitle;
    }

    public void setyTitle(String yTitle) {
        this.yTitle = yTitle;
    }

    public Double getxMin() {
        return xMin;
    }

    public void setxMin(Double xMin) {
        this.xMin = xMin;
    }

    public Double getxMax() {
        return xMax;
    }

    public void setxMax(Double xMax) {
        this.xMax = xMax;
    }

    public Double getyMin() {
        return yMin;
    }

    public void setyMin(Double yMin) {
        this.yMin = yMin;
    }

    public Double getyMax() {
        return yMax;
    }

    public void setyMax(Double yMax) {
        this.yMax = yMax;
    }

    public int getxColor() {
        return xColor;
    }

    public void setxColor(int xColor) {
        this.xColor = xColor;
    }

    public int getyColor() {
        return yColor;
    }

    public void setyColor(int yColor) {
        this.yColor = yColor;
    }

    public List<AchartengineLineData> getLines() {
        return lines;
    }

    public void setLines(List<AchartengineLineData> lines) {
        this.lines = lines;
    }

    public Boolean getmBoolean() {
        return mBoolean;
    }

    public void setmBoolean(Boolean mBoolean) {
        this.mBoolean = mBoolean;
    }
}
