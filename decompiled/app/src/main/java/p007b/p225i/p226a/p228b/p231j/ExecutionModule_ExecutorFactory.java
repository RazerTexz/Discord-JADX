package p007b.p225i.p226a.p228b.p231j;

import java.util.concurrent.Executors;
import p496c0.p497a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.g, reason: use source file name */
/* JADX INFO: compiled from: ExecutionModule_ExecutorFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ExecutionModule_ExecutorFactory implements Provider3 {

    /* JADX INFO: renamed from: b.i.a.b.j.g$a */
    /* JADX INFO: compiled from: ExecutionModule_ExecutorFactory.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final ExecutionModule_ExecutorFactory f5278a = new ExecutionModule_ExecutorFactory();
    }

    @Override // p496c0.p497a.Provider3
    public Object get() {
        return new SafeLoggingExecutor(Executors.newSingleThreadExecutor());
    }
}
