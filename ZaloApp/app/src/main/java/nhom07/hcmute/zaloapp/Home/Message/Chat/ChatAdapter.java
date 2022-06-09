package nhom07.hcmute.zaloapp.Home.Message.Chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nhom07.hcmute.zaloapp.R;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private List<Chat> mListChats;
    private Context mContext;

    public ChatAdapter(Context context, List<Chat> mListChat){
        this.mContext = context;
        this.mListChats = mListChat;
    }


    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        return new ChatAdapter.ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        Chat chat = mListChats.get(position);
        if(chat == null){
            return;
        }
        holder.imgAvt.setImageResource(chat.getAvatar());
        holder.tvDisplayName.setText(chat.getDisplayName());
        holder.tvMessage.setText(chat.getMessage());
        holder.tvTime.setText(chat.getTime());
        holder.tvNotificationNumber.setText(chat.getNotificationNumber());

        holder.layoutItemChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickGoToChatActivity(chat);
            }

        });

    }

    private void OnClickGoToChatActivity(Chat chat) {
        Intent intent = new Intent(mContext, ChatActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_chat", chat);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if(mListChats != null){
            return mListChats.size();
        }
        return 0;
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout layoutItemChat;
        private ImageView imgAvt;
        private TextView tvDisplayName;
        private TextView tvMessage;
        private TextView tvTime;
        private TextView tvNotificationNumber;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItemChat = itemView.findViewById(R.id.layout_item_chat);
            imgAvt = itemView.findViewById(R.id.imageView_Avatar);
            tvDisplayName  = itemView.findViewById(R.id.textView_DisplayName);
            tvMessage = itemView.findViewById(R.id.textView_MessageContent);
            tvTime = itemView.findViewById(R.id.textView_Time);
            tvNotificationNumber = itemView.findViewById(R.id.textView_NotificationNumber);

        }
    }
}
