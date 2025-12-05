package p007b.p109f.p161j.p181p;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* compiled from: LocalAssetFetchProducer.java */
/* renamed from: b.f.j.p.d0, reason: use source file name */
/* loaded from: classes3.dex */
public class LocalAssetFetchProducer extends LocalFetchProducer {

    /* renamed from: c */
    public final AssetManager f4039c;

    public LocalAssetFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, AssetManager assetManager) {
        super(executor, pooledByteBufferFactory);
        this.f4039c = assetManager;
    }

    @Override // p007b.p109f.p161j.p181p.LocalFetchProducer
    /* renamed from: d */
    public EncodedImage2 mo1428d(ImageRequest imageRequest) throws IOException {
        int length;
        InputStream inputStreamOpen = this.f4039c.open(imageRequest.f19585c.getPath().substring(1), 2);
        AssetFileDescriptor assetFileDescriptorOpenFd = null;
        try {
            assetFileDescriptorOpenFd = this.f4039c.openFd(imageRequest.f19585c.getPath().substring(1));
            length = (int) assetFileDescriptorOpenFd.getLength();
        } catch (IOException unused) {
            length = -1;
            if (assetFileDescriptorOpenFd != null) {
            }
        } catch (Throwable th) {
            if (assetFileDescriptorOpenFd != null) {
                try {
                    assetFileDescriptorOpenFd.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
        try {
            assetFileDescriptorOpenFd.close();
        } catch (IOException unused3) {
        }
        return m1478c(inputStreamOpen, length);
    }

    @Override // p007b.p109f.p161j.p181p.LocalFetchProducer
    /* renamed from: e */
    public String mo1429e() {
        return "LocalAssetFetchProducer";
    }
}
