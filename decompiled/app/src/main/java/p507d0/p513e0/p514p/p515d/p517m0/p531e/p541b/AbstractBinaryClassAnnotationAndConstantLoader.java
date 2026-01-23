package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import com.discord.widgets.chat.input.MentionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.SpecialJvmAnnotations;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.UnsignedType3;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.MemberSignature;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11677b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11679d;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11682g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11696u;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.JvmProtoBuf;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.ClassMapperLite;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMemberSignature;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmProtoBufUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.Flags2;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.ProtoBufUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.protoTypeTableUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11810b0;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11808a0;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11812d;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11821m;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11827s;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11830v;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11832x;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11833y;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11834z;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.JvmClassName;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotatedCallableKind;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ProtoContainer;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C> implements AnnotationAndConstantLoader<A, C> {

    /* JADX INFO: renamed from: a */
    public final KotlinClassFinder f23533a;

    /* JADX INFO: renamed from: b */
    public final storage3<KotlinJvmBinaryClass, b<A, C>> f23534b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.a$a */
    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public enum a {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.a$b */
    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public static final class b<A, C> {

        /* JADX INFO: renamed from: a */
        public final Map<MemberSignature, List<A>> f23539a;

        /* JADX INFO: renamed from: b */
        public final Map<MemberSignature, C> f23540b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Map<MemberSignature, ? extends List<? extends A>> map, Map<MemberSignature, ? extends C> map2) {
            Intrinsics3.checkNotNullParameter(map, "memberAnnotations");
            Intrinsics3.checkNotNullParameter(map2, "propertyConstants");
            this.f23539a = map;
            this.f23540b = map2;
        }

        public final Map<MemberSignature, List<A>> getMemberAnnotations() {
            return this.f23539a;
        }

        public final Map<MemberSignature, C> getPropertyConstants() {
            return this.f23540b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.a$c */
    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public static final class c implements KotlinJvmBinaryClass.c {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> f23541a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ ArrayList<A> f23542b;

        public c(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader, ArrayList<A> arrayList) {
            this.f23541a = abstractBinaryClassAnnotationAndConstantLoader;
            this.f23542b = arrayList;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.c
        public KotlinJvmBinaryClass.a visitAnnotation(ClassId classId, SourceElement sourceElement) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            Intrinsics3.checkNotNullParameter(sourceElement, "source");
            return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.f23541a, classId, sourceElement, this.f23542b);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.c
        public void visitEnd() {
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.a$d */
    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public static final class d extends Lambda implements Function1<KotlinJvmBinaryClass, b<? extends A, ? extends C>> {
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader) {
            super(1);
            this.this$0 = abstractBinaryClassAnnotationAndConstantLoader;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
            return invoke2(kotlinJvmBinaryClass);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final b<A, C> invoke2(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
            Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
            return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationsAndInitializers(this.this$0, kotlinJvmBinaryClass);
        }
    }

    public AbstractBinaryClassAnnotationAndConstantLoader(StorageManager storageManager, KotlinClassFinder kotlinClassFinder) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.f23533a = kotlinClassFinder;
        this.f23534b = storageManager.createMemoizedFunction(new d(this));
    }

    public static final KotlinJvmBinaryClass.a access$loadAnnotationIfNotSpecial(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ClassId classId, SourceElement sourceElement, List list) {
        Objects.requireNonNull(abstractBinaryClassAnnotationAndConstantLoader);
        if (SpecialJvmAnnotations.f22449a.getSPECIAL_ANNOTATIONS().contains(classId)) {
            return null;
        }
        return abstractBinaryClassAnnotationAndConstantLoader.mo9535h(classId, sourceElement, list);
    }

    public static final b access$loadAnnotationsAndInitializers(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Objects.requireNonNull(abstractBinaryClassAnnotationAndConstantLoader);
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        AbstractBinaryClassAnnotationAndConstantLoader2 abstractBinaryClassAnnotationAndConstantLoader2 = new AbstractBinaryClassAnnotationAndConstantLoader2(abstractBinaryClassAnnotationAndConstantLoader, map, map2);
        Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        kotlinJvmBinaryClass.visitMembers(abstractBinaryClassAnnotationAndConstantLoader2, null);
        return new b(map, map2);
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ List m9528b(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ProtoContainer protoContainer, MemberSignature memberSignature, boolean z2, boolean z3, Boolean bool, boolean z4, int i, Object obj) {
        return abstractBinaryClassAnnotationAndConstantLoader.m9531a(protoContainer, memberSignature, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? false : z4);
    }

    /* JADX INFO: renamed from: d */
    public static /* synthetic */ MemberSignature m9529d(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean z2, int i, Object obj) {
        return abstractBinaryClassAnnotationAndConstantLoader.m9532c(messageLite, nameResolver, typeTable, annotatedCallableKind, (i & 16) != 0 ? false : z2);
    }

    /* JADX INFO: renamed from: f */
    public static /* synthetic */ MemberSignature m9530f(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, C11689n c11689n, NameResolver nameResolver, TypeTable typeTable, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        return abstractBinaryClassAnnotationAndConstantLoader.m9533e(c11689n, nameResolver, typeTable, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? true : z4);
    }

    /* JADX INFO: renamed from: a */
    public final List<A> m9531a(ProtoContainer protoContainer, MemberSignature memberSignature, boolean z2, boolean z3, Boolean bool, boolean z4) {
        KotlinJvmBinaryClass kotlinJvmBinaryClassM9534g = m9534g(protoContainer, z2, z3, bool, z4);
        if (kotlinJvmBinaryClassM9534g == null) {
            kotlinJvmBinaryClassM9534g = protoContainer instanceof ProtoContainer.a ? m9537j((ProtoContainer.a) protoContainer) : null;
        }
        if (kotlinJvmBinaryClassM9534g == null) {
            return Collections2.emptyList();
        }
        List<A> list = ((b) ((LockBasedStorageManager.m) this.f23534b).invoke(kotlinJvmBinaryClassM9534g)).getMemberAnnotations().get(memberSignature);
        return list == null ? Collections2.emptyList() : list;
    }

    /* JADX INFO: renamed from: c */
    public final MemberSignature m9532c(MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean z2) {
        if (messageLite instanceof C11679d) {
            MemberSignature.a aVar = MemberSignature.f23633a;
            JvmMemberSignature.b jvmConstructorSignature = JvmProtoBufUtil.f23720a.getJvmConstructorSignature((C11679d) messageLite, nameResolver, typeTable);
            if (jvmConstructorSignature == null) {
                return null;
            }
            return aVar.fromJvmMemberSignature(jvmConstructorSignature);
        }
        if (messageLite instanceof C11684i) {
            MemberSignature.a aVar2 = MemberSignature.f23633a;
            JvmMemberSignature.b jvmMethodSignature = JvmProtoBufUtil.f23720a.getJvmMethodSignature((C11684i) messageLite, nameResolver, typeTable);
            if (jvmMethodSignature == null) {
                return null;
            }
            return aVar2.fromJvmMemberSignature(jvmMethodSignature);
        }
        if (!(messageLite instanceof C11689n)) {
            return null;
        }
        GeneratedMessageLite.f<C11689n, JvmProtoBuf.d> fVar = JvmProtoBuf.f23654d;
        Intrinsics3.checkNotNullExpressionValue(fVar, "propertySignature");
        JvmProtoBuf.d dVar = (JvmProtoBuf.d) ProtoBufUtil.getExtensionOrNull((GeneratedMessageLite.d) messageLite, fVar);
        if (dVar == null) {
            return null;
        }
        int iOrdinal = annotatedCallableKind.ordinal();
        if (iOrdinal == 1) {
            return m9533e((C11689n) messageLite, nameResolver, typeTable, true, true, z2);
        }
        if (iOrdinal == 2) {
            if (!dVar.hasGetter()) {
                return null;
            }
            MemberSignature.a aVar3 = MemberSignature.f23633a;
            JvmProtoBuf.c getter = dVar.getGetter();
            Intrinsics3.checkNotNullExpressionValue(getter, "signature.getter");
            return aVar3.fromMethod(nameResolver, getter);
        }
        if (iOrdinal != 3 || !dVar.hasSetter()) {
            return null;
        }
        MemberSignature.a aVar4 = MemberSignature.f23633a;
        JvmProtoBuf.c setter = dVar.getSetter();
        Intrinsics3.checkNotNullExpressionValue(setter, "signature.setter");
        return aVar4.fromMethod(nameResolver, setter);
    }

    /* JADX INFO: renamed from: e */
    public final MemberSignature m9533e(C11689n c11689n, NameResolver nameResolver, TypeTable typeTable, boolean z2, boolean z3, boolean z4) {
        GeneratedMessageLite.f<C11689n, JvmProtoBuf.d> fVar = JvmProtoBuf.f23654d;
        Intrinsics3.checkNotNullExpressionValue(fVar, "propertySignature");
        JvmProtoBuf.d dVar = (JvmProtoBuf.d) ProtoBufUtil.getExtensionOrNull(c11689n, fVar);
        if (dVar == null) {
            return null;
        }
        if (z2) {
            JvmMemberSignature.a jvmFieldSignature = JvmProtoBufUtil.f23720a.getJvmFieldSignature(c11689n, nameResolver, typeTable, z4);
            if (jvmFieldSignature == null) {
                return null;
            }
            return MemberSignature.f23633a.fromJvmMemberSignature(jvmFieldSignature);
        }
        if (!z3 || !dVar.hasSyntheticMethod()) {
            return null;
        }
        MemberSignature.a aVar = MemberSignature.f23633a;
        JvmProtoBuf.c syntheticMethod = dVar.getSyntheticMethod();
        Intrinsics3.checkNotNullExpressionValue(syntheticMethod, "signature.syntheticMethod");
        return aVar.fromMethod(nameResolver, syntheticMethod);
    }

    /* JADX INFO: renamed from: g */
    public final KotlinJvmBinaryClass m9534g(ProtoContainer protoContainer, boolean z2, boolean z3, Boolean bool, boolean z4) {
        ProtoContainer.a outerClass;
        C11678c.c cVar = C11678c.c.INTERFACE;
        if (z2) {
            if (bool == null) {
                throw new IllegalStateException(("isConst should not be null for property (container=" + protoContainer + ')').toString());
            }
            if (protoContainer instanceof ProtoContainer.a) {
                ProtoContainer.a aVar = (ProtoContainer.a) protoContainer;
                if (aVar.getKind() == cVar) {
                    KotlinClassFinder kotlinClassFinder = this.f23533a;
                    ClassId classIdCreateNestedClassId = aVar.getClassId().createNestedClassId(Name.identifier("DefaultImpls"));
                    Intrinsics3.checkNotNullExpressionValue(classIdCreateNestedClassId, "container.classId.createNestedClassId(Name.identifier(JvmAbi.DEFAULT_IMPLS_CLASS_NAME))");
                    return KotlinClassFinder2.findKotlinClass(kotlinClassFinder, classIdCreateNestedClassId);
                }
            }
            if (bool.booleanValue() && (protoContainer instanceof ProtoContainer.b)) {
                SourceElement source = protoContainer.getSource();
                JvmPackagePartSource jvmPackagePartSource = source instanceof JvmPackagePartSource ? (JvmPackagePartSource) source : null;
                JvmClassName facadeClassName = jvmPackagePartSource == null ? null : jvmPackagePartSource.getFacadeClassName();
                if (facadeClassName != null) {
                    KotlinClassFinder kotlinClassFinder2 = this.f23533a;
                    String internalName = facadeClassName.getInternalName();
                    Intrinsics3.checkNotNullExpressionValue(internalName, "facadeClassName.internalName");
                    ClassId classId = ClassId.topLevel(new FqName(StringsJVM.replace$default(internalName, MentionUtils.SLASH_CHAR, '.', false, 4, (Object) null)));
                    Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(FqName(facadeClassName.internalName.replace('/', '.')))");
                    return KotlinClassFinder2.findKotlinClass(kotlinClassFinder2, classId);
                }
            }
        }
        if (z3 && (protoContainer instanceof ProtoContainer.a)) {
            ProtoContainer.a aVar2 = (ProtoContainer.a) protoContainer;
            if (aVar2.getKind() == C11678c.c.COMPANION_OBJECT && (outerClass = aVar2.getOuterClass()) != null && (outerClass.getKind() == C11678c.c.CLASS || outerClass.getKind() == C11678c.c.ENUM_CLASS || (z4 && (outerClass.getKind() == cVar || outerClass.getKind() == C11678c.c.ANNOTATION_CLASS)))) {
                return m9537j(outerClass);
            }
        }
        if (!(protoContainer instanceof ProtoContainer.b) || !(protoContainer.getSource() instanceof JvmPackagePartSource)) {
            return null;
        }
        SourceElement source2 = protoContainer.getSource();
        Objects.requireNonNull(source2, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        JvmPackagePartSource jvmPackagePartSource2 = (JvmPackagePartSource) source2;
        KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource2.getKnownJvmBinaryClass();
        return knownJvmBinaryClass == null ? KotlinClassFinder2.findKotlinClass(this.f23533a, jvmPackagePartSource2.getClassId()) : knownJvmBinaryClass;
    }

    /* JADX INFO: renamed from: h */
    public abstract KotlinJvmBinaryClass.a mo9535h(ClassId classId, SourceElement sourceElement, List<A> list);

    /* JADX INFO: renamed from: i */
    public final List<A> m9536i(ProtoContainer protoContainer, C11689n c11689n, a aVar) {
        Boolean bool = Flags2.f24055z.get(c11689n.getFlags());
        Intrinsics3.checkNotNullExpressionValue(bool, "IS_CONST.get(proto.flags)");
        boolean zBooleanValue = bool.booleanValue();
        JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.f23720a;
        boolean zIsMovedFromInterfaceCompanion = JvmProtoBufUtil.isMovedFromInterfaceCompanion(c11689n);
        if (aVar == a.PROPERTY) {
            MemberSignature memberSignatureM9530f = m9530f(this, c11689n, protoContainer.getNameResolver(), protoContainer.getTypeTable(), false, true, false, 40, null);
            return memberSignatureM9530f == null ? Collections2.emptyList() : m9528b(this, protoContainer, memberSignatureM9530f, true, false, Boolean.valueOf(zBooleanValue), zIsMovedFromInterfaceCompanion, 8, null);
        }
        MemberSignature memberSignatureM9530f2 = m9530f(this, c11689n, protoContainer.getNameResolver(), protoContainer.getTypeTable(), true, false, false, 48, null);
        if (memberSignatureM9530f2 == null) {
            return Collections2.emptyList();
        }
        return Strings4.contains$default((CharSequence) memberSignatureM9530f2.getSignature(), (CharSequence) "$delegate", false, 2, (Object) null) != (aVar == a.DELEGATE_FIELD) ? Collections2.emptyList() : m9531a(protoContainer, memberSignatureM9530f2, true, true, Boolean.valueOf(zBooleanValue), zIsMovedFromInterfaceCompanion);
    }

    /* JADX INFO: renamed from: j */
    public final KotlinJvmBinaryClass m9537j(ProtoContainer.a aVar) {
        SourceElement source = aVar.getSource();
        KotlinJvmBinarySourceElement kotlinJvmBinarySourceElement = source instanceof KotlinJvmBinarySourceElement ? (KotlinJvmBinarySourceElement) source : null;
        if (kotlinJvmBinarySourceElement == null) {
            return null;
        }
        return kotlinJvmBinarySourceElement.getBinaryClass();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<A> loadCallableAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(messageLite, "proto");
        Intrinsics3.checkNotNullParameter(annotatedCallableKind, "kind");
        if (annotatedCallableKind == AnnotatedCallableKind.PROPERTY) {
            return m9536i(protoContainer, (C11689n) messageLite, a.PROPERTY);
        }
        MemberSignature memberSignatureM9529d = m9529d(this, messageLite, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, false, 16, null);
        return memberSignatureM9529d == null ? Collections2.emptyList() : m9528b(this, protoContainer, memberSignatureM9529d, false, false, null, false, 60, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<A> loadClassAnnotations(ProtoContainer.a aVar) {
        Intrinsics3.checkNotNullParameter(aVar, "container");
        KotlinJvmBinaryClass kotlinJvmBinaryClassM9537j = m9537j(aVar);
        if (kotlinJvmBinaryClassM9537j == null) {
            throw new IllegalStateException(Intrinsics3.stringPlus("Class for loading annotations is not found: ", aVar.debugFqName()).toString());
        }
        ArrayList arrayList = new ArrayList(1);
        c cVar = new c(this, arrayList);
        Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClassM9537j, "kotlinClass");
        kotlinJvmBinaryClassM9537j.loadClassAnnotations(cVar, null);
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<A> loadEnumEntryAnnotations(ProtoContainer protoContainer, C11682g c11682g) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(c11682g, "proto");
        MemberSignature.a aVar = MemberSignature.f23633a;
        String string = protoContainer.getNameResolver().getString(c11682g.getName());
        ClassMapperLite classMapperLite = ClassMapperLite.f23700a;
        String strAsString = ((ProtoContainer.a) protoContainer).getClassId().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "container as ProtoContainer.Class).classId.asString()");
        return m9528b(this, protoContainer, aVar.fromFieldNameAndDesc(string, ClassMapperLite.mapClass(strAsString)), false, false, null, false, 60, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(messageLite, "proto");
        Intrinsics3.checkNotNullParameter(annotatedCallableKind, "kind");
        MemberSignature memberSignatureM9529d = m9529d(this, messageLite, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, false, 16, null);
        return memberSignatureM9529d != null ? m9528b(this, protoContainer, MemberSignature.f23633a.fromMethodSignatureAndParameterIndex(memberSignatureM9529d, 0), false, false, null, false, 60, null) : Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<A> loadPropertyBackingFieldAnnotations(ProtoContainer protoContainer, C11689n c11689n) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(c11689n, "proto");
        return m9536i(protoContainer, c11689n, a.BACKING_FIELD);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public C loadPropertyConstant(ProtoContainer protoContainer, C11689n c11689n, KotlinType kotlinType) {
        C c2;
        AbstractC11810b0 c11834z;
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(c11689n, "proto");
        Intrinsics3.checkNotNullParameter(kotlinType, "expectedType");
        Boolean bool = Flags2.f24055z.get(c11689n.getFlags());
        JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.f23720a;
        KotlinJvmBinaryClass kotlinJvmBinaryClassM9534g = m9534g(protoContainer, true, true, bool, JvmProtoBufUtil.isMovedFromInterfaceCompanion(c11689n));
        if (kotlinJvmBinaryClassM9534g == null) {
            kotlinJvmBinaryClassM9534g = protoContainer instanceof ProtoContainer.a ? m9537j((ProtoContainer.a) protoContainer) : null;
        }
        if (kotlinJvmBinaryClassM9534g == null) {
            return null;
        }
        MemberSignature memberSignatureM9532c = m9532c(c11689n, protoContainer.getNameResolver(), protoContainer.getTypeTable(), AnnotatedCallableKind.PROPERTY, kotlinJvmBinaryClassM9534g.getClassHeader().getMetadataVersion().isAtLeast(DeserializedDescriptorResolver.f23603a.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm()));
        if (memberSignatureM9532c == null || (c2 = ((b) ((LockBasedStorageManager.m) this.f23534b).invoke(kotlinJvmBinaryClassM9534g)).getPropertyConstants().get(memberSignatureM9532c)) == 0) {
            return null;
        }
        UnsignedType3 unsignedType3 = UnsignedType3.f22584a;
        if (!UnsignedType3.isUnsignedType(kotlinType)) {
            return c2;
        }
        C c3 = (C) ((AbstractC11815g) c2);
        Intrinsics3.checkNotNullParameter(c3, "constant");
        if (c3 instanceof C11812d) {
            c11834z = new C11832x(((C11812d) c3).getValue().byteValue());
        } else if (c3 instanceof C11830v) {
            c11834z = new C11808a0(((C11830v) c3).getValue().shortValue());
        } else if (c3 instanceof C11821m) {
            c11834z = new C11833y(((C11821m) c3).getValue().intValue());
        } else {
            if (!(c3 instanceof C11827s)) {
                return c3;
            }
            c11834z = new C11834z(((C11827s) c3).getValue().longValue());
        }
        return (C) c11834z;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer protoContainer, C11689n c11689n) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(c11689n, "proto");
        return m9536i(protoContainer, c11689n, a.DELEGATE_FIELD);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<A> loadTypeAnnotations(C11692q c11692q, NameResolver nameResolver) {
        Intrinsics3.checkNotNullParameter(c11692q, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Object extension = c11692q.getExtension(JvmProtoBuf.f23656f);
        Intrinsics3.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<C11677b> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(iterable, 10));
        for (C11677b c11677b : iterable) {
            Intrinsics3.checkNotNullExpressionValue(c11677b, "it");
            Intrinsics3.checkNotNullParameter(c11677b, "proto");
            Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
            arrayList.add(((BinaryClassAnnotationAndConstantLoaderImpl) this).f23587e.deserializeAnnotation(c11677b, nameResolver));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    public List<A> loadTypeParameterAnnotations(C11694s c11694s, NameResolver nameResolver) {
        Intrinsics3.checkNotNullParameter(c11694s, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Object extension = c11694s.getExtension(JvmProtoBuf.f23658h);
        Intrinsics3.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.typeParameterAnnotation)");
        Iterable<C11677b> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(iterable, 10));
        for (C11677b c11677b : iterable) {
            Intrinsics3.checkNotNullExpressionValue(c11677b, "it");
            Intrinsics3.checkNotNullParameter(c11677b, "proto");
            Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
            arrayList.add(((BinaryClassAnnotationAndConstantLoaderImpl) this).f23587e.deserializeAnnotation(c11677b, nameResolver));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<A> loadValueParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, C11696u c11696u) {
        Intrinsics3.checkNotNullParameter(protoContainer, "container");
        Intrinsics3.checkNotNullParameter(messageLite, "callableProto");
        Intrinsics3.checkNotNullParameter(annotatedCallableKind, "kind");
        Intrinsics3.checkNotNullParameter(c11696u, "proto");
        MemberSignature memberSignatureM9529d = m9529d(this, messageLite, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, false, 16, null);
        if (memberSignatureM9529d == null) {
            return Collections2.emptyList();
        }
        int i2 = 1;
        if (messageLite instanceof C11684i) {
            if (!protoTypeTableUtil.hasReceiver((C11684i) messageLite)) {
                i2 = 0;
            }
        } else if (messageLite instanceof C11689n) {
            if (!protoTypeTableUtil.hasReceiver((C11689n) messageLite)) {
            }
        } else {
            if (!(messageLite instanceof C11679d)) {
                throw new UnsupportedOperationException(Intrinsics3.stringPlus("Unsupported message: ", messageLite.getClass()));
            }
            ProtoContainer.a aVar = (ProtoContainer.a) protoContainer;
            if (aVar.getKind() == C11678c.c.ENUM_CLASS) {
                i2 = 2;
            } else if (!aVar.isInner()) {
            }
        }
        return m9528b(this, protoContainer, MemberSignature.f23633a.fromMethodSignatureAndParameterIndex(memberSignatureM9529d, i + i2), false, false, null, false, 60, null);
    }
}
