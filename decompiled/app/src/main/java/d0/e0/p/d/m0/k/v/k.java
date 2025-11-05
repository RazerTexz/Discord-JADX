package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public abstract class k extends g<Unit> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3474b = new a(null);

    /* compiled from: constantValues.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final k create(String str) {
            d0.z.d.m.checkNotNullParameter(str, "message");
            return new b(str);
        }
    }

    /* compiled from: constantValues.kt */
    public static final class b extends k {
        public final String c;

        public b(String str) {
            d0.z.d.m.checkNotNullParameter(str, "message");
            this.c = str;
        }

        @Override // d0.e0.p.d.m0.k.v.g
        public /* bridge */ /* synthetic */ c0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
            return getType(c0Var);
        }

        @Override // d0.e0.p.d.m0.k.v.g
        public String toString() {
            return this.c;
        }

        @Override // d0.e0.p.d.m0.k.v.g
        public j0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
            d0.z.d.m.checkNotNullParameter(c0Var, "module");
            j0 j0VarCreateErrorType = d0.e0.p.d.m0.n.t.createErrorType(this.c);
            d0.z.d.m.checkNotNullExpressionValue(j0VarCreateErrorType, "createErrorType(message)");
            return j0VarCreateErrorType;
        }
    }

    public k() {
        super(Unit.a);
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public /* bridge */ /* synthetic */ Unit getValue() {
        return getValue2();
    }

    @Override // d0.e0.p.d.m0.k.v.g
    /* renamed from: getValue, reason: avoid collision after fix types in other method */
    public Unit getValue2() {
        throw new UnsupportedOperationException();
    }
}
