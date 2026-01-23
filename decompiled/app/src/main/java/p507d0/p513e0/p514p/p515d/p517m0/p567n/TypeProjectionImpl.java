package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.y0, reason: use source file name */
/* JADX INFO: compiled from: TypeProjectionImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class TypeProjectionImpl extends TypeProjectionBase {

    /* JADX INFO: renamed from: a */
    public final Variance f24894a;

    /* JADX INFO: renamed from: b */
    public final KotlinType f24895b;

    public TypeProjectionImpl(Variance variance, KotlinType kotlinType) {
        if (variance == null) {
            m10039a(0);
            throw null;
        }
        if (kotlinType == null) {
            m10039a(1);
            throw null;
        }
        this.f24894a = variance;
        this.f24895b = kotlinType;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m10039a(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i == 3) {
            objArr[2] = "replaceType";
        } else if (i != 4 && i != 5) {
            if (i != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection
    public Variance getProjectionKind() {
        Variance variance = this.f24894a;
        if (variance != null) {
            return variance;
        }
        m10039a(4);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection
    public KotlinType getType() {
        KotlinType kotlinType = this.f24895b;
        if (kotlinType != null) {
            return kotlinType;
        }
        m10039a(5);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection
    public boolean isStarProjection() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection
    public TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner != null) {
            return new TypeProjectionImpl(this.f24894a, kotlinTypeRefiner.refineType(this.f24895b));
        }
        m10039a(6);
        throw null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TypeProjectionImpl(KotlinType kotlinType) {
        this(Variance.INVARIANT, kotlinType);
        if (kotlinType != null) {
        } else {
            m10039a(2);
            throw null;
        }
    }
}
