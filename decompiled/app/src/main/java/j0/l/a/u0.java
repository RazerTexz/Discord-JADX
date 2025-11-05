package j0.l.a;

import j0.l.e.m;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/* compiled from: OperatorDistinctUntilChanged.java */
/* loaded from: classes3.dex */
public final class u0<T, U> implements Observable.b<T, T>, Func2<U, U, Boolean> {
    public final j0.k.b<? super T, ? extends U> j;
    public final Func2<? super U, ? super U, Boolean> k;

    /* compiled from: OperatorDistinctUntilChanged.java */
    public static final class a {
        public static final u0<?, ?> a = new u0<>(m.a.INSTANCE);
    }

    public u0(j0.k.b<? super T, ? extends U> bVar) {
        this.j = bVar;
        this.k = this;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new t0(this, subscriber, subscriber);
    }

    @Override // rx.functions.Func2
    public Boolean call(Object obj, Object obj2) {
        return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
    }

    public u0(Func2<? super U, ? super U, Boolean> func2) {
        this.j = m.a.INSTANCE;
        this.k = func2;
    }
}
