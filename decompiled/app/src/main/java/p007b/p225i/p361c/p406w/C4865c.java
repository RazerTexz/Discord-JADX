package p007b.p225i.p361c.p406w;

import android.R;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.tasks.Task;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* renamed from: b.i.c.w.c */
/* loaded from: classes3.dex */
public class C4865c {

    /* renamed from: a */
    public final Executor f13014a;

    /* renamed from: b */
    public final Context f13015b;

    /* renamed from: c */
    public final C4880r f13016c;

    public C4865c(Context context, C4880r c4880r, Executor executor) {
        this.f13014a = executor;
        this.f13015b = context;
        this.f13016c = c4880r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e A[EDGE_INSN: B:283:0x004e->B:18:0x004e BREAK  A[LOOP:0: B:11:0x0036->B:285:?]] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x01cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01ea  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m6816a() {
        boolean z2;
        C4877o c4877o;
        Bundle bundle;
        int i;
        int identifier;
        Uri defaultUri;
        Intent launchIntentForPackage;
        PendingIntent activity;
        Integer numValueOf;
        Long lValueOf;
        long[] jArr;
        int[] iArr;
        ApplicationInfo applicationInfo;
        if (this.f13016c.m6822a("gcm.n.noui")) {
            return true;
        }
        if (!((KeyguardManager) this.f13015b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            int iMyPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f13015b.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == iMyPid) {
                        z2 = next.importance == 100;
                    }
                }
            }
        }
        if (z2) {
            return false;
        }
        String strM6826e = this.f13016c.m6826e("gcm.n.image");
        if (TextUtils.isEmpty(strM6826e)) {
            c4877o = null;
        } else {
            try {
                c4877o = new C4877o(new URL(strM6826e));
            } catch (MalformedURLException unused) {
                String strValueOf = String.valueOf(strM6826e);
                Log.w("FirebaseMessaging", strValueOf.length() != 0 ? "Not downloading image, bad URL: ".concat(strValueOf) : new String("Not downloading image, bad URL: "));
            }
        }
        if (c4877o != null) {
            c4877o.f13035k = C3404f.m4323o(this.f13014a, new CallableC4876n(c4877o));
        }
        Context context = this.f13015b;
        C4880r c4880r = this.f13016c;
        AtomicInteger atomicInteger = C4863a.f13012a;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            String strValueOf2 = String.valueOf(e);
            outline.m854h0(strValueOf2.length() + 35, "Couldn't get own application info: ", strValueOf2, "FirebaseMessaging");
        }
        if (applicationInfo != null) {
            bundle = applicationInfo.metaData;
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
        }
        String packageName = context.getPackageName();
        String strM6826e2 = c4880r.m6826e("gcm.n.android_channel_id");
        if (Build.VERSION.SDK_INT < 26) {
            strM6826e2 = null;
        } else {
            try {
                if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion >= 26) {
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
                    if (TextUtils.isEmpty(strM6826e2)) {
                        strM6826e2 = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
                        if (!TextUtils.isEmpty(strM6826e2)) {
                            Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                        } else if (notificationManager.getNotificationChannel(strM6826e2) == null) {
                            Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                        }
                        strM6826e2 = "fcm_fallback_notification_channel";
                        if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                            notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", context.getString(context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName())), 3));
                        }
                    } else if (notificationManager.getNotificationChannel(strM6826e2) == null) {
                        outline.m856i0(outline.m841b(strM6826e2, 122), "Notification Channel requested (", strM6826e2, ") has not been created by the app. Manifest configuration, or default, value will be used.", "FirebaseMessaging");
                        strM6826e2 = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
                        if (!TextUtils.isEmpty(strM6826e2)) {
                        }
                        strM6826e2 = "fcm_fallback_notification_channel";
                        if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException unused2) {
            }
        }
        Resources resources = context.getResources();
        PackageManager packageManager = context.getPackageManager();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, strM6826e2);
        CharSequence charSequenceM6825d = c4880r.m6825d(resources, packageName, "gcm.n.title");
        if (!TextUtils.isEmpty(charSequenceM6825d)) {
            builder.setContentTitle(charSequenceM6825d);
        }
        CharSequence charSequenceM6825d2 = c4880r.m6825d(resources, packageName, "gcm.n.body");
        if (!TextUtils.isEmpty(charSequenceM6825d2)) {
            builder.setContentText(charSequenceM6825d2);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(charSequenceM6825d2));
        }
        String strM6826e3 = c4880r.m6826e("gcm.n.icon");
        if (TextUtils.isEmpty(strM6826e3)) {
            i = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
            if (i == 0 && C4863a.m6815b(resources, i)) {
                identifier = i;
                if (identifier == 0) {
                    identifier = R.drawable.sym_def_app_icon;
                }
            } else {
                try {
                    identifier = packageManager.getApplicationInfo(packageName, 0).icon;
                } catch (PackageManager.NameNotFoundException e2) {
                    String strValueOf3 = String.valueOf(e2);
                    outline.m854h0(strValueOf3.length() + 35, "Couldn't get own application info: ", strValueOf3, "FirebaseMessaging");
                }
                if (identifier == 0 || !C4863a.m6815b(resources, identifier)) {
                    identifier = R.drawable.sym_def_app_icon;
                }
            }
        } else {
            identifier = resources.getIdentifier(strM6826e3, "drawable", packageName);
            if ((identifier == 0 || !C4863a.m6815b(resources, identifier)) && ((identifier = resources.getIdentifier(strM6826e3, "mipmap", packageName)) == 0 || !C4863a.m6815b(resources, identifier))) {
                outline.m856i0(outline.m841b(strM6826e3, 61), "Icon resource ", strM6826e3, " not found. Notification will use default icon.", "FirebaseMessaging");
                i = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
                if (i == 0) {
                    identifier = packageManager.getApplicationInfo(packageName, 0).icon;
                    if (identifier == 0) {
                    }
                }
            }
        }
        builder.setSmallIcon(identifier);
        String strM6826e4 = c4880r.m6826e("gcm.n.sound2");
        if (TextUtils.isEmpty(strM6826e4)) {
            strM6826e4 = c4880r.m6826e("gcm.n.sound");
        }
        if (TextUtils.isEmpty(strM6826e4)) {
            defaultUri = null;
        } else if ("default".equals(strM6826e4) || resources.getIdentifier(strM6826e4, "raw", packageName) == 0) {
            defaultUri = RingtoneManager.getDefaultUri(2);
        } else {
            StringBuilder sb = new StringBuilder(outline.m841b(strM6826e4, outline.m841b(packageName, 24)));
            sb.append("android.resource://");
            sb.append(packageName);
            sb.append("/raw/");
            sb.append(strM6826e4);
            defaultUri = Uri.parse(sb.toString());
        }
        if (defaultUri != null) {
            builder.setSound(defaultUri);
        }
        String strM6826e5 = c4880r.m6826e("gcm.n.click_action");
        if (TextUtils.isEmpty(strM6826e5)) {
            String strM6826e6 = c4880r.m6826e("gcm.n.link_android");
            if (TextUtils.isEmpty(strM6826e6)) {
                strM6826e6 = c4880r.m6826e("gcm.n.link");
            }
            Uri uri = !TextUtils.isEmpty(strM6826e6) ? Uri.parse(strM6826e6) : null;
            if (uri != null) {
                launchIntentForPackage = new Intent("android.intent.action.VIEW");
                launchIntentForPackage.setPackage(packageName);
                launchIntentForPackage.setData(uri);
            } else {
                launchIntentForPackage = packageManager.getLaunchIntentForPackage(packageName);
                if (launchIntentForPackage == null) {
                    Log.w("FirebaseMessaging", "No activity found to launch app");
                }
            }
        } else {
            launchIntentForPackage = new Intent(strM6826e5);
            launchIntentForPackage.setPackage(packageName);
            launchIntentForPackage.setFlags(268435456);
        }
        if (launchIntentForPackage == null) {
            activity = null;
        } else {
            launchIntentForPackage.addFlags(67108864);
            Bundle bundle2 = new Bundle(c4880r.f13039a);
            for (String str : c4880r.f13039a.keySet()) {
                if (str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                    bundle2.remove(str);
                }
            }
            launchIntentForPackage.putExtras(bundle2);
            activity = PendingIntent.getActivity(context, C4863a.f13012a.incrementAndGet(), launchIntentForPackage, BasicMeasure.EXACTLY);
            if (c4880r.m6822a("google.c.a.e")) {
                activity = C4863a.m6814a(context, new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN").putExtras(c4880r.m6827g()).putExtra("pending_intent", activity));
            }
        }
        builder.setContentIntent(activity);
        PendingIntent pendingIntentM6814a = !c4880r.m6822a("google.c.a.e") ? null : C4863a.m6814a(context, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(c4880r.m6827g()));
        if (pendingIntentM6814a != null) {
            builder.setDeleteIntent(pendingIntentM6814a);
        }
        String strM6826e7 = c4880r.m6826e("gcm.n.color");
        if (TextUtils.isEmpty(strM6826e7)) {
            int i2 = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
            if (i2 != 0) {
                try {
                    numValueOf = Integer.valueOf(ContextCompat.getColor(context, i2));
                } catch (Resources.NotFoundException unused3) {
                    Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
                }
            } else {
                numValueOf = null;
            }
        } else {
            try {
                numValueOf = Integer.valueOf(Color.parseColor(strM6826e7));
            } catch (IllegalArgumentException unused4) {
                outline.m856i0(outline.m841b(strM6826e7, 56), "Color is invalid: ", strM6826e7, ". Notification will use default color.", "FirebaseMessaging");
            }
        }
        if (numValueOf != null) {
            builder.setColor(numValueOf.intValue());
        }
        builder.setAutoCancel(!c4880r.m6822a("gcm.n.sticky"));
        builder.setLocalOnly(c4880r.m6822a("gcm.n.local_only"));
        CharSequence charSequenceM6826e = c4880r.m6826e("gcm.n.ticker");
        if (charSequenceM6826e != null) {
            builder.setTicker(charSequenceM6826e);
        }
        Integer numM6823b = c4880r.m6823b("gcm.n.notification_priority");
        if (numM6823b == null) {
            numM6823b = null;
        } else if (numM6823b.intValue() < -2 || numM6823b.intValue() > 2) {
            String strValueOf4 = String.valueOf(numM6823b);
            outline.m856i0(strValueOf4.length() + 72, "notificationPriority is invalid ", strValueOf4, ". Skipping setting notificationPriority.", "FirebaseMessaging");
            numM6823b = null;
        }
        if (numM6823b != null) {
            builder.setPriority(numM6823b.intValue());
        }
        Integer numM6823b2 = c4880r.m6823b("gcm.n.visibility");
        if (numM6823b2 == null) {
            numM6823b2 = null;
        } else if (numM6823b2.intValue() < -1 || numM6823b2.intValue() > 1) {
            String strValueOf5 = String.valueOf(numM6823b2);
            outline.m856i0(strValueOf5.length() + 53, "visibility is invalid: ", strValueOf5, ". Skipping setting visibility.", "NotificationParams");
            numM6823b2 = null;
        }
        if (numM6823b2 != null) {
            builder.setVisibility(numM6823b2.intValue());
        }
        Integer numM6823b3 = c4880r.m6823b("gcm.n.notification_count");
        if (numM6823b3 == null) {
            numM6823b3 = null;
        } else if (numM6823b3.intValue() < 0) {
            String strValueOf6 = String.valueOf(numM6823b3);
            outline.m856i0(strValueOf6.length() + 67, "notificationCount is invalid: ", strValueOf6, ". Skipping setting notificationCount.", "FirebaseMessaging");
            numM6823b3 = null;
        }
        if (numM6823b3 != null) {
            builder.setNumber(numM6823b3.intValue());
        }
        String strM6826e8 = c4880r.m6826e("gcm.n.event_time");
        if (TextUtils.isEmpty(strM6826e8)) {
            lValueOf = null;
        } else {
            try {
                lValueOf = Long.valueOf(Long.parseLong(strM6826e8));
            } catch (NumberFormatException unused5) {
                String strM6821h = C4880r.m6821h("gcm.n.event_time");
                outline.m874r0(outline.m831S(outline.m841b(strM6826e8, outline.m841b(strM6821h, 38)), "Couldn't parse value of ", strM6821h, "(", strM6826e8), ") into a long", "NotificationParams");
            }
        }
        if (lValueOf != null) {
            builder.setShowWhen(true);
            builder.setWhen(lValueOf.longValue());
        }
        JSONArray jSONArrayM6824c = c4880r.m6824c("gcm.n.vibrate_timings");
        if (jSONArrayM6824c == null) {
            jArr = null;
        } else {
            try {
                if (jSONArrayM6824c.length() <= 1) {
                    throw new JSONException("vibrateTimings have invalid length");
                }
                int length = jSONArrayM6824c.length();
                jArr = new long[length];
                for (int i3 = 0; i3 < length; i3++) {
                    jArr[i3] = jSONArrayM6824c.optLong(i3);
                }
            } catch (NumberFormatException | JSONException unused6) {
                String strValueOf7 = String.valueOf(jSONArrayM6824c);
                outline.m856i0(strValueOf7.length() + 74, "User defined vibrateTimings is invalid: ", strValueOf7, ". Skipping setting vibrateTimings.", "NotificationParams");
            }
        }
        if (jArr != null) {
            builder.setVibrate(jArr);
        }
        JSONArray jSONArrayM6824c2 = c4880r.m6824c("gcm.n.light_settings");
        if (jSONArrayM6824c2 == null) {
            iArr = null;
        } else {
            iArr = new int[3];
            try {
                if (jSONArrayM6824c2.length() != 3) {
                    throw new JSONException("lightSettings don't have all three fields");
                }
                int color = Color.parseColor(jSONArrayM6824c2.optString(0));
                if (color == -16777216) {
                    throw new IllegalArgumentException("Transparent color is invalid");
                }
                iArr[0] = color;
                iArr[1] = jSONArrayM6824c2.optInt(1);
                iArr[2] = jSONArrayM6824c2.optInt(2);
            } catch (IllegalArgumentException e3) {
                String strValueOf8 = String.valueOf(jSONArrayM6824c2);
                String message = e3.getMessage();
                outline.m874r0(outline.m831S(outline.m841b(message, strValueOf8.length() + 60), "LightSettings is invalid: ", strValueOf8, ". ", message), ". Skipping setting LightSettings", "NotificationParams");
            } catch (JSONException unused7) {
                String strValueOf9 = String.valueOf(jSONArrayM6824c2);
                outline.m856i0(strValueOf9.length() + 58, "LightSettings is invalid: ", strValueOf9, ". Skipping setting LightSettings", "NotificationParams");
            }
        }
        if (iArr != null) {
            builder.setLights(iArr[0], iArr[1], iArr[2]);
        }
        boolean zM6822a = c4880r.m6822a("gcm.n.default_sound");
        boolean z3 = zM6822a;
        if (c4880r.m6822a("gcm.n.default_vibrate_timings")) {
            z3 = (zM6822a ? 1 : 0) | 2;
        }
        int i4 = z3;
        if (c4880r.m6822a("gcm.n.default_light_settings")) {
            i4 = (z3 ? 1 : 0) | 4;
        }
        builder.setDefaults(i4);
        String strM6826e9 = c4880r.m6826e("gcm.n.tag");
        if (TextUtils.isEmpty(strM6826e9)) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("FCM-Notification:");
            sb2.append(jUptimeMillis);
            strM6826e9 = sb2.toString();
        }
        if (c4877o != null) {
            try {
                Task<Bitmap> task = c4877o.f13035k;
                Objects.requireNonNull(task, "null reference");
                Bitmap bitmap = (Bitmap) C3404f.m4307k(task, 5L, TimeUnit.SECONDS);
                builder.setLargeIcon(bitmap);
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null));
            } catch (InterruptedException unused8) {
                Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
                c4877o.close();
                Thread.currentThread().interrupt();
            } catch (ExecutionException e4) {
                String strValueOf10 = String.valueOf(e4.getCause());
                outline.m854h0(strValueOf10.length() + 26, "Failed to download image: ", strValueOf10, "FirebaseMessaging");
            } catch (TimeoutException unused9) {
                Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
                c4877o.close();
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f13015b.getSystemService("notification")).notify(strM6826e9, 0, builder.build());
        return true;
    }
}
