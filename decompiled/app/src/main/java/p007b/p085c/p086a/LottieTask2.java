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

/* compiled from: LottieTask.java */
/* renamed from: b.c.a.r, reason: use source file name */
/* loaded from: classes.dex */
public class LottieTask2<T> {

    /* renamed from: a */
    public static Executor f2452a = Executors.newCachedThreadPool();

    /* renamed from: b */
    public final Set<LottieListener<T>> f2453b = new LinkedHashSet(1);

    /* renamed from: c */
    public final Set<LottieListener<Throwable>> f2454c = new LinkedHashSet(1);

    /* renamed from: d */
    public final Handler f2455d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    @Nullable
    public volatile LottieResult<T> f2456e = null;

    /* compiled from: LottieTask.java */
    /* renamed from: b.c.a.r$a */
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

    /* renamed from: a */
    public synchronized LottieTask2<T> m705a(LottieListener<Throwable> lottieListener) {
        if (this.f2456e != null && this.f2456e.f2450b != null) {
            lottieListener.mo680a(this.f2456e.f2450b);
        }
        this.f2454c.add(lottieListener);
        return this;
    }

    /* renamed from: b */
    public synchronized LottieTask2<T> m706b(LottieListener<T> lottieListener) {
        if (this.f2456e != null && this.f2456e.f2449a != null) {
            lottieListener.mo680a(this.f2456e.f2449a);
        }
        this.f2453b.add(lottieListener);
        return this;
    }

    /* renamed from: c */
    public final void m707c(@Nullable LottieResult<T> lottieResult) {
        if (this.f2456e != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f2456e = lottieResult;
        this.f2455d.post(new LottieTask(this));
    }
}
