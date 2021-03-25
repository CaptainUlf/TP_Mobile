package com.example.listeplanetes;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class PlaneteAdapter extends BaseAdapter {

    private final Data data;
    private final MainActivity context;
    private final ArrayList<Item> allCheckbox;

    public PlaneteAdapter(MainActivity context) {
        this.data = new Data();
        data.installePlanetes();
        this.context = context;
        allCheckbox = new ArrayList<Item>();
    }

    @Override
    public int getCount() { return data.getPlanetes().size(); }

    @Override
    public Object getItem(int arg0) {
        return data.getPlanetes().get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }

        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);

        nomPlanete.setText(data.getPlanetes().get(position));

        //  installer l'adaptateur pour la liste déroulante (spinner)
        String[] taillePlanetes = data.getTaillePlanetes();
        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, taillePlanetes);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);

        allCheckbox.add(new Item(checkBox, spinner));

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox checkBox = (CheckBox)  compoundButton.findViewById(R.id.checkbox);
                spinner.setEnabled(!checkBox.isChecked());
                spinadapter.notifyDataSetChanged();
                checkState();
            }

            public void checkState()
            {
                boolean state = true;
                for (int i = 0; i < data.getPlanetes().size(); i++)
                {
                    if (i >= allCheckbox.size() || !allCheckbox.get(i).getCheckBox().isChecked())
                    {
                        state = false;
                    }
                }
                context.button.setEnabled(state);
            }
        });



        return itemView;
    }

    public ArrayList<Item> getItems()
    {
        return allCheckbox;
    }

    public static class Item {

        private final CheckBox checkBox;
        private final Spinner spinner;

        public Item(CheckBox checkBox, Spinner spinner)
        {
            this.checkBox = checkBox;
            this.spinner = spinner;
        }

        public CheckBox getCheckBox()
        {
            return this.checkBox;
        }

        public Spinner getSpinner()
        {
            return this.spinner;
        }

    }

}
