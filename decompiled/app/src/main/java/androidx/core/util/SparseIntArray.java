package androidx.core.util;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import p507d0.p580t.Iterators4;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.util.SparseIntArrayKt, reason: use source file name */
/* JADX INFO: compiled from: SparseIntArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SparseIntArray {

    /* JADX INFO: renamed from: androidx.core.util.SparseIntArrayKt$keyIterator$1 */
    /* JADX INFO: compiled from: SparseIntArray.kt */
    public static final class C02731 extends Iterators4 {
        public final /* synthetic */ android.util.SparseIntArray $this_keyIterator;
        private int index;

        public C02731(android.util.SparseIntArray sparseIntArray) {
            this.$this_keyIterator = sparseIntArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_keyIterator.size();
        }

        @Override // p507d0.p580t.Iterators4
        public int nextInt() {
            android.util.SparseIntArray sparseIntArray = this.$this_keyIterator;
            int i = this.index;
            this.index = i + 1;
            return sparseIntArray.keyAt(i);
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    /* JADX INFO: renamed from: androidx.core.util.SparseIntArrayKt$valueIterator$1 */
    /* JADX INFO: compiled from: SparseIntArray.kt */
    public static final class C02741 extends Iterators4 {
        public final /* synthetic */ android.util.SparseIntArray $this_valueIterator;
        private int index;

        public C02741(android.util.SparseIntArray sparseIntArray) {
            this.$this_valueIterator = sparseIntArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // p507d0.p580t.Iterators4
        public int nextInt() {
            android.util.SparseIntArray sparseIntArray = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return sparseIntArray.valueAt(i);
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    public static final boolean contains(android.util.SparseIntArray sparseIntArray, int i) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(android.util.SparseIntArray sparseIntArray, int i) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(android.util.SparseIntArray sparseIntArray, int i) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.indexOfValue(i) >= 0;
    }

    public static final void forEach(android.util.SparseIntArray sparseIntArray, Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        Intrinsics3.checkNotNullParameter(function2, "action");
        int size = sparseIntArray.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            function2.invoke(Integer.valueOf(sparseIntArray.keyAt(i)), Integer.valueOf(sparseIntArray.valueAt(i)));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final int getOrDefault(android.util.SparseIntArray sparseIntArray, int i, int i2) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.get(i, i2);
    }

    public static final int getOrElse(android.util.SparseIntArray sparseIntArray, int i, Function0<Integer> function0) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "defaultValue");
        int iIndexOfKey = sparseIntArray.indexOfKey(i);
        return iIndexOfKey >= 0 ? sparseIntArray.valueAt(iIndexOfKey) : function0.invoke().intValue();
    }

    public static final int getSize(android.util.SparseIntArray sparseIntArray) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(android.util.SparseIntArray sparseIntArray) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.size() == 0;
    }

    public static final boolean isNotEmpty(android.util.SparseIntArray sparseIntArray) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return sparseIntArray.size() != 0;
    }

    public static final Iterators4 keyIterator(android.util.SparseIntArray sparseIntArray) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return new C02731(sparseIntArray);
    }

    public static final android.util.SparseIntArray plus(android.util.SparseIntArray sparseIntArray, android.util.SparseIntArray sparseIntArray2) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        Intrinsics3.checkNotNullParameter(sparseIntArray2, "other");
        android.util.SparseIntArray sparseIntArray3 = new android.util.SparseIntArray(sparseIntArray2.size() + sparseIntArray.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void putAll(android.util.SparseIntArray sparseIntArray, android.util.SparseIntArray sparseIntArray2) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        Intrinsics3.checkNotNullParameter(sparseIntArray2, "other");
        int size = sparseIntArray2.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            sparseIntArray.put(sparseIntArray2.keyAt(i), sparseIntArray2.valueAt(i));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final boolean remove(android.util.SparseIntArray sparseIntArray, int i, int i2) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        int iIndexOfKey = sparseIntArray.indexOfKey(i);
        if (iIndexOfKey < 0 || i2 != sparseIntArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final void set(android.util.SparseIntArray sparseIntArray, int i, int i2) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        sparseIntArray.put(i, i2);
    }

    public static final Iterators4 valueIterator(android.util.SparseIntArray sparseIntArray) {
        Intrinsics3.checkNotNullParameter(sparseIntArray, "<this>");
        return new C02741(sparseIntArray);
    }
}
