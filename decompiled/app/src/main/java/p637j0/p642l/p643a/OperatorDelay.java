package p637j0.p642l.p643a;

import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.functions.Action0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.r0, reason: use source file name */
/* JADX INFO: compiled from: OperatorDelay.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorDelay<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public boolean f27015j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Scheduler.Worker f27016k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Subscriber f27017l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ OperatorDelay2 f27018m;

    /* JADX INFO: renamed from: j0.l.a.r0$a */
    /* JADX INFO: compiled from: OperatorDelay.java */
    public class a implements Action0 {
        public a() {
        }

        @Override // p658rx.functions.Action0
        public void call() {
            OperatorDelay operatorDelay = OperatorDelay.this;
            if (operatorDelay.f27015j) {
                return;
            }
            operatorDelay.f27015j = true;
            operatorDelay.f27017l.onCompleted();
        }
    }

    /* JADX INFO: renamed from: j0.l.a.r0$b */
    /* JADX INFO: compiled from: OperatorDelay.java */
    public class b implements Action0 {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Throwable f27020j;

        public b(Throwable th) {
            this.f27020j = th;
        }

        @Override // p658rx.functions.Action0
        public void call() {
            OperatorDelay operatorDelay = OperatorDelay.this;
            if (operatorDelay.f27015j) {
                return;
            }
            operatorDelay.f27015j = true;
            operatorDelay.f27017l.onError(this.f27020j);
            OperatorDelay.this.f27016k.unsubscribe();
        }
    }

    /* JADX INFO: renamed from: j0.l.a.r0$c */
    /* JADX INFO: compiled from: OperatorDelay.java */
    public class c implements Action0 {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Object f27022j;

        public c(Object obj) {
            this.f27022j = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p658rx.functions.Action0
        public void call() {
            OperatorDelay operatorDelay = OperatorDelay.this;
            if (operatorDelay.f27015j) {
                return;
            }
            operatorDelay.f27017l.onNext(this.f27022j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorDelay(OperatorDelay2 operatorDelay2, Subscriber subscriber, Scheduler.Worker worker, Subscriber subscriber2) {
        super(subscriber);
        this.f27018m = operatorDelay2;
        this.f27016k = worker;
        this.f27017l = subscriber2;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        Scheduler.Worker worker = this.f27016k;
        a aVar = new a();
        OperatorDelay2 operatorDelay2 = this.f27018m;
        worker.mo10741b(aVar, operatorDelay2.f27036j, operatorDelay2.f27037k);
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f27016k.mo10740a(new b(th));
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        Scheduler.Worker worker = this.f27016k;
        c cVar = new c(t);
        OperatorDelay2 operatorDelay2 = this.f27018m;
        worker.mo10741b(cVar, operatorDelay2.f27036j, operatorDelay2.f27037k);
    }
}
