package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l, reason: use source file name */
/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public class TypeSubstitution2 extends TypeSubstitution5 {

    /* JADX INFO: renamed from: b */
    public final TypeSubstitution5 f24796b;

    public TypeSubstitution2(TypeSubstitution5 typeSubstitution5) {
        Intrinsics3.checkNotNullParameter(typeSubstitution5, "substitution");
        this.f24796b = typeSubstitution5;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public boolean approximateCapturedTypes() {
        return this.f24796b.approximateCapturedTypes();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public Annotations4 filterAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        return this.f24796b.filterAnnotations(annotations4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "key");
        return this.f24796b.get(kotlinType);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public boolean isEmpty() {
        return this.f24796b.isEmpty();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5
    public KotlinType prepareTopLevelType(KotlinType kotlinType, Variance variance) {
        Intrinsics3.checkNotNullParameter(kotlinType, "topLevelType");
        Intrinsics3.checkNotNullParameter(variance, ModelAuditLogEntry.CHANGE_KEY_POSITION);
        return this.f24796b.prepareTopLevelType(kotlinType, variance);
    }
}
