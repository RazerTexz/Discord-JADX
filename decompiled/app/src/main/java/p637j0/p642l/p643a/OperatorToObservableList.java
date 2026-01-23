package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p644b.SingleDelayedProducer;
import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.m2, reason: use source file name */
/* JADX INFO: compiled from: OperatorToObservableList.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorToObservableList<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public boolean f26912j;

    /* JADX INFO: renamed from: k */
    public List<T> f26913k = new LinkedList();

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ SingleDelayedProducer f26914l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ Subscriber f26915m;

    public OperatorToObservableList(OperatorToObservableList2 operatorToObservableList2, SingleDelayedProducer singleDelayedProducer, Subscriber subscriber) {
        this.f26914l = singleDelayedProducer;
        this.f26915m = subscriber;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        if (this.f26912j) {
            return;
        }
        this.f26912j = true;
        try {
            ArrayList arrayList = new ArrayList(this.f26913k);
            this.f26913k = null;
            this.f26914l.m10799b(arrayList);
        } catch (Throwable th) {
            C3404f.m4325o1(th);
            onError(th);
        }
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f26915m.onError(th);
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        if (this.f26912j) {
            return;
        }
        this.f26913k.add(t);
    }

    @Override // p658rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
