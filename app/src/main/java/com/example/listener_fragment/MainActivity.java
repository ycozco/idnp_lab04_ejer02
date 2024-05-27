package com.example.listener_fragment;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements RegisterFragment.OnRegisterListener {

    private TextView txtMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMensaje = findViewById(R.id.txtMensaje);

        RegisterFragment registerFragment = new RegisterFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, registerFragment);
        transaction.commit();
    }

    @Override
    public void onRegister(User user) {
        String userInfo = "Name: " + user.getName() + ", Email: " + user.getEmail() + ", Password: " + user.getPassword();
        txtMensaje.setText(userInfo);
    }
}