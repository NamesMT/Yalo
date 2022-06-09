package nhom07.hcmute.zaloapp.Home.Contacts.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import nhom07.hcmute.zaloapp.Home.Contacts.Friend.FriendFragment;
import nhom07.hcmute.zaloapp.Home.Contacts.Phonebook.PhoneBookFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new FriendFragment();
            case 1:
                return new PhoneBookFragment();

            default:
                return new FriendFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Friends";
                break;
            case 1:
                title = "Phonebook";
                break;
        }
        return title;
    }
}
