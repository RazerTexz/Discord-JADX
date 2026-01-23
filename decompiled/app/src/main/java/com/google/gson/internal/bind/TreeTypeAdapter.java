package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p408d.JsonDeserializationContext;
import p007b.p225i.p408d.JsonDeserializer2;
import p007b.p225i.p408d.JsonNull;
import p007b.p225i.p408d.JsonSerializationContext;
import p007b.p225i.p408d.JsonSerializer2;
import p007b.p225i.p408d.TypeAdapterFactory2;

/* JADX INFO: loaded from: classes3.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {

    /* JADX INFO: renamed from: a */
    public final JsonSerializer2<T> f21541a;

    /* JADX INFO: renamed from: b */
    public final JsonDeserializer2<T> f21542b;

    /* JADX INFO: renamed from: c */
    public final Gson f21543c;

    /* JADX INFO: renamed from: d */
    public final TypeToken<T> f21544d;

    /* JADX INFO: renamed from: e */
    public final TypeAdapterFactory2 f21545e;

    /* JADX INFO: renamed from: f */
    public final TreeTypeAdapter<T>.C11113b f21546f = new C11113b(this, null);

    /* JADX INFO: renamed from: g */
    public TypeAdapter<T> f21547g;

    public static final class SingleTypeFactory implements TypeAdapterFactory2 {

        /* JADX INFO: renamed from: j */
        public final TypeToken<?> f21548j;

        /* JADX INFO: renamed from: k */
        public final boolean f21549k;

        /* JADX INFO: renamed from: l */
        public final Class<?> f21550l;

        /* JADX INFO: renamed from: m */
        public final JsonSerializer2<?> f21551m;

        /* JADX INFO: renamed from: n */
        public final JsonDeserializer2<?> f21552n;

        public SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z2, Class<?> cls) {
            JsonSerializer2<?> jsonSerializer2 = obj instanceof JsonSerializer2 ? (JsonSerializer2) obj : null;
            this.f21551m = jsonSerializer2;
            JsonDeserializer2<?> jsonDeserializer2 = obj instanceof JsonDeserializer2 ? (JsonDeserializer2) obj : null;
            this.f21552n = jsonDeserializer2;
            C3404f.m4355w((jsonSerializer2 == null && jsonDeserializer2 == null) ? false : true);
            this.f21548j = typeToken;
            this.f21549k = z2;
            this.f21550l = null;
        }

        @Override // p007b.p225i.p408d.TypeAdapterFactory2
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            TypeToken<?> typeToken2 = this.f21548j;
            if (typeToken2 != null ? typeToken2.equals(typeToken) || (this.f21549k && this.f21548j.getType() == typeToken.getRawType()) : this.f21550l.isAssignableFrom(typeToken.getRawType())) {
                return new TreeTypeAdapter(this.f21551m, this.f21552n, gson, typeToken, this);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TreeTypeAdapter$b */
    public final class C11113b implements JsonSerializationContext, JsonDeserializationContext {
        public C11113b(TreeTypeAdapter treeTypeAdapter, C11112a c11112a) {
        }
    }

    public TreeTypeAdapter(JsonSerializer2<T> jsonSerializer2, JsonDeserializer2<T> jsonDeserializer2, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory2 typeAdapterFactory2) {
        this.f21541a = jsonSerializer2;
        this.f21542b = jsonDeserializer2;
        this.f21543c = gson;
        this.f21544d = typeToken;
        this.f21545e = typeAdapterFactory2;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        if (this.f21542b == null) {
            TypeAdapter<T> typeAdapterM9206j = this.f21547g;
            if (typeAdapterM9206j == null) {
                typeAdapterM9206j = this.f21543c.m9206j(this.f21545e, this.f21544d);
                this.f21547g = typeAdapterM9206j;
            }
            return typeAdapterM9206j.read(jsonReader);
        }
        JsonElement jsonElementM4244S0 = C3404f.m4244S0(jsonReader);
        Objects.requireNonNull(jsonElementM4244S0);
        if (jsonElementM4244S0 instanceof JsonNull) {
            return null;
        }
        return this.f21542b.m6856a(jsonElementM4244S0, this.f21544d.getType(), this.f21546f);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        JsonSerializer2<T> jsonSerializer2 = this.f21541a;
        if (jsonSerializer2 == null) {
            TypeAdapter<T> typeAdapterM9206j = this.f21547g;
            if (typeAdapterM9206j == null) {
                typeAdapterM9206j = this.f21543c.m9206j(this.f21545e, this.f21544d);
                this.f21547g = typeAdapterM9206j;
            }
            typeAdapterM9206j.write(jsonWriter, t);
            return;
        }
        if (t == null) {
            jsonWriter.mo6905s();
        } else {
            TypeAdapters.f21579X.write(jsonWriter, jsonSerializer2.serialize(t, this.f21544d.getType(), this.f21546f));
        }
    }
}
