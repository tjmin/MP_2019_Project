package com.example.mp_hw_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    //계정 정보 리스트로 가져오는 메소드
    public static List<String[]> GetID(File file) {
        List<String[]> accountList = new ArrayList<String[]>();
        String[] splitedStr = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"euc-kr"));
            String line = null;
            splitedStr = null;

            while ((line = reader.readLine())!=null) {
                splitedStr = null;
                splitedStr = line.split("\t");

                for (int i=0;i<splitedStr.length;i++) {
                    splitedStr[i] = splitedStr[i].trim();
                }
                accountList.add(new String[]{splitedStr[0],splitedStr[1]});
                Log.d("mydebug",splitedStr[0]);
            }
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accountList;
    }


    //ID 중복 체크 메소드
    public static boolean CheckExistedID(List<String[]> accountList, String id) {
        for (String[] s : accountList) {
            Log.d("mydebugCheckAccount", s[0] + "_" + s[1]);
            if (s[0].equals(id)) {
                return true;
            }
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //confirm button
        Button btnSignUpConfirm = (Button) findViewById(R.id.btnSignUpConfirm);
        btnSignUpConfirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                File file = new File(getFilesDir()+"account.txt");

                EditText edtId = (EditText)findViewById(R.id.edtID);
                EditText edtPw = (EditText)findViewById(R.id.edtPW);
                EditText edtName = (EditText)findViewById(R.id.edtName);
                EditText edtPhoneNumber = (EditText)findViewById(R.id.edtPhoneNumber);
                EditText edtAddress = (EditText)findViewById(R.id.edtAddress);
                String id = edtId.getText().toString();
                String pw = edtPw.getText().toString();
                String name = edtName.getText().toString();
                String phoneNumber = edtPhoneNumber.getText().toString();
                String address = edtAddress.getText().toString();
                RadioButton rBtn = (RadioButton) findViewById(R.id.radioBtnAccept);

                //아이디 중복 체크
                List<String[]> accountList = GetID(file);
                if (CheckExistedID(accountList,id)) {
                    Toast.makeText(getApplicationContext(), "Existed ID", Toast.LENGTH_SHORT).show();
                    return;
                }

                //비밀번호 자리수
                if (pw.length() < 8) {
                    Toast.makeText(getApplicationContext(), "short PW (required over 8 characters)", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (rBtn.isChecked()) {
                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                        String account = id + "\t" + pw + "\t" + name + "\t" + phoneNumber + "\t" + address + "\n";
                        bw.write(account);
                        Log.d("mydebug", account);

                        //file_writer.close();
                        bw.close();
                        Toast.makeText(getApplicationContext(), "welcome", Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Accept terms and Conditions", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //backward button
        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
