package p007b.p225i.p226a.p288f.p291b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Process;
import java.lang.Thread;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p313h.p323j.C3514f1;

@SuppressLint({"StaticFieldLeak"})
/* renamed from: b.i.a.f.b.f */
/* loaded from: classes3.dex */
public final class C3180f {

    /* renamed from: a */
    public static volatile C3180f f9195a;

    /* renamed from: b */
    public final Context f9196b;

    /* renamed from: c */
    public final a f9197c;

    /* renamed from: d */
    public volatile C3514f1 f9198d;

    /* renamed from: e */
    public Thread.UncaughtExceptionHandler f9199e;

    /* renamed from: b.i.a.f.b.f$a */
    public class a extends ThreadPoolExecutor {
        public a() {
            super(1, 1, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
            setThreadFactory(new b(null));
            allowCoreThreadTimeOut(true);
        }

        @Override // java.util.concurrent.AbstractExecutorService
        public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new C3182h(this, runnable, t);
        }
    }

    /* renamed from: b.i.a.f.b.f$b */
    public static class b implements ThreadFactory {

        /* renamed from: j */
        public static final AtomicInteger f9201j = new AtomicInteger();

        public b(RunnableC3181g runnableC3181g) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new c(runnable, outline.m851g(23, "measurement-", f9201j.incrementAndGet()));
        }
    }

    /* renamed from: b.i.a.f.b.f$c */
    public static class c extends Thread {
        public c(Runnable runnable, String str) {
            super(runnable, str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    public C3180f(Context context) {
        Context applicationContext = context.getApplicationContext();
        Objects.requireNonNull(applicationContext, "null reference");
        this.f9196b = applicationContext;
        this.f9197c = new a();
        new CopyOnWriteArrayList();
        new C3178d();
    }

    /* renamed from: b */
    public static void m3967b() {
        if (!(Thread.currentThread() instanceof c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    /* renamed from: a */
    public final void m3968a(Runnable runnable) {
        this.f9197c.submit(runnable);
    }
}
