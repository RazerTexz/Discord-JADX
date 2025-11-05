package d0.e0.p.d;

import d0.e0.p.d.d;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.f.a0.a;
import d0.e0.p.d.m0.f.a0.b.e;
import d0.e0.p.d.m0.i.g;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RuntimeTypeMapper.kt */
/* loaded from: classes3.dex */
public abstract class e {

    /* compiled from: RuntimeTypeMapper.kt */
    public static final class a extends e {
        public final Field a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Field field) {
            super(null);
            d0.z.d.m.checkNotNullParameter(field, "field");
            this.a = field;
        }

        @Override // d0.e0.p.d.e
        public String asString() {
            StringBuilder sb = new StringBuilder();
            String name = this.a.getName();
            d0.z.d.m.checkNotNullExpressionValue(name, "field.name");
            sb.append(d0.e0.p.d.m0.e.a.z.getterName(name));
            sb.append("()");
            Class<?> type = this.a.getType();
            d0.z.d.m.checkNotNullExpressionValue(type, "field.type");
            sb.append(d0.e0.p.d.m0.c.k1.b.b.getDesc(type));
            return sb.toString();
        }

        public final Field getField() {
            return this.a;
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    public static final class b extends e {
        public final Method a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f3194b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method method, Method method2) {
            super(null);
            d0.z.d.m.checkNotNullParameter(method, "getterMethod");
            this.a = method;
            this.f3194b = method2;
        }

        @Override // d0.e0.p.d.e
        public String asString() {
            return h0.access$getSignature$p(this.a);
        }

        public final Method getGetterMethod() {
            return this.a;
        }

        public final Method getSetterMethod() {
            return this.f3194b;
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    public static final class c extends e {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final n0 f3195b;
        public final d0.e0.p.d.m0.f.n c;
        public final a.d d;
        public final d0.e0.p.d.m0.f.z.c e;
        public final d0.e0.p.d.m0.f.z.g f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0109  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c(n0 n0Var, d0.e0.p.d.m0.f.n nVar, a.d dVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar) {
            String string;
            String strK;
            super(null);
            d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
            d0.z.d.m.checkNotNullParameter(nVar, "proto");
            d0.z.d.m.checkNotNullParameter(dVar, "signature");
            d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
            d0.z.d.m.checkNotNullParameter(gVar, "typeTable");
            this.f3195b = n0Var;
            this.c = nVar;
            this.d = dVar;
            this.e = cVar;
            this.f = gVar;
            if (dVar.hasGetter()) {
                StringBuilder sb = new StringBuilder();
                a.c getter = dVar.getGetter();
                d0.z.d.m.checkNotNullExpressionValue(getter, "signature.getter");
                sb.append(cVar.getString(getter.getName()));
                a.c getter2 = dVar.getGetter();
                d0.z.d.m.checkNotNullExpressionValue(getter2, "signature.getter");
                sb.append(cVar.getString(getter2.getDesc()));
                strK = sb.toString();
            } else {
                e.a jvmFieldSignature$default = d0.e0.p.d.m0.f.a0.b.h.getJvmFieldSignature$default(d0.e0.p.d.m0.f.a0.b.h.a, nVar, cVar, gVar, false, 8, null);
                if (jvmFieldSignature$default == null) {
                    throw new a0("No field signature for property: " + n0Var);
                }
                String strComponent1 = jvmFieldSignature$default.component1();
                String strComponent2 = jvmFieldSignature$default.component2();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(d0.e0.p.d.m0.e.a.z.getterName(strComponent1));
                d0.e0.p.d.m0.c.m containingDeclaration = n0Var.getContainingDeclaration();
                d0.z.d.m.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
                if (d0.z.d.m.areEqual(n0Var.getVisibility(), d0.e0.p.d.m0.c.t.d) && (containingDeclaration instanceof d0.e0.p.d.m0.l.b.e0.d)) {
                    d0.e0.p.d.m0.f.c classProto = ((d0.e0.p.d.m0.l.b.e0.d) containingDeclaration).getClassProto();
                    g.f<d0.e0.p.d.m0.f.c, Integer> fVar = d0.e0.p.d.m0.f.a0.a.i;
                    d0.z.d.m.checkNotNullExpressionValue(fVar, "JvmProtoBuf.classModuleName");
                    Integer num = (Integer) d0.e0.p.d.m0.f.z.e.getExtensionOrNull(classProto, fVar);
                    String string2 = (num == null || (string2 = cVar.getString(num.intValue())) == null) ? "main" : string2;
                    StringBuilder sbU = b.d.b.a.a.U("$");
                    sbU.append(d0.e0.p.d.m0.g.f.sanitizeAsJavaIdentifier(string2));
                    string = sbU.toString();
                } else if (d0.z.d.m.areEqual(n0Var.getVisibility(), d0.e0.p.d.m0.c.t.a) && (containingDeclaration instanceof d0.e0.p.d.m0.c.e0)) {
                    Objects.requireNonNull(n0Var, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
                    d0.e0.p.d.m0.l.b.e0.f containerSource = ((d0.e0.p.d.m0.l.b.e0.j) n0Var).getContainerSource();
                    if (containerSource instanceof d0.e0.p.d.m0.e.b.j) {
                        d0.e0.p.d.m0.e.b.j jVar = (d0.e0.p.d.m0.e.b.j) containerSource;
                        if (jVar.getFacadeClassName() != null) {
                            StringBuilder sbU2 = b.d.b.a.a.U("$");
                            sbU2.append(jVar.getSimpleName().asString());
                            string = sbU2.toString();
                        }
                    }
                } else {
                    string = "";
                }
                strK = b.d.b.a.a.K(sb2, string, "()", strComponent2);
            }
            this.a = strK;
        }

        @Override // d0.e0.p.d.e
        public String asString() {
            return this.a;
        }

        public final n0 getDescriptor() {
            return this.f3195b;
        }

        public final d0.e0.p.d.m0.f.z.c getNameResolver() {
            return this.e;
        }

        public final d0.e0.p.d.m0.f.n getProto() {
            return this.c;
        }

        public final a.d getSignature() {
            return this.d;
        }

        public final d0.e0.p.d.m0.f.z.g getTypeTable() {
            return this.f;
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    public static final class d extends e {
        public final d.e a;

        /* renamed from: b, reason: collision with root package name */
        public final d.e f3196b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(d.e eVar, d.e eVar2) {
            super(null);
            d0.z.d.m.checkNotNullParameter(eVar, "getterSignature");
            this.a = eVar;
            this.f3196b = eVar2;
        }

        @Override // d0.e0.p.d.e
        public String asString() {
            return this.a.asString();
        }

        public final d.e getGetterSignature() {
            return this.a;
        }

        public final d.e getSetterSignature() {
            return this.f3196b;
        }
    }

    public e(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public abstract String asString();
}
