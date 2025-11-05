package d0.e0.p.d;

import d0.e0.f;
import d0.e0.p.d.c0;
import d0.e0.p.d.m0.c.b;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.q0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;

/* compiled from: KParameterImpl.kt */
/* loaded from: classes3.dex */
public final class o implements d0.e0.f {
    public static final /* synthetic */ KProperty[] j = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(o.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(o.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    public final c0.a k;
    public final f<?> l;
    public final int m;
    public final f.a n;

    /* compiled from: KParameterImpl.kt */
    public static final class a extends d0.z.d.o implements Function0<List<? extends Annotation>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends Annotation> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends Annotation> invoke2() {
            return j0.computeAnnotations(o.access$getDescriptor$p(o.this));
        }
    }

    /* compiled from: KParameterImpl.kt */
    public static final class b extends d0.z.d.o implements Function0<Type> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Type invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Type invoke2() {
            d0.e0.p.d.m0.c.k0 k0VarAccess$getDescriptor$p = o.access$getDescriptor$p(o.this);
            if (!(k0VarAccess$getDescriptor$p instanceof q0) || !d0.z.d.m.areEqual(j0.getInstanceReceiverParameter(o.this.getCallable().getDescriptor()), k0VarAccess$getDescriptor$p) || o.this.getCallable().getDescriptor().getKind() != b.a.FAKE_OVERRIDE) {
                return o.this.getCallable().getCaller().getParameterTypes().get(o.this.getIndex());
            }
            d0.e0.p.d.m0.c.m containingDeclaration = o.this.getCallable().getDescriptor().getContainingDeclaration();
            Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> javaClass = j0.toJavaClass((d0.e0.p.d.m0.c.e) containingDeclaration);
            if (javaClass != null) {
                return javaClass;
            }
            throw new a0("Cannot determine receiver Java type of inherited declaration: " + k0VarAccess$getDescriptor$p);
        }
    }

    public o(f<?> fVar, int i, f.a aVar, Function0<? extends d0.e0.p.d.m0.c.k0> function0) {
        d0.z.d.m.checkNotNullParameter(fVar, "callable");
        d0.z.d.m.checkNotNullParameter(aVar, "kind");
        d0.z.d.m.checkNotNullParameter(function0, "computeDescriptor");
        this.l = fVar;
        this.m = i;
        this.n = aVar;
        this.k = c0.lazySoft(function0);
        c0.lazySoft(new a());
    }

    public static final /* synthetic */ d0.e0.p.d.m0.c.k0 access$getDescriptor$p(o oVar) {
        return oVar.a();
    }

    public final d0.e0.p.d.m0.c.k0 a() {
        return (d0.e0.p.d.m0.c.k0) this.k.getValue(this, j[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (d0.z.d.m.areEqual(this.l, oVar.l) && getIndex() == oVar.getIndex()) {
                return true;
            }
        }
        return false;
    }

    public final f<?> getCallable() {
        return this.l;
    }

    public int getIndex() {
        return this.m;
    }

    @Override // d0.e0.f
    public f.a getKind() {
        return this.n;
    }

    @Override // d0.e0.f
    public String getName() {
        d0.e0.p.d.m0.c.k0 k0VarA = a();
        if (!(k0VarA instanceof c1)) {
            k0VarA = null;
        }
        c1 c1Var = (c1) k0VarA;
        if (c1Var == null || c1Var.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        d0.e0.p.d.m0.g.e name = c1Var.getName();
        d0.z.d.m.checkNotNullExpressionValue(name, "valueParameter.name");
        if (name.isSpecial()) {
            return null;
        }
        return name.asString();
    }

    @Override // d0.e0.f
    public KType getType() {
        d0.e0.p.d.m0.n.c0 type = a().getType();
        d0.z.d.m.checkNotNullExpressionValue(type, "descriptor.type");
        return new x(type, new b());
    }

    public int hashCode() {
        return Integer.valueOf(getIndex()).hashCode() + (this.l.hashCode() * 31);
    }

    @Override // d0.e0.f
    public boolean isOptional() {
        d0.e0.p.d.m0.c.k0 k0VarA = a();
        if (!(k0VarA instanceof c1)) {
            k0VarA = null;
        }
        c1 c1Var = (c1) k0VarA;
        if (c1Var != null) {
            return d0.e0.p.d.m0.k.x.a.declaresOrInheritsDefaultValue(c1Var);
        }
        return false;
    }

    @Override // d0.e0.f
    public boolean isVararg() {
        d0.e0.p.d.m0.c.k0 k0VarA = a();
        return (k0VarA instanceof c1) && ((c1) k0VarA).getVarargElementType() != null;
    }

    public String toString() {
        return e0.f3197b.renderParameter(this);
    }
}
