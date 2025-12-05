package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ImageDecoder.kt */
/* renamed from: androidx.core.graphics.ImageDecoderKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ImageDecoder {

    /* compiled from: ImageDecoder.kt */
    /* renamed from: androidx.core.graphics.ImageDecoderKt$decodeBitmap$1 */
    public static final class C02241 implements ImageDecoder.OnHeaderDecodedListener {
        public final /* synthetic */ Function3<android.graphics.ImageDecoder, ImageDecoder.ImageInfo, ImageDecoder.Source, Unit> $action;

        /* JADX WARN: Multi-variable type inference failed */
        public C02241(Function3<? super android.graphics.ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) {
            this.$action = function3;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        public final void onHeaderDecoded(android.graphics.ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            Intrinsics3.checkNotNullParameter(imageDecoder, "decoder");
            Intrinsics3.checkNotNullParameter(imageInfo, "info");
            Intrinsics3.checkNotNullParameter(source, "source");
            this.$action.invoke(imageDecoder, imageInfo, source);
        }
    }

    /* compiled from: ImageDecoder.kt */
    /* renamed from: androidx.core.graphics.ImageDecoderKt$decodeDrawable$1 */
    public static final class C02251 implements ImageDecoder.OnHeaderDecodedListener {
        public final /* synthetic */ Function3<android.graphics.ImageDecoder, ImageDecoder.ImageInfo, ImageDecoder.Source, Unit> $action;

        /* JADX WARN: Multi-variable type inference failed */
        public C02251(Function3<? super android.graphics.ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) {
            this.$action = function3;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        public final void onHeaderDecoded(android.graphics.ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            Intrinsics3.checkNotNullParameter(imageDecoder, "decoder");
            Intrinsics3.checkNotNullParameter(imageInfo, "info");
            Intrinsics3.checkNotNullParameter(source, "source");
            this.$action.invoke(imageDecoder, imageInfo, source);
        }
    }

    @RequiresApi(28)
    public static final Bitmap decodeBitmap(ImageDecoder.Source source, Function3<? super android.graphics.ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) throws IOException {
        Intrinsics3.checkNotNullParameter(source, "<this>");
        Intrinsics3.checkNotNullParameter(function3, "action");
        Bitmap bitmapDecodeBitmap = android.graphics.ImageDecoder.decodeBitmap(source, new C02241(function3));
        Intrinsics3.checkNotNullExpressionValue(bitmapDecodeBitmap, "crossinline action: ImageDecoder.(info: ImageInfo, source: Source) -> Unit\n): Bitmap {\n    return ImageDecoder.decodeBitmap(this) { decoder, info, source ->\n        decoder.action(info, source)\n    }");
        return bitmapDecodeBitmap;
    }

    @RequiresApi(28)
    public static final Drawable decodeDrawable(ImageDecoder.Source source, Function3<? super android.graphics.ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) throws IOException {
        Intrinsics3.checkNotNullParameter(source, "<this>");
        Intrinsics3.checkNotNullParameter(function3, "action");
        Drawable drawableDecodeDrawable = android.graphics.ImageDecoder.decodeDrawable(source, new C02251(function3));
        Intrinsics3.checkNotNullExpressionValue(drawableDecodeDrawable, "crossinline action: ImageDecoder.(info: ImageInfo, source: Source) -> Unit\n): Drawable {\n    return ImageDecoder.decodeDrawable(this) { decoder, info, source ->\n        decoder.action(info, source)\n    }");
        return drawableDecodeDrawable;
    }
}
