package common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by gaokun on 2017/11/1.
 */
public class MyView extends View {
    Paint paint=new Paint();//PaintAnti_ALIAS_FLAG抗锯齿
    Path path = new Path();
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
        Shader shader = new RadialGradient(300, 300, 200, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawCircle(300,300,200,paint);//圆
//        canvas.drawPath(path, paint);／



    }

}
