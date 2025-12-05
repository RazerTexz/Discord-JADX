package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Scheduler;
import p658rx.functions.Action0;

/* compiled from: Dispatcher.kt */
/* loaded from: classes2.dex */
public final class Dispatcher {
    private final boolean assertCleanDispatches;
    private final ArrayList<Store2> dispatchHandlers;
    private Thread dispatcherThread;
    private final Scheduler scheduler;

    /* compiled from: Dispatcher.kt */
    /* renamed from: com.discord.stores.Dispatcher$schedule$1 */
    public static final class C56681 implements Action0 {
        public final /* synthetic */ Function0 $action;

        public C56681(Function0 function0) {
            this.$action = function0;
        }

        @Override // p658rx.functions.Action0
        public final void call() {
            if (Dispatcher.access$getDispatcherThread$p(Dispatcher.this) == null) {
                Dispatcher.access$setDispatcherThread$p(Dispatcher.this, Thread.currentThread());
            }
            this.$action.invoke();
            Dispatcher.this.onDispatchEnded();
        }
    }

    public Dispatcher(Scheduler scheduler, boolean z2) {
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
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
            AppLog.f14950g.mo8370w("dirty dispatch", new RuntimeException());
        }
    }

    public final Scheduler getScheduler() {
        return this.scheduler;
    }

    @Store3
    public final void onDispatchEnded() {
        Iterator<Store2> it = this.dispatchHandlers.iterator();
        while (it.hasNext()) {
            it.next().onDispatchEnded();
        }
    }

    @Store3
    public final void registerDispatchHandlers(Store2... dispatchHandlerArgs) {
        Intrinsics3.checkNotNullParameter(dispatchHandlerArgs, "dispatchHandlerArgs");
        for (Store2 store2 : dispatchHandlerArgs) {
            this.dispatchHandlers.add(store2);
        }
    }

    public final void schedule(Function0<Unit> action) {
        Intrinsics3.checkNotNullParameter(action, "action");
        if (this.dispatchHandlers.isEmpty()) {
            AppLog appLog = AppLog.f14950g;
            String name = Dispatcher.class.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "javaClass.name");
            Logger.e$default(appLog, name, "scheduled an action without registering DispatchHandlers", null, null, 12, null);
        }
        if (this.assertCleanDispatches) {
            assertCleanDispatch();
        }
        this.scheduler.mo10739a().mo10740a(new C56681(action));
    }

    @Store3
    public final void unregisterDispatchHandlers(Store2... dispatchHandlerArgs) {
        Intrinsics3.checkNotNullParameter(dispatchHandlerArgs, "dispatchHandlerArgs");
        for (Store2 store2 : dispatchHandlerArgs) {
            this.dispatchHandlers.remove(store2);
        }
    }

    public /* synthetic */ Dispatcher(Scheduler scheduler, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(scheduler, (i & 2) != 0 ? false : z2);
    }
}
