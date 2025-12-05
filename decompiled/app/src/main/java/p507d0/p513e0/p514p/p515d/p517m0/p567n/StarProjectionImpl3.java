package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StarProjectionImpl.kt */
/* renamed from: d0.e0.p.d.m0.n.p0, reason: use source file name */
/* loaded from: classes3.dex */
public final class StarProjectionImpl3 {

    /* compiled from: StarProjectionImpl.kt */
    /* renamed from: d0.e0.p.d.m0.n.p0$a */
    public static final class a extends TypeSubstitution3 {

        /* renamed from: c */
        public final /* synthetic */ List<TypeConstructor> f24855c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends TypeConstructor> list) {
            this.f24855c = list;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution3
        public TypeProjection get(TypeConstructor typeConstructor) {
            Intrinsics3.checkNotNullParameter(typeConstructor, "key");
            if (!this.f24855c.contains(typeConstructor)) {
                return null;
            }
            ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
            Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            return TypeUtils.makeStarProjection((TypeParameterDescriptor) declarationDescriptor);
        }
    }

    public static final KotlinType starProjectionType(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "<this>");
        List<TypeParameterDescriptor> parameters = ((ClassifierDescriptorWithTypeParameters) typeParameterDescriptor.getContainingDeclaration()).getTypeConstructor().getParameters();
        Intrinsics3.checkNotNullExpressionValue(parameters, "classDescriptor.typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameters, 10));
        Iterator<T> it = parameters.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeParameterDescriptor) it.next()).getTypeConstructor());
        }
        TypeSubstitutor2 typeSubstitutor2Create = TypeSubstitutor2.create(new a(arrayList));
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics3.checkNotNullExpressionValue(upperBounds, "this.upperBounds");
        KotlinType kotlinTypeSubstitute = typeSubstitutor2Create.substitute((KotlinType) _Collections.first((List) upperBounds), Variance.OUT_VARIANCE);
        if (kotlinTypeSubstitute != null) {
            return kotlinTypeSubstitute;
        }
        KotlinType4 defaultBound = DescriptorUtils2.getBuiltIns(typeParameterDescriptor).getDefaultBound();
        Intrinsics3.checkNotNullExpressionValue(defaultBound, "builtIns.defaultBound");
        return defaultBound;
    }
}
