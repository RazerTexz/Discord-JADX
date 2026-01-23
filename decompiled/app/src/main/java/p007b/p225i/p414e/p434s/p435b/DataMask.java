package p007b.p225i.p414e.p434s.p435b;

import p007b.p225i.p414e.p418n.BitMatrix;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: b.i.e.s.b.c, reason: use source file name */
/* JADX INFO: compiled from: DataMask.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DataMask {

    /* JADX INFO: renamed from: j */
    public static final DataMask f13516j;

    /* JADX INFO: renamed from: k */
    public static final DataMask f13517k;

    /* JADX INFO: renamed from: l */
    public static final DataMask f13518l;

    /* JADX INFO: renamed from: m */
    public static final DataMask f13519m;

    /* JADX INFO: renamed from: n */
    public static final DataMask f13520n;

    /* JADX INFO: renamed from: o */
    public static final DataMask f13521o;

    /* JADX INFO: renamed from: p */
    public static final DataMask f13522p;

    /* JADX INFO: renamed from: q */
    public static final DataMask f13523q;

    /* JADX INFO: renamed from: r */
    public static final /* synthetic */ DataMask[] f13524r;

    /* JADX INFO: renamed from: b.i.e.s.b.c$a */
    /* JADX INFO: compiled from: DataMask.java */
    public enum a extends DataMask {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // p007b.p225i.p414e.p434s.p435b.DataMask
        /* JADX INFO: renamed from: f */
        public boolean mo7089f(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    }

    /* JADX INFO: renamed from: b.i.e.s.b.c$b */
    /* JADX INFO: compiled from: DataMask.java */
    public enum b extends DataMask {
        public b(String str, int i) {
            super(str, i, null);
        }

        @Override // p007b.p225i.p414e.p434s.p435b.DataMask
        /* JADX INFO: renamed from: f */
        public boolean mo7089f(int i, int i2) {
            return (i & 1) == 0;
        }
    }

    /* JADX INFO: renamed from: b.i.e.s.b.c$c */
    /* JADX INFO: compiled from: DataMask.java */
    public enum c extends DataMask {
        public c(String str, int i) {
            super(str, i, null);
        }

        @Override // p007b.p225i.p414e.p434s.p435b.DataMask
        /* JADX INFO: renamed from: f */
        public boolean mo7089f(int i, int i2) {
            return i2 % 3 == 0;
        }
    }

    /* JADX INFO: renamed from: b.i.e.s.b.c$d */
    /* JADX INFO: compiled from: DataMask.java */
    public enum d extends DataMask {
        public d(String str, int i) {
            super(str, i, null);
        }

        @Override // p007b.p225i.p414e.p434s.p435b.DataMask
        /* JADX INFO: renamed from: f */
        public boolean mo7089f(int i, int i2) {
            return (i + i2) % 3 == 0;
        }
    }

    /* JADX INFO: renamed from: b.i.e.s.b.c$e */
    /* JADX INFO: compiled from: DataMask.java */
    public enum e extends DataMask {
        public e(String str, int i) {
            super(str, i, null);
        }

        @Override // p007b.p225i.p414e.p434s.p435b.DataMask
        /* JADX INFO: renamed from: f */
        public boolean mo7089f(int i, int i2) {
            return (((i2 / 3) + (i / 2)) & 1) == 0;
        }
    }

    /* JADX INFO: renamed from: b.i.e.s.b.c$f */
    /* JADX INFO: compiled from: DataMask.java */
    public enum f extends DataMask {
        public f(String str, int i) {
            super(str, i, null);
        }

        @Override // p007b.p225i.p414e.p434s.p435b.DataMask
        /* JADX INFO: renamed from: f */
        public boolean mo7089f(int i, int i2) {
            return (i * i2) % 6 == 0;
        }
    }

    /* JADX INFO: renamed from: b.i.e.s.b.c$g */
    /* JADX INFO: compiled from: DataMask.java */
    public enum g extends DataMask {
        public g(String str, int i) {
            super(str, i, null);
        }

        @Override // p007b.p225i.p414e.p434s.p435b.DataMask
        /* JADX INFO: renamed from: f */
        public boolean mo7089f(int i, int i2) {
            return (i * i2) % 6 < 3;
        }
    }

    /* JADX INFO: renamed from: b.i.e.s.b.c$h */
    /* JADX INFO: compiled from: DataMask.java */
    public enum h extends DataMask {
        public h(String str, int i) {
            super(str, i, null);
        }

        @Override // p007b.p225i.p414e.p434s.p435b.DataMask
        /* JADX INFO: renamed from: f */
        public boolean mo7089f(int i, int i2) {
            return ((((i * i2) % 3) + (i + i2)) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        f13516j = aVar;
        b bVar = new b("DATA_MASK_001", 1);
        f13517k = bVar;
        c cVar = new c("DATA_MASK_010", 2);
        f13518l = cVar;
        d dVar = new d("DATA_MASK_011", 3);
        f13519m = dVar;
        e eVar = new e("DATA_MASK_100", 4);
        f13520n = eVar;
        f fVar = new f("DATA_MASK_101", 5);
        f13521o = fVar;
        g gVar = new g("DATA_MASK_110", 6);
        f13522p = gVar;
        h hVar = new h("DATA_MASK_111", 7);
        f13523q = hVar;
        f13524r = new DataMask[]{aVar, bVar, cVar, dVar, eVar, fVar, gVar, hVar};
    }

    public DataMask(String str, int i, a aVar) {
    }

    public static DataMask valueOf(String str) {
        return (DataMask) Enum.valueOf(DataMask.class, str);
    }

    public static DataMask[] values() {
        return (DataMask[]) f13524r.clone();
    }

    /* JADX INFO: renamed from: f */
    public abstract boolean mo7089f(int i, int i2);

    /* JADX INFO: renamed from: g */
    public final void m7090g(BitMatrix bitMatrix, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (mo7089f(i2, i3)) {
                    bitMatrix.m6941b(i3, i2);
                }
            }
        }
    }
}
