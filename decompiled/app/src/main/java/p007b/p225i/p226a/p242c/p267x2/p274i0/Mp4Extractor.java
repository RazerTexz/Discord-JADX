package p007b.p225i.p226a.p242c.p267x2.p274i0;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.permission.Permission;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.NalUnitUtil;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.Ac4Util;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.GaplessInfoHolder;
import p007b.p225i.p226a.p242c.p267x2.PositionHolder;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.SeekPoint;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.TrueHdSampleRechunker;
import p007b.p225i.p226a.p242c.p267x2.p274i0.Atom;
import p007b.p225i.p226a.p242c.p267x2.p274i0.SefReader;

/* compiled from: Mp4Extractor.java */
/* renamed from: b.i.a.c.x2.i0.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class Mp4Extractor implements Extractor, SeekMap {

    /* renamed from: a */
    public static final /* synthetic */ int f8419a = 0;

    /* renamed from: b */
    public final int f8420b;

    /* renamed from: c */
    public final ParsableByteArray f8421c;

    /* renamed from: d */
    public final ParsableByteArray f8422d;

    /* renamed from: e */
    public final ParsableByteArray f8423e;

    /* renamed from: f */
    public final ParsableByteArray f8424f;

    /* renamed from: g */
    public final ArrayDeque<Atom.a> f8425g;

    /* renamed from: h */
    public final SefReader f8426h;

    /* renamed from: i */
    public final List<Metadata.Entry> f8427i;

    /* renamed from: j */
    public int f8428j;

    /* renamed from: k */
    public int f8429k;

    /* renamed from: l */
    public long f8430l;

    /* renamed from: m */
    public int f8431m;

    /* renamed from: n */
    @Nullable
    public ParsableByteArray f8432n;

    /* renamed from: o */
    public int f8433o;

    /* renamed from: p */
    public int f8434p;

    /* renamed from: q */
    public int f8435q;

    /* renamed from: r */
    public int f8436r;

    /* renamed from: s */
    public ExtractorOutput f8437s;

    /* renamed from: t */
    public a[] f8438t;

    /* renamed from: u */
    public long[][] f8439u;

    /* renamed from: v */
    public int f8440v;

    /* renamed from: w */
    public long f8441w;

    /* renamed from: x */
    public int f8442x;

    /* renamed from: y */
    @Nullable
    public MotionPhotoMetadata f8443y;

    /* compiled from: Mp4Extractor.java */
    /* renamed from: b.i.a.c.x2.i0.i$a */
    public static final class a {

        /* renamed from: a */
        public final Track f8444a;

        /* renamed from: b */
        public final TrackSampleTable f8445b;

        /* renamed from: c */
        public final TrackOutput2 f8446c;

        /* renamed from: d */
        @Nullable
        public final TrueHdSampleRechunker f8447d;

        /* renamed from: e */
        public int f8448e;

        public a(Track track, TrackSampleTable trackSampleTable, TrackOutput2 trackOutput2) {
            this.f8444a = track;
            this.f8445b = trackSampleTable;
            this.f8446c = trackOutput2;
            this.f8447d = "audio/true-hd".equals(track.f8465f.f7155w) ? new TrueHdSampleRechunker() : null;
        }
    }

    static {
        C3043b c3043b = C3043b.f8347a;
    }

    public Mp4Extractor(int i) {
        this.f8420b = i;
        this.f8428j = (i & 4) != 0 ? 3 : 0;
        this.f8426h = new SefReader();
        this.f8427i = new ArrayList();
        this.f8424f = new ParsableByteArray(16);
        this.f8425g = new ArrayDeque<>();
        this.f8421c = new ParsableByteArray(NalUnitUtil.f6753a);
        this.f8422d = new ParsableByteArray(4);
        this.f8423e = new ParsableByteArray();
        this.f8433o = -1;
    }

    /* renamed from: k */
    public static long m3727k(TrackSampleTable trackSampleTable, long j, long j2) {
        int iM3732a = trackSampleTable.m3732a(j);
        if (iM3732a == -1) {
            iM3732a = trackSampleTable.m3733b(j);
        }
        return iM3732a == -1 ? j2 : Math.min(trackSampleTable.f8495c[iM3732a], j2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: b */
    public boolean mo3633b(ExtractorInput extractorInput) throws IOException {
        return Sniffer2.m3730a(extractorInput, false, (this.f8420b & 2) != 0);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: c */
    public boolean mo3619c() {
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:235:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x04a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:363:0x06bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:364:0x06b9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b1  */
    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int mo3635e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i;
        char c;
        boolean z2;
        long j;
        Atom.a aVarPeek;
        long j2;
        int i2;
        boolean z3;
        while (true) {
            int i3 = this.f8428j;
            int i4 = 4;
            int i5 = 2;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            throw new IllegalStateException();
                        }
                        SefReader sefReader = this.f8426h;
                        List<Metadata.Entry> list = this.f8427i;
                        int i6 = sefReader.f8455d;
                        if (i6 == 0) {
                            long jMo3642b = extractorInput.mo3642b();
                            positionHolder.f8992a = (jMo3642b == -1 || jMo3642b < 8) ? 0L : jMo3642b - 8;
                            sefReader.f8455d = 1;
                        } else if (i6 != 1) {
                            short s2 = 2819;
                            if (i6 == 2) {
                                long jMo3642b2 = extractorInput.mo3642b();
                                int i7 = (sefReader.f8456e - 12) - 8;
                                ParsableByteArray parsableByteArray = new ParsableByteArray(i7);
                                extractorInput.readFully(parsableByteArray.f6793a, 0, i7);
                                int i8 = 0;
                                while (i8 < i7 / 12) {
                                    parsableByteArray.m3080F(i5);
                                    short sM3089i = parsableByteArray.m3089i();
                                    if (sM3089i == 2192 || sM3089i == 2816 || sM3089i == 2817 || sM3089i == s2 || sM3089i == 2820) {
                                        sefReader.f8454c.add(new SefReader.a(sM3089i, (jMo3642b2 - sefReader.f8456e) - parsableByteArray.m3088h(), parsableByteArray.m3088h()));
                                    } else {
                                        parsableByteArray.m3080F(8);
                                    }
                                    i8++;
                                    s2 = 2819;
                                    i5 = 2;
                                }
                                if (sefReader.f8454c.isEmpty()) {
                                    positionHolder.f8992a = 0L;
                                } else {
                                    sefReader.f8455d = 3;
                                    positionHolder.f8992a = sefReader.f8454c.get(0).f8457a;
                                }
                            } else {
                                if (i6 != 3) {
                                    throw new IllegalStateException();
                                }
                                long position = extractorInput.getPosition();
                                int iMo3642b = (int) ((extractorInput.mo3642b() - extractorInput.getPosition()) - sefReader.f8456e);
                                ParsableByteArray parsableByteArray2 = new ParsableByteArray(iMo3642b);
                                extractorInput.readFully(parsableByteArray2.f6793a, 0, iMo3642b);
                                int i9 = 0;
                                while (i9 < sefReader.f8454c.size()) {
                                    SefReader.a aVar = sefReader.f8454c.get(i9);
                                    List<Metadata.Entry> list2 = list;
                                    parsableByteArray2.m3079E((int) (aVar.f8457a - position));
                                    parsableByteArray2.m3080F(i4);
                                    int iM3088h = parsableByteArray2.m3088h();
                                    String strM3097q = parsableByteArray2.m3097q(iM3088h);
                                    switch (strM3097q.hashCode()) {
                                        case -1711564334:
                                            i = strM3097q.equals("SlowMotion_Data") ? 0 : -1;
                                            break;
                                        case -1332107749:
                                            if (strM3097q.equals("Super_SlowMotion_Edit_Data")) {
                                                i = 1;
                                                break;
                                            }
                                            break;
                                        case -1251387154:
                                            if (strM3097q.equals("Super_SlowMotion_Data")) {
                                                i = 2;
                                                break;
                                            }
                                            break;
                                        case -830665521:
                                            if (strM3097q.equals("Super_SlowMotion_Deflickering_On")) {
                                                i = 3;
                                                break;
                                            }
                                            break;
                                        case 1760745220:
                                            if (strM3097q.equals("Super_SlowMotion_BGM")) {
                                                i = 4;
                                                break;
                                            }
                                            break;
                                    }
                                    if (i == 0) {
                                        c = 2192;
                                    } else if (i == 1) {
                                        c = 2819;
                                    } else if (i == 2) {
                                        c = 2816;
                                    } else if (i == 3) {
                                        c = 2820;
                                    } else {
                                        if (i != i4) {
                                            throw ParserException.m8755a("Invalid SEF name", null);
                                        }
                                        c = 2817;
                                    }
                                    int i10 = aVar.f8458b - (iM3088h + 8);
                                    if (c == 2192) {
                                        ArrayList arrayList = new ArrayList();
                                        List<String> listM6215a = SefReader.f8453b.m6215a(parsableByteArray2.m3097q(i10));
                                        for (int i11 = 0; i11 < listM6215a.size(); i11++) {
                                            List<String> listM6215a2 = SefReader.f8452a.m6215a(listM6215a.get(i11));
                                            if (listM6215a2.size() != 3) {
                                                throw ParserException.m8755a(null, null);
                                            }
                                            try {
                                                arrayList.add(new SlowMotionData.Segment(Long.parseLong(listM6215a2.get(0)), Long.parseLong(listM6215a2.get(1)), 1 << (Integer.parseInt(listM6215a2.get(2)) - 1)));
                                            } catch (NumberFormatException e) {
                                                throw ParserException.m8755a(null, e);
                                            }
                                        }
                                        list2.add(new SlowMotionData(arrayList));
                                    } else if (c != 2816 && c != 2817 && c != 2819 && c != 2820) {
                                        throw new IllegalStateException();
                                    }
                                    i9++;
                                    list = list2;
                                    i4 = 4;
                                }
                                positionHolder.f8992a = 0L;
                            }
                        } else {
                            byte[] bArr = new byte[8];
                            extractorInput.readFully(bArr, 0, 8);
                            sefReader.f8456e = ((bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 24)) + 8;
                            if (((bArr[7] & 255) | ((bArr[5] & 255) << 16) | ((bArr[4] & 255) << 24) | ((bArr[6] & 255) << 8)) != 1397048916) {
                                positionHolder.f8992a = 0L;
                            } else {
                                positionHolder.f8992a = extractorInput.getPosition() - (sefReader.f8456e - 12);
                                sefReader.f8455d = 2;
                            }
                        }
                        if (positionHolder.f8992a == 0) {
                            m3728j();
                        }
                        return 1;
                    }
                    long position2 = extractorInput.getPosition();
                    if (this.f8433o == -1) {
                        int i12 = -1;
                        boolean z4 = true;
                        int i13 = -1;
                        int i14 = 0;
                        long j3 = RecyclerView.FOREVER_NS;
                        boolean z5 = true;
                        long j4 = RecyclerView.FOREVER_NS;
                        long j5 = RecyclerView.FOREVER_NS;
                        while (true) {
                            a[] aVarArr = this.f8438t;
                            int i15 = Util2.f6708a;
                            if (i14 >= aVarArr.length) {
                                break;
                            }
                            a aVar2 = aVarArr[i14];
                            int i16 = aVar2.f8448e;
                            TrackSampleTable trackSampleTable = aVar2.f8445b;
                            if (i16 != trackSampleTable.f8494b) {
                                long j6 = trackSampleTable.f8495c[i16];
                                long j7 = this.f8439u[i14][i16];
                                long j8 = j6 - position2;
                                boolean z6 = j8 < 0 || j8 >= Permission.USE_EXTERNAL_EMOJIS;
                                if ((!z6 && z4) || (z6 == z4 && j8 < j5)) {
                                    z4 = z6;
                                    j5 = j8;
                                    i13 = i14;
                                    j4 = j7;
                                }
                                if (j7 < j3) {
                                    z5 = z6;
                                    i12 = i14;
                                    j3 = j7;
                                }
                            }
                            i14++;
                        }
                        if (j3 == RecyclerView.FOREVER_NS || !z5 || j4 < j3 + 10485760) {
                            i12 = i13;
                        }
                        this.f8433o = i12;
                        if (i12 == -1) {
                            return -1;
                        }
                    }
                    a[] aVarArr2 = this.f8438t;
                    int i17 = Util2.f6708a;
                    a aVar3 = aVarArr2[this.f8433o];
                    TrackOutput2 trackOutput2 = aVar3.f8446c;
                    int i18 = aVar3.f8448e;
                    TrackSampleTable trackSampleTable2 = aVar3.f8445b;
                    long j9 = trackSampleTable2.f8495c[i18];
                    int i19 = trackSampleTable2.f8496d[i18];
                    TrueHdSampleRechunker trueHdSampleRechunker = aVar3.f8447d;
                    long j10 = (j9 - position2) + this.f8434p;
                    if (j10 < 0 || j10 >= Permission.USE_EXTERNAL_EMOJIS) {
                        positionHolder.f8992a = j9;
                        return 1;
                    }
                    if (aVar3.f8444a.f8466g == 1) {
                        j10 += 8;
                        i19 -= 8;
                    }
                    extractorInput.mo3650l((int) j10);
                    Track track = aVar3.f8444a;
                    int i20 = track.f8469j;
                    if (i20 == 0) {
                        if ("audio/ac4".equals(track.f8465f.f7155w)) {
                            if (this.f8435q == 0) {
                                Ac4Util.m3492a(i19, this.f8423e);
                                trackOutput2.mo2524c(this.f8423e, 7);
                                this.f8435q += 7;
                            }
                            i19 += 7;
                        } else if (trueHdSampleRechunker != null) {
                            trueHdSampleRechunker.m3821c(extractorInput);
                        }
                        while (true) {
                            int i21 = this.f8435q;
                            if (i21 >= i19) {
                                break;
                            }
                            int iMo2523b = trackOutput2.mo2523b(extractorInput, i19 - i21, false);
                            this.f8434p += iMo2523b;
                            this.f8435q += iMo2523b;
                            this.f8436r -= iMo2523b;
                        }
                    } else {
                        byte[] bArr2 = this.f8422d.f6793a;
                        bArr2[0] = 0;
                        bArr2[1] = 0;
                        bArr2[2] = 0;
                        int i22 = 4 - i20;
                        while (this.f8435q < i19) {
                            int i23 = this.f8436r;
                            if (i23 == 0) {
                                extractorInput.readFully(bArr2, i22, i20);
                                this.f8434p += i20;
                                this.f8422d.m3079E(0);
                                int iM3086f = this.f8422d.m3086f();
                                if (iM3086f < 0) {
                                    throw ParserException.m8755a("Invalid NAL length", null);
                                }
                                this.f8436r = iM3086f;
                                this.f8421c.m3079E(0);
                                trackOutput2.mo2524c(this.f8421c, 4);
                                this.f8435q += 4;
                                i19 += i22;
                            } else {
                                int iMo2523b2 = trackOutput2.mo2523b(extractorInput, i23, false);
                                this.f8434p += iMo2523b2;
                                this.f8435q += iMo2523b2;
                                this.f8436r -= iMo2523b2;
                            }
                        }
                    }
                    int i24 = i19;
                    TrackSampleTable trackSampleTable3 = aVar3.f8445b;
                    long j11 = trackSampleTable3.f8498f[i18];
                    int i25 = trackSampleTable3.f8499g[i18];
                    if (trueHdSampleRechunker != null) {
                        trueHdSampleRechunker.m3820b(trackOutput2, j11, i25, i24, 0, null);
                        if (i18 + 1 == aVar3.f8445b.f8494b) {
                            trueHdSampleRechunker.m3819a(trackOutput2, null);
                        }
                    } else {
                        trackOutput2.mo2525d(j11, i25, i24, 0, null);
                    }
                    aVar3.f8448e++;
                    this.f8433o = -1;
                    this.f8434p = 0;
                    this.f8435q = 0;
                    this.f8436r = 0;
                    return 0;
                }
                long j12 = this.f8430l - this.f8431m;
                long position3 = extractorInput.getPosition() + j12;
                ParsableByteArray parsableByteArray3 = this.f8432n;
                if (parsableByteArray3 != null) {
                    extractorInput.readFully(parsableByteArray3.f6793a, this.f8431m, (int) j12);
                    if (this.f8429k == 1718909296) {
                        parsableByteArray3.m3079E(8);
                        int iM3086f2 = parsableByteArray3.m3086f();
                        int i26 = iM3086f2 != 1751476579 ? iM3086f2 != 1903435808 ? 0 : 1 : 2;
                        if (i26 == 0) {
                            parsableByteArray3.m3080F(4);
                            while (true) {
                                if (parsableByteArray3.m3081a() <= 0) {
                                    i26 = 0;
                                    break;
                                }
                                int iM3086f3 = parsableByteArray3.m3086f();
                                i26 = iM3086f3 != 1751476579 ? iM3086f3 != 1903435808 ? 0 : 1 : 2;
                                if (i26 != 0) {
                                    break;
                                }
                            }
                        }
                        this.f8442x = i26;
                    } else if (!this.f8425g.isEmpty()) {
                        this.f8425g.peek().f8351c.add(new Atom.b(this.f8429k, parsableByteArray3));
                    }
                } else if (j12 < Permission.USE_EXTERNAL_EMOJIS) {
                    extractorInput.mo3650l((int) j12);
                } else {
                    positionHolder.f8992a = extractorInput.getPosition() + j12;
                    z2 = true;
                    m3729l(position3);
                    if (!((z2 || this.f8428j == 2) ? false : true)) {
                        return 1;
                    }
                }
                z2 = false;
                m3729l(position3);
                if (z2) {
                    if (!((z2 || this.f8428j == 2) ? false : true)) {
                    }
                }
            } else if (this.f8431m != 0) {
                j = this.f8430l;
                if (j != 1) {
                    extractorInput.readFully(this.f8424f.f6793a, 8, 8);
                    this.f8431m += 8;
                    this.f8430l = this.f8424f.m3104x();
                } else if (j == 0) {
                    long jMo3642b3 = extractorInput.mo3642b();
                    if (jMo3642b3 == -1 && (aVarPeek = this.f8425g.peek()) != null) {
                        jMo3642b3 = aVarPeek.f8350b;
                    }
                    if (jMo3642b3 != -1) {
                        this.f8430l = (jMo3642b3 - extractorInput.getPosition()) + this.f8431m;
                    }
                }
                j2 = this.f8430l;
                i2 = this.f8431m;
                if (j2 >= i2) {
                    throw ParserException.m8756b("Atom size less than header length (unsupported).");
                }
                int i27 = this.f8429k;
                if (i27 == 1836019574 || i27 == 1953653099 || i27 == 1835297121 || i27 == 1835626086 || i27 == 1937007212 || i27 == 1701082227 || i27 == 1835365473) {
                    long position4 = extractorInput.getPosition();
                    long j13 = this.f8430l;
                    long j14 = this.f8431m;
                    long j15 = (position4 + j13) - j14;
                    if (j13 != j14 && this.f8429k == 1835365473) {
                        this.f8423e.m3075A(8);
                        extractorInput.mo3652o(this.f8423e.f6793a, 0, 8);
                        ParsableByteArray parsableByteArray4 = this.f8423e;
                        byte[] bArr3 = AtomParsers.f8354a;
                        int i28 = parsableByteArray4.f6794b;
                        parsableByteArray4.m3080F(4);
                        if (parsableByteArray4.m3086f() != 1751411826) {
                            i28 += 4;
                        }
                        parsableByteArray4.m3079E(i28);
                        extractorInput.mo3650l(this.f8423e.f6794b);
                        extractorInput.mo3649k();
                    }
                    this.f8425g.push(new Atom.a(this.f8429k, j15));
                    if (this.f8430l == this.f8431m) {
                        m3729l(j15);
                    } else {
                        m3728j();
                    }
                } else if (i27 == 1835296868 || i27 == 1836476516 || i27 == 1751411826 || i27 == 1937011556 || i27 == 1937011827 || i27 == 1937011571 || i27 == 1668576371 || i27 == 1701606260 || i27 == 1937011555 || i27 == 1937011578 || i27 == 1937013298 || i27 == 1937007471 || i27 == 1668232756 || i27 == 1953196132 || i27 == 1718909296 || i27 == 1969517665 || i27 == 1801812339 || i27 == 1768715124) {
                    AnimatableValueParser.m426D(i2 == 8);
                    AnimatableValueParser.m426D(this.f8430l <= 2147483647L);
                    ParsableByteArray parsableByteArray5 = new ParsableByteArray((int) this.f8430l);
                    System.arraycopy(this.f8424f.f6793a, 0, parsableByteArray5.f6793a, 0, 8);
                    this.f8432n = parsableByteArray5;
                    this.f8428j = 1;
                } else {
                    long position5 = extractorInput.getPosition();
                    long j16 = this.f8431m;
                    long j17 = position5 - j16;
                    if (this.f8429k == 1836086884) {
                        this.f8443y = new MotionPhotoMetadata(0L, j17, -9223372036854775807L, j17 + j16, this.f8430l - j16);
                    }
                    this.f8432n = null;
                    this.f8428j = 1;
                }
                z3 = true;
                if (z3) {
                    return -1;
                }
            } else if (extractorInput.mo3643c(this.f8424f.f6793a, 0, 8, true)) {
                this.f8431m = 8;
                this.f8424f.m3079E(0);
                this.f8430l = this.f8424f.m3101u();
                this.f8429k = this.f8424f.m3086f();
                j = this.f8430l;
                if (j != 1) {
                }
                j2 = this.f8430l;
                i2 = this.f8431m;
                if (j2 >= i2) {
                }
            } else {
                if (this.f8442x == 2 && (this.f8420b & 2) != 0) {
                    ExtractorOutput extractorOutput = this.f8437s;
                    Objects.requireNonNull(extractorOutput);
                    TrackOutput2 trackOutput2Mo2492p = extractorOutput.mo2492p(0, 4);
                    MotionPhotoMetadata motionPhotoMetadata = this.f8443y;
                    Metadata metadata = motionPhotoMetadata == null ? null : new Metadata(motionPhotoMetadata);
                    Format2.b bVar = new Format2.b();
                    bVar.f7171i = metadata;
                    trackOutput2Mo2492p.mo2526e(bVar.m3277a());
                    extractorOutput.mo2486j();
                    extractorOutput.mo2477a(new SeekMap.b(-9223372036854775807L, 0L));
                }
                z3 = false;
                if (z3) {
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: f */
    public void mo3636f(ExtractorOutput extractorOutput) {
        this.f8437s = extractorOutput;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: g */
    public void mo3637g(long j, long j2) {
        this.f8425g.clear();
        this.f8431m = 0;
        this.f8433o = -1;
        this.f8434p = 0;
        this.f8435q = 0;
        this.f8436r = 0;
        if (j == 0) {
            if (this.f8428j != 3) {
                m3728j();
                return;
            }
            SefReader sefReader = this.f8426h;
            sefReader.f8454c.clear();
            sefReader.f8455d = 0;
            this.f8427i.clear();
            return;
        }
        a[] aVarArr = this.f8438t;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                TrackSampleTable trackSampleTable = aVar.f8445b;
                int iM3732a = trackSampleTable.m3732a(j2);
                if (iM3732a == -1) {
                    iM3732a = trackSampleTable.m3733b(j2);
                }
                aVar.f8448e = iM3732a;
                TrueHdSampleRechunker trueHdSampleRechunker = aVar.f8447d;
                if (trueHdSampleRechunker != null) {
                    trueHdSampleRechunker.f9005b = false;
                    trueHdSampleRechunker.f9006c = 0;
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: h */
    public SeekMap.a mo3620h(long j) {
        long j2;
        long jM3727k;
        long j3;
        long j4;
        int iM3733b;
        long j5 = j;
        a[] aVarArr = this.f8438t;
        Objects.requireNonNull(aVarArr);
        if (aVarArr.length == 0) {
            return new SeekMap.a(SeekPoint.f8997a);
        }
        long j6 = -1;
        int i = this.f8440v;
        if (i != -1) {
            TrackSampleTable trackSampleTable = this.f8438t[i].f8445b;
            int iM3732a = trackSampleTable.m3732a(j5);
            if (iM3732a == -1) {
                iM3732a = trackSampleTable.m3733b(j5);
            }
            if (iM3732a == -1) {
                return new SeekMap.a(SeekPoint.f8997a);
            }
            long j7 = trackSampleTable.f8498f[iM3732a];
            j2 = trackSampleTable.f8495c[iM3732a];
            if (j7 >= j5 || iM3732a >= trackSampleTable.f8494b - 1 || (iM3733b = trackSampleTable.m3733b(j5)) == -1 || iM3733b == iM3732a) {
                j4 = -9223372036854775807L;
            } else {
                long j8 = trackSampleTable.f8498f[iM3733b];
                long j9 = trackSampleTable.f8495c[iM3733b];
                j4 = j8;
                j6 = j9;
            }
            jM3727k = j6;
            j3 = j4;
            j5 = j7;
        } else {
            j2 = RecyclerView.FOREVER_NS;
            jM3727k = -1;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            a[] aVarArr2 = this.f8438t;
            if (i2 >= aVarArr2.length) {
                break;
            }
            if (i2 != this.f8440v) {
                TrackSampleTable trackSampleTable2 = aVarArr2[i2].f8445b;
                long jM3727k2 = m3727k(trackSampleTable2, j5, j2);
                if (j3 != -9223372036854775807L) {
                    jM3727k = m3727k(trackSampleTable2, j3, jM3727k);
                }
                j2 = jM3727k2;
            }
            i2++;
        }
        SeekPoint seekPoint = new SeekPoint(j5, j2);
        return j3 == -9223372036854775807L ? new SeekMap.a(seekPoint) : new SeekMap.a(seekPoint, new SeekPoint(j3, jM3727k));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.SeekMap
    /* renamed from: i */
    public long mo3621i() {
        return this.f8441w;
    }

    /* renamed from: j */
    public final void m3728j() {
        this.f8428j = 0;
        this.f8431m = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01d0, code lost:
    
        r13 = r3.m3095o(r11 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01db, code lost:
    
        if (r9 != 1851878757) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01dd, code lost:
    
        r6 = r3.m3095o(r11 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01e7, code lost:
    
        if (r9 != 1684108385) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01e9, code lost:
    
        r5 = r11;
        r0 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01ec, code lost:
    
        r3.m3080F(r11 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01f1, code lost:
    
        r8 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01f4, code lost:
    
        r19 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01f6, code lost:
    
        if (r13 == null) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01f8, code lost:
    
        if (r6 == null) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01fb, code lost:
    
        if (r0 != (-1)) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01ff, code lost:
    
        r3.m3079E(r0);
        r3.m3080F(16);
        r0 = new com.google.android.exoplayer2.metadata.id3.InternalFrame(r13, r6, r3.m3095o(r5 - 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0215, code lost:
    
        r19 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0219, code lost:
    
        r19 = r8;
        r8 = 16777215 & r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0222, code lost:
    
        if (r8 != 6516084) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0224, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3721a(r5, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x022a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0230, code lost:
    
        if (r8 == 7233901) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0235, code lost:
    
        if (r8 != 7631467) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x023c, code lost:
    
        if (r8 == 6516589) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0241, code lost:
    
        if (r8 != 7828084) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0248, code lost:
    
        if (r8 != 6578553) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x024a, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "TDRC", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0255, code lost:
    
        if (r8 != 4280916) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0257, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "TPE1", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0261, code lost:
    
        if (r8 != 7630703) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0263, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "TSSE", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x026d, code lost:
    
        if (r8 != 6384738) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x026f, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "TALB", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0279, code lost:
    
        if (r8 != 7108978) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x027b, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "USLT", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0285, code lost:
    
        if (r8 != 6776174) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0287, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "TCON", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x028f, code lost:
    
        if (r8 != 6779504) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0291, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "TIT1", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0298, code lost:
    
        r5 = java.lang.String.valueOf(p007b.p225i.p226a.p242c.p267x2.p274i0.Atom.m3699a(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02a6, code lost:
    
        if (r5.length() == 0) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02a8, code lost:
    
        r5 = "Skipped unknown metadata entry: ".concat(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02ad, code lost:
    
        r5 = new java.lang.String("Skipped unknown metadata entry: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02b2, code lost:
    
        android.util.Log.d("MetadataUtil", r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02b5, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02b7, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "TCOM", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02be, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "TIT2", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02c7, code lost:
    
        if (r0 == null) goto L363;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02c9, code lost:
    
        r4.add(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x02cc, code lost:
    
        r13 = null;
        r6 = r16;
        r0 = r17;
        r8 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02d5, code lost:
    
        r3.m3079E(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x02d8, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x02d9, code lost:
    
        r17 = r0;
        r19 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02e1, code lost:
    
        if (r4.isEmpty() == false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x02e4, code lost:
    
        r0 = new com.google.android.exoplayer2.metadata.Metadata(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0097, code lost:
    
        r3.m3079E(r6);
        r6 = r6 + r7;
        r3.m3080F(r9);
        r4 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
    
        r5 = r3.f6794b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a5, code lost:
    
        if (r5 >= r6) goto L361;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a7, code lost:
    
        r7 = r3.m3086f() + r5;
        r5 = r3.m3086f();
        r9 = (r5 >> 24) & 255;
        r16 = r6;
        r17 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00be, code lost:
    
        if (r9 == 169) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c2, code lost:
    
        if (r9 != 253) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c9, code lost:
    
        if (r5 != 1735291493) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
    
        r5 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3726f(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cf, code lost:
    
        if (r5 <= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d1, code lost:
    
        r9 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.f8418a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d4, code lost:
    
        if (r5 > r9.length) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d6, code lost:
    
        r5 = r9[r5 - 1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00db, code lost:
    
        r5 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00dc, code lost:
    
        if (r5 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00de, code lost:
    
        r0 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame("TCON", r13, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e5, code lost:
    
        android.util.Log.w("MetadataUtil", "Failed to parse standard genre code");
        r19 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f1, code lost:
    
        if (r5 != 1684632427) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f3, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3723c(r5, "TPOS", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00fe, code lost:
    
        if (r5 != 1953655662) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0100, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3723c(r5, "TRCK", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x010b, code lost:
    
        if (r5 != 1953329263) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x010d, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3725e(r5, "TBPM", r3, true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x011b, code lost:
    
        if (r5 != 1668311404) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x011d, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3725e(r5, "TCMP", r3, true, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0128, code lost:
    
        if (r5 != 1668249202) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x012a, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3722b(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0133, code lost:
    
        if (r5 != 1631670868) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0135, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "TPE2", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0140, code lost:
    
        if (r5 != 1936682605) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0142, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "TSOT", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014c, code lost:
    
        if (r5 != 1936679276) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x014e, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "TSO2", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0158, code lost:
    
        if (r5 != 1936679282) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x015a, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "TSOA", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0164, code lost:
    
        if (r5 != 1936679265) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0166, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "TSOP", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0170, code lost:
    
        if (r5 != 1936679791) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0172, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "TSOC", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x017c, code lost:
    
        if (r5 != 1920233063) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x017e, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3725e(r5, "ITUNESADVISORY", r3, false, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x018a, code lost:
    
        if (r5 != 1885823344) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x018c, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3725e(r5, "ITUNESGAPLESS", r3, false, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0197, code lost:
    
        if (r5 != 1936683886) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0199, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "TVSHOWSORT", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01a3, code lost:
    
        if (r5 != 1953919848) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01a5, code lost:
    
        r0 = p007b.p225i.p226a.p242c.p267x2.p274i0.MetadataUtil.m3724d(r5, "TVSHOW", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01ab, code lost:
    
        r19 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01b2, code lost:
    
        if (r5 != 757935405) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01b4, code lost:
    
        r0 = -1;
        r5 = -1;
        r6 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01b7, code lost:
    
        r9 = r3.f6794b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01b9, code lost:
    
        if (r9 >= r7) goto L364;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01bb, code lost:
    
        r11 = r3.m3086f();
        r9 = r3.m3086f();
        r19 = r8;
        r3.m3080F(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01ce, code lost:
    
        if (r9 != 1835360622) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x061e A[LOOP:12: B:316:0x061b->B:318:0x061e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x063a  */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3729l(long j) throws ParserException {
        ArrayList arrayList;
        boolean z2;
        Metadata metadata;
        int i;
        Metadata metadata2;
        Metadata metadata3;
        Metadata metadata4;
        int size;
        int i2;
        a[] aVarArr;
        int i3;
        int i4;
        ArrayList arrayList2;
        int i5;
        Metadata metadata5;
        int i6;
        int i7;
        ArrayList arrayList3;
        int i8;
        int i9;
        String[] strArr;
        Metadata metadata6;
        MdtaMetadataEntry mdtaMetadataEntry;
        ArrayList arrayList4;
        boolean z3;
        while (!this.f8425g.isEmpty() && this.f8425g.peek().f8350b == j) {
            Atom.a aVarPop = this.f8425g.pop();
            if (aVarPop.f8349a == 1836019574) {
                ArrayList arrayList5 = new ArrayList();
                boolean z4 = this.f8442x == 1;
                GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
                Atom.b bVarM3701c = aVarPop.m3701c(1969517665);
                int i10 = 1768715124;
                int i11 = 1751411826;
                int i12 = 1835365473;
                int i13 = 4;
                int i14 = 8;
                Metadata metadata7 = null;
                if (bVarM3701c != null) {
                    byte[] bArr = AtomParsers.f8354a;
                    ParsableByteArray parsableByteArray = bVarM3701c.f8353b;
                    parsableByteArray.m3079E(8);
                    Metadata metadata8 = null;
                    String strM3095o = null;
                    while (parsableByteArray.m3081a() >= i14) {
                        int i15 = parsableByteArray.f6794b;
                        int iM3086f = parsableByteArray.m3086f();
                        int i16 = i10;
                        int iM3086f2 = parsableByteArray.m3086f();
                        if (iM3086f2 == i12) {
                            parsableByteArray.m3079E(i15);
                            int i17 = i15 + iM3086f;
                            parsableByteArray.m3080F(i14);
                            int i18 = parsableByteArray.f6794b;
                            parsableByteArray.m3080F(i13);
                            if (parsableByteArray.m3086f() != i11) {
                                i18 += 4;
                            }
                            parsableByteArray.m3079E(i18);
                            int i19 = i16;
                            while (true) {
                                int i20 = parsableByteArray.f6794b;
                                if (i20 >= i17) {
                                    arrayList4 = arrayList5;
                                    z3 = z4;
                                    break;
                                }
                                int iM3086f3 = parsableByteArray.m3086f();
                                if (parsableByteArray.m3086f() == i19) {
                                    break;
                                }
                                parsableByteArray.m3079E(i20 + iM3086f3);
                                i14 = 8;
                                i19 = 1768715124;
                                strM3095o = null;
                            }
                            Metadata metadata9 = null;
                            metadata7 = metadata9;
                        } else {
                            arrayList4 = arrayList5;
                            z3 = z4;
                            if (iM3086f2 == 1936553057) {
                                parsableByteArray.m3079E(i15);
                                int i21 = i15 + iM3086f;
                                parsableByteArray.m3080F(12);
                                while (true) {
                                    int i22 = parsableByteArray.f6794b;
                                    if (i22 >= i21) {
                                        break;
                                    }
                                    int iM3086f4 = parsableByteArray.m3086f();
                                    if (parsableByteArray.m3086f() != 1935766900) {
                                        parsableByteArray.m3079E(i22 + iM3086f4);
                                    } else {
                                        if (iM3086f4 < 14) {
                                            break;
                                        }
                                        parsableByteArray.m3080F(5);
                                        int iM3100t = parsableByteArray.m3100t();
                                        if (iM3100t == 12 || iM3100t == 13) {
                                            float f = iM3100t == 12 ? 240.0f : 120.0f;
                                            parsableByteArray.m3080F(1);
                                            metadata8 = new Metadata(new SmtaMetadataEntry(f, parsableByteArray.m3100t()));
                                        }
                                    }
                                }
                                metadata8 = null;
                            }
                        }
                        parsableByteArray.m3079E(i15 + iM3086f);
                        i14 = 8;
                        i10 = 1768715124;
                        i11 = 1751411826;
                        i12 = 1835365473;
                        strM3095o = null;
                        i13 = 4;
                        arrayList5 = arrayList4;
                        z4 = z3;
                    }
                    arrayList = arrayList5;
                    z2 = z4;
                    Pair pairCreate = Pair.create(metadata7, metadata8);
                    metadata2 = (Metadata) pairCreate.first;
                    metadata = (Metadata) pairCreate.second;
                    if (metadata2 != null) {
                        gaplessInfoHolder.m3815b(metadata2);
                    }
                    i = 1835365473;
                } else {
                    arrayList = arrayList5;
                    z2 = z4;
                    metadata = null;
                    i = 1835365473;
                    metadata2 = null;
                }
                Metadata metadata10 = metadata2;
                Atom.a aVarM3700b = aVarPop.m3700b(i);
                if (aVarM3700b != null) {
                    byte[] bArr2 = AtomParsers.f8354a;
                    Atom.b bVarM3701c2 = aVarM3700b.m3701c(1751411826);
                    Atom.b bVarM3701c3 = aVarM3700b.m3701c(1801812339);
                    Atom.b bVarM3701c4 = aVarM3700b.m3701c(1768715124);
                    if (bVarM3701c2 == null || bVarM3701c3 == null || bVarM3701c4 == null) {
                        metadata3 = metadata10;
                        metadata4 = null;
                        Metadata metadata11 = metadata4;
                        List<TrackSampleTable> listM3706e = AtomParsers.m3706e(aVarPop, gaplessInfoHolder, -9223372036854775807L, null, (this.f8420b & 1) != 0, z2, C3042a.f8346a);
                        ExtractorOutput extractorOutput = this.f8437s;
                        Objects.requireNonNull(extractorOutput);
                        ArrayList arrayList6 = (ArrayList) listM3706e;
                        size = arrayList6.size();
                        long jMax = -9223372036854775807L;
                        long j2 = -9223372036854775807L;
                        i2 = 0;
                        int size2 = -1;
                        while (i2 < size) {
                            TrackSampleTable trackSampleTable = (TrackSampleTable) arrayList6.get(i2);
                            if (trackSampleTable.f8494b == 0) {
                                metadata5 = metadata;
                                arrayList2 = arrayList6;
                                i5 = size;
                                arrayList3 = arrayList;
                            } else {
                                Track track = trackSampleTable.f8493a;
                                Metadata metadata12 = metadata11;
                                int i23 = size2;
                                long j3 = track.f8464e;
                                if (j3 == j2) {
                                    j3 = trackSampleTable.f8500h;
                                }
                                jMax = Math.max(jMax, j3);
                                a aVar = new a(track, trackSampleTable, extractorOutput.mo2492p(i2, track.f8461b));
                                arrayList2 = arrayList6;
                                int i24 = "audio/true-hd".equals(track.f8465f.f7155w) ? trackSampleTable.f8497e * 16 : trackSampleTable.f8497e + 30;
                                Format2.b bVarM3275a = track.f8465f.m3275a();
                                bVarM3275a.f7174l = i24;
                                int i25 = track.f8461b;
                                i5 = size;
                                if (i25 == 2 && j3 > 0 && (i8 = trackSampleTable.f8494b) > 1) {
                                    bVarM3275a.f7180r = i8 / (j3 / 1000000.0f);
                                }
                                if (i25 == 1) {
                                    int i26 = gaplessInfoHolder.f8985b;
                                    if ((i26 == -1 || gaplessInfoHolder.f8986c == -1) ? false : true) {
                                        bVarM3275a.f7159A = i26;
                                        bVarM3275a.f7160B = gaplessInfoHolder.f8986c;
                                    }
                                }
                                Metadata[] metadataArr = new Metadata[2];
                                metadataArr[0] = metadata;
                                metadataArr[1] = this.f8427i.isEmpty() ? null : new Metadata(this.f8427i);
                                Metadata metadata13 = new Metadata(new Metadata.Entry[0]);
                                if (i25 == 1) {
                                    if (metadata3 != null) {
                                        metadata5 = metadata;
                                        metadata11 = metadata12;
                                        metadata13 = metadata3;
                                    } else {
                                        metadata5 = metadata;
                                        metadata11 = metadata12;
                                    }
                                    for (i6 = 0; i6 < 2; i6++) {
                                        Metadata metadata14 = metadataArr[i6];
                                        if (metadata14 != null) {
                                            metadata13 = metadata13.m8877a(metadata14.f19936j);
                                        }
                                    }
                                    if (metadata13.f19936j.length > 0) {
                                        bVarM3275a.f7171i = metadata13;
                                    }
                                    aVar.f8446c.mo2526e(bVarM3275a.m3277a());
                                    if (track.f8461b != 2) {
                                        i7 = i23;
                                        if (i7 == -1) {
                                            size2 = arrayList.size();
                                        }
                                        arrayList3 = arrayList;
                                        arrayList3.add(aVar);
                                    } else {
                                        i7 = i23;
                                    }
                                    size2 = i7;
                                    arrayList3 = arrayList;
                                    arrayList3.add(aVar);
                                } else {
                                    if (i25 == 2 && metadata12 != null) {
                                        int i27 = 0;
                                        metadata11 = metadata12;
                                        while (true) {
                                            Metadata.Entry[] entryArr = metadata11.f19936j;
                                            if (i27 >= entryArr.length) {
                                                metadata5 = metadata;
                                                break;
                                            }
                                            Metadata.Entry entry = entryArr[i27];
                                            if (entry instanceof MdtaMetadataEntry) {
                                                MdtaMetadataEntry mdtaMetadataEntry2 = (MdtaMetadataEntry) entry;
                                                metadata5 = metadata;
                                                if ("com.android.capture.fps".equals(mdtaMetadataEntry2.f20004j)) {
                                                    metadata13 = new Metadata(mdtaMetadataEntry2);
                                                    break;
                                                }
                                            } else {
                                                metadata5 = metadata;
                                            }
                                            i27++;
                                            metadata = metadata5;
                                        }
                                    }
                                    while (i6 < 2) {
                                    }
                                    if (metadata13.f19936j.length > 0) {
                                    }
                                    aVar.f8446c.mo2526e(bVarM3275a.m3277a());
                                    if (track.f8461b != 2) {
                                    }
                                    size2 = i7;
                                    arrayList3 = arrayList;
                                    arrayList3.add(aVar);
                                }
                            }
                            i2++;
                            j2 = -9223372036854775807L;
                            arrayList = arrayList3;
                            arrayList6 = arrayList2;
                            size = i5;
                            metadata = metadata5;
                        }
                        long j4 = 0;
                        this.f8440v = size2;
                        this.f8441w = jMax;
                        aVarArr = (a[]) arrayList.toArray(new a[0]);
                        this.f8438t = aVarArr;
                        long[][] jArr = new long[aVarArr.length][];
                        int[] iArr = new int[aVarArr.length];
                        long[] jArr2 = new long[aVarArr.length];
                        boolean[] zArr = new boolean[aVarArr.length];
                        for (i3 = 0; i3 < aVarArr.length; i3++) {
                            jArr[i3] = new long[aVarArr[i3].f8445b.f8494b];
                            jArr2[i3] = aVarArr[i3].f8445b.f8498f[0];
                        }
                        i4 = 0;
                        while (i4 < aVarArr.length) {
                            long j5 = RecyclerView.FOREVER_NS;
                            int i28 = -1;
                            for (int i29 = 0; i29 < aVarArr.length; i29++) {
                                if (!zArr[i29] && jArr2[i29] <= j5) {
                                    j5 = jArr2[i29];
                                    i28 = i29;
                                }
                            }
                            int i30 = iArr[i28];
                            jArr[i28][i30] = j4;
                            j4 += aVarArr[i28].f8445b.f8496d[i30];
                            int i31 = i30 + 1;
                            iArr[i28] = i31;
                            if (i31 < jArr[i28].length) {
                                jArr2[i28] = aVarArr[i28].f8445b.f8498f[i31];
                            } else {
                                zArr[i28] = true;
                                i4++;
                            }
                        }
                        this.f8439u = jArr;
                        extractorOutput.mo2486j();
                        extractorOutput.mo2477a(this);
                        this.f8425g.clear();
                        this.f8428j = 2;
                    } else {
                        ParsableByteArray parsableByteArray2 = bVarM3701c2.f8353b;
                        parsableByteArray2.m3079E(16);
                        if (parsableByteArray2.m3086f() == 1835299937) {
                            ParsableByteArray parsableByteArray3 = bVarM3701c3.f8353b;
                            parsableByteArray3.m3079E(12);
                            int iM3086f5 = parsableByteArray3.m3086f();
                            String[] strArr2 = new String[iM3086f5];
                            for (int i32 = 0; i32 < iM3086f5; i32++) {
                                int iM3086f6 = parsableByteArray3.m3086f();
                                parsableByteArray3.m3080F(4);
                                strArr2[i32] = parsableByteArray3.m3097q(iM3086f6 - 8);
                            }
                            int i33 = 8;
                            ParsableByteArray parsableByteArray4 = bVarM3701c4.f8353b;
                            parsableByteArray4.m3079E(8);
                            ArrayList arrayList7 = new ArrayList();
                            while (parsableByteArray4.m3081a() > i33) {
                                int i34 = parsableByteArray4.f6794b;
                                int iM3086f7 = parsableByteArray4.m3086f();
                                int iM3086f8 = parsableByteArray4.m3086f() - 1;
                                if (iM3086f8 < 0 || iM3086f8 >= iM3086f5) {
                                    i9 = iM3086f5;
                                    strArr = strArr2;
                                    metadata6 = metadata10;
                                    outline.m852g0(52, "Skipped metadata with unknown key index: ", iM3086f8, "AtomParsers");
                                } else {
                                    String str = strArr2[iM3086f8];
                                    int i35 = i34 + iM3086f7;
                                    while (true) {
                                        int i36 = parsableByteArray4.f6794b;
                                        if (i36 >= i35) {
                                            i9 = iM3086f5;
                                            strArr = strArr2;
                                            metadata6 = metadata10;
                                            mdtaMetadataEntry = null;
                                            break;
                                        }
                                        int iM3086f9 = parsableByteArray4.m3086f();
                                        i9 = iM3086f5;
                                        if (parsableByteArray4.m3086f() == 1684108385) {
                                            int iM3086f10 = parsableByteArray4.m3086f();
                                            int iM3086f11 = parsableByteArray4.m3086f();
                                            int i37 = iM3086f9 - 16;
                                            byte[] bArr3 = new byte[i37];
                                            strArr = strArr2;
                                            metadata6 = metadata10;
                                            System.arraycopy(parsableByteArray4.f6793a, parsableByteArray4.f6794b, bArr3, 0, i37);
                                            parsableByteArray4.f6794b += i37;
                                            mdtaMetadataEntry = new MdtaMetadataEntry(str, bArr3, iM3086f11, iM3086f10);
                                            break;
                                        }
                                        parsableByteArray4.m3079E(i36 + iM3086f9);
                                        iM3086f5 = i9;
                                    }
                                    if (mdtaMetadataEntry != null) {
                                        arrayList7.add(mdtaMetadataEntry);
                                    }
                                }
                                parsableByteArray4.m3079E(i34 + iM3086f7);
                                i33 = 8;
                                iM3086f5 = i9;
                                strArr2 = strArr;
                                metadata10 = metadata6;
                            }
                            metadata3 = metadata10;
                            if (!arrayList7.isEmpty()) {
                                metadata4 = new Metadata(arrayList7);
                            }
                            Metadata metadata112 = metadata4;
                            List<TrackSampleTable> listM3706e2 = AtomParsers.m3706e(aVarPop, gaplessInfoHolder, -9223372036854775807L, null, (this.f8420b & 1) != 0, z2, C3042a.f8346a);
                            ExtractorOutput extractorOutput2 = this.f8437s;
                            Objects.requireNonNull(extractorOutput2);
                            ArrayList arrayList62 = (ArrayList) listM3706e2;
                            size = arrayList62.size();
                            long jMax2 = -9223372036854775807L;
                            long j22 = -9223372036854775807L;
                            i2 = 0;
                            int size22 = -1;
                            while (i2 < size) {
                            }
                            long j42 = 0;
                            this.f8440v = size22;
                            this.f8441w = jMax2;
                            aVarArr = (a[]) arrayList.toArray(new a[0]);
                            this.f8438t = aVarArr;
                            long[][] jArr3 = new long[aVarArr.length][];
                            int[] iArr2 = new int[aVarArr.length];
                            long[] jArr22 = new long[aVarArr.length];
                            boolean[] zArr2 = new boolean[aVarArr.length];
                            while (i3 < aVarArr.length) {
                            }
                            i4 = 0;
                            while (i4 < aVarArr.length) {
                            }
                            this.f8439u = jArr3;
                            extractorOutput2.mo2486j();
                            extractorOutput2.mo2477a(this);
                            this.f8425g.clear();
                            this.f8428j = 2;
                        }
                        metadata4 = null;
                        Metadata metadata1122 = metadata4;
                        List<TrackSampleTable> listM3706e22 = AtomParsers.m3706e(aVarPop, gaplessInfoHolder, -9223372036854775807L, null, (this.f8420b & 1) != 0, z2, C3042a.f8346a);
                        ExtractorOutput extractorOutput22 = this.f8437s;
                        Objects.requireNonNull(extractorOutput22);
                        ArrayList arrayList622 = (ArrayList) listM3706e22;
                        size = arrayList622.size();
                        long jMax22 = -9223372036854775807L;
                        long j222 = -9223372036854775807L;
                        i2 = 0;
                        int size222 = -1;
                        while (i2 < size) {
                        }
                        long j422 = 0;
                        this.f8440v = size222;
                        this.f8441w = jMax22;
                        aVarArr = (a[]) arrayList.toArray(new a[0]);
                        this.f8438t = aVarArr;
                        long[][] jArr32 = new long[aVarArr.length][];
                        int[] iArr22 = new int[aVarArr.length];
                        long[] jArr222 = new long[aVarArr.length];
                        boolean[] zArr22 = new boolean[aVarArr.length];
                        while (i3 < aVarArr.length) {
                        }
                        i4 = 0;
                        while (i4 < aVarArr.length) {
                        }
                        this.f8439u = jArr32;
                        extractorOutput22.mo2486j();
                        extractorOutput22.mo2477a(this);
                        this.f8425g.clear();
                        this.f8428j = 2;
                    }
                }
            } else if (!this.f8425g.isEmpty()) {
                this.f8425g.peek().f8352d.add(aVarPop);
            }
        }
        if (this.f8428j != 2) {
            m3728j();
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    public void release() {
    }
}
