package p007b.p225i.p361c.p401u.p403p;

import androidx.annotation.GuardedBy;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import p007b.p225i.p361c.p401u.Utils6;

/* JADX INFO: renamed from: b.i.c.u.p.e, reason: use source file name */
/* JADX INFO: compiled from: RequestLimiter.java */
/* JADX INFO: loaded from: classes3.dex */
public class RequestLimiter {

    /* JADX INFO: renamed from: a */
    public static final long f12998a = TimeUnit.HOURS.toMillis(24);

    /* JADX INFO: renamed from: b */
    public static final long f12999b = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: c */
    public final Utils6 f13000c = Utils6.m6770c();

    /* JADX INFO: renamed from: d */
    @GuardedBy("this")
    public long f13001d;

    /* JADX INFO: renamed from: e */
    @GuardedBy("this")
    public int f13002e;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean m6811a() {
        boolean z2;
        if (this.f13002e != 0) {
            z2 = this.f13000c.m6771a() > this.f13001d;
        }
        return z2;
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m6812b(int i) {
        long jMin;
        boolean z2 = false;
        if ((i >= 200 && i < 300) || i == 401 || i == 404) {
            synchronized (this) {
                this.f13002e = 0;
            }
            return;
        }
        this.f13002e++;
        synchronized (this) {
            if (i == 429 || (i >= 500 && i < 600)) {
                z2 = true;
            }
            if (z2) {
                double dPow = Math.pow(2.0d, this.f13002e);
                Objects.requireNonNull(this.f13000c);
                jMin = (long) Math.min(dPow + ((long) (Math.random() * 1000.0d)), f12999b);
            } else {
                jMin = f12998a;
            }
            this.f13001d = this.f13000c.m6771a() + jMin;
        }
        return;
    }
}
