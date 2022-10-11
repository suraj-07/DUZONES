package duzones.creativednas.com.duzones;

import android.app.Application;
import android.support.annotation.NonNull;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import java.util.HashMap;
import java.util.Map;

public class Firebase_app extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);


        final FirebaseRemoteConfig remoteConfig = FirebaseRemoteConfig.getInstance();


        Map<String,Object> defaultValue = new HashMap<>();
        defaultValue.put(UpdateHelper.KEY_UPDATE_ENABLE,false);
        defaultValue.put(UpdateHelper.KEY_UPDATE_VERSION,"1.2");
        defaultValue.put(UpdateHelper.KEY_UPDATE_ENABLE,"https://play.google.com/store/apps/details?id=duzones.creativednas.com.duzones");

        remoteConfig.setDefaults(defaultValue);
        remoteConfig.fetch(5)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            remoteConfig.activateFetched();
                        }
                    }
                });



    }
}
