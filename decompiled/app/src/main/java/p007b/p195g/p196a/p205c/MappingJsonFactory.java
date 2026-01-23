package p007b.p195g.p196a.p205c;

import p007b.p195g.p196a.p198b.JsonFactory;
import p007b.p195g.p196a.p198b.ObjectCodec;

/* JADX INFO: renamed from: b.g.a.c.q, reason: use source file name */
/* JADX INFO: compiled from: MappingJsonFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class MappingJsonFactory extends JsonFactory {
    private static final long serialVersionUID = -1;

    public MappingJsonFactory() {
        super(null);
        this._objectCodec = new ObjectMapper(this, null, null);
    }

    @Override // p007b.p195g.p196a.p198b.JsonFactory
    /* JADX INFO: renamed from: b */
    public ObjectCodec mo1627b() {
        return (ObjectMapper) this._objectCodec;
    }

    public MappingJsonFactory(ObjectMapper objectMapper) {
        super(objectMapper);
    }
}
