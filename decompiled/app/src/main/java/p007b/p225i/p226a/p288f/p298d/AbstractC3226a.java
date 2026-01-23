package p007b.p225i.p226a.p288f.p298d;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p299e.p308o.p309j.ThreadFactoryC3408a;
import p007b.p225i.p361c.p398s.C4815f;

/* JADX INFO: renamed from: b.i.a.f.d.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3226a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    public final ExecutorService f9242a;

    public AbstractC3226a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC3408a("firebase-iid-executor"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f9242a = Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final int m3997a(@NonNull Context context, @NonNull Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            try {
                C3404f.m4303j(new C4815f(context).m6725b(new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN").putExtras(extras)));
                return -1;
            } catch (InterruptedException | ExecutionException e) {
                Log.e("FirebaseInstanceId", "Failed to send notification open event to service.", e);
                return -1;
            }
        }
        if (!"com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(intent.getAction())) {
            Log.e("CloudMessagingReceiver", "Unknown notification action");
            return 500;
        }
        try {
            C3404f.m4303j(new C4815f(context).m6725b(new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(extras)));
            return -1;
        } catch (InterruptedException | ExecutionException e2) {
            Log.e("FirebaseInstanceId", "Failed to send notification dismissed event to service.", e2);
            return -1;
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: b */
    public final int m3998b(@NonNull Context context, @NonNull Intent intent) {
        int i;
        Task taskM4002b;
        int iIntValue = 500;
        if (intent.getExtras() == null) {
            return 500;
        }
        String stringExtra = intent.getStringExtra("google.message_id");
        if (TextUtils.isEmpty(stringExtra)) {
            taskM4002b = C3404f.m4264Z(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("google.message_id", stringExtra);
            C3231f c3231fM4001a = C3231f.m4001a(context);
            synchronized (c3231fM4001a) {
                i = c3231fM4001a.f9262e;
                c3231fM4001a.f9262e = i + 1;
            }
            taskM4002b = c3231fM4001a.m4002b(new C3240o(i, bundle));
        }
        try {
            iIntValue = ((Integer) C3404f.m4303j(new C4815f(context).m6725b(new CloudMessage(intent).f20470j))).intValue();
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseInstanceId", "Failed to send message to service.", e);
        }
        try {
            C3404f.m4307k(taskM4002b, TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            String strValueOf = String.valueOf(e2);
            outline.m854h0(strValueOf.length() + 20, "Message ack failed: ", strValueOf, "CloudMessagingReceiver");
        }
        return iIntValue;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(@NonNull Context context, @NonNull Intent intent) {
        if (intent == null) {
            return;
        }
        this.f9242a.execute(new RunnableC3230e(this, intent, context, isOrderedBroadcast(), goAsync()));
    }
}
