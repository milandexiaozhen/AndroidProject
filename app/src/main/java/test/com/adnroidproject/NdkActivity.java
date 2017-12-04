package test.com.adnroidproject;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ndkutils.JniUtils;

public class NdkActivity extends BaseActivity {

    @BindView(R.id.tv_test)
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndk);
        JniUtils jniUtils=new JniUtils();
        ButterKnife.bind(this);
        tvTest.setText(jniUtils.getStringFromNative());
    }
}
