package com.ddd.materialcomponents.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ddd.materialcomponents.R;
import com.ddd.materialcomponents.databinding.FragmentHomeBinding;
import com.ddd.materialcomponents.model.HomeModel;
import com.ddd.materialcomponents.ui.activity.HomeActivity;
import com.ddd.materialcomponents.ui.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by S.C. on 21/05/18.
 */

public class HomeFragment extends Fragment implements HomeAdapter.OnClickListener {
    private FragmentHomeBinding binding;
    private final String BUNDLE_ID = "BUNDLE_ID";
    private List<HomeModel> homeList = new ArrayList<>();


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
    }

    private void initView() {
        homeList.add(new HomeModel(R.drawable.house1, R.string.desc1, R.string.property1_name));
        homeList.add(new HomeModel(R.drawable.house2, R.string.desc2, R.string.property2_name));
        homeList.add(new HomeModel(R.drawable.house3, R.string.desc3, R.string.property3_name));

        final HomeAdapter adapter = new HomeAdapter(getActivity(), homeList, this);
        binding.rvHome.hasFixedSize();
        binding.rvHome.setAdapter(adapter);
    }

    @Override
    public void onClick(int position) {
        final DetailsFragment detailsFragment = new DetailsFragment();
        final Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_ID, homeList.get(position));
        detailsFragment.setArguments(bundle);

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.flContainerHome, detailsFragment)
                .addToBackStack(SignupFragment.class.getSimpleName())
                .hide(HomeFragment.this)
                .commit();
        ((HomeActivity) getActivity()).detachFab();
        ((HomeActivity) getActivity()).moveToDetails();
    }
}