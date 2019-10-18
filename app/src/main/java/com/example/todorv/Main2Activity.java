package com.example.todorv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Main2Activity extends AppCompatActivity {

    TextInputLayout tilTask;
    TextInputLayout tilCategory;
    ImageButton btnSaveTask;

    public static final String KEY_TODO_DATA = "KEY_TODO_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tilTask = findViewById(R.id.til_task);
        tilCategory = findViewById(R.id.til_category);
        btnSaveTask = findViewById(R.id.btn_save_task);

        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkEmptyValues())
                    Toast.makeText(Main2Activity.this,
                            "One of the fields are empty",
                            Toast.LENGTH_LONG).show();
                else{
                    setResult(RESULT_OK,
                        setData());
                    finish();
                }
            }
        });
    }

    private Intent setData(){
        PojoTodo data = new PojoTodo();
        Intent intent = new Intent();
        data.setTask(tilTask.getEditText().getText().toString());
        data.setCategory(tilCategory.getEditText().getText().toString());
        intent.putExtra(KEY_TODO_DATA, data);
        return intent;
    }

    /**
     * This method is intended to check for null values on the
     * task and the category and avoid a null pointer
     * when creating the intent to send the result to the previous
     * activity
     * @return false when both values are false...
     */
    private boolean checkEmptyValues(){
        String task, category;
        task = tilTask.getEditText().getText().toString();
        category = tilCategory.getEditText().getText().toString();

        return task.isEmpty() || category.isEmpty();

    }
}





