package b.i.e.s.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DataMask.java */
/* loaded from: classes3.dex */
public abstract class c {
    public static final c j;
    public static final c k;
    public static final c l;
    public static final c m;
    public static final c n;
    public static final c o;
    public static final c p;
    public static final c q;
    public static final /* synthetic */ c[] r;

    /* compiled from: DataMask.java */
    public enum a extends c {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.e.s.b.c
        public boolean f(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    }

    /* compiled from: DataMask.java */
    public enum b extends c {
        public b(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.e.s.b.c
        public boolean f(int i, int i2) {
            return (i & 1) == 0;
        }
    }

    /* compiled from: DataMask.java */
    /* renamed from: b.i.e.s.b.c$c, reason: collision with other inner class name */
    public enum C0160c extends c {
        public C0160c(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.e.s.b.c
        public boolean f(int i, int i2) {
            return i2 % 3 == 0;
        }
    }

    /* compiled from: DataMask.java */
    public enum d extends c {
        public d(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.e.s.b.c
        public boolean f(int i, int i2) {
            return (i + i2) % 3 == 0;
        }
    }

    /* compiled from: DataMask.java */
    public enum e extends c {
        public e(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.e.s.b.c
        public boolean f(int i, int i2) {
            return (((i2 / 3) + (i / 2)) & 1) == 0;
        }
    }

    /* compiled from: DataMask.java */
    public enum f extends c {
        public f(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.e.s.b.c
        public boolean f(int i, int i2) {
            return (i * i2) % 6 == 0;
        }
    }

    /* compiled from: DataMask.java */
    public enum g extends c {
        public g(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.e.s.b.c
        public boolean f(int i, int i2) {
            return (i * i2) % 6 < 3;
        }
    }

    /* compiled from: DataMask.java */
    public enum h extends c {
        public h(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.e.s.b.c
        public boolean f(int i, int i2) {
            return ((((i * i2) % 3) + (i + i2)) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        j = aVar;
        b bVar = new b("DATA_MASK_001", 1);
        k = bVar;
        C0160c c0160c = new C0160c("DATA_MASK_010", 2);
        l = c0160c;
        d dVar = new d("DATA_MASK_011", 3);
        m = dVar;
        e eVar = new e("DATA_MASK_100", 4);
        n = eVar;
        f fVar = new f("DATA_MASK_101", 5);
        o = fVar;
        g gVar = new g("DATA_MASK_110", 6);
        p = gVar;
        h hVar = new h("DATA_MASK_111", 7);
        q = hVar;
        r = new c[]{aVar, bVar, c0160c, dVar, eVar, fVar, gVar, hVar};
    }

    public c(String str, int i, a aVar) {
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) r.clone();
    }

    public abstract boolean f(int i, int i2);

    public final void g(b.i.e.n.b bVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (f(i2, i3)) {
                    bVar.b(i3, i2);
                }
            }
        }
    }
}
