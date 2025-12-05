package p507d0.p513e0.p514p.p515d;

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
import p007b.p100d.p104b.p105a.outline;
import p507d0.Lazy5;
import p507d0.LazyJVM;
import p507d0.Standard2;
import p507d0.p513e0.KClassifier;
import p507d0.p513e0.KTypeProjection;
import p507d0.p513e0.p514p.KTypesJvm;
import p507d0.p513e0.p514p.p515d.ReflectProperties;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.reflectClassUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Arrays;
import p507d0.p580t._Collections;
import p507d0.p592z.JvmClassMapping;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.KTypeBase;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: KTypeImpl.kt */
/* renamed from: d0.e0.p.d.x, reason: use source file name */
/* loaded from: classes3.dex */
public final class KTypeImpl implements KTypeBase {

    /* renamed from: j */
    public static final /* synthetic */ KProperty[] f25061j = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(KTypeImpl.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(KTypeImpl.class), "arguments", "getArguments()Ljava/util/List;"))};

    /* renamed from: k */
    public final ReflectProperties.a<Type> f25062k;

    /* renamed from: l */
    public final ReflectProperties.a f25063l;

    /* renamed from: m */
    public final ReflectProperties.a f25064m;

    /* renamed from: n */
    public final KotlinType f25065n;

    /* compiled from: KTypeImpl.kt */
    /* renamed from: d0.e0.p.d.x$a */
    public static final class a extends Lambda implements Function0<List<? extends KTypeProjection>> {
        public final /* synthetic */ Function0 $computeJavaType;

        /* compiled from: KTypeImpl.kt */
        /* renamed from: d0.e0.p.d.x$a$a, reason: collision with other inner class name */
        public static final class C13342a extends Lambda implements Function0<Type> {

            /* renamed from: $i */
            public final /* synthetic */ int f25066$i;
            public final /* synthetic */ Lazy $parameterizedTypeArguments$inlined;
            public final /* synthetic */ KProperty $parameterizedTypeArguments$metadata$inlined = null;
            public final /* synthetic */ a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C13342a(int i, a aVar, Lazy lazy, KProperty kProperty) {
                super(0);
                this.f25066$i = i;
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
                Type javaType = KTypeImpl.this.getJavaType();
                if (javaType instanceof Class) {
                    Class cls = (Class) javaType;
                    Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
                    Intrinsics3.checkNotNullExpressionValue(componentType, "if (javaType.isArray) ja…Type else Any::class.java");
                    return componentType;
                }
                if (javaType instanceof GenericArrayType) {
                    if (this.f25066$i == 0) {
                        Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
                        Intrinsics3.checkNotNullExpressionValue(genericComponentType, "javaType.genericComponentType");
                        return genericComponentType;
                    }
                    StringBuilder sbM833U = outline.m833U("Array type has been queried for a non-0th argument: ");
                    sbM833U.append(KTypeImpl.this);
                    throw new KotlinReflectionInternalError(sbM833U.toString());
                }
                if (!(javaType instanceof ParameterizedType)) {
                    StringBuilder sbM833U2 = outline.m833U("Non-generic type has been queried for arguments: ");
                    sbM833U2.append(KTypeImpl.this);
                    throw new KotlinReflectionInternalError(sbM833U2.toString());
                }
                Type type = (Type) ((List) this.$parameterizedTypeArguments$inlined.getValue()).get(this.f25066$i);
                if (type instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type;
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    Intrinsics3.checkNotNullExpressionValue(lowerBounds, "argument.lowerBounds");
                    Type type2 = (Type) _Arrays.firstOrNull(lowerBounds);
                    if (type2 != null) {
                        type = type2;
                    } else {
                        Type[] upperBounds = wildcardType.getUpperBounds();
                        Intrinsics3.checkNotNullExpressionValue(upperBounds, "argument.upperBounds");
                        type = (Type) _Arrays.first(upperBounds);
                    }
                }
                Intrinsics3.checkNotNullExpressionValue(type, "if (argument !is Wildcar…ument.upperBounds.first()");
                return type;
            }
        }

        /* compiled from: KTypeImpl.kt */
        /* renamed from: d0.e0.p.d.x$a$b */
        public static final class b extends Lambda implements Function0<List<? extends Type>> {
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
                Type javaType = KTypeImpl.this.getJavaType();
                Intrinsics3.checkNotNull(javaType);
                return reflectClassUtil.getParameterizedTypeArguments(javaType);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(0);
            this.$computeJavaType = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends KTypeProjection> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends KTypeProjection> invoke2() {
            KTypeProjection kTypeProjectionInvariant;
            List<TypeProjection> arguments = KTypeImpl.this.getType().getArguments();
            if (arguments.isEmpty()) {
                return Collections2.emptyList();
            }
            Lazy lazy = LazyJVM.lazy(Lazy5.PUBLICATION, new b());
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arguments, 10));
            int i = 0;
            for (Object obj : arguments) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                TypeProjection typeProjection = (TypeProjection) obj;
                if (typeProjection.isStarProjection()) {
                    kTypeProjectionInvariant = KTypeProjection.f22301b.getSTAR();
                } else {
                    KotlinType type = typeProjection.getType();
                    Intrinsics3.checkNotNullExpressionValue(type, "typeProjection.type");
                    KTypeImpl kTypeImpl = new KTypeImpl(type, this.$computeJavaType != null ? new C13342a(i, this, lazy, null) : null);
                    int iOrdinal = typeProjection.getProjectionKind().ordinal();
                    if (iOrdinal == 0) {
                        kTypeProjectionInvariant = KTypeProjection.f22301b.invariant(kTypeImpl);
                    } else if (iOrdinal == 1) {
                        kTypeProjectionInvariant = KTypeProjection.f22301b.contravariant(kTypeImpl);
                    } else {
                        if (iOrdinal != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        kTypeProjectionInvariant = KTypeProjection.f22301b.covariant(kTypeImpl);
                    }
                }
                arrayList.add(kTypeProjectionInvariant);
                i = i2;
            }
            return arrayList;
        }
    }

    /* compiled from: KTypeImpl.kt */
    /* renamed from: d0.e0.p.d.x$b */
    public static final class b extends Lambda implements Function0<KClassifier> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ KClassifier invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KClassifier invoke() {
            KTypeImpl kTypeImpl = KTypeImpl.this;
            return KTypeImpl.access$convert(kTypeImpl, kTypeImpl.getType());
        }
    }

    public KTypeImpl(KotlinType kotlinType, Function0<? extends Type> function0) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        this.f25065n = kotlinType;
        ReflectProperties.a<Type> aVarLazySoft = null;
        ReflectProperties.a<Type> aVar = (ReflectProperties.a) (!(function0 instanceof ReflectProperties.a) ? null : function0);
        if (aVar != null) {
            aVarLazySoft = aVar;
        } else if (function0 != null) {
            aVarLazySoft = ReflectProperties.lazySoft(function0);
        }
        this.f25062k = aVarLazySoft;
        this.f25063l = ReflectProperties.lazySoft(new b());
        this.f25064m = ReflectProperties.lazySoft(new a(function0));
    }

    public static final /* synthetic */ KClassifier access$convert(KTypeImpl kTypeImpl, KotlinType kotlinType) {
        return kTypeImpl.m10057a(kotlinType);
    }

    /* renamed from: a */
    public final KClassifier m10057a(KotlinType kotlinType) {
        KotlinType type;
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            if (declarationDescriptor instanceof TypeParameterDescriptor) {
                return new KTypeParameterImpl(null, (TypeParameterDescriptor) declarationDescriptor);
            }
            if (declarationDescriptor instanceof TypeAliasDescriptor) {
                throw new Standard2(outline.m883w("An operation is not implemented: ", "Type alias classifiers are not yet supported"));
            }
            return null;
        }
        Class<?> javaClass = util2.toJavaClass((ClassDescriptor) declarationDescriptor);
        if (javaClass == null) {
            return null;
        }
        if (!javaClass.isArray()) {
            if (TypeUtils.isNullableType(kotlinType)) {
                return new KClassImpl(javaClass);
            }
            Class<?> primitiveByWrapper = reflectClassUtil.getPrimitiveByWrapper(javaClass);
            if (primitiveByWrapper != null) {
                javaClass = primitiveByWrapper;
            }
            return new KClassImpl(javaClass);
        }
        TypeProjection typeProjection = (TypeProjection) _Collections.singleOrNull((List) kotlinType.getArguments());
        if (typeProjection == null || (type = typeProjection.getType()) == null) {
            return new KClassImpl(javaClass);
        }
        Intrinsics3.checkNotNullExpressionValue(type, "type.arguments.singleOrN…return KClassImpl(jClass)");
        KClassifier kClassifierM10057a = m10057a(type);
        if (kClassifierM10057a != null) {
            return new KClassImpl(reflectClassUtil.createArrayType(JvmClassMapping.getJavaClass(KTypesJvm.getJvmErasure(kClassifierM10057a))));
        }
        throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
    }

    public boolean equals(Object obj) {
        return (obj instanceof KTypeImpl) && Intrinsics3.areEqual(this.f25065n, ((KTypeImpl) obj).f25065n);
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> getArguments() {
        return (List) this.f25064m.getValue(this, f25061j[1]);
    }

    @Override // kotlin.reflect.KType
    public KClassifier getClassifier() {
        return (KClassifier) this.f25063l.getValue(this, f25061j[0]);
    }

    @Override // p507d0.p592z.p594d.KTypeBase
    public Type getJavaType() {
        ReflectProperties.a<Type> aVar = this.f25062k;
        if (aVar != null) {
            return aVar.invoke();
        }
        return null;
    }

    public final KotlinType getType() {
        return this.f25065n;
    }

    public int hashCode() {
        return this.f25065n.hashCode();
    }

    public String toString() {
        return ReflectionObjectRenderer.f22349b.renderType(this.f25065n);
    }

    public /* synthetic */ KTypeImpl(KotlinType kotlinType, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kotlinType, (i & 2) != 0 ? null : function0);
    }
}
