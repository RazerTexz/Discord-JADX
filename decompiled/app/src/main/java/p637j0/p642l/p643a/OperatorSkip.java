package p637j0.p642l.p643a;

import p658rx.Producer;
import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorSkip.java */
/* renamed from: j0.l.a.s1, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorSkip<T> extends Subscriber<T> {

    /* renamed from: j */
    public int f27039j;

    /* renamed from: k */
    public final /* synthetic */ Subscriber f27040k;

    /* renamed from: l */
    public final /* synthetic */ OperatorSkip2 f27041l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorSkip(OperatorSkip2 operatorSkip2, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.f27041l = operatorSkip2;
        this.f27040k = subscriber2;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        this.f27040k.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f27040k.onError(th);
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        int i = this.f27039j;
        if (i >= this.f27041l.f27054j) {
            this.f27040k.onNext(t);
        } else {
            this.f27039j = i + 1;
        }
    }

    @Override // p658rx.Subscriber
    public void setProducer(Producer producer) {
        this.f27040k.setProducer(producer);
        producer.mo10704j(this.f27041l.f27054j);
    }
}
