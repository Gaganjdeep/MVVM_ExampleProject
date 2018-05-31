package sdei.customer.xCash.features.internal.test;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import sdei.customer.xCash.R;
import sdei.customer.xCash.databinding.ActivityAccountSettingsBinding;
import sdei.customer.xCash.features.editProfile.accountSettings.AccountSettingsBinder;
import sdei.customer.xCash.utilsG.UtillsG;

public class TestActivity extends BaseLiveDataActivity<ActivityAccountSettingsBinding, TestViewModel> implements AccountSettingsBinder {

    public static void start(Context context) {
        Intent starter = new Intent(context, TestActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_account_settings;
    }

    @Override
    protected TestViewModel initViewModel() {
        return ViewModelProviders.of(this).get(TestViewModel.class);
    }

    @Override
    protected Activity getActivityG() {
        return TestActivity.this;
    }

    @Override
    protected void initViews() {
        getDataBinder().setBinder(this);
    }

    @Override
    protected void showLoading() {
        super.showLoading();
        onError("loading");
    }

    @Override
    protected void hideLoading() {
        super.hideLoading();
        onError("hide loading");
    }

    @Override
    protected void onError(String errorString) {
        UtillsG.showToast(errorString, getActivityG(), true);
    }

    @Override
    public void emailClicked(View view) {
        getViewModel().hitAPI();
    }

    @Override
    public void mobileClicked(View view) {

    }

    @Override
    public void FBClicked(View view) {

    }

    @Override
    public String emailText() {
        return "";
    }

    @Override
    public String mobileText() {
        return "";
    }

    @Override
    public String FBText() {
        return "";
    }
}
