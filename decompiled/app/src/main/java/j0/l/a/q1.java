package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.l.a.o1;
import java.util.Objects;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorScan.java */
/* loaded from: classes3.dex */
public class q1<T> extends Subscriber<T> {
    public R j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ o1.b l;
    public final /* synthetic */ o1 m;

    /* JADX WARN: Multi-variable type inference failed */
    public q1(o1 o1Var, Object obj, o1.b bVar) {
        this.m = o1Var;
        this.k = obj;
        this.l = bVar;
        this.j = obj;
    }

    @Override // j0.g
    public void onCompleted() {
        this.l.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        o1.b bVar = this.l;
        bVar.r = th;
        bVar.q = true;
        bVar.b();
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [R, java.lang.Object] */
    @Override // j0.g
    public void onNext(T t) {
        try {
            ?? Call = this.m.l.call(this.j, t);
            this.j = Call;
            this.l.onNext(Call);
        } catch (Throwable th) {
            b.i.a.f.e.o.f.p1(th, this, t);
        }
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        long j;
        o1.b bVar = this.l;
        Objects.requireNonNull(bVar);
        Objects.requireNonNull(producer);
        synchronized (bVar.o) {
            if (bVar.p != null) {
                throw new IllegalStateException("Can't set more than one Producer!");
            }
            j = bVar.n;
            if (j != RecyclerView.FOREVER_NS) {
                j--;
            }
            bVar.n = 0L;
            bVar.p = producer;
        }
        if (j > 0) {
            producer.j(j);
        }
        bVar.b();
    }
}
