package com.example.finalassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WarningAdapter extends RecyclerView.Adapter<WarningAdapter.WarningViewHolder> {

    private ArrayList<WarningItem> warningList;

    public WarningAdapter(ArrayList<WarningItem> warningList) {
        this.warningList = warningList;
    }

    @NonNull
    @Override
    public WarningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_warning, parent, false);
        return new WarningViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WarningViewHolder holder, int position) {
        WarningItem item = warningList.get(position);
        holder.title.setText(item.getTitle());
        holder.message.setText(item.getMessage());
        holder.icon.setImageResource(item.getIconResId());
    }

    @Override
    public int getItemCount() {
        return warningList.size();
    }

    static class WarningViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title, message;

        public WarningViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.warning_icon);
            title = itemView.findViewById(R.id.warning_title);
            message = itemView.findViewById(R.id.warning_message);
        }
    }
}
