package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleCapability;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ResolutionAnchorProvider.kt */
/* renamed from: d0.e0.p.d.m0.k.r, reason: use source file name */
/* loaded from: classes3.dex */
public final class ResolutionAnchorProvider2 {

    /* renamed from: a */
    public static final ModuleCapability<ResolutionAnchorProvider> f24427a = new ModuleCapability<>("ResolutionAnchorProvider");

    public static final ModuleDescriptor2 getResolutionAnchorIfAny(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "<this>");
        ResolutionAnchorProvider resolutionAnchorProvider = (ResolutionAnchorProvider) moduleDescriptor2.getCapability(f24427a);
        if (resolutionAnchorProvider == null) {
            return null;
        }
        return resolutionAnchorProvider.getResolutionAnchor(moduleDescriptor2);
    }
}
