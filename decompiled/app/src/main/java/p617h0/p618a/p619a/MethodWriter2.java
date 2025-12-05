package p617h0.p618a.p619a;

import com.discord.widgets.chat.input.MentionUtils;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p617h0.p618a.p619a.SymbolTable2;

/* compiled from: MethodWriter.java */
/* renamed from: h0.a.a.r, reason: use source file name */
/* loaded from: classes3.dex */
public final class MethodWriter2 extends MethodVisitor2 {

    /* renamed from: c */
    public static final int[] f26264c = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -4, -3, -4, -3, -3, -3, -3, -1, -2, 1, 1, 1, 2, 2, 2, 0, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -2, -1, -2, -1, -2, 0, 1, 0, 1, -1, -1, 0, 0, 1, 1, -1, 0, -1, 0, 0, 0, -3, -1, -1, -3, -3, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, 0, 1, 0, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, 0, 0};

    /* renamed from: A */
    public final int f26265A;

    /* renamed from: B */
    public AnnotationWriter2 f26266B;

    /* renamed from: C */
    public AnnotationWriter2 f26267C;

    /* renamed from: D */
    public int f26268D;

    /* renamed from: E */
    public AnnotationWriter2[] f26269E;

    /* renamed from: F */
    public int f26270F;

    /* renamed from: G */
    public AnnotationWriter2[] f26271G;

    /* renamed from: H */
    public AnnotationWriter2 f26272H;

    /* renamed from: I */
    public AnnotationWriter2 f26273I;

    /* renamed from: J */
    public ByteVector2 f26274J;

    /* renamed from: K */
    public int f26275K;

    /* renamed from: L */
    public ByteVector2 f26276L;

    /* renamed from: M */
    public Attribute2 f26277M;

    /* renamed from: N */
    public final int f26278N;

    /* renamed from: O */
    public Label2 f26279O;

    /* renamed from: P */
    public Label2 f26280P;

    /* renamed from: Q */
    public Label2 f26281Q;

    /* renamed from: R */
    public int f26282R;

    /* renamed from: S */
    public int f26283S;

    /* renamed from: T */
    public int f26284T;

    /* renamed from: U */
    public int f26285U;

    /* renamed from: V */
    public int[] f26286V;

    /* renamed from: W */
    public int[] f26287W;

    /* renamed from: X */
    public boolean f26288X;

    /* renamed from: Y */
    public boolean f26289Y;

    /* renamed from: Z */
    public int f26290Z;

    /* renamed from: a0 */
    public int f26291a0;

    /* renamed from: b0 */
    public int f26292b0;

    /* renamed from: d */
    public final SymbolTable2 f26293d;

    /* renamed from: e */
    public final int f26294e;

    /* renamed from: f */
    public final int f26295f;

    /* renamed from: g */
    public final String f26296g;

    /* renamed from: h */
    public final int f26297h;

    /* renamed from: i */
    public final String f26298i;

    /* renamed from: j */
    public int f26299j;

    /* renamed from: k */
    public int f26300k;

    /* renamed from: l */
    public final ByteVector2 f26301l;

    /* renamed from: m */
    public Handler5 f26302m;

    /* renamed from: n */
    public Handler5 f26303n;

    /* renamed from: o */
    public int f26304o;

    /* renamed from: p */
    public ByteVector2 f26305p;

    /* renamed from: q */
    public int f26306q;

    /* renamed from: r */
    public ByteVector2 f26307r;

    /* renamed from: s */
    public int f26308s;

    /* renamed from: t */
    public ByteVector2 f26309t;

    /* renamed from: u */
    public int f26310u;

    /* renamed from: v */
    public ByteVector2 f26311v;

    /* renamed from: w */
    public AnnotationWriter2 f26312w;

    /* renamed from: x */
    public AnnotationWriter2 f26313x;

    /* renamed from: y */
    public final int f26314y;

    /* renamed from: z */
    public final int[] f26315z;

    public MethodWriter2(SymbolTable2 symbolTable2, int i, String str, String str2, String str3, String[] strArr, int i2) {
        super(Opcodes.ASM7);
        this.f26301l = new ByteVector2();
        this.f26293d = symbolTable2;
        this.f26294e = "<init>".equals(str) ? 262144 | i : i;
        this.f26295f = symbolTable2.m10637l(str);
        this.f26296g = str;
        this.f26297h = symbolTable2.m10637l(str2);
        this.f26298i = str2;
        this.f26265A = str3 == null ? 0 : symbolTable2.m10637l(str3);
        if (strArr == null || strArr.length <= 0) {
            this.f26314y = 0;
            this.f26315z = null;
        } else {
            int length = strArr.length;
            this.f26314y = length;
            this.f26315z = new int[length];
            for (int i3 = 0; i3 < this.f26314y; i3++) {
                this.f26315z[i3] = symbolTable2.m10628c(strArr[i3]).f26340a;
            }
        }
        this.f26278N = i2;
        if (i2 != 0) {
            int iM10645b = Type2.m10645b(str2) >> 2;
            iM10645b = (i & 8) != 0 ? iM10645b - 1 : iM10645b;
            this.f26300k = iM10645b;
            this.f26284T = iM10645b;
            Label2 label2 = new Label2();
            this.f26279O = label2;
            mo10601i(label2);
        }
    }

    /* renamed from: A */
    public int m10613A(int i, int i2, int i3) {
        int i4 = i2 + 3 + i3;
        int[] iArr = this.f26287W;
        if (iArr == null || iArr.length < i4) {
            this.f26287W = new int[i4];
        }
        int[] iArr2 = this.f26287W;
        iArr2[0] = i;
        iArr2[1] = i2;
        iArr2[2] = i3;
        return 3;
    }

    /* renamed from: B */
    public final void m10614B(Label2 label2, Label2[] label2Arr) {
        Label2 label22 = this.f26281Q;
        if (label22 != null) {
            int i = this.f26278N;
            if (i == 4) {
                label22.f26258k.mo10569b(Opcodes.LOOKUPSWITCH, 0, null, null);
                m10615u(0, label2);
                Label2 label2M10588b = label2.m10588b();
                label2M10588b.f26249b = (short) (label2M10588b.f26249b | 2);
                for (Label2 label23 : label2Arr) {
                    m10615u(0, label23);
                    Label2 label2M10588b2 = label23.m10588b();
                    label2M10588b2.f26249b = (short) (label2M10588b2.f26249b | 2);
                }
            } else if (i == 1) {
                int i2 = this.f26282R - 1;
                this.f26282R = i2;
                m10615u(i2, label2);
                for (Label2 label24 : label2Arr) {
                    m10615u(this.f26282R, label24);
                }
            }
            m10616v();
        }
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: a */
    public AnnotationWriter2 mo10593a(String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        byteVector2.m10538j(this.f26293d.m10637l(str));
        byteVector2.m10538j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.f26293d, true, byteVector2, this.f26266B);
            this.f26266B = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter22 = new AnnotationWriter2(this.f26293d, true, byteVector2, this.f26267C);
        this.f26267C = annotationWriter22;
        return annotationWriter22;
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: b */
    public void mo10594b(int i, String str, String str2, String str3) {
        int i2;
        int i3;
        this.f26290Z = this.f26301l.f26154b;
        SymbolTable2.a aVarM10633h = this.f26293d.m10633h(9, str, str2, str3);
        this.f26301l.m10533e(i, aVarM10633h.f26340a);
        Label2 label2 = this.f26281Q;
        if (label2 != null) {
            int i4 = this.f26278N;
            if (i4 == 4 || i4 == 3) {
                label2.f26258k.mo10569b(i, 0, aVarM10633h, this.f26293d);
                return;
            }
            char cCharAt = str3.charAt(0);
            int i5 = -2;
            switch (i) {
                case Opcodes.GETSTATIC /* 178 */:
                    i2 = this.f26282R + ((cCharAt == 'D' || cCharAt == 'J') ? 2 : 1);
                    break;
                case Opcodes.PUTSTATIC /* 179 */:
                    i3 = this.f26282R;
                    if (cCharAt != 'D' && cCharAt != 'J') {
                        i5 = -1;
                    }
                    i2 = i3 + i5;
                    break;
                case 180:
                    i2 = this.f26282R + ((cCharAt == 'D' || cCharAt == 'J') ? 1 : 0);
                    break;
                default:
                    i3 = this.f26282R;
                    if (cCharAt == 'D' || cCharAt == 'J') {
                        i5 = -3;
                    }
                    i2 = i3 + i5;
                    break;
            }
            if (i2 > this.f26283S) {
                this.f26283S = i2;
            }
            this.f26282R = i2;
        }
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: c */
    public void mo10595c(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4;
        int i5 = this.f26278N;
        if (i5 == 4) {
            return;
        }
        int i6 = 3;
        if (i5 == 3) {
            Label2 label2 = this.f26281Q;
            Frame3 frame3 = label2.f26258k;
            if (frame3 == null) {
                CurrentFrame2 currentFrame2 = new CurrentFrame2(label2);
                label2.f26258k = currentFrame2;
                currentFrame2.m10584n(this.f26293d, this.f26294e, this.f26298i, i2);
                this.f26281Q.f26258k.m10575a(this);
            } else {
                if (i == -1) {
                    SymbolTable2 symbolTable2 = this.f26293d;
                    int i7 = 0;
                    for (int i8 = 0; i8 < i2; i8++) {
                        int i9 = i7 + 1;
                        frame3.f26229b[i7] = Frame3.m10572c(symbolTable2, objArr[i8]);
                        if (objArr[i8] == Opcodes2.f26337e || objArr[i8] == Opcodes2.f26336d) {
                            frame3.f26229b[i9] = 16777216;
                            i7 = i9 + 1;
                        } else {
                            i7 = i9;
                        }
                    }
                    while (true) {
                        int[] iArr = frame3.f26229b;
                        if (i7 >= iArr.length) {
                            break;
                        }
                        iArr[i7] = 16777216;
                        i7++;
                    }
                    int i10 = 0;
                    for (int i11 = 0; i11 < i3; i11++) {
                        if (objArr2[i11] == Opcodes2.f26337e || objArr2[i11] == Opcodes2.f26336d) {
                            i10++;
                        }
                    }
                    frame3.f26230c = new int[i10 + i3];
                    int i12 = 0;
                    for (int i13 = 0; i13 < i3; i13++) {
                        int i14 = i12 + 1;
                        frame3.f26230c[i12] = Frame3.m10572c(symbolTable2, objArr2[i13]);
                        if (objArr2[i13] == Opcodes2.f26337e || objArr2[i13] == Opcodes2.f26336d) {
                            frame3.f26230c[i14] = 16777216;
                            i12 = i14 + 1;
                        } else {
                            i12 = i14;
                        }
                    }
                    frame3.f26234g = (short) 0;
                    frame3.f26235h = 0;
                }
                this.f26281Q.f26258k.m10575a(this);
            }
        } else if (i == -1) {
            if (this.f26286V == null) {
                int iM10645b = Type2.m10645b(this.f26298i) >> 2;
                Frame3 frame32 = new Frame3(new Label2());
                frame32.m10584n(this.f26293d, this.f26294e, this.f26298i, iM10645b);
                frame32.m10575a(this);
            }
            this.f26284T = i2;
            m10613A(this.f26301l.f26154b, i2, i3);
            int i15 = 0;
            while (i15 < i2) {
                this.f26287W[i6] = Frame3.m10572c(this.f26293d, objArr[i15]);
                i15++;
                i6++;
            }
            int i16 = 0;
            while (i16 < i3) {
                this.f26287W[i6] = Frame3.m10572c(this.f26293d, objArr2[i16]);
                i16++;
                i6++;
            }
            m10620z();
        } else {
            if (this.f26311v == null) {
                this.f26311v = new ByteVector2();
                i4 = this.f26301l.f26154b;
            } else {
                i4 = (this.f26301l.f26154b - this.f26285U) - 1;
                if (i4 < 0) {
                    if (i != 3) {
                        throw new IllegalStateException();
                    }
                    return;
                }
            }
            if (i == 0) {
                this.f26284T = i2;
                ByteVector2 byteVector2 = this.f26311v;
                byteVector2.m10535g(255);
                byteVector2.m10538j(i4);
                byteVector2.m10538j(i2);
                for (int i17 = 0; i17 < i2; i17++) {
                    m10618x(objArr[i17]);
                }
                this.f26311v.m10538j(i3);
                for (int i18 = 0; i18 < i3; i18++) {
                    m10618x(objArr2[i18]);
                }
            } else if (i == 1) {
                this.f26284T += i2;
                ByteVector2 byteVector22 = this.f26311v;
                byteVector22.m10535g(i2 + 251);
                byteVector22.m10538j(i4);
                for (int i19 = 0; i19 < i2; i19++) {
                    m10618x(objArr[i19]);
                }
            } else if (i == 2) {
                this.f26284T -= i2;
                ByteVector2 byteVector23 = this.f26311v;
                byteVector23.m10535g(251 - i2);
                byteVector23.m10538j(i4);
            } else if (i != 3) {
                if (i != 4) {
                    throw new IllegalArgumentException();
                }
                if (i4 < 64) {
                    this.f26311v.m10535g(i4 + 64);
                } else {
                    ByteVector2 byteVector24 = this.f26311v;
                    byteVector24.m10535g(247);
                    byteVector24.m10538j(i4);
                }
                m10618x(objArr2[0]);
            } else if (i4 < 64) {
                this.f26311v.m10535g(i4);
            } else {
                ByteVector2 byteVector25 = this.f26311v;
                byteVector25.m10535g(251);
                byteVector25.m10538j(i4);
            }
            this.f26285U = this.f26301l.f26154b;
            this.f26310u++;
        }
        if (this.f26278N == 2) {
            this.f26282R = i3;
            for (int i20 = 0; i20 < i3; i20++) {
                if (objArr2[i20] == Opcodes2.f26337e || objArr2[i20] == Opcodes2.f26336d) {
                    this.f26282R++;
                }
            }
            int i21 = this.f26282R;
            if (i21 > this.f26283S) {
                this.f26283S = i21;
            }
        }
        this.f26299j = Math.max(this.f26299j, i3);
        this.f26300k = Math.max(this.f26300k, this.f26284T);
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: d */
    public void mo10596d(int i, int i2) {
        int i3;
        int i4;
        ByteVector2 byteVector2 = this.f26301l;
        this.f26290Z = byteVector2.f26154b;
        if (i > 255 || i2 > 127 || i2 < -128) {
            byteVector2.m10535g(196);
            byteVector2.m10533e(Opcodes.IINC, i);
            byteVector2.m10538j(i2);
        } else {
            byteVector2.m10535g(Opcodes.IINC);
            byteVector2.m10531c(i, i2);
        }
        Label2 label2 = this.f26281Q;
        if (label2 != null && ((i4 = this.f26278N) == 4 || i4 == 3)) {
            label2.f26258k.mo10569b(Opcodes.IINC, i, null, null);
        }
        if (this.f26278N == 0 || (i3 = i + 1) <= this.f26300k) {
            return;
        }
        this.f26300k = i3;
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: e */
    public void mo10597e(int i) {
        ByteVector2 byteVector2 = this.f26301l;
        this.f26290Z = byteVector2.f26154b;
        byteVector2.m10535g(i);
        Label2 label2 = this.f26281Q;
        if (label2 != null) {
            int i2 = this.f26278N;
            if (i2 == 4 || i2 == 3) {
                label2.f26258k.mo10569b(i, 0, null, null);
            } else {
                int i3 = this.f26282R + f26264c[i];
                if (i3 > this.f26283S) {
                    this.f26283S = i3;
                }
                this.f26282R = i3;
            }
            if ((i < 172 || i > 177) && i != 191) {
                return;
            }
            m10616v();
        }
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: f */
    public AnnotationWriter2 mo10598f(int i, TypePath2 typePath2, String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        C3404f.m4256W0((i & (-16776961)) | (this.f26290Z << 8), byteVector2);
        TypePath2.m10655a(typePath2, byteVector2);
        byteVector2.m10538j(this.f26293d.m10637l(str));
        byteVector2.m10538j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.f26293d, true, byteVector2, this.f26312w);
            this.f26312w = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter22 = new AnnotationWriter2(this.f26293d, true, byteVector2, this.f26313x);
        this.f26313x = annotationWriter22;
        return annotationWriter22;
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: g */
    public void mo10599g(int i, int i2) {
        ByteVector2 byteVector2 = this.f26301l;
        this.f26290Z = byteVector2.f26154b;
        if (i == 17) {
            byteVector2.m10533e(i, i2);
        } else {
            byteVector2.m10531c(i, i2);
        }
        Label2 label2 = this.f26281Q;
        if (label2 != null) {
            int i3 = this.f26278N;
            if (i3 == 4 || i3 == 3) {
                label2.f26258k.mo10569b(i, i2, null, null);
            } else if (i != 188) {
                int i4 = this.f26282R + 1;
                if (i4 > this.f26283S) {
                    this.f26283S = i4;
                }
                this.f26282R = i4;
            }
        }
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: h */
    public void mo10600h(int i, Label2 label2) {
        boolean z2;
        ByteVector2 byteVector2 = this.f26301l;
        int i2 = byteVector2.f26154b;
        this.f26290Z = i2;
        int i3 = i >= 200 ? i - 33 : i;
        if ((label2.f26249b & 4) == 0 || label2.f26252e - i2 >= -32768) {
            if (i3 != i) {
                byteVector2.m10535g(i);
                ByteVector2 byteVector22 = this.f26301l;
                label2.m10591e(byteVector22, byteVector22.f26154b - 1, true);
            } else {
                byteVector2.m10535g(i3);
                ByteVector2 byteVector23 = this.f26301l;
                label2.m10591e(byteVector23, byteVector23.f26154b - 1, false);
            }
            z2 = false;
        } else {
            if (i3 == 167) {
                byteVector2.m10535g(200);
            } else if (i3 == 168) {
                byteVector2.m10535g(201);
            } else {
                byteVector2.m10535g(i3 >= 198 ? i3 ^ 1 : ((i3 + 1) ^ 1) - 1);
                this.f26301l.m10538j(8);
                this.f26301l.m10535g(220);
                this.f26289Y = true;
                z2 = true;
                ByteVector2 byteVector24 = this.f26301l;
                label2.m10591e(byteVector24, byteVector24.f26154b - 1, true);
            }
            z2 = false;
            ByteVector2 byteVector242 = this.f26301l;
            label2.m10591e(byteVector242, byteVector242.f26154b - 1, true);
        }
        Label2 label22 = this.f26281Q;
        if (label22 != null) {
            int i4 = this.f26278N;
            Label2 label23 = null;
            if (i4 == 4) {
                label22.f26258k.mo10569b(i3, 0, null, null);
                Label2 label2M10588b = label2.m10588b();
                label2M10588b.f26249b = (short) (label2M10588b.f26249b | 2);
                m10615u(0, label2);
                if (i3 != 167) {
                    label23 = new Label2();
                }
            } else if (i4 == 3) {
                label22.f26258k.mo10569b(i3, 0, null, null);
            } else if (i4 == 2) {
                this.f26282R += f26264c[i3];
            } else if (i3 == 168) {
                short s2 = label2.f26249b;
                if ((s2 & 32) == 0) {
                    label2.f26249b = (short) (s2 | 32);
                    this.f26288X = true;
                }
                label22.f26249b = (short) (label22.f26249b | 16);
                m10615u(this.f26282R + 1, label2);
                label23 = new Label2();
            } else {
                int i5 = this.f26282R + f26264c[i3];
                this.f26282R = i5;
                m10615u(i5, label2);
            }
            if (label23 != null) {
                if (z2) {
                    label23.f26249b = (short) (label23.f26249b | 2);
                }
                mo10601i(label23);
            }
            if (i3 == 167) {
                m10616v();
            }
        }
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: i */
    public void mo10601i(Label2 label2) {
        boolean z2 = this.f26289Y;
        ByteVector2 byteVector2 = this.f26301l;
        this.f26289Y = z2 | label2.m10592f(byteVector2.f26153a, byteVector2.f26154b);
        short s2 = label2.f26249b;
        if ((s2 & 1) != 0) {
            return;
        }
        int i = this.f26278N;
        if (i == 4) {
            Label2 label22 = this.f26281Q;
            if (label22 != null) {
                if (label2.f26252e == label22.f26252e) {
                    label22.f26249b = (short) ((s2 & 2) | label22.f26249b);
                    label2.f26258k = label22.f26258k;
                    return;
                }
                m10615u(0, label2);
            }
            Label2 label23 = this.f26280P;
            if (label23 != null) {
                if (label2.f26252e == label23.f26252e) {
                    label23.f26249b = (short) (label23.f26249b | (label2.f26249b & 2));
                    label2.f26258k = label23.f26258k;
                    this.f26281Q = label23;
                    return;
                }
                label23.f26259l = label2;
            }
            this.f26280P = label2;
            this.f26281Q = label2;
            label2.f26258k = new Frame3(label2);
            return;
        }
        if (i == 3) {
            Label2 label24 = this.f26281Q;
            if (label24 == null) {
                this.f26281Q = label2;
                return;
            } else {
                label24.f26258k.f26228a = label2;
                return;
            }
        }
        if (i != 1) {
            if (i == 2 && this.f26281Q == null) {
                this.f26281Q = label2;
                return;
            }
            return;
        }
        Label2 label25 = this.f26281Q;
        if (label25 != null) {
            label25.f26256i = (short) this.f26283S;
            m10615u(this.f26282R, label2);
        }
        this.f26281Q = label2;
        this.f26282R = 0;
        this.f26283S = 0;
        Label2 label26 = this.f26280P;
        if (label26 != null) {
            label26.f26259l = label2;
        }
        this.f26280P = label2;
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: j */
    public void mo10602j(Object obj) {
        char cCharAt;
        this.f26290Z = this.f26301l.f26154b;
        Symbol2 symbol2M10627b = this.f26293d.m10627b(obj);
        int i = symbol2M10627b.f26340a;
        int i2 = symbol2M10627b.f26341b;
        boolean z2 = i2 == 5 || i2 == 6 || (i2 == 17 && ((cCharAt = symbol2M10627b.f26344e.charAt(0)) == 'J' || cCharAt == 'D'));
        if (z2) {
            this.f26301l.m10533e(20, i);
        } else if (i >= 256) {
            this.f26301l.m10533e(19, i);
        } else {
            this.f26301l.m10531c(18, i);
        }
        Label2 label2 = this.f26281Q;
        if (label2 != null) {
            int i3 = this.f26278N;
            if (i3 == 4 || i3 == 3) {
                label2.f26258k.mo10569b(18, 0, symbol2M10627b, this.f26293d);
                return;
            }
            int i4 = this.f26282R + (z2 ? 2 : 1);
            if (i4 > this.f26283S) {
                this.f26283S = i4;
            }
            this.f26282R = i4;
        }
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: k */
    public void mo10603k(int i, Label2 label2) {
        if (this.f26305p == null) {
            this.f26305p = new ByteVector2();
        }
        this.f26304o++;
        this.f26305p.m10538j(label2.f26252e);
        this.f26305p.m10538j(i);
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: l */
    public void mo10604l(String str, String str2, String str3, Label2 label2, Label2 label22, int i) {
        if (str3 != null) {
            if (this.f26309t == null) {
                this.f26309t = new ByteVector2();
            }
            this.f26308s++;
            ByteVector2 byteVector2 = this.f26309t;
            byteVector2.m10538j(label2.f26252e);
            byteVector2.m10538j(label22.f26252e - label2.f26252e);
            byteVector2.m10538j(this.f26293d.m10637l(str));
            byteVector2.m10538j(this.f26293d.m10637l(str3));
            byteVector2.m10538j(i);
        }
        if (this.f26307r == null) {
            this.f26307r = new ByteVector2();
        }
        this.f26306q++;
        ByteVector2 byteVector22 = this.f26307r;
        byteVector22.m10538j(label2.f26252e);
        byteVector22.m10538j(label22.f26252e - label2.f26252e);
        byteVector22.m10538j(this.f26293d.m10637l(str));
        byteVector22.m10538j(this.f26293d.m10637l(str2));
        byteVector22.m10538j(i);
        if (this.f26278N != 0) {
            char cCharAt = str2.charAt(0);
            int i2 = i + ((cCharAt == 'J' || cCharAt == 'D') ? 2 : 1);
            if (i2 > this.f26300k) {
                this.f26300k = i2;
            }
        }
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: m */
    public AnnotationWriter2 mo10605m(int i, TypePath2 typePath2, Label2[] label2Arr, Label2[] label2Arr2, int[] iArr, String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        byteVector2.m10535g(i >>> 24);
        byteVector2.m10538j(label2Arr.length);
        for (int i2 = 0; i2 < label2Arr.length; i2++) {
            byteVector2.m10538j(label2Arr[i2].f26252e);
            byteVector2.m10538j(label2Arr2[i2].f26252e - label2Arr[i2].f26252e);
            byteVector2.m10538j(iArr[i2]);
        }
        TypePath2.m10655a(typePath2, byteVector2);
        byteVector2.m10538j(this.f26293d.m10637l(str));
        byteVector2.m10538j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.f26293d, true, byteVector2, this.f26312w);
            this.f26312w = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter22 = new AnnotationWriter2(this.f26293d, true, byteVector2, this.f26313x);
        this.f26313x = annotationWriter22;
        return annotationWriter22;
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: n */
    public void mo10606n(int i, int i2) {
        int i3 = this.f26278N;
        if (i3 == 4) {
            Handler5 handler5 = this.f26302m;
            while (true) {
                if (handler5 == null) {
                    break;
                }
                String str = handler5.f26246e;
                int iM10639n = 33554432 | this.f26293d.m10639n(str != null ? str : "java/lang/Throwable");
                Label2 label2M10588b = handler5.f26244c.m10588b();
                label2M10588b.f26249b = (short) (label2M10588b.f26249b | 2);
                Label2 label2M10588b2 = handler5.f26243b.m10588b();
                for (Label2 label2M10588b3 = handler5.f26242a.m10588b(); label2M10588b3 != label2M10588b2; label2M10588b3 = label2M10588b3.f26259l) {
                    label2M10588b3.f26260m = new Edge2(iM10639n, label2M10588b, label2M10588b3.f26260m);
                }
                handler5 = handler5.f26247f;
            }
            Frame3 frame3 = this.f26279O.f26258k;
            frame3.m10584n(this.f26293d, this.f26294e, this.f26298i, this.f26300k);
            frame3.m10575a(this);
            Label2 label2 = this.f26279O;
            label2.f26261n = Label2.f26248a;
            int iMax = 0;
            while (label2 != Label2.f26248a) {
                Label2 label22 = label2.f26261n;
                label2.f26261n = null;
                label2.f26249b = (short) (label2.f26249b | 8);
                int length = label2.f26258k.f26230c.length + label2.f26256i;
                if (length > iMax) {
                    iMax = length;
                }
                for (Edge2 edge2 = label2.f26260m; edge2 != null; edge2 = edge2.f26215c) {
                    Label2 label2M10588b4 = edge2.f26214b.m10588b();
                    if (label2.f26258k.m10578h(this.f26293d, label2M10588b4.f26258k, edge2.f26213a) && label2M10588b4.f26261n == null) {
                        label2M10588b4.f26261n = label22;
                        label22 = label2M10588b4;
                    }
                }
                label2 = label22;
            }
            for (Label2 label23 = this.f26279O; label23 != null; label23 = label23.f26259l) {
                if ((label23.f26249b & 10) == 10) {
                    label23.f26258k.m10575a(this);
                }
                if ((label23.f26249b & 8) == 0) {
                    Label2 label24 = label23.f26259l;
                    int i4 = label23.f26252e;
                    int i5 = (label24 == null ? this.f26301l.f26154b : label24.f26252e) - 1;
                    if (i5 >= i4) {
                        for (int i6 = i4; i6 < i5; i6++) {
                            this.f26301l.f26153a[i6] = 0;
                        }
                        this.f26301l.f26153a[i5] = -65;
                        m10613A(i4, 0, 1);
                        this.f26287W[3] = this.f26293d.m10639n("java/lang/Throwable") | 33554432;
                        m10620z();
                        this.f26302m = Handler5.m10586a(this.f26302m, label23, label24);
                        iMax = Math.max(iMax, 1);
                    }
                }
            }
            this.f26299j = iMax;
            return;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                this.f26299j = this.f26283S;
                return;
            } else {
                this.f26299j = i;
                this.f26300k = i2;
                return;
            }
        }
        for (Handler5 handler52 = this.f26302m; handler52 != null; handler52 = handler52.f26247f) {
            Label2 label25 = handler52.f26244c;
            Label2 label26 = handler52.f26243b;
            for (Label2 label27 = handler52.f26242a; label27 != label26; label27 = label27.f26259l) {
                if ((label27.f26249b & 16) == 0) {
                    label27.f26260m = new Edge2(Integer.MAX_VALUE, label25, label27.f26260m);
                } else {
                    Edge2 edge22 = label27.f26260m.f26215c;
                    edge22.f26215c = new Edge2(Integer.MAX_VALUE, label25, edge22.f26215c);
                }
            }
        }
        if (this.f26288X) {
            this.f26279O.m10589c((short) 1);
            short s2 = 1;
            for (short s3 = 1; s3 <= s2; s3 = (short) (s3 + 1)) {
                for (Label2 label28 = this.f26279O; label28 != null; label28 = label28.f26259l) {
                    if ((label28.f26249b & 16) != 0 && label28.f26257j == s3) {
                        Label2 label29 = label28.f26260m.f26215c.f26214b;
                        if (label29.f26257j == 0) {
                            s2 = (short) (s2 + 1);
                            label29.m10589c(s2);
                        }
                    }
                }
            }
            for (Label2 label210 = this.f26279O; label210 != null; label210 = label210.f26259l) {
                if ((label210.f26249b & 16) != 0) {
                    Label2 label2M10590d = label210.f26260m.f26215c.f26214b;
                    Label2 label211 = Label2.f26248a;
                    label2M10590d.f26261n = label211;
                    while (label2M10590d != Label2.f26248a) {
                        Label2 label212 = label2M10590d.f26261n;
                        label2M10590d.f26261n = label211;
                        if ((label2M10590d.f26249b & 64) != 0 && label2M10590d.f26257j != label210.f26257j) {
                            label2M10590d.f26260m = new Edge2(label2M10590d.f26255h, label210.f26260m.f26214b, label2M10590d.f26260m);
                        }
                        label211 = label2M10590d;
                        label2M10590d = label2M10590d.m10590d(label212);
                    }
                    while (label211 != Label2.f26248a) {
                        Label2 label213 = label211.f26261n;
                        label211.f26261n = null;
                        label211 = label213;
                    }
                }
            }
        }
        Label2 label214 = this.f26279O;
        label214.f26261n = Label2.f26248a;
        int i7 = this.f26299j;
        while (label214 != Label2.f26248a) {
            Label2 label215 = label214.f26261n;
            short s4 = label214.f26254g;
            int i8 = label214.f26256i + s4;
            if (i8 > i7) {
                i7 = i8;
            }
            Edge2 edge23 = label214.f26260m;
            if ((label214.f26249b & 16) != 0) {
                edge23 = edge23.f26215c;
            }
            label214 = label215;
            while (edge23 != null) {
                Label2 label216 = edge23.f26214b;
                if (label216.f26261n == null) {
                    int i9 = edge23.f26213a;
                    label216.f26254g = (short) (i9 == Integer.MAX_VALUE ? 1 : i9 + s4);
                    label216.f26261n = label214;
                    label214 = label216;
                }
                edge23 = edge23.f26215c;
            }
        }
        this.f26299j = i7;
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: p */
    public void mo10608p(int i, String str, String str2, String str3, boolean z2) {
        this.f26290Z = this.f26301l.f26154b;
        SymbolTable2.a aVarM10633h = this.f26293d.m10633h(z2 ? 11 : 10, str, str2, str3);
        if (i == 185) {
            ByteVector2 byteVector2 = this.f26301l;
            byteVector2.m10533e(Opcodes.INVOKEINTERFACE, aVarM10633h.f26340a);
            byteVector2.m10531c(aVarM10633h.m10621a() >> 2, 0);
        } else {
            this.f26301l.m10533e(i, aVarM10633h.f26340a);
        }
        Label2 label2 = this.f26281Q;
        if (label2 != null) {
            int i2 = this.f26278N;
            if (i2 == 4 || i2 == 3) {
                label2.f26258k.mo10569b(i, 0, aVarM10633h, this.f26293d);
                return;
            }
            int iM10621a = aVarM10633h.m10621a();
            int i3 = (iM10621a & 3) - (iM10621a >> 2);
            int i4 = i == 184 ? this.f26282R + i3 + 1 : this.f26282R + i3;
            if (i4 > this.f26283S) {
                this.f26283S = i4;
            }
            this.f26282R = i4;
        }
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: q */
    public void mo10609q(int i, int i2, Label2 label2, Label2... label2Arr) {
        ByteVector2 byteVector2 = this.f26301l;
        this.f26290Z = byteVector2.f26154b;
        byteVector2.m10535g(Opcodes.TABLESWITCH);
        byteVector2.m10536h(null, 0, (4 - (this.f26301l.f26154b % 4)) % 4);
        label2.m10591e(this.f26301l, this.f26290Z, true);
        ByteVector2 byteVector22 = this.f26301l;
        byteVector22.m10537i(i);
        byteVector22.m10537i(i2);
        for (Label2 label22 : label2Arr) {
            label22.m10591e(this.f26301l, this.f26290Z, true);
        }
        m10614B(label2, label2Arr);
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: r */
    public AnnotationWriter2 mo10610r(int i, TypePath2 typePath2, String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        C3404f.m4256W0(i, byteVector2);
        TypePath2.m10655a(typePath2, byteVector2);
        byteVector2.m10538j(this.f26293d.m10637l(str));
        byteVector2.m10538j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.f26293d, true, byteVector2, this.f26272H);
            this.f26272H = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter22 = new AnnotationWriter2(this.f26293d, true, byteVector2, this.f26273I);
        this.f26273I = annotationWriter22;
        return annotationWriter22;
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: s */
    public void mo10611s(int i, String str) {
        this.f26290Z = this.f26301l.f26154b;
        Symbol2 symbol2M10638m = this.f26293d.m10638m(7, str);
        this.f26301l.m10533e(i, symbol2M10638m.f26340a);
        Label2 label2 = this.f26281Q;
        if (label2 != null) {
            int i2 = this.f26278N;
            if (i2 == 4 || i2 == 3) {
                label2.f26258k.mo10569b(i, this.f26290Z, symbol2M10638m, this.f26293d);
            } else if (i == 187) {
                int i3 = this.f26282R + 1;
                if (i3 > this.f26283S) {
                    this.f26283S = i3;
                }
                this.f26282R = i3;
            }
        }
    }

    @Override // p617h0.p618a.p619a.MethodVisitor2
    /* renamed from: t */
    public void mo10612t(int i, int i2) {
        ByteVector2 byteVector2 = this.f26301l;
        this.f26290Z = byteVector2.f26154b;
        if (i2 < 4 && i != 169) {
            byteVector2.m10535g((i < 54 ? ((i - 21) << 2) + 26 : ((i - 54) << 2) + 59) + i2);
        } else if (i2 >= 256) {
            byteVector2.m10535g(196);
            byteVector2.m10533e(i, i2);
        } else {
            byteVector2.m10531c(i, i2);
        }
        Label2 label2 = this.f26281Q;
        if (label2 != null) {
            int i3 = this.f26278N;
            if (i3 == 4 || i3 == 3) {
                label2.f26258k.mo10569b(i, i2, null, null);
            } else if (i == 169) {
                label2.f26249b = (short) (label2.f26249b | 64);
                label2.f26255h = (short) this.f26282R;
                m10616v();
            } else {
                int i4 = this.f26282R + f26264c[i];
                if (i4 > this.f26283S) {
                    this.f26283S = i4;
                }
                this.f26282R = i4;
            }
        }
        int i5 = this.f26278N;
        if (i5 != 0) {
            int i6 = (i == 22 || i == 24 || i == 55 || i == 57) ? i2 + 2 : i2 + 1;
            if (i6 > this.f26300k) {
                this.f26300k = i6;
            }
        }
        if (i < 54 || i5 != 4 || this.f26302m == null) {
            return;
        }
        mo10601i(new Label2());
    }

    /* renamed from: u */
    public final void m10615u(int i, Label2 label2) {
        Label2 label22 = this.f26281Q;
        label22.f26260m = new Edge2(i, label2, label22.f26260m);
    }

    /* renamed from: v */
    public final void m10616v() {
        int i = this.f26278N;
        if (i != 4) {
            if (i == 1) {
                this.f26281Q.f26256i = (short) this.f26283S;
                this.f26281Q = null;
                return;
            }
            return;
        }
        Label2 label2 = new Label2();
        label2.f26258k = new Frame3(label2);
        ByteVector2 byteVector2 = this.f26301l;
        label2.m10592f(byteVector2.f26153a, byteVector2.f26154b);
        this.f26280P.f26259l = label2;
        this.f26280P = label2;
        this.f26281Q = null;
    }

    /* renamed from: w */
    public final void m10617w(int i, int i2) {
        while (i < i2) {
            SymbolTable2 symbolTable2 = this.f26293d;
            int i3 = this.f26287W[i];
            ByteVector2 byteVector2 = this.f26311v;
            int i4 = ((-268435456) & i3) >> 28;
            if (i4 == 0) {
                int i5 = i3 & 1048575;
                int i6 = i3 & 251658240;
                if (i6 == 16777216) {
                    byteVector2.m10535g(i5);
                } else if (i6 == 33554432) {
                    byteVector2.m10535g(7);
                    byteVector2.m10538j(symbolTable2.m10628c(symbolTable2.f26358l[i5].f26344e).f26340a);
                } else {
                    if (i6 != 50331648) {
                        throw new AssertionError();
                    }
                    byteVector2.m10535g(8);
                    byteVector2.m10538j((int) symbolTable2.f26358l[i5].f26345f);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i7 = i4 - 1;
                    if (i4 > 0) {
                        sb.append('[');
                        i4 = i7;
                    } else {
                        if ((i3 & 251658240) == 33554432) {
                            sb.append('L');
                            sb.append(symbolTable2.f26358l[i3 & 1048575].f26344e);
                            sb.append(';');
                        } else {
                            int i8 = i3 & 1048575;
                            if (i8 == 1) {
                                sb.append('I');
                            } else if (i8 == 2) {
                                sb.append('F');
                            } else if (i8 == 3) {
                                sb.append('D');
                            } else if (i8 != 4) {
                                switch (i8) {
                                    case 9:
                                        sb.append('Z');
                                        break;
                                    case 10:
                                        sb.append('B');
                                        break;
                                    case 11:
                                        sb.append('C');
                                        break;
                                    case 12:
                                        sb.append('S');
                                        break;
                                    default:
                                        throw new AssertionError();
                                }
                            } else {
                                sb.append('J');
                            }
                        }
                        byteVector2.m10535g(7);
                        byteVector2.m10538j(symbolTable2.m10628c(sb.toString()).f26340a);
                    }
                }
            }
            i++;
        }
    }

    /* renamed from: x */
    public final void m10618x(Object obj) {
        if (obj instanceof Integer) {
            this.f26311v.m10535g(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof String) {
            ByteVector2 byteVector2 = this.f26311v;
            byteVector2.m10535g(7);
            byteVector2.m10538j(this.f26293d.m10628c((String) obj).f26340a);
        } else {
            ByteVector2 byteVector22 = this.f26311v;
            byteVector22.m10535g(8);
            byteVector22.m10538j(((Label2) obj).f26252e);
        }
    }

    /* renamed from: y */
    public void m10619y(ByteVector2 byteVector2) {
        int i;
        boolean z2 = this.f26293d.f26349c < 49;
        byteVector2.m10538j((~(z2 ? 4096 : 0)) & this.f26294e);
        byteVector2.m10538j(this.f26295f);
        byteVector2.m10538j(this.f26297h);
        int i2 = this.f26291a0;
        if (i2 != 0) {
            byteVector2.m10536h(this.f26293d.f26348b.f26155a, i2, this.f26292b0);
            return;
        }
        int iM10525c = this.f26301l.f26154b > 0 ? 1 : 0;
        if (this.f26314y > 0) {
            iM10525c++;
        }
        int i3 = this.f26294e;
        if ((i3 & 4096) != 0 && z2) {
            iM10525c++;
        }
        if (this.f26265A != 0) {
            iM10525c++;
        }
        if ((i3 & 131072) != 0) {
            iM10525c++;
        }
        if (this.f26266B != null) {
            iM10525c++;
        }
        if (this.f26267C != null) {
            iM10525c++;
        }
        if (this.f26269E != null) {
            iM10525c++;
        }
        if (this.f26271G != null) {
            iM10525c++;
        }
        if (this.f26272H != null) {
            iM10525c++;
        }
        if (this.f26273I != null) {
            iM10525c++;
        }
        if (this.f26274J != null) {
            iM10525c++;
        }
        if (this.f26276L != null) {
            iM10525c++;
        }
        Attribute2 attribute2 = this.f26277M;
        if (attribute2 != null) {
            iM10525c += attribute2.m10525c();
        }
        byteVector2.m10538j(iM10525c);
        int i4 = this.f26301l.f26154b;
        if (i4 > 0) {
            int i5 = i4 + 10;
            int i6 = 0;
            for (Handler5 handler5 = this.f26302m; handler5 != null; handler5 = handler5.f26247f) {
                i6++;
            }
            int iM10518a = (i6 * 8) + 2 + i5;
            ByteVector2 byteVector22 = this.f26311v;
            if (byteVector22 != null) {
                iM10518a += byteVector22.f26154b + 8;
                i = 1;
            } else {
                i = 0;
            }
            ByteVector2 byteVector23 = this.f26305p;
            if (byteVector23 != null) {
                iM10518a += byteVector23.f26154b + 8;
                i++;
            }
            ByteVector2 byteVector24 = this.f26307r;
            if (byteVector24 != null) {
                iM10518a += byteVector24.f26154b + 8;
                i++;
            }
            ByteVector2 byteVector25 = this.f26309t;
            if (byteVector25 != null) {
                iM10518a += byteVector25.f26154b + 8;
                i++;
            }
            AnnotationWriter2 annotationWriter2 = this.f26312w;
            if (annotationWriter2 != null) {
                iM10518a += annotationWriter2.m10518a("RuntimeVisibleTypeAnnotations");
                i++;
            }
            AnnotationWriter2 annotationWriter22 = this.f26313x;
            if (annotationWriter22 != null) {
                iM10518a += annotationWriter22.m10518a("RuntimeInvisibleTypeAnnotations");
                i++;
            }
            outline.m878t0(this.f26293d, "Code", byteVector2, iM10518a);
            byteVector2.m10538j(this.f26299j);
            byteVector2.m10538j(this.f26300k);
            byteVector2.m10537i(this.f26301l.f26154b);
            ByteVector2 byteVector26 = this.f26301l;
            byteVector2.m10536h(byteVector26.f26153a, 0, byteVector26.f26154b);
            Handler5 handler52 = this.f26302m;
            int i7 = 0;
            for (Handler5 handler53 = handler52; handler53 != null; handler53 = handler53.f26247f) {
                i7++;
            }
            byteVector2.m10538j(i7);
            while (handler52 != null) {
                byteVector2.m10538j(handler52.f26242a.f26252e);
                byteVector2.m10538j(handler52.f26243b.f26252e);
                byteVector2.m10538j(handler52.f26244c.f26252e);
                byteVector2.m10538j(handler52.f26245d);
                handler52 = handler52.f26247f;
            }
            byteVector2.m10538j(i);
            if (this.f26311v != null) {
                SymbolTable2 symbolTable2 = this.f26293d;
                byteVector2.m10538j(symbolTable2.m10637l(symbolTable2.f26349c >= 50 ? "StackMapTable" : "StackMap"));
                byteVector2.m10537i(this.f26311v.f26154b + 2);
                byteVector2.m10538j(this.f26310u);
                ByteVector2 byteVector27 = this.f26311v;
                byteVector2.m10536h(byteVector27.f26153a, 0, byteVector27.f26154b);
            }
            if (this.f26305p != null) {
                byteVector2.m10538j(this.f26293d.m10637l("LineNumberTable"));
                byteVector2.m10537i(this.f26305p.f26154b + 2);
                byteVector2.m10538j(this.f26304o);
                ByteVector2 byteVector28 = this.f26305p;
                byteVector2.m10536h(byteVector28.f26153a, 0, byteVector28.f26154b);
            }
            if (this.f26307r != null) {
                byteVector2.m10538j(this.f26293d.m10637l("LocalVariableTable"));
                byteVector2.m10537i(this.f26307r.f26154b + 2);
                byteVector2.m10538j(this.f26306q);
                ByteVector2 byteVector29 = this.f26307r;
                byteVector2.m10536h(byteVector29.f26153a, 0, byteVector29.f26154b);
            }
            if (this.f26309t != null) {
                byteVector2.m10538j(this.f26293d.m10637l("LocalVariableTypeTable"));
                byteVector2.m10537i(this.f26309t.f26154b + 2);
                byteVector2.m10538j(this.f26308s);
                ByteVector2 byteVector210 = this.f26309t;
                byteVector2.m10536h(byteVector210.f26153a, 0, byteVector210.f26154b);
            }
            AnnotationWriter2 annotationWriter23 = this.f26312w;
            if (annotationWriter23 != null) {
                annotationWriter23.m10519c(this.f26293d.m10637l("RuntimeVisibleTypeAnnotations"), byteVector2);
            }
            AnnotationWriter2 annotationWriter24 = this.f26313x;
            if (annotationWriter24 != null) {
                annotationWriter24.m10519c(this.f26293d.m10637l("RuntimeInvisibleTypeAnnotations"), byteVector2);
            }
        }
        if (this.f26314y > 0) {
            byteVector2.m10538j(this.f26293d.m10637l("Exceptions"));
            byteVector2.m10537i((this.f26314y * 2) + 2);
            byteVector2.m10538j(this.f26314y);
            for (int i8 : this.f26315z) {
                byteVector2.m10538j(i8);
            }
        }
        if ((4096 & this.f26294e) != 0 && z2) {
            outline.m878t0(this.f26293d, "Synthetic", byteVector2, 0);
        }
        if (this.f26265A != 0) {
            outline.m878t0(this.f26293d, "Signature", byteVector2, 2);
            byteVector2.m10538j(this.f26265A);
        }
        if ((this.f26294e & 131072) != 0) {
            outline.m878t0(this.f26293d, "Deprecated", byteVector2, 0);
        }
        AnnotationWriter2 annotationWriter25 = this.f26266B;
        if (annotationWriter25 != null) {
            annotationWriter25.m10519c(this.f26293d.m10637l("RuntimeVisibleAnnotations"), byteVector2);
        }
        AnnotationWriter2 annotationWriter26 = this.f26267C;
        if (annotationWriter26 != null) {
            annotationWriter26.m10519c(this.f26293d.m10637l("RuntimeInvisibleAnnotations"), byteVector2);
        }
        if (this.f26269E != null) {
            int iM10637l = this.f26293d.m10637l("RuntimeVisibleParameterAnnotations");
            AnnotationWriter2[] annotationWriter2Arr = this.f26269E;
            int length = this.f26268D;
            if (length == 0) {
                length = annotationWriter2Arr.length;
            }
            AnnotationWriter2.m10517d(iM10637l, annotationWriter2Arr, length, byteVector2);
        }
        if (this.f26271G != null) {
            int iM10637l2 = this.f26293d.m10637l("RuntimeInvisibleParameterAnnotations");
            AnnotationWriter2[] annotationWriter2Arr2 = this.f26271G;
            int length2 = this.f26270F;
            if (length2 == 0) {
                length2 = annotationWriter2Arr2.length;
            }
            AnnotationWriter2.m10517d(iM10637l2, annotationWriter2Arr2, length2, byteVector2);
        }
        AnnotationWriter2 annotationWriter27 = this.f26272H;
        if (annotationWriter27 != null) {
            annotationWriter27.m10519c(this.f26293d.m10637l("RuntimeVisibleTypeAnnotations"), byteVector2);
        }
        AnnotationWriter2 annotationWriter28 = this.f26273I;
        if (annotationWriter28 != null) {
            annotationWriter28.m10519c(this.f26293d.m10637l("RuntimeInvisibleTypeAnnotations"), byteVector2);
        }
        if (this.f26274J != null) {
            byteVector2.m10538j(this.f26293d.m10637l("AnnotationDefault"));
            byteVector2.m10537i(this.f26274J.f26154b);
            ByteVector2 byteVector211 = this.f26274J;
            byteVector2.m10536h(byteVector211.f26153a, 0, byteVector211.f26154b);
        }
        if (this.f26276L != null) {
            byteVector2.m10538j(this.f26293d.m10637l("MethodParameters"));
            byteVector2.m10537i(this.f26276L.f26154b + 1);
            byteVector2.m10535g(this.f26275K);
            ByteVector2 byteVector212 = this.f26276L;
            byteVector2.m10536h(byteVector212.f26153a, 0, byteVector212.f26154b);
        }
        Attribute2 attribute22 = this.f26277M;
        if (attribute22 != null) {
            attribute22.m10526d(this.f26293d, byteVector2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ff  */
    /* renamed from: z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m10620z() {
        char c;
        int[] iArr = this.f26286V;
        if (iArr != null) {
            if (this.f26311v == null) {
                this.f26311v = new ByteVector2();
            }
            int[] iArr2 = this.f26287W;
            int i = iArr2[1];
            int i2 = iArr2[2];
            int i3 = 0;
            if (this.f26293d.f26349c < 50) {
                ByteVector2 byteVector2 = this.f26311v;
                byteVector2.m10538j(iArr2[0]);
                byteVector2.m10538j(i);
                int i4 = i + 3;
                m10617w(3, i4);
                this.f26311v.m10538j(i2);
                m10617w(i4, i2 + i4);
            } else {
                int i5 = this.f26310u == 0 ? iArr2[0] : (iArr2[0] - iArr[0]) - 1;
                int i6 = iArr[1];
                int i7 = i - i6;
                if (i2 == 0) {
                    switch (i7) {
                        case -3:
                        case -2:
                        case -1:
                            c = 248;
                            break;
                        case 0:
                            c = i5 >= 64 ? (char) 251 : (char) 0;
                            break;
                        case 1:
                        case 2:
                        case 3:
                            c = 252;
                            break;
                        default:
                            c = 255;
                            break;
                    }
                    if (c != 255) {
                        int i8 = 3;
                        while (true) {
                            if (i3 < i6 && i3 < i) {
                                if (this.f26287W[i8] != this.f26286V[i8]) {
                                    c = 255;
                                } else {
                                    i8++;
                                    i3++;
                                }
                            }
                        }
                    }
                    if (c != 0) {
                        this.f26311v.m10535g(i5);
                    } else if (c == '@') {
                        this.f26311v.m10535g(i5 + 64);
                        m10617w(i + 3, i + 4);
                    } else if (c == 247) {
                        ByteVector2 byteVector22 = this.f26311v;
                        byteVector22.m10535g(247);
                        byteVector22.m10538j(i5);
                        m10617w(i + 3, i + 4);
                    } else if (c == 248) {
                        ByteVector2 byteVector23 = this.f26311v;
                        byteVector23.m10535g(i7 + 251);
                        byteVector23.m10538j(i5);
                    } else if (c == 251) {
                        ByteVector2 byteVector24 = this.f26311v;
                        byteVector24.m10535g(251);
                        byteVector24.m10538j(i5);
                    } else if (c != 252) {
                        ByteVector2 byteVector25 = this.f26311v;
                        byteVector25.m10535g(255);
                        byteVector25.m10538j(i5);
                        byteVector25.m10538j(i);
                        int i9 = i + 3;
                        m10617w(3, i9);
                        this.f26311v.m10538j(i2);
                        m10617w(i9, i2 + i9);
                    } else {
                        ByteVector2 byteVector26 = this.f26311v;
                        byteVector26.m10535g(i7 + 251);
                        byteVector26.m10538j(i5);
                        m10617w(i6 + 3, i + 3);
                    }
                } else {
                    if (i7 == 0 && i2 == 1) {
                        c = i5 < 63 ? MentionUtils.MENTIONS_CHAR : (char) 247;
                    }
                    if (c != 255) {
                    }
                    if (c != 0) {
                    }
                }
            }
            this.f26310u++;
        }
        this.f26286V = this.f26287W;
        this.f26287W = null;
    }
}
