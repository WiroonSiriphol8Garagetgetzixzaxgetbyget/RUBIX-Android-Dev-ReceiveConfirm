package com.example.wiroon.test1.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.wiroon.test1.Appconfig;
import com.example.wiroon.test1.AsyncTaskAdapter;
import com.example.wiroon.test1.MainActivity;
import com.example.wiroon.test1.R;
import com.google.gson.Gson;
import com.jaredrummler.materialspinner.MaterialSpinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecievingFragment extends Fragment {
    private static final int RESULT_OK = 0;
    //scan
    private Button btnScan;
    private EditText editText_scan;
    //Spinner
    private Spinner spn_date;
    private ArrayList<String> item = new ArrayList<>();
    //config
    Appconfig appconfig;

    private JSONObject js;

    public RecievingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_recieving, container, false);

        btnScan = v.findViewById(R.id.btn_scan);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, CameraFragment.newInstance("Receive_Do"), "tag_barcode")
                        .addToBackStack("ScanCode Fragment").commit();
            }
        });
        //find id
        editText_scan = v.findViewById(R.id.edt_scan);
//        spn_date = v.findViewById(R.id.spinner_date);

        //set default

        //scan
        if (editText_scan.getText().toString().equals("")) {
            editText_scan.setText("-");
            editText_scan.setEnabled(true);
            editText_scan.setTextSize(18);
            editText_scan.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
        } else {
            editText_scan.setEnabled(false);
            editText_scan.setTextSize(18);
            editText_scan.setTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
        }
        //spinner
        MaterialSpinner spinner = (MaterialSpinner) v.findViewById(R.id.spinner_date);
//        AsyncTaskAdapter s = new AsyncTaskAdapter(new Gson().toJson(1),appconfig);
//        s.execute("api/MobileReceiving/SearchReceivingInstructionEntry");
        try {
                spinner.setItems(" ",
                                 "2018-03-02",
                                 "2016-06-23",
                                 "2017-09-25",
                                 "2017-09-26");

        } catch (Exception ex){
            ex.printStackTrace();
        }


        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });
//        item.add("10/07/2018");
//        item.add("12/07/2018");
//        item.add("13/07/2018");
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item);
//        spn_date.setAdapter(adapter);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
//        if (!appconfig.checkstate())
//            ((MainActivity) getActivity()).restartApp();

        //receive data
        if (getArguments() != null) {
            if (getArguments().getString("WhereScan") != null) {
                if (getArguments().getString("WhereScan").equals("Do")) {
                    editText_scan.setText(getArguments().getString("result"));
                }
            }
        }
    }


}
