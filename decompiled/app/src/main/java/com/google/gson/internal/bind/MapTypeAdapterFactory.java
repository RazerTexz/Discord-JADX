package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p408d.JsonArray;
import p007b.p225i.p408d.JsonNull;
import p007b.p225i.p408d.JsonPrimitive;
import p007b.p225i.p408d.TypeAdapterFactory2;
import p007b.p225i.p408d.p410q.C$Gson$Types;
import p007b.p225i.p408d.p410q.C4922g;
import p007b.p225i.p408d.p410q.JsonReaderInternalAccess;
import p007b.p225i.p408d.p410q.ObjectConstructor;
import p007b.p225i.p408d.p410q.p411x.JsonTreeReader;

/* JADX INFO: loaded from: classes3.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory2 {

    /* JADX INFO: renamed from: j */
    public final C4922g f21519j;

    /* JADX INFO: renamed from: k */
    public final boolean f21520k;

    public final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {

        /* JADX INFO: renamed from: a */
        public final TypeAdapter<K> f21521a;

        /* JADX INFO: renamed from: b */
        public final TypeAdapter<V> f21522b;

        /* JADX INFO: renamed from: c */
        public final ObjectConstructor<? extends Map<K, V>> f21523c;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            this.f21521a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f21522b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.f21523c = objectConstructor;
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) throws IOException {
            JsonToken jsonTokenMo6878N = jsonReader.mo6878N();
            if (jsonTokenMo6878N == JsonToken.NULL) {
                jsonReader.mo6876H();
                return null;
            }
            Map<K, V> mapMo6869a = this.f21523c.mo6869a();
            if (jsonTokenMo6878N == JsonToken.BEGIN_ARRAY) {
                jsonReader.mo6882a();
                while (jsonReader.mo6888q()) {
                    jsonReader.mo6882a();
                    K k = this.f21521a.read(jsonReader);
                    if (mapMo6869a.put(k, this.f21522b.read(jsonReader)) != null) {
                        throw new JsonSyntaxException(outline.m881v("duplicate key: ", k));
                    }
                    jsonReader.mo6886e();
                }
                jsonReader.mo6886e();
            } else {
                jsonReader.mo6883b();
                while (jsonReader.mo6888q()) {
                    Objects.requireNonNull((JsonReader.C11149a) JsonReaderInternalAccess.f13124a);
                    if (jsonReader instanceof JsonTreeReader) {
                        JsonTreeReader jsonTreeReader = (JsonTreeReader) jsonReader;
                        jsonTreeReader.m6880W(JsonToken.NAME);
                        Map.Entry entry = (Map.Entry) ((Iterator) jsonTreeReader.m6881X()).next();
                        jsonTreeReader.m6885c0(entry.getValue());
                        jsonTreeReader.m6885c0(new JsonPrimitive((String) entry.getKey()));
                    } else {
                        int iM9247d = jsonReader.f21633r;
                        if (iM9247d == 0) {
                            iM9247d = jsonReader.m9247d();
                        }
                        if (iM9247d == 13) {
                            jsonReader.f21633r = 9;
                        } else if (iM9247d == 12) {
                            jsonReader.f21633r = 8;
                        } else {
                            if (iM9247d != 14) {
                                StringBuilder sbM833U = outline.m833U("Expected a name but was ");
                                sbM833U.append(jsonReader.mo6878N());
                                sbM833U.append(jsonReader.m9250t());
                                throw new IllegalStateException(sbM833U.toString());
                            }
                            jsonReader.f21633r = 10;
                        }
                    }
                    K k2 = this.f21521a.read(jsonReader);
                    if (mapMo6869a.put(k2, this.f21522b.read(jsonReader)) != null) {
                        throw new JsonSyntaxException(outline.m881v("duplicate key: ", k2));
                    }
                }
                jsonReader.mo6887f();
            }
            return mapMo6869a;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object obj) throws IOException {
            String strMo6855g;
            Map map = (Map) obj;
            if (map == null) {
                jsonWriter.mo6905s();
                return;
            }
            if (!MapTypeAdapterFactory.this.f21520k) {
                jsonWriter.mo6901c();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    jsonWriter.mo6904n(String.valueOf(entry.getKey()));
                    this.f21522b.write(jsonWriter, entry.getValue());
                }
                jsonWriter.mo6903f();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i = 0;
            boolean z2 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                JsonElement jsonTree = this.f21521a.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                Objects.requireNonNull(jsonTree);
                z2 |= (jsonTree instanceof JsonArray) || (jsonTree instanceof JsonObject);
            }
            if (z2) {
                jsonWriter.mo6900b();
                int size = arrayList.size();
                while (i < size) {
                    jsonWriter.mo6900b();
                    TypeAdapters.f21579X.write(jsonWriter, (JsonElement) arrayList.get(i));
                    this.f21522b.write(jsonWriter, arrayList2.get(i));
                    jsonWriter.mo6902e();
                    i++;
                }
                jsonWriter.mo6902e();
                return;
            }
            jsonWriter.mo6901c();
            int size2 = arrayList.size();
            while (i < size2) {
                JsonElement jsonElement = (JsonElement) arrayList.get(i);
                Objects.requireNonNull(jsonElement);
                if (jsonElement instanceof JsonPrimitive) {
                    JsonPrimitive jsonPrimitiveM9213e = jsonElement.m9213e();
                    Object obj2 = jsonPrimitiveM9213e.f13107a;
                    if (obj2 instanceof Number) {
                        strMo6855g = String.valueOf(jsonPrimitiveM9213e.m6859i());
                    } else if (obj2 instanceof Boolean) {
                        strMo6855g = Boolean.toString(jsonPrimitiveM9213e.m6858h());
                    } else {
                        if (!(obj2 instanceof String)) {
                            throw new AssertionError();
                        }
                        strMo6855g = jsonPrimitiveM9213e.mo6855g();
                    }
                } else {
                    if (!(jsonElement instanceof JsonNull)) {
                        throw new AssertionError();
                    }
                    strMo6855g = "null";
                }
                jsonWriter.mo6904n(strMo6855g);
                this.f21522b.write(jsonWriter, arrayList2.get(i));
                i++;
            }
            jsonWriter.mo6903f();
        }
    }

    public MapTypeAdapterFactory(C4922g c4922g, boolean z2) {
        this.f21519j = c4922g;
        this.f21520k = z2;
    }

    @Override // p007b.p225i.p408d.TypeAdapterFactory2
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type[] actualTypeArguments;
        Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Class<?> clsM6864e = C$Gson$Types.m6864e(type);
        if (type == Properties.class) {
            actualTypeArguments = new Type[]{String.class, String.class};
        } else {
            Type typeM6865f = C$Gson$Types.m6865f(type, clsM6864e, Map.class);
            actualTypeArguments = typeM6865f instanceof ParameterizedType ? ((ParameterizedType) typeM6865f).getActualTypeArguments() : new Type[]{Object.class, Object.class};
        }
        Type type2 = actualTypeArguments[0];
        return new Adapter(gson, actualTypeArguments[0], (type2 == Boolean.TYPE || type2 == Boolean.class) ? TypeAdapters.f21587f : gson.m9204h(TypeToken.get(type2)), actualTypeArguments[1], gson.m9204h(TypeToken.get(actualTypeArguments[1])), this.f21519j.m6870a(typeToken));
    }
}
