package p507d0.p513e0.p514p.p515d.p517m0.p551j;

import java.lang.reflect.Field;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.properties.Interfaces;
import kotlin.reflect.KProperty;
import p507d0.p509b0.ObservableProperty;
import p507d0.p513e0.KClass;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.ClassifierNamePolicy;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.MutablePropertyReference1Impl;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: DescriptorRendererOptionsImpl.kt */
/* renamed from: d0.e0.p.d.m0.j.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class DescriptorRendererOptionsImpl implements DescriptorRenderer4 {

    /* renamed from: a */
    public static final /* synthetic */ KProperty<Object>[] f24261a = {Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "withDefinedIn", "getWithDefinedIn()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "modifiers", "getModifiers()Ljava/util/Set;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "startFromName", "getStartFromName()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "debugMode", "getDebugMode()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "verbose", "getVerbose()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "unitReturnType", "getUnitReturnType()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "withoutReturnType", "getWithoutReturnType()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "enhancedTypes", "getEnhancedTypes()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderDefaultModality", "getRenderDefaultModality()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "receiverAfterName", "getReceiverAfterName()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), Reflection2.mutableProperty1(new MutablePropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "informativeErrorType", "getInformativeErrorType()Z"))};

    /* renamed from: A */
    public final Interfaces f24262A;

    /* renamed from: B */
    public final Interfaces f24263B;

    /* renamed from: C */
    public final Interfaces f24264C;

    /* renamed from: D */
    public final Interfaces f24265D;

    /* renamed from: E */
    public final Interfaces f24266E;

    /* renamed from: F */
    public final Interfaces f24267F;

    /* renamed from: G */
    public final Interfaces f24268G;

    /* renamed from: H */
    public final Interfaces f24269H;

    /* renamed from: I */
    public final Interfaces f24270I;

    /* renamed from: J */
    public final Interfaces f24271J;

    /* renamed from: K */
    public final Interfaces f24272K;

    /* renamed from: L */
    public final Interfaces f24273L;

    /* renamed from: M */
    public final Interfaces f24274M;

    /* renamed from: N */
    public final Interfaces f24275N;

    /* renamed from: O */
    public final Interfaces f24276O;

    /* renamed from: P */
    public final Interfaces f24277P;

    /* renamed from: Q */
    public final Interfaces f24278Q;

    /* renamed from: R */
    public final Interfaces f24279R;

    /* renamed from: S */
    public final Interfaces f24280S;

    /* renamed from: T */
    public final Interfaces f24281T;

    /* renamed from: U */
    public final Interfaces f24282U;

    /* renamed from: V */
    public final Interfaces f24283V;

    /* renamed from: W */
    public final Interfaces f24284W;

    /* renamed from: b */
    public boolean f24285b;

    /* renamed from: c */
    public final Interfaces f24286c;

    /* renamed from: d */
    public final Interfaces f24287d;

    /* renamed from: e */
    public final Interfaces f24288e;

    /* renamed from: f */
    public final Interfaces f24289f;

    /* renamed from: g */
    public final Interfaces f24290g;

    /* renamed from: h */
    public final Interfaces f24291h;

    /* renamed from: i */
    public final Interfaces f24292i;

    /* renamed from: j */
    public final Interfaces f24293j;

    /* renamed from: k */
    public final Interfaces f24294k;

    /* renamed from: l */
    public final Interfaces f24295l;

    /* renamed from: m */
    public final Interfaces f24296m;

    /* renamed from: n */
    public final Interfaces f24297n;

    /* renamed from: o */
    public final Interfaces f24298o;

    /* renamed from: p */
    public final Interfaces f24299p;

    /* renamed from: q */
    public final Interfaces f24300q;

    /* renamed from: r */
    public final Interfaces f24301r;

    /* renamed from: s */
    public final Interfaces f24302s;

    /* renamed from: t */
    public final Interfaces f24303t;

    /* renamed from: u */
    public final Interfaces f24304u;

    /* renamed from: v */
    public final Interfaces f24305v;

    /* renamed from: w */
    public final Interfaces f24306w;

    /* renamed from: x */
    public final Interfaces f24307x;

    /* renamed from: y */
    public final Interfaces f24308y;

    /* renamed from: z */
    public final Interfaces f24309z;

    /* compiled from: DescriptorRendererOptionsImpl.kt */
    /* renamed from: d0.e0.p.d.m0.j.i$a */
    public static final class a extends Lambda implements Function1<ValueParameterDescriptor, String> {

        /* renamed from: j */
        public static final a f24310j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(ValueParameterDescriptor valueParameterDescriptor) {
            return invoke2(valueParameterDescriptor);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(ValueParameterDescriptor valueParameterDescriptor) {
            Intrinsics3.checkNotNullParameter(valueParameterDescriptor, "it");
            return "...";
        }
    }

    /* compiled from: DescriptorRendererOptionsImpl.kt */
    /* renamed from: d0.e0.p.d.m0.j.i$b */
    public static final class b extends Lambda implements Function1<KotlinType, KotlinType> {

        /* renamed from: j */
        public static final b f24311j = new b();

        public b() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final KotlinType invoke2(KotlinType kotlinType) {
            Intrinsics3.checkNotNullParameter(kotlinType, "it");
            return kotlinType;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ KotlinType invoke(KotlinType kotlinType) {
            return invoke2(kotlinType);
        }
    }

    public DescriptorRendererOptionsImpl() {
        ClassifierNamePolicy.c cVar = ClassifierNamePolicy.c.f24224a;
        this.f24286c = new Delegates2(cVar, cVar, this);
        Boolean bool = Boolean.TRUE;
        this.f24287d = new Delegates2(bool, bool, this);
        this.f24288e = new Delegates2(bool, bool, this);
        Set<DescriptorRenderer3> set = DescriptorRenderer3.f24244j;
        this.f24289f = new Delegates2(set, set, this);
        Boolean bool2 = Boolean.FALSE;
        this.f24290g = new Delegates2(bool2, bool2, this);
        this.f24291h = new Delegates2(bool2, bool2, this);
        this.f24292i = new Delegates2(bool2, bool2, this);
        this.f24293j = new Delegates2(bool2, bool2, this);
        this.f24294k = new Delegates2(bool2, bool2, this);
        this.f24295l = new Delegates2(bool, bool, this);
        this.f24296m = new Delegates2(bool2, bool2, this);
        this.f24297n = new Delegates2(bool2, bool2, this);
        this.f24298o = new Delegates2(bool2, bool2, this);
        this.f24299p = new Delegates2(bool, bool, this);
        this.f24300q = new Delegates2(bool, bool, this);
        this.f24301r = new Delegates2(bool2, bool2, this);
        this.f24302s = new Delegates2(bool2, bool2, this);
        this.f24303t = new Delegates2(bool2, bool2, this);
        this.f24304u = new Delegates2(bool2, bool2, this);
        this.f24305v = new Delegates2(bool2, bool2, this);
        this.f24306w = new Delegates2(bool2, bool2, this);
        this.f24307x = new Delegates2(bool2, bool2, this);
        b bVar = b.f24311j;
        this.f24308y = new Delegates2(bVar, bVar, this);
        a aVar = a.f24310j;
        this.f24309z = new Delegates2(aVar, aVar, this);
        this.f24262A = new Delegates2(bool, bool, this);
        DescriptorRenderer6 descriptorRenderer6 = DescriptorRenderer6.RENDER_OPEN;
        this.f24263B = new Delegates2(descriptorRenderer6, descriptorRenderer6, this);
        DescriptorRenderer2.l.a aVar2 = DescriptorRenderer2.l.a.f24238a;
        this.f24264C = new Delegates2(aVar2, aVar2, this);
        DescriptorRenderer9 descriptorRenderer9 = DescriptorRenderer9.f24329j;
        this.f24265D = new Delegates2(descriptorRenderer9, descriptorRenderer9, this);
        DescriptorRenderer7 descriptorRenderer7 = DescriptorRenderer7.ALL;
        this.f24266E = new Delegates2(descriptorRenderer7, descriptorRenderer7, this);
        this.f24267F = new Delegates2(bool2, bool2, this);
        this.f24268G = new Delegates2(bool2, bool2, this);
        DescriptorRenderer8 descriptorRenderer8 = DescriptorRenderer8.DEBUG;
        this.f24269H = new Delegates2(descriptorRenderer8, descriptorRenderer8, this);
        this.f24270I = new Delegates2(bool2, bool2, this);
        this.f24271J = new Delegates2(bool2, bool2, this);
        Set setEmptySet = Sets5.emptySet();
        this.f24272K = new Delegates2(setEmptySet, setEmptySet, this);
        Set<FqName> internalAnnotationsForResolve = DescriptorRenderer5.f24314a.getInternalAnnotationsForResolve();
        this.f24273L = new Delegates2(internalAnnotationsForResolve, internalAnnotationsForResolve, this);
        this.f24274M = new Delegates2(null, null, this);
        DescriptorRenderer descriptorRenderer = DescriptorRenderer.NO_ARGUMENTS;
        this.f24275N = new Delegates2(descriptorRenderer, descriptorRenderer, this);
        this.f24276O = new Delegates2(bool2, bool2, this);
        this.f24277P = new Delegates2(bool, bool, this);
        this.f24278Q = new Delegates2(bool, bool, this);
        this.f24279R = new Delegates2(bool2, bool2, this);
        this.f24280S = new Delegates2(bool, bool, this);
        this.f24281T = new Delegates2(bool, bool, this);
        new Delegates2(bool2, bool2, this);
        this.f24282U = new Delegates2(bool2, bool2, this);
        this.f24283V = new Delegates2(bool2, bool2, this);
        this.f24284W = new Delegates2(bool, bool, this);
    }

    public final DescriptorRendererOptionsImpl copy() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
        Field[] declaredFields = DescriptorRendererOptionsImpl.class.getDeclaredFields();
        Intrinsics3.checkNotNullExpressionValue(declaredFields, "this::class.java.declaredFields");
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            i++;
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(this);
                ObservableProperty observableProperty = obj instanceof ObservableProperty ? (ObservableProperty) obj : null;
                if (observableProperty != null) {
                    String name = field.getName();
                    Intrinsics3.checkNotNullExpressionValue(name, "field.name");
                    StringsJVM.startsWith$default(name, "is", false, 2, null);
                    KClass orCreateKotlinClass = Reflection2.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class);
                    String name2 = field.getName();
                    String name3 = field.getName();
                    Intrinsics3.checkNotNullExpressionValue(name3, "field.name");
                    Object value = observableProperty.getValue(this, new PropertyReference1Impl(orCreateKotlinClass, name2, Intrinsics3.stringPlus("get", StringsJVM.capitalize(name3))));
                    field.set(descriptorRendererOptionsImpl, new Delegates2(value, value, descriptorRendererOptionsImpl));
                }
            }
        }
        return descriptorRendererOptionsImpl;
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return ((Boolean) this.f24303t.getValue(this, f24261a[17])).booleanValue();
    }

    public boolean getAlwaysRenderModifiers() {
        return ((Boolean) this.f24276O.getValue(this, f24261a[38])).booleanValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public DescriptorRenderer getAnnotationArgumentsRenderingPolicy() {
        return (DescriptorRenderer) this.f24275N.getValue(this, f24261a[37]);
    }

    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return (Function1) this.f24274M.getValue(this, f24261a[36]);
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return ((Boolean) this.f24283V.getValue(this, f24261a[46])).booleanValue();
    }

    public boolean getClassWithPrimaryConstructor() {
        return ((Boolean) this.f24293j.getValue(this, f24261a[7])).booleanValue();
    }

    public ClassifierNamePolicy getClassifierNamePolicy() {
        return (ClassifierNamePolicy) this.f24286c.getValue(this, f24261a[0]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public boolean getDebugMode() {
        return ((Boolean) this.f24292i.getValue(this, f24261a[6])).booleanValue();
    }

    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return (Function1) this.f24309z.getValue(this, f24261a[23]);
    }

    public boolean getEachAnnotationOnNewLine() {
        return ((Boolean) this.f24271J.getValue(this, f24261a[33])).booleanValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public boolean getEnhancedTypes() {
        return ((Boolean) this.f24297n.getValue(this, f24261a[11])).booleanValue();
    }

    public Set<FqName> getExcludedAnnotationClasses() {
        return (Set) this.f24272K.getValue(this, f24261a[34]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return (Set) this.f24273L.getValue(this, f24261a[35]);
    }

    public boolean getIncludeAdditionalModifiers() {
        return ((Boolean) this.f24280S.getValue(this, f24261a[42])).booleanValue();
    }

    public boolean getIncludeAnnotationArguments() {
        return DescriptorRenderer4.a.getIncludeAnnotationArguments(this);
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return DescriptorRenderer4.a.getIncludeEmptyAnnotationArguments(this);
    }

    public boolean getIncludePropertyConstant() {
        return ((Boolean) this.f24305v.getValue(this, f24261a[19])).booleanValue();
    }

    public boolean getInformativeErrorType() {
        return ((Boolean) this.f24284W.getValue(this, f24261a[47])).booleanValue();
    }

    public Set<DescriptorRenderer3> getModifiers() {
        return (Set) this.f24289f.getValue(this, f24261a[3]);
    }

    public boolean getNormalizedVisibilities() {
        return ((Boolean) this.f24298o.getValue(this, f24261a[12])).booleanValue();
    }

    public DescriptorRenderer6 getOverrideRenderingPolicy() {
        return (DescriptorRenderer6) this.f24263B.getValue(this, f24261a[25]);
    }

    public DescriptorRenderer7 getParameterNameRenderingPolicy() {
        return (DescriptorRenderer7) this.f24266E.getValue(this, f24261a[28]);
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return ((Boolean) this.f24281T.getValue(this, f24261a[43])).booleanValue();
    }

    public boolean getPresentableUnresolvedTypes() {
        return ((Boolean) this.f24282U.getValue(this, f24261a[45])).booleanValue();
    }

    public DescriptorRenderer8 getPropertyAccessorRenderingPolicy() {
        return (DescriptorRenderer8) this.f24269H.getValue(this, f24261a[31]);
    }

    public boolean getReceiverAfterName() {
        return ((Boolean) this.f24267F.getValue(this, f24261a[29])).booleanValue();
    }

    public boolean getRenderCompanionObjectName() {
        return ((Boolean) this.f24268G.getValue(this, f24261a[30])).booleanValue();
    }

    public boolean getRenderConstructorDelegation() {
        return ((Boolean) this.f24301r.getValue(this, f24261a[15])).booleanValue();
    }

    public boolean getRenderConstructorKeyword() {
        return ((Boolean) this.f24277P.getValue(this, f24261a[39])).booleanValue();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return ((Boolean) this.f24270I.getValue(this, f24261a[32])).booleanValue();
    }

    public boolean getRenderDefaultModality() {
        return ((Boolean) this.f24300q.getValue(this, f24261a[14])).booleanValue();
    }

    public boolean getRenderDefaultVisibility() {
        return ((Boolean) this.f24299p.getValue(this, f24261a[13])).booleanValue();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return ((Boolean) this.f24302s.getValue(this, f24261a[16])).booleanValue();
    }

    public boolean getRenderTypeExpansions() {
        return ((Boolean) this.f24279R.getValue(this, f24261a[41])).booleanValue();
    }

    public boolean getRenderUnabbreviatedType() {
        return ((Boolean) this.f24278Q.getValue(this, f24261a[40])).booleanValue();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return ((Boolean) this.f24262A.getValue(this, f24261a[24])).booleanValue();
    }

    public boolean getStartFromDeclarationKeyword() {
        return ((Boolean) this.f24291h.getValue(this, f24261a[5])).booleanValue();
    }

    public boolean getStartFromName() {
        return ((Boolean) this.f24290g.getValue(this, f24261a[4])).booleanValue();
    }

    public DescriptorRenderer9 getTextFormat() {
        return (DescriptorRenderer9) this.f24265D.getValue(this, f24261a[27]);
    }

    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return (Function1) this.f24308y.getValue(this, f24261a[22]);
    }

    public boolean getUninferredTypeParameterAsName() {
        return ((Boolean) this.f24304u.getValue(this, f24261a[18])).booleanValue();
    }

    public boolean getUnitReturnType() {
        return ((Boolean) this.f24295l.getValue(this, f24261a[9])).booleanValue();
    }

    public DescriptorRenderer2.l getValueParametersHandler() {
        return (DescriptorRenderer2.l) this.f24264C.getValue(this, f24261a[26]);
    }

    public boolean getVerbose() {
        return ((Boolean) this.f24294k.getValue(this, f24261a[8])).booleanValue();
    }

    public boolean getWithDefinedIn() {
        return ((Boolean) this.f24287d.getValue(this, f24261a[1])).booleanValue();
    }

    public boolean getWithSourceFileForTopLevel() {
        return ((Boolean) this.f24288e.getValue(this, f24261a[2])).booleanValue();
    }

    public boolean getWithoutReturnType() {
        return ((Boolean) this.f24296m.getValue(this, f24261a[10])).booleanValue();
    }

    public boolean getWithoutSuperTypes() {
        return ((Boolean) this.f24307x.getValue(this, f24261a[21])).booleanValue();
    }

    public boolean getWithoutTypeParameters() {
        return ((Boolean) this.f24306w.getValue(this, f24261a[20])).booleanValue();
    }

    public final boolean isLocked() {
        return this.f24285b;
    }

    public final void lock() {
        this.f24285b = true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setAnnotationArgumentsRenderingPolicy(DescriptorRenderer descriptorRenderer) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer, "<set-?>");
        this.f24275N.setValue(this, f24261a[37], descriptorRenderer);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setClassifierNamePolicy(ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics3.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.f24286c.setValue(this, f24261a[0], classifierNamePolicy);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setDebugMode(boolean z2) {
        this.f24292i.setValue(this, f24261a[6], Boolean.valueOf(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setExcludedTypeAnnotationClasses(Set<FqName> set) {
        Intrinsics3.checkNotNullParameter(set, "<set-?>");
        this.f24273L.setValue(this, f24261a[35], set);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setModifiers(Set<? extends DescriptorRenderer3> set) {
        Intrinsics3.checkNotNullParameter(set, "<set-?>");
        this.f24289f.setValue(this, f24261a[3], set);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setParameterNameRenderingPolicy(DescriptorRenderer7 descriptorRenderer7) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer7, "<set-?>");
        this.f24266E.setValue(this, f24261a[28], descriptorRenderer7);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setReceiverAfterName(boolean z2) {
        this.f24267F.setValue(this, f24261a[29], Boolean.valueOf(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setRenderCompanionObjectName(boolean z2) {
        this.f24268G.setValue(this, f24261a[30], Boolean.valueOf(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setStartFromName(boolean z2) {
        this.f24290g.setValue(this, f24261a[4], Boolean.valueOf(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setTextFormat(DescriptorRenderer9 descriptorRenderer9) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer9, "<set-?>");
        this.f24265D.setValue(this, f24261a[27], descriptorRenderer9);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setWithDefinedIn(boolean z2) {
        this.f24287d.setValue(this, f24261a[1], Boolean.valueOf(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setWithoutSuperTypes(boolean z2) {
        this.f24307x.setValue(this, f24261a[21], Boolean.valueOf(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4
    public void setWithoutTypeParameters(boolean z2) {
        this.f24306w.setValue(this, f24261a[20], Boolean.valueOf(z2));
    }
}
