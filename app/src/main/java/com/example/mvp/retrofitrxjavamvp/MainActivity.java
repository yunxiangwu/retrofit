package com.example.mvp.retrofitrxjavamvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv =findViewById(R.id.sample_text);
        Button button=findViewById(R.id.click);
        tv.setText(stringFromJNI());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDatas();
            }
        });


    }

    private void getDatas(){
        OkHttpClient client = new OkHttpClient();
        GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
                mRetrofit.create(RetrofitService.class);

    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
