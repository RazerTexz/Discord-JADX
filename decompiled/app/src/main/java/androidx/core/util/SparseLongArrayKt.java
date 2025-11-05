package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import d0.t.c0;
import d0.t.d0;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: SparseLongArray.kt */
/* loaded from: classes.dex */
public final class SparseLongArrayKt {

    /* compiled from: SparseLongArray.kt */
    /* renamed from: androidx.core.util.SparseLongArrayKt$keyIterator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends c0 {
        public final /* synthetic */ SparseLongArray $this_keyIterator;
        private int index;

        public AnonymousClass1(SparseLongArray sparseLongArray) {
            this.$this_keyIterator = sparseLongArray;
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
            SparseLongArray sparseLongArray = this.$this_keyIterator;
            int i = this.index;
            this.index = i + 1;
            return sparseLongArray.keyAt(i);
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    /* compiled from: SparseLongArray.kt */
    /* renamed from: androidx.core.util.SparseLongArrayKt$valueIterator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0 {
        public final /* synthetic */ SparseLongArray $this_valueIterator;
        private int index;

        public AnonymousClass1(SparseLongArray sparseLongArray) {
            this.$this_valueIterator = sparseLongArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // d0.t.d0
        public long nextLong() {
            SparseLongArray sparseLongArray = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return sparseLongArray.valueAt(i);
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    @RequiresApi(18)
    public static final boolean contains(SparseLongArray sparseLongArray, int i) {
        m.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsKey(SparseLongArray sparseLongArray, int i) {
        m.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(SparseLongArray sparseLongArray, long j) {
        m.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.indexOfValue(j) >= 0;
    }

    @RequiresApi(18)
    public static final void forEach(SparseLongArray sparseLongArray, Function2<? super Integer, ? super Long, Unit> function2) {
        m.checkNotNullParameter(sparseLongArray, "<this>");
        m.checkNotNullParameter(function2, "action");
        int size = sparseLongArray.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            function2.invoke(Integer.valueOf(sparseLongArray.keyAt(i)), Long.valueOf(sparseLongArray.valueAt(i)));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    @RequiresApi(18)
    public static final long getOrDefault(SparseLongArray sparseLongArray, int i, long j) {
        m.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.get(i, j);
    }

    @RequiresApi(18)
    public static final long getOrElse(SparseLongArray sparseLongArray, int i, Function0<Long> function0) {
        m.checkNotNullParameter(sparseLongArray, "<this>");
        m.checkNotNullParameter(function0, "defaultValue");
        int iIndexOfKey = sparseLongArray.indexOfKey(i);
        return iIndexOfKey >= 0 ? sparseLongArray.valueAt(iIndexOfKey) : function0.invoke().longValue();
    }

    @RequiresApi(18)
    public static final int getSize(SparseLongArray sparseLongArray) {
        m.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(SparseLongArray sparseLongArray) {
        m.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(SparseLongArray sparseLongArray) {
        m.checkNotNullParameter(sparseLongArray, "<this>");
        return sparseLongArray.size() != 0;
    }

    @RequiresApi(18)
    public static final c0 keyIterator(SparseLongArray sparseLongArray) {
        m.checkNotNullParameter(sparseLongArray, "<this>");
        return new AnonymousClass1(sparseLongArray);
    }

    @RequiresApi(18)
    public static final SparseLongArray plus(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        m.checkNotNullParameter(sparseLongArray, "<this>");
        m.checkNotNullParameter(sparseLongArray2, "other");
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray2.size() + sparseLongArray.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    @RequiresApi(18)
    public static final void putAll(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        m.checkNotNullParameter(sparseLongArray, "<this>");
        m.checkNotNullParameter(sparseLongArray2, "other");
        int size = sparseLongArray2.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            sparseLongArray.put(sparseLongArray2.keyAt(i), sparseLongArray2.valueAt(i));
            if (i2 >= size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    @RequiresApi(18)
    public static final boolean remove(SparseLongArray sparseLongArray, int i, long j) {
        m.checkNotNullParameter(sparseLongArray, "<this>");
        int iIndexOfKey = sparseLongArray.indexOfKey(i);
        if (iIndexOfKey < 0 || j != sparseLongArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(iIndexOfKey);
        return true;
    }

    @RequiresApi(18)
    public static final void set(SparseLongArray sparseLongArray, int i, long j) {
        m.checkNotNullParameter(sparseLongArray, "<this>");
        sparseLongArray.put(i, j);
    }

    @RequiresApi(18)
    public static final d0 valueIterator(SparseLongArray sparseLongArray) {
        m.checkNotNullParameter(sparseLongArray, "<this>");
        return new AnonymousClass1(sparseLongArray);
    }
}
