package h0.a.a;

import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* compiled from: ClassReader.java */
/* loaded from: classes3.dex */
public class d {
    public final byte[] a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f3700b;
    public final String[] c;
    public final g[] d;
    public final int[] e;
    public final int f;
    public final int g;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public d(byte[] bArr, int i, boolean z2) {
        int i2;
        this.a = bArr;
        if (z2) {
            int i3 = i + 6;
            if (q(i3) > 56) {
                StringBuilder sbU = b.d.b.a.a.U("Unsupported class file major version ");
                sbU.append((int) q(i3));
                throw new IllegalArgumentException(sbU.toString());
            }
        }
        int iU = u(i + 8);
        this.f3700b = new int[iU];
        this.c = new String[iU];
        int i4 = i + 10;
        int i5 = 1;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            int iU2 = 4;
            if (i5 >= iU) {
                this.f = i6;
                this.g = i4;
                int[] iArr = null;
                this.d = z3 ? new g[iU] : null;
                if (z3 | z4) {
                    char[] cArr = new char[i6];
                    int iC = c();
                    int iU3 = u(iC - 2);
                    while (true) {
                        if (iU3 > 0) {
                            String strT = t(iC, cArr);
                            int iL = l(iC + 2);
                            int i7 = iC + 6;
                            if ("BootstrapMethods".equals(strT)) {
                                int iU4 = u(i7);
                                int[] iArr2 = new int[iU4];
                                int iU5 = i7 + 2;
                                for (int i8 = 0; i8 < iU4; i8++) {
                                    iArr2[i8] = iU5;
                                    iU5 += (u(iU5 + 2) * 2) + 4;
                                }
                                iArr = iArr2;
                            } else {
                                iC = i7 + iL;
                                iU3--;
                            }
                        }
                    }
                }
                this.e = iArr;
                return;
            }
            int i9 = i5 + 1;
            int i10 = i4 + 1;
            this.f3700b[i5] = i10;
            switch (bArr[i4]) {
                case 1:
                    iU2 = u(i10) + 3;
                    if (iU2 > i6) {
                        i6 = iU2;
                    }
                    i2 = iU2;
                    i4 += i2;
                    i5 = i9;
                case 2:
                case 13:
                case 14:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                    i2 = 5;
                    i4 += i2;
                    i5 = i9;
                case 5:
                case 6:
                    iU2 = 9;
                    i9++;
                    i2 = iU2;
                    i4 += i2;
                    i5 = i9;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    i2 = 3;
                    i4 += i2;
                    i5 = i9;
                case 15:
                    i2 = iU2;
                    i4 += i2;
                    i5 = i9;
                case 17:
                    z3 = true;
                    i2 = 5;
                    i4 += i2;
                    i5 = i9;
                case 18:
                    z4 = true;
                    i2 = 5;
                    i4 += i2;
                    i5 = i9;
            }
        }
    }

    public final void a(int i, p[] pVarArr) {
        if (pVarArr[i] == null) {
            if (pVarArr[i] == null) {
                pVarArr[i] = new p();
            }
            p pVar = pVarArr[i];
            pVar.f3714b = (short) (pVar.f3714b | 1);
        }
    }

    public final p b(int i, p[] pVarArr) {
        if (pVarArr[i] == null) {
            pVarArr[i] = new p();
        }
        p pVar = pVarArr[i];
        pVar.f3714b = (short) (pVar.f3714b & (-2));
        return pVar;
    }

    public final int c() {
        int i = this.g;
        int iU = (u(i + 6) * 2) + i + 8;
        int iU2 = u(iU);
        int iL = iU + 2;
        while (true) {
            int i2 = iU2 - 1;
            if (iU2 <= 0) {
                break;
            }
            int iU3 = u(iL + 6);
            iL += 8;
            while (true) {
                int i3 = iU3 - 1;
                if (iU3 > 0) {
                    iL += l(iL + 2) + 6;
                    iU3 = i3;
                }
            }
            iU2 = i2;
        }
        int iU4 = u(iL);
        int iL2 = iL + 2;
        while (true) {
            int i4 = iU4 - 1;
            if (iU4 <= 0) {
                return iL2 + 2;
            }
            int iU5 = u(iL2 + 6);
            iL2 += 8;
            while (true) {
                int i5 = iU5 - 1;
                if (iU5 > 0) {
                    iL2 += l(iL2 + 2) + 6;
                    iU5 = i5;
                }
            }
            iU4 = i4;
        }
    }

    public final int d(int[] iArr, int i) {
        if (iArr == null || i >= iArr.length || f(iArr[i]) < 67) {
            return -1;
        }
        return u(iArr[i] + 1);
    }

    public final b e(b[] bVarArr, String str, int i, int i2, char[] cArr, int i3, p[] pVarArr) {
        for (b bVar : bVarArr) {
            if (bVar.a.equals(str)) {
                b bVar2 = new b(bVar.a);
                byte[] bArr = new byte[i2];
                bVar2.f3697b = bArr;
                System.arraycopy(this.a, i, bArr, 0, i2);
                return bVar2;
            }
        }
        b bVar3 = new b(str);
        byte[] bArr2 = new byte[i2];
        bVar3.f3697b = bArr2;
        System.arraycopy(this.a, i, bArr2, 0, i2);
        return bVar3;
    }

    public int f(int i) {
        return this.a[i] & 255;
    }

    public String g(int i, char[] cArr) {
        return t(this.f3700b[u(i)], cArr);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:138:0x036d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0683  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0695  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x06b7  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x06f7  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x070b  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x077e  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x078f  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0845  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x089e  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x092f  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0972  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x098c  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x09a6  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x09be  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x09d8  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x09f1  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0a17  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0a31  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0a4b  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0a63  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0a80  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0a87  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0ab0  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0ab7  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0ad9  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x068f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(q qVar, h hVar, int i) {
        p[] pVarArr;
        int i2;
        p[] pVarArr2;
        int i3;
        b bVar;
        int i4;
        int i5;
        b bVar2;
        int[] iArr;
        String strT;
        int i6;
        int i7;
        boolean z2;
        int i8;
        boolean z3;
        boolean z4;
        int i9;
        int i10;
        int iD;
        int i11;
        boolean z5;
        int[] iArr2;
        boolean z6;
        int i12;
        boolean z7;
        int i13;
        int iD2;
        boolean z8;
        int i14;
        int i15;
        int[] iArr3;
        int[] iArr4;
        int i16;
        int i17;
        int i18;
        boolean z9;
        int i19;
        int i20;
        int i21;
        p[] pVarArr3;
        int i22;
        int iU;
        int iX;
        short s2;
        p[] pVarArr4;
        int i23;
        int iU2;
        int i24;
        int i25;
        int[] iArr5;
        p[] pVarArr5;
        int i26;
        int i27;
        p[] pVarArr6;
        int i28;
        int i29;
        int[] iArrS;
        int i30;
        int[] iArr6;
        p[] pVarArr7;
        int i31;
        int i32;
        int i33;
        int i34;
        byte[] bArr = this.a;
        char[] cArr = hVar.c;
        int iU3 = u(i);
        int iU4 = u(i + 2);
        int iL = l(i + 4);
        int i35 = i + 8;
        int i36 = i35 + iL;
        p[] pVarArr8 = new p[iL + 1];
        hVar.g = pVarArr8;
        int i37 = i35;
        while (i37 < i36) {
            int i38 = i37 - i35;
            switch (bArr[i37] & 255) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case Opcodes.LUSHR /* 125 */:
                case 126:
                case Opcodes.LAND /* 127 */:
                case 128:
                case Opcodes.LOR /* 129 */:
                case 130:
                case Opcodes.LXOR /* 131 */:
                case Opcodes.I2L /* 133 */:
                case Opcodes.I2F /* 134 */:
                case Opcodes.I2D /* 135 */:
                case Opcodes.L2I /* 136 */:
                case Opcodes.L2F /* 137 */:
                case Opcodes.L2D /* 138 */:
                case Opcodes.F2I /* 139 */:
                case Opcodes.F2L /* 140 */:
                case Opcodes.F2D /* 141 */:
                case Opcodes.D2I /* 142 */:
                case Opcodes.D2L /* 143 */:
                case Opcodes.D2F /* 144 */:
                case Opcodes.I2B /* 145 */:
                case Opcodes.I2C /* 146 */:
                case Opcodes.I2S /* 147 */:
                case Opcodes.LCMP /* 148 */:
                case Opcodes.FCMPL /* 149 */:
                case 150:
                case Opcodes.DCMPL /* 151 */:
                case Opcodes.DCMPG /* 152 */:
                case Opcodes.IRETURN /* 172 */:
                case Opcodes.LRETURN /* 173 */:
                case Opcodes.FRETURN /* 174 */:
                case 175:
                case Opcodes.ARETURN /* 176 */:
                case Opcodes.RETURN /* 177 */:
                case Opcodes.ARRAYLENGTH /* 190 */:
                case Opcodes.ATHROW /* 191 */:
                case Opcodes.MONITORENTER /* 194 */:
                case Opcodes.MONITOREXIT /* 195 */:
                    i37++;
                case 16:
                case 18:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case Opcodes.RET /* 169 */:
                case Opcodes.NEWARRAY /* 188 */:
                    i37 += 2;
                case 17:
                case 19:
                case 20:
                case Opcodes.IINC /* 132 */:
                case Opcodes.GETSTATIC /* 178 */:
                case Opcodes.PUTSTATIC /* 179 */:
                case 180:
                case Opcodes.PUTFIELD /* 181 */:
                case Opcodes.INVOKEVIRTUAL /* 182 */:
                case Opcodes.INVOKESPECIAL /* 183 */:
                case Opcodes.INVOKESTATIC /* 184 */:
                case Opcodes.NEW /* 187 */:
                case Opcodes.ANEWARRAY /* 189 */:
                case Opcodes.CHECKCAST /* 192 */:
                case Opcodes.INSTANCEOF /* 193 */:
                    i37 += 3;
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case Opcodes.IF_ICMPEQ /* 159 */:
                case Opcodes.IF_ICMPNE /* 160 */:
                case Opcodes.IF_ICMPLT /* 161 */:
                case Opcodes.IF_ICMPGE /* 162 */:
                case Opcodes.IF_ICMPGT /* 163 */:
                case Opcodes.IF_ICMPLE /* 164 */:
                case Opcodes.IF_ACMPEQ /* 165 */:
                case Opcodes.IF_ACMPNE /* 166 */:
                case Opcodes.GOTO /* 167 */:
                case Opcodes.JSR /* 168 */:
                case Opcodes.IFNULL /* 198 */:
                case Opcodes.IFNONNULL /* 199 */:
                    b(q(i37 + 1) + i38, pVarArr8);
                    i37 += 3;
                case Opcodes.TABLESWITCH /* 170 */:
                    int i39 = (4 - (i38 & 3)) + i37;
                    b(l(i39) + i38, pVarArr8);
                    int iL2 = (l(i39 + 8) - l(i39 + 4)) + 1;
                    i34 = i39 + 12;
                    while (true) {
                        int i40 = iL2 - 1;
                        if (iL2 > 0) {
                            b(l(i34) + i38, pVarArr8);
                            i34 += 4;
                            iL2 = i40;
                        } else {
                            i37 = i34;
                        }
                    }
                case Opcodes.LOOKUPSWITCH /* 171 */:
                    int i41 = (4 - (i38 & 3)) + i37;
                    b(l(i41) + i38, pVarArr8);
                    int iL3 = l(i41 + 4);
                    i34 = i41 + 8;
                    while (true) {
                        int i42 = iL3 - 1;
                        if (iL3 > 0) {
                            b(l(i34 + 4) + i38, pVarArr8);
                            i34 += 8;
                            iL3 = i42;
                        } else {
                            i37 = i34;
                        }
                    }
                case Opcodes.INVOKEINTERFACE /* 185 */:
                case Opcodes.INVOKEDYNAMIC /* 186 */:
                    i37 += 5;
                case 196:
                    int i43 = bArr[i37 + 1] & 255;
                    if (i43 != 132) {
                        if (i43 != 169) {
                            switch (i43) {
                                default:
                                    switch (i43) {
                                        case 54:
                                        case 55:
                                        case 56:
                                        case 57:
                                        case 58:
                                            break;
                                        default:
                                            throw new IllegalArgumentException();
                                    }
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                    i37 += 4;
                            }
                        }
                        i37 += 4;
                    } else {
                        i37 += 6;
                    }
                case Opcodes.MULTIANEWARRAY /* 197 */:
                    i37 += 4;
                case 200:
                case 201:
                case 220:
                    b(l(i37 + 1) + i38, pVarArr8);
                    i37 += 5;
                case 202:
                case 203:
                case 204:
                case 205:
                case 206:
                case 207:
                case 208:
                case 209:
                case 210:
                case 211:
                case 212:
                case 213:
                case 214:
                case 215:
                case 216:
                case 217:
                case 218:
                case 219:
                    b(u(i37 + 1) + i38, pVarArr8);
                    i37 += 3;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int iU5 = u(i37);
        int i44 = i37 + 2;
        while (true) {
            int i45 = iU5 - 1;
            if (iU5 > 0) {
                p pVarB = b(u(i44), pVarArr8);
                p pVarB2 = b(u(i44 + 2), pVarArr8);
                p pVarB3 = b(u(i44 + 4), pVarArr8);
                String strT2 = t(this.f3700b[u(i44 + 6)], cArr);
                i44 += 8;
                r rVar = (r) qVar;
                if (strT2 != null) {
                    i32 = i36;
                    i33 = rVar.d.m(7, strT2).a;
                } else {
                    i32 = i36;
                    i33 = 0;
                }
                o oVar = new o(pVarB, pVarB2, pVarB3, i33, strT2);
                if (rVar.m == null) {
                    rVar.m = oVar;
                } else {
                    rVar.n.f = oVar;
                }
                rVar.n = oVar;
                iU5 = i45;
                i36 = i32;
            } else {
                int i46 = i36;
                int iU6 = u(i44);
                int i47 = i44 + 2;
                int[] iArr7 = null;
                boolean z10 = true;
                int i48 = 0;
                b bVar3 = null;
                int i49 = 0;
                int[] iArrS2 = null;
                int i50 = 0;
                int i51 = 0;
                while (true) {
                    int i52 = iU6 - 1;
                    if (iU6 > 0) {
                        String strT3 = t(i47, cArr);
                        int iL4 = l(i47 + 2);
                        int i53 = i47 + 6;
                        if ("LocalVariableTable".equals(strT3)) {
                            if ((hVar.f3707b & 2) == 0) {
                                int iU7 = u(i53);
                                int i54 = i53 + 2;
                                while (true) {
                                    int i55 = iU7 - 1;
                                    if (iU7 > 0) {
                                        int iU8 = u(i54);
                                        a(iU8, pVarArr8);
                                        a(u(i54 + 2) + iU8, pVarArr8);
                                        i54 += 10;
                                        iU7 = i55;
                                    } else {
                                        i50 = i53;
                                        iArrS = iArr7;
                                        pVarArr5 = pVarArr8;
                                        i26 = iL;
                                        iArr7 = iArrS;
                                        i27 = i53;
                                        i28 = i46;
                                        pVarArr6 = pVarArr5;
                                        i29 = i26;
                                    }
                                }
                            }
                            iArr5 = iArr7;
                            pVarArr5 = pVarArr8;
                            i26 = iL;
                            iArrS = iArr5;
                            iArr7 = iArrS;
                            i27 = i53;
                            i28 = i46;
                            pVarArr6 = pVarArr5;
                            i29 = i26;
                        } else if ("LocalVariableTypeTable".equals(strT3)) {
                            i51 = i53;
                            iArrS = iArr7;
                            pVarArr5 = pVarArr8;
                            i26 = iL;
                            iArr7 = iArrS;
                            i27 = i53;
                            i28 = i46;
                            pVarArr6 = pVarArr5;
                            i29 = i26;
                        } else if ("LineNumberTable".equals(strT3)) {
                            if ((hVar.f3707b & 2) == 0) {
                                int iU9 = u(i53);
                                int i56 = i53 + 2;
                                while (true) {
                                    int i57 = iU9 - 1;
                                    if (iU9 > 0) {
                                        int iU10 = u(i56);
                                        int iU11 = u(i56 + 2);
                                        int i58 = i56 + 4;
                                        a(iU10, pVarArr8);
                                        p pVar = pVarArr8[iU10];
                                        if (pVar.c == 0) {
                                            pVar.c = (short) iU11;
                                            i30 = i58;
                                            iArr6 = iArr7;
                                            pVarArr7 = pVarArr8;
                                            i31 = iL;
                                        } else {
                                            if (pVar.d == null) {
                                                i30 = i58;
                                                pVar.d = new int[4];
                                            } else {
                                                i30 = i58;
                                            }
                                            int[] iArr8 = pVar.d;
                                            iArr6 = iArr7;
                                            int i59 = iArr8[0] + 1;
                                            iArr8[0] = i59;
                                            if (i59 >= iArr8.length) {
                                                int[] iArr9 = new int[iArr8.length + 4];
                                                pVarArr7 = pVarArr8;
                                                i31 = iL;
                                                System.arraycopy(iArr8, 0, iArr9, 0, iArr8.length);
                                                pVar.d = iArr9;
                                            } else {
                                                pVarArr7 = pVarArr8;
                                                i31 = iL;
                                            }
                                            pVar.d[i59] = iU11;
                                        }
                                        iU9 = i57;
                                        i56 = i30;
                                        iArr7 = iArr6;
                                        pVarArr8 = pVarArr7;
                                        iL = i31;
                                    }
                                }
                            }
                            iArr5 = iArr7;
                            pVarArr5 = pVarArr8;
                            i26 = iL;
                            iArrS = iArr5;
                            iArr7 = iArrS;
                            i27 = i53;
                            i28 = i46;
                            pVarArr6 = pVarArr5;
                            i29 = i26;
                        } else {
                            iArr5 = iArr7;
                            pVarArr5 = pVarArr8;
                            i26 = iL;
                            if ("RuntimeVisibleTypeAnnotations".equals(strT3)) {
                                iArrS = s(qVar, hVar, i53, true);
                                iArr7 = iArrS;
                                i27 = i53;
                                i28 = i46;
                                pVarArr6 = pVarArr5;
                                i29 = i26;
                            } else if ("RuntimeInvisibleTypeAnnotations".equals(strT3)) {
                                iArrS2 = s(qVar, hVar, i53, false);
                                iArrS = iArr5;
                                iArr7 = iArrS;
                                i27 = i53;
                                i28 = i46;
                                pVarArr6 = pVarArr5;
                                i29 = i26;
                            } else {
                                if ("StackMapTable".equals(strT3)) {
                                    if ((hVar.f3707b & 4) == 0) {
                                        i48 = i53 + 2;
                                        i49 = i53 + iL4;
                                    }
                                } else if (!"StackMap".equals(strT3)) {
                                    i27 = i53;
                                    pVarArr6 = pVarArr5;
                                    i28 = i46;
                                    i29 = i26;
                                    b bVarE = e(hVar.a, strT3, i53, iL4, cArr, i, pVarArr6);
                                    bVarE.c = bVar3;
                                    bVar3 = bVarE;
                                    iArr7 = iArr5;
                                } else if ((hVar.f3707b & 4) == 0) {
                                    i48 = i53 + 2;
                                    i49 = i53 + iL4;
                                    i27 = i53;
                                    i28 = i46;
                                    iArr7 = iArr5;
                                    pVarArr6 = pVarArr5;
                                    i29 = i26;
                                    z10 = false;
                                }
                                iArrS = iArr5;
                                iArr7 = iArrS;
                                i27 = i53;
                                i28 = i46;
                                pVarArr6 = pVarArr5;
                                i29 = i26;
                            }
                        }
                        i47 = i27 + iL4;
                        pVarArr8 = pVarArr6;
                        iU6 = i52;
                        i46 = i28;
                        iL = i29;
                    } else {
                        int[] iArr10 = iArr7;
                        p[] pVarArr9 = pVarArr8;
                        int i60 = iL;
                        int i61 = i46;
                        b bVar4 = bVar3;
                        boolean z11 = (hVar.f3707b & 8) != 0;
                        if (i48 != 0) {
                            hVar.m = -1;
                            hVar.n = 0;
                            hVar.o = 0;
                            hVar.p = 0;
                            Object[] objArr = new Object[iU4];
                            hVar.q = objArr;
                            hVar.r = 0;
                            hVar.f3708s = new Object[iU3];
                            if (z11) {
                                String str = hVar.f;
                                if ((hVar.d & 8) == 0) {
                                    if ("<init>".equals(hVar.e)) {
                                        objArr[0] = t.g;
                                    } else {
                                        objArr[0] = g(this.g + 2, hVar.c);
                                    }
                                    i24 = 1;
                                } else {
                                    i24 = 0;
                                }
                                int i62 = i24;
                                int i63 = 1;
                                while (true) {
                                    int i64 = i63 + 1;
                                    char cCharAt = str.charAt(i63);
                                    if (cCharAt == 'F') {
                                        i25 = i62 + 1;
                                        objArr[i62] = t.c;
                                    } else if (cCharAt == 'L') {
                                        int i65 = i64;
                                        while (str.charAt(i65) != ';') {
                                            i65++;
                                        }
                                        objArr[i62] = str.substring(i64, i65);
                                        i62++;
                                        i63 = i65 + 1;
                                    } else if (cCharAt == 'S' || cCharAt == 'I') {
                                        i25 = i62 + 1;
                                        objArr[i62] = t.f3723b;
                                    } else if (cCharAt == 'J') {
                                        i25 = i62 + 1;
                                        objArr[i62] = t.e;
                                    } else if (cCharAt != 'Z') {
                                        if (cCharAt != '[') {
                                            switch (cCharAt) {
                                                case 'D':
                                                    i25 = i62 + 1;
                                                    objArr[i62] = t.d;
                                                    break;
                                            }
                                            hVar.o = i62;
                                        } else {
                                            while (str.charAt(i64) == '[') {
                                                i64++;
                                            }
                                            if (str.charAt(i64) == 'L') {
                                                do {
                                                    i64++;
                                                } while (str.charAt(i64) != ';');
                                            }
                                            int i66 = i64 + 1;
                                            objArr[i62] = str.substring(i63, i66);
                                            i63 = i66;
                                            i62++;
                                        }
                                    }
                                    i62 = i25;
                                    i63 = i64;
                                }
                            }
                            int i67 = i48;
                            while (true) {
                                i2 = i49;
                                if (i67 < i2 - 2) {
                                    if (bArr[i67] != 8 || (iU2 = u(i67 + 1)) < 0) {
                                        pVarArr4 = pVarArr9;
                                        i23 = i60;
                                    } else {
                                        i23 = i60;
                                        if (iU2 < i23) {
                                            if ((bArr[i35 + iU2] & 255) == 187) {
                                                pVarArr4 = pVarArr9;
                                                b(iU2, pVarArr4);
                                            } else {
                                                pVarArr4 = pVarArr9;
                                            }
                                            i67++;
                                            pVarArr9 = pVarArr4;
                                            i60 = i23;
                                            i49 = i2;
                                        } else {
                                            pVarArr4 = pVarArr9;
                                        }
                                    }
                                    i67++;
                                    pVarArr9 = pVarArr4;
                                    i60 = i23;
                                    i49 = i2;
                                } else {
                                    pVarArr = pVarArr9;
                                }
                            }
                        } else {
                            pVarArr = pVarArr9;
                            i2 = i49;
                        }
                        int i68 = i60;
                        if (!z11 || (hVar.f3707b & 256) == 0) {
                            pVarArr2 = pVarArr;
                            i3 = i68;
                            bVar = bVar4;
                            i4 = 0;
                        } else {
                            pVarArr2 = pVarArr;
                            bVar = bVar4;
                            i4 = 0;
                            i3 = i68;
                            qVar.c(-1, iU4, null, 0, null);
                        }
                        int[] iArr11 = iArr10;
                        int iD3 = d(iArr11, i4);
                        int[] iArr12 = iArrS2;
                        int iD4 = d(iArr12, i4);
                        int i69 = (hVar.f3707b & 256) == 0 ? 33 : 0;
                        int i70 = iD4;
                        int i71 = i35;
                        int i72 = i48;
                        int i73 = 0;
                        int i74 = 0;
                        int i75 = iD3;
                        boolean z12 = false;
                        while (true) {
                            int i76 = i61;
                            if (i71 >= i76) {
                                int[] iArr13 = iArr11;
                                int i77 = iU3;
                                int i78 = iU4;
                                p[] pVarArr10 = pVarArr2;
                                int[] iArr14 = iArr12;
                                if (pVarArr10[i3] != null) {
                                    qVar.i(pVarArr10[i3]);
                                }
                                int i79 = i50;
                                if (i79 != 0 && (hVar.f3707b & 2) == 0) {
                                    int i80 = i51;
                                    if (i80 != 0) {
                                        int iU12 = u(i80) * 3;
                                        int[] iArr15 = new int[iU12];
                                        int i81 = i80 + 2;
                                        while (iU12 > 0) {
                                            int i82 = iU12 - 1;
                                            iArr15[i82] = i81 + 6;
                                            int i83 = i82 - 1;
                                            iArr15[i83] = u(i81 + 8);
                                            iU12 = i83 - 1;
                                            iArr15[iU12] = u(i81);
                                            i81 += 10;
                                        }
                                        iArr = iArr15;
                                    } else {
                                        iArr = null;
                                    }
                                    int iU13 = u(i79);
                                    int i84 = i79 + 2;
                                    while (true) {
                                        int i85 = iU13 - 1;
                                        if (iU13 > 0) {
                                            int iU14 = u(i84);
                                            int iU15 = u(i84 + 2);
                                            String strT4 = t(i84 + 4, cArr);
                                            String strT5 = t(i84 + 6, cArr);
                                            int iU16 = u(i84 + 8);
                                            int i86 = i84 + 10;
                                            if (iArr != null) {
                                                for (int i87 = 0; i87 < iArr.length; i87 += 3) {
                                                    if (iArr[i87] == iU14 && iArr[i87 + 1] == iU16) {
                                                        strT = t(iArr[i87 + 2], cArr);
                                                    }
                                                }
                                                strT = null;
                                            } else {
                                                strT = null;
                                            }
                                            qVar.l(strT4, strT5, strT, pVarArr10[iU14], pVarArr10[iU14 + iU15], iU16);
                                            iU13 = i85;
                                            i84 = i86;
                                        }
                                    }
                                }
                                int i88 = 65;
                                if (iArr13 != null) {
                                    int length = iArr13.length;
                                    int i89 = 0;
                                    while (i89 < length) {
                                        int i90 = iArr13[i89];
                                        int iF = f(i90);
                                        if (iF == 64 || iF == i88) {
                                            int iR = r(hVar, i90);
                                            i5 = i89;
                                            bVar2 = bVar;
                                            k(qVar.m(hVar.h, hVar.i, hVar.j, hVar.k, hVar.l, t(iR, cArr), true), iR + 2, true, cArr);
                                        } else {
                                            i5 = i89;
                                            bVar2 = bVar;
                                        }
                                        i89 = i5 + 1;
                                        bVar = bVar2;
                                        i88 = 65;
                                    }
                                }
                                b bVar5 = bVar;
                                if (iArr14 != null) {
                                    for (int i91 : iArr14) {
                                        int iF2 = f(i91);
                                        if (iF2 == 64 || iF2 == 65) {
                                            int iR2 = r(hVar, i91);
                                            k(qVar.m(hVar.h, hVar.i, hVar.j, hVar.k, hVar.l, t(iR2, cArr), false), iR2 + 2, true, cArr);
                                        }
                                    }
                                }
                                b bVar6 = bVar5;
                                while (bVar6 != null) {
                                    b bVar7 = bVar6.c;
                                    bVar6.c = null;
                                    r rVar2 = (r) qVar;
                                    bVar6.c = rVar2.M;
                                    rVar2.M = bVar6;
                                    bVar6 = bVar7;
                                }
                                qVar.n(i77, i78);
                                return;
                            }
                            i61 = i76;
                            int i92 = i71 - i35;
                            int i93 = iU3;
                            p[] pVarArr11 = pVarArr2;
                            p pVar2 = pVarArr11[i92];
                            boolean z13 = z12;
                            if (pVar2 == null) {
                                i6 = i72;
                                i7 = i71;
                            } else {
                                boolean z14 = (hVar.f3707b & 2) == 0;
                                qVar.i(pVar2);
                                if (z14 && (s2 = pVar2.c) != 0) {
                                    qVar.k(s2 & 65535, pVar2);
                                    if (pVar2.d != null) {
                                        i6 = i72;
                                        int i94 = 1;
                                        while (true) {
                                            int[] iArr16 = pVar2.d;
                                            i7 = i71;
                                            if (i94 <= iArr16[0]) {
                                                qVar.k(iArr16[i94], pVar2);
                                                i94++;
                                                i71 = i7;
                                            }
                                        }
                                    }
                                }
                            }
                            boolean z15 = z13;
                            int i95 = i6;
                            while (i95 != 0) {
                                int i96 = hVar.m;
                                if (i96 == i92 || i96 == -1) {
                                    if (i96 != -1) {
                                        if (!z10 || z11) {
                                            iArr3 = iArr12;
                                            iArr4 = iArr11;
                                            i16 = iU4;
                                            i17 = i7;
                                            i18 = i95;
                                            qVar.c(-1, hVar.o, hVar.q, hVar.r, hVar.f3708s);
                                        } else {
                                            i16 = iU4;
                                            i18 = i95;
                                            i17 = i7;
                                            iArr3 = iArr12;
                                            iArr4 = iArr11;
                                            qVar.c(hVar.n, hVar.p, hVar.q, hVar.r, hVar.f3708s);
                                        }
                                        z9 = false;
                                    } else {
                                        iArr3 = iArr12;
                                        iArr4 = iArr11;
                                        i16 = iU4;
                                        i17 = i7;
                                        i18 = i95;
                                        z9 = z15;
                                    }
                                    if (i18 < i2) {
                                        char[] cArr2 = hVar.c;
                                        p[] pVarArr12 = hVar.g;
                                        if (z10) {
                                            i19 = i18 + 1;
                                            i21 = this.a[i18] & 255;
                                            i20 = 0;
                                        } else {
                                            hVar.m = -1;
                                            i19 = i18;
                                            i20 = 0;
                                            i21 = 255;
                                        }
                                        hVar.p = i20;
                                        if (i21 < 64) {
                                            hVar.n = 3;
                                            hVar.r = i20;
                                            iX = i19;
                                            pVarArr3 = pVarArr12;
                                            i22 = i2;
                                        } else {
                                            if (i21 < 128) {
                                                iU = i21 - 64;
                                                i22 = i2;
                                                pVarArr3 = pVarArr12;
                                                iX = x(i19, hVar.f3708s, 0, cArr2, pVarArr3);
                                                hVar.n = 4;
                                                hVar.r = 1;
                                            } else {
                                                pVarArr3 = pVarArr12;
                                                i22 = i2;
                                                if (i21 < 247) {
                                                    throw new IllegalArgumentException();
                                                }
                                                iU = u(i19);
                                                int iX2 = i19 + 2;
                                                if (i21 == 247) {
                                                    iX = x(iX2, hVar.f3708s, 0, cArr2, pVarArr3);
                                                    hVar.n = 4;
                                                    hVar.r = 1;
                                                } else {
                                                    if (i21 >= 248 && i21 < 251) {
                                                        hVar.n = 2;
                                                        int i97 = 251 - i21;
                                                        hVar.p = i97;
                                                        hVar.o -= i97;
                                                        hVar.r = 0;
                                                    } else if (i21 == 251) {
                                                        hVar.n = 3;
                                                        hVar.r = 0;
                                                    } else if (i21 < 255) {
                                                        int i98 = i21 - 251;
                                                        int i99 = z11 ? hVar.o : 0;
                                                        int i100 = i98;
                                                        while (i100 > 0) {
                                                            iX2 = x(iX2, hVar.q, i99, cArr2, pVarArr3);
                                                            i100--;
                                                            i98 = i98;
                                                            i99++;
                                                            cArr2 = cArr2;
                                                        }
                                                        int i101 = i98;
                                                        hVar.n = 1;
                                                        hVar.p = i101;
                                                        hVar.o += i101;
                                                        hVar.r = 0;
                                                    } else {
                                                        int iU17 = u(iX2);
                                                        int iX3 = iX2 + 2;
                                                        hVar.n = 0;
                                                        hVar.p = iU17;
                                                        hVar.o = iU17;
                                                        for (int i102 = 0; i102 < iU17; i102++) {
                                                            iX3 = x(iX3, hVar.q, i102, cArr2, pVarArr3);
                                                        }
                                                        int iU18 = u(iX3);
                                                        iX2 = iX3 + 2;
                                                        hVar.r = iU18;
                                                        for (int i103 = 0; i103 < iU18; i103++) {
                                                            iX2 = x(iX2, hVar.f3708s, i103, cArr2, pVarArr3);
                                                        }
                                                    }
                                                    iX = iX2;
                                                }
                                            }
                                            i21 = iU;
                                        }
                                        int i104 = i21 + 1 + hVar.m;
                                        hVar.m = i104;
                                        b(i104, pVarArr3);
                                        i95 = iX;
                                        i7 = i17;
                                        z15 = z9;
                                        i2 = i22;
                                        iU4 = i16;
                                        iArr12 = iArr3;
                                        iArr11 = iArr4;
                                    } else {
                                        i7 = i17;
                                        z15 = z9;
                                        iU4 = i16;
                                        iArr12 = iArr3;
                                        iArr11 = iArr4;
                                        i95 = 0;
                                    }
                                } else {
                                    int[] iArr17 = iArr12;
                                    int[] iArr18 = iArr11;
                                    int i105 = i2;
                                    int i106 = iU4;
                                    int i107 = i7;
                                    int i108 = i95;
                                    if (z15) {
                                        z2 = z15;
                                    } else {
                                        if ((hVar.f3707b & 8) != 0) {
                                            qVar.c(256, 0, null, 0, null);
                                        }
                                        z2 = false;
                                    }
                                    i8 = bArr[i107] & 255;
                                    switch (i8) {
                                        case 0:
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                        case 7:
                                        case 8:
                                        case 9:
                                        case 10:
                                        case 11:
                                        case 12:
                                        case 13:
                                        case 14:
                                        case 15:
                                        case 46:
                                        case 47:
                                        case 48:
                                        case 49:
                                        case 50:
                                        case 51:
                                        case 52:
                                        case 53:
                                        case 79:
                                        case 80:
                                        case 81:
                                        case 82:
                                        case 83:
                                        case 84:
                                        case 85:
                                        case 86:
                                        case 87:
                                        case 88:
                                        case 89:
                                        case 90:
                                        case 91:
                                        case 92:
                                        case 93:
                                        case 94:
                                        case 95:
                                        case 96:
                                        case 97:
                                        case 98:
                                        case 99:
                                        case 100:
                                        case 101:
                                        case 102:
                                        case 103:
                                        case 104:
                                        case 105:
                                        case 106:
                                        case 107:
                                        case 108:
                                        case 109:
                                        case 110:
                                        case 111:
                                        case 112:
                                        case 113:
                                        case 114:
                                        case 115:
                                        case 116:
                                        case 117:
                                        case 118:
                                        case 119:
                                        case 120:
                                        case 121:
                                        case 122:
                                        case 123:
                                        case 124:
                                        case Opcodes.LUSHR /* 125 */:
                                        case 126:
                                        case Opcodes.LAND /* 127 */:
                                        case 128:
                                        case Opcodes.LOR /* 129 */:
                                        case 130:
                                        case Opcodes.LXOR /* 131 */:
                                        case Opcodes.I2L /* 133 */:
                                        case Opcodes.I2F /* 134 */:
                                        case Opcodes.I2D /* 135 */:
                                        case Opcodes.L2I /* 136 */:
                                        case Opcodes.L2F /* 137 */:
                                        case Opcodes.L2D /* 138 */:
                                        case Opcodes.F2I /* 139 */:
                                        case Opcodes.F2L /* 140 */:
                                        case Opcodes.F2D /* 141 */:
                                        case Opcodes.D2I /* 142 */:
                                        case Opcodes.D2L /* 143 */:
                                        case Opcodes.D2F /* 144 */:
                                        case Opcodes.I2B /* 145 */:
                                        case Opcodes.I2C /* 146 */:
                                        case Opcodes.I2S /* 147 */:
                                        case Opcodes.LCMP /* 148 */:
                                        case Opcodes.FCMPL /* 149 */:
                                        case 150:
                                        case Opcodes.DCMPL /* 151 */:
                                        case Opcodes.DCMPG /* 152 */:
                                        case Opcodes.IRETURN /* 172 */:
                                        case Opcodes.LRETURN /* 173 */:
                                        case Opcodes.FRETURN /* 174 */:
                                        case 175:
                                        case Opcodes.ARETURN /* 176 */:
                                        case Opcodes.RETURN /* 177 */:
                                        case Opcodes.ARRAYLENGTH /* 190 */:
                                        case Opcodes.ATHROW /* 191 */:
                                        case Opcodes.MONITORENTER /* 194 */:
                                        case Opcodes.MONITOREXIT /* 195 */:
                                            z3 = z11;
                                            z4 = z2;
                                            i9 = i108;
                                            qVar.e(i8);
                                            i10 = i107 + 1;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z4;
                                            iArr2 = iArr18;
                                            while (iArr2 != null && i11 < iArr2.length && iD <= i92) {
                                                if (iD == i92) {
                                                    int iR3 = r(hVar, iArr2[i11]);
                                                    k(qVar.f(hVar.h, hVar.i, t(iR3, cArr), true), iR3 + 2, true, cArr);
                                                }
                                                i11++;
                                                iD = d(iArr2, i11);
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null && i13 < iArr17.length && iD2 <= i92) {
                                                if (iD2 != i92) {
                                                    int iR4 = r(hVar, iArr17[i13]);
                                                    z8 = z5;
                                                    i14 = i10;
                                                    i15 = i92;
                                                    k(qVar.f(hVar.h, hVar.i, t(iR4, cArr), false), iR4 + 2, true, cArr);
                                                } else {
                                                    z8 = z5;
                                                    i14 = i10;
                                                    i15 = i92;
                                                }
                                                i13++;
                                                iD2 = d(iArr17, i13);
                                                z5 = z8;
                                                i10 = i14;
                                                i92 = i15;
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 16:
                                        case Opcodes.NEWARRAY /* 188 */:
                                            z3 = z11;
                                            z4 = z2;
                                            i9 = i108;
                                            qVar.g(i8, bArr[i107 + 1]);
                                            i10 = i107 + 2;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z4;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                                if (iD == i92) {
                                                }
                                                i11++;
                                                iD = d(iArr2, i11);
                                                break;
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                                if (iD2 != i92) {
                                                }
                                                i13++;
                                                iD2 = d(iArr17, i13);
                                                z5 = z8;
                                                i10 = i14;
                                                i92 = i15;
                                                break;
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                            break;
                                        case 17:
                                            z3 = z11;
                                            z4 = z2;
                                            i9 = i108;
                                            qVar.g(i8, q(i107 + 1));
                                            i10 = i107 + 3;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z4;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 18:
                                            z3 = z11;
                                            z4 = z2;
                                            i9 = i108;
                                            qVar.j(i(bArr[i107 + 1] & 255, cArr));
                                            i10 = i107 + 2;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z4;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 19:
                                        case 20:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            qVar.j(i(u(i107 + 1), cArr));
                                            i10 = i107 + 3;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 21:
                                        case 22:
                                        case 23:
                                        case 24:
                                        case 25:
                                        case 54:
                                        case 55:
                                        case 56:
                                        case 57:
                                        case 58:
                                        case Opcodes.RET /* 169 */:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            qVar.t(i8, bArr[i107 + 1] & 255);
                                            i10 = i107 + 2;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 26:
                                        case 27:
                                        case 28:
                                        case 29:
                                        case 30:
                                        case 31:
                                        case 32:
                                        case 33:
                                        case 34:
                                        case 35:
                                        case 36:
                                        case 37:
                                        case 38:
                                        case 39:
                                        case 40:
                                        case 41:
                                        case 42:
                                        case 43:
                                        case 44:
                                        case 45:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            int i109 = i8 - 26;
                                            qVar.t((i109 >> 2) + 21, 3 & i109);
                                            i10 = i107 + 1;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 59:
                                        case 60:
                                        case 61:
                                        case 62:
                                        case 63:
                                        case 64:
                                        case 65:
                                        case 66:
                                        case 67:
                                        case 68:
                                        case 69:
                                        case 70:
                                        case 71:
                                        case 72:
                                        case 73:
                                        case 74:
                                        case 75:
                                        case 76:
                                        case 77:
                                        case 78:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            int i110 = i8 - 59;
                                            qVar.t((i110 >> 2) + 54, 3 & i110);
                                            i10 = i107 + 1;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case Opcodes.IINC /* 132 */:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            qVar.d(bArr[i107 + 1] & 255, bArr[i107 + 2]);
                                            i10 = i107 + 3;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 153:
                                        case 154:
                                        case 155:
                                        case 156:
                                        case 157:
                                        case 158:
                                        case Opcodes.IF_ICMPEQ /* 159 */:
                                        case Opcodes.IF_ICMPNE /* 160 */:
                                        case Opcodes.IF_ICMPLT /* 161 */:
                                        case Opcodes.IF_ICMPGE /* 162 */:
                                        case Opcodes.IF_ICMPGT /* 163 */:
                                        case Opcodes.IF_ICMPLE /* 164 */:
                                        case Opcodes.IF_ACMPEQ /* 165 */:
                                        case Opcodes.IF_ACMPNE /* 166 */:
                                        case Opcodes.GOTO /* 167 */:
                                        case Opcodes.JSR /* 168 */:
                                        case Opcodes.IFNULL /* 198 */:
                                        case Opcodes.IFNONNULL /* 199 */:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            qVar.h(i8, pVarArr11[q(i107 + 1) + i92]);
                                            i10 = i107 + 3;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case Opcodes.TABLESWITCH /* 170 */:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            int i111 = (4 - (i92 & 3)) + i107;
                                            p pVar3 = pVarArr11[l(i111) + i92];
                                            int iL5 = l(i111 + 4);
                                            int iL6 = l(i111 + 8);
                                            int i112 = i111 + 12;
                                            int i113 = (iL6 - iL5) + 1;
                                            p[] pVarArr13 = new p[i113];
                                            for (int i114 = 0; i114 < i113; i114++) {
                                                pVarArr13[i114] = pVarArr11[l(i112) + i92];
                                                i112 += 4;
                                            }
                                            qVar.q(iL5, iL6, pVar3, pVarArr13);
                                            i10 = i112;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case Opcodes.LOOKUPSWITCH /* 171 */:
                                            z3 = z11;
                                            z6 = z2;
                                            int i115 = (4 - (i92 & 3)) + i107;
                                            p pVar4 = pVarArr11[l(i115) + i92];
                                            int iL7 = l(i115 + 4);
                                            int[] iArr19 = new int[iL7];
                                            p[] pVarArr14 = new p[iL7];
                                            int i116 = i115 + 8;
                                            for (int i117 = 0; i117 < iL7; i117++) {
                                                iArr19[i117] = l(i116);
                                                pVarArr14[i117] = pVarArr11[l(i116 + 4) + i92];
                                                i116 += 8;
                                            }
                                            r rVar3 = (r) qVar;
                                            c cVar = rVar3.l;
                                            rVar3.Z = cVar.f3699b;
                                            cVar.g(Opcodes.LOOKUPSWITCH);
                                            int i118 = i116;
                                            i9 = i108;
                                            cVar.h(null, 0, (4 - (rVar3.l.f3699b % 4)) % 4);
                                            boolean z16 = true;
                                            pVar4.e(rVar3.l, rVar3.Z, true);
                                            rVar3.l.i(iL7);
                                            int i119 = 0;
                                            while (i119 < iL7) {
                                                rVar3.l.i(iArr19[i119]);
                                                pVarArr14[i119].e(rVar3.l, rVar3.Z, z16);
                                                i119++;
                                                iL7 = iL7;
                                                z16 = true;
                                            }
                                            rVar3.B(pVar4, pVarArr14);
                                            i10 = i118;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case Opcodes.GETSTATIC /* 178 */:
                                        case Opcodes.PUTSTATIC /* 179 */:
                                        case 180:
                                        case Opcodes.PUTFIELD /* 181 */:
                                        case Opcodes.INVOKEVIRTUAL /* 182 */:
                                        case Opcodes.INVOKESPECIAL /* 183 */:
                                        case Opcodes.INVOKESTATIC /* 184 */:
                                        case Opcodes.INVOKEINTERFACE /* 185 */:
                                            z3 = z11;
                                            int i120 = this.f3700b[u(i107 + 1)];
                                            int i121 = this.f3700b[u(i120 + 2)];
                                            String strG = g(i120, cArr);
                                            String strT6 = t(i121, cArr);
                                            String strT7 = t(i121 + 2, cArr);
                                            if (i8 < 182) {
                                                qVar.b(i8, strG, strT6, strT7);
                                                z6 = z2;
                                                i12 = i8;
                                            } else {
                                                z6 = z2;
                                                i12 = i8;
                                                qVar.p(i8, strG, strT6, strT7, bArr[i120 + (-1)] == 11);
                                            }
                                            i10 = i12 == 185 ? i107 + 5 : i107 + 3;
                                            i9 = i108;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case Opcodes.INVOKEDYNAMIC /* 186 */:
                                            int i122 = this.f3700b[u(i107 + 1)];
                                            int i123 = this.f3700b[u(i122 + 2)];
                                            String strT8 = t(i123, cArr);
                                            String strT9 = t(i123 + 2, cArr);
                                            int i124 = this.e[u(i122)];
                                            n nVar = (n) i(u(i124), cArr);
                                            int iU19 = u(i124 + 2);
                                            Object[] objArr2 = new Object[iU19];
                                            int i125 = i124 + 4;
                                            z3 = z11;
                                            int i126 = 0;
                                            while (i126 < iU19) {
                                                objArr2[i126] = i(u(i125), cArr);
                                                i125 += 2;
                                                i126++;
                                                iU19 = iU19;
                                            }
                                            r rVar4 = (r) qVar;
                                            rVar4.Z = rVar4.l.f3699b;
                                            v vVar = rVar4.d;
                                            u uVarD = vVar.d(18, strT8, strT9, vVar.a(nVar, objArr2).a);
                                            rVar4.l.e(Opcodes.INVOKEDYNAMIC, uVarD.a);
                                            rVar4.l.j(0);
                                            p pVar5 = rVar4.Q;
                                            if (pVar5 != null) {
                                                int i127 = rVar4.N;
                                                if (i127 == 4 || i127 == 3) {
                                                    pVar5.k.b(Opcodes.INVOKEDYNAMIC, 0, uVarD, rVar4.d);
                                                } else {
                                                    int iA = uVarD.a();
                                                    int i128 = rVar4.R + ((iA & 3) - (iA >> 2)) + 1;
                                                    if (i128 > rVar4.S) {
                                                        rVar4.S = i128;
                                                    }
                                                    rVar4.R = i128;
                                                }
                                            }
                                            i10 = i107 + 5;
                                            z7 = z2;
                                            z5 = z7;
                                            i9 = i108;
                                            iD = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                            break;
                                        case Opcodes.NEW /* 187 */:
                                        case Opcodes.ANEWARRAY /* 189 */:
                                        case Opcodes.CHECKCAST /* 192 */:
                                        case Opcodes.INSTANCEOF /* 193 */:
                                            qVar.s(i8, g(i107 + 1, cArr));
                                            i10 = i107 + 3;
                                            z3 = z11;
                                            z7 = z2;
                                            z5 = z7;
                                            i9 = i108;
                                            iD = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 196:
                                            int i129 = bArr[i107 + 1] & 255;
                                            if (i129 == 132) {
                                                qVar.d(u(i107 + 2), q(i107 + 4));
                                                i10 = i107 + 6;
                                                z3 = z11;
                                                z7 = z2;
                                                z5 = z7;
                                                i9 = i108;
                                                iD = i75;
                                                i11 = i73;
                                                iArr2 = iArr18;
                                                while (iArr2 != null) {
                                                }
                                                i13 = i74;
                                                iD2 = i70;
                                                while (iArr17 != null) {
                                                }
                                                z12 = z5;
                                                i74 = i13;
                                                i70 = iD2;
                                                i73 = i11;
                                                iArr11 = iArr2;
                                                pVarArr2 = pVarArr11;
                                                i71 = i10;
                                                iU3 = i93;
                                                z11 = z3;
                                                i2 = i105;
                                                i72 = i9;
                                                i75 = iD;
                                                iArr12 = iArr17;
                                                iU4 = i106;
                                            } else {
                                                qVar.t(i129, u(i107 + 2));
                                                i10 = i107 + 4;
                                                z3 = z11;
                                                z7 = z2;
                                                z5 = z7;
                                                i9 = i108;
                                                iD = i75;
                                                i11 = i73;
                                                iArr2 = iArr18;
                                                while (iArr2 != null) {
                                                }
                                                i13 = i74;
                                                iD2 = i70;
                                                while (iArr17 != null) {
                                                }
                                                z12 = z5;
                                                i74 = i13;
                                                i70 = iD2;
                                                i73 = i11;
                                                iArr11 = iArr2;
                                                pVarArr2 = pVarArr11;
                                                i71 = i10;
                                                iU3 = i93;
                                                z11 = z3;
                                                i2 = i105;
                                                i72 = i9;
                                                i75 = iD;
                                                iArr12 = iArr17;
                                                iU4 = i106;
                                            }
                                        case Opcodes.MULTIANEWARRAY /* 197 */:
                                            String strG2 = g(i107 + 1, cArr);
                                            int i130 = bArr[i107 + 3] & 255;
                                            r rVar5 = (r) qVar;
                                            rVar5.Z = rVar5.l.f3699b;
                                            u uVarM = rVar5.d.m(7, strG2);
                                            c cVar2 = rVar5.l;
                                            cVar2.e(Opcodes.MULTIANEWARRAY, uVarM.a);
                                            cVar2.g(i130);
                                            p pVar6 = rVar5.Q;
                                            if (pVar6 != null) {
                                                int i131 = rVar5.N;
                                                if (i131 == 4 || i131 == 3) {
                                                    pVar6.k.b(Opcodes.MULTIANEWARRAY, i130, uVarM, rVar5.d);
                                                } else {
                                                    rVar5.R = (1 - i130) + rVar5.R;
                                                }
                                            }
                                            i10 = i107 + 4;
                                            z3 = z11;
                                            z7 = z2;
                                            z5 = z7;
                                            i9 = i108;
                                            iD = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                            break;
                                        case 200:
                                        case 201:
                                            qVar.h(i8 - i69, pVarArr11[l(i107 + 1) + i92]);
                                            i10 = i107 + 5;
                                            z3 = z11;
                                            z7 = z2;
                                            z5 = z7;
                                            i9 = i108;
                                            iD = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 202:
                                        case 203:
                                        case 204:
                                        case 205:
                                        case 206:
                                        case 207:
                                        case 208:
                                        case 209:
                                        case 210:
                                        case 211:
                                        case 212:
                                        case 213:
                                        case 214:
                                        case 215:
                                        case 216:
                                        case 217:
                                        case 218:
                                        case 219:
                                            int i132 = i8 < 218 ? i8 - 49 : i8 - 20;
                                            p pVar7 = pVarArr11[u(i107 + 1) + i92];
                                            if (i132 == 167 || i132 == 168) {
                                                qVar.h(i132 + 33, pVar7);
                                                z7 = z2;
                                            } else {
                                                qVar.h(i132 < 167 ? ((i132 + 1) ^ 1) - 1 : i132 ^ 1, b(i92 + 3, pVarArr11));
                                                qVar.h(200, pVar7);
                                                z7 = true;
                                            }
                                            i10 = i107 + 3;
                                            z3 = z11;
                                            z5 = z7;
                                            i9 = i108;
                                            iD = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                            break;
                                        case 220:
                                            qVar.h(200, pVarArr11[l(i107 + 1) + i92]);
                                            i10 = i107 + 5;
                                            z3 = z11;
                                            i9 = i108;
                                            iD = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            z5 = true;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            pVarArr2 = pVarArr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        default:
                                            throw new AssertionError();
                                    }
                                }
                            }
                            int[] iArr172 = iArr12;
                            int[] iArr182 = iArr11;
                            int i1052 = i2;
                            int i1062 = iU4;
                            int i1072 = i7;
                            int i1082 = i95;
                            if (z15) {
                            }
                            i8 = bArr[i1072] & 255;
                            switch (i8) {
                            }
                        }
                    }
                }
            }
        }
    }

    public Object i(int i, char[] cArr) {
        int[] iArr = this.f3700b;
        int i2 = iArr[i];
        byte b2 = this.a[i2 - 1];
        switch (b2) {
            case 3:
                return Integer.valueOf(l(i2));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(l(i2)));
            case 5:
                return Long.valueOf(m(i2));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(m(i2)));
            case 7:
                return w.h(t(i2, cArr));
            case 8:
                return t(i2, cArr);
            default:
                switch (b2) {
                    case 15:
                        int iF = f(i2);
                        int i3 = this.f3700b[u(i2 + 1)];
                        int i4 = this.f3700b[u(i3 + 2)];
                        return new n(iF, g(i3, cArr), t(i4, cArr), t(i4 + 2, cArr), this.a[i3 - 1] == 11);
                    case 16:
                        String strT = t(i2, cArr);
                        return new w(11, strT, 0, strT.length());
                    case 17:
                        g gVar = this.d[i];
                        if (gVar != null) {
                            return gVar;
                        }
                        int i5 = iArr[i];
                        int i6 = iArr[u(i5 + 2)];
                        String strT2 = t(i6, cArr);
                        String strT3 = t(i6 + 2, cArr);
                        int i7 = this.e[u(i5)];
                        n nVar = (n) i(u(i7), cArr);
                        int iU = u(i7 + 2);
                        Object[] objArr = new Object[iU];
                        int i8 = i7 + 4;
                        for (int i9 = 0; i9 < iU; i9++) {
                            objArr[i9] = i(u(i8), cArr);
                            i8 += 2;
                        }
                        g[] gVarArr = this.d;
                        g gVar2 = new g(strT2, strT3, nVar, objArr);
                        gVarArr[i] = gVar2;
                        return gVar2;
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x0235  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int j(a aVar, int i, String str, char[] cArr) {
        int i2 = 0;
        if (aVar == null) {
            int i3 = this.a[i] & 255;
            return i3 != 64 ? i3 != 91 ? i3 != 101 ? i + 3 : i + 5 : k(null, i + 1, false, cArr) : k(null, i + 3, true, cArr);
        }
        int i4 = i + 1;
        int i5 = this.a[i] & 255;
        if (i5 == 64) {
            String strT = t(i4, cArr);
            aVar.e++;
            if (aVar.f3696b) {
                aVar.c.j(aVar.a.l(str));
            }
            c cVar = aVar.c;
            cVar.e(64, aVar.a.l(strT));
            cVar.j(0);
            return k(new a(aVar.a, true, aVar.c, null), i4 + 2, true, cArr);
        }
        if (i5 == 70) {
            aVar.e(str, i(u(i4), cArr));
        } else if (i5 == 83) {
            aVar.e(str, Short.valueOf((short) l(this.f3700b[u(i4)])));
        } else if (i5 == 99) {
            String strT2 = t(i4, cArr);
            aVar.e(str, w.k(strT2, 0, strT2.length()));
        } else {
            if (i5 == 101) {
                String strT3 = t(i4, cArr);
                String strT4 = t(i4 + 2, cArr);
                aVar.e++;
                if (aVar.f3696b) {
                    aVar.c.j(aVar.a.l(str));
                }
                c cVar2 = aVar.c;
                cVar2.e(101, aVar.a.l(strT3));
                cVar2.j(aVar.a.l(strT4));
                return i4 + 4;
            }
            if (i5 == 115) {
                aVar.e(str, t(i4, cArr));
            } else if (i5 != 73 && i5 != 74) {
                if (i5 == 90) {
                    aVar.e(str, l(this.f3700b[u(i4)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                } else {
                    if (i5 == 91) {
                        int iU = u(i4);
                        int i6 = i4 + 2;
                        if (iU == 0) {
                            return k(aVar.f(str), i6 - 2, false, cArr);
                        }
                        int i7 = this.a[i6] & 255;
                        if (i7 == 70) {
                            float[] fArr = new float[iU];
                            while (i2 < iU) {
                                fArr[i2] = Float.intBitsToFloat(l(this.f3700b[u(i6 + 1)]));
                                i6 += 3;
                                i2++;
                            }
                            aVar.e(str, fArr);
                            return i6;
                        }
                        if (i7 == 83) {
                            short[] sArr = new short[iU];
                            while (i2 < iU) {
                                sArr[i2] = (short) l(this.f3700b[u(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            aVar.e(str, sArr);
                            return i6;
                        }
                        if (i7 == 90) {
                            boolean[] zArr = new boolean[iU];
                            for (int i8 = 0; i8 < iU; i8++) {
                                zArr[i8] = l(this.f3700b[u(i6 + 1)]) != 0;
                                i6 += 3;
                            }
                            aVar.e(str, zArr);
                            return i6;
                        }
                        if (i7 == 73) {
                            int[] iArr = new int[iU];
                            while (i2 < iU) {
                                iArr[i2] = l(this.f3700b[u(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            aVar.e(str, iArr);
                            return i6;
                        }
                        if (i7 == 74) {
                            long[] jArr = new long[iU];
                            while (i2 < iU) {
                                jArr[i2] = m(this.f3700b[u(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            aVar.e(str, jArr);
                            return i6;
                        }
                        switch (i7) {
                            case 66:
                                byte[] bArr = new byte[iU];
                                while (i2 < iU) {
                                    bArr[i2] = (byte) l(this.f3700b[u(i6 + 1)]);
                                    i6 += 3;
                                    i2++;
                                }
                                aVar.e(str, bArr);
                                return i6;
                            case 67:
                                char[] cArr2 = new char[iU];
                                while (i2 < iU) {
                                    cArr2[i2] = (char) l(this.f3700b[u(i6 + 1)]);
                                    i6 += 3;
                                    i2++;
                                }
                                aVar.e(str, cArr2);
                                return i6;
                            case 68:
                                double[] dArr = new double[iU];
                                while (i2 < iU) {
                                    dArr[i2] = Double.longBitsToDouble(m(this.f3700b[u(i6 + 1)]));
                                    i6 += 3;
                                    i2++;
                                }
                                aVar.e(str, dArr);
                                return i6;
                            default:
                                return k(aVar.f(str), i6 - 2, false, cArr);
                        }
                    }
                    switch (i5) {
                        case 66:
                            aVar.e(str, Byte.valueOf((byte) l(this.f3700b[u(i4)])));
                            break;
                        case 67:
                            aVar.e(str, Character.valueOf((char) l(this.f3700b[u(i4)])));
                            break;
                        case 68:
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
        }
        return i4 + 2;
    }

    public final int k(a aVar, int i, boolean z2, char[] cArr) {
        int iU = u(i);
        int iJ = i + 2;
        if (!z2) {
            while (true) {
                int i2 = iU - 1;
                if (iU <= 0) {
                    break;
                }
                iJ = j(aVar, iJ, null, cArr);
                iU = i2;
            }
        } else {
            while (true) {
                int i3 = iU - 1;
                if (iU <= 0) {
                    break;
                }
                iJ = j(aVar, iJ + 2, t(iJ, cArr), cArr);
                iU = i3;
            }
        }
        if (aVar != null) {
            aVar.g();
        }
        return iJ;
    }

    public int l(int i) {
        byte[] bArr = this.a;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public long m(int i) {
        return (l(i) << 32) | (l(i + 4) & 4294967295L);
    }

    public String n(int i, char[] cArr) {
        return t(this.f3700b[u(i)], cArr);
    }

    public String o(int i, char[] cArr) {
        return t(this.f3700b[u(i)], cArr);
    }

    public final void p(q qVar, h hVar, int i, boolean z2) {
        a aVar;
        int iK = i + 1;
        int i2 = this.a[i] & 255;
        r rVar = (r) qVar;
        if (z2) {
            rVar.D = i2;
        } else {
            rVar.F = i2;
        }
        char[] cArr = hVar.c;
        for (int i3 = 0; i3 < i2; i3++) {
            int iU = u(iK);
            iK += 2;
            while (true) {
                int i4 = iU - 1;
                if (iU > 0) {
                    String strT = t(iK, cArr);
                    int i5 = iK + 2;
                    c cVar = new c();
                    cVar.j(rVar.d.l(strT));
                    cVar.j(0);
                    if (z2) {
                        if (rVar.E == null) {
                            rVar.E = new a[w.a(rVar.i).length];
                        }
                        a[] aVarArr = rVar.E;
                        aVar = new a(rVar.d, true, cVar, aVarArr[i3]);
                        aVarArr[i3] = aVar;
                    } else {
                        if (rVar.G == null) {
                            rVar.G = new a[w.a(rVar.i).length];
                        }
                        a[] aVarArr2 = rVar.G;
                        aVar = new a(rVar.d, true, cVar, aVarArr2[i3]);
                        aVarArr2[i3] = aVar;
                    }
                    iK = k(aVar, i5, true, cArr);
                    iU = i4;
                }
            }
        }
    }

    public short q(int i) {
        byte[] bArr = this.a;
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int r(h hVar, int i) {
        int i2;
        int i3;
        int iL = l(i);
        int i4 = iL >>> 24;
        if (i4 == 0 || i4 == 1) {
            i2 = iL & (-65536);
            i3 = i + 2;
        } else {
            switch (i4) {
                case 16:
                case 17:
                case 18:
                case 23:
                    i2 = iL & InputDeviceCompat.SOURCE_ANY;
                    i3 = i + 3;
                    break;
                case 19:
                case 20:
                case 21:
                    i2 = iL & ViewCompat.MEASURED_STATE_MASK;
                    i3 = i + 1;
                    break;
                case 22:
                    break;
                default:
                    switch (i4) {
                        case 64:
                        case 65:
                            i2 = iL & ViewCompat.MEASURED_STATE_MASK;
                            int iU = u(i + 1);
                            i3 = i + 3;
                            hVar.j = new p[iU];
                            hVar.k = new p[iU];
                            hVar.l = new int[iU];
                            for (int i5 = 0; i5 < iU; i5++) {
                                int iU2 = u(i3);
                                int iU3 = u(i3 + 2);
                                int iU4 = u(i3 + 4);
                                i3 += 6;
                                hVar.j[i5] = b(iU2, hVar.g);
                                hVar.k[i5] = b(iU2 + iU3, hVar.g);
                                hVar.l[i5] = iU4;
                            }
                            break;
                        case 66:
                            break;
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                            i2 = iL & ViewCompat.MEASURED_STATE_MASK;
                            i3 = i + 3;
                            break;
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            i2 = iL & (-16776961);
                            i3 = i + 4;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
            }
        }
        hVar.h = i2;
        int iF = f(i3);
        hVar.i = iF == 0 ? null : new x(this.a, i3);
        return (iF * 2) + i3 + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int[] s(q qVar, h hVar, int i, boolean z2) {
        int i2;
        a aVar;
        char[] cArr = hVar.c;
        int iU = u(i);
        int[] iArr = new int[iU];
        int iK = i + 2;
        for (int i3 = 0; i3 < iU; i3++) {
            iArr[i3] = iK;
            int iL = l(iK);
            int i4 = iL >>> 24;
            if (i4 != 23) {
                switch (i4) {
                    default:
                        switch (i4) {
                            case 64:
                            case 65:
                                int iU2 = u(iK + 1);
                                i2 = iK + 3;
                                while (true) {
                                    int i5 = iU2 - 1;
                                    if (iU2 <= 0) {
                                        break;
                                    } else {
                                        int iU3 = u(i2);
                                        int iU4 = u(i2 + 2);
                                        i2 += 6;
                                        b(iU3, hVar.g);
                                        b(iU3 + iU4, hVar.g);
                                        iU2 = i5;
                                    }
                                }
                            case 66:
                            case 67:
                            case 68:
                            case 69:
                            case 70:
                                break;
                            case 71:
                            case 72:
                            case 73:
                            case 74:
                            case 75:
                                i2 = iK + 4;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                    case 16:
                    case 17:
                    case 18:
                        i2 = iK + 3;
                        break;
                }
            }
            int iF = f(i2);
            if (i4 == 66) {
                x xVar = iF != 0 ? new x(this.a, i2) : null;
                int i6 = (iF * 2) + 1 + i2;
                String strT = t(i6, cArr);
                int i7 = i6 + 2;
                int i8 = iL & InputDeviceCompat.SOURCE_ANY;
                r rVar = (r) qVar;
                Objects.requireNonNull(rVar);
                c cVar = new c();
                b.i.a.f.e.o.f.W0(i8, cVar);
                x.a(xVar, cVar);
                cVar.j(rVar.d.l(strT));
                cVar.j(0);
                if (z2) {
                    aVar = new a(rVar.d, true, cVar, rVar.w);
                    rVar.w = aVar;
                } else {
                    aVar = new a(rVar.d, true, cVar, rVar.f3719x);
                    rVar.f3719x = aVar;
                }
                iK = k(aVar, i7, true, cArr);
            } else {
                iK = k(null, (iF * 2) + 3 + i2, true, cArr);
            }
        }
        return iArr;
    }

    public String t(int i, char[] cArr) {
        int iU = u(i);
        if (i == 0 || iU == 0) {
            return null;
        }
        return w(iU, cArr);
    }

    public int u(int i) {
        byte[] bArr = this.a;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public final String v(int i, int i2, char[] cArr) {
        int i3;
        int i4 = i2 + i;
        byte[] bArr = this.a;
        int i5 = 0;
        while (i < i4) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            if ((b2 & 128) == 0) {
                i3 = i5 + 1;
                cArr[i5] = (char) (b2 & 127);
            } else if ((b2 & 224) == 192) {
                cArr[i5] = (char) (((b2 & 31) << 6) + (bArr[i6] & 63));
                i5++;
                i = i6 + 1;
            } else {
                i3 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = ((b2 & 15) << 12) + ((bArr[i6] & 63) << 6);
                i6 = i7 + 1;
                cArr[i5] = (char) (i8 + (bArr[i7] & 63));
            }
            i = i6;
            i5 = i3;
        }
        return new String(cArr, 0, i5);
    }

    public final String w(int i, char[] cArr) {
        String[] strArr = this.c;
        String str = strArr[i];
        if (str != null) {
            return str;
        }
        int i2 = this.f3700b[i];
        String strV = v(i2 + 2, u(i2), cArr);
        strArr[i] = strV;
        return strV;
    }

    public final int x(int i, Object[] objArr, int i2, char[] cArr, p[] pVarArr) {
        int i3 = i + 1;
        switch (this.a[i] & 255) {
            case 0:
                objArr[i2] = t.a;
                return i3;
            case 1:
                objArr[i2] = t.f3723b;
                return i3;
            case 2:
                objArr[i2] = t.c;
                return i3;
            case 3:
                objArr[i2] = t.d;
                return i3;
            case 4:
                objArr[i2] = t.e;
                return i3;
            case 5:
                objArr[i2] = t.f;
                return i3;
            case 6:
                objArr[i2] = t.g;
                return i3;
            case 7:
                objArr[i2] = g(i3, cArr);
                break;
            case 8:
                objArr[i2] = b(u(i3), pVarArr);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return i3 + 2;
    }
}
