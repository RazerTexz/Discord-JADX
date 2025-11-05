package com.discord.api.science;

import b.i.d.c;
import b.i.d.e;
import b.i.d.l;
import b.i.d.m;
import b.i.d.q.x.b;
import com.discord.api.science.Science;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import d0.t.h0;
import d0.t.r;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;

/* compiled from: AnalyticsSchemaTypeAdapter.kt */
/* loaded from: classes.dex */
public final class AnalyticsSchemaTypeAdapter implements m<Science.Event.SchemaObject> {
    private final Gson gson;

    public AnalyticsSchemaTypeAdapter() {
        e eVar = new e();
        eVar.c = c.m;
        this.gson = eVar.a();
    }

    public final List<Pair<String, Object>> a(Map<String, ? extends Object> map) {
        List<Pair<String, Object>> listListOf;
        d0.z.d.m.checkNotNullParameter(map, "$this$flatMapProperties");
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
            if (map2 == null || (listListOf = a(map2)) == null) {
                listListOf = d0.t.m.listOf(new Pair(entry.getKey(), entry.getValue()));
            }
            r.addAll(arrayList, listListOf);
        }
        return arrayList;
    }

    @Override // b.i.d.m
    public JsonElement serialize(Science.Event.SchemaObject schemaObject, Type type, l lVar) throws JsonSyntaxException, JsonIOException {
        Science.Event.SchemaObject schemaObject2 = schemaObject;
        d0.z.d.m.checkNotNullParameter(schemaObject2, "src");
        d0.z.d.m.checkNotNullParameter(type, "typeOfSrc");
        d0.z.d.m.checkNotNullParameter(lVar, "context");
        Gson gson = this.gson;
        String type2 = schemaObject2.getType();
        AnalyticsSchema schema = schemaObject2.getSchema();
        d0.z.d.m.checkNotNullParameter(schema, "$this$serializeToMap");
        Object objG = this.gson.g(this.gson.m(schema), new AnalyticsSchemaTypeAdapter$serializeToMap$1().getType());
        d0.z.d.m.checkNotNullExpressionValue(objG, "gson.fromJson(json, obje…<String, Any>>() {}.type)");
        Science.Event.MapObject mapObject = new Science.Event.MapObject(type2, h0.toMap(a((Map) objG)));
        Objects.requireNonNull(gson);
        b bVar = new b();
        gson.o(mapObject, Science.Event.MapObject.class, bVar);
        JsonElement jsonElementL = bVar.L();
        d0.z.d.m.checkNotNullExpressionValue(jsonElementL, "gson.toJsonTree(\n       …).toMap()\n        )\n    )");
        return jsonElementL;
    }
}
