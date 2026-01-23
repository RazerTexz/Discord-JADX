package com.discord.utilities.networking;

import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import com.discord.utilities.networking.Backoff;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.networking.Backoff$TimerScheduler$schedule$1, reason: use source file name */
/* JADX INFO: compiled from: Backoff.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Backoff2 extends TimerTask {
    public final /* synthetic */ Function0 $action;
    public final /* synthetic */ Backoff.TimerScheduler this$0;

    public Backoff2(Backoff.TimerScheduler timerScheduler, Function0 function0) {
        this.this$0 = timerScheduler;
        this.$action = function0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (Backoff.TimerScheduler.access$getDelegateExecutor$p(this.this$0) == null) {
            this.$action.invoke();
            return;
        }
        Logger logger = LoggingProvider.INSTANCE.get();
        if (Backoff.TimerScheduler.access$getDelegateExecutor$p(this.this$0).isShutdown()) {
            Logger.i$default(logger, Backoff.TimerScheduler.access$getTag$p(this.this$0), "skipping delayed task. executor is not running", null, 4, null);
            return;
        }
        Logger.v$default(logger, Backoff.TimerScheduler.access$getTag$p(this.this$0), "TimerScheduler posting to delegate scheduler", null, 4, null);
        ExecutorService executorServiceAccess$getDelegateExecutor$p = Backoff.TimerScheduler.access$getDelegateExecutor$p(this.this$0);
        Function0 function0 = this.$action;
        Object backoff3 = function0;
        if (function0 != null) {
            backoff3 = new Backoff3(function0);
        }
        executorServiceAccess$getDelegateExecutor$p.execute((Runnable) backoff3);
    }
}
