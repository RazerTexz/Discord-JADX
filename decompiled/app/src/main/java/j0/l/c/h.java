package j0.l.c;

import j0.l.c.i;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.functions.Action0;

/* compiled from: SchedulePeriodicHelper.java */
/* loaded from: classes3.dex */
public final class h implements Action0 {
    public long j;
    public long k;
    public long l;
    public final /* synthetic */ long m;
    public final /* synthetic */ long n;
    public final /* synthetic */ Action0 o;
    public final /* synthetic */ j0.l.d.a p;
    public final /* synthetic */ i.a q;
    public final /* synthetic */ Scheduler.Worker r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ long f3790s;

    public h(long j, long j2, Action0 action0, j0.l.d.a aVar, i.a aVar2, Scheduler.Worker worker, long j3) {
        this.m = j;
        this.n = j2;
        this.o = action0;
        this.p = aVar;
        this.q = aVar2;
        this.r = worker;
        this.f3790s = j3;
        this.k = j;
        this.l = j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    @Override // rx.functions.Action0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void call() {
        long nanos;
        long j;
        this.o.call();
        if (this.p.isUnsubscribed()) {
            return;
        }
        i.a aVar = this.q;
        if (aVar != null) {
            nanos = aVar.a();
        } else {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Objects.requireNonNull(this.r);
            nanos = timeUnit.toNanos(System.currentTimeMillis());
        }
        long j2 = i.a;
        long j3 = nanos + j2;
        long j4 = this.k;
        if (j3 >= j4) {
            long j5 = this.f3790s;
            if (nanos >= j4 + j5 + j2) {
                long j6 = this.f3790s;
                j = nanos + j6;
                long j7 = this.j + 1;
                this.j = j7;
                this.l = j - (j6 * j7);
            } else {
                long j8 = this.l;
                long j9 = this.j + 1;
                this.j = j9;
                j = (j9 * j5) + j8;
            }
        }
        this.k = nanos;
        this.p.a(this.r.b(this, j - nanos, TimeUnit.NANOSECONDS));
    }
}
