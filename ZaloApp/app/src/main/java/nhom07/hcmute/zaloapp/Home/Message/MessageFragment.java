package nhom07.hcmute.zaloapp.Home.Message;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;



import java.util.ArrayList;
import java.util.List;

import nhom07.hcmute.zaloapp.Home.Message.Chat.ChatAdapter;
import nhom07.hcmute.zaloapp.R;
import nhom07.hcmute.zaloapp.UserSearch.SearchActivity;
import nhom07.hcmute.zaloapp.Home.Message.User.UserAdapter;
import nhom07.hcmute.zaloapp.Home.Message.Chat.Chat;
import nhom07.hcmute.zaloapp.Home.Message.User.User;


public class MessageFragment extends Fragment {


    private RecyclerView rcvChatBox;
    private ChatAdapter chatAdapter;

    private RecyclerView rcvUsers;
    private UserAdapter userAdapter;

    private LinearLayout layoutSearch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_message, container, false);

        ////////////  LOAD RECYCLE VIEW CHAT BOX  //////////////////////////////////////////////////
        rcvChatBox = view.findViewById(R.id.rcv_ChatBox);
        rcvChatBox.setLayoutManager(new LinearLayoutManager(this.getContext()));

        chatAdapter = new ChatAdapter(this.getContext(),getListChats());

        rcvChatBox.setAdapter(chatAdapter);
        ////////////////////////////////////////////////////////////////////////////////////////////


        ////////////  LOAD RECYCLE VIEW USER  //////////////////////////////////////////////////
        rcvUsers = view.findViewById(R.id.rcv_Users);
        rcvUsers.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false));

        userAdapter = new UserAdapter(getListUsers());

        rcvUsers.setAdapter(userAdapter);
        ////////////////////////////////////////////////////////////////////////////////////////////


        ////////////  LOAD SEARCH ACTIVITY  //////////////////////////////////////////////////
        LinearLayout layoutSearch = view.findViewById(R.id.layout_Search);
        layoutSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), SearchActivity.class);
                startActivity(in);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////


        return view;
    }

    //ADD LIST USERS
    private List<User> getListUsers() {
        List<User> list = new ArrayList<>();

        list.add(new User(R.drawable.imguser_avatar, "Thy Tran"));
        list.add(new User(R.drawable.img_avt_1, "Mai Ngan"));
        list.add(new User(R.drawable.img_avt_2, "My Huyen"));
        list.add(new User(R.drawable.img_avt_3, "Ngoc Nhu"));
        list.add(new User(R.drawable.img_avt_4, "Khanh Ngan"));
        list.add(new User(R.drawable.imguser_avatar, "Thy Tran"));
        list.add(new User(R.drawable.img_avt_1, "Mai Ngan"));
        list.add(new User(R.drawable.img_avt_2, "My Huyen"));
        list.add(new User(R.drawable.img_avt_3, "Ngoc Nhu"));
        list.add(new User(R.drawable.img_avt_4, "Khanh Ngan"));
        list.add(new User(R.drawable.imguser_avatar, "Thy Tran"));
        list.add(new User(R.drawable.img_avt_1, "Mai Ngan"));
        list.add(new User(R.drawable.img_avt_2, "My Huyen"));
        list.add(new User(R.drawable.img_avt_3, "Ngoc Nhu"));
        list.add(new User(R.drawable.img_avt_4, "Khanh Ngan"));



        return list;
    }

    //ADD LIST CHATS
    private List<Chat> getListChats() {
        List<Chat> list = new ArrayList<>();

        list.add(new Chat(R.drawable.imguser_avatar, "Duong Hoang Thy Tran", "Ok. I'm fine. What about you?", "1 hours", "2"));
        list.add(new Chat(R.drawable.img_avt_1, "Le Hoang Mai Ngan", "Hey, do you want to go see a movie tonight?", "1 day", "1"));
        list.add(new Chat(R.drawable.img_avt_2, "My Huyen", "Ok. I'm fine. What about you?", "1 hours", "2"));
        list.add(new Chat(R.drawable.img_avt_3, "Ngoc Nhu", "Hey, do you want to go see a movie tonight?", "1 day", "1"));
        list.add(new Chat(R.drawable.img_avt_4, "Khanh Ngan", "Ok. I'm fine. What about you?", "1 hours", "2"));
        list.add(new Chat(R.drawable.imguser_avatar, "Duong Hoang Thy Tran", "Ok. I'm fine. What about you?", "1 hours", "2"));
        list.add(new Chat(R.drawable.img_avt_1, "Le Hoang Mai Ngan", "Hey, do you want to go see a movie tonight?", "1 day", "1"));
        list.add(new Chat(R.drawable.img_avt_2, "My Huyen", "Ok. I'm fine. What about you?", "1 hours", "2"));
        list.add(new Chat(R.drawable.img_avt_3, "Ngoc Nhu", "Hey, do you want to go see a movie tonight?", "1 day", "1"));
        list.add(new Chat(R.drawable.img_avt_4, "Khanh Ngan", "Ok. I'm fine. What about you?", "1 hours", "2"));

        return list;
    }

}