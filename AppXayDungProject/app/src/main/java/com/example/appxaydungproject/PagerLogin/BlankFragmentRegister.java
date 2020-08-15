package com.example.appxaydungproject.PagerLogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.appxaydungproject.Model.UserModel;
import com.example.appxaydungproject.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentRegister#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentRegister extends Fragment {
    private EditText txtSDT,txtEmail,txtID,txtPass,txtAddress,txtName;
    private Button btnRegister;
    public static List<UserModel> lsUserModels = new ArrayList<>();
    View v;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentRegister() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentRegister.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentRegister newInstance(String param1, String param2) {
        BlankFragmentRegister fragment = new BlankFragmentRegister();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_blank_register, container, false);


        AnhXa();
        HandleSystem();
        return v;
    }

    private void AnhXa(){
        txtID = (EditText) v.findViewById(R.id.txtID);
        txtPass = (EditText) v.findViewById(R.id.txtPass);
        txtEmail = (EditText) v.findViewById(R.id.txtEmail);
        txtSDT = (EditText) v.findViewById(R.id.txtNumberPhone);
        txtAddress = (EditText) v.findViewById(R.id.txtAddress);
        txtName = (EditText) v.findViewById(R.id.txtName);
        btnRegister = (Button) v.findViewById(R.id.btnRegister);

    }
    private void HandleEvent(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lsUserModels.add(new UserModel(txtID.getText().toString(),txtPass.getText().toString(),txtEmail.getText().toString(),txtSDT.getText().toString(),txtAddress.getText().toString(),txtName.getText().toString()));
            }
        });
    }
    private void HandleSystem(){
        HandleEvent();
    }
}