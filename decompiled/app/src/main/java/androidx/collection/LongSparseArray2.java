package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import p507d0.p580t.Iterators5;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* JADX INFO: renamed from: androidx.collection.LongSparseArrayKt, reason: use source file name */
/* JADX INFO: compiled from: LongSparseArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LongSparseArray2 {

    /* JADX INFO: renamed from: androidx.collection.LongSparseArrayKt$keyIterator$1 */
    /* JADX INFO: compiled from: LongSparseArray.kt */
    public static final class C01651 extends Iterators5 {
        public final /* synthetic */ LongSparseArray $this_keyIterator;
        private int index;

        public C01651(LongSparseArray<T> longSparseArray) {
            this.$this_keyIterator = longSparseArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_keyIterator.size();
        }

        @Override // p507d0.p580t.Iterators5
        public long nextLong() {
            LongSparseArray longSparseArray = this.$this_keyIterator;
            int i = this.index;
            this.index = i + 1;
            return longSparseArray.keyAt(i);
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.collection.LongSparseArrayKt$valueIterator$1 */
    /* JADX INFO: compiled from: LongSparseArray.kt */
    public static final class C01661<T> implements Iterator<T>, KMarkers {
        public final /* synthetic */ LongSparseArray $this_valueIterator;
        private int index;

        public C01661(LongSparseArray<T> longSparseArray) {
            this.$this_valueIterator = longSparseArray;
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
            LongSparseArray longSparseArray = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return (T) longSparseArray.valueAt(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j) {
        Intrinsics3.checkParameterIsNotNull(longSparseArray, "receiver$0");
        return longSparseArray.containsKey(j);
    }

    public static final <T> void forEach(LongSparseArray<T> longSparseArray, Function2<? super Long, ? super T, Unit> function2) {
        Intrinsics3.checkParameterIsNotNull(longSparseArray, "receiver$0");
        Intrinsics3.checkParameterIsNotNull(function2, "action");
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Long.valueOf(longSparseArray.keyAt(i)), longSparseArray.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j, T t) {
        Intrinsics3.checkParameterIsNotNull(longSparseArray, "receiver$0");
        return longSparseArray.get(j, t);
    }

    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j, Function0<? extends T> function0) {
        Intrinsics3.checkParameterIsNotNull(longSparseArray, "receiver$0");
        Intrinsics3.checkParameterIsNotNull(function0, "defaultValue");
        T t = longSparseArray.get(j);
        return t != null ? t : function0.invoke();
    }

    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        Intrinsics3.checkParameterIsNotNull(longSparseArray, "receiver$0");
        return longSparseArray.size();
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        Intrinsics3.checkParameterIsNotNull(longSparseArray, "receiver$0");
        return !longSparseArray.isEmpty();
    }

    public static final <T> Iterators5 keyIterator(LongSparseArray<T> longSparseArray) {
        Intrinsics3.checkParameterIsNotNull(longSparseArray, "receiver$0");
        return new C01651(longSparseArray);
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        Intrinsics3.checkParameterIsNotNull(longSparseArray, "receiver$0");
        Intrinsics3.checkParameterIsNotNull(longSparseArray2, "other");
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray2.size() + longSparseArray.size());
        longSparseArray3.putAll(longSparseArray);
        longSparseArray3.putAll(longSparseArray2);
        return longSparseArray3;
    }

    public static final <T> boolean remove(LongSparseArray<T> longSparseArray, long j, T t) {
        Intrinsics3.checkParameterIsNotNull(longSparseArray, "receiver$0");
        return longSparseArray.remove(j, t);
    }

    public static final <T> void set(LongSparseArray<T> longSparseArray, long j, T t) {
        Intrinsics3.checkParameterIsNotNull(longSparseArray, "receiver$0");
        longSparseArray.put(j, t);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        Intrinsics3.checkParameterIsNotNull(longSparseArray, "receiver$0");
        return new C01661(longSparseArray);
    }
}
