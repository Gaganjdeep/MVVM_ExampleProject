package ggn.lecture.verb.UtilsG.Anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by G-Expo on 03 May 2017.
 */

public class AnimHelper
{
    private static final AnimHelper ourInstance = new AnimHelper();

    public static AnimHelper getInstance()
    {
        return ourInstance;
    }

    private AnimHelper()
    {
    }

    public void shakeView(View target_view)
    {
        final AnimatorSet mAnimatorSet = new AnimatorSet();
        mAnimatorSet.playTogether(ObjectAnimator.ofFloat(target_view, "scaleX", 1, 0.7f, 0.7f, 0.7f, 1, 1), ObjectAnimator.ofFloat(target_view, "scaleY", 1, 0.7f, 0.7f, 0.7f, 1, 1), ObjectAnimator.ofFloat(target_view, "rotation", 0, -3, -3, 3, -3, 3, -3, 3, -3, 3, -3, 0));
        mAnimatorSet.setDuration(1000);
        mAnimatorSet.start();
    }

}
