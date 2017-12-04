package common.bean;

/**
 * Created by vtg on 2017/5/22.
 */
public class AchartengineDotsData {
    private double x;				//x轴数据
    private double y;				//y轴数据
    private String xTitle;			//x轴对应的名称
    //	private String yTitle;			//y轴对应的名称
    private String dotsName;		//点名称


    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public String getxTitle() {
        return xTitle;
    }
    public void setxTitle(String xTitle) {
        this.xTitle = xTitle;
    }
    //	public String getyTitle() {
//		return yTitle;
//	}
//	public void setyTitle(String yTitle) {
//		this.yTitle = yTitle;
//	}
    public String getDotsName() {
        return dotsName;
    }
    public void setDotsName(String dotsName) {
        this.dotsName = dotsName;
    }

}
