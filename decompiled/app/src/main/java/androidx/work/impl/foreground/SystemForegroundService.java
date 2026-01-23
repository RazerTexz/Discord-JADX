package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.view.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.foreground.SystemForegroundDispatcher;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {
    private static final String TAG = Logger.tagWithPrefix("SystemFgService");

    @Nullable
    private static SystemForegroundService sForegroundService = null;
    public SystemForegroundDispatcher mDispatcher;
    private Handler mHandler;
    private boolean mIsShutdown;
    public NotificationManager mNotificationManager;

    /* JADX INFO: renamed from: androidx.work.impl.foreground.SystemForegroundService$1 */
    public class RunnableC07421 implements Runnable {
        public RunnableC07421() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.mDispatcher.handleStop();
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.foreground.SystemForegroundService$2 */
    public class RunnableC07432 implements Runnable {
        public final /* synthetic */ Notification val$notification;
        public final /* synthetic */ int val$notificationId;
        public final /* synthetic */ int val$notificationType;

        public RunnableC07432(int i, Notification notification, int i2) {
            this.val$notificationId = i;
            this.val$notification = notification;
            this.val$notificationType = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.val$notificationId, this.val$notification, this.val$notificationType);
            } else {
                SystemForegroundService.this.startForeground(this.val$notificationId, this.val$notification);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.foreground.SystemForegroundService$3 */
    public class RunnableC07443 implements Runnable {
        public final /* synthetic */ Notification val$notification;
        public final /* synthetic */ int val$notificationId;

        public RunnableC07443(int i, Notification notification) {
            this.val$notificationId = i;
            this.val$notification = notification;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.mNotificationManager.notify(this.val$notificationId, this.val$notification);
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.foreground.SystemForegroundService$4 */
    public class RunnableC07454 implements Runnable {
        public final /* synthetic */ int val$notificationId;

        public RunnableC07454(int i) {
            this.val$notificationId = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.mNotificationManager.cancel(this.val$notificationId);
        }
    }

    @Nullable
    public static SystemForegroundService getInstance() {
        return sForegroundService;
    }

    @MainThread
    private void initializeDispatcher() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.mDispatcher = systemForegroundDispatcher;
        systemForegroundDispatcher.setCallback(this);
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void cancelNotification(int i) {
        this.mHandler.post(new RunnableC07454(i));
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void notify(int i, @NonNull Notification notification) {
        this.mHandler.post(new RunnableC07443(i, notification));
    }

    @Override // androidx.view.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        sForegroundService = this;
        initializeDispatcher();
    }

    @Override // androidx.view.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mDispatcher.onDestroy();
    }

    @Override // androidx.view.LifecycleService, android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.mIsShutdown) {
            Logger.get().info(TAG, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.mDispatcher.onDestroy();
            initializeDispatcher();
            this.mIsShutdown = false;
        }
        if (intent == null) {
            return 3;
        }
        this.mDispatcher.onStartCommand(intent);
        return 3;
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void startForeground(int i, int i2, @NonNull Notification notification) {
        this.mHandler.post(new RunnableC07432(i, notification, i2));
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    @MainThread
    public void stop() {
        this.mIsShutdown = true;
        Logger.get().debug(TAG, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        sForegroundService = null;
        stopSelf();
    }

    public void stopForegroundService() {
        this.mHandler.post(new RunnableC07421());
    }
}
