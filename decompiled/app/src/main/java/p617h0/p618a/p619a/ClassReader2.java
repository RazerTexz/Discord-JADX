package p617h0.p618a.p619a;

import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: h0.a.a.d, reason: use source file name */
/* JADX INFO: compiled from: ClassReader.java */
/* JADX INFO: loaded from: classes3.dex */
public class ClassReader2 {

    /* JADX INFO: renamed from: a */
    public final byte[] f26155a;

    /* JADX INFO: renamed from: b */
    public final int[] f26156b;

    /* JADX INFO: renamed from: c */
    public final String[] f26157c;

    /* JADX INFO: renamed from: d */
    public final ConstantDynamic2[] f26158d;

    /* JADX INFO: renamed from: e */
    public final int[] f26159e;

    /* JADX INFO: renamed from: f */
    public final int f26160f;

    /* JADX INFO: renamed from: g */
    public final int f26161g;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public ClassReader2(byte[] bArr, int i, boolean z2) {
        int i2;
        this.f26155a = bArr;
        if (z2) {
            int i3 = i + 6;
            if (m10555q(i3) > 56) {
                StringBuilder sbM833U = outline.m833U("Unsupported class file major version ");
                sbM833U.append((int) m10555q(i3));
                throw new IllegalArgumentException(sbM833U.toString());
            }
        }
        int iM10559u = m10559u(i + 8);
        this.f26156b = new int[iM10559u];
        this.f26157c = new String[iM10559u];
        int i4 = i + 10;
        int i5 = 1;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            int iM10559u2 = 4;
            if (i5 >= iM10559u) {
                this.f26160f = i6;
                this.f26161g = i4;
                int[] iArr = null;
                this.f26158d = z3 ? new ConstantDynamic2[iM10559u] : null;
                if (z3 | z4) {
                    char[] cArr = new char[i6];
                    int iM10541c = m10541c();
                    int iM10559u3 = m10559u(iM10541c - 2);
                    while (true) {
                        if (iM10559u3 > 0) {
                            String strM10558t = m10558t(iM10541c, cArr);
                            int iM10550l = m10550l(iM10541c + 2);
                            int i7 = iM10541c + 6;
                            if ("BootstrapMethods".equals(strM10558t)) {
                                int iM10559u4 = m10559u(i7);
                                int[] iArr2 = new int[iM10559u4];
                                int iM10559u5 = i7 + 2;
                                for (int i8 = 0; i8 < iM10559u4; i8++) {
                                    iArr2[i8] = iM10559u5;
                                    iM10559u5 += (m10559u(iM10559u5 + 2) * 2) + 4;
                                }
                                iArr = iArr2;
                            } else {
                                iM10541c = i7 + iM10550l;
                                iM10559u3--;
                            }
                        }
                    }
                }
                this.f26159e = iArr;
                return;
            }
            int i9 = i5 + 1;
            int i10 = i4 + 1;
            this.f26156b[i5] = i10;
            switch (bArr[i4]) {
                case 1:
                    iM10559u2 = m10559u(i10) + 3;
                    if (iM10559u2 > i6) {
                        i6 = iM10559u2;
                    }
                    i2 = iM10559u2;
                    i4 += i2;
                    i5 = i9;
                    break;
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
                    break;
                case 5:
                case 6:
                    iM10559u2 = 9;
                    i9++;
                    i2 = iM10559u2;
                    i4 += i2;
                    i5 = i9;
                    break;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    i2 = 3;
                    i4 += i2;
                    i5 = i9;
                    break;
                case 15:
                    i2 = iM10559u2;
                    i4 += i2;
                    i5 = i9;
                    break;
                case 17:
                    z3 = true;
                    i2 = 5;
                    i4 += i2;
                    i5 = i9;
                    break;
                case 18:
                    z4 = true;
                    i2 = 5;
                    i4 += i2;
                    i5 = i9;
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m10539a(int i, Label2[] label2Arr) {
        if (label2Arr[i] == null) {
            if (label2Arr[i] == null) {
                label2Arr[i] = new Label2();
            }
            Label2 label2 = label2Arr[i];
            label2.f26249b = (short) (label2.f26249b | 1);
        }
    }

    /* JADX INFO: renamed from: b */
    public final Label2 m10540b(int i, Label2[] label2Arr) {
        if (label2Arr[i] == null) {
            label2Arr[i] = new Label2();
        }
        Label2 label2 = label2Arr[i];
        label2.f26249b = (short) (label2.f26249b & (-2));
        return label2;
    }

    /* JADX INFO: renamed from: c */
    public final int m10541c() {
        int i = this.f26161g;
        int iM10559u = (m10559u(i + 6) * 2) + i + 8;
        int iM10559u2 = m10559u(iM10559u);
        int iM10550l = iM10559u + 2;
        while (true) {
            int i2 = iM10559u2 - 1;
            if (iM10559u2 <= 0) {
                break;
            }
            int iM10559u3 = m10559u(iM10550l + 6);
            iM10550l += 8;
            while (true) {
                int i3 = iM10559u3 - 1;
                if (iM10559u3 > 0) {
                    iM10550l += m10550l(iM10550l + 2) + 6;
                    iM10559u3 = i3;
                }
            }
            iM10559u2 = i2;
        }
        int iM10559u4 = m10559u(iM10550l);
        int iM10550l2 = iM10550l + 2;
        while (true) {
            int i4 = iM10559u4 - 1;
            if (iM10559u4 <= 0) {
                return iM10550l2 + 2;
            }
            int iM10559u5 = m10559u(iM10550l2 + 6);
            iM10550l2 += 8;
            while (true) {
                int i5 = iM10559u5 - 1;
                if (iM10559u5 > 0) {
                    iM10550l2 += m10550l(iM10550l2 + 2) + 6;
                    iM10559u5 = i5;
                }
            }
            iM10559u4 = i4;
        }
    }

    /* JADX INFO: renamed from: d */
    public final int m10542d(int[] iArr, int i) {
        if (iArr == null || i >= iArr.length || m10544f(iArr[i]) < 67) {
            return -1;
        }
        return m10559u(iArr[i] + 1);
    }

    /* JADX INFO: renamed from: e */
    public final Attribute2 m10543e(Attribute2[] attribute2Arr, String str, int i, int i2, char[] cArr, int i3, Label2[] label2Arr) {
        for (Attribute2 attribute2 : attribute2Arr) {
            if (attribute2.f26148a.equals(str)) {
                Attribute2 attribute22 = new Attribute2(attribute2.f26148a);
                byte[] bArr = new byte[i2];
                attribute22.f26149b = bArr;
                System.arraycopy(this.f26155a, i, bArr, 0, i2);
                return attribute22;
            }
        }
        Attribute2 attribute23 = new Attribute2(str);
        byte[] bArr2 = new byte[i2];
        attribute23.f26149b = bArr2;
        System.arraycopy(this.f26155a, i, bArr2, 0, i2);
        return attribute23;
    }

    /* JADX INFO: renamed from: f */
    public int m10544f(int i) {
        return this.f26155a[i] & 255;
    }

    /* JADX INFO: renamed from: g */
    public String m10545g(int i, char[] cArr) {
        return m10558t(this.f26156b[m10559u(i)], cArr);
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
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m10546h(MethodVisitor2 methodVisitor2, Context3 context3, int i) {
        Label2[] label2Arr;
        int i2;
        Label2[] label2Arr2;
        int i3;
        Attribute2 attribute2;
        int i4;
        int i5;
        Attribute2 attribute22;
        int[] iArr;
        String strM10558t;
        int i6;
        int i7;
        boolean z2;
        int i8;
        boolean z3;
        boolean z4;
        int i9;
        int i10;
        int iM10542d;
        int i11;
        boolean z5;
        int[] iArr2;
        boolean z6;
        int i12;
        boolean z7;
        int i13;
        int iM10542d2;
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
        Label2[] label2Arr3;
        int i22;
        int iM10559u;
        int iM10562x;
        short s2;
        Label2[] label2Arr4;
        int i23;
        int iM10559u2;
        int i24;
        int i25;
        int[] iArr5;
        Label2[] label2Arr5;
        int i26;
        int i27;
        Label2[] label2Arr6;
        int i28;
        int i29;
        int[] iArrM10557s;
        int i30;
        int[] iArr6;
        Label2[] label2Arr7;
        int i31;
        int i32;
        int i33;
        int i34;
        byte[] bArr = this.f26155a;
        char[] cArr = context3.f26196c;
        int iM10559u3 = m10559u(i);
        int iM10559u4 = m10559u(i + 2);
        int iM10550l = m10550l(i + 4);
        int i35 = i + 8;
        int i36 = i35 + iM10550l;
        Label2[] label2Arr8 = new Label2[iM10550l + 1];
        context3.f26200g = label2Arr8;
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
                    break;
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
                    break;
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
                    break;
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
                    m10540b(m10555q(i37 + 1) + i38, label2Arr8);
                    i37 += 3;
                    break;
                case Opcodes.TABLESWITCH /* 170 */:
                    int i39 = (4 - (i38 & 3)) + i37;
                    m10540b(m10550l(i39) + i38, label2Arr8);
                    int iM10550l2 = (m10550l(i39 + 8) - m10550l(i39 + 4)) + 1;
                    i34 = i39 + 12;
                    while (true) {
                        int i40 = iM10550l2 - 1;
                        if (iM10550l2 <= 0) {
                            i37 = i34;
                        } else {
                            m10540b(m10550l(i34) + i38, label2Arr8);
                            i34 += 4;
                            iM10550l2 = i40;
                        }
                        break;
                    }
                    break;
                case Opcodes.LOOKUPSWITCH /* 171 */:
                    int i41 = (4 - (i38 & 3)) + i37;
                    m10540b(m10550l(i41) + i38, label2Arr8);
                    int iM10550l3 = m10550l(i41 + 4);
                    i34 = i41 + 8;
                    while (true) {
                        int i42 = iM10550l3 - 1;
                        if (iM10550l3 <= 0) {
                            i37 = i34;
                        } else {
                            m10540b(m10550l(i34 + 4) + i38, label2Arr8);
                            i34 += 8;
                            iM10550l3 = i42;
                        }
                        break;
                    }
                    break;
                case Opcodes.INVOKEINTERFACE /* 185 */:
                case Opcodes.INVOKEDYNAMIC /* 186 */:
                    i37 += 5;
                    break;
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
                                    break;
                            }
                        }
                        i37 += 4;
                    } else {
                        i37 += 6;
                    }
                    break;
                case Opcodes.MULTIANEWARRAY /* 197 */:
                    i37 += 4;
                    break;
                case 200:
                case 201:
                case 220:
                    m10540b(m10550l(i37 + 1) + i38, label2Arr8);
                    i37 += 5;
                    break;
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
                    m10540b(m10559u(i37 + 1) + i38, label2Arr8);
                    i37 += 3;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int iM10559u5 = m10559u(i37);
        int i44 = i37 + 2;
        while (true) {
            int i45 = iM10559u5 - 1;
            if (iM10559u5 > 0) {
                Label2 label2M10540b = m10540b(m10559u(i44), label2Arr8);
                Label2 label2M10540b2 = m10540b(m10559u(i44 + 2), label2Arr8);
                Label2 label2M10540b3 = m10540b(m10559u(i44 + 4), label2Arr8);
                String strM10558t2 = m10558t(this.f26156b[m10559u(i44 + 6)], cArr);
                i44 += 8;
                MethodWriter2 methodWriter2 = (MethodWriter2) methodVisitor2;
                if (strM10558t2 != null) {
                    i32 = i36;
                    i33 = methodWriter2.f26293d.m10638m(7, strM10558t2).f26340a;
                } else {
                    i32 = i36;
                    i33 = 0;
                }
                Handler5 handler5 = new Handler5(label2M10540b, label2M10540b2, label2M10540b3, i33, strM10558t2);
                if (methodWriter2.f26302m == null) {
                    methodWriter2.f26302m = handler5;
                } else {
                    methodWriter2.f26303n.f26247f = handler5;
                }
                methodWriter2.f26303n = handler5;
                iM10559u5 = i45;
                i36 = i32;
            } else {
                int i46 = i36;
                int iM10559u6 = m10559u(i44);
                int i47 = i44 + 2;
                int[] iArr7 = null;
                boolean z10 = true;
                int i48 = 0;
                Attribute2 attribute23 = null;
                int i49 = 0;
                int[] iArrM10557s2 = null;
                int i50 = 0;
                int i51 = 0;
                while (true) {
                    int i52 = iM10559u6 - 1;
                    if (iM10559u6 > 0) {
                        String strM10558t3 = m10558t(i47, cArr);
                        int iM10550l4 = m10550l(i47 + 2);
                        int i53 = i47 + 6;
                        if ("LocalVariableTable".equals(strM10558t3)) {
                            if ((context3.f26195b & 2) == 0) {
                                int iM10559u7 = m10559u(i53);
                                int i54 = i53 + 2;
                                while (true) {
                                    int i55 = iM10559u7 - 1;
                                    if (iM10559u7 > 0) {
                                        int iM10559u8 = m10559u(i54);
                                        m10539a(iM10559u8, label2Arr8);
                                        m10539a(m10559u(i54 + 2) + iM10559u8, label2Arr8);
                                        i54 += 10;
                                        iM10559u7 = i55;
                                    } else {
                                        i50 = i53;
                                        iArrM10557s = iArr7;
                                        label2Arr5 = label2Arr8;
                                        i26 = iM10550l;
                                        iArr7 = iArrM10557s;
                                        i27 = i53;
                                        i28 = i46;
                                        label2Arr6 = label2Arr5;
                                        i29 = i26;
                                    }
                                }
                            }
                            iArr5 = iArr7;
                            label2Arr5 = label2Arr8;
                            i26 = iM10550l;
                            iArrM10557s = iArr5;
                            iArr7 = iArrM10557s;
                            i27 = i53;
                            i28 = i46;
                            label2Arr6 = label2Arr5;
                            i29 = i26;
                        } else if ("LocalVariableTypeTable".equals(strM10558t3)) {
                            i51 = i53;
                            iArrM10557s = iArr7;
                            label2Arr5 = label2Arr8;
                            i26 = iM10550l;
                            iArr7 = iArrM10557s;
                            i27 = i53;
                            i28 = i46;
                            label2Arr6 = label2Arr5;
                            i29 = i26;
                        } else if ("LineNumberTable".equals(strM10558t3)) {
                            if ((context3.f26195b & 2) == 0) {
                                int iM10559u9 = m10559u(i53);
                                int i56 = i53 + 2;
                                while (true) {
                                    int i57 = iM10559u9 - 1;
                                    if (iM10559u9 > 0) {
                                        int iM10559u10 = m10559u(i56);
                                        int iM10559u11 = m10559u(i56 + 2);
                                        int i58 = i56 + 4;
                                        m10539a(iM10559u10, label2Arr8);
                                        Label2 label2 = label2Arr8[iM10559u10];
                                        if (label2.f26250c == 0) {
                                            label2.f26250c = (short) iM10559u11;
                                            i30 = i58;
                                            iArr6 = iArr7;
                                            label2Arr7 = label2Arr8;
                                            i31 = iM10550l;
                                        } else {
                                            if (label2.f26251d == null) {
                                                i30 = i58;
                                                label2.f26251d = new int[4];
                                            } else {
                                                i30 = i58;
                                            }
                                            int[] iArr8 = label2.f26251d;
                                            iArr6 = iArr7;
                                            int i59 = iArr8[0] + 1;
                                            iArr8[0] = i59;
                                            if (i59 >= iArr8.length) {
                                                int[] iArr9 = new int[iArr8.length + 4];
                                                label2Arr7 = label2Arr8;
                                                i31 = iM10550l;
                                                System.arraycopy(iArr8, 0, iArr9, 0, iArr8.length);
                                                label2.f26251d = iArr9;
                                            } else {
                                                label2Arr7 = label2Arr8;
                                                i31 = iM10550l;
                                            }
                                            label2.f26251d[i59] = iM10559u11;
                                        }
                                        iM10559u9 = i57;
                                        i56 = i30;
                                        iArr7 = iArr6;
                                        label2Arr8 = label2Arr7;
                                        iM10550l = i31;
                                    }
                                }
                            }
                            iArr5 = iArr7;
                            label2Arr5 = label2Arr8;
                            i26 = iM10550l;
                            iArrM10557s = iArr5;
                            iArr7 = iArrM10557s;
                            i27 = i53;
                            i28 = i46;
                            label2Arr6 = label2Arr5;
                            i29 = i26;
                        } else {
                            iArr5 = iArr7;
                            label2Arr5 = label2Arr8;
                            i26 = iM10550l;
                            if ("RuntimeVisibleTypeAnnotations".equals(strM10558t3)) {
                                iArrM10557s = m10557s(methodVisitor2, context3, i53, true);
                                iArr7 = iArrM10557s;
                                i27 = i53;
                                i28 = i46;
                                label2Arr6 = label2Arr5;
                                i29 = i26;
                            } else if ("RuntimeInvisibleTypeAnnotations".equals(strM10558t3)) {
                                iArrM10557s2 = m10557s(methodVisitor2, context3, i53, false);
                                iArrM10557s = iArr5;
                                iArr7 = iArrM10557s;
                                i27 = i53;
                                i28 = i46;
                                label2Arr6 = label2Arr5;
                                i29 = i26;
                            } else {
                                if ("StackMapTable".equals(strM10558t3)) {
                                    if ((context3.f26195b & 4) == 0) {
                                        i48 = i53 + 2;
                                        i49 = i53 + iM10550l4;
                                    }
                                } else if (!"StackMap".equals(strM10558t3)) {
                                    i27 = i53;
                                    label2Arr6 = label2Arr5;
                                    i28 = i46;
                                    i29 = i26;
                                    Attribute2 attribute2M10543e = m10543e(context3.f26194a, strM10558t3, i53, iM10550l4, cArr, i, label2Arr6);
                                    attribute2M10543e.f26150c = attribute23;
                                    attribute23 = attribute2M10543e;
                                    iArr7 = iArr5;
                                } else if ((context3.f26195b & 4) == 0) {
                                    i48 = i53 + 2;
                                    i49 = i53 + iM10550l4;
                                    i27 = i53;
                                    i28 = i46;
                                    iArr7 = iArr5;
                                    label2Arr6 = label2Arr5;
                                    i29 = i26;
                                    z10 = false;
                                }
                                iArrM10557s = iArr5;
                                iArr7 = iArrM10557s;
                                i27 = i53;
                                i28 = i46;
                                label2Arr6 = label2Arr5;
                                i29 = i26;
                            }
                        }
                        i47 = i27 + iM10550l4;
                        label2Arr8 = label2Arr6;
                        iM10559u6 = i52;
                        i46 = i28;
                        iM10550l = i29;
                    } else {
                        int[] iArr10 = iArr7;
                        Label2[] label2Arr9 = label2Arr8;
                        int i60 = iM10550l;
                        int i61 = i46;
                        Attribute2 attribute24 = attribute23;
                        boolean z11 = (context3.f26195b & 8) != 0;
                        if (i48 != 0) {
                            context3.f26206m = -1;
                            context3.f26207n = 0;
                            context3.f26208o = 0;
                            context3.f26209p = 0;
                            Object[] objArr = new Object[iM10559u4];
                            context3.f26210q = objArr;
                            context3.f26211r = 0;
                            context3.f26212s = new Object[iM10559u3];
                            if (z11) {
                                String str = context3.f26199f;
                                if ((context3.f26197d & 8) == 0) {
                                    if ("<init>".equals(context3.f26198e)) {
                                        objArr[0] = Opcodes2.f26339g;
                                    } else {
                                        objArr[0] = m10545g(this.f26161g + 2, context3.f26196c);
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
                                        objArr[i62] = Opcodes2.f26335c;
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
                                        objArr[i62] = Opcodes2.f26334b;
                                    } else if (cCharAt == 'J') {
                                        i25 = i62 + 1;
                                        objArr[i62] = Opcodes2.f26337e;
                                    } else if (cCharAt != 'Z') {
                                        if (cCharAt != '[') {
                                            switch (cCharAt) {
                                                case 'D':
                                                    i25 = i62 + 1;
                                                    objArr[i62] = Opcodes2.f26336d;
                                                    break;
                                            }
                                            context3.f26208o = i62;
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
                                    if (bArr[i67] != 8 || (iM10559u2 = m10559u(i67 + 1)) < 0) {
                                        label2Arr4 = label2Arr9;
                                        i23 = i60;
                                    } else {
                                        i23 = i60;
                                        if (iM10559u2 < i23) {
                                            if ((bArr[i35 + iM10559u2] & 255) == 187) {
                                                label2Arr4 = label2Arr9;
                                                m10540b(iM10559u2, label2Arr4);
                                            } else {
                                                label2Arr4 = label2Arr9;
                                            }
                                            i67++;
                                            label2Arr9 = label2Arr4;
                                            i60 = i23;
                                            i49 = i2;
                                        } else {
                                            label2Arr4 = label2Arr9;
                                        }
                                    }
                                    i67++;
                                    label2Arr9 = label2Arr4;
                                    i60 = i23;
                                    i49 = i2;
                                } else {
                                    label2Arr = label2Arr9;
                                }
                            }
                        } else {
                            label2Arr = label2Arr9;
                            i2 = i49;
                        }
                        int i68 = i60;
                        if (!z11 || (context3.f26195b & 256) == 0) {
                            label2Arr2 = label2Arr;
                            i3 = i68;
                            attribute2 = attribute24;
                            i4 = 0;
                        } else {
                            label2Arr2 = label2Arr;
                            attribute2 = attribute24;
                            i4 = 0;
                            i3 = i68;
                            methodVisitor2.mo10595c(-1, iM10559u4, null, 0, null);
                        }
                        int[] iArr11 = iArr10;
                        int iM10542d3 = m10542d(iArr11, i4);
                        int[] iArr12 = iArrM10557s2;
                        int iM10542d4 = m10542d(iArr12, i4);
                        int i69 = (context3.f26195b & 256) == 0 ? 33 : 0;
                        int i70 = iM10542d4;
                        int i71 = i35;
                        int i72 = i48;
                        int i73 = 0;
                        int i74 = 0;
                        int i75 = iM10542d3;
                        boolean z12 = false;
                        while (true) {
                            int i76 = i61;
                            if (i71 >= i76) {
                                int[] iArr13 = iArr11;
                                int i77 = iM10559u3;
                                int i78 = iM10559u4;
                                Label2[] label2Arr10 = label2Arr2;
                                int[] iArr14 = iArr12;
                                if (label2Arr10[i3] != null) {
                                    methodVisitor2.mo10601i(label2Arr10[i3]);
                                }
                                int i79 = i50;
                                if (i79 != 0 && (context3.f26195b & 2) == 0) {
                                    int i80 = i51;
                                    if (i80 != 0) {
                                        int iM10559u12 = m10559u(i80) * 3;
                                        int[] iArr15 = new int[iM10559u12];
                                        int i81 = i80 + 2;
                                        while (iM10559u12 > 0) {
                                            int i82 = iM10559u12 - 1;
                                            iArr15[i82] = i81 + 6;
                                            int i83 = i82 - 1;
                                            iArr15[i83] = m10559u(i81 + 8);
                                            iM10559u12 = i83 - 1;
                                            iArr15[iM10559u12] = m10559u(i81);
                                            i81 += 10;
                                        }
                                        iArr = iArr15;
                                    } else {
                                        iArr = null;
                                    }
                                    int iM10559u13 = m10559u(i79);
                                    int i84 = i79 + 2;
                                    while (true) {
                                        int i85 = iM10559u13 - 1;
                                        if (iM10559u13 > 0) {
                                            int iM10559u14 = m10559u(i84);
                                            int iM10559u15 = m10559u(i84 + 2);
                                            String strM10558t4 = m10558t(i84 + 4, cArr);
                                            String strM10558t5 = m10558t(i84 + 6, cArr);
                                            int iM10559u16 = m10559u(i84 + 8);
                                            int i86 = i84 + 10;
                                            if (iArr != null) {
                                                for (int i87 = 0; i87 < iArr.length; i87 += 3) {
                                                    if (iArr[i87] == iM10559u14 && iArr[i87 + 1] == iM10559u16) {
                                                        strM10558t = m10558t(iArr[i87 + 2], cArr);
                                                    }
                                                }
                                                strM10558t = null;
                                            } else {
                                                strM10558t = null;
                                            }
                                            methodVisitor2.mo10604l(strM10558t4, strM10558t5, strM10558t, label2Arr10[iM10559u14], label2Arr10[iM10559u14 + iM10559u15], iM10559u16);
                                            iM10559u13 = i85;
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
                                        int iM10544f = m10544f(i90);
                                        if (iM10544f == 64 || iM10544f == i88) {
                                            int iM10556r = m10556r(context3, i90);
                                            i5 = i89;
                                            attribute22 = attribute2;
                                            m10549k(methodVisitor2.mo10605m(context3.f26201h, context3.f26202i, context3.f26203j, context3.f26204k, context3.f26205l, m10558t(iM10556r, cArr), true), iM10556r + 2, true, cArr);
                                        } else {
                                            i5 = i89;
                                            attribute22 = attribute2;
                                        }
                                        i89 = i5 + 1;
                                        attribute2 = attribute22;
                                        i88 = 65;
                                    }
                                }
                                Attribute2 attribute25 = attribute2;
                                if (iArr14 != null) {
                                    for (int i91 : iArr14) {
                                        int iM10544f2 = m10544f(i91);
                                        if (iM10544f2 == 64 || iM10544f2 == 65) {
                                            int iM10556r2 = m10556r(context3, i91);
                                            m10549k(methodVisitor2.mo10605m(context3.f26201h, context3.f26202i, context3.f26203j, context3.f26204k, context3.f26205l, m10558t(iM10556r2, cArr), false), iM10556r2 + 2, true, cArr);
                                        }
                                    }
                                }
                                Attribute2 attribute26 = attribute25;
                                while (attribute26 != null) {
                                    Attribute2 attribute27 = attribute26.f26150c;
                                    attribute26.f26150c = null;
                                    MethodWriter2 methodWriter22 = (MethodWriter2) methodVisitor2;
                                    attribute26.f26150c = methodWriter22.f26277M;
                                    methodWriter22.f26277M = attribute26;
                                    attribute26 = attribute27;
                                }
                                methodVisitor2.mo10606n(i77, i78);
                                return;
                            }
                            i61 = i76;
                            int i92 = i71 - i35;
                            int i93 = iM10559u3;
                            Label2[] label2Arr11 = label2Arr2;
                            Label2 label22 = label2Arr11[i92];
                            boolean z13 = z12;
                            if (label22 == null) {
                                i6 = i72;
                                i7 = i71;
                            } else {
                                boolean z14 = (context3.f26195b & 2) == 0;
                                methodVisitor2.mo10601i(label22);
                                if (z14 && (s2 = label22.f26250c) != 0) {
                                    methodVisitor2.mo10603k(s2 & 65535, label22);
                                    if (label22.f26251d != null) {
                                        i6 = i72;
                                        int i94 = 1;
                                        while (true) {
                                            int[] iArr16 = label22.f26251d;
                                            i7 = i71;
                                            if (i94 <= iArr16[0]) {
                                                methodVisitor2.mo10603k(iArr16[i94], label22);
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
                                int i96 = context3.f26206m;
                                if (i96 == i92 || i96 == -1) {
                                    if (i96 != -1) {
                                        if (!z10 || z11) {
                                            iArr3 = iArr12;
                                            iArr4 = iArr11;
                                            i16 = iM10559u4;
                                            i17 = i7;
                                            i18 = i95;
                                            methodVisitor2.mo10595c(-1, context3.f26208o, context3.f26210q, context3.f26211r, context3.f26212s);
                                        } else {
                                            i16 = iM10559u4;
                                            i18 = i95;
                                            i17 = i7;
                                            iArr3 = iArr12;
                                            iArr4 = iArr11;
                                            methodVisitor2.mo10595c(context3.f26207n, context3.f26209p, context3.f26210q, context3.f26211r, context3.f26212s);
                                        }
                                        z9 = false;
                                    } else {
                                        iArr3 = iArr12;
                                        iArr4 = iArr11;
                                        i16 = iM10559u4;
                                        i17 = i7;
                                        i18 = i95;
                                        z9 = z15;
                                    }
                                    if (i18 < i2) {
                                        char[] cArr2 = context3.f26196c;
                                        Label2[] label2Arr12 = context3.f26200g;
                                        if (z10) {
                                            i19 = i18 + 1;
                                            i21 = this.f26155a[i18] & 255;
                                            i20 = 0;
                                        } else {
                                            context3.f26206m = -1;
                                            i19 = i18;
                                            i20 = 0;
                                            i21 = 255;
                                        }
                                        context3.f26209p = i20;
                                        if (i21 < 64) {
                                            context3.f26207n = 3;
                                            context3.f26211r = i20;
                                            iM10562x = i19;
                                            label2Arr3 = label2Arr12;
                                            i22 = i2;
                                        } else {
                                            if (i21 < 128) {
                                                iM10559u = i21 - 64;
                                                i22 = i2;
                                                label2Arr3 = label2Arr12;
                                                iM10562x = m10562x(i19, context3.f26212s, 0, cArr2, label2Arr3);
                                                context3.f26207n = 4;
                                                context3.f26211r = 1;
                                            } else {
                                                label2Arr3 = label2Arr12;
                                                i22 = i2;
                                                if (i21 < 247) {
                                                    throw new IllegalArgumentException();
                                                }
                                                iM10559u = m10559u(i19);
                                                int iM10562x2 = i19 + 2;
                                                if (i21 == 247) {
                                                    iM10562x = m10562x(iM10562x2, context3.f26212s, 0, cArr2, label2Arr3);
                                                    context3.f26207n = 4;
                                                    context3.f26211r = 1;
                                                } else {
                                                    if (i21 >= 248 && i21 < 251) {
                                                        context3.f26207n = 2;
                                                        int i97 = 251 - i21;
                                                        context3.f26209p = i97;
                                                        context3.f26208o -= i97;
                                                        context3.f26211r = 0;
                                                    } else if (i21 == 251) {
                                                        context3.f26207n = 3;
                                                        context3.f26211r = 0;
                                                    } else if (i21 < 255) {
                                                        int i98 = i21 - 251;
                                                        int i99 = z11 ? context3.f26208o : 0;
                                                        int i100 = i98;
                                                        while (i100 > 0) {
                                                            iM10562x2 = m10562x(iM10562x2, context3.f26210q, i99, cArr2, label2Arr3);
                                                            i100--;
                                                            i98 = i98;
                                                            i99++;
                                                            cArr2 = cArr2;
                                                        }
                                                        int i101 = i98;
                                                        context3.f26207n = 1;
                                                        context3.f26209p = i101;
                                                        context3.f26208o += i101;
                                                        context3.f26211r = 0;
                                                    } else {
                                                        int iM10559u17 = m10559u(iM10562x2);
                                                        int iM10562x3 = iM10562x2 + 2;
                                                        context3.f26207n = 0;
                                                        context3.f26209p = iM10559u17;
                                                        context3.f26208o = iM10559u17;
                                                        for (int i102 = 0; i102 < iM10559u17; i102++) {
                                                            iM10562x3 = m10562x(iM10562x3, context3.f26210q, i102, cArr2, label2Arr3);
                                                        }
                                                        int iM10559u18 = m10559u(iM10562x3);
                                                        iM10562x2 = iM10562x3 + 2;
                                                        context3.f26211r = iM10559u18;
                                                        for (int i103 = 0; i103 < iM10559u18; i103++) {
                                                            iM10562x2 = m10562x(iM10562x2, context3.f26212s, i103, cArr2, label2Arr3);
                                                        }
                                                    }
                                                    iM10562x = iM10562x2;
                                                }
                                            }
                                            i21 = iM10559u;
                                        }
                                        int i104 = i21 + 1 + context3.f26206m;
                                        context3.f26206m = i104;
                                        m10540b(i104, label2Arr3);
                                        i95 = iM10562x;
                                        i7 = i17;
                                        z15 = z9;
                                        i2 = i22;
                                        iM10559u4 = i16;
                                        iArr12 = iArr3;
                                        iArr11 = iArr4;
                                    } else {
                                        i7 = i17;
                                        z15 = z9;
                                        iM10559u4 = i16;
                                        iArr12 = iArr3;
                                        iArr11 = iArr4;
                                        i95 = 0;
                                    }
                                } else {
                                    int[] iArr17 = iArr12;
                                    int[] iArr18 = iArr11;
                                    int i105 = i2;
                                    int i106 = iM10559u4;
                                    int i107 = i7;
                                    int i108 = i95;
                                    if (z15) {
                                        z2 = z15;
                                    } else {
                                        if ((context3.f26195b & 8) != 0) {
                                            methodVisitor2.mo10595c(256, 0, null, 0, null);
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
                                            methodVisitor2.mo10597e(i8);
                                            i10 = i107 + 1;
                                            iM10542d = i75;
                                            i11 = i73;
                                            z5 = z4;
                                            iArr2 = iArr18;
                                            while (iArr2 != null && i11 < iArr2.length && iM10542d <= i92) {
                                                if (iM10542d == i92) {
                                                    int iM10556r3 = m10556r(context3, iArr2[i11]);
                                                    m10549k(methodVisitor2.mo10598f(context3.f26201h, context3.f26202i, m10558t(iM10556r3, cArr), true), iM10556r3 + 2, true, cArr);
                                                }
                                                i11++;
                                                iM10542d = m10542d(iArr2, i11);
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null && i13 < iArr17.length && iM10542d2 <= i92) {
                                                if (iM10542d2 != i92) {
                                                    int iM10556r4 = m10556r(context3, iArr17[i13]);
                                                    z8 = z5;
                                                    i14 = i10;
                                                    i15 = i92;
                                                    m10549k(methodVisitor2.mo10598f(context3.f26201h, context3.f26202i, m10558t(iM10556r4, cArr), false), iM10556r4 + 2, true, cArr);
                                                } else {
                                                    z8 = z5;
                                                    i14 = i10;
                                                    i15 = i92;
                                                }
                                                i13++;
                                                iM10542d2 = m10542d(iArr17, i13);
                                                z5 = z8;
                                                i10 = i14;
                                                i92 = i15;
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
                                        case 16:
                                        case Opcodes.NEWARRAY /* 188 */:
                                            z3 = z11;
                                            z4 = z2;
                                            i9 = i108;
                                            methodVisitor2.mo10599g(i8, bArr[i107 + 1]);
                                            i10 = i107 + 2;
                                            iM10542d = i75;
                                            i11 = i73;
                                            z5 = z4;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                                if (iM10542d == i92) {
                                                }
                                                i11++;
                                                iM10542d = m10542d(iArr2, i11);
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                                if (iM10542d2 != i92) {
                                                }
                                                i13++;
                                                iM10542d2 = m10542d(iArr17, i13);
                                                z5 = z8;
                                                i10 = i14;
                                                i92 = i15;
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
                                        case 17:
                                            z3 = z11;
                                            z4 = z2;
                                            i9 = i108;
                                            methodVisitor2.mo10599g(i8, m10555q(i107 + 1));
                                            i10 = i107 + 3;
                                            iM10542d = i75;
                                            i11 = i73;
                                            z5 = z4;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
                                        case 18:
                                            z3 = z11;
                                            z4 = z2;
                                            i9 = i108;
                                            methodVisitor2.mo10602j(m10547i(bArr[i107 + 1] & 255, cArr));
                                            i10 = i107 + 2;
                                            iM10542d = i75;
                                            i11 = i73;
                                            z5 = z4;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
                                        case 19:
                                        case 20:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            methodVisitor2.mo10602j(m10547i(m10559u(i107 + 1), cArr));
                                            i10 = i107 + 3;
                                            iM10542d = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
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
                                            methodVisitor2.mo10612t(i8, bArr[i107 + 1] & 255);
                                            i10 = i107 + 2;
                                            iM10542d = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
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
                                            methodVisitor2.mo10612t((i109 >> 2) + 21, 3 & i109);
                                            i10 = i107 + 1;
                                            iM10542d = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
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
                                            methodVisitor2.mo10612t((i110 >> 2) + 54, 3 & i110);
                                            i10 = i107 + 1;
                                            iM10542d = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
                                        case Opcodes.IINC /* 132 */:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            methodVisitor2.mo10596d(bArr[i107 + 1] & 255, bArr[i107 + 2]);
                                            i10 = i107 + 3;
                                            iM10542d = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
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
                                            methodVisitor2.mo10600h(i8, label2Arr11[m10555q(i107 + 1) + i92]);
                                            i10 = i107 + 3;
                                            iM10542d = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
                                        case Opcodes.TABLESWITCH /* 170 */:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            int i111 = (4 - (i92 & 3)) + i107;
                                            Label2 label23 = label2Arr11[m10550l(i111) + i92];
                                            int iM10550l5 = m10550l(i111 + 4);
                                            int iM10550l6 = m10550l(i111 + 8);
                                            int i112 = i111 + 12;
                                            int i113 = (iM10550l6 - iM10550l5) + 1;
                                            Label2[] label2Arr13 = new Label2[i113];
                                            for (int i114 = 0; i114 < i113; i114++) {
                                                label2Arr13[i114] = label2Arr11[m10550l(i112) + i92];
                                                i112 += 4;
                                            }
                                            methodVisitor2.mo10609q(iM10550l5, iM10550l6, label23, label2Arr13);
                                            i10 = i112;
                                            iM10542d = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
                                        case Opcodes.LOOKUPSWITCH /* 171 */:
                                            z3 = z11;
                                            z6 = z2;
                                            int i115 = (4 - (i92 & 3)) + i107;
                                            Label2 label24 = label2Arr11[m10550l(i115) + i92];
                                            int iM10550l7 = m10550l(i115 + 4);
                                            int[] iArr19 = new int[iM10550l7];
                                            Label2[] label2Arr14 = new Label2[iM10550l7];
                                            int i116 = i115 + 8;
                                            for (int i117 = 0; i117 < iM10550l7; i117++) {
                                                iArr19[i117] = m10550l(i116);
                                                label2Arr14[i117] = label2Arr11[m10550l(i116 + 4) + i92];
                                                i116 += 8;
                                            }
                                            MethodWriter2 methodWriter23 = (MethodWriter2) methodVisitor2;
                                            ByteVector2 byteVector2 = methodWriter23.f26301l;
                                            methodWriter23.f26290Z = byteVector2.f26154b;
                                            byteVector2.m10535g(Opcodes.LOOKUPSWITCH);
                                            int i118 = i116;
                                            i9 = i108;
                                            byteVector2.m10536h(null, 0, (4 - (methodWriter23.f26301l.f26154b % 4)) % 4);
                                            boolean z16 = true;
                                            label24.m10591e(methodWriter23.f26301l, methodWriter23.f26290Z, true);
                                            methodWriter23.f26301l.m10537i(iM10550l7);
                                            int i119 = 0;
                                            while (i119 < iM10550l7) {
                                                methodWriter23.f26301l.m10537i(iArr19[i119]);
                                                label2Arr14[i119].m10591e(methodWriter23.f26301l, methodWriter23.f26290Z, z16);
                                                i119++;
                                                iM10550l7 = iM10550l7;
                                                z16 = true;
                                            }
                                            methodWriter23.m10614B(label24, label2Arr14);
                                            i10 = i118;
                                            iM10542d = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
                                        case Opcodes.GETSTATIC /* 178 */:
                                        case Opcodes.PUTSTATIC /* 179 */:
                                        case 180:
                                        case Opcodes.PUTFIELD /* 181 */:
                                        case Opcodes.INVOKEVIRTUAL /* 182 */:
                                        case Opcodes.INVOKESPECIAL /* 183 */:
                                        case Opcodes.INVOKESTATIC /* 184 */:
                                        case Opcodes.INVOKEINTERFACE /* 185 */:
                                            z3 = z11;
                                            int i120 = this.f26156b[m10559u(i107 + 1)];
                                            int i121 = this.f26156b[m10559u(i120 + 2)];
                                            String strM10545g = m10545g(i120, cArr);
                                            String strM10558t6 = m10558t(i121, cArr);
                                            String strM10558t7 = m10558t(i121 + 2, cArr);
                                            if (i8 < 182) {
                                                methodVisitor2.mo10594b(i8, strM10545g, strM10558t6, strM10558t7);
                                                z6 = z2;
                                                i12 = i8;
                                            } else {
                                                z6 = z2;
                                                i12 = i8;
                                                methodVisitor2.mo10608p(i8, strM10545g, strM10558t6, strM10558t7, bArr[i120 + (-1)] == 11);
                                            }
                                            i10 = i12 == 185 ? i107 + 5 : i107 + 3;
                                            i9 = i108;
                                            iM10542d = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
                                        case Opcodes.INVOKEDYNAMIC /* 186 */:
                                            int i122 = this.f26156b[m10559u(i107 + 1)];
                                            int i123 = this.f26156b[m10559u(i122 + 2)];
                                            String strM10558t8 = m10558t(i123, cArr);
                                            String strM10558t9 = m10558t(i123 + 2, cArr);
                                            int i124 = this.f26159e[m10559u(i122)];
                                            Handle2 handle2 = (Handle2) m10547i(m10559u(i124), cArr);
                                            int iM10559u19 = m10559u(i124 + 2);
                                            Object[] objArr2 = new Object[iM10559u19];
                                            int i125 = i124 + 4;
                                            z3 = z11;
                                            int i126 = 0;
                                            while (i126 < iM10559u19) {
                                                objArr2[i126] = m10547i(m10559u(i125), cArr);
                                                i125 += 2;
                                                i126++;
                                                iM10559u19 = iM10559u19;
                                            }
                                            MethodWriter2 methodWriter24 = (MethodWriter2) methodVisitor2;
                                            methodWriter24.f26290Z = methodWriter24.f26301l.f26154b;
                                            SymbolTable2 symbolTable2 = methodWriter24.f26293d;
                                            Symbol2 symbol2M10629d = symbolTable2.m10629d(18, strM10558t8, strM10558t9, symbolTable2.m10626a(handle2, objArr2).f26340a);
                                            methodWriter24.f26301l.m10533e(Opcodes.INVOKEDYNAMIC, symbol2M10629d.f26340a);
                                            methodWriter24.f26301l.m10538j(0);
                                            Label2 label25 = methodWriter24.f26281Q;
                                            if (label25 != null) {
                                                int i127 = methodWriter24.f26278N;
                                                if (i127 == 4 || i127 == 3) {
                                                    label25.f26258k.mo10569b(Opcodes.INVOKEDYNAMIC, 0, symbol2M10629d, methodWriter24.f26293d);
                                                } else {
                                                    int iM10621a = symbol2M10629d.m10621a();
                                                    int i128 = methodWriter24.f26282R + ((iM10621a & 3) - (iM10621a >> 2)) + 1;
                                                    if (i128 > methodWriter24.f26283S) {
                                                        methodWriter24.f26283S = i128;
                                                    }
                                                    methodWriter24.f26282R = i128;
                                                }
                                            }
                                            i10 = i107 + 5;
                                            z7 = z2;
                                            z5 = z7;
                                            i9 = i108;
                                            iM10542d = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
                                        case Opcodes.NEW /* 187 */:
                                        case Opcodes.ANEWARRAY /* 189 */:
                                        case Opcodes.CHECKCAST /* 192 */:
                                        case Opcodes.INSTANCEOF /* 193 */:
                                            methodVisitor2.mo10611s(i8, m10545g(i107 + 1, cArr));
                                            i10 = i107 + 3;
                                            z3 = z11;
                                            z7 = z2;
                                            z5 = z7;
                                            i9 = i108;
                                            iM10542d = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
                                        case 196:
                                            int i129 = bArr[i107 + 1] & 255;
                                            if (i129 == 132) {
                                                methodVisitor2.mo10596d(m10559u(i107 + 2), m10555q(i107 + 4));
                                                i10 = i107 + 6;
                                                z3 = z11;
                                                z7 = z2;
                                                z5 = z7;
                                                i9 = i108;
                                                iM10542d = i75;
                                                i11 = i73;
                                                iArr2 = iArr18;
                                                while (iArr2 != null) {
                                                }
                                                i13 = i74;
                                                iM10542d2 = i70;
                                                while (iArr17 != null) {
                                                }
                                                z12 = z5;
                                                i74 = i13;
                                                i70 = iM10542d2;
                                                i73 = i11;
                                                iArr11 = iArr2;
                                                label2Arr2 = label2Arr11;
                                                i71 = i10;
                                                iM10559u3 = i93;
                                                z11 = z3;
                                                i2 = i105;
                                                i72 = i9;
                                                i75 = iM10542d;
                                                iArr12 = iArr17;
                                                iM10559u4 = i106;
                                            } else {
                                                methodVisitor2.mo10612t(i129, m10559u(i107 + 2));
                                                i10 = i107 + 4;
                                                z3 = z11;
                                                z7 = z2;
                                                z5 = z7;
                                                i9 = i108;
                                                iM10542d = i75;
                                                i11 = i73;
                                                iArr2 = iArr18;
                                                while (iArr2 != null) {
                                                }
                                                i13 = i74;
                                                iM10542d2 = i70;
                                                while (iArr17 != null) {
                                                }
                                                z12 = z5;
                                                i74 = i13;
                                                i70 = iM10542d2;
                                                i73 = i11;
                                                iArr11 = iArr2;
                                                label2Arr2 = label2Arr11;
                                                i71 = i10;
                                                iM10559u3 = i93;
                                                z11 = z3;
                                                i2 = i105;
                                                i72 = i9;
                                                i75 = iM10542d;
                                                iArr12 = iArr17;
                                                iM10559u4 = i106;
                                            }
                                            break;
                                        case Opcodes.MULTIANEWARRAY /* 197 */:
                                            String strM10545g2 = m10545g(i107 + 1, cArr);
                                            int i130 = bArr[i107 + 3] & 255;
                                            MethodWriter2 methodWriter25 = (MethodWriter2) methodVisitor2;
                                            methodWriter25.f26290Z = methodWriter25.f26301l.f26154b;
                                            Symbol2 symbol2M10638m = methodWriter25.f26293d.m10638m(7, strM10545g2);
                                            ByteVector2 byteVector22 = methodWriter25.f26301l;
                                            byteVector22.m10533e(Opcodes.MULTIANEWARRAY, symbol2M10638m.f26340a);
                                            byteVector22.m10535g(i130);
                                            Label2 label26 = methodWriter25.f26281Q;
                                            if (label26 != null) {
                                                int i131 = methodWriter25.f26278N;
                                                if (i131 == 4 || i131 == 3) {
                                                    label26.f26258k.mo10569b(Opcodes.MULTIANEWARRAY, i130, symbol2M10638m, methodWriter25.f26293d);
                                                } else {
                                                    methodWriter25.f26282R = (1 - i130) + methodWriter25.f26282R;
                                                }
                                            }
                                            i10 = i107 + 4;
                                            z3 = z11;
                                            z7 = z2;
                                            z5 = z7;
                                            i9 = i108;
                                            iM10542d = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
                                        case 200:
                                        case 201:
                                            methodVisitor2.mo10600h(i8 - i69, label2Arr11[m10550l(i107 + 1) + i92]);
                                            i10 = i107 + 5;
                                            z3 = z11;
                                            z7 = z2;
                                            z5 = z7;
                                            i9 = i108;
                                            iM10542d = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
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
                                            Label2 label27 = label2Arr11[m10559u(i107 + 1) + i92];
                                            if (i132 == 167 || i132 == 168) {
                                                methodVisitor2.mo10600h(i132 + 33, label27);
                                                z7 = z2;
                                            } else {
                                                methodVisitor2.mo10600h(i132 < 167 ? ((i132 + 1) ^ 1) - 1 : i132 ^ 1, m10540b(i92 + 3, label2Arr11));
                                                methodVisitor2.mo10600h(200, label27);
                                                z7 = true;
                                            }
                                            i10 = i107 + 3;
                                            z3 = z11;
                                            z5 = z7;
                                            i9 = i108;
                                            iM10542d = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
                                        case 220:
                                            methodVisitor2.mo10600h(200, label2Arr11[m10550l(i107 + 1) + i92]);
                                            i10 = i107 + 5;
                                            z3 = z11;
                                            i9 = i108;
                                            iM10542d = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            z5 = true;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iM10542d2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iM10542d2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iM10559u3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iM10542d;
                                            iArr12 = iArr17;
                                            iM10559u4 = i106;
                                            break;
                                        default:
                                            throw new AssertionError();
                                    }
                                }
                            }
                            int[] iArr172 = iArr12;
                            int[] iArr182 = iArr11;
                            int i1052 = i2;
                            int i1062 = iM10559u4;
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

    /* JADX INFO: renamed from: i */
    public Object m10547i(int i, char[] cArr) {
        int[] iArr = this.f26156b;
        int i2 = iArr[i];
        byte b2 = this.f26155a[i2 - 1];
        switch (b2) {
            case 3:
                return Integer.valueOf(m10550l(i2));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(m10550l(i2)));
            case 5:
                return Long.valueOf(m10551m(i2));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(m10551m(i2)));
            case 7:
                return Type2.m10647h(m10558t(i2, cArr));
            case 8:
                return m10558t(i2, cArr);
            default:
                switch (b2) {
                    case 15:
                        int iM10544f = m10544f(i2);
                        int i3 = this.f26156b[m10559u(i2 + 1)];
                        int i4 = this.f26156b[m10559u(i3 + 2)];
                        return new Handle2(iM10544f, m10545g(i3, cArr), m10558t(i4, cArr), m10558t(i4 + 2, cArr), this.f26155a[i3 - 1] == 11);
                    case 16:
                        String strM10558t = m10558t(i2, cArr);
                        return new Type2(11, strM10558t, 0, strM10558t.length());
                    case 17:
                        ConstantDynamic2 constantDynamic2 = this.f26158d[i];
                        if (constantDynamic2 != null) {
                            return constantDynamic2;
                        }
                        int i5 = iArr[i];
                        int i6 = iArr[m10559u(i5 + 2)];
                        String strM10558t2 = m10558t(i6, cArr);
                        String strM10558t3 = m10558t(i6 + 2, cArr);
                        int i7 = this.f26159e[m10559u(i5)];
                        Handle2 handle2 = (Handle2) m10547i(m10559u(i7), cArr);
                        int iM10559u = m10559u(i7 + 2);
                        Object[] objArr = new Object[iM10559u];
                        int i8 = i7 + 4;
                        for (int i9 = 0; i9 < iM10559u; i9++) {
                            objArr[i9] = m10547i(m10559u(i8), cArr);
                            i8 += 2;
                        }
                        ConstantDynamic2[] constantDynamic2Arr = this.f26158d;
                        ConstantDynamic2 constantDynamic22 = new ConstantDynamic2(strM10558t2, strM10558t3, handle2, objArr);
                        constantDynamic2Arr[i] = constantDynamic22;
                        return constantDynamic22;
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x0235  */
    /* JADX INFO: renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m10548j(AnnotationWriter2 annotationWriter2, int i, String str, char[] cArr) {
        int i2 = 0;
        if (annotationWriter2 == null) {
            int i3 = this.f26155a[i] & 255;
            return i3 != 64 ? i3 != 91 ? i3 != 101 ? i + 3 : i + 5 : m10549k(null, i + 1, false, cArr) : m10549k(null, i + 3, true, cArr);
        }
        int i4 = i + 1;
        int i5 = this.f26155a[i] & 255;
        if (i5 == 64) {
            String strM10558t = m10558t(i4, cArr);
            annotationWriter2.f26145e++;
            if (annotationWriter2.f26142b) {
                annotationWriter2.f26143c.m10538j(annotationWriter2.f26141a.m10637l(str));
            }
            ByteVector2 byteVector2 = annotationWriter2.f26143c;
            byteVector2.m10533e(64, annotationWriter2.f26141a.m10637l(strM10558t));
            byteVector2.m10538j(0);
            return m10549k(new AnnotationWriter2(annotationWriter2.f26141a, true, annotationWriter2.f26143c, null), i4 + 2, true, cArr);
        }
        if (i5 == 70) {
            annotationWriter2.m10520e(str, m10547i(m10559u(i4), cArr));
        } else if (i5 == 83) {
            annotationWriter2.m10520e(str, Short.valueOf((short) m10550l(this.f26156b[m10559u(i4)])));
        } else if (i5 == 99) {
            String strM10558t2 = m10558t(i4, cArr);
            annotationWriter2.m10520e(str, Type2.m10649k(strM10558t2, 0, strM10558t2.length()));
        } else {
            if (i5 == 101) {
                String strM10558t3 = m10558t(i4, cArr);
                String strM10558t4 = m10558t(i4 + 2, cArr);
                annotationWriter2.f26145e++;
                if (annotationWriter2.f26142b) {
                    annotationWriter2.f26143c.m10538j(annotationWriter2.f26141a.m10637l(str));
                }
                ByteVector2 byteVector22 = annotationWriter2.f26143c;
                byteVector22.m10533e(101, annotationWriter2.f26141a.m10637l(strM10558t3));
                byteVector22.m10538j(annotationWriter2.f26141a.m10637l(strM10558t4));
                return i4 + 4;
            }
            if (i5 == 115) {
                annotationWriter2.m10520e(str, m10558t(i4, cArr));
            } else if (i5 != 73 && i5 != 74) {
                if (i5 == 90) {
                    annotationWriter2.m10520e(str, m10550l(this.f26156b[m10559u(i4)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                } else {
                    if (i5 == 91) {
                        int iM10559u = m10559u(i4);
                        int i6 = i4 + 2;
                        if (iM10559u == 0) {
                            return m10549k(annotationWriter2.m10521f(str), i6 - 2, false, cArr);
                        }
                        int i7 = this.f26155a[i6] & 255;
                        if (i7 == 70) {
                            float[] fArr = new float[iM10559u];
                            while (i2 < iM10559u) {
                                fArr[i2] = Float.intBitsToFloat(m10550l(this.f26156b[m10559u(i6 + 1)]));
                                i6 += 3;
                                i2++;
                            }
                            annotationWriter2.m10520e(str, fArr);
                            return i6;
                        }
                        if (i7 == 83) {
                            short[] sArr = new short[iM10559u];
                            while (i2 < iM10559u) {
                                sArr[i2] = (short) m10550l(this.f26156b[m10559u(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            annotationWriter2.m10520e(str, sArr);
                            return i6;
                        }
                        if (i7 == 90) {
                            boolean[] zArr = new boolean[iM10559u];
                            for (int i8 = 0; i8 < iM10559u; i8++) {
                                zArr[i8] = m10550l(this.f26156b[m10559u(i6 + 1)]) != 0;
                                i6 += 3;
                            }
                            annotationWriter2.m10520e(str, zArr);
                            return i6;
                        }
                        if (i7 == 73) {
                            int[] iArr = new int[iM10559u];
                            while (i2 < iM10559u) {
                                iArr[i2] = m10550l(this.f26156b[m10559u(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            annotationWriter2.m10520e(str, iArr);
                            return i6;
                        }
                        if (i7 == 74) {
                            long[] jArr = new long[iM10559u];
                            while (i2 < iM10559u) {
                                jArr[i2] = m10551m(this.f26156b[m10559u(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            annotationWriter2.m10520e(str, jArr);
                            return i6;
                        }
                        switch (i7) {
                            case 66:
                                byte[] bArr = new byte[iM10559u];
                                while (i2 < iM10559u) {
                                    bArr[i2] = (byte) m10550l(this.f26156b[m10559u(i6 + 1)]);
                                    i6 += 3;
                                    i2++;
                                }
                                annotationWriter2.m10520e(str, bArr);
                                return i6;
                            case 67:
                                char[] cArr2 = new char[iM10559u];
                                while (i2 < iM10559u) {
                                    cArr2[i2] = (char) m10550l(this.f26156b[m10559u(i6 + 1)]);
                                    i6 += 3;
                                    i2++;
                                }
                                annotationWriter2.m10520e(str, cArr2);
                                return i6;
                            case 68:
                                double[] dArr = new double[iM10559u];
                                while (i2 < iM10559u) {
                                    dArr[i2] = Double.longBitsToDouble(m10551m(this.f26156b[m10559u(i6 + 1)]));
                                    i6 += 3;
                                    i2++;
                                }
                                annotationWriter2.m10520e(str, dArr);
                                return i6;
                            default:
                                return m10549k(annotationWriter2.m10521f(str), i6 - 2, false, cArr);
                        }
                    }
                    switch (i5) {
                        case 66:
                            annotationWriter2.m10520e(str, Byte.valueOf((byte) m10550l(this.f26156b[m10559u(i4)])));
                            break;
                        case 67:
                            annotationWriter2.m10520e(str, Character.valueOf((char) m10550l(this.f26156b[m10559u(i4)])));
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

    /* JADX INFO: renamed from: k */
    public final int m10549k(AnnotationWriter2 annotationWriter2, int i, boolean z2, char[] cArr) {
        int iM10559u = m10559u(i);
        int iM10548j = i + 2;
        if (!z2) {
            while (true) {
                int i2 = iM10559u - 1;
                if (iM10559u <= 0) {
                    break;
                }
                iM10548j = m10548j(annotationWriter2, iM10548j, null, cArr);
                iM10559u = i2;
            }
        } else {
            while (true) {
                int i3 = iM10559u - 1;
                if (iM10559u <= 0) {
                    break;
                }
                iM10548j = m10548j(annotationWriter2, iM10548j + 2, m10558t(iM10548j, cArr), cArr);
                iM10559u = i3;
            }
        }
        if (annotationWriter2 != null) {
            annotationWriter2.m10522g();
        }
        return iM10548j;
    }

    /* JADX INFO: renamed from: l */
    public int m10550l(int i) {
        byte[] bArr = this.f26155a;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    /* JADX INFO: renamed from: m */
    public long m10551m(int i) {
        return (((long) m10550l(i)) << 32) | (((long) m10550l(i + 4)) & 4294967295L);
    }

    /* JADX INFO: renamed from: n */
    public String m10552n(int i, char[] cArr) {
        return m10558t(this.f26156b[m10559u(i)], cArr);
    }

    /* JADX INFO: renamed from: o */
    public String m10553o(int i, char[] cArr) {
        return m10558t(this.f26156b[m10559u(i)], cArr);
    }

    /* JADX INFO: renamed from: p */
    public final void m10554p(MethodVisitor2 methodVisitor2, Context3 context3, int i, boolean z2) {
        AnnotationWriter2 annotationWriter2;
        int iM10549k = i + 1;
        int i2 = this.f26155a[i] & 255;
        MethodWriter2 methodWriter2 = (MethodWriter2) methodVisitor2;
        if (z2) {
            methodWriter2.f26268D = i2;
        } else {
            methodWriter2.f26270F = i2;
        }
        char[] cArr = context3.f26196c;
        for (int i3 = 0; i3 < i2; i3++) {
            int iM10559u = m10559u(iM10549k);
            iM10549k += 2;
            while (true) {
                int i4 = iM10559u - 1;
                if (iM10559u > 0) {
                    String strM10558t = m10558t(iM10549k, cArr);
                    int i5 = iM10549k + 2;
                    ByteVector2 byteVector2 = new ByteVector2();
                    byteVector2.m10538j(methodWriter2.f26293d.m10637l(strM10558t));
                    byteVector2.m10538j(0);
                    if (z2) {
                        if (methodWriter2.f26269E == null) {
                            methodWriter2.f26269E = new AnnotationWriter2[Type2.m10644a(methodWriter2.f26298i).length];
                        }
                        AnnotationWriter2[] annotationWriter2Arr = methodWriter2.f26269E;
                        annotationWriter2 = new AnnotationWriter2(methodWriter2.f26293d, true, byteVector2, annotationWriter2Arr[i3]);
                        annotationWriter2Arr[i3] = annotationWriter2;
                    } else {
                        if (methodWriter2.f26271G == null) {
                            methodWriter2.f26271G = new AnnotationWriter2[Type2.m10644a(methodWriter2.f26298i).length];
                        }
                        AnnotationWriter2[] annotationWriter2Arr2 = methodWriter2.f26271G;
                        annotationWriter2 = new AnnotationWriter2(methodWriter2.f26293d, true, byteVector2, annotationWriter2Arr2[i3]);
                        annotationWriter2Arr2[i3] = annotationWriter2;
                    }
                    iM10549k = m10549k(annotationWriter2, i5, true, cArr);
                    iM10559u = i4;
                }
            }
        }
    }

    /* JADX INFO: renamed from: q */
    public short m10555q(int i) {
        byte[] bArr = this.f26155a;
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /* JADX INFO: renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m10556r(Context3 context3, int i) {
        int i2;
        int i3;
        int iM10550l = m10550l(i);
        int i4 = iM10550l >>> 24;
        if (i4 != 0 && i4 != 1) {
            switch (i4) {
                case 16:
                case 17:
                case 18:
                case 23:
                    i2 = iM10550l & InputDeviceCompat.SOURCE_ANY;
                    i3 = i + 3;
                    break;
                case 19:
                case 20:
                case 21:
                    i2 = iM10550l & ViewCompat.MEASURED_STATE_MASK;
                    i3 = i + 1;
                    break;
                case 22:
                    break;
                default:
                    switch (i4) {
                        case 64:
                        case 65:
                            i2 = iM10550l & ViewCompat.MEASURED_STATE_MASK;
                            int iM10559u = m10559u(i + 1);
                            i3 = i + 3;
                            context3.f26203j = new Label2[iM10559u];
                            context3.f26204k = new Label2[iM10559u];
                            context3.f26205l = new int[iM10559u];
                            for (int i5 = 0; i5 < iM10559u; i5++) {
                                int iM10559u2 = m10559u(i3);
                                int iM10559u3 = m10559u(i3 + 2);
                                int iM10559u4 = m10559u(i3 + 4);
                                i3 += 6;
                                context3.f26203j[i5] = m10540b(iM10559u2, context3.f26200g);
                                context3.f26204k[i5] = m10540b(iM10559u2 + iM10559u3, context3.f26200g);
                                context3.f26205l[i5] = iM10559u4;
                            }
                            break;
                        case 66:
                            break;
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                            i2 = iM10550l & ViewCompat.MEASURED_STATE_MASK;
                            i3 = i + 3;
                            break;
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            i2 = iM10550l & (-16776961);
                            i3 = i + 4;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    break;
            }
        } else {
            i2 = iM10550l & (-65536);
            i3 = i + 2;
        }
        context3.f26201h = i2;
        int iM10544f = m10544f(i3);
        context3.f26202i = iM10544f == 0 ? null : new TypePath2(this.f26155a, i3);
        return (iM10544f * 2) + i3 + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[FALL_THROUGH] */
    /* JADX INFO: renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int[] m10557s(MethodVisitor2 methodVisitor2, Context3 context3, int i, boolean z2) {
        int i2;
        AnnotationWriter2 annotationWriter2;
        char[] cArr = context3.f26196c;
        int iM10559u = m10559u(i);
        int[] iArr = new int[iM10559u];
        int iM10549k = i + 2;
        for (int i3 = 0; i3 < iM10559u; i3++) {
            iArr[i3] = iM10549k;
            int iM10550l = m10550l(iM10549k);
            int i4 = iM10550l >>> 24;
            if (i4 != 23) {
                switch (i4) {
                    default:
                        switch (i4) {
                            case 64:
                            case 65:
                                int iM10559u2 = m10559u(iM10549k + 1);
                                i2 = iM10549k + 3;
                                while (true) {
                                    int i5 = iM10559u2 - 1;
                                    if (iM10559u2 > 0) {
                                        int iM10559u3 = m10559u(i2);
                                        int iM10559u4 = m10559u(i2 + 2);
                                        i2 += 6;
                                        m10540b(iM10559u3, context3.f26200g);
                                        m10540b(iM10559u3 + iM10559u4, context3.f26200g);
                                        iM10559u2 = i5;
                                    }
                                    break;
                                }
                                break;
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
                                i2 = iM10549k + 4;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                    case 16:
                    case 17:
                    case 18:
                        i2 = iM10549k + 3;
                        break;
                }
            }
            int iM10544f = m10544f(i2);
            if (i4 == 66) {
                TypePath2 typePath2 = iM10544f != 0 ? new TypePath2(this.f26155a, i2) : null;
                int i6 = (iM10544f * 2) + 1 + i2;
                String strM10558t = m10558t(i6, cArr);
                int i7 = i6 + 2;
                int i8 = iM10550l & InputDeviceCompat.SOURCE_ANY;
                MethodWriter2 methodWriter2 = (MethodWriter2) methodVisitor2;
                Objects.requireNonNull(methodWriter2);
                ByteVector2 byteVector2 = new ByteVector2();
                C3404f.m4256W0(i8, byteVector2);
                TypePath2.m10655a(typePath2, byteVector2);
                byteVector2.m10538j(methodWriter2.f26293d.m10637l(strM10558t));
                byteVector2.m10538j(0);
                if (z2) {
                    annotationWriter2 = new AnnotationWriter2(methodWriter2.f26293d, true, byteVector2, methodWriter2.f26312w);
                    methodWriter2.f26312w = annotationWriter2;
                } else {
                    annotationWriter2 = new AnnotationWriter2(methodWriter2.f26293d, true, byteVector2, methodWriter2.f26313x);
                    methodWriter2.f26313x = annotationWriter2;
                }
                iM10549k = m10549k(annotationWriter2, i7, true, cArr);
            } else {
                iM10549k = m10549k(null, (iM10544f * 2) + 3 + i2, true, cArr);
            }
        }
        return iArr;
    }

    /* JADX INFO: renamed from: t */
    public String m10558t(int i, char[] cArr) {
        int iM10559u = m10559u(i);
        if (i == 0 || iM10559u == 0) {
            return null;
        }
        return m10561w(iM10559u, cArr);
    }

    /* JADX INFO: renamed from: u */
    public int m10559u(int i) {
        byte[] bArr = this.f26155a;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    /* JADX INFO: renamed from: v */
    public final String m10560v(int i, int i2, char[] cArr) {
        int i3;
        int i4 = i2 + i;
        byte[] bArr = this.f26155a;
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

    /* JADX INFO: renamed from: w */
    public final String m10561w(int i, char[] cArr) {
        String[] strArr = this.f26157c;
        String str = strArr[i];
        if (str != null) {
            return str;
        }
        int i2 = this.f26156b[i];
        String strM10560v = m10560v(i2 + 2, m10559u(i2), cArr);
        strArr[i] = strM10560v;
        return strM10560v;
    }

    /* JADX INFO: renamed from: x */
    public final int m10562x(int i, Object[] objArr, int i2, char[] cArr, Label2[] label2Arr) {
        int i3 = i + 1;
        switch (this.f26155a[i] & 255) {
            case 0:
                objArr[i2] = Opcodes2.f26333a;
                return i3;
            case 1:
                objArr[i2] = Opcodes2.f26334b;
                return i3;
            case 2:
                objArr[i2] = Opcodes2.f26335c;
                return i3;
            case 3:
                objArr[i2] = Opcodes2.f26336d;
                return i3;
            case 4:
                objArr[i2] = Opcodes2.f26337e;
                return i3;
            case 5:
                objArr[i2] = Opcodes2.f26338f;
                return i3;
            case 6:
                objArr[i2] = Opcodes2.f26339g;
                return i3;
            case 7:
                objArr[i2] = m10545g(i3, cArr);
                break;
            case 8:
                objArr[i2] = m10540b(m10559u(i3), label2Arr);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return i3 + 2;
    }
}
