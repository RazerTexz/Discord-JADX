package j0.l.e;

import j0.l.e.k;
import rx.Scheduler;
import rx.functions.Action0;

/* compiled from: ScalarSynchronousObservable.java */
/* loaded from: classes3.dex */
public class l implements Action0 {
    public final /* synthetic */ Action0 j;
    public final /* synthetic */ Scheduler.Worker k;

    public l(k.b bVar, Action0 action0, Scheduler.Worker worker) {
        this.j = action0;
        this.k = worker;
    }

    @Override // rx.functions.Action0
    public void call() {
        try {
            this.j.call();
        } finally {
            this.k.unsubscribe();
        }
    }
}
