package ggn.lecture.verb.UtilsG.BitmapUtils;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import ggn.lecture.verb.R;

/**
 * Created by G-Expo on 19 Apr 2017.
 */
public class SmartImageView extends LinearLayout
{

    public SmartImageView(Context context)
    {
        super(context);

        init(context, null);
    }

    public SmartImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context, attrs);
    }

    public SmartImageView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public SmartImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private ImageView imageView;

    private View progressBar;

    public void init(Context context, AttributeSet attrs)
    {
        this.context = context;

        setGravity(Gravity.CENTER);
        imageView = new ImageView(context);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);

        setLayoutTransition(new LayoutTransition());

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        progressBar = inflater.inflate(R.layout.progress_dialog, null);
        progressBar.setVisibility(GONE);

        addView(imageView);
        addView(progressBar);
    }

    private Context context;

    public ImageView getImageView()
    {
        return imageView;
    }

    public void setImageURLresize(String url, int height, int width)
    {
        loadingImage(true);

        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(height, width)
                .listener(new RequestListener<String, GlideDrawable>()
                {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource)
                    {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource)
                    {
                        loadingImage(false);
                        return false;
                    }
                })
                .into(imageView);
    }

    public void setImageURLresizeWithoutLoading(String url, int height, int width)
    {


        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(height, width)
                .listener(new RequestListener<String, GlideDrawable>()
                {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource)
                    {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource)
                    {
                        return false;
                    }
                })
                .into(imageView);
    }

    public void setImageURL(String url)
    {
        loadingImage(true);


        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(500, 500)
                .listener(new RequestListener<String, GlideDrawable>()
                {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource)
                    {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource)
                    {
                        loadingImage(false);
                        return false;
                    }
                })
                .into(imageView);
    }

    public void loadingImage(boolean loading)
    {
        if (loading) {
            imageView.setVisibility(GONE);
            progressBar.setVisibility(VISIBLE);
        }
        else {
            progressBar.setVisibility(GONE);
            imageView.setVisibility(VISIBLE);
        }
    }

}