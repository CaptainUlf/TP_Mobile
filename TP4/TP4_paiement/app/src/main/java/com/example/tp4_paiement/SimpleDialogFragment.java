package com.example.tp4_paiement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SimpleDialogFragment extends DialogFragment {


    private EditText mEditText;
    private SimpleDialogListener listener;
    private Button btn;


    public SimpleDialogFragment() {
        // le fragment est créé par la méthode newInstance
    }

    public static SimpleDialogFragment newInstance(String title) {

        SimpleDialogFragment frag = new SimpleDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_carte, container);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }


}
