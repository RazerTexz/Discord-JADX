package p659s.p660a;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import p659s.p660a.p661a.Concurrent;

/* JADX INFO: renamed from: s.a.w0, reason: use source file name */
/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Executors6 extends Executors5 {

    /* JADX INFO: renamed from: k */
    public final Executor f27914k;

    public Executors6(Executor executor) {
        Method method;
        this.f27914k = executor;
        Method method2 = Concurrent.f27673a;
        boolean z2 = false;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) (executor instanceof ScheduledThreadPoolExecutor ? executor : null);
            if (scheduledThreadPoolExecutor != null && (method = Concurrent.f27673a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
                z2 = true;
            }
        } catch (Throwable unused) {
        }
        this.f27911j = z2;
    }

    @Override // kotlinx.coroutines.Executors
    /* JADX INFO: renamed from: H */
    public Executor mo10908H() {
        return this.f27914k;
    }
}
