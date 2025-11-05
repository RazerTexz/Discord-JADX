package j0.l.a;

import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorDelay.java */
/* loaded from: classes3.dex */
public class r0<T> extends Subscriber<T> {
    public boolean j;
    public final /* synthetic */ Scheduler.Worker k;
    public final /* synthetic */ Subscriber l;
    public final /* synthetic */ s0 m;

    /* compiled from: OperatorDelay.java */
    public class a implements Action0 {
        public a() {
        }

        @Override // rx.functions.Action0
        public void call() {
            r0 r0Var = r0.this;
            if (r0Var.j) {
                return;
            }
            r0Var.j = true;
            r0Var.l.onCompleted();
        }
    }

    /* compiled from: OperatorDelay.java */
    public class b implements Action0 {
        public final /* synthetic */ Throwable j;

        public b(Throwable th) {
            this.j = th;
        }

        @Override // rx.functions.Action0
        public void call() {
            r0 r0Var = r0.this;
            if (r0Var.j) {
                return;
            }
            r0Var.j = true;
            r0Var.l.onError(this.j);
            r0.this.k.unsubscribe();
        }
    }

    /* compiled from: OperatorDelay.java */
    public class c implements Action0 {
        public final /* synthetic */ Object j;

        public c(Object obj) {
            this.j = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Action0
        public void call() {
            r0 r0Var = r0.this;
            if (r0Var.j) {
                return;
            }
            r0Var.l.onNext(this.j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(s0 s0Var, Subscriber subscriber, Scheduler.Worker worker, Subscriber subscriber2) {
        super(subscriber);
        this.m = s0Var;
        this.k = worker;
        this.l = subscriber2;
    }

    @Override // j0.g
    public void onCompleted() {
        Scheduler.Worker worker = this.k;
        a aVar = new a();
        s0 s0Var = this.m;
        worker.b(aVar, s0Var.j, s0Var.k);
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.k.a(new b(th));
    }

    @Override // j0.g
    public void onNext(T t) {
        Scheduler.Worker worker = this.k;
        c cVar = new c(t);
        s0 s0Var = this.m;
        worker.b(cVar, s0Var.j, s0Var.k);
    }
}
