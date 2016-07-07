package zpm.codefarmer.sample.retrofit;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/7/7 0007.
 */
public interface Api {
    /**
     *接口地址 http://apis.juhe.cn/mobile/get；
     * 请求示例：http://apis.juhe.cn/mobile/get?phone=13429667914&key=您申请的KEY
     * @param phone
     * @param key
     * @return
     */
    @Headers("Content-Type:application/json")
    @GET("mobile/get")
    Observable<PhoneNumInfo> getPhoneNumBerInfo(@Query("phone") String phone, @Query("key") String key);
}
