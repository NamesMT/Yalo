package nhom07.hcmute.zaloapp.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import nhom07.hcmute.zaloapp.Home.Account.AccountFragment;
import nhom07.hcmute.zaloapp.Home.Contacts.ContactsFragment;
import nhom07.hcmute.zaloapp.Home.Message.MessageFragment;
import nhom07.hcmute.zaloapp.R;

public class HomeActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        //BOTTOM NAVIGATION

        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_message));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_contact));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_person));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()){
                    case 1:
                        fragment = new MessageFragment();
                        break;
                    case 2:
                        fragment = new ContactsFragment();
                        break;
                    case 3:
                        fragment = new AccountFragment();
                        break;
                }
                loadFragment(fragment);

            }
        });

        //set notification count
        bottomNavigation.setCount(1,"10");
        //set home fragment initially selected
        bottomNavigation.show(1, true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext()
                        , "You Clicked " + item.getId()
                        , Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext()
                        , "You Reselected " + item.getId()
                        , Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }
}