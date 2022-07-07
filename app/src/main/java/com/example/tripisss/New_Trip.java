package com.example.tripisss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class New_Trip extends AppCompatActivity {
    EditText Trip;
    Button addNewTripBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trip);
        Trip = findViewById(R.id.tripName);
        addNewTripBtn = findViewById(R.id.addNewTrip);
        DAOTrp dao = new DAOTrp();
        addNewTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Trp tr = new Trp(Trip.getText().toString());
//                Toast.makeText(New_Trip.this, tr.getTripName(), Toast.LENGTH_SHORT).show();
                FirebaseDatabase.getInstance().getReference().child("users").setValue(tr);
            }
        });
    }
}