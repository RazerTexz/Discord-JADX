package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorScan.java */
/* renamed from: j0.l.a.p1, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorScan2<T> extends Subscriber<T> {

    /* renamed from: j */
    public boolean f26981j;

    /* renamed from: k */
    public R f26982k;

    /* renamed from: l */
    public final /* synthetic */ Subscriber f26983l;

    /* renamed from: m */
    public final /* synthetic */ OperatorScan f26984m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorScan2(OperatorScan operatorScan, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.f26984m = operatorScan;
        this.f26983l = subscriber2;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        this.f26983l.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f26983l.onError(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p637j0.Observer2
    public void onNext(T t) {
        R r;
        if (this.f26981j) {
            try {
                r = (T) this.f26984m.f26959l.call(this.f26982k, t);
            } catch (Throwable th) {
                C3404f.m4329p1(th, this.f26983l, t);
                return;
            }
        } else {
            this.f26981j = true;
            r = t;
        }
        this.f26982k = r;
        this.f26983l.onNext(r);
    }
}
