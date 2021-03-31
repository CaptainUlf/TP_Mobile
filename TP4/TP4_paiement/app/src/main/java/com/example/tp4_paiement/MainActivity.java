package com.example.tp4_paiement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button p_Carte;
    Button p_PayPal;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p_Carte = (Button) findViewById(R.id.button);
        p_PayPal = (Button) findViewById(R.id.button2);

        fragmentManager = getSupportFragmentManager();

        p_Carte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDialogFragment carte = new SimpleDialogFragment();
                carte = SimpleDialogFragment.newInstance("Paiement carte");
                carte.show(fragmentManager,"fragment_carte");
            }
        });

        p_PayPal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_PayPal paypal = new Fragment_PayPal();
                paypal = Fragment_PayPal.newInstance("Paiement paypal");
                paypal.show(fragmentManager,"fragment_paypal");
            }
        });
    }
}