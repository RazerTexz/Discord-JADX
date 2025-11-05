package j0.l.a;

import rx.Observable;
import rx.Subscriber;

/* compiled from: EmptyObservableHolder.java */
/* loaded from: classes3.dex */
public enum c implements Observable.a<Object> {
    INSTANCE;

    public static final Observable<Object> k = Observable.h0(INSTANCE);

    @Override // rx.functions.Action1
    public void call(Object obj) {
        ((Subscriber) obj).onCompleted();
    }
}
