package p007b.p225i.p408d;

import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: JsonArray.java */
/* renamed from: b.i.d.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {

    /* renamed from: j */
    public final List<JsonElement> f13105j = new ArrayList();

    @Override // com.google.gson.JsonElement
    /* renamed from: c */
    public int mo6854c() {
        if (this.f13105j.size() == 1) {
            return this.f13105j.get(0).mo6854c();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonArray) && ((JsonArray) obj).f13105j.equals(this.f13105j));
    }

    @Override // com.google.gson.JsonElement
    /* renamed from: g */
    public String mo6855g() {
        if (this.f13105j.size() == 1) {
            return this.f13105j.get(0).mo6855g();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.f13105j.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<JsonElement> iterator() {
        return this.f13105j.iterator();
    }
}
