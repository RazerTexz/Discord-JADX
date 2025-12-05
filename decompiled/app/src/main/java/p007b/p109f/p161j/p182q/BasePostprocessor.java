package p007b.p109f.p161j.p182q;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p007b.p109f.p161j.p170e.NativeCodeSetup;

/* compiled from: BasePostprocessor.java */
/* renamed from: b.f.j.q.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BasePostprocessor implements Postprocessor {
    public static final Bitmap.Config FALLBACK_BITMAP_CONFIGURATION = Bitmap.Config.ARGB_8888;
    private static Method sCopyBitmap;

    private static void internalCopyBitmap(Bitmap bitmap, Bitmap bitmap2) throws IllegalArgumentException {
        if (!NativeCodeSetup.f3808a || bitmap.getConfig() != bitmap2.getConfig()) {
            new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
            return;
        }
        try {
            if (sCopyBitmap == null) {
                sCopyBitmap = Class.forName("com.facebook.imagepipeline.nativecode.Bitmaps").getDeclaredMethod("copyBitmap", Bitmap.class, Bitmap.class);
            }
            sCopyBitmap.invoke(null, bitmap, bitmap2);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Wrong Native code setup, reflection failed.", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Wrong Native code setup, reflection failed.", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("Wrong Native code setup, reflection failed.", e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("Wrong Native code setup, reflection failed.", e4);
        }
    }

    @Override // p007b.p109f.p161j.p182q.Postprocessor
    public String getName() {
        return "Unknown postprocessor";
    }

    @Override // p007b.p109f.p161j.p182q.Postprocessor
    public CacheKey getPostprocessorCacheKey() {
        return null;
    }

    @Override // p007b.p109f.p161j.p182q.Postprocessor
    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        Bitmap.Config config = bitmap.getConfig();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (config == null) {
            config = FALLBACK_BITMAP_CONFIGURATION;
        }
        CloseableReference<Bitmap> closeableReferenceMo1206b = platformBitmapFactory.mo1206b(width, height, config);
        try {
            process(closeableReferenceMo1206b.m8642u(), bitmap);
            CloseableReference<Bitmap> closeableReferenceMo999b = closeableReferenceMo1206b.mo999b();
            closeableReferenceMo1206b.close();
            return closeableReferenceMo999b;
        } catch (Throwable th) {
            Class<CloseableReference> cls = CloseableReference.f19438j;
            if (closeableReferenceMo1206b != null) {
                closeableReferenceMo1206b.close();
            }
            throw th;
        }
    }

    public void process(Bitmap bitmap) {
    }

    public void process(Bitmap bitmap, Bitmap bitmap2) throws IllegalArgumentException {
        internalCopyBitmap(bitmap, bitmap2);
        process(bitmap);
    }
}
