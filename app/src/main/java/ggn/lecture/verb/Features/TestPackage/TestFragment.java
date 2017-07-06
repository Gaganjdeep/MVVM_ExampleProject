package ggn.lecture.verb.Features.TestPackage;

import android.support.v4.app.Fragment;
import android.view.View;

import ggn.lecture.verb.Features.Internal.Base.BaseFragment;
import ggn.lecture.verb.R;
import ggn.lecture.verb.databinding.FragmentBlankBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends BaseFragment<FragmentBlankBinding,TestPresenter> implements TestView
{

    public TestFragment()
    {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId()
    {
        return R.layout.fragment_blank;
    }

    @Override
    protected void onCreateFragmentG()
    {
        injectPresenter(new TestPresenter());
        getPresenter().attachView(this);
    }

    @Override
    public void initViews()
    {
        getDataBinder().addReview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                TestActivity.start(getActivityG());
            }
        });
    }

    @Override
    public void setReview(TestModel testModel)
    {

    }
}
