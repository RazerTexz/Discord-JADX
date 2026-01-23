package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ReceiverValue;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.f0, reason: use source file name */
/* JADX INFO: compiled from: ReceiverParameterDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class ReceiverParameterDescriptorImpl extends AbstractReceiverParameterDescriptor {

    /* JADX INFO: renamed from: m */
    public final DeclarationDescriptor f22871m;

    /* JADX INFO: renamed from: n */
    public final ReceiverValue f22872n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReceiverParameterDescriptorImpl(DeclarationDescriptor declarationDescriptor, ReceiverValue receiverValue, Annotations4 annotations4) {
        super(annotations4);
        if (declarationDescriptor == null) {
            m9406a(0);
            throw null;
        }
        if (receiverValue == null) {
            m9406a(1);
            throw null;
        }
        if (annotations4 == null) {
            m9406a(2);
            throw null;
        }
        this.f22871m = declarationDescriptor;
        this.f22872n = receiverValue;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9406a(int i) {
        String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "value";
        } else if (i == 2) {
            objArr[0] = "annotations";
        } else if (i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else if (i != 5) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 3) {
            objArr[1] = "getValue";
        } else if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i != 3 && i != 4) {
            if (i != 5) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.f22871m;
        if (declarationDescriptor != null) {
            return declarationDescriptor;
        }
        m9406a(4);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor
    public ReceiverValue getValue() {
        ReceiverValue receiverValue = this.f22872n;
        if (receiverValue != null) {
            return receiverValue;
        }
        m9406a(3);
        throw null;
    }
}
