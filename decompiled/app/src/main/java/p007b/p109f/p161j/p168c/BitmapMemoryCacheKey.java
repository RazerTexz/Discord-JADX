package p007b.p109f.p161j.p168c;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.time.RealtimeSinceBootClock;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p161j.p169d.ImageDecodeOptions;
import p007b.p109f.p161j.p169d.ResizeOptions;
import p007b.p109f.p161j.p169d.RotationOptions;

/* compiled from: BitmapMemoryCacheKey.java */
/* renamed from: b.f.j.c.b, reason: use source file name */
/* loaded from: classes.dex */
public class BitmapMemoryCacheKey implements CacheKey {

    /* renamed from: a */
    public final String f3648a;

    /* renamed from: b */
    public final ResizeOptions f3649b;

    /* renamed from: c */
    public final RotationOptions f3650c;

    /* renamed from: d */
    public final ImageDecodeOptions f3651d;

    /* renamed from: e */
    public final CacheKey f3652e;

    /* renamed from: f */
    public final String f3653f;

    /* renamed from: g */
    public final int f3654g;

    /* renamed from: h */
    public final Object f3655h;

    public BitmapMemoryCacheKey(String str, ResizeOptions resizeOptions, RotationOptions rotationOptions, ImageDecodeOptions imageDecodeOptions, CacheKey cacheKey, String str2, Object obj) {
        Objects.requireNonNull(str);
        this.f3648a = str;
        this.f3649b = resizeOptions;
        this.f3650c = rotationOptions;
        this.f3651d = imageDecodeOptions;
        this.f3652e = cacheKey;
        this.f3653f = str2;
        Integer numValueOf = Integer.valueOf(str.hashCode());
        Integer numValueOf2 = Integer.valueOf(resizeOptions != null ? resizeOptions.hashCode() : 0);
        Integer numValueOf3 = Integer.valueOf(rotationOptions.hashCode());
        int iHashCode = numValueOf == null ? 0 : numValueOf.hashCode();
        int iHashCode2 = numValueOf2 == null ? 0 : numValueOf2.hashCode();
        int iHashCode3 = numValueOf3 == null ? 0 : numValueOf3.hashCode();
        int iHashCode4 = imageDecodeOptions == null ? 0 : imageDecodeOptions.hashCode();
        this.f3654g = ((((((((((iHashCode + 31) * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + (cacheKey == null ? 0 : cacheKey.hashCode())) * 31) + (str2 != null ? str2.hashCode() : 0);
        this.f3655h = obj;
        RealtimeSinceBootClock.get().now();
    }

    @Override // com.facebook.cache.common.CacheKey
    /* renamed from: a */
    public boolean mo929a() {
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    /* renamed from: b */
    public String mo930b() {
        return this.f3648a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (!(obj instanceof BitmapMemoryCacheKey)) {
            return false;
        }
        BitmapMemoryCacheKey bitmapMemoryCacheKey = (BitmapMemoryCacheKey) obj;
        return this.f3654g == bitmapMemoryCacheKey.f3654g && this.f3648a.equals(bitmapMemoryCacheKey.f3648a) && AnimatableValueParser.m520g0(this.f3649b, bitmapMemoryCacheKey.f3649b) && AnimatableValueParser.m520g0(this.f3650c, bitmapMemoryCacheKey.f3650c) && AnimatableValueParser.m520g0(this.f3651d, bitmapMemoryCacheKey.f3651d) && AnimatableValueParser.m520g0(this.f3652e, bitmapMemoryCacheKey.f3652e) && AnimatableValueParser.m520g0(this.f3653f, bitmapMemoryCacheKey.f3653f);
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.f3654g;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.f3648a, this.f3649b, this.f3650c, this.f3651d, this.f3652e, this.f3653f, Integer.valueOf(this.f3654g));
    }
}
