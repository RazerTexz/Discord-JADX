package com.discord.api.auth;

import com.discord.api.auth.OAuthScope;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.KClass;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: OAuthScopeTypeAdapter.kt */
/* loaded from: classes.dex */
public final class OAuthScopeTypeAdapter extends TypeAdapter<OAuthScope> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<String, OAuthScope> nameToScopeMap;

    /* compiled from: OAuthScopeTypeAdapter.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        HashMap<String, OAuthScope> map = new HashMap<>();
        for (KClass kClass : Reflection2.getOrCreateKotlinClass(OAuthScope.class).getSealedSubclasses()) {
            if (kClass.getObjectInstance() != null) {
                Object objectInstance = kClass.getObjectInstance();
                Objects.requireNonNull(objectInstance, "null cannot be cast to non-null type com.discord.api.auth.OAuthScope");
                OAuthScope oAuthScope = (OAuthScope) objectInstance;
                map.put(oAuthScope.getScopeName(), oAuthScope);
            }
        }
        nameToScopeMap = map;
    }

    /* renamed from: a */
    public static final /* synthetic */ HashMap m7584a() {
        return nameToScopeMap;
    }

    @Override // com.google.gson.TypeAdapter
    public OAuthScope read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        if (jsonReader.mo6878N() == JsonToken.NULL) {
            jsonReader.mo6876H();
            return null;
        }
        String strMo6877J = jsonReader.mo6877J();
        OAuthScope invalid = nameToScopeMap.get(strMo6877J);
        if (invalid == null) {
            Intrinsics3.checkNotNullExpressionValue(strMo6877J, "scopeName");
            invalid = new OAuthScope.Invalid(strMo6877J);
        }
        return invalid;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, OAuthScope oAuthScope) throws IOException {
        OAuthScope oAuthScope2 = oAuthScope;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (oAuthScope2 != null) {
            jsonWriter.mo6895H(oAuthScope2.getScopeName());
        } else {
            jsonWriter.mo6905s();
        }
    }
}
