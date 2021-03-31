package com.example.tp4_paiement;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Fragment_PayPal extends DialogFragment {

    private SimpleDialogListener listener;

    public Fragment_PayPal() {
        // le fragment est créé par la méthode newInstance
    }


    public static Fragment_PayPal newInstance(String title) {

        Fragment_PayPal frag_P = new Fragment_PayPal();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag_P.setArguments(args);
        return frag_P;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_paypal, container);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }
}