package p007b.p225i.p355b.p357b;

import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* compiled from: Collections2.java */
/* renamed from: b.i.b.b.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class Collections2 {

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* compiled from: Sets.java */
    /* renamed from: b.i.b.b.h$a */
    public static class a<E> extends Sets4<E> {

        /* renamed from: j */
        public final /* synthetic */ Set f12010j;

        /* renamed from: k */
        public final /* synthetic */ Set f12011k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Set set, Set set2) {
            super(null);
            this.f12010j = set;
            this.f12011k = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f12010j.contains(obj) && this.f12011k.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.f12010j.containsAll(collection) && this.f12011k.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.f12011k, this.f12010j);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new Sets2(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f12010j.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (this.f12011k.contains(it.next())) {
                    i++;
                }
            }
            return i;
        }
    }

    /* renamed from: a */
    public static int m6238a(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    /* renamed from: b */
    public static <E> Sets4<E> m6239b(Set<E> set, Set<?> set2) {
        Objects.requireNonNull(set, "set1");
        Objects.requireNonNull(set2, "set2");
        return new a(set, set2);
    }

    /* renamed from: c */
    public static <E> Set<E> m6240c() {
        return Collections.newSetFromMap(new IdentityHashMap());
    }

    /* renamed from: d */
    public static boolean m6241d(Set<?> set, Iterator<?> it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }
}
