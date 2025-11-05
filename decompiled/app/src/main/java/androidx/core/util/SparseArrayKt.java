package androidx.core.util;

import android.util.SparseArray;
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
    /* renamed from: androidx.core.util.SparseArrayKt$keyIterator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends c0 {
        public final /* synthetic */ SparseArray<T> $this_keyIterator;
        private int index;

        public AnonymousClass1(SparseArray<T> sparseArray) {
            this.$this_keyIterator = sparseArray;
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
            SparseArray<T> sparseArray = this.$this_keyIterator;
            int i = this.index;
            this.index = i + 1;
            return sparseArray.keyAt(i);
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SparseArray.kt */
    /* renamed from: androidx.core.util.SparseArrayKt$valueIterator$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Iterator<T>, a {
        public final /* synthetic */ SparseArray<T> $this_valueIterator;
        private int index;

        public AnonymousClass1(SparseArray<T> sparseArray) {
            this.$this_valueIterator = sparseArray;
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
            SparseArray<T> sparseArray = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return sparseArray.valueAt(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    public static final <T> boolean contains(SparseArray<T> sparseArray, int i) {
        m.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsKey(SparseArray<T> sparseArray, int i) {
        m.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsValue(SparseArray<T> sparseArray, T t) {
        m.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.indexOfValue(t) >= 0;
    }

    public static final <T> void forEach(SparseArray<T> sparseArray, Function2<? super Integer, ? super T, Unit> function2) {
        m.checkNotNullParameter(sparseArray, "<this>");
        m.checkNotNullParameter(function2, "action");
        int size = sparseArray.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            function2.invoke(Integer.valueOf(sparseArray.keyAt(i)), sparseArray.valueAt(i));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> sparseArray, int i, T t) {
        m.checkNotNullParameter(sparseArray, "<this>");
        T t2 = sparseArray.get(i);
        return t2 == null ? t : t2;
    }

    public static final <T> T getOrElse(SparseArray<T> sparseArray, int i, Function0<? extends T> function0) {
        m.checkNotNullParameter(sparseArray, "<this>");
        m.checkNotNullParameter(function0, "defaultValue");
        T t = sparseArray.get(i);
        return t == null ? function0.invoke() : t;
    }

    public static final <T> int getSize(SparseArray<T> sparseArray) {
        m.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> sparseArray) {
        m.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> sparseArray) {
        m.checkNotNullParameter(sparseArray, "<this>");
        return sparseArray.size() != 0;
    }

    public static final <T> c0 keyIterator(SparseArray<T> sparseArray) {
        m.checkNotNullParameter(sparseArray, "<this>");
        return new AnonymousClass1(sparseArray);
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        m.checkNotNullParameter(sparseArray, "<this>");
        m.checkNotNullParameter(sparseArray2, "other");
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray2.size() + sparseArray.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        m.checkNotNullParameter(sparseArray, "<this>");
        m.checkNotNullParameter(sparseArray2, "other");
        int size = sparseArray2.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            sparseArray.put(sparseArray2.keyAt(i), sparseArray2.valueAt(i));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final <T> boolean remove(SparseArray<T> sparseArray, int i, T t) {
        m.checkNotNullParameter(sparseArray, "<this>");
        int iIndexOfKey = sparseArray.indexOfKey(i);
        if (iIndexOfKey < 0 || !m.areEqual(t, sparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final <T> void set(SparseArray<T> sparseArray, int i, T t) {
        m.checkNotNullParameter(sparseArray, "<this>");
        sparseArray.put(i, t);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> sparseArray) {
        m.checkNotNullParameter(sparseArray, "<this>");
        return new AnonymousClass1(sparseArray);
    }
}
