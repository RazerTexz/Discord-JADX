package p007b.p109f.p161j.p170e;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: DefaultExecutorSupplier.java */
/* renamed from: b.f.j.e.b, reason: use source file name */
/* loaded from: classes.dex */
public class DefaultExecutorSupplier implements ExecutorSupplier {

    /* renamed from: b */
    public final Executor f3728b;

    /* renamed from: c */
    public final Executor f3729c;

    /* renamed from: e */
    public final ScheduledExecutorService f3731e;

    /* renamed from: a */
    public final Executor f3727a = Executors.newFixedThreadPool(2, new PriorityThreadFactory2(10, "FrescoIoBoundExecutor", true));

    /* renamed from: d */
    public final Executor f3730d = Executors.newFixedThreadPool(1, new PriorityThreadFactory2(10, "FrescoLightWeightBackgroundExecutor", true));

    public DefaultExecutorSupplier(int i) {
        this.f3728b = Executors.newFixedThreadPool(i, new PriorityThreadFactory2(10, "FrescoDecodeExecutor", true));
        this.f3729c = Executors.newFixedThreadPool(i, new PriorityThreadFactory2(10, "FrescoBackgroundExecutor", true));
        this.f3731e = Executors.newScheduledThreadPool(i, new PriorityThreadFactory2(10, "FrescoBackgroundExecutor", true));
    }

    @Override // p007b.p109f.p161j.p170e.ExecutorSupplier
    /* renamed from: a */
    public Executor mo1254a() {
        return this.f3728b;
    }

    @Override // p007b.p109f.p161j.p170e.ExecutorSupplier
    /* renamed from: b */
    public Executor mo1255b() {
        return this.f3730d;
    }

    @Override // p007b.p109f.p161j.p170e.ExecutorSupplier
    /* renamed from: c */
    public Executor mo1256c() {
        return this.f3729c;
    }

    @Override // p007b.p109f.p161j.p170e.ExecutorSupplier
    /* renamed from: d */
    public Executor mo1257d() {
        return this.f3727a;
    }

    @Override // p007b.p109f.p161j.p170e.ExecutorSupplier
    /* renamed from: e */
    public Executor mo1258e() {
        return this.f3727a;
    }

    @Override // p007b.p109f.p161j.p170e.ExecutorSupplier
    /* renamed from: f */
    public Executor mo1259f() {
        return this.f3727a;
    }

    @Override // p007b.p109f.p161j.p170e.ExecutorSupplier
    /* renamed from: g */
    public ScheduledExecutorService mo1260g() {
        return this.f3731e;
    }
}
