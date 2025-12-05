package p637j0.p650m;

import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* compiled from: ConnectableObservable.java */
/* renamed from: j0.m.b, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ConnectableObservable<T> extends Observable<T> {
    public ConnectableObservable(Observable.InterfaceC13005a<T> interfaceC13005a) {
        super(interfaceC13005a);
    }

    /* renamed from: k0 */
    public abstract void mo10753k0(Action1<? super Subscription> action1);
}
