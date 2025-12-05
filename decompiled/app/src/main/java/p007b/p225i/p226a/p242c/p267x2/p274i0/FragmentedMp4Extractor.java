package p007b.p225i.p226a.p242c.p267x2.p274i0;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.NalUnitUtil;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.Ac4Util;
import p007b.p225i.p226a.p242c.p267x2.ChunkIndex;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.GaplessInfoHolder;
import p007b.p225i.p226a.p242c.p267x2.PositionHolder;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p274i0.Atom;
import p007b.p225i.p226a.p242c.p279z2.p281i.EventMessageEncoder;

/* compiled from: FragmentedMp4Extractor.java */
/* renamed from: b.i.a.c.x2.i0.g, reason: use source file name */
/* loaded from: classes3.dex */
public class FragmentedMp4Extractor implements Extractor {

    /* renamed from: a */
    public static final byte[] f8371a = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};

    /* renamed from: b */
    public static final Format2 f8372b;

    /* renamed from: A */
    public int f8373A;

    /* renamed from: B */
    public int f8374B;

    /* renamed from: C */
    public boolean f8375C;

    /* renamed from: D */
    public ExtractorOutput f8376D;

    /* renamed from: E */
    public TrackOutput2[] f8377E;

    /* renamed from: F */
    public TrackOutput2[] f8378F;

    /* renamed from: G */
    public boolean f8379G;

    /* renamed from: c */
    public final int f8380c;

    /* renamed from: d */
    public final List<Format2> f8381d;

    /* renamed from: e */
    public final SparseArray<b> f8382e;

    /* renamed from: f */
    public final ParsableByteArray f8383f;

    /* renamed from: g */
    public final ParsableByteArray f8384g;

    /* renamed from: h */
    public final ParsableByteArray f8385h;

    /* renamed from: i */
    public final byte[] f8386i;

    /* renamed from: j */
    public final ParsableByteArray f8387j;

    /* renamed from: k */
    public final EventMessageEncoder f8388k;

    /* renamed from: l */
    public final ParsableByteArray f8389l;

    /* renamed from: m */
    public final ArrayDeque<Atom.a> f8390m;

    /* renamed from: n */
    public final ArrayDeque<a> f8391n;

    /* renamed from: o */
    public int f8392o;

    /* renamed from: p */
    public int f8393p;

    /* renamed from: q */
    public long f8394q;

    /* renamed from: r */
    public int f8395r;

    /* renamed from: s */
    @Nullable
    public ParsableByteArray f8396s;

    /* renamed from: t */
    public long f8397t;

    /* renamed from: u */
    public int f8398u;

    /* renamed from: v */
    public long f8399v;

    /* renamed from: w */
    public long f8400w;

    /* renamed from: x */
    public long f8401x;

    /* renamed from: y */
    @Nullable
    public b f8402y;

    /* renamed from: z */
    public int f8403z;

    /* compiled from: FragmentedMp4Extractor.java */
    /* renamed from: b.i.a.c.x2.i0.g$a */
    public static final class a {

        /* renamed from: a */
        public final long f8404a;

        /* renamed from: b */
        public final int f8405b;

        public a(long j, int i) {
            this.f8404a = j;
            this.f8405b = i;
        }
    }

    /* compiled from: FragmentedMp4Extractor.java */
    /* renamed from: b.i.a.c.x2.i0.g$b */
    public static final class b {

        /* renamed from: a */
        public final TrackOutput2 f8406a;

        /* renamed from: d */
        public TrackSampleTable f8409d;

        /* renamed from: e */
        public DefaultSampleValues f8410e;

        /* renamed from: f */
        public int f8411f;

        /* renamed from: g */
        public int f8412g;

        /* renamed from: h */
        public int f8413h;

        /* renamed from: i */
        public int f8414i;

        /* renamed from: l */
        public boolean f8417l;

        /* renamed from: b */
        public final TrackFragment f8407b = new TrackFragment();

        /* renamed from: c */
        public final ParsableByteArray f8408c = new ParsableByteArray();

        /* renamed from: j */
        public final ParsableByteArray f8415j = new ParsableByteArray(1);

        /* renamed from: k */
        public final ParsableByteArray f8416k = new ParsableByteArray();

        public b(TrackOutput2 trackOutput2, TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues) {
            this.f8406a = trackOutput2;
            this.f8409d = trackSampleTable;
            this.f8410e = defaultSampleValues;
            this.f8409d = trackSampleTable;
            this.f8410e = defaultSampleValues;
            trackOutput2.mo2526e(trackSampleTable.f8493a.f8465f);
            m3720e();
        }

        /* renamed from: a */
        public long m3716a() {
            return !this.f8417l ? this.f8409d.f8495c[this.f8411f] : this.f8407b.f8481f[this.f8413h];
        }

        @Nullable
        /* renamed from: b */
        public TrackEncryptionBox m3717b() {
            if (!this.f8417l) {
                return null;
            }
            TrackFragment trackFragment = this.f8407b;
            DefaultSampleValues defaultSampleValues = trackFragment.f8476a;
            int i = Util2.f6708a;
            int i2 = defaultSampleValues.f8367a;
            TrackEncryptionBox trackEncryptionBoxM3731a = trackFragment.f8488m;
            if (trackEncryptionBoxM3731a == null) {
                trackEncryptionBoxM3731a = this.f8409d.f8493a.m3731a(i2);
            }
            if (trackEncryptionBoxM3731a == null || !trackEncryptionBoxM3731a.f8471a) {
                return null;
            }
            return trackEncryptionBoxM3731a;
        }

        /* renamed from: c */
        public boolean m3718c() {
            this.f8411f++;
            if (!this.f8417l) {
                return false;
            }
            int i = this.f8412g + 1;
            this.f8412g = i;
            int[] iArr = this.f8407b.f8482g;
            int i2 = this.f8413h;
            if (i != iArr[i2]) {
                return true;
            }
            this.f8413h = i2 + 1;
            this.f8412g = 0;
            return false;
        }

        /* renamed from: d */
        public int m3719d(int i, int i2) {
            ParsableByteArray parsableByteArray;
            TrackEncryptionBox trackEncryptionBoxM3717b = m3717b();
            if (trackEncryptionBoxM3717b == null) {
                return 0;
            }
            int length = trackEncryptionBoxM3717b.f8474d;
            if (length != 0) {
                parsableByteArray = this.f8407b.f8489n;
            } else {
                byte[] bArr = trackEncryptionBoxM3717b.f8475e;
                int i3 = Util2.f6708a;
                ParsableByteArray parsableByteArray2 = this.f8416k;
                int length2 = bArr.length;
                parsableByteArray2.f6793a = bArr;
                parsableByteArray2.f6795c = length2;
                parsableByteArray2.f6794b = 0;
                length = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            TrackFragment trackFragment = this.f8407b;
            boolean z2 = trackFragment.f8486k && trackFragment.f8487l[this.f8411f];
            boolean z3 = z2 || i2 != 0;
            ParsableByteArray parsableByteArray3 = this.f8415j;
            parsableByteArray3.f6793a[0] = (byte) ((z3 ? 128 : 0) | length);
            parsableByteArray3.m3079E(0);
            this.f8406a.mo2527f(this.f8415j, 1, 1);
            this.f8406a.mo2527f(parsableByteArray, length, 1);
            if (!z3) {
                return length + 1;
            }
            if (!z2) {
                this.f8408c.m3075A(8);
                ParsableByteArray parsableByteArray4 = this.f8408c;
                byte[] bArr2 = parsableByteArray4.f6793a;
                bArr2[0] = 0;
                bArr2[1] = 1;
                bArr2[2] = (byte) ((i2 >> 8) & 255);
                bArr2[3] = (byte) (i2 & 255);
                bArr2[4] = (byte) ((i >> 24) & 255);
                bArr2[5] = (byte) ((i >> 16) & 255);
                bArr2[6] = (byte) ((i >> 8) & 255);
                bArr2[7] = (byte) (i & 255);
                this.f8406a.mo2527f(parsableByteArray4, 8, 1);
                return length + 1 + 8;
            }
            ParsableByteArray parsableByteArray5 = this.f8407b.f8489n;
            int iM3105y = parsableByteArray5.m3105y();
            parsableByteArray5.m3080F(-2);
            int i4 = (iM3105y * 6) + 2;
            if (i2 != 0) {
                this.f8408c.m3075A(i4);
                byte[] bArr3 = this.f8408c.f6793a;
                parsableByteArray5.m3085e(bArr3, 0, i4);
                int i5 = (((bArr3[2] & 255) << 8) | (bArr3[3] & 255)) + i2;
                bArr3[2] = (byte) ((i5 >> 8) & 255);
                bArr3[3] = (byte) (i5 & 255);
                parsableByteArray5 = this.f8408c;
            }
            this.f8406a.mo2527f(parsableByteArray5, i4, 1);
            return length + 1 + i4;
        }

        /* renamed from: e */
        public void m3720e() {
            TrackFragment trackFragment = this.f8407b;
            trackFragment.f8479d = 0;
            trackFragment.f8491p = 0L;
            trackFragment.f8492q = false;
            trackFragment.f8486k = false;
            trackFragment.f8490o = false;
            trackFragment.f8488m = null;
            this.f8411f = 0;
            this.f8413h = 0;
            this.f8412g = 0;
            this.f8414i = 0;
            this.f8417l = false;
        }
    }

    static {
        Format2.b bVar = new Format2.b();
        bVar.f7173k = "application/x-emsg";
        f8372b = bVar.m3277a();
    }

    public FragmentedMp4Extractor(int i) {
        List listEmptyList = Collections.emptyList();
        this.f8380c = i;
        this.f8381d = Collections.unmodifiableList(listEmptyList);
        this.f8388k = new EventMessageEncoder();
        this.f8389l = new ParsableByteArray(16);
        this.f8383f = new ParsableByteArray(NalUnitUtil.f6753a);
        this.f8384g = new ParsableByteArray(5);
        this.f8385h = new ParsableByteArray();
        byte[] bArr = new byte[16];
        this.f8386i = bArr;
        this.f8387j = new ParsableByteArray(bArr);
        this.f8390m = new ArrayDeque<>();
        this.f8391n = new ArrayDeque<>();
        this.f8382e = new SparseArray<>();
        this.f8400w = -9223372036854775807L;
        this.f8399v = -9223372036854775807L;
        this.f8401x = -9223372036854775807L;
        this.f8376D = ExtractorOutput.f8501d;
        this.f8377E = new TrackOutput2[0];
        this.f8378F = new TrackOutput2[0];
    }

    /* renamed from: a */
    public static int m3710a(int i) throws ParserException {
        if (i >= 0) {
            return i;
        }
        throw outline.m884w0(38, "Unexpected negative value: ", i, null);
    }

    @Nullable
    /* renamed from: h */
    public static DrmInitData m3711h(List<Atom.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Atom.b bVar = list.get(i);
            if (bVar.f8349a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.f8353b.f6793a;
                PsshAtomUtil psshAtomUtilM581v1 = AnimatableValueParser.m581v1(bArr);
                UUID uuid = psshAtomUtilM581v1 == null ? null : psshAtomUtilM581v1.f8449a;
                if (uuid == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuid, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(null, false, (DrmInitData.SchemeData[]) arrayList.toArray(new DrmInitData.SchemeData[0]));
    }

    /* renamed from: i */
    public static void m3712i(ParsableByteArray parsableByteArray, int i, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.m3079E(i + 8);
        int iM3086f = parsableByteArray.m3086f() & ViewCompat.MEASURED_SIZE_MASK;
        if ((iM3086f & 1) != 0) {
            throw ParserException.m8756b("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z2 = (iM3086f & 2) != 0;
        int iM3103w = parsableByteArray.m3103w();
        if (iM3103w == 0) {
            Arrays.fill(trackFragment.f8487l, 0, trackFragment.f8480e, false);
            return;
        }
        int i2 = trackFragment.f8480e;
        if (iM3103w != i2) {
            throw ParserException.m8755a(outline.m853h(80, "Senc sample count ", iM3103w, " is different from fragment sample count", i2), null);
        }
        Arrays.fill(trackFragment.f8487l, 0, iM3103w, z2);
        int iM3081a = parsableByteArray.m3081a();
        ParsableByteArray parsableByteArray2 = trackFragment.f8489n;
        byte[] bArr = parsableByteArray2.f6793a;
        if (bArr.length < iM3081a) {
            bArr = new byte[iM3081a];
        }
        parsableByteArray2.f6793a = bArr;
        parsableByteArray2.f6795c = iM3081a;
        parsableByteArray2.f6794b = 0;
        trackFragment.f8486k = true;
        trackFragment.f8490o = true;
        parsableByteArray.m3085e(bArr, 0, iM3081a);
        trackFragment.f8489n.m3079E(0);
        trackFragment.f8490o = false;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: b */
    public boolean mo3633b(ExtractorInput extractorInput) throws IOException {
        return Sniffer2.m3730a(extractorInput, true, false);
    }

    /* renamed from: c */
    public final void m3713c() {
        this.f8392o = 0;
        this.f8395r = 0;
    }

    /* renamed from: d */
    public final DefaultSampleValues m3714d(SparseArray<DefaultSampleValues> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        DefaultSampleValues defaultSampleValues = sparseArray.get(i);
        Objects.requireNonNull(defaultSampleValues);
        return defaultSampleValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0236 A[LOOP:10: B:106:0x0236->B:108:0x023c, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x02cb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0759 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0762 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ca  */
    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int mo3635e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i;
        int iMo2523b;
        String strM3094n;
        String strM3094n2;
        long jM2985F;
        long j;
        long jM3101u;
        long jM3104x;
        long jM3104x2;
        long j2;
        boolean z2;
        while (true) {
            int i2 = this.f8392o;
            int i3 = 1;
            if (i2 != 0) {
                if (i2 == 1) {
                    int i4 = ((int) this.f8394q) - this.f8395r;
                    ParsableByteArray parsableByteArray = this.f8396s;
                    if (parsableByteArray != null) {
                        extractorInput.readFully(parsableByteArray.f6793a, 8, i4);
                        int i5 = this.f8393p;
                        Atom.b bVar = new Atom.b(i5, parsableByteArray);
                        long position = extractorInput.getPosition();
                        if (!this.f8390m.isEmpty()) {
                            this.f8390m.peek().f8351c.add(bVar);
                        } else if (i5 == 1936286840) {
                            parsableByteArray.m3079E(8);
                            int iM3086f = (parsableByteArray.m3086f() >> 24) & 255;
                            parsableByteArray.m3080F(4);
                            long jM3101u2 = parsableByteArray.m3101u();
                            if (iM3086f == 0) {
                                jM3104x = parsableByteArray.m3101u();
                                jM3104x2 = parsableByteArray.m3101u();
                            } else {
                                jM3104x = parsableByteArray.m3104x();
                                jM3104x2 = parsableByteArray.m3104x();
                            }
                            long j3 = position + jM3104x2;
                            long jM2985F2 = Util2.m2985F(jM3104x, 1000000L, jM3101u2);
                            parsableByteArray.m3080F(2);
                            int iM3105y = parsableByteArray.m3105y();
                            int[] iArr = new int[iM3105y];
                            long[] jArr = new long[iM3105y];
                            long[] jArr2 = new long[iM3105y];
                            long[] jArr3 = new long[iM3105y];
                            int i6 = 0;
                            long jM2985F3 = jM2985F2;
                            while (i6 < iM3105y) {
                                int iM3086f2 = parsableByteArray.m3086f();
                                if ((iM3086f2 & Integer.MIN_VALUE) != 0) {
                                    throw ParserException.m8755a("Unhandled indirect reference", null);
                                }
                                long jM3101u3 = parsableByteArray.m3101u();
                                iArr[i6] = iM3086f2 & Integer.MAX_VALUE;
                                jArr[i6] = j3;
                                jArr3[i6] = jM2985F3;
                                long j4 = jM3104x + jM3101u3;
                                int i7 = i6;
                                int i8 = iM3105y;
                                long[] jArr4 = jArr2;
                                long[] jArr5 = jArr3;
                                jM2985F3 = Util2.m2985F(j4, 1000000L, jM3101u2);
                                jArr4[i7] = jM2985F3 - jArr5[i7];
                                parsableByteArray.m3080F(4);
                                j3 += iArr[i7];
                                i6 = i7 + 1;
                                jArr2 = jArr4;
                                jArr3 = jArr5;
                                jArr = jArr;
                                jM3104x = j4;
                                iM3105y = i8;
                            }
                            Pair pairCreate = Pair.create(Long.valueOf(jM2985F2), new ChunkIndex(iArr, jArr, jArr2, jArr3));
                            this.f8401x = ((Long) pairCreate.first).longValue();
                            this.f8376D.mo2477a((SeekMap) pairCreate.second);
                            this.f8379G = true;
                        } else if (i5 == 1701671783 && this.f8377E.length != 0) {
                            parsableByteArray.m3079E(8);
                            int iM3086f3 = (parsableByteArray.m3086f() >> 24) & 255;
                            if (iM3086f3 == 0) {
                                strM3094n = parsableByteArray.m3094n();
                                Objects.requireNonNull(strM3094n);
                                strM3094n2 = parsableByteArray.m3094n();
                                Objects.requireNonNull(strM3094n2);
                                long jM3101u4 = parsableByteArray.m3101u();
                                long jM2985F4 = Util2.m2985F(parsableByteArray.m3101u(), 1000000L, jM3101u4);
                                long j5 = this.f8401x;
                                j = j5 != -9223372036854775807L ? j5 + jM2985F4 : -9223372036854775807L;
                                jM2985F = Util2.m2985F(parsableByteArray.m3101u(), 1000L, jM3101u4);
                                j = j;
                                j = jM2985F4;
                                jM3101u = parsableByteArray.m3101u();
                            } else if (iM3086f3 != 1) {
                                outline.m852g0(46, "Skipping unsupported emsg version: ", iM3086f3, "FragmentedMp4Extractor");
                            } else {
                                long jM3101u5 = parsableByteArray.m3101u();
                                long jM2985F5 = Util2.m2985F(parsableByteArray.m3104x(), 1000000L, jM3101u5);
                                jM2985F = Util2.m2985F(parsableByteArray.m3101u(), 1000L, jM3101u5);
                                jM3101u = parsableByteArray.m3101u();
                                strM3094n = parsableByteArray.m3094n();
                                Objects.requireNonNull(strM3094n);
                                strM3094n2 = parsableByteArray.m3094n();
                                Objects.requireNonNull(strM3094n2);
                                j = jM2985F5;
                            }
                            byte[] bArr = new byte[parsableByteArray.m3081a()];
                            int iM3081a = parsableByteArray.m3081a();
                            System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr, 0, iM3081a);
                            parsableByteArray.f6794b += iM3081a;
                            EventMessageEncoder eventMessageEncoder = this.f8388k;
                            eventMessageEncoder.f9148a.reset();
                            try {
                                DataOutputStream dataOutputStream = eventMessageEncoder.f9149b;
                                dataOutputStream.writeBytes(strM3094n);
                                dataOutputStream.writeByte(0);
                                DataOutputStream dataOutputStream2 = eventMessageEncoder.f9149b;
                                dataOutputStream2.writeBytes(strM3094n2);
                                dataOutputStream2.writeByte(0);
                                eventMessageEncoder.f9149b.writeLong(jM2985F);
                                eventMessageEncoder.f9149b.writeLong(jM3101u);
                                eventMessageEncoder.f9149b.write(bArr);
                                eventMessageEncoder.f9149b.flush();
                                ParsableByteArray parsableByteArray2 = new ParsableByteArray(eventMessageEncoder.f9148a.toByteArray());
                                int iM3081a2 = parsableByteArray2.m3081a();
                                for (TrackOutput2 trackOutput2 : this.f8377E) {
                                    parsableByteArray2.m3079E(0);
                                    trackOutput2.mo2524c(parsableByteArray2, iM3081a2);
                                }
                                if (j == -9223372036854775807L) {
                                    this.f8391n.addLast(new a(j, iM3081a2));
                                    this.f8398u += iM3081a2;
                                } else {
                                    for (TrackOutput2 trackOutput22 : this.f8377E) {
                                        trackOutput22.mo2525d(j, 1, iM3081a2, 0, null);
                                    }
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    } else {
                        extractorInput.mo3650l(i4);
                    }
                    m3715j(extractorInput.getPosition());
                } else if (i2 != 2) {
                    b bVar2 = this.f8402y;
                    if (bVar2 == null) {
                        SparseArray<b> sparseArray = this.f8382e;
                        int size = sparseArray.size();
                        long j6 = Long.MAX_VALUE;
                        b bVar3 = null;
                        for (int i9 = 0; i9 < size; i9++) {
                            b bVarValueAt = sparseArray.valueAt(i9);
                            boolean z3 = bVarValueAt.f8417l;
                            if ((z3 || bVarValueAt.f8411f != bVarValueAt.f8409d.f8494b) && (!z3 || bVarValueAt.f8413h != bVarValueAt.f8407b.f8479d)) {
                                long jM3716a = bVarValueAt.m3716a();
                                if (jM3716a < j6) {
                                    bVar3 = bVarValueAt;
                                    j6 = jM3716a;
                                }
                            }
                        }
                        if (bVar3 == null) {
                            int position2 = (int) (this.f8397t - extractorInput.getPosition());
                            if (position2 < 0) {
                                throw ParserException.m8755a("Offset to end of mdat was negative.", null);
                            }
                            extractorInput.mo3650l(position2);
                            m3713c();
                            i3 = 0;
                            if (i3 == 0) {
                                return 0;
                            }
                        } else {
                            int iM3716a = (int) (bVar3.m3716a() - extractorInput.getPosition());
                            if (iM3716a < 0) {
                                Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                                iM3716a = 0;
                            }
                            extractorInput.mo3650l(iM3716a);
                            this.f8402y = bVar3;
                            bVar2 = bVar3;
                            char c = 6;
                            if (this.f8392o != 3) {
                                TrackSampleTable trackSampleTable = bVar2.f8409d;
                                Track track = trackSampleTable.f8493a;
                                TrackOutput2 trackOutput23 = bVar2.f8406a;
                                long j7 = bVar2.f8417l ? trackSampleTable.f8498f[bVar2.f8411f] : bVar2.f8407b.f8484i[bVar2.f8411f];
                                i = track.f8469j;
                                if (i != 0) {
                                    while (true) {
                                        int i10 = this.f8373A;
                                        int i11 = this.f8403z;
                                        if (i10 >= i11) {
                                            break;
                                        }
                                        this.f8373A += trackOutput23.mo2523b(extractorInput, i11 - i10, false);
                                    }
                                } else {
                                    byte[] bArr2 = this.f8384g.f6793a;
                                    bArr2[0] = 0;
                                    bArr2[1] = 0;
                                    bArr2[2] = 0;
                                    int i12 = i + 1;
                                    int i13 = 4 - i;
                                    while (this.f8373A < this.f8403z) {
                                        int i14 = this.f8374B;
                                        if (i14 == 0) {
                                            extractorInput.readFully(bArr2, i13, i12);
                                            this.f8384g.m3079E(0);
                                            int iM3086f4 = this.f8384g.m3086f();
                                            if (iM3086f4 < i3) {
                                                throw ParserException.m8755a("Invalid NAL length", null);
                                            }
                                            this.f8374B = iM3086f4 - 1;
                                            this.f8383f.m3079E(0);
                                            trackOutput23.mo2524c(this.f8383f, 4);
                                            trackOutput23.mo2524c(this.f8384g, i3);
                                            if (this.f8378F.length > 0) {
                                                String str = track.f8465f.f7155w;
                                                byte b2 = bArr2[4];
                                                byte[] bArr3 = NalUnitUtil.f6753a;
                                                boolean z4 = ("video/avc".equals(str) && (b2 & 31) == c) || ("video/hevc".equals(str) && ((b2 & 126) >> i3) == 39);
                                                this.f8375C = z4;
                                                this.f8373A += 5;
                                                this.f8403z += i13;
                                            }
                                        } else {
                                            if (this.f8375C) {
                                                this.f8385h.m3075A(i14);
                                                extractorInput.readFully(this.f8385h.f6793a, 0, this.f8374B);
                                                trackOutput23.mo2524c(this.f8385h, this.f8374B);
                                                iMo2523b = this.f8374B;
                                                ParsableByteArray parsableByteArray3 = this.f8385h;
                                                int iM3059f = NalUnitUtil.m3059f(parsableByteArray3.f6793a, parsableByteArray3.f6795c);
                                                this.f8385h.m3079E("video/hevc".equals(track.f8465f.f7155w) ? 1 : 0);
                                                this.f8385h.m3078D(iM3059f);
                                                AnimatableValueParser.m444J(j7, this.f8385h, this.f8378F);
                                            } else {
                                                iMo2523b = trackOutput23.mo2523b(extractorInput, i14, false);
                                            }
                                            this.f8373A += iMo2523b;
                                            this.f8374B -= iMo2523b;
                                            c = 6;
                                            i3 = 1;
                                        }
                                    }
                                }
                                int i15 = bVar2.f8417l ? bVar2.f8409d.f8499g[bVar2.f8411f] : bVar2.f8407b.f8485j[bVar2.f8411f] ? 1 : 0;
                                if (bVar2.m3717b() != null) {
                                    i15 |= BasicMeasure.EXACTLY;
                                }
                                int i16 = i15;
                                TrackEncryptionBox trackEncryptionBoxM3717b = bVar2.m3717b();
                                trackOutput23.mo2525d(j7, i16, this.f8403z, 0, trackEncryptionBoxM3717b == null ? trackEncryptionBoxM3717b.f8473c : null);
                                while (!this.f8391n.isEmpty()) {
                                    a aVarRemoveFirst = this.f8391n.removeFirst();
                                    this.f8398u -= aVarRemoveFirst.f8405b;
                                    long j8 = aVarRemoveFirst.f8404a + j7;
                                    TrackOutput2[] trackOutput2Arr = this.f8377E;
                                    int i17 = 0;
                                    for (int length = trackOutput2Arr.length; i17 < length; length = length) {
                                        trackOutput2Arr[i17].mo2525d(j8, 1, aVarRemoveFirst.f8405b, this.f8398u, null);
                                        i17++;
                                    }
                                }
                                if (!bVar2.m3718c()) {
                                    this.f8402y = null;
                                }
                                this.f8392o = 3;
                                i3 = 1;
                                if (i3 == 0) {
                                }
                            } else {
                                int i18 = !bVar2.f8417l ? bVar2.f8409d.f8496d[bVar2.f8411f] : bVar2.f8407b.f8483h[bVar2.f8411f];
                                this.f8403z = i18;
                                if (bVar2.f8411f < bVar2.f8414i) {
                                    extractorInput.mo3650l(i18);
                                    TrackEncryptionBox trackEncryptionBoxM3717b2 = bVar2.m3717b();
                                    if (trackEncryptionBoxM3717b2 != null) {
                                        ParsableByteArray parsableByteArray4 = bVar2.f8407b.f8489n;
                                        int i19 = trackEncryptionBoxM3717b2.f8474d;
                                        if (i19 != 0) {
                                            parsableByteArray4.m3080F(i19);
                                        }
                                        TrackFragment trackFragment = bVar2.f8407b;
                                        if (trackFragment.f8486k && trackFragment.f8487l[bVar2.f8411f]) {
                                            parsableByteArray4.m3080F(parsableByteArray4.m3105y() * 6);
                                        }
                                    }
                                    if (!bVar2.m3718c()) {
                                        this.f8402y = null;
                                    }
                                    this.f8392o = 3;
                                    if (i3 == 0) {
                                    }
                                } else {
                                    if (bVar2.f8409d.f8493a.f8466g == 1) {
                                        this.f8403z = i18 - 8;
                                        extractorInput.mo3650l(8);
                                    }
                                    if ("audio/ac4".equals(bVar2.f8409d.f8493a.f8465f.f7155w)) {
                                        this.f8373A = bVar2.m3719d(this.f8403z, 7);
                                        Ac4Util.m3492a(this.f8403z, this.f8387j);
                                        bVar2.f8406a.mo2524c(this.f8387j, 7);
                                        this.f8373A += 7;
                                    } else {
                                        this.f8373A = bVar2.m3719d(this.f8403z, 0);
                                    }
                                    this.f8403z += this.f8373A;
                                    this.f8392o = 4;
                                    this.f8374B = 0;
                                    TrackSampleTable trackSampleTable2 = bVar2.f8409d;
                                    Track track2 = trackSampleTable2.f8493a;
                                    TrackOutput2 trackOutput232 = bVar2.f8406a;
                                    long j72 = bVar2.f8417l ? trackSampleTable2.f8498f[bVar2.f8411f] : bVar2.f8407b.f8484i[bVar2.f8411f];
                                    i = track2.f8469j;
                                    if (i != 0) {
                                    }
                                    if (bVar2.f8417l) {
                                    }
                                    if (bVar2.m3717b() != null) {
                                    }
                                    int i162 = i15;
                                    TrackEncryptionBox trackEncryptionBoxM3717b3 = bVar2.m3717b();
                                    trackOutput232.mo2525d(j72, i162, this.f8403z, 0, trackEncryptionBoxM3717b3 == null ? trackEncryptionBoxM3717b3.f8473c : null);
                                    while (!this.f8391n.isEmpty()) {
                                    }
                                    if (!bVar2.m3718c()) {
                                    }
                                    this.f8392o = 3;
                                    i3 = 1;
                                    if (i3 == 0) {
                                    }
                                }
                            }
                        }
                    } else {
                        char c2 = 6;
                        if (this.f8392o != 3) {
                        }
                    }
                } else {
                    int size2 = this.f8382e.size();
                    long j9 = Long.MAX_VALUE;
                    b bVarValueAt2 = null;
                    for (int i20 = 0; i20 < size2; i20++) {
                        TrackFragment trackFragment2 = this.f8382e.valueAt(i20).f8407b;
                        if (trackFragment2.f8490o) {
                            long j10 = trackFragment2.f8478c;
                            if (j10 < j9) {
                                bVarValueAt2 = this.f8382e.valueAt(i20);
                                j9 = j10;
                            }
                        }
                    }
                    if (bVarValueAt2 == null) {
                        this.f8392o = 3;
                    } else {
                        int position3 = (int) (j9 - extractorInput.getPosition());
                        if (position3 < 0) {
                            throw ParserException.m8755a("Offset to encryption data was negative.", null);
                        }
                        extractorInput.mo3650l(position3);
                        TrackFragment trackFragment3 = bVarValueAt2.f8407b;
                        ParsableByteArray parsableByteArray5 = trackFragment3.f8489n;
                        extractorInput.readFully(parsableByteArray5.f6793a, 0, parsableByteArray5.f6795c);
                        trackFragment3.f8489n.m3079E(0);
                        trackFragment3.f8490o = false;
                    }
                }
            } else if (this.f8395r != 0) {
                j2 = this.f8394q;
                if (j2 != 1) {
                    extractorInput.readFully(this.f8389l.f6793a, 8, 8);
                    this.f8395r += 8;
                    this.f8394q = this.f8389l.m3104x();
                } else if (j2 == 0) {
                    long jMo3642b = extractorInput.mo3642b();
                    if (jMo3642b == -1 && !this.f8390m.isEmpty()) {
                        jMo3642b = this.f8390m.peek().f8350b;
                    }
                    if (jMo3642b != -1) {
                        this.f8394q = (jMo3642b - extractorInput.getPosition()) + this.f8395r;
                    }
                }
                if (this.f8394q >= this.f8395r) {
                    throw ParserException.m8756b("Atom size less than header length (unsupported).");
                }
                long position4 = extractorInput.getPosition() - this.f8395r;
                int i21 = this.f8393p;
                if ((i21 == 1836019558 || i21 == 1835295092) && !this.f8379G) {
                    this.f8376D.mo2477a(new SeekMap.b(this.f8400w, position4));
                    this.f8379G = true;
                }
                if (this.f8393p == 1836019558) {
                    int size3 = this.f8382e.size();
                    for (int i22 = 0; i22 < size3; i22++) {
                        TrackFragment trackFragment4 = this.f8382e.valueAt(i22).f8407b;
                        Objects.requireNonNull(trackFragment4);
                        trackFragment4.f8478c = position4;
                        trackFragment4.f8477b = position4;
                    }
                }
                int i23 = this.f8393p;
                if (i23 == 1835295092) {
                    this.f8402y = null;
                    this.f8397t = position4 + this.f8394q;
                    this.f8392o = 2;
                } else if (i23 == 1836019574 || i23 == 1953653099 || i23 == 1835297121 || i23 == 1835626086 || i23 == 1937007212 || i23 == 1836019558 || i23 == 1953653094 || i23 == 1836475768 || i23 == 1701082227) {
                    long position5 = (extractorInput.getPosition() + this.f8394q) - 8;
                    this.f8390m.push(new Atom.a(this.f8393p, position5));
                    if (this.f8394q == this.f8395r) {
                        m3715j(position5);
                    } else {
                        m3713c();
                    }
                } else if (i23 == 1751411826 || i23 == 1835296868 || i23 == 1836476516 || i23 == 1936286840 || i23 == 1937011556 || i23 == 1937011827 || i23 == 1668576371 || i23 == 1937011555 || i23 == 1937011578 || i23 == 1937013298 || i23 == 1937007471 || i23 == 1668232756 || i23 == 1937011571 || i23 == 1952867444 || i23 == 1952868452 || i23 == 1953196132 || i23 == 1953654136 || i23 == 1953658222 || i23 == 1886614376 || i23 == 1935763834 || i23 == 1935763823 || i23 == 1936027235 || i23 == 1970628964 || i23 == 1935828848 || i23 == 1936158820 || i23 == 1701606260 || i23 == 1835362404 || i23 == 1701671783) {
                    if (this.f8395r != 8) {
                        throw ParserException.m8756b("Leaf atom defines extended atom size (unsupported).");
                    }
                    long j11 = this.f8394q;
                    if (j11 > 2147483647L) {
                        throw ParserException.m8756b("Leaf atom with length > 2147483647 (unsupported).");
                    }
                    ParsableByteArray parsableByteArray6 = new ParsableByteArray((int) j11);
                    System.arraycopy(this.f8389l.f6793a, 0, parsableByteArray6.f6793a, 0, 8);
                    this.f8396s = parsableByteArray6;
                    this.f8392o = 1;
                } else {
                    if (this.f8394q > 2147483647L) {
                        throw ParserException.m8756b("Skipping atom with length > 2147483647 (unsupported).");
                    }
                    this.f8396s = null;
                    this.f8392o = 1;
                }
                z2 = true;
                if (z2) {
                    return -1;
                }
            } else if (extractorInput.mo3643c(this.f8389l.f6793a, 0, 8, true)) {
                this.f8395r = 8;
                this.f8389l.m3079E(0);
                this.f8394q = this.f8389l.m3101u();
                this.f8393p = this.f8389l.m3086f();
                j2 = this.f8394q;
                if (j2 != 1) {
                }
                if (this.f8394q >= this.f8395r) {
                }
            } else {
                z2 = false;
                if (z2) {
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: f */
    public void mo3636f(ExtractorOutput extractorOutput) {
        int i;
        this.f8376D = extractorOutput;
        m3713c();
        TrackOutput2[] trackOutput2Arr = new TrackOutput2[2];
        this.f8377E = trackOutput2Arr;
        int i2 = 100;
        int i3 = 0;
        if ((this.f8380c & 4) != 0) {
            trackOutput2Arr[0] = this.f8376D.mo2492p(100, 5);
            i2 = 101;
            i = 1;
        } else {
            i = 0;
        }
        TrackOutput2[] trackOutput2Arr2 = (TrackOutput2[]) Util2.m2983D(this.f8377E, i);
        this.f8377E = trackOutput2Arr2;
        for (TrackOutput2 trackOutput2 : trackOutput2Arr2) {
            trackOutput2.mo2526e(f8372b);
        }
        this.f8378F = new TrackOutput2[this.f8381d.size()];
        while (i3 < this.f8378F.length) {
            TrackOutput2 trackOutput2Mo2492p = this.f8376D.mo2492p(i2, 3);
            trackOutput2Mo2492p.mo2526e(this.f8381d.get(i3));
            this.f8378F[i3] = trackOutput2Mo2492p;
            i3++;
            i2++;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: g */
    public void mo3637g(long j, long j2) {
        int size = this.f8382e.size();
        for (int i = 0; i < size; i++) {
            this.f8382e.valueAt(i).m3720e();
        }
        this.f8391n.clear();
        this.f8398u = 0;
        this.f8399v = j2;
        this.f8390m.clear();
        m3713c();
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0680  */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3715j(long j) throws ParserException {
        FragmentedMp4Extractor fragmentedMp4Extractor;
        byte[] bArr;
        SparseArray<b> sparseArray;
        Atom.a aVar;
        int i;
        int i2;
        int i3;
        int i4;
        byte[] bArr2;
        int i5;
        byte[] bArr3;
        int i6;
        Atom.a aVar2;
        int i7;
        List<Atom.b> list;
        int i8;
        Atom.a aVar3;
        TrackFragment trackFragment;
        int i9;
        int i10;
        long j2;
        int i11;
        int i12;
        boolean z2;
        int iM3086f;
        boolean z3;
        int iM3086f2;
        boolean z4;
        int iM3086f3;
        boolean z5;
        boolean z6;
        int iM3086f4;
        int i13;
        ParsableByteArray parsableByteArray;
        FragmentedMp4Extractor fragmentedMp4Extractor2 = this;
        FragmentedMp4Extractor fragmentedMp4Extractor3 = fragmentedMp4Extractor2;
        while (!fragmentedMp4Extractor3.f8390m.isEmpty() && fragmentedMp4Extractor3.f8390m.peek().f8350b == j) {
            Atom.a aVarPop = fragmentedMp4Extractor3.f8390m.pop();
            int i14 = aVarPop.f8349a;
            int i15 = 12;
            if (i14 == 1836019574) {
                AnimatableValueParser.m429E(true, "Unexpected moov box.");
                DrmInitData drmInitDataM3711h = m3711h(aVarPop.f8351c);
                Atom.a aVarM3700b = aVarPop.m3700b(1836475768);
                Objects.requireNonNull(aVarM3700b);
                SparseArray<DefaultSampleValues> sparseArray2 = new SparseArray<>();
                int size = aVarM3700b.f8351c.size();
                long jM3101u = -9223372036854775807L;
                int i16 = 0;
                while (i16 < size) {
                    Atom.b bVar = aVarM3700b.f8351c.get(i16);
                    int i17 = bVar.f8349a;
                    if (i17 == 1953654136) {
                        ParsableByteArray parsableByteArray2 = bVar.f8353b;
                        parsableByteArray2.m3079E(i15);
                        Pair pairCreate = Pair.create(Integer.valueOf(parsableByteArray2.m3086f()), new DefaultSampleValues(parsableByteArray2.m3086f() - 1, parsableByteArray2.m3086f(), parsableByteArray2.m3086f(), parsableByteArray2.m3086f()));
                        sparseArray2.put(((Integer) pairCreate.first).intValue(), (DefaultSampleValues) pairCreate.second);
                    } else {
                        if (i17 == 1835362404) {
                            ParsableByteArray parsableByteArray3 = bVar.f8353b;
                            parsableByteArray3.m3079E(8);
                            jM3101u = ((parsableByteArray3.m3086f() >> 24) & 255) == 0 ? parsableByteArray3.m3101u() : parsableByteArray3.m3104x();
                        }
                        i16++;
                        i15 = 12;
                    }
                    i16++;
                    i15 = 12;
                }
                ArrayList arrayList = (ArrayList) AtomParsers.m3706e(aVarPop, new GaplessInfoHolder(), jM3101u, drmInitDataM3711h, (fragmentedMp4Extractor3.f8380c & 16) != 0, false, new C3044c(fragmentedMp4Extractor3));
                int size2 = arrayList.size();
                if (fragmentedMp4Extractor3.f8382e.size() == 0) {
                    for (int i18 = 0; i18 < size2; i18++) {
                        TrackSampleTable trackSampleTable = (TrackSampleTable) arrayList.get(i18);
                        Track track = trackSampleTable.f8493a;
                        fragmentedMp4Extractor3.f8382e.put(track.f8460a, new b(fragmentedMp4Extractor3.f8376D.mo2492p(i18, track.f8461b), trackSampleTable, fragmentedMp4Extractor3.m3714d(sparseArray2, track.f8460a)));
                        fragmentedMp4Extractor3.f8400w = Math.max(fragmentedMp4Extractor3.f8400w, track.f8464e);
                    }
                    fragmentedMp4Extractor3.f8376D.mo2486j();
                } else {
                    AnimatableValueParser.m426D(fragmentedMp4Extractor3.f8382e.size() == size2);
                    for (int i19 = 0; i19 < size2; i19++) {
                        TrackSampleTable trackSampleTable2 = (TrackSampleTable) arrayList.get(i19);
                        Track track2 = trackSampleTable2.f8493a;
                        b bVar2 = fragmentedMp4Extractor3.f8382e.get(track2.f8460a);
                        DefaultSampleValues defaultSampleValuesM3714d = fragmentedMp4Extractor3.m3714d(sparseArray2, track2.f8460a);
                        bVar2.f8409d = trackSampleTable2;
                        bVar2.f8410e = defaultSampleValuesM3714d;
                        bVar2.f8406a.mo2526e(trackSampleTable2.f8493a.f8465f);
                        bVar2.m3720e();
                    }
                }
                fragmentedMp4Extractor = fragmentedMp4Extractor2;
            } else {
                int i20 = 8;
                if (i14 == 1836019558) {
                    SparseArray<b> sparseArray3 = fragmentedMp4Extractor3.f8382e;
                    int i21 = fragmentedMp4Extractor3.f8380c;
                    byte[] bArr4 = fragmentedMp4Extractor3.f8386i;
                    int size3 = aVarPop.f8352d.size();
                    int i22 = 0;
                    while (i22 < size3) {
                        Atom.a aVar4 = aVarPop.f8352d.get(i22);
                        if (aVar4.f8349a == 1953653094) {
                            Atom.b bVarM3701c = aVar4.m3701c(1952868452);
                            Objects.requireNonNull(bVarM3701c);
                            ParsableByteArray parsableByteArray4 = bVarM3701c.f8353b;
                            parsableByteArray4.m3079E(i20);
                            int iM3086f5 = parsableByteArray4.m3086f() & ViewCompat.MEASURED_SIZE_MASK;
                            b bVar3 = sparseArray3.get(parsableByteArray4.m3086f());
                            if (bVar3 == null) {
                                bVar3 = null;
                            } else {
                                if ((iM3086f5 & 1) != 0) {
                                    long jM3104x = parsableByteArray4.m3104x();
                                    TrackFragment trackFragment2 = bVar3.f8407b;
                                    trackFragment2.f8477b = jM3104x;
                                    trackFragment2.f8478c = jM3104x;
                                }
                                DefaultSampleValues defaultSampleValues = bVar3.f8410e;
                                bVar3.f8407b.f8476a = new DefaultSampleValues((iM3086f5 & 2) != 0 ? parsableByteArray4.m3086f() - 1 : defaultSampleValues.f8367a, (iM3086f5 & 8) != 0 ? parsableByteArray4.m3086f() : defaultSampleValues.f8368b, (iM3086f5 & 16) != 0 ? parsableByteArray4.m3086f() : defaultSampleValues.f8369c, (iM3086f5 & 32) != 0 ? parsableByteArray4.m3086f() : defaultSampleValues.f8370d);
                            }
                            if (bVar3 == null) {
                                bArr = bArr4;
                                sparseArray = sparseArray3;
                                aVar = aVarPop;
                                i = i21;
                                i2 = size3;
                                i3 = i22;
                            } else {
                                TrackFragment trackFragment3 = bVar3.f8407b;
                                long j3 = trackFragment3.f8491p;
                                boolean z7 = trackFragment3.f8492q;
                                bVar3.m3720e();
                                bVar3.f8417l = true;
                                Atom.b bVarM3701c2 = aVar4.m3701c(1952867444);
                                if (bVarM3701c2 == null || (i21 & 2) != 0) {
                                    trackFragment3.f8491p = j3;
                                    trackFragment3.f8492q = z7;
                                } else {
                                    ParsableByteArray parsableByteArray5 = bVarM3701c2.f8353b;
                                    parsableByteArray5.m3079E(i20);
                                    trackFragment3.f8491p = ((parsableByteArray5.m3086f() >> 24) & 255) == 1 ? parsableByteArray5.m3104x() : parsableByteArray5.m3101u();
                                    trackFragment3.f8492q = true;
                                }
                                List<Atom.b> list2 = aVar4.f8351c;
                                int size4 = list2.size();
                                int i23 = 0;
                                int i24 = 0;
                                int i25 = 0;
                                while (true) {
                                    i4 = 1953658222;
                                    if (i23 >= size4) {
                                        break;
                                    }
                                    SparseArray<b> sparseArray4 = sparseArray3;
                                    Atom.b bVar4 = list2.get(i23);
                                    int i26 = size3;
                                    if (bVar4.f8349a == 1953658222) {
                                        ParsableByteArray parsableByteArray6 = bVar4.f8353b;
                                        parsableByteArray6.m3079E(12);
                                        int iM3103w = parsableByteArray6.m3103w();
                                        if (iM3103w > 0) {
                                            i25 += iM3103w;
                                            i24++;
                                        }
                                    }
                                    i23++;
                                    size3 = i26;
                                    sparseArray3 = sparseArray4;
                                }
                                sparseArray = sparseArray3;
                                i2 = size3;
                                bVar3.f8413h = 0;
                                bVar3.f8412g = 0;
                                bVar3.f8411f = 0;
                                TrackFragment trackFragment4 = bVar3.f8407b;
                                trackFragment4.f8479d = i24;
                                trackFragment4.f8480e = i25;
                                if (trackFragment4.f8482g.length < i24) {
                                    trackFragment4.f8481f = new long[i24];
                                    trackFragment4.f8482g = new int[i24];
                                }
                                if (trackFragment4.f8483h.length < i25) {
                                    int i27 = (i25 * Opcodes.LUSHR) / 100;
                                    trackFragment4.f8483h = new int[i27];
                                    trackFragment4.f8484i = new long[i27];
                                    trackFragment4.f8485j = new boolean[i27];
                                    trackFragment4.f8487l = new boolean[i27];
                                }
                                int i28 = 0;
                                int i29 = 0;
                                int i30 = 0;
                                while (i28 < size4) {
                                    Atom.b bVar5 = list2.get(i28);
                                    if (bVar5.f8349a == i4) {
                                        int i31 = i30 + 1;
                                        ParsableByteArray parsableByteArray7 = bVar5.f8353b;
                                        parsableByteArray7.m3079E(8);
                                        int iM3086f6 = parsableByteArray7.m3086f() & ViewCompat.MEASURED_SIZE_MASK;
                                        list = list2;
                                        Track track3 = bVar3.f8409d.f8493a;
                                        i9 = size4;
                                        TrackFragment trackFragment5 = bVar3.f8407b;
                                        DefaultSampleValues defaultSampleValues2 = trackFragment5.f8476a;
                                        int i32 = Util2.f6708a;
                                        trackFragment5.f8482g[i30] = parsableByteArray7.m3103w();
                                        long[] jArr = trackFragment5.f8481f;
                                        i8 = i22;
                                        aVar3 = aVar4;
                                        jArr[i30] = trackFragment5.f8477b;
                                        if ((iM3086f6 & 1) != 0) {
                                            aVar2 = aVarPop;
                                            bArr3 = bArr4;
                                            i6 = i28;
                                            jArr[i30] = jArr[i30] + parsableByteArray7.m3086f();
                                        } else {
                                            bArr3 = bArr4;
                                            i6 = i28;
                                            aVar2 = aVarPop;
                                        }
                                        boolean z8 = (iM3086f6 & 4) != 0;
                                        int iM3086f7 = defaultSampleValues2.f8370d;
                                        if (z8) {
                                            iM3086f7 = parsableByteArray7.m3086f();
                                        }
                                        boolean z9 = (iM3086f6 & 256) != 0;
                                        boolean z10 = (iM3086f6 & 512) != 0;
                                        boolean z11 = (iM3086f6 & 1024) != 0;
                                        boolean z12 = (iM3086f6 & 2048) != 0;
                                        long[] jArr2 = track3.f8467h;
                                        if (jArr2 != null) {
                                            i10 = iM3086f7;
                                            trackFragment = trackFragment3;
                                            if (jArr2.length == 1 && jArr2[0] == 0) {
                                                j2 = track3.f8468i[0];
                                            }
                                            int[] iArr = trackFragment5.f8483h;
                                            long[] jArr3 = trackFragment5.f8484i;
                                            boolean[] zArr = trackFragment5.f8485j;
                                            boolean z13 = (track3.f8461b == 2 || (i21 & 1) == 0) ? false : true;
                                            i11 = trackFragment5.f8482g[i30] + i29;
                                            i7 = i21;
                                            long j4 = track3.f8462c;
                                            long j5 = trackFragment5.f8491p;
                                            i12 = i29;
                                            while (i12 < i11) {
                                                if (z9) {
                                                    z2 = z9;
                                                    iM3086f = parsableByteArray7.m3086f();
                                                } else {
                                                    z2 = z9;
                                                    iM3086f = defaultSampleValues2.f8368b;
                                                }
                                                m3710a(iM3086f);
                                                if (z10) {
                                                    z3 = z10;
                                                    iM3086f2 = parsableByteArray7.m3086f();
                                                } else {
                                                    z3 = z10;
                                                    iM3086f2 = defaultSampleValues2.f8369c;
                                                }
                                                m3710a(iM3086f2);
                                                if (z11) {
                                                    z4 = z8;
                                                    iM3086f3 = parsableByteArray7.m3086f();
                                                } else if (i12 == 0 && z8) {
                                                    z4 = z8;
                                                    iM3086f3 = i10;
                                                } else {
                                                    z4 = z8;
                                                    iM3086f3 = defaultSampleValues2.f8370d;
                                                }
                                                if (z12) {
                                                    z5 = z11;
                                                    z6 = z12;
                                                    iM3086f4 = parsableByteArray7.m3086f();
                                                } else {
                                                    z5 = z11;
                                                    z6 = z12;
                                                    iM3086f4 = 0;
                                                }
                                                jArr3[i12] = Util2.m2985F((iM3086f4 + j5) - j2, 1000000L, j4);
                                                if (trackFragment5.f8492q) {
                                                    i13 = i11;
                                                    parsableByteArray = parsableByteArray7;
                                                } else {
                                                    i13 = i11;
                                                    parsableByteArray = parsableByteArray7;
                                                    jArr3[i12] = jArr3[i12] + bVar3.f8409d.f8500h;
                                                }
                                                iArr[i12] = iM3086f2;
                                                zArr[i12] = ((iM3086f3 >> 16) & 1) == 0 && (!z13 || i12 == 0);
                                                j5 += iM3086f;
                                                i12++;
                                                i11 = i13;
                                                parsableByteArray7 = parsableByteArray;
                                                z9 = z2;
                                                z10 = z3;
                                                z8 = z4;
                                                z11 = z5;
                                                z12 = z6;
                                            }
                                            int i33 = i11;
                                            trackFragment5.f8491p = j5;
                                            i30 = i31;
                                            i29 = i33;
                                        } else {
                                            i10 = iM3086f7;
                                            trackFragment = trackFragment3;
                                        }
                                        j2 = 0;
                                        int[] iArr2 = trackFragment5.f8483h;
                                        long[] jArr32 = trackFragment5.f8484i;
                                        boolean[] zArr2 = trackFragment5.f8485j;
                                        if (track3.f8461b == 2) {
                                            i11 = trackFragment5.f8482g[i30] + i29;
                                            i7 = i21;
                                            long j42 = track3.f8462c;
                                            long j52 = trackFragment5.f8491p;
                                            i12 = i29;
                                            while (i12 < i11) {
                                            }
                                            int i332 = i11;
                                            trackFragment5.f8491p = j52;
                                            i30 = i31;
                                            i29 = i332;
                                        }
                                    } else {
                                        bArr3 = bArr4;
                                        i6 = i28;
                                        aVar2 = aVarPop;
                                        i7 = i21;
                                        list = list2;
                                        i8 = i22;
                                        aVar3 = aVar4;
                                        trackFragment = trackFragment3;
                                        i9 = size4;
                                    }
                                    i28 = i6 + 1;
                                    i21 = i7;
                                    list2 = list;
                                    size4 = i9;
                                    i22 = i8;
                                    aVar4 = aVar3;
                                    aVarPop = aVar2;
                                    bArr4 = bArr3;
                                    trackFragment3 = trackFragment;
                                    i4 = 1953658222;
                                }
                                byte[] bArr5 = bArr4;
                                aVar = aVarPop;
                                i = i21;
                                i3 = i22;
                                TrackFragment trackFragment6 = trackFragment3;
                                Track track4 = bVar3.f8409d.f8493a;
                                DefaultSampleValues defaultSampleValues3 = trackFragment6.f8476a;
                                Objects.requireNonNull(defaultSampleValues3);
                                TrackEncryptionBox trackEncryptionBoxM3731a = track4.m3731a(defaultSampleValues3.f8367a);
                                Atom.b bVarM3701c3 = aVar4.m3701c(1935763834);
                                if (bVarM3701c3 != null) {
                                    Objects.requireNonNull(trackEncryptionBoxM3731a);
                                    ParsableByteArray parsableByteArray8 = bVarM3701c3.f8353b;
                                    int i34 = trackEncryptionBoxM3731a.f8474d;
                                    parsableByteArray8.m3079E(8);
                                    if ((parsableByteArray8.m3086f() & ViewCompat.MEASURED_SIZE_MASK & 1) == 1) {
                                        parsableByteArray8.m3080F(8);
                                    }
                                    int iM3100t = parsableByteArray8.m3100t();
                                    int iM3103w2 = parsableByteArray8.m3103w();
                                    int i35 = trackFragment6.f8480e;
                                    if (iM3103w2 > i35) {
                                        throw ParserException.m8755a(outline.m853h(78, "Saiz sample count ", iM3103w2, " is greater than fragment sample count", i35), null);
                                    }
                                    if (iM3100t == 0) {
                                        boolean[] zArr3 = trackFragment6.f8487l;
                                        i5 = 0;
                                        for (int i36 = 0; i36 < iM3103w2; i36++) {
                                            int iM3100t2 = parsableByteArray8.m3100t();
                                            i5 += iM3100t2;
                                            zArr3[i36] = iM3100t2 > i34;
                                        }
                                    } else {
                                        i5 = (iM3100t * iM3103w2) + 0;
                                        Arrays.fill(trackFragment6.f8487l, 0, iM3103w2, iM3100t > i34);
                                    }
                                    Arrays.fill(trackFragment6.f8487l, iM3103w2, trackFragment6.f8480e, false);
                                    if (i5 > 0) {
                                        ParsableByteArray parsableByteArray9 = trackFragment6.f8489n;
                                        byte[] bArr6 = parsableByteArray9.f6793a;
                                        if (bArr6.length < i5) {
                                            bArr6 = new byte[i5];
                                        }
                                        parsableByteArray9.m3077C(bArr6, i5);
                                        trackFragment6.f8486k = true;
                                        trackFragment6.f8490o = true;
                                    }
                                }
                                Atom.b bVarM3701c4 = aVar4.m3701c(1935763823);
                                if (bVarM3701c4 != null) {
                                    ParsableByteArray parsableByteArray10 = bVarM3701c4.f8353b;
                                    parsableByteArray10.m3079E(8);
                                    int iM3086f8 = parsableByteArray10.m3086f();
                                    if ((16777215 & iM3086f8 & 1) == 1) {
                                        parsableByteArray10.m3080F(8);
                                    }
                                    int iM3103w3 = parsableByteArray10.m3103w();
                                    if (iM3103w3 != 1) {
                                        throw outline.m884w0(40, "Unexpected saio entry count: ", iM3103w3, null);
                                    }
                                    trackFragment6.f8478c += ((iM3086f8 >> 24) & 255) == 0 ? parsableByteArray10.m3101u() : parsableByteArray10.m3104x();
                                }
                                byte[] bArr7 = null;
                                Atom.b bVarM3701c5 = aVar4.m3701c(1936027235);
                                if (bVarM3701c5 != null) {
                                    m3712i(bVarM3701c5.f8353b, 0, trackFragment6);
                                }
                                String str = trackEncryptionBoxM3731a != null ? trackEncryptionBoxM3731a.f8472b : null;
                                ParsableByteArray parsableByteArray11 = null;
                                ParsableByteArray parsableByteArray12 = null;
                                for (int i37 = 0; i37 < aVar4.f8351c.size(); i37++) {
                                    Atom.b bVar6 = aVar4.f8351c.get(i37);
                                    ParsableByteArray parsableByteArray13 = bVar6.f8353b;
                                    int i38 = bVar6.f8349a;
                                    if (i38 == 1935828848) {
                                        parsableByteArray13.m3079E(12);
                                        if (parsableByteArray13.m3086f() == 1936025959) {
                                            parsableByteArray11 = parsableByteArray13;
                                        }
                                    } else if (i38 == 1936158820) {
                                        parsableByteArray13.m3079E(12);
                                        if (parsableByteArray13.m3086f() == 1936025959) {
                                            parsableByteArray12 = parsableByteArray13;
                                        }
                                    }
                                }
                                if (parsableByteArray11 != null && parsableByteArray12 != null) {
                                    parsableByteArray11.m3079E(8);
                                    int iM3086f9 = (parsableByteArray11.m3086f() >> 24) & 255;
                                    parsableByteArray11.m3080F(4);
                                    if (iM3086f9 == 1) {
                                        parsableByteArray11.m3080F(4);
                                    }
                                    if (parsableByteArray11.m3086f() != 1) {
                                        throw ParserException.m8756b("Entry count in sbgp != 1 (unsupported).");
                                    }
                                    parsableByteArray12.m3079E(8);
                                    int iM3086f10 = (parsableByteArray12.m3086f() >> 24) & 255;
                                    parsableByteArray12.m3080F(4);
                                    if (iM3086f10 == 1) {
                                        if (parsableByteArray12.m3101u() == 0) {
                                            throw ParserException.m8756b("Variable length description in sgpd found (unsupported)");
                                        }
                                    } else if (iM3086f10 >= 2) {
                                        parsableByteArray12.m3080F(4);
                                    }
                                    if (parsableByteArray12.m3101u() != 1) {
                                        throw ParserException.m8756b("Entry count in sgpd != 1 (unsupported).");
                                    }
                                    parsableByteArray12.m3080F(1);
                                    int iM3100t3 = parsableByteArray12.m3100t();
                                    int i39 = (iM3100t3 & 240) >> 4;
                                    int i40 = iM3100t3 & 15;
                                    boolean z14 = parsableByteArray12.m3100t() == 1;
                                    if (z14) {
                                        int iM3100t4 = parsableByteArray12.m3100t();
                                        byte[] bArr8 = new byte[16];
                                        System.arraycopy(parsableByteArray12.f6793a, parsableByteArray12.f6794b, bArr8, 0, 16);
                                        parsableByteArray12.f6794b += 16;
                                        if (iM3100t4 == 0) {
                                            int iM3100t5 = parsableByteArray12.m3100t();
                                            bArr7 = new byte[iM3100t5];
                                            System.arraycopy(parsableByteArray12.f6793a, parsableByteArray12.f6794b, bArr7, 0, iM3100t5);
                                            parsableByteArray12.f6794b += iM3100t5;
                                        }
                                        trackFragment6.f8486k = true;
                                        trackFragment6.f8488m = new TrackEncryptionBox(z14, str, iM3100t4, bArr8, i39, i40, bArr7);
                                    }
                                }
                                int size5 = aVar4.f8351c.size();
                                int i41 = 0;
                                while (i41 < size5) {
                                    Atom.b bVar7 = aVar4.f8351c.get(i41);
                                    if (bVar7.f8349a == 1970628964) {
                                        ParsableByteArray parsableByteArray14 = bVar7.f8353b;
                                        parsableByteArray14.m3079E(8);
                                        bArr2 = bArr5;
                                        System.arraycopy(parsableByteArray14.f6793a, parsableByteArray14.f6794b, bArr2, 0, 16);
                                        parsableByteArray14.f6794b += 16;
                                        if (Arrays.equals(bArr2, f8371a)) {
                                            m3712i(parsableByteArray14, 16, trackFragment6);
                                        }
                                    } else {
                                        bArr2 = bArr5;
                                    }
                                    i41++;
                                    bArr5 = bArr2;
                                }
                                bArr = bArr5;
                            }
                        }
                        i22 = i3 + 1;
                        i20 = 8;
                        bArr4 = bArr;
                        i21 = i;
                        size3 = i2;
                        sparseArray3 = sparseArray;
                        aVarPop = aVar;
                    }
                    DrmInitData drmInitDataM3711h2 = m3711h(aVarPop.f8351c);
                    fragmentedMp4Extractor = this;
                    if (drmInitDataM3711h2 != null) {
                        int size6 = fragmentedMp4Extractor.f8382e.size();
                        for (int i42 = 0; i42 < size6; i42++) {
                            b bVarValueAt = fragmentedMp4Extractor.f8382e.valueAt(i42);
                            Track track5 = bVarValueAt.f8409d.f8493a;
                            DefaultSampleValues defaultSampleValues4 = bVarValueAt.f8407b.f8476a;
                            int i43 = Util2.f6708a;
                            TrackEncryptionBox trackEncryptionBoxM3731a2 = track5.m3731a(defaultSampleValues4.f8367a);
                            DrmInitData drmInitDataM8835a = drmInitDataM3711h2.m8835a(trackEncryptionBoxM3731a2 != null ? trackEncryptionBoxM3731a2.f8472b : null);
                            Format2.b bVarM3275a = bVarValueAt.f8409d.f8493a.f8465f.m3275a();
                            bVarM3275a.f7176n = drmInitDataM8835a;
                            bVarValueAt.f8406a.mo2526e(bVarM3275a.m3277a());
                        }
                    }
                    if (fragmentedMp4Extractor.f8399v != -9223372036854775807L) {
                        int size7 = fragmentedMp4Extractor.f8382e.size();
                        for (int i44 = 0; i44 < size7; i44++) {
                            b bVarValueAt2 = fragmentedMp4Extractor.f8382e.valueAt(i44);
                            long j6 = fragmentedMp4Extractor.f8399v;
                            int i45 = bVarValueAt2.f8411f;
                            while (true) {
                                TrackFragment trackFragment7 = bVarValueAt2.f8407b;
                                if (i45 >= trackFragment7.f8480e || trackFragment7.f8484i[i45] >= j6) {
                                    break;
                                }
                                if (trackFragment7.f8485j[i45]) {
                                    bVarValueAt2.f8414i = i45;
                                }
                                i45++;
                            }
                        }
                        fragmentedMp4Extractor.f8399v = -9223372036854775807L;
                    }
                    fragmentedMp4Extractor3 = fragmentedMp4Extractor;
                } else {
                    fragmentedMp4Extractor = fragmentedMp4Extractor2;
                    if (!fragmentedMp4Extractor3.f8390m.isEmpty()) {
                        fragmentedMp4Extractor3.f8390m.peek().f8352d.add(aVarPop);
                    }
                }
            }
            fragmentedMp4Extractor2 = fragmentedMp4Extractor;
        }
        m3713c();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    public void release() {
    }
}
