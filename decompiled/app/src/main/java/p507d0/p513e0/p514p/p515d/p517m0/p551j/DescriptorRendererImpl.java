package p507d0.p513e0.p514p.p515d.p517m0.p551j;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.functionTypes;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithSource;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FieldDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11469v0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.NotFoundClasses;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageViewDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyAccessorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyGetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertySetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.VariableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationUseSiteTarget;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.typeParameterUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.typeParameterUtils3;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.SpecialNames;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11807a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11809b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11826r;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorType2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p579g0._Strings;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p580t._Sets;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: DescriptorRendererImpl.kt */
/* renamed from: d0.e0.p.d.m0.j.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class DescriptorRendererImpl extends DescriptorRenderer2 implements DescriptorRenderer4 {

    /* renamed from: d */
    public final DescriptorRendererOptionsImpl f24239d;

    /* renamed from: e */
    public final Lazy f24240e;

    /* compiled from: DescriptorRendererImpl.kt */
    /* renamed from: d0.e0.p.d.m0.j.d$a */
    public final class a implements DeclarationDescriptorVisitor<Unit, StringBuilder> {

        /* renamed from: a */
        public final /* synthetic */ DescriptorRendererImpl f24241a;

        public a(DescriptorRendererImpl descriptorRendererImpl) {
            Intrinsics3.checkNotNullParameter(descriptorRendererImpl, "this$0");
            this.f24241a = descriptorRendererImpl;
        }

        /* renamed from: a */
        public final void m9908a(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb, String str) {
            int iOrdinal = this.f24241a.getPropertyAccessorRenderingPolicy().ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    return;
                }
                visitFunctionDescriptor2((FunctionDescriptor) propertyAccessorDescriptor, sb);
            } else {
                DescriptorRendererImpl.access$renderAccessorModifiers(this.f24241a, propertyAccessorDescriptor, sb);
                sb.append(Intrinsics3.stringPlus(str, " for "));
                DescriptorRendererImpl descriptorRendererImpl = this.f24241a;
                PropertyDescriptor correspondingProperty = propertyAccessorDescriptor.getCorrespondingProperty();
                Intrinsics3.checkNotNullExpressionValue(correspondingProperty, "descriptor.correspondingProperty");
                DescriptorRendererImpl.access$renderProperty(descriptorRendererImpl, correspondingProperty, sb);
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitClassDescriptor(ClassDescriptor classDescriptor, StringBuilder sb) {
            visitClassDescriptor2(classDescriptor, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, StringBuilder sb) {
            visitConstructorDescriptor2(constructorDescriptor, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitFunctionDescriptor(FunctionDescriptor functionDescriptor, StringBuilder sb) {
            visitFunctionDescriptor2(functionDescriptor, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitModuleDeclaration(ModuleDescriptor2 moduleDescriptor2, StringBuilder sb) {
            visitModuleDeclaration2(moduleDescriptor2, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
            visitPackageFragmentDescriptor2(packageFragmentDescriptor, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
            visitPackageViewDescriptor2(packageViewDescriptor, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
            visitPropertyDescriptor2(propertyDescriptor, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, StringBuilder sb) {
            visitPropertyGetterDescriptor2(propertyGetterDescriptor, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, StringBuilder sb) {
            visitPropertySetterDescriptor2(propertySetterDescriptor, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, StringBuilder sb) {
            visitReceiverParameterDescriptor2(receiverParameterDescriptor, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
            visitTypeAliasDescriptor2(typeAliasDescriptor, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb) {
            visitTypeParameterDescriptor2(typeParameterDescriptor, sb);
            return Unit.f27425a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, StringBuilder sb) {
            visitValueParameterDescriptor2(valueParameterDescriptor, sb);
            return Unit.f27425a;
        }

        /* renamed from: visitClassDescriptor, reason: avoid collision after fix types in other method */
        public void visitClassDescriptor2(ClassDescriptor classDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderClass(this.f24241a, classDescriptor, sb);
        }

        /* renamed from: visitConstructorDescriptor, reason: avoid collision after fix types in other method */
        public void visitConstructorDescriptor2(ConstructorDescriptor constructorDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(constructorDescriptor, "constructorDescriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderConstructor(this.f24241a, constructorDescriptor, sb);
        }

        /* renamed from: visitFunctionDescriptor, reason: avoid collision after fix types in other method */
        public void visitFunctionDescriptor2(FunctionDescriptor functionDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(functionDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderFunction(this.f24241a, functionDescriptor, sb);
        }

        /* renamed from: visitModuleDeclaration, reason: avoid collision after fix types in other method */
        public void visitModuleDeclaration2(ModuleDescriptor2 moduleDescriptor2, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderName(this.f24241a, moduleDescriptor2, sb, true);
        }

        /* renamed from: visitPackageFragmentDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageFragmentDescriptor2(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderPackageFragment(this.f24241a, packageFragmentDescriptor, sb);
        }

        /* renamed from: visitPackageViewDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageViewDescriptor2(PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(packageViewDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderPackageView(this.f24241a, packageViewDescriptor, sb);
        }

        /* renamed from: visitPropertyDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyDescriptor2(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderProperty(this.f24241a, propertyDescriptor, sb);
        }

        /* renamed from: visitPropertyGetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyGetterDescriptor2(PropertyGetterDescriptor propertyGetterDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(propertyGetterDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            m9908a(propertyGetterDescriptor, sb, "getter");
        }

        /* renamed from: visitPropertySetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertySetterDescriptor2(PropertySetterDescriptor propertySetterDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(propertySetterDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            m9908a(propertySetterDescriptor, sb, "setter");
        }

        /* renamed from: visitReceiverParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitReceiverParameterDescriptor2(ReceiverParameterDescriptor receiverParameterDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(receiverParameterDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            sb.append(receiverParameterDescriptor.getName());
        }

        /* renamed from: visitTypeAliasDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeAliasDescriptor2(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(typeAliasDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderTypeAlias(this.f24241a, typeAliasDescriptor, sb);
        }

        /* renamed from: visitTypeParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeParameterDescriptor2(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderTypeParameter(this.f24241a, typeParameterDescriptor, sb, true);
        }

        /* renamed from: visitValueParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitValueParameterDescriptor2(ValueParameterDescriptor valueParameterDescriptor, StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(valueParameterDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderValueParameter(this.f24241a, valueParameterDescriptor, true, sb, true);
        }
    }

    /* compiled from: DescriptorRendererImpl.kt */
    /* renamed from: d0.e0.p.d.m0.j.d$b */
    public static final class b extends Lambda implements Function1<TypeProjection, CharSequence> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(TypeProjection typeProjection) {
            return invoke2(typeProjection);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(TypeProjection typeProjection) {
            Intrinsics3.checkNotNullParameter(typeProjection, "it");
            if (typeProjection.isStarProjection()) {
                return "*";
            }
            DescriptorRendererImpl descriptorRendererImpl = DescriptorRendererImpl.this;
            KotlinType type = typeProjection.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "it.type");
            String strRenderType = descriptorRendererImpl.renderType(type);
            if (typeProjection.getProjectionKind() == Variance.INVARIANT) {
                return strRenderType;
            }
            return typeProjection.getProjectionKind() + ' ' + strRenderType;
        }
    }

    /* compiled from: DescriptorRendererImpl.kt */
    /* renamed from: d0.e0.p.d.m0.j.d$c */
    public static final class c extends Lambda implements Function0<DescriptorRendererImpl> {

        /* compiled from: DescriptorRendererImpl.kt */
        /* renamed from: d0.e0.p.d.m0.j.d$c$a */
        public static final class a extends Lambda implements Function1<DescriptorRenderer4, Unit> {

            /* renamed from: j */
            public static final a f24242j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
                invoke2(descriptorRenderer4);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
                Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
                descriptorRenderer4.setExcludedTypeAnnotationClasses(_Sets.plus((Set) descriptorRenderer4.getExcludedTypeAnnotationClasses(), (Iterable) CollectionsJVM.listOf(StandardNames.a.f22569x)));
                descriptorRenderer4.setAnnotationArgumentsRenderingPolicy(DescriptorRenderer.ALWAYS_PARENTHESIZED);
            }
        }

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ DescriptorRendererImpl invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DescriptorRendererImpl invoke() {
            return (DescriptorRendererImpl) DescriptorRendererImpl.this.withOptions(a.f24242j);
        }
    }

    /* compiled from: DescriptorRendererImpl.kt */
    /* renamed from: d0.e0.p.d.m0.j.d$d */
    public static final class d extends Lambda implements Function1<AbstractC11815g<?>, CharSequence> {
        public d() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(AbstractC11815g<?> abstractC11815g) {
            Intrinsics3.checkNotNullParameter(abstractC11815g, "it");
            return DescriptorRendererImpl.access$renderConstant(DescriptorRendererImpl.this, abstractC11815g);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(AbstractC11815g<?> abstractC11815g) {
            return invoke2(abstractC11815g);
        }
    }

    public DescriptorRendererImpl(DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        Intrinsics3.checkNotNullParameter(descriptorRendererOptionsImpl, "options");
        this.f24239d = descriptorRendererOptionsImpl;
        descriptorRendererOptionsImpl.isLocked();
        this.f24240e = LazyJVM.lazy(new c());
    }

    public static final void access$renderAccessorModifiers(DescriptorRendererImpl descriptorRendererImpl, PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb) {
        descriptorRendererImpl.m9897p(propertyAccessorDescriptor, sb);
    }

    public static final void access$renderClass(DescriptorRendererImpl descriptorRendererImpl, ClassDescriptor classDescriptor, StringBuilder sb) {
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        Objects.requireNonNull(descriptorRendererImpl);
        boolean z2 = classDescriptor.getKind() == ClassKind.ENUM_ENTRY;
        if (!descriptorRendererImpl.getStartFromName()) {
            descriptorRendererImpl.m9890h(sb, classDescriptor, null);
            if (!z2) {
                DescriptorVisibility2 visibility = classDescriptor.getVisibility();
                Intrinsics3.checkNotNullExpressionValue(visibility, "klass.visibility");
                descriptorRendererImpl.m9879I(visibility, sb);
            }
            if ((classDescriptor.getKind() != ClassKind.INTERFACE || classDescriptor.getModality() != Modality.ABSTRACT) && (!classDescriptor.getKind().isSingleton() || classDescriptor.getModality() != Modality.FINAL)) {
                Modality modality = classDescriptor.getModality();
                Intrinsics3.checkNotNullExpressionValue(modality, "klass.modality");
                descriptorRendererImpl.m9898q(modality, sb, descriptorRendererImpl.m9887e(classDescriptor));
            }
            descriptorRendererImpl.m9897p(classDescriptor, sb);
            descriptorRendererImpl.m9900s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRenderer3.INNER) && classDescriptor.isInner(), "inner");
            descriptorRendererImpl.m9900s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRenderer3.DATA) && classDescriptor.isData(), "data");
            descriptorRendererImpl.m9900s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRenderer3.INLINE) && classDescriptor.isInline(), "inline");
            descriptorRendererImpl.m9900s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRenderer3.VALUE) && classDescriptor.isValue(), "value");
            descriptorRendererImpl.m9900s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRenderer3.FUN) && classDescriptor.isFun(), "fun");
            sb.append(descriptorRendererImpl.m9895n(DescriptorRenderer2.f24225a.getClassifierKindPrefix(classDescriptor)));
        }
        if (DescriptorUtils.isCompanionObject(classDescriptor)) {
            if (descriptorRendererImpl.getRenderCompanionObjectName()) {
                if (descriptorRendererImpl.getStartFromName()) {
                    sb.append("companion object");
                }
                descriptorRendererImpl.m9872B(sb);
                DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
                if (containingDeclaration != null) {
                    sb.append("of ");
                    Name name = containingDeclaration.getName();
                    Intrinsics3.checkNotNullExpressionValue(name, "containingDeclaration.name");
                    sb.append(descriptorRendererImpl.renderName(name, false));
                }
            }
            if (descriptorRendererImpl.getVerbose() || !Intrinsics3.areEqual(classDescriptor.getName(), SpecialNames.f24093b)) {
                if (!descriptorRendererImpl.getStartFromName()) {
                    descriptorRendererImpl.m9872B(sb);
                }
                Name name2 = classDescriptor.getName();
                Intrinsics3.checkNotNullExpressionValue(name2, "descriptor.name");
                sb.append(descriptorRendererImpl.renderName(name2, true));
            }
        } else {
            if (!descriptorRendererImpl.getStartFromName()) {
                descriptorRendererImpl.m9872B(sb);
            }
            descriptorRendererImpl.m9901t(classDescriptor, sb, true);
        }
        if (z2) {
            return;
        }
        List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(declaredTypeParameters, "klass.declaredTypeParameters");
        descriptorRendererImpl.m9875E(declaredTypeParameters, sb, false);
        descriptorRendererImpl.m9891j(classDescriptor, sb);
        if (!classDescriptor.getKind().isSingleton() && descriptorRendererImpl.getClassWithPrimaryConstructor() && (unsubstitutedPrimaryConstructor = classDescriptor.getUnsubstitutedPrimaryConstructor()) != null) {
            sb.append(" ");
            descriptorRendererImpl.m9890h(sb, unsubstitutedPrimaryConstructor, null);
            DescriptorVisibility2 visibility2 = unsubstitutedPrimaryConstructor.getVisibility();
            Intrinsics3.checkNotNullExpressionValue(visibility2, "primaryConstructor.visibility");
            descriptorRendererImpl.m9879I(visibility2, sb);
            sb.append(descriptorRendererImpl.m9895n("constructor"));
            List<ValueParameterDescriptor> valueParameters = unsubstitutedPrimaryConstructor.getValueParameters();
            Intrinsics3.checkNotNullExpressionValue(valueParameters, "primaryConstructor.valueParameters");
            descriptorRendererImpl.m9878H(valueParameters, unsubstitutedPrimaryConstructor.hasSynthesizedParameterNames(), sb);
        }
        if (!descriptorRendererImpl.getWithoutSuperTypes() && !KotlinBuiltIns.isNothing(classDescriptor.getDefaultType())) {
            Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
            Intrinsics3.checkNotNullExpressionValue(supertypes, "klass.typeConstructor.supertypes");
            if (!supertypes.isEmpty() && (supertypes.size() != 1 || !KotlinBuiltIns.isAnyOrNullableAny(supertypes.iterator().next()))) {
                descriptorRendererImpl.m9872B(sb);
                sb.append(": ");
                _Collections.joinTo$default(supertypes, sb, ", ", null, null, 0, null, new DescriptorRendererImpl3(descriptorRendererImpl), 60, null);
            }
        }
        descriptorRendererImpl.m9880J(declaredTypeParameters, sb);
    }

    public static final /* synthetic */ String access$renderConstant(DescriptorRendererImpl descriptorRendererImpl, AbstractC11815g abstractC11815g) {
        return descriptorRendererImpl.m9892k(abstractC11815g);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void access$renderConstructor(DescriptorRendererImpl descriptorRendererImpl, ConstructorDescriptor constructorDescriptor, StringBuilder sb) {
        boolean z2;
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        descriptorRendererImpl.m9890h(sb, constructorDescriptor, null);
        if (descriptorRendererImpl.f24239d.getRenderDefaultVisibility() || constructorDescriptor.getConstructedClass().getModality() != Modality.SEALED) {
            DescriptorVisibility2 visibility = constructorDescriptor.getVisibility();
            Intrinsics3.checkNotNullExpressionValue(visibility, "constructor.visibility");
            z2 = descriptorRendererImpl.m9879I(visibility, sb);
        }
        descriptorRendererImpl.m9896o(constructorDescriptor, sb);
        boolean z3 = descriptorRendererImpl.getRenderConstructorKeyword() || !constructorDescriptor.isPrimary() || z2;
        if (z3) {
            sb.append(descriptorRendererImpl.m9895n("constructor"));
        }
        ClassifierDescriptorWithTypeParameters containingDeclaration = constructorDescriptor.getContainingDeclaration();
        Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "constructor.containingDeclaration");
        if (descriptorRendererImpl.getSecondaryConstructorsAsPrimary()) {
            if (z3) {
                sb.append(" ");
            }
            descriptorRendererImpl.m9901t(containingDeclaration, sb, true);
            List<TypeParameterDescriptor> typeParameters = constructorDescriptor.getTypeParameters();
            Intrinsics3.checkNotNullExpressionValue(typeParameters, "constructor.typeParameters");
            descriptorRendererImpl.m9875E(typeParameters, sb, false);
        }
        List<ValueParameterDescriptor> valueParameters = constructorDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "constructor.valueParameters");
        descriptorRendererImpl.m9878H(valueParameters, constructorDescriptor.hasSynthesizedParameterNames(), sb);
        if (descriptorRendererImpl.getRenderConstructorDelegation() && !constructorDescriptor.isPrimary() && (containingDeclaration instanceof ClassDescriptor) && (unsubstitutedPrimaryConstructor = ((ClassDescriptor) containingDeclaration).getUnsubstitutedPrimaryConstructor()) != null) {
            List<ValueParameterDescriptor> valueParameters2 = unsubstitutedPrimaryConstructor.getValueParameters();
            ArrayList arrayListM840a0 = outline.m840a0(valueParameters2, "primaryConstructor.valueParameters");
            for (Object obj : valueParameters2) {
                ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) obj;
                if (!valueParameterDescriptor.declaresDefaultValue() && valueParameterDescriptor.getVarargElementType() == null) {
                    arrayListM840a0.add(obj);
                }
            }
            if (!arrayListM840a0.isEmpty()) {
                sb.append(" : ");
                sb.append(descriptorRendererImpl.m9895n("this"));
                sb.append(_Collections.joinToString$default(arrayListM840a0, ", ", "(", ")", 0, null, DescriptorRendererImpl2.f24243j, 24, null));
            }
        }
        if (descriptorRendererImpl.getSecondaryConstructorsAsPrimary()) {
            List<TypeParameterDescriptor> typeParameters2 = constructorDescriptor.getTypeParameters();
            Intrinsics3.checkNotNullExpressionValue(typeParameters2, "constructor.typeParameters");
            descriptorRendererImpl.m9880J(typeParameters2, sb);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void access$renderFunction(DescriptorRendererImpl descriptorRendererImpl, FunctionDescriptor functionDescriptor, StringBuilder sb) {
        boolean z2;
        boolean z3;
        if (!descriptorRendererImpl.getStartFromName()) {
            if (!descriptorRendererImpl.getStartFromDeclarationKeyword()) {
                descriptorRendererImpl.m9890h(sb, functionDescriptor, null);
                DescriptorVisibility2 visibility = functionDescriptor.getVisibility();
                Intrinsics3.checkNotNullExpressionValue(visibility, "function.visibility");
                descriptorRendererImpl.m9879I(visibility, sb);
                descriptorRendererImpl.m9899r(functionDescriptor, sb);
                if (descriptorRendererImpl.getIncludeAdditionalModifiers()) {
                    descriptorRendererImpl.m9897p(functionDescriptor, sb);
                }
                descriptorRendererImpl.m9904w(functionDescriptor, sb);
                if (descriptorRendererImpl.getIncludeAdditionalModifiers()) {
                    boolean z4 = false;
                    if (functionDescriptor.isOperator()) {
                        Collection<? extends FunctionDescriptor> overriddenDescriptors = functionDescriptor.getOverriddenDescriptors();
                        Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors, "functionDescriptor.overriddenDescriptors");
                        if (overriddenDescriptors.isEmpty()) {
                            z3 = true;
                            boolean z5 = !z3 || descriptorRendererImpl.getAlwaysRenderModifiers();
                            if (functionDescriptor.isInfix()) {
                                Collection<? extends FunctionDescriptor> overriddenDescriptors2 = functionDescriptor.getOverriddenDescriptors();
                                Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors2, "functionDescriptor.overriddenDescriptors");
                                if (overriddenDescriptors2.isEmpty()) {
                                    z2 = true;
                                    if (!z2 || descriptorRendererImpl.getAlwaysRenderModifiers()) {
                                        z4 = true;
                                    }
                                } else {
                                    Iterator<T> it = overriddenDescriptors2.iterator();
                                    while (it.hasNext()) {
                                        if (((FunctionDescriptor) it.next()).isInfix()) {
                                            z2 = false;
                                            break;
                                        }
                                    }
                                    z2 = true;
                                    if (!z2) {
                                        z4 = true;
                                    }
                                }
                            }
                            descriptorRendererImpl.m9900s(sb, functionDescriptor.isTailrec(), "tailrec");
                            descriptorRendererImpl.m9900s(sb, functionDescriptor.isSuspend(), "suspend");
                            descriptorRendererImpl.m9900s(sb, functionDescriptor.isInline(), "inline");
                            descriptorRendererImpl.m9900s(sb, z4, "infix");
                            descriptorRendererImpl.m9900s(sb, z5, "operator");
                        } else {
                            Iterator<T> it2 = overriddenDescriptors.iterator();
                            while (it2.hasNext()) {
                                if (((FunctionDescriptor) it2.next()).isOperator()) {
                                    z3 = false;
                                    break;
                                }
                            }
                            z3 = true;
                            if (z3) {
                            }
                            if (functionDescriptor.isInfix()) {
                            }
                            descriptorRendererImpl.m9900s(sb, functionDescriptor.isTailrec(), "tailrec");
                            descriptorRendererImpl.m9900s(sb, functionDescriptor.isSuspend(), "suspend");
                            descriptorRendererImpl.m9900s(sb, functionDescriptor.isInline(), "inline");
                            descriptorRendererImpl.m9900s(sb, z4, "infix");
                            descriptorRendererImpl.m9900s(sb, z5, "operator");
                        }
                    }
                } else {
                    descriptorRendererImpl.m9900s(sb, functionDescriptor.isSuspend(), "suspend");
                }
                descriptorRendererImpl.m9896o(functionDescriptor, sb);
                if (descriptorRendererImpl.getVerbose()) {
                    if (functionDescriptor.isHiddenToOvercomeSignatureClash()) {
                        sb.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (functionDescriptor.isHiddenForResolutionEverywhereBesideSupercalls()) {
                        sb.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb.append(descriptorRendererImpl.m9895n("fun"));
            sb.append(" ");
            List<TypeParameterDescriptor> typeParameters = functionDescriptor.getTypeParameters();
            Intrinsics3.checkNotNullExpressionValue(typeParameters, "function.typeParameters");
            descriptorRendererImpl.m9875E(typeParameters, sb, true);
            descriptorRendererImpl.m9907z(functionDescriptor, sb);
        }
        descriptorRendererImpl.m9901t(functionDescriptor, sb, true);
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "function.valueParameters");
        descriptorRendererImpl.m9878H(valueParameters, functionDescriptor.hasSynthesizedParameterNames(), sb);
        descriptorRendererImpl.m9871A(functionDescriptor, sb);
        KotlinType returnType = functionDescriptor.getReturnType();
        if (!descriptorRendererImpl.getWithoutReturnType() && (descriptorRendererImpl.getUnitReturnType() || returnType == null || !KotlinBuiltIns.isUnit(returnType))) {
            sb.append(": ");
            sb.append(returnType == null ? "[NULL]" : descriptorRendererImpl.renderType(returnType));
        }
        List<TypeParameterDescriptor> typeParameters2 = functionDescriptor.getTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(typeParameters2, "function.typeParameters");
        descriptorRendererImpl.m9880J(typeParameters2, sb);
    }

    public static final /* synthetic */ void access$renderName(DescriptorRendererImpl descriptorRendererImpl, DeclarationDescriptor declarationDescriptor, StringBuilder sb, boolean z2) {
        descriptorRendererImpl.m9901t(declarationDescriptor, sb, z2);
    }

    public static final void access$renderPackageFragment(DescriptorRendererImpl descriptorRendererImpl, PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
        Objects.requireNonNull(descriptorRendererImpl);
        descriptorRendererImpl.m9905x(packageFragmentDescriptor.getFqName(), "package-fragment", sb);
        if (descriptorRendererImpl.getDebugMode()) {
            sb.append(" in ");
            descriptorRendererImpl.m9901t(packageFragmentDescriptor.getContainingDeclaration(), sb, false);
        }
    }

    public static final void access$renderPackageView(DescriptorRendererImpl descriptorRendererImpl, PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
        Objects.requireNonNull(descriptorRendererImpl);
        descriptorRendererImpl.m9905x(packageViewDescriptor.getFqName(), "package", sb);
        if (descriptorRendererImpl.getDebugMode()) {
            sb.append(" in context of ");
            descriptorRendererImpl.m9901t(packageViewDescriptor.getModule(), sb, false);
        }
    }

    public static final void access$renderProperty(DescriptorRendererImpl descriptorRendererImpl, PropertyDescriptor propertyDescriptor, StringBuilder sb) {
        if (!descriptorRendererImpl.getStartFromName()) {
            if (!descriptorRendererImpl.getStartFromDeclarationKeyword()) {
                if (descriptorRendererImpl.getModifiers().contains(DescriptorRenderer3.ANNOTATIONS)) {
                    descriptorRendererImpl.m9890h(sb, propertyDescriptor, null);
                    FieldDescriptor backingField = propertyDescriptor.getBackingField();
                    if (backingField != null) {
                        descriptorRendererImpl.m9890h(sb, backingField, AnnotationUseSiteTarget.FIELD);
                    }
                    FieldDescriptor delegateField = propertyDescriptor.getDelegateField();
                    if (delegateField != null) {
                        descriptorRendererImpl.m9890h(sb, delegateField, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
                    }
                    if (descriptorRendererImpl.getPropertyAccessorRenderingPolicy() == DescriptorRenderer8.NONE) {
                        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
                        if (getter != null) {
                            descriptorRendererImpl.m9890h(sb, getter, AnnotationUseSiteTarget.PROPERTY_GETTER);
                        }
                        PropertySetterDescriptor setter = propertyDescriptor.getSetter();
                        if (setter != null) {
                            descriptorRendererImpl.m9890h(sb, setter, AnnotationUseSiteTarget.PROPERTY_SETTER);
                            List<ValueParameterDescriptor> valueParameters = setter.getValueParameters();
                            Intrinsics3.checkNotNullExpressionValue(valueParameters, "setter.valueParameters");
                            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) _Collections.single((List) valueParameters);
                            Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor, "it");
                            descriptorRendererImpl.m9890h(sb, valueParameterDescriptor, AnnotationUseSiteTarget.SETTER_PARAMETER);
                        }
                    }
                }
                DescriptorVisibility2 visibility = propertyDescriptor.getVisibility();
                Intrinsics3.checkNotNullExpressionValue(visibility, "property.visibility");
                descriptorRendererImpl.m9879I(visibility, sb);
                descriptorRendererImpl.m9900s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRenderer3.CONST) && propertyDescriptor.isConst(), "const");
                descriptorRendererImpl.m9897p(propertyDescriptor, sb);
                descriptorRendererImpl.m9899r(propertyDescriptor, sb);
                descriptorRendererImpl.m9904w(propertyDescriptor, sb);
                descriptorRendererImpl.m9900s(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRenderer3.LATEINIT) && propertyDescriptor.isLateInit(), "lateinit");
                descriptorRendererImpl.m9896o(propertyDescriptor, sb);
            }
            descriptorRendererImpl.m9876F(propertyDescriptor, sb, false);
            List<TypeParameterDescriptor> typeParameters = propertyDescriptor.getTypeParameters();
            Intrinsics3.checkNotNullExpressionValue(typeParameters, "property.typeParameters");
            descriptorRendererImpl.m9875E(typeParameters, sb, true);
            descriptorRendererImpl.m9907z(propertyDescriptor, sb);
        }
        descriptorRendererImpl.m9901t(propertyDescriptor, sb, true);
        sb.append(": ");
        KotlinType type = propertyDescriptor.getType();
        Intrinsics3.checkNotNullExpressionValue(type, "property.type");
        sb.append(descriptorRendererImpl.renderType(type));
        descriptorRendererImpl.m9871A(propertyDescriptor, sb);
        descriptorRendererImpl.m9894m(propertyDescriptor, sb);
        List<TypeParameterDescriptor> typeParameters2 = propertyDescriptor.getTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(typeParameters2, "property.typeParameters");
        descriptorRendererImpl.m9880J(typeParameters2, sb);
    }

    public static final void access$renderTypeAlias(DescriptorRendererImpl descriptorRendererImpl, TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
        descriptorRendererImpl.m9890h(sb, typeAliasDescriptor, null);
        DescriptorVisibility2 visibility = typeAliasDescriptor.getVisibility();
        Intrinsics3.checkNotNullExpressionValue(visibility, "typeAlias.visibility");
        descriptorRendererImpl.m9879I(visibility, sb);
        descriptorRendererImpl.m9897p(typeAliasDescriptor, sb);
        sb.append(descriptorRendererImpl.m9895n("typealias"));
        sb.append(" ");
        descriptorRendererImpl.m9901t(typeAliasDescriptor, sb, true);
        List<TypeParameterDescriptor> declaredTypeParameters = typeAliasDescriptor.getDeclaredTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(declaredTypeParameters, "typeAlias.declaredTypeParameters");
        descriptorRendererImpl.m9875E(declaredTypeParameters, sb, false);
        descriptorRendererImpl.m9891j(typeAliasDescriptor, sb);
        sb.append(" = ");
        sb.append(descriptorRendererImpl.renderType(typeAliasDescriptor.getUnderlyingType()));
    }

    public static final /* synthetic */ void access$renderTypeParameter(DescriptorRendererImpl descriptorRendererImpl, TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb, boolean z2) {
        descriptorRendererImpl.m9873C(typeParameterDescriptor, sb, z2);
    }

    public static final /* synthetic */ void access$renderValueParameter(DescriptorRendererImpl descriptorRendererImpl, ValueParameterDescriptor valueParameterDescriptor, boolean z2, StringBuilder sb, boolean z3) {
        descriptorRendererImpl.m9877G(valueParameterDescriptor, z2, sb, z3);
    }

    /* renamed from: i */
    public static /* synthetic */ void m9870i(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, Annotations3 annotations3, AnnotationUseSiteTarget annotationUseSiteTarget, int i) {
        int i2 = i & 2;
        descriptorRendererImpl.m9890h(sb, annotations3, null);
    }

    /* renamed from: A */
    public final void m9871A(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter;
        if (getReceiverAfterName() && (extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter()) != null) {
            sb.append(" on ");
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "receiver.type");
            sb.append(renderType(type));
        }
    }

    /* renamed from: B */
    public final void m9872B(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    /* renamed from: C */
    public final void m9873C(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb, boolean z2) {
        if (z2) {
            sb.append(m9888f());
        }
        if (getVerbose()) {
            sb.append("/*");
            sb.append(typeParameterDescriptor.getIndex());
            sb.append("*/ ");
        }
        m9900s(sb, typeParameterDescriptor.isReified(), "reified");
        String label = typeParameterDescriptor.getVariance().getLabel();
        boolean z3 = true;
        m9900s(sb, label.length() > 0, label);
        m9890h(sb, typeParameterDescriptor, null);
        m9901t(typeParameterDescriptor, sb, z2);
        int size = typeParameterDescriptor.getUpperBounds().size();
        if ((size > 1 && !z2) || size == 1) {
            KotlinType next = typeParameterDescriptor.getUpperBounds().iterator().next();
            if (!KotlinBuiltIns.isDefaultBound(next)) {
                sb.append(" : ");
                Intrinsics3.checkNotNullExpressionValue(next, "upperBound");
                sb.append(renderType(next));
            }
        } else if (z2) {
            for (KotlinType kotlinType : typeParameterDescriptor.getUpperBounds()) {
                if (!KotlinBuiltIns.isDefaultBound(kotlinType)) {
                    if (z3) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    Intrinsics3.checkNotNullExpressionValue(kotlinType, "upperBound");
                    sb.append(renderType(kotlinType));
                    z3 = false;
                }
            }
        }
        if (z2) {
            sb.append(m9886d());
        }
    }

    /* renamed from: D */
    public final void m9874D(StringBuilder sb, List<? extends TypeParameterDescriptor> list) {
        Iterator<? extends TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            m9873C(it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    /* renamed from: E */
    public final void m9875E(List<? extends TypeParameterDescriptor> list, StringBuilder sb, boolean z2) {
        if (!getWithoutTypeParameters() && (!list.isEmpty())) {
            sb.append(m9888f());
            m9874D(sb, list);
            sb.append(m9886d());
            if (z2) {
                sb.append(" ");
            }
        }
    }

    /* renamed from: F */
    public final void m9876F(VariableDescriptor variableDescriptor, StringBuilder sb, boolean z2) {
        if (z2 || !(variableDescriptor instanceof ValueParameterDescriptor)) {
            sb.append(m9895n(variableDescriptor.isVar() ? "var" : "val"));
            sb.append(" ");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e4  */
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m9877G(ValueParameterDescriptor valueParameterDescriptor, boolean z2, StringBuilder sb, boolean z3) {
        boolean z4;
        if (z3) {
            sb.append(m9895n("value-parameter"));
            sb.append(" ");
        }
        if (getVerbose()) {
            sb.append("/*");
            sb.append(valueParameterDescriptor.getIndex());
            sb.append("*/ ");
        }
        m9890h(sb, valueParameterDescriptor, null);
        m9900s(sb, valueParameterDescriptor.isCrossinline(), "crossinline");
        m9900s(sb, valueParameterDescriptor.isNoinline(), "noinline");
        boolean z5 = true;
        if (getRenderPrimaryConstructorParametersAsProperties()) {
            CallableDescriptor containingDeclaration = valueParameterDescriptor.getContainingDeclaration();
            ClassConstructorDescriptor classConstructorDescriptor = containingDeclaration instanceof ClassConstructorDescriptor ? (ClassConstructorDescriptor) containingDeclaration : null;
            z4 = Intrinsics3.areEqual(classConstructorDescriptor == null ? null : Boolean.valueOf(classConstructorDescriptor.isPrimary()), Boolean.TRUE);
        }
        if (z4) {
            m9900s(sb, getActualPropertiesInPrimaryConstructor(), "actual");
        }
        KotlinType type = valueParameterDescriptor.getType();
        Intrinsics3.checkNotNullExpressionValue(type, "variable.type");
        KotlinType varargElementType = valueParameterDescriptor != null ? valueParameterDescriptor.getVarargElementType() : null;
        KotlinType kotlinType = varargElementType == null ? type : varargElementType;
        m9900s(sb, varargElementType != null, "vararg");
        if (z4 || (z3 && !getStartFromName())) {
            m9876F(valueParameterDescriptor, sb, z4);
        }
        if (z2) {
            m9901t(valueParameterDescriptor, sb, z3);
            sb.append(": ");
        }
        sb.append(renderType(kotlinType));
        m9894m(valueParameterDescriptor, sb);
        if (getVerbose() && varargElementType != null) {
            sb.append(" /*");
            sb.append(renderType(type));
            sb.append("*/");
        }
        if (getDefaultParameterValueRenderer() == null) {
            z5 = false;
        } else {
            if (!(getDebugMode() ? valueParameterDescriptor.declaresDefaultValue() : DescriptorUtils2.declaresOrInheritsDefaultValue(valueParameterDescriptor))) {
            }
        }
        if (z5) {
            Function1<ValueParameterDescriptor, String> defaultParameterValueRenderer = getDefaultParameterValueRenderer();
            Intrinsics3.checkNotNull(defaultParameterValueRenderer);
            sb.append(Intrinsics3.stringPlus(" = ", defaultParameterValueRenderer.invoke(valueParameterDescriptor)));
        }
    }

    /* renamed from: H */
    public final void m9878H(Collection<? extends ValueParameterDescriptor> collection, boolean z2, StringBuilder sb) {
        int iOrdinal = getParameterNameRenderingPolicy().ordinal();
        boolean z3 = true;
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (z2) {
            }
            z3 = false;
        }
        int size = collection.size();
        getValueParametersHandler().appendBeforeValueParameters(size, sb);
        int i = 0;
        for (ValueParameterDescriptor valueParameterDescriptor : collection) {
            getValueParametersHandler().appendBeforeValueParameter(valueParameterDescriptor, i, size, sb);
            m9877G(valueParameterDescriptor, z3, sb, false);
            getValueParametersHandler().appendAfterValueParameter(valueParameterDescriptor, i, size, sb);
            i++;
        }
        getValueParametersHandler().appendAfterValueParameters(size, sb);
    }

    /* renamed from: I */
    public final boolean m9879I(DescriptorVisibility2 descriptorVisibility2, StringBuilder sb) {
        if (!getModifiers().contains(DescriptorRenderer3.VISIBILITY)) {
            return false;
        }
        if (getNormalizedVisibilities()) {
            descriptorVisibility2 = descriptorVisibility2.normalize();
        }
        if (!getRenderDefaultVisibility() && Intrinsics3.areEqual(descriptorVisibility2, DescriptorVisibilities.f23093k)) {
            return false;
        }
        sb.append(m9895n(descriptorVisibility2.getInternalDisplayName()));
        sb.append(" ");
        return true;
    }

    /* renamed from: J */
    public final void m9880J(List<? extends TypeParameterDescriptor> list, StringBuilder sb) {
        if (getWithoutTypeParameters()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        for (TypeParameterDescriptor typeParameterDescriptor : list) {
            List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
            Intrinsics3.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
            for (KotlinType kotlinType : _Collections.drop(upperBounds, 1)) {
                StringBuilder sb2 = new StringBuilder();
                Name name = typeParameterDescriptor.getName();
                Intrinsics3.checkNotNullExpressionValue(name, "typeParameter.name");
                sb2.append(renderName(name, false));
                sb2.append(" : ");
                Intrinsics3.checkNotNullExpressionValue(kotlinType, "it");
                sb2.append(renderType(kotlinType));
                arrayList.add(sb2.toString());
            }
        }
        if (!arrayList.isEmpty()) {
            sb.append(" ");
            sb.append(m9895n("where"));
            sb.append(" ");
            _Collections.joinTo$default(arrayList, sb, ", ", null, null, 0, null, null, 124, null);
        }
    }

    /* renamed from: K */
    public final String m9881K(String str, String str2, String str3, String str4, String str5) {
        if (StringsJVM.startsWith$default(str, str2, false, 2, null) && StringsJVM.startsWith$default(str3, str4, false, 2, null)) {
            int length = str2.length();
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = str.substring(length);
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            int length2 = str4.length();
            Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
            String strSubstring2 = str3.substring(length2);
            Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            String strStringPlus = Intrinsics3.stringPlus(str5, strSubstring);
            if (Intrinsics3.areEqual(strSubstring, strSubstring2)) {
                return strStringPlus;
            }
            if (m9884b(strSubstring, strSubstring2)) {
                return Intrinsics3.stringPlus(strStringPlus, "!");
            }
        }
        return null;
    }

    /* renamed from: L */
    public final boolean m9882L(KotlinType kotlinType) {
        boolean z2;
        if (!functionTypes.isBuiltinFunctionalType(kotlinType)) {
            return false;
        }
        List<TypeProjection> arguments = kotlinType.getArguments();
        if ((arguments instanceof Collection) && arguments.isEmpty()) {
            z2 = true;
        } else {
            Iterator<T> it = arguments.iterator();
            while (it.hasNext()) {
                if (((TypeProjection) it.next()).isStarProjection()) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
        }
        return z2;
    }

    /* renamed from: a */
    public final void m9883a(StringBuilder sb, List<? extends TypeProjection> list) {
        _Collections.joinTo$default(list, sb, ", ", null, null, 0, null, new b(), 60, null);
    }

    /* renamed from: b */
    public final boolean m9884b(String str, String str2) {
        if (!Intrinsics3.areEqual(str, StringsJVM.replace$default(str2, "?", "", false, 4, (Object) null)) && (!StringsJVM.endsWith$default(str2, "?", false, 2, null) || !Intrinsics3.areEqual(Intrinsics3.stringPlus(str, "?"), str2))) {
            if (!Intrinsics3.areEqual('(' + str + ")?", str2)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public final String m9885c(String str) {
        return getTextFormat().escape(str);
    }

    /* renamed from: d */
    public final String m9886d() {
        return getTextFormat().escape(">");
    }

    /* renamed from: e */
    public final Modality m9887e(MemberDescriptor memberDescriptor) {
        ClassKind classKind = ClassKind.INTERFACE;
        if (memberDescriptor instanceof ClassDescriptor) {
            return ((ClassDescriptor) memberDescriptor).getKind() == classKind ? Modality.ABSTRACT : Modality.FINAL;
        }
        DeclarationDescriptor containingDeclaration = memberDescriptor.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor != null && (memberDescriptor instanceof CallableMemberDescriptor)) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) memberDescriptor;
            Intrinsics3.checkNotNullExpressionValue(callableMemberDescriptor.getOverriddenDescriptors(), "this.overriddenDescriptors");
            if ((!r2.isEmpty()) && classDescriptor.getModality() != Modality.FINAL) {
                return Modality.OPEN;
            }
            if (classDescriptor.getKind() != classKind || Intrinsics3.areEqual(callableMemberDescriptor.getVisibility(), DescriptorVisibilities.f23083a)) {
                return Modality.FINAL;
            }
            Modality modality = callableMemberDescriptor.getModality();
            Modality modality2 = Modality.ABSTRACT;
            return modality == modality2 ? modality2 : Modality.OPEN;
        }
        return Modality.FINAL;
    }

    /* renamed from: f */
    public final String m9888f() {
        return getTextFormat().escape("<");
    }

    /* renamed from: g */
    public final void m9889g(StringBuilder sb, SpecialTypes specialTypes) {
        DescriptorRenderer9 textFormat = getTextFormat();
        DescriptorRenderer9 descriptorRenderer9 = DescriptorRenderer9.f24330k;
        if (textFormat == descriptorRenderer9) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* = ");
        m9903v(sb, specialTypes.getExpandedType());
        sb.append(" */");
        if (getTextFormat() == descriptorRenderer9) {
            sb.append("</i></font>");
        }
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return this.f24239d.getActualPropertiesInPrimaryConstructor();
    }

    public boolean getAlwaysRenderModifiers() {
        return this.f24239d.getAlwaysRenderModifiers();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public DescriptorRenderer getAnnotationArgumentsRenderingPolicy() {
        return this.f24239d.getAnnotationArgumentsRenderingPolicy();
    }

    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return this.f24239d.getAnnotationFilter();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return this.f24239d.getBoldOnlyForNamesInHtml();
    }

    public boolean getClassWithPrimaryConstructor() {
        return this.f24239d.getClassWithPrimaryConstructor();
    }

    public ClassifierNamePolicy getClassifierNamePolicy() {
        return this.f24239d.getClassifierNamePolicy();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public boolean getDebugMode() {
        return this.f24239d.getDebugMode();
    }

    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return this.f24239d.getDefaultParameterValueRenderer();
    }

    public boolean getEachAnnotationOnNewLine() {
        return this.f24239d.getEachAnnotationOnNewLine();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public boolean getEnhancedTypes() {
        return this.f24239d.getEnhancedTypes();
    }

    public Set<FqName> getExcludedAnnotationClasses() {
        return this.f24239d.getExcludedAnnotationClasses();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return this.f24239d.getExcludedTypeAnnotationClasses();
    }

    public boolean getIncludeAdditionalModifiers() {
        return this.f24239d.getIncludeAdditionalModifiers();
    }

    public boolean getIncludeAnnotationArguments() {
        return this.f24239d.getIncludeAnnotationArguments();
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return this.f24239d.getIncludeEmptyAnnotationArguments();
    }

    public boolean getIncludePropertyConstant() {
        return this.f24239d.getIncludePropertyConstant();
    }

    public boolean getInformativeErrorType() {
        return this.f24239d.getInformativeErrorType();
    }

    public Set<DescriptorRenderer3> getModifiers() {
        return this.f24239d.getModifiers();
    }

    public boolean getNormalizedVisibilities() {
        return this.f24239d.getNormalizedVisibilities();
    }

    public final DescriptorRendererOptionsImpl getOptions() {
        return this.f24239d;
    }

    public DescriptorRenderer6 getOverrideRenderingPolicy() {
        return this.f24239d.getOverrideRenderingPolicy();
    }

    public DescriptorRenderer7 getParameterNameRenderingPolicy() {
        return this.f24239d.getParameterNameRenderingPolicy();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return this.f24239d.getParameterNamesInFunctionalTypes();
    }

    public boolean getPresentableUnresolvedTypes() {
        return this.f24239d.getPresentableUnresolvedTypes();
    }

    public DescriptorRenderer8 getPropertyAccessorRenderingPolicy() {
        return this.f24239d.getPropertyAccessorRenderingPolicy();
    }

    public boolean getReceiverAfterName() {
        return this.f24239d.getReceiverAfterName();
    }

    public boolean getRenderCompanionObjectName() {
        return this.f24239d.getRenderCompanionObjectName();
    }

    public boolean getRenderConstructorDelegation() {
        return this.f24239d.getRenderConstructorDelegation();
    }

    public boolean getRenderConstructorKeyword() {
        return this.f24239d.getRenderConstructorKeyword();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return this.f24239d.getRenderDefaultAnnotationArguments();
    }

    public boolean getRenderDefaultModality() {
        return this.f24239d.getRenderDefaultModality();
    }

    public boolean getRenderDefaultVisibility() {
        return this.f24239d.getRenderDefaultVisibility();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return this.f24239d.getRenderPrimaryConstructorParametersAsProperties();
    }

    public boolean getRenderTypeExpansions() {
        return this.f24239d.getRenderTypeExpansions();
    }

    public boolean getRenderUnabbreviatedType() {
        return this.f24239d.getRenderUnabbreviatedType();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return this.f24239d.getSecondaryConstructorsAsPrimary();
    }

    public boolean getStartFromDeclarationKeyword() {
        return this.f24239d.getStartFromDeclarationKeyword();
    }

    public boolean getStartFromName() {
        return this.f24239d.getStartFromName();
    }

    public DescriptorRenderer9 getTextFormat() {
        return this.f24239d.getTextFormat();
    }

    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return this.f24239d.getTypeNormalizer();
    }

    public boolean getUninferredTypeParameterAsName() {
        return this.f24239d.getUninferredTypeParameterAsName();
    }

    public boolean getUnitReturnType() {
        return this.f24239d.getUnitReturnType();
    }

    public DescriptorRenderer2.l getValueParametersHandler() {
        return this.f24239d.getValueParametersHandler();
    }

    public boolean getVerbose() {
        return this.f24239d.getVerbose();
    }

    public boolean getWithDefinedIn() {
        return this.f24239d.getWithDefinedIn();
    }

    public boolean getWithSourceFileForTopLevel() {
        return this.f24239d.getWithSourceFileForTopLevel();
    }

    public boolean getWithoutReturnType() {
        return this.f24239d.getWithoutReturnType();
    }

    public boolean getWithoutSuperTypes() {
        return this.f24239d.getWithoutSuperTypes();
    }

    public boolean getWithoutTypeParameters() {
        return this.f24239d.getWithoutTypeParameters();
    }

    /* renamed from: h */
    public final void m9890h(StringBuilder sb, Annotations3 annotations3, AnnotationUseSiteTarget annotationUseSiteTarget) {
        if (getModifiers().contains(DescriptorRenderer3.ANNOTATIONS)) {
            Set<FqName> excludedTypeAnnotationClasses = annotations3 instanceof KotlinType ? getExcludedTypeAnnotationClasses() : getExcludedAnnotationClasses();
            Function1<AnnotationDescriptor, Boolean> annotationFilter = getAnnotationFilter();
            for (AnnotationDescriptor annotationDescriptor : annotations3.getAnnotations()) {
                if (!_Collections.contains(excludedTypeAnnotationClasses, annotationDescriptor.getFqName()) && !Intrinsics3.areEqual(annotationDescriptor.getFqName(), StandardNames.a.f22570y) && (annotationFilter == null || annotationFilter.invoke(annotationDescriptor).booleanValue())) {
                    sb.append(renderAnnotation(annotationDescriptor, annotationUseSiteTarget));
                    if (getEachAnnotationOnNewLine()) {
                        sb.append('\n');
                        Intrinsics3.checkNotNullExpressionValue(sb, "append('\\n')");
                    } else {
                        sb.append(" ");
                    }
                }
            }
        }
    }

    /* renamed from: j */
    public final void m9891j(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, StringBuilder sb) {
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(declaredTypeParameters, "classifier.declaredTypeParameters");
        List<TypeParameterDescriptor> parameters = classifierDescriptorWithTypeParameters.getTypeConstructor().getParameters();
        Intrinsics3.checkNotNullExpressionValue(parameters, "classifier.typeConstructor.parameters");
        if (getVerbose() && classifierDescriptorWithTypeParameters.isInner() && parameters.size() > declaredTypeParameters.size()) {
            sb.append(" /*captured type parameters: ");
            m9874D(sb, parameters.subList(declaredTypeParameters.size(), parameters.size()));
            sb.append("*/");
        }
    }

    /* renamed from: k */
    public final String m9892k(AbstractC11815g<?> abstractC11815g) {
        if (abstractC11815g instanceof C11809b) {
            return _Collections.joinToString$default(((C11809b) abstractC11815g).getValue(), ", ", "{", "}", 0, null, new d(), 24, null);
        }
        if (abstractC11815g instanceof C11807a) {
            return Strings4.removePrefix(DescriptorRenderer2.renderAnnotation$default(this, ((C11807a) abstractC11815g).getValue(), null, 2, null), "@");
        }
        if (!(abstractC11815g instanceof C11826r)) {
            return abstractC11815g.toString();
        }
        C11826r.b value = ((C11826r) abstractC11815g).getValue();
        if (value instanceof C11826r.b.a) {
            return ((C11826r.b.a) value).getType() + "::class";
        }
        if (!(value instanceof C11826r.b.C13329b)) {
            throw new NoWhenBranchMatchedException();
        }
        C11826r.b.C13329b c13329b = (C11826r.b.C13329b) value;
        String strAsString = c13329b.getClassId().asSingleFqName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "classValue.classId.asSingleFqName().asString()");
        for (int i = 0; i < c13329b.getArrayDimensions(); i++) {
            strAsString = "kotlin.Array<" + strAsString + '>';
        }
        return Intrinsics3.stringPlus(strAsString, "::class");
    }

    /* renamed from: l */
    public final void m9893l(StringBuilder sb, KotlinType kotlinType) {
        m9890h(sb, kotlinType, null);
        if (KotlinType2.isError(kotlinType)) {
            if ((kotlinType instanceof ErrorType) && getPresentableUnresolvedTypes()) {
                sb.append(((ErrorType) kotlinType).getPresentableName());
            } else if (!(kotlinType instanceof ErrorType2) || getInformativeErrorType()) {
                sb.append(kotlinType.getConstructor().toString());
            } else {
                sb.append(((ErrorType2) kotlinType).getPresentableName());
            }
            sb.append(renderTypeArguments(kotlinType.getArguments()));
        } else {
            TypeConstructor constructor = kotlinType.getConstructor();
            typeParameterUtils3 typeparameterutils3BuildPossiblyInnerType = typeParameterUtils.buildPossiblyInnerType(kotlinType);
            if (typeparameterutils3BuildPossiblyInnerType == null) {
                sb.append(renderTypeConstructor(constructor));
                sb.append(renderTypeArguments(kotlinType.getArguments()));
            } else {
                m9906y(sb, typeparameterutils3BuildPossiblyInnerType);
            }
        }
        if (kotlinType.isMarkedNullable()) {
            sb.append("?");
        }
        if (SpecialTypes5.isDefinitelyNotNullType(kotlinType)) {
            sb.append("!!");
        }
    }

    /* renamed from: m */
    public final void m9894m(VariableDescriptor variableDescriptor, StringBuilder sb) {
        AbstractC11815g<?> compileTimeInitializer;
        if (!getIncludePropertyConstant() || (compileTimeInitializer = variableDescriptor.getCompileTimeInitializer()) == null) {
            return;
        }
        sb.append(" = ");
        sb.append(m9885c(m9892k(compileTimeInitializer)));
    }

    /* renamed from: n */
    public final String m9895n(String str) {
        int iOrdinal = getTextFormat().ordinal();
        if (iOrdinal == 0) {
            return str;
        }
        if (iOrdinal == 1) {
            return getBoldOnlyForNamesInHtml() ? str : outline.m886y("<b>", str, "</b>");
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: o */
    public final void m9896o(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (getModifiers().contains(DescriptorRenderer3.MEMBER_KIND) && getVerbose() && callableMemberDescriptor.getKind() != CallableMemberDescriptor.a.DECLARATION) {
            sb.append("/*");
            String strName = callableMemberDescriptor.getKind().name();
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strName.toLowerCase();
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            sb.append(lowerCase);
            sb.append("*/ ");
        }
    }

    /* renamed from: p */
    public final void m9897p(MemberDescriptor memberDescriptor, StringBuilder sb) {
        m9900s(sb, memberDescriptor.isExternal(), "external");
        boolean z2 = false;
        m9900s(sb, getModifiers().contains(DescriptorRenderer3.EXPECT) && memberDescriptor.isExpect(), "expect");
        if (getModifiers().contains(DescriptorRenderer3.ACTUAL) && memberDescriptor.isActual()) {
            z2 = true;
        }
        m9900s(sb, z2, "actual");
    }

    /* renamed from: q */
    public final void m9898q(Modality modality, StringBuilder sb, Modality modality2) {
        if (getRenderDefaultModality() || modality != modality2) {
            boolean zContains = getModifiers().contains(DescriptorRenderer3.MODALITY);
            String strName = modality.name();
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strName.toLowerCase();
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            m9900s(sb, zContains, lowerCase);
        }
    }

    /* renamed from: r */
    public final void m9899r(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (DescriptorUtils.isTopLevelDeclaration(callableMemberDescriptor) && callableMemberDescriptor.getModality() == Modality.FINAL) {
            return;
        }
        if (getOverrideRenderingPolicy() == DescriptorRenderer6.RENDER_OVERRIDE && callableMemberDescriptor.getModality() == Modality.OPEN && (!callableMemberDescriptor.getOverriddenDescriptors().isEmpty())) {
            return;
        }
        Modality modality = callableMemberDescriptor.getModality();
        Intrinsics3.checkNotNullExpressionValue(modality, "callable.modality");
        m9898q(modality, sb, m9887e(callableMemberDescriptor));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2
    public String render(DeclarationDescriptor declarationDescriptor) {
        String name;
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb = new StringBuilder();
        declarationDescriptor.accept(new a(this), sb);
        if (getWithDefinedIn() && !(declarationDescriptor instanceof PackageFragmentDescriptor) && !(declarationDescriptor instanceof PackageViewDescriptor)) {
            if (declarationDescriptor instanceof ModuleDescriptor2) {
                sb.append(" is a module");
            } else {
                DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
                if (containingDeclaration != null && !(containingDeclaration instanceof ModuleDescriptor2)) {
                    sb.append(" ");
                    sb.append(renderMessage("defined in"));
                    sb.append(" ");
                    FqNameUnsafe fqName = DescriptorUtils.getFqName(containingDeclaration);
                    Intrinsics3.checkNotNullExpressionValue(fqName, "getFqName(containingDeclaration)");
                    sb.append(fqName.isRoot() ? "root package" : renderFqName(fqName));
                    if (getWithSourceFileForTopLevel() && (containingDeclaration instanceof PackageFragmentDescriptor) && (declarationDescriptor instanceof DeclarationDescriptorWithSource) && (name = ((InterfaceC11469v0.a) ((DeclarationDescriptorWithSource) declarationDescriptor).getSource().getContainingFile()).getName()) != null) {
                        sb.append(" ");
                        sb.append(renderMessage("in file"));
                        sb.append(" ");
                        sb.append(name);
                    }
                }
            }
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2
    public String renderAnnotation(AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget) {
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotation");
        StringBuilder sb = new StringBuilder();
        sb.append(MentionUtils.MENTIONS_CHAR);
        if (annotationUseSiteTarget != null) {
            sb.append(Intrinsics3.stringPlus(annotationUseSiteTarget.getRenderName(), ":"));
        }
        KotlinType type = annotationDescriptor.getType();
        sb.append(renderType(type));
        if (getIncludeAnnotationArguments()) {
            Map<Name, AbstractC11815g<?>> allValueArguments = annotationDescriptor.getAllValueArguments();
            List listEmptyList = null;
            ClassDescriptor annotationClass = getRenderDefaultAnnotationArguments() ? DescriptorUtils2.getAnnotationClass(annotationDescriptor) : null;
            List<ValueParameterDescriptor> valueParameters = (annotationClass == null || (unsubstitutedPrimaryConstructor = annotationClass.getUnsubstitutedPrimaryConstructor()) == null) ? null : unsubstitutedPrimaryConstructor.getValueParameters();
            if (valueParameters != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : valueParameters) {
                    if (((ValueParameterDescriptor) obj).declaresDefaultValue()) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((ValueParameterDescriptor) it.next()).getName());
                }
                listEmptyList = arrayList2;
            }
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : listEmptyList) {
                Intrinsics3.checkNotNullExpressionValue((Name) obj2, "it");
                if (!allValueArguments.containsKey(r6)) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(Intrinsics3.stringPlus(((Name) it2.next()).asString(), " = ..."));
            }
            Set<Map.Entry<Name, AbstractC11815g<?>>> setEntrySet = allValueArguments.entrySet();
            ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(setEntrySet, 10));
            Iterator<T> it3 = setEntrySet.iterator();
            while (it3.hasNext()) {
                Map.Entry entry = (Map.Entry) it3.next();
                Name name = (Name) entry.getKey();
                AbstractC11815g<?> abstractC11815g = (AbstractC11815g) entry.getValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(name.asString());
                sb2.append(" = ");
                sb2.append(!listEmptyList.contains(name) ? m9892k(abstractC11815g) : "...");
                arrayList5.add(sb2.toString());
            }
            List listSorted = _Collections.sorted(_Collections.plus((Collection) arrayList4, (Iterable) arrayList5));
            if (getIncludeEmptyAnnotationArguments() || (!listSorted.isEmpty())) {
                _Collections.joinTo$default(listSorted, sb, ", ", "(", ")", 0, null, null, 112, null);
            }
        }
        if (getVerbose() && (KotlinType2.isError(type) || (type.getConstructor().getDeclarationDescriptor() instanceof NotFoundClasses.b))) {
            sb.append(" /* annotation class not found */");
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public String renderClassifierName(ClassifierDescriptor classifierDescriptor) {
        Intrinsics3.checkNotNullParameter(classifierDescriptor, "klass");
        return ErrorUtils.isError(classifierDescriptor) ? classifierDescriptor.getTypeConstructor().toString() : getClassifierNamePolicy().renderClassifier(classifierDescriptor, this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2
    public String renderFlexibleType(String str, String str2, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics3.checkNotNullParameter(str, "lowerRendered");
        Intrinsics3.checkNotNullParameter(str2, "upperRendered");
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        if (m9884b(str, str2)) {
            if (!StringsJVM.startsWith$default(str2, "(", false, 2, null)) {
                return Intrinsics3.stringPlus(str, "!");
            }
            return '(' + str + ")!";
        }
        ClassifierNamePolicy classifierNamePolicy = getClassifierNamePolicy();
        ClassDescriptor collection = kotlinBuiltIns.getCollection();
        Intrinsics3.checkNotNullExpressionValue(collection, "builtIns.collection");
        String strSubstringBefore$default = Strings4.substringBefore$default(classifierNamePolicy.renderClassifier(collection, this), "Collection", (String) null, 2, (Object) null);
        String strM9881K = m9881K(str, Intrinsics3.stringPlus(strSubstringBefore$default, "Mutable"), str2, strSubstringBefore$default, strSubstringBefore$default + "(Mutable)");
        if (strM9881K != null) {
            return strM9881K;
        }
        String strM9881K2 = m9881K(str, Intrinsics3.stringPlus(strSubstringBefore$default, "MutableMap.MutableEntry"), str2, Intrinsics3.stringPlus(strSubstringBefore$default, "Map.Entry"), Intrinsics3.stringPlus(strSubstringBefore$default, "(Mutable)Map.(Mutable)Entry"));
        if (strM9881K2 != null) {
            return strM9881K2;
        }
        ClassifierNamePolicy classifierNamePolicy2 = getClassifierNamePolicy();
        ClassDescriptor array = kotlinBuiltIns.getArray();
        Intrinsics3.checkNotNullExpressionValue(array, "builtIns.array");
        String strSubstringBefore$default2 = Strings4.substringBefore$default(classifierNamePolicy2.renderClassifier(array, this), "Array", (String) null, 2, (Object) null);
        String strM9881K3 = m9881K(str, Intrinsics3.stringPlus(strSubstringBefore$default2, getTextFormat().escape("Array<")), str2, Intrinsics3.stringPlus(strSubstringBefore$default2, getTextFormat().escape("Array<out ")), Intrinsics3.stringPlus(strSubstringBefore$default2, getTextFormat().escape("Array<(out) ")));
        if (strM9881K3 != null) {
            return strM9881K3;
        }
        return '(' + str + ".." + str2 + ')';
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2
    public String renderFqName(FqNameUnsafe fqNameUnsafe) {
        Intrinsics3.checkNotNullParameter(fqNameUnsafe, "fqName");
        List<Name> listPathSegments = fqNameUnsafe.pathSegments();
        Intrinsics3.checkNotNullExpressionValue(listPathSegments, "fqName.pathSegments()");
        return m9885c(RenderingUtils.renderFqName(listPathSegments));
    }

    public String renderMessage(String str) {
        Intrinsics3.checkNotNullParameter(str, "message");
        int iOrdinal = getTextFormat().ordinal();
        if (iOrdinal == 0) {
            return str;
        }
        if (iOrdinal == 1) {
            return outline.m886y("<i>", str, "</i>");
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2
    public String renderName(Name name, boolean z2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strM9885c = m9885c(RenderingUtils.render(name));
        return (getBoldOnlyForNamesInHtml() && getTextFormat() == DescriptorRenderer9.f24330k && z2) ? outline.m886y("<b>", strM9885c, "</b>") : strM9885c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2
    public String renderType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        StringBuilder sb = new StringBuilder();
        m9902u(sb, getTypeNormalizer().invoke(kotlinType));
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public String renderTypeArguments(List<? extends TypeProjection> list) {
        Intrinsics3.checkNotNullParameter(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m9888f());
        m9883a(sb, list);
        sb.append(m9886d());
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public String renderTypeConstructor(TypeConstructor typeConstructor) {
        Intrinsics3.checkNotNullParameter(typeConstructor, "typeConstructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor ? true : declarationDescriptor instanceof ClassDescriptor ? true : declarationDescriptor instanceof TypeAliasDescriptor) {
            return renderClassifierName(declarationDescriptor);
        }
        if (declarationDescriptor == null) {
            return typeConstructor.toString();
        }
        throw new IllegalStateException(Intrinsics3.stringPlus("Unexpected classifier: ", declarationDescriptor.getClass()).toString());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2
    public String renderTypeProjection(TypeProjection typeProjection) {
        Intrinsics3.checkNotNullParameter(typeProjection, "typeProjection");
        StringBuilder sb = new StringBuilder();
        m9883a(sb, CollectionsJVM.listOf(typeProjection));
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* renamed from: s */
    public final void m9900s(StringBuilder sb, boolean z2, String str) {
        if (z2) {
            sb.append(m9895n(str));
            sb.append(" ");
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setAnnotationArgumentsRenderingPolicy(DescriptorRenderer descriptorRenderer) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer, "<set-?>");
        this.f24239d.setAnnotationArgumentsRenderingPolicy(descriptorRenderer);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setClassifierNamePolicy(ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics3.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.f24239d.setClassifierNamePolicy(classifierNamePolicy);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setDebugMode(boolean z2) {
        this.f24239d.setDebugMode(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setExcludedTypeAnnotationClasses(Set<FqName> set) {
        Intrinsics3.checkNotNullParameter(set, "<set-?>");
        this.f24239d.setExcludedTypeAnnotationClasses(set);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setModifiers(Set<? extends DescriptorRenderer3> set) {
        Intrinsics3.checkNotNullParameter(set, "<set-?>");
        this.f24239d.setModifiers(set);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setParameterNameRenderingPolicy(DescriptorRenderer7 descriptorRenderer7) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer7, "<set-?>");
        this.f24239d.setParameterNameRenderingPolicy(descriptorRenderer7);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setReceiverAfterName(boolean z2) {
        this.f24239d.setReceiverAfterName(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setRenderCompanionObjectName(boolean z2) {
        this.f24239d.setRenderCompanionObjectName(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setStartFromName(boolean z2) {
        this.f24239d.setStartFromName(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setTextFormat(DescriptorRenderer9 descriptorRenderer9) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer9, "<set-?>");
        this.f24239d.setTextFormat(descriptorRenderer9);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setWithDefinedIn(boolean z2) {
        this.f24239d.setWithDefinedIn(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setWithoutSuperTypes(boolean z2) {
        this.f24239d.setWithoutSuperTypes(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setWithoutTypeParameters(boolean z2) {
        this.f24239d.setWithoutTypeParameters(z2);
    }

    /* renamed from: t */
    public final void m9901t(DeclarationDescriptor declarationDescriptor, StringBuilder sb, boolean z2) {
        Name name = declarationDescriptor.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(renderName(name, z2));
    }

    /* renamed from: u */
    public final void m9902u(StringBuilder sb, KotlinType kotlinType) {
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        SpecialTypes specialTypes = kotlinType3Unwrap instanceof SpecialTypes ? (SpecialTypes) kotlinType3Unwrap : null;
        if (specialTypes == null) {
            m9903v(sb, kotlinType);
            return;
        }
        if (getRenderTypeExpansions()) {
            m9903v(sb, specialTypes.getExpandedType());
            return;
        }
        m9903v(sb, specialTypes.getAbbreviation());
        if (getRenderUnabbreviatedType()) {
            m9889g(sb, specialTypes);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0124  */
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m9903v(StringBuilder sb, KotlinType kotlinType) {
        String strEscape;
        Name nameExtractParameterNameFromFunctionTypeArgument;
        if ((kotlinType instanceof KotlinType5) && getDebugMode() && !((KotlinType5) kotlinType).isComputed()) {
            sb.append("<Not computed yet>");
            return;
        }
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        if (kotlinType3Unwrap instanceof KotlinType6) {
            sb.append(((KotlinType6) kotlinType3Unwrap).render(this, this));
            return;
        }
        if (kotlinType3Unwrap instanceof KotlinType4) {
            KotlinType4 kotlinType4 = (KotlinType4) kotlinType3Unwrap;
            if (Intrinsics3.areEqual(kotlinType4, TypeUtils.f24754b) || TypeUtils.isDontCarePlaceholder(kotlinType4)) {
                sb.append("???");
                return;
            }
            if (ErrorUtils.isUninferredParameter(kotlinType4)) {
                if (!getUninferredTypeParameterAsName()) {
                    sb.append("???");
                    return;
                }
                String string = ((ErrorUtils.f) kotlinType4.getConstructor()).getTypeParameterDescriptor().getName().toString();
                Intrinsics3.checkNotNullExpressionValue(string, "type.constructor as UninferredParameterTypeConstructor).typeParameterDescriptor.name.toString()");
                int iOrdinal = getTextFormat().ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    string = outline.m886y("<font color=red><b>", string, "</b></font>");
                }
                sb.append(string);
                return;
            }
            if (KotlinType2.isError(kotlinType4)) {
                m9893l(sb, kotlinType4);
                return;
            }
            if (!m9882L(kotlinType4)) {
                m9893l(sb, kotlinType4);
                return;
            }
            int length = sb.length();
            m9870i((DescriptorRendererImpl) this.f24240e.getValue(), sb, kotlinType4, null, 2);
            boolean z2 = sb.length() != length;
            boolean zIsSuspendFunctionType = functionTypes.isSuspendFunctionType(kotlinType4);
            boolean zIsMarkedNullable = kotlinType4.isMarkedNullable();
            KotlinType receiverTypeFromFunctionType = functionTypes.getReceiverTypeFromFunctionType(kotlinType4);
            boolean z3 = zIsMarkedNullable || (z2 && receiverTypeFromFunctionType != null);
            if (z3) {
                if (zIsSuspendFunctionType) {
                    sb.insert(length, '(');
                } else {
                    if (z2) {
                        _Strings.last(sb);
                        if (sb.charAt(Strings4.getLastIndex(sb) - 1) != ')') {
                            sb.insert(Strings4.getLastIndex(sb), "()");
                        }
                    }
                    sb.append("(");
                }
            }
            m9900s(sb, zIsSuspendFunctionType, "suspend");
            if (receiverTypeFromFunctionType != null) {
                if (!m9882L(receiverTypeFromFunctionType) || receiverTypeFromFunctionType.isMarkedNullable()) {
                    boolean z4 = functionTypes.isSuspendFunctionType(receiverTypeFromFunctionType) || !receiverTypeFromFunctionType.getAnnotations().isEmpty();
                    if (z4) {
                        sb.append("(");
                    }
                    m9902u(sb, receiverTypeFromFunctionType);
                    if (z4) {
                        sb.append(")");
                    }
                    sb.append(".");
                }
            }
            sb.append("(");
            int i = 0;
            for (TypeProjection typeProjection : functionTypes.getValueParameterTypesFromFunctionType(kotlinType4)) {
                int i2 = i + 1;
                if (i > 0) {
                    sb.append(", ");
                }
                if (getParameterNamesInFunctionalTypes()) {
                    KotlinType type = typeProjection.getType();
                    Intrinsics3.checkNotNullExpressionValue(type, "typeProjection.type");
                    nameExtractParameterNameFromFunctionTypeArgument = functionTypes.extractParameterNameFromFunctionTypeArgument(type);
                } else {
                    nameExtractParameterNameFromFunctionTypeArgument = null;
                }
                if (nameExtractParameterNameFromFunctionTypeArgument != null) {
                    sb.append(renderName(nameExtractParameterNameFromFunctionTypeArgument, false));
                    sb.append(": ");
                }
                sb.append(renderTypeProjection(typeProjection));
                i = i2;
            }
            sb.append(") ");
            int iOrdinal2 = getTextFormat().ordinal();
            if (iOrdinal2 == 0) {
                strEscape = getTextFormat().escape("->");
            } else {
                if (iOrdinal2 != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                strEscape = "&rarr;";
            }
            sb.append(strEscape);
            sb.append(" ");
            m9902u(sb, functionTypes.getReturnTypeFromFunctionType(kotlinType4));
            if (z3) {
                sb.append(")");
            }
            if (zIsMarkedNullable) {
                sb.append("?");
            }
        }
    }

    /* renamed from: w */
    public final void m9904w(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (getModifiers().contains(DescriptorRenderer3.OVERRIDE) && (!callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) && getOverrideRenderingPolicy() != DescriptorRenderer6.RENDER_OPEN) {
            m9900s(sb, true, "override");
            if (getVerbose()) {
                sb.append("/*");
                sb.append(callableMemberDescriptor.getOverriddenDescriptors().size());
                sb.append("*/ ");
            }
        }
    }

    /* renamed from: x */
    public final void m9905x(FqName fqName, String str, StringBuilder sb) {
        sb.append(m9895n(str));
        FqNameUnsafe unsafe = fqName.toUnsafe();
        Intrinsics3.checkNotNullExpressionValue(unsafe, "fqName.toUnsafe()");
        String strRenderFqName = renderFqName(unsafe);
        if (strRenderFqName.length() > 0) {
            sb.append(" ");
            sb.append(strRenderFqName);
        }
    }

    /* renamed from: y */
    public final void m9906y(StringBuilder sb, typeParameterUtils3 typeparameterutils3) {
        StringBuilder sb2;
        typeParameterUtils3 outerType = typeparameterutils3.getOuterType();
        if (outerType == null) {
            sb2 = null;
        } else {
            m9906y(sb, outerType);
            sb.append('.');
            Name name = typeparameterutils3.getClassifierDescriptor().getName();
            Intrinsics3.checkNotNullExpressionValue(name, "possiblyInnerType.classifierDescriptor.name");
            sb.append(renderName(name, false));
            sb2 = sb;
        }
        if (sb2 == null) {
            TypeConstructor typeConstructor = typeparameterutils3.getClassifierDescriptor().getTypeConstructor();
            Intrinsics3.checkNotNullExpressionValue(typeConstructor, "possiblyInnerType.classifierDescriptor.typeConstructor");
            sb.append(renderTypeConstructor(typeConstructor));
        }
        sb.append(renderTypeArguments(typeparameterutils3.getArguments()));
    }

    /* renamed from: z */
    public final void m9907z(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            m9890h(sb, extensionReceiverParameter, AnnotationUseSiteTarget.RECEIVER);
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "receiver.type");
            String strRenderType = renderType(type);
            if (m9882L(type) && !TypeUtils.isNullableType(type)) {
                strRenderType = '(' + strRenderType + ')';
            }
            sb.append(strRenderType);
            sb.append(".");
        }
    }
}
