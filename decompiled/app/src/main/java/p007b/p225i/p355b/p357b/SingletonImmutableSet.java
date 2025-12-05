package p007b.p225i.p355b.p357b;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Iterator;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: SingletonImmutableSet.java */
/* renamed from: b.i.b.b.q0, reason: use source file name */
/* loaded from: classes3.dex */
public final class SingletonImmutableSet<E> extends ImmutableSet2<E> {

    /* renamed from: m */
    public final transient E f12055m;

    /* renamed from: n */
    @LazyInit
    public transient int f12056n;

    public SingletonImmutableSet(E e) {
        Objects.requireNonNull(e);
        this.f12055m = e;
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f12055m.equals(obj);
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection
    /* renamed from: d */
    public int mo6242d(Object[] objArr, int i) {
        objArr[i] = this.f12055m;
        return i + 1;
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableSet2, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.f12056n;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.f12055m.hashCode();
        this.f12056n = iHashCode;
        return iHashCode;
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection
    /* renamed from: i */
    public boolean mo6246i() {
        return false;
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableSet2, p007b.p225i.p355b.p357b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return mo6251j();
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection
    /* renamed from: j */
    public UnmodifiableIterator<E> mo6251j() {
        return new Iterators(this.f12055m);
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableSet2
    /* renamed from: o */
    public ImmutableList2<E> mo6252o() {
        return ImmutableList2.m6266u(this.f12055m);
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableSet2
    /* renamed from: p */
    public boolean mo6278p() {
        return this.f12056n != 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sbM829Q = outline.m829Q('[');
        sbM829Q.append(this.f12055m.toString());
        sbM829Q.append(']');
        return sbM829Q.toString();
    }

    public SingletonImmutableSet(E e, int i) {
        this.f12055m = e;
        this.f12056n = i;
    }
}
