package sdei.customer.xCash.features.internal.test;

import sdei.customer.xCash.web.ApiCallBack;
import sdei.customer.xCash.web.apiInterface.LoginSignupAPI;
import sdei.customer.xCash.web.model.BaseModel;

public class TestViewModel extends BaseViewModel {

    /**
     * only testing live data
     */
    public void hitAPI() {
        createApiRequest(getRetrofitInstance(LoginSignupAPI.class).changePin(""), new ApiCallBack<BaseModel<Object>>() {
            @Override
            public void onSuccess(BaseModel<Object> data) {

            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

}
