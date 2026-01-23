package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Subscriber;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.h0, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeTimerOnce.java */
/* JADX INFO: loaded from: classes3.dex */
public class OnSubscribeTimerOnce implements Action0 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Subscriber f26829j;

    public OnSubscribeTimerOnce(OnSubscribeTimerOnce2 onSubscribeTimerOnce2, Subscriber subscriber) {
        this.f26829j = subscriber;
    }

    @Override // p658rx.functions.Action0
    public void call() {
        try {
            this.f26829j.onNext(0L);
            this.f26829j.onCompleted();
        } catch (Throwable th) {
            Subscriber subscriber = this.f26829j;
            C3404f.m4325o1(th);
            subscriber.onError(th);
        }
    }
}
