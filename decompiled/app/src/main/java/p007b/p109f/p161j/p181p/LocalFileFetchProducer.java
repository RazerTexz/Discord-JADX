package p007b.p109f.p161j.p181p;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* compiled from: LocalFileFetchProducer.java */
/* renamed from: b.f.j.p.h0, reason: use source file name */
/* loaded from: classes3.dex */
public class LocalFileFetchProducer extends LocalFetchProducer {
    public LocalFileFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory) {
        super(executor, pooledByteBufferFactory);
    }

    @Override // p007b.p109f.p161j.p181p.LocalFetchProducer
    /* renamed from: d */
    public EncodedImage2 mo1428d(ImageRequest imageRequest) throws IOException {
        return m1478c(new FileInputStream(imageRequest.m8719a().toString()), (int) imageRequest.m8719a().length());
    }

    @Override // p007b.p109f.p161j.p181p.LocalFetchProducer
    /* renamed from: e */
    public String mo1429e() {
        return "LocalFileFetchProducer";
    }
}
