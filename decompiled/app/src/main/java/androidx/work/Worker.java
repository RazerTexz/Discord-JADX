package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import p007b.p225i.p355b.p359d.p360a.ListenableFuture8;

/* loaded from: classes.dex */
public abstract class Worker extends ListenableWorker {
    public SettableFuture<ListenableWorker.Result> mFuture;

    /* renamed from: androidx.work.Worker$1 */
    public class RunnableC07201 implements Runnable {
        public RunnableC07201() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Worker.this.mFuture.set(Worker.this.doWork());
            } catch (Throwable th) {
                Worker.this.mFuture.setException(th);
            }
        }
    }

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public Worker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @NonNull
    @WorkerThread
    public abstract ListenableWorker.Result doWork();

    @Override // androidx.work.ListenableWorker
    @NonNull
    public final ListenableFuture8<ListenableWorker.Result> startWork() {
        this.mFuture = SettableFuture.create();
        getBackgroundExecutor().execute(new RunnableC07201());
        return this.mFuture;
    }
}
