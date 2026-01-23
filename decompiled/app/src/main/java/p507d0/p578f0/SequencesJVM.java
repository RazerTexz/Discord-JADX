package p507d0.p578f0;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.sequences.Sequence;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.f0.a, reason: use source file name */
/* JADX INFO: compiled from: SequencesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SequencesJVM<T> implements Sequence<T> {

    /* JADX INFO: renamed from: a */
    public final AtomicReference<Sequence<T>> f25071a;

    public SequencesJVM(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "sequence");
        this.f25071a = new AtomicReference<>(sequence);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        Sequence<T> andSet = this.f25071a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
