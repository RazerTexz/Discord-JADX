package com.discord.nullserializable;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import p007b.p225i.p408d.TypeAdapterFactory2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.nullserializable.NullSerializableTypeAdapterFactory, reason: use source file name */
/* JADX INFO: compiled from: NullSerializable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NullSerializable3 implements TypeAdapterFactory2 {
    @Override // p007b.p225i.p408d.TypeAdapterFactory2
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Intrinsics3.checkNotNullParameter(gson, "gson");
        Intrinsics3.checkNotNullParameter(type, "type");
        if (!NullSerializable.class.isAssignableFrom(type.getRawType())) {
            return null;
        }
        Type type2 = type.getType();
        Objects.requireNonNull(type2, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        TypeAdapter<T> typeAdapterM9204h = gson.m9204h(TypeToken.get(((ParameterizedType) type2).getActualTypeArguments()[0]));
        Intrinsics3.checkNotNullExpressionValue(typeAdapterM9204h, "delegateTypeAdapter");
        return new NullSerializable2(gson, typeAdapterM9204h);
    }
}
