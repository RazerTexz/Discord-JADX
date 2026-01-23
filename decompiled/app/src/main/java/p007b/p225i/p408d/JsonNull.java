package p007b.p225i.p408d;

import com.google.gson.JsonElement;

/* JADX INFO: renamed from: b.i.d.j, reason: use source file name */
/* JADX INFO: compiled from: JsonNull.java */
/* JADX INFO: loaded from: classes3.dex */
public final class JsonNull extends JsonElement {

    /* JADX INFO: renamed from: a */
    public static final JsonNull f13106a = new JsonNull();

    @Deprecated
    public JsonNull() {
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof JsonNull);
    }

    public int hashCode() {
        return JsonNull.class.hashCode();
    }
}
