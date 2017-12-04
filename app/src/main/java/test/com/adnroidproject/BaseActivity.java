package test.com.adnroidproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dhh.rxlifecycle.ActivityEvent;
import com.dhh.rxlifecycle.LifecycleTransformer;
import com.dhh.rxlifecycle.RxLifecycle;

import rx.Observable;

/**
 * Created by vtg on 2017/5/11.
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //轻量级无侵入性的RxJava自动注销库RxLifecycle
        RxLifecycle.injectRxLifecycle(this);

    }
    private <T> LifecycleTransformer<T> bindToLifecycle() {
        return RxLifecycle.with(this).bindToLifecycle();
    }

    private <T> LifecycleTransformer<T> bindOnDestroy() {
        return RxLifecycle.with(this).bindOnDestroy();
    }

    private <T> LifecycleTransformer<T> bindUntilEvent(ActivityEvent event) {
        return RxLifecycle.with(this).bindUntilEvent(event);
    }

//use @Override
protected void onStart() {
    super.onStart();
    Observable.just(1)
            //use
            .compose(bindToLifecycle())
            .subscribe();
}


}
