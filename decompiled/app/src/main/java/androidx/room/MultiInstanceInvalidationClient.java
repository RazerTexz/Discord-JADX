package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class MultiInstanceInvalidationClient {
    public final Context mAppContext;
    public int mClientId;
    public final Executor mExecutor;
    public final InvalidationTracker mInvalidationTracker;
    public final String mName;
    public final InvalidationTracker.Observer mObserver;
    public final Runnable mRemoveObserverRunnable;

    @Nullable
    public IMultiInstanceInvalidationService mService;
    public final ServiceConnection mServiceConnection;
    public final Runnable mSetUpRunnable;
    private final Runnable mTearDownRunnable;
    public final IMultiInstanceInvalidationCallback mCallback = new BinderC05841();
    public final AtomicBoolean mStopped = new AtomicBoolean(false);

    /* JADX INFO: renamed from: androidx.room.MultiInstanceInvalidationClient$1 */
    public class BinderC05841 extends IMultiInstanceInvalidationCallback.Stub {

        /* JADX INFO: renamed from: androidx.room.MultiInstanceInvalidationClient$1$1, reason: invalid class name */
        public class AnonymousClass1 implements Runnable {
            public final /* synthetic */ String[] val$tables;

            public AnonymousClass1(String[] strArr) {
                this.val$tables = strArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                MultiInstanceInvalidationClient.this.mInvalidationTracker.notifyObserversByTableNames(this.val$tables);
            }
        }

        public BinderC05841() {
        }

        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public void onInvalidation(String[] strArr) {
            MultiInstanceInvalidationClient.this.mExecutor.execute(new AnonymousClass1(strArr));
        }
    }

    /* JADX INFO: renamed from: androidx.room.MultiInstanceInvalidationClient$2 */
    public class ServiceConnectionC05852 implements ServiceConnection {
        public ServiceConnectionC05852() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MultiInstanceInvalidationClient.this.mService = IMultiInstanceInvalidationService.Stub.asInterface(iBinder);
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.mExecutor.execute(multiInstanceInvalidationClient.mSetUpRunnable);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.mExecutor.execute(multiInstanceInvalidationClient.mRemoveObserverRunnable);
            MultiInstanceInvalidationClient.this.mService = null;
        }
    }

    /* JADX INFO: renamed from: androidx.room.MultiInstanceInvalidationClient$3 */
    public class RunnableC05863 implements Runnable {
        public RunnableC05863() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.mService;
                if (iMultiInstanceInvalidationService != null) {
                    multiInstanceInvalidationClient.mClientId = iMultiInstanceInvalidationService.registerCallback(multiInstanceInvalidationClient.mCallback, multiInstanceInvalidationClient.mName);
                    MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = MultiInstanceInvalidationClient.this;
                    multiInstanceInvalidationClient2.mInvalidationTracker.addObserver(multiInstanceInvalidationClient2.mObserver);
                }
            } catch (RemoteException e) {
                Log.w(Room.LOG_TAG, "Cannot register multi-instance invalidation callback", e);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.room.MultiInstanceInvalidationClient$4 */
    public class RunnableC05874 implements Runnable {
        public RunnableC05874() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.mInvalidationTracker.removeObserver(multiInstanceInvalidationClient.mObserver);
        }
    }

    /* JADX INFO: renamed from: androidx.room.MultiInstanceInvalidationClient$5 */
    public class RunnableC05885 implements Runnable {
        public RunnableC05885() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.mInvalidationTracker.removeObserver(multiInstanceInvalidationClient.mObserver);
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = MultiInstanceInvalidationClient.this;
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient2.mService;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(multiInstanceInvalidationClient2.mCallback, multiInstanceInvalidationClient2.mClientId);
                }
            } catch (RemoteException e) {
                Log.w(Room.LOG_TAG, "Cannot unregister multi-instance invalidation callback", e);
            }
            MultiInstanceInvalidationClient multiInstanceInvalidationClient3 = MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient3.mAppContext.unbindService(multiInstanceInvalidationClient3.mServiceConnection);
        }
    }

    /* JADX INFO: renamed from: androidx.room.MultiInstanceInvalidationClient$6 */
    public class C05896 extends InvalidationTracker.Observer {
        public C05896(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public boolean isRemote() {
            return true;
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@NonNull Set<String> set) {
            if (MultiInstanceInvalidationClient.this.mStopped.get()) {
                return;
            }
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.mService;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.broadcastInvalidation(multiInstanceInvalidationClient.mClientId, (String[]) set.toArray(new String[0]));
                }
            } catch (RemoteException e) {
                Log.w(Room.LOG_TAG, "Cannot broadcast invalidation", e);
            }
        }
    }

    public MultiInstanceInvalidationClient(Context context, String str, InvalidationTracker invalidationTracker, Executor executor) {
        ServiceConnectionC05852 serviceConnectionC05852 = new ServiceConnectionC05852();
        this.mServiceConnection = serviceConnectionC05852;
        this.mSetUpRunnable = new RunnableC05863();
        this.mRemoveObserverRunnable = new RunnableC05874();
        this.mTearDownRunnable = new RunnableC05885();
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mName = str;
        this.mInvalidationTracker = invalidationTracker;
        this.mExecutor = executor;
        this.mObserver = new C05896((String[]) invalidationTracker.mTableIdLookup.keySet().toArray(new String[0]));
        applicationContext.bindService(new Intent(applicationContext, (Class<?>) MultiInstanceInvalidationService.class), serviceConnectionC05852, 1);
    }

    public void stop() {
        if (this.mStopped.compareAndSet(false, true)) {
            this.mExecutor.execute(this.mTearDownRunnable);
        }
    }
}
