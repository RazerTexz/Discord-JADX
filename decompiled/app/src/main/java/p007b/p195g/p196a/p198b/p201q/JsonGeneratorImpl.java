package p007b.p195g.p196a.p198b.p201q;

import com.fasterxml.jackson.core.JsonGenerationException;
import java.io.IOException;
import org.objectweb.asm.Opcodes;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.ObjectCodec;
import p007b.p195g.p196a.p198b.SerializableString;
import p007b.p195g.p196a.p198b.p199o.GeneratorBase;
import p007b.p195g.p196a.p198b.p200p.CharTypes;
import p007b.p195g.p196a.p198b.p200p.IOContext;
import p007b.p195g.p196a.p198b.p204t.DefaultPrettyPrinter;

/* JADX INFO: renamed from: b.g.a.b.q.b, reason: use source file name */
/* JADX INFO: compiled from: JsonGeneratorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class JsonGeneratorImpl extends GeneratorBase {

    /* JADX INFO: renamed from: r */
    public static final int[] f4564r = CharTypes.f4541f;

    /* JADX INFO: renamed from: s */
    public final IOContext f4565s;

    /* JADX INFO: renamed from: t */
    public int[] f4566t;

    /* JADX INFO: renamed from: u */
    public int f4567u;

    /* JADX INFO: renamed from: v */
    public SerializableString f4568v;

    /* JADX INFO: renamed from: w */
    public boolean f4569w;

    public JsonGeneratorImpl(IOContext iOContext, int i, ObjectCodec objectCodec) {
        super(i, objectCodec);
        this.f4566t = f4564r;
        this.f4568v = DefaultPrettyPrinter.f4599j;
        this.f4565s = iOContext;
        if (JsonGenerator.a.ESCAPE_NON_ASCII.m1668g(i)) {
            this.f4567u = Opcodes.LAND;
        }
        this.f4569w = !JsonGenerator.a.QUOTE_FIELD_NAMES.m1668g(i);
    }

    @Override // p007b.p195g.p196a.p198b.JsonGenerator
    /* JADX INFO: renamed from: b */
    public JsonGenerator mo1648b(JsonGenerator.a aVar) {
        int iM1669h = aVar.m1669h();
        this.f4529o &= ~iM1669h;
        if ((iM1669h & GeneratorBase.f4527m) != 0) {
            if (aVar == JsonGenerator.a.WRITE_NUMBERS_AS_STRINGS) {
                this.f4530p = false;
            } else if (aVar == JsonGenerator.a.ESCAPE_NON_ASCII) {
                m1705y0(0);
            } else if (aVar == JsonGenerator.a.STRICT_DUPLICATE_DETECTION) {
                JsonWriteContext jsonWriteContext = this.f4531q;
                jsonWriteContext.f4571d = null;
                this.f4531q = jsonWriteContext;
            }
        }
        if (aVar == JsonGenerator.a.QUOTE_FIELD_NAMES) {
            this.f4569w = true;
        }
        return this;
    }

    @Override // p007b.p195g.p196a.p198b.p199o.GeneratorBase
    /* JADX INFO: renamed from: r0 */
    public void mo1692r0(int i, int i2) {
        if ((GeneratorBase.f4527m & i2) != 0) {
            this.f4530p = JsonGenerator.a.WRITE_NUMBERS_AS_STRINGS.m1668g(i);
            JsonGenerator.a aVar = JsonGenerator.a.ESCAPE_NON_ASCII;
            if (aVar.m1668g(i2)) {
                if (aVar.m1668g(i)) {
                    m1705y0(Opcodes.LAND);
                } else {
                    m1705y0(0);
                }
            }
            JsonGenerator.a aVar2 = JsonGenerator.a.STRICT_DUPLICATE_DETECTION;
            if (aVar2.m1668g(i2)) {
                if (aVar2.m1668g(i)) {
                    JsonWriteContext jsonWriteContext = this.f4531q;
                    if (jsonWriteContext.f4571d == null) {
                        jsonWriteContext.f4571d = new DupDetector(this);
                        this.f4531q = jsonWriteContext;
                    }
                } else {
                    JsonWriteContext jsonWriteContext2 = this.f4531q;
                    jsonWriteContext2.f4571d = null;
                    this.f4531q = jsonWriteContext2;
                }
            }
        }
        this.f4569w = !JsonGenerator.a.QUOTE_FIELD_NAMES.m1668g(i);
    }

    /* JADX INFO: renamed from: x0 */
    public void m1704x0(String str) throws IOException {
        throw new JsonGenerationException(String.format("Can not %s, expecting field name (context: %s)", str, this.f4531q.m1677e()), this);
    }

    /* JADX INFO: renamed from: y0 */
    public JsonGenerator m1705y0(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f4567u = i;
        return this;
    }
}
