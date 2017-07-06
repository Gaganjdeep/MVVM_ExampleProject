package ggn.lecture.verb.UtilsG.Anim;

/**
 * Created by G-Expo on 19 Apr 2017.
 */

public class BounceInterpolatorG implements android.view.animation.Interpolator
{
    double mAmplitude = 1;
    double mFrequency = 10;

    public BounceInterpolatorG(double amplitude, double frequency)
    {
        mAmplitude = amplitude;
        mFrequency = frequency;
    }

    public float getInterpolation(float time)
    {
        return (float) (-1 * Math.pow(Math.E, -time / mAmplitude) *
                Math.cos(mFrequency * time) + 1);
    }
}
