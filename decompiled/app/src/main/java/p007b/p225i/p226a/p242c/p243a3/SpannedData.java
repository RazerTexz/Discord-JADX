package p007b.p225i.p226a.p242c.p243a3;

import android.util.SparseArray;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.Consumer3;

/* JADX INFO: renamed from: b.i.a.c.a3.m0, reason: use source file name */
/* JADX INFO: compiled from: SpannedData.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SpannedData<V> {

    /* JADX INFO: renamed from: c */
    public final Consumer3<V> f5650c;

    /* JADX INFO: renamed from: b */
    public final SparseArray<V> f5649b = new SparseArray<>();

    /* JADX INFO: renamed from: a */
    public int f5648a = -1;

    public SpannedData(Consumer3<V> consumer3) {
        this.f5650c = consumer3;
    }

    /* JADX INFO: renamed from: a */
    public void m2560a(int i, V v) {
        if (this.f5648a == -1) {
            AnimatableValueParser.m426D(this.f5649b.size() == 0);
            this.f5648a = 0;
        }
        if (this.f5649b.size() > 0) {
            SparseArray<V> sparseArray = this.f5649b;
            int iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
            AnimatableValueParser.m531j(i >= iKeyAt);
            if (iKeyAt == i) {
                Consumer3<V> consumer3 = this.f5650c;
                SparseArray<V> sparseArray2 = this.f5649b;
                consumer3.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f5649b.append(i, v);
    }

    /* JADX INFO: renamed from: b */
    public V m2561b(int i) {
        if (this.f5648a == -1) {
            this.f5648a = 0;
        }
        while (true) {
            int i2 = this.f5648a;
            if (i2 <= 0 || i >= this.f5649b.keyAt(i2)) {
                break;
            }
            this.f5648a--;
        }
        while (this.f5648a < this.f5649b.size() - 1 && i >= this.f5649b.keyAt(this.f5648a + 1)) {
            this.f5648a++;
        }
        return this.f5649b.valueAt(this.f5648a);
    }

    /* JADX INFO: renamed from: c */
    public V m2562c() {
        return this.f5649b.valueAt(r0.size() - 1);
    }
}
