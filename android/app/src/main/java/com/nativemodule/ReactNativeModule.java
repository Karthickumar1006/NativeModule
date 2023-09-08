package com.nativemodule;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;


import com.facebook.react.ReactApplication;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

public class ReactNativeModule extends ReactContextBaseJavaModule {

    private String eventString = "Karthic Kumar";

    ReactNativeModule(ReactApplicationContext context) {
        super(context);
    }

    @NonNull
    @Override
    public String getName() {
        return "RN";
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @ReactMethod
    public void sampleTesting(String s) {
        /*Used to get vlaue form React Native and native anf show custom toast*/
        Context context = getReactApplicationContext();
        // Create a Toast object
        Toast toast = Toast.makeText(context, s, Toast.LENGTH_SHORT);
        // Show the Toast
        toast.show();

        /*Line used to get value from native*/
        sendEvent(getReactApplicationContext(), "EventName", eventString);

    }


    /*Created Method for sending value native to React Native*/
    private void sendEvent(ReactContext reactContext,
                           String eventName,
                           String params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }


}
