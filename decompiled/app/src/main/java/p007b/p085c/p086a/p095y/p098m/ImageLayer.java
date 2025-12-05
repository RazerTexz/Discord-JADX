package p007b.p085c.p086a.p095y.p098m;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.ImageAssetDelegate;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.LottieImageAsset;
import p007b.p085c.p086a.LottieProperty;
import p007b.p085c.p086a.p089b0.Logger2;
import p007b.p085c.p086a.p089b0.Utils;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p091w.LPaint;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.ValueCallbackKeyframeAnimation;
import p007b.p085c.p086a.p094x.ImageAssetManager;

/* compiled from: ImageLayer.java */
/* renamed from: b.c.a.y.m.d, reason: use source file name */
/* loaded from: classes.dex */
public class ImageLayer extends BaseLayer2 {

    /* renamed from: A */
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> f2864A;

    /* renamed from: x */
    public final Paint f2865x;

    /* renamed from: y */
    public final Rect f2866y;

    /* renamed from: z */
    public final Rect f2867z;

    public ImageLayer(LottieDrawable lottieDrawable, Layer2 layer2) {
        super(lottieDrawable, layer2);
        this.f2865x = new LPaint(3);
        this.f2866y = new Rect();
        this.f2867z = new Rect();
    }

    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2, p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        super.mo712d(rectF, matrix, z2);
        if (m787q() != null) {
            rectF.set(0.0f, 0.0f, Utils.m659c() * r3.getWidth(), Utils.m659c() * r3.getHeight());
            this.f2848m.mapRect(rectF);
        }
    }

    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2, p007b.p085c.p086a.p095y.KeyPathElement
    /* renamed from: g */
    public <T> void mo714g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        this.f2857v.m745c(t, lottieValueCallback);
        if (t == LottieProperty.f2421C) {
            if (lottieValueCallback == null) {
                this.f2864A = null;
            } else {
                this.f2864A = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            }
        }
    }

    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2
    /* renamed from: j */
    public void mo780j(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmapM787q = m787q();
        if (bitmapM787q == null || bitmapM787q.isRecycled()) {
            return;
        }
        float fM659c = Utils.m659c();
        this.f2865x.setAlpha(i);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f2864A;
        if (baseKeyframeAnimation != null) {
            this.f2865x.setColorFilter(baseKeyframeAnimation.mo727e());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f2866y.set(0, 0, bitmapM787q.getWidth(), bitmapM787q.getHeight());
        this.f2867z.set(0, 0, (int) (bitmapM787q.getWidth() * fM659c), (int) (bitmapM787q.getHeight() * fM659c));
        canvas.drawBitmap(bitmapM787q, this.f2866y, this.f2867z, this.f2865x);
        canvas.restore();
    }

    @Nullable
    /* renamed from: q */
    public final Bitmap m787q() {
        ImageAssetManager imageAssetManager;
        LottieImageAsset lottieImageAsset;
        String str = this.f2850o.f2874g;
        LottieDrawable lottieDrawable = this.f2849n;
        if (lottieDrawable.getCallback() == null) {
            imageAssetManager = null;
        } else {
            ImageAssetManager imageAssetManager2 = lottieDrawable.f2378s;
            if (imageAssetManager2 != null) {
                Drawable.Callback callback = lottieDrawable.getCallback();
                Context context = (callback != null && (callback instanceof View)) ? ((View) callback).getContext() : null;
                if (!((context == null && imageAssetManager2.f2648b == null) || imageAssetManager2.f2648b.equals(context))) {
                    lottieDrawable.f2378s = null;
                }
            }
            if (lottieDrawable.f2378s == null) {
                lottieDrawable.f2378s = new ImageAssetManager(lottieDrawable.getCallback(), lottieDrawable.f2379t, lottieDrawable.f2380u, lottieDrawable.f2370k.f2339d);
            }
            imageAssetManager = lottieDrawable.f2378s;
        }
        if (imageAssetManager == null || (lottieImageAsset = imageAssetManager.f2651e.get(str)) == null) {
            return null;
        }
        Bitmap bitmap = lottieImageAsset.f2418e;
        if (bitmap != null) {
            return bitmap;
        }
        ImageAssetDelegate imageAssetDelegate = imageAssetManager.f2650d;
        if (imageAssetDelegate != null) {
            Bitmap bitmapM636a = imageAssetDelegate.m636a(lottieImageAsset);
            if (bitmapM636a == null) {
                return bitmapM636a;
            }
            imageAssetManager.m749a(str, bitmapM636a);
            return bitmapM636a;
        }
        String str2 = lottieImageAsset.f2417d;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = Opcodes.IF_ICMPNE;
        if (str2.startsWith("data:") && str2.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(str2.substring(str2.indexOf(44) + 1), 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                imageAssetManager.m749a(str, bitmapDecodeByteArray);
                return bitmapDecodeByteArray;
            } catch (IllegalArgumentException e) {
                Logger2.m641c("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(imageAssetManager.f2649c)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            Bitmap bitmapM661e = Utils.m661e(BitmapFactory.decodeStream(imageAssetManager.f2648b.getAssets().open(imageAssetManager.f2649c + str2), null, options), lottieImageAsset.f2414a, lottieImageAsset.f2415b);
            imageAssetManager.m749a(str, bitmapM661e);
            return bitmapM661e;
        } catch (IOException e2) {
            Logger2.m641c("Unable to open asset.", e2);
            return null;
        }
    }
}
