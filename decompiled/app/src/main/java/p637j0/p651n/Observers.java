package p637j0.p651n;

import p637j0.Observer2;
import p658rx.exceptions.OnErrorNotImplementedException;

/* compiled from: Observers.java */
/* renamed from: j0.n.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class Observers {

    /* renamed from: a */
    public static final Observer2<Object> f27363a = new a();

    /* compiled from: Observers.java */
    /* renamed from: j0.n.a$a */
    public static class a implements Observer2<Object> {
        @Override // p637j0.Observer2
        public final void onCompleted() {
        }

        @Override // p637j0.Observer2
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // p637j0.Observer2
        public final void onNext(Object obj) {
        }
    }
}
