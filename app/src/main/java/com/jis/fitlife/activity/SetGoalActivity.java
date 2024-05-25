package com.jis.fitlife.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jis.fitlife.R;

public class SetGoalActivity extends AppCompatActivity {
    public static float mSeries = 0f;
    public static float mSeries1 = 0f;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setgoal);


        final EditText stepGoal = findViewById(R.id.et1);
        final EditText calorieGoal = findViewById(R.id.et2);

        Button setgoal = findViewById(R.id.setgoal);
        setgoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stepGoal.getText().toString().length() == 0) {
                    stepGoal.setError("Set Steps Goal");
                    return;
                } else if (calorieGoal.getText().toString().length() == 0) {
                    calorieGoal.setError("Set Calorie Goal!");
                    return;
                }else {
                    mSeries = Float.parseFloat(String.valueOf(stepGoal.getText().toString()));
                    mSeries1 = Float.parseFloat(String.valueOf(calorieGoal.getText().toString()));
                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                            .putFloat("stepgoal", mSeries).commit();
                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                            .putFloat("caloriegoal", mSeries1).commit();
                    Intent myIntent = new Intent(SetGoalActivity.this, MainActivity.class);
                    startActivity(myIntent);
                }


             /*  mDatabase.child("Users").child(userId).child("stepgoal").setValue(stepGoal.getText().toString());
                mDatabase.child("Users").child(userId).child("caloriegoal").setValue(calorieGoal.getText().toString());

                mDatabase.child("Users").child(userId).child("stepgoal").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        mSeries = Float.parseFloat(String.valueOf(dataSnapshot.getValue()));
                        Log.d("mSeries", (String.valueOf(mSeries)));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

                mDatabase.child("Users").child(userId).child("caloriegoal").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        mSeries1 = Float.parseFloat(String.valueOf(dataSnapshot.getValue()));
                        Log.d("mSeries1", (String.valueOf(mSeries1)));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
*/

            }
        });

    }

}

