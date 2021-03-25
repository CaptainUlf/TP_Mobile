package com.example.listeplanetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    PlaneteAdapter adapter;
    Data data;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new Data();
        data.installePlanetes();

        listview = (ListView) findViewById(R.id.listView);

        adapter = new PlaneteAdapter(this);
        listview.setAdapter(adapter);

        button = (Button) findViewById(R.id.button);
        button.setEnabled(false);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean bonneRep = true;
                for (int i = 0; i < data.getPlanetes().size(); i++)
                {
                    String res1 = adapter.getItems().get(i).getSpinner().getSelectedItem().toString();
                    String res2 = data.getTaillePlanetes()[i];
                    if (!res1.equals(res2))
                    {
                        bonneRep = false;
                    }
                }
                if (bonneRep)
                    popUp("Correct !");
                else
                    popUp("Il y a des erreurs");
            }
        });
    }

    public void popUp(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}