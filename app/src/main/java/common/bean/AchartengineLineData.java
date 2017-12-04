package common.bean;

import android.graphics.Color;

import org.achartengine.chart.PointStyle;

import java.util.List;

/**
 * Created by vtg on 2017/5/22.
 */
public class AchartengineLineData {
    private int lineColor = Color.RED;						//默认黑色
    private PointStyle linePointStyle = PointStyle.CIRCLE;		//默认圆心
    private Boolean fillpoint = true;							//默认实心
    //	private double[] yValues;									//y坐标数据
//	private double[] xValues;									//x轴坐标
    private String xTitle;										//x轴名称
    private String lineName;									//线名称
    private List<AchartengineDotsData> dots;					//点集合





    public int getLineColor() {
        return lineColor;
    }
    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
    }
    public PointStyle getLinePointStyle() {
        return linePointStyle;
    }
    public void setLinePointStyle(PointStyle linePointStyle) {
        this.linePointStyle = linePointStyle;
    }
    public Boolean getFillpoint() {
        return fillpoint;
    }
    public void setFillpoint(Boolean fillpoint) {
        this.fillpoint = fillpoint;
    }

    public String getxTitle() {
        return xTitle;
    }
    public void setxTitle(String xTitle) {
        this.xTitle = xTitle;
    }
    //	public double[] getyValues() {
//		return yValues;
//	}
//	public void setyValues(double[] yValues) {
//		this.yValues = yValues;
//	}
//	public double[] getxValues() {
//		return xValues;
//	}
//	public void setxValues(double[] xValues) {
//		this.xValues = xValues;
//	}
    public String getLineName() {
        return lineName;
    }
    public void setLineName(String lineName) {
        this.lineName = lineName;
    }
    public List<AchartengineDotsData> getDots() {
        return dots;
    }
    public void setDots(List<AchartengineDotsData> dots) {
        this.dots = dots;
    }


}
