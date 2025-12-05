package p659s.p660a;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Executors;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: Executors.kt */
/* renamed from: s.a.v0, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class Executors5 extends Executors implements Delay {

    /* renamed from: j */
    public boolean f27911j;

    /* renamed from: I */
    public final ScheduledFuture<?> m11350I(Runnable runnable, CoroutineContext coroutineContext, long j) {
        try {
            Executor executorMo10908H = mo10908H();
            if (!(executorMo10908H instanceof ScheduledExecutorService)) {
                executorMo10908H = null;
            }
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) executorMo10908H;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
            }
            return null;
        } catch (RejectedExecutionException e) {
            CancellationException cancellationExceptionM4267a = C3404f.m4267a("The task was rejected", e);
            Job job = (Job) coroutineContext.get(Job.INSTANCE);
            if (job == null) {
                return null;
            }
            job.mo10911b(cancellationExceptionM4267a);
            return null;
        }
    }

    @Override // p659s.p660a.Delay
    /* renamed from: c */
    public void mo11195c(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        ScheduledFuture<?> scheduledFutureM11350I = this.f27911j ? m11350I(new Executors3(this, cancellableContinuation), ((CancellableContinuationImpl5) cancellableContinuation).f27871o, j) : null;
        if (scheduledFutureM11350I != null) {
            ((CancellableContinuationImpl5) cancellableContinuation).mo10902f(new Future(scheduledFutureM11350I));
        } else {
            DefaultExecutor.f27779q.mo11195c(j, cancellableContinuation);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorMo10908H = mo10908H();
        if (!(executorMo10908H instanceof ExecutorService)) {
            executorMo10908H = null;
        }
        ExecutorService executorService = (ExecutorService) executorMo10908H;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            mo10908H().execute(runnable);
        } catch (RejectedExecutionException e) {
            CancellationException cancellationExceptionM4267a = C3404f.m4267a("The task was rejected", e);
            Job job = (Job) coroutineContext.get(Job.INSTANCE);
            if (job != null) {
                job.mo10911b(cancellationExceptionM4267a);
            }
            Dispatchers.f27867b.dispatch(coroutineContext, runnable);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof Executors5) && ((Executors5) obj).mo10908H() == mo10908H();
    }

    public int hashCode() {
        return System.identityHashCode(mo10908H());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return mo10908H().toString();
    }

    @Override // p659s.p660a.Delay
    /* renamed from: x */
    public Job2 mo11196x(long j, Runnable runnable, CoroutineContext coroutineContext) {
        ScheduledFuture<?> scheduledFutureM11350I = this.f27911j ? m11350I(runnable, coroutineContext, j) : null;
        return scheduledFutureM11350I != null ? new Executors2(scheduledFutureM11350I) : DefaultExecutor.f27779q.mo11196x(j, runnable, coroutineContext);
    }
}
