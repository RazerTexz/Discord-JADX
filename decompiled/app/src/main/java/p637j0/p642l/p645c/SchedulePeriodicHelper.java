package p637j0.p642l.p645c;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import p637j0.p642l.p645c.SchedulePeriodicHelper2;
import p637j0.p642l.p646d.SequentialSubscription;
import p658rx.Scheduler;
import p658rx.functions.Action0;

/* compiled from: SchedulePeriodicHelper.java */
/* renamed from: j0.l.c.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class SchedulePeriodicHelper implements Action0 {

    /* renamed from: j */
    public long f27231j;

    /* renamed from: k */
    public long f27232k;

    /* renamed from: l */
    public long f27233l;

    /* renamed from: m */
    public final /* synthetic */ long f27234m;

    /* renamed from: n */
    public final /* synthetic */ long f27235n;

    /* renamed from: o */
    public final /* synthetic */ Action0 f27236o;

    /* renamed from: p */
    public final /* synthetic */ SequentialSubscription f27237p;

    /* renamed from: q */
    public final /* synthetic */ SchedulePeriodicHelper2.a f27238q;

    /* renamed from: r */
    public final /* synthetic */ Scheduler.Worker f27239r;

    /* renamed from: s */
    public final /* synthetic */ long f27240s;

    public SchedulePeriodicHelper(long j, long j2, Action0 action0, SequentialSubscription sequentialSubscription, SchedulePeriodicHelper2.a aVar, Scheduler.Worker worker, long j3) {
        this.f27234m = j;
        this.f27235n = j2;
        this.f27236o = action0;
        this.f27237p = sequentialSubscription;
        this.f27238q = aVar;
        this.f27239r = worker;
        this.f27240s = j3;
        this.f27232k = j;
        this.f27233l = j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    @Override // p658rx.functions.Action0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void call() {
        long nanos;
        long j;
        this.f27236o.call();
        if (this.f27237p.isUnsubscribed()) {
            return;
        }
        SchedulePeriodicHelper2.a aVar = this.f27238q;
        if (aVar != null) {
            nanos = aVar.m10806a();
        } else {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Objects.requireNonNull(this.f27239r);
            nanos = timeUnit.toNanos(System.currentTimeMillis());
        }
        long j2 = SchedulePeriodicHelper2.f27241a;
        long j3 = nanos + j2;
        long j4 = this.f27232k;
        if (j3 >= j4) {
            long j5 = this.f27240s;
            if (nanos >= j4 + j5 + j2) {
                long j6 = this.f27240s;
                j = nanos + j6;
                long j7 = this.f27231j + 1;
                this.f27231j = j7;
                this.f27233l = j - (j6 * j7);
            } else {
                long j8 = this.f27233l;
                long j9 = this.f27231j + 1;
                this.f27231j = j9;
                j = (j9 * j5) + j8;
            }
        }
        this.f27232k = nanos;
        this.f27237p.m10809a(this.f27239r.mo10741b(this, j - nanos, TimeUnit.NANOSECONDS));
    }
}
