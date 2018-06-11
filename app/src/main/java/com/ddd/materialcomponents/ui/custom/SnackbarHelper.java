package com.ddd.materialcomponents.ui.custom;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;

import com.ddd.materialcomponents.R;

/**
 * Created by S.C. on 29/05/18.
 */

public class SnackbarHelper {

    public static void configSnackbar(Context context, Snackbar snack) {
        addMargins(snack);
        setRoundBordersBg(context, snack);
//        addSwipeToDismissBehaviour(snack);
        setAction(snack, context);
        ViewCompat.setElevation(snack.getView(), 6f);
    }

    private static void addMargins(Snackbar snack) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) snack.getView().getLayoutParams();
        params.setMargins(30, 0, 30, 30);
        snack.getView().setLayoutParams(params);
    }

    private static void setRoundBordersBg(Context context, Snackbar snackbar) {
        snackbar.getView().setBackground(context.getDrawable(R.drawable.bg_snackbar));
    }

    private static void setAction(final Snackbar snackbar, Context context) {
        snackbar.setActionTextColor(ContextCompat.getColor(context, R.color.colorFlamingo));
        snackbar.setAction("Dismiss", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        });
    }

//    private static void addSwipeToDismissBehaviour(Snackbar snackbar){
//        View snackBarView = snackbar.getView();
//        final ViewGroup.LayoutParams lp = snackBarView.getLayoutParams();
//        if (lp instanceof CoordinatorLayout.LayoutParams) {
//            final CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) lp;
//            CoordinatorLayout.Behavior behavior = layoutParams.getBehavior();
//            if(behavior instanceof SwipeDismissBehavior){
//                ((SwipeDismissBehavior) behavior).setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_END_TO_START); // or SwipeDismissBehavior.SWIPE_DIRECTION_ANY
//            }
//            layoutParams.setBehavior(behavior);
//        }
//    }
}
