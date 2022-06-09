package nhom07.hcmute.zaloapp.Home.Contacts.Friend.FriendUser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import nhom07.hcmute.zaloapp.Home.Message.User.User;

import java.util.List;

import nhom07.hcmute.zaloapp.R;

public class FriendUserAdapter extends RecyclerView.Adapter<FriendUserAdapter.FriendUserViewHolder>{


    private List<User> mListUsers;

    public FriendUserAdapter(List<User> mListUsers){

        this.mListUsers = mListUsers;
    }

    @NonNull
    @Override
    public FriendUserAdapter.FriendUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend_user, parent, false);
        return new FriendUserAdapter.FriendUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendUserViewHolder holder, int position) {
        User user = mListUsers.get(position);
        if(user == null){
            return;
        }
        holder.imgAvt.setImageResource(user.getAvatar());
        holder.tvDisplayName.setText(user.getDisplayName());
    }


    @Override
    public int getItemCount() {
        if(mListUsers != null){
            return mListUsers.size();
        }
        return 0;
    }


    public class FriendUserViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgAvt;
        private TextView tvDisplayName;

        public FriendUserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvt = itemView.findViewById(R.id.imageView_Avatar);
            tvDisplayName  = itemView.findViewById(R.id.textView_DisplayName);
        }
    }

}
