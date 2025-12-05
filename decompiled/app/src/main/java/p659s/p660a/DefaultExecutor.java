package p659s.p660a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import p507d0.p512d0._Ranges;
import p659s.p660a.AbstractC13145r0;

/* compiled from: DefaultExecutor.kt */
/* renamed from: s.a.d0, reason: use source file name */
/* loaded from: classes3.dex */
public final class DefaultExecutor extends AbstractC13145r0 implements Runnable {
    public static volatile Thread _thread;
    public static volatile int debugStatus;

    /* renamed from: p */
    public static final long f27778p;

    /* renamed from: q */
    public static final DefaultExecutor f27779q;

    static {
        Long l;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        f27779q = defaultExecutor;
        defaultExecutor.m11337L(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        f27778p = timeUnit.toNanos(l.longValue());
    }

    @Override // p659s.p660a.EventLoop2
    /* renamed from: S */
    public Thread mo11243S() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }

    /* renamed from: X */
    public final synchronized void m11244X() {
        if (m11245b0()) {
            debugStatus = 3;
            this._queue = null;
            this._delayed = null;
            notifyAll();
        }
    }

    /* renamed from: b0 */
    public final boolean m11245b0() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z2;
        boolean zM11343V;
        C13161w1 c13161w1 = C13161w1.f27916b;
        C13161w1.f27915a.set(this);
        try {
            synchronized (this) {
                if (m11245b0()) {
                    z2 = false;
                } else {
                    z2 = true;
                    debugStatus = 1;
                    notifyAll();
                }
            }
            if (!z2) {
                if (zM11343V) {
                    return;
                } else {
                    return;
                }
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jMo11339O = mo11339O();
                if (jMo11339O == RecyclerView.FOREVER_NS) {
                    long jNanoTime = System.nanoTime();
                    if (j == RecyclerView.FOREVER_NS) {
                        j = f27778p + jNanoTime;
                    }
                    long j2 = j - jNanoTime;
                    if (j2 <= 0) {
                        _thread = null;
                        m11244X();
                        if (m11343V()) {
                            return;
                        }
                        mo11243S();
                        return;
                    }
                    jMo11339O = _Ranges.coerceAtMost(jMo11339O, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (jMo11339O > 0) {
                    if (m11245b0()) {
                        _thread = null;
                        m11244X();
                        if (m11343V()) {
                            return;
                        }
                        mo11243S();
                        return;
                    }
                    LockSupport.parkNanos(this, jMo11339O);
                }
            }
        } finally {
            _thread = null;
            m11244X();
            if (!m11343V()) {
                mo11243S();
            }
        }
    }

    @Override // p659s.p660a.AbstractC13145r0, p659s.p660a.Delay
    /* renamed from: x */
    public Job2 mo11196x(long j, Runnable runnable, CoroutineContext coroutineContext) {
        long jM11348a = C13151t0.m11348a(j);
        if (jM11348a >= 4611686018427387903L) {
            return Job3.f27880j;
        }
        long jNanoTime = System.nanoTime();
        AbstractC13145r0.b bVar = new AbstractC13145r0.b(jM11348a + jNanoTime, runnable);
        m11344W(jNanoTime, bVar);
        return bVar;
    }
}
