package zpm.codefarmer.sample.retrofit;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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

    /**
     * http://image.ideayapai.com/upload?defectType=0&perunit=1
     * @param defectType
     * @param perunit
     * @return
     */
    @Multipart
    @Headers({"Content-Type: multipart/form-data","Accept: application/json"})
    @POST("upload")
    Observable<PictureModel> getPictureCheck(@Query("defectType") int defectType,
                                             @Query("perunit") double perunit,
                                             @Part("filename") String description,
                                             @Part("file; filename=\"image.png\"") RequestBody file);

}
