package zpm.codefarmer.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import zpm.lib.ui.betterspinner.BetterSpinner;

public class BetterSpinnerActivity extends AppCompatActivity {
    @BindView(R.id.titlebar)
    TextView titleText;
    @BindView(R.id.spinner1)
    BetterSpinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_better_spinner);
        ButterKnife.bind(this);
        titleText.setText(getIntent().getStringExtra("titlename"));
        String[] list =new String[]{"1","4","2"};
        /*R.layout.simple_dropdown_item_1line为系统自带*/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, list);

        spinner.setAdapter(adapter);

    }
}
