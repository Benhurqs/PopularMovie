package benhurqs.com.popularmovies.commons.domain.usecases;

/**
 * Created by benhur.souza on 22/02/2017.
 */

public abstract class UseCase<RequestValue extends UseCase.RequestValues, ResponseValue extends UseCase.ResponseValue> {

    private RequestValue mRequestValues;

    private UseCaseCallback<ResponseValue> mUseCaseCallback;

    public void setRequestValues(RequestValue requestValues) {
        mRequestValues = requestValues;
    }

    public RequestValue getRequestValues() {
        return mRequestValues;
    }

    public UseCaseCallback<ResponseValue> getUseCaseCallback() {
        return mUseCaseCallback;
    }

    public void setUseCaseCallback(UseCaseCallback<ResponseValue> useCaseCallback) {
        mUseCaseCallback = useCaseCallback;
    }

    void run() {
        executeUseCase(mRequestValues);
    }

    protected abstract void executeUseCase(RequestValue requestValues);

    /**
     * Data passed to a request.
     */
    public interface RequestValues {
    }

    /**
     * Data received from a request.
     */
    public interface ResponseValue {
    }

}