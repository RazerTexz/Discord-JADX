package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import java.util.Comparator;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.h, reason: use source file name */
/* JADX INFO: compiled from: MemberComparator.java */
/* JADX INFO: loaded from: classes3.dex */
public class MemberComparator implements Comparator<DeclarationDescriptor> {

    /* JADX INFO: renamed from: j */
    public static final MemberComparator f24409j = new MemberComparator();

    /* JADX INFO: renamed from: a */
    public static int m9929a(DeclarationDescriptor declarationDescriptor) {
        if (DescriptorUtils.isEnumEntry(declarationDescriptor)) {
            return 8;
        }
        if (declarationDescriptor instanceof ConstructorDescriptor) {
            return 7;
        }
        if (declarationDescriptor instanceof PropertyDescriptor) {
            return ((PropertyDescriptor) declarationDescriptor).getExtensionReceiverParameter() == null ? 6 : 5;
        }
        if (declarationDescriptor instanceof FunctionDescriptor) {
            return ((FunctionDescriptor) declarationDescriptor).getExtensionReceiverParameter() == null ? 4 : 3;
        }
        if (declarationDescriptor instanceof ClassDescriptor) {
            return 2;
        }
        return declarationDescriptor instanceof TypeAliasDescriptor ? 1 : 0;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        return compare2(declarationDescriptor, declarationDescriptor2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        Integer numValueOf;
        int iM9929a = m9929a(declarationDescriptor2) - m9929a(declarationDescriptor);
        if (iM9929a != 0) {
            numValueOf = Integer.valueOf(iM9929a);
        } else if (DescriptorUtils.isEnumEntry(declarationDescriptor) && DescriptorUtils.isEnumEntry(declarationDescriptor2)) {
            numValueOf = 0;
        } else {
            int iCompareTo2 = declarationDescriptor.getName().compareTo2(declarationDescriptor2.getName());
            numValueOf = iCompareTo2 != 0 ? Integer.valueOf(iCompareTo2) : null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }
}
