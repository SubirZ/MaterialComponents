package com.ddd.materialcomponents.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ddd.materialcomponents.R;
import com.ddd.materialcomponents.databinding.FragmentSignupBinding;
import com.ddd.materialcomponents.ui.util.IValidator;

/**
 * Created by S.C. on 21/05/18.
 */

public class SignupFragment extends Fragment implements View.OnClickListener, IValidator {
    private FragmentSignupBinding binding;

    public static SignupFragment newInstance() {
        return new SignupFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.tvLogin.setOnClickListener(this);
        binding.btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvLogin:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flContainer, LoginFragment.newInstance())
                        .commit();
                break;
            case R.id.btnSignUp:
                validate();
                break;

        }
    }

    @Override
    public void validate() {
        resetError();
        if (TextUtils.isEmpty(binding.etUserName.getText())) {
            onValidationFailure(binding.tilUserName, getString(R.string.alert_username));
        } else if (TextUtils.isEmpty(binding.etName.getText())) {
            onValidationFailure(binding.tilName, getString(R.string.alert_name));

        } else if (TextUtils.isEmpty(binding.etPassword.getText())) {
            binding.etPassword.setError(getString(R.string.alert_password));
            binding.tilPassword.requestFocus();

        } else if (binding.etPassword.getText().length() < 8) {
            binding.etPassword.setError(getString(R.string.help_password));
            binding.tilPassword.requestFocus();

        } else if (TextUtils.isEmpty(binding.etConfirmPassword.getText())) {
            onValidationFailure(binding.tilConfirmPassword, getString(R.string.help_retype_password));

        } else if (!binding.etPassword.getText().toString().equals(binding.etConfirmPassword.getText().toString())) {
            onValidationFailure(binding.tilConfirmPassword, getString(R.string.alert_retype_password));

        } else {
            resetError();
            onValidationSuccess();
        }

    }

    @Override
    public void onValidationFailure(TextInputLayout inputLayout, String error) {
        inputLayout.setError(error);
        inputLayout.requestFocus();
    }

    @Override
    public void onValidationSuccess() {
        Snackbar.make(binding.etName, getString(R.string.signup_success), Snackbar.LENGTH_SHORT).show();
    }

    private void resetError() {
        binding.tilName.setError(null);
        binding.tilUserName.setError(null);
        binding.tilPassword.setError(null);
        binding.tilConfirmPassword.setError(null);
    }
}
