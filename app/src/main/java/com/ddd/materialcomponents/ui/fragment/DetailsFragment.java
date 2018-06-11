package com.ddd.materialcomponents.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.chip.ChipGroup;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AnticipateInterpolator;
import android.widget.Toast;

import com.ddd.materialcomponents.R;
import com.ddd.materialcomponents.databinding.FragmentDetailBinding;
import com.ddd.materialcomponents.model.HomeModel;

/**
 * Created by S.C. on 21/05/18.
 */

public class DetailsFragment extends Fragment implements ChipGroup.OnCheckedChangeListener {
    private final String BUNDLE_ID = "BUNDLE_ID";
    private boolean isRevealed;
    private FragmentDetailBinding binding;
    private HomeModel homeList = new HomeModel();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        homeList = getArguments().getParcelable(BUNDLE_ID);
        initView();
    }

    private void initView() {
        binding.tvProperty.setText(homeList.getPropertyName());
        binding.tvDescription.setText(homeList.getDescription());
        binding.ivProperty.setImageResource(homeList.getImage());


        binding.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isRevealed) {
                    binding.fabAdd.setImageResource(R.drawable.ic_remove);
                    int w = binding.hsvChip.getWidth();
                    int h = binding.hsvChip.getHeight();
                    final int endRadius = (int) Math.hypot(w, h);
                    final int cy = (binding.hsvChip.getBottom() + binding.hsvChip.getTop()) / 2;

                    final Animator revealAnimator = ViewAnimationUtils.createCircularReveal(binding.hsvChip, 0, cy, 0, endRadius);
                    revealAnimator.setDuration(700);
                    revealAnimator.setInterpolator(new AnticipateInterpolator());
                    revealAnimator.start();
                    binding.cgChips.setVisibility(View.VISIBLE);
                    isRevealed = true;
                } else {
                    int w = binding.hsvChip.getWidth();
                    int h = binding.hsvChip.getHeight();
                    final int endRadius = (int) Math.hypot(w, h);
                    final int cy = (binding.hsvChip.getBottom() + binding.hsvChip.getTop()) / 2;

                    final Animator revealAnimator = ViewAnimationUtils.createCircularReveal(binding.hsvChip, 0, cy, endRadius, 0);
                    revealAnimator.setDuration(700);
                    revealAnimator.setInterpolator(new AnticipateInterpolator());
                    revealAnimator.start();
                    revealAnimator.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            binding.fabAdd.setImageResource(R.drawable.ic_add);
                            binding.cgChips.setVisibility(View.GONE);
                        }
                    });
                    isRevealed = false;
                }
            }
        });

        binding.cgChips.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(ChipGroup group, int checkedId) {
        Toast.makeText(getActivity(), "checked "+checkedId, Toast.LENGTH_SHORT).show();
    }
}
