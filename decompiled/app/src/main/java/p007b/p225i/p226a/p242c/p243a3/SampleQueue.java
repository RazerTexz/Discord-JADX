package p007b.p225i.p226a.p242c.p243a3;

import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.FormatHolder;
import p007b.p225i.p226a.p242c.p243a3.SampleDataQueue;
import p007b.p225i.p226a.p242c.p257e3.Allocation;
import p007b.p225i.p226a.p242c.p257e3.DataReader;
import p007b.p225i.p226a.p242c.p257e3.DefaultAllocator;
import p007b.p225i.p226a.p242c.p259f3.MimeTypes;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p266w2.C2982m;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionManager2;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;

/* compiled from: SampleQueue.java */
/* renamed from: b.i.a.c.a3.h0, reason: use source file name */
/* loaded from: classes3.dex */
public class SampleQueue implements TrackOutput2 {

    /* renamed from: A */
    @Nullable
    public Format2 f5592A;

    /* renamed from: B */
    @Nullable
    public Format2 f5593B;

    /* renamed from: C */
    public boolean f5594C;

    /* renamed from: D */
    public boolean f5595D;

    /* renamed from: a */
    public final SampleDataQueue f5596a;

    /* renamed from: d */
    @Nullable
    public final DrmSessionManager2 f5599d;

    /* renamed from: e */
    @Nullable
    public final DrmSessionEventListener.a f5600e;

    /* renamed from: f */
    @Nullable
    public final Looper f5601f;

    /* renamed from: g */
    @Nullable
    public d f5602g;

    /* renamed from: h */
    @Nullable
    public Format2 f5603h;

    /* renamed from: i */
    @Nullable
    public DrmSession f5604i;

    /* renamed from: q */
    public int f5612q;

    /* renamed from: r */
    public int f5613r;

    /* renamed from: s */
    public int f5614s;

    /* renamed from: t */
    public int f5615t;

    /* renamed from: x */
    public boolean f5619x;

    /* renamed from: b */
    public final b f5597b = new b();

    /* renamed from: j */
    public int f5605j = 1000;

    /* renamed from: k */
    public int[] f5606k = new int[1000];

    /* renamed from: l */
    public long[] f5607l = new long[1000];

    /* renamed from: o */
    public long[] f5610o = new long[1000];

    /* renamed from: n */
    public int[] f5609n = new int[1000];

    /* renamed from: m */
    public int[] f5608m = new int[1000];

    /* renamed from: p */
    public TrackOutput2.a[] f5611p = new TrackOutput2.a[1000];

    /* renamed from: c */
    public final SpannedData<c> f5598c = new SpannedData<>(C2549k.f5629a);

    /* renamed from: u */
    public long f5616u = Long.MIN_VALUE;

    /* renamed from: v */
    public long f5617v = Long.MIN_VALUE;

    /* renamed from: w */
    public long f5618w = Long.MIN_VALUE;

    /* renamed from: z */
    public boolean f5621z = true;

    /* renamed from: y */
    public boolean f5620y = true;

    /* compiled from: SampleQueue.java */
    /* renamed from: b.i.a.c.a3.h0$b */
    public static final class b {

        /* renamed from: a */
        public int f5622a;

        /* renamed from: b */
        public long f5623b;

        /* renamed from: c */
        @Nullable
        public TrackOutput2.a f5624c;
    }

    /* compiled from: SampleQueue.java */
    /* renamed from: b.i.a.c.a3.h0$c */
    public static final class c {

        /* renamed from: a */
        public final Format2 f5625a;

        /* renamed from: b */
        public final DrmSessionManager2.b f5626b;

        public c(Format2 format2, DrmSessionManager2.b bVar, a aVar) {
            this.f5625a = format2;
            this.f5626b = bVar;
        }
    }

    /* compiled from: SampleQueue.java */
    /* renamed from: b.i.a.c.a3.h0$d */
    public interface d {
    }

    public SampleQueue(DefaultAllocator defaultAllocator, @Nullable Looper looper, @Nullable DrmSessionManager2 drmSessionManager2, @Nullable DrmSessionEventListener.a aVar) {
        this.f5601f = looper;
        this.f5599d = drmSessionManager2;
        this.f5600e = aVar;
        this.f5596a = new SampleDataQueue(defaultAllocator);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.TrackOutput2
    /* renamed from: a */
    public final int mo2522a(DataReader dataReader, int i, boolean z2, int i2) throws IOException {
        SampleDataQueue sampleDataQueue = this.f5596a;
        int iM2520c = sampleDataQueue.m2520c(i);
        SampleDataQueue.a aVar = sampleDataQueue.f5583f;
        int i3 = dataReader.read(aVar.f5588d.f6522a, aVar.m2521a(sampleDataQueue.f5584g), iM2520c);
        if (i3 != -1) {
            sampleDataQueue.m2519b(i3);
            return i3;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.TrackOutput2
    /* renamed from: b */
    public /* synthetic */ int mo2523b(DataReader dataReader, int i, boolean z2) {
        return TrackOutput.m3817a(this, dataReader, i, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.TrackOutput2
    /* renamed from: c */
    public /* synthetic */ void mo2524c(ParsableByteArray parsableByteArray, int i) {
        TrackOutput.m3818b(this, parsableByteArray, i);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.TrackOutput2
    /* renamed from: d */
    public void mo2525d(long j, int i, int i2, int i3, @Nullable TrackOutput2.a aVar) {
        DrmSessionManager2.b bVarMo3598b;
        int i4 = i & 1;
        boolean z2 = i4 != 0;
        if (this.f5620y) {
            if (!z2) {
                return;
            } else {
                this.f5620y = false;
            }
        }
        long j2 = j + 0;
        if (this.f5594C) {
            if (j2 < this.f5616u) {
                return;
            }
            if (i4 == 0) {
                if (!this.f5595D) {
                    String strValueOf = String.valueOf(this.f5593B);
                    outline.m854h0(strValueOf.length() + 50, "Overriding unexpected non-sync sample for format: ", strValueOf, "SampleQueue");
                    this.f5595D = true;
                }
                i |= 1;
            }
        }
        long j3 = (this.f5596a.f5584g - i2) - i3;
        synchronized (this) {
            int i5 = this.f5612q;
            if (i5 > 0) {
                int iM2533l = m2533l(i5 - 1);
                AnimatableValueParser.m531j(this.f5607l[iM2533l] + ((long) this.f5608m[iM2533l]) <= j3);
            }
            this.f5619x = (536870912 & i) != 0;
            this.f5618w = Math.max(this.f5618w, j2);
            int iM2533l2 = m2533l(this.f5612q);
            this.f5610o[iM2533l2] = j2;
            this.f5607l[iM2533l2] = j3;
            this.f5608m[iM2533l2] = i2;
            this.f5609n[iM2533l2] = i;
            this.f5611p[iM2533l2] = aVar;
            this.f5606k[iM2533l2] = 0;
            if ((this.f5598c.f5649b.size() == 0) || !this.f5598c.m2562c().f5625a.equals(this.f5593B)) {
                DrmSessionManager2 drmSessionManager2 = this.f5599d;
                if (drmSessionManager2 != null) {
                    Looper looper = this.f5601f;
                    Objects.requireNonNull(looper);
                    bVarMo3598b = drmSessionManager2.mo3598b(looper, this.f5600e, this.f5593B);
                } else {
                    bVarMo3598b = C2982m.f8003b;
                }
                SpannedData<c> spannedData = this.f5598c;
                int iM2535n = m2535n();
                Format2 format2 = this.f5593B;
                Objects.requireNonNull(format2);
                spannedData.m2560a(iM2535n, new c(format2, bVarMo3598b, null));
            }
            int i6 = this.f5612q + 1;
            this.f5612q = i6;
            int i7 = this.f5605j;
            if (i6 == i7) {
                int i8 = i7 + 1000;
                int[] iArr = new int[i8];
                long[] jArr = new long[i8];
                long[] jArr2 = new long[i8];
                int[] iArr2 = new int[i8];
                int[] iArr3 = new int[i8];
                TrackOutput2.a[] aVarArr = new TrackOutput2.a[i8];
                int i9 = this.f5614s;
                int i10 = i7 - i9;
                System.arraycopy(this.f5607l, i9, jArr, 0, i10);
                System.arraycopy(this.f5610o, this.f5614s, jArr2, 0, i10);
                System.arraycopy(this.f5609n, this.f5614s, iArr2, 0, i10);
                System.arraycopy(this.f5608m, this.f5614s, iArr3, 0, i10);
                System.arraycopy(this.f5611p, this.f5614s, aVarArr, 0, i10);
                System.arraycopy(this.f5606k, this.f5614s, iArr, 0, i10);
                int i11 = this.f5614s;
                System.arraycopy(this.f5607l, 0, jArr, i10, i11);
                System.arraycopy(this.f5610o, 0, jArr2, i10, i11);
                System.arraycopy(this.f5609n, 0, iArr2, i10, i11);
                System.arraycopy(this.f5608m, 0, iArr3, i10, i11);
                System.arraycopy(this.f5611p, 0, aVarArr, i10, i11);
                System.arraycopy(this.f5606k, 0, iArr, i10, i11);
                this.f5607l = jArr;
                this.f5610o = jArr2;
                this.f5609n = iArr2;
                this.f5608m = iArr3;
                this.f5611p = aVarArr;
                this.f5606k = iArr;
                this.f5614s = 0;
                this.f5605j = i8;
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.TrackOutput2
    /* renamed from: e */
    public final void mo2526e(Format2 format2) {
        boolean z2;
        this.f5592A = format2;
        synchronized (this) {
            z2 = false;
            this.f5621z = false;
            if (!Util2.m2993a(format2, this.f5593B)) {
                if ((this.f5598c.f5649b.size() == 0) || !this.f5598c.m2562c().f5625a.equals(format2)) {
                    this.f5593B = format2;
                } else {
                    this.f5593B = this.f5598c.m2562c().f5625a;
                }
                Format2 format22 = this.f5593B;
                this.f5594C = MimeTypes.m3043a(format22.f7155w, format22.f7152t);
                this.f5595D = false;
                z2 = true;
            }
        }
        d dVar = this.f5602g;
        if (dVar == null || !z2) {
            return;
        }
        ProgressiveMediaPeriod progressiveMediaPeriod = (ProgressiveMediaPeriod) dVar;
        progressiveMediaPeriod.f5500A.post(progressiveMediaPeriod.f5536y);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.TrackOutput2
    /* renamed from: f */
    public final void mo2527f(ParsableByteArray parsableByteArray, int i, int i2) {
        SampleDataQueue sampleDataQueue = this.f5596a;
        Objects.requireNonNull(sampleDataQueue);
        while (i > 0) {
            int iM2520c = sampleDataQueue.m2520c(i);
            SampleDataQueue.a aVar = sampleDataQueue.f5583f;
            parsableByteArray.m3085e(aVar.f5588d.f6522a, aVar.m2521a(sampleDataQueue.f5584g), iM2520c);
            i -= iM2520c;
            sampleDataQueue.m2519b(iM2520c);
        }
    }

    @GuardedBy("this")
    /* renamed from: g */
    public final long m2528g(int i) {
        this.f5617v = Math.max(this.f5617v, m2531j(i));
        this.f5612q -= i;
        int i2 = this.f5613r + i;
        this.f5613r = i2;
        int i3 = this.f5614s + i;
        this.f5614s = i3;
        int i4 = this.f5605j;
        if (i3 >= i4) {
            this.f5614s = i3 - i4;
        }
        int i5 = this.f5615t - i;
        this.f5615t = i5;
        int i6 = 0;
        if (i5 < 0) {
            this.f5615t = 0;
        }
        SpannedData<c> spannedData = this.f5598c;
        while (i6 < spannedData.f5649b.size() - 1) {
            int i7 = i6 + 1;
            if (i2 < spannedData.f5649b.keyAt(i7)) {
                break;
            }
            spannedData.f5650c.accept(spannedData.f5649b.valueAt(i6));
            spannedData.f5649b.removeAt(i6);
            int i8 = spannedData.f5648a;
            if (i8 > 0) {
                spannedData.f5648a = i8 - 1;
            }
            i6 = i7;
        }
        if (this.f5612q != 0) {
            return this.f5607l[this.f5614s];
        }
        int i9 = this.f5614s;
        if (i9 == 0) {
            i9 = this.f5605j;
        }
        return this.f5607l[i9 - 1] + this.f5608m[r6];
    }

    /* renamed from: h */
    public final void m2529h() {
        long jM2528g;
        SampleDataQueue sampleDataQueue = this.f5596a;
        synchronized (this) {
            int i = this.f5612q;
            jM2528g = i == 0 ? -1L : m2528g(i);
        }
        sampleDataQueue.m2518a(jM2528g);
    }

    /* renamed from: i */
    public final int m2530i(int i, int i2, long j, boolean z2) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long[] jArr = this.f5610o;
            if (jArr[i] > j) {
                return i3;
            }
            if (!z2 || (this.f5609n[i] & 1) != 0) {
                if (jArr[i] == j) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.f5605j) {
                i = 0;
            }
        }
        return i3;
    }

    /* renamed from: j */
    public final long m2531j(int i) {
        long jMax = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int iM2533l = m2533l(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            jMax = Math.max(jMax, this.f5610o[iM2533l]);
            if ((this.f5609n[iM2533l] & 1) != 0) {
                break;
            }
            iM2533l--;
            if (iM2533l == -1) {
                iM2533l = this.f5605j - 1;
            }
        }
        return jMax;
    }

    /* renamed from: k */
    public final int m2532k() {
        return this.f5613r + this.f5615t;
    }

    /* renamed from: l */
    public final int m2533l(int i) {
        int i2 = this.f5614s + i;
        int i3 = this.f5605j;
        return i2 < i3 ? i2 : i2 - i3;
    }

    @Nullable
    /* renamed from: m */
    public final synchronized Format2 m2534m() {
        return this.f5621z ? null : this.f5593B;
    }

    /* renamed from: n */
    public final int m2535n() {
        return this.f5613r + this.f5612q;
    }

    /* renamed from: o */
    public final boolean m2536o() {
        return this.f5615t != this.f5612q;
    }

    @CallSuper
    /* renamed from: p */
    public synchronized boolean m2537p(boolean z2) {
        Format2 format2;
        boolean z3 = true;
        if (m2536o()) {
            if (this.f5598c.m2561b(m2532k()).f5625a != this.f5603h) {
                return true;
            }
            return m2538q(m2533l(this.f5615t));
        }
        if (!z2 && !this.f5619x && ((format2 = this.f5593B) == null || format2 == this.f5603h)) {
            z3 = false;
        }
        return z3;
    }

    /* renamed from: q */
    public final boolean m2538q(int i) {
        DrmSession drmSession = this.f5604i;
        return drmSession == null || drmSession.getState() == 4 || ((this.f5609n[i] & BasicMeasure.EXACTLY) == 0 && this.f5604i.mo3609d());
    }

    /* renamed from: r */
    public final void m2539r(Format2 format2, FormatHolder formatHolder) {
        Format2 format2M3277a;
        Format2 format22 = this.f5603h;
        boolean z2 = format22 == null;
        DrmInitData drmInitData = z2 ? null : format22.f7158z;
        this.f5603h = format2;
        DrmInitData drmInitData2 = format2.f7158z;
        DrmSessionManager2 drmSessionManager2 = this.f5599d;
        if (drmSessionManager2 != null) {
            int iMo3600d = drmSessionManager2.mo3600d(format2);
            Format2.b bVarM3275a = format2.m3275a();
            bVarM3275a.f7162D = iMo3600d;
            format2M3277a = bVarM3275a.m3277a();
        } else {
            format2M3277a = format2;
        }
        formatHolder.f7196b = format2M3277a;
        formatHolder.f7195a = this.f5604i;
        if (this.f5599d == null) {
            return;
        }
        if (z2 || !Util2.m2993a(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.f5604i;
            DrmSessionManager2 drmSessionManager22 = this.f5599d;
            Looper looper = this.f5601f;
            Objects.requireNonNull(looper);
            DrmSession drmSessionMo3599c = drmSessionManager22.mo3599c(looper, this.f5600e, format2);
            this.f5604i = drmSessionMo3599c;
            formatHolder.f7195a = drmSessionMo3599c;
            if (drmSession != null) {
                drmSession.mo3607b(this.f5600e);
            }
        }
    }

    @CallSuper
    /* renamed from: s */
    public void m2540s(boolean z2) {
        SampleDataQueue sampleDataQueue = this.f5596a;
        SampleDataQueue.a aVar = sampleDataQueue.f5581d;
        if (aVar.f5587c) {
            SampleDataQueue.a aVar2 = sampleDataQueue.f5583f;
            int i = (((int) (aVar2.f5585a - aVar.f5585a)) / sampleDataQueue.f5579b) + (aVar2.f5587c ? 1 : 0);
            Allocation[] allocationArr = new Allocation[i];
            int i2 = 0;
            while (i2 < i) {
                allocationArr[i2] = aVar.f5588d;
                aVar.f5588d = null;
                SampleDataQueue.a aVar3 = aVar.f5589e;
                aVar.f5589e = null;
                i2++;
                aVar = aVar3;
            }
            sampleDataQueue.f5578a.m2858a(allocationArr);
        }
        SampleDataQueue.a aVar4 = new SampleDataQueue.a(0L, sampleDataQueue.f5579b);
        sampleDataQueue.f5581d = aVar4;
        sampleDataQueue.f5582e = aVar4;
        sampleDataQueue.f5583f = aVar4;
        sampleDataQueue.f5584g = 0L;
        sampleDataQueue.f5578a.m2860c();
        this.f5612q = 0;
        this.f5613r = 0;
        this.f5614s = 0;
        this.f5615t = 0;
        this.f5620y = true;
        this.f5616u = Long.MIN_VALUE;
        this.f5617v = Long.MIN_VALUE;
        this.f5618w = Long.MIN_VALUE;
        this.f5619x = false;
        SpannedData<c> spannedData = this.f5598c;
        for (int i3 = 0; i3 < spannedData.f5649b.size(); i3++) {
            spannedData.f5650c.accept(spannedData.f5649b.valueAt(i3));
        }
        spannedData.f5648a = -1;
        spannedData.f5649b.clear();
        if (z2) {
            this.f5592A = null;
            this.f5593B = null;
            this.f5621z = true;
        }
    }

    /* renamed from: t */
    public final synchronized boolean m2541t(long j, boolean z2) {
        synchronized (this) {
            this.f5615t = 0;
            SampleDataQueue sampleDataQueue = this.f5596a;
            sampleDataQueue.f5582e = sampleDataQueue.f5581d;
        }
        int iM2533l = m2533l(0);
        if (m2536o() && j >= this.f5610o[iM2533l] && (j <= this.f5618w || z2)) {
            int iM2530i = m2530i(iM2533l, this.f5612q - this.f5615t, j, true);
            if (iM2530i == -1) {
                return false;
            }
            this.f5616u = j;
            this.f5615t += iM2530i;
            return true;
        }
        return false;
    }
}
