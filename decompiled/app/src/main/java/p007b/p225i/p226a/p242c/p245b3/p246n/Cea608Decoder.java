package p007b.p225i.p226a.p242c.p245b3.p246n;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;
import p007b.p225i.p226a.p242c.p245b3.SubtitleInputBuffer;
import p007b.p225i.p226a.p242c.p245b3.SubtitleOutputBuffer;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: Cea608Decoder.java */
/* renamed from: b.i.a.c.b3.n.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class Cea608Decoder extends CeaDecoder {

    /* renamed from: g */
    public static final int[] f5820g = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: h */
    public static final int[] f5821h = {0, 4, 8, 12, 16, 20, 24, 28};

    /* renamed from: i */
    public static final int[] f5822i = {-1, -16711936, -16776961, -16711681, -65536, InputDeviceCompat.SOURCE_ANY, -65281};

    /* renamed from: j */
    public static final int[] f5823j = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};

    /* renamed from: k */
    public static final int[] f5824k = {Opcodes.FRETURN, Opcodes.ARETURN, Opcodes.ANEWARRAY, Opcodes.ATHROW, 8482, Opcodes.IF_ICMPGE, Opcodes.IF_ICMPGT, 9834, 224, 32, 232, 226, 234, 238, 244, 251};

    /* renamed from: l */
    public static final int[] f5825l = {Opcodes.INSTANCEOF, 201, 211, 218, 220, 252, 8216, Opcodes.IF_ICMPLT, 42, 39, 8212, Opcodes.RET, 8480, 8226, 8220, 8221, Opcodes.CHECKCAST, Opcodes.MONITORENTER, Opcodes.IFNONNULL, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, Opcodes.LOOKUPSWITCH, Opcodes.NEW};

    /* renamed from: m */
    public static final int[] f5826m = {Opcodes.MONITOREXIT, 227, 205, 204, 236, 210, 242, 213, 245, 123, Opcodes.LUSHR, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, Opcodes.IF_ACMPEQ, Opcodes.IF_ICMPLE, 9474, Opcodes.MULTIANEWARRAY, 229, 216, 248, 9484, 9488, 9492, 9496};

    /* renamed from: n */
    public static final boolean[] f5827n = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* renamed from: A */
    public boolean f5828A;

    /* renamed from: B */
    public byte f5829B;

    /* renamed from: C */
    public byte f5830C;

    /* renamed from: E */
    public boolean f5832E;

    /* renamed from: F */
    public long f5833F;

    /* renamed from: p */
    public final int f5835p;

    /* renamed from: q */
    public final int f5836q;

    /* renamed from: r */
    public final int f5837r;

    /* renamed from: s */
    public final long f5838s;

    /* renamed from: v */
    @Nullable
    public List<Cue> f5841v;

    /* renamed from: w */
    @Nullable
    public List<Cue> f5842w;

    /* renamed from: x */
    public int f5843x;

    /* renamed from: y */
    public int f5844y;

    /* renamed from: z */
    public boolean f5845z;

    /* renamed from: o */
    public final ParsableByteArray f5834o = new ParsableByteArray();

    /* renamed from: t */
    public final ArrayList<a> f5839t = new ArrayList<>();

    /* renamed from: u */
    public a f5840u = new a(0, 4);

    /* renamed from: D */
    public int f5831D = 0;

    /* compiled from: Cea608Decoder.java */
    /* renamed from: b.i.a.c.b3.n.c$a */
    public static final class a {

        /* renamed from: a */
        public final List<C13223a> f5846a = new ArrayList();

        /* renamed from: b */
        public final List<SpannableString> f5847b = new ArrayList();

        /* renamed from: c */
        public final StringBuilder f5848c = new StringBuilder();

        /* renamed from: d */
        public int f5849d;

        /* renamed from: e */
        public int f5850e;

        /* renamed from: f */
        public int f5851f;

        /* renamed from: g */
        public int f5852g;

        /* renamed from: h */
        public int f5853h;

        /* compiled from: Cea608Decoder.java */
        /* renamed from: b.i.a.c.b3.n.c$a$a, reason: collision with other inner class name */
        public static class C13223a {

            /* renamed from: a */
            public final int f5854a;

            /* renamed from: b */
            public final boolean f5855b;

            /* renamed from: c */
            public int f5856c;

            public C13223a(int i, boolean z2, int i2) {
                this.f5854a = i;
                this.f5855b = z2;
                this.f5856c = i2;
            }
        }

        public a(int i, int i2) {
            m2647f(i);
            this.f5853h = i2;
        }

        /* renamed from: a */
        public void m2642a(char c) {
            if (this.f5848c.length() < 32) {
                this.f5848c.append(c);
            }
        }

        /* renamed from: b */
        public void m2643b() {
            int length = this.f5848c.length();
            if (length > 0) {
                this.f5848c.delete(length - 1, length);
                for (int size = this.f5846a.size() - 1; size >= 0; size--) {
                    C13223a c13223a = this.f5846a.get(size);
                    int i = c13223a.f5856c;
                    if (i != length) {
                        return;
                    }
                    c13223a.f5856c = i - 1;
                }
            }
        }

        @Nullable
        /* renamed from: c */
        public Cue m2644c(int i) {
            float f;
            int i2 = this.f5850e + this.f5851f;
            int i3 = 32 - i2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.f5847b.size(); i4++) {
                SpannableString spannableStringSubSequence = this.f5847b.get(i4);
                int i5 = Util2.f6708a;
                if (spannableStringSubSequence.length() > i3) {
                    spannableStringSubSequence = spannableStringSubSequence.subSequence(0, i3);
                }
                spannableStringBuilder.append(spannableStringSubSequence);
                spannableStringBuilder.append('\n');
            }
            SpannableString spannableStringM2645d = m2645d();
            int i6 = Util2.f6708a;
            int length = spannableStringM2645d.length();
            CharSequence charSequenceSubSequence = spannableStringM2645d;
            if (length > i3) {
                charSequenceSubSequence = spannableStringM2645d.subSequence(0, i3);
            }
            spannableStringBuilder.append(charSequenceSubSequence);
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length2 = i3 - spannableStringBuilder.length();
            int i7 = i2 - length2;
            int i8 = i != Integer.MIN_VALUE ? i : (this.f5852g != 2 || (Math.abs(i7) >= 3 && length2 >= 0)) ? (this.f5852g != 2 || i7 <= 0) ? 0 : 2 : 1;
            if (i8 != 1) {
                if (i8 == 2) {
                    i2 = 32 - length2;
                }
                f = ((i2 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f = 0.5f;
            }
            int i9 = this.f5849d;
            if (i9 > 7) {
                i9 = (i9 - 15) - 2;
            } else if (this.f5852g == 1) {
                i9 -= this.f5853h - 1;
            }
            return new Cue(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, null, null, i9, 1, Integer.MIN_VALUE, f, i8, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
        }

        /* renamed from: d */
        public final SpannableString m2645d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f5848c);
            int length = spannableStringBuilder.length();
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            int i4 = 0;
            int i5 = -1;
            boolean z2 = false;
            int i6 = -1;
            while (i < this.f5846a.size()) {
                C13223a c13223a = this.f5846a.get(i);
                boolean z3 = c13223a.f5855b;
                int i7 = c13223a.f5854a;
                if (i7 != 8) {
                    boolean z4 = i7 == 7;
                    if (i7 != 7) {
                        i6 = Cea608Decoder.f5822i[i7];
                    }
                    z2 = z4;
                }
                int i8 = c13223a.f5856c;
                i++;
                if (i8 != (i < this.f5846a.size() ? this.f5846a.get(i).f5856c : length)) {
                    if (i2 != -1 && !z3) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i8, 33);
                        i2 = -1;
                    } else if (i2 == -1 && z3) {
                        i2 = i8;
                    }
                    if (i3 != -1 && !z2) {
                        spannableStringBuilder.setSpan(new StyleSpan(2), i3, i8, 33);
                        i3 = -1;
                    } else if (i3 == -1 && z2) {
                        i3 = i8;
                    }
                    if (i6 != i5) {
                        if (i5 != -1) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(i5), i4, i8, 33);
                        }
                        i4 = i8;
                        i5 = i6;
                    }
                }
            }
            if (i2 != -1 && i2 != length) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
            }
            if (i3 != -1 && i3 != length) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, length, 33);
            }
            if (i4 != length && i5 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i5), i4, length, 33);
            }
            return new SpannableString(spannableStringBuilder);
        }

        /* renamed from: e */
        public boolean m2646e() {
            return this.f5846a.isEmpty() && this.f5847b.isEmpty() && this.f5848c.length() == 0;
        }

        /* renamed from: f */
        public void m2647f(int i) {
            this.f5852g = i;
            this.f5846a.clear();
            this.f5847b.clear();
            this.f5848c.setLength(0);
            this.f5849d = 15;
            this.f5850e = 0;
            this.f5851f = 0;
        }
    }

    public Cea608Decoder(String str, int i, long j) {
        this.f5838s = j > 0 ? j * 1000 : -9223372036854775807L;
        this.f5835p = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i == 1) {
            this.f5837r = 0;
            this.f5836q = 0;
        } else if (i == 2) {
            this.f5837r = 1;
            this.f5836q = 0;
        } else if (i == 3) {
            this.f5837r = 0;
            this.f5836q = 1;
        } else if (i != 4) {
            Log.w("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f5837r = 0;
            this.f5836q = 0;
        } else {
            this.f5837r = 1;
            this.f5836q = 1;
        }
        m2640l(0);
        m2639k();
        this.f5832E = true;
        this.f5833F = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.p246n.CeaDecoder, p007b.p225i.p226a.p242c.p265v2.Decoder
    @Nullable
    /* renamed from: b */
    public /* bridge */ /* synthetic */ SubtitleOutputBuffer mo2608b() throws DecoderException {
        return mo2636g();
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.p246n.CeaDecoder
    /* renamed from: e */
    public Subtitle mo2634e() {
        List<Cue> list = this.f5841v;
        this.f5842w = list;
        Objects.requireNonNull(list);
        return new CeaSubtitle(list);
    }

    /* JADX WARN: Removed duplicated region for block: B:215:0x008f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3 A[FALL_THROUGH] */
    @Override // p007b.p225i.p226a.p242c.p245b3.p246n.CeaDecoder
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo2635f(SubtitleInputBuffer subtitleInputBuffer) {
        boolean z2;
        ByteBuffer byteBuffer = subtitleInputBuffer.f19778l;
        Objects.requireNonNull(byteBuffer);
        this.f5834o.m3077C(byteBuffer.array(), byteBuffer.limit());
        boolean z3 = false;
        while (true) {
            int iM3081a = this.f5834o.m3081a();
            int i = this.f5835p;
            if (iM3081a < i) {
                if (z3) {
                    int i2 = this.f5843x;
                    if (i2 == 1 || i2 == 3) {
                        this.f5841v = m2638j();
                        this.f5833F = this.f5910e;
                        return;
                    }
                    return;
                }
                return;
            }
            byte bM3100t = i == 2 ? (byte) -4 : (byte) this.f5834o.m3100t();
            int iM3100t = this.f5834o.m3100t();
            int iM3100t2 = this.f5834o.m3100t();
            if ((bM3100t & 2) == 0 && (bM3100t & 1) == this.f5836q) {
                byte b2 = (byte) (iM3100t & Opcodes.LAND);
                byte b3 = (byte) (iM3100t2 & Opcodes.LAND);
                if (b2 != 0 || b3 != 0) {
                    boolean z4 = this.f5845z;
                    if ((bM3100t & 4) == 4) {
                        boolean[] zArr = f5827n;
                        boolean z5 = zArr[iM3100t] && zArr[iM3100t2];
                        this.f5845z = z5;
                        if (z5) {
                            if ((b2 & 240) == 16) {
                                if (this.f5828A && this.f5829B == b2 && this.f5830C == b3) {
                                    this.f5828A = false;
                                    z2 = true;
                                    if (!z2) {
                                    }
                                } else {
                                    this.f5828A = true;
                                    this.f5829B = b2;
                                    this.f5830C = b3;
                                }
                            }
                            z2 = false;
                            if (!z2) {
                            }
                        } else {
                            this.f5828A = false;
                            z2 = false;
                            if (!z2) {
                                if (z5) {
                                    if (1 <= b2 && b2 <= 15) {
                                        this.f5832E = false;
                                    } else if ((b2 & 247) == 20) {
                                        if (b3 != 32 && b3 != 47) {
                                            switch (b3) {
                                                default:
                                                    switch (b3) {
                                                        case 42:
                                                        case 43:
                                                            this.f5832E = false;
                                                            break;
                                                    }
                                                case 37:
                                                case 38:
                                                case 39:
                                                    break;
                                            }
                                        } else {
                                            this.f5832E = true;
                                        }
                                    }
                                    if (this.f5832E) {
                                        int i3 = b2 & 224;
                                        if (i3 == 0) {
                                            this.f5831D = (b2 >> 3) & 1;
                                        }
                                        if (this.f5831D == this.f5837r) {
                                            if (i3 == 0) {
                                                int i4 = b2 & 247;
                                                if (i4 == 17 && (b3 & 240) == 48) {
                                                    this.f5840u.m2642a((char) f5824k[b3 & 15]);
                                                } else {
                                                    int i5 = b2 & 246;
                                                    if (i5 == 18 && (b3 & 224) == 32) {
                                                        this.f5840u.m2643b();
                                                        this.f5840u.m2642a((char) ((b2 & 1) == 0 ? f5825l[b3 & 31] : f5826m[b3 & 31]));
                                                    } else if (i4 == 17 && (b3 & 240) == 32) {
                                                        this.f5840u.m2642a(' ');
                                                        boolean z6 = (b3 & 1) == 1;
                                                        a aVar = this.f5840u;
                                                        aVar.f5846a.add(new a.C13223a((b3 >> 1) & 7, z6, aVar.f5848c.length()));
                                                    } else if ((b2 & 240) == 16 && (b3 & 192) == 64) {
                                                        int i6 = f5820g[b2 & 7];
                                                        if ((b3 & 32) != 0) {
                                                            i6++;
                                                        }
                                                        a aVar2 = this.f5840u;
                                                        if (i6 != aVar2.f5849d) {
                                                            if (this.f5843x != 1 && !aVar2.m2646e()) {
                                                                a aVar3 = new a(this.f5843x, this.f5844y);
                                                                this.f5840u = aVar3;
                                                                this.f5839t.add(aVar3);
                                                            }
                                                            this.f5840u.f5849d = i6;
                                                        }
                                                        boolean z7 = (b3 & 16) == 16;
                                                        boolean z8 = (b3 & 1) == 1;
                                                        int i7 = (b3 >> 1) & 7;
                                                        a aVar4 = this.f5840u;
                                                        aVar4.f5846a.add(new a.C13223a(z7 ? 8 : i7, z8, aVar4.f5848c.length()));
                                                        if (z7) {
                                                            this.f5840u.f5850e = f5821h[i7];
                                                        }
                                                    } else if (i4 == 23 && b3 >= 33 && b3 <= 35) {
                                                        this.f5840u.f5851f = b3 - 32;
                                                    } else if (i5 == 20 && (b3 & 240) == 32) {
                                                        if (b3 == 32) {
                                                            m2640l(2);
                                                        } else if (b3 != 41) {
                                                            switch (b3) {
                                                                case 37:
                                                                    m2640l(1);
                                                                    m2641m(2);
                                                                    break;
                                                                case 38:
                                                                    m2640l(1);
                                                                    m2641m(3);
                                                                    break;
                                                                case 39:
                                                                    m2640l(1);
                                                                    m2641m(4);
                                                                    break;
                                                                default:
                                                                    int i8 = this.f5843x;
                                                                    if (i8 != 0) {
                                                                        if (b3 != 33) {
                                                                            switch (b3) {
                                                                                case 44:
                                                                                    this.f5841v = Collections.emptyList();
                                                                                    int i9 = this.f5843x;
                                                                                    if (i9 == 1 || i9 == 3) {
                                                                                        m2639k();
                                                                                    }
                                                                                    break;
                                                                                case 45:
                                                                                    if (i8 == 1 && !this.f5840u.m2646e()) {
                                                                                        a aVar5 = this.f5840u;
                                                                                        aVar5.f5847b.add(aVar5.m2645d());
                                                                                        aVar5.f5848c.setLength(0);
                                                                                        aVar5.f5846a.clear();
                                                                                        int iMin = Math.min(aVar5.f5853h, aVar5.f5849d);
                                                                                        while (aVar5.f5847b.size() >= iMin) {
                                                                                            aVar5.f5847b.remove(0);
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                case 46:
                                                                                    m2639k();
                                                                                    break;
                                                                                case 47:
                                                                                    this.f5841v = m2638j();
                                                                                    m2639k();
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            this.f5840u.m2643b();
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            m2640l(3);
                                                        }
                                                    }
                                                }
                                            } else {
                                                a aVar6 = this.f5840u;
                                                int[] iArr = f5823j;
                                                aVar6.m2642a((char) iArr[(b2 & 127) - 32]);
                                                if ((b3 & 224) != 0) {
                                                    this.f5840u.m2642a((char) iArr[(b3 & 127) - 32]);
                                                }
                                            }
                                            z3 = true;
                                        }
                                    }
                                } else if (z4) {
                                    m2639k();
                                    z3 = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.p246n.CeaDecoder, p007b.p225i.p226a.p242c.p265v2.Decoder
    public void flush() {
        super.flush();
        this.f5841v = null;
        this.f5842w = null;
        m2640l(0);
        m2641m(4);
        m2639k();
        this.f5845z = false;
        this.f5828A = false;
        this.f5829B = (byte) 0;
        this.f5830C = (byte) 0;
        this.f5831D = 0;
        this.f5832E = true;
        this.f5833F = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.p246n.CeaDecoder
    @Nullable
    /* renamed from: g */
    public SubtitleOutputBuffer mo2636g() throws SubtitleDecoderException {
        SubtitleOutputBuffer subtitleOutputBufferPollFirst;
        SubtitleOutputBuffer subtitleOutputBufferMo2636g = super.mo2636g();
        if (subtitleOutputBufferMo2636g != null) {
            return subtitleOutputBufferMo2636g;
        }
        long j = this.f5838s;
        boolean z2 = false;
        if (j != -9223372036854775807L) {
            long j2 = this.f5833F;
            if (j2 != -9223372036854775807L && this.f5910e - j2 >= j) {
                z2 = true;
            }
        }
        if (!z2 || (subtitleOutputBufferPollFirst = this.f5907b.pollFirst()) == null) {
            return null;
        }
        List<Cue> listEmptyList = Collections.emptyList();
        this.f5841v = listEmptyList;
        this.f5833F = -9223372036854775807L;
        this.f5842w = listEmptyList;
        Objects.requireNonNull(listEmptyList);
        subtitleOutputBufferPollFirst.m2619r(this.f5910e, new CeaSubtitle(listEmptyList), RecyclerView.FOREVER_NS);
        return subtitleOutputBufferPollFirst;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.p246n.CeaDecoder
    /* renamed from: h */
    public boolean mo2637h() {
        return this.f5841v != this.f5842w;
    }

    /* renamed from: j */
    public final List<Cue> m2638j() {
        int size = this.f5839t.size();
        ArrayList arrayList = new ArrayList(size);
        int iMin = 2;
        for (int i = 0; i < size; i++) {
            Cue cueM2644c = this.f5839t.get(i).m2644c(Integer.MIN_VALUE);
            arrayList.add(cueM2644c);
            if (cueM2644c != null) {
                iMin = Math.min(iMin, cueM2644c.f5766t);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            Cue cueM2644c2 = (Cue) arrayList.get(i2);
            if (cueM2644c2 != null) {
                if (cueM2644c2.f5766t != iMin) {
                    cueM2644c2 = this.f5839t.get(i2).m2644c(iMin);
                    Objects.requireNonNull(cueM2644c2);
                }
                arrayList2.add(cueM2644c2);
            }
        }
        return arrayList2;
    }

    /* renamed from: k */
    public final void m2639k() {
        this.f5840u.m2647f(this.f5843x);
        this.f5839t.clear();
        this.f5839t.add(this.f5840u);
    }

    /* renamed from: l */
    public final void m2640l(int i) {
        int i2 = this.f5843x;
        if (i2 == i) {
            return;
        }
        this.f5843x = i;
        if (i == 3) {
            for (int i3 = 0; i3 < this.f5839t.size(); i3++) {
                this.f5839t.get(i3).f5852g = i;
            }
            return;
        }
        m2639k();
        if (i2 == 3 || i == 1 || i == 0) {
            this.f5841v = Collections.emptyList();
        }
    }

    /* renamed from: m */
    public final void m2641m(int i) {
        this.f5844y = i;
        this.f5840u.f5853h = i;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.p246n.CeaDecoder, p007b.p225i.p226a.p242c.p265v2.Decoder
    public void release() {
    }
}
