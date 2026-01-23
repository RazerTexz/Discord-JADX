package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.SmartList;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.b, reason: use source file name */
/* JADX INFO: compiled from: AbstractClassTypeConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractClassTypeConstructor extends AbstractTypeConstructor implements TypeConstructor {

    /* JADX INFO: renamed from: b */
    public int f24742b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractClassTypeConstructor(StorageManager storageManager) {
        super(storageManager);
        if (storageManager == null) {
            m9994g(0);
            throw null;
        }
        this.f24742b = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void m9994g(int i) {
        String str = (i == 1 || i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 3 || i == 4) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        } else if (i == 2) {
            objArr[0] = "descriptor";
        } else if (i != 3 && i != 4) {
            objArr[0] = "storageManager";
        }
        if (i == 1) {
            objArr[1] = "getBuiltIns";
        } else if (i == 3 || i == 4) {
            objArr[1] = "getAdditionalNeighboursInSupertypeGraph";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        }
        if (i != 1) {
            if (i == 2) {
                objArr[2] = "hasMeaningfulFqName";
            } else if (i != 3 && i != 4) {
                objArr[2] = "<init>";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 3 && i != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    /* JADX INFO: renamed from: h */
    public static boolean m9995h(ClassifierDescriptor classifierDescriptor) {
        if (classifierDescriptor != null) {
            return (ErrorUtils.isError(classifierDescriptor) || DescriptorUtils.isLocal(classifierDescriptor)) ? false : true;
        }
        m9994g(2);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor
    /* JADX INFO: renamed from: b */
    public KotlinType mo9403b() {
        if (KotlinBuiltIns.isSpecialClassWithNoSupertypes(getDeclarationDescriptor())) {
            return null;
        }
        return getBuiltIns().getAnyType();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor
    /* JADX INFO: renamed from: c */
    public Collection<KotlinType> mo9996c(boolean z2) {
        DeclarationDescriptor containingDeclaration = getDeclarationDescriptor().getContainingDeclaration();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            List listEmptyList = Collections.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            m9994g(3);
            throw null;
        }
        SmartList smartList = new SmartList();
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        smartList.add(classDescriptor.getDefaultType());
        ClassDescriptor companionObjectDescriptor = classDescriptor.getCompanionObjectDescriptor();
        if (z2 && companionObjectDescriptor != null) {
            smartList.add(companionObjectDescriptor.getDefaultType());
        }
        return smartList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeConstructor) || obj.hashCode() != hashCode()) {
            return false;
        }
        TypeConstructor typeConstructor = (TypeConstructor) obj;
        if (typeConstructor.getParameters().size() != getParameters().size()) {
            return false;
        }
        ClassDescriptor declarationDescriptor = getDeclarationDescriptor();
        ClassifierDescriptor declarationDescriptor2 = typeConstructor.getDeclarationDescriptor();
        if (!m9995h(declarationDescriptor) || ((declarationDescriptor2 != null && !m9995h(declarationDescriptor2)) || !(declarationDescriptor2 instanceof ClassDescriptor))) {
            return false;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor2;
        if (declarationDescriptor.getName().equals(classDescriptor.getName())) {
            DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
            for (DeclarationDescriptor containingDeclaration2 = classDescriptor.getContainingDeclaration(); containingDeclaration != null && containingDeclaration2 != null; containingDeclaration2 = containingDeclaration2.getContainingDeclaration()) {
                if (containingDeclaration instanceof ModuleDescriptor2) {
                    return containingDeclaration2 instanceof ModuleDescriptor2;
                }
                if (!(containingDeclaration2 instanceof ModuleDescriptor2)) {
                    if (containingDeclaration instanceof PackageFragmentDescriptor) {
                        if ((containingDeclaration2 instanceof PackageFragmentDescriptor) && ((PackageFragmentDescriptor) containingDeclaration).getFqName().equals(((PackageFragmentDescriptor) containingDeclaration2).getFqName())) {
                            return true;
                        }
                    } else if (!(containingDeclaration2 instanceof PackageFragmentDescriptor) && containingDeclaration.getName().equals(containingDeclaration2.getName())) {
                        containingDeclaration = containingDeclaration.getContainingDeclaration();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = DescriptorUtils2.getBuiltIns(getDeclarationDescriptor());
        if (builtIns != null) {
            return builtIns;
        }
        m9994g(1);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor, p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public abstract ClassDescriptor getDeclarationDescriptor();

    public final int hashCode() {
        int i = this.f24742b;
        if (i != 0) {
            return i;
        }
        ClassDescriptor declarationDescriptor = getDeclarationDescriptor();
        int iHashCode = m9995h(declarationDescriptor) ? DescriptorUtils.getFqName(declarationDescriptor).hashCode() : System.identityHashCode(this);
        this.f24742b = iHashCode;
        return iHashCode;
    }
}
