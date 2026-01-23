package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.z, reason: use source file name */
/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeSubstitution4 extends TypeSubstitution5 {

    /* JADX INFO: renamed from: b */
    public final TypeParameterDescriptor[] f24896b;

    /* JADX INFO: renamed from: c */
    public final TypeProjection[] f24897c;

    /* JADX INFO: renamed from: d */
    public final boolean f24898d;

    public /* synthetic */ TypeSubstitution4(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeParameterDescriptorArr, typeProjectionArr, (i & 4) != 0 ? false : z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public boolean approximateContravariantCapturedTypes() {
        return this.f24898d;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "key");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        TypeParameterDescriptor typeParameterDescriptor = declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null;
        if (typeParameterDescriptor == null) {
            return null;
        }
        int index = typeParameterDescriptor.getIndex();
        TypeParameterDescriptor[] typeParameterDescriptorArr = this.f24896b;
        if (index >= typeParameterDescriptorArr.length || !Intrinsics3.areEqual(typeParameterDescriptorArr[index].getTypeConstructor(), typeParameterDescriptor.getTypeConstructor())) {
            return null;
        }
        return this.f24897c[index];
    }

    public final TypeProjection[] getArguments() {
        return this.f24897c;
    }

    public final TypeParameterDescriptor[] getParameters() {
        return this.f24896b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public boolean isEmpty() {
        return this.f24897c.length == 0;
    }

    public TypeSubstitution4(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z2) {
        Intrinsics3.checkNotNullParameter(typeParameterDescriptorArr, "parameters");
        Intrinsics3.checkNotNullParameter(typeProjectionArr, "arguments");
        this.f24896b = typeParameterDescriptorArr;
        this.f24897c = typeProjectionArr;
        this.f24898d = z2;
        int length = typeParameterDescriptorArr.length;
        int length2 = typeProjectionArr.length;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TypeSubstitution4(List<? extends TypeParameterDescriptor> list, List<? extends TypeProjection> list2) {
        Intrinsics3.checkNotNullParameter(list, "parameters");
        Intrinsics3.checkNotNullParameter(list2, "argumentsList");
        Object[] array = list.toArray(new TypeParameterDescriptor[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        TypeParameterDescriptor[] typeParameterDescriptorArr = (TypeParameterDescriptor[]) array;
        Object[] array2 = list2.toArray(new TypeProjection[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        this(typeParameterDescriptorArr, (TypeProjection[]) array2, false, 4, null);
    }
}
