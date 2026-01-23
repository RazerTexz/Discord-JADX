package p637j0.p642l.p643a;

import java.util.Comparator;
import java.util.List;
import p637j0.p642l.p644b.SingleDelayedProducer;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: j0.l.a.o2, reason: use source file name */
/* JADX INFO: compiled from: OperatorToObservableSortedList.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorToObservableSortedList<T> implements Observable.InterfaceC13006b<List<T>, T> {

    /* JADX INFO: renamed from: j */
    public final Comparator<? super T> f26970j;

    /* JADX INFO: renamed from: j0.l.a.o2$a */
    /* JADX INFO: compiled from: OperatorToObservableSortedList.java */
    public class a implements Comparator<T> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Func2 f26971j;

        public a(OperatorToObservableSortedList operatorToObservableSortedList, Func2 func2) {
            this.f26971j = func2;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            return ((Integer) this.f26971j.call(t, t2)).intValue();
        }
    }

    public OperatorToObservableSortedList(Func2<? super T, ? super T, Integer> func2, int i) {
        this.f26970j = new a(this, func2);
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        OperatorToObservableSortedList2 operatorToObservableSortedList2 = new OperatorToObservableSortedList2(this, singleDelayedProducer, subscriber);
        subscriber.add(operatorToObservableSortedList2);
        subscriber.setProducer(singleDelayedProducer);
        return operatorToObservableSortedList2;
    }
}
