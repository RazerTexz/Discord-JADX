package p615g0;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: g0.y, reason: use source file name */
/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Timeout2 {

    /* JADX INFO: renamed from: a */
    public static final Timeout2 f26133a = new a();

    /* JADX INFO: renamed from: b */
    public boolean f26134b;

    /* JADX INFO: renamed from: c */
    public long f26135c;

    /* JADX INFO: renamed from: d */
    public long f26136d;

    /* JADX INFO: renamed from: g0.y$a */
    /* JADX INFO: compiled from: Timeout.kt */
    public static final class a extends Timeout2 {
        @Override // p615g0.Timeout2
        /* JADX INFO: renamed from: d */
        public Timeout2 mo10481d(long j) {
            return this;
        }

        @Override // p615g0.Timeout2
        /* JADX INFO: renamed from: f */
        public void mo10483f() {
        }

        @Override // p615g0.Timeout2
        /* JADX INFO: renamed from: g */
        public Timeout2 mo10484g(long j, TimeUnit timeUnit) {
            Intrinsics3.checkParameterIsNotNull(timeUnit, "unit");
            return this;
        }
    }

    /* JADX INFO: renamed from: a */
    public Timeout2 mo10478a() {
        this.f26134b = false;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public Timeout2 mo10479b() {
        this.f26136d = 0L;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public long mo10480c() {
        if (this.f26134b) {
            return this.f26135c;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    /* JADX INFO: renamed from: d */
    public Timeout2 mo10481d(long j) {
        this.f26134b = true;
        this.f26135c = j;
        return this;
    }

    /* JADX INFO: renamed from: e */
    public boolean mo10482e() {
        return this.f26134b;
    }

    /* JADX INFO: renamed from: f */
    public void mo10483f() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f26134b && this.f26135c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    /* JADX INFO: renamed from: g */
    public Timeout2 mo10484g(long j, TimeUnit timeUnit) {
        Intrinsics3.checkParameterIsNotNull(timeUnit, "unit");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.m877t("timeout < 0: ", j).toString());
        }
        this.f26136d = timeUnit.toNanos(j);
        return this;
    }

    /* JADX INFO: renamed from: h */
    public long mo10485h() {
        return this.f26136d;
    }
}
