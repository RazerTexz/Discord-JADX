package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ImplicitClassReceiver.kt */
/* renamed from: d0.e0.p.d.m0.k.a0.p.c, reason: use source file name */
/* loaded from: classes3.dex */
public class ImplicitClassReceiver implements ReceiverValue, ImplicitClassReceiver2 {

    /* renamed from: a */
    public final ClassDescriptor f24389a;

    /* renamed from: b */
    public final ClassDescriptor f24390b;

    public ImplicitClassReceiver(ClassDescriptor classDescriptor, ImplicitClassReceiver implicitClassReceiver) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        this.f24389a = classDescriptor;
        this.f24390b = classDescriptor;
    }

    public boolean equals(Object obj) {
        ClassDescriptor classDescriptor = this.f24389a;
        ImplicitClassReceiver implicitClassReceiver = obj instanceof ImplicitClassReceiver ? (ImplicitClassReceiver) obj : null;
        return Intrinsics3.areEqual(classDescriptor, implicitClassReceiver != null ? implicitClassReceiver.f24389a : null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ImplicitClassReceiver2
    public final ClassDescriptor getClassDescriptor() {
        return this.f24389a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ReceiverValue
    public /* bridge */ /* synthetic */ KotlinType getType() {
        return getType();
    }

    public int hashCode() {
        return this.f24389a.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Class{");
        sbM833U.append(getType());
        sbM833U.append('}');
        return sbM833U.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ReceiverValue
    public KotlinType4 getType() {
        KotlinType4 defaultType = this.f24389a.getDefaultType();
        Intrinsics3.checkNotNullExpressionValue(defaultType, "classDescriptor.defaultType");
        return defaultType;
    }
}
