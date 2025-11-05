package d0.e0.p.d.m0.p;

import d0.t.k;
import d0.t.n0;
import d0.z.d.e0;
import d0.z.d.m;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SmartSet.kt */
/* loaded from: classes3.dex */
public final class j<T> extends AbstractSet<T> {
    public static final b j = new b(null);
    public Object k;
    public int l;

    /* compiled from: SmartSet.kt */
    public static final class a<T> implements Iterator<T>, d0.z.d.g0.a {
        public final Iterator<T> j;

        public a(T[] tArr) {
            m.checkNotNullParameter(tArr, "array");
            this.j = d0.z.d.c.iterator(tArr);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.j.next();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            remove();
        }

        @Override // java.util.Iterator
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: SmartSet.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final <T> j<T> create() {
            return new j<>(null);
        }

        public final <T> j<T> create(Collection<? extends T> collection) {
            m.checkNotNullParameter(collection, "set");
            j<T> jVar = new j<>(null);
            jVar.addAll(collection);
            return jVar;
        }
    }

    /* compiled from: SmartSet.kt */
    public static final class c<T> implements Iterator<T>, d0.z.d.g0.a {
        public final T j;
        public boolean k = true;

        public c(T t) {
            this.j = t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.k;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.k) {
                throw new NoSuchElementException();
            }
            this.k = false;
            return this.j;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            remove();
        }

        @Override // java.util.Iterator
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public j() {
    }

    public static final <T> j<T> create() {
        return j.create();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t) {
        Object[] objArr;
        if (size() == 0) {
            this.k = t;
        } else if (size() == 1) {
            if (m.areEqual(this.k, t)) {
                return false;
            }
            this.k = new Object[]{this.k, t};
        } else if (size() < 5) {
            Object obj = this.k;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr2 = (Object[]) obj;
            if (k.contains(objArr2, t)) {
                return false;
            }
            if (size() == 4) {
                Object[] objArr3 = new Object[objArr2.length];
                System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
                LinkedHashSet linkedHashSetLinkedSetOf = n0.linkedSetOf(objArr3);
                linkedHashSetLinkedSetOf.add(t);
                objArr = linkedHashSetLinkedSetOf;
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(objArr2, size() + 1);
                m.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                objArrCopyOf[objArrCopyOf.length - 1] = t;
                objArr = objArrCopyOf;
            }
            this.k = objArr;
        } else {
            Object obj2 = this.k;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!e0.asMutableSet(obj2).add(t)) {
                return false;
            }
        }
        setSize(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.k = null;
        setSize(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return m.areEqual(this.k, obj);
        }
        if (size() < 5) {
            Object obj2 = this.k;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return k.contains((Object[]) obj2, obj);
        }
        Object obj3 = this.k;
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) obj3).contains(obj);
    }

    public int getSize() {
        return this.l;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.emptySet().iterator();
        }
        if (size() == 1) {
            return new c(this.k);
        }
        if (size() < 5) {
            Object obj = this.k;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new a((Object[]) obj);
        }
        Object obj2 = this.k;
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return e0.asMutableSet(obj2).iterator();
    }

    public void setSize(int i) {
        this.l = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    public j(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
