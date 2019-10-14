package com.example.mp_hw_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
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


    //ID 체크 메소드
    public static boolean CheckID(List<String[]> accountList, String id, String pw) {
        for (String[] s : accountList) {
            Log.d("mydebugCheckAccount", s[0] + "_" + s[1]);
            if (s[0].equals(id) && s[1].equals(pw)) {
                return true;
            }
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sign in button
        Button btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                File file = new File(getFilesDir()+"account.txt");

                EditText edtId = (EditText)findViewById(R.id.edtID);
                EditText edtPw = (EditText)findViewById(R.id.edtPW);
                String id = edtId.getText().toString();
                String pw = edtPw.getText().toString();

                //load account information
                List<String[]> accountList = GetID(file);

                //check account
                if (CheckID(accountList,id,pw)) {
                    Intent myIntent = new Intent(getApplicationContext(), FunctionActivity.class);
                    startActivity(myIntent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "wrong account", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //sign up button
        Button btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(myIntent);
            }
        });



    }
}

