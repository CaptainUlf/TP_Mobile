package com.example.tp4.ui.main;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.tp4.R;

import java.util.Locale;

/**
 * une instance de NatureFragment contient ici juste un label
 */
public class NatureFragment extends Fragment {
    // Les champs utilisés par chaque Fragment
    //Ils sont distincts pour chaque NatureFragment instancié
    private String title;
    private int page;
    /**
     * Pour la sauvegarde et la récupération des données
     * dans un Bundle
     */
    private static final String ARG_SECTION_NUMBER = "numero_page";
    private static final String ARG_SECTION_TITLE = "titre_page";

    /**
     * Retourne une nouvelle instance de ce fragment
     * pour le numéro de section donné.
     */
    public static NatureFragment newInstance(int position, String title) {
        NatureFragment fragment = new NatureFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, position);
        args.putString(ARG_SECTION_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    // retrouver les valeurs des champs à partir du bundle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(ARG_SECTION_NUMBER, 0);
        title = getArguments().getString(ARG_SECTION_TITLE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        TextView tvLabel = (TextView) view.findViewById(R.id.section_label);
        tvLabel.setText(page + " -- " + title);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

        switch (page)
        {
            case 0:
                imageView.setImageResource(R.mipmap.printemps_icon_round);
                break;
            case 1:
                imageView.setImageResource(R.mipmap.ete_icon_round);
                break;
            case 2:
                imageView.setImageResource(R.mipmap.automne_icon_round);
                break;
            case 3:
                imageView.setImageResource(R.mipmap.hiver_icon_round);
                break;
            case 4:
                view = inflater.inflate(R.layout.saison_layout, container, false);
                ViewPager viewPager = getActivity().findViewById(R.id.view_pager);

                ImageView imageView1 = (ImageView) view.findViewById(R.id.imageView1);
                imageView1.setImageResource(R.mipmap.printemps_icon_foreground);

                ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView2);
                imageView2.setImageResource(R.mipmap.ete_icon_foreground);

                ImageView imageView3 = (ImageView) view.findViewById(R.id.imageView3);
                imageView3.setImageResource(R.mipmap.automne_icon_foreground);

                ImageView imageView4 = (ImageView) view.findViewById(R.id.imageView4);
                imageView4.setImageResource(R.mipmap.hiver_icon_foreground);

                imageView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(0);
                    }
                });

                imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(1);
                    }
                });

                imageView3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(2);
                    }
                });

                imageView4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(3);
                    }
                });
                break;
        }
        return view;
    }
}


