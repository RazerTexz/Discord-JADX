package com.discord.nullserializable;

import androidx.exifinterface.media.ExifInterface;
import com.discord.nullserializable.NullSerializable;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: NullSerializable.kt */
/* renamed from: com.discord.nullserializable.NullSerializableTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class NullSerializable2<T> extends TypeAdapter<NullSerializable<? super T>> {

    /* renamed from: a, reason: from kotlin metadata */
    public final Gson gsonInstance;

    /* renamed from: b, reason: from kotlin metadata */
    public final TypeAdapter<T> delegateTypeAdapter;

    public NullSerializable2(Gson gson, TypeAdapter<T> typeAdapter) {
        Intrinsics3.checkNotNullParameter(gson, "gsonInstance");
        Intrinsics3.checkNotNullParameter(typeAdapter, "delegateTypeAdapter");
        this.gsonInstance = gson;
        this.delegateTypeAdapter = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        T t = this.delegateTypeAdapter.read(jsonReader);
        return t == null ? new NullSerializable.C5565a(null, 1) : new NullSerializable.C5566b(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        NullSerializable nullSerializable = (NullSerializable) obj;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (nullSerializable instanceof NullSerializable.C5566b) {
            Object objMo8429a = nullSerializable.mo8429a();
            Gson gson = this.gsonInstance;
            Intrinsics3.checkNotNull(objMo8429a);
            TypeAdapter typeAdapterM9205i = gson.m9205i(objMo8429a.getClass());
            Objects.requireNonNull(typeAdapterM9205i, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T>");
            typeAdapterM9205i.write(jsonWriter, objMo8429a);
            return;
        }
        if (nullSerializable instanceof NullSerializable.C5565a) {
            boolean z2 = jsonWriter.f21662t;
            jsonWriter.f21662t = true;
            jsonWriter.mo6905s();
            jsonWriter.f21662t = z2;
            return;
        }
        if (nullSerializable == null) {
            boolean z3 = jsonWriter.f21662t;
            jsonWriter.f21662t = false;
            jsonWriter.mo6905s();
            jsonWriter.f21662t = z3;
        }
    }
}
