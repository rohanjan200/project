package com.example.instagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registerActivity extends AppCompatActivity {
      private   EditText emailAddress;
       private EditText password;
       private Button button;
        private FirebaseAuth auth;
@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register2);

    emailAddress = findViewById(R.id.emailAddress);
    password = findViewById(R.id.password);
    button = findViewById(R.id.button);

    auth = FirebaseAuth.getInstance();
}

    public void register (View view){

        String email = emailAddress.getText().toString();
        String numpassword = password.getText().toString();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(numpassword)) {
            Toast.makeText(registerActivity.this, "Empty Credentials", Toast.LENGTH_SHORT).show();

        } else if (numpassword.length() < 4) {
            Toast.makeText(registerActivity.this, "PASS MUST BE GREATER THAN 4", Toast.LENGTH_SHORT).show();
        } else {
            registerUser(email, numpassword);
        }
    }

        private void registerUser(String email, String numpassword) {
        auth.createUserWithEmailAndPassword(email,numpassword).addOnCompleteListener(registerActivity.this,new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful()){
                             Toast.makeText(registerActivity.this, "REGISTER SUCCESSFUL", Toast.LENGTH_SHORT).show();
                     }else{
                             Toast.makeText(registerActivity.this, "REGISTER FAIL", Toast.LENGTH_SHORT).show();
                     }
                }
        });
        }
}