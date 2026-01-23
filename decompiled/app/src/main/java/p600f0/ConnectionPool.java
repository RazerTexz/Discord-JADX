package p600f0;

import java.util.concurrent.TimeUnit;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.p604f.TaskRunner;
import p600f0.p601e0.p605g.RealConnectionPool;

/* JADX INFO: renamed from: f0.l, reason: use source file name */
/* JADX INFO: compiled from: ConnectionPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConnectionPool {

    /* JADX INFO: renamed from: a */
    public final RealConnectionPool f25929a;

    public ConnectionPool() {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        Intrinsics3.checkParameterIsNotNull(timeUnit, "timeUnit");
        RealConnectionPool realConnectionPool = new RealConnectionPool(TaskRunner.f25420a, 5, 5L, timeUnit);
        Intrinsics3.checkParameterIsNotNull(realConnectionPool, "delegate");
        this.f25929a = realConnectionPool;
    }
}
