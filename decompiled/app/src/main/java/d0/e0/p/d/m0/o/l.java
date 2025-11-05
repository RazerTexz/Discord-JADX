package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.o.b;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
public abstract class l implements d0.e0.p.d.m0.o.b {
    public final String a;

    /* compiled from: modifierChecks.kt */
    public static final class a extends l {

        /* renamed from: b, reason: collision with root package name */
        public final int f3557b;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(int i) {
            StringBuilder sbV = b.d.b.a.a.V("must have at least ", i, " value parameter");
            sbV.append(i > 1 ? "s" : "");
            super(sbV.toString(), null);
            this.f3557b = i;
        }

        @Override // d0.e0.p.d.m0.o.b
        public boolean check(x xVar) {
            m.checkNotNullParameter(xVar, "functionDescriptor");
            return xVar.getValueParameters().size() >= this.f3557b;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class b extends l {

        /* renamed from: b, reason: collision with root package name */
        public final int f3558b;

        public b(int i) {
            super(b.d.b.a.a.r("must have exactly ", i, " value parameters"), null);
            this.f3558b = i;
        }

        @Override // d0.e0.p.d.m0.o.b
        public boolean check(x xVar) {
            m.checkNotNullParameter(xVar, "functionDescriptor");
            return xVar.getValueParameters().size() == this.f3558b;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class c extends l {

        /* renamed from: b, reason: collision with root package name */
        public static final c f3559b = new c();

        public c() {
            super("must have no value parameters", null);
        }

        @Override // d0.e0.p.d.m0.o.b
        public boolean check(x xVar) {
            m.checkNotNullParameter(xVar, "functionDescriptor");
            return xVar.getValueParameters().isEmpty();
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class d extends l {

        /* renamed from: b, reason: collision with root package name */
        public static final d f3560b = new d();

        public d() {
            super("must have a single value parameter", null);
        }

        @Override // d0.e0.p.d.m0.o.b
        public boolean check(x xVar) {
            m.checkNotNullParameter(xVar, "functionDescriptor");
            return xVar.getValueParameters().size() == 1;
        }
    }

    public l(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.a = str;
    }

    @Override // d0.e0.p.d.m0.o.b
    public String getDescription() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.o.b
    public String invoke(x xVar) {
        return b.a.invoke(this, xVar);
    }
}
