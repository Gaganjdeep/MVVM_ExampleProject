package ggn.lecture.verb.Features.LoginRegisteration.UserPrefrence;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.RadioGroup;

import ggn.lecture.verb.Features.Internal.Base.BaseActivity;
import ggn.lecture.verb.R;
import ggn.lecture.verb.databinding.ActivityUserSelectionBinding;

public class UserSelectionActivity extends BaseActivity<ActivityUserSelectionBinding, UserSelectionPresenter> implements UserSelectionView
{

    public static void start(Context context)
    {
        Intent starter = new Intent(context, UserSelectionActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayoutId()
    {
        return R.layout.activity_user_selection;
    }

    @Override
    protected void onCreateActivityG()
    {
        injectPresenter(new UserSelectionPresenter());
        getPresenter().attachView(this);
    }

    @Override
    public void initViews()
    {
        getDataBinder().radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i)
            {
                getPresenter().onCheckChanged(i);
            }
        });


        getDataBinder().btnSkip.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getPresenter().skipClicked();
            }
        });
    }

    @Override
    public Context getActivityG()
    {
        return UserSelectionActivity.this;
    }
}
