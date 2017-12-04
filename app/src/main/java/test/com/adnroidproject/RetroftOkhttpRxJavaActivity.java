package test.com.adnroidproject;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit.bean.MenuBean;
import retrofit.bean.Verification;
import retrofit.network.NetWorks;
import rx.Observer;

public class RetroftOkhttpRxJavaActivity extends BaseActivity {
    @BindView(R.id.tv_PostData)
    TextView tvPostData;
    @BindView(R.id.tv_GetData)
    TextView tvGetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        NetWorks net=new NetWorks(RetroftOkhttpRxJavaActivity.this);
        NetWorks.verfacationCodePost("2", "112", new Observer<Verification>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                tvPostData.setText(e.getLocalizedMessage());
                Log.e("MAIN2", e.getLocalizedMessage() + "--" + e.getMessage());
            }

            @Override
            public void onNext(Verification verification) {
                tvPostData.setText(verification.getData().get(0).getDescription());
            }
        });


        NetWorks.Getcache(new Observer<MenuBean>() {
            @Override
            public void onCompleted() {
                //完成
            }

            @Override
            public void onError(Throwable e) {
                //异常
                tvGetData.setText(e.getLocalizedMessage());
                Log.e("MAIN2", e.getLocalizedMessage() + "--" + e.getMessage());
            }

            @Override
            public void onNext(MenuBean baseBean) {
                //成功
                tvGetData.setText(baseBean.getData().getCategoryNo1().get(0).getName() + "=======" + baseBean.getData().getCategoryNo2().get(0).getName());
            }
        });
    }
}