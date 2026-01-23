package androidx.room;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.InvalidationTracker;
import androidx.view.LiveData;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class RoomTrackingLiveData<T> extends LiveData<T> {
    public final Callable<T> mComputeFunction;
    private final InvalidationLiveDataContainer mContainer;
    public final RoomDatabase mDatabase;
    public final boolean mInTransaction;
    public final InvalidationTracker.Observer mObserver;
    public final AtomicBoolean mInvalid = new AtomicBoolean(true);
    public final AtomicBoolean mComputing = new AtomicBoolean(false);
    public final AtomicBoolean mRegisteredObserver = new AtomicBoolean(false);
    public final Runnable mRefreshRunnable = new RunnableC05941();
    public final Runnable mInvalidationRunnable = new RunnableC05952();

    /* JADX INFO: renamed from: androidx.room.RoomTrackingLiveData$1 */
    public class RunnableC05941 implements Runnable {
        public RunnableC05941() {
        }

        @Override // java.lang.Runnable
        @WorkerThread
        public void run() {
            boolean z2;
            if (RoomTrackingLiveData.this.mRegisteredObserver.compareAndSet(false, true)) {
                RoomTrackingLiveData.this.mDatabase.getInvalidationTracker().addWeakObserver(RoomTrackingLiveData.this.mObserver);
            }
            do {
                if (RoomTrackingLiveData.this.mComputing.compareAndSet(false, true)) {
                    T tCall = null;
                    z2 = false;
                    while (RoomTrackingLiveData.this.mInvalid.compareAndSet(true, false)) {
                        try {
                            try {
                                tCall = RoomTrackingLiveData.this.mComputeFunction.call();
                                z2 = true;
                            } catch (Exception e) {
                                throw new RuntimeException("Exception while computing database live data.", e);
                            }
                        } finally {
                            RoomTrackingLiveData.this.mComputing.set(false);
                        }
                    }
                    if (z2) {
                        RoomTrackingLiveData.access$000(RoomTrackingLiveData.this, tCall);
                    }
                } else {
                    z2 = false;
                }
                if (!z2) {
                    return;
                }
            } while (RoomTrackingLiveData.this.mInvalid.get());
        }
    }

    /* JADX INFO: renamed from: androidx.room.RoomTrackingLiveData$2 */
    public class RunnableC05952 implements Runnable {
        public RunnableC05952() {
        }

        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            boolean zHasActiveObservers = RoomTrackingLiveData.this.hasActiveObservers();
            if (RoomTrackingLiveData.this.mInvalid.compareAndSet(false, true) && zHasActiveObservers) {
                RoomTrackingLiveData.this.getQueryExecutor().execute(RoomTrackingLiveData.this.mRefreshRunnable);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.room.RoomTrackingLiveData$3 */
    public class C05963 extends InvalidationTracker.Observer {
        public C05963(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@NonNull Set<String> set) {
            ArchTaskExecutor.getInstance().executeOnMainThread(RoomTrackingLiveData.this.mInvalidationRunnable);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z2, Callable<T> callable, String[] strArr) {
        this.mDatabase = roomDatabase;
        this.mInTransaction = z2;
        this.mComputeFunction = callable;
        this.mContainer = invalidationLiveDataContainer;
        this.mObserver = new C05963(strArr);
    }

    public static /* synthetic */ void access$000(RoomTrackingLiveData roomTrackingLiveData, Object obj) {
        roomTrackingLiveData.postValue(obj);
    }

    public Executor getQueryExecutor() {
        return this.mInTransaction ? this.mDatabase.getTransactionExecutor() : this.mDatabase.getQueryExecutor();
    }

    @Override // androidx.view.LiveData
    public void onActive() {
        super.onActive();
        this.mContainer.onActive(this);
        getQueryExecutor().execute(this.mRefreshRunnable);
    }

    @Override // androidx.view.LiveData
    public void onInactive() {
        super.onInactive();
        this.mContainer.onInactive(this);
    }
}
