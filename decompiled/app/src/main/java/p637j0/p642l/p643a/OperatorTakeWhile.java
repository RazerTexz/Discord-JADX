package p637j0.p642l.p643a;

import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: j0.l.a.i2, reason: use source file name */
/* JADX INFO: compiled from: OperatorTakeWhile.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorTakeWhile<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final Func2<? super T, ? super Integer, Boolean> f26851j;

    /* JADX INFO: renamed from: j0.l.a.i2$a */
    /* JADX INFO: compiled from: OperatorTakeWhile.java */
    public class a implements Func2<T, Integer, Boolean> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Func1 f26852j;

        public a(Func1 func1) {
            this.f26852j = func1;
        }

        @Override // p658rx.functions.Func2
        public Boolean call(Object obj, Integer num) {
            return (Boolean) this.f26852j.call(obj);
        }
    }

    public OperatorTakeWhile(Func1<? super T, Boolean> func1) {
        this.f26851j = new a(func1);
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        OperatorTakeWhile2 operatorTakeWhile2 = new OperatorTakeWhile2(this, subscriber, false, subscriber);
        subscriber.add(operatorTakeWhile2);
        return operatorTakeWhile2;
    }
}
