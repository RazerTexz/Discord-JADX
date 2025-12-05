package p507d0.p592z.p594d;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: PropertyReference.java */
/* renamed from: d0.z.d.z, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class PropertyReference extends CallableReference implements KProperty {
    public PropertyReference() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && Intrinsics3.areEqual(getBoundReceiver(), propertyReference.getBoundReceiver());
        }
        if (obj instanceof KProperty) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // p507d0.p592z.p594d.CallableReference
    public /* bridge */ /* synthetic */ KCallable getReflected() {
        return getReflected();
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        KCallable kCallableCompute = compute();
        if (kCallableCompute != this) {
            return kCallableCompute.toString();
        }
        StringBuilder sbM833U = outline.m833U("property ");
        sbM833U.append(getName());
        sbM833U.append(" (Kotlin reflection is not available)");
        return sbM833U.toString();
    }

    public PropertyReference(Object obj) {
        super(obj);
    }

    @Override // p507d0.p592z.p594d.CallableReference
    public KProperty getReflected() {
        return (KProperty) super.getReflected();
    }

    public PropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
    }
}
