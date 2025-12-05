package p007b.p225i.p226a.p242c.p260g3;

import java.util.Arrays;

/* compiled from: FixedFrameRateEstimator.java */
/* renamed from: b.i.a.c.g3.p, reason: use source file name */
/* loaded from: classes3.dex */
public final class FixedFrameRateEstimator {

    /* renamed from: c */
    public boolean f6852c;

    /* renamed from: e */
    public int f6854e;

    /* renamed from: a */
    public a f6850a = new a();

    /* renamed from: b */
    public a f6851b = new a();

    /* renamed from: d */
    public long f6853d = -9223372036854775807L;

    /* compiled from: FixedFrameRateEstimator.java */
    /* renamed from: b.i.a.c.g3.p$a */
    public static final class a {

        /* renamed from: a */
        public long f6855a;

        /* renamed from: b */
        public long f6856b;

        /* renamed from: c */
        public long f6857c;

        /* renamed from: d */
        public long f6858d;

        /* renamed from: e */
        public long f6859e;

        /* renamed from: f */
        public long f6860f;

        /* renamed from: g */
        public final boolean[] f6861g = new boolean[15];

        /* renamed from: h */
        public int f6862h;

        /* renamed from: a */
        public boolean m3128a() {
            return this.f6858d > 15 && this.f6862h == 0;
        }

        /* renamed from: b */
        public void m3129b(long j) {
            long j2 = this.f6858d;
            if (j2 == 0) {
                this.f6855a = j;
            } else if (j2 == 1) {
                long j3 = j - this.f6855a;
                this.f6856b = j3;
                this.f6860f = j3;
                this.f6859e = 1L;
            } else {
                long j4 = j - this.f6857c;
                int i = (int) (j2 % 15);
                if (Math.abs(j4 - this.f6856b) <= 1000000) {
                    this.f6859e++;
                    this.f6860f += j4;
                    boolean[] zArr = this.f6861g;
                    if (zArr[i]) {
                        zArr[i] = false;
                        this.f6862h--;
                    }
                } else {
                    boolean[] zArr2 = this.f6861g;
                    if (!zArr2[i]) {
                        zArr2[i] = true;
                        this.f6862h++;
                    }
                }
            }
            this.f6858d++;
            this.f6857c = j;
        }

        /* renamed from: c */
        public void m3130c() {
            this.f6858d = 0L;
            this.f6859e = 0L;
            this.f6860f = 0L;
            this.f6862h = 0;
            Arrays.fill(this.f6861g, false);
        }
    }

    /* renamed from: a */
    public boolean m3127a() {
        return this.f6850a.m3128a();
    }
}
