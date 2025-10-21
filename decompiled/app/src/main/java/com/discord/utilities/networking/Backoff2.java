package com.discord.utilities.networking;

import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import com.discord.utilities.networking.Backoff;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.functions.Function0;

/* compiled from: Backoff.kt */
/* renamed from: com.discord.utilities.networking.Backoff$TimerScheduler$schedule$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class Backoff2 extends TimerTask {
    public final /* synthetic */ Function0 $action;
    public final /* synthetic */ Backoff.TimerScheduler this$0;

    public Backoff2(Backoff.TimerScheduler timerScheduler, Function0 function0) {
        this.this$0 = timerScheduler;
        this.$action = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.discord.utilities.networking.Backoff$sam$java_lang_Runnable$0] */
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
        Function0 backoff3 = this.$action;
        if (backoff3 != null) {
            backoff3 = new Backoff3(backoff3);
        }
        executorServiceAccess$getDelegateExecutor$p.execute((Runnable) backoff3);
    }
}
