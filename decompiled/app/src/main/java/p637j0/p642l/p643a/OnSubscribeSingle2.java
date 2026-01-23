package p637j0.p642l.p643a;

import p637j0.Single2;
import p637j0.SingleSubscriber;
import p658rx.Observable;

/* JADX INFO: renamed from: j0.l.a.e0, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeSingle.java */
/* JADX INFO: loaded from: classes3.dex */
public class OnSubscribeSingle2<T> implements Single2.a<T> {

    /* JADX INFO: renamed from: j */
    public final Observable<T> f26771j;

    public OnSubscribeSingle2(Observable<T> observable) {
        this.f26771j = observable;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        SingleSubscriber singleSubscriber = (SingleSubscriber) obj;
        OnSubscribeSingle onSubscribeSingle = new OnSubscribeSingle(this, singleSubscriber);
        singleSubscriber.f26697j.m11128a(onSubscribeSingle);
        this.f26771j.m11107i0(onSubscribeSingle);
    }
}
