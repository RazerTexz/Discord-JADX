package p686z;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: BoltsExecutors.java */
/* renamed from: z.b, reason: use source file name */
/* loaded from: classes.dex */
public final class BoltsExecutors {

    /* renamed from: a */
    public static final BoltsExecutors f27965a = new BoltsExecutors();

    /* renamed from: b */
    public final ExecutorService f27966b;

    /* renamed from: c */
    public final Executor f27967c;

    /* compiled from: BoltsExecutors.java */
    /* renamed from: z.b$b */
    public static class b implements Executor {

        /* renamed from: j */
        public ThreadLocal<Integer> f27968j = new ThreadLocal<>();

        public b(a aVar) {
        }

        /* renamed from: a */
        public final int m11365a() {
            Integer num = this.f27968j.get();
            if (num == null) {
                num = 0;
            }
            int iIntValue = num.intValue() - 1;
            if (iIntValue == 0) {
                this.f27968j.remove();
            } else {
                this.f27968j.set(Integer.valueOf(iIntValue));
            }
            return iIntValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Integer num = this.f27968j.get();
            if (num == null) {
                num = 0;
            }
            int iIntValue = num.intValue() + 1;
            this.f27968j.set(Integer.valueOf(iIntValue));
            try {
                if (iIntValue <= 15) {
                    runnable.run();
                } else {
                    BoltsExecutors.f27965a.f27966b.execute(runnable);
                }
            } finally {
                m11365a();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.concurrent.ExecutorService] */
    public BoltsExecutors() {
        ThreadPoolExecutor threadPoolExecutorNewCachedThreadPool;
        String property = System.getProperty("java.runtime.name");
        if (property == null ? false : property.toLowerCase(Locale.US).contains("android")) {
            AndroidExecutors androidExecutors = AndroidExecutors.f27960a;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(AndroidExecutors.f27962c, AndroidExecutors.f27963d, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            threadPoolExecutorNewCachedThreadPool = threadPoolExecutor;
        } else {
            threadPoolExecutorNewCachedThreadPool = Executors.newCachedThreadPool();
        }
        this.f27966b = threadPoolExecutorNewCachedThreadPool;
        Executors.newSingleThreadScheduledExecutor();
        this.f27967c = new b(null);
    }
}
