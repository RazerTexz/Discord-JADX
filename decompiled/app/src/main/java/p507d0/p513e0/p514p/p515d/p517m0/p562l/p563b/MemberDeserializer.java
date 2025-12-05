package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KDeclarationContainer;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.functionTypes;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FieldDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.PropertyGetterDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.PropertySetterDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ValueParameterDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11677b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11679d;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11693r;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11696u;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11697v;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.EnumC11686k;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.EnumC11699x;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.Flags2;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement2;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.protoTypeTableUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ProtoContainer;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedAnnotations;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedAnnotations2;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor4;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor5;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor6;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p582u._ComparisonsJvm;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: MemberDeserializer.kt */
/* renamed from: d0.e0.p.d.m0.l.b.u, reason: use source file name */
/* loaded from: classes3.dex */
public final class MemberDeserializer {

    /* renamed from: a */
    public final context6 f24683a;

    /* renamed from: b */
    public final AnnotationDeserializer f24684b;

    /* compiled from: MemberDeserializer.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.u$a */
    public /* synthetic */ class a extends PropertyReference1 {

        /* renamed from: j */
        public static final a f24685j = new a();

        @Override // p507d0.p513e0.KProperty3
        public Object get(Object obj) {
            return Boolean.valueOf(functionTypes.isSuspendFunctionType((KotlinType) obj));
        }

        @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return "isSuspendFunctionType";
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinPackage(functionTypes.class, "deserialization");
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public String getSignature() {
            return "isSuspendFunctionType(Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }
    }

    /* compiled from: MemberDeserializer.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.u$b */
    public static final class b extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
        public final /* synthetic */ AnnotatedCallableKind $kind;
        public final /* synthetic */ MessageLite $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
            super(0);
            this.$proto = messageLite;
            this.$kind = annotatedCallableKind;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends AnnotationDescriptor> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends AnnotationDescriptor> invoke2() {
            List<? extends AnnotationDescriptor> list;
            MemberDeserializer memberDeserializer = MemberDeserializer.this;
            ProtoContainer protoContainerAccess$asProtoContainer = MemberDeserializer.access$asProtoContainer(memberDeserializer, MemberDeserializer.access$getC$p(memberDeserializer).getContainingDeclaration());
            if (protoContainerAccess$asProtoContainer == null) {
                list = null;
            } else {
                list = _Collections.toList(MemberDeserializer.access$getC$p(MemberDeserializer.this).getComponents().getAnnotationAndConstantLoader().loadCallableAnnotations(protoContainerAccess$asProtoContainer, this.$proto, this.$kind));
            }
            return list != null ? list : Collections2.emptyList();
        }
    }

    /* compiled from: MemberDeserializer.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.u$c */
    public static final class c extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
        public final /* synthetic */ boolean $isDelegate;
        public final /* synthetic */ C11689n $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z2, C11689n c11689n) {
            super(0);
            this.$isDelegate = z2;
            this.$proto = c11689n;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends AnnotationDescriptor> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends AnnotationDescriptor> invoke2() {
            List<? extends AnnotationDescriptor> list;
            MemberDeserializer memberDeserializer = MemberDeserializer.this;
            ProtoContainer protoContainerAccess$asProtoContainer = MemberDeserializer.access$asProtoContainer(memberDeserializer, MemberDeserializer.access$getC$p(memberDeserializer).getContainingDeclaration());
            if (protoContainerAccess$asProtoContainer == null) {
                list = null;
            } else {
                boolean z2 = this.$isDelegate;
                MemberDeserializer memberDeserializer2 = MemberDeserializer.this;
                C11689n c11689n = this.$proto;
                list = z2 ? _Collections.toList(MemberDeserializer.access$getC$p(memberDeserializer2).getComponents().getAnnotationAndConstantLoader().loadPropertyDelegateFieldAnnotations(protoContainerAccess$asProtoContainer, c11689n)) : _Collections.toList(MemberDeserializer.access$getC$p(memberDeserializer2).getComponents().getAnnotationAndConstantLoader().loadPropertyBackingFieldAnnotations(protoContainerAccess$asProtoContainer, c11689n));
            }
            return list != null ? list : Collections2.emptyList();
        }
    }

    /* compiled from: MemberDeserializer.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.u$d */
    public static final class d extends Lambda implements Function0<AbstractC11815g<?>> {
        public final /* synthetic */ DeserializedMemberDescriptor4 $property;
        public final /* synthetic */ C11689n $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(C11689n c11689n, DeserializedMemberDescriptor4 deserializedMemberDescriptor4) {
            super(0);
            this.$proto = c11689n;
            this.$property = deserializedMemberDescriptor4;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ AbstractC11815g<?> invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AbstractC11815g<?> invoke() {
            MemberDeserializer memberDeserializer = MemberDeserializer.this;
            ProtoContainer protoContainerAccess$asProtoContainer = MemberDeserializer.access$asProtoContainer(memberDeserializer, MemberDeserializer.access$getC$p(memberDeserializer).getContainingDeclaration());
            Intrinsics3.checkNotNull(protoContainerAccess$asProtoContainer);
            AnnotationAndConstantLoader<AnnotationDescriptor, AbstractC11815g<?>> annotationAndConstantLoader = MemberDeserializer.access$getC$p(MemberDeserializer.this).getComponents().getAnnotationAndConstantLoader();
            C11689n c11689n = this.$proto;
            KotlinType returnType = this.$property.getReturnType();
            Intrinsics3.checkNotNullExpressionValue(returnType, "property.returnType");
            return annotationAndConstantLoader.loadPropertyConstant(protoContainerAccess$asProtoContainer, c11689n, returnType);
        }
    }

    /* compiled from: MemberDeserializer.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.u$e */
    public static final class e extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
        public final /* synthetic */ MessageLite $callable;
        public final /* synthetic */ ProtoContainer $containerOfCallable;

        /* renamed from: $i */
        public final /* synthetic */ int f24686$i;
        public final /* synthetic */ AnnotatedCallableKind $kind;
        public final /* synthetic */ C11696u $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, C11696u c11696u) {
            super(0);
            this.$containerOfCallable = protoContainer;
            this.$callable = messageLite;
            this.$kind = annotatedCallableKind;
            this.f24686$i = i;
            this.$proto = c11696u;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends AnnotationDescriptor> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends AnnotationDescriptor> invoke2() {
            return _Collections.toList(MemberDeserializer.access$getC$p(MemberDeserializer.this).getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations(this.$containerOfCallable, this.$callable, this.$kind, this.f24686$i, this.$proto));
        }
    }

    public MemberDeserializer(context6 context6Var) {
        Intrinsics3.checkNotNullParameter(context6Var, "c");
        this.f24683a = context6Var;
        this.f24684b = new AnnotationDeserializer(context6Var.getComponents().getModuleDescriptor(), context6Var.getComponents().getNotFoundClasses());
    }

    public static final /* synthetic */ ProtoContainer access$asProtoContainer(MemberDeserializer memberDeserializer, DeclarationDescriptor declarationDescriptor) {
        return memberDeserializer.m9968a(declarationDescriptor);
    }

    public static final /* synthetic */ context6 access$getC$p(MemberDeserializer memberDeserializer) {
        return memberDeserializer.f24683a;
    }

    /* renamed from: a */
    public final ProtoContainer m9968a(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            return new ProtoContainer.b(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), this.f24683a.getNameResolver(), this.f24683a.getTypeTable(), this.f24683a.getContainerSource());
        }
        if (declarationDescriptor instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) declarationDescriptor).getThisAsProtoContainer$deserialization();
        }
        return null;
    }

    /* renamed from: b */
    public final DeserializedMemberDescriptor3.a m9969b(DeserializedMemberDescriptor3 deserializedMemberDescriptor3, TypeDeserializer typeDeserializer) {
        DeserializedMemberDescriptor3.a aVar = DeserializedMemberDescriptor3.a.COMPATIBLE;
        if (!m9976i(deserializedMemberDescriptor3)) {
            return aVar;
        }
        Iterator<T> it = typeDeserializer.getOwnTypeParameters().iterator();
        while (it.hasNext()) {
            ((TypeParameterDescriptor) it.next()).getUpperBounds();
        }
        return typeDeserializer.getExperimentalSuspendFunctionTypeEncountered() ? DeserializedMemberDescriptor3.a.INCOMPATIBLE : aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[LOOP:3: B:29:0x0073->B:95:?, LOOP_END, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DeserializedMemberDescriptor3.a m9970c(DeserializedMemberDescriptor deserializedMemberDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor, Collection<? extends ValueParameterDescriptor> collection, Collection<? extends TypeParameterDescriptor> collection2, KotlinType kotlinType, boolean z2) {
        boolean z3;
        boolean z4;
        DeserializedMemberDescriptor3.a aVar;
        boolean z5;
        DeserializedMemberDescriptor3.a aVar2 = DeserializedMemberDescriptor3.a.NEEDS_WRAPPER;
        DeserializedMemberDescriptor3.a aVar3 = DeserializedMemberDescriptor3.a.INCOMPATIBLE;
        DeserializedMemberDescriptor3.a aVar4 = DeserializedMemberDescriptor3.a.COMPATIBLE;
        if (!m9976i(deserializedMemberDescriptor) || Intrinsics3.areEqual(DescriptorUtils2.fqNameOrNull(deserializedMemberDescriptor), suspendFunctionTypeUtil.f24502a)) {
            return aVar4;
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((ValueParameterDescriptor) it.next()).getType());
        }
        List<KotlinType> listPlus = _Collections.plus((Collection) arrayList, (Iterable) Collections2.listOfNotNull(receiverParameterDescriptor == null ? null : receiverParameterDescriptor.getType()));
        if (Intrinsics3.areEqual(kotlinType != null ? Boolean.valueOf(m9971d(kotlinType)) : null, Boolean.TRUE)) {
            return aVar3;
        }
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            z4 = false;
        } else {
            Iterator<T> it2 = collection2.iterator();
            while (it2.hasNext()) {
                List<KotlinType> upperBounds = ((TypeParameterDescriptor) it2.next()).getUpperBounds();
                Intrinsics3.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
                if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                    for (KotlinType kotlinType2 : upperBounds) {
                        Intrinsics3.checkNotNullExpressionValue(kotlinType2, "it");
                        if (m9971d(kotlinType2)) {
                            z3 = true;
                            break;
                        }
                    }
                    z3 = false;
                    if (!z3) {
                        z4 = true;
                        break;
                    }
                } else {
                    z3 = false;
                    if (!z3) {
                    }
                }
            }
            z4 = false;
        }
        if (z4) {
            return aVar3;
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listPlus, 10));
        for (KotlinType kotlinType3 : listPlus) {
            Intrinsics3.checkNotNullExpressionValue(kotlinType3, "type");
            if (!functionTypes.isSuspendFunctionType(kotlinType3) || kotlinType3.getArguments().size() > 3) {
                aVar = m9971d(kotlinType3) ? aVar3 : aVar4;
            } else {
                List<TypeProjection> arguments = kotlinType3.getArguments();
                if ((arguments instanceof Collection) && arguments.isEmpty()) {
                    z5 = false;
                    if (z5) {
                    }
                } else {
                    Iterator<T> it3 = arguments.iterator();
                    while (it3.hasNext()) {
                        KotlinType type = ((TypeProjection) it3.next()).getType();
                        Intrinsics3.checkNotNullExpressionValue(type, "it.type");
                        if (m9971d(type)) {
                            z5 = true;
                            break;
                        }
                    }
                    z5 = false;
                    if (z5) {
                        aVar = aVar2;
                    }
                }
            }
            arrayList2.add(aVar);
        }
        DeserializedMemberDescriptor3.a aVar5 = (DeserializedMemberDescriptor3.a) _Collections.maxOrNull((Iterable) arrayList2);
        if (aVar5 == null) {
            aVar5 = aVar4;
        }
        if (!z2) {
            aVar2 = aVar4;
        }
        return (DeserializedMemberDescriptor3.a) _ComparisonsJvm.maxOf(aVar2, aVar5);
    }

    /* renamed from: d */
    public final boolean m9971d(KotlinType kotlinType) {
        return TypeUtils2.contains(kotlinType, a.f24685j);
    }

    /* renamed from: e */
    public final Annotations4 m9972e(MessageLite messageLite, int i, AnnotatedCallableKind annotatedCallableKind) {
        return !Flags2.f24031b.get(i).booleanValue() ? Annotations4.f22735f.getEMPTY() : new DeserializedAnnotations2(this.f24683a.getStorageManager(), new b(messageLite, annotatedCallableKind));
    }

    /* renamed from: f */
    public final ReceiverParameterDescriptor m9973f() {
        DeclarationDescriptor containingDeclaration = this.f24683a.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null) {
            return null;
        }
        return classDescriptor.getThisAsReceiverParameter();
    }

    /* renamed from: g */
    public final Annotations4 m9974g(C11689n c11689n, boolean z2) {
        return !Flags2.f24031b.get(c11689n.getFlags()).booleanValue() ? Annotations4.f22735f.getEMPTY() : new DeserializedAnnotations2(this.f24683a.getStorageManager(), new c(z2, c11689n));
    }

    /* renamed from: h */
    public final List<ValueParameterDescriptor> m9975h(List<C11696u> list, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        CallableDescriptor callableDescriptor = (CallableDescriptor) this.f24683a.getContainingDeclaration();
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "callableDescriptor.containingDeclaration");
        ProtoContainer protoContainerM9968a = m9968a(containingDeclaration);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            C11696u c11696u = (C11696u) obj;
            int flags = c11696u.hasFlags() ? c11696u.getFlags() : 0;
            Annotations4 empty = (protoContainerM9968a == null || !outline.m880u0(Flags2.f24031b, flags, "HAS_ANNOTATIONS.get(flags)")) ? Annotations4.f22735f.getEMPTY() : new DeserializedAnnotations2(this.f24683a.getStorageManager(), new e(protoContainerM9968a, messageLite, annotatedCallableKind, i, c11696u));
            Name name = NameResolverUtil.getName(this.f24683a.getNameResolver(), c11696u.getName());
            KotlinType kotlinTypeType = this.f24683a.getTypeDeserializer().type(protoTypeTableUtil.type(c11696u, this.f24683a.getTypeTable()));
            boolean zM880u0 = outline.m880u0(Flags2.f24022F, flags, "DECLARES_DEFAULT_VALUE.get(flags)");
            boolean zM880u02 = outline.m880u0(Flags2.f24023G, flags, "IS_CROSSINLINE.get(flags)");
            boolean zM880u03 = outline.m880u0(Flags2.f24024H, flags, "IS_NOINLINE.get(flags)");
            C11692q c11692qVarargElementType = protoTypeTableUtil.varargElementType(c11696u, this.f24683a.getTypeTable());
            KotlinType kotlinTypeType2 = c11692qVarargElementType == null ? null : this.f24683a.getTypeDeserializer().type(c11692qVarargElementType);
            SourceElement sourceElement = SourceElement.f23099a;
            Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new ValueParameterDescriptorImpl(callableDescriptor, null, i, empty, name, kotlinTypeType, zM880u0, zM880u02, zM880u03, kotlinTypeType2, sourceElement));
            arrayList = arrayList2;
            i = i2;
        }
        return _Collections.toList(arrayList);
    }

    /* renamed from: i */
    public final boolean m9976i(DeserializedMemberDescriptor3 deserializedMemberDescriptor3) {
        boolean z2;
        if (!this.f24683a.getComponents().getConfiguration().getReleaseCoroutines()) {
            return false;
        }
        List<VersionRequirement> versionRequirements = deserializedMemberDescriptor3.getVersionRequirements();
        if ((versionRequirements instanceof Collection) && versionRequirements.isEmpty()) {
            z2 = true;
        } else {
            for (VersionRequirement versionRequirement : versionRequirements) {
                if (Intrinsics3.areEqual(versionRequirement.getVersion(), new VersionRequirement.b(1, 3, 0, 4, null)) && versionRequirement.getKind() == C11697v.d.LANGUAGE_VERSION) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public final ClassConstructorDescriptor loadConstructor(C11679d c11679d, boolean z2) {
        DeserializedMemberDescriptor2 deserializedMemberDescriptor2;
        DeserializedMemberDescriptor3.a aVarM9970c;
        TypeDeserializer typeDeserializer;
        Intrinsics3.checkNotNullParameter(c11679d, "proto");
        ClassDescriptor classDescriptor = (ClassDescriptor) this.f24683a.getContainingDeclaration();
        int flags = c11679d.getFlags();
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        DeserializedMemberDescriptor2 deserializedMemberDescriptor22 = new DeserializedMemberDescriptor2(classDescriptor, null, m9972e(c11679d, flags, annotatedCallableKind), z2, CallableMemberDescriptor.a.DECLARATION, c11679d, this.f24683a.getNameResolver(), this.f24683a.getTypeTable(), this.f24683a.getVersionRequirementTable(), this.f24683a.getContainerSource(), null, 1024, null);
        MemberDeserializer memberDeserializer = context6.childContext$default(this.f24683a, deserializedMemberDescriptor22, Collections2.emptyList(), null, null, null, null, 60, null).getMemberDeserializer();
        List<C11696u> valueParameterList = c11679d.getValueParameterList();
        Intrinsics3.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
        deserializedMemberDescriptor22.initialize(memberDeserializer.m9975h(valueParameterList, c11679d, annotatedCallableKind), ProtoEnumFlagsUtils.descriptorVisibility(ProtoEnumFlags.f24700a, Flags2.f24032c.get(c11679d.getFlags())));
        deserializedMemberDescriptor22.setReturnType(classDescriptor.getDefaultType());
        deserializedMemberDescriptor22.setHasStableParameterNames(!Flags2.f24042m.get(c11679d.getFlags()).booleanValue());
        DeclarationDescriptor containingDeclaration = this.f24683a.getContainingDeclaration();
        Boolean boolValueOf = null;
        DeserializedClassDescriptor deserializedClassDescriptor = containingDeclaration instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) containingDeclaration : null;
        context6 c2 = deserializedClassDescriptor == null ? null : deserializedClassDescriptor.getC();
        if (c2 != null && (typeDeserializer = c2.getTypeDeserializer()) != null) {
            boolValueOf = Boolean.valueOf(typeDeserializer.getExperimentalSuspendFunctionTypeEncountered());
        }
        if (Intrinsics3.areEqual(boolValueOf, Boolean.TRUE) && m9976i(deserializedMemberDescriptor22)) {
            aVarM9970c = DeserializedMemberDescriptor3.a.INCOMPATIBLE;
            deserializedMemberDescriptor2 = deserializedMemberDescriptor22;
        } else {
            Collection<? extends ValueParameterDescriptor> valueParameters = deserializedMemberDescriptor22.getValueParameters();
            Intrinsics3.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            Collection<? extends TypeParameterDescriptor> typeParameters = deserializedMemberDescriptor22.getTypeParameters();
            Intrinsics3.checkNotNullExpressionValue(typeParameters, "descriptor.typeParameters");
            deserializedMemberDescriptor2 = deserializedMemberDescriptor22;
            aVarM9970c = m9970c(deserializedMemberDescriptor22, null, valueParameters, typeParameters, deserializedMemberDescriptor22.getReturnType(), false);
        }
        deserializedMemberDescriptor2.setCoroutinesExperimentalCompatibilityMode$deserialization(aVarM9970c);
        return deserializedMemberDescriptor2;
    }

    public final SimpleFunctionDescriptor loadFunction(C11684i c11684i) {
        int flags;
        KotlinType kotlinTypeType;
        Intrinsics3.checkNotNullParameter(c11684i, "proto");
        if (c11684i.hasFlags()) {
            flags = c11684i.getFlags();
        } else {
            int oldFlags = c11684i.getOldFlags();
            flags = ((oldFlags >> 8) << 6) + (oldFlags & 63);
        }
        int i = flags;
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        Annotations4 annotations4M9972e = m9972e(c11684i, i, annotatedCallableKind);
        Annotations4 deserializedAnnotations = protoTypeTableUtil.hasReceiver(c11684i) ? new DeserializedAnnotations(this.f24683a.getStorageManager(), new MemberDeserializer2(this, c11684i, annotatedCallableKind)) : Annotations4.f22735f.getEMPTY();
        VersionRequirement2 empty = Intrinsics3.areEqual(DescriptorUtils2.getFqNameSafe(this.f24683a.getContainingDeclaration()).child(NameResolverUtil.getName(this.f24683a.getNameResolver(), c11684i.getName())), suspendFunctionTypeUtil.f24502a) ? VersionRequirement2.f24073a.getEMPTY() : this.f24683a.getVersionRequirementTable();
        DeclarationDescriptor containingDeclaration = this.f24683a.getContainingDeclaration();
        Name name = NameResolverUtil.getName(this.f24683a.getNameResolver(), c11684i.getName());
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.f24700a;
        DeserializedMemberDescriptor5 deserializedMemberDescriptor5 = new DeserializedMemberDescriptor5(containingDeclaration, null, annotations4M9972e, name, ProtoEnumFlagsUtils.memberKind(protoEnumFlags, Flags2.f24043n.get(i)), c11684i, this.f24683a.getNameResolver(), this.f24683a.getTypeTable(), empty, this.f24683a.getContainerSource(), null, 1024, null);
        context6 context6Var = this.f24683a;
        List<C11694s> typeParameterList = c11684i.getTypeParameterList();
        Intrinsics3.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        context6 context6VarChildContext$default = context6.childContext$default(context6Var, deserializedMemberDescriptor5, typeParameterList, null, null, null, null, 60, null);
        C11692q c11692qReceiverType = protoTypeTableUtil.receiverType(c11684i, this.f24683a.getTypeTable());
        ReceiverParameterDescriptor receiverParameterDescriptorCreateExtensionReceiverParameterForCallable = (c11692qReceiverType == null || (kotlinTypeType = context6VarChildContext$default.getTypeDeserializer().type(c11692qReceiverType)) == null) ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedMemberDescriptor5, kotlinTypeType, deserializedAnnotations);
        ReceiverParameterDescriptor receiverParameterDescriptorM9973f = m9973f();
        List<TypeParameterDescriptor> ownTypeParameters = context6VarChildContext$default.getTypeDeserializer().getOwnTypeParameters();
        MemberDeserializer memberDeserializer = context6VarChildContext$default.getMemberDeserializer();
        List<C11696u> valueParameterList = c11684i.getValueParameterList();
        Intrinsics3.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
        List<ValueParameterDescriptor> listM9975h = memberDeserializer.m9975h(valueParameterList, c11684i, annotatedCallableKind);
        KotlinType kotlinTypeType2 = context6VarChildContext$default.getTypeDeserializer().type(protoTypeTableUtil.returnType(c11684i, this.f24683a.getTypeTable()));
        Modality modality = protoEnumFlags.modality(Flags2.f24033d.get(i));
        DescriptorVisibility2 descriptorVisibility2DescriptorVisibility = ProtoEnumFlagsUtils.descriptorVisibility(protoEnumFlags, Flags2.f24032c.get(i));
        Map<? extends CallableDescriptor.a<?>, ?> mapEmptyMap = Maps6.emptyMap();
        Flags2.b bVar = Flags2.f24049t;
        deserializedMemberDescriptor5.initialize(receiverParameterDescriptorCreateExtensionReceiverParameterForCallable, receiverParameterDescriptorM9973f, ownTypeParameters, listM9975h, kotlinTypeType2, modality, descriptorVisibility2DescriptorVisibility, mapEmptyMap, m9970c(deserializedMemberDescriptor5, receiverParameterDescriptorCreateExtensionReceiverParameterForCallable, listM9975h, ownTypeParameters, kotlinTypeType2, outline.m880u0(bVar, i, "IS_SUSPEND.get(flags)")));
        Boolean bool = Flags2.f24044o.get(i);
        Intrinsics3.checkNotNullExpressionValue(bool, "IS_OPERATOR.get(flags)");
        deserializedMemberDescriptor5.setOperator(bool.booleanValue());
        Boolean bool2 = Flags2.f24045p.get(i);
        Intrinsics3.checkNotNullExpressionValue(bool2, "IS_INFIX.get(flags)");
        deserializedMemberDescriptor5.setInfix(bool2.booleanValue());
        Boolean bool3 = Flags2.f24048s.get(i);
        Intrinsics3.checkNotNullExpressionValue(bool3, "IS_EXTERNAL_FUNCTION.get(flags)");
        deserializedMemberDescriptor5.setExternal(bool3.booleanValue());
        Boolean bool4 = Flags2.f24046q.get(i);
        Intrinsics3.checkNotNullExpressionValue(bool4, "IS_INLINE.get(flags)");
        deserializedMemberDescriptor5.setInline(bool4.booleanValue());
        Boolean bool5 = Flags2.f24047r.get(i);
        Intrinsics3.checkNotNullExpressionValue(bool5, "IS_TAILREC.get(flags)");
        deserializedMemberDescriptor5.setTailrec(bool5.booleanValue());
        Boolean bool6 = bVar.get(i);
        Intrinsics3.checkNotNullExpressionValue(bool6, "IS_SUSPEND.get(flags)");
        deserializedMemberDescriptor5.setSuspend(bool6.booleanValue());
        Boolean bool7 = Flags2.f24050u.get(i);
        Intrinsics3.checkNotNullExpressionValue(bool7, "IS_EXPECT_FUNCTION.get(flags)");
        deserializedMemberDescriptor5.setExpect(bool7.booleanValue());
        deserializedMemberDescriptor5.setHasStableParameterNames(!Flags2.f24051v.get(i).booleanValue());
        Tuples2<CallableDescriptor.a<?>, Object> tuples2DeserializeContractFromFunction = this.f24683a.getComponents().getContractDeserializer().deserializeContractFromFunction(c11684i, deserializedMemberDescriptor5, this.f24683a.getTypeTable(), context6VarChildContext$default.getTypeDeserializer());
        if (tuples2DeserializeContractFromFunction != null) {
            deserializedMemberDescriptor5.putInUserDataMap(tuples2DeserializeContractFromFunction.getFirst(), tuples2DeserializeContractFromFunction.getSecond());
        }
        return deserializedMemberDescriptor5;
    }

    public final PropertyDescriptor loadProperty(C11689n c11689n) {
        int flags;
        C11689n c11689n2;
        AnnotatedCallableKind annotatedCallableKind;
        Annotations4 empty;
        ReceiverParameterDescriptor receiverParameterDescriptorCreateExtensionReceiverParameterForCallable;
        DeserializedMemberDescriptor4 deserializedMemberDescriptor4;
        ProtoEnumFlags protoEnumFlags;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImplCreateDefaultGetter;
        KotlinType kotlinTypeType;
        AnnotatedCallableKind annotatedCallableKind2 = AnnotatedCallableKind.PROPERTY_GETTER;
        Intrinsics3.checkNotNullParameter(c11689n, "proto");
        if (c11689n.hasFlags()) {
            flags = c11689n.getFlags();
        } else {
            int oldFlags = c11689n.getOldFlags();
            flags = ((oldFlags >> 8) << 6) + (oldFlags & 63);
        }
        int i = flags;
        DeclarationDescriptor containingDeclaration = this.f24683a.getContainingDeclaration();
        Annotations4 annotations4M9972e = m9972e(c11689n, i, AnnotatedCallableKind.PROPERTY);
        ProtoEnumFlags protoEnumFlags2 = ProtoEnumFlags.f24700a;
        Flags2.d<EnumC11686k> dVar = Flags2.f24033d;
        Modality modality = protoEnumFlags2.modality(dVar.get(i));
        Flags2.d<EnumC11699x> dVar2 = Flags2.f24032c;
        DeserializedMemberDescriptor4 deserializedMemberDescriptor42 = new DeserializedMemberDescriptor4(containingDeclaration, null, annotations4M9972e, modality, ProtoEnumFlagsUtils.descriptorVisibility(protoEnumFlags2, dVar2.get(i)), outline.m880u0(Flags2.f24052w, i, "IS_VAR.get(flags)"), NameResolverUtil.getName(this.f24683a.getNameResolver(), c11689n.getName()), ProtoEnumFlagsUtils.memberKind(protoEnumFlags2, Flags2.f24043n.get(i)), outline.m880u0(Flags2.f24017A, i, "IS_LATEINIT.get(flags)"), outline.m880u0(Flags2.f24055z, i, "IS_CONST.get(flags)"), outline.m880u0(Flags2.f24019C, i, "IS_EXTERNAL_PROPERTY.get(flags)"), outline.m880u0(Flags2.f24020D, i, "IS_DELEGATED.get(flags)"), outline.m880u0(Flags2.f24021E, i, "IS_EXPECT_PROPERTY.get(flags)"), c11689n, this.f24683a.getNameResolver(), this.f24683a.getTypeTable(), this.f24683a.getVersionRequirementTable(), this.f24683a.getContainerSource());
        context6 context6Var = this.f24683a;
        List<C11694s> typeParameterList = c11689n.getTypeParameterList();
        Intrinsics3.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        context6 context6VarChildContext$default = context6.childContext$default(context6Var, deserializedMemberDescriptor42, typeParameterList, null, null, null, null, 60, null);
        boolean zM880u0 = outline.m880u0(Flags2.f24053x, i, "HAS_GETTER.get(flags)");
        if (zM880u0 && protoTypeTableUtil.hasReceiver(c11689n)) {
            c11689n2 = c11689n;
            annotatedCallableKind = annotatedCallableKind2;
            empty = new DeserializedAnnotations(this.f24683a.getStorageManager(), new MemberDeserializer2(this, c11689n2, annotatedCallableKind));
        } else {
            c11689n2 = c11689n;
            annotatedCallableKind = annotatedCallableKind2;
            empty = Annotations4.f22735f.getEMPTY();
        }
        KotlinType kotlinTypeType2 = context6VarChildContext$default.getTypeDeserializer().type(protoTypeTableUtil.returnType(c11689n2, this.f24683a.getTypeTable()));
        List<TypeParameterDescriptor> ownTypeParameters = context6VarChildContext$default.getTypeDeserializer().getOwnTypeParameters();
        ReceiverParameterDescriptor receiverParameterDescriptorM9973f = m9973f();
        C11692q c11692qReceiverType = protoTypeTableUtil.receiverType(c11689n2, this.f24683a.getTypeTable());
        if (c11692qReceiverType == null || (kotlinTypeType = context6VarChildContext$default.getTypeDeserializer().type(c11692qReceiverType)) == null) {
            receiverParameterDescriptorCreateExtensionReceiverParameterForCallable = null;
            deserializedMemberDescriptor4 = deserializedMemberDescriptor42;
        } else {
            deserializedMemberDescriptor4 = deserializedMemberDescriptor42;
            receiverParameterDescriptorCreateExtensionReceiverParameterForCallable = DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedMemberDescriptor4, kotlinTypeType, empty);
        }
        deserializedMemberDescriptor4.setType(kotlinTypeType2, ownTypeParameters, receiverParameterDescriptorM9973f, receiverParameterDescriptorCreateExtensionReceiverParameterForCallable);
        int accessorFlags = Flags2.getAccessorFlags(outline.m880u0(Flags2.f24031b, i, "HAS_ANNOTATIONS.get(flags)"), dVar2.get(i), dVar.get(i), false, false, false);
        if (zM880u0) {
            int getterFlags = c11689n.hasGetterFlags() ? c11689n.getGetterFlags() : accessorFlags;
            boolean zM880u02 = outline.m880u0(Flags2.f24025I, getterFlags, "IS_NOT_DEFAULT.get(getterFlags)");
            boolean zM880u03 = outline.m880u0(Flags2.f24026J, getterFlags, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean zM880u04 = outline.m880u0(Flags2.f24027K, getterFlags, "IS_INLINE_ACCESSOR.get(getterFlags)");
            Annotations4 annotations4M9972e2 = m9972e(c11689n2, getterFlags, annotatedCallableKind);
            if (zM880u02) {
                protoEnumFlags = protoEnumFlags2;
                propertyGetterDescriptorImplCreateDefaultGetter = new PropertyGetterDescriptorImpl(deserializedMemberDescriptor4, annotations4M9972e2, protoEnumFlags2.modality(dVar.get(getterFlags)), ProtoEnumFlagsUtils.descriptorVisibility(protoEnumFlags2, dVar2.get(getterFlags)), !zM880u02, zM880u03, zM880u04, deserializedMemberDescriptor4.getKind(), null, SourceElement.f23099a);
            } else {
                protoEnumFlags = protoEnumFlags2;
                propertyGetterDescriptorImplCreateDefaultGetter = DescriptorFactory.createDefaultGetter(deserializedMemberDescriptor4, annotations4M9972e2);
                Intrinsics3.checkNotNullExpressionValue(propertyGetterDescriptorImplCreateDefaultGetter, "{\n                DescriptorFactory.createDefaultGetter(property, annotations)\n            }");
            }
            propertyGetterDescriptorImplCreateDefaultGetter.initialize(deserializedMemberDescriptor4.getReturnType());
            propertyGetterDescriptorImpl = propertyGetterDescriptorImplCreateDefaultGetter;
        } else {
            protoEnumFlags = protoEnumFlags2;
            propertyGetterDescriptorImpl = null;
        }
        if (outline.m880u0(Flags2.f24054y, i, "HAS_SETTER.get(flags)")) {
            if (c11689n.hasSetterFlags()) {
                accessorFlags = c11689n.getSetterFlags();
            }
            boolean zM880u05 = outline.m880u0(Flags2.f24025I, accessorFlags, "IS_NOT_DEFAULT.get(setterFlags)");
            boolean zM880u06 = outline.m880u0(Flags2.f24026J, accessorFlags, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean zM880u07 = outline.m880u0(Flags2.f24027K, accessorFlags, "IS_INLINE_ACCESSOR.get(setterFlags)");
            AnnotatedCallableKind annotatedCallableKind3 = AnnotatedCallableKind.PROPERTY_SETTER;
            Annotations4 annotations4M9972e3 = m9972e(c11689n2, accessorFlags, annotatedCallableKind3);
            if (zM880u05) {
                PropertySetterDescriptorImpl propertySetterDescriptorImpl2 = new PropertySetterDescriptorImpl(deserializedMemberDescriptor4, annotations4M9972e3, protoEnumFlags.modality(dVar.get(accessorFlags)), ProtoEnumFlagsUtils.descriptorVisibility(protoEnumFlags, dVar2.get(accessorFlags)), !zM880u05, zM880u06, zM880u07, deserializedMemberDescriptor4.getKind(), null, SourceElement.f23099a);
                propertySetterDescriptorImpl2.initialize((ValueParameterDescriptor) _Collections.single((List) context6.childContext$default(context6VarChildContext$default, propertySetterDescriptorImpl2, Collections2.emptyList(), null, null, null, null, 60, null).getMemberDeserializer().m9975h(CollectionsJVM.listOf(c11689n.getSetterValueParameter()), c11689n2, annotatedCallableKind3)));
                propertySetterDescriptorImpl = propertySetterDescriptorImpl2;
            } else {
                PropertySetterDescriptorImpl propertySetterDescriptorImplCreateDefaultSetter = DescriptorFactory.createDefaultSetter(deserializedMemberDescriptor4, annotations4M9972e3, Annotations4.f22735f.getEMPTY());
                Intrinsics3.checkNotNullExpressionValue(propertySetterDescriptorImplCreateDefaultSetter, "{\n                DescriptorFactory.createDefaultSetter(\n                    property, annotations,\n                    Annotations.EMPTY /* Otherwise the setter is not default, see DescriptorResolver.resolvePropertySetterDescriptor */\n                )\n            }");
                propertySetterDescriptorImpl = propertySetterDescriptorImplCreateDefaultSetter;
            }
        } else {
            propertySetterDescriptorImpl = null;
        }
        if (outline.m880u0(Flags2.f24018B, i, "HAS_CONSTANT.get(flags)")) {
            deserializedMemberDescriptor4.setCompileTimeInitializer(this.f24683a.getStorageManager().createNullableLazyValue(new d(c11689n2, deserializedMemberDescriptor4)));
        }
        deserializedMemberDescriptor4.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, new FieldDescriptorImpl(m9974g(c11689n2, false), deserializedMemberDescriptor4), new FieldDescriptorImpl(m9974g(c11689n2, true), deserializedMemberDescriptor4), m9969b(deserializedMemberDescriptor4, context6VarChildContext$default.getTypeDeserializer()));
        return deserializedMemberDescriptor4;
    }

    public final TypeAliasDescriptor loadTypeAlias(C11693r c11693r) {
        Intrinsics3.checkNotNullParameter(c11693r, "proto");
        Annotations4.a aVar = Annotations4.f22735f;
        List<C11677b> annotationList = c11693r.getAnnotationList();
        Intrinsics3.checkNotNullExpressionValue(annotationList, "proto.annotationList");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(annotationList, 10));
        for (C11677b c11677b : annotationList) {
            AnnotationDeserializer annotationDeserializer = this.f24684b;
            Intrinsics3.checkNotNullExpressionValue(c11677b, "it");
            arrayList.add(annotationDeserializer.deserializeAnnotation(c11677b, this.f24683a.getNameResolver()));
        }
        DeserializedMemberDescriptor6 deserializedMemberDescriptor6 = new DeserializedMemberDescriptor6(this.f24683a.getStorageManager(), this.f24683a.getContainingDeclaration(), aVar.create(arrayList), NameResolverUtil.getName(this.f24683a.getNameResolver(), c11693r.getName()), ProtoEnumFlagsUtils.descriptorVisibility(ProtoEnumFlags.f24700a, Flags2.f24032c.get(c11693r.getFlags())), c11693r, this.f24683a.getNameResolver(), this.f24683a.getTypeTable(), this.f24683a.getVersionRequirementTable(), this.f24683a.getContainerSource());
        context6 context6Var = this.f24683a;
        List<C11694s> typeParameterList = c11693r.getTypeParameterList();
        Intrinsics3.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        context6 context6VarChildContext$default = context6.childContext$default(context6Var, deserializedMemberDescriptor6, typeParameterList, null, null, null, null, 60, null);
        deserializedMemberDescriptor6.initialize(context6VarChildContext$default.getTypeDeserializer().getOwnTypeParameters(), context6VarChildContext$default.getTypeDeserializer().simpleType(protoTypeTableUtil.underlyingType(c11693r, this.f24683a.getTypeTable()), false), context6VarChildContext$default.getTypeDeserializer().simpleType(protoTypeTableUtil.expandedType(c11693r, this.f24683a.getTypeTable()), false), m9969b(deserializedMemberDescriptor6, context6VarChildContext$default.getTypeDeserializer()));
        return deserializedMemberDescriptor6;
    }
}
