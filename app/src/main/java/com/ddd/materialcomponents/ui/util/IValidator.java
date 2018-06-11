package com.ddd.materialcomponents.ui.util;

import android.support.design.widget.TextInputLayout;

/**
 * Created by S.C. on 22/05/18.
 */

public interface IValidator {

    void validate();

    void onValidationFailure(TextInputLayout inputLayout, String error);

    void onValidationSuccess();
}
