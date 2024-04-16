package com.example.dispmoveisavaliacao01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ValuesAdapter extends RecyclerView.Adapter<ValuesAdapter.ValueViewHolder> {

    private List<String> valuesList;

    public ValuesAdapter(List<String> valuesList) {
        this.valuesList = valuesList;
    }

    @NonNull
    @Override
    public ValueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_value, parent, false);
        return new ValueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ValueViewHolder holder, int position) {
        String value = valuesList.get(position);
        holder.bind(value);
    }

    @Override
    public int getItemCount() {
        return valuesList.size();
    }

    public class ValueViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewValue;

        public ValueViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewValue = itemView.findViewById(R.id.textViewValue);
        }

        public void bind(String value) {
            textViewValue.setText(value);
        }
    }
}
