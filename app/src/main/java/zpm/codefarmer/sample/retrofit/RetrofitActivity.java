package zpm.codefarmer.sample.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    @OnClick
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
    @OnClick
    void uploadPicture(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
    }
}
