package p659s.p660a;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Timeout3;
import p507d0.p584w.p586i.p587a.ContinuationImpl3;
import p659s.p660a.p661a.Scopes2;

/* JADX INFO: renamed from: s.a.x1, reason: use source file name */
/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Timeout4<U, T extends U> extends Scopes2<T> implements Runnable {

    /* JADX INFO: renamed from: n */
    public final long f27920n;

    public Timeout4(long j, Continuation<? super U> continuation) {
        super(((ContinuationImpl3) continuation).getContext(), continuation);
        this.f27920n = j;
    }

    @Override // p659s.p660a.AbstractCoroutine, p659s.p660a.C13116h1
    /* JADX INFO: renamed from: T */
    public String mo11184T() {
        return super.mo11184T() + "(timeMillis=" + this.f27920n + ')';
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        m11306w(new Timeout3("Timed out waiting for " + this.f27920n + " ms", this));
    }
}
