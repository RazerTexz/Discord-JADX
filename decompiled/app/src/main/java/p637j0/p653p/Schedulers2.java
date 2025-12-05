package p637j0.p653p;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import p637j0.p642l.p645c.CachedThreadScheduler;
import p637j0.p642l.p645c.EventLoopsScheduler;
import p637j0.p642l.p645c.NewThreadScheduler;
import p637j0.p642l.p645c.SchedulerLifecycle;
import p637j0.p642l.p647e.RxThreadFactory;
import p637j0.p652o.RxJavaPlugins;
import p658rx.Scheduler;

/* compiled from: Schedulers.java */
/* renamed from: j0.p.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class Schedulers2 {

    /* renamed from: a */
    public static final AtomicReference<Schedulers2> f27393a = new AtomicReference<>();

    /* renamed from: b */
    public final Scheduler f27394b;

    /* renamed from: c */
    public final Scheduler f27395c;

    /* renamed from: d */
    public final Scheduler f27396d;

    public Schedulers2() {
        Objects.requireNonNull(RxJavaPlugins.f27384a.m10871e());
        this.f27394b = new EventLoopsScheduler(new RxThreadFactory("RxComputationScheduler-"));
        this.f27395c = new CachedThreadScheduler(new RxThreadFactory("RxIoScheduler-"));
        this.f27396d = new NewThreadScheduler(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    /* renamed from: a */
    public static Scheduler m10873a() {
        return m10874b().f27394b;
    }

    /* renamed from: b */
    public static Schedulers2 m10874b() {
        while (true) {
            AtomicReference<Schedulers2> atomicReference = f27393a;
            Schedulers2 schedulers2 = atomicReference.get();
            if (schedulers2 != null) {
                return schedulers2;
            }
            Schedulers2 schedulers22 = new Schedulers2();
            if (atomicReference.compareAndSet(null, schedulers22)) {
                return schedulers22;
            }
            synchronized (schedulers22) {
                Object obj = schedulers22.f27394b;
                if (obj instanceof SchedulerLifecycle) {
                    ((SchedulerLifecycle) obj).shutdown();
                }
                Object obj2 = schedulers22.f27395c;
                if (obj2 instanceof SchedulerLifecycle) {
                    ((SchedulerLifecycle) obj2).shutdown();
                }
                Object obj3 = schedulers22.f27396d;
                if (obj3 instanceof SchedulerLifecycle) {
                    ((SchedulerLifecycle) obj3).shutdown();
                }
            }
        }
    }

    /* renamed from: c */
    public static Scheduler m10875c() {
        return m10874b().f27395c;
    }
}
