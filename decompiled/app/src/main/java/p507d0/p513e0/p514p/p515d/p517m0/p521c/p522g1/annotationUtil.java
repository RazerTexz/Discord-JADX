package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import kotlin.jvm.functions.Function1;
import p507d0.Tuples;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11807a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11809b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11818j;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11831w;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p580t.Collections2;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.f, reason: use source file name */
/* JADX INFO: compiled from: annotationUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class annotationUtil {

    /* JADX INFO: renamed from: a */
    public static final Name f22730a;

    /* JADX INFO: renamed from: b */
    public static final Name f22731b;

    /* JADX INFO: renamed from: c */
    public static final Name f22732c;

    /* JADX INFO: renamed from: d */
    public static final Name f22733d;

    /* JADX INFO: renamed from: e */
    public static final Name f22734e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.f$a */
    /* JADX INFO: compiled from: annotationUtil.kt */
    public static final class a extends Lambda implements Function1<ModuleDescriptor2, KotlinType> {
        public final /* synthetic */ KotlinBuiltIns $this_createDeprecatedAnnotation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(KotlinBuiltIns kotlinBuiltIns) {
            super(1);
            this.$this_createDeprecatedAnnotation = kotlinBuiltIns;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ KotlinType invoke(ModuleDescriptor2 moduleDescriptor2) {
            return invoke2(moduleDescriptor2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final KotlinType invoke2(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
            KotlinType4 arrayType = moduleDescriptor2.getBuiltIns().getArrayType(Variance.INVARIANT, this.$this_createDeprecatedAnnotation.getStringType());
            Intrinsics3.checkNotNullExpressionValue(arrayType, "module.builtIns.getArrayType(Variance.INVARIANT, stringType)");
            return arrayType;
        }
    }

    static {
        Name nameIdentifier = Name.identifier("message");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(\"message\")");
        f22730a = nameIdentifier;
        Name nameIdentifier2 = Name.identifier("replaceWith");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier2, "identifier(\"replaceWith\")");
        f22731b = nameIdentifier2;
        Name nameIdentifier3 = Name.identifier("level");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier3, "identifier(\"level\")");
        f22732c = nameIdentifier3;
        Name nameIdentifier4 = Name.identifier("expression");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier4, "identifier(\"expression\")");
        f22733d = nameIdentifier4;
        Name nameIdentifier5 = Name.identifier("imports");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier5, "identifier(\"imports\")");
        f22734e = nameIdentifier5;
    }

    public static final AnnotationDescriptor createDeprecatedAnnotation(KotlinBuiltIns kotlinBuiltIns, String str, String str2, String str3) {
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "<this>");
        Intrinsics3.checkNotNullParameter(str, "message");
        Intrinsics3.checkNotNullParameter(str2, "replaceWith");
        Intrinsics3.checkNotNullParameter(str3, "level");
        BuiltInAnnotationDescriptor builtInAnnotationDescriptor = new BuiltInAnnotationDescriptor(kotlinBuiltIns, StandardNames.a.f22568w, Maps6.mapOf(Tuples.m10073to(f22733d, new C11831w(str2)), Tuples.m10073to(f22734e, new C11809b(Collections2.emptyList(), new a(kotlinBuiltIns)))));
        FqName fqName = StandardNames.a.f22566u;
        Name name = f22732c;
        ClassId classId = ClassId.topLevel(StandardNames.a.f22567v);
        Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.deprecationLevel)");
        Name nameIdentifier = Name.identifier(str3);
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(level)");
        return new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, Maps6.mapOf(Tuples.m10073to(f22730a, new C11831w(str)), Tuples.m10073to(f22731b, new C11807a(builtInAnnotationDescriptor)), Tuples.m10073to(name, new C11818j(classId, nameIdentifier))));
    }

    public static /* synthetic */ AnnotationDescriptor createDeprecatedAnnotation$default(KotlinBuiltIns kotlinBuiltIns, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "WARNING";
        }
        return createDeprecatedAnnotation(kotlinBuiltIns, str, str2, str3);
    }
}
