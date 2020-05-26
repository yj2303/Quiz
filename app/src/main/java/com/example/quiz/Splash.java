package com.example.quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splash extends Fragment {

    private ProgressBar start_progress;
    private TextView start_feedback;
    private FirebaseAuth firebaseAuth;
    private static final String Start_tag="START_LOG";
    private NavController navController;



    public Splash() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        start_progress= view.findViewById(R.id.startprogress);
        start_feedback = view.findViewById(R.id.startprogress);
        firebaseAuth = FirebaseAuth.getInstance();
        navController = Navigation.findNavController(view);
        start_feedback.setText("Checking User Account");

    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentuser = firebaseAuth.getCurrentUser();
        if(currentuser == null){

            start_feedback.setText("Creating Account");
            firebaseAuth.signInAnonymously().addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        start_feedback.setText("Account Created");
                        navController.navigate(R.id.action_splash_to_allquestion);
                    }
                    else{
                        Log.d(Start_tag,"Start log : " + task.getException());

                    }
                }
            });
        }
        else
            {
                start_feedback.setText("Account Created");
                navController.navigate(R.id.action_splash_to_allquestion);


        }
    }
}
