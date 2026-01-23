package p007b.p225i.p408d;

import com.google.gson.JsonElement;
import java.lang.reflect.Type;

/* JADX INFO: renamed from: b.i.d.m, reason: use source file name */
/* JADX INFO: compiled from: JsonSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public interface JsonSerializer2<T> {
    JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext);
}
