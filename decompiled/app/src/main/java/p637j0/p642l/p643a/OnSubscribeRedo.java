package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicLong;
import p637j0.Notification;
import p637j0.p642l.p644b.ProducerArbiter;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.functions.Action0;
import p658rx.subjects.Subject;
import p658rx.subscriptions.SerialSubscription;

/* compiled from: OnSubscribeRedo.java */
/* renamed from: j0.l.a.t, reason: use source file name */
/* loaded from: classes3.dex */
public class OnSubscribeRedo implements Action0 {

    /* renamed from: j */
    public final /* synthetic */ Subscriber f27042j;

    /* renamed from: k */
    public final /* synthetic */ Subject f27043k;

    /* renamed from: l */
    public final /* synthetic */ ProducerArbiter f27044l;

    /* renamed from: m */
    public final /* synthetic */ AtomicLong f27045m;

    /* renamed from: n */
    public final /* synthetic */ SerialSubscription f27046n;

    /* renamed from: o */
    public final /* synthetic */ OnSubscribeRedo6 f27047o;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: OnSubscribeRedo.java */
    /* renamed from: j0.l.a.t$a */
    public class a<T> extends Subscriber<T> {

        /* renamed from: j */
        public boolean f27048j;

        public a() {
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            if (this.f27048j) {
                return;
            }
            this.f27048j = true;
            unsubscribe();
            OnSubscribeRedo.this.f27043k.onNext(Notification.f26688a);
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            if (this.f27048j) {
                return;
            }
            this.f27048j = true;
            unsubscribe();
            OnSubscribeRedo.this.f27043k.onNext(new Notification(Notification.a.OnError, null, th));
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            long j;
            if (this.f27048j) {
                return;
            }
            OnSubscribeRedo.this.f27042j.onNext(t);
            do {
                j = OnSubscribeRedo.this.f27045m.get();
                if (j == RecyclerView.FOREVER_NS) {
                    break;
                }
            } while (!OnSubscribeRedo.this.f27045m.compareAndSet(j, j - 1));
            OnSubscribeRedo.this.f27044l.m10796b(1L);
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            OnSubscribeRedo.this.f27044l.m10797c(producer);
        }
    }

    public OnSubscribeRedo(OnSubscribeRedo6 onSubscribeRedo6, Subscriber subscriber, Subject subject, ProducerArbiter producerArbiter, AtomicLong atomicLong, SerialSubscription serialSubscription) {
        this.f27047o = onSubscribeRedo6;
        this.f27042j = subscriber;
        this.f27043k = subject;
        this.f27044l = producerArbiter;
        this.f27045m = atomicLong;
        this.f27046n = serialSubscription;
    }

    @Override // p658rx.functions.Action0
    public void call() {
        if (this.f27042j.isUnsubscribed()) {
            return;
        }
        a aVar = new a();
        this.f27046n.m11139a(aVar);
        this.f27047o.f27120j.m11107i0(aVar);
    }
}
