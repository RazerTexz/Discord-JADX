package p507d0.p580t;

import java.util.AbstractCollection;
import java.util.Collection;
import p507d0.p592z.p594d.p595g0.KMarkers2;

/* compiled from: AbstractMutableCollection.kt */
/* renamed from: d0.t.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractMutableCollection<E> extends AbstractCollection<E> implements Collection<E>, KMarkers2 {
    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }
}
