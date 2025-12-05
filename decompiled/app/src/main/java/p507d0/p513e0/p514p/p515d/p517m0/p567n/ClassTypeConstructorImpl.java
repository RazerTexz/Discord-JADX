package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SupertypeLoopChecker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;

/* compiled from: ClassTypeConstructorImpl.java */
/* renamed from: d0.e0.p.d.m0.n.i, reason: use source file name */
/* loaded from: classes3.dex */
public class ClassTypeConstructorImpl extends AbstractClassTypeConstructor implements TypeConstructor {

    /* renamed from: c */
    public final ClassDescriptor f24781c;

    /* renamed from: d */
    public final List<TypeParameterDescriptor> f24782d;

    /* renamed from: e */
    public final Collection<KotlinType> f24783e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassTypeConstructorImpl(ClassDescriptor classDescriptor, List<? extends TypeParameterDescriptor> list, Collection<KotlinType> collection, StorageManager storageManager) {
        super(storageManager);
        if (classDescriptor == null) {
            m10012g(0);
            throw null;
        }
        if (list == null) {
            m10012g(1);
            throw null;
        }
        if (collection == null) {
            m10012g(2);
            throw null;
        }
        if (storageManager == null) {
            m10012g(3);
            throw null;
        }
        this.f24781c = classDescriptor;
        this.f24782d = Collections.unmodifiableList(new ArrayList(list));
        this.f24783e = Collections.unmodifiableCollection(collection);
    }

    /* renamed from: g */
    public static /* synthetic */ void m10012g(int i) {
        String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i == 4) {
            objArr[1] = "getParameters";
        } else if (i == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor
    /* renamed from: a */
    public Collection<KotlinType> mo9370a() {
        Collection<KotlinType> collection = this.f24783e;
        if (collection != null) {
            return collection;
        }
        m10012g(6);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor
    /* renamed from: d */
    public SupertypeLoopChecker mo9371d() {
        return SupertypeLoopChecker.a.f23103a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor, p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getDeclarationDescriptor() {
        return getDeclarationDescriptor();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> list = this.f24782d;
        if (list != null) {
            return list;
        }
        m10012g(4);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public boolean isDenotable() {
        return true;
    }

    public String toString() {
        return DescriptorUtils.getFqName(this.f24781c).asString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractClassTypeConstructor, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor, p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public ClassDescriptor getDeclarationDescriptor() {
        ClassDescriptor classDescriptor = this.f24781c;
        if (classDescriptor != null) {
            return classDescriptor;
        }
        m10012g(5);
        throw null;
    }
}
