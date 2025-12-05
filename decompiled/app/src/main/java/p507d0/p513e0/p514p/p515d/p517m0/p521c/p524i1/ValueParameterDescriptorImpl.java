package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.LazyJVM;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithSource;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.VariableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: ValueParameterDescriptorImpl.kt */
/* renamed from: d0.e0.p.d.m0.c.i1.l0, reason: use source file name */
/* loaded from: classes3.dex */
public class ValueParameterDescriptorImpl extends VariableDescriptorImpl implements ValueParameterDescriptor {

    /* renamed from: o */
    public static final a f22898o = new a(null);

    /* renamed from: p */
    public final int f22899p;

    /* renamed from: q */
    public final boolean f22900q;

    /* renamed from: r */
    public final boolean f22901r;

    /* renamed from: s */
    public final boolean f22902s;

    /* renamed from: t */
    public final KotlinType f22903t;

    /* renamed from: u */
    public final ValueParameterDescriptor f22904u;

    /* compiled from: ValueParameterDescriptorImpl.kt */
    /* renamed from: d0.e0.p.d.m0.c.i1.l0$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final ValueParameterDescriptorImpl createWithDestructuringDeclarations(CallableDescriptor callableDescriptor, ValueParameterDescriptor valueParameterDescriptor, int i, Annotations4 annotations4, Name name, KotlinType kotlinType, boolean z2, boolean z3, boolean z4, KotlinType kotlinType2, SourceElement sourceElement, Function0<? extends List<? extends VariableDescriptor>> function0) {
            Intrinsics3.checkNotNullParameter(callableDescriptor, "containingDeclaration");
            Intrinsics3.checkNotNullParameter(annotations4, "annotations");
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(kotlinType, "outType");
            Intrinsics3.checkNotNullParameter(sourceElement, "source");
            return function0 == null ? new ValueParameterDescriptorImpl(callableDescriptor, valueParameterDescriptor, i, annotations4, name, kotlinType, z2, z3, z4, kotlinType2, sourceElement) : new b(callableDescriptor, valueParameterDescriptor, i, annotations4, name, kotlinType, z2, z3, z4, kotlinType2, sourceElement, function0);
        }
    }

    /* compiled from: ValueParameterDescriptorImpl.kt */
    /* renamed from: d0.e0.p.d.m0.c.i1.l0$b */
    public static final class b extends ValueParameterDescriptorImpl {

        /* renamed from: v */
        public final Lazy f22905v;

        /* compiled from: ValueParameterDescriptorImpl.kt */
        /* renamed from: d0.e0.p.d.m0.c.i1.l0$b$a */
        public static final class a extends Lambda implements Function0<List<? extends VariableDescriptor>> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends VariableDescriptor> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends VariableDescriptor> invoke2() {
                return b.this.getDestructuringVariables();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CallableDescriptor callableDescriptor, ValueParameterDescriptor valueParameterDescriptor, int i, Annotations4 annotations4, Name name, KotlinType kotlinType, boolean z2, boolean z3, boolean z4, KotlinType kotlinType2, SourceElement sourceElement, Function0<? extends List<? extends VariableDescriptor>> function0) {
            super(callableDescriptor, valueParameterDescriptor, i, annotations4, name, kotlinType, z2, z3, z4, kotlinType2, sourceElement);
            Intrinsics3.checkNotNullParameter(callableDescriptor, "containingDeclaration");
            Intrinsics3.checkNotNullParameter(annotations4, "annotations");
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(kotlinType, "outType");
            Intrinsics3.checkNotNullParameter(sourceElement, "source");
            Intrinsics3.checkNotNullParameter(function0, "destructuringVariables");
            this.f22905v = LazyJVM.lazy(function0);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ValueParameterDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor
        public ValueParameterDescriptor copy(CallableDescriptor callableDescriptor, Name name, int i) {
            Intrinsics3.checkNotNullParameter(callableDescriptor, "newOwner");
            Intrinsics3.checkNotNullParameter(name, "newName");
            Annotations4 annotations = getAnnotations();
            Intrinsics3.checkNotNullExpressionValue(annotations, "annotations");
            KotlinType type = getType();
            Intrinsics3.checkNotNullExpressionValue(type, "type");
            boolean zDeclaresDefaultValue = declaresDefaultValue();
            boolean zIsCrossinline = isCrossinline();
            boolean zIsNoinline = isNoinline();
            KotlinType varargElementType = getVarargElementType();
            SourceElement sourceElement = SourceElement.f23099a;
            Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            return new b(callableDescriptor, null, i, annotations, name, type, zDeclaresDefaultValue, zIsCrossinline, zIsNoinline, varargElementType, sourceElement, new a());
        }

        public final List<VariableDescriptor> getDestructuringVariables() {
            return (List) this.f22905v.getValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValueParameterDescriptorImpl(CallableDescriptor callableDescriptor, ValueParameterDescriptor valueParameterDescriptor, int i, Annotations4 annotations4, Name name, KotlinType kotlinType, boolean z2, boolean z3, boolean z4, KotlinType kotlinType2, SourceElement sourceElement) {
        super(callableDescriptor, annotations4, name, kotlinType, sourceElement);
        Intrinsics3.checkNotNullParameter(callableDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(kotlinType, "outType");
        Intrinsics3.checkNotNullParameter(sourceElement, "source");
        this.f22899p = i;
        this.f22900q = z2;
        this.f22901r = z3;
        this.f22902s = z4;
        this.f22903t = kotlinType2;
        this.f22904u = valueParameterDescriptor == null ? this : valueParameterDescriptor;
    }

    public static final ValueParameterDescriptorImpl createWithDestructuringDeclarations(CallableDescriptor callableDescriptor, ValueParameterDescriptor valueParameterDescriptor, int i, Annotations4 annotations4, Name name, KotlinType kotlinType, boolean z2, boolean z3, boolean z4, KotlinType kotlinType2, SourceElement sourceElement, Function0<? extends List<? extends VariableDescriptor>> function0) {
        return f22898o.createWithDestructuringDeclarations(callableDescriptor, valueParameterDescriptor, i, annotations4, name, kotlinType, z2, z3, z4, kotlinType2, sourceElement, function0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        Intrinsics3.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitValueParameterDescriptor(this, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor
    public ValueParameterDescriptor copy(CallableDescriptor callableDescriptor, Name name, int i) {
        Intrinsics3.checkNotNullParameter(callableDescriptor, "newOwner");
        Intrinsics3.checkNotNullParameter(name, "newName");
        Annotations4 annotations = getAnnotations();
        Intrinsics3.checkNotNullExpressionValue(annotations, "annotations");
        KotlinType type = getType();
        Intrinsics3.checkNotNullExpressionValue(type, "type");
        boolean zDeclaresDefaultValue = declaresDefaultValue();
        boolean zIsCrossinline = isCrossinline();
        boolean zIsNoinline = isNoinline();
        KotlinType varargElementType = getVarargElementType();
        SourceElement sourceElement = SourceElement.f23099a;
        Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return new ValueParameterDescriptorImpl(callableDescriptor, null, i, annotations, name, type, zDeclaresDefaultValue, zIsCrossinline, zIsNoinline, varargElementType, sourceElement);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor
    public boolean declaresDefaultValue() {
        return this.f22900q && ((CallableMemberDescriptor) getContainingDeclaration()).getKind().isReal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.VariableDescriptor
    public /* bridge */ /* synthetic */ AbstractC11815g getCompileTimeInitializer() {
        return (AbstractC11815g) m11462getCompileTimeInitializer();
    }

    /* renamed from: getCompileTimeInitializer, reason: collision with other method in class */
    public Void m11462getCompileTimeInitializer() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor
    public int getIndex() {
        return this.f22899p;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public Collection<ValueParameterDescriptor> getOverriddenDescriptors() {
        Collection<? extends CallableDescriptor> overriddenDescriptors = getContainingDeclaration().getOverriddenDescriptors();
        Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors, "containingDeclaration.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(overriddenDescriptors, 10));
        Iterator<T> it = overriddenDescriptors.iterator();
        while (it.hasNext()) {
            arrayList.add(((CallableDescriptor) it.next()).getValueParameters().get(getIndex()));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor
    public KotlinType getVarargElementType() {
        return this.f22903t;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithVisibility, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        DescriptorVisibility2 descriptorVisibility2 = DescriptorVisibilities.f23088f;
        Intrinsics3.checkNotNullExpressionValue(descriptorVisibility2, "LOCAL");
        return descriptorVisibility2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor
    public boolean isCrossinline() {
        return this.f22901r;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor
    public boolean isNoinline() {
        return this.f22902s;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.VariableDescriptor
    public boolean isVar() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor2 typeSubstitutor2) {
        return substitute(typeSubstitutor2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public CallableDescriptor getContainingDeclaration() {
        return (CallableDescriptor) super.getContainingDeclaration();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    public ValueParameterDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        Intrinsics3.checkNotNullParameter(typeSubstitutor2, "substitutor");
        if (typeSubstitutor2.isEmpty()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public ValueParameterDescriptor getOriginal() {
        ValueParameterDescriptor valueParameterDescriptor = this.f22904u;
        return valueParameterDescriptor == this ? this : valueParameterDescriptor.getOriginal();
    }
}
