package p637j0.p642l.p647e;

import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Scheduler;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.e.l, reason: use source file name */
/* JADX INFO: compiled from: ScalarSynchronousObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public class ScalarSynchronousObservable2 implements Action0 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Action0 f27299j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Scheduler.Worker f27300k;

    public ScalarSynchronousObservable2(ScalarSynchronousObservable.b bVar, Action0 action0, Scheduler.Worker worker) {
        this.f27299j = action0;
        this.f27300k = worker;
    }

    @Override // p658rx.functions.Action0
    public void call() {
        try {
            this.f27299j.call();
        } finally {
            this.f27300k.unsubscribe();
        }
    }
}
