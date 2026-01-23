package p615g0;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: g0.b, reason: use source file name */
/* JADX INFO: compiled from: AsyncTimeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public class AsyncTimeout extends Timeout2 {

    /* JADX INFO: renamed from: e */
    public static final long f26068e;

    /* JADX INFO: renamed from: f */
    public static final long f26069f;

    /* JADX INFO: renamed from: g */
    public static AsyncTimeout f26070g;

    /* JADX INFO: renamed from: h */
    public static final a f26071h = new a(null);

    /* JADX INFO: renamed from: i */
    public boolean f26072i;

    /* JADX INFO: renamed from: j */
    public AsyncTimeout f26073j;

    /* JADX INFO: renamed from: k */
    public long f26074k;

    /* JADX INFO: renamed from: g0.b$a */
    /* JADX INFO: compiled from: AsyncTimeout.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final AsyncTimeout m10426a() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.f26070g;
            if (asyncTimeout == null) {
                Intrinsics3.throwNpe();
            }
            AsyncTimeout asyncTimeout2 = asyncTimeout.f26073j;
            if (asyncTimeout2 == null) {
                long jNanoTime = System.nanoTime();
                AsyncTimeout.class.wait(AsyncTimeout.f26068e);
                AsyncTimeout asyncTimeout3 = AsyncTimeout.f26070g;
                if (asyncTimeout3 == null) {
                    Intrinsics3.throwNpe();
                }
                if (asyncTimeout3.f26073j != null || System.nanoTime() - jNanoTime < AsyncTimeout.f26069f) {
                    return null;
                }
                return AsyncTimeout.f26070g;
            }
            long jNanoTime2 = asyncTimeout2.f26074k - System.nanoTime();
            if (jNanoTime2 > 0) {
                long j = jNanoTime2 / 1000000;
                AsyncTimeout.class.wait(j, (int) (jNanoTime2 - (1000000 * j)));
                return null;
            }
            AsyncTimeout asyncTimeout4 = AsyncTimeout.f26070g;
            if (asyncTimeout4 == null) {
                Intrinsics3.throwNpe();
            }
            asyncTimeout4.f26073j = asyncTimeout2.f26073j;
            asyncTimeout2.f26073j = null;
            return asyncTimeout2;
        }
    }

    /* JADX INFO: renamed from: g0.b$b */
    /* JADX INFO: compiled from: AsyncTimeout.kt */
    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AsyncTimeout asyncTimeoutM10426a;
            while (true) {
                try {
                    synchronized (AsyncTimeout.class) {
                        asyncTimeoutM10426a = AsyncTimeout.f26071h.m10426a();
                        if (asyncTimeoutM10426a == AsyncTimeout.f26070g) {
                            AsyncTimeout.f26070g = null;
                            return;
                        }
                    }
                    if (asyncTimeoutM10426a != null) {
                        asyncTimeoutM10426a.mo10191l();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f26068e = millis;
        f26069f = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: renamed from: i */
    public final void m10424i() {
        AsyncTimeout asyncTimeout;
        if (!(!this.f26072i)) {
            throw new IllegalStateException("Unbalanced enter/exit".toString());
        }
        long j = this.f26136d;
        boolean z2 = this.f26134b;
        if (j != 0 || z2) {
            this.f26072i = true;
            synchronized (AsyncTimeout.class) {
                if (f26070g == null) {
                    f26070g = new AsyncTimeout();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j != 0 && z2) {
                    this.f26074k = Math.min(j, mo10480c() - jNanoTime) + jNanoTime;
                } else if (j != 0) {
                    this.f26074k = j + jNanoTime;
                } else {
                    if (!z2) {
                        throw new AssertionError();
                    }
                    this.f26074k = mo10480c();
                }
                long j2 = this.f26074k - jNanoTime;
                AsyncTimeout asyncTimeout2 = f26070g;
                if (asyncTimeout2 == null) {
                    Intrinsics3.throwNpe();
                }
                while (true) {
                    asyncTimeout = asyncTimeout2.f26073j;
                    if (asyncTimeout == null || j2 < asyncTimeout.f26074k - jNanoTime) {
                        break;
                    } else {
                        asyncTimeout2 = asyncTimeout;
                    }
                }
                this.f26073j = asyncTimeout;
                asyncTimeout2.f26073j = this;
                if (asyncTimeout2 == f26070g) {
                    AsyncTimeout.class.notify();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        r2.f26073j = r4.f26073j;
        r4.f26073j = null;
     */
    /* JADX INFO: renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m10425j() {
        boolean z2 = false;
        if (!this.f26072i) {
            return false;
        }
        this.f26072i = false;
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout = f26070g;
            while (true) {
                if (asyncTimeout == null) {
                    z2 = true;
                    break;
                }
                AsyncTimeout asyncTimeout2 = asyncTimeout.f26073j;
                if (asyncTimeout2 == this) {
                    break;
                }
                asyncTimeout = asyncTimeout2;
            }
        }
        return z2;
    }

    /* JADX INFO: renamed from: k */
    public IOException mo10296k(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX INFO: renamed from: l */
    public void mo10191l() {
    }
}
