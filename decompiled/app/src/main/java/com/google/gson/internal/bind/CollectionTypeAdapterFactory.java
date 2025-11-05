package com.google.gson.internal.bind;

import b.i.d.o;
import b.i.d.q.a;
import b.i.d.q.g;
import b.i.d.q.r;
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

/* loaded from: classes3.dex */
public final class CollectionTypeAdapterFactory implements o {
    public final g j;

    public static final class Adapter<E> extends TypeAdapter<Collection<E>> {
        public final TypeAdapter<E> a;

        /* renamed from: b, reason: collision with root package name */
        public final r<? extends Collection<E>> f3118b;

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, r<? extends Collection<E>> rVar) {
            this.a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f3118b = rVar;
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() == JsonToken.NULL) {
                jsonReader.H();
                return null;
            }
            Collection<E> collectionA = this.f3118b.a();
            jsonReader.a();
            while (jsonReader.q()) {
                collectionA.add(this.a.read(jsonReader));
            }
            jsonReader.e();
            return collectionA;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object obj) throws IOException {
            Collection collection = (Collection) obj;
            if (collection == null) {
                jsonWriter.s();
                return;
            }
            jsonWriter.b();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.a.write(jsonWriter, it.next());
            }
            jsonWriter.e();
        }
    }

    public CollectionTypeAdapterFactory(g gVar) {
        this.j = gVar;
    }

    @Override // b.i.d.o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type typeF = a.f(type, rawType, Collection.class);
        if (typeF instanceof WildcardType) {
            typeF = ((WildcardType) typeF).getUpperBounds()[0];
        }
        Class cls = typeF instanceof ParameterizedType ? ((ParameterizedType) typeF).getActualTypeArguments()[0] : Object.class;
        return new Adapter(gson, cls, gson.h(TypeToken.get(cls)), this.j.a(typeToken));
    }
}
