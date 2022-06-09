package nhom07.hcmute.zaloapp.Home.Contacts;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;

import nhom07.hcmute.zaloapp.Home.Contacts.Adapter.ViewPagerAdapter;
import nhom07.hcmute.zaloapp.R;
import nhom07.hcmute.zaloapp.UserSearch.SearchActivity;


public class ContactsFragment extends Fragment {

    private LinearLayout layoutSearch;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        //Layout Search OnClick
        LinearLayout layoutSearch = view.findViewById(R.id.layout_Search);
        layoutSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), SearchActivity.class);
                startActivity(in);
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////////

        TabLayout mTabLayout = view.findViewById(R.id.tab_Layout);
        ViewPager mViewPager = view.findViewById(R.id.view_Pager);


        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);


        return view;

    }
}