package j0.l.a;

import rx.Observable;
import rx.Subscriber;

/* compiled from: OnSubscribeRedo.java */
/* loaded from: classes3.dex */
public class v implements Observable.b<j0.f<?>, j0.f<?>> {
    public final /* synthetic */ y j;

    public v(y yVar) {
        this.j = yVar;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new u(this, subscriber, subscriber);
    }
}
