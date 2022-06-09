package nhom07.hcmute.zaloapp.Onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import nhom07.hcmute.zaloapp.Home.HomeActivity;
import nhom07.hcmute.zaloapp.R;

public class LoginActivity extends AppCompatActivity {

    TextView txtSignup;

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtSignup = (TextView) findViewById(R.id.textView_Signup);
        btnLogin = (Button) findViewById(R.id.button_login);

        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}