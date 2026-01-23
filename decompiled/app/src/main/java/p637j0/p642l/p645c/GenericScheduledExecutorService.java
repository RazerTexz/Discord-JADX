package p637j0.p642l.p645c;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: j0.l.c.d, reason: use source file name */
/* JADX INFO: compiled from: GenericScheduledExecutorService.java */
/* JADX INFO: loaded from: classes3.dex */
public final class GenericScheduledExecutorService implements SchedulerLifecycle {

    /* JADX INFO: renamed from: a */
    public static final ScheduledExecutorService[] f27215a = new ScheduledExecutorService[0];

    /* JADX INFO: renamed from: b */
    public static final ScheduledExecutorService f27216b;

    /* JADX INFO: renamed from: c */
    public static final GenericScheduledExecutorService f27217c;

    /* JADX INFO: renamed from: d */
    public static int f27218d;

    /* JADX INFO: renamed from: e */
    public final AtomicReference<ScheduledExecutorService[]> f27219e = new AtomicReference<>(f27215a);

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f27216b = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        f27217c = new GenericScheduledExecutorService();
    }

    public GenericScheduledExecutorService() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        iAvailableProcessors = iAvailableProcessors > 4 ? iAvailableProcessors / 2 : iAvailableProcessors;
        iAvailableProcessors = iAvailableProcessors > 8 ? 8 : iAvailableProcessors;
        ScheduledExecutorService[] scheduledExecutorServiceArr = new ScheduledExecutorService[iAvailableProcessors];
        int i = 0;
        for (int i2 = 0; i2 < iAvailableProcessors; i2++) {
            scheduledExecutorServiceArr[i2] = Executors.newScheduledThreadPool(1, GenericScheduledExecutorServiceFactory.f27220j);
        }
        if (!this.f27219e.compareAndSet(f27215a, scheduledExecutorServiceArr)) {
            while (i < iAvailableProcessors) {
                scheduledExecutorServiceArr[i].shutdownNow();
                i++;
            }
        } else {
            while (i < iAvailableProcessors) {
                ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceArr[i];
                if (!NewThreadWorker.m10804g(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                    NewThreadWorker.m10803e((ScheduledThreadPoolExecutor) scheduledExecutorService);
                }
                i++;
            }
        }
    }

    @Override // p637j0.p642l.p645c.SchedulerLifecycle
    public void shutdown() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        ScheduledExecutorService[] scheduledExecutorServiceArr2;
        do {
            scheduledExecutorServiceArr = this.f27219e.get();
            scheduledExecutorServiceArr2 = f27215a;
            if (scheduledExecutorServiceArr == scheduledExecutorServiceArr2) {
                return;
            }
        } while (!this.f27219e.compareAndSet(scheduledExecutorServiceArr, scheduledExecutorServiceArr2));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            NewThreadWorker.f27225l.remove(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }
}
