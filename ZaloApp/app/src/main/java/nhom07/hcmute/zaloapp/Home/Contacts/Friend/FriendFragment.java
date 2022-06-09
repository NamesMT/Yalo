package nhom07.hcmute.zaloapp.Home.Contacts.Friend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nhom07.hcmute.zaloapp.Home.Contacts.Friend.FriendUser.FriendUserAdapter;
import nhom07.hcmute.zaloapp.R;
import nhom07.hcmute.zaloapp.Home.Message.User.User;


public class FriendFragment extends Fragment {

    private RecyclerView rcvFriendUser;
    private FriendUserAdapter friendUserAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend, container, false);

        ////////////  LOAD RECYCLE VIEW FRIEND USER  //////////////////////////////////////////////////
        rcvFriendUser = view.findViewById(R.id.rcv_FriendUser);
        rcvFriendUser.setLayoutManager(new LinearLayoutManager(this.getContext()));

        friendUserAdapter = new FriendUserAdapter(getListFriendUser());

        rcvFriendUser.setAdapter(friendUserAdapter);
        ////////////////////////////////////////////////////////////////////////////////////////////

        return view;
    }

    private List<User> getListFriendUser() {
        List<User> list = new ArrayList<>();

        list.add(new User(R.drawable.imguser_avatar, "Thy Tran"));
        list.add(new User(R.drawable.img_avt_1, "Ngoc Nhu"));
        list.add(new User(R.drawable.imguser_avatar, "My Huyen"));
        list.add(new User(R.drawable.img_avt_1, "Ngoc Nhu"));
        list.add(new User(R.drawable.imguser_avatar, "Thy Tran"));
        list.add(new User(R.drawable.img_avt_1, "Ngoc Nhu"));
        list.add(new User(R.drawable.imguser_avatar, "Thy Tran"));
        list.add(new User(R.drawable.img_avt_1, "Ngoc Nhu"));
        list.add(new User(R.drawable.imguser_avatar, "My Huyen"));
        list.add(new User(R.drawable.img_avt_1, "Ngoc Nhu"));
        list.add(new User(R.drawable.imguser_avatar, "Thy Tran"));
        list.add(new User(R.drawable.img_avt_1, "Ngoc Nhu"));

        return list;

    }


}