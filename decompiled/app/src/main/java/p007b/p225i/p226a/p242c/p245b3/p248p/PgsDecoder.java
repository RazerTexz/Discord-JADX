package p007b.p225i.p226a.p242c.p245b3.p248p;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.zip.Inflater;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.SimpleSubtitleDecoder2;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: PgsDecoder.java */
/* renamed from: b.i.a.c.b3.p.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class PgsDecoder extends SimpleSubtitleDecoder2 {

    /* renamed from: n */
    public final ParsableByteArray f5967n;

    /* renamed from: o */
    public final ParsableByteArray f5968o;

    /* renamed from: p */
    public final a f5969p;

    /* renamed from: q */
    @Nullable
    public Inflater f5970q;

    /* compiled from: PgsDecoder.java */
    /* renamed from: b.i.a.c.b3.p.a$a */
    public static final class a {

        /* renamed from: a */
        public final ParsableByteArray f5971a = new ParsableByteArray();

        /* renamed from: b */
        public final int[] f5972b = new int[256];

        /* renamed from: c */
        public boolean f5973c;

        /* renamed from: d */
        public int f5974d;

        /* renamed from: e */
        public int f5975e;

        /* renamed from: f */
        public int f5976f;

        /* renamed from: g */
        public int f5977g;

        /* renamed from: h */
        public int f5978h;

        /* renamed from: i */
        public int f5979i;

        /* renamed from: a */
        public void m2667a() {
            this.f5974d = 0;
            this.f5975e = 0;
            this.f5976f = 0;
            this.f5977g = 0;
            this.f5978h = 0;
            this.f5979i = 0;
            this.f5971a.m3075A(0);
            this.f5973c = false;
        }
    }

    public PgsDecoder() {
        super("PgsDecoder");
        this.f5967n = new ParsableByteArray();
        this.f5968o = new ParsableByteArray();
        this.f5969p = new a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
    @Override // p007b.p225i.p226a.p242c.p245b3.SimpleSubtitleDecoder2
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Subtitle mo2617j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        ParsableByteArray parsableByteArray;
        Cue cue;
        ParsableByteArray parsableByteArray2;
        int i2;
        int iM3100t;
        int i3;
        int i4;
        int iM3102v;
        PgsDecoder pgsDecoder = this;
        ParsableByteArray parsableByteArray3 = pgsDecoder.f5967n;
        parsableByteArray3.f6793a = bArr;
        parsableByteArray3.f6795c = i;
        int i5 = 0;
        parsableByteArray3.f6794b = 0;
        if (parsableByteArray3.m3081a() > 0 && parsableByteArray3.m3083c() == 120) {
            if (pgsDecoder.f5970q == null) {
                pgsDecoder.f5970q = new Inflater();
            }
            if (Util2.m3016x(parsableByteArray3, pgsDecoder.f5968o, pgsDecoder.f5970q)) {
                ParsableByteArray parsableByteArray4 = pgsDecoder.f5968o;
                parsableByteArray3.m3077C(parsableByteArray4.f6793a, parsableByteArray4.f6795c);
            }
        }
        pgsDecoder.f5969p.m2667a();
        ArrayList arrayList = new ArrayList();
        while (pgsDecoder.f5967n.m3081a() >= 3) {
            ParsableByteArray parsableByteArray5 = pgsDecoder.f5967n;
            a aVar = pgsDecoder.f5969p;
            int i6 = parsableByteArray5.f6795c;
            int iM3100t2 = parsableByteArray5.m3100t();
            int iM3105y = parsableByteArray5.m3105y();
            int i7 = parsableByteArray5.f6794b + iM3105y;
            if (i7 > i6) {
                parsableByteArray5.m3079E(i6);
                cue = null;
            } else {
                if (iM3100t2 != 128) {
                    switch (iM3100t2) {
                        case 20:
                            Objects.requireNonNull(aVar);
                            if (iM3105y % 5 == 2) {
                                parsableByteArray5.m3080F(2);
                                Arrays.fill(aVar.f5972b, i5);
                                int i8 = iM3105y / 5;
                                int i9 = 0;
                                while (i9 < i8) {
                                    int iM3100t3 = parsableByteArray5.m3100t();
                                    int iM3100t4 = parsableByteArray5.m3100t();
                                    double d = iM3100t4;
                                    double dM3100t = parsableByteArray5.m3100t() - 128;
                                    arrayList = arrayList;
                                    double dM3100t2 = parsableByteArray5.m3100t() - 128;
                                    aVar.f5972b[iM3100t3] = (Util2.m3000h((int) ((1.402d * dM3100t) + d), 0, 255) << 16) | (parsableByteArray5.m3100t() << 24) | (Util2.m3000h((int) ((d - (0.34414d * dM3100t2)) - (dM3100t * 0.71414d)), 0, 255) << 8) | Util2.m3000h((int) ((dM3100t2 * 1.772d) + d), 0, 255);
                                    i9++;
                                    parsableByteArray5 = parsableByteArray5;
                                }
                                parsableByteArray = parsableByteArray5;
                                aVar.f5973c = true;
                            } else {
                                parsableByteArray = parsableByteArray5;
                            }
                            break;
                        case 21:
                            Objects.requireNonNull(aVar);
                            if (iM3105y >= 4) {
                                parsableByteArray5.m3080F(3);
                                int i10 = iM3105y - 4;
                                if (!((parsableByteArray5.m3100t() & 128) != 0)) {
                                    ParsableByteArray parsableByteArray6 = aVar.f5971a;
                                    i3 = parsableByteArray6.f6794b;
                                    i4 = parsableByteArray6.f6795c;
                                    if (i3 < i4 && i10 > 0) {
                                        int iMin = Math.min(i10, i4 - i3);
                                        parsableByteArray5.m3085e(aVar.f5971a.f6793a, i3, iMin);
                                        aVar.f5971a.m3079E(i3 + iMin);
                                    }
                                } else if (i10 >= 7 && (iM3102v = parsableByteArray5.m3102v()) >= 4) {
                                    aVar.f5978h = parsableByteArray5.m3105y();
                                    aVar.f5979i = parsableByteArray5.m3105y();
                                    aVar.f5971a.m3075A(iM3102v - 4);
                                    i10 -= 7;
                                    ParsableByteArray parsableByteArray62 = aVar.f5971a;
                                    i3 = parsableByteArray62.f6794b;
                                    i4 = parsableByteArray62.f6795c;
                                    if (i3 < i4) {
                                        int iMin2 = Math.min(i10, i4 - i3);
                                        parsableByteArray5.m3085e(aVar.f5971a.f6793a, i3, iMin2);
                                        aVar.f5971a.m3079E(i3 + iMin2);
                                    }
                                }
                            }
                            parsableByteArray = parsableByteArray5;
                            break;
                        case 22:
                            Objects.requireNonNull(aVar);
                            if (iM3105y >= 19) {
                                aVar.f5974d = parsableByteArray5.m3105y();
                                aVar.f5975e = parsableByteArray5.m3105y();
                                parsableByteArray5.m3080F(11);
                                aVar.f5976f = parsableByteArray5.m3105y();
                                aVar.f5977g = parsableByteArray5.m3105y();
                            }
                            parsableByteArray = parsableByteArray5;
                            break;
                    }
                    cue = null;
                } else {
                    parsableByteArray = parsableByteArray5;
                    if (aVar.f5974d == 0 || aVar.f5975e == 0 || aVar.f5978h == 0 || aVar.f5979i == 0 || (i2 = (parsableByteArray2 = aVar.f5971a).f6795c) == 0 || parsableByteArray2.f6794b != i2 || !aVar.f5973c) {
                        cue = null;
                    } else {
                        parsableByteArray2.m3079E(0);
                        int i11 = aVar.f5978h * aVar.f5979i;
                        int[] iArr = new int[i11];
                        int i12 = 0;
                        while (i12 < i11) {
                            int iM3100t5 = aVar.f5971a.m3100t();
                            if (iM3100t5 != 0) {
                                iM3100t = i12 + 1;
                                iArr[i12] = aVar.f5972b[iM3100t5];
                            } else {
                                int iM3100t6 = aVar.f5971a.m3100t();
                                if (iM3100t6 != 0) {
                                    iM3100t = ((iM3100t6 & 64) == 0 ? iM3100t6 & 63 : ((iM3100t6 & 63) << 8) | aVar.f5971a.m3100t()) + i12;
                                    Arrays.fill(iArr, i12, iM3100t, (iM3100t6 & 128) == 0 ? 0 : aVar.f5972b[aVar.f5971a.m3100t()]);
                                }
                            }
                            i12 = iM3100t;
                        }
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, aVar.f5978h, aVar.f5979i, Bitmap.Config.ARGB_8888);
                        float f = aVar.f5976f;
                        float f2 = aVar.f5974d;
                        float f3 = f / f2;
                        float f4 = aVar.f5977g;
                        float f5 = aVar.f5975e;
                        cue = new Cue(null, null, null, bitmapCreateBitmap, f4 / f5, 0, 0, f3, 0, Integer.MIN_VALUE, -3.4028235E38f, aVar.f5978h / f2, aVar.f5979i / f5, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
                    }
                    aVar.m2667a();
                }
                parsableByteArray.m3079E(i7);
            }
            ArrayList arrayList2 = arrayList;
            if (cue != null) {
                arrayList2.add(cue);
            }
            arrayList = arrayList2;
            i5 = 0;
            pgsDecoder = this;
        }
        return new PgsSubtitle(Collections.unmodifiableList(arrayList));
    }
}
