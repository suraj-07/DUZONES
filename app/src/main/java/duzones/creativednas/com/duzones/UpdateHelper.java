package duzones.creativednas.com.duzones;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class UpdateHelper {

    public static String KEY_UPDATE_ENABLE = "is_update";
    public static String KEY_UPDATE_VERSION = "version";
    public static String KEY_UPDATE_URL = "update_url";

    public interface onUpdateCheckListner{
        void  onUpdateCheckListner(String AppUrl);
    }

    public static Builder with(Context context)
    {
        return new Builder(context);
    }

    private onUpdateCheckListner onUpdateCheckListner;
    private Context context;

    public UpdateHelper(Context context,onUpdateCheckListner onUpdateCheckListner) {
        this.onUpdateCheckListner = onUpdateCheckListner;
        this.context = context;
    }

    public void check(){
        FirebaseRemoteConfig remoteConfig = FirebaseRemoteConfig.getInstance();
        if(remoteConfig.getBoolean(KEY_UPDATE_ENABLE))
        {
            String currentVersion = remoteConfig.getString(KEY_UPDATE_ENABLE);
            String appVersion = getAppVersion(context);
            String updateURL = remoteConfig.getString(KEY_UPDATE_URL);

            if(!TextUtils.equals(currentVersion,appVersion) && onUpdateCheckListner != null)
                onUpdateCheckListner.onUpdateCheckListner(updateURL);
        }

    }

    private String getAppVersion(Context context) {
        String result = "";
        try {
            result=context.getPackageManager().getPackageInfo(context.getPackageName(),0)
                    .versionName;
            result=result.replaceAll("[a-zA-Z]|-","");
        }catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }

        return result;

    }

    public static class Builder{

        private Context context;
        private onUpdateCheckListner onUpdateCheckListner;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder onUpdateCheck(onUpdateCheckListner onUpdateCheckListner) {
            this.onUpdateCheckListner = onUpdateCheckListner;
            return this;
        }

        public UpdateHelper build(){
            return new UpdateHelper(context,onUpdateCheckListner);
        }

        public UpdateHelper check()
        {
            UpdateHelper updateHelper=build();
            updateHelper.check();

            return updateHelper;
        }



    }




}
