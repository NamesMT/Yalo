package nhom07.hcmute.zaloapp.Onboarding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import nhom07.hcmute.zaloapp.Home.HomeActivity;
import nhom07.hcmute.zaloapp.R;

public class SignupActivity extends AppCompatActivity {


    TextView txtLogin;
    Button btnSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txtLogin = (TextView) findViewById(R.id.textView_Login);
        btnSignup = (Button) findViewById(R.id.button_signup);

        final EditText edtUserName = findViewById(R.id.editText_Username);
        final EditText edtPhoneNumber = findViewById(R.id.editText_PhoneNumber);
        final EditText edtPassword = findViewById(R.id.editText_Password);
        final EditText edtConfirmPassword = findViewById(R.id.editText_ConfirmPassword);

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });

    }
}