package test.com.adnroidproject;

import android.os.Bundle;
import android.util.Log;

import common.RxBus;
import common.bean.UserInfo;
import retrofit.bean.Verification;
import retrofit.network.NetWorks;
import rx.Observer;

public class RxBusActivity extends BaseActivity {
    UserInfo user=new UserInfo();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_bus);
        NetWorks net=new NetWorks(RxBusActivity.this);
        NetWorks.verfacationCodePost("2", "112", new Observer<Verification>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("MAIN2", e.getLocalizedMessage() + "--" + e.getMessage());
            }

            @Override
            public void onNext(Verification verification) {
                user.setUserName(verification.getData().get(0).getDescription());
                RxBus.getDefault().post(user);
            }
        });



    }

}
