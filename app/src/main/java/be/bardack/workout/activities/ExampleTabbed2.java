package be.bardack.workout.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

import be.bardack.workout.R;

public class ExampleTabbed2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ExampleTabbed2", "This is a test");
        setContentView(R.layout.activity_example_tabbed2);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        addTab(tabHost, "Tab one", R.id.tab1);
        addTab(tabHost, "Tab two", R.id.tab2);

    }

    private void addTab(TabHost tabHost, String name, int layout) {
        TabHost.TabSpec spec = tabHost.newTabSpec(name);
        spec.setContent(layout);
        spec.setIndicator(name);
        tabHost.addTab(spec);
    }
}
