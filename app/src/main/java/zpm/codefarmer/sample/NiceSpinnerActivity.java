package zpm.codefarmer.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zpm.lib.ui.nicespinner.NiceSpinner;

public class NiceSpinnerActivity extends AppCompatActivity {

    @BindView(R.id.titlebar)
    TextView titleText;
    @BindView(R.id.tv_tinted_spinner)
    NiceSpinner niceSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nice_spinner);
        ButterKnife.bind(this);
        titleText.setText(getIntent().getStringExtra("titlename"));
        List<String> dataset = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        niceSpinner.attachDataSource(dataset);
    }
}
