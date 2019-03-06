package com.example.karim.oge_v1;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {


    private static final String TAG = "Fragment1";

    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference noteRef = db.document("ОГЭ/1 Вариант/Задание1/Задание1");

    TextView fragment1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmentds
        View view =  inflater.inflate(R.layout.fragment_fragment1, container, false);

        fragment1 = view.findViewById(R.id.fragment1);




            noteRef.get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()){
                                String title = documentSnapshot.getString(KEY_TITLE);
                                String description = documentSnapshot.getString(KEY_DESCRIPTION);

                                //Map<String, Object> note = documentSnapshot.getData();

                                fragment1.setText(description);
                            }else {
                                Toast.makeText(getActivity(), "Document does not exist", Toast.LENGTH_SHORT).show();
                            }

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), "Error!", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, e.toString());

                        }
                    });


        return  view;
    }

}
