package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.q, reason: use source file name */
/* JADX INFO: compiled from: mappingUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class mappingUtil {
    public static final TypeSubstitution3 createMappedTypeParametersSubstitution(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "from");
        Intrinsics3.checkNotNullParameter(classDescriptor2, "to");
        classDescriptor.getDeclaredTypeParameters().size();
        classDescriptor2.getDeclaredTypeParameters().size();
        TypeSubstitution3.a aVar = TypeSubstitution3.f24889b;
        List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(declaredTypeParameters, "from.declaredTypeParameters");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(declaredTypeParameters, 10));
        Iterator<T> it = declaredTypeParameters.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeParameterDescriptor) it.next()).getTypeConstructor());
        }
        List<TypeParameterDescriptor> declaredTypeParameters2 = classDescriptor2.getDeclaredTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(declaredTypeParameters2, "to.declaredTypeParameters");
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(declaredTypeParameters2, 10));
        Iterator<T> it2 = declaredTypeParameters2.iterator();
        while (it2.hasNext()) {
            KotlinType4 defaultType = ((TypeParameterDescriptor) it2.next()).getDefaultType();
            Intrinsics3.checkNotNullExpressionValue(defaultType, "it.defaultType");
            arrayList2.add(TypeUtils2.asTypeProjection(defaultType));
        }
        return TypeSubstitution3.a.createByConstructorsMap$default(aVar, Maps6.toMap(_Collections.zip(arrayList, arrayList2)), false, 2, null);
    }
}
