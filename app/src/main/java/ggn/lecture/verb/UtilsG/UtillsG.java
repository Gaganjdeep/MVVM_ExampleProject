package ggn.lecture.verb.UtilsG;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Random;

/**
 * Created by G-Expo on 05 Jul 2017.
 */

public class UtillsG
{
    private static Toast toastG;

    /**
     * @param msg    -message to be displayed
     * @param center - true ,if toast is to be displayed in center,otherwise false.
     */
    public static void showToast(String msg, Context context, boolean center)
    {
        if (toastG != null) {
            toastG.cancel();
        }
        toastG = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        if (center) {
            toastG.setGravity(Gravity.CENTER, 0, 0);
        }
        toastG.show();
    }

    /**
     * finish all the activities from stack.(works only in higher versions).
     */
    public static void finishAll(Context context)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ((Activity) context).finishAffinity();
        }
        else {
            ((Activity) context).finish();
        }
    }

    /**
     * @param i    -intent to be fired.
     * @param logo --shareable view. (used shared object for transitions ).
     */
    public static void startTransition(Activity activity, Intent i, View logo)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(activity,
                    Pair.create(logo, Constants.Extras.TRANSITION_NAME_1));
            activity.startActivity(i, options.toBundle());
        }
        else {
            activity.startActivity(i);
        }
    }

    /**
     * @param i     -intent to be fired.
     * @param view1 --1st shareable view. (used shared object for transitions ).
     * @param view2 --2nd shareable view. (used shared object for transitions ).
     */
    public static void startTransition(Activity activity, Intent i, View view1, View view2)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Pair<View, String> p1 = Pair.create(view1, Constants.Extras.TRANSITION_NAME_1);
            Pair<View, String> p2 = Pair.create(view2, Constants.Extras.TRANSITION_NAME_2);

            ActivityOptions options = ActivityOptions.
                    makeSceneTransitionAnimation(activity, p1, p2);
            activity.startActivity(i, options.toBundle());
        }
        else {
            activity.startActivity(i);
        }
    }

    /**
     * @return true, if app is running in foreground.
     */
    public static boolean isAppOnForeground(Context context)
    {
        ActivityManager                             activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses    = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }
        final String packageName = "com.ameba.ggn.wishdrop";
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    public static String SaveImage(Bitmap finalBitmap)
    {
        String root  = Environment.getExternalStorageDirectory().toString();
        File   myDir = new File(root + "/HomeHelp");
        myDir.mkdirs();
        Random generator = new Random();
        int    n         = 10000;
        n = generator.nextInt(n);
        String fname = "Image-" + n + ".jpg";
        File   file  = new File(myDir, fname);
        if (file.exists()) file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return Uri.fromFile(file).getPath();
    }

    /**
     * @param view --current focused view
     */
    public static void hideKeyboard(Context context, View view)
    {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
