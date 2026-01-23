package p630i0.p633e0.p634a;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p630i0.Converter2;
import p630i0.Retrofit2;

/* JADX INFO: renamed from: i0.e0.a.a, reason: use source file name */
/* JADX INFO: compiled from: GsonConverterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class GsonConverterFactory extends Converter2.a {

    /* JADX INFO: renamed from: a */
    public final Gson f26510a;

    public GsonConverterFactory(Gson gson) {
        this.f26510a = gson;
    }

    @Override // p630i0.Converter2.a
    public Converter2<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit2 retrofit22) {
        return new GsonRequestBodyConverter(this.f26510a, this.f26510a.m9204h(TypeToken.get(type)));
    }

    @Override // p630i0.Converter2.a
    public Converter2<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit2 retrofit22) {
        return new GsonResponseBodyConverter(this.f26510a, this.f26510a.m9204h(TypeToken.get(type)));
    }
}
