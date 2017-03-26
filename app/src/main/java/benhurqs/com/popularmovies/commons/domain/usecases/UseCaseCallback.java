package benhurqs.com.popularmovies.commons.domain.usecases;

/**
 * Created by benhursouza on 26/03/17.
 */

public interface UseCaseCallback<ResponseValue extends UseCase.ResponseValue> {
    void onStart();
    void onSuccess(ResponseValue response);
    void onError(String error);
    void onFinish();
}
