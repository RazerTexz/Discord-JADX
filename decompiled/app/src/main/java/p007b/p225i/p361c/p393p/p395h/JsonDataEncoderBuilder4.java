package p007b.p225i.p361c.p393p.p395h;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import p007b.p225i.p361c.p393p.DataEncoder;

/* JADX INFO: renamed from: b.i.c.p.h.d, reason: use source file name */
/* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class JsonDataEncoderBuilder4 implements DataEncoder {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ JsonDataEncoderBuilder5 f12820a;

    public JsonDataEncoderBuilder4(JsonDataEncoderBuilder5 jsonDataEncoderBuilder5) {
        this.f12820a = jsonDataEncoderBuilder5;
    }

    /* JADX INFO: renamed from: a */
    public String m6711a(@NonNull Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            m6712b(obj, stringWriter);
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    /* JADX INFO: renamed from: b */
    public void m6712b(@NonNull Object obj, @NonNull Writer writer) throws IOException {
        JsonDataEncoderBuilder5 jsonDataEncoderBuilder5 = this.f12820a;
        JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, jsonDataEncoderBuilder5.f12822b, jsonDataEncoderBuilder5.f12823c, jsonDataEncoderBuilder5.f12824d, jsonDataEncoderBuilder5.f12825e);
        jsonValueObjectEncoderContext.m6713g(obj, false);
        jsonValueObjectEncoderContext.m6715i();
        jsonValueObjectEncoderContext.f12828b.flush();
    }
}
