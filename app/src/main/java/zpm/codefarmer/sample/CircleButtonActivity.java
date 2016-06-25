package zpm.codefarmer.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CircleButtonActivity extends BaseTitleActivity {

    @BindView(R.id.titlebar)
    TextView titleText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_button);
        ButterKnife.bind(this);
        titleText.setText(getIntent().getStringExtra("titlename"));
    }
}
