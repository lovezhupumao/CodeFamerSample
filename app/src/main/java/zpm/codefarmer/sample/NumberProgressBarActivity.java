package zpm.codefarmer.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import zpm.lib.ui.numberprogressbar.NumberProgressBar;
import zpm.lib.ui.numberprogressbar.OnProgressBarListener;

public class NumberProgressBarActivity extends AppCompatActivity implements OnProgressBarListener {

    private Timer timer;
    @BindView(R.id.titlebar)
    TextView titleText;
    @BindView(R.id.numberbar1)
    NumberProgressBar bnp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_progress_bar);
        ButterKnife.bind(this);
        titleText.setText(getIntent().getStringExtra("titlename"));
        bnp.setOnProgressBarListener(this);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        bnp.incrementProgressBy(1);
                    }
                });
            }
        }, 1000, 100);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    @Override
    public void onProgressChange(int current, int max) {
        if(current == max) {
            Toast.makeText(getApplicationContext(), "finish", Toast.LENGTH_SHORT).show();
            bnp.setProgress(0);
        }
    }
}
