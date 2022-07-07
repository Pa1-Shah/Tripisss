package com.example.tripisss;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOTrp {

    private DatabaseReference databaseReference;
    public DAOTrp(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Trp.class.getSimpleName());
    }
    public Task<Void> add(Trp tr){

        return databaseReference.push().setValue(tr);
    }

}
