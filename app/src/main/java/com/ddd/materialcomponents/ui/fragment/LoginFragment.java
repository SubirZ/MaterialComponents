package com.ddd.materialcomponents.ui.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ddd.materialcomponents.R;
import com.ddd.materialcomponents.databinding.FragmentLoginBinding;
import com.ddd.materialcomponents.ui.activity.HomeActivity;
import com.ddd.materialcomponents.ui.custom.SnackbarHelper;

/**
 * Created by S.C. on 21/05/18.
 */

public class LoginFragment extends Fragment implements View.OnClickListener {
    private FragmentLoginBinding binding;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.tvSignUp.setOnClickListener(this);
        binding.btnDribbleLogin.setOnClickListener(this);
        binding.btnFacebookLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvSignUp:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.flContainer, SignupFragment.newInstance())
                        .addToBackStack(SignupFragment.class.getSimpleName())
                        .hide(LoginFragment.this)
                        .commit();
                break;

            case R.id.btnDribbleLogin:
                validate();
                break;
            case R.id.btnFacebookLogin:
                login();
                break;
        }
    }


    private void validate() {
        final Snackbar snack = Snackbar.make(binding.btnFacebookLogin, getString(R.string.alert_login), Snackbar.LENGTH_LONG);
        SnackbarHelper.configSnackbar(getActivity(), snack);
        //snack.config(this) if you're using Kotlin
        snack.show();
    }

    private void login() {
        startActivity(new Intent(getActivity(), HomeActivity.class));
        getActivity().finish();
    }

}
