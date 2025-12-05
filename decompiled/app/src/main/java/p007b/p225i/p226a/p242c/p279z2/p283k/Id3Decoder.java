package p007b.p225i.p226a.p242c.p279z2.p283k;

import android.util.Log;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.BinaryFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p259f3.ParsableBitArray;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p279z2.MetadataInputBuffer;
import p007b.p225i.p226a.p242c.p279z2.SimpleMetadataDecoder;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: Id3Decoder.java */
/* renamed from: b.i.a.c.z2.k.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class Id3Decoder extends SimpleMetadataDecoder {

    /* renamed from: a */
    public static final /* synthetic */ int f9154a = 0;

    /* renamed from: b */
    @Nullable
    public final a f9155b;

    /* compiled from: Id3Decoder.java */
    /* renamed from: b.i.a.c.z2.k.b$a */
    public interface a {
        /* renamed from: a */
        boolean mo3688a(int i, int i2, int i3, int i4, int i5);
    }

    /* compiled from: Id3Decoder.java */
    /* renamed from: b.i.a.c.z2.k.b$b */
    public static final class b {

        /* renamed from: a */
        public final int f9156a;

        /* renamed from: b */
        public final boolean f9157b;

        /* renamed from: c */
        public final int f9158c;

        public b(int i, boolean z2, int i2) {
            this.f9156a = i;
            this.f9157b = z2;
            this.f9158c = i2;
        }
    }

    public Id3Decoder() {
        this.f9155b = null;
    }

    /* renamed from: c */
    public static byte[] m3900c(byte[] bArr, int i, int i2) {
        return i2 <= i ? Util2.f6713f : Arrays.copyOfRange(bArr, i, i2);
    }

    /* renamed from: e */
    public static ApicFrame m3901e(ParsableByteArray parsableByteArray, int i, int i2) throws UnsupportedEncodingException {
        int iM3919w;
        String strConcat;
        int iM3100t = parsableByteArray.m3100t();
        String strM3916t = m3916t(iM3100t);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr, 0, i3);
        parsableByteArray.f6794b += i3;
        if (i2 == 2) {
            String strValueOf = String.valueOf(C3404f.m4349u1(new String(bArr, 0, 3, "ISO-8859-1")));
            String strConcat2 = strValueOf.length() != 0 ? "image/".concat(strValueOf) : new String("image/");
            if ("image/jpg".equals(strConcat2)) {
                strConcat2 = "image/jpeg";
            }
            strConcat = strConcat2;
            iM3919w = 2;
        } else {
            iM3919w = m3919w(bArr, 0);
            String strM4349u1 = C3404f.m4349u1(new String(bArr, 0, iM3919w, "ISO-8859-1"));
            strConcat = strM4349u1.indexOf(47) == -1 ? strM4349u1.length() != 0 ? "image/".concat(strM4349u1) : new String("image/") : strM4349u1;
        }
        int i4 = bArr[iM3919w + 1] & 255;
        int i5 = iM3919w + 2;
        int iM3918v = m3918v(bArr, i5, iM3100t);
        return new ApicFrame(strConcat, new String(bArr, i5, iM3918v - i5, strM3916t), i4, m3900c(bArr, m3915s(iM3100t) + iM3918v, i3));
    }

    /* renamed from: f */
    public static BinaryFrame m3902f(ParsableByteArray parsableByteArray, int i, String str) {
        byte[] bArr = new byte[i];
        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr, 0, i);
        parsableByteArray.f6794b += i;
        return new BinaryFrame(str, bArr);
    }

    /* renamed from: g */
    public static ChapterFrame m3903g(ParsableByteArray parsableByteArray, int i, int i2, boolean z2, int i3, @Nullable a aVar) throws UnsupportedEncodingException {
        int i4 = parsableByteArray.f6794b;
        int iM3919w = m3919w(parsableByteArray.f6793a, i4);
        String str = new String(parsableByteArray.f6793a, i4, iM3919w - i4, "ISO-8859-1");
        parsableByteArray.m3079E(iM3919w + 1);
        int iM3086f = parsableByteArray.m3086f();
        int iM3086f2 = parsableByteArray.m3086f();
        long jM3101u = parsableByteArray.m3101u();
        long j = jM3101u == 4294967295L ? -1L : jM3101u;
        long jM3101u2 = parsableByteArray.m3101u();
        long j2 = jM3101u2 == 4294967295L ? -1L : jM3101u2;
        ArrayList arrayList = new ArrayList();
        int i5 = i4 + i;
        while (parsableByteArray.f6794b < i5) {
            Id3Frame id3FrameM3906j = m3906j(i2, parsableByteArray, z2, i3, aVar);
            if (id3FrameM3906j != null) {
                arrayList.add(id3FrameM3906j);
            }
        }
        return new ChapterFrame(str, iM3086f, iM3086f2, j, j2, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    /* renamed from: h */
    public static ChapterTocFrame m3904h(ParsableByteArray parsableByteArray, int i, int i2, boolean z2, int i3, @Nullable a aVar) throws UnsupportedEncodingException {
        int i4 = parsableByteArray.f6794b;
        int iM3919w = m3919w(parsableByteArray.f6793a, i4);
        String str = new String(parsableByteArray.f6793a, i4, iM3919w - i4, "ISO-8859-1");
        parsableByteArray.m3079E(iM3919w + 1);
        int iM3100t = parsableByteArray.m3100t();
        boolean z3 = (iM3100t & 2) != 0;
        boolean z4 = (iM3100t & 1) != 0;
        int iM3100t2 = parsableByteArray.m3100t();
        String[] strArr = new String[iM3100t2];
        for (int i5 = 0; i5 < iM3100t2; i5++) {
            int i6 = parsableByteArray.f6794b;
            int iM3919w2 = m3919w(parsableByteArray.f6793a, i6);
            strArr[i5] = new String(parsableByteArray.f6793a, i6, iM3919w2 - i6, "ISO-8859-1");
            parsableByteArray.m3079E(iM3919w2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i7 = i4 + i;
        while (parsableByteArray.f6794b < i7) {
            Id3Frame id3FrameM3906j = m3906j(i2, parsableByteArray, z2, i3, aVar);
            if (id3FrameM3906j != null) {
                arrayList.add(id3FrameM3906j);
            }
        }
        return new ChapterTocFrame(str, z3, z4, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    @Nullable
    /* renamed from: i */
    public static CommentFrame m3905i(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int iM3100t = parsableByteArray.m3100t();
        String strM3916t = m3916t(iM3100t);
        byte[] bArr = new byte[3];
        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr, 0, 3);
        parsableByteArray.f6794b += 3;
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr2, 0, i2);
        parsableByteArray.f6794b += i2;
        int iM3918v = m3918v(bArr2, 0, iM3100t);
        String str2 = new String(bArr2, 0, iM3918v, strM3916t);
        int iM3915s = m3915s(iM3100t) + iM3918v;
        return new CommentFrame(str, str2, m3910n(bArr2, iM3915s, m3918v(bArr2, iM3915s, iM3100t), strM3916t));
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e2 A[Catch: all -> 0x0126, UnsupportedEncodingException -> 0x021a, TryCatch #1 {UnsupportedEncodingException -> 0x021a, blocks: (B:91:0x0114, B:159:0x01ec, B:93:0x011c, B:102:0x0135, B:104:0x013d, B:112:0x0157, B:121:0x016f, B:132:0x018a, B:139:0x019c, B:145:0x01ab, B:150:0x01c3, B:156:0x01dd, B:157:0x01e2), top: B:169:0x010a, outer: #0 }] */
    @Nullable
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Id3Frame m3906j(int i, ParsableByteArray parsableByteArray, boolean z2, int i2, @Nullable a aVar) {
        int iM3103w;
        String str;
        int i3;
        int i4;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Id3Frame id3FrameM3905i;
        int iM3100t = parsableByteArray.m3100t();
        int iM3100t2 = parsableByteArray.m3100t();
        int iM3100t3 = parsableByteArray.m3100t();
        int iM3100t4 = i >= 3 ? parsableByteArray.m3100t() : 0;
        if (i == 4) {
            iM3103w = parsableByteArray.m3103w();
            if (!z2) {
                iM3103w = (((iM3103w >> 24) & 255) << 21) | (iM3103w & 255) | (((iM3103w >> 8) & 255) << 7) | (((iM3103w >> 16) & 255) << 14);
            }
        } else {
            iM3103w = i == 3 ? parsableByteArray.m3103w() : parsableByteArray.m3102v();
        }
        int iM3920x = iM3103w;
        int iM3105y = i >= 3 ? parsableByteArray.m3105y() : 0;
        if (iM3100t == 0 && iM3100t2 == 0 && iM3100t3 == 0 && iM3100t4 == 0 && iM3920x == 0 && iM3105y == 0) {
            parsableByteArray.m3079E(parsableByteArray.f6795c);
            return null;
        }
        int i5 = parsableByteArray.f6794b + iM3920x;
        if (i5 > parsableByteArray.f6795c) {
            Log.w("Id3Decoder", "Frame size exceeds remaining tag data");
            parsableByteArray.m3079E(parsableByteArray.f6795c);
            return null;
        }
        if (aVar != null) {
            str = "Id3Decoder";
            i3 = i5;
            i4 = iM3105y;
            if (!aVar.mo3688a(i, iM3100t, iM3100t2, iM3100t3, iM3100t4)) {
                parsableByteArray.m3079E(i3);
                return null;
            }
        } else {
            str = "Id3Decoder";
            i3 = i5;
            i4 = iM3105y;
        }
        if (i == 3) {
            int i6 = i4;
            z4 = (i6 & 128) != 0;
            z5 = (i6 & 64) != 0;
            z3 = (i6 & 32) != 0;
            z7 = z4;
            z6 = false;
        } else {
            int i7 = i4;
            if (i == 4) {
                boolean z8 = (i7 & 64) != 0;
                boolean z9 = (i7 & 8) != 0;
                boolean z10 = (i7 & 4) != 0;
                z6 = (i7 & 2) != 0;
                boolean z11 = (i7 & 1) != 0;
                z3 = z8;
                z4 = z11;
                z7 = z9;
                z5 = z10;
            } else {
                z3 = false;
                z4 = false;
                z5 = false;
                z6 = false;
                z7 = false;
            }
        }
        if (z7 || z5) {
            Log.w(str, "Skipping unsupported compressed or encrypted frame");
            parsableByteArray.m3079E(i3);
            return null;
        }
        if (z3) {
            iM3920x--;
            parsableByteArray.m3080F(1);
        }
        if (z4) {
            iM3920x -= 4;
            parsableByteArray.m3080F(4);
        }
        if (z6) {
            iM3920x = m3920x(parsableByteArray, iM3920x);
        }
        try {
            try {
                if (iM3100t == 84 && iM3100t2 == 88 && iM3100t3 == 88 && (i == 2 || iM3100t4 == 88)) {
                    id3FrameM3905i = m3912p(parsableByteArray, iM3920x);
                } else if (iM3100t == 84) {
                    id3FrameM3905i = m3911o(parsableByteArray, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                } else if (iM3100t == 87 && iM3100t2 == 88 && iM3100t3 == 88 && (i == 2 || iM3100t4 == 88)) {
                    id3FrameM3905i = m3914r(parsableByteArray, iM3920x);
                } else if (iM3100t == 87) {
                    id3FrameM3905i = m3913q(parsableByteArray, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                } else if (iM3100t == 80 && iM3100t2 == 82 && iM3100t3 == 73 && iM3100t4 == 86) {
                    id3FrameM3905i = m3909m(parsableByteArray, iM3920x);
                } else if (iM3100t == 71 && iM3100t2 == 69 && iM3100t3 == 79 && (iM3100t4 == 66 || i == 2)) {
                    id3FrameM3905i = m3907k(parsableByteArray, iM3920x);
                } else if (i == 2) {
                    if (iM3100t == 80 && iM3100t2 == 73 && iM3100t3 == 67) {
                        id3FrameM3905i = m3901e(parsableByteArray, iM3920x, i);
                    }
                    id3FrameM3905i = (iM3100t != 67 && iM3100t2 == 79 && iM3100t3 == 77 && (iM3100t4 == 77 || i == 2)) ? m3905i(parsableByteArray, iM3920x) : (iM3100t != 67 && iM3100t2 == 72 && iM3100t3 == 65 && iM3100t4 == 80) ? m3903g(parsableByteArray, iM3920x, i, z2, i2, aVar) : (iM3100t != 67 && iM3100t2 == 84 && iM3100t3 == 79 && iM3100t4 == 67) ? m3904h(parsableByteArray, iM3920x, i, z2, i2, aVar) : (iM3100t != 77 && iM3100t2 == 76 && iM3100t3 == 76 && iM3100t4 == 84) ? m3908l(parsableByteArray, iM3920x) : m3902f(parsableByteArray, iM3920x, m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4));
                } else if (iM3100t == 65 && iM3100t2 == 80 && iM3100t3 == 73 && iM3100t4 == 67) {
                    id3FrameM3905i = m3901e(parsableByteArray, iM3920x, i);
                } else if (iM3100t != 67) {
                }
                if (id3FrameM3905i == null) {
                    String strM3917u = m3917u(i, iM3100t, iM3100t2, iM3100t3, iM3100t4);
                    StringBuilder sb = new StringBuilder(String.valueOf(strM3917u).length() + 50);
                    sb.append("Failed to decode frame: id=");
                    sb.append(strM3917u);
                    sb.append(", frameSize=");
                    sb.append(iM3920x);
                    Log.w(str, sb.toString());
                }
                parsableByteArray.m3079E(i3);
                return id3FrameM3905i;
            } catch (UnsupportedEncodingException unused) {
                Log.w(str, "Unsupported character encoding");
                parsableByteArray.m3079E(i3);
                return null;
            }
        } catch (Throwable th) {
            parsableByteArray.m3079E(i3);
            throw th;
        }
    }

    /* renamed from: k */
    public static GeobFrame m3907k(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        int iM3100t = parsableByteArray.m3100t();
        String strM3916t = m3916t(iM3100t);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr, 0, i2);
        parsableByteArray.f6794b += i2;
        int iM3919w = m3919w(bArr, 0);
        String str = new String(bArr, 0, iM3919w, "ISO-8859-1");
        int i3 = iM3919w + 1;
        int iM3918v = m3918v(bArr, i3, iM3100t);
        String strM3910n = m3910n(bArr, i3, iM3918v, strM3916t);
        int iM3915s = m3915s(iM3100t) + iM3918v;
        int iM3918v2 = m3918v(bArr, iM3915s, iM3100t);
        return new GeobFrame(str, strM3910n, m3910n(bArr, iM3915s, iM3918v2, strM3916t), m3900c(bArr, m3915s(iM3100t) + iM3918v2, i2));
    }

    /* renamed from: l */
    public static MlltFrame m3908l(ParsableByteArray parsableByteArray, int i) {
        int iM3105y = parsableByteArray.m3105y();
        int iM3102v = parsableByteArray.m3102v();
        int iM3102v2 = parsableByteArray.m3102v();
        int iM3100t = parsableByteArray.m3100t();
        int iM3100t2 = parsableByteArray.m3100t();
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.m3070j(parsableByteArray.f6793a, parsableByteArray.f6795c);
        parsableBitArray.m3071k(parsableByteArray.f6794b * 8);
        int i2 = ((i - 10) * 8) / (iM3100t + iM3100t2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iM3067g = parsableBitArray.m3067g(iM3100t);
            int iM3067g2 = parsableBitArray.m3067g(iM3100t2);
            iArr[i3] = iM3067g;
            iArr2[i3] = iM3067g2;
        }
        return new MlltFrame(iM3105y, iM3102v, iM3102v2, iArr, iArr2);
    }

    /* renamed from: m */
    public static PrivFrame m3909m(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr, 0, i);
        parsableByteArray.f6794b += i;
        int iM3919w = m3919w(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iM3919w, "ISO-8859-1"), m3900c(bArr, iM3919w + 1, i));
    }

    /* renamed from: n */
    public static String m3910n(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    @Nullable
    /* renamed from: o */
    public static TextInformationFrame m3911o(ParsableByteArray parsableByteArray, int i, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iM3100t = parsableByteArray.m3100t();
        String strM3916t = m3916t(iM3100t);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr, 0, i2);
        parsableByteArray.f6794b += i2;
        return new TextInformationFrame(str, null, new String(bArr, 0, m3918v(bArr, 0, iM3100t), strM3916t));
    }

    @Nullable
    /* renamed from: p */
    public static TextInformationFrame m3912p(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iM3100t = parsableByteArray.m3100t();
        String strM3916t = m3916t(iM3100t);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr, 0, i2);
        parsableByteArray.f6794b += i2;
        int iM3918v = m3918v(bArr, 0, iM3100t);
        String str = new String(bArr, 0, iM3918v, strM3916t);
        int iM3915s = m3915s(iM3100t) + iM3918v;
        return new TextInformationFrame("TXXX", str, m3910n(bArr, iM3915s, m3918v(bArr, iM3915s, iM3100t), strM3916t));
    }

    /* renamed from: q */
    public static UrlLinkFrame m3913q(ParsableByteArray parsableByteArray, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr, 0, i);
        parsableByteArray.f6794b += i;
        return new UrlLinkFrame(str, null, new String(bArr, 0, m3919w(bArr, 0), "ISO-8859-1"));
    }

    @Nullable
    /* renamed from: r */
    public static UrlLinkFrame m3914r(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int iM3100t = parsableByteArray.m3100t();
        String strM3916t = m3916t(iM3100t);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr, 0, i2);
        parsableByteArray.f6794b += i2;
        int iM3918v = m3918v(bArr, 0, iM3100t);
        String str = new String(bArr, 0, iM3918v, strM3916t);
        int iM3915s = m3915s(iM3100t) + iM3918v;
        return new UrlLinkFrame("WXXX", str, m3910n(bArr, iM3915s, m3919w(bArr, iM3915s), "ISO-8859-1"));
    }

    /* renamed from: s */
    public static int m3915s(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    /* renamed from: t */
    public static String m3916t(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : Constants.ENCODING : "UTF-16BE" : "UTF-16";
    }

    /* renamed from: u */
    public static String m3917u(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    /* renamed from: v */
    public static int m3918v(byte[] bArr, int i, int i2) {
        int iM3919w = m3919w(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iM3919w;
        }
        while (iM3919w < bArr.length - 1) {
            if ((iM3919w - i) % 2 == 0 && bArr[iM3919w + 1] == 0) {
                return iM3919w;
            }
            iM3919w = m3919w(bArr, iM3919w + 1);
        }
        return bArr.length;
    }

    /* renamed from: w */
    public static int m3919w(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    /* renamed from: x */
    public static int m3920x(ParsableByteArray parsableByteArray, int i) {
        byte[] bArr = parsableByteArray.f6793a;
        int i2 = parsableByteArray.f6794b;
        int i3 = i2;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= i2 + i) {
                return i;
            }
            if ((bArr[i3] & 255) == 255 && bArr[i4] == 0) {
                System.arraycopy(bArr, i3 + 2, bArr, i4, (i - (i3 - i2)) - 2);
                i--;
            }
            i3 = i4;
        }
    }

    /* renamed from: y */
    public static boolean m3921y(ParsableByteArray parsableByteArray, int i, int i2, boolean z2) {
        int iM3102v;
        long jM3102v;
        int iM3105y;
        int i3;
        int i4 = parsableByteArray.f6794b;
        while (true) {
            try {
                boolean z3 = true;
                if (parsableByteArray.m3081a() < i2) {
                    return true;
                }
                if (i >= 3) {
                    iM3102v = parsableByteArray.m3086f();
                    jM3102v = parsableByteArray.m3101u();
                    iM3105y = parsableByteArray.m3105y();
                } else {
                    iM3102v = parsableByteArray.m3102v();
                    jM3102v = parsableByteArray.m3102v();
                    iM3105y = 0;
                }
                if (iM3102v == 0 && jM3102v == 0 && iM3105y == 0) {
                    return true;
                }
                if (i == 4 && !z2) {
                    if ((8421504 & jM3102v) != 0) {
                        return false;
                    }
                    jM3102v = (((jM3102v >> 24) & 255) << 21) | (jM3102v & 255) | (((jM3102v >> 8) & 255) << 7) | (((jM3102v >> 16) & 255) << 14);
                }
                if (i == 4) {
                    i3 = (iM3105y & 64) != 0 ? 1 : 0;
                    if ((iM3105y & 1) == 0) {
                        z3 = false;
                    }
                } else {
                    if (i == 3) {
                        i3 = (iM3105y & 32) != 0 ? 1 : 0;
                        if ((iM3105y & 128) == 0) {
                        }
                    } else {
                        i3 = 0;
                    }
                    z3 = false;
                }
                if (z3) {
                    i3 += 4;
                }
                if (jM3102v < i3) {
                    return false;
                }
                if (parsableByteArray.m3081a() < jM3102v) {
                    return false;
                }
                parsableByteArray.m3080F((int) jM3102v);
            } finally {
                parsableByteArray.m3079E(i4);
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p279z2.SimpleMetadataDecoder
    @Nullable
    /* renamed from: b */
    public Metadata mo3899b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        return m3922d(byteBuffer.array(), byteBuffer.limit());
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c2  */
    @Nullable
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Metadata m3922d(byte[] bArr, int i) {
        b bVar;
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        boolean z2 = false;
        if (parsableByteArray.m3081a() < 10) {
            Log.w("Id3Decoder", "Data too short to be an ID3 tag");
        } else {
            int iM3102v = parsableByteArray.m3102v();
            if (iM3102v == 4801587) {
                int iM3100t = parsableByteArray.m3100t();
                parsableByteArray.m3080F(1);
                int iM3100t2 = parsableByteArray.m3100t();
                int iM3099s = parsableByteArray.m3099s();
                if (iM3100t == 2) {
                    if ((iM3100t2 & 64) != 0) {
                        Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                    }
                    bVar = new b(iM3100t, iM3100t >= 4 && (iM3100t2 & 128) != 0, iM3099s);
                } else {
                    if (iM3100t == 3) {
                        if ((iM3100t2 & 64) != 0) {
                            int iM3086f = parsableByteArray.m3086f();
                            parsableByteArray.m3080F(iM3086f);
                            iM3099s -= iM3086f + 4;
                        }
                    } else if (iM3100t == 4) {
                        if ((iM3100t2 & 64) != 0) {
                            int iM3099s2 = parsableByteArray.m3099s();
                            parsableByteArray.m3080F(iM3099s2 - 4);
                            iM3099s -= iM3099s2;
                        }
                        if ((iM3100t2 & 16) != 0) {
                            iM3099s -= 10;
                        }
                    } else {
                        outline.m852g0(57, "Skipped ID3 tag with unsupported majorVersion=", iM3100t, "Id3Decoder");
                    }
                    if (iM3100t >= 4) {
                        bVar = new b(iM3100t, iM3100t >= 4 && (iM3100t2 & 128) != 0, iM3099s);
                    }
                }
                if (bVar != null) {
                    return null;
                }
                int i2 = parsableByteArray.f6794b;
                int i3 = bVar.f9156a == 2 ? 6 : 10;
                int iM3920x = bVar.f9158c;
                if (bVar.f9157b) {
                    iM3920x = m3920x(parsableByteArray, iM3920x);
                }
                parsableByteArray.m3078D(i2 + iM3920x);
                if (!m3921y(parsableByteArray, bVar.f9156a, i3, false)) {
                    if (bVar.f9156a != 4 || !m3921y(parsableByteArray, 4, i3, true)) {
                        outline.m852g0(56, "Failed to validate ID3 tag with majorVersion=", bVar.f9156a, "Id3Decoder");
                        return null;
                    }
                    z2 = true;
                }
                while (parsableByteArray.m3081a() >= i3) {
                    Id3Frame id3FrameM3906j = m3906j(bVar.f9156a, parsableByteArray, z2, i3, this.f9155b);
                    if (id3FrameM3906j != null) {
                        arrayList.add(id3FrameM3906j);
                    }
                }
                return new Metadata(arrayList);
            }
            String strValueOf = String.valueOf(String.format("%06X", Integer.valueOf(iM3102v)));
            Log.w("Id3Decoder", strValueOf.length() != 0 ? "Unexpected first three bytes of ID3 tag header: 0x".concat(strValueOf) : new String("Unexpected first three bytes of ID3 tag header: 0x"));
        }
        bVar = null;
        if (bVar != null) {
        }
    }

    public Id3Decoder(@Nullable a aVar) {
        this.f9155b = aVar;
    }
}
