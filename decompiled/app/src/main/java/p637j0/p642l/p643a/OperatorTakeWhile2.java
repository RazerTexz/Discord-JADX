package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Subscriber;
import p658rx.functions.Func2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorTakeWhile.java */
/* renamed from: j0.l.a.j2, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorTakeWhile2<T> extends Subscriber<T> {

    /* renamed from: j */
    public int f26877j;

    /* renamed from: k */
    public boolean f26878k;

    /* renamed from: l */
    public final /* synthetic */ Subscriber f26879l;

    /* renamed from: m */
    public final /* synthetic */ OperatorTakeWhile f26880m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorTakeWhile2(OperatorTakeWhile operatorTakeWhile, Subscriber subscriber, boolean z2, Subscriber subscriber2) {
        super(subscriber, z2);
        this.f26880m = operatorTakeWhile;
        this.f26879l = subscriber2;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        if (this.f26878k) {
            return;
        }
        this.f26879l.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        if (this.f26878k) {
            return;
        }
        this.f26879l.onError(th);
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        try {
            Func2<? super T, ? super Integer, Boolean> func2 = this.f26880m.f26851j;
            int i = this.f26877j;
            this.f26877j = i + 1;
            if (func2.call(t, Integer.valueOf(i)).booleanValue()) {
                this.f26879l.onNext(t);
                return;
            }
            this.f26878k = true;
            this.f26879l.onCompleted();
            unsubscribe();
        } catch (Throwable th) {
            this.f26878k = true;
            C3404f.m4329p1(th, this.f26879l, t);
            unsubscribe();
        }
    }
}
