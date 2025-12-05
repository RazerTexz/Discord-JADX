package p630i0.p633e0.p634a;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import p507d0.p579g0.Charsets2;
import p615g0.BufferedSource;
import p630i0.Converter2;

/* compiled from: GsonResponseBodyConverter.java */
/* renamed from: i0.e0.a.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class GsonResponseBodyConverter<T> implements Converter2<ResponseBody, T> {

    /* renamed from: a */
    public final Gson f26515a;

    /* renamed from: b */
    public final TypeAdapter<T> f26516b;

    public GsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f26515a = gson;
        this.f26516b = typeAdapter;
    }

    @Override // p630i0.Converter2
    public Object convert(ResponseBody responseBody) throws IOException {
        Charset charsetM10966a;
        ResponseBody responseBody2 = responseBody;
        Gson gson = this.f26515a;
        Reader c12938a = responseBody2.reader;
        if (c12938a == null) {
            BufferedSource bufferedSourceMo10105c = responseBody2.mo10105c();
            MediaType mediaTypeMo10104b = responseBody2.mo10104b();
            if (mediaTypeMo10104b == null || (charsetM10966a = mediaTypeMo10104b.m10966a(Charsets2.f25136a)) == null) {
                charsetM10966a = Charsets2.f25136a;
            }
            c12938a = new ResponseBody.C12938a(bufferedSourceMo10105c, charsetM10966a);
            responseBody2.reader = c12938a;
        }
        JsonReader jsonReaderM9207k = gson.m9207k(c12938a);
        try {
            T t = this.f26516b.read(jsonReaderM9207k);
            if (jsonReaderM9207k.mo6878N() == JsonToken.END_DOCUMENT) {
                return t;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            responseBody2.close();
        }
    }
}
