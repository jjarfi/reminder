package com.github.jjarfi.menu.Controller.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jjarfi.menu.Controller.Regsitrasi.Registrasi;
import com.github.jjarfi.menu.Controller.ResetPassword.ResetPass;
import com.github.jjarfi.menu.MainActivity;
import com.github.jjarfi.menu.R;

public class Login extends AppCompatActivity {
    EditText uname,pass;
    Button masuk;
    TextView lblSignup, lupa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uname = findViewById(R.id.uname);
        pass = findViewById(R.id.pass);
        masuk = findViewById(R.id.masuk);
        lblSignup = findViewById(R.id.daftar);
        lupa = findViewById(R.id.lupa);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        lblSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daftar();
            }
        });
        lupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    private void reset() {
        Intent i = new Intent(getApplicationContext(), ResetPass.class);
        startActivity(i);
    }

    private void daftar() {
        Intent i = new Intent(getApplicationContext(), Registrasi.class);
        startActivity(i);
    }

    private void login(){
        String user=uname.getText().toString().trim();
        String pas=pass.getText().toString().trim();
        if(user.equals("admin")&& pas.equals("admin"))
        {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            clear();
        }else {
            Toast.makeText(this,"username atau password salah!",Toast.LENGTH_LONG).show();
        }
    }

    private void clear() {
        uname.setText("");
        pass.setText("");
    }
}
