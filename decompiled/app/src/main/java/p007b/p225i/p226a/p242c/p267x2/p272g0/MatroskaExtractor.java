package p007b.p225i.p226a.p242c.p267x2.p272g0;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.discord.api.permission.Permission;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.C;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.LongArray;
import p007b.p225i.p226a.p242c.p259f3.MimeTypes;
import p007b.p225i.p226a.p242c.p259f3.NalUnitUtil;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.AvcConfig;
import p007b.p225i.p226a.p242c.p260g3.ColorInfo;
import p007b.p225i.p226a.p242c.p260g3.DolbyVisionConfig;
import p007b.p225i.p226a.p242c.p260g3.HevcConfig;
import p007b.p225i.p226a.p242c.p263t2.AacUtil;
import p007b.p225i.p226a.p242c.p267x2.ChunkIndex;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.PositionHolder;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.TrueHdSampleRechunker;
import p007b.p225i.p226a.p242c.p267x2.p272g0.DefaultEbmlReader;
import p007b.p225i.p355b.p357b.AbstractIndexedListIterator;
import p007b.p225i.p355b.p357b.ImmutableList2;

/* compiled from: MatroskaExtractor.java */
/* renamed from: b.i.a.c.x2.g0.e, reason: use source file name */
/* loaded from: classes3.dex */
public class MatroskaExtractor implements Extractor {

    /* renamed from: a */
    public static final byte[] f8190a;

    /* renamed from: b */
    public static final byte[] f8191b;

    /* renamed from: c */
    public static final byte[] f8192c;

    /* renamed from: d */
    public static final UUID f8193d;

    /* renamed from: e */
    public static final Map<String, Integer> f8194e;

    /* renamed from: A */
    public boolean f8195A;

    /* renamed from: B */
    public int f8196B;

    /* renamed from: C */
    public long f8197C;

    /* renamed from: D */
    public boolean f8198D;

    /* renamed from: E */
    public long f8199E;

    /* renamed from: F */
    public long f8200F;

    /* renamed from: G */
    public long f8201G;

    /* renamed from: H */
    @Nullable
    public LongArray f8202H;

    /* renamed from: I */
    @Nullable
    public LongArray f8203I;

    /* renamed from: J */
    public boolean f8204J;

    /* renamed from: K */
    public boolean f8205K;

    /* renamed from: L */
    public int f8206L;

    /* renamed from: M */
    public long f8207M;

    /* renamed from: N */
    public long f8208N;

    /* renamed from: O */
    public int f8209O;

    /* renamed from: P */
    public int f8210P;

    /* renamed from: Q */
    public int[] f8211Q;

    /* renamed from: R */
    public int f8212R;

    /* renamed from: S */
    public int f8213S;

    /* renamed from: T */
    public int f8214T;

    /* renamed from: U */
    public int f8215U;

    /* renamed from: V */
    public boolean f8216V;

    /* renamed from: W */
    public int f8217W;

    /* renamed from: X */
    public int f8218X;

    /* renamed from: Y */
    public int f8219Y;

    /* renamed from: Z */
    public boolean f8220Z;

    /* renamed from: a0 */
    public boolean f8221a0;

    /* renamed from: b0 */
    public boolean f8222b0;

    /* renamed from: c0 */
    public int f8223c0;

    /* renamed from: d0 */
    public byte f8224d0;

    /* renamed from: e0 */
    public boolean f8225e0;

    /* renamed from: f */
    public final EbmlReader f8226f;

    /* renamed from: f0 */
    public ExtractorOutput f8227f0;

    /* renamed from: g */
    public final VarintReader f8228g;

    /* renamed from: h */
    public final SparseArray<c> f8229h;

    /* renamed from: i */
    public final boolean f8230i;

    /* renamed from: j */
    public final ParsableByteArray f8231j;

    /* renamed from: k */
    public final ParsableByteArray f8232k;

    /* renamed from: l */
    public final ParsableByteArray f8233l;

    /* renamed from: m */
    public final ParsableByteArray f8234m;

    /* renamed from: n */
    public final ParsableByteArray f8235n;

    /* renamed from: o */
    public final ParsableByteArray f8236o;

    /* renamed from: p */
    public final ParsableByteArray f8237p;

    /* renamed from: q */
    public final ParsableByteArray f8238q;

    /* renamed from: r */
    public final ParsableByteArray f8239r;

    /* renamed from: s */
    public final ParsableByteArray f8240s;

    /* renamed from: t */
    public ByteBuffer f8241t;

    /* renamed from: u */
    public long f8242u;

    /* renamed from: v */
    public long f8243v;

    /* renamed from: w */
    public long f8244w;

    /* renamed from: x */
    public long f8245x;

    /* renamed from: y */
    public long f8246y;

    /* renamed from: z */
    @Nullable
    public c f8247z;

    /* compiled from: MatroskaExtractor.java */
    /* renamed from: b.i.a.c.x2.g0.e$b */
    public final class b implements EbmlProcessor {
        public b(a aVar) {
        }
    }

    static {
        C3024a c3024a = C3024a.f8180a;
        f8190a = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        f8191b = Util2.m3015w("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
        f8192c = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        f8193d = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        f8194e = Collections.unmodifiableMap(map);
    }

    public MatroskaExtractor(int i) {
        DefaultEbmlReader defaultEbmlReader = new DefaultEbmlReader();
        this.f8243v = -1L;
        this.f8244w = -9223372036854775807L;
        this.f8245x = -9223372036854775807L;
        this.f8246y = -9223372036854775807L;
        this.f8199E = -1L;
        this.f8200F = -1L;
        this.f8201G = -9223372036854775807L;
        this.f8226f = defaultEbmlReader;
        defaultEbmlReader.f8184d = new b(null);
        this.f8230i = (i & 1) == 0;
        this.f8228g = new VarintReader();
        this.f8229h = new SparseArray<>();
        this.f8233l = new ParsableByteArray(4);
        this.f8234m = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.f8235n = new ParsableByteArray(4);
        this.f8231j = new ParsableByteArray(NalUnitUtil.f6753a);
        this.f8232k = new ParsableByteArray(4);
        this.f8236o = new ParsableByteArray();
        this.f8237p = new ParsableByteArray();
        this.f8238q = new ParsableByteArray(8);
        this.f8239r = new ParsableByteArray();
        this.f8240s = new ParsableByteArray();
        this.f8211Q = new int[1];
    }

    /* renamed from: i */
    public static int[] m3671i(@Nullable int[] iArr, int i) {
        return iArr == null ? new int[i] : iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    /* renamed from: j */
    public static byte[] m3672j(long j, String str, long j2) {
        AnimatableValueParser.m531j(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - ((i * 3600) * 1000000);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - ((i2 * 60) * 1000000);
        int i3 = (int) (j4 / 1000000);
        return Util2.m3015w(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (i3 * 1000000)) / j2))));
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    /* renamed from: a */
    public final void m3673a(int i) throws ParserException {
        if (this.f8202H == null || this.f8203I == null) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Element ");
            sb.append(i);
            sb.append(" must be in a Cues");
            throw ParserException.m8755a(sb.toString(), null);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: b */
    public final boolean mo3633b(ExtractorInput extractorInput) throws IOException {
        Sniffer sniffer = new Sniffer();
        long jMo3642b = extractorInput.mo3642b();
        long j = Permission.VIEW_CHANNEL;
        if (jMo3642b != -1 && jMo3642b <= Permission.VIEW_CHANNEL) {
            j = jMo3642b;
        }
        int i = (int) j;
        extractorInput.mo3652o(sniffer.f8300a.f6793a, 0, 4);
        sniffer.f8301b = 4;
        for (long jM3101u = sniffer.f8300a.m3101u(); jM3101u != 440786851; jM3101u = ((jM3101u << 8) & (-256)) | (sniffer.f8300a.f6793a[0] & 255)) {
            int i2 = sniffer.f8301b + 1;
            sniffer.f8301b = i2;
            if (i2 == i) {
                return false;
            }
            extractorInput.mo3652o(sniffer.f8300a.f6793a, 0, 1);
        }
        long jM3684a = sniffer.m3684a(extractorInput);
        long j2 = sniffer.f8301b;
        if (jM3684a == Long.MIN_VALUE) {
            return false;
        }
        if (jMo3642b != -1 && j2 + jM3684a >= jMo3642b) {
            return false;
        }
        while (true) {
            long j3 = sniffer.f8301b;
            long j4 = j2 + jM3684a;
            if (j3 >= j4) {
                return j3 == j4;
            }
            if (sniffer.m3684a(extractorInput) == Long.MIN_VALUE) {
                return false;
            }
            long jM3684a2 = sniffer.m3684a(extractorInput);
            if (jM3684a2 < 0 || jM3684a2 > 2147483647L) {
                return false;
            }
            if (jM3684a2 != 0) {
                int i3 = (int) jM3684a2;
                extractorInput.mo3646g(i3);
                sniffer.f8301b += i3;
            }
        }
    }

    @EnsuresNonNull({"currentTrack"})
    /* renamed from: c */
    public final void m3674c(int i) throws ParserException {
        if (this.f8247z != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(43);
        sb.append("Element ");
        sb.append(i);
        sb.append(" must be in a TrackEntry");
        throw ParserException.m8755a(sb.toString(), null);
    }

    @RequiresNonNull({"#1.output"})
    /* renamed from: d */
    public final void m3675d(c cVar, long j, int i, int i2, int i3) {
        byte[] bArrM3672j;
        int i4;
        TrueHdSampleRechunker trueHdSampleRechunker = cVar.f8268T;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.m3820b(cVar.f8272X, j, i, i2, i3, cVar.f8283j);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.f8275b) || "S_TEXT/ASS".equals(cVar.f8275b)) {
                if (this.f8210P > 1) {
                    Log.w("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.f8208N;
                    if (j2 == -9223372036854775807L) {
                        Log.w("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        String str = cVar.f8275b;
                        byte[] bArr = this.f8237p.f6793a;
                        str.hashCode();
                        if (str.equals("S_TEXT/ASS")) {
                            bArrM3672j = m3672j(j2, "%01d:%02d:%02d:%02d", 10000L);
                            i4 = 21;
                        } else {
                            if (!str.equals("S_TEXT/UTF8")) {
                                throw new IllegalArgumentException();
                            }
                            bArrM3672j = m3672j(j2, "%02d:%02d:%02d,%03d", 1000L);
                            i4 = 19;
                        }
                        System.arraycopy(bArrM3672j, 0, bArr, i4, bArrM3672j.length);
                        int i5 = this.f8237p.f6794b;
                        while (true) {
                            ParsableByteArray parsableByteArray = this.f8237p;
                            if (i5 >= parsableByteArray.f6795c) {
                                break;
                            }
                            if (parsableByteArray.f6793a[i5] == 0) {
                                parsableByteArray.m3078D(i5);
                                break;
                            }
                            i5++;
                        }
                        TrackOutput2 trackOutput2 = cVar.f8272X;
                        ParsableByteArray parsableByteArray2 = this.f8237p;
                        trackOutput2.mo2524c(parsableByteArray2, parsableByteArray2.f6795c);
                        i2 += this.f8237p.f6795c;
                    }
                }
            }
            if ((268435456 & i) != 0) {
                if (this.f8210P > 1) {
                    i &= -268435457;
                } else {
                    ParsableByteArray parsableByteArray3 = this.f8240s;
                    int i6 = parsableByteArray3.f6795c;
                    cVar.f8272X.mo2527f(parsableByteArray3, i6, 2);
                    i2 += i6;
                }
            }
            cVar.f8272X.mo2525d(j, i, i2, i3, cVar.f8283j);
        }
        this.f8205K = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:414:0x08a8, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x08aa, code lost:
    
        if (r5 == false) goto L464;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x08ac, code lost:
    
        r3 = r29.getPosition();
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x08b2, code lost:
    
        if (r28.f8198D == false) goto L419;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x08b4, code lost:
    
        r28.f8200F = r3;
        r30.f8992a = r28.f8199E;
        r28.f8198D = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x08c0, code lost:
    
        if (r28.f8195A == false) goto L425;
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x08c2, code lost:
    
        r3 = r28.f8200F;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x08c8, code lost:
    
        if (r3 == (-1)) goto L425;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x08ca, code lost:
    
        r30.f8992a = r3;
        r28.f8200F = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x08ce, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x08d0, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x08d1, code lost:
    
        if (r3 == false) goto L465;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x08d3, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x08d5, code lost:
    
        r3 = false;
        r4 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v6, types: [int[]] */
    /* JADX WARN: Type inference failed for: r3v145 */
    /* JADX WARN: Type inference failed for: r3v68 */
    /* JADX WARN: Type inference failed for: r3v79 */
    /* JADX WARN: Type inference failed for: r4v124 */
    /* JADX WARN: Type inference failed for: r4v139 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v89, types: [b.i.a.c.x2.g0.g] */
    /* JADX WARN: Type inference failed for: r5v90, types: [b.i.a.c.x2.g0.g] */
    /* JADX WARN: Type inference failed for: r8v28, types: [b.i.a.c.x2.g0.g] */
    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int mo3635e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i;
        int i2;
        String str;
        long j;
        int i3;
        int[] iArr;
        boolean z2 = false;
        this.f8205K = false;
        boolean z3 = true;
        boolean z4 = true;
        while (z4 && !this.f8205K) {
            DefaultEbmlReader defaultEbmlReader = (DefaultEbmlReader) this.f8226f;
            AnimatableValueParser.m438H(defaultEbmlReader.f8184d);
            boolean z5 = z2;
            ?? r4 = z3;
            while (true) {
                DefaultEbmlReader.b bVarPeek = defaultEbmlReader.f8182b.peek();
                if (bVarPeek == null || extractorInput.getPosition() < bVarPeek.f8189b) {
                    if (defaultEbmlReader.f8185e == 0) {
                        long jM3687c = defaultEbmlReader.f8183c.m3687c(extractorInput, r4, z5, 4);
                        if (jM3687c == -2) {
                            extractorInput.mo3649k();
                            while (true) {
                                extractorInput.mo3652o(defaultEbmlReader.f8181a, z5 ? 1 : 0, 4);
                                int iM3686b = VarintReader.m3686b(defaultEbmlReader.f8181a[z5 ? 1 : 0]);
                                if (iM3686b != -1 && iM3686b <= 4) {
                                    int iM3685a = (int) VarintReader.m3685a(defaultEbmlReader.f8181a, iM3686b, z5);
                                    Objects.requireNonNull(MatroskaExtractor.this);
                                    if (iM3685a == 357149030 || iM3685a == 524531317 || iM3685a == 475249515 || iM3685a == 374648427) {
                                        extractorInput.mo3650l(iM3686b);
                                        jM3687c = iM3685a;
                                    }
                                }
                                extractorInput.mo3650l(r4 == true ? 1 : 0);
                            }
                        }
                        if (jM3687c == -1) {
                            z4 = false;
                        } else {
                            defaultEbmlReader.f8186f = (int) jM3687c;
                            defaultEbmlReader.f8185e = r4 == true ? 1 : 0;
                        }
                    }
                    if (defaultEbmlReader.f8185e == r4) {
                        defaultEbmlReader.f8187g = defaultEbmlReader.f8183c.m3687c(extractorInput, z5, r4, 8);
                        defaultEbmlReader.f8185e = 2;
                    }
                    EbmlProcessor ebmlProcessor = defaultEbmlReader.f8184d;
                    int i4 = defaultEbmlReader.f8186f;
                    Objects.requireNonNull(MatroskaExtractor.this);
                    switch (i4) {
                        case Opcodes.LXOR /* 131 */:
                        case Opcodes.L2I /* 136 */:
                        case 155:
                        case Opcodes.IF_ICMPEQ /* 159 */:
                        case Opcodes.ARETURN /* 176 */:
                        case Opcodes.PUTSTATIC /* 179 */:
                        case Opcodes.INVOKEDYNAMIC /* 186 */:
                        case 215:
                        case 231:
                        case 238:
                        case 241:
                        case 251:
                        case 16871:
                        case 16980:
                        case 17029:
                        case 17143:
                        case 18401:
                        case 18408:
                        case 20529:
                        case 20530:
                        case 21420:
                        case 21432:
                        case 21680:
                        case 21682:
                        case 21690:
                        case 21930:
                        case 21945:
                        case 21946:
                        case 21947:
                        case 21948:
                        case 21949:
                        case 21998:
                        case 22186:
                        case 22203:
                        case 25188:
                        case 30321:
                        case 2352003:
                        case 2807729:
                            i = 2;
                            break;
                        case Opcodes.I2F /* 134 */:
                        case 17026:
                        case 21358:
                        case 2274716:
                            i = 3;
                            break;
                        case Opcodes.IF_ICMPNE /* 160 */:
                        case Opcodes.IF_ACMPNE /* 166 */:
                        case Opcodes.FRETURN /* 174 */:
                        case Opcodes.INVOKESPECIAL /* 183 */:
                        case Opcodes.NEW /* 187 */:
                        case 224:
                        case HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION /* 225 */:
                        case 16868:
                        case 18407:
                        case 19899:
                        case 20532:
                        case 20533:
                        case 21936:
                        case 21968:
                        case 25152:
                        case 28032:
                        case 30113:
                        case 30320:
                        case 290298740:
                        case 357149030:
                        case 374648427:
                        case 408125543:
                        case 440786851:
                        case 475249515:
                        case 524531317:
                            i = 1;
                            break;
                        case Opcodes.IF_ICMPLT /* 161 */:
                        case Opcodes.IF_ICMPGT /* 163 */:
                        case Opcodes.IF_ACMPEQ /* 165 */:
                        case 16877:
                        case 16981:
                        case 18402:
                        case 21419:
                        case 25506:
                        case 30322:
                            i = 4;
                            break;
                        case Opcodes.PUTFIELD /* 181 */:
                        case 17545:
                        case 21969:
                        case 21970:
                        case 21971:
                        case 21972:
                        case 21973:
                        case 21974:
                        case 21975:
                        case 21976:
                        case 21977:
                        case 21978:
                        case 30323:
                        case 30324:
                        case 30325:
                            i = 5;
                            break;
                        default:
                            i = 0;
                            break;
                    }
                    if (i == 0) {
                        extractorInput.mo3650l((int) defaultEbmlReader.f8187g);
                        z5 = false;
                        defaultEbmlReader.f8185e = 0;
                        r4 = 1;
                    } else if (i == r4) {
                        long position = extractorInput.getPosition();
                        defaultEbmlReader.f8182b.push(new DefaultEbmlReader.b(defaultEbmlReader.f8186f, defaultEbmlReader.f8187g + position, null));
                        EbmlProcessor ebmlProcessor2 = defaultEbmlReader.f8184d;
                        int i5 = defaultEbmlReader.f8186f;
                        long j2 = defaultEbmlReader.f8187g;
                        MatroskaExtractor matroskaExtractor = MatroskaExtractor.this;
                        AnimatableValueParser.m438H(matroskaExtractor.f8227f0);
                        if (i5 == 160) {
                            i2 = 0;
                            matroskaExtractor.f8216V = false;
                        } else if (i5 == 174) {
                            i2 = 0;
                            matroskaExtractor.f8247z = new c(null);
                        } else if (i5 != 187) {
                            if (i5 == 19899) {
                                matroskaExtractor.f8196B = -1;
                                matroskaExtractor.f8197C = -1L;
                            } else if (i5 == 20533) {
                                matroskaExtractor.m3674c(i5);
                                matroskaExtractor.f8247z.f8281h = true;
                            } else if (i5 == 21968) {
                                matroskaExtractor.m3674c(i5);
                                matroskaExtractor.f8247z.f8297x = true;
                            } else if (i5 == 408125543) {
                                long j3 = matroskaExtractor.f8243v;
                                if (j3 != -1 && j3 != position) {
                                    throw ParserException.m8755a("Multiple Segment elements not supported", null);
                                }
                                matroskaExtractor.f8243v = position;
                                matroskaExtractor.f8242u = j2;
                            } else if (i5 == 475249515) {
                                matroskaExtractor.f8202H = new LongArray();
                                matroskaExtractor.f8203I = new LongArray();
                            } else if (i5 == 524531317 && !matroskaExtractor.f8195A) {
                                if (!matroskaExtractor.f8230i || matroskaExtractor.f8199E == -1) {
                                    matroskaExtractor.f8227f0.mo2477a(new SeekMap.b(matroskaExtractor.f8246y, 0L));
                                    matroskaExtractor.f8195A = true;
                                } else {
                                    matroskaExtractor.f8198D = true;
                                }
                            }
                            i2 = 0;
                        } else {
                            i2 = 0;
                            matroskaExtractor.f8204J = false;
                        }
                        defaultEbmlReader.f8185e = i2;
                    } else if (i == 2) {
                        long j4 = defaultEbmlReader.f8187g;
                        if (j4 > 8) {
                            StringBuilder sb = new StringBuilder(42);
                            sb.append("Invalid integer size: ");
                            sb.append(j4);
                            throw ParserException.m8755a(sb.toString(), null);
                        }
                        EbmlProcessor ebmlProcessor3 = defaultEbmlReader.f8184d;
                        int i6 = defaultEbmlReader.f8186f;
                        long jM3670a = defaultEbmlReader.m3670a(extractorInput, (int) j4);
                        MatroskaExtractor matroskaExtractor2 = MatroskaExtractor.this;
                        Objects.requireNonNull(matroskaExtractor2);
                        if (i6 != 20529) {
                            if (i6 != 20530) {
                                switch (i6) {
                                    case Opcodes.LXOR /* 131 */:
                                        matroskaExtractor2.m3674c(i6);
                                        matroskaExtractor2.f8247z.f8277d = (int) jM3670a;
                                        break;
                                    case Opcodes.L2I /* 136 */:
                                        matroskaExtractor2.m3674c(i6);
                                        matroskaExtractor2.f8247z.f8270V = jM3670a == 1;
                                        break;
                                    case 155:
                                        matroskaExtractor2.f8208N = matroskaExtractor2.m3679m(jM3670a);
                                        break;
                                    case Opcodes.IF_ICMPEQ /* 159 */:
                                        matroskaExtractor2.m3674c(i6);
                                        matroskaExtractor2.f8247z.f8263O = (int) jM3670a;
                                        break;
                                    case Opcodes.ARETURN /* 176 */:
                                        matroskaExtractor2.m3674c(i6);
                                        matroskaExtractor2.f8247z.f8286m = (int) jM3670a;
                                        break;
                                    case Opcodes.PUTSTATIC /* 179 */:
                                        matroskaExtractor2.m3673a(i6);
                                        matroskaExtractor2.f8202H.m3041a(matroskaExtractor2.m3679m(jM3670a));
                                        break;
                                    case Opcodes.INVOKEDYNAMIC /* 186 */:
                                        matroskaExtractor2.m3674c(i6);
                                        matroskaExtractor2.f8247z.f8287n = (int) jM3670a;
                                        break;
                                    case 215:
                                        matroskaExtractor2.m3674c(i6);
                                        matroskaExtractor2.f8247z.f8276c = (int) jM3670a;
                                        break;
                                    case 231:
                                        matroskaExtractor2.f8201G = matroskaExtractor2.m3679m(jM3670a);
                                        break;
                                    case 238:
                                        matroskaExtractor2.f8215U = (int) jM3670a;
                                        break;
                                    case 241:
                                        if (!matroskaExtractor2.f8204J) {
                                            matroskaExtractor2.m3673a(i6);
                                            matroskaExtractor2.f8203I.m3041a(jM3670a);
                                            matroskaExtractor2.f8204J = true;
                                        }
                                        break;
                                    case 251:
                                        matroskaExtractor2.f8216V = true;
                                        break;
                                    case 16871:
                                        matroskaExtractor2.m3674c(i6);
                                        matroskaExtractor2.f8247z.f8280g = (int) jM3670a;
                                        break;
                                    case 16980:
                                        if (jM3670a != 3) {
                                            throw ParserException.m8755a(outline.m855i(50, "ContentCompAlgo ", jM3670a, " not supported"), null);
                                        }
                                        break;
                                    case 17029:
                                        if (jM3670a < 1 || jM3670a > 2) {
                                            throw ParserException.m8755a(outline.m855i(53, "DocTypeReadVersion ", jM3670a, " not supported"), null);
                                        }
                                        break;
                                    case 17143:
                                        if (jM3670a != 1) {
                                            throw ParserException.m8755a(outline.m855i(50, "EBMLReadVersion ", jM3670a, " not supported"), null);
                                        }
                                        break;
                                    case 18401:
                                        if (jM3670a != 5) {
                                            throw ParserException.m8755a(outline.m855i(49, "ContentEncAlgo ", jM3670a, " not supported"), null);
                                        }
                                        break;
                                    case 18408:
                                        if (jM3670a != 1) {
                                            throw ParserException.m8755a(outline.m855i(56, "AESSettingsCipherMode ", jM3670a, " not supported"), null);
                                        }
                                        break;
                                    case 21420:
                                        matroskaExtractor2.f8197C = jM3670a + matroskaExtractor2.f8243v;
                                        break;
                                    case 21432:
                                        int i7 = (int) jM3670a;
                                        matroskaExtractor2.m3674c(i6);
                                        if (i7 == 0) {
                                            matroskaExtractor2.f8247z.f8296w = 0;
                                        } else if (i7 == 1) {
                                            matroskaExtractor2.f8247z.f8296w = 2;
                                        } else if (i7 == 3) {
                                            matroskaExtractor2.f8247z.f8296w = 1;
                                        } else if (i7 == 15) {
                                            matroskaExtractor2.f8247z.f8296w = 3;
                                        }
                                        break;
                                    case 21680:
                                        matroskaExtractor2.m3674c(i6);
                                        matroskaExtractor2.f8247z.f8288o = (int) jM3670a;
                                        break;
                                    case 21682:
                                        matroskaExtractor2.m3674c(i6);
                                        matroskaExtractor2.f8247z.f8290q = (int) jM3670a;
                                        break;
                                    case 21690:
                                        matroskaExtractor2.m3674c(i6);
                                        matroskaExtractor2.f8247z.f8289p = (int) jM3670a;
                                        break;
                                    case 21930:
                                        matroskaExtractor2.m3674c(i6);
                                        matroskaExtractor2.f8247z.f8269U = jM3670a == 1;
                                        break;
                                    case 21998:
                                        matroskaExtractor2.m3674c(i6);
                                        matroskaExtractor2.f8247z.f8279f = (int) jM3670a;
                                        break;
                                    case 22186:
                                        matroskaExtractor2.m3674c(i6);
                                        matroskaExtractor2.f8247z.f8266R = jM3670a;
                                        break;
                                    case 22203:
                                        matroskaExtractor2.m3674c(i6);
                                        matroskaExtractor2.f8247z.f8267S = jM3670a;
                                        break;
                                    case 25188:
                                        matroskaExtractor2.m3674c(i6);
                                        matroskaExtractor2.f8247z.f8264P = (int) jM3670a;
                                        break;
                                    case 30321:
                                        matroskaExtractor2.m3674c(i6);
                                        int i8 = (int) jM3670a;
                                        if (i8 == 0) {
                                            matroskaExtractor2.f8247z.f8291r = 0;
                                        } else if (i8 == 1) {
                                            matroskaExtractor2.f8247z.f8291r = 1;
                                        } else if (i8 == 2) {
                                            matroskaExtractor2.f8247z.f8291r = 2;
                                        } else if (i8 == 3) {
                                            matroskaExtractor2.f8247z.f8291r = 3;
                                        }
                                        break;
                                    case 2352003:
                                        matroskaExtractor2.m3674c(i6);
                                        matroskaExtractor2.f8247z.f8278e = (int) jM3670a;
                                        break;
                                    case 2807729:
                                        matroskaExtractor2.f8244w = jM3670a;
                                        break;
                                    default:
                                        switch (i6) {
                                            case 21945:
                                                matroskaExtractor2.m3674c(i6);
                                                int i9 = (int) jM3670a;
                                                if (i9 == 1) {
                                                    matroskaExtractor2.f8247z.f8249A = 2;
                                                } else if (i9 == 2) {
                                                    matroskaExtractor2.f8247z.f8249A = 1;
                                                }
                                                break;
                                            case 21946:
                                                matroskaExtractor2.m3674c(i6);
                                                int iM3124b = ColorInfo.m3124b((int) jM3670a);
                                                if (iM3124b != -1) {
                                                    matroskaExtractor2.f8247z.f8299z = iM3124b;
                                                }
                                                break;
                                            case 21947:
                                                matroskaExtractor2.m3674c(i6);
                                                matroskaExtractor2.f8247z.f8297x = true;
                                                int iM3123a = ColorInfo.m3123a((int) jM3670a);
                                                if (iM3123a != -1) {
                                                    matroskaExtractor2.f8247z.f8298y = iM3123a;
                                                }
                                                break;
                                            case 21948:
                                                matroskaExtractor2.m3674c(i6);
                                                matroskaExtractor2.f8247z.f8250B = (int) jM3670a;
                                                break;
                                            case 21949:
                                                matroskaExtractor2.m3674c(i6);
                                                matroskaExtractor2.f8247z.f8251C = (int) jM3670a;
                                                break;
                                        }
                                        break;
                                }
                            } else if (jM3670a != 1) {
                                throw ParserException.m8755a(outline.m855i(55, "ContentEncodingScope ", jM3670a, " not supported"), null);
                            }
                        } else if (jM3670a != 0) {
                            throw ParserException.m8755a(outline.m855i(55, "ContentEncodingOrder ", jM3670a, " not supported"), null);
                        }
                        defaultEbmlReader.f8185e = 0;
                    } else if (i == 3) {
                        long j5 = defaultEbmlReader.f8187g;
                        if (j5 > 2147483647L) {
                            StringBuilder sb2 = new StringBuilder(41);
                            sb2.append("String element size: ");
                            sb2.append(j5);
                            throw ParserException.m8755a(sb2.toString(), null);
                        }
                        EbmlProcessor ebmlProcessor4 = defaultEbmlReader.f8184d;
                        int i10 = defaultEbmlReader.f8186f;
                        int i11 = (int) j5;
                        if (i11 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i11];
                            extractorInput.readFully(bArr, 0, i11);
                            while (i11 > 0) {
                                int i12 = i11 - 1;
                                if (bArr[i12] == 0) {
                                    i11 = i12;
                                } else {
                                    str = new String(bArr, 0, i11);
                                }
                            }
                            str = new String(bArr, 0, i11);
                        }
                        MatroskaExtractor matroskaExtractor3 = MatroskaExtractor.this;
                        Objects.requireNonNull(matroskaExtractor3);
                        if (i10 == 134) {
                            matroskaExtractor3.m3674c(i10);
                            matroskaExtractor3.f8247z.f8275b = str;
                        } else if (i10 != 17026) {
                            if (i10 == 21358) {
                                matroskaExtractor3.m3674c(i10);
                                matroskaExtractor3.f8247z.f8274a = str;
                            } else if (i10 == 2274716) {
                                matroskaExtractor3.m3674c(i10);
                                matroskaExtractor3.f8247z.f8271W = str;
                            }
                        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
                            StringBuilder sb3 = new StringBuilder(str.length() + 22);
                            sb3.append("DocType ");
                            sb3.append(str);
                            sb3.append(" not supported");
                            throw ParserException.m8755a(sb3.toString(), null);
                        }
                        defaultEbmlReader.f8185e = 0;
                    } else if (i == 4) {
                        EbmlProcessor ebmlProcessor5 = defaultEbmlReader.f8184d;
                        int i13 = defaultEbmlReader.f8186f;
                        int i14 = (int) defaultEbmlReader.f8187g;
                        MatroskaExtractor matroskaExtractor4 = MatroskaExtractor.this;
                        Objects.requireNonNull(matroskaExtractor4);
                        if (i13 == 161 || i13 == 163) {
                            if (matroskaExtractor4.f8206L == 0) {
                                matroskaExtractor4.f8212R = (int) matroskaExtractor4.f8228g.m3687c(extractorInput, z5, r4, 8);
                                matroskaExtractor4.f8213S = matroskaExtractor4.f8228g.f8305d;
                                matroskaExtractor4.f8208N = -9223372036854775807L;
                                matroskaExtractor4.f8206L = r4 == true ? 1 : 0;
                                matroskaExtractor4.f8233l.m3075A(z5 ? 1 : 0);
                            }
                            c cVar = matroskaExtractor4.f8229h.get(matroskaExtractor4.f8212R);
                            if (cVar == null) {
                                extractorInput.mo3650l(i14 - matroskaExtractor4.f8213S);
                                matroskaExtractor4.f8206L = z5 ? 1 : 0;
                            } else {
                                Objects.requireNonNull(cVar.f8272X);
                                if (matroskaExtractor4.f8206L == r4) {
                                    matroskaExtractor4.m3677k(extractorInput, 3);
                                    int i15 = (matroskaExtractor4.f8233l.f6793a[2] & 6) >> (r4 == true ? 1 : 0);
                                    byte b2 = 255;
                                    if (i15 == 0) {
                                        matroskaExtractor4.f8210P = r4 == true ? 1 : 0;
                                        int[] iArrM3671i = m3671i(matroskaExtractor4.f8211Q, r4 == true ? 1 : 0);
                                        matroskaExtractor4.f8211Q = iArrM3671i;
                                        iArrM3671i[z5 ? 1 : 0] = (i14 - matroskaExtractor4.f8213S) - 3;
                                    } else {
                                        matroskaExtractor4.m3677k(extractorInput, 4);
                                        int i16 = (matroskaExtractor4.f8233l.f6793a[3] & 255) + (r4 == true ? 1 : 0);
                                        matroskaExtractor4.f8210P = i16;
                                        int[] iArrM3671i2 = m3671i(matroskaExtractor4.f8211Q, i16);
                                        matroskaExtractor4.f8211Q = iArrM3671i2;
                                        if (i15 == 2) {
                                            int i17 = (i14 - matroskaExtractor4.f8213S) - 4;
                                            int i18 = matroskaExtractor4.f8210P;
                                            Arrays.fill(iArrM3671i2, z5 ? 1 : 0, i18, i17 / i18);
                                        } else {
                                            int i19 = 4;
                                            if (i15 != r4) {
                                                if (i15 != 3) {
                                                    throw outline.m884w0(36, "Unexpected lacing value: ", i15, null);
                                                }
                                                int i20 = 0;
                                                int i21 = 0;
                                                ?? r3 = z5;
                                                int i22 = r4;
                                                while (true) {
                                                    int i23 = matroskaExtractor4.f8210P;
                                                    if (i20 < i23 - 1) {
                                                        matroskaExtractor4.f8211Q[i20] = r3;
                                                        i19++;
                                                        matroskaExtractor4.m3677k(extractorInput, i19);
                                                        int i24 = i19 - 1;
                                                        if (matroskaExtractor4.f8233l.f6793a[i24] == 0) {
                                                            throw ParserException.m8755a("No valid varint length mask found", null);
                                                        }
                                                        int i25 = 8;
                                                        int i26 = 0;
                                                        int i27 = i22;
                                                        while (true) {
                                                            if (i26 < i25) {
                                                                int i28 = i27 << (7 - i26);
                                                                if ((matroskaExtractor4.f8233l.f6793a[i24] & i28) != 0) {
                                                                    int i29 = i19 + i26;
                                                                    matroskaExtractor4.m3677k(extractorInput, i29);
                                                                    j = (~i28) & matroskaExtractor4.f8233l.f6793a[i24] & b2;
                                                                    int i30 = i24 + 1;
                                                                    while (i30 < i29) {
                                                                        j = (j << 8) | (matroskaExtractor4.f8233l.f6793a[i30] & 255);
                                                                        i30++;
                                                                        i29 = i29;
                                                                    }
                                                                    int i31 = i29;
                                                                    if (i20 > 0) {
                                                                        j -= (1 << ((i26 * 7) + 6)) - 1;
                                                                    }
                                                                    i19 = i31;
                                                                } else {
                                                                    i26++;
                                                                    i25 = 8;
                                                                    i27 = 1;
                                                                    b2 = 255;
                                                                }
                                                            } else {
                                                                j = 0;
                                                            }
                                                        }
                                                        if (j >= -2147483648L && j <= 2147483647L) {
                                                            int i32 = (int) j;
                                                            int[] iArr2 = matroskaExtractor4.f8211Q;
                                                            if (i20 != 0) {
                                                                i32 += iArr2[i20 - 1];
                                                            }
                                                            iArr2[i20] = i32;
                                                            i21 += iArr2[i20];
                                                            i20++;
                                                            r3 = 0;
                                                            i22 = 1;
                                                            b2 = 255;
                                                        }
                                                    } else {
                                                        matroskaExtractor4.f8211Q[i23 - 1] = ((i14 - matroskaExtractor4.f8213S) - i19) - i21;
                                                    }
                                                }
                                                throw ParserException.m8755a("EBML lacing sample size out of range.", null);
                                            }
                                            int i33 = 0;
                                            int i34 = 0;
                                            while (true) {
                                                int i35 = matroskaExtractor4.f8210P;
                                                if (i33 < i35 - 1) {
                                                    matroskaExtractor4.f8211Q[i33] = z5 ? 1 : 0;
                                                    do {
                                                        i19 += r4 == true ? 1 : 0;
                                                        matroskaExtractor4.m3677k(extractorInput, i19);
                                                        i3 = matroskaExtractor4.f8233l.f6793a[i19 - 1] & 255;
                                                        iArr = matroskaExtractor4.f8211Q;
                                                        iArr[i33] = iArr[i33] + i3;
                                                    } while (i3 == 255);
                                                    i34 += iArr[i33];
                                                    i33++;
                                                } else {
                                                    matroskaExtractor4.f8211Q[i35 - 1] = ((i14 - matroskaExtractor4.f8213S) - i19) - i34;
                                                }
                                            }
                                        }
                                    }
                                    byte[] bArr2 = matroskaExtractor4.f8233l.f6793a;
                                    matroskaExtractor4.f8207M = matroskaExtractor4.m3679m((bArr2[1] & 255) | (bArr2[0] << 8)) + matroskaExtractor4.f8201G;
                                    matroskaExtractor4.f8214T = (cVar.f8277d == 2 || (i13 == 163 && (matroskaExtractor4.f8233l.f6793a[2] & 128) == 128)) ? 1 : 0;
                                    matroskaExtractor4.f8206L = 2;
                                    matroskaExtractor4.f8209O = 0;
                                }
                                if (i13 == 163) {
                                    while (true) {
                                        int i36 = matroskaExtractor4.f8209O;
                                        if (i36 < matroskaExtractor4.f8210P) {
                                            matroskaExtractor4.m3675d(cVar, ((matroskaExtractor4.f8209O * cVar.f8278e) / 1000) + matroskaExtractor4.f8207M, matroskaExtractor4.f8214T, matroskaExtractor4.m3680n(extractorInput, cVar, matroskaExtractor4.f8211Q[i36]), 0);
                                            matroskaExtractor4.f8209O++;
                                        } else {
                                            matroskaExtractor4.f8206L = 0;
                                        }
                                    }
                                } else {
                                    while (true) {
                                        int i37 = matroskaExtractor4.f8209O;
                                        if (i37 < matroskaExtractor4.f8210P) {
                                            int[] iArr3 = matroskaExtractor4.f8211Q;
                                            iArr3[i37] = matroskaExtractor4.m3680n(extractorInput, cVar, iArr3[i37]);
                                            matroskaExtractor4.f8209O++;
                                        }
                                    }
                                }
                            }
                        } else if (i13 != 165) {
                            if (i13 == 16877) {
                                matroskaExtractor4.m3674c(i13);
                                c cVar2 = matroskaExtractor4.f8247z;
                                int i38 = cVar2.f8280g;
                                if (i38 == 1685485123 || i38 == 1685480259) {
                                    byte[] bArr3 = new byte[i14];
                                    cVar2.f8262N = bArr3;
                                    extractorInput.readFully(bArr3, z5 ? 1 : 0, i14);
                                } else {
                                    extractorInput.mo3650l(i14);
                                }
                            } else if (i13 == 16981) {
                                matroskaExtractor4.m3674c(i13);
                                byte[] bArr4 = new byte[i14];
                                matroskaExtractor4.f8247z.f8282i = bArr4;
                                extractorInput.readFully(bArr4, z5 ? 1 : 0, i14);
                            } else if (i13 == 18402) {
                                byte[] bArr5 = new byte[i14];
                                extractorInput.readFully(bArr5, z5 ? 1 : 0, i14);
                                matroskaExtractor4.m3674c(i13);
                                matroskaExtractor4.f8247z.f8283j = new TrackOutput2.a(r4 == true ? 1 : 0, bArr5, z5 ? 1 : 0, z5 ? 1 : 0);
                            } else if (i13 == 21419) {
                                Arrays.fill(matroskaExtractor4.f8235n.f6793a, z5 ? (byte) 1 : (byte) 0);
                                extractorInput.readFully(matroskaExtractor4.f8235n.f6793a, 4 - i14, i14);
                                matroskaExtractor4.f8235n.m3079E(z5 ? 1 : 0);
                                matroskaExtractor4.f8196B = (int) matroskaExtractor4.f8235n.m3101u();
                            } else if (i13 == 25506) {
                                matroskaExtractor4.m3674c(i13);
                                byte[] bArr6 = new byte[i14];
                                matroskaExtractor4.f8247z.f8284k = bArr6;
                                extractorInput.readFully(bArr6, z5 ? 1 : 0, i14);
                            } else {
                                if (i13 != 30322) {
                                    throw outline.m884w0(26, "Unexpected id: ", i13, null);
                                }
                                matroskaExtractor4.m3674c(i13);
                                byte[] bArr7 = new byte[i14];
                                matroskaExtractor4.f8247z.f8295v = bArr7;
                                extractorInput.readFully(bArr7, z5 ? 1 : 0, i14);
                            }
                        } else if (matroskaExtractor4.f8206L == 2) {
                            c cVar3 = matroskaExtractor4.f8229h.get(matroskaExtractor4.f8212R);
                            if (matroskaExtractor4.f8215U == 4 && "V_VP9".equals(cVar3.f8275b)) {
                                ParsableByteArray parsableByteArray = matroskaExtractor4.f8240s;
                                byte[] bArr8 = parsableByteArray.f6793a;
                                if (bArr8.length < i14) {
                                    bArr8 = new byte[i14];
                                }
                                parsableByteArray.m3077C(bArr8, i14);
                                extractorInput.readFully(matroskaExtractor4.f8240s.f6793a, z5 ? 1 : 0, i14);
                            } else {
                                extractorInput.mo3650l(i14);
                            }
                        }
                        defaultEbmlReader.f8185e = 0;
                    } else {
                        if (i != 5) {
                            throw outline.m884w0(32, "Invalid element type ", i, null);
                        }
                        long j6 = defaultEbmlReader.f8187g;
                        if (j6 != 4 && j6 != 8) {
                            StringBuilder sb4 = new StringBuilder(40);
                            sb4.append("Invalid float size: ");
                            sb4.append(j6);
                            throw ParserException.m8755a(sb4.toString(), null);
                        }
                        EbmlProcessor ebmlProcessor6 = defaultEbmlReader.f8184d;
                        int i39 = defaultEbmlReader.f8186f;
                        int i40 = (int) j6;
                        double dIntBitsToFloat = i40 == 4 ? Float.intBitsToFloat((int) r9) : Double.longBitsToDouble(defaultEbmlReader.m3670a(extractorInput, i40));
                        MatroskaExtractor matroskaExtractor5 = MatroskaExtractor.this;
                        Objects.requireNonNull(matroskaExtractor5);
                        if (i39 == 181) {
                            matroskaExtractor5.m3674c(i39);
                            matroskaExtractor5.f8247z.f8265Q = (int) dIntBitsToFloat;
                        } else if (i39 != 17545) {
                            switch (i39) {
                                case 21969:
                                    matroskaExtractor5.m3674c(i39);
                                    matroskaExtractor5.f8247z.f8252D = (float) dIntBitsToFloat;
                                    break;
                                case 21970:
                                    matroskaExtractor5.m3674c(i39);
                                    matroskaExtractor5.f8247z.f8253E = (float) dIntBitsToFloat;
                                    break;
                                case 21971:
                                    matroskaExtractor5.m3674c(i39);
                                    matroskaExtractor5.f8247z.f8254F = (float) dIntBitsToFloat;
                                    break;
                                case 21972:
                                    matroskaExtractor5.m3674c(i39);
                                    matroskaExtractor5.f8247z.f8255G = (float) dIntBitsToFloat;
                                    break;
                                case 21973:
                                    matroskaExtractor5.m3674c(i39);
                                    matroskaExtractor5.f8247z.f8256H = (float) dIntBitsToFloat;
                                    break;
                                case 21974:
                                    matroskaExtractor5.m3674c(i39);
                                    matroskaExtractor5.f8247z.f8257I = (float) dIntBitsToFloat;
                                    break;
                                case 21975:
                                    matroskaExtractor5.m3674c(i39);
                                    matroskaExtractor5.f8247z.f8258J = (float) dIntBitsToFloat;
                                    break;
                                case 21976:
                                    matroskaExtractor5.m3674c(i39);
                                    matroskaExtractor5.f8247z.f8259K = (float) dIntBitsToFloat;
                                    break;
                                case 21977:
                                    matroskaExtractor5.m3674c(i39);
                                    matroskaExtractor5.f8247z.f8260L = (float) dIntBitsToFloat;
                                    break;
                                case 21978:
                                    matroskaExtractor5.m3674c(i39);
                                    matroskaExtractor5.f8247z.f8261M = (float) dIntBitsToFloat;
                                    break;
                                default:
                                    switch (i39) {
                                        case 30323:
                                            matroskaExtractor5.m3674c(i39);
                                            matroskaExtractor5.f8247z.f8292s = (float) dIntBitsToFloat;
                                            break;
                                        case 30324:
                                            matroskaExtractor5.m3674c(i39);
                                            matroskaExtractor5.f8247z.f8293t = (float) dIntBitsToFloat;
                                            break;
                                        case 30325:
                                            matroskaExtractor5.m3674c(i39);
                                            matroskaExtractor5.f8247z.f8294u = (float) dIntBitsToFloat;
                                            break;
                                    }
                                    break;
                            }
                        } else {
                            matroskaExtractor5.f8245x = (long) dIntBitsToFloat;
                        }
                        defaultEbmlReader.f8185e = z5 ? 1 : 0;
                    }
                } else {
                    MatroskaExtractor.this.m3676h(defaultEbmlReader.f8182b.pop().f8188a);
                }
            }
        }
        if (z4) {
            return 0;
        }
        for (int i41 = 0; i41 < this.f8229h.size(); i41++) {
            c cVarValueAt = this.f8229h.valueAt(i41);
            Objects.requireNonNull(cVarValueAt.f8272X);
            TrueHdSampleRechunker trueHdSampleRechunker = cVarValueAt.f8268T;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.m3819a(cVarValueAt.f8272X, cVarValueAt.f8283j);
            }
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: f */
    public final void mo3636f(ExtractorOutput extractorOutput) {
        this.f8227f0 = extractorOutput;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    @CallSuper
    /* renamed from: g */
    public void mo3637g(long j, long j2) {
        this.f8201G = -9223372036854775807L;
        this.f8206L = 0;
        DefaultEbmlReader defaultEbmlReader = (DefaultEbmlReader) this.f8226f;
        defaultEbmlReader.f8185e = 0;
        defaultEbmlReader.f8182b.clear();
        VarintReader varintReader = defaultEbmlReader.f8183c;
        varintReader.f8304c = 0;
        varintReader.f8305d = 0;
        VarintReader varintReader2 = this.f8228g;
        varintReader2.f8304c = 0;
        varintReader2.f8305d = 0;
        m3678l();
        for (int i = 0; i < this.f8229h.size(); i++) {
            TrueHdSampleRechunker trueHdSampleRechunker = this.f8229h.valueAt(i).f8268T;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.f9005b = false;
                trueHdSampleRechunker.f9006c = 0;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:210:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x080e  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x083c  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0866  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x087d  */
    /* JADX WARN: Removed duplicated region for block: B:500:0x087f  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x088c  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x0899  */
    /* JADX WARN: Removed duplicated region for block: B:553:0x09c6  */
    /* JADX WARN: Removed duplicated region for block: B:575:0x0a19  */
    /* JADX WARN: Removed duplicated region for block: B:593:0x0a69  */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v9, types: [b.i.a.c.x2.g0.e$c, java.lang.Object] */
    @CallSuper
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m3676h(int i) throws ParserException {
        boolean z2;
        char c2;
        boolean z3;
        int iM3010r;
        List<byte[]> listSingletonList;
        int i2;
        List<byte[]> list;
        String str;
        String str2;
        String str3;
        ArrayList arrayList;
        Pair pair;
        Pair pair2;
        String str4;
        List<byte[]> list2;
        String str5;
        String str6;
        String str7;
        int i3;
        String str8;
        List<byte[]> list3;
        List<byte[]> list4;
        List<byte[]> listM6266u;
        byte[] bArr;
        Format2.b bVar;
        int i4;
        int i5;
        ColorInfo colorInfo;
        int i6;
        byte[] bArr2;
        int i7;
        String str9;
        DolbyVisionConfig dolbyVisionConfigM3126a;
        List<byte[]> list5;
        List<byte[]> list6;
        SeekMap bVar2;
        int i8;
        int i9;
        AnimatableValueParser.m438H(this.f8227f0);
        int i10 = 0;
        if (i == 160) {
            if (this.f8206L != 2) {
                return;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.f8210P; i12++) {
                i11 += this.f8211Q[i12];
            }
            c cVar = this.f8229h.get(this.f8212R);
            Objects.requireNonNull(cVar.f8272X);
            int i13 = 0;
            while (i13 < this.f8210P) {
                long j = this.f8207M + ((cVar.f8278e * i13) / 1000);
                int i14 = this.f8214T;
                if (i13 == 0 && !this.f8216V) {
                    i14 |= 1;
                }
                int i15 = this.f8211Q[i13];
                int i16 = i11 - i15;
                m3675d(cVar, j, i14, i15, i16);
                i13++;
                i11 = i16;
            }
            this.f8206L = 0;
            return;
        }
        if (i != 174) {
            if (i == 19899) {
                int i17 = this.f8196B;
                if (i17 != -1) {
                    long j2 = this.f8197C;
                    if (j2 != -1) {
                        if (i17 == 475249515) {
                            this.f8199E = j2;
                            return;
                        }
                        return;
                    }
                }
                throw ParserException.m8755a("Mandatory element SeekID or SeekPosition not found", null);
            }
            if (i == 25152) {
                m3674c(i);
                c cVar2 = this.f8247z;
                if (cVar2.f8281h) {
                    TrackOutput2.a aVar = cVar2.f8283j;
                    if (aVar == null) {
                        throw ParserException.m8755a("Encrypted Track found but ContentEncKeyID was not found", null);
                    }
                    cVar2.f8285l = new DrmInitData(null, true, new DrmInitData.SchemeData(C.f8021a, "video/webm", aVar.f9001b));
                    return;
                }
                return;
            }
            if (i == 28032) {
                m3674c(i);
                c cVar3 = this.f8247z;
                if (cVar3.f8281h && cVar3.f8282i != null) {
                    throw ParserException.m8755a("Combining encryption and compression is not supported", null);
                }
                return;
            }
            if (i == 357149030) {
                if (this.f8244w == -9223372036854775807L) {
                    this.f8244w = 1000000L;
                }
                long j3 = this.f8245x;
                if (j3 != -9223372036854775807L) {
                    this.f8246y = m3679m(j3);
                    return;
                }
                return;
            }
            if (i == 374648427) {
                if (this.f8229h.size() == 0) {
                    throw ParserException.m8755a("No valid tracks were found", null);
                }
                this.f8227f0.mo2486j();
                return;
            }
            if (i != 475249515) {
                return;
            }
            if (!this.f8195A) {
                ExtractorOutput extractorOutput = this.f8227f0;
                LongArray longArray = this.f8202H;
                LongArray longArray2 = this.f8203I;
                if (this.f8243v == -1 || this.f8246y == -9223372036854775807L || longArray == null || (i8 = longArray.f6747a) == 0 || longArray2 == null || longArray2.f6747a != i8) {
                    bVar2 = new SeekMap.b(this.f8246y, 0L);
                } else {
                    int[] iArrCopyOf = new int[i8];
                    long[] jArrCopyOf = new long[i8];
                    long[] jArrCopyOf2 = new long[i8];
                    long[] jArrCopyOf3 = new long[i8];
                    for (int i18 = 0; i18 < i8; i18++) {
                        jArrCopyOf3[i18] = longArray.m3042b(i18);
                        jArrCopyOf[i18] = longArray2.m3042b(i18) + this.f8243v;
                    }
                    while (true) {
                        i9 = i8 - 1;
                        if (i10 >= i9) {
                            break;
                        }
                        int i19 = i10 + 1;
                        iArrCopyOf[i10] = (int) (jArrCopyOf[i19] - jArrCopyOf[i10]);
                        jArrCopyOf2[i10] = jArrCopyOf3[i19] - jArrCopyOf3[i10];
                        i10 = i19;
                    }
                    iArrCopyOf[i9] = (int) ((this.f8243v + this.f8242u) - jArrCopyOf[i9]);
                    jArrCopyOf2[i9] = this.f8246y - jArrCopyOf3[i9];
                    long j4 = jArrCopyOf2[i9];
                    if (j4 <= 0) {
                        StringBuilder sb = new StringBuilder(72);
                        sb.append("Discarding last cue point with unexpected duration: ");
                        sb.append(j4);
                        Log.w("MatroskaExtractor", sb.toString());
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i9);
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i9);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i9);
                        jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i9);
                    }
                    bVar2 = new ChunkIndex(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
                }
                extractorOutput.mo2477a(bVar2);
                this.f8195A = true;
            }
            this.f8202H = null;
            this.f8203I = null;
            return;
        }
        ?? r0 = this.f8247z;
        AnimatableValueParser.m438H(r0);
        String str10 = r0.f8275b;
        if (str10 == null) {
            throw ParserException.m8755a("CodecId is missing in TrackEntry element", null);
        }
        switch (str10) {
            case "V_MPEG4/ISO/AP":
            case "V_MPEG4/ISO/SP":
            case "A_MS/ACM":
            case "A_TRUEHD":
            case "A_VORBIS":
            case "A_MPEG/L2":
            case "A_MPEG/L3":
            case "V_MS/VFW/FOURCC":
            case "S_DVBSUB":
            case "V_MPEG4/ISO/ASP":
            case "V_MPEG4/ISO/AVC":
            case "S_VOBSUB":
            case "A_DTS/LOSSLESS":
            case "A_AAC":
            case "A_AC3":
            case "A_DTS":
            case "V_AV1":
            case "V_VP8":
            case "V_VP9":
            case "S_HDMV/PGS":
            case "V_THEORA":
            case "A_DTS/EXPRESS":
            case "A_PCM/FLOAT/IEEE":
            case "A_PCM/INT/BIG":
            case "A_PCM/INT/LIT":
            case "S_TEXT/ASS":
            case "V_MPEGH/ISO/HEVC":
            case "S_TEXT/UTF8":
            case "V_MPEG2":
            case "A_EAC3":
            case "A_FLAC":
            case "A_OPUS":
                z2 = true;
                break;
            default:
                z2 = false;
                break;
        }
        if (z2) {
            ExtractorOutput extractorOutput2 = this.f8227f0;
            int i20 = r0.f8276c;
            String str11 = r0.f8275b;
            str11.hashCode();
            switch (str11.hashCode()) {
                case -2095576542:
                    c2 = str11.equals("V_MPEG4/ISO/AP") ? (char) 0 : (char) 65535;
                    break;
                case -2095575984:
                    if (str11.equals("V_MPEG4/ISO/SP")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1985379776:
                    if (str11.equals("A_MS/ACM")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1784763192:
                    if (str11.equals("A_TRUEHD")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1730367663:
                    if (str11.equals("A_VORBIS")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1482641358:
                    if (str11.equals("A_MPEG/L2")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1482641357:
                    if (str11.equals("A_MPEG/L3")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -1373388978:
                    if (str11.equals("V_MS/VFW/FOURCC")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -933872740:
                    if (str11.equals("S_DVBSUB")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -538363189:
                    if (str11.equals("V_MPEG4/ISO/ASP")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case -538363109:
                    if (str11.equals("V_MPEG4/ISO/AVC")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case -425012669:
                    if (str11.equals("S_VOBSUB")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case -356037306:
                    if (str11.equals("A_DTS/LOSSLESS")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case 62923557:
                    if (str11.equals("A_AAC")) {
                        c2 = '\r';
                        break;
                    }
                    break;
                case 62923603:
                    if (str11.equals("A_AC3")) {
                        c2 = 14;
                        break;
                    }
                    break;
                case 62927045:
                    if (str11.equals("A_DTS")) {
                        c2 = 15;
                        break;
                    }
                    break;
                case 82318131:
                    if (str11.equals("V_AV1")) {
                        c2 = 16;
                        break;
                    }
                    break;
                case 82338133:
                    if (str11.equals("V_VP8")) {
                        c2 = 17;
                        break;
                    }
                    break;
                case 82338134:
                    if (str11.equals("V_VP9")) {
                        c2 = 18;
                        break;
                    }
                    break;
                case 99146302:
                    if (str11.equals("S_HDMV/PGS")) {
                        c2 = 19;
                        break;
                    }
                    break;
                case 444813526:
                    if (str11.equals("V_THEORA")) {
                        c2 = 20;
                        break;
                    }
                    break;
                case 542569478:
                    if (str11.equals("A_DTS/EXPRESS")) {
                        c2 = 21;
                        break;
                    }
                    break;
                case 635596514:
                    if (str11.equals("A_PCM/FLOAT/IEEE")) {
                        c2 = 22;
                        break;
                    }
                    break;
                case 725948237:
                    if (str11.equals("A_PCM/INT/BIG")) {
                        c2 = 23;
                        break;
                    }
                    break;
                case 725957860:
                    if (str11.equals("A_PCM/INT/LIT")) {
                        c2 = 24;
                        break;
                    }
                    break;
                case 738597099:
                    if (str11.equals("S_TEXT/ASS")) {
                        c2 = 25;
                        break;
                    }
                    break;
                case 855502857:
                    if (str11.equals("V_MPEGH/ISO/HEVC")) {
                        c2 = 26;
                        break;
                    }
                    break;
                case 1422270023:
                    if (str11.equals("S_TEXT/UTF8")) {
                        c2 = 27;
                        break;
                    }
                    break;
                case 1809237540:
                    if (str11.equals("V_MPEG2")) {
                        c2 = 28;
                        break;
                    }
                    break;
                case 1950749482:
                    if (str11.equals("A_EAC3")) {
                        c2 = 29;
                        break;
                    }
                    break;
                case 1950789798:
                    if (str11.equals("A_FLAC")) {
                        c2 = 30;
                        break;
                    }
                    break;
                case 1951062397:
                    if (str11.equals("A_OPUS")) {
                        c2 = 31;
                        break;
                    }
                    break;
            }
            String str12 = "video/x-unknown";
            String str13 = "audio/x-unknown";
            switch (c2) {
                case 0:
                case 1:
                case '\t':
                    byte[] bArr3 = r0.f8284k;
                    str13 = "video/mp4v-es";
                    listSingletonList = bArr3 == null ? null : Collections.singletonList(bArr3);
                    i2 = -1;
                    list = listSingletonList;
                    str = null;
                    list5 = list;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null && (dolbyVisionConfigM3126a = DolbyVisionConfig.m3126a(new ParsableByteArray(bArr))) != null) {
                        str8 = dolbyVisionConfigM3126a.f6849a;
                        str13 = "video/dolby-vision";
                    }
                    int i21 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                        bVar.f7186x = r0.f8263O;
                        bVar.f7187y = r0.f8265Q;
                        bVar.f7188z = iM3010r;
                        i4 = 1;
                    } else if (MimeTypes.m3052j(str13)) {
                        if (r0.f8290q == 0) {
                            int i22 = r0.f8288o;
                            i5 = -1;
                            if (i22 == -1) {
                                i22 = r0.f8286m;
                            }
                            r0.f8288o = i22;
                            int i23 = r0.f8289p;
                            if (i23 == -1) {
                                i23 = r0.f8287n;
                            }
                            r0.f8289p = i23;
                        } else {
                            i5 = -1;
                        }
                        float f = -1.0f;
                        if (r0.f8288o != i5 && (i7 = r0.f8289p) != i5) {
                            f = (r0.f8287n * r8) / (r0.f8286m * i7);
                        }
                        if (r0.f8297x) {
                            if (r0.f8252D == -1.0f || r0.f8253E == -1.0f || r0.f8254F == -1.0f || r0.f8255G == -1.0f || r0.f8256H == -1.0f || r0.f8257I == -1.0f || r0.f8258J == -1.0f || r0.f8259K == -1.0f || r0.f8260L == -1.0f || r0.f8261M == -1.0f) {
                                bArr2 = null;
                            } else {
                                bArr2 = new byte[25];
                                ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder.put((byte) 0);
                                byteBufferOrder.putShort((short) ((r0.f8252D * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.f8253E * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.f8254F * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.f8255G * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.f8256H * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.f8257I * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.f8258J * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) ((r0.f8259K * 50000.0f) + 0.5f));
                                byteBufferOrder.putShort((short) (r0.f8260L + 0.5f));
                                byteBufferOrder.putShort((short) (r0.f8261M + 0.5f));
                                byteBufferOrder.putShort((short) r0.f8250B);
                                byteBufferOrder.putShort((short) r0.f8251C);
                            }
                            colorInfo = new ColorInfo(r0.f8298y, r0.f8249A, r0.f8299z, bArr2);
                        } else {
                            colorInfo = null;
                        }
                        String str14 = r0.f8274a;
                        if (str14 != null) {
                            Map<String, Integer> map = f8194e;
                            int iIntValue = map.containsKey(str14) ? map.get(r0.f8274a).intValue() : -1;
                            if (r0.f8291r == 0 && Float.compare(r0.f8292s, 0.0f) == 0 && Float.compare(r0.f8293t, 0.0f) == 0) {
                                if (Float.compare(r0.f8294u, 0.0f) == 0) {
                                    i6 = 0;
                                } else if (Float.compare(r0.f8293t, 90.0f) == 0) {
                                    i6 = 90;
                                } else if (Float.compare(r0.f8293t, -180.0f) == 0 || Float.compare(r0.f8293t, 180.0f) == 0) {
                                    i6 = 180;
                                } else if (Float.compare(r0.f8293t, -90.0f) == 0) {
                                    i6 = 270;
                                }
                                bVar.f7178p = r0.f8286m;
                                bVar.f7179q = r0.f8287n;
                                bVar.f7182t = f;
                                bVar.f7181s = i6;
                                bVar.f7183u = r0.f8295v;
                                bVar.f7184v = r0.f8296w;
                                bVar.f7185w = colorInfo;
                                i4 = 2;
                            } else {
                                i6 = iIntValue;
                                bVar.f7178p = r0.f8286m;
                                bVar.f7179q = r0.f8287n;
                                bVar.f7182t = f;
                                bVar.f7181s = i6;
                                bVar.f7183u = r0.f8295v;
                                bVar.f7184v = r0.f8296w;
                                bVar.f7185w = colorInfo;
                                i4 = 2;
                            }
                        }
                    } else {
                        if (!"application/x-subrip".equals(str13) && !"text/x-ssa".equals(str13) && !"application/vobsub".equals(str13) && !"application/pgs".equals(str13) && !"application/dvbsubs".equals(str13)) {
                            throw ParserException.m8755a("Unexpected MIME type.", null);
                        }
                        i4 = 3;
                    }
                    str9 = r0.f8274a;
                    if (str9 != null && !f8194e.containsKey(str9)) {
                        bVar.f7164b = r0.f8274a;
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i21;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p;
                    trackOutput2Mo2492p.mo2526e(format2M3277a);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 2:
                    ParsableByteArray parsableByteArray = new ParsableByteArray(r0.m3683a(r0.f8275b));
                    try {
                        int iM3092l = parsableByteArray.m3092l();
                        if (iM3092l != 1) {
                            if (iM3092l == 65534) {
                                parsableByteArray.m3079E(24);
                                long jM3093m = parsableByteArray.m3093m();
                                UUID uuid = f8193d;
                                if (jM3093m == uuid.getMostSignificantBits()) {
                                    if (parsableByteArray.m3093m() == uuid.getLeastSignificantBits()) {
                                    }
                                    if (z3) {
                                        iM3010r = Util2.m3010r(r0.f8264P);
                                        if (iM3010r == 0) {
                                            int i24 = r0.f8264P;
                                            StringBuilder sb2 = new StringBuilder(75);
                                            sb2.append("Unsupported PCM bit depth: ");
                                            sb2.append(i24);
                                            sb2.append(". Setting mimeType to ");
                                            sb2.append("audio/x-unknown");
                                            Log.w("MatroskaExtractor", sb2.toString());
                                        }
                                        str13 = "audio/raw";
                                        list2 = null;
                                        i3 = -1;
                                        str8 = null;
                                        bArr = r0.f8262N;
                                        if (bArr != null) {
                                            str8 = dolbyVisionConfigM3126a.f6849a;
                                            str13 = "video/dolby-vision";
                                        }
                                        int i212 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                                        bVar = new Format2.b();
                                        if (MimeTypes.m3050h(str13)) {
                                        }
                                        str9 = r0.f8274a;
                                        if (str9 != null) {
                                            bVar.f7164b = r0.f8274a;
                                        }
                                        bVar.m3278b(i20);
                                        bVar.f7173k = str13;
                                        bVar.f7174l = i3;
                                        bVar.f7165c = r0.f8271W;
                                        bVar.f7166d = i212;
                                        bVar.f7175m = list2;
                                        bVar.f7170h = str8;
                                        bVar.f7176n = r0.f8285l;
                                        Format2 format2M3277a2 = bVar.m3277a();
                                        TrackOutput2 trackOutput2Mo2492p2 = extractorOutput2.mo2492p(r0.f8276c, i4);
                                        r0.f8272X = trackOutput2Mo2492p2;
                                        trackOutput2Mo2492p2.mo2526e(format2M3277a2);
                                        this.f8229h.put(r0.f8276c, r0);
                                    } else {
                                        Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat("audio/x-unknown"));
                                    }
                                    listSingletonList = null;
                                    i2 = -1;
                                    list = listSingletonList;
                                    str = null;
                                    list5 = list;
                                    str8 = str;
                                    i3 = i2;
                                    list2 = list5;
                                    iM3010r = -1;
                                    bArr = r0.f8262N;
                                    if (bArr != null) {
                                    }
                                    int i2122 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                                    bVar = new Format2.b();
                                    if (MimeTypes.m3050h(str13)) {
                                    }
                                    str9 = r0.f8274a;
                                    if (str9 != null) {
                                    }
                                    bVar.m3278b(i20);
                                    bVar.f7173k = str13;
                                    bVar.f7174l = i3;
                                    bVar.f7165c = r0.f8271W;
                                    bVar.f7166d = i2122;
                                    bVar.f7175m = list2;
                                    bVar.f7170h = str8;
                                    bVar.f7176n = r0.f8285l;
                                    Format2 format2M3277a22 = bVar.m3277a();
                                    TrackOutput2 trackOutput2Mo2492p22 = extractorOutput2.mo2492p(r0.f8276c, i4);
                                    r0.f8272X = trackOutput2Mo2492p22;
                                    trackOutput2Mo2492p22.mo2526e(format2M3277a22);
                                    this.f8229h.put(r0.f8276c, r0);
                                }
                            }
                            z3 = false;
                            if (z3) {
                            }
                            listSingletonList = null;
                            i2 = -1;
                            list = listSingletonList;
                            str = null;
                            list5 = list;
                            str8 = str;
                            i3 = i2;
                            list2 = list5;
                            iM3010r = -1;
                            bArr = r0.f8262N;
                            if (bArr != null) {
                            }
                            int i21222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                            bVar = new Format2.b();
                            if (MimeTypes.m3050h(str13)) {
                            }
                            str9 = r0.f8274a;
                            if (str9 != null) {
                            }
                            bVar.m3278b(i20);
                            bVar.f7173k = str13;
                            bVar.f7174l = i3;
                            bVar.f7165c = r0.f8271W;
                            bVar.f7166d = i21222;
                            bVar.f7175m = list2;
                            bVar.f7170h = str8;
                            bVar.f7176n = r0.f8285l;
                            Format2 format2M3277a222 = bVar.m3277a();
                            TrackOutput2 trackOutput2Mo2492p222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                            r0.f8272X = trackOutput2Mo2492p222;
                            trackOutput2Mo2492p222.mo2526e(format2M3277a222);
                            this.f8229h.put(r0.f8276c, r0);
                            break;
                        }
                        z3 = true;
                        if (z3) {
                        }
                        listSingletonList = null;
                        i2 = -1;
                        list = listSingletonList;
                        str = null;
                        list5 = list;
                        str8 = str;
                        i3 = i2;
                        list2 = list5;
                        iM3010r = -1;
                        bArr = r0.f8262N;
                        if (bArr != null) {
                        }
                        int i212222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                        bVar = new Format2.b();
                        if (MimeTypes.m3050h(str13)) {
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                        }
                        bVar.m3278b(i20);
                        bVar.f7173k = str13;
                        bVar.f7174l = i3;
                        bVar.f7165c = r0.f8271W;
                        bVar.f7166d = i212222;
                        bVar.f7175m = list2;
                        bVar.f7170h = str8;
                        bVar.f7176n = r0.f8285l;
                        Format2 format2M3277a2222 = bVar.m3277a();
                        TrackOutput2 trackOutput2Mo2492p2222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                        r0.f8272X = trackOutput2Mo2492p2222;
                        trackOutput2Mo2492p2222.mo2526e(format2M3277a2222);
                        this.f8229h.put(r0.f8276c, r0);
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw ParserException.m8755a("Error parsing MS/ACM codec private", null);
                    }
                    break;
                case 3:
                    r0.f8268T = new TrueHdSampleRechunker();
                    str13 = "audio/true-hd";
                    listSingletonList = null;
                    i2 = -1;
                    list = listSingletonList;
                    str = null;
                    list5 = list;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i2122222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i2122222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a22222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p22222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p22222;
                    trackOutput2Mo2492p22222.mo2526e(format2M3277a22222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 4:
                    byte[] bArrM3683a = r0.m3683a(r0.f8275b);
                    try {
                        try {
                            if (bArrM3683a[0] != 2) {
                                throw ParserException.m8755a("Error parsing vorbis codec private", null);
                            }
                            int i25 = 1;
                            int i26 = 0;
                            while ((bArrM3683a[i25] & 255) == 255) {
                                i26 += 255;
                                i25++;
                            }
                            int i27 = i25 + 1;
                            int i28 = i26 + (bArrM3683a[i25] & 255);
                            int i29 = 0;
                            while ((bArrM3683a[i27] & 255) == 255) {
                                i29 += 255;
                                i27++;
                            }
                            int i30 = i27 + 1;
                            int i31 = i29 + (bArrM3683a[i27] & 255);
                            if (bArrM3683a[i30] != 1) {
                                throw ParserException.m8755a("Error parsing vorbis codec private", null);
                            }
                            byte[] bArr4 = new byte[i28];
                            System.arraycopy(bArrM3683a, i30, bArr4, 0, i28);
                            int i32 = i30 + i28;
                            if (bArrM3683a[i32] != 3) {
                                throw ParserException.m8755a("Error parsing vorbis codec private", null);
                            }
                            int i33 = i32 + i31;
                            if (bArrM3683a[i33] != 5) {
                                throw ParserException.m8755a("Error parsing vorbis codec private", null);
                            }
                            byte[] bArr5 = new byte[bArrM3683a.length - i33];
                            System.arraycopy(bArrM3683a, i33, bArr5, 0, bArrM3683a.length - i33);
                            ArrayList arrayList2 = new ArrayList(2);
                            arrayList2.add(bArr4);
                            arrayList2.add(bArr5);
                            i2 = 8192;
                            str13 = "audio/vorbis";
                            list = arrayList2;
                            str = null;
                            list5 = list;
                            str8 = str;
                            i3 = i2;
                            list2 = list5;
                            iM3010r = -1;
                            bArr = r0.f8262N;
                            if (bArr != null) {
                            }
                            int i21222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                            bVar = new Format2.b();
                            if (MimeTypes.m3050h(str13)) {
                            }
                            str9 = r0.f8274a;
                            if (str9 != null) {
                            }
                            bVar.m3278b(i20);
                            bVar.f7173k = str13;
                            bVar.f7174l = i3;
                            bVar.f7165c = r0.f8271W;
                            bVar.f7166d = i21222222;
                            bVar.f7175m = list2;
                            bVar.f7170h = str8;
                            bVar.f7176n = r0.f8285l;
                            Format2 format2M3277a222222 = bVar.m3277a();
                            TrackOutput2 trackOutput2Mo2492p222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                            r0.f8272X = trackOutput2Mo2492p222222;
                            trackOutput2Mo2492p222222.mo2526e(format2M3277a222222);
                            this.f8229h.put(r0.f8276c, r0);
                        } catch (ArrayIndexOutOfBoundsException unused2) {
                            throw ParserException.m8755a("Error parsing vorbis codec private", r0);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused3) {
                        r0 = 0;
                    }
                    break;
                case 5:
                    str2 = "audio/mpeg-L2";
                    str3 = str2;
                    i2 = 4096;
                    arrayList = null;
                    str = null;
                    list6 = arrayList;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i212222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i212222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a2222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p2222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p2222222;
                    trackOutput2Mo2492p2222222.mo2526e(format2M3277a2222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 6:
                    str2 = "audio/mpeg";
                    str3 = str2;
                    i2 = 4096;
                    arrayList = null;
                    str = null;
                    list6 = arrayList;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i2122222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i2122222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a22222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p22222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p22222222;
                    trackOutput2Mo2492p22222222.mo2526e(format2M3277a22222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 7:
                    byte[] bArrM3683a2 = r0.m3683a(r0.f8275b);
                    try {
                        AnimatableValueParser.m531j(16 <= bArrM3683a2.length);
                        long j5 = (bArrM3683a2[16] & 255) | ((bArrM3683a2[17] & 255) << 8) | ((bArrM3683a2[18] & 255) << 16) | ((255 & bArrM3683a2[19]) << 24);
                        if (j5 == 1482049860) {
                            pair2 = new Pair("video/divx", null);
                        } else if (j5 == 859189832) {
                            pair2 = new Pair("video/3gpp", null);
                        } else {
                            if (j5 == 826496599) {
                                for (int i34 = 40; i34 < bArrM3683a2.length - 4; i34++) {
                                    if (bArrM3683a2[i34] == 0 && bArrM3683a2[i34 + 1] == 0 && bArrM3683a2[i34 + 2] == 1) {
                                        if (bArrM3683a2[i34 + 3] == 15) {
                                            pair = new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrM3683a2, i34, bArrM3683a2.length)));
                                        }
                                    }
                                }
                                throw ParserException.m8755a("Failed to find FourCC VC1 initialization data", null);
                            }
                            Log.w("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                            pair = new Pair("video/x-unknown", null);
                            pair2 = pair;
                        }
                        str4 = (String) pair2.first;
                        listM6266u = (List) pair2.second;
                        str3 = str4;
                        list3 = listM6266u;
                        str7 = null;
                        list4 = list3;
                        str = str7;
                        i2 = -1;
                        list6 = list4;
                        str13 = str3;
                        list5 = list6;
                        str8 = str;
                        i3 = i2;
                        list2 = list5;
                        iM3010r = -1;
                        bArr = r0.f8262N;
                        if (bArr != null) {
                        }
                        int i21222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                        bVar = new Format2.b();
                        if (MimeTypes.m3050h(str13)) {
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                        }
                        bVar.m3278b(i20);
                        bVar.f7173k = str13;
                        bVar.f7174l = i3;
                        bVar.f7165c = r0.f8271W;
                        bVar.f7166d = i21222222222;
                        bVar.f7175m = list2;
                        bVar.f7170h = str8;
                        bVar.f7176n = r0.f8285l;
                        Format2 format2M3277a222222222 = bVar.m3277a();
                        TrackOutput2 trackOutput2Mo2492p222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                        r0.f8272X = trackOutput2Mo2492p222222222;
                        trackOutput2Mo2492p222222222.mo2526e(format2M3277a222222222);
                        this.f8229h.put(r0.f8276c, r0);
                    } catch (ArrayIndexOutOfBoundsException unused4) {
                        throw ParserException.m8755a("Error parsing FourCC private data", null);
                    }
                    break;
                case '\b':
                    byte[] bArr6 = new byte[4];
                    System.arraycopy(r0.m3683a(r0.f8275b), 0, bArr6, 0, 4);
                    ImmutableList2 immutableList2M6266u = ImmutableList2.m6266u(bArr6);
                    str4 = "application/dvbsubs";
                    listM6266u = immutableList2M6266u;
                    str3 = str4;
                    list3 = listM6266u;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i212222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i212222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a2222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p2222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p2222222222;
                    trackOutput2Mo2492p2222222222.mo2526e(format2M3277a2222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case '\n':
                    AvcConfig avcConfigM3122b = AvcConfig.m3122b(new ParsableByteArray(r0.m3683a(r0.f8275b)));
                    list2 = avcConfigM3122b.f6837a;
                    r0.f8273Y = avcConfigM3122b.f6838b;
                    str5 = avcConfigM3122b.f6842f;
                    str6 = "video/avc";
                    str8 = str5;
                    str13 = str6;
                    iM3010r = -1;
                    i3 = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i2122222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i2122222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a22222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p22222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p22222222222;
                    trackOutput2Mo2492p22222222222.mo2526e(format2M3277a22222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 11:
                    str4 = "application/vobsub";
                    listM6266u = ImmutableList2.m6266u(r0.m3683a(r0.f8275b));
                    str3 = str4;
                    list3 = listM6266u;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i21222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i21222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p222222222222;
                    trackOutput2Mo2492p222222222222.mo2526e(format2M3277a222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case '\f':
                    str12 = "audio/vnd.dts.hd";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i212222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i212222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a2222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p2222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p2222222222222;
                    trackOutput2Mo2492p2222222222222.mo2526e(format2M3277a2222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case '\r':
                    List<byte[]> listSingletonList2 = Collections.singletonList(r0.m3683a(r0.f8275b));
                    AacUtil.b bVarM3490c = AacUtil.m3490c(r0.f8284k);
                    r0.f8265Q = bVarM3490c.f7766a;
                    r0.f8263O = bVarM3490c.f7767b;
                    str7 = bVarM3490c.f7768c;
                    str3 = "audio/mp4a-latm";
                    list4 = listSingletonList2;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i2122222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i2122222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a22222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p22222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p22222222222222;
                    trackOutput2Mo2492p22222222222222.mo2526e(format2M3277a22222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 14:
                    str12 = "audio/ac3";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i21222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i21222222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a222222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p222222222222222;
                    trackOutput2Mo2492p222222222222222.mo2526e(format2M3277a222222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 15:
                case 21:
                    str12 = "audio/vnd.dts";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i212222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i212222222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a2222222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p2222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p2222222222222222;
                    trackOutput2Mo2492p2222222222222222.mo2526e(format2M3277a2222222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 16:
                    str12 = "video/av01";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i2122222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i2122222222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a22222222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p22222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p22222222222222222;
                    trackOutput2Mo2492p22222222222222222.mo2526e(format2M3277a22222222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 17:
                    str12 = "video/x-vnd.on2.vp8";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i21222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i21222222222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a222222222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p222222222222222222;
                    trackOutput2Mo2492p222222222222222222.mo2526e(format2M3277a222222222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 18:
                    str12 = "video/x-vnd.on2.vp9";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i212222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i212222222222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a2222222222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p2222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p2222222222222222222;
                    trackOutput2Mo2492p2222222222222222222.mo2526e(format2M3277a2222222222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 19:
                    str12 = "application/pgs";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i2122222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i2122222222222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a22222222222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p22222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p22222222222222222222;
                    trackOutput2Mo2492p22222222222222222222.mo2526e(format2M3277a22222222222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 20:
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i21222222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i21222222222222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a222222222222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p222222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p222222222222222222222;
                    trackOutput2Mo2492p222222222222222222222.mo2526e(format2M3277a222222222222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 22:
                    int i35 = r0.f8264P;
                    if (i35 == 32) {
                        iM3010r = 4;
                        str13 = "audio/raw";
                        list2 = null;
                        i3 = -1;
                        str8 = null;
                        bArr = r0.f8262N;
                        if (bArr != null) {
                        }
                        int i212222222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                        bVar = new Format2.b();
                        if (MimeTypes.m3050h(str13)) {
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                        }
                        bVar.m3278b(i20);
                        bVar.f7173k = str13;
                        bVar.f7174l = i3;
                        bVar.f7165c = r0.f8271W;
                        bVar.f7166d = i212222222222222222222222;
                        bVar.f7175m = list2;
                        bVar.f7170h = str8;
                        bVar.f7176n = r0.f8285l;
                        Format2 format2M3277a2222222222222222222222 = bVar.m3277a();
                        TrackOutput2 trackOutput2Mo2492p2222222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                        r0.f8272X = trackOutput2Mo2492p2222222222222222222222;
                        trackOutput2Mo2492p2222222222222222222222.mo2526e(format2M3277a2222222222222222222222);
                        this.f8229h.put(r0.f8276c, r0);
                    } else {
                        StringBuilder sb3 = new StringBuilder(90);
                        sb3.append("Unsupported floating point PCM bit depth: ");
                        sb3.append(i35);
                        sb3.append(". Setting mimeType to ");
                        sb3.append("audio/x-unknown");
                        Log.w("MatroskaExtractor", sb3.toString());
                        str3 = str13;
                        list3 = null;
                        str7 = null;
                        list4 = list3;
                        str = str7;
                        i2 = -1;
                        list6 = list4;
                        str13 = str3;
                        list5 = list6;
                        str8 = str;
                        i3 = i2;
                        list2 = list5;
                        iM3010r = -1;
                        bArr = r0.f8262N;
                        if (bArr != null) {
                        }
                        int i2122222222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                        bVar = new Format2.b();
                        if (MimeTypes.m3050h(str13)) {
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                        }
                        bVar.m3278b(i20);
                        bVar.f7173k = str13;
                        bVar.f7174l = i3;
                        bVar.f7165c = r0.f8271W;
                        bVar.f7166d = i2122222222222222222222222;
                        bVar.f7175m = list2;
                        bVar.f7170h = str8;
                        bVar.f7176n = r0.f8285l;
                        Format2 format2M3277a22222222222222222222222 = bVar.m3277a();
                        TrackOutput2 trackOutput2Mo2492p22222222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                        r0.f8272X = trackOutput2Mo2492p22222222222222222222222;
                        trackOutput2Mo2492p22222222222222222222222.mo2526e(format2M3277a22222222222222222222222);
                        this.f8229h.put(r0.f8276c, r0);
                    }
                    break;
                case 23:
                    int i36 = r0.f8264P;
                    if (i36 == 8) {
                        iM3010r = 3;
                    } else if (i36 != 16) {
                        StringBuilder sb4 = new StringBuilder(86);
                        sb4.append("Unsupported big endian PCM bit depth: ");
                        sb4.append(i36);
                        sb4.append(". Setting mimeType to ");
                        sb4.append("audio/x-unknown");
                        Log.w("MatroskaExtractor", sb4.toString());
                        str3 = str13;
                        list3 = null;
                        str7 = null;
                        list4 = list3;
                        str = str7;
                        i2 = -1;
                        list6 = list4;
                        str13 = str3;
                        list5 = list6;
                        str8 = str;
                        i3 = i2;
                        list2 = list5;
                        iM3010r = -1;
                        bArr = r0.f8262N;
                        if (bArr != null) {
                        }
                        int i21222222222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                        bVar = new Format2.b();
                        if (MimeTypes.m3050h(str13)) {
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                        }
                        bVar.m3278b(i20);
                        bVar.f7173k = str13;
                        bVar.f7174l = i3;
                        bVar.f7165c = r0.f8271W;
                        bVar.f7166d = i21222222222222222222222222;
                        bVar.f7175m = list2;
                        bVar.f7170h = str8;
                        bVar.f7176n = r0.f8285l;
                        Format2 format2M3277a222222222222222222222222 = bVar.m3277a();
                        TrackOutput2 trackOutput2Mo2492p222222222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                        r0.f8272X = trackOutput2Mo2492p222222222222222222222222;
                        trackOutput2Mo2492p222222222222222222222222.mo2526e(format2M3277a222222222222222222222222);
                        this.f8229h.put(r0.f8276c, r0);
                    } else {
                        iM3010r = 268435456;
                    }
                    str13 = "audio/raw";
                    list2 = null;
                    i3 = -1;
                    str8 = null;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i212222222222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i212222222222222222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a2222222222222222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p2222222222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p2222222222222222222222222;
                    trackOutput2Mo2492p2222222222222222222222222.mo2526e(format2M3277a2222222222222222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 24:
                    iM3010r = Util2.m3010r(r0.f8264P);
                    if (iM3010r == 0) {
                        int i37 = r0.f8264P;
                        StringBuilder sb5 = new StringBuilder(89);
                        sb5.append("Unsupported little endian PCM bit depth: ");
                        sb5.append(i37);
                        sb5.append(". Setting mimeType to ");
                        sb5.append("audio/x-unknown");
                        Log.w("MatroskaExtractor", sb5.toString());
                        str3 = str13;
                        list3 = null;
                        str7 = null;
                        list4 = list3;
                        str = str7;
                        i2 = -1;
                        list6 = list4;
                        str13 = str3;
                        list5 = list6;
                        str8 = str;
                        i3 = i2;
                        list2 = list5;
                        iM3010r = -1;
                        bArr = r0.f8262N;
                        if (bArr != null) {
                        }
                        int i2122222222222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                        bVar = new Format2.b();
                        if (MimeTypes.m3050h(str13)) {
                        }
                        str9 = r0.f8274a;
                        if (str9 != null) {
                        }
                        bVar.m3278b(i20);
                        bVar.f7173k = str13;
                        bVar.f7174l = i3;
                        bVar.f7165c = r0.f8271W;
                        bVar.f7166d = i2122222222222222222222222222;
                        bVar.f7175m = list2;
                        bVar.f7170h = str8;
                        bVar.f7176n = r0.f8285l;
                        Format2 format2M3277a22222222222222222222222222 = bVar.m3277a();
                        TrackOutput2 trackOutput2Mo2492p22222222222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                        r0.f8272X = trackOutput2Mo2492p22222222222222222222222222;
                        trackOutput2Mo2492p22222222222222222222222222.mo2526e(format2M3277a22222222222222222222222222);
                        this.f8229h.put(r0.f8276c, r0);
                    }
                    str13 = "audio/raw";
                    list2 = null;
                    i3 = -1;
                    str8 = null;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i21222222222222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i21222222222222222222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a222222222222222222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p222222222222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p222222222222222222222222222;
                    trackOutput2Mo2492p222222222222222222222222222.mo2526e(format2M3277a222222222222222222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 25:
                    byte[] bArr7 = f8191b;
                    byte[] bArrM3683a3 = r0.m3683a(r0.f8275b);
                    AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
                    Object[] objArr = {bArr7, bArrM3683a3};
                    str4 = "text/x-ssa";
                    listM6266u = ImmutableList2.m6263m(objArr);
                    str3 = str4;
                    list3 = listM6266u;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i212222222222222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i212222222222222222222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a2222222222222222222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p2222222222222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p2222222222222222222222222222;
                    trackOutput2Mo2492p2222222222222222222222222222.mo2526e(format2M3277a2222222222222222222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 26:
                    HevcConfig hevcConfigM3131a = HevcConfig.m3131a(new ParsableByteArray(r0.m3683a(r0.f8275b)));
                    list2 = hevcConfigM3131a.f6863a;
                    r0.f8273Y = hevcConfigM3131a.f6864b;
                    str5 = hevcConfigM3131a.f6866d;
                    str6 = "video/hevc";
                    str8 = str5;
                    str13 = str6;
                    iM3010r = -1;
                    i3 = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i2122222222222222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i2122222222222222222222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a22222222222222222222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p22222222222222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p22222222222222222222222222222;
                    trackOutput2Mo2492p22222222222222222222222222222.mo2526e(format2M3277a22222222222222222222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 27:
                    str12 = "application/x-subrip";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i21222222222222222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i21222222222222222222222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a222222222222222222222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p222222222222222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p222222222222222222222222222222;
                    trackOutput2Mo2492p222222222222222222222222222222.mo2526e(format2M3277a222222222222222222222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 28:
                    str12 = "video/mpeg2";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i212222222222222222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i212222222222222222222222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a2222222222222222222222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p2222222222222222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p2222222222222222222222222222222;
                    trackOutput2Mo2492p2222222222222222222222222222222.mo2526e(format2M3277a2222222222222222222222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 29:
                    str12 = "audio/eac3";
                    str13 = str12;
                    str3 = str13;
                    list3 = null;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i2122222222222222222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i2122222222222222222222222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a22222222222222222222222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p22222222222222222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p22222222222222222222222222222222;
                    trackOutput2Mo2492p22222222222222222222222222222222.mo2526e(format2M3277a22222222222222222222222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 30:
                    str4 = "audio/flac";
                    listM6266u = Collections.singletonList(r0.m3683a(r0.f8275b));
                    str3 = str4;
                    list3 = listM6266u;
                    str7 = null;
                    list4 = list3;
                    str = str7;
                    i2 = -1;
                    list6 = list4;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i21222222222222222222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i21222222222222222222222222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a222222222222222222222222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p222222222222222222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p222222222222222222222222222222222;
                    trackOutput2Mo2492p222222222222222222222222222222222.mo2526e(format2M3277a222222222222222222222222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                case 31:
                    ArrayList arrayList3 = new ArrayList(3);
                    arrayList3.add(r0.m3683a(r0.f8275b));
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    arrayList3.add(byteBufferAllocate.order(byteOrder).putLong(r0.f8266R).array());
                    arrayList3.add(ByteBuffer.allocate(8).order(byteOrder).putLong(r0.f8267S).array());
                    i2 = 5760;
                    str3 = "audio/opus";
                    arrayList = arrayList3;
                    str = null;
                    list6 = arrayList;
                    str13 = str3;
                    list5 = list6;
                    str8 = str;
                    i3 = i2;
                    list2 = list5;
                    iM3010r = -1;
                    bArr = r0.f8262N;
                    if (bArr != null) {
                    }
                    int i212222222222222222222222222222222222 = (r0.f8270V ? 1 : 0) | 0 | (r0.f8269U ? 2 : 0);
                    bVar = new Format2.b();
                    if (MimeTypes.m3050h(str13)) {
                    }
                    str9 = r0.f8274a;
                    if (str9 != null) {
                    }
                    bVar.m3278b(i20);
                    bVar.f7173k = str13;
                    bVar.f7174l = i3;
                    bVar.f7165c = r0.f8271W;
                    bVar.f7166d = i212222222222222222222222222222222222;
                    bVar.f7175m = list2;
                    bVar.f7170h = str8;
                    bVar.f7176n = r0.f8285l;
                    Format2 format2M3277a2222222222222222222222222222222222 = bVar.m3277a();
                    TrackOutput2 trackOutput2Mo2492p2222222222222222222222222222222222 = extractorOutput2.mo2492p(r0.f8276c, i4);
                    r0.f8272X = trackOutput2Mo2492p2222222222222222222222222222222222;
                    trackOutput2Mo2492p2222222222222222222222222222222222.mo2526e(format2M3277a2222222222222222222222222222222222);
                    this.f8229h.put(r0.f8276c, r0);
                    break;
                default:
                    throw ParserException.m8755a("Unrecognized codec identifier.", null);
            }
        }
        this.f8247z = null;
    }

    /* renamed from: k */
    public final void m3677k(ExtractorInput extractorInput, int i) throws IOException {
        ParsableByteArray parsableByteArray = this.f8233l;
        if (parsableByteArray.f6795c >= i) {
            return;
        }
        byte[] bArr = parsableByteArray.f6793a;
        if (bArr.length < i) {
            parsableByteArray.m3082b(Math.max(bArr.length * 2, i));
        }
        ParsableByteArray parsableByteArray2 = this.f8233l;
        byte[] bArr2 = parsableByteArray2.f6793a;
        int i2 = parsableByteArray2.f6795c;
        extractorInput.readFully(bArr2, i2, i - i2);
        this.f8233l.m3078D(i);
    }

    /* renamed from: l */
    public final void m3678l() {
        this.f8217W = 0;
        this.f8218X = 0;
        this.f8219Y = 0;
        this.f8220Z = false;
        this.f8221a0 = false;
        this.f8222b0 = false;
        this.f8223c0 = 0;
        this.f8224d0 = (byte) 0;
        this.f8225e0 = false;
        this.f8236o.m3075A(0);
    }

    /* renamed from: m */
    public final long m3679m(long j) throws ParserException {
        long j2 = this.f8244w;
        if (j2 != -9223372036854775807L) {
            return Util2.m2985F(j, j2, 1000L);
        }
        throw ParserException.m8755a("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @RequiresNonNull({"#2.output"})
    /* renamed from: n */
    public final int m3680n(ExtractorInput extractorInput, c cVar, int i) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(cVar.f8275b)) {
            m3681o(extractorInput, f8190a, i);
            int i3 = this.f8218X;
            m3678l();
            return i3;
        }
        if ("S_TEXT/ASS".equals(cVar.f8275b)) {
            m3681o(extractorInput, f8192c, i);
            int i4 = this.f8218X;
            m3678l();
            return i4;
        }
        TrackOutput2 trackOutput2 = cVar.f8272X;
        if (!this.f8220Z) {
            if (cVar.f8281h) {
                this.f8214T &= -1073741825;
                if (!this.f8221a0) {
                    extractorInput.readFully(this.f8233l.f6793a, 0, 1);
                    this.f8217W++;
                    byte[] bArr = this.f8233l.f6793a;
                    if ((bArr[0] & 128) == 128) {
                        throw ParserException.m8755a("Extension bit is set in signal byte", null);
                    }
                    this.f8224d0 = bArr[0];
                    this.f8221a0 = true;
                }
                byte b2 = this.f8224d0;
                if ((b2 & 1) == 1) {
                    boolean z2 = (b2 & 2) == 2;
                    this.f8214T |= BasicMeasure.EXACTLY;
                    if (!this.f8225e0) {
                        extractorInput.readFully(this.f8238q.f6793a, 0, 8);
                        this.f8217W += 8;
                        this.f8225e0 = true;
                        ParsableByteArray parsableByteArray = this.f8233l;
                        parsableByteArray.f6793a[0] = (byte) ((z2 ? 128 : 0) | 8);
                        parsableByteArray.m3079E(0);
                        trackOutput2.mo2527f(this.f8233l, 1, 1);
                        this.f8218X++;
                        this.f8238q.m3079E(0);
                        trackOutput2.mo2527f(this.f8238q, 8, 1);
                        this.f8218X += 8;
                    }
                    if (z2) {
                        if (!this.f8222b0) {
                            extractorInput.readFully(this.f8233l.f6793a, 0, 1);
                            this.f8217W++;
                            this.f8233l.m3079E(0);
                            this.f8223c0 = this.f8233l.m3100t();
                            this.f8222b0 = true;
                        }
                        int i5 = this.f8223c0 * 4;
                        this.f8233l.m3075A(i5);
                        extractorInput.readFully(this.f8233l.f6793a, 0, i5);
                        this.f8217W += i5;
                        short s2 = (short) ((this.f8223c0 / 2) + 1);
                        int i6 = (s2 * 6) + 2;
                        ByteBuffer byteBuffer = this.f8241t;
                        if (byteBuffer == null || byteBuffer.capacity() < i6) {
                            this.f8241t = ByteBuffer.allocate(i6);
                        }
                        this.f8241t.position(0);
                        this.f8241t.putShort(s2);
                        int i7 = 0;
                        int i8 = 0;
                        while (true) {
                            i2 = this.f8223c0;
                            if (i7 >= i2) {
                                break;
                            }
                            int iM3103w = this.f8233l.m3103w();
                            if (i7 % 2 == 0) {
                                this.f8241t.putShort((short) (iM3103w - i8));
                            } else {
                                this.f8241t.putInt(iM3103w - i8);
                            }
                            i7++;
                            i8 = iM3103w;
                        }
                        int i9 = (i - this.f8217W) - i8;
                        if (i2 % 2 == 1) {
                            this.f8241t.putInt(i9);
                        } else {
                            this.f8241t.putShort((short) i9);
                            this.f8241t.putInt(0);
                        }
                        this.f8239r.m3077C(this.f8241t.array(), i6);
                        trackOutput2.mo2527f(this.f8239r, i6, 1);
                        this.f8218X += i6;
                    }
                }
            } else {
                byte[] bArr2 = cVar.f8282i;
                if (bArr2 != null) {
                    ParsableByteArray parsableByteArray2 = this.f8236o;
                    int length = bArr2.length;
                    parsableByteArray2.f6793a = bArr2;
                    parsableByteArray2.f6795c = length;
                    parsableByteArray2.f6794b = 0;
                }
            }
            if (cVar.f8279f > 0) {
                this.f8214T |= 268435456;
                this.f8240s.m3075A(0);
                this.f8233l.m3075A(4);
                ParsableByteArray parsableByteArray3 = this.f8233l;
                byte[] bArr3 = parsableByteArray3.f6793a;
                bArr3[0] = (byte) ((i >> 24) & 255);
                bArr3[1] = (byte) ((i >> 16) & 255);
                bArr3[2] = (byte) ((i >> 8) & 255);
                bArr3[3] = (byte) (i & 255);
                trackOutput2.mo2527f(parsableByteArray3, 4, 2);
                this.f8218X += 4;
            }
            this.f8220Z = true;
        }
        int i10 = i + this.f8236o.f6795c;
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f8275b) && !"V_MPEGH/ISO/HEVC".equals(cVar.f8275b)) {
            if (cVar.f8268T != null) {
                AnimatableValueParser.m426D(this.f8236o.f6795c == 0);
                cVar.f8268T.m3821c(extractorInput);
            }
            while (true) {
                int i11 = this.f8217W;
                if (i11 >= i10) {
                    break;
                }
                int iM3682p = m3682p(extractorInput, trackOutput2, i10 - i11);
                this.f8217W += iM3682p;
                this.f8218X += iM3682p;
            }
        } else {
            byte[] bArr4 = this.f8232k.f6793a;
            bArr4[0] = 0;
            bArr4[1] = 0;
            bArr4[2] = 0;
            int i12 = cVar.f8273Y;
            int i13 = 4 - i12;
            while (this.f8217W < i10) {
                int i14 = this.f8219Y;
                if (i14 == 0) {
                    int iMin = Math.min(i12, this.f8236o.m3081a());
                    extractorInput.readFully(bArr4, i13 + iMin, i12 - iMin);
                    if (iMin > 0) {
                        ParsableByteArray parsableByteArray4 = this.f8236o;
                        System.arraycopy(parsableByteArray4.f6793a, parsableByteArray4.f6794b, bArr4, i13, iMin);
                        parsableByteArray4.f6794b += iMin;
                    }
                    this.f8217W += i12;
                    this.f8232k.m3079E(0);
                    this.f8219Y = this.f8232k.m3103w();
                    this.f8231j.m3079E(0);
                    trackOutput2.mo2524c(this.f8231j, 4);
                    this.f8218X += 4;
                } else {
                    int iM3682p2 = m3682p(extractorInput, trackOutput2, i14);
                    this.f8217W += iM3682p2;
                    this.f8218X += iM3682p2;
                    this.f8219Y -= iM3682p2;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f8275b)) {
            this.f8234m.m3079E(0);
            trackOutput2.mo2524c(this.f8234m, 4);
            this.f8218X += 4;
        }
        int i15 = this.f8218X;
        m3678l();
        return i15;
    }

    /* renamed from: o */
    public final void m3681o(ExtractorInput extractorInput, byte[] bArr, int i) throws IOException {
        int length = bArr.length + i;
        ParsableByteArray parsableByteArray = this.f8237p;
        byte[] bArr2 = parsableByteArray.f6793a;
        if (bArr2.length < length) {
            parsableByteArray.m3076B(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        extractorInput.readFully(this.f8237p.f6793a, bArr.length, i);
        this.f8237p.m3079E(0);
        this.f8237p.m3078D(length);
    }

    /* renamed from: p */
    public final int m3682p(ExtractorInput extractorInput, TrackOutput2 trackOutput2, int i) throws IOException {
        int iM3081a = this.f8236o.m3081a();
        if (iM3081a <= 0) {
            return trackOutput2.mo2523b(extractorInput, i, false);
        }
        int iMin = Math.min(i, iM3081a);
        trackOutput2.mo2524c(this.f8236o, iMin);
        return iMin;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    public final void release() {
    }

    /* compiled from: MatroskaExtractor.java */
    /* renamed from: b.i.a.c.x2.g0.e$c */
    public static final class c {

        /* renamed from: N */
        public byte[] f8262N;

        /* renamed from: T */
        public TrueHdSampleRechunker f8268T;

        /* renamed from: U */
        public boolean f8269U;

        /* renamed from: X */
        public TrackOutput2 f8272X;

        /* renamed from: Y */
        public int f8273Y;

        /* renamed from: a */
        public String f8274a;

        /* renamed from: b */
        public String f8275b;

        /* renamed from: c */
        public int f8276c;

        /* renamed from: d */
        public int f8277d;

        /* renamed from: e */
        public int f8278e;

        /* renamed from: f */
        public int f8279f;

        /* renamed from: g */
        public int f8280g;

        /* renamed from: h */
        public boolean f8281h;

        /* renamed from: i */
        public byte[] f8282i;

        /* renamed from: j */
        public TrackOutput2.a f8283j;

        /* renamed from: k */
        public byte[] f8284k;

        /* renamed from: l */
        public DrmInitData f8285l;

        /* renamed from: m */
        public int f8286m = -1;

        /* renamed from: n */
        public int f8287n = -1;

        /* renamed from: o */
        public int f8288o = -1;

        /* renamed from: p */
        public int f8289p = -1;

        /* renamed from: q */
        public int f8290q = 0;

        /* renamed from: r */
        public int f8291r = -1;

        /* renamed from: s */
        public float f8292s = 0.0f;

        /* renamed from: t */
        public float f8293t = 0.0f;

        /* renamed from: u */
        public float f8294u = 0.0f;

        /* renamed from: v */
        public byte[] f8295v = null;

        /* renamed from: w */
        public int f8296w = -1;

        /* renamed from: x */
        public boolean f8297x = false;

        /* renamed from: y */
        public int f8298y = -1;

        /* renamed from: z */
        public int f8299z = -1;

        /* renamed from: A */
        public int f8249A = -1;

        /* renamed from: B */
        public int f8250B = 1000;

        /* renamed from: C */
        public int f8251C = 200;

        /* renamed from: D */
        public float f8252D = -1.0f;

        /* renamed from: E */
        public float f8253E = -1.0f;

        /* renamed from: F */
        public float f8254F = -1.0f;

        /* renamed from: G */
        public float f8255G = -1.0f;

        /* renamed from: H */
        public float f8256H = -1.0f;

        /* renamed from: I */
        public float f8257I = -1.0f;

        /* renamed from: J */
        public float f8258J = -1.0f;

        /* renamed from: K */
        public float f8259K = -1.0f;

        /* renamed from: L */
        public float f8260L = -1.0f;

        /* renamed from: M */
        public float f8261M = -1.0f;

        /* renamed from: O */
        public int f8263O = 1;

        /* renamed from: P */
        public int f8264P = -1;

        /* renamed from: Q */
        public int f8265Q = 8000;

        /* renamed from: R */
        public long f8266R = 0;

        /* renamed from: S */
        public long f8267S = 0;

        /* renamed from: V */
        public boolean f8270V = true;

        /* renamed from: W */
        public String f8271W = "eng";

        public c() {
        }

        @EnsuresNonNull({"codecPrivate"})
        /* renamed from: a */
        public final byte[] m3683a(String str) throws ParserException {
            byte[] bArr = this.f8284k;
            if (bArr != null) {
                return bArr;
            }
            String strValueOf = String.valueOf(str);
            throw ParserException.m8755a(strValueOf.length() != 0 ? "Missing CodecPrivate for codec ".concat(strValueOf) : new String("Missing CodecPrivate for codec "), null);
        }

        public c(a aVar) {
        }
    }
}
