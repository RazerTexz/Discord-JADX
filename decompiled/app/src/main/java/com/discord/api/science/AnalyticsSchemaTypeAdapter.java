package com.discord.api.science;

import com.discord.api.science.Science;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Tuples2;
import p007b.p225i.p408d.FieldNamingPolicy;
import p007b.p225i.p408d.GsonBuilder;
import p007b.p225i.p408d.JsonSerializationContext;
import p007b.p225i.p408d.JsonSerializer2;
import p007b.p225i.p408d.p410q.p411x.JsonTreeWriter;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Maps6;
import p507d0.p580t.MutableCollections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: AnalyticsSchemaTypeAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnalyticsSchemaTypeAdapter implements JsonSerializer2<Science.Event.SchemaObject> {
    private final Gson gson;

    public AnalyticsSchemaTypeAdapter() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.f13097c = FieldNamingPolicy.f13091m;
        this.gson = gsonBuilder.m6851a();
    }

    /* JADX INFO: renamed from: a */
    public final List<Tuples2<String, Object>> m8214a(Map<String, ? extends Object> map) {
        List<Tuples2<String, Object>> listListOf;
        Intrinsics3.checkNotNullParameter(map, "$this$flatMapProperties");
        Set<Map.Entry<String, ? extends Object>> setEntrySet = map.entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object value = entry.getValue();
            if (!(value instanceof Map)) {
                value = null;
            }
            Map<String, ? extends Object> map2 = (Map) value;
            if (map2 == null || (listListOf = m8214a(map2)) == null) {
                listListOf = CollectionsJVM.listOf(new Tuples2(entry.getKey(), entry.getValue()));
            }
            MutableCollections.addAll(arrayList, listListOf);
        }
        return arrayList;
    }

    @Override // p007b.p225i.p408d.JsonSerializer2
    public JsonElement serialize(Science.Event.SchemaObject schemaObject, Type type, JsonSerializationContext jsonSerializationContext) {
        Science.Event.SchemaObject schemaObject2 = schemaObject;
        Intrinsics3.checkNotNullParameter(schemaObject2, "src");
        Intrinsics3.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics3.checkNotNullParameter(jsonSerializationContext, "context");
        Gson gson = this.gson;
        String type2 = schemaObject2.getType();
        AnalyticsSchema schema = schemaObject2.getSchema();
        Intrinsics3.checkNotNullParameter(schema, "$this$serializeToMap");
        Object objM9203g = this.gson.m9203g(this.gson.m9209m(schema), new AnalyticsSchemaTypeAdapter2().getType());
        Intrinsics3.checkNotNullExpressionValue(objM9203g, "gson.fromJson(json, obje…<String, Any>>() {}.type)");
        Science.Event.MapObject mapObject = new Science.Event.MapObject(type2, Maps6.toMap(m8214a((Map) objM9203g)));
        Objects.requireNonNull(gson);
        JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
        gson.m9211o(mapObject, Science.Event.MapObject.class, jsonTreeWriter);
        JsonElement jsonElementM6897L = jsonTreeWriter.m6897L();
        Intrinsics3.checkNotNullExpressionValue(jsonElementM6897L, "gson.toJsonTree(\n       …).toMap()\n        )\n    )");
        return jsonElementM6897L;
    }
}
