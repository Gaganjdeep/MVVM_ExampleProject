package ggn.lecture.verb.UtilsG.Anim.CircularReveal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ggn.lecture.verb.R;

public class CircularRevealActivity extends AppCompatActivity
{

    private static Intent  intent;
    private static int[]   values;
    private static boolean isReverse;

    public static void start(Context context, Intent intent)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Intent starter = new Intent(context, CircularRevealActivity.class);
            context.startActivity(starter);
            CircularRevealActivity.intent = intent;
            values = null;
        }
        else {
            context.startActivity(intent);
        }
    }

    public static void start(Context context, Intent intent, int[] values)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Intent starter = new Intent(context, CircularRevealActivity.class);
            context.startActivity(starter);

            CircularRevealActivity.intent = intent;
            if (values != null) {
                CircularRevealActivity.values = values;
            }
            CircularRevealActivity.isReverse = false;
        }
        else {
            context.startActivity(intent);
        }
    }

    public static void start(Context context, Intent intent, View values)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Intent starter = new Intent(context, CircularRevealActivity.class);
            context.startActivity(starter);

            CircularRevealActivity.intent = intent;
            if (values != null) {
                int[] position = new int[2];
                values.getLocationOnScreen(position);
                CircularRevealActivity.values = position;
            }
            CircularRevealActivity.isReverse = false;
        }
        else {
            context.startActivity(intent);
        }
    }

    public static void startReverse(Context context, Intent intent, int[] values)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Intent starter = new Intent(context, CircularRevealActivity.class);
            context.startActivity(starter);

            if (values != null) {
                CircularRevealActivity.values = values;
            }
            CircularRevealActivity.intent = intent;
            CircularRevealActivity.isReverse = true;
        }
        else {
            if (intent == null) {
                ((Activity) context).finish();
            }
            else {
                context.startActivity(intent);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_reveal);

        final View circularReveal = findViewById(R.id.circularReveal);

        circularReveal.post(new Runnable()
        {
            @Override
            public void run()
            {
                animate(circularReveal);

            }
        });

    }

    private void animate(final View circularReveal)
    {
        if (isReverse) {
            new CircularRevealHelperG()
            {
                @Override
                protected int[] getPositionValue()
                {
                    return values;
                }

                @Override
                protected View getRootView()
                {
                    return circularReveal;
                }

                @Override
                protected void animationEnded()
                {
                    if (intent != null) {
                        startActivity(intent);
                    }
                    else {
                        finish();
                    }
                }
            }.animateViewReverse();
        }
        else {
            new CircularRevealHelperG()
            {
                @Override
                protected int[] getPositionValue()
                {
                    return values;
                }

                @Override
                protected View getRootView()
                {
                    return circularReveal;
                }

                @Override
                protected void animationEnded()
                {
                    if (intent != null) {
                        startActivity(intent);
                    }
                    else {
                        finish();
                    }
                }
            }.animateView();
        }
    }
}
