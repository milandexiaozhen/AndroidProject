package retrofit.network;


import android.content.Context;

import com.dhh.rxlifecycle.ActivityEvent;
import com.dhh.rxlifecycle.RxLifecycle;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import retrofit.bean.MenuBean;
import retrofit.bean.Verification;
import retrofit.utils.RetrofitUtils;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 类名称：NetWorks
 * 创建人：wangliteng
 * 创建时间：2016-5-18 14:57:11
 * 类描述：网络请求的操作类
 */
public class NetWorks extends RetrofitUtils {

    protected static final NetService service = getRetrofit().create(NetService.class);
    private  static  Context mContext;

    public  NetWorks(Context mContext){
        this.mContext=mContext;
    }


    //POST请求
    public static void verfacationCodePost(String tel, String pass,Observer<Verification> observer){
        setSubscribe(service.getVerfcationCodePost(tel, pass),observer);
    }


    //POST请求参数以map传入
    public static void verfacationCodePostMap(Map<String, String> map,Observer<Verification> observer) {
       setSubscribe(service.getVerfcationCodePostMap(map),observer);
    }

    //Get请求设置缓存
    public static void verfacationCodeGetCache(String tel, String pass,Observer<Verification> observer) {
        setSubscribe(service.getVerfcationGetCache(tel, pass),observer);
    }

    //Get请求
    public static void verfacationCodeGet(String tel, String pass,Observer<Verification> observer) {
        setSubscribe(service.getVerfcationGet(tel, pass),observer);
    }

    //Get请求
    public static void verfacationCodeGetsub(String tel, String pass, Observer<Verification> observer) {
        setSubscribe(service.getVerfcationGet(tel, pass),observer);
    }

    //Get请求
    public static void Getcache( Observer<MenuBean> observer) {
        setSubscribe(service.getMainMenu(),observer);
    }

    /**
     * 插入观察者
     * @param observable
     * @param observer
     * @param <T>
     */
    public static <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
        observable.timer(10, TimeUnit.SECONDS)
                //自动判断生命周期
                .compose(RxLifecycle.with(mContext).<Long>bindToLifecycle())
                .subscribe();

        observable.timer(10, TimeUnit.SECONDS)
                //当activity onStop 注销
                .compose(RxLifecycle.with(mContext).<Long>bindUntilEvent(ActivityEvent.onStop))
                .subscribe();
        observable.just("dhhAndroid")
                //当activity onDestroy 注销
                .compose(RxLifecycle.with(mContext).<String>bindOnDestroy())
                .subscribe();
    }

}
