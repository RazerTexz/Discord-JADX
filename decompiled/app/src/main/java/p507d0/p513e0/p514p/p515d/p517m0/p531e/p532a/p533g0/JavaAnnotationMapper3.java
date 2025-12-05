package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.Tuples;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.KotlinRetention;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.KotlinTarget;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments5;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11809b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11818j;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t.MutableCollections;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: JavaAnnotationMapper.kt */
/* renamed from: d0.e0.p.d.m0.e.a.g0.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class JavaAnnotationMapper3 {

    /* renamed from: a */
    public static final JavaAnnotationMapper3 f23236a = new JavaAnnotationMapper3();

    /* renamed from: b */
    public static final Map<String, EnumSet<KotlinTarget>> f23237b = Maps6.mapOf(Tuples.m10073to("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), Tuples.m10073to("TYPE", EnumSet.of(KotlinTarget.CLASS, KotlinTarget.FILE)), Tuples.m10073to("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.ANNOTATION_CLASS)), Tuples.m10073to("TYPE_PARAMETER", EnumSet.of(KotlinTarget.TYPE_PARAMETER)), Tuples.m10073to("FIELD", EnumSet.of(KotlinTarget.FIELD)), Tuples.m10073to("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.LOCAL_VARIABLE)), Tuples.m10073to("PARAMETER", EnumSet.of(KotlinTarget.VALUE_PARAMETER)), Tuples.m10073to("CONSTRUCTOR", EnumSet.of(KotlinTarget.CONSTRUCTOR)), Tuples.m10073to("METHOD", EnumSet.of(KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER)), Tuples.m10073to("TYPE_USE", EnumSet.of(KotlinTarget.TYPE)));

    /* renamed from: c */
    public static final Map<String, KotlinRetention> f23238c = Maps6.mapOf(Tuples.m10073to("RUNTIME", KotlinRetention.RUNTIME), Tuples.m10073to("CLASS", KotlinRetention.BINARY), Tuples.m10073to("SOURCE", KotlinRetention.SOURCE));

    /* compiled from: JavaAnnotationMapper.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.g0.d$a */
    public static final class a extends Lambda implements Function1<ModuleDescriptor2, KotlinType> {

        /* renamed from: j */
        public static final a f23239j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ KotlinType invoke(ModuleDescriptor2 moduleDescriptor2) {
            return invoke2(moduleDescriptor2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final KotlinType invoke2(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
            ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(JavaAnnotationMapper2.f23230a.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), moduleDescriptor2.getBuiltIns().getBuiltInClassByFqName(StandardNames.a.f22504A));
            KotlinType type = annotationParameterByName == null ? null : annotationParameterByName.getType();
            if (type != null) {
                return type;
            }
            KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType("Error: AnnotationTarget[]");
            Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(\"Error: AnnotationTarget[]\")");
            return kotlinType4CreateErrorType;
        }
    }

    public final AbstractC11815g<?> mapJavaRetentionArgument$descriptors_jvm(annotationArguments annotationarguments) {
        annotationArguments5 annotationarguments5 = annotationarguments instanceof annotationArguments5 ? (annotationArguments5) annotationarguments : null;
        if (annotationarguments5 == null) {
            return null;
        }
        Map<String, KotlinRetention> map = f23238c;
        Name entryName = annotationarguments5.getEntryName();
        KotlinRetention kotlinRetention = map.get(entryName == null ? null : entryName.asString());
        if (kotlinRetention == null) {
            return null;
        }
        ClassId classId = ClassId.topLevel(StandardNames.a.f22506C);
        Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.annotationRetention)");
        Name nameIdentifier = Name.identifier(kotlinRetention.name());
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(retention.name)");
        return new C11818j(classId, nameIdentifier);
    }

    public final Set<KotlinTarget> mapJavaTargetArgumentByName(String str) {
        EnumSet<KotlinTarget> enumSet = f23237b.get(str);
        return enumSet == null ? Sets5.emptySet() : enumSet;
    }

    public final AbstractC11815g<?> mapJavaTargetArguments$descriptors_jvm(List<? extends annotationArguments> list) {
        Intrinsics3.checkNotNullParameter(list, "arguments");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof annotationArguments5) {
                arrayList.add(obj);
            }
        }
        ArrayList<KotlinTarget> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Name entryName = ((annotationArguments5) it.next()).getEntryName();
            MutableCollections.addAll(arrayList2, mapJavaTargetArgumentByName(entryName == null ? null : entryName.asString()));
        }
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList2, 10));
        for (KotlinTarget kotlinTarget : arrayList2) {
            ClassId classId = ClassId.topLevel(StandardNames.a.f22505B);
            Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.annotationTarget)");
            Name nameIdentifier = Name.identifier(kotlinTarget.name());
            Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(kotlinTarget.name)");
            arrayList3.add(new C11818j(classId, nameIdentifier));
        }
        return new C11809b(arrayList3, a.f23239j);
    }
}
