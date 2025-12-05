package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.Tuples;
import p507d0.p580t.Maps6;
import p507d0.p580t._Arrays;
import p507d0.p580t._Collections;

/* compiled from: KotlinTarget.kt */
/* renamed from: d0.e0.p.d.m0.c.g1.n, reason: use source file name */
/* loaded from: classes3.dex */
public enum KotlinTarget {
    CLASS("class", false, 2),
    ANNOTATION_CLASS("annotation class", false, 2),
    TYPE_PARAMETER("type parameter", false),
    PROPERTY("property", false, 2),
    FIELD("field", false, 2),
    LOCAL_VARIABLE("local variable", false, 2),
    VALUE_PARAMETER("value parameter", false, 2),
    CONSTRUCTOR("constructor", false, 2),
    FUNCTION("function", false, 2),
    PROPERTY_GETTER("getter", false, 2),
    PROPERTY_SETTER("setter", false, 2),
    TYPE("type usage", false),
    EXPRESSION("expression", false),
    FILE("file", false),
    TYPEALIAS("typealias", false),
    TYPE_PROJECTION("type projection", false),
    STAR_PROJECTION("star projection", false),
    PROPERTY_PARAMETER("property constructor parameter", false),
    CLASS_ONLY("class", false),
    OBJECT("object", false),
    COMPANION_OBJECT("companion object", false),
    INTERFACE("interface", false),
    ENUM_CLASS("enum class", false),
    ENUM_ENTRY("enum entry", false),
    LOCAL_CLASS("local class", false),
    LOCAL_FUNCTION("local function", false),
    MEMBER_FUNCTION("member function", false),
    TOP_LEVEL_FUNCTION("top level function", false),
    MEMBER_PROPERTY("member property", false),
    MEMBER_PROPERTY_WITH_BACKING_FIELD("member property with backing field", false),
    MEMBER_PROPERTY_WITH_DELEGATE("member property with delegate", false),
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("member property without backing field or delegate", false),
    TOP_LEVEL_PROPERTY("top level property", false),
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD("top level property with backing field", false),
    TOP_LEVEL_PROPERTY_WITH_DELEGATE("top level property with delegate", false),
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("top level property without backing field or delegate", false),
    INITIALIZER("initializer", false),
    DESTRUCTURING_DECLARATION("destructuring declaration", false),
    LAMBDA_EXPRESSION("lambda expression", false),
    ANONYMOUS_FUNCTION("anonymous function", false),
    OBJECT_LITERAL("object literal", false);


    /* renamed from: j */
    public static final HashMap<String, KotlinTarget> f22779j;

    /* renamed from: k */
    public static final Map<AnnotationUseSiteTarget, KotlinTarget> f22780k;
    private final String description;
    private final boolean isDefault;

    /* compiled from: KotlinTarget.kt */
    /* renamed from: d0.e0.p.d.m0.c.g1.n$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        f22779j = new HashMap<>();
        KotlinTarget[] kotlinTargetArrValuesCustom = valuesCustom();
        int i = 0;
        while (i < 41) {
            KotlinTarget kotlinTarget = kotlinTargetArrValuesCustom[i];
            i++;
            f22779j.put(kotlinTarget.name(), kotlinTarget);
        }
        KotlinTarget[] kotlinTargetArrValuesCustom2 = valuesCustom();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 41; i2++) {
            KotlinTarget kotlinTarget2 = kotlinTargetArrValuesCustom2[i2];
            if (kotlinTarget2.isDefault()) {
                arrayList.add(kotlinTarget2);
            }
        }
        _Collections.toSet(arrayList);
        _Arrays.toSet(valuesCustom());
        AnnotationUseSiteTarget annotationUseSiteTarget = AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER;
        KotlinTarget kotlinTarget3 = VALUE_PARAMETER;
        AnnotationUseSiteTarget annotationUseSiteTarget2 = AnnotationUseSiteTarget.FIELD;
        KotlinTarget kotlinTarget4 = FIELD;
        f22780k = Maps6.mapOf(Tuples.m10073to(annotationUseSiteTarget, kotlinTarget3), Tuples.m10073to(annotationUseSiteTarget2, kotlinTarget4), Tuples.m10073to(AnnotationUseSiteTarget.PROPERTY, PROPERTY), Tuples.m10073to(AnnotationUseSiteTarget.FILE, FILE), Tuples.m10073to(AnnotationUseSiteTarget.PROPERTY_GETTER, PROPERTY_GETTER), Tuples.m10073to(AnnotationUseSiteTarget.PROPERTY_SETTER, PROPERTY_SETTER), Tuples.m10073to(AnnotationUseSiteTarget.RECEIVER, kotlinTarget3), Tuples.m10073to(AnnotationUseSiteTarget.SETTER_PARAMETER, kotlinTarget3), Tuples.m10073to(AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, kotlinTarget4));
    }

    KotlinTarget(String str, boolean z2) {
        this.description = str;
        this.isDefault = z2;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static KotlinTarget[] valuesCustom() {
        KotlinTarget[] kotlinTargetArrValuesCustom = values();
        KotlinTarget[] kotlinTargetArr = new KotlinTarget[kotlinTargetArrValuesCustom.length];
        System.arraycopy(kotlinTargetArrValuesCustom, 0, kotlinTargetArr, 0, kotlinTargetArrValuesCustom.length);
        return kotlinTargetArr;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    KotlinTarget(String str, boolean z2, int i) {
        z2 = (i & 2) != 0 ? true : z2;
        this.description = str;
        this.isDefault = z2;
    }
}
