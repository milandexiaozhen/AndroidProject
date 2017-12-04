package test.com.adnroidproject;

import org.litepal.LitePalApplication;

/**
 *
 */
public class MyApplication extends LitePalApplication {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;

    }



    public static MyApplication getInstance() {
        return instance;
    }

}

