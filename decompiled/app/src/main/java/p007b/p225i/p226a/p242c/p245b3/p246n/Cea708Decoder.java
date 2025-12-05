package p007b.p225i.p226a.p242c.p245b3.p246n;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;
import p007b.p225i.p226a.p242c.p245b3.SubtitleInputBuffer;
import p007b.p225i.p226a.p242c.p259f3.ParsableBitArray;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;

/* compiled from: Cea708Decoder.java */
/* renamed from: b.i.a.c.b3.n.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class Cea708Decoder extends CeaDecoder {

    /* renamed from: g */
    public final ParsableByteArray f5857g = new ParsableByteArray();

    /* renamed from: h */
    public final ParsableBitArray f5858h = new ParsableBitArray();

    /* renamed from: i */
    public int f5859i = -1;

    /* renamed from: j */
    public final int f5860j;

    /* renamed from: k */
    public final b[] f5861k;

    /* renamed from: l */
    public b f5862l;

    /* renamed from: m */
    @Nullable
    public List<Cue> f5863m;

    /* renamed from: n */
    @Nullable
    public List<Cue> f5864n;

    /* renamed from: o */
    @Nullable
    public c f5865o;

    /* renamed from: p */
    public int f5866p;

    /* compiled from: Cea708Decoder.java */
    /* renamed from: b.i.a.c.b3.n.d$a */
    public static final class a {

        /* renamed from: a */
        public final Cue f5867a;

        /* renamed from: b */
        public final int f5868b;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z2, int i4, int i5) {
            boolean z3;
            int i6;
            if (z2) {
                i6 = i4;
                z3 = true;
            } else {
                z3 = false;
                i6 = ViewCompat.MEASURED_STATE_MASK;
            }
            this.f5867a = new Cue(charSequence, alignment, null, null, f, i, i2, f2, i3, Integer.MIN_VALUE, -3.4028235E38f, f3, -3.4028235E38f, z3, i6, Integer.MIN_VALUE, 0.0f, null);
            this.f5868b = i5;
        }
    }

    /* compiled from: Cea708Decoder.java */
    /* renamed from: b.i.a.c.b3.n.d$b */
    public static final class b {

        /* renamed from: a */
        public static final int f5869a = m2651d(2, 2, 2, 0);

        /* renamed from: b */
        public static final int f5870b;

        /* renamed from: c */
        public static final int f5871c;

        /* renamed from: d */
        public static final int[] f5872d;

        /* renamed from: e */
        public static final int[] f5873e;

        /* renamed from: f */
        public static final int[] f5874f;

        /* renamed from: g */
        public static final boolean[] f5875g;

        /* renamed from: h */
        public static final int[] f5876h;

        /* renamed from: i */
        public static final int[] f5877i;

        /* renamed from: j */
        public static final int[] f5878j;

        /* renamed from: k */
        public static final int[] f5879k;

        /* renamed from: A */
        public int f5880A;

        /* renamed from: B */
        public int f5881B;

        /* renamed from: C */
        public int f5882C;

        /* renamed from: D */
        public int f5883D;

        /* renamed from: E */
        public int f5884E;

        /* renamed from: F */
        public int f5885F;

        /* renamed from: G */
        public int f5886G;

        /* renamed from: l */
        public final List<SpannableString> f5887l = new ArrayList();

        /* renamed from: m */
        public final SpannableStringBuilder f5888m = new SpannableStringBuilder();

        /* renamed from: n */
        public boolean f5889n;

        /* renamed from: o */
        public boolean f5890o;

        /* renamed from: p */
        public int f5891p;

        /* renamed from: q */
        public boolean f5892q;

        /* renamed from: r */
        public int f5893r;

        /* renamed from: s */
        public int f5894s;

        /* renamed from: t */
        public int f5895t;

        /* renamed from: u */
        public int f5896u;

        /* renamed from: v */
        public boolean f5897v;

        /* renamed from: w */
        public int f5898w;

        /* renamed from: x */
        public int f5899x;

        /* renamed from: y */
        public int f5900y;

        /* renamed from: z */
        public int f5901z;

        static {
            int iM2651d = m2651d(0, 0, 0, 0);
            f5870b = iM2651d;
            int iM2651d2 = m2651d(0, 0, 0, 3);
            f5871c = iM2651d2;
            f5872d = new int[]{0, 0, 0, 0, 0, 2, 0};
            f5873e = new int[]{0, 0, 0, 0, 0, 0, 2};
            f5874f = new int[]{3, 3, 3, 3, 3, 3, 1};
            f5875g = new boolean[]{false, false, false, true, true, true, false};
            f5876h = new int[]{iM2651d, iM2651d2, iM2651d, iM2651d, iM2651d2, iM2651d, iM2651d};
            f5877i = new int[]{0, 1, 2, 3, 4, 3, 4};
            f5878j = new int[]{0, 0, 0, 0, 0, 3, 3};
            f5879k = new int[]{iM2651d, iM2651d, iM2651d, iM2651d, iM2651d, iM2651d2, iM2651d2};
        }

        public b() {
            m2656f();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int m2651d(int i, int i2, int i3, int i4) {
            int i5;
            AnimatableValueParser.m571t(i, 0, 4);
            AnimatableValueParser.m571t(i2, 0, 4);
            AnimatableValueParser.m571t(i3, 0, 4);
            AnimatableValueParser.m571t(i4, 0, 4);
            if (i4 == 0 || i4 == 1) {
                i5 = 255;
            } else if (i4 == 2) {
                i5 = Opcodes.LAND;
            } else if (i4 == 3) {
                i5 = 0;
            }
            return Color.argb(i5, i > 1 ? 255 : 0, i2 > 1 ? 255 : 0, i3 > 1 ? 255 : 0);
        }

        /* renamed from: a */
        public void m2652a(char c) {
            if (c != '\n') {
                this.f5888m.append(c);
                return;
            }
            this.f5887l.add(m2653b());
            this.f5888m.clear();
            if (this.f5880A != -1) {
                this.f5880A = 0;
            }
            if (this.f5881B != -1) {
                this.f5881B = 0;
            }
            if (this.f5882C != -1) {
                this.f5882C = 0;
            }
            if (this.f5884E != -1) {
                this.f5884E = 0;
            }
            while (true) {
                if ((!this.f5897v || this.f5887l.size() < this.f5896u) && this.f5887l.size() < 15) {
                    return;
                } else {
                    this.f5887l.remove(0);
                }
            }
        }

        /* renamed from: b */
        public SpannableString m2653b() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f5888m);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f5880A != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f5880A, length, 33);
                }
                if (this.f5881B != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f5881B, length, 33);
                }
                if (this.f5882C != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f5883D), this.f5882C, length, 33);
                }
                if (this.f5884E != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f5885F), this.f5884E, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        /* renamed from: c */
        public void m2654c() {
            this.f5887l.clear();
            this.f5888m.clear();
            this.f5880A = -1;
            this.f5881B = -1;
            this.f5882C = -1;
            this.f5884E = -1;
            this.f5886G = 0;
        }

        /* renamed from: e */
        public boolean m2655e() {
            return !this.f5889n || (this.f5887l.isEmpty() && this.f5888m.length() == 0);
        }

        /* renamed from: f */
        public void m2656f() {
            m2654c();
            this.f5889n = false;
            this.f5890o = false;
            this.f5891p = 4;
            this.f5892q = false;
            this.f5893r = 0;
            this.f5894s = 0;
            this.f5895t = 0;
            this.f5896u = 15;
            this.f5897v = true;
            this.f5898w = 0;
            this.f5899x = 0;
            this.f5900y = 0;
            int i = f5870b;
            this.f5901z = i;
            this.f5883D = f5869a;
            this.f5885F = i;
        }

        /* renamed from: g */
        public void m2657g(boolean z2, boolean z3) {
            if (this.f5880A != -1) {
                if (!z2) {
                    this.f5888m.setSpan(new StyleSpan(2), this.f5880A, this.f5888m.length(), 33);
                    this.f5880A = -1;
                }
            } else if (z2) {
                this.f5880A = this.f5888m.length();
            }
            if (this.f5881B == -1) {
                if (z3) {
                    this.f5881B = this.f5888m.length();
                }
            } else {
                if (z3) {
                    return;
                }
                this.f5888m.setSpan(new UnderlineSpan(), this.f5881B, this.f5888m.length(), 33);
                this.f5881B = -1;
            }
        }

        /* renamed from: h */
        public void m2658h(int i, int i2) {
            if (this.f5882C != -1 && this.f5883D != i) {
                this.f5888m.setSpan(new ForegroundColorSpan(this.f5883D), this.f5882C, this.f5888m.length(), 33);
            }
            if (i != f5869a) {
                this.f5882C = this.f5888m.length();
                this.f5883D = i;
            }
            if (this.f5884E != -1 && this.f5885F != i2) {
                this.f5888m.setSpan(new BackgroundColorSpan(this.f5885F), this.f5884E, this.f5888m.length(), 33);
            }
            if (i2 != f5870b) {
                this.f5884E = this.f5888m.length();
                this.f5885F = i2;
            }
        }
    }

    /* compiled from: Cea708Decoder.java */
    /* renamed from: b.i.a.c.b3.n.d$c */
    public static final class c {

        /* renamed from: a */
        public final int f5902a;

        /* renamed from: b */
        public final int f5903b;

        /* renamed from: c */
        public final byte[] f5904c;

        /* renamed from: d */
        public int f5905d = 0;

        public c(int i, int i2) {
            this.f5902a = i;
            this.f5903b = i2;
            this.f5904c = new byte[(i2 * 2) - 1];
        }
    }

    public Cea708Decoder(int i, @Nullable List<byte[]> list) {
        this.f5860j = i == -1 ? 1 : i;
        if (list != null && (list.size() != 1 || list.get(0).length != 1 || list.get(0)[0] != 1)) {
        }
        this.f5861k = new b[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.f5861k[i2] = new b();
        }
        this.f5862l = this.f5861k[0];
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.p246n.CeaDecoder
    /* renamed from: e */
    public Subtitle mo2634e() {
        List<Cue> list = this.f5863m;
        this.f5864n = list;
        Objects.requireNonNull(list);
        return new CeaSubtitle(list);
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.p246n.CeaDecoder
    /* renamed from: f */
    public void mo2635f(SubtitleInputBuffer subtitleInputBuffer) {
        ByteBuffer byteBuffer = subtitleInputBuffer.f19778l;
        Objects.requireNonNull(byteBuffer);
        this.f5857g.m3077C(byteBuffer.array(), byteBuffer.limit());
        while (this.f5857g.m3081a() >= 3) {
            int iM3100t = this.f5857g.m3100t() & 7;
            int i = iM3100t & 3;
            boolean z2 = (iM3100t & 4) == 4;
            byte bM3100t = (byte) this.f5857g.m3100t();
            byte bM3100t2 = (byte) this.f5857g.m3100t();
            if (i == 2 || i == 3) {
                if (z2) {
                    if (i == 3) {
                        m2648j();
                        int i2 = (bM3100t & 192) >> 6;
                        int i3 = this.f5859i;
                        if (i3 != -1 && i2 != (i3 + 1) % 4) {
                            m2650l();
                            Log.w("Cea708Decoder", outline.m853h(71, "Sequence number discontinuity. previous=", this.f5859i, " current=", i2));
                        }
                        this.f5859i = i2;
                        int i4 = bM3100t & 63;
                        if (i4 == 0) {
                            i4 = 64;
                        }
                        c cVar = new c(i2, i4);
                        this.f5865o = cVar;
                        byte[] bArr = cVar.f5904c;
                        int i5 = cVar.f5905d;
                        cVar.f5905d = i5 + 1;
                        bArr[i5] = bM3100t2;
                    } else {
                        AnimatableValueParser.m531j(i == 2);
                        c cVar2 = this.f5865o;
                        if (cVar2 == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = cVar2.f5904c;
                            int i6 = cVar2.f5905d;
                            int i7 = i6 + 1;
                            cVar2.f5905d = i7;
                            bArr2[i6] = bM3100t;
                            cVar2.f5905d = i7 + 1;
                            bArr2[i7] = bM3100t2;
                        }
                    }
                    if (this.f5865o.f5905d == (r8.f5903b * 2) - 1) {
                        m2648j();
                    }
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.p246n.CeaDecoder, p007b.p225i.p226a.p242c.p265v2.Decoder
    public void flush() {
        super.flush();
        this.f5863m = null;
        this.f5864n = null;
        this.f5866p = 0;
        this.f5862l = this.f5861k[0];
        m2650l();
        this.f5865o = null;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.p246n.CeaDecoder
    /* renamed from: h */
    public boolean mo2637h() {
        return this.f5863m != this.f5864n;
    }

    /* renamed from: j */
    public final void m2648j() {
        c cVar = this.f5865o;
        if (cVar == null) {
            return;
        }
        int i = cVar.f5905d;
        int i2 = (cVar.f5903b * 2) - 1;
        if (i != i2) {
            int i3 = cVar.f5902a;
            StringBuilder sb = new StringBuilder(115);
            sb.append("DtvCcPacket ended prematurely; size is ");
            sb.append(i2);
            sb.append(", but current index is ");
            sb.append(i);
            sb.append(" (sequence number ");
            sb.append(i3);
            sb.append(");");
            Log.d("Cea708Decoder", sb.toString());
        }
        ParsableBitArray parsableBitArray = this.f5858h;
        c cVar2 = this.f5865o;
        parsableBitArray.m3070j(cVar2.f5904c, cVar2.f5905d);
        int i4 = 3;
        int iM3067g = this.f5858h.m3067g(3);
        int iM3067g2 = this.f5858h.m3067g(5);
        int i5 = 7;
        int i6 = 6;
        if (iM3067g == 7) {
            this.f5858h.m3073m(2);
            iM3067g = this.f5858h.m3067g(6);
            if (iM3067g < 7) {
                outline.m852g0(44, "Invalid extended service number: ", iM3067g, "Cea708Decoder");
            }
        }
        if (iM3067g2 == 0) {
            if (iM3067g != 0) {
                StringBuilder sb2 = new StringBuilder(59);
                sb2.append("serviceNumber is non-zero (");
                sb2.append(iM3067g);
                sb2.append(") when blockSize is 0");
                Log.w("Cea708Decoder", sb2.toString());
            }
        } else if (iM3067g == this.f5860j) {
            boolean z2 = false;
            while (this.f5858h.m3062b() > 0) {
                int iM3067g3 = this.f5858h.m3067g(8);
                if (iM3067g3 == 16) {
                    int iM3067g4 = this.f5858h.m3067g(8);
                    if (iM3067g4 > 31) {
                        if (iM3067g4 <= 127) {
                            if (iM3067g4 == 32) {
                                this.f5862l.m2652a(' ');
                            } else if (iM3067g4 == 33) {
                                this.f5862l.m2652a((char) 160);
                            } else if (iM3067g4 == 37) {
                                this.f5862l.m2652a((char) 8230);
                            } else if (iM3067g4 == 42) {
                                this.f5862l.m2652a((char) 352);
                            } else if (iM3067g4 == 44) {
                                this.f5862l.m2652a((char) 338);
                            } else if (iM3067g4 == 63) {
                                this.f5862l.m2652a((char) 376);
                            } else if (iM3067g4 == 57) {
                                this.f5862l.m2652a((char) 8482);
                            } else if (iM3067g4 == 58) {
                                this.f5862l.m2652a((char) 353);
                            } else if (iM3067g4 == 60) {
                                this.f5862l.m2652a((char) 339);
                            } else if (iM3067g4 != 61) {
                                switch (iM3067g4) {
                                    case 48:
                                        this.f5862l.m2652a((char) 9608);
                                        break;
                                    case 49:
                                        this.f5862l.m2652a((char) 8216);
                                        break;
                                    case 50:
                                        this.f5862l.m2652a((char) 8217);
                                        break;
                                    case 51:
                                        this.f5862l.m2652a((char) 8220);
                                        break;
                                    case 52:
                                        this.f5862l.m2652a((char) 8221);
                                        break;
                                    case 53:
                                        this.f5862l.m2652a((char) 8226);
                                        break;
                                    default:
                                        switch (iM3067g4) {
                                            case 118:
                                                this.f5862l.m2652a((char) 8539);
                                                break;
                                            case 119:
                                                this.f5862l.m2652a((char) 8540);
                                                break;
                                            case 120:
                                                this.f5862l.m2652a((char) 8541);
                                                break;
                                            case 121:
                                                this.f5862l.m2652a((char) 8542);
                                                break;
                                            case 122:
                                                this.f5862l.m2652a((char) 9474);
                                                break;
                                            case 123:
                                                this.f5862l.m2652a((char) 9488);
                                                break;
                                            case 124:
                                                this.f5862l.m2652a((char) 9492);
                                                break;
                                            case Opcodes.LUSHR /* 125 */:
                                                this.f5862l.m2652a((char) 9472);
                                                break;
                                            case 126:
                                                this.f5862l.m2652a((char) 9496);
                                                break;
                                            case Opcodes.LAND /* 127 */:
                                                this.f5862l.m2652a((char) 9484);
                                                break;
                                            default:
                                                outline.m852g0(33, "Invalid G2 character: ", iM3067g4, "Cea708Decoder");
                                                break;
                                        }
                                        break;
                                }
                            } else {
                                this.f5862l.m2652a((char) 8480);
                            }
                        } else if (iM3067g4 <= 159) {
                            if (iM3067g4 <= 135) {
                                this.f5858h.m3073m(32);
                            } else if (iM3067g4 <= 143) {
                                this.f5858h.m3073m(40);
                            } else if (iM3067g4 <= 159) {
                                this.f5858h.m3073m(2);
                                this.f5858h.m3073m(this.f5858h.m3067g(6) * 8);
                            }
                        } else if (iM3067g4 > 255) {
                            outline.m852g0(37, "Invalid extended command: ", iM3067g4, "Cea708Decoder");
                        } else if (iM3067g4 == 160) {
                            this.f5862l.m2652a((char) 13252);
                        } else {
                            outline.m852g0(33, "Invalid G3 character: ", iM3067g4, "Cea708Decoder");
                            this.f5862l.m2652a('_');
                        }
                        z2 = true;
                    } else if (iM3067g4 > 7) {
                        if (iM3067g4 <= 15) {
                            this.f5858h.m3073m(8);
                        } else if (iM3067g4 <= 23) {
                            this.f5858h.m3073m(16);
                        } else if (iM3067g4 <= 31) {
                            this.f5858h.m3073m(24);
                        }
                    }
                } else if (iM3067g3 > 31) {
                    if (iM3067g3 <= 127) {
                        if (iM3067g3 == 127) {
                            this.f5862l.m2652a((char) 9835);
                        } else {
                            this.f5862l.m2652a((char) (iM3067g3 & 255));
                        }
                    } else if (iM3067g3 <= 159) {
                        switch (iM3067g3) {
                            case 128:
                            case Opcodes.LOR /* 129 */:
                            case 130:
                            case Opcodes.LXOR /* 131 */:
                            case Opcodes.IINC /* 132 */:
                            case Opcodes.I2L /* 133 */:
                            case Opcodes.I2F /* 134 */:
                            case Opcodes.I2D /* 135 */:
                                int i7 = iM3067g3 - 128;
                                if (this.f5866p != i7) {
                                    this.f5866p = i7;
                                    this.f5862l = this.f5861k[i7];
                                }
                                break;
                            case Opcodes.L2I /* 136 */:
                                for (int i8 = 1; i8 <= 8; i8++) {
                                    if (this.f5858h.m3066f()) {
                                        this.f5861k[8 - i8].m2654c();
                                    }
                                }
                                break;
                            case Opcodes.L2F /* 137 */:
                                for (int i9 = 1; i9 <= 8; i9++) {
                                    if (this.f5858h.m3066f()) {
                                        this.f5861k[8 - i9].f5890o = true;
                                    }
                                }
                                break;
                            case Opcodes.L2D /* 138 */:
                                for (int i10 = 1; i10 <= 8; i10++) {
                                    if (this.f5858h.m3066f()) {
                                        this.f5861k[8 - i10].f5890o = false;
                                    }
                                }
                                break;
                            case Opcodes.F2I /* 139 */:
                                for (int i11 = 1; i11 <= 8; i11++) {
                                    if (this.f5858h.m3066f()) {
                                        this.f5861k[8 - i11].f5890o = !r1.f5890o;
                                    }
                                }
                                break;
                            case Opcodes.F2L /* 140 */:
                                for (int i12 = 1; i12 <= 8; i12++) {
                                    if (this.f5858h.m3066f()) {
                                        this.f5861k[8 - i12].m2656f();
                                    }
                                }
                                break;
                            case Opcodes.F2D /* 141 */:
                                this.f5858h.m3073m(8);
                                break;
                            case Opcodes.D2I /* 142 */:
                                break;
                            case Opcodes.D2L /* 143 */:
                                m2650l();
                                break;
                            case Opcodes.D2F /* 144 */:
                                if (this.f5862l.f5889n) {
                                    this.f5858h.m3067g(4);
                                    this.f5858h.m3067g(2);
                                    this.f5858h.m3067g(2);
                                    boolean zM3066f = this.f5858h.m3066f();
                                    boolean zM3066f2 = this.f5858h.m3066f();
                                    this.f5858h.m3067g(3);
                                    this.f5858h.m3067g(3);
                                    this.f5862l.m2657g(zM3066f, zM3066f2);
                                } else {
                                    this.f5858h.m3073m(16);
                                }
                                break;
                            case Opcodes.I2B /* 145 */:
                                if (this.f5862l.f5889n) {
                                    int iM2651d = b.m2651d(this.f5858h.m3067g(2), this.f5858h.m3067g(2), this.f5858h.m3067g(2), this.f5858h.m3067g(2));
                                    int iM2651d2 = b.m2651d(this.f5858h.m3067g(2), this.f5858h.m3067g(2), this.f5858h.m3067g(2), this.f5858h.m3067g(2));
                                    this.f5858h.m3073m(2);
                                    b.m2651d(this.f5858h.m3067g(2), this.f5858h.m3067g(2), this.f5858h.m3067g(2), 0);
                                    this.f5862l.m2658h(iM2651d, iM2651d2);
                                } else {
                                    this.f5858h.m3073m(24);
                                }
                                break;
                            case Opcodes.I2C /* 146 */:
                                if (this.f5862l.f5889n) {
                                    this.f5858h.m3073m(4);
                                    int iM3067g5 = this.f5858h.m3067g(4);
                                    this.f5858h.m3073m(2);
                                    this.f5858h.m3067g(6);
                                    b bVar = this.f5862l;
                                    if (bVar.f5886G != iM3067g5) {
                                        bVar.m2652a('\n');
                                    }
                                    bVar.f5886G = iM3067g5;
                                } else {
                                    this.f5858h.m3073m(16);
                                }
                                break;
                            case Opcodes.I2S /* 147 */:
                            case Opcodes.LCMP /* 148 */:
                            case Opcodes.FCMPL /* 149 */:
                            case 150:
                            default:
                                Log.w("Cea708Decoder", outline.m851g(31, "Invalid C1 command: ", iM3067g3));
                                break;
                            case Opcodes.DCMPL /* 151 */:
                                if (this.f5862l.f5889n) {
                                    int iM2651d3 = b.m2651d(this.f5858h.m3067g(2), this.f5858h.m3067g(2), this.f5858h.m3067g(2), this.f5858h.m3067g(2));
                                    this.f5858h.m3067g(2);
                                    b.m2651d(this.f5858h.m3067g(2), this.f5858h.m3067g(2), this.f5858h.m3067g(2), 0);
                                    this.f5858h.m3066f();
                                    this.f5858h.m3066f();
                                    this.f5858h.m3067g(2);
                                    this.f5858h.m3067g(2);
                                    int iM3067g6 = this.f5858h.m3067g(2);
                                    this.f5858h.m3073m(8);
                                    b bVar2 = this.f5862l;
                                    bVar2.f5901z = iM2651d3;
                                    bVar2.f5898w = iM3067g6;
                                } else {
                                    this.f5858h.m3073m(32);
                                }
                                break;
                            case Opcodes.DCMPG /* 152 */:
                            case 153:
                            case 154:
                            case 155:
                            case 156:
                            case 157:
                            case 158:
                            case Opcodes.IF_ICMPEQ /* 159 */:
                                int i13 = iM3067g3 - 152;
                                b bVar3 = this.f5861k[i13];
                                this.f5858h.m3073m(2);
                                boolean zM3066f3 = this.f5858h.m3066f();
                                boolean zM3066f4 = this.f5858h.m3066f();
                                this.f5858h.m3066f();
                                int iM3067g7 = this.f5858h.m3067g(i4);
                                boolean zM3066f5 = this.f5858h.m3066f();
                                int iM3067g8 = this.f5858h.m3067g(i5);
                                int iM3067g9 = this.f5858h.m3067g(8);
                                int iM3067g10 = this.f5858h.m3067g(4);
                                int iM3067g11 = this.f5858h.m3067g(4);
                                this.f5858h.m3073m(2);
                                this.f5858h.m3067g(i6);
                                this.f5858h.m3073m(2);
                                int iM3067g12 = this.f5858h.m3067g(i4);
                                int iM3067g13 = this.f5858h.m3067g(i4);
                                bVar3.f5889n = true;
                                bVar3.f5890o = zM3066f3;
                                bVar3.f5897v = zM3066f4;
                                bVar3.f5891p = iM3067g7;
                                bVar3.f5892q = zM3066f5;
                                bVar3.f5893r = iM3067g8;
                                bVar3.f5894s = iM3067g9;
                                bVar3.f5895t = iM3067g10;
                                int i14 = iM3067g11 + 1;
                                if (bVar3.f5896u != i14) {
                                    bVar3.f5896u = i14;
                                    while (true) {
                                        if ((zM3066f4 && bVar3.f5887l.size() >= bVar3.f5896u) || bVar3.f5887l.size() >= 15) {
                                            bVar3.f5887l.remove(0);
                                        }
                                    }
                                }
                                if (iM3067g12 != 0 && bVar3.f5899x != iM3067g12) {
                                    bVar3.f5899x = iM3067g12;
                                    int i15 = iM3067g12 - 1;
                                    int i16 = b.f5876h[i15];
                                    boolean z3 = b.f5875g[i15];
                                    int i17 = b.f5873e[i15];
                                    int i18 = b.f5874f[i15];
                                    int i19 = b.f5872d[i15];
                                    bVar3.f5901z = i16;
                                    bVar3.f5898w = i19;
                                }
                                if (iM3067g13 != 0 && bVar3.f5900y != iM3067g13) {
                                    bVar3.f5900y = iM3067g13;
                                    int i20 = iM3067g13 - 1;
                                    int i21 = b.f5878j[i20];
                                    int i22 = b.f5877i[i20];
                                    bVar3.m2657g(false, false);
                                    bVar3.m2658h(b.f5869a, b.f5879k[i20]);
                                }
                                if (this.f5866p != i13) {
                                    this.f5866p = i13;
                                    this.f5862l = this.f5861k[i13];
                                }
                                break;
                        }
                    } else if (iM3067g3 <= 255) {
                        this.f5862l.m2652a((char) (iM3067g3 & 255));
                    } else {
                        outline.m852g0(33, "Invalid base command: ", iM3067g3, "Cea708Decoder");
                    }
                    z2 = true;
                } else if (iM3067g3 != 0) {
                    if (iM3067g3 == i4) {
                        this.f5863m = m2649k();
                    } else if (iM3067g3 != 8) {
                        switch (iM3067g3) {
                            case 12:
                                m2650l();
                                break;
                            case 13:
                                this.f5862l.m2652a('\n');
                                break;
                            case 14:
                                break;
                            default:
                                if (iM3067g3 >= 17 && iM3067g3 <= 23) {
                                    outline.m852g0(55, "Currently unsupported COMMAND_EXT1 Command: ", iM3067g3, "Cea708Decoder");
                                    this.f5858h.m3073m(8);
                                } else if (iM3067g3 < 24 || iM3067g3 > 31) {
                                    outline.m852g0(31, "Invalid C0 command: ", iM3067g3, "Cea708Decoder");
                                } else {
                                    outline.m852g0(54, "Currently unsupported COMMAND_P16 Command: ", iM3067g3, "Cea708Decoder");
                                    this.f5858h.m3073m(16);
                                }
                                break;
                        }
                    } else {
                        b bVar4 = this.f5862l;
                        int length = bVar4.f5888m.length();
                        if (length > 0) {
                            bVar4.f5888m.delete(length - 1, length);
                        }
                    }
                }
                i4 = 3;
                i5 = 7;
                i6 = 6;
            }
            if (z2) {
                this.f5863m = m2649k();
            }
        }
        this.f5865o = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c7  */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Cue> m2649k() {
        Layout.Alignment alignment;
        float f;
        float f2;
        a aVar;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.f5861k[i].m2655e()) {
                b[] bVarArr = this.f5861k;
                if (bVarArr[i].f5890o) {
                    b bVar = bVarArr[i];
                    if (bVar.m2655e()) {
                        aVar = null;
                    } else {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        for (int i2 = 0; i2 < bVar.f5887l.size(); i2++) {
                            spannableStringBuilder.append((CharSequence) bVar.f5887l.get(i2));
                            spannableStringBuilder.append('\n');
                        }
                        spannableStringBuilder.append((CharSequence) bVar.m2653b());
                        int i3 = bVar.f5898w;
                        if (i3 == 0) {
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                            Layout.Alignment alignment2 = alignment;
                            if (bVar.f5892q) {
                                f = bVar.f5894s / 209.0f;
                                f2 = bVar.f5893r / 74.0f;
                            } else {
                                f = bVar.f5894s / 99.0f;
                                f2 = bVar.f5893r / 99.0f;
                            }
                            float f3 = (f * 0.9f) + 0.05f;
                            float f4 = (f2 * 0.9f) + 0.05f;
                            int i4 = bVar.f5895t;
                            int i5 = i4 / 3;
                            int i6 = i4 % 3;
                            aVar = new a(spannableStringBuilder, alignment2, f4, 0, i5 != 0 ? 0 : i5 == 1 ? 1 : 2, f3, i6 != 0 ? 0 : i6 == 1 ? 1 : 2, -3.4028235E38f, bVar.f5901z == b.f5870b, bVar.f5901z, bVar.f5891p);
                        } else {
                            if (i3 == 1) {
                                alignment = Layout.Alignment.ALIGN_OPPOSITE;
                            } else if (i3 != 2) {
                                if (i3 != 3) {
                                    throw new IllegalArgumentException(outline.m851g(43, "Unexpected justification value: ", bVar.f5898w));
                                }
                                alignment = Layout.Alignment.ALIGN_NORMAL;
                            } else {
                                alignment = Layout.Alignment.ALIGN_CENTER;
                            }
                            Layout.Alignment alignment22 = alignment;
                            if (bVar.f5892q) {
                            }
                            float f32 = (f * 0.9f) + 0.05f;
                            float f42 = (f2 * 0.9f) + 0.05f;
                            int i42 = bVar.f5895t;
                            int i52 = i42 / 3;
                            int i62 = i42 % 3;
                            aVar = new a(spannableStringBuilder, alignment22, f42, 0, i52 != 0 ? 0 : i52 == 1 ? 1 : 2, f32, i62 != 0 ? 0 : i62 == 1 ? 1 : 2, -3.4028235E38f, bVar.f5901z == b.f5870b, bVar.f5901z, bVar.f5891p);
                        }
                    }
                    if (aVar != null) {
                        arrayList.add(aVar);
                    }
                } else {
                    continue;
                }
            }
        }
        Collections.sort(arrayList, C2590a.f5818j);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            arrayList2.add(((a) arrayList.get(i7)).f5867a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    /* renamed from: l */
    public final void m2650l() {
        for (int i = 0; i < 8; i++) {
            this.f5861k[i].m2656f();
        }
    }
}
