package p007b.p225i.p226a.p242c.p257e3.p258b0;

import androidx.annotation.Nullable;
import java.io.File;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.h, reason: use source file name */
/* JADX INFO: compiled from: CacheSpan.java */
/* JADX INFO: loaded from: classes3.dex */
public class CacheSpan implements Comparable<CacheSpan> {

    /* JADX INFO: renamed from: j */
    public final String f6465j;

    /* JADX INFO: renamed from: k */
    public final long f6466k;

    /* JADX INFO: renamed from: l */
    public final long f6467l;

    /* JADX INFO: renamed from: m */
    public final boolean f6468m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public final File f6469n;

    /* JADX INFO: renamed from: o */
    public final long f6470o;

    public CacheSpan(String str, long j, long j2, long j3, @Nullable File file) {
        this.f6465j = str;
        this.f6466k = j;
        this.f6467l = j2;
        this.f6468m = file != null;
        this.f6469n = file;
        this.f6470o = j3;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CacheSpan cacheSpan) {
        return m2791f(cacheSpan);
    }

    /* JADX INFO: renamed from: f */
    public int m2791f(CacheSpan cacheSpan) {
        if (!this.f6465j.equals(cacheSpan.f6465j)) {
            return this.f6465j.compareTo(cacheSpan.f6465j);
        }
        long j = this.f6466k - cacheSpan.f6466k;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }

    public String toString() {
        long j = this.f6466k;
        return outline.m815C(outline.m830R(44, "[", j, ", "), this.f6467l, "]");
    }
}
