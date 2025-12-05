package p507d0.p513e0.p514p.p515d.p517m0.p576p;

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
import p507d0.p580t.Sets5;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.ArrayIterator4;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.TypeIntrinsics;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* compiled from: SmartSet.kt */
/* renamed from: d0.e0.p.d.m0.p.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class SmartSet<T> extends AbstractSet<T> {

    /* renamed from: j */
    public static final b f25003j = new b(null);

    /* renamed from: k */
    public Object f25004k;

    /* renamed from: l */
    public int f25005l;

    /* compiled from: SmartSet.kt */
    /* renamed from: d0.e0.p.d.m0.p.j$a */
    public static final class a<T> implements Iterator<T>, KMarkers {

        /* renamed from: j */
        public final Iterator<T> f25006j;

        public a(T[] tArr) {
            Intrinsics3.checkNotNullParameter(tArr, "array");
            this.f25006j = ArrayIterator4.iterator(tArr);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25006j.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f25006j.next();
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
    /* renamed from: d0.e0.p.d.m0.p.j$b */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final <T> SmartSet<T> create() {
            return new SmartSet<>(null);
        }

        public final <T> SmartSet<T> create(Collection<? extends T> collection) {
            Intrinsics3.checkNotNullParameter(collection, "set");
            SmartSet<T> smartSet = new SmartSet<>(null);
            smartSet.addAll(collection);
            return smartSet;
        }
    }

    /* compiled from: SmartSet.kt */
    /* renamed from: d0.e0.p.d.m0.p.j$c */
    public static final class c<T> implements Iterator<T>, KMarkers {

        /* renamed from: j */
        public final T f25007j;

        /* renamed from: k */
        public boolean f25008k = true;

        public c(T t) {
            this.f25007j = t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25008k;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f25008k) {
                throw new NoSuchElementException();
            }
            this.f25008k = false;
            return this.f25007j;
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

    public SmartSet() {
    }

    public static final <T> SmartSet<T> create() {
        return f25003j.create();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t) {
        Object[] objArr;
        if (size() == 0) {
            this.f25004k = t;
        } else if (size() == 1) {
            if (Intrinsics3.areEqual(this.f25004k, t)) {
                return false;
            }
            this.f25004k = new Object[]{this.f25004k, t};
        } else if (size() < 5) {
            Object obj = this.f25004k;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr2 = (Object[]) obj;
            if (_Arrays.contains(objArr2, t)) {
                return false;
            }
            if (size() == 4) {
                Object[] objArr3 = new Object[objArr2.length];
                System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
                LinkedHashSet linkedHashSetLinkedSetOf = Sets5.linkedSetOf(objArr3);
                linkedHashSetLinkedSetOf.add(t);
                objArr = linkedHashSetLinkedSetOf;
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(objArr2, size() + 1);
                Intrinsics3.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                objArrCopyOf[objArrCopyOf.length - 1] = t;
                objArr = objArrCopyOf;
            }
            this.f25004k = objArr;
        } else {
            Object obj2 = this.f25004k;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!TypeIntrinsics.asMutableSet(obj2).add(t)) {
                return false;
            }
        }
        setSize(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f25004k = null;
        setSize(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return Intrinsics3.areEqual(this.f25004k, obj);
        }
        if (size() < 5) {
            Object obj2 = this.f25004k;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return _Arrays.contains((Object[]) obj2, obj);
        }
        Object obj3 = this.f25004k;
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) obj3).contains(obj);
    }

    public int getSize() {
        return this.f25005l;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.emptySet().iterator();
        }
        if (size() == 1) {
            return new c(this.f25004k);
        }
        if (size() < 5) {
            Object obj = this.f25004k;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new a((Object[]) obj);
        }
        Object obj2 = this.f25004k;
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return TypeIntrinsics.asMutableSet(obj2).iterator();
    }

    public void setSize(int i) {
        this.f25005l = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    public SmartSet(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
