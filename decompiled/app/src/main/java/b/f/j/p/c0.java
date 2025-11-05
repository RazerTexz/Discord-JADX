package b.f.j.p;

import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: JobScheduler.java */
/* loaded from: classes3.dex */
public class c0 {
    public final Executor a;

    /* renamed from: b, reason: collision with root package name */
    public final c f606b;
    public final int e;
    public final Runnable c = new a();
    public final Runnable d = new b();

    @VisibleForTesting
    public b.f.j.j.e f = null;

    @VisibleForTesting
    public int g = 0;

    @VisibleForTesting
    public int h = 1;

    @VisibleForTesting
    public long i = 0;

    @VisibleForTesting
    public long j = 0;

    /* compiled from: JobScheduler.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.f.j.j.e eVar;
            int i;
            c0 c0Var = c0.this;
            Objects.requireNonNull(c0Var);
            long jUptimeMillis = SystemClock.uptimeMillis();
            synchronized (c0Var) {
                eVar = c0Var.f;
                i = c0Var.g;
                c0Var.f = null;
                c0Var.g = 0;
                c0Var.h = 3;
                c0Var.j = jUptimeMillis;
            }
            try {
                if (c0.e(eVar, i)) {
                    c0Var.f606b.a(eVar, i);
                }
            } finally {
                if (eVar != null) {
                    eVar.close();
                }
                c0Var.c();
            }
        }
    }

    /* compiled from: JobScheduler.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c0 c0Var = c0.this;
            c0Var.a.execute(c0Var.c);
        }
    }

    /* compiled from: JobScheduler.java */
    public interface c {
        void a(b.f.j.j.e eVar, int i);
    }

    public c0(Executor executor, c cVar, int i) {
        this.a = executor;
        this.f606b = cVar;
        this.e = i;
    }

    public static boolean e(b.f.j.j.e eVar, int i) {
        return b.f.j.p.b.e(i) || b.f.j.p.b.m(i, 4) || b.f.j.j.e.u(eVar);
    }

    public void a() {
        b.f.j.j.e eVar;
        synchronized (this) {
            eVar = this.f;
            this.f = null;
            this.g = 0;
        }
        if (eVar != null) {
            eVar.close();
        }
    }

    public final void b(long j) {
        Runnable runnable = this.d;
        if (j <= 0) {
            runnable.run();
            return;
        }
        if (b.c.a.a0.d.f329b == null) {
            b.c.a.a0.d.f329b = Executors.newSingleThreadScheduledExecutor();
        }
        b.c.a.a0.d.f329b.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public final void c() {
        boolean z2;
        long jMax;
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            z2 = true;
            if (this.h == 4) {
                jMax = Math.max(this.j + this.e, jUptimeMillis);
                this.i = jUptimeMillis;
                this.h = 2;
            } else {
                this.h = 1;
                jMax = 0;
                z2 = false;
            }
        }
        if (z2) {
            b(jMax - jUptimeMillis);
        }
    }

    public boolean d() {
        long jMax;
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            boolean z2 = false;
            if (!e(this.f, this.g)) {
                return false;
            }
            int iH = b.c.a.y.b.h(this.h);
            if (iH != 0) {
                if (iH == 2) {
                    this.h = 4;
                }
                jMax = 0;
            } else {
                jMax = Math.max(this.j + this.e, jUptimeMillis);
                this.i = jUptimeMillis;
                this.h = 2;
                z2 = true;
            }
            if (z2) {
                b(jMax - jUptimeMillis);
            }
            return true;
        }
    }

    public boolean f(b.f.j.j.e eVar, int i) {
        b.f.j.j.e eVar2;
        if (!e(eVar, i)) {
            return false;
        }
        synchronized (this) {
            eVar2 = this.f;
            this.f = b.f.j.j.e.a(eVar);
            this.g = i;
        }
        if (eVar2 == null) {
            return true;
        }
        eVar2.close();
        return true;
    }
}
