package p507d0.p580t;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p512d0._Ranges;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SlidingWindow.kt */
/* renamed from: d0.t.l0, reason: use source file name */
/* loaded from: classes3.dex */
public final class SlidingWindow<T> extends AbstractList<T> implements RandomAccess {

    /* renamed from: k */
    public final int f25191k;

    /* renamed from: l */
    public int f25192l;

    /* renamed from: m */
    public int f25193m;

    /* renamed from: n */
    public final Object[] f25194n;

    /* compiled from: SlidingWindow.kt */
    /* renamed from: d0.t.l0$a */
    public static final class a extends AbstractIterator3<T> {

        /* renamed from: l */
        public int f25195l;

        /* renamed from: m */
        public int f25196m;

        public a() {
            this.f25195l = SlidingWindow.this.size();
            this.f25196m = SlidingWindow.access$getStartIndex$p(SlidingWindow.this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p507d0.p580t.AbstractIterator3
        /* renamed from: a */
        public void mo10059a() {
            if (this.f25195l == 0) {
                this.f25173j = 3;
                return;
            }
            m10074b(SlidingWindow.access$getBuffer$p(SlidingWindow.this)[this.f25196m]);
            this.f25196m = (this.f25196m + 1) % SlidingWindow.access$getCapacity$p(SlidingWindow.this);
            this.f25195l--;
        }
    }

    public SlidingWindow(Object[] objArr, int i) {
        Intrinsics3.checkNotNullParameter(objArr, "buffer");
        this.f25194n = objArr;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(outline.m871q("ring buffer filled size should not be negative but it is ", i).toString());
        }
        if (i <= objArr.length) {
            this.f25191k = objArr.length;
            this.f25193m = i;
        } else {
            StringBuilder sbM834V = outline.m834V("ring buffer filled size: ", i, " cannot be larger than the buffer size: ");
            sbM834V.append(objArr.length);
            throw new IllegalArgumentException(sbM834V.toString().toString());
        }
    }

    public static final /* synthetic */ Object[] access$getBuffer$p(SlidingWindow slidingWindow) {
        return slidingWindow.f25194n;
    }

    public static final /* synthetic */ int access$getCapacity$p(SlidingWindow slidingWindow) {
        return slidingWindow.f25191k;
    }

    public static final /* synthetic */ int access$getStartIndex$p(SlidingWindow slidingWindow) {
        return slidingWindow.f25192l;
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T t) {
        if (isFull()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f25194n[(size() + this.f25192l) % access$getCapacity$p(this)] = t;
        this.f25193m = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SlidingWindow<T> expanded(int i) {
        Object[] array;
        int i2 = this.f25191k;
        int iCoerceAtMost = _Ranges.coerceAtMost(i2 + (i2 >> 1) + 1, i);
        if (this.f25192l == 0) {
            array = Arrays.copyOf(this.f25194n, iCoerceAtMost);
            Intrinsics3.checkNotNullExpressionValue(array, "java.util.Arrays.copyOf(this, newSize)");
        } else {
            array = toArray(new Object[iCoerceAtMost]);
        }
        return new SlidingWindow<>(array, size());
    }

    @Override // p507d0.p580t.AbstractList, java.util.List
    public T get(int i) {
        AbstractList.f25177j.checkElementIndex$kotlin_stdlib(i, size());
        return (T) this.f25194n[(this.f25192l + i) % access$getCapacity$p(this)];
    }

    @Override // p507d0.p580t.AbstractCollection
    public int getSize() {
        return this.f25193m;
    }

    public final boolean isFull() {
        return size() == this.f25191k;
    }

    @Override // p507d0.p580t.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new a();
    }

    public final void removeFirst(int i) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(outline.m871q("n shouldn't be negative but it is ", i).toString());
        }
        if (!(i <= size())) {
            StringBuilder sbM834V = outline.m834V("n shouldn't be greater than the buffer size: n = ", i, ", size = ");
            sbM834V.append(size());
            throw new IllegalArgumentException(sbM834V.toString().toString());
        }
        if (i > 0) {
            int i2 = this.f25192l;
            int iAccess$getCapacity$p = (i2 + i) % access$getCapacity$p(this);
            if (i2 > iAccess$getCapacity$p) {
                _ArraysJvm.fill(this.f25194n, (Object) null, i2, this.f25191k);
                _ArraysJvm.fill(this.f25194n, (Object) null, 0, iAccess$getCapacity$p);
            } else {
                _ArraysJvm.fill(this.f25194n, (Object) null, i2, iAccess$getCapacity$p);
            }
            this.f25192l = iAccess$getCapacity$p;
            this.f25193m = size() - i;
        }
    }

    @Override // p507d0.p580t.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
            Intrinsics3.checkNotNullExpressionValue(tArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i = 0;
        int i2 = 0;
        for (int i3 = this.f25192l; i2 < size && i3 < this.f25191k; i3++) {
            tArr[i2] = this.f25194n[i3];
            i2++;
        }
        while (i2 < size) {
            tArr[i2] = this.f25194n[i];
            i2++;
            i++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }

    public SlidingWindow(int i) {
        this(new Object[i], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p507d0.p580t.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
