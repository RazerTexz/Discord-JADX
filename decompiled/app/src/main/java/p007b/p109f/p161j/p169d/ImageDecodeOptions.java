package p007b.p109f.p161j.p169d;

import android.graphics.Bitmap;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p109f.p115d.p119d.Objects2;

/* JADX INFO: renamed from: b.f.j.d.b, reason: use source file name */
/* JADX INFO: compiled from: ImageDecodeOptions.java */
/* JADX INFO: loaded from: classes.dex */
public class ImageDecodeOptions {

    /* JADX INFO: renamed from: a */
    public static final ImageDecodeOptions f3706a = new ImageDecodeOptions(new ImageDecodeOptionsBuilder());

    /* JADX INFO: renamed from: b */
    public final int f3707b = 100;

    /* JADX INFO: renamed from: c */
    public final int f3708c = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: d */
    public final Bitmap.Config f3709d;

    /* JADX INFO: renamed from: e */
    public final Bitmap.Config f3710e;

    public ImageDecodeOptions(ImageDecodeOptionsBuilder imageDecodeOptionsBuilder) {
        this.f3709d = imageDecodeOptionsBuilder.f3711a;
        this.f3710e = imageDecodeOptionsBuilder.f3712b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ImageDecodeOptions.class != obj.getClass()) {
            return false;
        }
        ImageDecodeOptions imageDecodeOptions = (ImageDecodeOptions) obj;
        return this.f3707b == imageDecodeOptions.f3707b && this.f3708c == imageDecodeOptions.f3708c && this.f3709d == imageDecodeOptions.f3709d && this.f3710e == imageDecodeOptions.f3710e;
    }

    public int hashCode() {
        int iOrdinal = (this.f3709d.ordinal() + (((((((((((this.f3707b * 31) + this.f3708c) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31)) * 31;
        Bitmap.Config config = this.f3710e;
        return ((((((iOrdinal + (config != null ? config.ordinal() : 0)) * 31) + 0) * 31) + 0) * 31) + 0;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ImageDecodeOptions{");
        Objects2 objects2M526h2 = AnimatableValueParser.m526h2(this);
        objects2M526h2.m969a("minDecodeIntervalMs", this.f3707b);
        objects2M526h2.m969a("maxDimensionPx", this.f3708c);
        objects2M526h2.m970b("decodePreviewFrame", false);
        objects2M526h2.m970b("useLastFrameForPreview", false);
        objects2M526h2.m970b("decodeAllFrames", false);
        objects2M526h2.m970b("forceStaticImage", false);
        objects2M526h2.m971c("bitmapConfigName", this.f3709d.name());
        objects2M526h2.m971c("animatedBitmapConfigName", this.f3710e.name());
        objects2M526h2.m971c("customImageDecoder", null);
        objects2M526h2.m971c("bitmapTransformation", null);
        objects2M526h2.m971c("colorSpace", null);
        return outline.m822J(sbM833U, objects2M526h2.toString(), "}");
    }
}
