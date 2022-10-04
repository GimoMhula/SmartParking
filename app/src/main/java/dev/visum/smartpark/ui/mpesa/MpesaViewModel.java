package dev.visum.smartpark.ui.mpesa;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MpesaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MpesaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Area de pagamento");
    }

    public LiveData<String> getText() {
        return mText;
    }
}