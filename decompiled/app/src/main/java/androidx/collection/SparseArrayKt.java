package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import d0.t.c0;
import d0.z.d.g0.a;
import d0.z.d.m;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: SparseArray.kt */
/* loaded from: classes.dex */
public final class SparseArrayKt {

    /* compiled from: SparseArray.kt */
    /* renamed from: androidx.collection.SparseArrayKt$keyIterator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends c0 {
        public final /* synthetic */ SparseArrayCompat $this_keyIterator;
        private int index;

        public AnonymousClass1(SparseArrayCompat<T> sparseArrayCompat) {
            this.$this_keyIterator = sparseArrayCompat;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_keyIterator.size();
        }

        @Override // d0.t.c0
        public int nextInt() {
            SparseArrayCompat sparseArrayCompat = this.$this_keyIterator;
            int i = this.index;
            this.index = i + 1;
            return sparseArrayCompat.keyAt(i);
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SparseArray.kt */
    /* renamed from: androidx.collection.SparseArrayKt$valueIterator$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Iterator<T>, a {
        public final /* synthetic */ SparseArrayCompat $this_valueIterator;
        private int index;

        public AnonymousClass1(SparseArrayCompat<T> sparseArrayCompat) {
            this.$this_valueIterator = sparseArrayCompat;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArrayCompat sparseArrayCompat = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return (T) sparseArrayCompat.valueAt(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    public static final <T> boolean contains(SparseArrayCompat<T> sparseArrayCompat, int i) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.containsKey(i);
    }

    public static final <T> void forEach(SparseArrayCompat<T> sparseArrayCompat, Function2<? super Integer, ? super T, Unit> function2) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        m.checkParameterIsNotNull(function2, "action");
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(sparseArrayCompat.keyAt(i)), sparseArrayCompat.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(SparseArrayCompat<T> sparseArrayCompat, int i, T t) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.get(i, t);
    }

    public static final <T> T getOrElse(SparseArrayCompat<T> sparseArrayCompat, int i, Function0<? extends T> function0) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        m.checkParameterIsNotNull(function0, "defaultValue");
        T t = sparseArrayCompat.get(i);
        return t != null ? t : function0.invoke();
    }

    public static final <T> int getSize(SparseArrayCompat<T> sparseArrayCompat) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.size();
    }

    public static final <T> boolean isNotEmpty(SparseArrayCompat<T> sparseArrayCompat) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return !sparseArrayCompat.isEmpty();
    }

    public static final <T> c0 keyIterator(SparseArrayCompat<T> sparseArrayCompat) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return new AnonymousClass1(sparseArrayCompat);
    }

    public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> sparseArrayCompat, SparseArrayCompat<T> sparseArrayCompat2) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        m.checkParameterIsNotNull(sparseArrayCompat2, "other");
        SparseArrayCompat<T> sparseArrayCompat3 = new SparseArrayCompat<>(sparseArrayCompat2.size() + sparseArrayCompat.size());
        sparseArrayCompat3.putAll(sparseArrayCompat);
        sparseArrayCompat3.putAll(sparseArrayCompat2);
        return sparseArrayCompat3;
    }

    public static final <T> boolean remove(SparseArrayCompat<T> sparseArrayCompat, int i, T t) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.remove(i, t);
    }

    public static final <T> void set(SparseArrayCompat<T> sparseArrayCompat, int i, T t) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        sparseArrayCompat.put(i, t);
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> sparseArrayCompat) {
        m.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return new AnonymousClass1(sparseArrayCompat);
    }
}
