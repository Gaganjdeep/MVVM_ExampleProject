package ggn.lecture.verb.Features.TestPackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import ggn.lecture.verb.Features.Internal.Base.BaseActivity;
import ggn.lecture.verb.R;
import ggn.lecture.verb.databinding.ActivityTestBinding;

public class TestActivity extends BaseActivity<ActivityTestBinding, TestPresenter> implements TestView
{

    public static void start(Context context)
    {
        Intent starter = new Intent(context, TestActivity.class);
        context.startActivity(starter);

    }

    @Override
    protected int setLayoutId()
    {
        return R.layout.activity_test;
    }

//    @Override
//    protected View setParentView()
//    {
//        return findViewById(R.id.activity_test);
//    }

    @Override
    protected void onCreateActivityG()
    {
        injectPresenter(new TestPresenter());
        getPresenter().attachView(this);

        setReview(getPresenter().getData());
    }

    @Override
    public void setReview(TestModel testModel)
    {
        getDataBinder().setReview(testModel);
    }

    @Override
    public void initViews()
    {
//        setupToolbar("Gagan");
        getDataBinder().saveReview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getPresenter().changeData();
            }
        });
    }

    @Override
    public Context getActivityG()
    {
        return TestActivity.this;
    }

}
