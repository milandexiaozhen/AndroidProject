package test.com.adnroidproject;
/**
 * 图片加载，放弃传统的bitmap imageloader加载，，
 * 改用Glide加载，说到glide 类似的有Picasso, 但是Glide扩展性强，，
 * 加载速度快，最主要 内存管理比较合理，比picasso加载消耗内存少，
 * 不过照片质量 稍逊于picasso.  如需加载高质量的 GlideModule 子类，
 * 把 Bitmap 的格式转换到 ARGB_8888：具体详情：http://www.apkbus.com/blog-705730-62880.html
 * **/

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GlideOrPicassoActivity extends BaseActivity {
    @BindView(R.id.iv_Glide)
    ImageView ivGlide;
    @BindView(R.id.iv_Picasso)
    ImageView ivPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);

        Glide.with(this)
                .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
                .into(ivGlide);
        Picasso.with(this)
                .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
                .into(ivPicasso);
    }

}
