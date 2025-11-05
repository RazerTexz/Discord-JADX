package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.o.b;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
public abstract class k implements d0.e0.p.d.m0.o.b {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1<d0.e0.p.d.m0.b.h, c0> f3556b;
    public final String c;

    /* compiled from: modifierChecks.kt */
    public static final class a extends k {
        public static final a d = new a();

        /* compiled from: modifierChecks.kt */
        /* renamed from: d0.e0.p.d.m0.o.k$a$a, reason: collision with other inner class name */
        public static final class C0588a extends o implements Function1<d0.e0.p.d.m0.b.h, c0> {
            public static final C0588a j = new C0588a();

            public C0588a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ c0 invoke(d0.e0.p.d.m0.b.h hVar) {
                return invoke2(hVar);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final c0 invoke2(d0.e0.p.d.m0.b.h hVar) {
                m.checkNotNullParameter(hVar, "<this>");
                j0 booleanType = hVar.getBooleanType();
                m.checkNotNullExpressionValue(booleanType, "booleanType");
                return booleanType;
            }
        }

        public a() {
            super("Boolean", C0588a.j, null);
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class b extends k {
        public static final b d = new b();

        /* compiled from: modifierChecks.kt */
        public static final class a extends o implements Function1<d0.e0.p.d.m0.b.h, c0> {
            public static final a j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ c0 invoke(d0.e0.p.d.m0.b.h hVar) {
                return invoke2(hVar);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final c0 invoke2(d0.e0.p.d.m0.b.h hVar) {
                m.checkNotNullParameter(hVar, "<this>");
                j0 intType = hVar.getIntType();
                m.checkNotNullExpressionValue(intType, "intType");
                return intType;
            }
        }

        public b() {
            super("Int", a.j, null);
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class c extends k {
        public static final c d = new c();

        /* compiled from: modifierChecks.kt */
        public static final class a extends o implements Function1<d0.e0.p.d.m0.b.h, c0> {
            public static final a j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ c0 invoke(d0.e0.p.d.m0.b.h hVar) {
                return invoke2(hVar);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final c0 invoke2(d0.e0.p.d.m0.b.h hVar) {
                m.checkNotNullParameter(hVar, "<this>");
                j0 unitType = hVar.getUnitType();
                m.checkNotNullExpressionValue(unitType, "unitType");
                return unitType;
            }
        }

        public c() {
            super("Unit", a.j, null);
        }
    }

    public k(String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this.a = str;
        this.f3556b = function1;
        this.c = m.stringPlus("must return ", str);
    }

    @Override // d0.e0.p.d.m0.o.b
    public boolean check(x xVar) {
        m.checkNotNullParameter(xVar, "functionDescriptor");
        return m.areEqual(xVar.getReturnType(), this.f3556b.invoke(d0.e0.p.d.m0.k.x.a.getBuiltIns(xVar)));
    }

    @Override // d0.e0.p.d.m0.o.b
    public String getDescription() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.o.b
    public String invoke(x xVar) {
        return b.a.invoke(this, xVar);
    }
}
