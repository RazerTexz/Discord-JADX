package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Scheduler;
import rx.functions.Action0;

/* compiled from: Dispatcher.kt */
/* loaded from: classes2.dex */
public final class Dispatcher {
    private final boolean assertCleanDispatches;
    private final ArrayList<DispatchHandler> dispatchHandlers;
    private Thread dispatcherThread;
    private final Scheduler scheduler;

    /* compiled from: Dispatcher.kt */
    /* renamed from: com.discord.stores.Dispatcher$schedule$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Action0 {
        public final /* synthetic */ Function0 $action;

        public AnonymousClass1(Function0 function0) {
            this.$action = function0;
        }

        @Override // rx.functions.Action0
        public final void call() {
            if (Dispatcher.access$getDispatcherThread$p(Dispatcher.this) == null) {
                Dispatcher.access$setDispatcherThread$p(Dispatcher.this, Thread.currentThread());
            }
            this.$action.invoke();
            Dispatcher.this.onDispatchEnded();
        }
    }

    public Dispatcher(Scheduler scheduler, boolean z2) {
        m.checkNotNullParameter(scheduler, "scheduler");
        this.scheduler = scheduler;
        this.assertCleanDispatches = z2;
        this.dispatchHandlers = new ArrayList<>();
    }

    public static final /* synthetic */ Thread access$getDispatcherThread$p(Dispatcher dispatcher) {
        return dispatcher.dispatcherThread;
    }

    public static final /* synthetic */ void access$setDispatcherThread$p(Dispatcher dispatcher, Thread thread) {
        dispatcher.dispatcherThread = thread;
    }

    private final void assertCleanDispatch() {
        if (Thread.currentThread() == this.dispatcherThread) {
            AppLog.g.w("dirty dispatch", new RuntimeException());
        }
    }

    public final Scheduler getScheduler() {
        return this.scheduler;
    }

    @StoreThread
    public final void onDispatchEnded() {
        Iterator<DispatchHandler> it = this.dispatchHandlers.iterator();
        while (it.hasNext()) {
            it.next().onDispatchEnded();
        }
    }

    @StoreThread
    public final void registerDispatchHandlers(DispatchHandler... dispatchHandlerArgs) {
        m.checkNotNullParameter(dispatchHandlerArgs, "dispatchHandlerArgs");
        for (DispatchHandler dispatchHandler : dispatchHandlerArgs) {
            this.dispatchHandlers.add(dispatchHandler);
        }
    }

    public final void schedule(Function0<Unit> action) {
        m.checkNotNullParameter(action, "action");
        if (this.dispatchHandlers.isEmpty()) {
            AppLog appLog = AppLog.g;
            String name = Dispatcher.class.getName();
            m.checkNotNullExpressionValue(name, "javaClass.name");
            Logger.e$default(appLog, name, "scheduled an action without registering DispatchHandlers", null, null, 12, null);
        }
        if (this.assertCleanDispatches) {
            assertCleanDispatch();
        }
        this.scheduler.a().a(new AnonymousClass1(action));
    }

    @StoreThread
    public final void unregisterDispatchHandlers(DispatchHandler... dispatchHandlerArgs) {
        m.checkNotNullParameter(dispatchHandlerArgs, "dispatchHandlerArgs");
        for (DispatchHandler dispatchHandler : dispatchHandlerArgs) {
            this.dispatchHandlers.remove(dispatchHandler);
        }
    }

    public /* synthetic */ Dispatcher(Scheduler scheduler, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(scheduler, (i & 2) != 0 ? false : z2);
    }
}
