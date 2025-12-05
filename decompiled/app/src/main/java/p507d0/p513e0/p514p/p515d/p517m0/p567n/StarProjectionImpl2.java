package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.Lazy5;
import p507d0.LazyJVM;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: StarProjectionImpl.kt */
/* renamed from: d0.e0.p.d.m0.n.o0, reason: use source file name */
/* loaded from: classes3.dex */
public final class StarProjectionImpl2 extends TypeProjectionBase {

    /* renamed from: a */
    public final TypeParameterDescriptor f24848a;

    /* renamed from: b */
    public final Lazy f24849b;

    /* compiled from: StarProjectionImpl.kt */
    /* renamed from: d0.e0.p.d.m0.n.o0$a */
    public static final class a extends Lambda implements Function0<KotlinType> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ KotlinType invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType invoke() {
            return StarProjectionImpl3.starProjectionType(StarProjectionImpl2.access$getTypeParameter$p(StarProjectionImpl2.this));
        }
    }

    public StarProjectionImpl2(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        this.f24848a = typeParameterDescriptor;
        this.f24849b = LazyJVM.lazy(Lazy5.PUBLICATION, new a());
    }

    public static final /* synthetic */ TypeParameterDescriptor access$getTypeParameter$p(StarProjectionImpl2 starProjectionImpl2) {
        return starProjectionImpl2.f24848a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection
    public KotlinType getType() {
        return (KotlinType) this.f24849b.getValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection
    public boolean isStarProjection() {
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection
    public TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
