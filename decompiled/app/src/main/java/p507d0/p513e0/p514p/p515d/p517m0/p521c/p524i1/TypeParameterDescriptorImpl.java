package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SupertypeLoopChecker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.k0, reason: use source file name */
/* JADX INFO: compiled from: TypeParameterDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class TypeParameterDescriptorImpl extends AbstractTypeParameterDescriptor {

    /* JADX INFO: renamed from: t */
    public final Function1<KotlinType, Void> f22893t;

    /* JADX INFO: renamed from: u */
    public final List<KotlinType> f22894u;

    /* JADX INFO: renamed from: v */
    public boolean f22895v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeParameterDescriptorImpl(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, boolean z2, Variance variance, Name name, int i, SourceElement sourceElement, Function1<KotlinType, Void> function1, SupertypeLoopChecker supertypeLoopChecker, StorageManager storageManager) {
        super(storageManager, declarationDescriptor, annotations4, name, variance, z2, i, sourceElement, supertypeLoopChecker);
        if (declarationDescriptor == null) {
            m9413a(19);
            throw null;
        }
        if (annotations4 == null) {
            m9413a(20);
            throw null;
        }
        if (variance == null) {
            m9413a(21);
            throw null;
        }
        if (name == null) {
            m9413a(22);
            throw null;
        }
        if (sourceElement == null) {
            m9413a(23);
            throw null;
        }
        if (supertypeLoopChecker == null) {
            m9413a(24);
            throw null;
        }
        if (storageManager == null) {
            m9413a(25);
            throw null;
        }
        this.f22894u = new ArrayList(1);
        this.f22895v = false;
        this.f22893t = function1;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9413a(int i) {
        String str = (i == 5 || i == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 28) ? 2 : 3];
        switch (i) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        if (i == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 28) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, boolean z2, Variance variance, Name name, int i, SourceElement sourceElement, StorageManager storageManager) {
        if (declarationDescriptor == null) {
            m9413a(6);
            throw null;
        }
        if (annotations4 == null) {
            m9413a(7);
            throw null;
        }
        if (variance == null) {
            m9413a(8);
            throw null;
        }
        if (name == null) {
            m9413a(9);
            throw null;
        }
        if (sourceElement == null) {
            m9413a(10);
            throw null;
        }
        if (storageManager != null) {
            return createForFurtherModification(declarationDescriptor, annotations4, z2, variance, name, i, sourceElement, null, SupertypeLoopChecker.a.f23103a, storageManager);
        }
        m9413a(11);
        throw null;
    }

    public static TypeParameterDescriptor createWithDefaultBound(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, boolean z2, Variance variance, Name name, int i, StorageManager storageManager) {
        if (declarationDescriptor == null) {
            m9413a(0);
            throw null;
        }
        if (annotations4 == null) {
            m9413a(1);
            throw null;
        }
        if (variance == null) {
            m9413a(2);
            throw null;
        }
        if (name == null) {
            m9413a(3);
            throw null;
        }
        if (storageManager == null) {
            m9413a(4);
            throw null;
        }
        TypeParameterDescriptorImpl typeParameterDescriptorImplCreateForFurtherModification = createForFurtherModification(declarationDescriptor, annotations4, z2, variance, name, i, SourceElement.f23099a, storageManager);
        typeParameterDescriptorImplCreateForFurtherModification.addUpperBound(DescriptorUtils2.getBuiltIns(declarationDescriptor).getDefaultBound());
        typeParameterDescriptorImplCreateForFurtherModification.setInitialized();
        return typeParameterDescriptorImplCreateForFurtherModification;
    }

    public void addUpperBound(KotlinType kotlinType) {
        if (kotlinType == null) {
            m9413a(26);
            throw null;
        }
        m9414e();
        if (KotlinType2.isError(kotlinType)) {
            return;
        }
        this.f22894u.add(kotlinType);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractTypeParameterDescriptor
    /* JADX INFO: renamed from: c */
    public void mo9400c(KotlinType kotlinType) {
        if (kotlinType == null) {
            m9413a(27);
            throw null;
        }
        Function1<KotlinType, Void> function1 = this.f22893t;
        if (function1 == null) {
            return;
        }
        function1.invoke(kotlinType);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractTypeParameterDescriptor
    /* JADX INFO: renamed from: d */
    public List<KotlinType> mo9401d() {
        if (!this.f22895v) {
            StringBuilder sbM833U = outline.m833U("Type parameter descriptor is not initialized: ");
            sbM833U.append(m9415f());
            throw new IllegalStateException(sbM833U.toString());
        }
        List<KotlinType> list = this.f22894u;
        if (list != null) {
            return list;
        }
        m9413a(28);
        throw null;
    }

    /* JADX INFO: renamed from: e */
    public final void m9414e() {
        if (this.f22895v) {
            StringBuilder sbM833U = outline.m833U("Type parameter descriptor is already initialized: ");
            sbM833U.append(m9415f());
            throw new IllegalStateException(sbM833U.toString());
        }
    }

    /* JADX INFO: renamed from: f */
    public final String m9415f() {
        return getName() + " declared in " + DescriptorUtils.getFqName(getContainingDeclaration());
    }

    public void setInitialized() {
        m9414e();
        this.f22895v = true;
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, boolean z2, Variance variance, Name name, int i, SourceElement sourceElement, Function1<KotlinType, Void> function1, SupertypeLoopChecker supertypeLoopChecker, StorageManager storageManager) {
        if (declarationDescriptor == null) {
            m9413a(12);
            throw null;
        }
        if (annotations4 == null) {
            m9413a(13);
            throw null;
        }
        if (variance == null) {
            m9413a(14);
            throw null;
        }
        if (name == null) {
            m9413a(15);
            throw null;
        }
        if (sourceElement == null) {
            m9413a(16);
            throw null;
        }
        if (supertypeLoopChecker == null) {
            m9413a(17);
            throw null;
        }
        if (storageManager != null) {
            return new TypeParameterDescriptorImpl(declarationDescriptor, annotations4, z2, variance, name, i, sourceElement, function1, supertypeLoopChecker, storageManager);
        }
        m9413a(18);
        throw null;
    }
}
