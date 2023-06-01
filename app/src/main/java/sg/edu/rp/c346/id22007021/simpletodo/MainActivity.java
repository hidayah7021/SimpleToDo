package sg.edu.rp.c346.id22007021.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editInput;
    TextView tvDisplay;
    Button btnAdd;
    Button btnClear;
    ListView scheduleList;

    ArrayList<String> addSchedule = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editInput = findViewById(R.id.editInput);
        tvDisplay = findViewById(R.id.textDisplay);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        scheduleList = findViewById(R.id.scheduleList);

        addSchedule.add("Finish Worksheet");
        addSchedule.add("Finish Reflection Journey");

        ArrayAdapter aaList = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, addSchedule);
        scheduleList.setAdapter(aaList);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sched = editInput.getText().toString();
                aaList.add(sched);
                aaList.notifyDataSetChanged();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editInput.getText().clear();
            }
        });

    }
}