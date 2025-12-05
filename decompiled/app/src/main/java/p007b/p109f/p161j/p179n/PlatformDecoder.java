package p007b.p109f.p161j.p179n;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* compiled from: PlatformDecoder.java */
/* renamed from: b.f.j.n.d, reason: use source file name */
/* loaded from: classes3.dex */
public interface PlatformDecoder {
    /* renamed from: a */
    CloseableReference<Bitmap> mo1414a(EncodedImage2 encodedImage2, Bitmap.Config config, Rect rect, ColorSpace colorSpace);

    /* renamed from: b */
    CloseableReference<Bitmap> mo1415b(EncodedImage2 encodedImage2, Bitmap.Config config, Rect rect, int i, ColorSpace colorSpace);
}
