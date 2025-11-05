package d0.e0.p.d.m0.p;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: JavaTypeEnhancementState.kt */
/* loaded from: classes3.dex */
public enum h {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");

    private final String description;

    /* compiled from: JavaTypeEnhancementState.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
    }

    h(String str) {
        this.description = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static h[] valuesCustom() {
        h[] hVarArrValuesCustom = values();
        h[] hVarArr = new h[hVarArrValuesCustom.length];
        System.arraycopy(hVarArrValuesCustom, 0, hVarArr, 0, hVarArrValuesCustom.length);
        return hVarArr;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean isIgnore() {
        return this == IGNORE;
    }

    public final boolean isWarning() {
        return this == WARN;
    }
}
