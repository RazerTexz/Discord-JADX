package b.i.d;

import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* compiled from: JsonDeserializer.java */
/* loaded from: classes3.dex */
public interface i<T> {
    T a(JsonElement jsonElement, Type type, h hVar) throws JsonParseException;
}
