package com.example.todorv;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    RecyclerView todoList;
    FloatingActionButton addNewTask;
    CustomAdapter adapter;
    private final int TASK_REQ_CODE = 350;

    DeleteListener activityListener = new DeleteListener() {
        @Override
        public void deleteItem(PojoTodo item) {
            List<PojoTodo> removeItem =
                    adapter.getDataSet();
            if (removeItem.remove(item))
                adapter.setDataSet(removeItem);
        }
    };

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,
                    Main2Activity.class);
            startActivityForResult(intent, TASK_REQ_CODE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todoList = findViewById(R.id.rv_todo_list);
        addNewTask = findViewById(R.id.fab_add_task);

        addNewTask.setOnClickListener(listener);

        adapter = new CustomAdapter(activityListener);

        //this Handles data
        todoList.setAdapter(adapter);
        //this Handles view positioning
        todoList.setLayoutManager(new GridLayoutManager(this, 3));

    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: " + requestCode + " " + resultCode);
        if (requestCode == TASK_REQ_CODE
                && resultCode == RESULT_OK
                && data != null) {
            PojoTodo dataFromNewTask =
                    data.getParcelableExtra(Main2Activity.KEY_TODO_DATA);

            List<PojoTodo> dataSet = adapter.getDataSet();

            dataSet.add(dataFromNewTask);

            adapter.setDataSet(dataSet);

        }
    }
}






