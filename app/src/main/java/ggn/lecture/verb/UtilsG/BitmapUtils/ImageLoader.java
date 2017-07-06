package ggn.lecture.verb.UtilsG.BitmapUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import ggn.lecture.verb.UtilsG.CallBackG;

/**
 * Created by G-Expo on 16 Mar 2017.
 */

public class ImageLoader
{
    private static final ImageLoader ourInstance = new ImageLoader();

    public static ImageLoader getInstance()
    {
        return ourInstance;
    }

    private ImageLoader()
    {
    }

    public void setImageResized(final Context con, String url, int height, final CallBackG<Bitmap> callBackG)
    {


        Glide.with(con)
                .load(url)
                .asBitmap()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new SimpleTarget<Bitmap>(height, height)
                {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation)
                    {
                        callBackG.CallBackG(resource);
                    }
                });
    }

    public void setImageResized(final Context con, String url, int height, ImageView imageView)
    {

        Glide.with(con)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(height, height)
                .fitCenter()
                .into(imageView);
    }

}
