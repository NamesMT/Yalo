package nhom07.hcmute.zaloapp.UserSearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

import nhom07.hcmute.zaloapp.R;
import nhom07.hcmute.zaloapp.UserSearch.UserSearchAdapter;
import nhom07.hcmute.zaloapp.UserSearch.UserSearch;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView rcvUserSearch;
    private UserSearchAdapter userSearchAdapter;

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.primary)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //LOAD RECYCLE VIEW USER SEARCH
        ///////////////////////////////////////////////////////////////////////////////////////////////
        rcvUserSearch = findViewById(R.id.rcv_UserSearch);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUserSearch.setLayoutManager(linearLayoutManager);

        userSearchAdapter = new UserSearchAdapter(this, getListUserSearch());
        rcvUserSearch.setAdapter(userSearchAdapter);
        ///////////////////////////////////////////////////////////////////////////////////////////////

    }


    private List<UserSearch> getListUserSearch() {
        List<UserSearch> list = new ArrayList<>();

        list.add(new UserSearch(R.drawable.imguser_avatar, "Thy Tran Duong", "0355876942", true));
        list.add(new UserSearch(R.drawable.img_avt_1, "Huyen Ho", "0913197922", true));
        list.add(new UserSearch(R.drawable.img_avt_2, "Ngoc Nhu Nguyen", "0786171831", false));
        list.add(new UserSearch(R.drawable.imguser_avatar, "Duong Hoang Thy Tran", "0769842084", true));

        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_UserSearch).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setBackgroundResource(R.color.primary);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                userSearchAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                userSearchAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }
}