package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.functions.Action0;

/* compiled from: OnSubscribeTimerPeriodically.java */
/* renamed from: j0.l.a.j0, reason: use source file name */
/* loaded from: classes3.dex */
public class OnSubscribeTimerPeriodically implements Action0 {

    /* renamed from: j */
    public long f26854j;

    /* renamed from: k */
    public final /* synthetic */ Subscriber f26855k;

    /* renamed from: l */
    public final /* synthetic */ Scheduler.Worker f26856l;

    public OnSubscribeTimerPeriodically(OnSubscribeTimerPeriodically2 onSubscribeTimerPeriodically2, Subscriber subscriber, Scheduler.Worker worker) {
        this.f26855k = subscriber;
        this.f26856l = worker;
    }

    @Override // p658rx.functions.Action0
    public void call() {
        try {
            Subscriber subscriber = this.f26855k;
            long j = this.f26854j;
            this.f26854j = 1 + j;
            subscriber.onNext(Long.valueOf(j));
        } catch (Throwable th) {
            try {
                this.f26856l.unsubscribe();
            } finally {
                Subscriber subscriber2 = this.f26855k;
                C3404f.m4325o1(th);
                subscriber2.onError(th);
            }
        }
    }
}
