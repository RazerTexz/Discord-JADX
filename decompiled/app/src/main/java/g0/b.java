package g0;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AsyncTimeout.kt */
/* loaded from: classes3.dex */
public class b extends y {
    public static final long e;
    public static final long f;
    public static b g;
    public static final a h = new a(null);
    public boolean i;
    public b j;
    public long k;

    /* compiled from: AsyncTimeout.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final b a() throws InterruptedException {
            b bVar = b.g;
            if (bVar == null) {
                d0.z.d.m.throwNpe();
            }
            b bVar2 = bVar.j;
            if (bVar2 == null) {
                long jNanoTime = System.nanoTime();
                b.class.wait(b.e);
                b bVar3 = b.g;
                if (bVar3 == null) {
                    d0.z.d.m.throwNpe();
                }
                if (bVar3.j != null || System.nanoTime() - jNanoTime < b.f) {
                    return null;
                }
                return b.g;
            }
            long jNanoTime2 = bVar2.k - System.nanoTime();
            if (jNanoTime2 > 0) {
                long j = jNanoTime2 / 1000000;
                b.class.wait(j, (int) (jNanoTime2 - (1000000 * j)));
                return null;
            }
            b bVar4 = b.g;
            if (bVar4 == null) {
                d0.z.d.m.throwNpe();
            }
            bVar4.j = bVar2.j;
            bVar2.j = null;
            return bVar2;
        }
    }

    /* compiled from: AsyncTimeout.kt */
    /* renamed from: g0.b$b, reason: collision with other inner class name */
    public static final class C0613b extends Thread {
        public C0613b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            b bVarA;
            while (true) {
                try {
                    synchronized (b.class) {
                        bVarA = b.h.a();
                        if (bVarA == b.g) {
                            b.g = null;
                            return;
                        }
                    }
                    if (bVarA != null) {
                        bVarA.l();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        e = millis;
        f = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void i() {
        b bVar;
        if (!(!this.i)) {
            throw new IllegalStateException("Unbalanced enter/exit".toString());
        }
        long j = this.d;
        boolean z2 = this.f3695b;
        if (j != 0 || z2) {
            this.i = true;
            synchronized (b.class) {
                if (g == null) {
                    g = new b();
                    new C0613b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j != 0 && z2) {
                    this.k = Math.min(j, c() - jNanoTime) + jNanoTime;
                } else if (j != 0) {
                    this.k = j + jNanoTime;
                } else {
                    if (!z2) {
                        throw new AssertionError();
                    }
                    this.k = c();
                }
                long j2 = this.k - jNanoTime;
                b bVar2 = g;
                if (bVar2 == null) {
                    d0.z.d.m.throwNpe();
                }
                while (true) {
                    bVar = bVar2.j;
                    if (bVar == null || j2 < bVar.k - jNanoTime) {
                        break;
                    } else {
                        bVar2 = bVar;
                    }
                }
                this.j = bVar;
                bVar2.j = this;
                if (bVar2 == g) {
                    b.class.notify();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        r2.j = r4.j;
        r4.j = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean j() {
        boolean z2 = false;
        if (!this.i) {
            return false;
        }
        this.i = false;
        synchronized (b.class) {
            b bVar = g;
            while (true) {
                if (bVar == null) {
                    z2 = true;
                    break;
                }
                b bVar2 = bVar.j;
                if (bVar2 == this) {
                    break;
                }
                bVar = bVar2;
            }
        }
        return z2;
    }

    public IOException k(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void l() {
    }
}
