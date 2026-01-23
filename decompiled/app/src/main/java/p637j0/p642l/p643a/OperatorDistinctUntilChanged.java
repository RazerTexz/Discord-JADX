package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.t0, reason: use source file name */
/* JADX INFO: compiled from: OperatorDistinctUntilChanged.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorDistinctUntilChanged<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public U f27050j;

    /* JADX INFO: renamed from: k */
    public boolean f27051k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Subscriber f27052l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ OperatorDistinctUntilChanged2 f27053m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorDistinctUntilChanged(OperatorDistinctUntilChanged2 operatorDistinctUntilChanged2, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.f27053m = operatorDistinctUntilChanged2;
        this.f27052l = subscriber2;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        this.f27052l.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f27052l.onError(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [U, java.lang.Object] */
    @Override // p637j0.Observer2
    public void onNext(T t) {
        try {
            ?? Call = this.f27053m.f27057j.call(t);
            U u = this.f27050j;
            this.f27050j = Call;
            if (!this.f27051k) {
                this.f27051k = true;
                this.f27052l.onNext(t);
                return;
            }
            try {
                if (this.f27053m.f27058k.call(u, Call).booleanValue()) {
                    request(1L);
                } else {
                    this.f27052l.onNext(t);
                }
            } catch (Throwable th) {
                C3404f.m4329p1(th, this.f27052l, Call);
            }
        } catch (Throwable th2) {
            C3404f.m4329p1(th2, this.f27052l, t);
        }
    }
}
