package com.discord.models.deserialization.gson;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.Model;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonReader;
import p007b.p008a.p017b.TypeAdapterRegistrar;
import p007b.p225i.p408d.FieldNamingPolicy;
import p007b.p225i.p408d.GsonBuilder;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: InboundGatewayGsonParser.kt */
/* loaded from: classes.dex */
public final class InboundGatewayGsonParser {
    public static final InboundGatewayGsonParser INSTANCE = new InboundGatewayGsonParser();
    private static final Gson gatewayGsonInstance;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.f13095a = gsonBuilder.f13095a.m9222j(8);
        gsonBuilder.f13097c = FieldNamingPolicy.f13091m;
        Intrinsics3.checkNotNullExpressionValue(gsonBuilder, "GsonBuilder()\n          …ER_CASE_WITH_UNDERSCORES)");
        TypeAdapterRegistrar.m147a(gsonBuilder);
        gatewayGsonInstance = gsonBuilder.m6851a();
    }

    private InboundGatewayGsonParser() {
    }

    public static final <T> T fromJson(Model.JsonReader reader, Class<T> clazz) {
        Intrinsics3.checkNotNullParameter(reader, "reader");
        Intrinsics3.checkNotNullParameter(clazz, "clazz");
        JsonReader jsonReader = reader.f18559in;
        Intrinsics3.checkNotNullExpressionValue(jsonReader, "reader.`in`");
        return (T) fromJson(jsonReader, clazz);
    }

    public static final <T> String toJson(T source) throws JsonIOException {
        String strM9209m = gatewayGsonInstance.m9209m(source);
        Intrinsics3.checkNotNullExpressionValue(strM9209m, "gatewayGsonInstance.toJson(source)");
        return strM9209m;
    }

    public final Gson getGatewayGsonInstance() {
        return gatewayGsonInstance;
    }

    public static final <T> T fromJson(JsonReader reader, Class<T> clazz) {
        Intrinsics3.checkNotNullParameter(reader, "reader");
        Intrinsics3.checkNotNullParameter(clazz, "clazz");
        return (T) gatewayGsonInstance.m9200d(reader, clazz);
    }
}
