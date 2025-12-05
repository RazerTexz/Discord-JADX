package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: DisjointKeysUnionTypeSubstitution.kt */
/* renamed from: d0.e0.p.d.m0.n.p, reason: use source file name */
/* loaded from: classes3.dex */
public final class DisjointKeysUnionTypeSubstitution extends TypeSubstitution5 {

    /* renamed from: b */
    public static final a f24852b = new a(null);

    /* renamed from: c */
    public final TypeSubstitution5 f24853c;

    /* renamed from: d */
    public final TypeSubstitution5 f24854d;

    /* compiled from: DisjointKeysUnionTypeSubstitution.kt */
    /* renamed from: d0.e0.p.d.m0.n.p$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final TypeSubstitution5 create(TypeSubstitution5 typeSubstitution5, TypeSubstitution5 typeSubstitution52) {
            Intrinsics3.checkNotNullParameter(typeSubstitution5, "first");
            Intrinsics3.checkNotNullParameter(typeSubstitution52, "second");
            return typeSubstitution5.isEmpty() ? typeSubstitution52 : typeSubstitution52.isEmpty() ? typeSubstitution5 : new DisjointKeysUnionTypeSubstitution(typeSubstitution5, typeSubstitution52, null);
        }
    }

    public DisjointKeysUnionTypeSubstitution(TypeSubstitution5 typeSubstitution5, TypeSubstitution5 typeSubstitution52, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24853c = typeSubstitution5;
        this.f24854d = typeSubstitution52;
    }

    public static final TypeSubstitution5 create(TypeSubstitution5 typeSubstitution5, TypeSubstitution5 typeSubstitution52) {
        return f24852b.create(typeSubstitution5, typeSubstitution52);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public boolean approximateCapturedTypes() {
        return this.f24853c.approximateCapturedTypes() || this.f24854d.approximateCapturedTypes();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public boolean approximateContravariantCapturedTypes() {
        return this.f24853c.approximateContravariantCapturedTypes() || this.f24854d.approximateContravariantCapturedTypes();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public Annotations4 filterAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        return this.f24854d.filterAnnotations(this.f24853c.filterAnnotations(annotations4));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "key");
        TypeProjection typeProjection = this.f24853c.get(kotlinType);
        return typeProjection == null ? this.f24854d.get(kotlinType) : typeProjection;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public boolean isEmpty() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public KotlinType prepareTopLevelType(KotlinType kotlinType, Variance variance) {
        Intrinsics3.checkNotNullParameter(kotlinType, "topLevelType");
        Intrinsics3.checkNotNullParameter(variance, ModelAuditLogEntry.CHANGE_KEY_POSITION);
        return this.f24854d.prepareTopLevelType(this.f24853c.prepareTopLevelType(kotlinType, variance), variance);
    }
}
