package p007b.p225i.p414e.p426q.p427r.p428f.p429d;

import com.discord.widgets.chat.input.MentionUtils;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.p418n.BitArray;

/* compiled from: GeneralAppIdDecoder.java */
/* renamed from: b.i.e.q.r.f.d.s, reason: use source file name */
/* loaded from: classes3.dex */
public final class GeneralAppIdDecoder {

    /* renamed from: a */
    public final BitArray f13457a;

    /* renamed from: b */
    public final CurrentParsingState f13458b = new CurrentParsingState();

    /* renamed from: c */
    public final StringBuilder f13459c = new StringBuilder();

    public GeneralAppIdDecoder(BitArray bitArray) {
        this.f13457a = bitArray;
    }

    /* renamed from: d */
    public static int m7038d(BitArray bitArray, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (bitArray.m6935b(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    /* renamed from: a */
    public String m7039a(StringBuilder sb, int i) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            DecodedInformation decodedInformationM7040b = m7040b(i, str);
            String strM7035a = FieldParser.m7035a(decodedInformationM7040b.f13446b);
            if (strM7035a != null) {
                sb.append(strM7035a);
            }
            String strValueOf = decodedInformationM7040b.f13448d ? String.valueOf(decodedInformationM7040b.f13447c) : null;
            int i2 = decodedInformationM7040b.f13451a;
            if (i == i2) {
                return sb.toString();
            }
            i = i2;
            str = strValueOf;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x0285, code lost:
    
        r1 = r2.f13442b;
     */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x039c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x039e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0249 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0358 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x017b  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DecodedInformation m7040b(int i, String str) throws FormatException {
        boolean zM6935b;
        boolean z2;
        BlockParsedResult blockParsedResult;
        boolean z3;
        DecodedNumeric decodedNumeric;
        boolean z4;
        char c;
        DecodedChar decodedChar;
        DecodedChar decodedChar2;
        int iM7038d;
        int i2;
        boolean z5;
        char c2;
        DecodedChar decodedChar3;
        DecodedChar decodedChar4;
        int iM7038d2;
        this.f13459c.setLength(0);
        if (str != null) {
            this.f13459c.append(str);
        }
        this.f13458b.f13443a = i;
        int i3 = 2;
        while (true) {
            CurrentParsingState currentParsingState = this.f13458b;
            int i4 = currentParsingState.f13443a;
            int i5 = currentParsingState.f13444b;
            if (i5 == i3) {
                while (true) {
                    int i6 = this.f13458b.f13443a;
                    int i7 = i6 + 5;
                    BitArray bitArray = this.f13457a;
                    if (i7 <= bitArray.f13228k) {
                        int iM7038d3 = m7038d(bitArray, i6, 5);
                        if (iM7038d3 < 5 || iM7038d3 >= 16) {
                            int i8 = i6 + 6;
                            BitArray bitArray2 = this.f13457a;
                            if (i8 > bitArray2.f13228k || (iM7038d2 = m7038d(bitArray2, i6, 6)) < 16 || iM7038d2 >= 63) {
                                z5 = false;
                            }
                            if (z5) {
                                if (m7042e(this.f13458b.f13443a)) {
                                    this.f13458b.m7034a(3);
                                    this.f13458b.f13444b = 1;
                                } else if (m7043f(this.f13458b.f13443a)) {
                                    CurrentParsingState currentParsingState2 = this.f13458b;
                                    int i9 = currentParsingState2.f13443a + 5;
                                    int i10 = this.f13457a.f13228k;
                                    if (i9 < i10) {
                                        currentParsingState2.m7034a(5);
                                    } else {
                                        currentParsingState2.f13443a = i10;
                                    }
                                    this.f13458b.f13444b = 3;
                                }
                                blockParsedResult = new BlockParsedResult(null, false);
                            } else {
                                int i11 = this.f13458b.f13443a;
                                int iM7038d4 = m7038d(this.f13457a, i11, 5);
                                if (iM7038d4 == 15) {
                                    decodedChar4 = new DecodedChar(i11 + 5, '$');
                                } else {
                                    if (iM7038d4 < 5 || iM7038d4 >= 15) {
                                        int iM7038d5 = m7038d(this.f13457a, i11, 6);
                                        if (iM7038d5 < 32 || iM7038d5 >= 58) {
                                            switch (iM7038d5) {
                                                case 58:
                                                    c2 = '*';
                                                    break;
                                                case 59:
                                                    c2 = ',';
                                                    break;
                                                case 60:
                                                    c2 = '-';
                                                    break;
                                                case 61:
                                                    c2 = '.';
                                                    break;
                                                case 62:
                                                    c2 = MentionUtils.SLASH_CHAR;
                                                    break;
                                                default:
                                                    throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(iM7038d5)));
                                            }
                                            decodedChar3 = new DecodedChar(i11 + 6, c2);
                                        } else {
                                            decodedChar3 = new DecodedChar(i11 + 6, (char) (iM7038d5 + 33));
                                        }
                                    } else {
                                        decodedChar3 = new DecodedChar(i11 + 5, (char) ((iM7038d4 + 48) - 5));
                                    }
                                    decodedChar4 = decodedChar3;
                                }
                                CurrentParsingState currentParsingState3 = this.f13458b;
                                int i12 = decodedChar4.f13451a;
                                currentParsingState3.f13443a = i12;
                                char c3 = decodedChar4.f13445b;
                                if (c3 == '$') {
                                    blockParsedResult = new BlockParsedResult(new DecodedInformation(i12, this.f13459c.toString()), true);
                                } else {
                                    this.f13459c.append(c3);
                                }
                            }
                        }
                        z5 = true;
                        if (z5) {
                        }
                    }
                    i2 = this.f13458b.f13443a;
                    if (((i4 != i2) || z3) && !z3) {
                    }
                }
                z3 = blockParsedResult.f13442b;
            } else if (i5 == 3) {
                while (true) {
                    int i13 = this.f13458b.f13443a;
                    int i14 = i13 + 5;
                    BitArray bitArray3 = this.f13457a;
                    if (i14 <= bitArray3.f13228k) {
                        int iM7038d6 = m7038d(bitArray3, i13, 5);
                        if (iM7038d6 < 5 || iM7038d6 >= 16) {
                            int i15 = i13 + 7;
                            BitArray bitArray4 = this.f13457a;
                            if (i15 <= bitArray4.f13228k) {
                                int iM7038d7 = m7038d(bitArray4, i13, 7);
                                if (iM7038d7 < 64 || iM7038d7 >= 116) {
                                    int i16 = i13 + 8;
                                    BitArray bitArray5 = this.f13457a;
                                    if (i16 <= bitArray5.f13228k && (iM7038d = m7038d(bitArray5, i13, 8)) >= 232 && iM7038d < 253) {
                                    }
                                    if (z4) {
                                        if (m7042e(this.f13458b.f13443a)) {
                                            this.f13458b.m7034a(3);
                                            this.f13458b.f13444b = 1;
                                        } else if (m7043f(this.f13458b.f13443a)) {
                                            CurrentParsingState currentParsingState4 = this.f13458b;
                                            int i17 = currentParsingState4.f13443a + 5;
                                            int i18 = this.f13457a.f13228k;
                                            if (i17 < i18) {
                                                currentParsingState4.m7034a(5);
                                            } else {
                                                currentParsingState4.f13443a = i18;
                                            }
                                            this.f13458b.f13444b = 2;
                                        }
                                        blockParsedResult = new BlockParsedResult(null, false);
                                    } else {
                                        int i19 = this.f13458b.f13443a;
                                        int iM7038d8 = m7038d(this.f13457a, i19, 5);
                                        if (iM7038d8 == 15) {
                                            decodedChar2 = new DecodedChar(i19 + 5, '$');
                                        } else {
                                            if (iM7038d8 < 5 || iM7038d8 >= 15) {
                                                int iM7038d9 = m7038d(this.f13457a, i19, 7);
                                                if (iM7038d9 >= 64 && iM7038d9 < 90) {
                                                    decodedChar = new DecodedChar(i19 + 7, (char) (iM7038d9 + 1));
                                                } else if (iM7038d9 < 90 || iM7038d9 >= 116) {
                                                    switch (m7038d(this.f13457a, i19, 8)) {
                                                        case 232:
                                                            c = '!';
                                                            break;
                                                        case 233:
                                                            c = '\"';
                                                            break;
                                                        case 234:
                                                            c = '%';
                                                            break;
                                                        case 235:
                                                            c = '&';
                                                            break;
                                                        case 236:
                                                            c = '\'';
                                                            break;
                                                        case 237:
                                                            c = '(';
                                                            break;
                                                        case 238:
                                                            c = ')';
                                                            break;
                                                        case 239:
                                                            c = '*';
                                                            break;
                                                        case 240:
                                                            c = '+';
                                                            break;
                                                        case 241:
                                                            c = ',';
                                                            break;
                                                        case 242:
                                                            c = '-';
                                                            break;
                                                        case 243:
                                                            c = '.';
                                                            break;
                                                        case 244:
                                                            c = MentionUtils.SLASH_CHAR;
                                                            break;
                                                        case 245:
                                                            c = MentionUtils.EMOJIS_AND_STICKERS_CHAR;
                                                            break;
                                                        case 246:
                                                            c = ';';
                                                            break;
                                                        case 247:
                                                            c = '<';
                                                            break;
                                                        case 248:
                                                            c = '=';
                                                            break;
                                                        case 249:
                                                            c = '>';
                                                            break;
                                                        case 250:
                                                            c = '?';
                                                            break;
                                                        case 251:
                                                            c = '_';
                                                            break;
                                                        case 252:
                                                            c = ' ';
                                                            break;
                                                        default:
                                                            throw FormatException.m9260a();
                                                    }
                                                    decodedChar = new DecodedChar(i19 + 8, c);
                                                } else {
                                                    decodedChar = new DecodedChar(i19 + 7, (char) (iM7038d9 + 7));
                                                }
                                            } else {
                                                decodedChar = new DecodedChar(i19 + 5, (char) ((iM7038d8 + 48) - 5));
                                            }
                                            decodedChar2 = decodedChar;
                                        }
                                        CurrentParsingState currentParsingState5 = this.f13458b;
                                        int i20 = decodedChar2.f13451a;
                                        currentParsingState5.f13443a = i20;
                                        char c4 = decodedChar2.f13445b;
                                        if (c4 == '$') {
                                            blockParsedResult = new BlockParsedResult(new DecodedInformation(i20, this.f13459c.toString()), true);
                                        } else {
                                            this.f13459c.append(c4);
                                        }
                                    }
                                }
                            }
                            z4 = false;
                            if (z4) {
                            }
                        }
                        z4 = true;
                        if (z4) {
                        }
                    } else {
                        z4 = false;
                        if (z4) {
                        }
                    }
                    i2 = this.f13458b.f13443a;
                    i3 = i4 != i2 ? 2 : 2;
                }
            } else {
                while (true) {
                    int i21 = this.f13458b.f13443a;
                    int i22 = i21 + 7;
                    int i23 = this.f13457a.f13228k;
                    if (i22 > i23) {
                        zM6935b = i21 + 4 <= i23;
                        if (zM6935b) {
                            int i24 = this.f13458b.f13443a;
                            if (i24 + 1 > this.f13457a.f13228k) {
                                z2 = false;
                                if (!z2) {
                                    CurrentParsingState currentParsingState6 = this.f13458b;
                                    currentParsingState6.f13444b = 2;
                                    currentParsingState6.m7034a(4);
                                }
                                blockParsedResult = new BlockParsedResult(null, false);
                            } else {
                                for (int i25 = 0; i25 < 4; i25++) {
                                    int i26 = i25 + i24;
                                    BitArray bitArray6 = this.f13457a;
                                    if (i26 >= bitArray6.f13228k) {
                                        z2 = true;
                                        if (!z2) {
                                        }
                                        blockParsedResult = new BlockParsedResult(null, false);
                                    } else if (bitArray6.m6935b(i26)) {
                                        z2 = false;
                                        if (!z2) {
                                        }
                                        blockParsedResult = new BlockParsedResult(null, false);
                                    }
                                }
                                z2 = true;
                                if (!z2) {
                                }
                                blockParsedResult = new BlockParsedResult(null, false);
                            }
                        } else {
                            int i27 = this.f13458b.f13443a;
                            int i28 = i27 + 7;
                            BitArray bitArray7 = this.f13457a;
                            if (i28 > bitArray7.f13228k) {
                                int iM7038d10 = m7038d(bitArray7, i27, 4);
                                decodedNumeric = iM7038d10 == 0 ? new DecodedNumeric(this.f13457a.f13228k, 10, 10) : new DecodedNumeric(this.f13457a.f13228k, iM7038d10 - 1, 10);
                            } else {
                                int iM7038d11 = m7038d(bitArray7, i27, 7) - 8;
                                decodedNumeric = new DecodedNumeric(i28, iM7038d11 / 11, iM7038d11 % 11);
                            }
                            CurrentParsingState currentParsingState7 = this.f13458b;
                            int i29 = decodedNumeric.f13451a;
                            currentParsingState7.f13443a = i29;
                            int i30 = decodedNumeric.f13449b;
                            if (i30 == 10) {
                                blockParsedResult = new BlockParsedResult(decodedNumeric.f13450c == 10 ? new DecodedInformation(i29, this.f13459c.toString()) : new DecodedInformation(i29, this.f13459c.toString(), decodedNumeric.f13450c), true);
                            } else {
                                this.f13459c.append(i30);
                                int i31 = decodedNumeric.f13450c;
                                if (i31 == 10) {
                                    blockParsedResult = new BlockParsedResult(new DecodedInformation(this.f13458b.f13443a, this.f13459c.toString()), true);
                                } else {
                                    this.f13459c.append(i31);
                                }
                            }
                        }
                    } else {
                        int i32 = i21;
                        while (true) {
                            int i33 = i21 + 3;
                            if (i32 >= i33) {
                                zM6935b = this.f13457a.m6935b(i33);
                            } else if (!this.f13457a.m6935b(i32)) {
                                i32++;
                            }
                        }
                        if (zM6935b) {
                        }
                    }
                    i2 = this.f13458b.f13443a;
                    if (i4 != i2) {
                    }
                }
                z3 = blockParsedResult.f13442b;
                i2 = this.f13458b.f13443a;
                if (i4 != i2) {
                }
            }
            i2 = this.f13458b.f13443a;
            if (i4 != i2) {
            }
        }
        DecodedInformation decodedInformation = blockParsedResult.f13441a;
        return (decodedInformation == null || !decodedInformation.f13448d) ? new DecodedInformation(i2, this.f13459c.toString()) : new DecodedInformation(i2, this.f13459c.toString(), decodedInformation.f13447c);
    }

    /* renamed from: c */
    public int m7041c(int i, int i2) {
        return m7038d(this.f13457a, i, i2);
    }

    /* renamed from: e */
    public final boolean m7042e(int i) {
        int i2 = i + 3;
        if (i2 > this.f13457a.f13228k) {
            return false;
        }
        while (i < i2) {
            if (this.f13457a.m6935b(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* renamed from: f */
    public final boolean m7043f(int i) {
        if (i + 1 > this.f13457a.f13228k) {
            return false;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = i2 + i;
            BitArray bitArray = this.f13457a;
            if (i3 >= bitArray.f13228k) {
                return true;
            }
            if (i2 == 2) {
                if (!bitArray.m6935b(i + 2)) {
                    return false;
                }
            } else if (bitArray.m6935b(i3)) {
                return false;
            }
        }
        return true;
    }
}
