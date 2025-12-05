package p007b.p225i.p355b.p357b;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: RegularImmutableSet.java */
/* renamed from: b.i.b.b.j0, reason: use source file name */
/* loaded from: classes3.dex */
public final class RegularImmutableSet<E> extends ImmutableSet2<E> {

    /* renamed from: m */
    public static final RegularImmutableSet<Object> f12032m = new RegularImmutableSet<>(new Object[0], 0, null, 0, 0);

    /* renamed from: n */
    public final transient Object[] f12033n;

    /* renamed from: o */
    public final transient Object[] f12034o;

    /* renamed from: p */
    public final transient int f12035p;

    /* renamed from: q */
    public final transient int f12036q;

    /* renamed from: r */
    public final transient int f12037r;

    public RegularImmutableSet(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.f12033n = objArr;
        this.f12034o = objArr2;
        this.f12035p = i2;
        this.f12036q = i;
        this.f12037r = i3;
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.f12034o;
        if (obj == null || objArr == null) {
            return false;
        }
        int iM4277c1 = C3404f.m4277c1(obj.hashCode());
        while (true) {
            int i = iM4277c1 & this.f12035p;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iM4277c1 = i + 1;
        }
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection
    /* renamed from: d */
    public int mo6242d(Object[] objArr, int i) {
        System.arraycopy(this.f12033n, 0, objArr, i, this.f12037r);
        return i + this.f12037r;
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection
    /* renamed from: e */
    public Object[] mo6243e() {
        return this.f12033n;
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection
    /* renamed from: g */
    public int mo6244g() {
        return this.f12037r;
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableCollection
    /* renamed from: h */
    public int mo6245h() {
        return 0;
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableSet2, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f12036q;
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
        return mo6253c().m6268p();
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableSet2
    /* renamed from: o */
    public ImmutableList2<E> mo6252o() {
        return ImmutableList2.m6262l(this.f12033n, this.f12037r);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f12037r;
    }
}
