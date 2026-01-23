package p507d0.p513e0.p514p.p515d;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import p507d0.p513e0.KParameter;
import p507d0.p513e0.p514p.p515d.ReflectProperties;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: d0.e0.p.d.o, reason: use source file name */
/* JADX INFO: compiled from: KParameterImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KParameterImpl implements KParameter {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f25034j = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(KParameterImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(KParameterImpl.class), "annotations", "getAnnotations()Ljava/util/List;"))};

    /* JADX INFO: renamed from: k */
    public final ReflectProperties.a f25035k;

    /* JADX INFO: renamed from: l */
    public final KCallableImpl<?> f25036l;

    /* JADX INFO: renamed from: m */
    public final int f25037m;

    /* JADX INFO: renamed from: n */
    public final KParameter.a f25038n;

    /* JADX INFO: renamed from: d0.e0.p.d.o$a */
    /* JADX INFO: compiled from: KParameterImpl.kt */
    public static final class a extends Lambda implements Function0<List<? extends Annotation>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends Annotation> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends Annotation> invoke2() {
            return util2.computeAnnotations(KParameterImpl.access$getDescriptor$p(KParameterImpl.this));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.o$b */
    /* JADX INFO: compiled from: KParameterImpl.kt */
    public static final class b extends Lambda implements Function0<Type> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Type invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Type invoke2() {
            ParameterDescriptor parameterDescriptorAccess$getDescriptor$p = KParameterImpl.access$getDescriptor$p(KParameterImpl.this);
            if (!(parameterDescriptorAccess$getDescriptor$p instanceof ReceiverParameterDescriptor) || !Intrinsics3.areEqual(util2.getInstanceReceiverParameter(KParameterImpl.this.getCallable().getDescriptor()), parameterDescriptorAccess$getDescriptor$p) || KParameterImpl.this.getCallable().getDescriptor().getKind() != CallableMemberDescriptor.a.FAKE_OVERRIDE) {
                return KParameterImpl.this.getCallable().getCaller().getParameterTypes().get(KParameterImpl.this.getIndex());
            }
            DeclarationDescriptor containingDeclaration = KParameterImpl.this.getCallable().getDescriptor().getContainingDeclaration();
            Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> javaClass = util2.toJavaClass((ClassDescriptor) containingDeclaration);
            if (javaClass != null) {
                return javaClass;
            }
            throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + parameterDescriptorAccess$getDescriptor$p);
        }
    }

    public KParameterImpl(KCallableImpl<?> kCallableImpl, int i, KParameter.a aVar, Function0<? extends ParameterDescriptor> function0) {
        Intrinsics3.checkNotNullParameter(kCallableImpl, "callable");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(function0, "computeDescriptor");
        this.f25036l = kCallableImpl;
        this.f25037m = i;
        this.f25038n = aVar;
        this.f25035k = ReflectProperties.lazySoft(function0);
        ReflectProperties.lazySoft(new a());
    }

    public static final /* synthetic */ ParameterDescriptor access$getDescriptor$p(KParameterImpl kParameterImpl) {
        return kParameterImpl.m10055a();
    }

    /* JADX INFO: renamed from: a */
    public final ParameterDescriptor m10055a() {
        return (ParameterDescriptor) this.f25035k.getValue(this, f25034j[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof KParameterImpl) {
            KParameterImpl kParameterImpl = (KParameterImpl) obj;
            if (Intrinsics3.areEqual(this.f25036l, kParameterImpl.f25036l) && getIndex() == kParameterImpl.getIndex()) {
                return true;
            }
        }
        return false;
    }

    public final KCallableImpl<?> getCallable() {
        return this.f25036l;
    }

    public int getIndex() {
        return this.f25037m;
    }

    @Override // p507d0.p513e0.KParameter
    public KParameter.a getKind() {
        return this.f25038n;
    }

    @Override // p507d0.p513e0.KParameter
    public String getName() {
        ParameterDescriptor parameterDescriptorM10055a = m10055a();
        if (!(parameterDescriptorM10055a instanceof ValueParameterDescriptor)) {
            parameterDescriptorM10055a = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) parameterDescriptorM10055a;
        if (valueParameterDescriptor == null || valueParameterDescriptor.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        Name name = valueParameterDescriptor.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "valueParameter.name");
        if (name.isSpecial()) {
            return null;
        }
        return name.asString();
    }

    @Override // p507d0.p513e0.KParameter
    public KType getType() {
        KotlinType type = m10055a().getType();
        Intrinsics3.checkNotNullExpressionValue(type, "descriptor.type");
        return new KTypeImpl(type, new b());
    }

    public int hashCode() {
        return Integer.valueOf(getIndex()).hashCode() + (this.f25036l.hashCode() * 31);
    }

    @Override // p507d0.p513e0.KParameter
    public boolean isOptional() {
        ParameterDescriptor parameterDescriptorM10055a = m10055a();
        if (!(parameterDescriptorM10055a instanceof ValueParameterDescriptor)) {
            parameterDescriptorM10055a = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) parameterDescriptorM10055a;
        if (valueParameterDescriptor != null) {
            return DescriptorUtils2.declaresOrInheritsDefaultValue(valueParameterDescriptor);
        }
        return false;
    }

    @Override // p507d0.p513e0.KParameter
    public boolean isVararg() {
        ParameterDescriptor parameterDescriptorM10055a = m10055a();
        return (parameterDescriptorM10055a instanceof ValueParameterDescriptor) && ((ValueParameterDescriptor) parameterDescriptorM10055a).getVarargElementType() != null;
    }

    public String toString() {
        return ReflectionObjectRenderer.f22349b.renderParameter(this);
    }
}
