package p007b.p195g.p196a.p205c.p214f0;

import java.io.Serializable;

/* compiled from: JsonNodeFactory.java */
/* renamed from: b.g.a.c.f0.a, reason: use source file name */
/* loaded from: classes3.dex */
public class JsonNodeFactory implements Serializable {

    /* renamed from: j */
    public static final JsonNodeFactory f4782j;

    /* renamed from: k */
    public static final JsonNodeFactory f4783k;
    private static final long serialVersionUID = 1;
    private final boolean _cfgBigDecimalExact;

    static {
        JsonNodeFactory jsonNodeFactory = new JsonNodeFactory(false);
        f4782j = jsonNodeFactory;
        f4783k = jsonNodeFactory;
    }

    public JsonNodeFactory() {
        this._cfgBigDecimalExact = false;
    }

    public JsonNodeFactory(boolean z2) {
        this._cfgBigDecimalExact = z2;
    }
}
