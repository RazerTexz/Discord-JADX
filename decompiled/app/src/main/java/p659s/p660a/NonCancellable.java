package p659s.p660a;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;
import p507d0.p578f0.C12075n;
import p507d0.p584w.CoroutineContextImpl;

/* JADX INFO: renamed from: s.a.n1, reason: use source file name */
/* JADX INFO: compiled from: NonCancellable.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NonCancellable extends CoroutineContextImpl implements Job {

    /* JADX INFO: renamed from: j */
    public static final NonCancellable f27877j = new NonCancellable();

    public NonCancellable() {
        super(Job.INSTANCE);
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: D */
    public Job4 mo10909D(Job6 job6) {
        return Job3.f27880j;
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: a */
    public boolean mo10910a() {
        return true;
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: b */
    public void mo10911b(CancellationException cancellationException) {
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: e */
    public Sequence<Job> mo10912e() {
        return C12075n.emptySequence();
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: n */
    public Job2 mo10913n(boolean z2, boolean z3, Function1<? super Throwable, Unit> function1) {
        return Job3.f27880j;
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: q */
    public CancellationException mo10914q() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: u */
    public Job2 mo10915u(Function1<? super Throwable, Unit> function1) {
        return Job3.f27880j;
    }
}
