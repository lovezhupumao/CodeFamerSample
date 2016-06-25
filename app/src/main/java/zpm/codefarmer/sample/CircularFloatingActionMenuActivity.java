package zpm.codefarmer.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import zpm.lib.ui.circlebutton.CircleButton;
import zpm.lib.ui.circularfloatingactionmenu.FloatingActionButton;
import zpm.lib.ui.circularfloatingactionmenu.FloatingActionMenu;
import zpm.lib.ui.circularfloatingactionmenu.SubActionButton;

public class CircularFloatingActionMenuActivity extends AppCompatActivity {
    @BindView(R.id.titlebar)
    TextView titleText;
    @BindView(R.id.menubutton)
    CircleButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_floating_action_menu);
        ButterKnife.bind(this);
        titleText.setText(getIntent().getStringExtra("titlename"));
        //第一步
        ImageView icon = new ImageView(this); // Create an icon
        icon.setImageDrawable(getResources().getDrawable(R.drawable.ic_fab_star));
        icon.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .setPosition(3)
                .build();

        // 第二步
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        // repeat many times:
        ImageView itemIcon0 = new ImageView(this);
        itemIcon0.setImageDrawable(getResources().getDrawable(R.drawable.ic_fab_star));
        ImageView itemIcon1 = new ImageView(this);
        itemIcon1.setImageDrawable(getResources().getDrawable(R.drawable.ic_fab_star));
        ImageView itemIcon2 = new ImageView(this);
        itemIcon2.setImageDrawable(getResources().getDrawable(R.drawable.ic_fab_star));
        ImageView itemIcon3 = new ImageView(this);
        itemIcon3.setImageDrawable(getResources().getDrawable(R.drawable.ic_fab_star));
        SubActionButton button1 = itemBuilder.setContentView(itemIcon0).build();
        SubActionButton button2 = itemBuilder.setContentView(itemIcon1).build();
        SubActionButton button3 = itemBuilder.setContentView(itemIcon2).build();
        SubActionButton button4 = itemBuilder.setContentView(itemIcon3).build();

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .setStartAngle(90)
                .setEndAngle(180)
                .setRadius(200)
                .addSubActionView(button1)
                .addSubActionView(button2)
                .addSubActionView(button3)
                .addSubActionView(button4)
                .attachTo(actionButton)
                .build();
    }
}
