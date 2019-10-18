package com.example.todorv;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter
        extends RecyclerView.Adapter<CustomViewHolder> {

    private List<PojoTodo> dataSet = new ArrayList<>();

    private DeleteListener listener;
    private static final String TAG = "CustomAdapter";

    public CustomAdapter(DeleteListener activityListener){
        listener = activityListener;
    }

    public void setDataSet(List<PojoTodo> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    public List<PojoTodo> getDataSet(){
        return dataSet != null ? dataSet :
                new ArrayList<PojoTodo>();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_layout,
                        parent,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder,
                                 int position) {
        holder.bindView(dataSet.get(position), listener);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+ (dataSet!=null? dataSet.size() : 0));
        return dataSet != null ? dataSet.size() : 0;
    }
}





