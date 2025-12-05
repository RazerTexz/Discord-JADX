package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p659s.p660a.Job2;
import p659s.p660a.Job4;
import p659s.p660a.Job6;

/* compiled from: Job.kt */
/* loaded from: classes3.dex */
public interface Job extends CoroutineContext.Element {

    /* renamed from: h, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.f27463a;

    /* compiled from: Job.kt */
    /* renamed from: kotlinx.coroutines.Job$a, reason: from kotlin metadata */
    public static final class Companion implements CoroutineContext.Key<Job> {

        /* renamed from: a */
        public static final /* synthetic */ Companion f27463a = new Companion();

        static {
            int i = CoroutineExceptionHandler.f27455g;
        }
    }

    /* renamed from: D */
    Job4 mo10909D(Job6 child);

    /* renamed from: a */
    boolean mo10910a();

    /* renamed from: b */
    void mo10911b(CancellationException cause);

    /* renamed from: e */
    Sequence<Job> mo10912e();

    /* renamed from: n */
    Job2 mo10913n(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler);

    /* renamed from: q */
    CancellationException mo10914q();

    boolean start();

    /* renamed from: u */
    Job2 mo10915u(Function1<? super Throwable, Unit> handler);
}
