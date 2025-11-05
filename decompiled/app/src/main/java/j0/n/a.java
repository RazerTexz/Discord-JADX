package j0.n;

import j0.g;
import rx.exceptions.OnErrorNotImplementedException;

/* compiled from: Observers.java */
/* loaded from: classes3.dex */
public final class a {
    public static final g<Object> a = new C0636a();

    /* compiled from: Observers.java */
    /* renamed from: j0.n.a$a, reason: collision with other inner class name */
    public static class C0636a implements g<Object> {
        @Override // j0.g
        public final void onCompleted() {
        }

        @Override // j0.g
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // j0.g
        public final void onNext(Object obj) {
        }
    }
}
