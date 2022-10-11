
package duzones.creativednas.com.duzones;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.Map;
import java.util.Objects;

public class MessagingService extends FirebaseMessagingService {

    String title, imgurl, text,intent_type,notification_type;
    String CHANNEL_ID = "DEFAULT_NEWS_CHANNEL";
    PendingIntent intent;


    Target target = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            showNotificationwithimage(bitmap);
        }

        @Override
        public void onBitmapFailed(Exception e, Drawable errorDrawable) {
            Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            Toast.makeText(getApplicationContext(), "notification", Toast.LENGTH_LONG).show();
        }
    };

    private void showNotificationwithimage(Bitmap bitmap) {
        if(Objects.equals(intent_type, "home")) {
            intent = PendingIntent.getActivity(this, 0, new Intent(this, home.class), 0);
        }

        else if(Objects.equals(intent_type, "result")) {
            intent = PendingIntent.getActivity(this, 0, new Intent(this, home.class), 0);


        }

        else if(Objects.equals(intent_type, "cutoffs")) {
            intent = PendingIntent.getActivity(this, 0, new Intent(this, Cutoffs.class), 0);

        }

        else if(Objects.equals(intent_type, "internships")) {
            intent = PendingIntent.getActivity(this, 0, new Intent(this, internships.class), 0);

        }

        else if(Objects.equals(intent_type, "notices")) {
            intent = PendingIntent.getActivity(this, 0, new Intent(this, notices.class), 0);

        }

        else if(Objects.equals(intent_type, "events")) {
            intent = PendingIntent.getActivity(this, 0, new Intent(this, collegeevents.class), 0);
        }

        else if(Objects.equals(intent_type, "papers")) {
            intent = PendingIntent.getActivity(this, 0, new Intent(this, Courselist.class), 0);
        }

        else  {
           // intent = PendingIntent.getActivity(this, 0, new Intent(this, tryfirebase.class), 0);
            Intent aint = new Intent(this, tryfirebase.class);
            aint.putExtra("link_to_pass", intent_type);
           // a.putExtra("link_to_pass",r);
            intent = PendingIntent.getActivity(this,(int) (System.currentTimeMillis() & 0xfffffff), aint, PendingIntent.FLAG_UPDATE_CURRENT);
            //Toast.makeText(this, intent_type, Toast.LENGTH_SHORT).show();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence name = "News Channel";
            String description = "Default Notification News Channel";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getApplication().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);


            NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
            style.setSummaryText(text);
            style.bigPicture(bitmap);

            Uri defaultsound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationbuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this, CHANNEL_ID);
            notificationbuilder.setStyle(style)
                    .setSmallIcon(R.raw.mainlogofinal)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.raw.mainlogofinal))
                    .setContentTitle(title)
                    .setAutoCancel(true)
                    .setPriority(NotificationManager.IMPORTANCE_HIGH)
                    .setContentIntent(intent)
                    .setSound(defaultsound)
                    // .addAction(android.R.drawable.ic_menu_view, "VIEW", pi)
                    .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                    .setLights(Color.RED, 3000, 3000);

            NotificationManager mnotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mnotificationManager.notify(0, notificationbuilder.build());

        }

        else {

            NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
            style.setSummaryText(text);
            style.bigPicture(bitmap);

            Uri defaultsound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationbuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this, CHANNEL_ID);
            notificationbuilder.setStyle(style)
                    .setSmallIcon(R.raw.mainlogofinal)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.raw.mainlogofinal))
                    .setContentTitle(title)
                    .setAutoCancel(true)
                    .setPriority(NotificationManager.IMPORTANCE_HIGH)
                    .setContentIntent(intent)
                    .setSound(defaultsound)
                    // .addAction(android.R.drawable.ic_menu_view, "VIEW", pi)
                    .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                    .setLights(Color.RED, 3000, 3000);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notificationbuilder.build());
        }

    }


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getData() != null) {

            title = remoteMessage.getData().get("heading");
            text = remoteMessage.getData().get("content");
            intent_type = remoteMessage.getData().get("intent");
            notification_type = remoteMessage.getData().get("notification");
            imgurl = remoteMessage.getData().get("imglink");
            getimage(remoteMessage);


        }

    }

    private void getimage(final RemoteMessage remoteMessage) {

        Handler uiHandler = new Handler(Looper.getMainLooper());
        uiHandler.post(new Runnable() {
            @Override
            public void run() {

                Picasso.get().load(imgurl).into(target);
            }
        });
    }
}
