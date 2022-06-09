package nhom07.hcmute.zaloapp.Home.Message.User;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nhom07.hcmute.zaloapp.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {


    private List<User> mListUsers;

    public UserAdapter(List<User> mListUsers){

        this.mListUsers = mListUsers;
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserAdapter.UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {

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


    public class UserViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgAvt;
        private TextView tvDisplayName;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvt = itemView.findViewById(R.id.imageView_Avatar);
            tvDisplayName  = itemView.findViewById(R.id.textView_DisplayName);
        }
    }



}
