package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Subscriber;
import p658rx.functions.Func2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorSkipWhile.java */
/* renamed from: j0.l.a.u1, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorSkipWhile<T> extends Subscriber<T> {

    /* renamed from: j */
    public boolean f27060j;

    /* renamed from: k */
    public int f27061k;

    /* renamed from: l */
    public final /* synthetic */ Subscriber f27062l;

    /* renamed from: m */
    public final /* synthetic */ OperatorSkipWhile3 f27063m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorSkipWhile(OperatorSkipWhile3 operatorSkipWhile3, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.f27063m = operatorSkipWhile3;
        this.f27062l = subscriber2;
        this.f27060j = true;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        this.f27062l.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f27062l.onError(th);
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        if (!this.f27060j) {
            this.f27062l.onNext(t);
            return;
        }
        try {
            Func2<? super T, Integer, Boolean> func2 = this.f27063m.f27075j;
            int i = this.f27061k;
            this.f27061k = i + 1;
            if (func2.call(t, Integer.valueOf(i)).booleanValue()) {
                request(1L);
            } else {
                this.f27060j = false;
                this.f27062l.onNext(t);
            }
        } catch (Throwable th) {
            C3404f.m4329p1(th, this.f27062l, t);
        }
    }
}
