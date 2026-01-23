package p507d0.p513e0.p514p.p515d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.KClass;
import p507d0.p513e0.KTypeParameter;
import p507d0.p513e0.KVariance;
import p507d0.p513e0.p514p.p515d.ReflectProperties;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.ReflectKotlinClass2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.JvmPackagePartSource;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedContainerSource2;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p580t.Iterables2;
import p507d0.p592z.JvmClassMapping;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;
import p507d0.p592z.p594d.TypeParameterReference;

/* JADX INFO: renamed from: d0.e0.p.d.y, reason: use source file name */
/* JADX INFO: compiled from: KTypeParameterImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KTypeParameterImpl implements KTypeParameter {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f25067j = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(KTypeParameterImpl.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};

    /* JADX INFO: renamed from: k */
    public final ReflectProperties.a f25068k;

    /* JADX INFO: renamed from: l */
    public final KTypeParameterOwnerImpl f25069l;

    /* JADX INFO: renamed from: m */
    public final TypeParameterDescriptor f25070m;

    /* JADX INFO: renamed from: d0.e0.p.d.y$a */
    /* JADX INFO: compiled from: KTypeParameterImpl.kt */
    public static final class a extends Lambda implements Function0<List<? extends KTypeImpl>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends KTypeImpl> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends KTypeImpl> invoke2() {
            List<KotlinType> upperBounds = KTypeParameterImpl.this.getDescriptor().getUpperBounds();
            Intrinsics3.checkNotNullExpressionValue(upperBounds, "descriptor.upperBounds");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(upperBounds, 10));
            Iterator<T> it = upperBounds.iterator();
            while (it.hasNext()) {
                arrayList.add(new KTypeImpl((KotlinType) it.next(), null, 2, null));
            }
            return arrayList;
        }
    }

    public KTypeParameterImpl(KTypeParameterOwnerImpl kTypeParameterOwnerImpl, TypeParameterDescriptor typeParameterDescriptor) {
        Class<?> klass;
        KClassImpl<?> kClassImplM10058a;
        Object objAccept;
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "descriptor");
        this.f25070m = typeParameterDescriptor;
        this.f25068k = ReflectProperties.lazySoft(new a());
        if (kTypeParameterOwnerImpl == null) {
            DeclarationDescriptor containingDeclaration = getDescriptor().getContainingDeclaration();
            Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof ClassDescriptor) {
                objAccept = m10058a((ClassDescriptor) containingDeclaration);
            } else {
                if (!(containingDeclaration instanceof CallableMemberDescriptor)) {
                    throw new KotlinReflectionInternalError("Unknown type parameter container: " + containingDeclaration);
                }
                DeclarationDescriptor containingDeclaration2 = ((CallableMemberDescriptor) containingDeclaration).getContainingDeclaration();
                Intrinsics3.checkNotNullExpressionValue(containingDeclaration2, "declaration.containingDeclaration");
                if (containingDeclaration2 instanceof ClassDescriptor) {
                    kClassImplM10058a = m10058a((ClassDescriptor) containingDeclaration2);
                } else {
                    DeserializedMemberDescriptor3 deserializedMemberDescriptor3 = (DeserializedMemberDescriptor3) (!(containingDeclaration instanceof DeserializedMemberDescriptor3) ? null : containingDeclaration);
                    if (deserializedMemberDescriptor3 == null) {
                        throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + containingDeclaration);
                    }
                    DeserializedContainerSource2 containerSource = deserializedMemberDescriptor3.getContainerSource();
                    JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource) (containerSource instanceof JvmPackagePartSource ? containerSource : null);
                    KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource != null ? jvmPackagePartSource.getKnownJvmBinaryClass() : null;
                    ReflectKotlinClass2 reflectKotlinClass2 = (ReflectKotlinClass2) (knownJvmBinaryClass instanceof ReflectKotlinClass2 ? knownJvmBinaryClass : null);
                    if (reflectKotlinClass2 == null || (klass = reflectKotlinClass2.getKlass()) == null) {
                        throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + deserializedMemberDescriptor3);
                    }
                    KClass kotlinClass = JvmClassMapping.getKotlinClass(klass);
                    Objects.requireNonNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                    kClassImplM10058a = (KClassImpl) kotlinClass;
                }
                objAccept = containingDeclaration.accept(new util(kClassImplM10058a), Unit.f27425a);
            }
            Intrinsics3.checkNotNullExpressionValue(objAccept, "when (val declaration = … $declaration\")\n        }");
            kTypeParameterOwnerImpl = (KTypeParameterOwnerImpl) objAccept;
        }
        this.f25069l = kTypeParameterOwnerImpl;
    }

    /* JADX INFO: renamed from: a */
    public final KClassImpl<?> m10058a(ClassDescriptor classDescriptor) {
        Class<?> javaClass = util2.toJavaClass(classDescriptor);
        KClassImpl<?> kClassImpl = (KClassImpl) (javaClass != null ? JvmClassMapping.getKotlinClass(javaClass) : null);
        if (kClassImpl != null) {
            return kClassImpl;
        }
        StringBuilder sbM833U = outline.m833U("Type parameter container is not resolved: ");
        sbM833U.append(classDescriptor.getContainingDeclaration());
        throw new KotlinReflectionInternalError(sbM833U.toString());
    }

    public boolean equals(Object obj) {
        if (obj instanceof KTypeParameterImpl) {
            KTypeParameterImpl kTypeParameterImpl = (KTypeParameterImpl) obj;
            if (Intrinsics3.areEqual(this.f25069l, kTypeParameterImpl.f25069l) && Intrinsics3.areEqual(getName(), kTypeParameterImpl.getName())) {
                return true;
            }
        }
        return false;
    }

    public TypeParameterDescriptor getDescriptor() {
        return this.f25070m;
    }

    @Override // p507d0.p513e0.KTypeParameter
    public String getName() {
        String strAsString = getDescriptor().getName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        return strAsString;
    }

    @Override // p507d0.p513e0.KTypeParameter
    public List<KType> getUpperBounds() {
        return (List) this.f25068k.getValue(this, f25067j[0]);
    }

    @Override // p507d0.p513e0.KTypeParameter
    public KVariance getVariance() {
        int iOrdinal = getDescriptor().getVariance().ordinal();
        if (iOrdinal == 0) {
            return KVariance.INVARIANT;
        }
        if (iOrdinal == 1) {
            return KVariance.IN;
        }
        if (iOrdinal == 2) {
            return KVariance.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public int hashCode() {
        return getName().hashCode() + (this.f25069l.hashCode() * 31);
    }

    public String toString() {
        return TypeParameterReference.f25289j.toString(this);
    }
}
