package p007b.p225i.p226a.p242c.p267x2.p273h0;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.MpegAudioUtil;
import p007b.p225i.p226a.p242c.p267x2.DummyTrackOutput;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.GaplessInfoHolder;
import p007b.p225i.p226a.p242c.p267x2.Id3Peeker;
import p007b.p225i.p226a.p242c.p267x2.PositionHolder;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p273h0.Seeker;
import p007b.p225i.p226a.p242c.p279z2.p283k.Id3Decoder;

/* JADX INFO: renamed from: b.i.a.c.x2.h0.f, reason: use source file name */
/* JADX INFO: compiled from: Mp3Extractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Mp3Extractor implements Extractor {

    /* JADX INFO: renamed from: a */
    public static final Id3Decoder.a f8315a;

    /* JADX INFO: renamed from: b */
    public final int f8316b;

    /* JADX INFO: renamed from: c */
    public final long f8317c;

    /* JADX INFO: renamed from: d */
    public final ParsableByteArray f8318d;

    /* JADX INFO: renamed from: e */
    public final MpegAudioUtil.a f8319e;

    /* JADX INFO: renamed from: f */
    public final GaplessInfoHolder f8320f;

    /* JADX INFO: renamed from: g */
    public final Id3Peeker f8321g;

    /* JADX INFO: renamed from: h */
    public final TrackOutput2 f8322h;

    /* JADX INFO: renamed from: i */
    public ExtractorOutput f8323i;

    /* JADX INFO: renamed from: j */
    public TrackOutput2 f8324j;

    /* JADX INFO: renamed from: k */
    public TrackOutput2 f8325k;

    /* JADX INFO: renamed from: l */
    public int f8326l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public Metadata f8327m;

    /* JADX INFO: renamed from: n */
    public long f8328n;

    /* JADX INFO: renamed from: o */
    public long f8329o;

    /* JADX INFO: renamed from: p */
    public long f8330p;

    /* JADX INFO: renamed from: q */
    public int f8331q;

    /* JADX INFO: renamed from: r */
    public Seeker f8332r;

    /* JADX INFO: renamed from: s */
    public boolean f8333s;

    /* JADX INFO: renamed from: t */
    public boolean f8334t;

    /* JADX INFO: renamed from: u */
    public long f8335u;

    static {
        C3032a c3032a = C3032a.f8306a;
        f8315a = C3033b.f8307a;
    }

    public Mp3Extractor() {
        this(0);
    }

    /* JADX INFO: renamed from: d */
    public static long m3693d(@Nullable Metadata metadata) {
        if (metadata == null) {
            return -9223372036854775807L;
        }
        int length = metadata.f19936j.length;
        for (int i = 0; i < length; i++) {
            Metadata.Entry entry = metadata.f19936j[i];
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                if (textInformationFrame.f19989j.equals("TLEN")) {
                    return Util2.m2981B(Long.parseLong(textInformationFrame.f20001l));
                }
            }
        }
        return -9223372036854775807L;
    }

    /* JADX INFO: renamed from: h */
    public static boolean m3694h(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    /* JADX INFO: renamed from: a */
    public final long m3695a(long j) {
        return ((j * 1000000) / ((long) this.f8319e.f7680d)) + this.f8328n;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(ExtractorInput extractorInput) throws IOException {
        return m3698j(extractorInput, true);
    }

    /* JADX INFO: renamed from: c */
    public final Seeker m3696c(ExtractorInput extractorInput, boolean z2) throws IOException {
        extractorInput.mo3652o(this.f8318d.f6793a, 0, 4);
        this.f8318d.m3079E(0);
        this.f8319e.m3469a(this.f8318d.m3086f());
        return new ConstantBitrateSeeker(extractorInput.mo3642b(), extractorInput.getPosition(), this.f8319e, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int mo3635e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Mp3Extractor mp3Extractor;
        int i;
        ExtractorInput extractorInput2;
        int iMo2523b;
        int i2;
        Seeker seekerM3696c;
        int iM3103w;
        XingSeeker xingSeeker;
        MlltSeeker mlltSeeker;
        long jM3693d;
        long jMo3621i;
        long jMo3689a;
        int iM3100t;
        AnimatableValueParser.m438H(this.f8324j);
        int i3 = Util2.f6708a;
        if (this.f8326l == 0) {
            try {
                m3698j(extractorInput, false);
                if (this.f8332r != null) {
                    ParsableByteArray parsableByteArray = new ParsableByteArray(this.f8319e.f7679c);
                    extractorInput.mo3652o(parsableByteArray.f6793a, 0, this.f8319e.f7679c);
                    MpegAudioUtil.a aVar = this.f8319e;
                    int i4 = 21;
                    if ((aVar.f7677a & 1) != 0) {
                        if (aVar.f7681e != 1) {
                            i4 = 36;
                        }
                    } else if (aVar.f7681e == 1) {
                        i4 = 13;
                    }
                    if (parsableByteArray.f6795c >= i4 + 4) {
                        parsableByteArray.m3079E(i4);
                        int iM3086f = parsableByteArray.m3086f();
                        if (iM3086f != 1483304551 && iM3086f != 1231971951) {
                            if (parsableByteArray.f6795c >= 40) {
                                parsableByteArray.m3079E(36);
                                iM3086f = parsableByteArray.m3086f() == 1447187017 ? 1447187017 : 0;
                            }
                        }
                        String str = ", ";
                        if (iM3086f == 1483304551 || iM3086f == 1231971951) {
                            mp3Extractor = this;
                            long jMo3642b = extractorInput.mo3642b();
                            long position = extractorInput.getPosition();
                            MpegAudioUtil.a aVar2 = mp3Extractor.f8319e;
                            int i5 = aVar2.f7683g;
                            int i6 = aVar2.f7680d;
                            int iM3086f2 = parsableByteArray.m3086f();
                            if ((iM3086f2 & 1) != 1 || (iM3103w = parsableByteArray.m3103w()) == 0) {
                                i2 = i4;
                                seekerM3696c = null;
                            } else {
                                i2 = i4;
                                long jM2985F = Util2.m2985F(iM3103w, ((long) i5) * 1000000, i6);
                                if ((iM3086f2 & 6) != 6) {
                                    xingSeeker = new XingSeeker(position, aVar2.f7679c, jM2985F, -1L, null);
                                } else {
                                    long jM3101u = parsableByteArray.m3101u();
                                    long[] jArr = new long[100];
                                    for (int i7 = 0; i7 < 100; i7++) {
                                        jArr[i7] = parsableByteArray.m3100t();
                                    }
                                    if (jMo3642b != -1) {
                                        long j = position + jM3101u;
                                        if (jMo3642b != j) {
                                            StringBuilder sbM830R = outline.m830R(67, "XING data size mismatch: ", jMo3642b, ", ");
                                            sbM830R.append(j);
                                            Log.w("XingSeeker", sbM830R.toString());
                                        }
                                    }
                                    xingSeeker = new XingSeeker(position, aVar2.f7679c, jM2985F, jM3101u, jArr);
                                }
                                seekerM3696c = xingSeeker;
                            }
                            if (seekerM3696c != null) {
                                GaplessInfoHolder gaplessInfoHolder = mp3Extractor.f8320f;
                                if ((gaplessInfoHolder.f8985b == -1 || gaplessInfoHolder.f8986c == -1) ? false : true) {
                                    extractorInput2 = extractorInput;
                                } else {
                                    extractorInput.mo3649k();
                                    extractorInput2 = extractorInput;
                                    extractorInput2.mo3646g(i2 + Opcodes.F2D);
                                    extractorInput2.mo3652o(mp3Extractor.f8318d.f6793a, 0, 3);
                                    mp3Extractor.f8318d.m3079E(0);
                                    GaplessInfoHolder gaplessInfoHolder2 = mp3Extractor.f8320f;
                                    int iM3102v = mp3Extractor.f8318d.m3102v();
                                    Objects.requireNonNull(gaplessInfoHolder2);
                                    int i8 = iM3102v >> 12;
                                    int i9 = iM3102v & 4095;
                                    if (i8 > 0 || i9 > 0) {
                                        gaplessInfoHolder2.f8985b = i8;
                                        gaplessInfoHolder2.f8986c = i9;
                                    }
                                }
                                extractorInput2.mo3650l(mp3Extractor.f8319e.f7679c);
                                if (seekerM3696c != null && !seekerM3696c.mo3619c() && iM3086f == 1231971951) {
                                    seekerM3696c = mp3Extractor.m3696c(extractorInput2, false);
                                }
                            }
                        } else if (iM3086f == 1447187017) {
                            long jMo3642b2 = extractorInput.mo3642b();
                            long position2 = extractorInput.getPosition();
                            MpegAudioUtil.a aVar3 = this.f8319e;
                            parsableByteArray.m3080F(10);
                            int iM3086f3 = parsableByteArray.m3086f();
                            if (iM3086f3 <= 0) {
                                seekerM3696c = null;
                                mp3Extractor = this;
                                extractorInput.mo3650l(mp3Extractor.f8319e.f7679c);
                                extractorInput2 = extractorInput;
                            } else {
                                int i10 = aVar3.f7680d;
                                long jM2985F2 = Util2.m2985F(iM3086f3, ((long) (i10 >= 32000 ? 1152 : 576)) * 1000000, i10);
                                int iM3105y = parsableByteArray.m3105y();
                                int iM3105y2 = parsableByteArray.m3105y();
                                int iM3105y3 = parsableByteArray.m3105y();
                                parsableByteArray.m3080F(2);
                                long j2 = ((long) aVar3.f7679c) + position2;
                                long[] jArr2 = new long[iM3105y];
                                long[] jArr3 = new long[iM3105y];
                                int i11 = 0;
                                long j3 = position2;
                                while (i11 < iM3105y) {
                                    String str2 = str;
                                    long j4 = jMo3642b2;
                                    jArr2[i11] = (((long) i11) * jM2985F2) / ((long) iM3105y);
                                    jArr3[i11] = Math.max(j3, j2);
                                    if (iM3105y3 == 1) {
                                        iM3100t = parsableByteArray.m3100t();
                                    } else if (iM3105y3 == 2) {
                                        iM3100t = parsableByteArray.m3105y();
                                    } else if (iM3105y3 == 3) {
                                        iM3100t = parsableByteArray.m3102v();
                                    } else {
                                        if (iM3105y3 != 4) {
                                            seekerM3696c = null;
                                            break;
                                        }
                                        iM3100t = parsableByteArray.m3103w();
                                    }
                                    j3 += (long) (iM3100t * iM3105y2);
                                    i11++;
                                    str = str2;
                                    jMo3642b2 = j4;
                                }
                                String str3 = str;
                                long j5 = jMo3642b2;
                                if (j5 != -1 && j5 != j3) {
                                    StringBuilder sbM830R2 = outline.m830R(67, "VBRI data size mismatch: ", j5, str3);
                                    sbM830R2.append(j3);
                                    Log.w("VbriSeeker", sbM830R2.toString());
                                }
                                seekerM3696c = new VbriSeeker(jArr2, jArr3, jM2985F2, j3);
                                mp3Extractor = this;
                                extractorInput.mo3650l(mp3Extractor.f8319e.f7679c);
                                extractorInput2 = extractorInput;
                            }
                        } else {
                            mp3Extractor = this;
                            extractorInput.mo3649k();
                            extractorInput2 = extractorInput;
                            seekerM3696c = null;
                        }
                        Metadata metadata = mp3Extractor.f8327m;
                        long position3 = extractorInput.getPosition();
                        if (metadata != null) {
                            int length = metadata.f19936j.length;
                            for (int i12 = 0; i12 < length; i12++) {
                                Metadata.Entry entry = metadata.f19936j[i12];
                                if (entry instanceof MlltFrame) {
                                    MlltFrame mlltFrame = (MlltFrame) entry;
                                    long jM3693d2 = m3693d(metadata);
                                    int length2 = mlltFrame.f19996n.length;
                                    int i13 = length2 + 1;
                                    long[] jArr4 = new long[i13];
                                    long[] jArr5 = new long[i13];
                                    jArr4[0] = position3;
                                    jArr5[0] = 0;
                                    long j6 = 0;
                                    for (int i14 = 1; i14 <= length2; i14++) {
                                        int i15 = i14 - 1;
                                        position3 += (long) (mlltFrame.f19994l + mlltFrame.f19996n[i15]);
                                        j6 += (long) (mlltFrame.f19995m + mlltFrame.f19997o[i15]);
                                        jArr4[i14] = position3;
                                        jArr5[i14] = j6;
                                    }
                                    mlltSeeker = new MlltSeeker(jArr4, jArr5, jM3693d2);
                                    if (mp3Extractor.f8333s) {
                                        seekerM3696c = new Seeker.a();
                                    } else {
                                        if ((mp3Extractor.f8316b & 4) != 0) {
                                            if (mlltSeeker != null) {
                                                jM3693d = mlltSeeker.f8314c;
                                            } else if (seekerM3696c != null) {
                                                jMo3621i = seekerM3696c.mo3621i();
                                                jMo3689a = seekerM3696c.mo3689a();
                                                seekerM3696c = new IndexSeeker(jMo3621i, extractorInput.getPosition(), jMo3689a);
                                            } else {
                                                jM3693d = m3693d(mp3Extractor.f8327m);
                                            }
                                            jMo3621i = jM3693d;
                                            jMo3689a = -1;
                                            seekerM3696c = new IndexSeeker(jMo3621i, extractorInput.getPosition(), jMo3689a);
                                        } else if (mlltSeeker != null) {
                                            seekerM3696c = mlltSeeker;
                                        } else if (seekerM3696c == null) {
                                            seekerM3696c = null;
                                        }
                                        if (seekerM3696c == null || (!seekerM3696c.mo3619c() && (mp3Extractor.f8316b & 1) != 0)) {
                                            seekerM3696c = mp3Extractor.m3696c(extractorInput2, (mp3Extractor.f8316b & 2) != 0);
                                        }
                                    }
                                    mp3Extractor.f8332r = seekerM3696c;
                                    mp3Extractor.f8323i.mo2477a(seekerM3696c);
                                    TrackOutput2 trackOutput2 = mp3Extractor.f8325k;
                                    Format2.b bVar = new Format2.b();
                                    MpegAudioUtil.a aVar4 = mp3Extractor.f8319e;
                                    bVar.f7173k = aVar4.f7678b;
                                    bVar.f7174l = 4096;
                                    bVar.f7186x = aVar4.f7681e;
                                    bVar.f7187y = aVar4.f7680d;
                                    GaplessInfoHolder gaplessInfoHolder3 = mp3Extractor.f8320f;
                                    bVar.f7159A = gaplessInfoHolder3.f8985b;
                                    bVar.f7160B = gaplessInfoHolder3.f8986c;
                                    bVar.f7171i = (mp3Extractor.f8316b & 8) != 0 ? null : mp3Extractor.f8327m;
                                    trackOutput2.mo2526e(bVar.m3277a());
                                    mp3Extractor.f8330p = extractorInput.getPosition();
                                }
                            }
                            mlltSeeker = null;
                            if (mp3Extractor.f8333s) {
                            }
                            mp3Extractor.f8332r = seekerM3696c;
                            mp3Extractor.f8323i.mo2477a(seekerM3696c);
                            TrackOutput2 trackOutput22 = mp3Extractor.f8325k;
                            Format2.b bVar2 = new Format2.b();
                            MpegAudioUtil.a aVar42 = mp3Extractor.f8319e;
                            bVar2.f7173k = aVar42.f7678b;
                            bVar2.f7174l = 4096;
                            bVar2.f7186x = aVar42.f7681e;
                            bVar2.f7187y = aVar42.f7680d;
                            GaplessInfoHolder gaplessInfoHolder32 = mp3Extractor.f8320f;
                            bVar2.f7159A = gaplessInfoHolder32.f8985b;
                            bVar2.f7160B = gaplessInfoHolder32.f8986c;
                            bVar2.f7171i = (mp3Extractor.f8316b & 8) != 0 ? null : mp3Extractor.f8327m;
                            trackOutput22.mo2526e(bVar2.m3277a());
                            mp3Extractor.f8330p = extractorInput.getPosition();
                        } else {
                            mlltSeeker = null;
                            if (mp3Extractor.f8333s) {
                            }
                            mp3Extractor.f8332r = seekerM3696c;
                            mp3Extractor.f8323i.mo2477a(seekerM3696c);
                            TrackOutput2 trackOutput222 = mp3Extractor.f8325k;
                            Format2.b bVar22 = new Format2.b();
                            MpegAudioUtil.a aVar422 = mp3Extractor.f8319e;
                            bVar22.f7173k = aVar422.f7678b;
                            bVar22.f7174l = 4096;
                            bVar22.f7186x = aVar422.f7681e;
                            bVar22.f7187y = aVar422.f7680d;
                            GaplessInfoHolder gaplessInfoHolder322 = mp3Extractor.f8320f;
                            bVar22.f7159A = gaplessInfoHolder322.f8985b;
                            bVar22.f7160B = gaplessInfoHolder322.f8986c;
                            bVar22.f7171i = (mp3Extractor.f8316b & 8) != 0 ? null : mp3Extractor.f8327m;
                            trackOutput222.mo2526e(bVar22.m3277a());
                            mp3Extractor.f8330p = extractorInput.getPosition();
                        }
                    }
                } else {
                    extractorInput2 = extractorInput;
                    mp3Extractor = this;
                    if (mp3Extractor.f8330p != 0) {
                        long position4 = extractorInput.getPosition();
                        long j7 = mp3Extractor.f8330p;
                        if (position4 < j7) {
                            extractorInput2.mo3650l((int) (j7 - position4));
                        }
                    }
                }
            } catch (EOFException unused) {
                mp3Extractor = this;
            }
            if (mp3Extractor.f8331q != 0) {
                extractorInput.mo3649k();
                if (!m3697i(extractorInput)) {
                    mp3Extractor.f8318d.m3079E(0);
                    int iM3086f4 = mp3Extractor.f8318d.m3086f();
                    if (!m3694h(iM3086f4, mp3Extractor.f8326l) || MpegAudioUtil.m3465a(iM3086f4) == -1) {
                        extractorInput2.mo3650l(1);
                        mp3Extractor.f8326l = 0;
                        i = 0;
                    } else {
                        mp3Extractor.f8319e.m3469a(iM3086f4);
                        if (mp3Extractor.f8328n == -9223372036854775807L) {
                            mp3Extractor.f8328n = mp3Extractor.f8332r.mo3690d(extractorInput.getPosition());
                            if (mp3Extractor.f8317c != -9223372036854775807L) {
                                mp3Extractor.f8328n = (mp3Extractor.f8317c - mp3Extractor.f8332r.mo3690d(0L)) + mp3Extractor.f8328n;
                            }
                        }
                        MpegAudioUtil.a aVar5 = mp3Extractor.f8319e;
                        mp3Extractor.f8331q = aVar5.f7679c;
                        Seeker seeker = mp3Extractor.f8332r;
                        if (seeker instanceof IndexSeeker) {
                            IndexSeeker indexSeeker = (IndexSeeker) seeker;
                            long jM3695a = mp3Extractor.m3695a(mp3Extractor.f8329o + ((long) aVar5.f7683g));
                            long position5 = extractorInput.getPosition() + ((long) mp3Extractor.f8319e.f7679c);
                            if (!indexSeeker.m3691b(jM3695a)) {
                                indexSeeker.f8309b.m3041a(jM3695a);
                                indexSeeker.f8310c.m3041a(position5);
                            }
                            if (mp3Extractor.f8334t && indexSeeker.m3691b(mp3Extractor.f8335u)) {
                                mp3Extractor.f8334t = false;
                                mp3Extractor.f8325k = mp3Extractor.f8324j;
                            }
                        }
                        iMo2523b = mp3Extractor.f8325k.mo2523b(extractorInput2, mp3Extractor.f8331q, true);
                        if (iMo2523b != -1) {
                            int i16 = mp3Extractor.f8331q - iMo2523b;
                            mp3Extractor.f8331q = i16;
                            if (i16 <= 0) {
                                mp3Extractor.f8325k.mo2525d(mp3Extractor.m3695a(mp3Extractor.f8329o), 1, mp3Extractor.f8319e.f7679c, 0, null);
                                mp3Extractor.f8329o += (long) mp3Extractor.f8319e.f7683g;
                                mp3Extractor.f8331q = 0;
                            }
                            i = 0;
                        }
                    }
                }
                i = -1;
            } else {
                iMo2523b = mp3Extractor.f8325k.mo2523b(extractorInput2, mp3Extractor.f8331q, true);
                if (iMo2523b != -1) {
                }
                i = -1;
            }
        } else {
            if (this.f8332r != null) {
            }
            if (mp3Extractor.f8331q != 0) {
            }
        }
        if (i == -1 && (mp3Extractor.f8332r instanceof IndexSeeker)) {
            long jM3695a2 = mp3Extractor.m3695a(mp3Extractor.f8329o);
            if (mp3Extractor.f8332r.mo3621i() != jM3695a2) {
                Seeker seeker2 = mp3Extractor.f8332r;
                ((IndexSeeker) seeker2).f8311d = jM3695a2;
                mp3Extractor.f8323i.mo2477a(seeker2);
            }
        }
        return i;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: f */
    public void mo3636f(ExtractorOutput extractorOutput) {
        this.f8323i = extractorOutput;
        TrackOutput2 trackOutput2Mo2492p = extractorOutput.mo2492p(0, 1);
        this.f8324j = trackOutput2Mo2492p;
        this.f8325k = trackOutput2Mo2492p;
        this.f8323i.mo2486j();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        this.f8326l = 0;
        this.f8328n = -9223372036854775807L;
        this.f8329o = 0L;
        this.f8331q = 0;
        this.f8335u = j2;
        Seeker seeker = this.f8332r;
        if (!(seeker instanceof IndexSeeker) || ((IndexSeeker) seeker).m3691b(j2)) {
            return;
        }
        this.f8334t = true;
        this.f8325k = this.f8322h;
    }

    /* JADX INFO: renamed from: i */
    public final boolean m3697i(ExtractorInput extractorInput) throws IOException {
        Seeker seeker = this.f8332r;
        if (seeker != null) {
            long jMo3689a = seeker.mo3689a();
            if (jMo3689a != -1 && extractorInput.mo3645f() > jMo3689a - 4) {
                return true;
            }
        }
        try {
            return !extractorInput.mo3644e(this.f8318d.f6793a, 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    /* JADX INFO: renamed from: j */
    public final boolean m3698j(ExtractorInput extractorInput, boolean z2) throws IOException {
        int i;
        int iMo3645f;
        int iM3465a;
        int i2 = z2 ? 32768 : 131072;
        extractorInput.mo3649k();
        if (extractorInput.getPosition() == 0) {
            Metadata metadataM3816a = this.f8321g.m3816a(extractorInput, (this.f8316b & 8) == 0 ? null : f8315a);
            this.f8327m = metadataM3816a;
            if (metadataM3816a != null) {
                this.f8320f.m3815b(metadataM3816a);
            }
            iMo3645f = (int) extractorInput.mo3645f();
            if (!z2) {
                extractorInput.mo3650l(iMo3645f);
            }
            i = 0;
        } else {
            i = 0;
            iMo3645f = 0;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (!m3697i(extractorInput)) {
                this.f8318d.m3079E(0);
                int iM3086f = this.f8318d.m3086f();
                if ((i == 0 || m3694h(iM3086f, i)) && (iM3465a = MpegAudioUtil.m3465a(iM3086f)) != -1) {
                    i3++;
                    if (i3 != 1) {
                        if (i3 == 4) {
                            break;
                        }
                    } else {
                        this.f8319e.m3469a(iM3086f);
                        i = iM3086f;
                    }
                    extractorInput.mo3646g(iM3465a - 4);
                } else {
                    int i5 = i4 + 1;
                    if (i4 == i2) {
                        if (z2) {
                            return false;
                        }
                        throw ParserException.m8755a("Searched too many bytes.", null);
                    }
                    if (z2) {
                        extractorInput.mo3649k();
                        extractorInput.mo3646g(iMo3645f + i5);
                    } else {
                        extractorInput.mo3650l(1);
                    }
                    i4 = i5;
                    i = 0;
                    i3 = 0;
                }
            } else if (i3 <= 0) {
                throw new EOFException();
            }
        }
        if (z2) {
            extractorInput.mo3650l(iMo3645f + i4);
        } else {
            extractorInput.mo3649k();
        }
        this.f8326l = i;
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    public void release() {
    }

    public Mp3Extractor(int i) {
        this.f8316b = (i & 2) != 0 ? i | 1 : i;
        this.f8317c = -9223372036854775807L;
        this.f8318d = new ParsableByteArray(10);
        this.f8319e = new MpegAudioUtil.a();
        this.f8320f = new GaplessInfoHolder();
        this.f8328n = -9223372036854775807L;
        this.f8321g = new Id3Peeker();
        DummyTrackOutput dummyTrackOutput = new DummyTrackOutput();
        this.f8322h = dummyTrackOutput;
        this.f8325k = dummyTrackOutput;
    }
}
