package p507d0.p580t;

import java.util.List;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ReversedViews.kt */
/* renamed from: d0.t.j0, reason: use source file name */
/* loaded from: classes3.dex */
public final class ReversedViews<T> extends AbstractMutableList<T> {

    /* renamed from: j */
    public final List<T> f25187j;

    public ReversedViews(List<T> list) {
        Intrinsics3.checkNotNullParameter(list, "delegate");
        this.f25187j = list;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        this.f25187j.add(ReversedViews3.access$reversePositionIndex(this, i), t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f25187j.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.f25187j.get(ReversedViews3.access$reverseElementIndex(this, i));
    }

    @Override // p507d0.p580t.AbstractMutableList
    public int getSize() {
        return this.f25187j.size();
    }

    @Override // p507d0.p580t.AbstractMutableList
    public T removeAt(int i) {
        return this.f25187j.remove(ReversedViews3.access$reverseElementIndex(this, i));
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        return this.f25187j.set(ReversedViews3.access$reverseElementIndex(this, i), t);
    }
}
