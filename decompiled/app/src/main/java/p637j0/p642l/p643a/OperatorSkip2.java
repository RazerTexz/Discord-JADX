package p637j0.p642l.p643a;

import p007b.p100d.p104b.p105a.outline;
import p658rx.Observable;
import p658rx.Subscriber;

/* compiled from: OperatorSkip.java */
/* renamed from: j0.l.a.t1, reason: use source file name */
/* loaded from: classes3.dex */
public final class OperatorSkip2<T> implements Observable.InterfaceC13006b<T, T> {

    /* renamed from: j */
    public final int f27054j;

    public OperatorSkip2(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(outline.m871q("n >= 0 required but it was ", i));
        }
        this.f27054j = i;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new OperatorSkip(this, subscriber, subscriber);
    }
}
