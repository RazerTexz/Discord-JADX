package p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjectionImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.u.a.d, reason: use source file name */
/* JADX INFO: compiled from: CapturedTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CapturedTypeConstructor4 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.u.a.d$a */
    /* JADX INFO: compiled from: CapturedTypeConstructor.kt */
    public static final class a extends Lambda implements Function0<KotlinType> {
        public final /* synthetic */ TypeProjection $this_createCapturedIfNeeded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TypeProjection typeProjection) {
            super(0);
            this.$this_createCapturedIfNeeded = typeProjection;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ KotlinType invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType invoke() {
            KotlinType type = this.$this_createCapturedIfNeeded.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "this@createCapturedIfNeeded.type");
            return type;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.u.a.d$b */
    /* JADX INFO: compiled from: CapturedTypeConstructor.kt */
    public static final class b extends TypeSubstitution2 {

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ boolean f24434c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z2, TypeSubstitution5 typeSubstitution5) {
            super(typeSubstitution5);
            this.f24434c = z2;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
        public boolean approximateContravariantCapturedTypes() {
            return this.f24434c;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution2, p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
        public TypeProjection get(KotlinType kotlinType) {
            Intrinsics3.checkNotNullParameter(kotlinType, "key");
            TypeProjection typeProjection = super.get(kotlinType);
            if (typeProjection == null) {
                return null;
            }
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
            return CapturedTypeConstructor4.access$createCapturedIfNeeded(typeProjection, declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final TypeProjection m9941a(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null || typeProjection.getProjectionKind() == Variance.INVARIANT) {
            return typeProjection;
        }
        if (typeParameterDescriptor.getVariance() != typeProjection.getProjectionKind()) {
            return new TypeProjectionImpl(createCapturedType(typeProjection));
        }
        if (!typeProjection.isStarProjection()) {
            return new TypeProjectionImpl(typeProjection.getType());
        }
        StorageManager storageManager = LockBasedStorageManager.f24710b;
        Intrinsics3.checkNotNullExpressionValue(storageManager, "NO_LOCKS");
        return new TypeProjectionImpl(new SpecialTypes2(storageManager, new a(typeProjection)));
    }

    public static final /* synthetic */ TypeProjection access$createCapturedIfNeeded(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        return m9941a(typeProjection, typeParameterDescriptor);
    }

    public static final KotlinType createCapturedType(TypeProjection typeProjection) {
        Intrinsics3.checkNotNullParameter(typeProjection, "typeProjection");
        return new CapturedTypeConstructor(typeProjection, null, false, null, 14, null);
    }

    public static final boolean isCaptured(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.getConstructor() instanceof CapturedTypeConstructor2;
    }

    public static final TypeSubstitution5 wrapWithCapturingSubstitution(TypeSubstitution5 typeSubstitution5, boolean z2) {
        Intrinsics3.checkNotNullParameter(typeSubstitution5, "<this>");
        if (!(typeSubstitution5 instanceof TypeSubstitution4)) {
            return new b(z2, typeSubstitution5);
        }
        TypeSubstitution4 typeSubstitution4 = (TypeSubstitution4) typeSubstitution5;
        TypeParameterDescriptor[] parameters = typeSubstitution4.getParameters();
        List<Tuples2> listZip = _Arrays.zip(typeSubstitution4.getArguments(), typeSubstitution4.getParameters());
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listZip, 10));
        for (Tuples2 tuples2 : listZip) {
            arrayList.add(m9941a((TypeProjection) tuples2.getFirst(), (TypeParameterDescriptor) tuples2.getSecond()));
        }
        Object[] array = arrayList.toArray(new TypeProjection[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return new TypeSubstitution4(parameters, (TypeProjection[]) array, z2);
    }

    public static /* synthetic */ TypeSubstitution5 wrapWithCapturingSubstitution$default(TypeSubstitution5 typeSubstitution5, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return wrapWithCapturingSubstitution(typeSubstitution5, z2);
    }
}
