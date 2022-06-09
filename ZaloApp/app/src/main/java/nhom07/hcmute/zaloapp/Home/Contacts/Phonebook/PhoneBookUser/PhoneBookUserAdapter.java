package nhom07.hcmute.zaloapp.Home.Contacts.Phonebook.PhoneBookUser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nhom07.hcmute.zaloapp.R;

public class PhoneBookUserAdapter extends RecyclerView.Adapter<PhoneBookUserAdapter.PhoneBookUserViewHolder>{

    private List<PhoneBookUser> mListPhoneBookUser;

    public PhoneBookUserAdapter(List<PhoneBookUser> mListPhoneBookUser){
        this.mListPhoneBookUser = mListPhoneBookUser;
    }

    @NonNull
    @Override
    public PhoneBookUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phone_book_user, parent, false);
        return new PhoneBookUserAdapter.PhoneBookUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneBookUserViewHolder holder, int position) {

        PhoneBookUser phoneBookUser = mListPhoneBookUser.get(position);
        if(phoneBookUser == null){
            return;
        }
        holder.imgAvt.setImageResource(phoneBookUser.getAvatar());
        holder.tvName.setText(phoneBookUser.getName());
        holder.tvDisplayName.setText(phoneBookUser.getDisplayName());
        holder.tvPhoneNumber.setText(phoneBookUser.getPhoneNumber());
        holder.btnAddFriend.setEnabled(phoneBookUser.getAddFriend());

    }

    @Override
    public int getItemCount() {
        if(mListPhoneBookUser != null){
            return mListPhoneBookUser.size();
        }
        return 0;
    }

    public class PhoneBookUserViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgAvt;
        private TextView tvName;
        private TextView tvDisplayName;
        private TextView tvPhoneNumber;
        private Button btnAddFriend;


        public PhoneBookUserViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAvt = itemView.findViewById(R.id.imageView_Avatar);
            tvName  = itemView.findViewById(R.id.textView_Name);
            tvDisplayName  = itemView.findViewById(R.id.textView_DisplayName);
            tvPhoneNumber = itemView.findViewById(R.id.textView_PhoneNumber);
            btnAddFriend = itemView.findViewById(R.id.button_AddFriend);

        }
    }
}
