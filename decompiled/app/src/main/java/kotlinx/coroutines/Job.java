package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import s.a.m0;
import s.a.p;
import s.a.r;

/* compiled from: Job.kt */
/* loaded from: classes3.dex */
public interface Job extends CoroutineContext.Element {

    /* renamed from: h, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.a;

    /* compiled from: Job.kt */
    /* renamed from: kotlinx.coroutines.Job$a, reason: from kotlin metadata */
    public static final class Companion implements CoroutineContext.Key<Job> {
        public static final /* synthetic */ Companion a = new Companion();

        static {
            int i = CoroutineExceptionHandler.g;
        }
    }

    p D(r child);

    boolean a();

    void b(CancellationException cause);

    Sequence<Job> e();

    m0 n(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler);

    CancellationException q();

    boolean start();

    m0 u(Function1<? super Throwable, Unit> handler);
}
