package com.sanim.khaja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sanim.khaja.Model.User;

public class SignIn extends AppCompatActivity {
    EditText edtPhone,edtPassword;
            Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edtPassword =(EditText)findViewById(R.id.edtPassword);
        edtPhone =(EditText)findViewById(R.id.edtPhone);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user= database.getReference("User");
         btnSignIn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 final ProgressDialog mDiaglog= new ProgressDialog(SignIn.this);
                 mDiaglog.setMessage("Waiting");
                 mDiaglog.show();

                 table_user.addValueEventListener(new ValueEventListener() {
                     @Override
                     public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                         if(dataSnapshot.child(edtPhone.getText().toString()).exists()){



                            mDiaglog.dismiss();
                         User user  = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                         if(user.getPassword().equals(edtPassword.getText().toString()))
                         {
                             Toast.makeText(SignIn.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                         }
                         else {
                             Toast.makeText(SignIn.this, "Sign in failed", Toast.LENGTH_SHORT).show();
                            }

                         }
                         else
                         {
                             Toast.makeText(SignIn.this, "User doesn't exist", Toast.LENGTH_SHORT).show();
                         }
                     }

                     @Override
                     public void onCancelled(@NonNull DatabaseError databaseError) {

                     }
                 });
             }
         });


    }
}
