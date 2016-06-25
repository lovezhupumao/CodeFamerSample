package zpm.codefarmer.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zpm.lib.ui.circlebutton.CircleButton;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listView;
    MyAdapter adapter;
    List<DemoInfo> list=new ArrayList<DemoInfo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initList();
        adapter=new MyAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,list.get(position).demoClass);
                startActivity(intent);
            }
        });
    }

    private void initList() {
        list.add(new DemoInfo("CircleButton Example",CircleButtonActivity.class));
        list.add(new DemoInfo("CircleImageView Example",CircleImageActivity.class));
    }

    private static class DemoInfo{
        private  String title;
        private  Class<? extends android.app.Activity> demoClass;

        public DemoInfo(String title ,Class<? extends android.app.Activity> demoClass) {
            this.title = title;
            this.demoClass = demoClass;
        }
    }
    private class   MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           if (convertView==null)
               convertView = View.inflate(MainActivity.this, R.layout.itemlayout, null);
            TextView title = (TextView)convertView.findViewById(R.id.classname);
            title.setText(list.get(position).title);
            return convertView;
        }
    }

}
