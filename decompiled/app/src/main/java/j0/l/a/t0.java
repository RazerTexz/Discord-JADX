package j0.l.a;

import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorDistinctUntilChanged.java */
/* loaded from: classes3.dex */
public class t0<T> extends Subscriber<T> {
    public U j;
    public boolean k;
    public final /* synthetic */ Subscriber l;
    public final /* synthetic */ u0 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(u0 u0Var, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.m = u0Var;
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
    /* JADX WARN: Type inference failed for: r0v3, types: [U, java.lang.Object] */
    @Override // j0.g
    public void onNext(T t) {
        try {
            ?? Call = this.m.j.call(t);
            U u = this.j;
            this.j = Call;
            if (!this.k) {
                this.k = true;
                this.l.onNext(t);
                return;
            }
            try {
                if (this.m.k.call(u, Call).booleanValue()) {
                    request(1L);
                } else {
                    this.l.onNext(t);
                }
            } catch (Throwable th) {
                b.i.a.f.e.o.f.p1(th, this.l, Call);
            }
        } catch (Throwable th2) {
            b.i.a.f.e.o.f.p1(th2, this.l, t);
        }
    }
}
