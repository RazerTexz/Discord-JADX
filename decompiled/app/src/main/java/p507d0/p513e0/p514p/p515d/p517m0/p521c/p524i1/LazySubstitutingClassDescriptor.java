package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.SubstitutingScope;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ClassTypeConstructorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.DescriptorSubstitutor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p580t._Collections;

/* compiled from: LazySubstitutingClassDescriptor.java */
/* renamed from: d0.e0.p.d.m0.c.i1.t, reason: use source file name */
/* loaded from: classes3.dex */
public class LazySubstitutingClassDescriptor extends ModuleAwareClassDescriptor {

    /* renamed from: k */
    public final ModuleAwareClassDescriptor f22980k;

    /* renamed from: l */
    public final TypeSubstitutor2 f22981l;

    /* renamed from: m */
    public TypeSubstitutor2 f22982m;

    /* renamed from: n */
    public List<TypeParameterDescriptor> f22983n;

    /* renamed from: o */
    public List<TypeParameterDescriptor> f22984o;

    /* renamed from: p */
    public TypeConstructor f22985p;

    /* compiled from: LazySubstitutingClassDescriptor.java */
    /* renamed from: d0.e0.p.d.m0.c.i1.t$a */
    public class a implements Function1<TypeParameterDescriptor, Boolean> {
        public a(LazySubstitutingClassDescriptor lazySubstitutingClassDescriptor) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(TypeParameterDescriptor typeParameterDescriptor) {
            return invoke2(typeParameterDescriptor);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public Boolean invoke2(TypeParameterDescriptor typeParameterDescriptor) {
            return Boolean.valueOf(!typeParameterDescriptor.isCapturedFromOuterDeclaration());
        }
    }

    public LazySubstitutingClassDescriptor(ModuleAwareClassDescriptor moduleAwareClassDescriptor, TypeSubstitutor2 typeSubstitutor2) {
        this.f22980k = moduleAwareClassDescriptor;
        this.f22981l = typeSubstitutor2;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void m9428a(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10 || i == 13 || i == 22) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10 || i == 13 || i == 22) ? 3 : 2];
        if (i == 2) {
            objArr[0] = "typeArguments";
        } else if (i == 3) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i == 5) {
            objArr[0] = "typeSubstitution";
        } else if (i != 6) {
            if (i != 8) {
                if (i != 10) {
                    if (i != 13) {
                        if (i != 22) {
                            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                        } else {
                            objArr[0] = "substitutor";
                        }
                    }
                }
            }
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 10:
            case 13:
            case 22:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 11:
                objArr[1] = "getMemberScope";
                break;
            case 12:
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getDefaultType";
                break;
            case 17:
                objArr[1] = "getConstructors";
                break;
            case 18:
                objArr[1] = "getAnnotations";
                break;
            case 19:
                objArr[1] = "getName";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getContainingDeclaration";
                break;
            case 23:
                objArr[1] = "substitute";
                break;
            case 24:
                objArr[1] = "getKind";
                break;
            case 25:
                objArr[1] = "getModality";
                break;
            case 26:
                objArr[1] = "getVisibility";
                break;
            case 27:
                objArr[1] = "getUnsubstitutedInnerClassesScope";
                break;
            case 28:
                objArr[1] = "getSource";
                break;
            case 29:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 30:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "getTypeConstructor";
                break;
        }
        if (i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10) {
            objArr[2] = "getMemberScope";
        } else if (i == 13) {
            objArr[2] = "getUnsubstitutedMemberScope";
        } else if (i == 22) {
            objArr[2] = "substitute";
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6 && i != 8 && i != 10 && i != 13 && i != 22) {
            throw new IllegalStateException(str2);
        }
        throw new IllegalArgumentException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitClassDescriptor(this, d);
    }

    /* renamed from: b */
    public final TypeSubstitutor2 m9429b() {
        if (this.f22982m == null) {
            if (this.f22981l.isEmpty()) {
                this.f22982m = this.f22981l;
            } else {
                List<TypeParameterDescriptor> parameters = this.f22980k.getTypeConstructor().getParameters();
                this.f22983n = new ArrayList(parameters.size());
                this.f22982m = DescriptorSubstitutor.substituteTypeParameters(parameters, this.f22981l.getSubstitution(), this, this.f22983n);
                this.f22984o = _Collections.filter(this.f22983n, new a(this));
            }
        }
        return this.f22982m;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public Annotations4 getAnnotations() {
        Annotations4 annotations = this.f22980k.getAnnotations();
        if (annotations != null) {
            return annotations;
        }
        m9428a(18);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public ClassDescriptor getCompanionObjectDescriptor() {
        return this.f22980k.getCompanionObjectDescriptor();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public Collection<ClassConstructorDescriptor> getConstructors() {
        Collection<ClassConstructorDescriptor> constructors = this.f22980k.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        for (ClassConstructorDescriptor classConstructorDescriptor : constructors) {
            arrayList.add(((ClassConstructorDescriptor) classConstructorDescriptor.newCopyBuilder().setOriginal(classConstructorDescriptor.getOriginal()).setModality(classConstructorDescriptor.getModality()).setVisibility(classConstructorDescriptor.getVisibility()).setKind(classConstructorDescriptor.getKind()).setCopyOverrides(false).build()).substitute(m9429b()));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor containingDeclaration = this.f22980k.getContainingDeclaration();
        if (containingDeclaration != null) {
            return containingDeclaration;
        }
        m9428a(21);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        m9429b();
        List<TypeParameterDescriptor> list = this.f22984o;
        if (list != null) {
            return list;
        }
        m9428a(29);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor
    public KotlinType4 getDefaultType() {
        KotlinType4 kotlinType4SimpleTypeWithNonTrivialMemberScope = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(getAnnotations(), getTypeConstructor(), TypeUtils.getDefaultTypeProjections(getTypeConstructor().getParameters()), false, getUnsubstitutedMemberScope());
        if (kotlinType4SimpleTypeWithNonTrivialMemberScope != null) {
            return kotlinType4SimpleTypeWithNonTrivialMemberScope;
        }
        m9428a(16);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public ClassKind getKind() {
        ClassKind kind = this.f22980k.getKind();
        if (kind != null) {
            return kind;
        }
        m9428a(24);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ModuleAwareClassDescriptor
    public MemberScope3 getMemberScope(TypeSubstitution5 typeSubstitution5, KotlinTypeRefiner kotlinTypeRefiner) {
        if (typeSubstitution5 == null) {
            m9428a(5);
            throw null;
        }
        if (kotlinTypeRefiner == null) {
            m9428a(6);
            throw null;
        }
        MemberScope3 memberScope = this.f22980k.getMemberScope(typeSubstitution5, kotlinTypeRefiner);
        if (!this.f22981l.isEmpty()) {
            return new SubstitutingScope(memberScope, m9429b());
        }
        if (memberScope != null) {
            return memberScope;
        }
        m9428a(7);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public Modality getModality() {
        Modality modality = this.f22980k.getModality();
        if (modality != null) {
            return modality;
        }
        m9428a(25);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public Name getName() {
        Name name = this.f22980k.getName();
        if (name != null) {
            return name;
        }
        m9428a(19);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        Collection<ClassDescriptor> sealedSubclasses = this.f22980k.getSealedSubclasses();
        if (sealedSubclasses != null) {
            return sealedSubclasses;
        }
        m9428a(30);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return SourceElement.f23099a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public MemberScope3 getStaticScope() {
        MemberScope3 staticScope = this.f22980k.getStaticScope();
        if (staticScope != null) {
            return staticScope;
        }
        m9428a(15);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        throw new UnsupportedOperationException();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor = this.f22980k.getTypeConstructor();
        if (this.f22981l.isEmpty()) {
            if (typeConstructor != null) {
                return typeConstructor;
            }
            m9428a(0);
            throw null;
        }
        if (this.f22985p == null) {
            TypeSubstitutor2 typeSubstitutor2M9429b = m9429b();
            Collection<KotlinType> supertypes = typeConstructor.getSupertypes();
            ArrayList arrayList = new ArrayList(supertypes.size());
            Iterator<KotlinType> it = supertypes.iterator();
            while (it.hasNext()) {
                arrayList.add(typeSubstitutor2M9429b.substitute(it.next(), Variance.INVARIANT));
            }
            this.f22985p = new ClassTypeConstructorImpl(this, this.f22983n, arrayList, LockBasedStorageManager.f24710b);
        }
        TypeConstructor typeConstructor2 = this.f22985p;
        if (typeConstructor2 != null) {
            return typeConstructor2;
        }
        m9428a(1);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public MemberScope3 getUnsubstitutedInnerClassesScope() {
        MemberScope3 unsubstitutedInnerClassesScope = this.f22980k.getUnsubstitutedInnerClassesScope();
        if (unsubstitutedInnerClassesScope != null) {
            return unsubstitutedInnerClassesScope;
        }
        m9428a(27);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public MemberScope3 getUnsubstitutedMemberScope() {
        MemberScope3 unsubstitutedMemberScope = getUnsubstitutedMemberScope(DescriptorUtils2.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this.f22980k)));
        if (unsubstitutedMemberScope != null) {
            return unsubstitutedMemberScope;
        }
        m9428a(12);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return this.f22980k.getUnsubstitutedPrimaryConstructor();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithVisibility, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        DescriptorVisibility2 visibility = this.f22980k.getVisibility();
        if (visibility != null) {
            return visibility;
        }
        m9428a(26);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isActual() {
        return this.f22980k.isActual();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isCompanionObject() {
        return this.f22980k.isCompanionObject();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isData() {
        return this.f22980k.isData();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isExpect() {
        return this.f22980k.isExpect();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isExternal() {
        return this.f22980k.isExternal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isFun() {
        return this.f22980k.isFun();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isInline() {
        return this.f22980k.isInline();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return this.f22980k.isInner();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isValue() {
        return this.f22980k.isValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor2 typeSubstitutor2) {
        return substitute(typeSubstitutor2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ModuleAwareClassDescriptor
    public MemberScope3 getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            m9428a(13);
            throw null;
        }
        MemberScope3 unsubstitutedMemberScope = this.f22980k.getUnsubstitutedMemberScope(kotlinTypeRefiner);
        if (!this.f22981l.isEmpty()) {
            return new SubstitutingScope(unsubstitutedMemberScope, m9429b());
        }
        if (unsubstitutedMemberScope != null) {
            return unsubstitutedMemberScope;
        }
        m9428a(14);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    public ClassDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        if (typeSubstitutor2 != null) {
            return typeSubstitutor2.isEmpty() ? this : new LazySubstitutingClassDescriptor(this, TypeSubstitutor2.createChainedSubstitutor(typeSubstitutor2.getSubstitution(), m9429b().getSubstitution()));
        }
        m9428a(22);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public ClassDescriptor getOriginal() {
        ClassDescriptor original = this.f22980k.getOriginal();
        if (original != null) {
            return original;
        }
        m9428a(20);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public MemberScope3 getMemberScope(TypeSubstitution5 typeSubstitution5) {
        if (typeSubstitution5 != null) {
            MemberScope3 memberScope = getMemberScope(typeSubstitution5, DescriptorUtils2.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
            if (memberScope != null) {
                return memberScope;
            }
            m9428a(11);
            throw null;
        }
        m9428a(10);
        throw null;
    }
}
