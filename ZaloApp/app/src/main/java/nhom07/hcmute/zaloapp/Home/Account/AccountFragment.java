package nhom07.hcmute.zaloapp.Home.Account;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

import nhom07.hcmute.zaloapp.Onboarding.LoginActivity;
import nhom07.hcmute.zaloapp.Home.Account.Profile.ProfileActivity;
import nhom07.hcmute.zaloapp.R;


public class AccountFragment extends Fragment {

    FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();

        View view = inflater.inflate(R.layout.fragment_account, container, false);

        LinearLayout linearLayoutProfile = (LinearLayout) view.findViewById(R.id.layout_Profile);
        linearLayoutProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), ProfileActivity.class);
                startActivity(in);
            }
        });

        LinearLayout linearLayoutSwitch = (LinearLayout) view.findViewById(R.id.layout_Switch);
        linearLayoutSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), LoginActivity.class);
                startActivity(in);
            }
        });

        LinearLayout linearLayoutLogout = (LinearLayout) view.findViewById(R.id.layout_Logout);
        linearLayoutLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent in = new Intent(getActivity(), LoginActivity.class);
                startActivity(in);
                getActivity().finish();
            }
        });


        return view;
    }
}