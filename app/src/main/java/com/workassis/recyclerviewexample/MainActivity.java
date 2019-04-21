package com.workassis.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.workassis.recyclerviewexample.adapters.ScheduleAdapter;
import com.workassis.recyclerviewexample.interfaces.ItemClickListener;
import com.workassis.recyclerviewexample.models.ScheduleModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    ArrayList<ScheduleModel> scheduleData=new ArrayList<ScheduleModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ScheduleAdapter adapter = new ScheduleAdapter(scheduleData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setClickListener(this);
        adapter.setLongClickListener(this);



        for(int i=0; i<20;i++) {
            scheduleData.add(new ScheduleModel("KL59E101"+i, "payyanur", "10:00:am", "50"+i));
        }

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View view, int position) {

        ScheduleModel schedule = scheduleData.get(position);

        Toast.makeText(this, schedule.getBusNo(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLongClickListener(View view, int position) {
        ScheduleModel schedule = scheduleData.get(position);
        Toast.makeText(this, "Long click"+ schedule.getBusNo(), Toast.LENGTH_SHORT).show();

    }
}
