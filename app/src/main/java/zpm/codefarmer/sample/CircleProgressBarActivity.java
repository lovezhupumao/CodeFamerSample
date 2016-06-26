package zpm.codefarmer.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import zpm.lib.ui.circleprogressbar.ArcProgress;
import zpm.lib.ui.circleprogressbar.CircleProgress;
import zpm.lib.ui.circleprogressbar.DonutProgress;

public class CircleProgressBarActivity extends AppCompatActivity {
    @BindView(R.id.titlebar)
    TextView titleText;
    @BindView(R.id.arc_progress1)
    ArcProgress arcProgress;
    @BindView(R.id.donut_progress)
    DonutProgress donutProgress;
    @BindView(R.id.circle_progress)
    CircleProgress circleProgress;
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_progress_bar);
            ButterKnife.bind(this);
            titleText.setText(getIntent().getStringExtra("titlename"));
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        donutProgress.setProgress(donutProgress.getProgress() + 1);
                        circleProgress.setProgress(circleProgress.getProgress() + 1);
                        arcProgress.setProgress(arcProgress.getProgress() + 1);
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
}
