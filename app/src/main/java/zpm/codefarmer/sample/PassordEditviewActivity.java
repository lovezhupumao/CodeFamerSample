package zpm.codefarmer.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PassordEditviewActivity extends AppCompatActivity {

    @BindView(R.id.titlebar)
    TextView titleText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passord_editview);
        ButterKnife.bind(this);
        titleText.setText(getIntent().getStringExtra("titlename"));
    }
}
