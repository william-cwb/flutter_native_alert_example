package com.example.flutter_native_alert;

import android.widget.Toast;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.plugin.common.MethodChannel;

import io.flutter.embedding.engine.FlutterEngine;


public class MainActivity extends FlutterActivity {

    private static final String CHANNEL = "alert_channel";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);

        final MethodChannel methodChannel = new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(), CHANNEL);
        methodChannel.setMethodCallHandler((call, result) -> {
            if(call.method.equals("showAlert")){
                Toast.makeText(getApplicationContext(), "Message from native code ANDROID", Toast.LENGTH_LONG).show();
            }else {
                result.notImplemented();
            }

        });
    }
}
