package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ReceiverValue;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: DescriptorVisibility.kt */
/* renamed from: d0.e0.p.d.m0.c.u, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class DescriptorVisibility2 {
    public final Integer compareTo(DescriptorVisibility2 descriptorVisibility2) {
        Intrinsics3.checkNotNullParameter(descriptorVisibility2, "visibility");
        return getDelegate().compareTo(descriptorVisibility2.getDelegate());
    }

    public abstract Visibility2 getDelegate();

    public abstract String getInternalDisplayName();

    public final boolean isPublicAPI() {
        return getDelegate().isPublicAPI();
    }

    public abstract boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor);

    public abstract DescriptorVisibility2 normalize();

    public final String toString() {
        return getDelegate().toString();
    }
}
