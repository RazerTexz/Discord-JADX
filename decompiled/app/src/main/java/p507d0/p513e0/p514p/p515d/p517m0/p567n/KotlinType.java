package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.NewKotlinTypeChecker5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.c0, reason: use source file name */
/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class KotlinType implements Annotations3, InterfaceC11979h {

    /* JADX INFO: renamed from: j */
    public int f24744j;

    public KotlinType() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KotlinType)) {
            return false;
        }
        KotlinType kotlinType = (KotlinType) obj;
        return isMarkedNullable() == kotlinType.isMarkedNullable() && NewKotlinTypeChecker5.f24828a.strictEqualTypes(unwrap(), kotlinType.unwrap());
    }

    public abstract List<TypeProjection> getArguments();

    public abstract TypeConstructor getConstructor();

    public abstract MemberScope3 getMemberScope();

    public final int hashCode() {
        int iHashCode;
        int i = this.f24744j;
        if (i != 0) {
            return i;
        }
        if (KotlinType2.isError(this)) {
            iHashCode = super.hashCode();
        } else {
            iHashCode = (isMarkedNullable() ? 1 : 0) + ((getArguments().hashCode() + (getConstructor().hashCode() * 31)) * 31);
        }
        this.f24744j = iHashCode;
        return iHashCode;
    }

    public abstract boolean isMarkedNullable();

    public abstract KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner);

    public abstract KotlinType3 unwrap();

    public KotlinType(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
