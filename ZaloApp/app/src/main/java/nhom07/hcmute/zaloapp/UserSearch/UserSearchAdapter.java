package nhom07.hcmute.zaloapp.UserSearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import nhom07.hcmute.zaloapp.R;

import java.util.ArrayList;
import java.util.List;

public class UserSearchAdapter extends RecyclerView.Adapter<UserSearchAdapter.UserSearchViewHolder> implements Filterable {

    private List<UserSearch> mListUserSearch;
    private List<UserSearch> mListUserSearchOld;

    public UserSearchAdapter(SearchActivity searchActivity, List<UserSearch> mListUserSearch){
        this.mListUserSearch = mListUserSearch;
        this.mListUserSearchOld= mListUserSearch;
    }

    @NonNull
    @Override
    public UserSearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_search, parent, false);
        return new UserSearchAdapter.UserSearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserSearchViewHolder holder, int position) {

        UserSearch userSearch = mListUserSearch.get(position);
        if(userSearch == null){
            return;
        }
        holder.imgAvt.setImageResource(userSearch.getAvatar());
        holder.tvDisplayName.setText(userSearch.getDisplayName());
        holder.tvPhoneNumber.setText(userSearch.getPhoneNumber());
        holder.btnAddFriend.setEnabled(userSearch.getAddFriend());

    }

    @Override
    public int getItemCount() {
        if(mListUserSearch != null){
            return mListUserSearch.size();
        }
        return 0;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String strSearch = charSequence.toString();

                if (strSearch.isEmpty()){
                    mListUserSearch = mListUserSearchOld;
                }else {
                    List<UserSearch> list = new ArrayList<>();
                    for(UserSearch userSearch : mListUserSearchOld){
                        if(userSearch.getDisplayName().toLowerCase().contains(strSearch.toLowerCase())
                                || userSearch.getPhoneNumber().contains(strSearch)){

                            list.add(userSearch);

                        }
                    }

                    mListUserSearch = list;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mListUserSearch;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                mListUserSearch = (List<UserSearch>) filterResults.values;
                notifyDataSetChanged();


            }
        };
    }

    public class UserSearchViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgAvt;
        private TextView tvDisplayName;
        private TextView tvPhoneNumber;
        private Button btnAddFriend;

        public UserSearchViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAvt = itemView.findViewById(R.id.imageView_Avatar);
            tvDisplayName  = itemView.findViewById(R.id.textView_DisplayName);
            tvPhoneNumber = itemView.findViewById(R.id.textView_PhoneNumber);
            btnAddFriend = itemView.findViewById(R.id.button_AddFriend);

        }
    }
}
