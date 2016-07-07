package zpm.codefarmer.sample.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zpm.codefarmer.sample.R;

public class RetrofitActivity extends AppCompatActivity {

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
