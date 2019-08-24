package com.test.interview.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import com.test.interview.data.model.AboutCananda;
import com.test.interview.data.rest.ImageRepository;

public class ImageListViewModel extends ViewModel {

    private final ImageRepository imageRepository;
    private CompositeDisposable disposable;

    private final MutableLiveData<AboutCananda> repos = new MutableLiveData<>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public ImageListViewModel(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
        disposable = new CompositeDisposable();
        fetchRepos();
    }

    public LiveData<AboutCananda> getRepos() {
        return repos;
    }
    LiveData<Boolean> getError() {
        return repoLoadError;
    }
    LiveData<Boolean> getLoading() {
        return loading;
    }

    private void fetchRepos() {
        //will tell the observer that the data fetching is in progress
        loading.setValue(true);
        disposable.add(imageRepository.getImageItem().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<AboutCananda>() {
                    @Override
                    public void onSuccess(AboutCananda value) {
                        repoLoadError.setValue(false);
                        repos.setValue(value);
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        repoLoadError.setValue(true);
                        loading.setValue(false);
                    }
                }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}
