package p007b.p225i.p414e.p426q;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Arrays;
import java.util.Map;
import p007b.p225i.p414e.DecodeHintType;
import p007b.p225i.p414e.p418n.BitArray;

/* compiled from: Code93Reader.java */
/* renamed from: b.i.e.q.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class Code93Reader extends OneDReader {

    /* renamed from: a */
    public static final char[] f13363a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* renamed from: b */
    public static final int[] f13364b;

    /* renamed from: c */
    public static final int f13365c;

    /* renamed from: d */
    public final StringBuilder f13366d = new StringBuilder(20);

    /* renamed from: e */
    public final int[] f13367e = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f13364b = iArr;
        f13365c = iArr[47];
    }

    /* renamed from: g */
    public static void m6987g(CharSequence charSequence, int i, int i2) throws ChecksumException {
        int iIndexOf = 0;
        int i3 = 1;
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i4)) * i3;
            i3++;
            if (i3 > i2) {
                i3 = 1;
            }
        }
        if (charSequence.charAt(i) != f13363a[iIndexOf % 47]) {
            throw ChecksumException.m9259a();
        }
    }

    /* renamed from: h */
    public static int m6988h(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int iRound = Math.round((iArr[i4] * 9.0f) / i);
            if (iRound <= 0 || iRound > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                for (int i5 = 0; i5 < iRound; i5++) {
                    i3 = (i3 << 1) | 1;
                }
            } else {
                i3 <<= iRound;
            }
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
    
        r8 = p007b.p225i.p414e.p426q.Code93Reader.f13363a[r9];
        r7.append(r8);
        r9 = r6.length;
        r12 = r4;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        if (r10 >= r9) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
    
        r12 = r12 + r6[r10];
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
    
        r9 = r18.m6936f(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
    
        if (r8 != '*') goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007a, code lost:
    
        r7.deleteCharAt(r7.length() - 1);
        r8 = r6.length;
        r10 = 0;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0085, code lost:
    
        if (r10 >= r8) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
    
        r12 = r12 + r6[r10];
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008d, code lost:
    
        if (r9 == r5) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0093, code lost:
    
        if (r18.m6935b(r9) == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0099, code lost:
    
        if (r7.length() < 2) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009b, code lost:
    
        r1 = r7.length();
        m6987g(r7, r1 - 2, 20);
        m6987g(r7, r1 - 1, 15);
        r7.setLength(r7.length() - 2);
        r1 = r7.length();
        r5 = new java.lang.StringBuilder(r1);
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bf, code lost:
    
        if (r6 >= r1) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c1, code lost:
    
        r8 = r7.charAt(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c7, code lost:
    
        if (r8 < 'a') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cb, code lost:
    
        if (r8 > 'd') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cf, code lost:
    
        if (r6 >= (r1 - 1)) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d1, code lost:
    
        r6 = r6 + 1;
        r9 = r7.charAt(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00dd, code lost:
    
        switch(r8) {
            case 97: goto L79;
            case 98: goto L55;
            case 99: goto L48;
            case 100: goto L43;
            default: goto L42;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e0, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e3, code lost:
    
        if (r9 < 'A') goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e5, code lost:
    
        if (r9 > 'Z') goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e7, code lost:
    
        r9 = r9 + ' ';
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ee, code lost:
    
        throw com.google.zxing.FormatException.m9260a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ef, code lost:
    
        if (r9 < 'A') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f1, code lost:
    
        if (r9 > 'O') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f3, code lost:
    
        r9 = r9 - ' ';
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f6, code lost:
    
        if (r9 != 'Z') goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f8, code lost:
    
        r8 = com.discord.widgets.chat.input.MentionUtils.EMOJIS_AND_STICKERS_CHAR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ff, code lost:
    
        throw com.google.zxing.FormatException.m9260a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0100, code lost:
    
        if (r9 < 'A') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0104, code lost:
    
        if (r9 > 'E') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0106, code lost:
    
        r9 = r9 - '&';
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010b, code lost:
    
        if (r9 < 'F') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x010f, code lost:
    
        if (r9 > 'J') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0111, code lost:
    
        r9 = r9 - 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0116, code lost:
    
        if (r9 < 'K') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0118, code lost:
    
        if (r9 > 'O') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x011a, code lost:
    
        r9 = r9 + 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x011f, code lost:
    
        if (r9 < 'P') goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0123, code lost:
    
        if (r9 > 'S') goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0125, code lost:
    
        r9 = r9 + '+';
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x012a, code lost:
    
        if (r9 < 'T') goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x012c, code lost:
    
        if (r9 > 'Z') goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x012e, code lost:
    
        r8 = 127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0135, code lost:
    
        throw com.google.zxing.FormatException.m9260a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0136, code lost:
    
        if (r9 < 'A') goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0138, code lost:
    
        if (r9 > 'Z') goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x013a, code lost:
    
        r9 = r9 - '@';
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x013c, code lost:
    
        r8 = (char) r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0142, code lost:
    
        throw com.google.zxing.FormatException.m9260a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0143, code lost:
    
        r5.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x014b, code lost:
    
        throw com.google.zxing.FormatException.m9260a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x014c, code lost:
    
        r5.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x014f, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0152, code lost:
    
        r9 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x017e, code lost:
    
        return new com.google.zxing.Result(r5.toString(), null, new p007b.p225i.p414e.ResultPoint[]{new p007b.p225i.p414e.ResultPoint((r2[1] + r2[0]) / 2.0f, r9), new p007b.p225i.p414e.ResultPoint((r12 / 2.0f) + r4, r9)}, p007b.p225i.p414e.BarcodeFormat.CODE_93);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0181, code lost:
    
        throw com.google.zxing.NotFoundException.f21665l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0184, code lost:
    
        throw com.google.zxing.NotFoundException.f21665l;
     */
    @Override // p007b.p225i.p414e.p426q.OneDReader
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result mo6983b(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int iM6936f;
        int i2 = bitArray.f13228k;
        int iM6936f2 = bitArray.m6936f(0);
        Arrays.fill(this.f13367e, 0);
        int[] iArr = this.f13367e;
        int length = iArr.length;
        int i3 = iM6936f2;
        boolean z2 = false;
        int i4 = 0;
        while (iM6936f2 < i2) {
            if (bitArray.m6935b(iM6936f2) != z2) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else if (m6988h(iArr) == f13365c) {
                    int iM6936f3 = bitArray.m6936f(new int[]{i3, iM6936f2}[1]);
                    int i5 = bitArray.f13228k;
                    int[] iArr2 = this.f13367e;
                    Arrays.fill(iArr2, 0);
                    StringBuilder sb = this.f13366d;
                    sb.setLength(0);
                    while (true) {
                        OneDReader.m6997e(bitArray, iM6936f3, iArr2);
                        int iM6988h = m6988h(iArr2);
                        if (iM6988h < 0) {
                            throw NotFoundException.f21665l;
                        }
                        int i6 = 0;
                        while (true) {
                            int[] iArr3 = f13364b;
                            if (i6 >= iArr3.length) {
                                throw NotFoundException.f21665l;
                            }
                            if (iArr3[i6] == iM6988h) {
                                break;
                            }
                            i6++;
                        }
                        iM6936f3 = iM6936f;
                    }
                } else {
                    i3 += iArr[0] + iArr[1];
                    int i7 = i4 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i7);
                    iArr[i7] = 0;
                    iArr[i4] = 0;
                    i4 = i7;
                }
                iArr[i4] = 1;
                z2 = !z2;
            }
            iM6936f2++;
        }
        throw NotFoundException.f21665l;
    }
}
