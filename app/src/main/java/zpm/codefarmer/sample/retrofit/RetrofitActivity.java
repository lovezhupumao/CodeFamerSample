package zpm.codefarmer.sample.retrofit;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.RequestBody;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import zpm.codefarmer.sample.R;

public class RetrofitActivity extends AppCompatActivity {
    private String phoneReqiureKey="2f121eb8bf260e938df638ec3cc2e5d4";
    @BindView(R.id.retrofit_phone_num)
    EditText phoneNum;
    @BindView(R.id.retrofit_phone_info)
    TextView phoneInfo;
    @OnClick(R.id.retrofit_phone_require)
    void phoneNumRequire(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://apis.juhe.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        final Api phone=retrofit.create(Api.class);
        phone.getPhoneNumBerInfo(phoneNum.getText().toString(), phoneReqiureKey)
                .map(new Func1<PhoneNumInfo, String>() {
                    @Override
                    public String call(PhoneNumInfo phoneNumInfo) {
                        return phoneNumInfo.getResult().getCity();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        phoneInfo.setText(s);
                    }
                });
    }
    @OnClick(R.id.retrofit_get_uploadpicture)
    void uploadPicture(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://image.ideayapai.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        final Api phone=retrofit.create(Api.class);
        RequestBody body= RequestBody
                .create(okhttp3.MediaType.parse("application/json; charset=utf-8")
                        , Environment.getExternalStorageDirectory().getPath()+"/33.png");
        phone.getPictureCheck(0,1,body).subscribe(new Subscriber<PictureModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("-----------",e.getMessage());
            }

            @Override
            public void onNext(PictureModel pictureModel) {
                Log.i("-----------",pictureModel.getImageGrayUrl());
            }
        });


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
    }
}
