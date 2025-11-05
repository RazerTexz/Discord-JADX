package androidx.view;

import android.annotation.SuppressLint;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import d0.z.d.Intrinsics3;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.Dispatchers;
import s.a.MainCoroutineDispatcher;
import s.a.a.MainDispatchers;

/* compiled from: DispatchQueue.kt */
/* loaded from: classes.dex */
public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused = true;
    private final Queue<Runnable> queue = new ArrayDeque();

    public static final /* synthetic */ void access$enqueue(DispatchQueue dispatchQueue, Runnable runnable) {
        dispatchQueue.enqueue(runnable);
    }

    @MainThread
    private final void enqueue(Runnable runnable) {
        if (!this.queue.offer(runnable)) {
            throw new IllegalStateException("cannot enqueue any more runnables".toString());
        }
        drainQueue();
    }

    @MainThread
    public final boolean canRun() {
        return this.finished || !this.paused;
    }

    @AnyThread
    @SuppressLint({"WrongThread"})
    public final void dispatchAndEnqueue(CoroutineContext context, Runnable runnable) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(runnable, "runnable");
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainCoroutineDispatcher mainCoroutineDispatcherH = MainDispatchers.f3830b.H();
        if (mainCoroutineDispatcherH.isDispatchNeeded(context) || canRun()) {
            mainCoroutineDispatcherH.dispatch(context, new DispatchQueue2(this, context, runnable));
        } else {
            enqueue(runnable);
        }
    }

    @MainThread
    public final void drainQueue() {
        if (this.isDraining) {
            return;
        }
        try {
            this.isDraining = true;
            while ((!this.queue.isEmpty()) && canRun()) {
                Runnable runnablePoll = this.queue.poll();
                if (runnablePoll != null) {
                    runnablePoll.run();
                }
            }
        } finally {
            this.isDraining = false;
        }
    }

    @MainThread
    public final void finish() {
        this.finished = true;
        drainQueue();
    }

    @MainThread
    public final void pause() {
        this.paused = true;
    }

    @MainThread
    public final void resume() {
        if (this.paused) {
            if (!(!this.finished)) {
                throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
            }
            this.paused = false;
            drainQueue();
        }
    }
}
