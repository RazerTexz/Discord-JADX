package p007b.p225i.p226a.p242c.p259f3;

import androidx.annotation.GuardedBy;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.permission.Permission;
import java.util.Objects;

/* compiled from: TimestampAdjuster.java */
/* renamed from: b.i.a.c.f3.d0, reason: use source file name */
/* loaded from: classes3.dex */
public final class TimestampAdjuster {

    /* renamed from: a */
    @GuardedBy("this")
    public long f6700a;

    /* renamed from: b */
    @GuardedBy("this")
    public long f6701b;

    /* renamed from: c */
    @GuardedBy("this")
    public long f6702c;

    /* renamed from: d */
    public final ThreadLocal<Long> f6703d = new ThreadLocal<>();

    public TimestampAdjuster(long j) {
        m2976e(j);
    }

    /* renamed from: a */
    public synchronized long m2972a(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f6701b == -9223372036854775807L) {
            long jLongValue = this.f6700a;
            if (jLongValue == 9223372036854775806L) {
                Long l = this.f6703d.get();
                Objects.requireNonNull(l);
                jLongValue = l.longValue();
            }
            this.f6701b = jLongValue - j;
            notifyAll();
        }
        this.f6702c = j;
        return j + this.f6701b;
    }

    /* renamed from: b */
    public synchronized long m2973b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = this.f6702c;
        if (j2 != -9223372036854775807L) {
            long j3 = (j2 * 90000) / 1000000;
            long j4 = (Permission.REQUEST_TO_SPEAK + j3) / Permission.MANAGE_EVENTS;
            long j5 = ((j4 - 1) * Permission.MANAGE_EVENTS) + j;
            long j6 = (j4 * Permission.MANAGE_EVENTS) + j;
            j = Math.abs(j5 - j3) < Math.abs(j6 - j3) ? j5 : j6;
        }
        return m2972a((j * 1000000) / 90000);
    }

    /* renamed from: c */
    public synchronized long m2974c() {
        long j;
        j = this.f6700a;
        if (j == RecyclerView.FOREVER_NS || j == 9223372036854775806L) {
            j = -9223372036854775807L;
        }
        return j;
    }

    /* renamed from: d */
    public synchronized long m2975d() {
        return this.f6701b;
    }

    /* renamed from: e */
    public synchronized void m2976e(long j) {
        this.f6700a = j;
        this.f6701b = j == RecyclerView.FOREVER_NS ? 0L : -9223372036854775807L;
        this.f6702c = -9223372036854775807L;
    }
}
