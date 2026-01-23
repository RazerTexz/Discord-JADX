package p007b.p195g.p196a.p198b.p199o;

import com.fasterxml.jackson.core.JsonGenerationException;
import java.io.IOException;
import java.math.BigDecimal;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonStreamContext;
import p007b.p195g.p196a.p198b.ObjectCodec;
import p007b.p195g.p196a.p198b.p201q.DupDetector;
import p007b.p195g.p196a.p198b.p201q.JsonWriteContext;

/* JADX INFO: renamed from: b.g.a.b.o.a, reason: use source file name */
/* JADX INFO: compiled from: GeneratorBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GeneratorBase extends JsonGenerator {

    /* JADX INFO: renamed from: m */
    public static final int f4527m = (JsonGenerator.a.WRITE_NUMBERS_AS_STRINGS.m1669h() | JsonGenerator.a.ESCAPE_NON_ASCII.m1669h()) | JsonGenerator.a.STRICT_DUPLICATE_DETECTION.m1669h();

    /* JADX INFO: renamed from: n */
    public ObjectCodec f4528n;

    /* JADX INFO: renamed from: o */
    public int f4529o;

    /* JADX INFO: renamed from: p */
    public boolean f4530p;

    /* JADX INFO: renamed from: q */
    public JsonWriteContext f4531q;

    public GeneratorBase(int i, ObjectCodec objectCodec) {
        this.f4529o = i;
        this.f4528n = objectCodec;
        this.f4531q = new JsonWriteContext(0, null, JsonGenerator.a.STRICT_DUPLICATE_DETECTION.m1668g(i) ? new DupDetector(this) : null);
        this.f4530p = JsonGenerator.a.WRITE_NUMBERS_AS_STRINGS.m1668g(i);
    }

    @Override // p007b.p195g.p196a.p198b.JsonGenerator
    /* JADX INFO: renamed from: V */
    public void mo1644V(String str) throws IOException {
        mo1693t0("write raw value");
        mo1642T(str);
    }

    @Override // p007b.p195g.p196a.p198b.JsonGenerator
    /* JADX INFO: renamed from: c */
    public JsonStreamContext mo1650c() {
        return this.f4531q;
    }

    @Override // p007b.p195g.p196a.p198b.JsonGenerator
    /* JADX INFO: renamed from: d */
    public final boolean mo1652d(JsonGenerator.a aVar) {
        return (aVar.m1669h() & this.f4529o) != 0;
    }

    @Override // p007b.p195g.p196a.p198b.JsonGenerator
    /* JADX INFO: renamed from: e */
    public void mo1654e(Object obj) {
        JsonWriteContext jsonWriteContext = this.f4531q;
        if (jsonWriteContext != null) {
            jsonWriteContext.f4574g = obj;
        }
    }

    /* JADX INFO: renamed from: o0 */
    public String m1691o0(BigDecimal bigDecimal) throws IOException {
        if (!JsonGenerator.a.WRITE_BIGDECIMAL_AS_PLAIN.m1668g(this.f4529o)) {
            return bigDecimal.toString();
        }
        int iScale = bigDecimal.scale();
        if (iScale < -9999 || iScale > 9999) {
            throw new JsonGenerationException(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(iScale), 9999, 9999), this);
        }
        return bigDecimal.toPlainString();
    }

    /* JADX INFO: renamed from: r0 */
    public abstract void mo1692r0(int i, int i2);

    /* JADX INFO: renamed from: t0 */
    public abstract void mo1693t0(String str) throws IOException;

    /* JADX INFO: renamed from: w0 */
    public JsonGenerator m1694w0(int i, int i2) {
        int i3 = this.f4529o;
        int i4 = (i & i2) | ((~i2) & i3);
        int i5 = i3 ^ i4;
        if (i5 != 0) {
            this.f4529o = i4;
            mo1692r0(i4, i5);
        }
        return this;
    }
}
