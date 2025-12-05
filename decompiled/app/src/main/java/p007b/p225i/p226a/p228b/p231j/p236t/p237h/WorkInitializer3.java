package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import java.util.concurrent.Executor;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore;
import p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard;

/* compiled from: WorkInitializer.java */
/* renamed from: b.i.a.b.j.t.h.p, reason: use source file name */
/* loaded from: classes3.dex */
public class WorkInitializer3 {

    /* renamed from: a */
    public final Executor f5401a;

    /* renamed from: b */
    public final EventStore f5402b;

    /* renamed from: c */
    public final WorkScheduler f5403c;

    /* renamed from: d */
    public final SynchronizationGuard f5404d;

    public WorkInitializer3(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.f5401a = executor;
        this.f5402b = eventStore;
        this.f5403c = workScheduler;
        this.f5404d = synchronizationGuard;
    }
}
