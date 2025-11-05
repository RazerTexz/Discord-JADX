package d0.e0.p.d.m0.p;

import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: JavaTypeEnhancementState.kt */
/* loaded from: classes3.dex */
public final class e {
    public static final h a;

    /* renamed from: b, reason: collision with root package name */
    public static final e f3563b;
    public final h c;
    public final h d;
    public final Map<String, h> e;
    public final boolean f;
    public final h g;
    public final Lazy h;
    public final boolean i;
    public final boolean j;

    /* compiled from: JavaTypeEnhancementState.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: JavaTypeEnhancementState.kt */
    public static final class b extends o implements Function0<String[]> {
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
            arrayList.add(e.this.getGlobalJsr305Level().getDescription());
            h migrationLevelForJsr305 = e.this.getMigrationLevelForJsr305();
            if (migrationLevelForJsr305 != null) {
                arrayList.add(m.stringPlus("under-migration:", migrationLevelForJsr305.getDescription()));
            }
            for (Map.Entry<String, h> entry : e.this.getUserDefinedLevelForSpecificJsr305Annotation().entrySet()) {
                StringBuilder sbQ = b.d.b.a.a.Q(MentionUtilsKt.MENTIONS_CHAR);
                sbQ.append(entry.getKey());
                sbQ.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                sbQ.append(entry.getValue().getDescription());
                arrayList.add(sbQ.toString());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (String[]) array;
        }
    }

    static {
        new a(null);
        h hVar = h.WARN;
        a = hVar;
        new e(hVar, null, h0.emptyMap(), false, null, 24, null);
        h hVar2 = h.IGNORE;
        f3563b = new e(hVar2, hVar2, h0.emptyMap(), false, null, 24, null);
        h hVar3 = h.STRICT;
        new e(hVar3, hVar3, h0.emptyMap(), false, null, 24, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(h hVar, h hVar2, Map<String, ? extends h> map, boolean z2, h hVar3) {
        m.checkNotNullParameter(hVar, "globalJsr305Level");
        m.checkNotNullParameter(map, "userDefinedLevelForSpecificJsr305Annotation");
        m.checkNotNullParameter(hVar3, "jspecifyReportLevel");
        this.c = hVar;
        this.d = hVar2;
        this.e = map;
        this.f = z2;
        this.g = hVar3;
        this.h = d0.g.lazy(new b());
        h hVar4 = h.IGNORE;
        boolean z3 = true;
        boolean z4 = hVar == hVar4 && hVar2 == hVar4 && map.isEmpty();
        this.i = z4;
        if (!z4 && hVar3 != hVar4) {
            z3 = false;
        }
        this.j = z3;
    }

    public final boolean getDisabledDefaultAnnotations() {
        return this.j;
    }

    public final boolean getDisabledJsr305() {
        return this.i;
    }

    public final boolean getEnableCompatqualCheckerFrameworkAnnotations() {
        return this.f;
    }

    public final h getGlobalJsr305Level() {
        return this.c;
    }

    public final h getJspecifyReportLevel() {
        return this.g;
    }

    public final h getMigrationLevelForJsr305() {
        return this.d;
    }

    public final Map<String, h> getUserDefinedLevelForSpecificJsr305Annotation() {
        return this.e;
    }

    public /* synthetic */ e(h hVar, h hVar2, Map map, boolean z2, h hVar3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(hVar, hVar2, map, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? a : hVar3);
    }
}
