package com.discord.api.auth;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Locale;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: RequiredAction.kt */
/* renamed from: com.discord.api.auth.RequiredActionTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class RequiredAction2 extends TypeAdapter<RequiredAction> {
    @Override // com.google.gson.TypeAdapter
    public RequiredAction read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        String strMo6877J = jsonReader.mo6877J();
        return (strMo6877J != null && strMo6877J.hashCode() == 509052241 && strMo6877J.equals("update_password")) ? RequiredAction.UPDATE_PASSWORD : RequiredAction.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, RequiredAction requiredAction) throws IOException {
        String lowerCase;
        String strName;
        RequiredAction requiredAction2 = requiredAction;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (requiredAction2 == null || (strName = requiredAction2.name()) == null) {
            lowerCase = null;
        } else {
            Locale locale = Locale.ROOT;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            lowerCase = strName.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        }
        jsonWriter.mo6895H(lowerCase);
    }
}
