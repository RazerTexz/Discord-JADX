package p637j0.p642l.p645c;

import java.util.concurrent.ThreadFactory;
import p658rx.Scheduler;

/* compiled from: NewThreadScheduler.java */
/* renamed from: j0.l.c.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class NewThreadScheduler extends Scheduler {

    /* renamed from: a */
    public final ThreadFactory f27222a;

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.f27222a = threadFactory;
    }

    @Override // p658rx.Scheduler
    /* renamed from: a */
    public Scheduler.Worker mo10739a() {
        return new NewThreadWorker(this.f27222a);
    }
}
