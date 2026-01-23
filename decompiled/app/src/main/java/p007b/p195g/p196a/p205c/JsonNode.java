package p007b.p195g.p196a.p205c;

import java.util.Iterator;
import p007b.p195g.p196a.p205c.JsonSerializable;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* JADX INFO: renamed from: b.g.a.c.l, reason: use source file name */
/* JADX INFO: compiled from: JsonNode.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class JsonNode extends JsonSerializable.a implements Iterable<JsonNode> {
    @Override // java.lang.Iterable
    public final Iterator<JsonNode> iterator() {
        return ClassUtil.f4946c;
    }
}
