package p507d0.p512d0;

import java.util.NoSuchElementException;
import p507d0.p580t.Iterators5;

/* compiled from: ProgressionIterators.kt */
/* renamed from: d0.d0.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class ProgressionIterators2 extends Iterators5 {

    /* renamed from: j */
    public final long f22286j;

    /* renamed from: k */
    public boolean f22287k;

    /* renamed from: l */
    public long f22288l;

    /* renamed from: m */
    public final long f22289m;

    public ProgressionIterators2(long j, long j2, long j3) {
        this.f22289m = j3;
        this.f22286j = j2;
        boolean z2 = true;
        if (j3 <= 0 ? j < j2 : j > j2) {
            z2 = false;
        }
        this.f22287k = z2;
        this.f22288l = z2 ? j : j2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f22287k;
    }

    @Override // p507d0.p580t.Iterators5
    public long nextLong() {
        long j = this.f22288l;
        if (j != this.f22286j) {
            this.f22288l = this.f22289m + j;
        } else {
            if (!this.f22287k) {
                throw new NoSuchElementException();
            }
            this.f22287k = false;
        }
        return j;
    }
}
