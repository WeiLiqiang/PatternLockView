package com.andrognito.patternlockdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.rxpatternlockview.PatternLockEvent;
import com.andrognito.rxpatternlockview.RxPatternLockView;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private PatternLockView mPatternLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mPatternLockView = (PatternLockView) findViewById(R.id.patter_lock_view);
        RxPatternLockView.patternChanges(mPatternLockView)
                .subscribe(new Consumer<PatternLockEvent>() {
                    @Override
                    public void accept(PatternLockEvent patternLockEvent) throws Exception {
                        Log.d(this.getClass().getName(), "Event Type " + patternLockEvent.getEventType());
                        Log.d(this.getClass().getName(), "Pattern " + patternLockEvent.getPattern().toString());
                    }
                });
    }
}
