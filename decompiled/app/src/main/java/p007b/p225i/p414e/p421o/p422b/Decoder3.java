package p007b.p225i.p414e.p421o.p422b;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p225i.p414e.p418n.BitMatrix;
import p007b.p225i.p414e.p418n.BitSource;
import p007b.p225i.p414e.p418n.DecoderResult;
import p007b.p225i.p414e.p418n.p420l.GenericGF;
import p007b.p225i.p414e.p418n.p420l.ReedSolomonDecoder;
import p007b.p225i.p414e.p421o.p422b.Version2;

/* compiled from: Decoder.java */
/* renamed from: b.i.e.o.b.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class Decoder3 {

    /* renamed from: a */
    public final ReedSolomonDecoder f13329a = new ReedSolomonDecoder(GenericGF.f13304f);

    /* JADX WARN: Code restructure failed: missing block: B:234:0x03ae, code lost:
    
        r5 = r7;
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x03bf, code lost:
    
        throw com.google.zxing.FormatException.m9260a();
     */
    /* JADX WARN: Removed duplicated region for block: B:440:0x065a  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0666 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:503:0x04fe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:504:? A[LOOP:15: B:201:0x0348->B:504:?, LOOP_END, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DecoderResult m6973a(BitMatrix bitMatrix) throws ChecksumException, FormatException {
        int iM6949b;
        boolean z2;
        int iM6949b2;
        int iM6949b3;
        int i;
        BitMatrixParser bitMatrixParser = new BitMatrixParser(bitMatrix);
        Version2 version2 = bitMatrixParser.f13321c;
        int i2 = version2.f13337h;
        byte[] bArr = new byte[i2];
        BitMatrix bitMatrix2 = bitMatrixParser.f13319a;
        int i3 = bitMatrix2.f13230k;
        int i4 = bitMatrix2.f13229j;
        int i5 = 0;
        int i6 = 4;
        int i7 = 0;
        boolean z3 = false;
        int i8 = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (true) {
            if (i6 == i3 && i7 == 0 && !z3) {
                int i9 = i8 + 1;
                int i10 = i3 - 1;
                int i11 = (bitMatrixParser.m6969a(i10, i5, i3, i4) ? 1 : 0) << 1;
                if (bitMatrixParser.m6969a(i10, 1, i3, i4)) {
                    i11 |= 1;
                }
                int i12 = i11 << 1;
                if (bitMatrixParser.m6969a(i10, 2, i3, i4)) {
                    i12 |= 1;
                }
                int i13 = i12 << 1;
                if (bitMatrixParser.m6969a(0, i4 - 2, i3, i4)) {
                    i13 |= 1;
                }
                int i14 = i13 << 1;
                int i15 = i4 - 1;
                if (bitMatrixParser.m6969a(0, i15, i3, i4)) {
                    i14 |= 1;
                }
                int i16 = i14 << 1;
                if (bitMatrixParser.m6969a(1, i15, i3, i4)) {
                    i16 |= 1;
                }
                int i17 = i16 << 1;
                if (bitMatrixParser.m6969a(2, i15, i3, i4)) {
                    i17 |= 1;
                }
                int i18 = i17 << 1;
                if (bitMatrixParser.m6969a(3, i15, i3, i4)) {
                    i18 |= 1;
                }
                bArr[i8] = (byte) i18;
                i6 -= 2;
                i7 += 2;
                i8 = i9;
                z3 = true;
            } else {
                int i19 = i3 - 2;
                if (i6 == i19 && i7 == 0 && (i4 & 3) != 0 && !z4) {
                    int i20 = i8 + 1;
                    int i21 = (bitMatrixParser.m6969a(i3 + (-3), 0, i3, i4) ? 1 : 0) << 1;
                    if (bitMatrixParser.m6969a(i19, 0, i3, i4)) {
                        i21 |= 1;
                    }
                    int i22 = i21 << 1;
                    if (bitMatrixParser.m6969a(i3 - 1, 0, i3, i4)) {
                        i22 |= 1;
                    }
                    int i23 = i22 << 1;
                    if (bitMatrixParser.m6969a(0, i4 - 4, i3, i4)) {
                        i23 |= 1;
                    }
                    int i24 = i23 << 1;
                    if (bitMatrixParser.m6969a(0, i4 - 3, i3, i4)) {
                        i24 |= 1;
                    }
                    int i25 = i24 << 1;
                    if (bitMatrixParser.m6969a(0, i4 - 2, i3, i4)) {
                        i25 |= 1;
                    }
                    int i26 = i25 << 1;
                    int i27 = i4 - 1;
                    if (bitMatrixParser.m6969a(0, i27, i3, i4)) {
                        i26 |= 1;
                    }
                    int i28 = i26 << 1;
                    if (bitMatrixParser.m6969a(1, i27, i3, i4)) {
                        i28 |= 1;
                    }
                    bArr[i8] = (byte) i28;
                    i6 -= 2;
                    i7 += 2;
                    i8 = i20;
                    z4 = true;
                } else if (i6 == i3 + 4 && i7 == 2 && (i4 & 7) == 0 && !z5) {
                    int i29 = i8 + 1;
                    int i30 = i3 - 1;
                    int i31 = (bitMatrixParser.m6969a(i30, 0, i3, i4) ? 1 : 0) << 1;
                    int i32 = i4 - 1;
                    if (bitMatrixParser.m6969a(i30, i32, i3, i4)) {
                        i31 |= 1;
                    }
                    int i33 = i31 << 1;
                    int i34 = i4 - 3;
                    if (bitMatrixParser.m6969a(0, i34, i3, i4)) {
                        i33 |= 1;
                    }
                    int i35 = i33 << 1;
                    int i36 = i4 - 2;
                    boolean z7 = z3;
                    if (bitMatrixParser.m6969a(0, i36, i3, i4)) {
                        i35 |= 1;
                    }
                    boolean z8 = z4;
                    int i37 = i35 << 1;
                    if (bitMatrixParser.m6969a(0, i32, i3, i4)) {
                        i37 |= 1;
                    }
                    int i38 = i37 << 1;
                    if (bitMatrixParser.m6969a(1, i34, i3, i4)) {
                        i38 |= 1;
                    }
                    int i39 = i38 << 1;
                    if (bitMatrixParser.m6969a(1, i36, i3, i4)) {
                        i39 |= 1;
                    }
                    int i40 = i39 << 1;
                    if (bitMatrixParser.m6969a(1, i32, i3, i4)) {
                        i40 |= 1;
                    }
                    bArr[i8] = (byte) i40;
                    i6 -= 2;
                    i7 += 2;
                    i8 = i29;
                    z3 = z7;
                    z4 = z8;
                    z5 = true;
                } else {
                    boolean z9 = z3;
                    boolean z10 = z4;
                    if (i6 == i19 && i7 == 0 && (i4 & 7) == 4 && !z6) {
                        int i41 = i8 + 1;
                        int i42 = (bitMatrixParser.m6969a(i3 + (-3), 0, i3, i4) ? 1 : 0) << 1;
                        if (bitMatrixParser.m6969a(i19, 0, i3, i4)) {
                            i42 |= 1;
                        }
                        int i43 = i42 << 1;
                        if (bitMatrixParser.m6969a(i3 - 1, 0, i3, i4)) {
                            i43 |= 1;
                        }
                        int i44 = i43 << 1;
                        if (bitMatrixParser.m6969a(0, i4 - 2, i3, i4)) {
                            i44 |= 1;
                        }
                        int i45 = i44 << 1;
                        int i46 = i4 - 1;
                        if (bitMatrixParser.m6969a(0, i46, i3, i4)) {
                            i45 |= 1;
                        }
                        int i47 = i45 << 1;
                        if (bitMatrixParser.m6969a(1, i46, i3, i4)) {
                            i47 |= 1;
                        }
                        int i48 = i47 << 1;
                        if (bitMatrixParser.m6969a(2, i46, i3, i4)) {
                            i48 |= 1;
                        }
                        int i49 = i48 << 1;
                        if (bitMatrixParser.m6969a(3, i46, i3, i4)) {
                            i49 |= 1;
                        }
                        bArr[i8] = (byte) i49;
                        i6 -= 2;
                        i7 += 2;
                        i8 = i41;
                        z3 = z9;
                        z4 = z10;
                        z6 = true;
                    } else {
                        do {
                            if (i6 < i3 && i7 >= 0 && !bitMatrixParser.f13320b.m6942f(i7, i6)) {
                                bArr[i8] = (byte) bitMatrixParser.m6970b(i6, i7, i3, i4);
                                i8++;
                            }
                            i6 -= 2;
                            i7 += 2;
                            if (i6 < 0) {
                                break;
                            }
                        } while (i7 < i4);
                        int i50 = i6 + 1;
                        int i51 = i7 + 3;
                        do {
                            if (i50 >= 0 && i51 < i4 && !bitMatrixParser.f13320b.m6942f(i51, i50)) {
                                bArr[i8] = (byte) bitMatrixParser.m6970b(i50, i51, i3, i4);
                                i8++;
                            }
                            i50 += 2;
                            i51 -= 2;
                            if (i50 >= i3) {
                                break;
                            }
                        } while (i51 >= 0);
                        i6 = i50 + 3;
                        i7 = i51 + 1;
                        z3 = z9;
                        z4 = z10;
                    }
                }
            }
            if (i6 >= i3 && i7 >= i4) {
                break;
            }
            i5 = 0;
        }
        if (i8 != bitMatrixParser.f13321c.f13337h) {
            throw FormatException.m9260a();
        }
        Version2.c cVar = version2.f13336g;
        Version2.b[] bVarArr = cVar.f13341b;
        int i52 = 0;
        for (Version2.b bVar : bVarArr) {
            i52 += bVar.f13338a;
        }
        DataBlock[] dataBlockArr = new DataBlock[i52];
        int i53 = 0;
        for (Version2.b bVar2 : bVarArr) {
            int i54 = 0;
            while (i54 < bVar2.f13338a) {
                int i55 = bVar2.f13339b;
                dataBlockArr[i53] = new DataBlock(i55, new byte[cVar.f13340a + i55]);
                i54++;
                i53++;
            }
        }
        int length = dataBlockArr[0].f13323b.length - cVar.f13340a;
        int i56 = length - 1;
        int i57 = 0;
        for (int i58 = 0; i58 < i56; i58++) {
            int i59 = 0;
            while (i59 < i53) {
                dataBlockArr[i59].f13323b[i58] = bArr[i57];
                i59++;
                i57++;
            }
        }
        boolean z11 = version2.f13331b == 24;
        int i60 = 8;
        int i61 = z11 ? 8 : i53;
        int i62 = 0;
        while (i62 < i61) {
            dataBlockArr[i62].f13323b[i56] = bArr[i57];
            i62++;
            i57++;
        }
        int length2 = dataBlockArr[0].f13323b.length;
        while (length < length2) {
            int i63 = 0;
            while (i63 < i53) {
                int i64 = z11 ? (i63 + 8) % i53 : i63;
                dataBlockArr[i64].f13323b[(!z11 || i64 <= 7) ? length : length - 1] = bArr[i57];
                i63++;
                i57++;
            }
            length++;
        }
        if (i57 != i2) {
            throw new IllegalArgumentException();
        }
        int i65 = 0;
        for (int i66 = 0; i66 < i52; i66++) {
            i65 += dataBlockArr[i66].f13322a;
        }
        byte[] bArr2 = new byte[i65];
        for (int i67 = 0; i67 < i52; i67++) {
            DataBlock dataBlock = dataBlockArr[i67];
            byte[] bArr3 = dataBlock.f13323b;
            int i68 = dataBlock.f13322a;
            int length3 = bArr3.length;
            int[] iArr = new int[length3];
            for (int i69 = 0; i69 < length3; i69++) {
                iArr[i69] = bArr3[i69] & 255;
            }
            try {
                this.f13329a.m6968a(iArr, bArr3.length - i68);
                for (int i70 = 0; i70 < i68; i70++) {
                    bArr3[i70] = (byte) iArr[i70];
                }
                for (int i71 = 0; i71 < i68; i71++) {
                    bArr2[(i71 * i52) + i67] = bArr3[i71];
                }
            } catch (ReedSolomonException unused) {
                throw ChecksumException.m9259a();
            }
        }
        BitSource bitSource = new BitSource(bArr2);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        int i72 = 2;
        while (true) {
            int i73 = 6;
            char c = 29;
            if (i72 == 2) {
                boolean z12 = false;
                while (true) {
                    int iM6949b4 = bitSource.m6949b(i60);
                    if (iM6949b4 == 0) {
                        throw FormatException.m9260a();
                    }
                    if (iM6949b4 <= 128) {
                        if (z12) {
                            iM6949b4 += 128;
                        }
                        sb.append((char) (iM6949b4 - 1));
                    } else if (iM6949b4 == 129) {
                        i73 = 1;
                    } else {
                        if (iM6949b4 > 229) {
                            switch (iM6949b4) {
                                case 230:
                                    i73 = 3;
                                    break;
                                case 231:
                                    i73 = 7;
                                    break;
                                case 232:
                                    sb.append((char) 29);
                                    if (bitSource.m6948a() > 0) {
                                    }
                                    break;
                                case 233:
                                case 234:
                                case 241:
                                    break;
                                case 235:
                                    z12 = true;
                                    if (bitSource.m6948a() > 0) {
                                    }
                                    break;
                                case 236:
                                    sb.append("[)>\u001e05\u001d");
                                    sb2.insert(0, "\u001e\u0004");
                                    if (bitSource.m6948a() > 0) {
                                    }
                                    break;
                                case 237:
                                    sb.append("[)>\u001e06\u001d");
                                    sb2.insert(0, "\u001e\u0004");
                                    if (bitSource.m6948a() > 0) {
                                    }
                                    break;
                                case 238:
                                    i73 = 5;
                                    break;
                                case 239:
                                    i73 = 4;
                                    break;
                                case 240:
                                    break;
                                default:
                                    if (iM6949b4 != 254 || bitSource.m6948a() != 0) {
                                    }
                                    if (bitSource.m6948a() > 0) {
                                    }
                                    break;
                            }
                        } else {
                            int i74 = iM6949b4 - 130;
                            if (i74 < 10) {
                                sb.append('0');
                            }
                            sb.append(i74);
                        }
                        if (bitSource.m6948a() > 0) {
                        }
                    }
                }
            } else {
                int iM758h = C1563b.m758h(i72);
                if (iM758h == 2) {
                    int[] iArr2 = new int[3];
                    boolean z13 = false;
                    int i75 = 0;
                    while (bitSource.m6948a() != 8 && (iM6949b = bitSource.m6949b(8)) != 254) {
                        DecodedBitStreamParser.m6971a(iM6949b, bitSource.m6949b(8), iArr2);
                        int i76 = 0;
                        int i77 = 3;
                        while (i76 < i77) {
                            int i78 = iArr2[i76];
                            if (i75 != 0) {
                                if (i75 != 1) {
                                    if (i75 == 2) {
                                        char[] cArr = DecodedBitStreamParser.f13325b;
                                        if (i78 < cArr.length) {
                                            char c2 = cArr[i78];
                                            if (z13) {
                                                sb.append((char) (c2 + 128));
                                                z13 = false;
                                                i75 = 0;
                                                i77 = 3;
                                            } else {
                                                sb.append(c2);
                                                z2 = z13;
                                                z13 = z2;
                                                i75 = 0;
                                                i77 = 3;
                                            }
                                        } else if (i78 == 27) {
                                            sb.append(c);
                                            i75 = 0;
                                            i77 = 3;
                                        } else {
                                            if (i78 != 30) {
                                                throw FormatException.m9260a();
                                            }
                                            z2 = true;
                                            z13 = z2;
                                            i75 = 0;
                                            i77 = 3;
                                        }
                                    } else {
                                        if (i75 != i77) {
                                            throw FormatException.m9260a();
                                        }
                                        if (z13) {
                                            sb.append((char) (i78 + 224));
                                            z13 = false;
                                            i75 = 0;
                                            i77 = 3;
                                        } else {
                                            sb.append((char) (i78 + 96));
                                            z2 = z13;
                                            z13 = z2;
                                            i75 = 0;
                                            i77 = 3;
                                        }
                                    }
                                } else if (z13) {
                                    sb.append((char) (i78 + 128));
                                    z13 = false;
                                    i75 = 0;
                                    i77 = 3;
                                } else {
                                    sb.append((char) i78);
                                    i75 = 0;
                                    i77 = 3;
                                }
                            } else if (i78 < i77) {
                                i75 = i78 + 1;
                            } else {
                                char[] cArr2 = DecodedBitStreamParser.f13324a;
                                if (i78 >= cArr2.length) {
                                    throw FormatException.m9260a();
                                }
                                char c3 = cArr2[i78];
                                if (z13) {
                                    sb.append((char) (c3 + 128));
                                    z13 = false;
                                } else {
                                    sb.append(c3);
                                }
                            }
                            i76++;
                            c = 29;
                        }
                        if (bitSource.m6948a() <= 0) {
                            i72 = 2;
                            i = 1;
                            if (i72 != i && bitSource.m6948a() > 0) {
                                i60 = 8;
                            }
                        } else {
                            c = 29;
                        }
                    }
                    i72 = 2;
                    i = 1;
                    if (i72 != i) {
                    }
                } else if (iM758h == 3) {
                    int i79 = 3;
                    int[] iArr3 = new int[3];
                    int i80 = 0;
                    boolean z14 = false;
                    for (int i81 = 254; bitSource.m6948a() != i60 && (iM6949b2 = bitSource.m6949b(i60)) != i81; i81 = 254) {
                        DecodedBitStreamParser.m6971a(iM6949b2, bitSource.m6949b(i60), iArr3);
                        boolean z15 = z14;
                        int i82 = 0;
                        while (i82 < i79) {
                            int i83 = iArr3[i82];
                            if (i80 != 0) {
                                if (i80 != 1) {
                                    if (i80 == 2) {
                                        char[] cArr3 = DecodedBitStreamParser.f13327d;
                                        if (i83 < cArr3.length) {
                                            char c4 = cArr3[i83];
                                            if (z15) {
                                                sb.append((char) (c4 + 128));
                                                z15 = false;
                                            } else {
                                                sb.append(c4);
                                            }
                                        } else if (i83 == 27) {
                                            sb.append((char) 29);
                                        } else {
                                            if (i83 != 30) {
                                                throw FormatException.m9260a();
                                            }
                                            z15 = true;
                                        }
                                        i80 = 0;
                                    } else {
                                        if (i80 != i79) {
                                            throw FormatException.m9260a();
                                        }
                                        char[] cArr4 = DecodedBitStreamParser.f13328e;
                                        if (i83 >= cArr4.length) {
                                            throw FormatException.m9260a();
                                        }
                                        char c5 = cArr4[i83];
                                        if (z15) {
                                            sb.append((char) (c5 + 128));
                                            z15 = false;
                                            i80 = 0;
                                        } else {
                                            sb.append(c5);
                                            i80 = 0;
                                        }
                                    }
                                } else if (z15) {
                                    sb.append((char) (i83 + 128));
                                    z15 = false;
                                    i80 = 0;
                                } else {
                                    sb.append((char) i83);
                                    i80 = 0;
                                }
                            } else if (i83 < i79) {
                                i80 = i83 + 1;
                            } else {
                                char[] cArr5 = DecodedBitStreamParser.f13326c;
                                if (i83 >= cArr5.length) {
                                    throw FormatException.m9260a();
                                }
                                char c6 = cArr5[i83];
                                if (z15) {
                                    sb.append((char) (c6 + 128));
                                    z15 = false;
                                } else {
                                    sb.append(c6);
                                }
                            }
                            i82++;
                            i79 = 3;
                        }
                        if (bitSource.m6948a() > 0) {
                            z14 = z15;
                            i79 = 3;
                            i60 = 8;
                        }
                    }
                } else if (iM758h == 4) {
                    int i84 = 3;
                    int[] iArr4 = new int[3];
                    while (bitSource.m6948a() != i60 && (iM6949b3 = bitSource.m6949b(i60)) != 254) {
                        DecodedBitStreamParser.m6971a(iM6949b3, bitSource.m6949b(i60), iArr4);
                        int i85 = 0;
                        while (i85 < i84) {
                            int i86 = iArr4[i85];
                            if (i86 == 0) {
                                sb.append('\r');
                            } else if (i86 == 1) {
                                sb.append('*');
                            } else if (i86 == 2) {
                                sb.append('>');
                            } else if (i86 == i84) {
                                sb.append(' ');
                            } else if (i86 < 14) {
                                sb.append((char) (i86 + 44));
                            } else {
                                if (i86 >= 40) {
                                    throw FormatException.m9260a();
                                }
                                sb.append((char) (i86 + 51));
                            }
                            i85++;
                            i84 = 3;
                        }
                        if (bitSource.m6948a() > 0) {
                            i84 = 3;
                        }
                    }
                } else if (iM758h == 5) {
                    while (true) {
                        if (bitSource.m6948a() > 16) {
                            int i87 = 0;
                            while (true) {
                                if (i87 < 4) {
                                    int iM6949b5 = bitSource.m6949b(6);
                                    if (iM6949b5 == 31) {
                                        int i88 = 8 - bitSource.f13235c;
                                        if (i88 != i60) {
                                            bitSource.m6949b(i88);
                                        }
                                    } else {
                                        if ((iM6949b5 & 32) == 0) {
                                            iM6949b5 |= 64;
                                        }
                                        sb.append((char) iM6949b5);
                                        i87++;
                                    }
                                } else if (bitSource.m6948a() <= 0) {
                                }
                            }
                        }
                    }
                } else {
                    if (iM758h != 6) {
                        throw FormatException.m9260a();
                    }
                    int i89 = bitSource.f13234b + 1;
                    int i90 = i89 + 1;
                    int iM6972b = DecodedBitStreamParser.m6972b(bitSource.m6949b(i60), i89);
                    if (iM6972b == 0) {
                        iM6972b = bitSource.m6948a() / i60;
                    } else if (iM6972b >= 250) {
                        iM6972b = ((iM6972b - 249) * 250) + DecodedBitStreamParser.m6972b(bitSource.m6949b(i60), i90);
                        i90++;
                    }
                    if (iM6972b < 0) {
                        throw FormatException.m9260a();
                    }
                    byte[] bArr4 = new byte[iM6972b];
                    int i91 = 0;
                    while (i91 < iM6972b) {
                        if (bitSource.m6948a() < i60) {
                            throw FormatException.m9260a();
                        }
                        bArr4[i91] = (byte) DecodedBitStreamParser.m6972b(bitSource.m6949b(i60), i90);
                        i91++;
                        i90++;
                    }
                    arrayList.add(bArr4);
                    try {
                        sb.append(new String(bArr4, "ISO8859_1"));
                    } catch (UnsupportedEncodingException e) {
                        throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e)));
                    }
                }
            }
            i72 = 2;
            i = 1;
            if (i72 != i) {
            }
        }
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String string = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new DecoderResult(bArr2, string, arrayList, null);
    }
}
