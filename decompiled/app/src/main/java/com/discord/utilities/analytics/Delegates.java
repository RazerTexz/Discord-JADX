package com.discord.utilities.analytics;

import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import d0.b0.ObservableProperty;
import d0.g0.Charsets2;
import d0.z.d.Intrinsics3;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Objects;
import kotlin.reflect.KProperty;

/* compiled from: Delegates.kt */
/* renamed from: com.discord.utilities.analytics.AnalyticSuperProperties$$special$$inlined$observable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class Delegates extends ObservableProperty<Map<String, ? extends Object>> {
    public final /* synthetic */ Object $initialValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Delegates(Object obj, Object obj2) {
        super(obj2);
        this.$initialValue = obj;
    }

    @Override // d0.b0.ObservableProperty
    public void afterChange(KProperty<?> property, Map<String, ? extends Object> oldValue, Map<String, ? extends Object> newValue) throws JsonIOException {
        Intrinsics3.checkNotNullParameter(property, "property");
        AnalyticSuperProperties analyticSuperProperties = AnalyticSuperProperties.INSTANCE;
        String strM = new Gson().m(newValue);
        if (strM == null) {
            strM = "{}";
        }
        AnalyticSuperProperties.access$setSuperPropertiesString$p(analyticSuperProperties, strM);
        String superPropertiesString = analyticSuperProperties.getSuperPropertiesString();
        Charset charset = Charsets2.a;
        Objects.requireNonNull(superPropertiesString, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = superPropertiesString.getBytes(charset);
        Intrinsics3.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        Intrinsics3.checkNotNullExpressionValue(strEncodeToString, "Base64.encodeToString(su…eArray(), Base64.NO_WRAP)");
        AnalyticSuperProperties.access$setSuperPropertiesStringBase64$p(analyticSuperProperties, strEncodeToString);
    }
}
