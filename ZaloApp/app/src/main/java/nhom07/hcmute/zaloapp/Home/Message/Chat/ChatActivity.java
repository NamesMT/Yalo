package nhom07.hcmute.zaloapp.Home.Message.Chat;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import nhom07.hcmute.zaloapp.Home.Message.Chat.Chat;
import nhom07.hcmute.zaloapp.R;

public class ChatActivity extends AppCompatActivity {

    private ImageView imgAvt;
    private TextView tvDisplayName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

        //MAPPING
        imgAvt = findViewById(R.id.imageView_Avatar);
        tvDisplayName = findViewById(R.id.textView_DisplayName);


        //Click Chat item -> Go to Chat Activity
        ///////////////////////////////////////////////////////////////////////////////////////////////
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Chat chat = (Chat) bundle.get("object_chat") ;

        //Mapping...............

        //Set Data
        imgAvt.setImageResource(chat.getAvatar());
        tvDisplayName.setText(chat.getDisplayName());

        ////////////////////////////////////////////////////////////////////////////////////////////////

    }
}