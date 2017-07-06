package ggn.lecture.verb.Features.TestPackage;

import ggn.lecture.verb.Features.Internal.Base.Contract.Viewable;

/**
 * Created by G-Expo on 03 Mar 2017.
 */

public interface TestView extends Viewable<TestPresenter>
{

    void setReview(TestModel testModel);
}
