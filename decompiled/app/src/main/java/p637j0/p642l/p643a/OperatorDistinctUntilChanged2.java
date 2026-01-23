package p637j0.p642l.p643a;

import p637j0.p641k.Func1;
import p637j0.p642l.p647e.UtilityFunctions;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: j0.l.a.u0, reason: use source file name */
/* JADX INFO: compiled from: OperatorDistinctUntilChanged.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorDistinctUntilChanged2<T, U> implements Observable.InterfaceC13006b<T, T>, Func2<U, U, Boolean> {

    /* JADX INFO: renamed from: j */
    public final Func1<? super T, ? extends U> f27057j;

    /* JADX INFO: renamed from: k */
    public final Func2<? super U, ? super U, Boolean> f27058k;

    /* JADX INFO: renamed from: j0.l.a.u0$a */
    /* JADX INFO: compiled from: OperatorDistinctUntilChanged.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final OperatorDistinctUntilChanged2<?, ?> f27059a = new OperatorDistinctUntilChanged2<>(UtilityFunctions.a.INSTANCE);
    }

    public OperatorDistinctUntilChanged2(Func1<? super T, ? extends U> func1) {
        this.f27057j = func1;
        this.f27058k = this;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new OperatorDistinctUntilChanged(this, subscriber, subscriber);
    }

    @Override // p658rx.functions.Func2
    public Boolean call(Object obj, Object obj2) {
        return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
    }

    public OperatorDistinctUntilChanged2(Func2<? super U, ? super U, Boolean> func2) {
        this.f27057j = UtilityFunctions.a.INSTANCE;
        this.f27058k = func2;
    }
}
