package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p161j.p177l.FlexByteArrayPool;

@DoNotStrip
@TargetApi(19)
/* loaded from: classes3.dex */
public class KitKatPurgeableDecoder extends DalvikPurgeableDecoder {

    /* renamed from: c */
    public final FlexByteArrayPool f19576c;

    @DoNotStrip
    public KitKatPurgeableDecoder(FlexByteArrayPool flexByteArrayPool) {
        this.f19576c = flexByteArrayPool;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    /* renamed from: c */
    public Bitmap mo8710c(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options) {
        PooledByteBuffer pooledByteBufferM8642u = closeableReference.m8642u();
        int size = pooledByteBufferM8642u.size();
        CloseableReference<byte[]> closeableReferenceM1391a = this.f19576c.m1391a(size);
        try {
            byte[] bArrM8642u = closeableReferenceM1391a.m8642u();
            pooledByteBufferM8642u.mo1396i(0, bArrM8642u, 0, size);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrM8642u, 0, size, options);
            AnimatableValueParser.m591y(bitmapDecodeByteArray, "BitmapFactory returned null");
            closeableReferenceM1391a.close();
            return bitmapDecodeByteArray;
        } catch (Throwable th) {
            if (closeableReferenceM1391a != null) {
                closeableReferenceM1391a.close();
            }
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    /* renamed from: d */
    public Bitmap mo8711d(CloseableReference<PooledByteBuffer> closeableReference, int i, BitmapFactory.Options options) {
        byte[] bArr = DalvikPurgeableDecoder.m8709e(closeableReference, i) ? null : DalvikPurgeableDecoder.f19566a;
        PooledByteBuffer pooledByteBufferM8642u = closeableReference.m8642u();
        AnimatableValueParser.m527i(Boolean.valueOf(i <= pooledByteBufferM8642u.size()));
        int i2 = i + 2;
        CloseableReference<byte[]> closeableReferenceM1391a = this.f19576c.m1391a(i2);
        try {
            byte[] bArrM8642u = closeableReferenceM1391a.m8642u();
            pooledByteBufferM8642u.mo1396i(0, bArrM8642u, 0, i);
            if (bArr != null) {
                bArrM8642u[i] = -1;
                bArrM8642u[i + 1] = ExifInterface.MARKER_EOI;
                i = i2;
            }
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrM8642u, 0, i, options);
            AnimatableValueParser.m591y(bitmapDecodeByteArray, "BitmapFactory returned null");
            closeableReferenceM1391a.close();
            return bitmapDecodeByteArray;
        } catch (Throwable th) {
            if (closeableReferenceM1391a != null) {
                closeableReferenceM1391a.close();
            }
            throw th;
        }
    }
}
