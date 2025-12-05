package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.CodecSpecificDataUtil;
import p007b.p225i.p226a.p242c.p259f3.NalUnitUtil;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.ParsableNalUnitBitArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* compiled from: H264Reader.java */
/* renamed from: b.i.a.c.x2.k0.r, reason: use source file name */
/* loaded from: classes3.dex */
public final class H264Reader implements ElementaryStreamReader {

    /* renamed from: a */
    public final SeiReader f8788a;

    /* renamed from: b */
    public final boolean f8789b;

    /* renamed from: c */
    public final boolean f8790c;

    /* renamed from: g */
    public long f8794g;

    /* renamed from: i */
    public String f8796i;

    /* renamed from: j */
    public TrackOutput2 f8797j;

    /* renamed from: k */
    public b f8798k;

    /* renamed from: l */
    public boolean f8799l;

    /* renamed from: n */
    public boolean f8801n;

    /* renamed from: h */
    public final boolean[] f8795h = new boolean[3];

    /* renamed from: d */
    public final NalUnitTargetBuffer f8791d = new NalUnitTargetBuffer(7, 128);

    /* renamed from: e */
    public final NalUnitTargetBuffer f8792e = new NalUnitTargetBuffer(8, 128);

    /* renamed from: f */
    public final NalUnitTargetBuffer f8793f = new NalUnitTargetBuffer(6, 128);

    /* renamed from: m */
    public long f8800m = -9223372036854775807L;

    /* renamed from: o */
    public final ParsableByteArray f8802o = new ParsableByteArray();

    /* compiled from: H264Reader.java */
    /* renamed from: b.i.a.c.x2.k0.r$b */
    public static final class b {

        /* renamed from: a */
        public final TrackOutput2 f8803a;

        /* renamed from: b */
        public final boolean f8804b;

        /* renamed from: c */
        public final boolean f8805c;

        /* renamed from: f */
        public final ParsableNalUnitBitArray f8808f;

        /* renamed from: g */
        public byte[] f8809g;

        /* renamed from: h */
        public int f8810h;

        /* renamed from: i */
        public int f8811i;

        /* renamed from: j */
        public long f8812j;

        /* renamed from: l */
        public long f8814l;

        /* renamed from: p */
        public long f8818p;

        /* renamed from: q */
        public long f8819q;

        /* renamed from: r */
        public boolean f8820r;

        /* renamed from: d */
        public final SparseArray<NalUnitUtil.c> f8806d = new SparseArray<>();

        /* renamed from: e */
        public final SparseArray<NalUnitUtil.b> f8807e = new SparseArray<>();

        /* renamed from: m */
        public a f8815m = new a(null);

        /* renamed from: n */
        public a f8816n = new a(null);

        /* renamed from: k */
        public boolean f8813k = false;

        /* renamed from: o */
        public boolean f8817o = false;

        /* compiled from: H264Reader.java */
        /* renamed from: b.i.a.c.x2.k0.r$b$a */
        public static final class a {

            /* renamed from: a */
            public boolean f8821a;

            /* renamed from: b */
            public boolean f8822b;

            /* renamed from: c */
            @Nullable
            public NalUnitUtil.c f8823c;

            /* renamed from: d */
            public int f8824d;

            /* renamed from: e */
            public int f8825e;

            /* renamed from: f */
            public int f8826f;

            /* renamed from: g */
            public int f8827g;

            /* renamed from: h */
            public boolean f8828h;

            /* renamed from: i */
            public boolean f8829i;

            /* renamed from: j */
            public boolean f8830j;

            /* renamed from: k */
            public boolean f8831k;

            /* renamed from: l */
            public int f8832l;

            /* renamed from: m */
            public int f8833m;

            /* renamed from: n */
            public int f8834n;

            /* renamed from: o */
            public int f8835o;

            /* renamed from: p */
            public int f8836p;

            public a(a aVar) {
            }
        }

        public b(TrackOutput2 trackOutput2, boolean z2, boolean z3) {
            this.f8803a = trackOutput2;
            this.f8804b = z2;
            this.f8805c = z3;
            byte[] bArr = new byte[128];
            this.f8809g = bArr;
            this.f8808f = new ParsableNalUnitBitArray(bArr, 0, 0);
            a aVar = this.f8816n;
            aVar.f8822b = false;
            aVar.f8821a = false;
        }
    }

    public H264Reader(SeiReader seiReader, boolean z2, boolean z3) {
        this.f8788a = seiReader;
        this.f8789b = z2;
        this.f8790c = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0171  */
    @RequiresNonNull({"sampleReader"})
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3783a(byte[] bArr, int i, int i2) {
        boolean zM3110d;
        boolean zM3110d2;
        boolean z2;
        boolean z3;
        int iM3112f;
        int i3;
        int iM3113g;
        int i4;
        int iM3111e;
        int iM3113g2;
        int i5;
        int iM3113g3;
        if (!this.f8799l || this.f8798k.f8805c) {
            this.f8791d.m3788a(bArr, i, i2);
            this.f8792e.m3788a(bArr, i, i2);
        }
        this.f8793f.m3788a(bArr, i, i2);
        b bVar = this.f8798k;
        if (bVar.f8813k) {
            int i6 = i2 - i;
            byte[] bArr2 = bVar.f8809g;
            int length = bArr2.length;
            int i7 = bVar.f8810h + i6;
            if (length < i7) {
                bVar.f8809g = Arrays.copyOf(bArr2, i7 * 2);
            }
            System.arraycopy(bArr, i, bVar.f8809g, bVar.f8810h, i6);
            int i8 = bVar.f8810h + i6;
            bVar.f8810h = i8;
            ParsableNalUnitBitArray parsableNalUnitBitArray = bVar.f8808f;
            parsableNalUnitBitArray.f6796a = bVar.f8809g;
            parsableNalUnitBitArray.f6798c = 0;
            parsableNalUnitBitArray.f6797b = i8;
            parsableNalUnitBitArray.f6799d = 0;
            parsableNalUnitBitArray.m3107a();
            if (bVar.f8808f.m3108b(8)) {
                bVar.f8808f.m3115i();
                int iM3111e2 = bVar.f8808f.m3111e(2);
                bVar.f8808f.m3116j(5);
                if (bVar.f8808f.m3109c()) {
                    bVar.f8808f.m3112f();
                    if (bVar.f8808f.m3109c()) {
                        int iM3112f2 = bVar.f8808f.m3112f();
                        if (!bVar.f8805c) {
                            bVar.f8813k = false;
                            b.a aVar = bVar.f8816n;
                            aVar.f8825e = iM3112f2;
                            aVar.f8822b = true;
                            return;
                        }
                        if (bVar.f8808f.m3109c()) {
                            int iM3112f3 = bVar.f8808f.m3112f();
                            if (bVar.f8807e.indexOfKey(iM3112f3) < 0) {
                                bVar.f8813k = false;
                                return;
                            }
                            NalUnitUtil.b bVar2 = bVar.f8807e.get(iM3112f3);
                            NalUnitUtil.c cVar = bVar.f8806d.get(bVar2.f6767b);
                            if (cVar.f6776h) {
                                if (!bVar.f8808f.m3108b(2)) {
                                    return;
                                } else {
                                    bVar.f8808f.m3116j(2);
                                }
                            }
                            if (bVar.f8808f.m3108b(cVar.f6778j)) {
                                int iM3111e3 = bVar.f8808f.m3111e(cVar.f6778j);
                                if (!cVar.f6777i) {
                                    if (bVar.f8808f.m3108b(1)) {
                                        zM3110d = bVar.f8808f.m3110d();
                                        if (zM3110d) {
                                            if (!bVar.f8808f.m3108b(1)) {
                                                return;
                                            }
                                            zM3110d2 = bVar.f8808f.m3110d();
                                            z2 = true;
                                        }
                                        z3 = bVar.f8811i != 5;
                                        if (z3) {
                                            iM3112f = 0;
                                        } else if (!bVar.f8808f.m3109c()) {
                                            return;
                                        } else {
                                            iM3112f = bVar.f8808f.m3112f();
                                        }
                                        i3 = cVar.f6779k;
                                        if (i3 == 0) {
                                            if (i3 != 1 || cVar.f6781m) {
                                                iM3113g = 0;
                                            } else {
                                                if (!bVar.f8808f.m3109c()) {
                                                    return;
                                                }
                                                iM3113g = bVar.f8808f.m3113g();
                                                if (bVar2.f6768c && !zM3110d) {
                                                    if (!bVar.f8808f.m3109c()) {
                                                        return;
                                                    }
                                                    iM3113g2 = bVar.f8808f.m3113g();
                                                    i5 = 0;
                                                    i4 = iM3113g;
                                                    iM3111e = 0;
                                                }
                                            }
                                            i4 = iM3113g;
                                            iM3111e = 0;
                                            iM3113g2 = 0;
                                            i5 = 0;
                                        } else {
                                            if (!bVar.f8808f.m3108b(cVar.f6780l)) {
                                                return;
                                            }
                                            iM3111e = bVar.f8808f.m3111e(cVar.f6780l);
                                            if (!bVar2.f6768c || zM3110d) {
                                                iM3113g3 = 0;
                                            } else if (!bVar.f8808f.m3109c()) {
                                                return;
                                            } else {
                                                iM3113g3 = bVar.f8808f.m3113g();
                                            }
                                            i5 = iM3113g3;
                                            iM3113g2 = 0;
                                            i4 = 0;
                                        }
                                        b.a aVar2 = bVar.f8816n;
                                        aVar2.f8823c = cVar;
                                        aVar2.f8824d = iM3111e2;
                                        aVar2.f8825e = iM3112f2;
                                        aVar2.f8826f = iM3111e3;
                                        aVar2.f8827g = iM3112f3;
                                        aVar2.f8828h = zM3110d;
                                        aVar2.f8829i = z2;
                                        aVar2.f8830j = zM3110d2;
                                        aVar2.f8831k = z3;
                                        aVar2.f8832l = iM3112f;
                                        aVar2.f8833m = iM3111e;
                                        aVar2.f8834n = i5;
                                        aVar2.f8835o = i4;
                                        aVar2.f8836p = iM3113g2;
                                        aVar2.f8821a = true;
                                        aVar2.f8822b = true;
                                        bVar.f8813k = false;
                                    }
                                    return;
                                }
                                zM3110d = false;
                                zM3110d2 = false;
                                z2 = false;
                                if (bVar.f8811i != 5) {
                                }
                                if (z3) {
                                }
                                i3 = cVar.f6779k;
                                if (i3 == 0) {
                                }
                                b.a aVar22 = bVar.f8816n;
                                aVar22.f8823c = cVar;
                                aVar22.f8824d = iM3111e2;
                                aVar22.f8825e = iM3112f2;
                                aVar22.f8826f = iM3111e3;
                                aVar22.f8827g = iM3112f3;
                                aVar22.f8828h = zM3110d;
                                aVar22.f8829i = z2;
                                aVar22.f8830j = zM3110d2;
                                aVar22.f8831k = z3;
                                aVar22.f8832l = iM3112f;
                                aVar22.f8833m = iM3111e;
                                aVar22.f8834n = i5;
                                aVar22.f8835o = i4;
                                aVar22.f8836p = iM3113g2;
                                aVar22.f8821a = true;
                                aVar22.f8822b = true;
                                bVar.f8813k = false;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01f3  */
    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo3758b(ParsableByteArray parsableByteArray) {
        int i;
        byte[] bArr;
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        int i6;
        boolean z3;
        AnimatableValueParser.m438H(this.f8797j);
        int i7 = Util2.f6708a;
        int i8 = parsableByteArray.f6794b;
        int i9 = parsableByteArray.f6795c;
        byte[] bArr2 = parsableByteArray.f6793a;
        this.f8794g += parsableByteArray.m3081a();
        this.f8797j.mo2524c(parsableByteArray, parsableByteArray.m3081a());
        while (true) {
            int iM3055b = NalUnitUtil.m3055b(bArr2, i8, i9, this.f8795h);
            if (iM3055b == i9) {
                m3783a(bArr2, i8, i9);
                return;
            }
            int i10 = iM3055b + 3;
            int i11 = bArr2[i10] & 31;
            int i12 = iM3055b - i8;
            if (i12 > 0) {
                m3783a(bArr2, i8, iM3055b);
            }
            int i13 = i9 - iM3055b;
            long j = this.f8794g - i13;
            int i14 = i12 < 0 ? -i12 : 0;
            long j2 = this.f8800m;
            if (!this.f8799l || this.f8798k.f8805c) {
                this.f8791d.m3789b(i14);
                this.f8792e.m3789b(i14);
                if (this.f8799l) {
                    i = i9;
                    bArr = bArr2;
                    NalUnitTargetBuffer nalUnitTargetBuffer = this.f8791d;
                    if (nalUnitTargetBuffer.f8905c) {
                        NalUnitUtil.c cVarM3058e = NalUnitUtil.m3058e(nalUnitTargetBuffer.f8906d, 3, nalUnitTargetBuffer.f8907e);
                        this.f8798k.f8806d.append(cVarM3058e.f6772d, cVarM3058e);
                        this.f8791d.m3790c();
                    } else {
                        NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f8792e;
                        if (nalUnitTargetBuffer2.f8905c) {
                            NalUnitUtil.b bVarM3057d = NalUnitUtil.m3057d(nalUnitTargetBuffer2.f8906d, 3, nalUnitTargetBuffer2.f8907e);
                            this.f8798k.f8807e.append(bVarM3057d.f6766a, bVarM3057d);
                            this.f8792e.m3790c();
                        }
                    }
                } else if (this.f8791d.f8905c && this.f8792e.f8905c) {
                    ArrayList arrayList = new ArrayList();
                    NalUnitTargetBuffer nalUnitTargetBuffer3 = this.f8791d;
                    arrayList.add(Arrays.copyOf(nalUnitTargetBuffer3.f8906d, nalUnitTargetBuffer3.f8907e));
                    NalUnitTargetBuffer nalUnitTargetBuffer4 = this.f8792e;
                    arrayList.add(Arrays.copyOf(nalUnitTargetBuffer4.f8906d, nalUnitTargetBuffer4.f8907e));
                    NalUnitTargetBuffer nalUnitTargetBuffer5 = this.f8791d;
                    NalUnitUtil.c cVarM3058e2 = NalUnitUtil.m3058e(nalUnitTargetBuffer5.f8906d, 3, nalUnitTargetBuffer5.f8907e);
                    NalUnitTargetBuffer nalUnitTargetBuffer6 = this.f8792e;
                    NalUnitUtil.b bVarM3057d2 = NalUnitUtil.m3057d(nalUnitTargetBuffer6.f8906d, 3, nalUnitTargetBuffer6.f8907e);
                    i = i9;
                    String strM3022a = CodecSpecificDataUtil.m3022a(cVarM3058e2.f6769a, cVarM3058e2.f6770b, cVarM3058e2.f6771c);
                    TrackOutput2 trackOutput2 = this.f8797j;
                    Format2.b bVar = new Format2.b();
                    bArr = bArr2;
                    bVar.f7163a = this.f8796i;
                    bVar.f7173k = "video/avc";
                    bVar.f7170h = strM3022a;
                    bVar.f7178p = cVarM3058e2.f6773e;
                    bVar.f7179q = cVarM3058e2.f6774f;
                    bVar.f7182t = cVarM3058e2.f6775g;
                    bVar.f7175m = arrayList;
                    trackOutput2.mo2526e(bVar.m3277a());
                    this.f8799l = true;
                    this.f8798k.f8806d.append(cVarM3058e2.f6772d, cVarM3058e2);
                    this.f8798k.f8807e.append(bVarM3057d2.f6766a, bVarM3057d2);
                    this.f8791d.m3790c();
                    this.f8792e.m3790c();
                } else {
                    i = i9;
                    bArr = bArr2;
                }
            }
            if (this.f8793f.m3789b(i14)) {
                NalUnitTargetBuffer nalUnitTargetBuffer7 = this.f8793f;
                this.f8802o.m3077C(this.f8793f.f8906d, NalUnitUtil.m3059f(nalUnitTargetBuffer7.f8906d, nalUnitTargetBuffer7.f8907e));
                this.f8802o.m3079E(4);
                AnimatableValueParser.m444J(j2, this.f8802o, this.f8788a.f8603b);
            }
            b bVar2 = this.f8798k;
            boolean z4 = this.f8799l;
            boolean z5 = this.f8801n;
            if (bVar2.f8811i == 9) {
                if (z4 && bVar2.f8817o) {
                    long j3 = bVar2.f8812j;
                    int i15 = i13 + ((int) (j - j3));
                    long j4 = bVar2.f8819q;
                    if (j4 != -9223372036854775807L) {
                        bVar2.f8803a.mo2525d(j4, bVar2.f8820r ? 1 : 0, (int) (j3 - bVar2.f8818p), i15, null);
                    }
                }
                bVar2.f8818p = bVar2.f8812j;
                bVar2.f8819q = bVar2.f8814l;
                bVar2.f8820r = false;
                bVar2.f8817o = true;
            } else if (bVar2.f8805c) {
                b.a aVar = bVar2.f8816n;
                b.a aVar2 = bVar2.f8815m;
                if (aVar.f8821a) {
                    if (aVar2.f8821a) {
                        NalUnitUtil.c cVar = aVar.f8823c;
                        AnimatableValueParser.m438H(cVar);
                        NalUnitUtil.c cVar2 = aVar2.f8823c;
                        AnimatableValueParser.m438H(cVar2);
                        if (aVar.f8826f == aVar2.f8826f && aVar.f8827g == aVar2.f8827g && aVar.f8828h == aVar2.f8828h && ((!aVar.f8829i || !aVar2.f8829i || aVar.f8830j == aVar2.f8830j) && (((i4 = aVar.f8824d) == (i5 = aVar2.f8824d) || (i4 != 0 && i5 != 0)) && (((i6 = cVar.f6779k) != 0 || cVar2.f6779k != 0 || (aVar.f8833m == aVar2.f8833m && aVar.f8834n == aVar2.f8834n)) && ((i6 != 1 || cVar2.f6779k != 1 || (aVar.f8835o == aVar2.f8835o && aVar.f8836p == aVar2.f8836p)) && (z3 = aVar.f8831k) == aVar2.f8831k && (!z3 || aVar.f8832l == aVar2.f8832l)))))) {
                            z2 = false;
                        }
                        if (z2) {
                        }
                    }
                    z2 = true;
                    if (z2) {
                    }
                }
            }
            if (bVar2.f8804b) {
                b.a aVar3 = bVar2.f8816n;
                z5 = aVar3.f8822b && ((i3 = aVar3.f8825e) == 7 || i3 == 2);
            }
            boolean z6 = bVar2.f8820r;
            int i16 = bVar2.f8811i;
            boolean z7 = z6 | (i16 == 5 || (z5 && i16 == 1));
            bVar2.f8820r = z7;
            if (z7) {
                this.f8801n = false;
            }
            long j5 = this.f8800m;
            if (!this.f8799l || this.f8798k.f8805c) {
                this.f8791d.m3791d(i11);
                this.f8792e.m3791d(i11);
            }
            this.f8793f.m3791d(i11);
            b bVar3 = this.f8798k;
            bVar3.f8811i = i11;
            bVar3.f8814l = j5;
            bVar3.f8812j = j;
            if (bVar3.f8804b) {
                i2 = 1;
                if (i11 == 1) {
                    b.a aVar4 = bVar3.f8815m;
                    bVar3.f8815m = bVar3.f8816n;
                    bVar3.f8816n = aVar4;
                    aVar4.f8822b = false;
                    aVar4.f8821a = false;
                    bVar3.f8810h = 0;
                    bVar3.f8813k = true;
                }
                i8 = i10;
                i9 = i;
                bArr2 = bArr;
            } else {
                i2 = 1;
            }
            if (!bVar3.f8805c || (i11 != 5 && i11 != i2 && i11 != 2)) {
            }
            i8 = i10;
            i9 = i;
            bArr2 = bArr;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: c */
    public void mo3759c() {
        this.f8794g = 0L;
        this.f8801n = false;
        this.f8800m = -9223372036854775807L;
        NalUnitUtil.m3054a(this.f8795h);
        this.f8791d.m3790c();
        this.f8792e.m3790c();
        this.f8793f.m3790c();
        b bVar = this.f8798k;
        if (bVar != null) {
            bVar.f8813k = false;
            bVar.f8817o = false;
            b.a aVar = bVar.f8816n;
            aVar.f8822b = false;
            aVar.f8821a = false;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: d */
    public void mo3760d() {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: e */
    public void mo3761e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.m3765a();
        this.f8796i = dVar.m3766b();
        TrackOutput2 trackOutput2Mo2492p = extractorOutput.mo2492p(dVar.m3767c(), 2);
        this.f8797j = trackOutput2Mo2492p;
        this.f8798k = new b(trackOutput2Mo2492p, this.f8789b, this.f8790c);
        this.f8788a.m3757a(extractorOutput, dVar);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* renamed from: f */
    public void mo3762f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f8800m = j;
        }
        this.f8801n |= (i & 2) != 0;
    }
}
