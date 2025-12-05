package p007b.p225i.p414e.p415m.p416c;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.material.badge.BadgeDrawable;
import com.google.zxing.FormatException;
import com.google.zxing.ReaderException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Arrays;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p225i.p414e.p415m.AztecDetectorResult;
import p007b.p225i.p414e.p418n.BitMatrix;
import p007b.p225i.p414e.p418n.DecoderResult;
import p007b.p225i.p414e.p418n.p420l.GenericGF;
import p007b.p225i.p414e.p418n.p420l.ReedSolomonDecoder;

/* compiled from: Decoder.java */
/* renamed from: b.i.e.m.c.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class Decoder2 {

    /* renamed from: a */
    public static final String[] f13212a = {"CTRL_PS", " ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: b */
    public static final String[] f13213b = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c */
    public static final String[] f13214c = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: d */
    public static final String[] f13215d = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, ",", "-", ".", AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    /* renamed from: e */
    public static final String[] f13216e = {"CTRL_PS", " ", "0", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: f */
    public AztecDetectorResult f13217f;

    /* renamed from: b */
    public static int m6925b(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    /* renamed from: a */
    public DecoderResult m6926a(AztecDetectorResult aztecDetectorResult) throws FormatException {
        int i;
        GenericGF genericGF;
        String str;
        this.f13217f = aztecDetectorResult;
        BitMatrix bitMatrix = aztecDetectorResult.f13275a;
        boolean z2 = aztecDetectorResult.f13209c;
        int i2 = aztecDetectorResult.f13211e;
        int i3 = (z2 ? 11 : 14) + (i2 << 2);
        int[] iArr = new int[i3];
        int i4 = ((z2 ? 88 : 112) + (i2 << 4)) * i2;
        boolean[] zArr = new boolean[i4];
        int i5 = 2;
        if (z2) {
            for (int i6 = 0; i6 < i3; i6++) {
                iArr[i6] = i6;
            }
        } else {
            int i7 = i3 / 2;
            int i8 = ((((i7 - 1) / 15) * 2) + (i3 + 1)) / 2;
            for (int i9 = 0; i9 < i7; i9++) {
                iArr[(i7 - i9) - 1] = (i8 - r15) - 1;
                iArr[i7 + i9] = (i9 / 15) + i9 + i8 + 1;
            }
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= i2) {
                break;
            }
            int i12 = ((i2 - i10) << i5) + (z2 ? 9 : 12);
            int i13 = i10 << 1;
            int i14 = (i3 - 1) - i13;
            int i15 = 0;
            while (i15 < i12) {
                int i16 = i15 << 1;
                int i17 = 0;
                while (i17 < i5) {
                    int i18 = i13 + i17;
                    int i19 = i13 + i15;
                    zArr[i11 + i16 + i17] = bitMatrix.m6942f(iArr[i18], iArr[i19]);
                    int i20 = i14 - i17;
                    zArr[(i12 * 2) + i11 + i16 + i17] = bitMatrix.m6942f(iArr[i19], iArr[i20]);
                    int i21 = i14 - i15;
                    zArr[(i12 * 4) + i11 + i16 + i17] = bitMatrix.m6942f(iArr[i20], iArr[i21]);
                    zArr[(i12 * 6) + i11 + i16 + i17] = bitMatrix.m6942f(iArr[i21], iArr[i18]);
                    i17++;
                    z2 = z2;
                    i2 = i2;
                    i5 = 2;
                }
                i15++;
                i5 = 2;
            }
            i11 += i12 << 3;
            i10++;
            i2 = i2;
            i5 = 2;
        }
        AztecDetectorResult aztecDetectorResult2 = this.f13217f;
        int i22 = aztecDetectorResult2.f13211e;
        int i23 = 8;
        if (i22 <= 2) {
            genericGF = GenericGF.f13301c;
            i = 6;
        } else if (i22 <= 8) {
            genericGF = GenericGF.f13305g;
            i = 8;
        } else if (i22 <= 22) {
            i = 10;
            genericGF = GenericGF.f13300b;
        } else {
            genericGF = GenericGF.f13299a;
        }
        int i24 = aztecDetectorResult2.f13210d;
        int i25 = i4 / i;
        if (i25 < i24) {
            throw FormatException.m9260a();
        }
        int i26 = i4 % i;
        int[] iArr2 = new int[i25];
        int i27 = 0;
        while (i27 < i25) {
            iArr2[i27] = m6925b(zArr, i26, i);
            i27++;
            i26 += i;
        }
        try {
            new ReedSolomonDecoder(genericGF).m6968a(iArr2, i25 - i24);
            int i28 = 1;
            int i29 = (1 << i) - 1;
            int i30 = 0;
            int i31 = 0;
            while (i30 < i24) {
                int i32 = iArr2[i30];
                if (i32 == 0 || i32 == i29) {
                    throw FormatException.m9260a();
                }
                if (i32 == i28 || i32 == i29 - 1) {
                    i31++;
                }
                i30++;
                i28 = 1;
            }
            int i33 = (i24 * i) - i31;
            boolean[] zArr2 = new boolean[i33];
            int i34 = 0;
            for (int i35 = 0; i35 < i24; i35++) {
                int i36 = iArr2[i35];
                int i37 = 1;
                if (i36 == 1 || i36 == i29 - 1) {
                    Arrays.fill(zArr2, i34, (i34 + i) - 1, i36 > 1);
                    i34 = (i - 1) + i34;
                } else {
                    int i38 = i - 1;
                    while (i38 >= 0) {
                        int i39 = i34 + 1;
                        zArr2[i34] = ((i37 << i38) & i36) != 0;
                        i38--;
                        i34 = i39;
                        i37 = 1;
                    }
                }
            }
            int i40 = (i33 + 7) / 8;
            byte[] bArr = new byte[i40];
            for (int i41 = 0; i41 < i40; i41++) {
                int i42 = i41 << 3;
                int i43 = i33 - i42;
                bArr[i41] = (byte) (i43 >= 8 ? m6925b(zArr2, i42, 8) : m6925b(zArr2, i42, i43) << (8 - i43));
            }
            StringBuilder sb = new StringBuilder(20);
            int i44 = 1;
            int i45 = 1;
            int i46 = 0;
            while (i46 < i33) {
                if (i44 != 6) {
                    int i47 = i44 == 4 ? 4 : 5;
                    if (i33 - i46 < i47) {
                        break;
                    }
                    int iM6925b = m6925b(zArr2, i46, i47);
                    i46 += i47;
                    int iM758h = C1563b.m758h(i44);
                    int i48 = 3;
                    if (iM758h == 0) {
                        str = f13212a[iM6925b];
                    } else if (iM758h == 1) {
                        str = f13213b[iM6925b];
                    } else if (iM758h == 2) {
                        str = f13214c[iM6925b];
                    } else if (iM758h == 3) {
                        str = f13216e[iM6925b];
                    } else {
                        if (iM758h != 4) {
                            throw new IllegalStateException("Bad table");
                        }
                        str = f13215d[iM6925b];
                    }
                    if (str.startsWith("CTRL_")) {
                        char cCharAt = str.charAt(5);
                        if (cCharAt == 'B') {
                            i48 = 6;
                        } else if (cCharAt == 'D') {
                            i48 = 4;
                        } else if (cCharAt == 'P') {
                            i48 = 5;
                        } else if (cCharAt == 'L') {
                            i48 = 2;
                        } else if (cCharAt != 'M') {
                            i48 = 1;
                        }
                        if (str.charAt(6) == 'L') {
                            i45 = i48;
                        } else {
                            i45 = i44;
                            i44 = i48;
                        }
                    } else {
                        sb.append(str);
                    }
                    i44 = i45;
                } else {
                    if (i33 - i46 < 5) {
                        break;
                    }
                    int iM6925b2 = m6925b(zArr2, i46, 5);
                    i46 += 5;
                    if (iM6925b2 == 0) {
                        if (i33 - i46 < 11) {
                            break;
                        }
                        iM6925b2 = m6925b(zArr2, i46, 11) + 31;
                        i46 += 11;
                    }
                    int i49 = 0;
                    while (true) {
                        if (i49 >= iM6925b2) {
                            break;
                        }
                        if (i33 - i46 < i23) {
                            i46 = i33;
                            break;
                        }
                        sb.append((char) m6925b(zArr2, i46, i23));
                        i46 += 8;
                        i49++;
                    }
                    i44 = i45;
                }
                i23 = 8;
            }
            DecoderResult decoderResult = new DecoderResult(bArr, sb.toString(), null, null);
            decoderResult.f13267b = i33;
            return decoderResult;
        } catch (ReedSolomonException e) {
            if (ReaderException.f21666j) {
                throw new FormatException(e);
            }
            throw FormatException.f21664l;
        }
    }
}
