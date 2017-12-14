package common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by gaokun on 2017/11/1.
 */
public class MyView extends View {
    Paint paint=new Paint();//PaintAnti_ALIAS_FLAG抗锯齿
    Path path = new Path();
    private int mWidth;
    private int mHeight;
    public MyView(Context context,AttributeSet attrs) {
        super(context,attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.rotate(40);//旋转画布


//        paint.setStyle(Paint.Style.FILL);   //填充方式
            // 正方形
//        canvas.drawRect(100, 100, 500, 500, paint);

        //渐变
//        Shader shader = new LinearGradient(100, 100, 500, 500, Color.parseColor("#E91E63"),
//                Color.parseColor("#2196F3"), Shader.TileMode.REPEAT);
//        //TileMode的一些属性，可百度
//        paint.setShader(shader);

        //三角形
//        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(Color.RED);
//        path.moveTo(100, 100);
//        path.lineTo(200, 100);
//        path.lineTo(150, 150);
//        path.close();

//        辐射渐变很好理解，就是从中心向周围辐射状的渐变
//        Shader shader = new RadialGradient(300, 300, 200, Color.parseColor("#E91E63"),
//                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
//        paint.setShader(shader);
//        canvas.drawCircle(300,300,200,paint);//圆
//        canvas.drawPath(path, paint);
//        paint.clearShadowLayer();

        Paint paint=new Paint(); //采用默认设置创建一个画笔

        paint.setAntiAlias(true); //使用抗锯齿功能

        paint.setColor(0xFFA4C739); //设置画笔的颜色为绿色

        //绘制机器人的头

        RectF rectf_head=new RectF(10, 10, 100, 100);

        rectf_head.offset(100, 20);

        canvas.drawArc(rectf_head, -10, -160, false, paint); //绘制弧

        //绘制眼睛

        paint.setColor(Color.WHITE); //设置画笔的颜色为白色

        canvas.drawCircle(135, 53, 4, paint); //绘制圆

        canvas.drawCircle(175, 53, 4, paint); //绘制圆

        paint.setColor(0xFFA4C739); //设置画笔的颜色为绿色

        //绘制天线

        paint.setStrokeWidth(2); //设置笔触的宽度

        canvas.drawLine(120, 15, 135, 35, paint); //绘制线

        canvas.drawLine(190, 15, 175, 35, paint); //绘制线

        //绘制身体

        canvas.drawRect(110, 75, 200, 150, paint); //绘制矩形

        RectF rectf_body=new RectF(110,140,200,160);

        canvas.drawRoundRect(rectf_body, 10, 10, paint); //绘制圆角矩形

        //绘制胳膊

        RectF rectf_arm=new RectF(85,75,105,140);

        canvas.drawRoundRect(rectf_arm, 10, 10, paint); //绘制左侧的胳膊

        rectf_arm.offset(120, 0); //设置在X轴上偏移120像素

        canvas.drawRoundRect(rectf_arm, 10, 10, paint); //绘制右侧的胳膊

        //绘制腿

        RectF rectf_leg=new RectF(125,150,145,200);

        canvas.drawRoundRect(rectf_leg, 10, 10, paint); //绘制左侧的腿

        rectf_leg.offset(40, 0); //设置在X轴上偏移40像素

        canvas.drawRoundRect(rectf_leg, 10, 10, paint); //绘制右侧的腿

        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
    }
}
