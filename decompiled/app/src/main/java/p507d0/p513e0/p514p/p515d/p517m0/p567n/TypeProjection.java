package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11982k;

/* compiled from: TypeProjection.java */
/* renamed from: d0.e0.p.d.m0.n.w0, reason: use source file name */
/* loaded from: classes3.dex */
public interface TypeProjection extends InterfaceC11982k {
    Variance getProjectionKind();

    KotlinType getType();

    boolean isStarProjection();

    TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner);
}
