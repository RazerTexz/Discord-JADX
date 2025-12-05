package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p644b.SingleDelayedProducer;
import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorToObservableSortedList.java */
/* renamed from: j0.l.a.p2, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorToObservableSortedList2<T> extends Subscriber<T> {

    /* renamed from: j */
    public List<T> f26985j = new ArrayList(10);

    /* renamed from: k */
    public boolean f26986k;

    /* renamed from: l */
    public final /* synthetic */ SingleDelayedProducer f26987l;

    /* renamed from: m */
    public final /* synthetic */ Subscriber f26988m;

    /* renamed from: n */
    public final /* synthetic */ OperatorToObservableSortedList f26989n;

    public OperatorToObservableSortedList2(OperatorToObservableSortedList operatorToObservableSortedList, SingleDelayedProducer singleDelayedProducer, Subscriber subscriber) {
        this.f26989n = operatorToObservableSortedList;
        this.f26987l = singleDelayedProducer;
        this.f26988m = subscriber;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        if (this.f26986k) {
            return;
        }
        this.f26986k = true;
        List<T> list = this.f26985j;
        this.f26985j = null;
        try {
            Collections.sort(list, this.f26989n.f26970j);
            this.f26987l.m10799b(list);
        } catch (Throwable th) {
            C3404f.m4325o1(th);
            onError(th);
        }
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f26988m.onError(th);
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        if (this.f26986k) {
            return;
        }
        this.f26985j.add(t);
    }

    @Override // p658rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
