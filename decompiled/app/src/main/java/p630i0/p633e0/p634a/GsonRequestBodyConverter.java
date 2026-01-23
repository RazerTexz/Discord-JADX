package p630i0.p633e0.p634a;

import com.adjust.sdk.Constants;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import p615g0.Buffer3;
import p615g0.Buffer4;
import p630i0.Converter2;

/* JADX INFO: renamed from: i0.e0.a.b, reason: use source file name */
/* JADX INFO: compiled from: GsonRequestBodyConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class GsonRequestBodyConverter<T> implements Converter2<T, RequestBody> {

    /* JADX INFO: renamed from: a */
    public static final MediaType f26511a;

    /* JADX INFO: renamed from: b */
    public static final Charset f26512b;

    /* JADX INFO: renamed from: c */
    public final Gson f26513c;

    /* JADX INFO: renamed from: d */
    public final TypeAdapter<T> f26514d;

    static {
        MediaType.Companion companion = MediaType.INSTANCE;
        f26511a = MediaType.Companion.m10967a("application/json; charset=UTF-8");
        f26512b = Charset.forName(Constants.ENCODING);
    }

    public GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f26513c = gson;
        this.f26514d = typeAdapter;
    }

    @Override // p630i0.Converter2
    public RequestBody convert(Object obj) throws IOException {
        Buffer3 buffer3 = new Buffer3();
        JsonWriter jsonWriterM9208l = this.f26513c.m9208l(new OutputStreamWriter(new Buffer4(buffer3), f26512b));
        this.f26514d.write(jsonWriterM9208l, obj);
        jsonWriterM9208l.close();
        return RequestBody.create(f26511a, buffer3.m10473x());
    }
}
