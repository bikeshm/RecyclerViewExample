package com.workassis.recyclerviewexample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.workassis.recyclerviewexample.R;
import com.workassis.recyclerviewexample.interfaces.ItemClickListener;
import com.workassis.recyclerviewexample.models.ScheduleModel;

import java.util.ArrayList;

public class ScheduleAdapter  extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    ArrayList<ScheduleModel> schedules=new ArrayList<ScheduleModel>();

    private ItemClickListener clickListener;

    public ScheduleAdapter(ArrayList<ScheduleModel> schedules) {
        this.schedules = schedules;
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public void setLongClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final ScheduleModel schedule = schedules.get(position);
        holder.busNo.setText(schedule.getBusNo());
        holder.route.setText(schedule.getRoute());
        holder.time.setText(schedule.getTime());
        holder.fee.setText(schedule.getFee());


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"click on item: "+schedule.getBusNo (),Toast.LENGTH_LONG).show();
                if (clickListener != null) clickListener.onClick(view,position);
            }
        });

        holder.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (clickListener != null) clickListener.onLongClickListener(v,position);
                return true;
            }

        });

    }


    @Override
    public int getItemCount() {
        return schedules.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView busNo;
        public TextView route;
        public TextView time;
        public TextView fee;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.busNo = (TextView) itemView.findViewById(R.id.busNo);
            this.route = (TextView) itemView.findViewById(R.id.route);
            this.time = (TextView) itemView.findViewById(R.id.time);
            this.fee = (TextView) itemView.findViewById(R.id.fee);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }
}
