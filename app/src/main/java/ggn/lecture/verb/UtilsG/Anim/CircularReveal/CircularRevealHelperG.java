package ggn.lecture.verb.UtilsG.Anim.CircularReveal;

import android.animation.Animator;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * Created by G-Expo on 20 Apr 2017.
 */

public abstract class CircularRevealHelperG
{
    private int[] values;

    public void animateView()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            values = new int[2];

            if (getPositionValue() == null) {
                getRootView().getLocationOnScreen(values);
            }
            else {
                values = getPositionValue();
            }

            animateRevealColorFromCoordinates(getRootView(), values[0] + 80, values[1] + 50);
        }
        else {
            animationEnded();
        }
    }

    public void animateViewReverse()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            values = new int[2];

            if (getPositionValue() == null) {
                getRootView().getLocationOnScreen(values);
            }
            else {
                values = getPositionValue();
            }

            reverseReveal(getRootView(), values[0] + 80, values[1] + 50);
        }
        else {
            animationEnded();
        }
    }

    protected abstract int[] getPositionValue();

    private void animateRevealColorFromCoordinates(final View viewRoot, int x, int y)
    {
        float finalRadius = (float) Math.hypot(viewRoot.getWidth(), viewRoot.getHeight());

        final Animator anim = ViewAnimationUtils.createCircularReveal(viewRoot, x, y, 0, finalRadius);

        viewRoot.setVisibility(View.VISIBLE);

        anim.setDuration(700);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();


        anim.addListener(new Animator.AnimatorListener()
        {
            @Override
            public void onAnimationStart(Animator animator)
            {
            }

            @Override
            public void onAnimationEnd(Animator animator)
            {
                animationEnded();
            }

            @Override
            public void onAnimationCancel(Animator animator)
            {

            }

            @Override
            public void onAnimationRepeat(Animator animator)
            {

            }
        });

    }

    private void reverseReveal(final View viewRoot, int x, int y)
    {
        float finalRadius = (float) Math.hypot(viewRoot.getWidth(), viewRoot.getHeight());

        final Animator anim = ViewAnimationUtils.createCircularReveal(viewRoot, x, y, finalRadius, 0);

        viewRoot.setVisibility(View.VISIBLE);

        anim.setDuration(700);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();


        anim.addListener(new Animator.AnimatorListener()
        {
            @Override
            public void onAnimationStart(Animator animator)
            {
            }

            @Override
            public void onAnimationEnd(Animator animator)
            {
                animationEnded();
            }

            @Override
            public void onAnimationCancel(Animator animator)
            {

            }

            @Override
            public void onAnimationRepeat(Animator animator)
            {

            }
        });

    }

    protected abstract View getRootView();

    protected abstract void animationEnded();

}
