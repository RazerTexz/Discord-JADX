package p007b.p085c.p086a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: renamed from: b.c.a.r, reason: use source file name */
/* JADX INFO: compiled from: LottieTask.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieTask2<T> {

    /* JADX INFO: renamed from: a */
    public static Executor f2452a = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: b */
    public final Set<LottieListener<T>> f2453b = new LinkedHashSet(1);

    /* JADX INFO: renamed from: c */
    public final Set<LottieListener<Throwable>> f2454c = new LinkedHashSet(1);

    /* JADX INFO: renamed from: d */
    public final Handler f2455d = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e */
    @Nullable
    public volatile LottieResult<T> f2456e = null;

    /* JADX INFO: renamed from: b.c.a.r$a */
    /* JADX INFO: compiled from: LottieTask.java */
    public class a extends FutureTask<LottieResult<T>> {
        public a(Callable<LottieResult<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                LottieTask2.this.m707c(get());
            } catch (InterruptedException | ExecutionException e) {
                LottieTask2.this.m707c(new LottieResult<>(e));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieTask2(Callable<LottieResult<T>> callable) {
        f2452a.execute(new a(callable));
    }

    /* JADX INFO: renamed from: a */
    public synchronized LottieTask2<T> m705a(LottieListener<Throwable> lottieListener) {
        if (this.f2456e != null && this.f2456e.f2450b != null) {
            lottieListener.mo680a(this.f2456e.f2450b);
        }
        this.f2454c.add(lottieListener);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public synchronized LottieTask2<T> m706b(LottieListener<T> lottieListener) {
        if (this.f2456e != null && this.f2456e.f2449a != null) {
            lottieListener.mo680a(this.f2456e.f2449a);
        }
        this.f2453b.add(lottieListener);
        return this;
    }

    /* JADX INFO: renamed from: c */
    public final void m707c(@Nullable LottieResult<T> lottieResult) {
        if (this.f2456e != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f2456e = lottieResult;
        this.f2455d.post(new LottieTask(this));
    }
}
