package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.Iterator;
import p007b.p225i.p408d.TypeAdapterFactory2;
import p007b.p225i.p408d.p410q.C$Gson$Types;
import p007b.p225i.p408d.p410q.C4922g;
import p007b.p225i.p408d.p410q.ObjectConstructor;

/* loaded from: classes3.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory2 {

    /* renamed from: j */
    public final C4922g f21513j;

    public static final class Adapter<E> extends TypeAdapter<Collection<E>> {

        /* renamed from: a */
        public final TypeAdapter<E> f21514a;

        /* renamed from: b */
        public final ObjectConstructor<? extends Collection<E>> f21515b;

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, ObjectConstructor<? extends Collection<E>> objectConstructor) {
            this.f21514a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f21515b = objectConstructor;
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo6878N() == JsonToken.NULL) {
                jsonReader.mo6876H();
                return null;
            }
            Collection<E> collectionMo6869a = this.f21515b.mo6869a();
            jsonReader.mo6882a();
            while (jsonReader.mo6888q()) {
                collectionMo6869a.add(this.f21514a.read(jsonReader));
            }
            jsonReader.mo6886e();
            return collectionMo6869a;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object obj) throws IOException {
            Collection collection = (Collection) obj;
            if (collection == null) {
                jsonWriter.mo6905s();
                return;
            }
            jsonWriter.mo6900b();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f21514a.write(jsonWriter, it.next());
            }
            jsonWriter.mo6902e();
        }
    }

    public CollectionTypeAdapterFactory(C4922g c4922g) {
        this.f21513j = c4922g;
    }

    @Override // p007b.p225i.p408d.TypeAdapterFactory2
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type typeM6865f = C$Gson$Types.m6865f(type, rawType, Collection.class);
        if (typeM6865f instanceof WildcardType) {
            typeM6865f = ((WildcardType) typeM6865f).getUpperBounds()[0];
        }
        Class cls = typeM6865f instanceof ParameterizedType ? ((ParameterizedType) typeM6865f).getActualTypeArguments()[0] : Object.class;
        return new Adapter(gson, cls, gson.m9204h(TypeToken.get(cls)), this.f21513j.m6870a(typeToken));
    }
}
