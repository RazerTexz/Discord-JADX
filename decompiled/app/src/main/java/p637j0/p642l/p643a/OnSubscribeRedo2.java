package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import p637j0.Notification;
import p658rx.Producer;
import p658rx.Subscriber;

/* compiled from: OnSubscribeRedo.java */
/* renamed from: j0.l.a.u, reason: use source file name */
/* loaded from: classes3.dex */
public class OnSubscribeRedo2 extends Subscriber<Notification<?>> {

    /* renamed from: j */
    public final /* synthetic */ Subscriber f27055j;

    /* renamed from: k */
    public final /* synthetic */ OnSubscribeRedo3 f27056k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnSubscribeRedo2(OnSubscribeRedo3 onSubscribeRedo3, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.f27056k = onSubscribeRedo3;
        this.f27055j = subscriber2;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        this.f27055j.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f27055j.onError(th);
    }

    @Override // p637j0.Observer2
    public void onNext(Object obj) {
        Notification notification = (Notification) obj;
        Notification.a aVar = notification.f26689b;
        if ((aVar == Notification.a.OnCompleted) && this.f27056k.f27064j.f27122l) {
            this.f27055j.onCompleted();
            return;
        }
        if ((aVar == Notification.a.OnError) && this.f27056k.f27064j.f27123m) {
            this.f27055j.onError(notification.f26690c);
        } else {
            this.f27055j.onNext(notification);
        }
    }

    @Override // p658rx.Subscriber
    public void setProducer(Producer producer) {
        producer.mo10704j(RecyclerView.FOREVER_NS);
    }
}
