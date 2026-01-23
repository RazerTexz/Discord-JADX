package p659s.p660a.p661a;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result2;
import p507d0.Result3;
import p659s.p660a.AbstractC13142q0;
import p659s.p660a.C13161w1;
import p659s.p660a.CompletionState3;

/* JADX INFO: renamed from: s.a.a.h, reason: use source file name */
/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DispatchedContinuation2 {

    /* JADX INFO: renamed from: a */
    public static final Symbol3 f27681a = new Symbol3("UNDEFINED");

    /* JADX INFO: renamed from: b */
    public static final Symbol3 f27682b = new Symbol3("REUSABLE_CLAIMED");

    /* JADX INFO: renamed from: a */
    public static final <T> void m11148a(Continuation<? super T> continuation, Object obj, Function1<? super Throwable, Unit> function1) {
        boolean z2;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation.resumeWith(obj);
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Object objM4353v1 = C3404f.m4353v1(obj, function1);
        if (dispatchedContinuation.f27679q.isDispatchNeeded(dispatchedContinuation.getContext())) {
            dispatchedContinuation.f27676n = objM4353v1;
            dispatchedContinuation.f27864l = 1;
            dispatchedContinuation.f27679q.dispatch(dispatchedContinuation.getContext(), dispatchedContinuation);
            return;
        }
        C13161w1 c13161w1 = C13161w1.f27916b;
        AbstractC13142q0 abstractC13142q0M11353a = C13161w1.m11353a();
        if (abstractC13142q0M11353a.m11338N()) {
            dispatchedContinuation.f27676n = objM4353v1;
            dispatchedContinuation.f27864l = 1;
            abstractC13142q0M11353a.m11336J(dispatchedContinuation);
            return;
        }
        abstractC13142q0M11353a.m11337L(true);
        try {
            Job job = (Job) dispatchedContinuation.getContext().get(Job.INSTANCE);
            if (job == null || job.mo10910a()) {
                z2 = false;
            } else {
                CancellationException cancellationExceptionMo10914q = job.mo10914q();
                if (objM4353v1 instanceof CompletionState3) {
                    ((CompletionState3) objM4353v1).f27918b.invoke(cancellationExceptionMo10914q);
                }
                Result2.a aVar = Result2.f25169j;
                dispatchedContinuation.resumeWith(Result2.m11474constructorimpl(Result3.createFailure(cancellationExceptionMo10914q)));
                z2 = true;
            }
            if (!z2) {
                CoroutineContext context = dispatchedContinuation.getContext();
                Object objM11141b = ThreadContext.m11141b(context, dispatchedContinuation.f27678p);
                try {
                    dispatchedContinuation.f27680r.resumeWith(obj);
                    ThreadContext.m11140a(context, objM11141b);
                } catch (Throwable th) {
                    ThreadContext.m11140a(context, objM11141b);
                    throw th;
                }
            }
            while (abstractC13142q0M11353a.m11340R()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ void m11149b(Continuation continuation, Object obj, Function1 function1, int i) {
        int i2 = i & 2;
        m11148a(continuation, obj, null);
    }
}
