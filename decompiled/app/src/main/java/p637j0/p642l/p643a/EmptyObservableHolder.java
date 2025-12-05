package p637j0.p642l.p643a;

import p658rx.Observable;
import p658rx.Subscriber;

/* compiled from: EmptyObservableHolder.java */
/* renamed from: j0.l.a.c, reason: use source file name */
/* loaded from: classes3.dex */
public enum EmptyObservableHolder implements Observable.InterfaceC13005a<Object> {
    INSTANCE;


    /* renamed from: k */
    public static final Observable<Object> f26751k = Observable.m11074h0(INSTANCE);

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        ((Subscriber) obj).onCompleted();
    }
}
