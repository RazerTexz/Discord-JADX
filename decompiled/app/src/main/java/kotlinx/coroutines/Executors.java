package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p584w.CoroutineContextImpl2;
import p659s.p660a.Executors4;

/* compiled from: Executors.kt */
/* renamed from: kotlinx.coroutines.ExecutorCoroutineDispatcher, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class Executors extends CoroutineDispatcher implements Closeable {

    /* compiled from: Executors.kt */
    /* renamed from: kotlinx.coroutines.ExecutorCoroutineDispatcher$a */
    public static final class C12805a extends CoroutineContextImpl2<CoroutineDispatcher, Executors> {
        public C12805a(DefaultConstructorMarker defaultConstructorMarker) {
            super(CoroutineDispatcher.INSTANCE, Executors4.f27905j);
        }
    }

    static {
        new C12805a(null);
    }

    /* renamed from: H */
    public abstract Executor mo10908H();
}
