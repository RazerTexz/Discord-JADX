package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: JavaForKotlinOverridePropertyDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.e.a.h0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class JavaForKotlinOverridePropertyDescriptor extends JavaPropertyDescriptor {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaForKotlinOverridePropertyDescriptor(ClassDescriptor classDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor2, PropertyDescriptor propertyDescriptor) {
        super(classDescriptor, Annotations4.f22735f.getEMPTY(), simpleFunctionDescriptor.getModality(), simpleFunctionDescriptor.getVisibility(), simpleFunctionDescriptor2 != null, propertyDescriptor.getName(), simpleFunctionDescriptor.getSource(), null, CallableMemberDescriptor.a.DECLARATION, false, null);
        Intrinsics3.checkNotNullParameter(classDescriptor, "ownerDescriptor");
        Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "getterMethod");
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "overriddenProperty");
    }
}
