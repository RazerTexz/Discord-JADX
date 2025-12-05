package p507d0.p512d0;

import java.util.NoSuchElementException;
import p507d0.p580t.Iterators4;

/* compiled from: ProgressionIterators.kt */
/* renamed from: d0.d0.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class ProgressionIterators extends Iterators4 {

    /* renamed from: j */
    public final int f22279j;

    /* renamed from: k */
    public boolean f22280k;

    /* renamed from: l */
    public int f22281l;

    /* renamed from: m */
    public final int f22282m;

    public ProgressionIterators(int i, int i2, int i3) {
        this.f22282m = i3;
        this.f22279j = i2;
        boolean z2 = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z2 = false;
        }
        this.f22280k = z2;
        this.f22281l = z2 ? i : i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f22280k;
    }

    @Override // p507d0.p580t.Iterators4
    public int nextInt() {
        int i = this.f22281l;
        if (i != this.f22279j) {
            this.f22281l = this.f22282m + i;
        } else {
            if (!this.f22280k) {
                throw new NoSuchElementException();
            }
            this.f22280k = false;
        }
        return i;
    }
}
