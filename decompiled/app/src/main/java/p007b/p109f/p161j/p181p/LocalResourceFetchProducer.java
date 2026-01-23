package p007b.p109f.p161j.p181p;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* JADX INFO: renamed from: b.f.j.p.i0, reason: use source file name */
/* JADX INFO: compiled from: LocalResourceFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class LocalResourceFetchProducer extends LocalFetchProducer {

    /* JADX INFO: renamed from: c */
    public final Resources f4081c;

    public LocalResourceFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Resources resources) {
        super(executor, pooledByteBufferFactory);
        this.f4081c = resources;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(3:20|3|4)|16|11|12|13|(1:(0))) */
    @Override // p007b.p109f.p161j.p181p.LocalFetchProducer
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EncodedImage2 mo1428d(ImageRequest imageRequest) throws IOException {
        int length;
        Resources resources = this.f4081c;
        String path = imageRequest.f19585c.getPath();
        Objects.requireNonNull(path);
        InputStream inputStreamOpenRawResource = resources.openRawResource(Integer.parseInt(path.substring(1)));
        AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = null;
        try {
            Resources resources2 = this.f4081c;
            String path2 = imageRequest.f19585c.getPath();
            Objects.requireNonNull(path2);
            assetFileDescriptorOpenRawResourceFd = resources2.openRawResourceFd(Integer.parseInt(path2.substring(1)));
            length = (int) assetFileDescriptorOpenRawResourceFd.getLength();
        } catch (Resources.NotFoundException unused) {
            length = -1;
            if (assetFileDescriptorOpenRawResourceFd != null) {
            }
            return m1478c(inputStreamOpenRawResource, length);
        } catch (Throwable th) {
            if (assetFileDescriptorOpenRawResourceFd != null) {
                try {
                    assetFileDescriptorOpenRawResourceFd.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
        assetFileDescriptorOpenRawResourceFd.close();
        return m1478c(inputStreamOpenRawResource, length);
    }

    @Override // p007b.p109f.p161j.p181p.LocalFetchProducer
    /* JADX INFO: renamed from: e */
    public String mo1429e() {
        return "LocalResourceFetchProducer";
    }
}
