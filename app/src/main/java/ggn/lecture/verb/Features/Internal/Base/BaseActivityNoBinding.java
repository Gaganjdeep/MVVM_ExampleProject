package ggn.lecture.verb.Features.Internal.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import ggn.lecture.verb.Features.Internal.Base.Contract.Presentable;
import ggn.lecture.verb.Features.Internal.Base.Contract.Viewable;
import ggn.lecture.verb.R;
import ggn.lecture.verb.UtilsG.SharedPrefHelper;

/**
 * Created by G-Expo on 05 Jul 2017.
 */

public abstract class BaseActivityNoBinding<T extends Presentable> extends AppCompatActivity implements Viewable<T>
{
    protected T presenter;

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStart()
    {
        super.onStart();
        getPresenter().onStart();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        getPresenter().onResume();
    }

    @Override
    protected void onPause()
    {
        getPresenter().onPause();
        super.onPause();
    }

    public void setupToolbar(String title)
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ((TextView) toolbar.findViewById(R.id.toolbar_title)).setText(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        onCreateActivityG();
        getPresenter().onViewCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStop()
    {
        getPresenter().onStop();
        super.onStop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDestroy()
    {
        getPresenter().detachView();
        presenter = null;
        super.onDestroy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayError(String message)
    {
        if (setParentView() != null) {
            Snackbar.make(setParentView(), message, Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showLoading()
    {
        // no-op by default
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hideLoading()
    {
        // no-op by default
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getPresenter()
    {
        return presenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void injectPresenter(T presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public SharedPrefHelper getLocalData()
    {
        return new SharedPrefHelper(getApplicationContext());
    }

    protected abstract int setLayoutId();

    protected View setParentView()
    {
        return findViewById(android.R.id.content);
    }

    /**
     * injectPresenter( @link Presentable);
     * attachView(this);
     */
    protected abstract void onCreateActivityG();
}
