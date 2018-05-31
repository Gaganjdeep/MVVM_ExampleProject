package sdei.customer.xCash.features.internal.test;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import org.json.JSONObject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
import sdei.customer.xCash.ApplicationClass;
import sdei.customer.xCash.features.internal.base.contract.Viewable;
import sdei.customer.xCash.utilsG.CallBackG;
import sdei.customer.xCash.web.ApiCallBack;
import sdei.customer.xCash.web.model.BaseModel;

public abstract class BaseViewModel extends ViewModel {

    public MutableLiveData<String>  errorMessage = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading    = new MutableLiveData<>();
    protected Disposable compositeDisposable;

    public BaseViewModel() {
        errorMessage.setValue("");
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }


    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    /**
     * get API interface created by retrofit instance using the interface class.
     *
     * @param retroInterface - API interface class.
     * @param <G>
     * @return API interface created by <b>Retrofit</b> Instance.
     */
    protected final <G> G getRetrofitInstance(Class<G> retroInterface) {
        return ApplicationClass.getRetrofit().create(retroInterface);
    }


    /**
     * Create a network call and return back the response using {@link CallBackG}
     * and errors are handled using {@link Viewable#displayError(String)} method.
     *
     * @param observables - observable returned by API interface
     * @param callBack    - generic call back.
     * @param <V>         - type of data which should be returned by the call back.
     */
    protected <V> void createApiRequest(Observable<V> observables, final ApiCallBack<V> callBack) {

        isLoading.setValue(true);
        compositeDisposable = (observables
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<V>() {
                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull V s) {

                        isLoading.setValue(false);
                        BaseModel baseModel = (BaseModel) s;
                        if (baseModel.getStatus()) {
                            callBack.onSuccess((V) s);
                        }
//                        else {
//                            callBack.onFailure(baseModel.getMessage());
//                        }
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {

                        try {
                            isLoading.setValue(false);
                            String string  = ((HttpException) e).response().errorBody().string();
                            String message = new JSONObject(string).getString("message");
                            callBack.onFailure(message);

                            String status = new JSONObject(string).getString("status");
                            errorMessage.postValue(message);


                        } catch (Exception e1) {
                            callBack.onFailure(e1.getMessage());
                            errorMessage.postValue(e1.getMessage());
                            e1.printStackTrace();
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

}
