package p007b.p195g.p196a.p205c.p212e0;

import java.io.IOException;
import p007b.p195g.p196a.p197a.JsonTypeInfo;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p198b.p204t.VersionUtil;
import p007b.p195g.p196a.p205c.BeanProperty;

/* JADX INFO: renamed from: b.g.a.c.e0.g, reason: use source file name */
/* JADX INFO: compiled from: TypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeSerializer {
    /* JADX INFO: renamed from: a */
    public abstract TypeSerializer mo1955a(BeanProperty beanProperty);

    /* JADX INFO: renamed from: b */
    public abstract String mo1956b();

    /* JADX INFO: renamed from: c */
    public abstract JsonTypeInfo.a mo1957c();

    /* JADX INFO: renamed from: d */
    public WritableTypeId m1958d(Object obj, JsonToken2 jsonToken2) {
        WritableTypeId writableTypeId = new WritableTypeId(obj, jsonToken2);
        int iOrdinal = mo1957c().ordinal();
        if (iOrdinal == 0) {
            writableTypeId.f4588e = 3;
            writableTypeId.f4587d = mo1956b();
        } else if (iOrdinal == 1) {
            writableTypeId.f4588e = 2;
        } else if (iOrdinal == 2) {
            writableTypeId.f4588e = 1;
        } else if (iOrdinal == 3) {
            writableTypeId.f4588e = 5;
            writableTypeId.f4587d = mo1956b();
        } else {
            if (iOrdinal != 4) {
                int i = VersionUtil.f4617a;
                throw new RuntimeException("Internal error: this code path should never get executed");
            }
            writableTypeId.f4588e = 4;
            writableTypeId.f4587d = mo1956b();
        }
        return writableTypeId;
    }

    /* JADX INFO: renamed from: e */
    public abstract WritableTypeId mo1959e(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException;

    /* JADX INFO: renamed from: f */
    public abstract WritableTypeId mo1960f(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException;
}
