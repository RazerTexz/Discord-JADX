package p007b.p109f.p161j.p181p;

import android.net.Uri;
import android.util.Base64;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p117b.CallerThreadExecutor;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* JADX INFO: renamed from: b.f.j.p.m, reason: use source file name */
/* JADX INFO: compiled from: DataFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class DataFetchProducer extends LocalFetchProducer {
    public DataFetchProducer(PooledByteBufferFactory pooledByteBufferFactory) {
        super(CallerThreadExecutor.f3078j, pooledByteBufferFactory);
    }

    @Override // p007b.p109f.p161j.p181p.LocalFetchProducer
    /* JADX INFO: renamed from: d */
    public EncodedImage2 mo1428d(ImageRequest imageRequest) throws IOException {
        boolean zEquals;
        byte[] bytes;
        String string = imageRequest.f19585c.toString();
        AnimatableValueParser.m527i(Boolean.valueOf(string.substring(0, 5).equals("data:")));
        int iIndexOf = string.indexOf(44);
        String strSubstring = string.substring(iIndexOf + 1, string.length());
        String strSubstring2 = string.substring(0, iIndexOf);
        if (strSubstring2.contains(";")) {
            zEquals = strSubstring2.split(";")[r5.length - 1].equals("base64");
        } else {
            zEquals = false;
        }
        if (zEquals) {
            bytes = Base64.decode(strSubstring, 0);
        } else {
            String strDecode = Uri.decode(strSubstring);
            Objects.requireNonNull(strDecode);
            bytes = strDecode.getBytes();
        }
        return m1478c(new ByteArrayInputStream(bytes), bytes.length);
    }

    @Override // p007b.p109f.p161j.p181p.LocalFetchProducer
    /* JADX INFO: renamed from: e */
    public String mo1429e() {
        return "DataFetchProducer";
    }
}
