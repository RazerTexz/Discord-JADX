package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.r, reason: use source file name */
/* JADX INFO: compiled from: DescriptorVisibility.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DescriptorVisibility extends DescriptorVisibility2 {

    /* JADX INFO: renamed from: a */
    public final Visibility2 f23076a;

    public DescriptorVisibility(Visibility2 visibility2) {
        Intrinsics3.checkNotNullParameter(visibility2, "delegate");
        this.f23076a = visibility2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2
    public Visibility2 getDelegate() {
        return this.f23076a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2
    public String getInternalDisplayName() {
        return getDelegate().getInternalDisplayName();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2
    public DescriptorVisibility2 normalize() {
        DescriptorVisibility2 descriptorVisibility = DescriptorVisibilities.toDescriptorVisibility(getDelegate().normalize());
        Intrinsics3.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(delegate.normalize())");
        return descriptorVisibility;
    }
}
