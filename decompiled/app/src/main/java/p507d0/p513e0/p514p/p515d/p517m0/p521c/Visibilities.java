package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import androidx.core.os.EnvironmentCompat;
import java.util.Map;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Visibilities.kt */
/* renamed from: d0.e0.p.d.m0.c.e1, reason: use source file name */
/* loaded from: classes3.dex */
public final class Visibilities {

    /* renamed from: a */
    public static final Visibilities f22694a = new Visibilities();

    /* renamed from: b */
    public static final Map<Visibility2, Integer> f22695b;

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$a */
    public static final class a extends Visibility2 {

        /* renamed from: c */
        public static final a f22696c = new a();

        public a() {
            super("inherited", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$b */
    public static final class b extends Visibility2 {

        /* renamed from: c */
        public static final b f22697c = new b();

        public b() {
            super("internal", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$c */
    public static final class c extends Visibility2 {

        /* renamed from: c */
        public static final c f22698c = new c();

        public c() {
            super("invisible_fake", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$d */
    public static final class d extends Visibility2 {

        /* renamed from: c */
        public static final d f22699c = new d();

        public d() {
            super("local", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$e */
    public static final class e extends Visibility2 {

        /* renamed from: c */
        public static final e f22700c = new e();

        public e() {
            super("private", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$f */
    public static final class f extends Visibility2 {

        /* renamed from: c */
        public static final f f22701c = new f();

        public f() {
            super("private_to_this", false);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.Visibility2
        public String getInternalDisplayName() {
            return "private/*private to this*/";
        }
    }

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$g */
    public static final class g extends Visibility2 {

        /* renamed from: c */
        public static final g f22702c = new g();

        public g() {
            super("protected", true);
        }
    }

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$h */
    public static final class h extends Visibility2 {

        /* renamed from: c */
        public static final h f22703c = new h();

        public h() {
            super("public", true);
        }
    }

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$i */
    public static final class i extends Visibility2 {

        /* renamed from: c */
        public static final i f22704c = new i();

        public i() {
            super(EnvironmentCompat.MEDIA_UNKNOWN, false);
        }
    }

    static {
        Map mapCreateMapBuilder = MapsJVM.createMapBuilder();
        mapCreateMapBuilder.put(f.f22701c, 0);
        mapCreateMapBuilder.put(e.f22700c, 0);
        mapCreateMapBuilder.put(b.f22697c, 1);
        mapCreateMapBuilder.put(g.f22702c, 1);
        mapCreateMapBuilder.put(h.f22703c, 2);
        f22695b = MapsJVM.build(mapCreateMapBuilder);
    }

    public final Integer compareLocal$compiler_common(Visibility2 visibility2, Visibility2 visibility22) {
        Intrinsics3.checkNotNullParameter(visibility2, "first");
        Intrinsics3.checkNotNullParameter(visibility22, "second");
        if (visibility2 == visibility22) {
            return 0;
        }
        Map<Visibility2, Integer> map = f22695b;
        Integer num = map.get(visibility2);
        Integer num2 = map.get(visibility22);
        if (num == null || num2 == null || Intrinsics3.areEqual(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean isPrivate(Visibility2 visibility2) {
        Intrinsics3.checkNotNullParameter(visibility2, "visibility");
        return visibility2 == e.f22700c || visibility2 == f.f22701c;
    }
}
