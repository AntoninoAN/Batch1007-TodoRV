package com.example.todorv;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    public TextView tvItemTask;
    public TextView tvItemCategory;
    private DeleteListener listener;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        initUI();
    }

    public void bindView(final PojoTodo item,
                         DeleteListener listener){
        this.listener = listener;
        tvItemTask.setText(item.getTask());
        tvItemCategory.setText(item.getCategory());
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                CustomViewHolder.this.listener.deleteItem(item);
                return true;
            }
        });
    }

    private void initUI(){
        tvItemTask = itemView.findViewById(R.id.tv_item_task);
        tvItemCategory = itemView
                .findViewById(R.id.tv_item_category);
    }
}








