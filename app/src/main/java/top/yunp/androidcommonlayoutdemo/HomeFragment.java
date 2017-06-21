package top.yunp.androidcommonlayoutdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import top.yunp.androidcommonlayoutdemo.databinding.FragmentHomeBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater);
        binding.viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {

            private List<VPFragment> fragments = Arrays.asList(new VP1Fragment(), new VP2Fragment(), new VP3Fragment());

            @Override
            public VPFragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getItem(position).getTitle();
            }
        });
        binding.tab.setupWithViewPager(binding.viewPager);
        return binding.getRoot();
    }

}
