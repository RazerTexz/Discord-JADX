package p659s.p660a.p661a;

import java.lang.Comparable;
import java.util.Arrays;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.AbstractC13145r0;
import p659s.p660a.p661a.ThreadSafeHeap2;

/* JADX INFO: renamed from: s.a.a.v, reason: use source file name */
/* JADX INFO: compiled from: ThreadSafeHeap.kt */
/* JADX INFO: loaded from: classes3.dex */
public class ThreadSafeHeap<T extends ThreadSafeHeap2 & Comparable<? super T>> {
    public volatile int _size = 0;

    /* JADX INFO: renamed from: a */
    public T[] f27707a;

    /* JADX INFO: renamed from: a */
    public final void m11174a(T t) {
        AbstractC13145r0.c cVar = (AbstractC13145r0.c) t;
        cVar.mo11180g(this);
        T[] tArr = this.f27707a;
        if (tArr == null) {
            tArr = (T[]) new ThreadSafeHeap2[4];
            this.f27707a = tArr;
        } else if (this._size >= tArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(tArr, this._size * 2);
            Intrinsics3.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            tArr = (T[]) ((ThreadSafeHeap2[]) objArrCopyOf);
            this.f27707a = tArr;
        }
        int i = this._size;
        this._size = i + 1;
        tArr[i] = t;
        cVar.f27893k = i;
        m11177d(i);
    }

    /* JADX INFO: renamed from: b */
    public final T m11175b() {
        T[] tArr = this.f27707a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[SYNTHETIC] */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final T m11176c(int i) {
        T[] tArr = this.f27707a;
        Intrinsics3.checkNotNull(tArr);
        this._size--;
        if (i < this._size) {
            m11178e(i, this._size);
            int i2 = (i - 1) / 2;
            if (i > 0) {
                T t = tArr[i];
                Intrinsics3.checkNotNull(t);
                T t2 = tArr[i2];
                Intrinsics3.checkNotNull(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    m11178e(i, i2);
                    m11177d(i2);
                } else {
                    while (true) {
                        int i3 = (i * 2) + 1;
                        if (i3 >= this._size) {
                            break;
                        }
                        T[] tArr2 = this.f27707a;
                        Intrinsics3.checkNotNull(tArr2);
                        int i4 = i3 + 1;
                        if (i4 < this._size) {
                            T t3 = tArr2[i4];
                            Intrinsics3.checkNotNull(t3);
                            T t4 = tArr2[i3];
                            Intrinsics3.checkNotNull(t4);
                            if (((Comparable) t3).compareTo(t4) < 0) {
                                i3 = i4;
                            }
                        }
                        T t5 = tArr2[i];
                        Intrinsics3.checkNotNull(t5);
                        T t6 = tArr2[i3];
                        Intrinsics3.checkNotNull(t6);
                        if (((Comparable) t5).compareTo(t6) <= 0) {
                            break;
                        }
                        m11178e(i, i3);
                        i = i3;
                    }
                }
            }
        }
        T t7 = tArr[this._size];
        Intrinsics3.checkNotNull(t7);
        t7.mo11180g(null);
        t7.mo11179f(-1);
        tArr[this._size] = null;
        return t7;
    }

    /* JADX INFO: renamed from: d */
    public final void m11177d(int i) {
        while (i > 0) {
            T[] tArr = this.f27707a;
            Intrinsics3.checkNotNull(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            Intrinsics3.checkNotNull(t);
            T t2 = tArr[i];
            Intrinsics3.checkNotNull(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            m11178e(i, i2);
            i = i2;
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m11178e(int i, int i2) {
        T[] tArr = this.f27707a;
        Intrinsics3.checkNotNull(tArr);
        T t = tArr[i2];
        Intrinsics3.checkNotNull(t);
        T t2 = tArr[i];
        Intrinsics3.checkNotNull(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.mo11179f(i);
        t2.mo11179f(i2);
    }
}
