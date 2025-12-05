package p007b.p225i.p414e.p434s.p435b;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.ArrayList;
import java.util.Map;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p414e.DecodeHintType;
import p007b.p225i.p414e.p418n.BitMatrix;
import p007b.p225i.p414e.p418n.BitSource;
import p007b.p225i.p414e.p418n.CharacterSetECI;
import p007b.p225i.p414e.p418n.DecoderResult;
import p007b.p225i.p414e.p418n.p420l.GenericGF;
import p007b.p225i.p414e.p418n.p420l.ReedSolomonDecoder;
import p007b.p225i.p414e.p434s.p435b.Version3;

/* compiled from: Decoder.java */
/* renamed from: b.i.e.s.b.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class Decoder5 {

    /* renamed from: a */
    public final ReedSolomonDecoder f13526a = new ReedSolomonDecoder(GenericGF.f13303e);

    /* renamed from: a */
    public DecoderResult m7097a(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        ChecksumException checksumException;
        BitMatrixParser3 bitMatrixParser3 = new BitMatrixParser3(bitMatrix);
        try {
            return m7098b(bitMatrixParser3, map);
        } catch (ChecksumException e) {
            checksumException = e;
            e = null;
            try {
                bitMatrixParser3.m7088e();
                bitMatrixParser3.f13511b = null;
                bitMatrixParser3.f13512c = null;
                bitMatrixParser3.f13513d = true;
                bitMatrixParser3.m7087d();
                bitMatrixParser3.m7086c();
                bitMatrixParser3.m7085b();
                DecoderResult decoderResultM7098b = m7098b(bitMatrixParser3, map);
                decoderResultM7098b.f13271f = new QRCodeDecoderMetaData(true);
                return decoderResultM7098b;
            } catch (ChecksumException | FormatException unused) {
                if (e != null) {
                    throw e;
                }
                throw checksumException;
            }
        } catch (FormatException e2) {
            e = e2;
            checksumException = null;
            bitMatrixParser3.m7088e();
            bitMatrixParser3.f13511b = null;
            bitMatrixParser3.f13512c = null;
            bitMatrixParser3.f13513d = true;
            bitMatrixParser3.m7087d();
            bitMatrixParser3.m7086c();
            bitMatrixParser3.m7085b();
            DecoderResult decoderResultM7098b2 = m7098b(bitMatrixParser3, map);
            decoderResultM7098b2.f13271f = new QRCodeDecoderMetaData(true);
            return decoderResultM7098b2;
        }
    }

    /* renamed from: b */
    public final DecoderResult m7098b(BitMatrixParser3 bitMatrixParser3, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        int iM6949b;
        Mode2 mode2;
        int i;
        int i2;
        int iM6949b2;
        BitMatrix bitMatrix;
        Version3 version3M7087d = bitMatrixParser3.m7087d();
        ErrorCorrectionLevel errorCorrectionLevel = bitMatrixParser3.m7086c().f13534b;
        FormatInformation formatInformationM7086c = bitMatrixParser3.m7086c();
        Version3 version3M7087d2 = bitMatrixParser3.m7087d();
        DataMask dataMask = DataMask.values()[formatInformationM7086c.f13535c];
        BitMatrix bitMatrix2 = bitMatrixParser3.f13510a;
        int i3 = bitMatrix2.f13230k;
        dataMask.m7090g(bitMatrix2, i3);
        int iM7105c = version3M7087d2.m7105c();
        BitMatrix bitMatrix3 = new BitMatrix(iM7105c, iM7105c);
        int i4 = 0;
        bitMatrix3.m6947k(0, 0, 9, 9);
        int i5 = iM7105c - 8;
        bitMatrix3.m6947k(i5, 0, 8, 9);
        bitMatrix3.m6947k(0, i5, 9, 8);
        int length = version3M7087d2.f13551d.length;
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = version3M7087d2.f13551d[i6] - 2;
            for (int i8 = 0; i8 < length; i8++) {
                if ((i6 != 0 || (i8 != 0 && i8 != length - 1)) && (i6 != length - 1 || i8 != 0)) {
                    bitMatrix3.m6947k(version3M7087d2.f13551d[i8] - 2, i7, 5, 5);
                }
            }
        }
        int i9 = iM7105c - 17;
        int i10 = 6;
        bitMatrix3.m6947k(6, 9, 1, i9);
        bitMatrix3.m6947k(9, 6, i9, 1);
        if (version3M7087d2.f13550c > 6) {
            int i11 = iM7105c - 11;
            bitMatrix3.m6947k(i11, 0, 3, 6);
            bitMatrix3.m6947k(0, i11, 6, 3);
        }
        int i12 = version3M7087d2.f13553f;
        byte[] bArr = new byte[i12];
        int i13 = i3 - 1;
        int i14 = i13;
        int i15 = 0;
        boolean z2 = true;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int i18 = 2;
            if (i14 <= 0) {
                break;
            }
            if (i14 == i10) {
                i14--;
            }
            int i19 = 0;
            while (i19 < i3) {
                int i20 = z2 ? i13 - i19 : i19;
                while (i4 < i18) {
                    int i21 = i14 - i4;
                    if (bitMatrix3.m6942f(i21, i20)) {
                        bitMatrix = bitMatrix3;
                    } else {
                        int i22 = i16 + 1;
                        int i23 = i17 << 1;
                        bitMatrix = bitMatrix3;
                        int i24 = bitMatrixParser3.f13510a.m6942f(i21, i20) ? i23 | 1 : i23;
                        if (i22 == 8) {
                            bArr[i15] = (byte) i24;
                            i15++;
                            i16 = 0;
                            i17 = 0;
                        } else {
                            i17 = i24;
                            i16 = i22;
                        }
                    }
                    i4++;
                    bitMatrix3 = bitMatrix;
                    i18 = 2;
                }
                i19++;
                i4 = 0;
                i18 = 2;
            }
            z2 = !z2;
            i14 -= 2;
            i4 = 0;
            i10 = 6;
        }
        if (i15 != version3M7087d2.f13553f) {
            throw FormatException.m9260a();
        }
        if (i12 != version3M7087d.f13553f) {
            throw new IllegalArgumentException();
        }
        Version3.b bVar = version3M7087d.f13552e[errorCorrectionLevel.ordinal()];
        Version3.a[] aVarArr = bVar.f13557b;
        int i25 = 0;
        for (Version3.a aVar : aVarArr) {
            i25 += aVar.f13554a;
        }
        DataBlock2[] dataBlock2Arr = new DataBlock2[i25];
        int i26 = 0;
        for (Version3.a aVar2 : aVarArr) {
            int i27 = 0;
            while (i27 < aVar2.f13554a) {
                int i28 = aVar2.f13555b;
                dataBlock2Arr[i26] = new DataBlock2(i28, new byte[bVar.f13556a + i28]);
                i27++;
                i26++;
            }
        }
        int length2 = dataBlock2Arr[0].f13515b.length;
        int i29 = i25 - 1;
        while (i29 >= 0 && dataBlock2Arr[i29].f13515b.length != length2) {
            i29--;
        }
        int i30 = i29 + 1;
        int i31 = length2 - bVar.f13556a;
        int i32 = 0;
        for (int i33 = 0; i33 < i31; i33++) {
            int i34 = 0;
            while (i34 < i26) {
                dataBlock2Arr[i34].f13515b[i33] = bArr[i32];
                i34++;
                i32++;
            }
        }
        int i35 = i30;
        while (i35 < i26) {
            dataBlock2Arr[i35].f13515b[i31] = bArr[i32];
            i35++;
            i32++;
        }
        boolean z3 = false;
        int length3 = dataBlock2Arr[0].f13515b.length;
        while (i31 < length3) {
            int i36 = 0;
            while (i36 < i26) {
                dataBlock2Arr[i36].f13515b[i36 < i30 ? i31 : i31 + 1] = bArr[i32];
                i36++;
                i32++;
            }
            i31++;
        }
        int i37 = 0;
        for (int i38 = 0; i38 < i25; i38++) {
            i37 += dataBlock2Arr[i38].f13514a;
        }
        byte[] bArr2 = new byte[i37];
        int i39 = 0;
        for (int i40 = 0; i40 < i25; i40++) {
            DataBlock2 dataBlock2 = dataBlock2Arr[i40];
            byte[] bArr3 = dataBlock2.f13515b;
            int i41 = dataBlock2.f13514a;
            int length4 = bArr3.length;
            int[] iArr = new int[length4];
            for (int i42 = 0; i42 < length4; i42++) {
                iArr[i42] = bArr3[i42] & 255;
            }
            try {
                this.f13526a.m6968a(iArr, bArr3.length - i41);
                for (int i43 = 0; i43 < i41; i43++) {
                    bArr3[i43] = (byte) iArr[i43];
                }
                int i44 = 0;
                while (i44 < i41) {
                    bArr2[i39] = bArr3[i44];
                    i44++;
                    i39++;
                }
            } catch (ReedSolomonException unused) {
                throw ChecksumException.m9259a();
            }
        }
        char[] cArr = DecodedBitStreamParser4.f13525a;
        Mode2 mode22 = Mode2.TERMINATOR;
        BitSource bitSource = new BitSource(bArr2);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int iM6949b3 = -1;
        int iM6949b4 = -1;
        CharacterSetECI characterSetECIM6950f = null;
        while (true) {
            try {
                if (bitSource.m6948a() < 4 || (iM6949b = bitSource.m6949b(4)) == 0) {
                    mode2 = mode22;
                } else if (iM6949b == 1) {
                    mode2 = Mode2.NUMERIC;
                } else if (iM6949b == 2) {
                    mode2 = Mode2.ALPHANUMERIC;
                } else if (iM6949b == 3) {
                    mode2 = Mode2.STRUCTURED_APPEND;
                } else if (iM6949b == 4) {
                    mode2 = Mode2.BYTE;
                } else if (iM6949b == 5) {
                    mode2 = Mode2.FNC1_FIRST_POSITION;
                } else if (iM6949b == 7) {
                    mode2 = Mode2.ECI;
                } else if (iM6949b == 8) {
                    mode2 = Mode2.KANJI;
                } else if (iM6949b == 9) {
                    mode2 = Mode2.FNC1_SECOND_POSITION;
                } else {
                    if (iM6949b != 13) {
                        throw new IllegalArgumentException();
                    }
                    mode2 = Mode2.HANZI;
                }
                int iOrdinal = mode2.ordinal();
                if (iOrdinal == 0) {
                    i2 = iM6949b3;
                    i = iM6949b4;
                } else {
                    if (iOrdinal != 3) {
                        if (iOrdinal == 5) {
                            int iM6949b5 = bitSource.m6949b(8);
                            if ((iM6949b5 & 128) == 0) {
                                iM6949b2 = iM6949b5 & Opcodes.LAND;
                            } else if ((iM6949b5 & Opcodes.CHECKCAST) == 128) {
                                iM6949b2 = ((iM6949b5 & 63) << 8) | bitSource.m6949b(8);
                            } else {
                                if ((iM6949b5 & 224) != 192) {
                                    throw FormatException.m9260a();
                                }
                                iM6949b2 = ((iM6949b5 & 31) << 16) | bitSource.m6949b(16);
                            }
                            characterSetECIM6950f = CharacterSetECI.m6950f(iM6949b2);
                            if (characterSetECIM6950f == null) {
                                throw FormatException.m9260a();
                            }
                        } else if (iOrdinal == 7 || iOrdinal == 8) {
                            z3 = true;
                        } else if (iOrdinal != 9) {
                            int iM6949b6 = bitSource.m6949b(mode2.m7101f(version3M7087d));
                            int iOrdinal2 = mode2.ordinal();
                            if (iOrdinal2 == 1) {
                                DecodedBitStreamParser4.m7095e(bitSource, sb, iM6949b6);
                            } else if (iOrdinal2 == 2) {
                                DecodedBitStreamParser4.m7091a(bitSource, sb, iM6949b6, z3);
                            } else if (iOrdinal2 == 4) {
                                DecodedBitStreamParser4.m7092b(bitSource, sb, iM6949b6, characterSetECIM6950f, arrayList, map);
                            } else {
                                if (iOrdinal2 != 6) {
                                    throw FormatException.m9260a();
                                }
                                DecodedBitStreamParser4.m7094d(bitSource, sb, iM6949b6);
                            }
                        } else {
                            int iM6949b7 = bitSource.m6949b(4);
                            int iM6949b8 = bitSource.m6949b(mode2.m7101f(version3M7087d));
                            if (iM6949b7 == 1) {
                                DecodedBitStreamParser4.m7093c(bitSource, sb, iM6949b8);
                            }
                        }
                        i2 = iM6949b3;
                        i = iM6949b4;
                    } else {
                        if (bitSource.m6948a() < 16) {
                            throw FormatException.m9260a();
                        }
                        iM6949b3 = bitSource.m6949b(8);
                        iM6949b4 = bitSource.m6949b(8);
                    }
                    i2 = iM6949b3;
                    i = iM6949b4;
                }
                if (mode2 == mode22) {
                    return new DecoderResult(bArr2, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel.toString(), i2, i);
                }
                iM6949b3 = i2;
                iM6949b4 = i;
            } catch (IllegalArgumentException unused2) {
                throw FormatException.m9260a();
            }
        }
    }
}
