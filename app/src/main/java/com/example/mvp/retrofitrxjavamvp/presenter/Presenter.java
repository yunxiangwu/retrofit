package com.example.mvp.retrofitrxjavamvp.presenter;

import android.content.Intent;
import android.view.View;

/**
 * Created by mc wu on 2017/12/4.
 */

public interface Presenter {
    void onCreate();
    void onRestart();
    void onStop();
    void onPause();
    void attachView(View view);
    void attachIncomingIntent(Intent intent);


}
