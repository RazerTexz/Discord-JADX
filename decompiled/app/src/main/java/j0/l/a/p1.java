package j0.l.a;

import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorScan.java */
/* loaded from: classes3.dex */
public class p1<T> extends Subscriber<T> {
    public boolean j;
    public R k;
    public final /* synthetic */ Subscriber l;
    public final /* synthetic */ o1 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p1(o1 o1Var, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.m = o1Var;
        this.l = subscriber2;
    }

    @Override // j0.g
    public void onCompleted() {
        this.l.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.l.onError(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j0.g
    public void onNext(T t) {
        R r;
        if (this.j) {
            try {
                r = (T) this.m.l.call(this.k, t);
            } catch (Throwable th) {
                b.i.a.f.e.o.f.p1(th, this.l, t);
                return;
            }
        } else {
            this.j = true;
            r = t;
        }
        this.k = r;
        this.l.onNext(r);
    }
}
