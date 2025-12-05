package p507d0.p580t;

import java.util.List;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ReversedViews.kt */
/* renamed from: d0.t.k0, reason: use source file name */
/* loaded from: classes3.dex */
public class ReversedViews2<T> extends AbstractList<T> {

    /* renamed from: k */
    public final List<T> f25190k;

    /* JADX WARN: Multi-variable type inference failed */
    public ReversedViews2(List<? extends T> list) {
        Intrinsics3.checkNotNullParameter(list, "delegate");
        this.f25190k = list;
    }

    @Override // p507d0.p580t.AbstractList, java.util.List
    public T get(int i) {
        return this.f25190k.get(ReversedViews3.access$reverseElementIndex(this, i));
    }

    @Override // p507d0.p580t.AbstractCollection
    public int getSize() {
        return this.f25190k.size();
    }
}
