package j0.l.c;

import java.util.concurrent.ThreadFactory;
import rx.Scheduler;

/* compiled from: NewThreadScheduler.java */
/* loaded from: classes3.dex */
public final class f extends Scheduler {
    public final ThreadFactory a;

    public f(ThreadFactory threadFactory) {
        this.a = threadFactory;
    }

    @Override // rx.Scheduler
    public Scheduler.Worker a() {
        return new g(this.a);
    }
}
