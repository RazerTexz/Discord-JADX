package p659s.p660a;

import java.util.concurrent.Future;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: s.a.l0, reason: use source file name */
/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Executors2 implements Job2 {

    /* JADX INFO: renamed from: j */
    public final Future<?> f27873j;

    public Executors2(Future<?> future) {
        this.f27873j = future;
    }

    @Override // p659s.p660a.Job2
    public void dispose() {
        this.f27873j.cancel(false);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("DisposableFutureHandle[");
        sbM833U.append(this.f27873j);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
