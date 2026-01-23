package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p643a.OperatorScan;
import p658rx.Producer;
import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.q1, reason: use source file name */
/* JADX INFO: compiled from: OperatorScan.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorScan3<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public R f27001j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Object f27002k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ OperatorScan.b f27003l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ OperatorScan f27004m;

    /* JADX WARN: Multi-variable type inference failed */
    public OperatorScan3(OperatorScan operatorScan, Object obj, OperatorScan.b bVar) {
        this.f27004m = operatorScan;
        this.f27002k = obj;
        this.f27003l = bVar;
        this.f27001j = obj;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        this.f27003l.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        OperatorScan.b bVar = this.f27003l;
        bVar.f26969r = th;
        bVar.f26968q = true;
        bVar.m10777b();
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [R, java.lang.Object] */
    @Override // p637j0.Observer2
    public void onNext(T t) {
        try {
            ?? Call = this.f27004m.f26959l.call(this.f27001j, t);
            this.f27001j = Call;
            this.f27003l.onNext(Call);
        } catch (Throwable th) {
            C3404f.m4329p1(th, this, t);
        }
    }

    @Override // p658rx.Subscriber
    public void setProducer(Producer producer) {
        long j;
        OperatorScan.b bVar = this.f27003l;
        Objects.requireNonNull(bVar);
        Objects.requireNonNull(producer);
        synchronized (bVar.f26966o) {
            if (bVar.f26967p != null) {
                throw new IllegalStateException("Can't set more than one Producer!");
            }
            j = bVar.f26965n;
            if (j != RecyclerView.FOREVER_NS) {
                j--;
            }
            bVar.f26965n = 0L;
            bVar.f26967p = producer;
        }
        if (j > 0) {
            producer.mo10704j(j);
        }
        bVar.m10777b();
    }
}
