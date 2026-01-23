package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithSource;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.TypeAliasConstructorDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor6;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.e, reason: use source file name */
/* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractTypeAliasDescriptor2 extends DeclarationDescriptorNonRootImpl implements TypeAliasDescriptor {

    /* JADX INFO: renamed from: n */
    public final DescriptorVisibility2 f22851n;

    /* JADX INFO: renamed from: o */
    public List<? extends TypeParameterDescriptor> f22852o;

    /* JADX INFO: renamed from: p */
    public final b f22853p;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.e$a */
    /* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
    public static final class a extends Lambda implements Function1<KotlinType3, Boolean> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(KotlinType3 kotlinType3) {
            return invoke2(kotlinType3);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Boolean invoke2(KotlinType3 kotlinType3) {
            boolean z2;
            Intrinsics3.checkNotNullExpressionValue(kotlinType3, "type");
            if (!KotlinType2.isError(kotlinType3)) {
                AbstractTypeAliasDescriptor2 abstractTypeAliasDescriptor2 = AbstractTypeAliasDescriptor2.this;
                ClassifierDescriptor declarationDescriptor = kotlinType3.getConstructor().getDeclarationDescriptor();
                z2 = (declarationDescriptor instanceof TypeParameterDescriptor) && !Intrinsics3.areEqual(((TypeParameterDescriptor) declarationDescriptor).getContainingDeclaration(), abstractTypeAliasDescriptor2);
            }
            return Boolean.valueOf(z2);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.e$b */
    /* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
    public static final class b implements TypeConstructor {
        public b() {
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            return DescriptorUtils2.getBuiltIns(getDeclarationDescriptor());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public /* bridge */ /* synthetic */ ClassifierDescriptor getDeclarationDescriptor() {
            return getDeclarationDescriptor();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            List list = ((DeserializedMemberDescriptor6) AbstractTypeAliasDescriptor2.this).f24621z;
            if (list != null) {
                return list;
            }
            Intrinsics3.throwUninitializedPropertyAccessException("typeConstructorParameters");
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public Collection<KotlinType> getSupertypes() {
            Collection<KotlinType> supertypes = getDeclarationDescriptor().getUnderlyingType().getConstructor().getSupertypes();
            Intrinsics3.checkNotNullExpressionValue(supertypes, "declarationDescriptor.underlyingType.constructor.supertypes");
            return supertypes;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("[typealias ");
            sbM833U.append(getDeclarationDescriptor().getName().asString());
            sbM833U.append(']');
            return sbM833U.toString();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public TypeAliasDescriptor getDeclarationDescriptor() {
            return AbstractTypeAliasDescriptor2.this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeAliasDescriptor2(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, Name name, SourceElement sourceElement, DescriptorVisibility2 descriptorVisibility2) {
        super(declarationDescriptor, annotations4, name, sourceElement);
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(sourceElement, "sourceElement");
        Intrinsics3.checkNotNullParameter(descriptorVisibility2, "visibilityImpl");
        this.f22851n = descriptorVisibility2;
        this.f22853p = new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        Intrinsics3.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitTypeAliasDescriptor(this, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List list = this.f22852o;
        if (list != null) {
            return list;
        }
        Intrinsics3.throwUninitializedPropertyAccessException("declaredTypeParametersImpl");
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getOriginal() {
        return getOriginal();
    }

    public final Collection<TypeAliasConstructorDescriptor> getTypeAliasConstructors() {
        DeserializedMemberDescriptor6 deserializedMemberDescriptor6 = (DeserializedMemberDescriptor6) this;
        ClassDescriptor classDescriptor = deserializedMemberDescriptor6.getClassDescriptor();
        if (classDescriptor == null) {
            return Collections2.emptyList();
        }
        Collection<ClassConstructorDescriptor> constructors = classDescriptor.getConstructors();
        Intrinsics3.checkNotNullExpressionValue(constructors, "classDescriptor.constructors");
        ArrayList arrayList = new ArrayList();
        for (ClassConstructorDescriptor classConstructorDescriptor : constructors) {
            TypeAliasConstructorDescriptor2.a aVar = TypeAliasConstructorDescriptor2.f22887M;
            StorageManager storageManager = deserializedMemberDescriptor6.f24612q;
            Intrinsics3.checkNotNullExpressionValue(classConstructorDescriptor, "it");
            TypeAliasConstructorDescriptor typeAliasConstructorDescriptorCreateIfAvailable = aVar.createIfAvailable(storageManager, this, classConstructorDescriptor);
            if (typeAliasConstructorDescriptorCreateIfAvailable != null) {
                arrayList.add(typeAliasConstructorDescriptorCreateIfAvailable);
            }
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.f22853p;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithVisibility, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        return this.f22851n;
    }

    public final void initialize(List<? extends TypeParameterDescriptor> list) {
        Intrinsics3.checkNotNullParameter(list, "declaredTypeParameters");
        this.f22852o = list;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return TypeUtils.contains(((DeserializedMemberDescriptor6) this).getUnderlyingType(), new a());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl
    public String toString() {
        return Intrinsics3.stringPlus("typealias ", getName().asString());
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
    public TypeAliasDescriptor getOriginal() {
        return (TypeAliasDescriptor) super.getOriginal();
    }
}
