package com.discord.utilities.analytics;

import android.util.Base64;
import com.google.gson.Gson;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Objects;
import kotlin.reflect.KProperty;
import p507d0.p509b0.ObservableProperty;
import p507d0.p579g0.Charsets2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.analytics.AnalyticSuperProperties$$special$$inlined$observable$1, reason: use source file name */
/* JADX INFO: compiled from: Delegates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Delegates extends ObservableProperty<Map<String, ? extends Object>> {
    public final /* synthetic */ Object $initialValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Delegates(Object obj, Object obj2) {
        super(obj2);
        this.$initialValue = obj;
    }

    @Override // p507d0.p509b0.ObservableProperty
    public void afterChange(KProperty<?> property, Map<String, ? extends Object> oldValue, Map<String, ? extends Object> newValue) {
        Intrinsics3.checkNotNullParameter(property, "property");
        AnalyticSuperProperties analyticSuperProperties = AnalyticSuperProperties.INSTANCE;
        String strM9209m = new Gson().m9209m(newValue);
        if (strM9209m == null) {
            strM9209m = "{}";
        }
        AnalyticSuperProperties.access$setSuperPropertiesString$p(analyticSuperProperties, strM9209m);
        String superPropertiesString = analyticSuperProperties.getSuperPropertiesString();
        Charset charset = Charsets2.f25136a;
        Objects.requireNonNull(superPropertiesString, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = superPropertiesString.getBytes(charset);
        Intrinsics3.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        Intrinsics3.checkNotNullExpressionValue(strEncodeToString, "Base64.encodeToString(su…eArray(), Base64.NO_WRAP)");
        AnalyticSuperProperties.access$setSuperPropertiesStringBase64$p(analyticSuperProperties, strEncodeToString);
    }
}
