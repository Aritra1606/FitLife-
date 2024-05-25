package com.jis.fitlife.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jis.fitlife.R;

import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class BasicInfoFragment extends Fragment {

    int position;


    public BasicInfoFragment() {
    }

    public static BasicInfoFragment newInstance() {
        BasicInfoFragment fragment = new BasicInfoFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle s) {
        super.onCreate(s);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_basicinfo, container, false);
        final OnFloatingButtonClickListener mListener;

        try {
            mListener = (OnFloatingButtonClickListener) getContext();
            Log.d("mContext is ", getContext().toString());
        } catch (ClassCastException ex) {
            throw new ClassCastException("The hosting activity of the fragment" +
                    "forgot to implement onFragmentInteractionListener");
        }

        final Button next = rootView.findViewById(R.id.nextbutton);

        final FloatingActionButton fab1 = getActivity().findViewById(R.id.next);
        final EditText nameET = rootView.findViewById(R.id.nameInput);
        final EditText phoneET = rootView.findViewById(R.id.phoneInput);
        final EditText ageET = rootView.findViewById(R.id.ageInput);
        final EditText weightET = rootView.findViewById(R.id.weightInput);
        final EditText heightET = rootView.findViewById(R.id.heightInput);

        final RadioGroup myRadioGroup = rootView.findViewById(R.id.genderGroup);
        myRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                position = myRadioGroup.indexOfChild(rootView.findViewById(checkedId));
                if (position == 0) {
                    Log.d("Gender is ", "Male");
                  //  getUsersRef("gender").setValue("Male");
                } else {
                    Log.d("Gender is ", "Female");
                   // getUsersRef("gender").setValue("Female");
                }
            }
        });

        ImageView userPhoto = (ImageView) getActivity().findViewById(R.id.userPhoto);
        userPhoto.setImageResource(R.drawable.runimage);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameET.getText().toString().length() == 0) {
                    nameET.setError("Name is required!");
                    return;
                }
                mListener.onFloatingButtonClicked();

                getActivity().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
                        .putString("name", nameET.getText().toString().trim()).commit();
                getActivity().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
                        .putString("phone", phoneET.getText().toString().trim()).commit();
                getActivity().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
                        .putString("age", ageET.getText().toString().trim()).commit();
                getActivity().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
                        .putString("height", heightET.getText().toString().trim()).commit();
                getActivity().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
                        .putString("weight", weightET.getText().toString().trim()).commit();

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameET.getText().toString().length() == 0) {
                    nameET.setError("Name is required!");
                    return;
                }
                mListener.onFloatingButtonClicked();
                getActivity().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
                        .putString("name", nameET.getText().toString().trim()).commit();
                getActivity().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
                        .putString("phone", phoneET.getText().toString().trim()).commit();
                getActivity().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
                        .putString("age", ageET.getText().toString().trim()).commit();
                getActivity().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
                        .putString("height", heightET.getText().toString().trim()).commit();
                getActivity().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
                        .putString("weight", weightET.getText().toString().trim()).commit();
            }
        });



        return rootView;
    }

    public interface OnFloatingButtonClickListener {
        public void onFloatingButtonClicked();
    }
}


