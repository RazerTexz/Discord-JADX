package p007b.p109f.p161j.p181p;

import android.content.ContentResolver;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* JADX INFO: renamed from: b.f.j.p.b1, reason: use source file name */
/* JADX INFO: compiled from: QualifiedResourceFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class QualifiedResourceFetchProducer extends LocalFetchProducer {

    /* JADX INFO: renamed from: c */
    public final ContentResolver f3998c;

    public QualifiedResourceFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.f3998c = contentResolver;
    }

    @Override // p007b.p109f.p161j.p181p.LocalFetchProducer
    /* JADX INFO: renamed from: d */
    public EncodedImage2 mo1428d(ImageRequest imageRequest) throws IOException {
        InputStream inputStreamOpenInputStream = this.f3998c.openInputStream(imageRequest.f19585c);
        AnimatableValueParser.m591y(inputStreamOpenInputStream, "ContentResolver returned null InputStream");
        return m1478c(inputStreamOpenInputStream, -1);
    }

    @Override // p007b.p109f.p161j.p181p.LocalFetchProducer
    /* JADX INFO: renamed from: e */
    public String mo1429e() {
        return "QualifiedResourceFetchProducer";
    }
}
