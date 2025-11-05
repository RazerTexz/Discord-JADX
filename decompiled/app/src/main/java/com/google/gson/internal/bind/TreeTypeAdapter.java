package com.google.gson.internal.bind;

import b.i.a.f.e.o.f;
import b.i.d.h;
import b.i.d.i;
import b.i.d.j;
import b.i.d.l;
import b.i.d.m;
import b.i.d.o;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    public final m<T> a;

    /* renamed from: b, reason: collision with root package name */
    public final i<T> f3126b;
    public final Gson c;
    public final TypeToken<T> d;
    public final o e;
    public final TreeTypeAdapter<T>.b f = new b(this, null);
    public TypeAdapter<T> g;

    public static final class SingleTypeFactory implements o {
        public final TypeToken<?> j;
        public final boolean k;
        public final Class<?> l;
        public final m<?> m;
        public final i<?> n;

        public SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z2, Class<?> cls) {
            m<?> mVar = obj instanceof m ? (m) obj : null;
            this.m = mVar;
            i<?> iVar = obj instanceof i ? (i) obj : null;
            this.n = iVar;
            f.w((mVar == null && iVar == null) ? false : true);
            this.j = typeToken;
            this.k = z2;
            this.l = null;
        }

        @Override // b.i.d.o
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            TypeToken<?> typeToken2 = this.j;
            if (typeToken2 != null ? typeToken2.equals(typeToken) || (this.k && this.j.getType() == typeToken.getRawType()) : this.l.isAssignableFrom(typeToken.getRawType())) {
                return new TreeTypeAdapter(this.m, this.n, gson, typeToken, this);
            }
            return null;
        }
    }

    public final class b implements l, h {
        public b(TreeTypeAdapter treeTypeAdapter, a aVar) {
        }
    }

    public TreeTypeAdapter(m<T> mVar, i<T> iVar, Gson gson, TypeToken<T> typeToken, o oVar) {
        this.a = mVar;
        this.f3126b = iVar;
        this.c = gson;
        this.d = typeToken;
        this.e = oVar;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws JsonParseException, IOException {
        if (this.f3126b == null) {
            TypeAdapter<T> typeAdapterJ = this.g;
            if (typeAdapterJ == null) {
                typeAdapterJ = this.c.j(this.e, this.d);
                this.g = typeAdapterJ;
            }
            return typeAdapterJ.read(jsonReader);
        }
        JsonElement jsonElementS0 = f.S0(jsonReader);
        Objects.requireNonNull(jsonElementS0);
        if (jsonElementS0 instanceof j) {
            return null;
        }
        return this.f3126b.a(jsonElementS0, this.d.getType(), this.f);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        m<T> mVar = this.a;
        if (mVar == null) {
            TypeAdapter<T> typeAdapterJ = this.g;
            if (typeAdapterJ == null) {
                typeAdapterJ = this.c.j(this.e, this.d);
                this.g = typeAdapterJ;
            }
            typeAdapterJ.write(jsonWriter, t);
            return;
        }
        if (t == null) {
            jsonWriter.s();
        } else {
            TypeAdapters.X.write(jsonWriter, mVar.serialize(t, this.d.getType(), this.f));
        }
    }
}
