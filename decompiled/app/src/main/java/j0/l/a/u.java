package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.f;
import rx.Producer;
import rx.Subscriber;

/* compiled from: OnSubscribeRedo.java */
/* loaded from: classes3.dex */
public class u extends Subscriber<j0.f<?>> {
    public final /* synthetic */ Subscriber j;
    public final /* synthetic */ v k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(v vVar, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.k = vVar;
        this.j = subscriber2;
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
    public void onNext(Object obj) {
        j0.f fVar = (j0.f) obj;
        f.a aVar = fVar.f3768b;
        if ((aVar == f.a.OnCompleted) && this.k.j.l) {
            this.j.onCompleted();
            return;
        }
        if ((aVar == f.a.OnError) && this.k.j.m) {
            this.j.onError(fVar.c);
        } else {
            this.j.onNext(fVar);
        }
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        producer.j(RecyclerView.FOREVER_NS);
    }
}
