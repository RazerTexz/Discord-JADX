package p637j0.p642l.p643a;

import p637j0.Notification;
import p658rx.Observable;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.v, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public class OnSubscribeRedo3 implements Observable.InterfaceC13006b<Notification<?>, Notification<?>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ OnSubscribeRedo6 f27064j;

    public OnSubscribeRedo3(OnSubscribeRedo6 onSubscribeRedo6) {
        this.f27064j = onSubscribeRedo6;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new OnSubscribeRedo2(this, subscriber, subscriber);
    }
}
