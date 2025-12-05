package p659s.p660a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: CompletionState.kt */
/* renamed from: s.a.w, reason: use source file name */
/* loaded from: classes3.dex */
public class CompletionState2 {

    /* renamed from: a */
    public static final AtomicIntegerFieldUpdater f27912a = AtomicIntegerFieldUpdater.newUpdater(CompletionState2.class, "_handled");
    public volatile int _handled;

    /* renamed from: b */
    public final Throwable f27913b;

    public CompletionState2(Throwable th, boolean z2) {
        this.f27913b = th;
        this._handled = z2 ? 1 : 0;
    }

    public String toString() {
        return getClass().getSimpleName() + '[' + this.f27913b + ']';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    public CompletionState2(Throwable th, boolean z2, int i) {
        ?? r2 = (i & 2) != 0 ? 0 : z2;
        this.f27913b = th;
        this._handled = r2;
    }
}
