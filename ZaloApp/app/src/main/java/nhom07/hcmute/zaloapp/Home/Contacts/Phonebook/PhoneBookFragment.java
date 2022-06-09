package nhom07.hcmute.zaloapp.Home.Contacts.Phonebook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nhom07.hcmute.zaloapp.Home.Contacts.Phonebook.PhoneBookUser.PhoneBookUserAdapter;
import nhom07.hcmute.zaloapp.Home.Contacts.Phonebook.PhoneBookUser.PhoneBookUser;
import nhom07.hcmute.zaloapp.R;


public class PhoneBookFragment extends Fragment {

    private RecyclerView rcvPhoneBook;
    private PhoneBookUserAdapter phoneBookUserAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phone_book, container, false);

        ////////////  LOAD RECYCLE VIEW PHONEBOOK  //////////////////////////////////////////////////
        rcvPhoneBook = view.findViewById(R.id.rcv_PhoneBook);
        rcvPhoneBook.setLayoutManager(new LinearLayoutManager(this.getContext()));

        phoneBookUserAdapter = new PhoneBookUserAdapter(getListPhoneBook());

        rcvPhoneBook.setAdapter(phoneBookUserAdapter);
        ////////////////////////////////////////////////////////////////////////////////////////////

        return view;
    }

    private List<PhoneBookUser> getListPhoneBook() {

        List<PhoneBookUser> list = new ArrayList<>();

        list.add(new PhoneBookUser(R.drawable.imguser_avatar, "Singapore Lion", "My Huyen Ho", "0355876942", true));
        list.add(new PhoneBookUser(R.drawable.img_avt_1, "Thy Tran", "Duong Hoang Thy Tran", "0855876942", true));
        list.add(new PhoneBookUser(R.drawable.img_avt_2, "Nhu khu B", "Nguyen Ngoc Nhu", "0355876942", false));
        list.add(new PhoneBookUser(R.drawable.imguser_avatar, "Singapore Lion", "My Huyen Ho", "0355876942", true));
        list.add(new PhoneBookUser(R.drawable.img_avt_1, "Thy Tran", "Duong Hoang Thy Tran", "0855876942", true));
        list.add(new PhoneBookUser(R.drawable.img_avt_2, "Nhu khu B", "Nguyen Ngoc Nhu", "0355876942", false));
        list.add(new PhoneBookUser(R.drawable.imguser_avatar, "Singapore Lion", "My Huyen Ho", "0355876942", true));
        list.add(new PhoneBookUser(R.drawable.img_avt_1, "Thy Tran", "Duong Hoang Thy Tran", "0855876942", true));
        list.add(new PhoneBookUser(R.drawable.img_avt_2, "Nhu khu B", "Nguyen Ngoc Nhu", "0355876942", false));

        return list;

    }
}