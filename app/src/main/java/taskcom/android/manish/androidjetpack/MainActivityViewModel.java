package taskcom.android.manish.androidjetpack;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import java.util.Random;

/**
 * Created by Manish Kumar on 11/6/2018
 */
public class MainActivityViewModel extends ViewModel {

    private String TAG = this.getClass().getSimpleName();
    private MutableLiveData<String> myRandomNumber;

    public MutableLiveData<String> getNumber() {
        if (myRandomNumber == null) {
            myRandomNumber = new MutableLiveData<>();
            createNumber();
        }
        return myRandomNumber;
    }

    public void createNumber() {
        Random random = new Random();
        //myRandomNumber = "Number : " + (random.nextInt(10 - 1) + 1);
        myRandomNumber.setValue("Number : " + (random.nextInt(10 - 1) + 1));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel is cleared !!");
    }
}
