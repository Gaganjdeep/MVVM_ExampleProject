package sdei.customer.xCash.features.internal.test;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import sdei.customer.xCash.utilsG.SharedPrefHelper;

public abstract class BaseLiveDataActivity<B extends ViewDataBinding, G extends BaseViewModel> extends AppCompatActivity {
    protected B binding;
    protected G viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(setLayoutId());
        binding = DataBindingUtil.setContentView(this, setLayoutId());
        binding.setLifecycleOwner(this);
        viewModel = initViewModel();

        initViews();
        viewModel.getErrorMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                if (s != null && !s.isEmpty()) {
                    onError(s);
                }
            }
        });
        viewModel.getIsLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean loading) {
                if (loading) {
                    showLoading();
                } else {
                    hideLoading();
                }
            }
        });
    }

    protected abstract int setLayoutId();

    protected abstract G initViewModel();

    protected abstract void initViews();

    protected void onError(String errorString) {

    }

    protected void showLoading() {

    }

    protected void hideLoading() {

    }

    public B getDataBinder() {
        return binding;
    }

    public SharedPrefHelper getLocalData() {
        return new SharedPrefHelper(getApplicationContext());
    }

    protected abstract Activity getActivityG();

    protected G getViewModel() {
        return viewModel;
    }
}
