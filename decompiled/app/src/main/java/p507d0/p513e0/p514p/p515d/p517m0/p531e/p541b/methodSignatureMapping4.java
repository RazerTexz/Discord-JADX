package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.descriptorBasedTypeSignatureMapping2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.y, reason: use source file name */
/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class methodSignatureMapping4 implements descriptorBasedTypeSignatureMapping2<methodSignatureMapping> {

    /* JADX INFO: renamed from: a */
    public static final methodSignatureMapping4 f23637a = new methodSignatureMapping4();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.descriptorBasedTypeSignatureMapping2
    public KotlinType commonSupertype(Collection<? extends KotlinType> collection) {
        Intrinsics3.checkNotNullParameter(collection, "types");
        throw new AssertionError(Intrinsics3.stringPlus("There should be no intersection type in existing descriptors, but found: ", _Collections.joinToString$default(collection, null, null, null, 0, null, null, 63, null)));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.descriptorBasedTypeSignatureMapping2
    public String getPredefinedFullInternalNameForClass(ClassDescriptor classDescriptor) {
        return descriptorBasedTypeSignatureMapping2.a.getPredefinedFullInternalNameForClass(this, classDescriptor);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.descriptorBasedTypeSignatureMapping2
    public String getPredefinedInternalNameForClass(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.descriptorBasedTypeSignatureMapping2
    public methodSignatureMapping getPredefinedTypeForClass(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.descriptorBasedTypeSignatureMapping2
    public /* bridge */ /* synthetic */ methodSignatureMapping getPredefinedTypeForClass(ClassDescriptor classDescriptor) {
        return getPredefinedTypeForClass(classDescriptor);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.descriptorBasedTypeSignatureMapping2
    public KotlinType preprocessType(KotlinType kotlinType) {
        return descriptorBasedTypeSignatureMapping2.a.preprocessType(this, kotlinType);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.descriptorBasedTypeSignatureMapping2
    public void processErrorType(KotlinType kotlinType, ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(kotlinType, "kotlinType");
        Intrinsics3.checkNotNullParameter(classDescriptor, "descriptor");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.descriptorBasedTypeSignatureMapping2
    public boolean releaseCoroutines() {
        return descriptorBasedTypeSignatureMapping2.a.releaseCoroutines(this);
    }
}
