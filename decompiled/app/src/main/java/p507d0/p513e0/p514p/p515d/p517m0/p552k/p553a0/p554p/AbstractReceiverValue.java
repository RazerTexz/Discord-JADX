package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;

/* compiled from: AbstractReceiverValue.java */
/* renamed from: d0.e0.p.d.m0.k.a0.p.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractReceiverValue implements ReceiverValue {

    /* renamed from: a */
    public final KotlinType f24386a;

    /* renamed from: b */
    public final ReceiverValue f24387b;

    public AbstractReceiverValue(KotlinType kotlinType, ReceiverValue receiverValue) {
        if (kotlinType == null) {
            m9914a(0);
            throw null;
        }
        this.f24386a = kotlinType;
        this.f24387b = receiverValue == null ? this : receiverValue;
    }

    /* renamed from: a */
    public static /* synthetic */ void m9914a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i == 1) {
            objArr[1] = "getType";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 1 && i != 2) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ReceiverValue
    public KotlinType getType() {
        KotlinType kotlinType = this.f24386a;
        if (kotlinType != null) {
            return kotlinType;
        }
        m9914a(1);
        throw null;
    }
}
