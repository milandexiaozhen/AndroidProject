package test.com.adnroidproject;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import api.GroupClass;
import api.GroupListener;
import api.IGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import common.ACache;
import common.RxBus;
import common.bean.UserInfo;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {
    @BindView(R.id.btn_rxjavaRetroft)
    Button btnRxjavaRetroft;
    @BindView(R.id.btn_aSimpleCache)
    Button btnASimpleCache;
    @BindView(R.id.tv_aSimpleCache)
    TextView tvASimpleCache;
    @BindView(R.id.btn_AChart)
    Button btnAChart;
    @BindView(R.id.btn_Ndk)
    Button btnNdk;
    @BindView(R.id.btn_vitamio)
    Button btnVitamio;
    @BindView(R.id.btn_LitePal)
    Button btnLitePal;
    @BindView(R.id.btn_Glide)
    Button btnGlide;
    @BindView(R.id.btn_RxBus)
    Button btnRxBus;
    @BindView(R.id.btnSateLLiteMenu)
    Button btnSateLLiteMenu;
    @BindView(R.id.btnBlur)
    Button btnBlur;
    private ACache aCache;
    private Subscription rxSubscription;
    private LocalBroadcastManager lbm;
    private LocalBroadReveiver reveiver;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        aCache = ACache.get(this);
        aCache.put("test", "aaa");//可设置缓存时间，有效的解决token失效的问题
        rxSubscription= RxBus.getDefault().tObservable(UserInfo.class)
                //在io线程进行订阅，可以执行一些耗时操作
                .subscribeOn(Schedulers.io())
                        //在主线程进行观察，可做UI更新操作
                .observeOn(AndroidSchedulers.mainThread())
                        //观察的对象
                .subscribe(new Action1<UserInfo>() {
                    @Override
                    public void call(UserInfo user) {
                        btnRxBus.setText(user.getUserName());
                        Toast.makeText(MainActivity.this, user.getUserName(), Toast.LENGTH_SHORT).show();
                    }

                });

    }

    @OnClick({R.id.btn_rxjavaRetroft, R.id.btn_aSimpleCache, R.id.btn_AChart, R.id.btn_mpAndroidChart, R.id.btn_Ndk,
            R.id.btn_vitamio,R.id.btn_LitePal,R.id.btn_Glide,R.id.btn_RxBus,R.id.btnSateLLiteMenu,R.id.btnBlur})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_rxjavaRetroft:
                startActivity(new Intent(this, RetroftOkhttpRxJavaActivity.class));
                //顺便试试本地广播
                lbm= LocalBroadcastManager.getInstance(this);
                reveiver=new LocalBroadReveiver();
                IntentFilter intentFilter=new IntentFilter();
                intentFilter.addAction("test.com.broadcast");
                lbm.registerReceiver(reveiver,intentFilter);

                break;
            case R.id.btn_aSimpleCache:
                tvASimpleCache.setText(aCache.getAsString("test"));
                break;
            case R.id.btn_AChart:
                startActivity(new Intent(this, AchartengineActivity.class));
                break;
            case R.id.btn_mpAndroidChart:
                startActivity(new Intent(this, MpAndroidChartActivity.class));
                break;
            case R.id.btn_Ndk:
//                startActivity(new Intent(this, NdkActivity.class));
                IGroup group=new GroupClass();
                group.setGroupListener(new GroupListener() {
                    @Override
                    public void onQuitGrouped(String accout, boolean succeed) {
                        if(succeed==true){

                            Log.e("test", accout);
                        }

                    }
                });
                group.quitGroup("590877");

                break;

            case R.id.btn_vitamio:
                startActivity(new Intent(this, VitamioActivity.class));
                break;
            case R.id.btn_LitePal:
                startActivity(new Intent(this,LitePalActivity.class));
                break;
            case R.id.btn_Glide:
                startActivity(new Intent(this,GlideOrPicassoActivity.class));
                break;
            case R.id.btn_RxBus:
                startActivity(new Intent(this, RxBusActivity.class));
                break;
            case R.id.btnSateLLiteMenu:
                startActivity(new Intent(this,SateLLiteMenuActivity.class));
                break;
            case R.id.btnBlur:
                startActivity(new Intent(this,BlurActivity.class));
        }
    }

    public class  LocalBroadReveiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,intent.getStringExtra("lbm"),Toast.LENGTH_LONG).show();

        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if(!rxSubscription.isUnsubscribed()) {
            rxSubscription.unsubscribe();
        }
        lbm.unregisterReceiver(reveiver);
    }


}
