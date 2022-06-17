package nhom07.hcmute.zaloapp.Onboarding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import nhom07.hcmute.zaloapp.Home.HomeActivity;
import nhom07.hcmute.zaloapp.R;

public class SignupActivity extends AppCompatActivity {


    TextView txtLogin;
    Button btnSignup, btnGenerateOTP;
    FirebaseAuth mAuth;
    String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        txtLogin = (TextView) findViewById(R.id.textView_Login);
        btnSignup = (Button) findViewById(R.id.button_signup);
        btnGenerateOTP = (Button) findViewById(R.id.btnGenerateOTP);

        final EditText edtUserName = findViewById(R.id.editText_Username);
        final EditText edtPhoneNumber = findViewById(R.id.editText_PhoneNumber);
        final EditText edtPassword = findViewById(R.id.editText_Password);
        final EditText edtConfirmPassword = findViewById(R.id.editText_ConfirmPassword);
        final EditText edtOTP = findViewById(R.id.editText_OTP);

        btnGenerateOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edtPhoneNumber.getText().toString())) {
                    Toast.makeText(SignupActivity.this, "Xin vui lòng điền số điện thoại", Toast.LENGTH_SHORT).show();
                }
                else {
                    String number = edtPhoneNumber.getText().toString();
                    sendVerificationCode(number);
                }
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edtOTP.getText().toString())) {
                    Toast.makeText(SignupActivity.this, "Xin hãy điền vào mã OTP từ tin nhắn", Toast.LENGTH_SHORT).show();
                }
                else {
                    verifyVerificationCode(edtOTP.getText().toString());
                }
            }
        });

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void verifyVerificationCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        loginByCredentials(credential);
    }

    private void loginByCredentials(PhoneAuthCredential credential) {
        FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignupActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                });
    }

    private void sendVerificationCode(String phoneNumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+84"+phoneNumber) // Automatically converts phone number to Viet Nam locale
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private final PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {
            // This callback will be invoked in two situations:
            // 1 - Instant verification. In some cases the phone number can be instantly
            //     verified without needing to send or enter a verification code.
            // 2 - Auto-retrieval. On some devices Google Play services can automatically
            //     detect the incoming verification SMS and perform verification without
            //     user action.
            Log.d(null, "onVerificationCompleted:" + credential);

            final String code = credential.getSmsCode();
            if (code != null) {
                verifyVerificationCode(code);
            }

            // signInWithPhoneAuthCredential(credential);
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            // This callback is invoked in an invalid request for verification is made,
            // for instance if the the phone number format is not valid.
            Log.w(null, "onVerificationFailed", e);

            Toast.makeText(SignupActivity.this, "Xác thực SMS OTP thất bại", Toast.LENGTH_SHORT).show();

            if (e instanceof FirebaseAuthInvalidCredentialsException) {
                // Invalid request
            } else if (e instanceof FirebaseTooManyRequestsException) {
                // The SMS quota for the project has been exceeded
            }

            // Show a message and update the UI
        }

        @Override
        public void onCodeSent(@NonNull String _verificationId,
                               @NonNull PhoneAuthProvider.ForceResendingToken token) {
            // The SMS verification code has been sent to the provided phone number, we
            // now need to ask the user to enter the code and then construct a credential
            // by combining the code with a verification ID.
            verificationId = _verificationId;

            Log.d(null, "onCodeSent:" + verificationId);

            super.onCodeSent(verificationId, token);

            // Save verification ID and resending token so we can use them later
            // mVerificationId = verificationId;
            // mResendToken = token;
        }
    };
}