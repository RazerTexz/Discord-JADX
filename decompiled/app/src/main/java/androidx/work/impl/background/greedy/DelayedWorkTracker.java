package androidx.work.impl.background.greedy;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class DelayedWorkTracker {
    public static final String TAG = Logger.tagWithPrefix("DelayedWorkTracker");
    public final GreedyScheduler mGreedyScheduler;
    private final RunnableScheduler mRunnableScheduler;
    private final Map<String, Runnable> mRunnables = new HashMap();

    /* renamed from: androidx.work.impl.background.greedy.DelayedWorkTracker$1 */
    public class RunnableC07351 implements Runnable {
        public final /* synthetic */ WorkSpec val$workSpec;

        public RunnableC07351(WorkSpec workSpec) {
            this.val$workSpec = workSpec;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.get().debug(DelayedWorkTracker.TAG, String.format("Scheduling work %s", this.val$workSpec.f163id), new Throwable[0]);
            DelayedWorkTracker.this.mGreedyScheduler.schedule(this.val$workSpec);
        }
    }

    public DelayedWorkTracker(@NonNull GreedyScheduler greedyScheduler, @NonNull RunnableScheduler runnableScheduler) {
        this.mGreedyScheduler = greedyScheduler;
        this.mRunnableScheduler = runnableScheduler;
    }

    public void schedule(@NonNull WorkSpec workSpec) {
        Runnable runnableRemove = this.mRunnables.remove(workSpec.f163id);
        if (runnableRemove != null) {
            this.mRunnableScheduler.cancel(runnableRemove);
        }
        RunnableC07351 runnableC07351 = new RunnableC07351(workSpec);
        this.mRunnables.put(workSpec.f163id, runnableC07351);
        this.mRunnableScheduler.scheduleWithDelay(workSpec.calculateNextRunTime() - System.currentTimeMillis(), runnableC07351);
    }

    public void unschedule(@NonNull String str) {
        Runnable runnableRemove = this.mRunnables.remove(str);
        if (runnableRemove != null) {
            this.mRunnableScheduler.cancel(runnableRemove);
        }
    }
}
