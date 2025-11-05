package b.i.a.b.j;

import java.util.concurrent.Executors;

/* compiled from: ExecutionModule_ExecutorFactory.java */
/* loaded from: classes3.dex */
public final class g implements c0.a.a {

    /* compiled from: ExecutionModule_ExecutorFactory.java */
    public static final class a {
        public static final g a = new g();
    }

    @Override // c0.a.a
    public Object get() {
        return new h(Executors.newSingleThreadExecutor());
    }
}
