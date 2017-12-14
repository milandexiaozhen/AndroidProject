package retrofit.network;

import java.util.Map;

import retrofit.bean.MenuBean;
import retrofit.bean.Verification;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by gaokun on 2017/12/6.
 */

public interface NetService {
    //设缓存有效期为1天
    long CACHE_STALE_SEC = 60 * 60 * 24 * 1;
    //查询缓存的Cache-Control设置，使用缓存
    String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
    //查询网络的Cache-Control设置。不使用缓存
    String CACHE_CONTROL_NETWORK = "max-age=0";
    //POST请求
    @FormUrlEncoded
    @POST("http://www.vitagou.hk/mobile/app_type_search")
    Observable<Verification> getVerfcationCodePost(@Field("type") String type, @Field("cat") String cat);

    //POST请求
    @FormUrlEncoded
    @POST("http://www.vitagou.hk/mobile/app_type_search")
    Observable<Verification> getVerfcationCodePostMap(@FieldMap Map<String, String> map);

    //GET请求
    @GET("bjws/app.user/login")
    Observable<Verification> getVerfcationGet(@Query("tel") String tel, @Query("password") String pass);

    //GET请求，设置缓存
//    @Headers("Cache-Control: public," + CACHE_CONTROL_CACHE)
    @GET("bjws/app.user/login")
    Observable<Verification> getVerfcationGetCache(@Query("tel") String tel, @Query("password") String pass);

//    @Headers("Cache-Control: public," + CACHE_CONTROL_CACHE)
    @GET("http://www.vitagou.hk/mobile/app_classify")
    Observable<MenuBean> getMainMenu();
}
