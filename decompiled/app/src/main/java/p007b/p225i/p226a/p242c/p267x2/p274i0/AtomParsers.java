package p007b.p225i.p226a.p242c.p267x2.p274i0;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.MimeTypes;
import p007b.p225i.p226a.p242c.p259f3.ParsableBitArray;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.AvcConfig;
import p007b.p225i.p226a.p242c.p260g3.ColorInfo;
import p007b.p225i.p226a.p242c.p260g3.DolbyVisionConfig;
import p007b.p225i.p226a.p242c.p260g3.HevcConfig;
import p007b.p225i.p226a.p242c.p263t2.AacUtil;
import p007b.p225i.p226a.p242c.p263t2.Ac3Util;
import p007b.p225i.p226a.p242c.p267x2.GaplessInfoHolder;
import p007b.p225i.p226a.p242c.p267x2.p274i0.Atom;
import p007b.p225i.p355b.p356a.Function2;
import p007b.p225i.p355b.p357b.ImmutableList2;

/* compiled from: AtomParsers.java */
/* renamed from: b.i.a.c.x2.i0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class AtomParsers {

    /* renamed from: a */
    public static final byte[] f8354a = Util2.m3015w("OpusHead");

    /* compiled from: AtomParsers.java */
    /* renamed from: b.i.a.c.x2.i0.e$a */
    public interface a {
        /* renamed from: a */
        int mo3707a();

        /* renamed from: b */
        int mo3708b();

        /* renamed from: c */
        int mo3709c();
    }

    /* compiled from: AtomParsers.java */
    /* renamed from: b.i.a.c.x2.i0.e$b */
    public static final class b {

        /* renamed from: a */
        public final TrackEncryptionBox[] f8355a;

        /* renamed from: b */
        @Nullable
        public Format2 f8356b;

        /* renamed from: c */
        public int f8357c;

        /* renamed from: d */
        public int f8358d = 0;

        public b(int i) {
            this.f8355a = new TrackEncryptionBox[i];
        }
    }

    /* compiled from: AtomParsers.java */
    /* renamed from: b.i.a.c.x2.i0.e$c */
    public static final class c implements a {

        /* renamed from: a */
        public final int f8359a;

        /* renamed from: b */
        public final int f8360b;

        /* renamed from: c */
        public final ParsableByteArray f8361c;

        public c(Atom.b bVar, Format2 format2) {
            ParsableByteArray parsableByteArray = bVar.f8353b;
            this.f8361c = parsableByteArray;
            parsableByteArray.m3079E(12);
            int iM3103w = parsableByteArray.m3103w();
            if ("audio/raw".equals(format2.f7155w)) {
                int iM3011s = Util2.m3011s(format2.f7138L, format2.f7136J);
                if (iM3103w == 0 || iM3103w % iM3011s != 0) {
                    Log.w("AtomParsers", outline.m853h(88, "Audio sample size mismatch. stsd sample size: ", iM3011s, ", stsz sample size: ", iM3103w));
                    iM3103w = iM3011s;
                }
            }
            this.f8359a = iM3103w == 0 ? -1 : iM3103w;
            this.f8360b = parsableByteArray.m3103w();
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p274i0.AtomParsers.a
        /* renamed from: a */
        public int mo3707a() {
            return this.f8359a;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p274i0.AtomParsers.a
        /* renamed from: b */
        public int mo3708b() {
            return this.f8360b;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p274i0.AtomParsers.a
        /* renamed from: c */
        public int mo3709c() {
            int i = this.f8359a;
            return i == -1 ? this.f8361c.m3103w() : i;
        }
    }

    /* compiled from: AtomParsers.java */
    /* renamed from: b.i.a.c.x2.i0.e$d */
    public static final class d implements a {

        /* renamed from: a */
        public final ParsableByteArray f8362a;

        /* renamed from: b */
        public final int f8363b;

        /* renamed from: c */
        public final int f8364c;

        /* renamed from: d */
        public int f8365d;

        /* renamed from: e */
        public int f8366e;

        public d(Atom.b bVar) {
            ParsableByteArray parsableByteArray = bVar.f8353b;
            this.f8362a = parsableByteArray;
            parsableByteArray.m3079E(12);
            this.f8364c = parsableByteArray.m3103w() & 255;
            this.f8363b = parsableByteArray.m3103w();
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p274i0.AtomParsers.a
        /* renamed from: a */
        public int mo3707a() {
            return -1;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p274i0.AtomParsers.a
        /* renamed from: b */
        public int mo3708b() {
            return this.f8363b;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p274i0.AtomParsers.a
        /* renamed from: c */
        public int mo3709c() {
            int i = this.f8364c;
            if (i == 8) {
                return this.f8362a.m3100t();
            }
            if (i == 16) {
                return this.f8362a.m3105y();
            }
            int i2 = this.f8365d;
            this.f8365d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.f8366e & 15;
            }
            int iM3100t = this.f8362a.m3100t();
            this.f8366e = iM3100t;
            return (iM3100t & 240) >> 4;
        }
    }

    /* renamed from: a */
    public static Pair<String, byte[]> m3702a(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.m3079E(i + 8 + 4);
        parsableByteArray.m3080F(1);
        m3703b(parsableByteArray);
        parsableByteArray.m3080F(2);
        int iM3100t = parsableByteArray.m3100t();
        if ((iM3100t & 128) != 0) {
            parsableByteArray.m3080F(2);
        }
        if ((iM3100t & 64) != 0) {
            parsableByteArray.m3080F(parsableByteArray.m3105y());
        }
        if ((iM3100t & 32) != 0) {
            parsableByteArray.m3080F(2);
        }
        parsableByteArray.m3080F(1);
        m3703b(parsableByteArray);
        String strM3046d = MimeTypes.m3046d(parsableByteArray.m3100t());
        if ("audio/mpeg".equals(strM3046d) || "audio/vnd.dts".equals(strM3046d) || "audio/vnd.dts.hd".equals(strM3046d)) {
            return Pair.create(strM3046d, null);
        }
        parsableByteArray.m3080F(12);
        parsableByteArray.m3080F(1);
        int iM3703b = m3703b(parsableByteArray);
        byte[] bArr = new byte[iM3703b];
        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr, 0, iM3703b);
        parsableByteArray.f6794b += iM3703b;
        return Pair.create(strM3046d, bArr);
    }

    /* renamed from: b */
    public static int m3703b(ParsableByteArray parsableByteArray) {
        int iM3100t = parsableByteArray.m3100t();
        int i = iM3100t & Opcodes.LAND;
        while ((iM3100t & 128) == 128) {
            iM3100t = parsableByteArray.m3100t();
            i = (i << 7) | (iM3100t & Opcodes.LAND);
        }
        return i;
    }

    @Nullable
    /* renamed from: c */
    public static Pair<Integer, TrackEncryptionBox> m3704c(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        Integer num;
        TrackEncryptionBox trackEncryptionBox;
        Pair<Integer, TrackEncryptionBox> pairCreate;
        int i3;
        int i4;
        byte[] bArr;
        int i5 = parsableByteArray.f6794b;
        while (i5 - i < i2) {
            parsableByteArray.m3079E(i5);
            int iM3086f = parsableByteArray.m3086f();
            int i6 = 1;
            AnimatableValueParser.m559q(iM3086f > 0, "childAtomSize must be positive");
            if (parsableByteArray.m3086f() == 1936289382) {
                int i7 = i5 + 8;
                int i8 = -1;
                int i9 = 0;
                String strM3097q = null;
                Integer numValueOf = null;
                while (i7 - i5 < iM3086f) {
                    parsableByteArray.m3079E(i7);
                    int iM3086f2 = parsableByteArray.m3086f();
                    int iM3086f3 = parsableByteArray.m3086f();
                    if (iM3086f3 == 1718775137) {
                        numValueOf = Integer.valueOf(parsableByteArray.m3086f());
                    } else if (iM3086f3 == 1935894637) {
                        parsableByteArray.m3080F(4);
                        strM3097q = parsableByteArray.m3097q(4);
                    } else if (iM3086f3 == 1935894633) {
                        i8 = i7;
                        i9 = iM3086f2;
                    }
                    i7 += iM3086f2;
                }
                if ("cenc".equals(strM3097q) || "cbc1".equals(strM3097q) || "cens".equals(strM3097q) || "cbcs".equals(strM3097q)) {
                    AnimatableValueParser.m559q(numValueOf != null, "frma atom is mandatory");
                    AnimatableValueParser.m559q(i8 != -1, "schi atom is mandatory");
                    int i10 = i8 + 8;
                    while (true) {
                        if (i10 - i8 >= i9) {
                            num = numValueOf;
                            trackEncryptionBox = null;
                            break;
                        }
                        parsableByteArray.m3079E(i10);
                        int iM3086f4 = parsableByteArray.m3086f();
                        if (parsableByteArray.m3086f() == 1952804451) {
                            int iM3086f5 = (parsableByteArray.m3086f() >> 24) & 255;
                            parsableByteArray.m3080F(i6);
                            if (iM3086f5 == 0) {
                                parsableByteArray.m3080F(i6);
                                i3 = 0;
                                i4 = 0;
                            } else {
                                int iM3100t = parsableByteArray.m3100t();
                                int i11 = (iM3100t & 240) >> 4;
                                i3 = iM3100t & 15;
                                i4 = i11;
                            }
                            boolean z2 = parsableByteArray.m3100t() == i6;
                            int iM3100t2 = parsableByteArray.m3100t();
                            byte[] bArr2 = new byte[16];
                            System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr2, 0, 16);
                            parsableByteArray.f6794b += 16;
                            if (z2 && iM3100t2 == 0) {
                                int iM3100t3 = parsableByteArray.m3100t();
                                byte[] bArr3 = new byte[iM3100t3];
                                System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr3, 0, iM3100t3);
                                parsableByteArray.f6794b += iM3100t3;
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            num = numValueOf;
                            trackEncryptionBox = new TrackEncryptionBox(z2, strM3097q, iM3100t2, bArr2, i4, i3, bArr);
                        } else {
                            i10 += iM3086f4;
                            i6 = 1;
                        }
                    }
                    AnimatableValueParser.m559q(trackEncryptionBox != null, "tenc atom is mandatory");
                    int i12 = Util2.f6708a;
                    pairCreate = Pair.create(num, trackEncryptionBox);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            i5 += iM3086f;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:232:0x0374  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b m3705d(ParsableByteArray parsableByteArray, int i, int i2, String str, @Nullable DrmInitData drmInitData, boolean z2) throws ParserException {
        int i3;
        int i4;
        int i5;
        int i6;
        DrmInitData drmInitDataM8835a;
        byte[] bArr;
        int i7;
        int i8;
        b bVar;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        b bVar2;
        int i14;
        int i15;
        b bVar3;
        int i16;
        int i17;
        int i18;
        float f;
        List<byte[]> listM6266u;
        int i19;
        List<byte[]> list;
        String str2;
        int iM3105y;
        int iRound;
        int iM3103w;
        int i20;
        int i21;
        int i22;
        DrmInitData drmInitDataM8835a2;
        String str3;
        int i23;
        int iIntValue;
        String str4;
        int i24;
        String str5;
        List<byte[]> listM6266u2;
        int i25;
        int i26;
        int i27;
        boolean z3;
        int i28;
        String str6;
        int i29;
        int i30;
        int i31;
        List<byte[]> listM519g;
        int i32;
        int i33;
        String str7;
        int iIntValue2;
        ImmutableList2 immutableList2M6266u;
        ImmutableList2 immutableList2M6266u2;
        String str8;
        String str9 = str;
        DrmInitData drmInitData2 = drmInitData;
        parsableByteArray.m3079E(12);
        int iM3086f = parsableByteArray.m3086f();
        b bVar4 = new b(iM3086f);
        int i34 = 0;
        while (i34 < iM3086f) {
            int i35 = parsableByteArray.f6794b;
            int iM3086f2 = parsableByteArray.m3086f();
            String str10 = "childAtomSize must be positive";
            AnimatableValueParser.m559q(iM3086f2 > 0, "childAtomSize must be positive");
            int iM3086f3 = parsableByteArray.m3086f();
            if (iM3086f3 == 1635148593 || iM3086f3 == 1635148595 || iM3086f3 == 1701733238 || iM3086f3 == 1831958048 || iM3086f3 == 1836070006 || iM3086f3 == 1752589105 || iM3086f3 == 1751479857 || iM3086f3 == 1932670515 || iM3086f3 == 1211250227 || iM3086f3 == 1987063864 || iM3086f3 == 1987063865 || iM3086f3 == 1635135537 || iM3086f3 == 1685479798 || iM3086f3 == 1685479729 || iM3086f3 == 1685481573 || iM3086f3 == 1685481521) {
                i3 = iM3086f;
                i4 = i34;
                parsableByteArray.m3079E(i35 + 8 + 8);
                parsableByteArray.m3080F(16);
                int iM3105y2 = parsableByteArray.m3105y();
                int iM3105y3 = parsableByteArray.m3105y();
                parsableByteArray.m3080F(50);
                int i36 = parsableByteArray.f6794b;
                if (iM3086f3 == 1701733238) {
                    i5 = i35;
                    i6 = iM3086f2;
                    Pair<Integer, TrackEncryptionBox> pairM3704c = m3704c(parsableByteArray, i5, i6);
                    if (pairM3704c != null) {
                        iM3086f3 = ((Integer) pairM3704c.first).intValue();
                        drmInitDataM8835a = drmInitData == null ? null : drmInitData.m8835a(((TrackEncryptionBox) pairM3704c.second).f8472b);
                        bVar4.f8355a[i4] = (TrackEncryptionBox) pairM3704c.second;
                    } else {
                        drmInitDataM8835a = drmInitData;
                    }
                    parsableByteArray.m3079E(i36);
                } else {
                    i5 = i35;
                    i6 = iM3086f2;
                    drmInitDataM8835a = drmInitData;
                }
                String str11 = iM3086f3 == 1831958048 ? "video/mpeg" : iM3086f3 == 1211250227 ? "video/3gpp" : null;
                float fM3103w = 1.0f;
                ByteBuffer byteBufferOrder = null;
                boolean z4 = false;
                DrmInitData drmInitData3 = drmInitDataM8835a;
                byte[] bArrCopyOfRange = null;
                String str12 = null;
                List<byte[]> list2 = null;
                int iM3124b = -1;
                int i37 = -1;
                int i38 = -1;
                int i39 = -1;
                while (true) {
                    if (i36 - i5 >= i6) {
                        bArr = bArrCopyOfRange;
                        i7 = iM3105y2;
                        i8 = iM3105y3;
                        bVar = bVar4;
                        i9 = i5;
                        i10 = i6;
                        i11 = i39;
                        break;
                    }
                    parsableByteArray.m3079E(i36);
                    int i40 = parsableByteArray.f6794b;
                    i11 = i39;
                    int iM3086f4 = parsableByteArray.m3086f();
                    bArr = bArrCopyOfRange;
                    if (iM3086f4 == 0 && parsableByteArray.f6794b - i5 == i6) {
                        i7 = iM3105y2;
                        i8 = iM3105y3;
                        bVar = bVar4;
                        i9 = i5;
                        i10 = i6;
                        break;
                    }
                    AnimatableValueParser.m559q(iM3086f4 > 0, str10);
                    int iM3086f5 = parsableByteArray.m3086f();
                    String str13 = str10;
                    if (iM3086f5 == 1635148611) {
                        AnimatableValueParser.m559q(str11 == null, null);
                        parsableByteArray.m3079E(i40 + 8);
                        AvcConfig avcConfigM3122b = AvcConfig.m3122b(parsableByteArray);
                        list = avcConfigM3122b.f6837a;
                        bVar4.f8357c = avcConfigM3122b.f6838b;
                        if (!z4) {
                            fM3103w = avcConfigM3122b.f6841e;
                        }
                        str12 = avcConfigM3122b.f6842f;
                        str2 = "video/avc";
                    } else if (iM3086f5 == 1752589123) {
                        AnimatableValueParser.m559q(str11 == null, null);
                        parsableByteArray.m3079E(i40 + 8);
                        HevcConfig hevcConfigM3131a = HevcConfig.m3131a(parsableByteArray);
                        list = hevcConfigM3131a.f6863a;
                        bVar4.f8357c = hevcConfigM3131a.f6864b;
                        if (!z4) {
                            fM3103w = hevcConfigM3131a.f6865c;
                        }
                        str12 = hevcConfigM3131a.f6866d;
                        str2 = "video/hevc";
                    } else {
                        if (iM3086f5 == 1685480259 || iM3086f5 == 1685485123) {
                            i14 = iM3105y2;
                            i15 = iM3105y3;
                            bVar3 = bVar4;
                            i16 = i5;
                            i17 = i6;
                            i18 = iM3086f3;
                            f = fM3103w;
                            DolbyVisionConfig dolbyVisionConfigM3126a = DolbyVisionConfig.m3126a(parsableByteArray);
                            if (dolbyVisionConfigM3126a != null) {
                                str11 = "video/dolby-vision";
                                str12 = dolbyVisionConfigM3126a.f6849a;
                            }
                        } else if (iM3086f5 == 1987076931) {
                            AnimatableValueParser.m559q(str11 == null, null);
                            str2 = iM3086f3 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                            list = list2;
                        } else {
                            if (iM3086f5 == 1635135811) {
                                AnimatableValueParser.m559q(str11 == null, null);
                                str11 = "video/av01";
                            } else if (iM3086f5 == 1668050025) {
                                if (byteBufferOrder == null) {
                                    byteBufferOrder = ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
                                }
                                ByteBuffer byteBuffer = byteBufferOrder;
                                byteBuffer.position(21);
                                byteBuffer.putShort(parsableByteArray.m3096p());
                                byteBuffer.putShort(parsableByteArray.m3096p());
                                byteBufferOrder = byteBuffer;
                            } else if (iM3086f5 == 1835295606) {
                                if (byteBufferOrder == null) {
                                    byteBufferOrder = ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
                                }
                                ByteBuffer byteBuffer2 = byteBufferOrder;
                                short sM3096p = parsableByteArray.m3096p();
                                short sM3096p2 = parsableByteArray.m3096p();
                                i18 = iM3086f3;
                                short sM3096p3 = parsableByteArray.m3096p();
                                i16 = i5;
                                short sM3096p4 = parsableByteArray.m3096p();
                                i17 = i6;
                                short sM3096p5 = parsableByteArray.m3096p();
                                bVar3 = bVar4;
                                short sM3096p6 = parsableByteArray.m3096p();
                                float f2 = fM3103w;
                                short sM3096p7 = parsableByteArray.m3096p();
                                i15 = iM3105y3;
                                short sM3096p8 = parsableByteArray.m3096p();
                                long jM3101u = parsableByteArray.m3101u();
                                long jM3101u2 = parsableByteArray.m3101u();
                                i14 = iM3105y2;
                                byteBuffer2.position(1);
                                byteBuffer2.putShort(sM3096p5);
                                byteBuffer2.putShort(sM3096p6);
                                byteBuffer2.putShort(sM3096p);
                                byteBuffer2.putShort(sM3096p2);
                                byteBuffer2.putShort(sM3096p3);
                                byteBuffer2.putShort(sM3096p4);
                                byteBuffer2.putShort(sM3096p7);
                                byteBuffer2.putShort(sM3096p8);
                                byteBuffer2.putShort((short) (jM3101u / 10000));
                                byteBuffer2.putShort((short) (jM3101u2 / 10000));
                                byteBufferOrder = byteBuffer2;
                                list = list2;
                                fM3103w = f2;
                                list2 = list;
                                bArrCopyOfRange = bArr;
                                i36 += iM3086f4;
                                i39 = i11;
                                str10 = str13;
                                iM3086f3 = i18;
                                i5 = i16;
                                i6 = i17;
                                bVar4 = bVar3;
                                iM3105y3 = i15;
                                iM3105y2 = i14;
                            } else {
                                i14 = iM3105y2;
                                i15 = iM3105y3;
                                bVar3 = bVar4;
                                i16 = i5;
                                i17 = i6;
                                i18 = iM3086f3;
                                f = fM3103w;
                                if (iM3086f5 == 1681012275) {
                                    AnimatableValueParser.m559q(str11 == null, null);
                                    str11 = "video/3gpp";
                                } else if (iM3086f5 == 1702061171) {
                                    AnimatableValueParser.m559q(str11 == null, null);
                                    Pair<String, byte[]> pairM3702a = m3702a(parsableByteArray, i40);
                                    str11 = (String) pairM3702a.first;
                                    byte[] bArr2 = (byte[]) pairM3702a.second;
                                    listM6266u = bArr2 != null ? ImmutableList2.m6266u(bArr2) : list2;
                                    bArrCopyOfRange = bArr;
                                    list2 = listM6266u;
                                    fM3103w = f;
                                    i36 += iM3086f4;
                                    i39 = i11;
                                    str10 = str13;
                                    iM3086f3 = i18;
                                    i5 = i16;
                                    i6 = i17;
                                    bVar4 = bVar3;
                                    iM3105y3 = i15;
                                    iM3105y2 = i14;
                                } else if (iM3086f5 == 1885434736) {
                                    parsableByteArray.m3079E(i40 + 8);
                                    fM3103w = parsableByteArray.m3103w() / parsableByteArray.m3103w();
                                    bArrCopyOfRange = bArr;
                                    z4 = true;
                                    i36 += iM3086f4;
                                    i39 = i11;
                                    str10 = str13;
                                    iM3086f3 = i18;
                                    i5 = i16;
                                    i6 = i17;
                                    bVar4 = bVar3;
                                    iM3105y3 = i15;
                                    iM3105y2 = i14;
                                } else if (iM3086f5 == 1937126244) {
                                    int i41 = i40 + 8;
                                    while (true) {
                                        if (i41 - i40 >= iM3086f4) {
                                            bArrCopyOfRange = null;
                                            break;
                                        }
                                        parsableByteArray.m3079E(i41);
                                        int iM3086f6 = parsableByteArray.m3086f();
                                        if (parsableByteArray.m3086f() == 1886547818) {
                                            bArrCopyOfRange = Arrays.copyOfRange(parsableByteArray.f6793a, i41, iM3086f6 + i41);
                                            break;
                                        }
                                        i41 += iM3086f6;
                                    }
                                    listM6266u = list2;
                                    list2 = listM6266u;
                                    fM3103w = f;
                                    i36 += iM3086f4;
                                    i39 = i11;
                                    str10 = str13;
                                    iM3086f3 = i18;
                                    i5 = i16;
                                    i6 = i17;
                                    bVar4 = bVar3;
                                    iM3105y3 = i15;
                                    iM3105y2 = i14;
                                } else if (iM3086f5 == 1936995172) {
                                    int iM3100t = parsableByteArray.m3100t();
                                    parsableByteArray.m3080F(3);
                                    if (iM3100t == 0) {
                                        int iM3100t2 = parsableByteArray.m3100t();
                                        if (iM3100t2 == 0) {
                                            i19 = 0;
                                        } else if (iM3100t2 == 1) {
                                            i19 = 1;
                                        } else if (iM3100t2 == 2) {
                                            i19 = 2;
                                        } else if (iM3100t2 == 3) {
                                            i19 = 3;
                                        }
                                        i11 = i19;
                                        bArrCopyOfRange = bArr;
                                        list2 = listM6266u;
                                        fM3103w = f;
                                    }
                                    i36 += iM3086f4;
                                    i39 = i11;
                                    str10 = str13;
                                    iM3086f3 = i18;
                                    i5 = i16;
                                    i6 = i17;
                                    bVar4 = bVar3;
                                    iM3105y3 = i15;
                                    iM3105y2 = i14;
                                } else if (iM3086f5 == 1668246642) {
                                    int iM3086f7 = parsableByteArray.m3086f();
                                    if (iM3086f7 == 1852009592 || iM3086f7 == 1852009571) {
                                        int iM3105y4 = parsableByteArray.m3105y();
                                        int iM3105y5 = parsableByteArray.m3105y();
                                        parsableByteArray.m3080F(2);
                                        boolean z5 = iM3086f4 == 19 && (parsableByteArray.m3100t() & 128) != 0;
                                        int iM3123a = ColorInfo.m3123a(iM3105y4);
                                        int i42 = z5 ? 1 : 2;
                                        i38 = iM3123a;
                                        iM3124b = ColorInfo.m3124b(iM3105y5);
                                        i37 = i42;
                                    } else {
                                        String strValueOf = String.valueOf(Atom.m3699a(iM3086f7));
                                        Log.w("AtomParsers", strValueOf.length() != 0 ? "Unsupported color type: ".concat(strValueOf) : new String("Unsupported color type: "));
                                    }
                                }
                            }
                            list = list2;
                            i14 = iM3105y2;
                            i15 = iM3105y3;
                            bVar3 = bVar4;
                            i16 = i5;
                            i17 = i6;
                            i18 = iM3086f3;
                            list2 = list;
                            bArrCopyOfRange = bArr;
                            i36 += iM3086f4;
                            i39 = i11;
                            str10 = str13;
                            iM3086f3 = i18;
                            i5 = i16;
                            i6 = i17;
                            bVar4 = bVar3;
                            iM3105y3 = i15;
                            iM3105y2 = i14;
                        }
                        i19 = i11;
                        i11 = i19;
                        bArrCopyOfRange = bArr;
                        list2 = listM6266u;
                        fM3103w = f;
                        i36 += iM3086f4;
                        i39 = i11;
                        str10 = str13;
                        iM3086f3 = i18;
                        i5 = i16;
                        i6 = i17;
                        bVar4 = bVar3;
                        iM3105y3 = i15;
                        iM3105y2 = i14;
                    }
                    str11 = str2;
                    i14 = iM3105y2;
                    i15 = iM3105y3;
                    bVar3 = bVar4;
                    i16 = i5;
                    i17 = i6;
                    i18 = iM3086f3;
                    list2 = list;
                    bArrCopyOfRange = bArr;
                    i36 += iM3086f4;
                    i39 = i11;
                    str10 = str13;
                    iM3086f3 = i18;
                    i5 = i16;
                    i6 = i17;
                    bVar4 = bVar3;
                    iM3105y3 = i15;
                    iM3105y2 = i14;
                }
                float f3 = fM3103w;
                if (str11 == null) {
                    bVar2 = bVar;
                } else {
                    Format2.b bVar5 = new Format2.b();
                    bVar5.m3278b(i);
                    bVar5.f7173k = str11;
                    bVar5.f7170h = str12;
                    bVar5.f7178p = i7;
                    bVar5.f7179q = i8;
                    bVar5.f7182t = f3;
                    bVar5.f7181s = i2;
                    bVar5.f7183u = bArr;
                    bVar5.f7184v = i11;
                    bVar5.f7175m = list2;
                    bVar5.f7176n = drmInitData3;
                    int i43 = i38;
                    if (i43 == -1) {
                        i13 = i37;
                        i12 = iM3124b;
                        if (i13 != -1 || i12 != -1 || byteBufferOrder != null) {
                        }
                        Format2 format2M3277a = bVar5.m3277a();
                        bVar2 = bVar;
                        bVar2.f8356b = format2M3277a;
                    } else {
                        i12 = iM3124b;
                        i13 = i37;
                    }
                    bVar5.f7185w = new ColorInfo(i43, i13, i12, byteBufferOrder != null ? byteBufferOrder.array() : null);
                    Format2 format2M3277a2 = bVar5.m3277a();
                    bVar2 = bVar;
                    bVar2.f8356b = format2M3277a2;
                }
            } else if (iM3086f3 == 1836069985 || iM3086f3 == 1701733217 || iM3086f3 == 1633889587 || iM3086f3 == 1700998451 || iM3086f3 == 1633889588 || iM3086f3 == 1835823201 || iM3086f3 == 1685353315 || iM3086f3 == 1685353317 || iM3086f3 == 1685353320 || iM3086f3 == 1685353324 || iM3086f3 == 1685353336 || iM3086f3 == 1935764850 || iM3086f3 == 1935767394 || iM3086f3 == 1819304813 || iM3086f3 == 1936684916 || iM3086f3 == 1953984371 || iM3086f3 == 778924082 || iM3086f3 == 778924083 || iM3086f3 == 1835557169 || iM3086f3 == 1835560241 || iM3086f3 == 1634492771 || iM3086f3 == 1634492791 || iM3086f3 == 1970037111 || iM3086f3 == 1332770163 || iM3086f3 == 1716281667) {
                parsableByteArray.m3079E(i35 + 8 + 8);
                if (z2) {
                    iM3105y = parsableByteArray.m3105y();
                    parsableByteArray.m3080F(6);
                } else {
                    parsableByteArray.m3080F(8);
                    iM3105y = 0;
                }
                if (iM3105y == 0 || iM3105y == 1) {
                    int iM3105y6 = parsableByteArray.m3105y();
                    parsableByteArray.m3080F(6);
                    byte[] bArr3 = parsableByteArray.f6793a;
                    int i44 = parsableByteArray.f6794b;
                    int i45 = i44 + 1;
                    parsableByteArray.f6794b = i45;
                    int i46 = (bArr3[i44] & 255) << 8;
                    i3 = iM3086f;
                    int i47 = i45 + 1;
                    parsableByteArray.f6794b = i47;
                    iRound = (bArr3[i45] & 255) | i46;
                    int i48 = i47 + 2;
                    parsableByteArray.f6794b = i48;
                    parsableByteArray.m3079E(i48 - 4);
                    int iM3086f8 = parsableByteArray.m3086f();
                    if (iM3105y == 1) {
                        parsableByteArray.m3080F(16);
                    }
                    iM3103w = iM3105y6;
                    i20 = iM3086f8;
                } else if (iM3105y == 2) {
                    parsableByteArray.m3080F(16);
                    iRound = (int) Math.round(Double.longBitsToDouble(parsableByteArray.m3093m()));
                    iM3103w = parsableByteArray.m3103w();
                    parsableByteArray.m3080F(20);
                    i20 = 0;
                    i3 = iM3086f;
                } else {
                    i3 = iM3086f;
                    i4 = i34;
                    i22 = i35;
                    i21 = iM3086f2;
                    bVar2 = bVar4;
                    i9 = i22;
                    i10 = i21;
                }
                int i49 = parsableByteArray.f6794b;
                if (iM3086f3 == 1701733217) {
                    Pair<Integer, TrackEncryptionBox> pairM3704c2 = m3704c(parsableByteArray, i35, iM3086f2);
                    if (pairM3704c2 != null) {
                        int iIntValue3 = ((Integer) pairM3704c2.first).intValue();
                        drmInitDataM8835a2 = drmInitData2 == null ? null : drmInitData2.m8835a(((TrackEncryptionBox) pairM3704c2.second).f8472b);
                        bVar4.f8355a[i34] = (TrackEncryptionBox) pairM3704c2.second;
                        iM3086f3 = iIntValue3;
                    } else {
                        drmInitDataM8835a2 = drmInitData2;
                    }
                    parsableByteArray.m3079E(i49);
                } else {
                    drmInitDataM8835a2 = drmInitData2;
                }
                String str14 = "audio/ac3";
                String str15 = "audio/raw";
                int i50 = iM3103w;
                if (iM3086f3 == 1633889587) {
                    str15 = "audio/ac3";
                } else if (iM3086f3 == 1700998451) {
                    str15 = "audio/eac3";
                } else if (iM3086f3 == 1633889588) {
                    str15 = "audio/ac4";
                } else {
                    if (iM3086f3 == 1685353315) {
                        str3 = "audio/vnd.dts";
                    } else if (iM3086f3 == 1685353320 || iM3086f3 == 1685353324) {
                        str3 = "audio/vnd.dts.hd";
                    } else if (iM3086f3 == 1685353317) {
                        str3 = "audio/vnd.dts.hd;profile=lbr";
                    } else if (iM3086f3 == 1685353336) {
                        str3 = "audio/vnd.dts.uhd;profile=p2";
                    } else if (iM3086f3 == 1935764850) {
                        str3 = "audio/3gpp";
                    } else if (iM3086f3 == 1935767394) {
                        str3 = "audio/amr-wb";
                    } else {
                        if (iM3086f3 == 1819304813 || iM3086f3 == 1936684916) {
                            i23 = 2;
                        } else if (iM3086f3 == 1953984371) {
                            i23 = 268435456;
                        } else if (iM3086f3 == 778924082 || iM3086f3 == 778924083) {
                            str3 = "audio/mpeg";
                        } else if (iM3086f3 == 1835557169) {
                            str3 = "audio/mha1";
                        } else if (iM3086f3 == 1835560241) {
                            str3 = "audio/mhm1";
                        } else if (iM3086f3 == 1634492771) {
                            str3 = "audio/alac";
                        } else if (iM3086f3 == 1634492791) {
                            str3 = "audio/g711-alaw";
                        } else if (iM3086f3 == 1970037111) {
                            str3 = "audio/g711-mlaw";
                        } else if (iM3086f3 == 1332770163) {
                            str3 = "audio/opus";
                        } else if (iM3086f3 == 1716281667) {
                            str3 = "audio/flac";
                        } else if (iM3086f3 == 1835823201) {
                            str3 = "audio/true-hd";
                        } else {
                            i23 = -1;
                            str15 = null;
                        }
                        int i51 = iRound;
                        iIntValue = i50;
                        str4 = null;
                        i4 = i34;
                        String str16 = str15;
                        i24 = i23;
                        str5 = str16;
                        listM6266u2 = null;
                        i25 = i49;
                        while (i25 - i35 < iM3086f2) {
                            parsableByteArray.m3079E(i25);
                            int iM3086f9 = parsableByteArray.m3086f();
                            if (iM3086f9 > 0) {
                                i27 = iM3086f2;
                                z3 = true;
                            } else {
                                i27 = iM3086f2;
                                z3 = false;
                            }
                            AnimatableValueParser.m559q(z3, str10);
                            int iM3086f10 = parsableByteArray.m3086f();
                            int i52 = i35;
                            if (iM3086f10 == 1835557187) {
                                int i53 = iM3086f9 - 13;
                                byte[] bArr4 = new byte[i53];
                                parsableByteArray.m3079E(i25 + 13);
                                System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr4, 0, i53);
                                parsableByteArray.f6794b += i53;
                                listM6266u2 = ImmutableList2.m6266u(bArr4);
                                str10 = str10;
                                i31 = iM3086f9;
                                i51 = i51;
                                str6 = str14;
                                i30 = i20;
                            } else {
                                int i54 = i51;
                                int i55 = iM3086f9;
                                String str17 = str10;
                                if (iM3086f10 == 1702061171) {
                                    i28 = i54;
                                    str6 = str14;
                                    i29 = 1702061171;
                                } else if (z2 && iM3086f10 == 2002876005) {
                                    i29 = 1702061171;
                                    i28 = i54;
                                    str6 = str14;
                                } else {
                                    if (iM3086f10 == 1684103987) {
                                        parsableByteArray.m3079E(i25 + 8);
                                        String string = Integer.toString(i);
                                        int i56 = Ac3Util.f7770b[(parsableByteArray.m3100t() & Opcodes.CHECKCAST) >> 6];
                                        int iM3100t3 = parsableByteArray.m3100t();
                                        int i57 = Ac3Util.f7772d[(iM3100t3 & 56) >> 3];
                                        if ((iM3100t3 & 4) != 0) {
                                            i57++;
                                        }
                                        Format2.b bVar6 = new Format2.b();
                                        bVar6.f7163a = string;
                                        bVar6.f7173k = str14;
                                        bVar6.f7186x = i57;
                                        bVar6.f7187y = i56;
                                        bVar6.f7176n = drmInitDataM8835a2;
                                        bVar6.f7165c = str9;
                                        bVar4.f8356b = bVar6.m3277a();
                                    } else if (iM3086f10 == 1684366131) {
                                        parsableByteArray.m3079E(i25 + 8);
                                        String string2 = Integer.toString(i);
                                        parsableByteArray.m3080F(2);
                                        int i58 = Ac3Util.f7770b[(parsableByteArray.m3100t() & Opcodes.CHECKCAST) >> 6];
                                        int iM3100t4 = parsableByteArray.m3100t();
                                        int i59 = Ac3Util.f7772d[(iM3100t4 & 14) >> 1];
                                        if ((iM3100t4 & 1) != 0) {
                                            i59++;
                                        }
                                        if (((parsableByteArray.m3100t() & 30) >> 1) > 0 && (parsableByteArray.m3100t() & 2) != 0) {
                                            i59 += 2;
                                        }
                                        String str18 = (parsableByteArray.m3081a() <= 0 || (parsableByteArray.m3100t() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc";
                                        Format2.b bVar7 = new Format2.b();
                                        bVar7.f7163a = string2;
                                        bVar7.f7173k = str18;
                                        bVar7.f7186x = i59;
                                        bVar7.f7187y = i58;
                                        bVar7.f7176n = drmInitDataM8835a2;
                                        bVar7.f7165c = str9;
                                        bVar4.f8356b = bVar7.m3277a();
                                    } else if (iM3086f10 == 1684103988) {
                                        parsableByteArray.m3079E(i25 + 8);
                                        String string3 = Integer.toString(i);
                                        parsableByteArray.m3080F(1);
                                        int i60 = ((parsableByteArray.m3100t() & 32) >> 5) == 1 ? 48000 : 44100;
                                        Format2.b bVar8 = new Format2.b();
                                        bVar8.f7163a = string3;
                                        bVar8.f7173k = "audio/ac4";
                                        bVar8.f7186x = 2;
                                        bVar8.f7187y = i60;
                                        bVar8.f7176n = drmInitDataM8835a2;
                                        bVar8.f7165c = str9;
                                        bVar4.f8356b = bVar8.m3277a();
                                    } else {
                                        if (iM3086f10 == 1684892784) {
                                            if (i20 <= 0) {
                                                throw outline.m884w0(60, "Invalid sample rate for Dolby TrueHD MLP stream: ", i20, null);
                                            }
                                            iIntValue = 2;
                                            i51 = i20;
                                            listM519g = listM6266u2;
                                        } else if (iM3086f10 == 1684305011) {
                                            Format2.b bVar9 = new Format2.b();
                                            bVar9.m3278b(i);
                                            bVar9.f7173k = str5;
                                            bVar9.f7186x = iIntValue;
                                            iIntValue2 = i54;
                                            bVar9.f7187y = iIntValue2;
                                            bVar9.f7176n = drmInitDataM8835a2;
                                            bVar9.f7165c = str9;
                                            bVar4.f8356b = bVar9.m3277a();
                                            str6 = str14;
                                            i51 = iIntValue2;
                                            listM519g = listM6266u2;
                                            str10 = str17;
                                            i31 = i55;
                                            i30 = i20;
                                            listM6266u2 = listM519g;
                                        } else {
                                            iIntValue2 = i54;
                                            if (iM3086f10 == 1682927731) {
                                                int i61 = i55 - 8;
                                                byte[] bArr5 = f8354a;
                                                byte[] bArrCopyOf = Arrays.copyOf(bArr5, bArr5.length + i61);
                                                parsableByteArray.m3079E(i25 + 8);
                                                parsableByteArray.m3085e(bArrCopyOf, bArr5.length, i61);
                                                listM519g = AnimatableValueParser.m519g(bArrCopyOf);
                                                i51 = iIntValue2;
                                            } else {
                                                if (iM3086f10 == 1684425825) {
                                                    int i62 = i55 - 12;
                                                    byte[] bArr6 = new byte[i62 + 4];
                                                    bArr6[0] = 102;
                                                    bArr6[1] = 76;
                                                    bArr6[2] = 97;
                                                    bArr6[3] = 67;
                                                    parsableByteArray.m3079E(i25 + 12);
                                                    str6 = str14;
                                                    System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr6, 4, i62);
                                                    parsableByteArray.f6794b += i62;
                                                    immutableList2M6266u = ImmutableList2.m6266u(bArr6);
                                                } else {
                                                    str6 = str14;
                                                    if (iM3086f10 == 1634492771) {
                                                        int i63 = i55 - 12;
                                                        byte[] bArr7 = new byte[i63];
                                                        parsableByteArray.m3079E(i25 + 12);
                                                        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr7, 0, i63);
                                                        parsableByteArray.f6794b += i63;
                                                        ParsableByteArray parsableByteArray2 = new ParsableByteArray(bArr7);
                                                        parsableByteArray2.m3079E(9);
                                                        int iM3100t5 = parsableByteArray2.m3100t();
                                                        parsableByteArray2.m3079E(20);
                                                        Pair pairCreate = Pair.create(Integer.valueOf(parsableByteArray2.m3103w()), Integer.valueOf(iM3100t5));
                                                        iIntValue2 = ((Integer) pairCreate.first).intValue();
                                                        iIntValue = ((Integer) pairCreate.second).intValue();
                                                        immutableList2M6266u = ImmutableList2.m6266u(bArr7);
                                                    }
                                                    i51 = iIntValue2;
                                                    listM519g = listM6266u2;
                                                    str10 = str17;
                                                    i31 = i55;
                                                    i30 = i20;
                                                    listM6266u2 = listM519g;
                                                }
                                                int i64 = iIntValue2;
                                                listM519g = immutableList2M6266u;
                                                i51 = i64;
                                                str10 = str17;
                                                i31 = i55;
                                                i30 = i20;
                                                listM6266u2 = listM519g;
                                            }
                                        }
                                        str6 = str14;
                                        str10 = str17;
                                        i31 = i55;
                                        i30 = i20;
                                        listM6266u2 = listM519g;
                                    }
                                    iIntValue2 = i54;
                                    str6 = str14;
                                    i51 = iIntValue2;
                                    listM519g = listM6266u2;
                                    str10 = str17;
                                    i31 = i55;
                                    i30 = i20;
                                    listM6266u2 = listM519g;
                                }
                                if (iM3086f10 != i29) {
                                    i32 = parsableByteArray.f6794b;
                                    AnimatableValueParser.m559q(i32 >= i25, null);
                                    while (true) {
                                        i31 = i55;
                                        if (i32 - i25 >= i31) {
                                            str10 = str17;
                                            i30 = i20;
                                            i33 = -1;
                                            i32 = -1;
                                            break;
                                        }
                                        parsableByteArray.m3079E(i32);
                                        int iM3086f11 = parsableByteArray.m3086f();
                                        str10 = str17;
                                        AnimatableValueParser.m559q(iM3086f11 > 0, str10);
                                        i30 = i20;
                                        if (parsableByteArray.m3086f() == 1702061171) {
                                            break;
                                        }
                                        i32 += iM3086f11;
                                        i55 = i31;
                                        i20 = i30;
                                        str17 = str10;
                                    }
                                } else {
                                    i32 = i25;
                                    str10 = str17;
                                    i31 = i55;
                                    i30 = i20;
                                }
                                i33 = -1;
                                if (i32 != i33) {
                                    Pair<String, byte[]> pairM3702a2 = m3702a(parsableByteArray, i32);
                                    str5 = (String) pairM3702a2.first;
                                    byte[] bArr8 = (byte[]) pairM3702a2.second;
                                    if (bArr8 != null) {
                                        if ("audio/mp4a-latm".equals(str5)) {
                                            AacUtil.b bVarM3489b = AacUtil.m3489b(new ParsableBitArray(bArr8), false);
                                            i28 = bVarM3489b.f7766a;
                                            iIntValue = bVarM3489b.f7767b;
                                            str7 = bVarM3489b.f7768c;
                                        } else {
                                            str7 = str4;
                                        }
                                        listM6266u2 = ImmutableList2.m6266u(bArr8);
                                        str4 = str7;
                                        i51 = i28;
                                    }
                                }
                                i51 = i28;
                                listM519g = listM6266u2;
                                listM6266u2 = listM519g;
                            }
                            i25 += i31;
                            i35 = i52;
                            iM3086f2 = i27;
                            i20 = i30;
                            str14 = str6;
                        }
                        i26 = i51;
                        i22 = i35;
                        i21 = iM3086f2;
                        if (bVar4.f8356b == null && str5 != null) {
                            Format2.b bVar10 = new Format2.b();
                            bVar10.m3278b(i);
                            bVar10.f7173k = str5;
                            bVar10.f7170h = str4;
                            bVar10.f7186x = iIntValue;
                            bVar10.f7187y = i26;
                            bVar10.f7188z = i24;
                            bVar10.f7175m = listM6266u2;
                            bVar10.f7176n = drmInitDataM8835a2;
                            bVar10.f7165c = str9;
                            bVar4.f8356b = bVar10.m3277a();
                        }
                        bVar2 = bVar4;
                        i9 = i22;
                        i10 = i21;
                    }
                    str15 = str3;
                }
                i23 = -1;
                int i512 = iRound;
                iIntValue = i50;
                str4 = null;
                i4 = i34;
                String str162 = str15;
                i24 = i23;
                str5 = str162;
                listM6266u2 = null;
                i25 = i49;
                while (i25 - i35 < iM3086f2) {
                }
                i26 = i512;
                i22 = i35;
                i21 = iM3086f2;
                if (bVar4.f8356b == null) {
                    Format2.b bVar102 = new Format2.b();
                    bVar102.m3278b(i);
                    bVar102.f7173k = str5;
                    bVar102.f7170h = str4;
                    bVar102.f7186x = iIntValue;
                    bVar102.f7187y = i26;
                    bVar102.f7188z = i24;
                    bVar102.f7175m = listM6266u2;
                    bVar102.f7176n = drmInitDataM8835a2;
                    bVar102.f7165c = str9;
                    bVar4.f8356b = bVar102.m3277a();
                }
                bVar2 = bVar4;
                i9 = i22;
                i10 = i21;
            } else {
                if (iM3086f3 == 1414810956 || iM3086f3 == 1954034535 || iM3086f3 == 2004251764 || iM3086f3 == 1937010800 || iM3086f3 == 1664495672) {
                    parsableByteArray.m3079E(i35 + 8 + 8);
                    long j = RecyclerView.FOREVER_NS;
                    String str19 = "application/ttml+xml";
                    if (iM3086f3 == 1414810956) {
                        immutableList2M6266u2 = null;
                        str8 = str19;
                        Format2.b bVar11 = new Format2.b();
                        bVar11.m3278b(i);
                        bVar11.f7173k = str8;
                        bVar11.f7165c = str9;
                        bVar11.f7177o = j;
                        bVar11.f7175m = immutableList2M6266u2;
                        bVar4.f8356b = bVar11.m3277a();
                    } else if (iM3086f3 == 1954034535) {
                        int i65 = (iM3086f2 - 8) - 8;
                        byte[] bArr9 = new byte[i65];
                        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr9, 0, i65);
                        parsableByteArray.f6794b += i65;
                        immutableList2M6266u2 = ImmutableList2.m6266u(bArr9);
                        str8 = "application/x-quicktime-tx3g";
                        Format2.b bVar112 = new Format2.b();
                        bVar112.m3278b(i);
                        bVar112.f7173k = str8;
                        bVar112.f7165c = str9;
                        bVar112.f7177o = j;
                        bVar112.f7175m = immutableList2M6266u2;
                        bVar4.f8356b = bVar112.m3277a();
                    } else {
                        if (iM3086f3 == 2004251764) {
                            str19 = "application/x-mp4-vtt";
                        } else if (iM3086f3 == 1937010800) {
                            j = 0;
                        } else {
                            if (iM3086f3 != 1664495672) {
                                throw new IllegalStateException();
                            }
                            bVar4.f8358d = 1;
                            str19 = "application/x-mp4-cea-608";
                        }
                        immutableList2M6266u2 = null;
                        str8 = str19;
                        Format2.b bVar1122 = new Format2.b();
                        bVar1122.m3278b(i);
                        bVar1122.f7173k = str8;
                        bVar1122.f7165c = str9;
                        bVar1122.f7177o = j;
                        bVar1122.f7175m = immutableList2M6266u2;
                        bVar4.f8356b = bVar1122.m3277a();
                    }
                } else if (iM3086f3 == 1835365492) {
                    parsableByteArray.m3079E(i35 + 8 + 8);
                    if (iM3086f3 == 1835365492) {
                        parsableByteArray.m3094n();
                        String strM3094n = parsableByteArray.m3094n();
                        if (strM3094n != null) {
                            Format2.b bVar12 = new Format2.b();
                            bVar12.m3278b(i);
                            bVar12.f7173k = strM3094n;
                            bVar4.f8356b = bVar12.m3277a();
                        }
                    }
                } else if (iM3086f3 == 1667329389) {
                    Format2.b bVar13 = new Format2.b();
                    bVar13.m3278b(i);
                    bVar13.f7173k = "application/x-camera-motion";
                    bVar4.f8356b = bVar13.m3277a();
                }
                i3 = iM3086f;
                bVar2 = bVar4;
                i4 = i34;
                i9 = i35;
                i10 = iM3086f2;
            }
            parsableByteArray.m3079E(i9 + i10);
            i34 = i4 + 1;
            str9 = str;
            bVar4 = bVar2;
            iM3086f = i3;
            drmInitData2 = drmInitData;
        }
        return bVar4;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x05e3  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x05ee  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0652  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0664  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ac  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<TrackSampleTable> m3706e(Atom.a aVar, GaplessInfoHolder gaplessInfoHolder, long j, @Nullable DrmInitData drmInitData, boolean z2, boolean z3, Function2<Track, Track> function2) throws ParserException {
        Track track;
        Function2<Track, Track> function22;
        Track trackApply;
        a dVar;
        boolean z4;
        int iM3103w;
        int iM3103w2;
        int iM3103w3;
        int i;
        int iMo3707a;
        ArrayList arrayList;
        String str;
        long[] jArrCopyOf;
        boolean z5;
        int i2;
        Track track2;
        int[] iArr;
        int i3;
        long[] jArr;
        int[] iArr2;
        long j2;
        int i4;
        long[] jArr2;
        int i5;
        int[] iArr3;
        long[] jArr3;
        TrackSampleTable trackSampleTable;
        long[] jArr4;
        int i6;
        int[] iArr4;
        int[] iArr5;
        TrackSampleTable trackSampleTable2;
        boolean z6;
        ArrayList arrayList2;
        boolean z7;
        long jM3101u;
        int i7;
        b bVarM3705d;
        long[] jArr5;
        long[] jArr6;
        Atom.a aVarM3700b;
        Pair pairCreate;
        int i8;
        int i9;
        long jM3086f;
        Atom.a aVar2 = aVar;
        ArrayList arrayList3 = new ArrayList();
        int i10 = 0;
        while (i10 < aVar2.f8352d.size()) {
            Atom.a aVar3 = aVar2.f8352d.get(i10);
            if (aVar3.f8349a != 1953653099) {
                arrayList2 = arrayList3;
                i = i10;
            } else {
                Atom.b bVarM3701c = aVar2.m3701c(1836476516);
                Objects.requireNonNull(bVarM3701c);
                Atom.a aVarM3700b2 = aVar3.m3700b(1835297121);
                Objects.requireNonNull(aVarM3700b2);
                Atom.b bVarM3701c2 = aVarM3700b2.m3701c(1751411826);
                Objects.requireNonNull(bVarM3701c2);
                ParsableByteArray parsableByteArray = bVarM3701c2.f8353b;
                parsableByteArray.m3079E(16);
                int iM3086f = parsableByteArray.m3086f();
                int i11 = iM3086f == 1936684398 ? 1 : iM3086f == 1986618469 ? 2 : (iM3086f == 1952807028 || iM3086f == 1935832172 || iM3086f == 1937072756 || iM3086f == 1668047728) ? 3 : iM3086f == 1835365473 ? 5 : -1;
                if (i11 == -1) {
                    track = null;
                    function22 = function2;
                    trackApply = function22.apply(track);
                    if (trackApply == null) {
                        Atom.a aVarM3700b3 = aVar3.m3700b(1835297121);
                        Objects.requireNonNull(aVarM3700b3);
                        Atom.a aVarM3700b4 = aVarM3700b3.m3700b(1835626086);
                        Objects.requireNonNull(aVarM3700b4);
                        Atom.a aVarM3700b5 = aVarM3700b4.m3700b(1937007212);
                        Objects.requireNonNull(aVarM3700b5);
                        Atom.b bVarM3701c3 = aVarM3700b5.m3701c(1937011578);
                        if (bVarM3701c3 != null) {
                            dVar = new c(bVarM3701c3, trackApply.f8465f);
                        } else {
                            Atom.b bVarM3701c4 = aVarM3700b5.m3701c(1937013298);
                            if (bVarM3701c4 == null) {
                                throw ParserException.m8755a("Track has no sample table size information", null);
                            }
                            dVar = new d(bVarM3701c4);
                        }
                        int iMo3708b = dVar.mo3708b();
                        if (iMo3708b == 0) {
                            trackSampleTable = new TrackSampleTable(trackApply, new long[0], new int[0], 0, new long[0], new int[0], 0L);
                            arrayList = arrayList3;
                            i = i10;
                        } else {
                            Atom.b bVarM3701c5 = aVarM3700b5.m3701c(1937007471);
                            if (bVarM3701c5 == null) {
                                bVarM3701c5 = aVarM3700b5.m3701c(1668232756);
                                Objects.requireNonNull(bVarM3701c5);
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            ParsableByteArray parsableByteArray2 = bVarM3701c5.f8353b;
                            Atom.b bVarM3701c6 = aVarM3700b5.m3701c(1937011555);
                            Objects.requireNonNull(bVarM3701c6);
                            ParsableByteArray parsableByteArray3 = bVarM3701c6.f8353b;
                            Atom.b bVarM3701c7 = aVarM3700b5.m3701c(1937011827);
                            Objects.requireNonNull(bVarM3701c7);
                            ParsableByteArray parsableByteArray4 = bVarM3701c7.f8353b;
                            Atom.b bVarM3701c8 = aVarM3700b5.m3701c(1937011571);
                            ParsableByteArray parsableByteArray5 = bVarM3701c8 != null ? bVarM3701c8.f8353b : null;
                            Atom.b bVarM3701c9 = aVarM3700b5.m3701c(1668576371);
                            ParsableByteArray parsableByteArray6 = bVarM3701c9 != null ? bVarM3701c9.f8353b : null;
                            parsableByteArray2.m3079E(12);
                            int iM3103w4 = parsableByteArray2.m3103w();
                            parsableByteArray3.m3079E(12);
                            int iM3103w5 = parsableByteArray3.m3103w();
                            AnimatableValueParser.m559q(parsableByteArray3.m3086f() == 1, "first_chunk must be 1");
                            parsableByteArray4.m3079E(12);
                            int iM3103w6 = parsableByteArray4.m3103w() - 1;
                            int iM3103w7 = parsableByteArray4.m3103w();
                            int i12 = iM3103w5;
                            int iM3103w8 = parsableByteArray4.m3103w();
                            if (parsableByteArray6 != null) {
                                parsableByteArray6.m3079E(12);
                                iM3103w = parsableByteArray6.m3103w();
                            } else {
                                iM3103w = 0;
                            }
                            if (parsableByteArray5 != null) {
                                parsableByteArray5.m3079E(12);
                                iM3103w2 = parsableByteArray5.m3103w();
                                if (iM3103w2 > 0) {
                                    iM3103w3 = parsableByteArray5.m3103w() - 1;
                                    i = i10;
                                    iMo3707a = dVar.mo3707a();
                                    arrayList = arrayList3;
                                    str = trackApply.f8465f.f7155w;
                                    if (iMo3707a == -1 && ("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && iM3103w6 == 0 && iM3103w == 0 && iM3103w2 == 0) {
                                        long[] jArrCopyOf2 = new long[iMo3708b];
                                        int[] iArrCopyOf = new int[iMo3708b];
                                        jArrCopyOf = new long[iMo3708b];
                                        int i13 = iM3103w2;
                                        int[] iArrCopyOf2 = new int[iMo3708b];
                                        int i14 = 0;
                                        int i15 = 0;
                                        int iM3103w9 = 0;
                                        long j3 = 0;
                                        long j4 = 0;
                                        long jM3104x = 0;
                                        int i16 = -1;
                                        int i17 = iM3103w8;
                                        int iM3103w10 = iM3103w7;
                                        int i18 = iM3103w3;
                                        int i19 = i13;
                                        int iM3086f2 = 0;
                                        int iM3103w11 = 0;
                                        int i20 = iM3103w6;
                                        int i21 = iM3103w;
                                        int i22 = 0;
                                        int i23 = 0;
                                        while (true) {
                                            if (i22 >= iMo3708b) {
                                                break;
                                            }
                                            boolean z8 = true;
                                            int i24 = i14;
                                            int i25 = iMo3708b;
                                            int iM3103w12 = i24;
                                            while (true) {
                                                if (i15 != 0) {
                                                    i4 = i18;
                                                    break;
                                                }
                                                i4 = i18;
                                                int i26 = i16 + 1;
                                                if (i26 == iM3103w4) {
                                                    z8 = false;
                                                } else {
                                                    jM3104x = z4 ? parsableByteArray2.m3104x() : parsableByteArray2.m3101u();
                                                    if (i26 == iM3103w12) {
                                                        iM3103w9 = parsableByteArray3.m3103w();
                                                        parsableByteArray3.m3080F(4);
                                                        i12--;
                                                        iM3103w12 = i12 > 0 ? parsableByteArray3.m3103w() - 1 : -1;
                                                    }
                                                    z8 = true;
                                                }
                                                i16 = i26;
                                                if (!z8) {
                                                    break;
                                                }
                                                i15 = iM3103w9;
                                                j4 = jM3104x;
                                                i18 = i4;
                                            }
                                            if (!z8) {
                                                Log.w("AtomParsers", "Unexpected end of chunk data");
                                                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i22);
                                                iArrCopyOf = Arrays.copyOf(iArrCopyOf, i22);
                                                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i22);
                                                iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i22);
                                                iMo3708b = i22;
                                                break;
                                            }
                                            if (parsableByteArray6 != null) {
                                                while (iM3103w11 == 0 && i21 > 0) {
                                                    iM3103w11 = parsableByteArray6.m3103w();
                                                    iM3086f2 = parsableByteArray6.m3086f();
                                                    i21--;
                                                }
                                                iM3103w11--;
                                            }
                                            int i27 = iM3086f2;
                                            jArrCopyOf2[i22] = j4;
                                            iArrCopyOf[i22] = dVar.mo3709c();
                                            if (iArrCopyOf[i22] > i23) {
                                                i23 = iArrCopyOf[i22];
                                            }
                                            ParsableByteArray parsableByteArray7 = parsableByteArray2;
                                            boolean z9 = z4;
                                            jArrCopyOf[i22] = j3 + i27;
                                            iArrCopyOf2[i22] = parsableByteArray5 == null ? 1 : 0;
                                            int iM3103w13 = i4;
                                            if (i22 == iM3103w13) {
                                                iArrCopyOf2[i22] = 1;
                                                i19--;
                                                if (i19 > 0) {
                                                    Objects.requireNonNull(parsableByteArray5);
                                                    iM3103w13 = parsableByteArray5.m3103w() - 1;
                                                }
                                            }
                                            long[] jArr7 = jArrCopyOf;
                                            int iM3086f3 = i17;
                                            int i28 = iM3103w12;
                                            j3 += iM3086f3;
                                            iM3103w10--;
                                            if (iM3103w10 == 0 && i20 > 0) {
                                                i20--;
                                                iM3103w10 = parsableByteArray4.m3103w();
                                                iM3086f3 = parsableByteArray4.m3086f();
                                            }
                                            j4 += iArrCopyOf[i22];
                                            i15--;
                                            i22++;
                                            iM3086f2 = i27;
                                            iMo3708b = i25;
                                            i14 = i28;
                                            jArrCopyOf = jArr7;
                                            i17 = iM3086f3;
                                            z4 = z9;
                                            i18 = iM3103w13;
                                            parsableByteArray2 = parsableByteArray7;
                                        }
                                        int i29 = i15;
                                        long j5 = j3 + iM3086f2;
                                        if (parsableByteArray6 != null) {
                                            while (i21 > 0) {
                                                if (parsableByteArray6.m3103w() != 0) {
                                                    z5 = false;
                                                    break;
                                                }
                                                parsableByteArray6.m3086f();
                                                i21--;
                                            }
                                            z5 = true;
                                            if (i19 != 0 && iM3103w10 == 0 && i29 == 0 && i20 == 0) {
                                                i2 = iM3103w11;
                                                if (i2 == 0 && z5) {
                                                    track2 = trackApply;
                                                }
                                                iArr = iArrCopyOf;
                                                i3 = i23;
                                                jArr = jArrCopyOf2;
                                                iArr2 = iArrCopyOf2;
                                                j2 = j5;
                                            } else {
                                                i2 = iM3103w11;
                                            }
                                            track2 = trackApply;
                                            int i30 = track2.f8460a;
                                            String str2 = z5 ? ", ctts invalid" : "";
                                            StringBuilder sb = new StringBuilder(str2.length() + 262);
                                            sb.append("Inconsistent stbl box for track ");
                                            sb.append(i30);
                                            sb.append(": remainingSynchronizationSamples ");
                                            sb.append(i19);
                                            sb.append(", remainingSamplesAtTimestampDelta ");
                                            sb.append(iM3103w10);
                                            sb.append(", remainingSamplesInChunk ");
                                            sb.append(i29);
                                            sb.append(", remainingTimestampDeltaChanges ");
                                            sb.append(i20);
                                            sb.append(", remainingSamplesAtTimestampOffset ");
                                            sb.append(i2);
                                            outline.m874r0(sb, str2, "AtomParsers");
                                            iArr = iArrCopyOf;
                                            i3 = i23;
                                            jArr = jArrCopyOf2;
                                            iArr2 = iArrCopyOf2;
                                            j2 = j5;
                                        } else {
                                            z5 = true;
                                            if (i19 != 0) {
                                                i2 = iM3103w11;
                                                track2 = trackApply;
                                                int i302 = track2.f8460a;
                                                if (z5) {
                                                }
                                                StringBuilder sb2 = new StringBuilder(str2.length() + 262);
                                                sb2.append("Inconsistent stbl box for track ");
                                                sb2.append(i302);
                                                sb2.append(": remainingSynchronizationSamples ");
                                                sb2.append(i19);
                                                sb2.append(", remainingSamplesAtTimestampDelta ");
                                                sb2.append(iM3103w10);
                                                sb2.append(", remainingSamplesInChunk ");
                                                sb2.append(i29);
                                                sb2.append(", remainingTimestampDeltaChanges ");
                                                sb2.append(i20);
                                                sb2.append(", remainingSamplesAtTimestampOffset ");
                                                sb2.append(i2);
                                                outline.m874r0(sb2, str2, "AtomParsers");
                                                iArr = iArrCopyOf;
                                                i3 = i23;
                                                jArr = jArrCopyOf2;
                                                iArr2 = iArrCopyOf2;
                                                j2 = j5;
                                            }
                                        }
                                    } else {
                                        long[] jArr8 = new long[iM3103w4];
                                        int[] iArr6 = new int[iM3103w4];
                                        int iM3103w14 = 0;
                                        long jM3104x2 = 0;
                                        int i31 = -1;
                                        int iM3103w15 = 0;
                                        while (true) {
                                            i31++;
                                            if (i31 == iM3103w4) {
                                                z6 = false;
                                            } else {
                                                jM3104x2 = z4 ? parsableByteArray2.m3104x() : parsableByteArray2.m3101u();
                                                if (i31 == iM3103w14) {
                                                    iM3103w15 = parsableByteArray3.m3103w();
                                                    parsableByteArray3.m3080F(4);
                                                    i12--;
                                                    iM3103w14 = i12 > 0 ? parsableByteArray3.m3103w() - 1 : -1;
                                                }
                                                z6 = true;
                                            }
                                            if (!z6) {
                                                break;
                                            }
                                            jArr8[i31] = jM3104x2;
                                            iArr6[i31] = iM3103w15;
                                        }
                                        long j6 = iM3103w8;
                                        int i32 = 8192 / iMo3707a;
                                        int iM2998f = 0;
                                        for (int i33 = 0; i33 < iM3103w4; i33++) {
                                            iM2998f += Util2.m2998f(iArr6[i33], i32);
                                        }
                                        jArr = new long[iM2998f];
                                        int[] iArr7 = new int[iM2998f];
                                        long[] jArr9 = new long[iM2998f];
                                        int[] iArr8 = new int[iM2998f];
                                        int i34 = 0;
                                        int i35 = 0;
                                        int i36 = 0;
                                        int i37 = 0;
                                        while (i34 < iM3103w4) {
                                            int i38 = iArr6[i34];
                                            long j7 = jArr8[i34];
                                            long[] jArr10 = jArr8;
                                            int[] iArr9 = iArr6;
                                            int iMax = i37;
                                            int i39 = i38;
                                            long j8 = j7;
                                            while (i39 > 0) {
                                                int iMin = Math.min(i32, i39);
                                                jArr[i36] = j8;
                                                iArr7[i36] = iMo3707a * iMin;
                                                iMax = Math.max(iMax, iArr7[i36]);
                                                jArr9[i36] = i35 * j6;
                                                iArr8[i36] = 1;
                                                j8 += iArr7[i36];
                                                i35 += iMin;
                                                i39 -= iMin;
                                                i36++;
                                                i32 = i32;
                                                iMo3707a = iMo3707a;
                                            }
                                            i34++;
                                            i37 = iMax;
                                            jArr8 = jArr10;
                                            iArr6 = iArr9;
                                        }
                                        j2 = j6 * i35;
                                        iArr2 = iArr8;
                                        iArr = iArr7;
                                        jArrCopyOf = jArr9;
                                        i3 = i37;
                                        track2 = trackApply;
                                    }
                                    long jM2985F = Util2.m2985F(j2, 1000000L, track2.f8462c);
                                    jArr2 = track2.f8467h;
                                    if (jArr2 != null) {
                                        Util2.m2986G(jArrCopyOf, 1000000L, track2.f8462c);
                                        trackSampleTable = new TrackSampleTable(track2, jArr, iArr, i3, jArrCopyOf, iArr2, jM2985F);
                                    } else {
                                        if (jArr2.length == 1 && track2.f8461b == 1 && jArrCopyOf.length >= 2) {
                                            long[] jArr11 = track2.f8468i;
                                            Objects.requireNonNull(jArr11);
                                            long j9 = jArr11[0];
                                            jArr3 = jArr;
                                            i5 = i3;
                                            iArr3 = iArr2;
                                            long jM2985F2 = Util2.m2985F(track2.f8467h[0], track2.f8462c, track2.f8463d) + j9;
                                            int length = jArrCopyOf.length - 1;
                                            if (jArrCopyOf[0] <= j9 && j9 < jArrCopyOf[Util2.m3000h(4, 0, length)] && jArrCopyOf[Util2.m3000h(jArrCopyOf.length - 4, 0, length)] < jM2985F2 && jM2985F2 <= j2) {
                                                long j10 = j2 - jM2985F2;
                                                long jM2985F3 = Util2.m2985F(j9 - jArrCopyOf[0], track2.f8465f.f7137K, track2.f8462c);
                                                long jM2985F4 = Util2.m2985F(j10, track2.f8465f.f7137K, track2.f8462c);
                                                if ((jM2985F3 != 0 || jM2985F4 != 0) && jM2985F3 <= 2147483647L && jM2985F4 <= 2147483647L) {
                                                    gaplessInfoHolder.f8985b = (int) jM2985F3;
                                                    gaplessInfoHolder.f8986c = (int) jM2985F4;
                                                    Util2.m2986G(jArrCopyOf, 1000000L, track2.f8462c);
                                                    trackSampleTable2 = new TrackSampleTable(track2, jArr3, iArr, i5, jArrCopyOf, iArr3, Util2.m2985F(track2.f8467h[0], 1000000L, track2.f8463d));
                                                }
                                                trackSampleTable = trackSampleTable2;
                                            }
                                        } else {
                                            i5 = i3;
                                            iArr3 = iArr2;
                                            jArr3 = jArr;
                                        }
                                        long[] jArr12 = track2.f8467h;
                                        if (jArr12.length == 1 && jArr12[0] == 0) {
                                            long[] jArr13 = track2.f8468i;
                                            Objects.requireNonNull(jArr13);
                                            long j11 = jArr13[0];
                                            for (int i40 = 0; i40 < jArrCopyOf.length; i40++) {
                                                jArrCopyOf[i40] = Util2.m2985F(jArrCopyOf[i40] - j11, 1000000L, track2.f8462c);
                                            }
                                            trackSampleTable2 = new TrackSampleTable(track2, jArr3, iArr, i5, jArrCopyOf, iArr3, Util2.m2985F(j2 - j11, 1000000L, track2.f8462c));
                                            trackSampleTable = trackSampleTable2;
                                        } else {
                                            boolean z10 = track2.f8461b == 1;
                                            int[] iArr10 = new int[jArr12.length];
                                            int[] iArr11 = new int[jArr12.length];
                                            long[] jArr14 = track2.f8468i;
                                            Objects.requireNonNull(jArr14);
                                            int i41 = 0;
                                            boolean z11 = false;
                                            int i42 = 0;
                                            int i43 = 0;
                                            while (true) {
                                                long[] jArr15 = track2.f8467h;
                                                if (i41 >= jArr15.length) {
                                                    break;
                                                }
                                                boolean z12 = z11;
                                                int i44 = i42;
                                                long j12 = jArr14[i41];
                                                if (j12 != -1) {
                                                    iArr5 = iArr11;
                                                    long jM2985F5 = Util2.m2985F(jArr15[i41], track2.f8462c, track2.f8463d);
                                                    iArr10[i41] = Util2.m2997e(jArrCopyOf, j12, true, true);
                                                    iArr5[i41] = Util2.m2994b(jArrCopyOf, j12 + jM2985F5, z10, false);
                                                    while (iArr10[i41] < iArr5[i41] && (iArr3[iArr10[i41]] & 1) == 0) {
                                                        iArr10[i41] = iArr10[i41] + 1;
                                                    }
                                                    int i45 = (iArr5[i41] - iArr10[i41]) + i44;
                                                    boolean z13 = i43 != iArr10[i41];
                                                    i42 = i45;
                                                    i43 = iArr5[i41];
                                                    z11 = z12 | z13;
                                                } else {
                                                    iArr5 = iArr11;
                                                    i42 = i44;
                                                    z11 = z12;
                                                }
                                                i41++;
                                                iArr11 = iArr5;
                                            }
                                            int[] iArr12 = iArr11;
                                            boolean z14 = z11 | (i42 != iMo3708b);
                                            long[] jArr16 = z14 ? new long[i42] : jArr3;
                                            int[] iArr13 = z14 ? new int[i42] : iArr;
                                            int i46 = z14 ? 0 : i5;
                                            int[] iArr14 = z14 ? new int[i42] : iArr3;
                                            long[] jArr17 = new long[i42];
                                            int i47 = 0;
                                            int i48 = 0;
                                            long j13 = 0;
                                            while (i47 < track2.f8467h.length) {
                                                long j14 = track2.f8468i[i47];
                                                int i49 = iArr10[i47];
                                                int[] iArr15 = iArr10;
                                                int i50 = iArr12[i47];
                                                if (z14) {
                                                    i6 = i46;
                                                    int i51 = i50 - i49;
                                                    System.arraycopy(jArr3, i49, jArr16, i48, i51);
                                                    System.arraycopy(iArr, i49, iArr13, i48, i51);
                                                    jArr4 = jArr3;
                                                    iArr4 = iArr3;
                                                    System.arraycopy(iArr4, i49, iArr14, i48, i51);
                                                } else {
                                                    jArr4 = jArr3;
                                                    i6 = i46;
                                                    iArr4 = iArr3;
                                                }
                                                i46 = i6;
                                                while (i49 < i50) {
                                                    int[] iArr16 = iArr14;
                                                    int i52 = i50;
                                                    int[] iArr17 = iArr4;
                                                    long[] jArr18 = jArrCopyOf;
                                                    long j15 = j13;
                                                    jArr17[i48] = Util2.m2985F(j13, 1000000L, track2.f8463d) + Util2.m2985F(Math.max(0L, jArrCopyOf[i49] - j14), 1000000L, track2.f8462c);
                                                    if (z14 && iArr13[i48] > i46) {
                                                        i46 = iArr[i49];
                                                    }
                                                    i48++;
                                                    i49++;
                                                    iArr14 = iArr16;
                                                    j13 = j15;
                                                    jArrCopyOf = jArr18;
                                                    iArr4 = iArr17;
                                                    i50 = i52;
                                                }
                                                j13 += track2.f8467h[i47];
                                                i47++;
                                                iArr10 = iArr15;
                                                iArr14 = iArr14;
                                                iArr3 = iArr4;
                                                jArr3 = jArr4;
                                            }
                                            trackSampleTable = new TrackSampleTable(track2, jArr16, iArr13, i46, jArr17, iArr14, Util2.m2985F(j13, 1000000L, track2.f8463d));
                                        }
                                    }
                                } else {
                                    parsableByteArray5 = null;
                                }
                            } else {
                                iM3103w2 = 0;
                            }
                            iM3103w3 = -1;
                            i = i10;
                            iMo3707a = dVar.mo3707a();
                            arrayList = arrayList3;
                            str = trackApply.f8465f.f7155w;
                            if (iMo3707a == -1) {
                                if (iMo3707a == -1 && ("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && iM3103w6 == 0 && iM3103w == 0 && iM3103w2 == 0) {
                                }
                                long jM2985F6 = Util2.m2985F(j2, 1000000L, track2.f8462c);
                                jArr2 = track2.f8467h;
                                if (jArr2 != null) {
                                }
                            }
                        }
                        arrayList2 = arrayList;
                        arrayList2.add(trackSampleTable);
                    }
                } else {
                    Atom.b bVarM3701c10 = aVar3.m3701c(1953196132);
                    Objects.requireNonNull(bVarM3701c10);
                    ParsableByteArray parsableByteArray8 = bVarM3701c10.f8353b;
                    parsableByteArray8.m3079E(8);
                    int iM3086f4 = (parsableByteArray8.m3086f() >> 24) & 255;
                    parsableByteArray8.m3080F(iM3086f4 != 0 ? 16 : 8);
                    int iM3086f5 = parsableByteArray8.m3086f();
                    parsableByteArray8.m3080F(4);
                    int i53 = parsableByteArray8.f6794b;
                    int i54 = iM3086f4 == 0 ? 4 : 8;
                    int i55 = 0;
                    while (true) {
                        if (i55 >= i54) {
                            z7 = true;
                            break;
                        }
                        if (parsableByteArray8.f6793a[i53 + i55] != -1) {
                            z7 = false;
                            break;
                        }
                        i55++;
                    }
                    if (z7) {
                        parsableByteArray8.m3080F(i54);
                    } else {
                        jM3101u = iM3086f4 == 0 ? parsableByteArray8.m3101u() : parsableByteArray8.m3104x();
                        if (jM3101u != 0) {
                            i7 = 16;
                        }
                        parsableByteArray8.m3080F(i7);
                        int iM3086f6 = parsableByteArray8.m3086f();
                        int iM3086f7 = parsableByteArray8.m3086f();
                        parsableByteArray8.m3080F(4);
                        int iM3086f8 = parsableByteArray8.m3086f();
                        int iM3086f9 = parsableByteArray8.m3086f();
                        int i56 = (iM3086f6 != 0 && iM3086f7 == 65536 && iM3086f8 == -65536 && iM3086f9 == 0) ? 90 : (iM3086f6 != 0 && iM3086f7 == -65536 && iM3086f8 == 65536 && iM3086f9 == 0) ? 270 : (iM3086f6 != -65536 && iM3086f7 == 0 && iM3086f8 == 0 && iM3086f9 == -65536) ? 180 : 0;
                        long j16 = j != -9223372036854775807L ? jM3101u : j;
                        ParsableByteArray parsableByteArray9 = bVarM3701c.f8353b;
                        parsableByteArray9.m3079E(8);
                        parsableByteArray9.m3080F(((parsableByteArray9.m3086f() >> 24) & 255) != 0 ? 8 : 16);
                        long jM3101u2 = parsableByteArray9.m3101u();
                        long jM2985F7 = j16 != -9223372036854775807L ? Util2.m2985F(j16, 1000000L, jM3101u2) : -9223372036854775807L;
                        Atom.a aVarM3700b6 = aVarM3700b2.m3700b(1835626086);
                        Objects.requireNonNull(aVarM3700b6);
                        Atom.a aVarM3700b7 = aVarM3700b6.m3700b(1937007212);
                        Objects.requireNonNull(aVarM3700b7);
                        Atom.b bVarM3701c11 = aVarM3700b2.m3701c(1835296868);
                        Objects.requireNonNull(bVarM3701c11);
                        ParsableByteArray parsableByteArray10 = bVarM3701c11.f8353b;
                        parsableByteArray10.m3079E(8);
                        int iM3086f10 = (parsableByteArray10.m3086f() >> 24) & 255;
                        parsableByteArray10.m3080F(iM3086f10 != 0 ? 8 : 16);
                        long jM3101u3 = parsableByteArray10.m3101u();
                        parsableByteArray10.m3080F(iM3086f10 != 0 ? 4 : 8);
                        int iM3105y = parsableByteArray10.m3105y();
                        StringBuilder sb3 = new StringBuilder(3);
                        sb3.append((char) (((iM3105y >> 10) & 31) + 96));
                        sb3.append((char) (((iM3105y >> 5) & 31) + 96));
                        sb3.append((char) ((iM3105y & 31) + 96));
                        Pair pairCreate2 = Pair.create(Long.valueOf(jM3101u3), sb3.toString());
                        Atom.b bVarM3701c12 = aVarM3700b7.m3701c(1937011556);
                        Objects.requireNonNull(bVarM3701c12);
                        bVarM3705d = m3705d(bVarM3701c12.f8353b, iM3086f5, i56, (String) pairCreate2.second, drmInitData, z3);
                        if (!z2 || (aVarM3700b = aVar3.m3700b(1701082227)) == null) {
                            jArr5 = null;
                            jArr6 = null;
                            if (bVarM3705d.f8356b != null) {
                                Track track3 = new Track(iM3086f5, i11, ((Long) pairCreate2.first).longValue(), jM3101u2, jM2985F7, bVarM3705d.f8356b, bVarM3705d.f8358d, bVarM3705d.f8355a, bVarM3705d.f8357c, jArr5, jArr6);
                                function22 = function2;
                                track = track3;
                            }
                            trackApply = function22.apply(track);
                            if (trackApply == null) {
                            }
                        } else {
                            Atom.b bVarM3701c13 = aVarM3700b.m3701c(1701606260);
                            if (bVarM3701c13 == null) {
                                pairCreate = null;
                            } else {
                                ParsableByteArray parsableByteArray11 = bVarM3701c13.f8353b;
                                parsableByteArray11.m3079E(8);
                                int iM3086f11 = (parsableByteArray11.m3086f() >> 24) & 255;
                                int iM3103w16 = parsableByteArray11.m3103w();
                                long[] jArr19 = new long[iM3103w16];
                                long[] jArr20 = new long[iM3103w16];
                                int i57 = 0;
                                while (i57 < iM3103w16) {
                                    jArr19[i57] = iM3086f11 == 1 ? parsableByteArray11.m3104x() : parsableByteArray11.m3101u();
                                    if (iM3086f11 == 1) {
                                        i9 = iM3103w16;
                                        i8 = iM3086f11;
                                        jM3086f = parsableByteArray11.m3093m();
                                    } else {
                                        i8 = iM3086f11;
                                        i9 = iM3103w16;
                                        jM3086f = parsableByteArray11.m3086f();
                                    }
                                    jArr20[i57] = jM3086f;
                                    if (parsableByteArray11.m3096p() != 1) {
                                        throw new IllegalArgumentException("Unsupported media rate.");
                                    }
                                    parsableByteArray11.m3080F(2);
                                    i57++;
                                    iM3086f11 = i8;
                                    iM3103w16 = i9;
                                }
                                pairCreate = Pair.create(jArr19, jArr20);
                            }
                            if (pairCreate != null) {
                                long[] jArr21 = (long[]) pairCreate.first;
                                jArr6 = (long[]) pairCreate.second;
                                jArr5 = jArr21;
                            }
                            if (bVarM3705d.f8356b != null) {
                            }
                            trackApply = function22.apply(track);
                            if (trackApply == null) {
                            }
                        }
                    }
                    i7 = 16;
                    jM3101u = -9223372036854775807L;
                    parsableByteArray8.m3080F(i7);
                    int iM3086f62 = parsableByteArray8.m3086f();
                    int iM3086f72 = parsableByteArray8.m3086f();
                    parsableByteArray8.m3080F(4);
                    int iM3086f82 = parsableByteArray8.m3086f();
                    int iM3086f92 = parsableByteArray8.m3086f();
                    if (iM3086f62 != 0) {
                        if (iM3086f62 != 0) {
                            if (iM3086f62 != -65536) {
                                if (j != -9223372036854775807L) {
                                }
                                ParsableByteArray parsableByteArray92 = bVarM3701c.f8353b;
                                parsableByteArray92.m3079E(8);
                                parsableByteArray92.m3080F(((parsableByteArray92.m3086f() >> 24) & 255) != 0 ? 8 : 16);
                                long jM3101u22 = parsableByteArray92.m3101u();
                                long jM2985F72 = j16 != -9223372036854775807L ? Util2.m2985F(j16, 1000000L, jM3101u22) : -9223372036854775807L;
                                Atom.a aVarM3700b62 = aVarM3700b2.m3700b(1835626086);
                                Objects.requireNonNull(aVarM3700b62);
                                Atom.a aVarM3700b72 = aVarM3700b62.m3700b(1937007212);
                                Objects.requireNonNull(aVarM3700b72);
                                Atom.b bVarM3701c112 = aVarM3700b2.m3701c(1835296868);
                                Objects.requireNonNull(bVarM3701c112);
                                ParsableByteArray parsableByteArray102 = bVarM3701c112.f8353b;
                                parsableByteArray102.m3079E(8);
                                int iM3086f102 = (parsableByteArray102.m3086f() >> 24) & 255;
                                parsableByteArray102.m3080F(iM3086f102 != 0 ? 8 : 16);
                                long jM3101u32 = parsableByteArray102.m3101u();
                                parsableByteArray102.m3080F(iM3086f102 != 0 ? 4 : 8);
                                int iM3105y2 = parsableByteArray102.m3105y();
                                StringBuilder sb32 = new StringBuilder(3);
                                sb32.append((char) (((iM3105y2 >> 10) & 31) + 96));
                                sb32.append((char) (((iM3105y2 >> 5) & 31) + 96));
                                sb32.append((char) ((iM3105y2 & 31) + 96));
                                Pair pairCreate22 = Pair.create(Long.valueOf(jM3101u32), sb32.toString());
                                Atom.b bVarM3701c122 = aVarM3700b72.m3701c(1937011556);
                                Objects.requireNonNull(bVarM3701c122);
                                bVarM3705d = m3705d(bVarM3701c122.f8353b, iM3086f5, i56, (String) pairCreate22.second, drmInitData, z3);
                                if (z2) {
                                    jArr5 = null;
                                    jArr6 = null;
                                    if (bVarM3705d.f8356b != null) {
                                    }
                                    trackApply = function22.apply(track);
                                    if (trackApply == null) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            i10 = i + 1;
            aVar2 = aVar;
            arrayList3 = arrayList2;
        }
        return arrayList3;
    }
}
