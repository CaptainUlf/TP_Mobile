package com.example.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DetecteurDeClicSurRecycler {
    private MonRecyclerViewAdapter mAdapter;

    private CoordinatorLayout mcoordinatorLayout;
    private static Context mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MonRecyclerViewAdapter(getDataSource());
        mRecyclerView.setAdapter(mAdapter);

        mcoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

    //  RecyclerView.ItemDecoration itemDecoration =
    //          new DividerItemDecoration(this, R.drawable.divider);
    //  mRecyclerView.addItemDecoration(itemDecoration);
    }

    private ArrayList<Donnee> getDataSource() {
        ArrayList<Donnee> results = new ArrayList<Donnee>();
        for (int i = 0; i < Donnee.nomPlanetes.length; i++) {
            Donnee obj = new Donnee(
                    Donnee.nomPlanetes[i],
                    "Taille : " + Donnee.taillePlanetes[i]);
            results.add(i, obj);
        }
        return results;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }

    public void clicSurRecyclerItem(int position, View v) {
        Snackbar.make(mcoordinatorLayout, " Clic sur l'item " + position, Snackbar.LENGTH_LONG).show();
    }

    public static int getImage( String nomImage ){
        return mainActivity.getResources().getIdentifier(nomImage, "drawable", mainActivity.getPackageName());
    }
}