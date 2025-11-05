package d0.e0.p.d.m0.c;

import androidx.core.os.EnvironmentCompat;
import java.util.Map;

/* compiled from: Visibilities.kt */
/* loaded from: classes3.dex */
public final class e1 {
    public static final e1 a = new e1();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<f1, Integer> f3246b;

    /* compiled from: Visibilities.kt */
    public static final class a extends f1 {
        public static final a c = new a();

        public a() {
            super("inherited", false);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class b extends f1 {
        public static final b c = new b();

        public b() {
            super("internal", false);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class c extends f1 {
        public static final c c = new c();

        public c() {
            super("invisible_fake", false);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class d extends f1 {
        public static final d c = new d();

        public d() {
            super("local", false);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class e extends f1 {
        public static final e c = new e();

        public e() {
            super("private", false);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class f extends f1 {
        public static final f c = new f();

        public f() {
            super("private_to_this", false);
        }

        @Override // d0.e0.p.d.m0.c.f1
        public String getInternalDisplayName() {
            return "private/*private to this*/";
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class g extends f1 {
        public static final g c = new g();

        public g() {
            super("protected", true);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class h extends f1 {
        public static final h c = new h();

        public h() {
            super("public", true);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class i extends f1 {
        public static final i c = new i();

        public i() {
            super(EnvironmentCompat.MEDIA_UNKNOWN, false);
        }
    }

    static {
        Map mapCreateMapBuilder = d0.t.g0.createMapBuilder();
        mapCreateMapBuilder.put(f.c, 0);
        mapCreateMapBuilder.put(e.c, 0);
        mapCreateMapBuilder.put(b.c, 1);
        mapCreateMapBuilder.put(g.c, 1);
        mapCreateMapBuilder.put(h.c, 2);
        f3246b = d0.t.g0.build(mapCreateMapBuilder);
    }

    public final Integer compareLocal$compiler_common(f1 f1Var, f1 f1Var2) {
        d0.z.d.m.checkNotNullParameter(f1Var, "first");
        d0.z.d.m.checkNotNullParameter(f1Var2, "second");
        if (f1Var == f1Var2) {
            return 0;
        }
        Map<f1, Integer> map = f3246b;
        Integer num = map.get(f1Var);
        Integer num2 = map.get(f1Var2);
        if (num == null || num2 == null || d0.z.d.m.areEqual(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean isPrivate(f1 f1Var) {
        d0.z.d.m.checkNotNullParameter(f1Var, "visibility");
        return f1Var == e.c || f1Var == f.c;
    }
}
