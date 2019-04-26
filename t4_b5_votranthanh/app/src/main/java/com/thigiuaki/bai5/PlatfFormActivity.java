package com.thigiuaki.bai5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PlatfFormActivity extends AppCompatActivity {

    ListView lvPF;
    ArrayList<PlatfForm> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platf_form);
        createData();
        PlatfFormAdapter adapter = new PlatfFormAdapter(this, R.layout.listview_my_layout, data);
        lvPF = (ListView)findViewById(R.id.lvPF);
        lvPF.setAdapter(adapter);
    }
    private void createData(){
        data = new ArrayList<PlatfForm>();
        data.add(new PlatfForm(R.drawable.ic_android, "Android"));
        data.add(new PlatfForm(R.drawable.ic_ios, "iOS"));
        data.add(new PlatfForm(R.drawable.ic_windowsphone, "Windows Phone"));
    }
}
