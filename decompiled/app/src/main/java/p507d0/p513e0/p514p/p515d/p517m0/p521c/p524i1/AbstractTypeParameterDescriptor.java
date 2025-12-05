package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithSource;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SupertypeLoopChecker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.LazyScopeAdapter;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.TypeIntersectionScope;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;

/* compiled from: AbstractTypeParameterDescriptor.java */
/* renamed from: d0.e0.p.d.m0.c.i1.f, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractTypeParameterDescriptor extends DeclarationDescriptorNonRootImpl implements TypeParameterDescriptor {

    /* renamed from: n */
    public final Variance f22857n;

    /* renamed from: o */
    public final boolean f22858o;

    /* renamed from: p */
    public final int f22859p;

    /* renamed from: q */
    public final storage5<TypeConstructor> f22860q;

    /* renamed from: r */
    public final storage5<KotlinType4> f22861r;

    /* renamed from: s */
    public final StorageManager f22862s;

    /* compiled from: AbstractTypeParameterDescriptor.java */
    /* renamed from: d0.e0.p.d.m0.c.i1.f$a */
    public class a implements Function0<TypeConstructor> {

        /* renamed from: j */
        public final /* synthetic */ StorageManager f22863j;

        /* renamed from: k */
        public final /* synthetic */ SupertypeLoopChecker f22864k;

        public a(StorageManager storageManager, SupertypeLoopChecker supertypeLoopChecker) {
            this.f22863j = storageManager;
            this.f22864k = supertypeLoopChecker;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ TypeConstructor invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public TypeConstructor invoke() {
            return new c(AbstractTypeParameterDescriptor.this, this.f22863j, this.f22864k);
        }
    }

    /* compiled from: AbstractTypeParameterDescriptor.java */
    /* renamed from: d0.e0.p.d.m0.c.i1.f$b */
    public class b implements Function0<KotlinType4> {

        /* renamed from: j */
        public final /* synthetic */ Name f22866j;

        /* compiled from: AbstractTypeParameterDescriptor.java */
        /* renamed from: d0.e0.p.d.m0.c.i1.f$b$a */
        public class a implements Function0<MemberScope3> {
            public a() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ MemberScope3 invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public MemberScope3 invoke() {
                StringBuilder sbM833U = outline.m833U("Scope for type parameter ");
                sbM833U.append(b.this.f22866j.asString());
                return TypeIntersectionScope.create(sbM833U.toString(), AbstractTypeParameterDescriptor.this.getUpperBounds());
            }
        }

        public b(Name name) {
            this.f22866j = name;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ KotlinType4 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public KotlinType4 invoke() {
            return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(Annotations4.f22735f.getEMPTY(), AbstractTypeParameterDescriptor.this.getTypeConstructor(), Collections.emptyList(), false, new LazyScopeAdapter(new a()));
        }
    }

    /* compiled from: AbstractTypeParameterDescriptor.java */
    /* renamed from: d0.e0.p.d.m0.c.i1.f$c */
    public class c extends AbstractTypeConstructor {

        /* renamed from: b */
        public final SupertypeLoopChecker f22869b;

        /* renamed from: c */
        public final /* synthetic */ AbstractTypeParameterDescriptor f22870c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbstractTypeParameterDescriptor abstractTypeParameterDescriptor, StorageManager storageManager, SupertypeLoopChecker supertypeLoopChecker) {
            super(storageManager);
            if (storageManager == null) {
                m9402g(0);
                throw null;
            }
            this.f22870c = abstractTypeParameterDescriptor;
            this.f22869b = supertypeLoopChecker;
        }

        /* renamed from: g */
        public static /* synthetic */ void m9402g(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? 2 : 3];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i == 2) {
                objArr[1] = "getParameters";
            } else if (i == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 8) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor
        /* renamed from: a */
        public Collection<KotlinType> mo9370a() {
            List<KotlinType> listMo9401d = this.f22870c.mo9401d();
            if (listMo9401d != null) {
                return listMo9401d;
            }
            m9402g(1);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor
        /* renamed from: b */
        public KotlinType mo9403b() {
            return ErrorUtils.createErrorType("Cyclic upper bounds");
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor
        /* renamed from: d */
        public SupertypeLoopChecker mo9371d() {
            SupertypeLoopChecker supertypeLoopChecker = this.f22869b;
            if (supertypeLoopChecker != null) {
                return supertypeLoopChecker;
            }
            m9402g(5);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor
        /* renamed from: e */
        public List<KotlinType> mo9404e(List<KotlinType> list) {
            if (list == null) {
                m9402g(7);
                throw null;
            }
            List<KotlinType> listMo9399b = this.f22870c.mo9399b(list);
            if (listMo9399b != null) {
                return listMo9399b;
            }
            m9402g(8);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor
        /* renamed from: f */
        public void mo9405f(KotlinType kotlinType) {
            if (kotlinType != null) {
                this.f22870c.mo9400c(kotlinType);
            } else {
                m9402g(6);
                throw null;
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = DescriptorUtils2.getBuiltIns(this.f22870c);
            if (builtIns != null) {
                return builtIns;
            }
            m9402g(4);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor, p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public ClassifierDescriptor getDeclarationDescriptor() {
            AbstractTypeParameterDescriptor abstractTypeParameterDescriptor = this.f22870c;
            if (abstractTypeParameterDescriptor != null) {
                return abstractTypeParameterDescriptor;
            }
            m9402g(3);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> listEmptyList = Collections.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            m9402g(2);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            return this.f22870c.getName().toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeParameterDescriptor(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, Name name, Variance variance, boolean z2, int i, SourceElement sourceElement, SupertypeLoopChecker supertypeLoopChecker) {
        super(declarationDescriptor, annotations4, name, sourceElement);
        if (storageManager == null) {
            m9398a(0);
            throw null;
        }
        if (declarationDescriptor == null) {
            m9398a(1);
            throw null;
        }
        if (annotations4 == null) {
            m9398a(2);
            throw null;
        }
        if (name == null) {
            m9398a(3);
            throw null;
        }
        if (variance == null) {
            m9398a(4);
            throw null;
        }
        if (sourceElement == null) {
            m9398a(5);
            throw null;
        }
        if (supertypeLoopChecker == null) {
            m9398a(6);
            throw null;
        }
        this.f22857n = variance;
        this.f22858o = z2;
        this.f22859p = i;
        this.f22860q = storageManager.createLazyValue(new a(storageManager, supertypeLoopChecker));
        this.f22861r = storageManager.createLazyValue(new b(name));
        this.f22862s = storageManager;
    }

    /* renamed from: a */
    public static /* synthetic */ void m9398a(int i) {
        String str;
        int i2;
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i2 = 2;
                break;
            case 12:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitTypeParameterDescriptor(this, d);
    }

    /* renamed from: b */
    public List<KotlinType> mo9399b(List<KotlinType> list) {
        if (list == null) {
            m9398a(12);
            throw null;
        }
        if (list != null) {
            return list;
        }
        m9398a(13);
        throw null;
    }

    /* renamed from: c */
    public abstract void mo9400c(KotlinType kotlinType);

    /* renamed from: d */
    public abstract List<KotlinType> mo9401d();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor
    public KotlinType4 getDefaultType() {
        KotlinType4 kotlinType4Invoke = this.f22861r.invoke();
        if (kotlinType4Invoke != null) {
            return kotlinType4Invoke;
        }
        m9398a(10);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor
    public int getIndex() {
        return this.f22859p;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor
    public StorageManager getStorageManager() {
        StorageManager storageManager = this.f22862s;
        if (storageManager != null) {
            return storageManager;
        }
        m9398a(14);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor
    public final TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructorInvoke = this.f22860q.invoke();
        if (typeConstructorInvoke != null) {
            return typeConstructorInvoke;
        }
        m9398a(9);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor
    public List<KotlinType> getUpperBounds() {
        List<KotlinType> supertypes = ((c) getTypeConstructor()).getSupertypes();
        if (supertypes != null) {
            return supertypes;
        }
        m9398a(8);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor
    public Variance getVariance() {
        Variance variance = this.f22857n;
        if (variance != null) {
            return variance;
        }
        m9398a(7);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor
    public boolean isCapturedFromOuterDeclaration() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor
    public boolean isReified() {
        return this.f22858o;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) super.getOriginal();
        if (typeParameterDescriptor != null) {
            return typeParameterDescriptor;
        }
        m9398a(11);
        throw null;
    }
}
