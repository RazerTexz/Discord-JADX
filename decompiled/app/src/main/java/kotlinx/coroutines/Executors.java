package kotlinx.coroutines;

import d0.w.CoroutineContextImpl2;
import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import s.a.Executors4;

/* compiled from: Executors.kt */
/* renamed from: kotlinx.coroutines.ExecutorCoroutineDispatcher, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class Executors extends CoroutineDispatcher implements Closeable {

    /* compiled from: Executors.kt */
    /* renamed from: kotlinx.coroutines.ExecutorCoroutineDispatcher$a */
    public static final class a extends CoroutineContextImpl2<CoroutineDispatcher, Executors> {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
            super(CoroutineDispatcher.INSTANCE, Executors4.j);
        }
    }

    static {
        new a(null);
    }

    public abstract Executor H();
}
