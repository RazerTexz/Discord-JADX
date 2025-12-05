package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;

/* compiled from: KotlinTypeChecker.java */
/* renamed from: d0.e0.p.d.m0.n.l1.f, reason: use source file name */
/* loaded from: classes3.dex */
public interface KotlinTypeChecker {

    /* renamed from: a */
    public static final KotlinTypeChecker f24806a = NewKotlinTypeChecker.f24820b.getDefault();

    /* compiled from: KotlinTypeChecker.java */
    /* renamed from: d0.e0.p.d.m0.n.l1.f$a */
    public interface a {
        boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2);
    }

    boolean equalTypes(KotlinType kotlinType, KotlinType kotlinType2);

    boolean isSubtypeOf(KotlinType kotlinType, KotlinType kotlinType2);
}
