package p600f0;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Challenge.kt */
/* renamed from: f0.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class Challenge {

    /* renamed from: a */
    public final Map<String, String> f25907a;

    /* renamed from: b */
    public final String f25908b;

    public Challenge(String str, Map<String, String> map) {
        String lowerCase;
        Intrinsics3.checkParameterIsNotNull(str, "scheme");
        Intrinsics3.checkParameterIsNotNull(map, "authParams");
        this.f25908b = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale locale = Locale.US;
                Intrinsics3.checkExpressionValueIsNotNull(locale, "US");
                lowerCase = key.toLowerCase(locale);
                Intrinsics3.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            linkedHashMap.put(lowerCase, value);
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics3.checkExpressionValueIsNotNull(mapUnmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.f25907a = mapUnmodifiableMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (Intrinsics3.areEqual(challenge.f25908b, this.f25908b) && Intrinsics3.areEqual(challenge.f25907a, this.f25907a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f25907a.hashCode() + outline.m863m(this.f25908b, 899, 31);
    }

    public String toString() {
        return this.f25908b + " authParams=" + this.f25907a;
    }
}
