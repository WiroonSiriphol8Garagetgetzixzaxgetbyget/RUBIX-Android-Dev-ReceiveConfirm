package com.example.wiroon.test1.Fragment;


import android.content.Intent;
import android.net.http.RequestQueue;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.wiroon.test1.Appconfig;
import com.example.wiroon.test1.AsyncTaskAdapter;
import com.example.wiroon.test1.MainActivity;
import com.example.wiroon.test1.R;
import com.google.gson.Gson;
import com.jaredrummler.materialspinner.MaterialSpinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecievingFragment extends Fragment {
    //scan
    private Button btnScan;
    private EditText editText_scan;
    //config
    Appconfig appconfig;

    private JSONObject js;
    private ArrayList<Object> spinData;

    public RecievingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_recieving, container, false);

        if (appconfig == null){
            appconfig = (Appconfig) getArguments().getSerializable("Appconfig");
        }
        if (!appconfig.checkstate())
            ((MainActivity) getActivity()).restartApp();

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

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();


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
