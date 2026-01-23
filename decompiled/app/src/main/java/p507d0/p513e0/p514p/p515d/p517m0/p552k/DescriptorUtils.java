package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.UnsignedType3;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithSource;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithVisibility;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11469v0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageViewDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertySetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.VariableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.SpecialNames;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeChecker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.e, reason: use source file name */
/* JADX INFO: compiled from: DescriptorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class DescriptorUtils {
    static {
        new FqName("kotlin.jvm.JvmName");
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9923a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 21:
            case 22:
            case 32:
            case 33:
            case 34:
            case 55:
            case 56:
            case 57:
            case 59:
            case 77:
            case 90:
            case 92:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 14:
                objArr[0] = "first";
                break;
            case 15:
                objArr[0] = "second";
                break;
            case 16:
            case 17:
                objArr[0] = "aClass";
                break;
            case 18:
                objArr[0] = "kotlinType";
                break;
            case 23:
                objArr[0] = "declarationDescriptor";
                break;
            case 24:
            case 26:
                objArr[0] = "subClass";
                break;
            case 25:
            case 27:
            case 31:
                objArr[0] = "superClass";
                break;
            case 28:
            case 30:
            case 43:
            case 62:
                objArr[0] = "type";
                break;
            case 29:
                objArr[0] = "other";
                break;
            case 35:
                objArr[0] = "classKind";
                break;
            case 36:
            case 37:
            case 39:
            case 42:
            case 46:
            case 52:
            case 63:
            case 64:
            case 65:
            case 72:
            case 73:
                objArr[0] = "classDescriptor";
                break;
            case 44:
                objArr[0] = "typeConstructor";
                break;
            case 53:
                objArr[0] = "innerClassName";
                break;
            case 54:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_LOCATION;
                break;
            case 61:
                objArr[0] = "variable";
                break;
            case 66:
                objArr[0] = "f";
                break;
            case 68:
                objArr[0] = "current";
                break;
            case 69:
                objArr[0] = "result";
                break;
            case 70:
                objArr[0] = "memberDescriptor";
                break;
            case 74:
            case 75:
            case 76:
                objArr[0] = "annotated";
                break;
            case 80:
            case 82:
            case 85:
            case 87:
                objArr[0] = "scope";
                break;
            case 83:
            case 86:
            case 88:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 20:
                objArr[1] = "getContainingModule";
                break;
            case 38:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case 40:
            case 41:
                objArr[1] = "getSuperClassType";
                break;
            case 45:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 58:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 60:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 67:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 71:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 78:
            case 79:
                objArr[1] = "getContainingSourceFile";
                break;
            case 81:
                objArr[1] = "getAllDescriptors";
                break;
            case 84:
                objArr[1] = "getFunctionByName";
                break;
            case 89:
                objArr[1] = "getPropertyByName";
                break;
            case 91:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "isExtension";
                break;
            case 12:
                objArr[2] = "isOverride";
                break;
            case 13:
                objArr[2] = "isStaticDeclaration";
                break;
            case 14:
            case 15:
                objArr[2] = "areInSameModule";
                break;
            case 16:
            case 17:
                objArr[2] = "getParentOfType";
                break;
            case 18:
            case 21:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case 19:
                objArr[2] = "getContainingModule";
                break;
            case 22:
                objArr[2] = "getContainingClass";
                break;
            case 23:
                objArr[2] = "isAncestor";
                break;
            case 24:
            case 25:
                objArr[2] = "isDirectSubclass";
                break;
            case 26:
            case 27:
                objArr[2] = "isSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSameClass";
                break;
            case 30:
            case 31:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 32:
                objArr[2] = "isAnonymousObject";
                break;
            case 33:
                objArr[2] = "isAnonymousFunction";
                break;
            case 34:
                objArr[2] = "isEnumEntry";
                break;
            case 35:
                objArr[2] = "isKindOf";
                break;
            case 36:
                objArr[2] = "hasAbstractMembers";
                break;
            case 37:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case 39:
                objArr[2] = "getSuperClassType";
                break;
            case 42:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 43:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 44:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 46:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 52:
            case 53:
            case 54:
                objArr[2] = "getInnerClassByName";
                break;
            case 55:
                objArr[2] = "isStaticNestedClass";
                break;
            case 56:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 57:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 59:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 61:
            case 62:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 63:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 64:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 65:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 66:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 68:
            case 69:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 70:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 72:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 73:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 74:
                objArr[2] = "getJvmName";
                break;
            case 75:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 76:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 77:
                objArr[2] = "getContainingSourceFile";
                break;
            case 80:
                objArr[2] = "getAllDescriptors";
                break;
            case 82:
            case 83:
                objArr[2] = "getFunctionByName";
                break;
            case 85:
            case 86:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 87:
            case 88:
                objArr[2] = "getPropertyByName";
                break;
            case 90:
                objArr[2] = "getDirectMember";
                break;
            case 92:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static boolean areInSameModule(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            m9923a(14);
            throw null;
        }
        if (declarationDescriptor2 != null) {
            return getContainingModule(declarationDescriptor).equals(getContainingModule(declarationDescriptor2));
        }
        m9923a(15);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: b */
    public static <D extends CallableDescriptor> void m9924b(D d, Set<D> set) {
        if (d == null) {
            m9923a(68);
            throw null;
        }
        if (set.contains(d)) {
            return;
        }
        Iterator<? extends CallableDescriptor> it = d.getOriginal().getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            CallableDescriptor original = it.next().getOriginal();
            m9924b(original, set);
            set.add(original);
        }
    }

    /* JADX INFO: renamed from: c */
    public static FqName m9925c(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            m9923a(5);
            throw null;
        }
        if ((declarationDescriptor instanceof ModuleDescriptor2) || ErrorUtils.isError(declarationDescriptor)) {
            return FqName.f24079a;
        }
        if (declarationDescriptor instanceof PackageViewDescriptor) {
            return ((PackageViewDescriptor) declarationDescriptor).getFqName();
        }
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            return ((PackageFragmentDescriptor) declarationDescriptor).getFqName();
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public static FqNameUnsafe m9926d(DeclarationDescriptor declarationDescriptor) {
        FqNameUnsafe fqNameUnsafeChild = getFqName(declarationDescriptor.getContainingDeclaration()).child(declarationDescriptor.getName());
        if (fqNameUnsafeChild != null) {
            return fqNameUnsafeChild;
        }
        m9923a(7);
        throw null;
    }

    /* JADX INFO: renamed from: e */
    public static boolean m9927e(DeclarationDescriptor declarationDescriptor, ClassKind classKind) {
        return (declarationDescriptor instanceof ClassDescriptor) && ((ClassDescriptor) declarationDescriptor).getKind() == classKind;
    }

    /* JADX INFO: renamed from: f */
    public static boolean m9928f(KotlinType kotlinType, DeclarationDescriptor declarationDescriptor) {
        if (kotlinType == null) {
            m9923a(28);
            throw null;
        }
        if (declarationDescriptor == null) {
            m9923a(29);
            throw null;
        }
        ClassifierDescriptor declarationDescriptor2 = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor2 == null) {
            return false;
        }
        DeclarationDescriptor original = declarationDescriptor2.getOriginal();
        return (original instanceof ClassifierDescriptor) && (declarationDescriptor instanceof ClassifierDescriptor) && ((ClassifierDescriptor) declarationDescriptor).getTypeConstructor().equals(((ClassifierDescriptor) original).getTypeConstructor());
    }

    public static <D extends CallableDescriptor> Set<D> getAllOverriddenDescriptors(D d) {
        if (d == null) {
            m9923a(66);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        m9924b(d.getOriginal(), linkedHashSet);
        return linkedHashSet;
    }

    public static ClassDescriptor getClassDescriptorForType(KotlinType kotlinType) {
        if (kotlinType != null) {
            return getClassDescriptorForTypeConstructor(kotlinType.getConstructor());
        }
        m9923a(43);
        throw null;
    }

    public static ClassDescriptor getClassDescriptorForTypeConstructor(TypeConstructor typeConstructor) {
        if (typeConstructor == null) {
            m9923a(44);
            throw null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) typeConstructor.getDeclarationDescriptor();
        if (classDescriptor != null) {
            return classDescriptor;
        }
        m9923a(45);
        throw null;
    }

    public static ModuleDescriptor2 getContainingModule(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            m9923a(19);
            throw null;
        }
        ModuleDescriptor2 containingModuleOrNull = getContainingModuleOrNull(declarationDescriptor);
        if (containingModuleOrNull != null) {
            return containingModuleOrNull;
        }
        m9923a(20);
        throw null;
    }

    public static ModuleDescriptor2 getContainingModuleOrNull(KotlinType kotlinType) {
        if (kotlinType == null) {
            m9923a(18);
            throw null;
        }
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return null;
        }
        return getContainingModuleOrNull(declarationDescriptor);
    }

    public static InterfaceC11469v0 getContainingSourceFile(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            m9923a(77);
            throw null;
        }
        if (declarationDescriptor instanceof PropertySetterDescriptor) {
            declarationDescriptor = ((PropertySetterDescriptor) declarationDescriptor).getCorrespondingProperty();
        }
        if (!(declarationDescriptor instanceof DeclarationDescriptorWithSource)) {
            return InterfaceC11469v0.f23100a;
        }
        InterfaceC11469v0 containingFile = ((DeclarationDescriptorWithSource) declarationDescriptor).getSource().getContainingFile();
        if (containingFile != null) {
            return containingFile;
        }
        m9923a(78);
        throw null;
    }

    public static DescriptorVisibility2 getDefaultConstructorVisibility(ClassDescriptor classDescriptor, boolean z2) {
        if (classDescriptor == null) {
            m9923a(46);
            throw null;
        }
        ClassKind kind = classDescriptor.getKind();
        if (kind == ClassKind.ENUM_CLASS || kind.isSingleton()) {
            DescriptorVisibility2 descriptorVisibility2 = DescriptorVisibilities.f23083a;
            if (descriptorVisibility2 != null) {
                return descriptorVisibility2;
            }
            m9923a(47);
            throw null;
        }
        if (isSealedClass(classDescriptor)) {
            if (z2) {
                DescriptorVisibility2 descriptorVisibility22 = DescriptorVisibilities.f23086d;
                if (descriptorVisibility22 != null) {
                    return descriptorVisibility22;
                }
                m9923a(48);
                throw null;
            }
            DescriptorVisibility2 descriptorVisibility23 = DescriptorVisibilities.f23083a;
            if (descriptorVisibility23 != null) {
                return descriptorVisibility23;
            }
            m9923a(49);
            throw null;
        }
        if (isAnonymousObject(classDescriptor)) {
            DescriptorVisibility2 descriptorVisibility24 = DescriptorVisibilities.f23093k;
            if (descriptorVisibility24 != null) {
                return descriptorVisibility24;
            }
            m9923a(50);
            throw null;
        }
        DescriptorVisibility2 descriptorVisibility25 = DescriptorVisibilities.f23087e;
        if (descriptorVisibility25 != null) {
            return descriptorVisibility25;
        }
        m9923a(51);
        throw null;
    }

    public static ReceiverParameterDescriptor getDispatchReceiverParameterIfNeeded(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            m9923a(0);
            throw null;
        }
        if (declarationDescriptor instanceof ClassDescriptor) {
            return ((ClassDescriptor) declarationDescriptor).getThisAsReceiverParameter();
        }
        return null;
    }

    public static FqNameUnsafe getFqName(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            FqName fqNameM9925c = m9925c(declarationDescriptor);
            return fqNameM9925c != null ? fqNameM9925c.toUnsafe() : m9926d(declarationDescriptor);
        }
        m9923a(2);
        throw null;
    }

    public static FqName getFqNameSafe(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            m9923a(3);
            throw null;
        }
        FqName fqNameM9925c = m9925c(declarationDescriptor);
        if (fqNameM9925c == null) {
            fqNameM9925c = m9926d(declarationDescriptor).toSafe();
        }
        if (fqNameM9925c != null) {
            return fqNameM9925c;
        }
        m9923a(4);
        throw null;
    }

    public static <D extends DeclarationDescriptor> D getParentOfType(DeclarationDescriptor declarationDescriptor, Class<D> cls) {
        if (cls != null) {
            return (D) getParentOfType(declarationDescriptor, cls, true);
        }
        m9923a(16);
        throw null;
    }

    public static ClassDescriptor getSuperClassDescriptor(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            m9923a(42);
            throw null;
        }
        Iterator<KotlinType> it = classDescriptor.getTypeConstructor().getSupertypes().iterator();
        while (it.hasNext()) {
            ClassDescriptor classDescriptorForType = getClassDescriptorForType(it.next());
            if (classDescriptorForType.getKind() != ClassKind.INTERFACE) {
                return classDescriptorForType;
            }
        }
        return null;
    }

    public static boolean isAnnotationClass(DeclarationDescriptor declarationDescriptor) {
        return m9927e(declarationDescriptor, ClassKind.ANNOTATION_CLASS);
    }

    public static boolean isAnonymousObject(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return isClass(declarationDescriptor) && declarationDescriptor.getName().equals(SpecialNames.f24092a);
        }
        m9923a(32);
        throw null;
    }

    public static boolean isClass(DeclarationDescriptor declarationDescriptor) {
        return m9927e(declarationDescriptor, ClassKind.CLASS);
    }

    public static boolean isClassOrEnumClass(DeclarationDescriptor declarationDescriptor) {
        return isClass(declarationDescriptor) || isEnumClass(declarationDescriptor);
    }

    public static boolean isCompanionObject(DeclarationDescriptor declarationDescriptor) {
        return m9927e(declarationDescriptor, ClassKind.OBJECT) && ((ClassDescriptor) declarationDescriptor).isCompanionObject();
    }

    public static boolean isDescriptorWithLocalVisibility(DeclarationDescriptor declarationDescriptor) {
        return (declarationDescriptor instanceof DeclarationDescriptorWithVisibility) && ((DeclarationDescriptorWithVisibility) declarationDescriptor).getVisibility() == DescriptorVisibilities.f23088f;
    }

    public static boolean isDirectSubclass(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        if (classDescriptor == null) {
            m9923a(24);
            throw null;
        }
        if (classDescriptor2 == null) {
            m9923a(25);
            throw null;
        }
        Iterator<KotlinType> it = classDescriptor.getTypeConstructor().getSupertypes().iterator();
        while (it.hasNext()) {
            if (m9928f(it.next(), classDescriptor2.getOriginal())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEnumClass(DeclarationDescriptor declarationDescriptor) {
        return m9927e(declarationDescriptor, ClassKind.ENUM_CLASS);
    }

    public static boolean isEnumEntry(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return m9927e(declarationDescriptor, ClassKind.ENUM_ENTRY);
        }
        m9923a(34);
        throw null;
    }

    public static boolean isInterface(DeclarationDescriptor declarationDescriptor) {
        return m9927e(declarationDescriptor, ClassKind.INTERFACE);
    }

    public static boolean isLocal(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            m9923a(1);
            throw null;
        }
        while (declarationDescriptor != null) {
            if (isAnonymousObject(declarationDescriptor) || isDescriptorWithLocalVisibility(declarationDescriptor)) {
                return true;
            }
            declarationDescriptor = declarationDescriptor.getContainingDeclaration();
        }
        return false;
    }

    public static boolean isSealedClass(DeclarationDescriptor declarationDescriptor) {
        return (m9927e(declarationDescriptor, ClassKind.CLASS) || m9927e(declarationDescriptor, ClassKind.INTERFACE)) && ((ClassDescriptor) declarationDescriptor).getModality() == Modality.SEALED;
    }

    public static boolean isSubclass(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        if (classDescriptor == null) {
            m9923a(26);
            throw null;
        }
        if (classDescriptor2 != null) {
            return isSubtypeOfClass(classDescriptor.getDefaultType(), classDescriptor2.getOriginal());
        }
        m9923a(27);
        throw null;
    }

    public static boolean isSubtypeOfClass(KotlinType kotlinType, DeclarationDescriptor declarationDescriptor) {
        if (kotlinType == null) {
            m9923a(30);
            throw null;
        }
        if (declarationDescriptor == null) {
            m9923a(31);
            throw null;
        }
        if (m9928f(kotlinType, declarationDescriptor)) {
            return true;
        }
        Iterator<KotlinType> it = kotlinType.getConstructor().getSupertypes().iterator();
        while (it.hasNext()) {
            if (isSubtypeOfClass(it.next(), declarationDescriptor)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTopLevelDeclaration(DeclarationDescriptor declarationDescriptor) {
        return declarationDescriptor != null && (declarationDescriptor.getContainingDeclaration() instanceof PackageFragmentDescriptor);
    }

    public static boolean shouldRecordInitializerForProperty(VariableDescriptor variableDescriptor, KotlinType kotlinType) {
        if (variableDescriptor == null) {
            m9923a(61);
            throw null;
        }
        if (kotlinType == null) {
            m9923a(62);
            throw null;
        }
        if (variableDescriptor.isVar() || KotlinType2.isError(kotlinType)) {
            return false;
        }
        if (TypeUtils.acceptsNullable(kotlinType)) {
            return true;
        }
        KotlinBuiltIns builtIns = DescriptorUtils2.getBuiltIns(variableDescriptor);
        if (!KotlinBuiltIns.isPrimitiveType(kotlinType)) {
            KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.f24806a;
            if (!kotlinTypeChecker.equalTypes(builtIns.getStringType(), kotlinType) && !kotlinTypeChecker.equalTypes(builtIns.getNumber().getDefaultType(), kotlinType) && !kotlinTypeChecker.equalTypes(builtIns.getAnyType(), kotlinType)) {
                UnsignedType3 unsignedType3 = UnsignedType3.f22584a;
                if (!UnsignedType3.isUnsignedType(kotlinType)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static <D extends CallableMemberDescriptor> D unwrapFakeOverride(D d) {
        if (d == null) {
            m9923a(57);
            throw null;
        }
        while (d.getKind() == CallableMemberDescriptor.a.FAKE_OVERRIDE) {
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = d.getOverriddenDescriptors();
            if (overriddenDescriptors.isEmpty()) {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + d);
            }
            d = (D) overriddenDescriptors.iterator().next();
        }
        return d;
    }

    public static <D extends DeclarationDescriptorWithVisibility> D unwrapFakeOverrideToAnyDeclaration(D d) {
        if (d == null) {
            m9923a(59);
            throw null;
        }
        if (d instanceof CallableMemberDescriptor) {
            return unwrapFakeOverride((CallableMemberDescriptor) d);
        }
        if (d != null) {
            return d;
        }
        m9923a(60);
        throw null;
    }

    public static <D extends DeclarationDescriptor> D getParentOfType(DeclarationDescriptor declarationDescriptor, Class<D> cls, boolean z2) {
        if (cls == null) {
            m9923a(17);
            throw null;
        }
        if (declarationDescriptor == null) {
            return null;
        }
        if (z2) {
            declarationDescriptor = (D) declarationDescriptor.getContainingDeclaration();
        }
        while (declarationDescriptor != null) {
            if (cls.isInstance(declarationDescriptor)) {
                return (D) declarationDescriptor;
            }
            declarationDescriptor = (D) declarationDescriptor.getContainingDeclaration();
        }
        return null;
    }

    public static ModuleDescriptor2 getContainingModuleOrNull(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            m9923a(21);
            throw null;
        }
        while (declarationDescriptor != null) {
            if (declarationDescriptor instanceof ModuleDescriptor2) {
                return (ModuleDescriptor2) declarationDescriptor;
            }
            if (declarationDescriptor instanceof PackageViewDescriptor) {
                return ((PackageViewDescriptor) declarationDescriptor).getModule();
            }
            declarationDescriptor = declarationDescriptor.getContainingDeclaration();
        }
        return null;
    }
}
