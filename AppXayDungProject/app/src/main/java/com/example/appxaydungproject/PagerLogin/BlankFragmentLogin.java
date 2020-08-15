package com.example.appxaydungproject.PagerLogin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;


import com.example.appxaydungproject.MainActivity2;
import com.example.appxaydungproject.MainActivityLoginAndRegister;
import com.example.appxaydungproject.Model.UserModel;
import com.example.appxaydungproject.R;
import com.example.appxaydungproject.Retrofit.RetrofitClient;
import com.example.appxaydungproject.SettingAll.SettingAll;
import com.example.appxaydungproject.TabMenu.BlankFragmentCaNhan;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentLogin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentLogin extends Fragment {
    private View v;
    public static EditText txtID,txtPass;
    private Button btnLogin;
    public static UserModel userModel;
    public static int id;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentLogin() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentLogin.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentLogin newInstance(String param1, String param2) {
        BlankFragmentLogin fragment = new BlankFragmentLogin();
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

        v = inflater.inflate(R.layout.fragment_blank_login, container, false);
        // Inflate the layout for this fragment

        AnhXa();
        Handle();
//        MainActivityLoginAndRegister.txtLogin.setTextColor(Color.WHITE);
//        MainActivityLoginAndRegister.txtRegister.setTextColor(getResources().getColor(R.color.colorBlackFill));
        return v;
    }
    private void AnhXa(){
        txtID = (EditText)v.findViewById(R.id.txtID);
        txtPass = (EditText)v.findViewById(R.id.txtPass);

        btnLogin = (Button) v.findViewById(R.id.btnLogin);
    }
    private void Handle(){
        HandleEvent();
    }
    private void HandleEvent(){
        BlankFragmentRegister.lsUserModels.add(new UserModel("bao","123","lebao@gmail.com","0935247352","115 lê trọng tấn","Bảo"));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                RetrofitClient.sendPostLogin(txtID.getText().toString(),txtPass.getText().toString());


                if(RetrofitClient.token == null){
                    dialogDN();
                }
                System.out.println(txtID.getText()+"+++"+txtPass.getText());
                for(int i = 0 ; i< BlankFragmentRegister.lsUserModels.size(); i++ ){

                    if(txtID.getText().toString().equals(BlankFragmentRegister.lsUserModels.get(i).getID()) && txtPass.getText().toString().equals(BlankFragmentRegister.lsUserModels.get(i).getPass())){
                        System.out.println("da thanh cong");
                        id = i;
                        userModel = BlankFragmentRegister.lsUserModels.get(i);
                        SettingAll.checkDNDX = 1;


                            SharedPreferences sharedPreferences = v.getContext().getSharedPreferences("data_user", Context.MODE_PRIVATE);
                            SharedPreferences.Editor edit= sharedPreferences.edit();
                            edit.putString("id", BlankFragmentLogin.userModel.getID());
                            edit.putString("pass", BlankFragmentLogin.userModel.getPass());
                            edit.putString("email", BlankFragmentLogin.userModel.getEmail());
                            edit.putString("numberPhone", BlankFragmentLogin.userModel.getNumberPhone());
                            edit.putString("address", BlankFragmentLogin.userModel.getAddress());
                            edit.putString("name", BlankFragmentLogin.userModel.getName());
                            edit.commit();
                        Intent intent = new Intent(v.getContext(), MainActivity2.class);
                        startActivity(intent);

                    }
                }


            }
        });


    }
    private void dialogDN(){
        //Tạo đối tượng
        AlertDialog.Builder b = new AlertDialog.Builder(v.getContext());
//Thiết lập tiêu đề
        b.setTitle("Thông Báo");

        b.setMessage("Bạn Đã Đăng Nhập Sai Mời Đăng Nhập Lại");
// Nút Ok
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
//Nút Cancel
//        b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                dialog.cancel();
//            }
//        });
//Tạo dialog
        AlertDialog al = b.create();
//Hiển thị
        al.show();
    }
}