package j0.l.a;

import rx.Observable;
import rx.Subscriber;

/* compiled from: OnSubscribeThrow.java */
/* loaded from: classes3.dex */
public final class f0<T> implements Observable.a<T> {
    public final Throwable j;

    public f0(Throwable th) {
        this.j = th;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        ((Subscriber) obj).onError(this.j);
    }
}
