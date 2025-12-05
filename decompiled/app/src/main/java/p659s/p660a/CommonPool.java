package p659s.p660a;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Executors;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p512d0._Ranges;
import p507d0.p579g0.StringNumberConversions;

/* compiled from: CommonPool.kt */
/* renamed from: s.a.s, reason: use source file name */
/* loaded from: classes3.dex */
public final class CommonPool extends Executors {

    /* renamed from: j */
    public static final int f27897j;

    /* renamed from: k */
    public static final CommonPool f27898k = new CommonPool();
    public static volatile Executor pool;

    /* compiled from: CommonPool.kt */
    /* renamed from: s.a.s$a */
    public static final class a implements ThreadFactory {

        /* renamed from: j */
        public final /* synthetic */ AtomicInteger f27899j;

        public a(AtomicInteger atomicInteger) {
            this.f27899j = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            StringBuilder sbM833U = outline.m833U("CommonPool-worker-");
            sbM833U.append(this.f27899j.incrementAndGet());
            Thread thread = new Thread(runnable, sbM833U.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    static {
        String property;
        int iIntValue;
        try {
            property = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            property = null;
        }
        if (property != null) {
            Integer intOrNull = StringNumberConversions.toIntOrNull(property);
            if (intOrNull == null || intOrNull.intValue() < 1) {
                throw new IllegalStateException(outline.m883w("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", property).toString());
            }
            iIntValue = intOrNull.intValue();
        } else {
            iIntValue = -1;
        }
        f27897j = iIntValue;
    }

    /* renamed from: I */
    public final ExecutorService m11345I() {
        return java.util.concurrent.Executors.newFixedThreadPool(m11347L(), new a(new AtomicInteger()));
    }

    /* renamed from: J */
    public final ExecutorService m11346J() {
        Class<?> cls;
        ExecutorService executorService;
        Integer num;
        if (System.getSecurityManager() != null) {
            return m11345I();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return m11345I();
        }
        if (f27897j < 0) {
            try {
                Method method = cls.getMethod("commonPool", new Class[0]);
                Object objInvoke = method != null ? method.invoke(null, new Object[0]) : null;
                if (!(objInvoke instanceof ExecutorService)) {
                    objInvoke = null;
                }
                executorService = (ExecutorService) objInvoke;
            } catch (Throwable unused2) {
                executorService = null;
            }
            if (executorService != null) {
                Objects.requireNonNull(f27898k);
                executorService.submit(CommonPool2.f27902j);
                try {
                    Object objInvoke2 = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
                    if (!(objInvoke2 instanceof Integer)) {
                        objInvoke2 = null;
                    }
                    num = (Integer) objInvoke2;
                } catch (Throwable unused3) {
                    num = null;
                }
                if (!(num != null && num.intValue() >= 1)) {
                    executorService = null;
                }
                if (executorService != null) {
                    return executorService;
                }
            }
        }
        try {
            Object objNewInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(f27898k.m11347L()));
            if (!(objNewInstance instanceof ExecutorService)) {
                objNewInstance = null;
            }
            executorService2 = (ExecutorService) objNewInstance;
        } catch (Throwable unused4) {
        }
        return executorService2 != null ? executorService2 : m11345I();
    }

    /* renamed from: L */
    public final int m11347L() {
        Integer numValueOf = Integer.valueOf(f27897j);
        if (!(numValueOf.intValue() > 0)) {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : _Ranges.coerceAtLeast(Runtime.getRuntime().availableProcessors() - 1, 1);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            Executor executorM11346J = pool;
            if (executorM11346J == null) {
                synchronized (this) {
                    executorM11346J = pool;
                    if (executorM11346J == null) {
                        executorM11346J = m11346J();
                        pool = executorM11346J;
                    }
                }
            }
            executorM11346J.execute(runnable);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.f27779q.m11341T(runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "CommonPool";
    }
}
