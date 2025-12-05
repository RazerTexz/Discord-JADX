package p507d0.p580t;

import java.util.AbstractSet;
import java.util.Set;
import p507d0.p592z.p594d.p595g0.KMarkers5;

/* compiled from: AbstractMutableSet.kt */
/* renamed from: d0.t.f, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractMutableSet<E> extends AbstractSet<E> implements Set<E>, KMarkers5 {
    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
