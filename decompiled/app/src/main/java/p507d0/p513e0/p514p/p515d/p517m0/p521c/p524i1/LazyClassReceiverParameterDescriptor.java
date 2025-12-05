package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ImplicitClassReceiver;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ReceiverValue;

/* compiled from: LazyClassReceiverParameterDescriptor.java */
/* renamed from: d0.e0.p.d.m0.c.i1.r, reason: use source file name */
/* loaded from: classes3.dex */
public class LazyClassReceiverParameterDescriptor extends AbstractReceiverParameterDescriptor {

    /* renamed from: m */
    public final ClassDescriptor f22973m;

    /* renamed from: n */
    public final ImplicitClassReceiver f22974n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyClassReceiverParameterDescriptor(ClassDescriptor classDescriptor) {
        super(Annotations4.f22735f.getEMPTY());
        if (classDescriptor == null) {
            m9427a(0);
            throw null;
        }
        this.f22973m = classDescriptor;
        this.f22974n = new ImplicitClassReceiver(classDescriptor, null);
    }

    /* renamed from: a */
    public static /* synthetic */ void m9427a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 1) {
            objArr[1] = "getValue";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i != 1 && i != 2) {
            if (i != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        ClassDescriptor classDescriptor = this.f22973m;
        if (classDescriptor != null) {
            return classDescriptor;
        }
        m9427a(2);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor
    public ReceiverValue getValue() {
        ImplicitClassReceiver implicitClassReceiver = this.f22974n;
        if (implicitClassReceiver != null) {
            return implicitClassReceiver;
        }
        m9427a(1);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl
    public String toString() {
        StringBuilder sbM833U = outline.m833U("class ");
        sbM833U.append(this.f22973m.getName());
        sbM833U.append("::this");
        return sbM833U.toString();
    }
}
