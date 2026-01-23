package p507d0.p592z.p594d;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: d0.z.d.j, reason: use source file name */
/* JADX INFO: compiled from: FunctionReference.java */
/* JADX INFO: loaded from: classes3.dex */
public class FunctionReference extends CallableReference implements FunctionBase, KFunction {
    private final int arity;
    private final int flags;

    public FunctionReference(int i) {
        this(i, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    @Override // p507d0.p592z.p594d.CallableReference
    public KCallable computeReflected() {
        return Reflection2.function(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return Intrinsics3.areEqual(getOwner(), functionReference.getOwner()) && getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && this.flags == functionReference.flags && this.arity == functionReference.arity && Intrinsics3.areEqual(getBoundReceiver(), functionReference.getBoundReceiver());
        }
        if (obj instanceof KFunction) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // p507d0.p592z.p594d.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @Override // p507d0.p592z.p594d.CallableReference
    public /* bridge */ /* synthetic */ KCallable getReflected() {
        return getReflected();
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable, kotlin.reflect.KFunction
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        KCallable kCallableCompute = compute();
        if (kCallableCompute != this) {
            return kCallableCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        StringBuilder sbM833U = outline.m833U("function ");
        sbM833U.append(getName());
        sbM833U.append(" (Kotlin reflection is not available)");
        return sbM833U.toString();
    }

    public FunctionReference(int i, Object obj) {
        this(i, obj, null, null, null, 0);
    }

    @Override // p507d0.p592z.p594d.CallableReference
    public KFunction getReflected() {
        return (KFunction) super.getReflected();
    }

    public FunctionReference(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = i2 >> 1;
    }
}
