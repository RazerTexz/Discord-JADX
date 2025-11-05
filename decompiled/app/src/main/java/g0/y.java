package g0;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout.kt */
/* loaded from: classes3.dex */
public class y {
    public static final y a = new a();

    /* renamed from: b, reason: collision with root package name */
    public boolean f3695b;
    public long c;
    public long d;

    /* compiled from: Timeout.kt */
    public static final class a extends y {
        @Override // g0.y
        public y d(long j) {
            return this;
        }

        @Override // g0.y
        public void f() {
        }

        @Override // g0.y
        public y g(long j, TimeUnit timeUnit) {
            d0.z.d.m.checkParameterIsNotNull(timeUnit, "unit");
            return this;
        }
    }

    public y a() {
        this.f3695b = false;
        return this;
    }

    public y b() {
        this.d = 0L;
        return this;
    }

    public long c() {
        if (this.f3695b) {
            return this.c;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public y d(long j) {
        this.f3695b = true;
        this.c = j;
        return this;
    }

    public boolean e() {
        return this.f3695b;
    }

    public void f() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f3695b && this.c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public y g(long j, TimeUnit timeUnit) {
        d0.z.d.m.checkParameterIsNotNull(timeUnit, "unit");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.t("timeout < 0: ", j).toString());
        }
        this.d = timeUnit.toNanos(j);
        return this;
    }

    public long h() {
        return this.d;
    }
}
