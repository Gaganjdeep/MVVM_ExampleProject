package ggn.lecture.verb.Features.TestPackage;

import ggn.lecture.verb.Features.Internal.Base.BasePresenter;

/**
 * Created by G-Expo on 03 Mar 2017.
 */

public class TestPresenter extends BasePresenter<TestView>
{
    TestModel testModel;

    public TestPresenter()
    {
        testModel = new TestModel();
    }

    public void changeData()
    {
        testModel.setMessage("Clicked");
        testModel.setAnonymous(true);

        getView().setReview(testModel);
    }

    public TestModel getData()
    {
        return testModel;
    }
}
