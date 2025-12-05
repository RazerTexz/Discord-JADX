package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SealedClassInheritorsProvider.kt */
/* renamed from: d0.e0.p.d.m0.k.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class SealedClassInheritorsProvider extends SealedClassInheritorsProvider2 {

    /* renamed from: a */
    public static final SealedClassInheritorsProvider f24332a = new SealedClassInheritorsProvider();

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static final void m9909a(ClassDescriptor classDescriptor, LinkedHashSet<ClassDescriptor> linkedHashSet, MemberScope3 memberScope3, boolean z2) {
        for (DeclarationDescriptor declarationDescriptor : ResolutionScope.a.getContributedDescriptors$default(memberScope3, MemberScope2.f24353o, null, 2, null)) {
            if (declarationDescriptor instanceof ClassDescriptor) {
                ClassDescriptor classDescriptor2 = (ClassDescriptor) declarationDescriptor;
                if (DescriptorUtils.isDirectSubclass(classDescriptor2, classDescriptor)) {
                    linkedHashSet.add(declarationDescriptor);
                }
                if (z2) {
                    MemberScope3 unsubstitutedInnerClassesScope = classDescriptor2.getUnsubstitutedInnerClassesScope();
                    Intrinsics3.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "descriptor.unsubstitutedInnerClassesScope");
                    m9909a(classDescriptor, linkedHashSet, unsubstitutedInnerClassesScope, z2);
                }
            }
        }
    }

    public Collection<ClassDescriptor> computeSealedSubclasses(ClassDescriptor classDescriptor, boolean z2) {
        DeclarationDescriptor next;
        DeclarationDescriptor containingDeclaration;
        Intrinsics3.checkNotNullParameter(classDescriptor, "sealedClass");
        if (classDescriptor.getModality() != Modality.SEALED) {
            return Collections2.emptyList();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z2) {
            Iterator<DeclarationDescriptor> it = DescriptorUtils2.getParents(classDescriptor).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next instanceof PackageFragmentDescriptor) {
                    break;
                }
            }
            containingDeclaration = next;
        } else {
            containingDeclaration = classDescriptor.getContainingDeclaration();
        }
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            m9909a(classDescriptor, linkedHashSet, ((PackageFragmentDescriptor) containingDeclaration).getMemberScope(), z2);
        }
        MemberScope3 unsubstitutedInnerClassesScope = classDescriptor.getUnsubstitutedInnerClassesScope();
        Intrinsics3.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "sealedClass.unsubstitutedInnerClassesScope");
        m9909a(classDescriptor, linkedHashSet, unsubstitutedInnerClassesScope, true);
        return linkedHashSet;
    }
}
