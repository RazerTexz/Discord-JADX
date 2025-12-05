package androidx.room;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class TransactionExecutor implements Executor {
    private Runnable mActive;
    private final Executor mExecutor;
    private final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();

    /* renamed from: androidx.room.TransactionExecutor$1 */
    public class RunnableC05971 implements Runnable {
        public final /* synthetic */ Runnable val$command;

        public RunnableC05971(Runnable runnable) {
            this.val$command = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.val$command.run();
            } finally {
                TransactionExecutor.this.scheduleNext();
            }
        }
    }

    public TransactionExecutor(@NonNull Executor executor) {
        this.mExecutor = executor;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        this.mTasks.offer(new RunnableC05971(runnable));
        if (this.mActive == null) {
            scheduleNext();
        }
    }

    public synchronized void scheduleNext() {
        Runnable runnablePoll = this.mTasks.poll();
        this.mActive = runnablePoll;
        if (runnablePoll != null) {
            this.mExecutor.execute(runnablePoll);
        }
    }
}
