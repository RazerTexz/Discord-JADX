package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ErrorType.kt */
/* renamed from: d0.e0.p.d.m0.n.s, reason: use source file name */
/* loaded from: classes3.dex */
public class ErrorType2 extends KotlinType4 {

    /* renamed from: k */
    public final TypeConstructor f24871k;

    /* renamed from: l */
    public final MemberScope3 f24872l;

    /* renamed from: m */
    public final List<TypeProjection> f24873m;

    /* renamed from: n */
    public final boolean f24874n;

    /* renamed from: o */
    public final String f24875o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ErrorType2(TypeConstructor typeConstructor, MemberScope3 memberScope3) {
        this(typeConstructor, memberScope3, null, false, null, 28, null);
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics3.checkNotNullParameter(memberScope3, "memberScope");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ErrorType2(TypeConstructor typeConstructor, MemberScope3 memberScope3, List<? extends TypeProjection> list, boolean z2) {
        this(typeConstructor, memberScope3, list, z2, null, 16, null);
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics3.checkNotNullParameter(memberScope3, "memberScope");
        Intrinsics3.checkNotNullParameter(list, "arguments");
    }

    public /* synthetic */ ErrorType2(TypeConstructor typeConstructor, MemberScope3 memberScope3, List list, boolean z2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeConstructor, memberScope3, (i & 4) != 0 ? Collections2.emptyList() : list, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? "???" : str);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public Annotations4 getAnnotations() {
        return Annotations4.f22735f.getEMPTY();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public List<TypeProjection> getArguments() {
        return this.f24873m;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public TypeConstructor getConstructor() {
        return this.f24871k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public MemberScope3 getMemberScope() {
        return this.f24872l;
    }

    public String getPresentableName() {
        return this.f24875o;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public boolean isMarkedNullable() {
        return this.f24874n;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public ErrorType2 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public KotlinType4 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getConstructor());
        sb.append(getArguments().isEmpty() ? "" : _Collections.joinToString(getArguments(), ", ", "<", ">", -1, "...", null));
        return sb.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public KotlinType4 makeNullableAsSpecified(boolean z2) {
        return new ErrorType2(getConstructor(), getMemberScope(), getArguments(), z2, null, 16, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ErrorType2(TypeConstructor typeConstructor, MemberScope3 memberScope3, List<? extends TypeProjection> list, boolean z2, String str) {
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics3.checkNotNullParameter(memberScope3, "memberScope");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        Intrinsics3.checkNotNullParameter(str, "presentableName");
        this.f24871k = typeConstructor;
        this.f24872l = memberScope3;
        this.f24873m = list;
        this.f24874n = z2;
        this.f24875o = str;
    }
}
