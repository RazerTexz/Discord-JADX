package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p644b.ProducerArbiter;
import p637j0.p652o.C12774l;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.subscriptions.SerialSubscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* renamed from: j0.l.a.e1, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorOnErrorResumeNextViaFunction3<T> extends Subscriber<T> {

    /* renamed from: j */
    public boolean f26772j;

    /* renamed from: k */
    public long f26773k;

    /* renamed from: l */
    public final /* synthetic */ Subscriber f26774l;

    /* renamed from: m */
    public final /* synthetic */ ProducerArbiter f26775m;

    /* renamed from: n */
    public final /* synthetic */ SerialSubscription f26776n;

    /* renamed from: o */
    public final /* synthetic */ OperatorOnErrorResumeNextViaFunction4 f26777o;

    /* compiled from: OperatorOnErrorResumeNextViaFunction.java */
    /* renamed from: j0.l.a.e1$a */
    public class a extends Subscriber<T> {
        public a() {
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            OperatorOnErrorResumeNextViaFunction3.this.f26774l.onCompleted();
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            OperatorOnErrorResumeNextViaFunction3.this.f26774l.onError(th);
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            OperatorOnErrorResumeNextViaFunction3.this.f26774l.onNext(t);
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            OperatorOnErrorResumeNextViaFunction3.this.f26775m.m10797c(producer);
        }
    }

    public OperatorOnErrorResumeNextViaFunction3(OperatorOnErrorResumeNextViaFunction4 operatorOnErrorResumeNextViaFunction4, Subscriber subscriber, ProducerArbiter producerArbiter, SerialSubscription serialSubscription) {
        this.f26777o = operatorOnErrorResumeNextViaFunction4;
        this.f26774l = subscriber;
        this.f26775m = producerArbiter;
        this.f26776n = serialSubscription;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        if (this.f26772j) {
            return;
        }
        this.f26772j = true;
        this.f26774l.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        if (this.f26772j) {
            C3404f.m4325o1(th);
            C12774l.m10863b(th);
            return;
        }
        this.f26772j = true;
        try {
            unsubscribe();
            a aVar = new a();
            this.f26776n.m11139a(aVar);
            long j = this.f26773k;
            if (j != 0) {
                this.f26775m.m10796b(j);
            }
            this.f26777o.f26788j.call(th).m11107i0(aVar);
        } catch (Throwable th2) {
            Subscriber subscriber = this.f26774l;
            C3404f.m4325o1(th2);
            subscriber.onError(th2);
        }
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        if (this.f26772j) {
            return;
        }
        this.f26773k++;
        this.f26774l.onNext(t);
    }

    @Override // p658rx.Subscriber
    public void setProducer(Producer producer) {
        this.f26775m.m10797c(producer);
    }
}
