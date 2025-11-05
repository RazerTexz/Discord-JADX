package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: OperatorTakeUntil.java */
/* loaded from: classes3.dex */
public class e2<E> extends Subscriber<E> {
    public final /* synthetic */ Subscriber j;

    public e2(f2 f2Var, Subscriber subscriber) {
        this.j = subscriber;
    }

    @Override // j0.g
    public void onCompleted() {
        this.j.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.j.onError(th);
    }

    @Override // j0.g
    public void onNext(E e) {
        this.j.onCompleted();
    }

    @Override // rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
