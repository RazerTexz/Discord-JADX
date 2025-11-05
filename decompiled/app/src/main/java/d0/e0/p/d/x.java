package d0.e0.p.d;

import d0.e0.p.d.c0;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.w0;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: KTypeImpl.kt */
/* loaded from: classes3.dex */
public final class x implements d0.z.d.n {
    public static final /* synthetic */ KProperty[] j = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(x.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(x.class), "arguments", "getArguments()Ljava/util/List;"))};
    public final c0.a<Type> k;
    public final c0.a l;
    public final c0.a m;
    public final d0.e0.p.d.m0.n.c0 n;

    /* compiled from: KTypeImpl.kt */
    public static final class a extends d0.z.d.o implements Function0<List<? extends d0.e0.i>> {
        public final /* synthetic */ Function0 $computeJavaType;

        /* compiled from: KTypeImpl.kt */
        /* renamed from: d0.e0.p.d.x$a$a, reason: collision with other inner class name */
        public static final class C0593a extends d0.z.d.o implements Function0<Type> {
            public final /* synthetic */ int $i;
            public final /* synthetic */ Lazy $parameterizedTypeArguments$inlined;
            public final /* synthetic */ KProperty $parameterizedTypeArguments$metadata$inlined = null;
            public final /* synthetic */ a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0593a(int i, a aVar, Lazy lazy, KProperty kProperty) {
                super(0);
                this.$i = i;
                this.this$0 = aVar;
                this.$parameterizedTypeArguments$inlined = lazy;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Type invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Type invoke2() {
                Type javaType = x.this.getJavaType();
                if (javaType instanceof Class) {
                    Class cls = (Class) javaType;
                    Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
                    d0.z.d.m.checkNotNullExpressionValue(componentType, "if (javaType.isArray) ja…Type else Any::class.java");
                    return componentType;
                }
                if (javaType instanceof GenericArrayType) {
                    if (this.$i == 0) {
                        Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
                        d0.z.d.m.checkNotNullExpressionValue(genericComponentType, "javaType.genericComponentType");
                        return genericComponentType;
                    }
                    StringBuilder sbU = b.d.b.a.a.U("Array type has been queried for a non-0th argument: ");
                    sbU.append(x.this);
                    throw new a0(sbU.toString());
                }
                if (!(javaType instanceof ParameterizedType)) {
                    StringBuilder sbU2 = b.d.b.a.a.U("Non-generic type has been queried for arguments: ");
                    sbU2.append(x.this);
                    throw new a0(sbU2.toString());
                }
                Type type = (Type) ((List) this.$parameterizedTypeArguments$inlined.getValue()).get(this.$i);
                if (type instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type;
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    d0.z.d.m.checkNotNullExpressionValue(lowerBounds, "argument.lowerBounds");
                    Type type2 = (Type) d0.t.k.firstOrNull(lowerBounds);
                    if (type2 != null) {
                        type = type2;
                    } else {
                        Type[] upperBounds = wildcardType.getUpperBounds();
                        d0.z.d.m.checkNotNullExpressionValue(upperBounds, "argument.upperBounds");
                        type = (Type) d0.t.k.first(upperBounds);
                    }
                }
                d0.z.d.m.checkNotNullExpressionValue(type, "if (argument !is Wildcar…ument.upperBounds.first()");
                return type;
            }
        }

        /* compiled from: KTypeImpl.kt */
        public static final class b extends d0.z.d.o implements Function0<List<? extends Type>> {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends Type> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends Type> invoke2() {
                Type javaType = x.this.getJavaType();
                d0.z.d.m.checkNotNull(javaType);
                return d0.e0.p.d.m0.c.k1.b.b.getParameterizedTypeArguments(javaType);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(0);
            this.$computeJavaType = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends d0.e0.i> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends d0.e0.i> invoke2() {
            d0.e0.i iVarInvariant;
            List<w0> arguments = x.this.getType().getArguments();
            if (arguments.isEmpty()) {
                return d0.t.n.emptyList();
            }
            Lazy lazy = d0.g.lazy(d0.i.PUBLICATION, new b());
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(arguments, 10));
            int i = 0;
            for (Object obj : arguments) {
                int i2 = i + 1;
                if (i < 0) {
                    d0.t.n.throwIndexOverflow();
                }
                w0 w0Var = (w0) obj;
                if (w0Var.isStarProjection()) {
                    iVarInvariant = d0.e0.i.f3190b.getSTAR();
                } else {
                    d0.e0.p.d.m0.n.c0 type = w0Var.getType();
                    d0.z.d.m.checkNotNullExpressionValue(type, "typeProjection.type");
                    x xVar = new x(type, this.$computeJavaType != null ? new C0593a(i, this, lazy, null) : null);
                    int iOrdinal = w0Var.getProjectionKind().ordinal();
                    if (iOrdinal == 0) {
                        iVarInvariant = d0.e0.i.f3190b.invariant(xVar);
                    } else if (iOrdinal == 1) {
                        iVarInvariant = d0.e0.i.f3190b.contravariant(xVar);
                    } else {
                        if (iOrdinal != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        iVarInvariant = d0.e0.i.f3190b.covariant(xVar);
                    }
                }
                arrayList.add(iVarInvariant);
                i = i2;
            }
            return arrayList;
        }
    }

    /* compiled from: KTypeImpl.kt */
    public static final class b extends d0.z.d.o implements Function0<d0.e0.d> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ d0.e0.d invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final d0.e0.d invoke() {
            x xVar = x.this;
            return x.access$convert(xVar, xVar.getType());
        }
    }

    public x(d0.e0.p.d.m0.n.c0 c0Var, Function0<? extends Type> function0) {
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        this.n = c0Var;
        c0.a<Type> aVarLazySoft = null;
        c0.a<Type> aVar = (c0.a) (!(function0 instanceof c0.a) ? null : function0);
        if (aVar != null) {
            aVarLazySoft = aVar;
        } else if (function0 != null) {
            aVarLazySoft = c0.lazySoft(function0);
        }
        this.k = aVarLazySoft;
        this.l = c0.lazySoft(new b());
        this.m = c0.lazySoft(new a(function0));
    }

    public static final /* synthetic */ d0.e0.d access$convert(x xVar, d0.e0.p.d.m0.n.c0 c0Var) {
        return xVar.a(c0Var);
    }

    public final d0.e0.d a(d0.e0.p.d.m0.n.c0 c0Var) {
        d0.e0.p.d.m0.n.c0 type;
        d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof d0.e0.p.d.m0.c.e)) {
            if (declarationDescriptor instanceof z0) {
                return new y(null, (z0) declarationDescriptor);
            }
            if (declarationDescriptor instanceof y0) {
                throw new d0.j(b.d.b.a.a.w("An operation is not implemented: ", "Type alias classifiers are not yet supported"));
            }
            return null;
        }
        Class<?> javaClass = j0.toJavaClass((d0.e0.p.d.m0.c.e) declarationDescriptor);
        if (javaClass == null) {
            return null;
        }
        if (!javaClass.isArray()) {
            if (e1.isNullableType(c0Var)) {
                return new h(javaClass);
            }
            Class<?> primitiveByWrapper = d0.e0.p.d.m0.c.k1.b.b.getPrimitiveByWrapper(javaClass);
            if (primitiveByWrapper != null) {
                javaClass = primitiveByWrapper;
            }
            return new h(javaClass);
        }
        w0 w0Var = (w0) d0.t.u.singleOrNull((List) c0Var.getArguments());
        if (w0Var == null || (type = w0Var.getType()) == null) {
            return new h(javaClass);
        }
        d0.z.d.m.checkNotNullExpressionValue(type, "type.arguments.singleOrN…return KClassImpl(jClass)");
        d0.e0.d dVarA = a(type);
        if (dVarA != null) {
            return new h(d0.e0.p.d.m0.c.k1.b.b.createArrayType(d0.z.a.getJavaClass(d0.e0.p.a.getJvmErasure(dVarA))));
        }
        throw new a0("Cannot determine classifier for array element type: " + this);
    }

    public boolean equals(Object obj) {
        return (obj instanceof x) && d0.z.d.m.areEqual(this.n, ((x) obj).n);
    }

    @Override // kotlin.reflect.KType
    public List<d0.e0.i> getArguments() {
        return (List) this.m.getValue(this, j[1]);
    }

    @Override // kotlin.reflect.KType
    public d0.e0.d getClassifier() {
        return (d0.e0.d) this.l.getValue(this, j[0]);
    }

    @Override // d0.z.d.n
    public Type getJavaType() {
        c0.a<Type> aVar = this.k;
        if (aVar != null) {
            return aVar.invoke();
        }
        return null;
    }

    public final d0.e0.p.d.m0.n.c0 getType() {
        return this.n;
    }

    public int hashCode() {
        return this.n.hashCode();
    }

    public String toString() {
        return e0.f3197b.renderType(this.n);
    }

    public /* synthetic */ x(d0.e0.p.d.m0.n.c0 c0Var, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c0Var, (i & 2) != 0 ? null : function0);
    }
}
