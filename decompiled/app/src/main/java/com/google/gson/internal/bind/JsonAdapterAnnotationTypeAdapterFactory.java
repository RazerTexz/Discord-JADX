package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p408d.JsonDeserializer2;
import p007b.p225i.p408d.JsonSerializer2;
import p007b.p225i.p408d.TypeAdapterFactory2;
import p007b.p225i.p408d.p409p.JsonAdapter;
import p007b.p225i.p408d.p410q.C4922g;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory2 {

    /* JADX INFO: renamed from: j */
    public final C4922g f21518j;

    public JsonAdapterAnnotationTypeAdapterFactory(C4922g c4922g) {
        this.f21518j = c4922g;
    }

    /* JADX INFO: renamed from: a */
    public TypeAdapter<?> m9232a(C4922g c4922g, Gson gson, TypeToken<?> typeToken, JsonAdapter jsonAdapter) {
        TypeAdapter<?> treeTypeAdapter;
        Object objMo6869a = c4922g.m6870a(TypeToken.get((Class) jsonAdapter.value())).mo6869a();
        if (objMo6869a instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) objMo6869a;
        } else if (objMo6869a instanceof TypeAdapterFactory2) {
            treeTypeAdapter = ((TypeAdapterFactory2) objMo6869a).create(gson, typeToken);
        } else {
            boolean z2 = objMo6869a instanceof JsonSerializer2;
            if (!z2 && !(objMo6869a instanceof JsonDeserializer2)) {
                StringBuilder sbM833U = outline.m833U("Invalid attempt to bind an instance of ");
                sbM833U.append(objMo6869a.getClass().getName());
                sbM833U.append(" as a @JsonAdapter for ");
                sbM833U.append(typeToken.toString());
                sbM833U.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                throw new IllegalArgumentException(sbM833U.toString());
            }
            treeTypeAdapter = new TreeTypeAdapter<>(z2 ? (JsonSerializer2) objMo6869a : null, objMo6869a instanceof JsonDeserializer2 ? (JsonDeserializer2) objMo6869a : null, gson, typeToken, null);
        }
        return (treeTypeAdapter == null || !jsonAdapter.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.nullSafe();
    }

    @Override // p007b.p225i.p408d.TypeAdapterFactory2
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return (TypeAdapter<T>) m9232a(this.f21518j, gson, typeToken, jsonAdapter);
    }
}
