package com.rezkyb.deadlinelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DeadlineAdapter extends RecyclerView.Adapter<DeadlineAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView deadlineName;
        public TextView deadlineDetails;
        public TextView deadlineDate;

        public ViewHolder(View itemView) {
            super(itemView);

            deadlineName = (TextView) itemView.findViewById(R.id.deadline_name);
            deadlineDetails = (TextView) itemView.findViewById(R.id.deadline_details);
            deadlineDate = (TextView) itemView.findViewById(R.id.deadline_date);
        }
    }

    private List<Deadline> mDeadline;

    public DeadlineAdapter(List<Deadline> deadlines) {
        mDeadline = deadlines;
    }

    @NonNull
    @Override
    public DeadlineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View deadlineView = inflater.inflate(R.layout.item_deadline,parent,false);

        ViewHolder viewHolder = new ViewHolder(deadlineView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DeadlineAdapter.ViewHolder viewHolder, int position) {
        Deadline deadlines = mDeadline.get(position);

        TextView deadlineName = viewHolder.deadlineName;
        deadlineName.setText(deadlines.getName());

        TextView deadlineDetails = viewHolder.deadlineDetails;
        deadlineDetails.setText(deadlines.getDetails());

        TextView deadlineDate = viewHolder.deadlineDate;
        deadlineDate.setText(deadlines.getDate());
    }

    @Override
    public int getItemCount() {
        return mDeadline.size();
    }
}
