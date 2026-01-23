package androidx.view;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ComputableLiveData<T> {
    public final AtomicBoolean mComputing;
    public final Executor mExecutor;
    public final AtomicBoolean mInvalid;

    @VisibleForTesting
    public final Runnable mInvalidationRunnable;
    public final LiveData<T> mLiveData;

    @VisibleForTesting
    public final Runnable mRefreshRunnable;

    /* JADX INFO: renamed from: androidx.lifecycle.ComputableLiveData$1 */
    public class C04261 extends LiveData<T> {
        public C04261() {
        }

        @Override // androidx.view.LiveData
        public void onActive() {
            ComputableLiveData computableLiveData = ComputableLiveData.this;
            computableLiveData.mExecutor.execute(computableLiveData.mRefreshRunnable);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.ComputableLiveData$2 */
    public class RunnableC04272 implements Runnable {
        public RunnableC04272() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        @WorkerThread
        public void run() {
            do {
                boolean z2 = false;
                if (ComputableLiveData.this.mComputing.compareAndSet(false, true)) {
                    Object objCompute = null;
                    boolean z3 = false;
                    while (ComputableLiveData.this.mInvalid.compareAndSet(true, false)) {
                        try {
                            objCompute = ComputableLiveData.this.compute();
                            z3 = true;
                        } catch (Throwable th) {
                            ComputableLiveData.this.mComputing.set(false);
                            throw th;
                        }
                    }
                    if (z3) {
                        ComputableLiveData.this.mLiveData.postValue(objCompute);
                    }
                    ComputableLiveData.this.mComputing.set(false);
                    z2 = z3;
                }
                if (!z2) {
                    return;
                }
            } while (ComputableLiveData.this.mInvalid.get());
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.ComputableLiveData$3 */
    public class RunnableC04283 implements Runnable {
        public RunnableC04283() {
        }

        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            boolean zHasActiveObservers = ComputableLiveData.this.mLiveData.hasActiveObservers();
            if (ComputableLiveData.this.mInvalid.compareAndSet(false, true) && zHasActiveObservers) {
                ComputableLiveData computableLiveData = ComputableLiveData.this;
                computableLiveData.mExecutor.execute(computableLiveData.mRefreshRunnable);
            }
        }
    }

    public ComputableLiveData() {
        this(ArchTaskExecutor.getIOThreadExecutor());
    }

    @WorkerThread
    public abstract T compute();

    @NonNull
    public LiveData<T> getLiveData() {
        return this.mLiveData;
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.mInvalidationRunnable);
    }

    public ComputableLiveData(@NonNull Executor executor) {
        this.mInvalid = new AtomicBoolean(true);
        this.mComputing = new AtomicBoolean(false);
        this.mRefreshRunnable = new RunnableC04272();
        this.mInvalidationRunnable = new RunnableC04283();
        this.mExecutor = executor;
        this.mLiveData = new C04261();
    }
}
