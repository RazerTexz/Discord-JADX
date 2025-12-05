package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: JavaDescriptorUtil.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.l.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class JavaDescriptorUtil {
    public static final boolean isJavaField(PropertyDescriptor propertyDescriptor) {
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "<this>");
        return propertyDescriptor.getGetter() == null;
    }
}
