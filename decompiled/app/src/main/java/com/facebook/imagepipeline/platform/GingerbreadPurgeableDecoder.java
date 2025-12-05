package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.Closeables;
import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p115d.p119d.Throwables;
import p007b.p109f.p115d.p122g.PooledByteBufferInputStream;
import p007b.p109f.p115d.p125j.LimitedInputStream;
import p007b.p109f.p115d.p128m.WebpBitmapFactory;
import p007b.p109f.p115d.p128m.WebpSupportStatus;

@DoNotStrip
/* loaded from: classes3.dex */
public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {

    /* renamed from: c */
    public static Method f19574c;

    /* renamed from: d */
    public final WebpBitmapFactory f19575d = WebpSupportStatus.m1015c();

    @DoNotStrip
    public GingerbreadPurgeableDecoder() {
    }

    /* renamed from: g */
    public static MemoryFile m8715g(CloseableReference<PooledByteBuffer> closeableReference, int i, byte[] bArr) throws Throwable {
        OutputStream outputStream;
        LimitedInputStream limitedInputStream;
        PooledByteBufferInputStream pooledByteBufferInputStream = null;
        OutputStream outputStream2 = null;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i);
        memoryFile.allowPurging(false);
        try {
            PooledByteBufferInputStream pooledByteBufferInputStream2 = new PooledByteBufferInputStream(closeableReference.m8642u());
            try {
                limitedInputStream = new LimitedInputStream(pooledByteBufferInputStream2, i);
                try {
                    outputStream2 = memoryFile.getOutputStream();
                    Objects.requireNonNull(outputStream2);
                    byte[] bArr2 = new byte[4096];
                    while (true) {
                        int i2 = limitedInputStream.read(bArr2);
                        if (i2 == -1) {
                            break;
                        }
                        outputStream2.write(bArr2, 0, i2);
                    }
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i, bArr.length);
                    }
                    closeableReference.close();
                    Closeables.m966b(pooledByteBufferInputStream2);
                    Closeables.m966b(limitedInputStream);
                    Closeables.m965a(outputStream2, true);
                    return memoryFile;
                } catch (Throwable th) {
                    th = th;
                    outputStream = outputStream2;
                    pooledByteBufferInputStream = pooledByteBufferInputStream2;
                    Class<CloseableReference> cls = CloseableReference.f19438j;
                    if (closeableReference != null) {
                        closeableReference.close();
                    }
                    Closeables.m966b(pooledByteBufferInputStream);
                    Closeables.m966b(limitedInputStream);
                    Closeables.m965a(outputStream, true);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                limitedInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            limitedInputStream = null;
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    /* renamed from: c */
    public Bitmap mo8710c(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options) {
        return m8716h(closeableReference, closeableReference.m8642u().size(), null, options);
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    /* renamed from: d */
    public Bitmap mo8711d(CloseableReference<PooledByteBuffer> closeableReference, int i, BitmapFactory.Options options) {
        return m8716h(closeableReference, i, DalvikPurgeableDecoder.m8709e(closeableReference, i) ? null : DalvikPurgeableDecoder.f19566a, options);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bitmap m8716h(CloseableReference<PooledByteBuffer> closeableReference, int i, byte[] bArr, BitmapFactory.Options options) throws Throwable {
        MemoryFile memoryFile = null;
        try {
            MemoryFile memoryFileM8715g = m8715g(closeableReference, i, bArr);
            try {
                FileDescriptor fileDescriptorM8718j = m8718j(memoryFileM8715g);
                WebpBitmapFactory webpBitmapFactory = this.f19575d;
                if (webpBitmapFactory == null) {
                    throw new IllegalStateException("WebpBitmapFactory is null");
                }
                Bitmap bitmapMo1011a = webpBitmapFactory.mo1011a(fileDescriptorM8718j, null, options);
                AnimatableValueParser.m591y(bitmapMo1011a, "BitmapFactory returned null");
                Bitmap bitmap = bitmapMo1011a;
                memoryFileM8715g.close();
                return bitmap;
            } catch (IOException e) {
                e = e;
                memoryFile = memoryFileM8715g;
                try {
                    Throwables.m972a(e);
                    throw new RuntimeException(e);
                } catch (Throwable th) {
                    th = th;
                    if (memoryFile != null) {
                        memoryFile.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                memoryFile = memoryFileM8715g;
                if (memoryFile != null) {
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: i */
    public final synchronized Method m8717i() {
        if (f19574c == null) {
            try {
                f19574c = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Exception e) {
                Throwables.m972a(e);
                throw new RuntimeException(e);
            }
        }
        return f19574c;
    }

    /* renamed from: j */
    public final FileDescriptor m8718j(MemoryFile memoryFile) throws Throwable {
        try {
            Object objInvoke = m8717i().invoke(memoryFile, new Object[0]);
            Objects.requireNonNull(objInvoke);
            return (FileDescriptor) objInvoke;
        } catch (Exception e) {
            Throwables.m972a(e);
            throw new RuntimeException(e);
        }
    }
}
