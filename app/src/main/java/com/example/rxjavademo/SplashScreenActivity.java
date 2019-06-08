package com.example.rxjavademo;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public class SplashScreenActivity extends AppCompatActivity {

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Button btn = findViewById(R.id.button);

        int startValue = 1;
        int incrementValue = 1;
//        Flowable.fromCallable(() -> doSomeThing(5))
//                .map(integer -> integer +10)
//                .subscribe(value -> Log.d("fromCallable", ""+value));

        Flowable<Integer> flowable = Flowable.generate(() -> startValue, (s, emitter) -> {
            int nextValue = s + incrementValue;
            if (nextValue == 1000) {
                emitter.onComplete();
            } else {
                emitter.onNext(nextValue);
            }
            return nextValue;
        }, i -> Log.d("sss", ""+ i.toString()));

        flowable.subscribe(value -> Log.d("generate", "" + value));

        btn.setOnClickListener(view -> Observable.generate(emitter -> {
            emitter.onNext(1);
            emitter.onComplete();
        })
                .subscribe(value -> Log.d("ButtonClicked", "" + value)));
    }

    private int doSomeThing(int i) {
        return i+5;
    }
}
