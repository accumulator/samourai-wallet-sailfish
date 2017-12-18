package com.samourai.wallet.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class NotificationsFactory {

    public static NotificationManager mNotificationManager;
    private static Context context = null;
    private static NotificationsFactory instance = null;

    private NotificationsFactory()	{
        ;
    }

    public static NotificationsFactory getInstance(Context ctx) {

        context = ctx;

        if(instance == null) {
            instance = new NotificationsFactory();
        }

        return instance;
    }

    public void clearNotification(int id) {
        mNotificationManager.cancel(id);
    }


    public void setNotification(String title, String marquee, String text, int drawable, Class cls, int id) {
        mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notifyIntent = new Intent(context, cls);
        PendingIntent intent = PendingIntent.getActivity(context, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"");

        Notification notification = builder.setContentIntent(intent)
                .setSmallIcon(drawable)
                .setTicker(text)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle(title)
                .setContentInfo(marquee)
                .setContentText(text)
                .build();

        mNotificationManager.notify(id, notification);
    }
}
