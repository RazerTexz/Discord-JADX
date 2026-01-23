package com.discord.utilities.system;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import com.discord.utilities.time.NtpClock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p007b.p445m.p446a.AndroidClockFactory;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: RemoteIntentService.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class RemoteIntentService extends IntentService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String MESSENGER_KEY = "com.discord.utilities.analytics.RemoteIntentService.MESSENGER_KEY";
    private static final String TAG = "RemoteIntentService";
    private static final int WHAT_CALLBACK_RESULT = 1;
    private final String name;

    /* JADX INFO: compiled from: RemoteIntentService.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$messageToString(Companion companion, Message message) {
            return companion.messageToString(message);
        }

        private final String messageToString(Message msg) {
            StringBuilder sbM833U = outline.m833U("Message(what=");
            sbM833U.append(msg.what);
            sbM833U.append(", arg1=");
            sbM833U.append(msg.arg1);
            sbM833U.append(", arg2=");
            sbM833U.append(msg.arg2);
            sbM833U.append(", obj=");
            sbM833U.append(msg.obj);
            sbM833U.append(", replyTo=");
            sbM833U.append(msg.replyTo);
            sbM833U.append(')');
            return sbM833U.toString();
        }

        public final void startRemoteServiceWithCallback(Context context, Class<?> serviceClass, IpcCallback callback) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(serviceClass, "serviceClass");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            Logger logger = LoggingProvider.INSTANCE.get();
            StringBuilder sbM833U = outline.m833U("Starting service in remote process: ");
            sbM833U.append(serviceClass.getSimpleName());
            sbM833U.append(", app pid=");
            sbM833U.append(Process.myPid());
            Logger.d$default(logger, RemoteIntentService.TAG, sbM833U.toString(), null, 4, null);
            Intent intent = new Intent(context, serviceClass);
            Bundle bundle = new Bundle();
            bundle.putParcelable(RemoteIntentService.MESSENGER_KEY, callback.getMessenger());
            intent.putExtras(bundle);
            context.startService(intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: RemoteIntentService.kt */
    public static abstract class IpcCallback {
        private final Handler handler;
        private final String name;

        public IpcCallback(String str, Looper looper) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(looper, "callbackLooper");
            this.name = str;
            this.handler = new Handler(looper, new RemoteIntentService2(this));
        }

        public static final /* synthetic */ String access$getName$p(IpcCallback ipcCallback) {
            return ipcCallback.name;
        }

        public final Messenger getMessenger() {
            return new Messenger(this.handler);
        }

        public abstract void onFailure(Throwable throwable);

        public abstract void onSuccess(Bundle bundle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteIntentService(String str) {
        super(str);
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
    }

    public abstract Bundle doWork(Intent intent);

    @Override // android.app.IntentService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        StringBuilder sbM829Q = outline.m829Q('[');
        sbM829Q.append(this.name);
        sbM829Q.append("] created, remote pid=");
        sbM829Q.append(Process.myPid());
        Log.d(TAG, sbM829Q.toString());
    }

    @Override // android.app.IntentService, android.app.Service
    public final void onDestroy() {
        StringBuilder sbM829Q = outline.m829Q('[');
        sbM829Q.append(this.name);
        sbM829Q.append("] destroyed");
        Log.d(TAG, sbM829Q.toString());
        super.onDestroy();
    }

    @Override // android.app.IntentService
    public final void onHandleIntent(Intent intent) throws RemoteException {
        StringBuilder sbM829Q = outline.m829Q('[');
        sbM829Q.append(this.name);
        sbM829Q.append("] onHandleIntent() start, pid=");
        sbM829Q.append(Process.myPid());
        Log.d(TAG, sbM829Q.toString());
        if (intent == null) {
            StringBuilder sbM829Q2 = outline.m829Q('[');
            sbM829Q2.append(this.name);
            sbM829Q2.append("] null intent");
            Log.d(TAG, sbM829Q2.toString());
            return;
        }
        NtpClock ntpClock = new NtpClock(AndroidClockFactory.m7127a(this, null, null, 0L, 0L, 0L, 62));
        long jCurrentTimeMillis = ntpClock.currentTimeMillis();
        try {
            th = doWork(intent);
        } catch (Throwable th) {
            th = th;
            StringBuilder sbM829Q3 = outline.m829Q('[');
            sbM829Q3.append(this.name);
            sbM829Q3.append("] doWork returned error: ");
            sbM829Q3.append(th);
            Log.e(TAG, sbM829Q3.toString());
        }
        long jCurrentTimeMillis2 = ntpClock.currentTimeMillis() - jCurrentTimeMillis;
        StringBuilder sbM829Q4 = outline.m829Q('[');
        sbM829Q4.append(this.name);
        sbM829Q4.append("] doWork finished: ");
        sbM829Q4.append(jCurrentTimeMillis2);
        sbM829Q4.append(" ms");
        Log.d(TAG, sbM829Q4.toString());
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.arg1 = (int) jCurrentTimeMillis2;
        messageObtain.obj = th;
        Messenger messenger = (Messenger) intent.getParcelableExtra(MESSENGER_KEY);
        if (messenger != null) {
            messenger.send(messageObtain);
            return;
        }
        StringBuilder sbM829Q5 = outline.m829Q('[');
        sbM829Q5.append(this.name);
        sbM829Q5.append("] reply-to Messenger not set by caller");
        Log.e(TAG, sbM829Q5.toString());
    }
}
