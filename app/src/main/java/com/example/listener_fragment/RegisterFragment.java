package com.example.listener_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment {

    private OnRegisterListener listener;

    public interface OnRegisterListener {
        void onRegister(User user);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRegisterListener) {
            listener = (OnRegisterListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement RegisterFragment.OnRegisterListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        EditText edtName = view.findViewById(R.id.edtName);
        EditText edtEmail = view.findViewById(R.id.edtEmail);
        EditText edtPassword = view.findViewById(R.id.edtPassword);
        Button btnRegister = view.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                User user = new User(name, email, password);
                listener.onRegister(user);
            }
        });

        return view;
    }
}