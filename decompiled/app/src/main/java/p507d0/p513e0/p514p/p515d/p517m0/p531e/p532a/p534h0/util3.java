package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Tuples2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ValueParameterDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JvmAnnotationNames;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaStaticClassScope2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11831w;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: util.kt */
/* renamed from: d0.e0.p.d.m0.e.a.h0.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class util3 {
    public static final List<ValueParameterDescriptor> copyValueParameters(Collection<util4> collection, Collection<? extends ValueParameterDescriptor> collection2, CallableDescriptor callableDescriptor) {
        Intrinsics3.checkNotNullParameter(collection, "newValueParametersTypes");
        Intrinsics3.checkNotNullParameter(collection2, "oldValueParameters");
        Intrinsics3.checkNotNullParameter(callableDescriptor, "newOwner");
        collection.size();
        collection2.size();
        List<Tuples2> listZip = _Collections.zip(collection, collection2);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listZip, 10));
        for (Tuples2 tuples2 : listZip) {
            util4 util4Var = (util4) tuples2.component1();
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) tuples2.component2();
            int index = valueParameterDescriptor.getIndex();
            Annotations4 annotations = valueParameterDescriptor.getAnnotations();
            Name name = valueParameterDescriptor.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "oldParameter.name");
            KotlinType type = util4Var.getType();
            boolean hasDefaultValue = util4Var.getHasDefaultValue();
            boolean zIsCrossinline = valueParameterDescriptor.isCrossinline();
            boolean zIsNoinline = valueParameterDescriptor.isNoinline();
            KotlinType arrayElementType = valueParameterDescriptor.getVarargElementType() != null ? DescriptorUtils2.getModule(callableDescriptor).getBuiltIns().getArrayElementType(util4Var.getType()) : null;
            SourceElement source = valueParameterDescriptor.getSource();
            Intrinsics3.checkNotNullExpressionValue(source, "oldParameter.source");
            arrayList.add(new ValueParameterDescriptorImpl(callableDescriptor, null, index, annotations, name, type, hasDefaultValue, zIsCrossinline, zIsNoinline, arrayElementType, source));
        }
        return arrayList;
    }

    public static final AnnotationDefaultValue getDefaultValueFromAnnotation(ValueParameterDescriptor valueParameterDescriptor) {
        AbstractC11815g<?> abstractC11815gFirstArgument;
        C11831w c11831w;
        String value;
        Intrinsics3.checkNotNullParameter(valueParameterDescriptor, "<this>");
        Annotations4 annotations = valueParameterDescriptor.getAnnotations();
        FqName fqName = JvmAnnotationNames.f23164r;
        Intrinsics3.checkNotNullExpressionValue(fqName, "DEFAULT_VALUE_FQ_NAME");
        AnnotationDescriptor annotationDescriptorFindAnnotation = annotations.findAnnotation(fqName);
        if (annotationDescriptorFindAnnotation == null || (abstractC11815gFirstArgument = DescriptorUtils2.firstArgument(annotationDescriptorFindAnnotation)) == null) {
            c11831w = null;
        } else {
            if (!(abstractC11815gFirstArgument instanceof C11831w)) {
                abstractC11815gFirstArgument = null;
            }
            c11831w = (C11831w) abstractC11815gFirstArgument;
        }
        if (c11831w != null && (value = c11831w.getValue()) != null) {
            return new AnnotationDefaultValue3(value);
        }
        Annotations4 annotations2 = valueParameterDescriptor.getAnnotations();
        FqName fqName2 = JvmAnnotationNames.f23165s;
        Intrinsics3.checkNotNullExpressionValue(fqName2, "DEFAULT_NULL_FQ_NAME");
        if (annotations2.hasAnnotation(fqName2)) {
            return AnnotationDefaultValue2.f23272a;
        }
        return null;
    }

    public static final LazyJavaStaticClassScope2 getParentJavaStaticClassScope(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "<this>");
        ClassDescriptor superClassNotAny = DescriptorUtils2.getSuperClassNotAny(classDescriptor);
        if (superClassNotAny == null) {
            return null;
        }
        MemberScope3 staticScope = superClassNotAny.getStaticScope();
        LazyJavaStaticClassScope2 lazyJavaStaticClassScope2 = staticScope instanceof LazyJavaStaticClassScope2 ? (LazyJavaStaticClassScope2) staticScope : null;
        return lazyJavaStaticClassScope2 == null ? getParentJavaStaticClassScope(superClassNotAny) : lazyJavaStaticClassScope2;
    }
}
