package com.example.appxaydungproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.appxaydungproject.Model.UserModel;
import com.example.appxaydungproject.PagerLogin.BlankFragmentLogin;
import com.example.appxaydungproject.PagerLogin.BlankFragmentRegister;
import com.example.appxaydungproject.SettingAll.SettingAll;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivityInfoUser extends AppCompatActivity {
    private ImageView backArrow;
    private TextInputEditText txtName,txtGmail,txtSDT,txtAddress,txtID,txtPass;
    private Button btnLuu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_info_user);
        AnhXa();
        HandleSystem();
    }
    private  void AnhXa(){
        backArrow = (ImageView) findViewById(R.id.backArrow);
        txtName = (TextInputEditText) findViewById(R.id.txtTen);
        txtGmail = (TextInputEditText) findViewById(R.id.txtGmail);
        txtSDT = (TextInputEditText) findViewById(R.id.txtSDT);
        txtAddress = (TextInputEditText) findViewById(R.id.txtAddress);
        txtID = (TextInputEditText) findViewById(R.id.txtID);
        txtPass = (TextInputEditText) findViewById(R.id.txtPass);

        txtName.setText(SettingAll.userModel.getID());
        txtGmail.setText(SettingAll.userModel.getEmail());
        txtSDT.setText(SettingAll.userModel.getNumberPhone());
        txtAddress.setText(SettingAll.userModel.getAddress());
        txtID.setText(SettingAll.userModel.getID());
        txtPass.setText(SettingAll.userModel.getPass());

        btnLuu = (Button) findViewById(R.id.btnLuu);
    }
    private  void HandleSystem(){
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.setChangePage(5);
                Intent intent = new Intent(MainActivityInfoUser.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlankFragmentRegister.lsUserModels.get(BlankFragmentLogin.id).setID(txtID.getText().toString());
                BlankFragmentRegister.lsUserModels.get(BlankFragmentLogin.id).setAddress(txtAddress.getText().toString());
                BlankFragmentRegister.lsUserModels.get(BlankFragmentLogin.id).setPass(txtPass.getText().toString());
                BlankFragmentRegister.lsUserModels.get(BlankFragmentLogin.id).setNumberPhone(txtSDT.getText().toString());
                BlankFragmentRegister.lsUserModels.get(BlankFragmentLogin.id).setName(txtName.getText().toString());
            }
        });
    }
}