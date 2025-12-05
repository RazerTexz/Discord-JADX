package p507d0.p513e0.p514p.p515d.p517m0.p576p;

import com.discord.widgets.chat.input.MentionUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: JavaTypeEnhancementState.kt */
/* renamed from: d0.e0.p.d.m0.p.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class JavaTypeEnhancementState {

    /* renamed from: a */
    public static final JavaTypeEnhancementState2 f24981a;

    /* renamed from: b */
    public static final JavaTypeEnhancementState f24982b;

    /* renamed from: c */
    public final JavaTypeEnhancementState2 f24983c;

    /* renamed from: d */
    public final JavaTypeEnhancementState2 f24984d;

    /* renamed from: e */
    public final Map<String, JavaTypeEnhancementState2> f24985e;

    /* renamed from: f */
    public final boolean f24986f;

    /* renamed from: g */
    public final JavaTypeEnhancementState2 f24987g;

    /* renamed from: h */
    public final Lazy f24988h;

    /* renamed from: i */
    public final boolean f24989i;

    /* renamed from: j */
    public final boolean f24990j;

    /* compiled from: JavaTypeEnhancementState.kt */
    /* renamed from: d0.e0.p.d.m0.p.e$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: JavaTypeEnhancementState.kt */
    /* renamed from: d0.e0.p.d.m0.p.e$b */
    public static final class b extends Lambda implements Function0<String[]> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String[] invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String[] invoke2() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(JavaTypeEnhancementState.this.getGlobalJsr305Level().getDescription());
            JavaTypeEnhancementState2 migrationLevelForJsr305 = JavaTypeEnhancementState.this.getMigrationLevelForJsr305();
            if (migrationLevelForJsr305 != null) {
                arrayList.add(Intrinsics3.stringPlus("under-migration:", migrationLevelForJsr305.getDescription()));
            }
            for (Map.Entry<String, JavaTypeEnhancementState2> entry : JavaTypeEnhancementState.this.getUserDefinedLevelForSpecificJsr305Annotation().entrySet()) {
                StringBuilder sbM829Q = outline.m829Q(MentionUtils.MENTIONS_CHAR);
                sbM829Q.append(entry.getKey());
                sbM829Q.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
                sbM829Q.append(entry.getValue().getDescription());
                arrayList.add(sbM829Q.toString());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (String[]) array;
        }
    }

    static {
        new a(null);
        JavaTypeEnhancementState2 javaTypeEnhancementState2 = JavaTypeEnhancementState2.WARN;
        f24981a = javaTypeEnhancementState2;
        new JavaTypeEnhancementState(javaTypeEnhancementState2, null, Maps6.emptyMap(), false, null, 24, null);
        JavaTypeEnhancementState2 javaTypeEnhancementState22 = JavaTypeEnhancementState2.IGNORE;
        f24982b = new JavaTypeEnhancementState(javaTypeEnhancementState22, javaTypeEnhancementState22, Maps6.emptyMap(), false, null, 24, null);
        JavaTypeEnhancementState2 javaTypeEnhancementState23 = JavaTypeEnhancementState2.STRICT;
        new JavaTypeEnhancementState(javaTypeEnhancementState23, javaTypeEnhancementState23, Maps6.emptyMap(), false, null, 24, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeEnhancementState(JavaTypeEnhancementState2 javaTypeEnhancementState2, JavaTypeEnhancementState2 javaTypeEnhancementState22, Map<String, ? extends JavaTypeEnhancementState2> map, boolean z2, JavaTypeEnhancementState2 javaTypeEnhancementState23) {
        Intrinsics3.checkNotNullParameter(javaTypeEnhancementState2, "globalJsr305Level");
        Intrinsics3.checkNotNullParameter(map, "userDefinedLevelForSpecificJsr305Annotation");
        Intrinsics3.checkNotNullParameter(javaTypeEnhancementState23, "jspecifyReportLevel");
        this.f24983c = javaTypeEnhancementState2;
        this.f24984d = javaTypeEnhancementState22;
        this.f24985e = map;
        this.f24986f = z2;
        this.f24987g = javaTypeEnhancementState23;
        this.f24988h = LazyJVM.lazy(new b());
        JavaTypeEnhancementState2 javaTypeEnhancementState24 = JavaTypeEnhancementState2.IGNORE;
        boolean z3 = true;
        boolean z4 = javaTypeEnhancementState2 == javaTypeEnhancementState24 && javaTypeEnhancementState22 == javaTypeEnhancementState24 && map.isEmpty();
        this.f24989i = z4;
        if (!z4 && javaTypeEnhancementState23 != javaTypeEnhancementState24) {
            z3 = false;
        }
        this.f24990j = z3;
    }

    public final boolean getDisabledDefaultAnnotations() {
        return this.f24990j;
    }

    public final boolean getDisabledJsr305() {
        return this.f24989i;
    }

    public final boolean getEnableCompatqualCheckerFrameworkAnnotations() {
        return this.f24986f;
    }

    public final JavaTypeEnhancementState2 getGlobalJsr305Level() {
        return this.f24983c;
    }

    public final JavaTypeEnhancementState2 getJspecifyReportLevel() {
        return this.f24987g;
    }

    public final JavaTypeEnhancementState2 getMigrationLevelForJsr305() {
        return this.f24984d;
    }

    public final Map<String, JavaTypeEnhancementState2> getUserDefinedLevelForSpecificJsr305Annotation() {
        return this.f24985e;
    }

    public /* synthetic */ JavaTypeEnhancementState(JavaTypeEnhancementState2 javaTypeEnhancementState2, JavaTypeEnhancementState2 javaTypeEnhancementState22, Map map, boolean z2, JavaTypeEnhancementState2 javaTypeEnhancementState23, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(javaTypeEnhancementState2, javaTypeEnhancementState22, map, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? f24981a : javaTypeEnhancementState23);
    }
}
