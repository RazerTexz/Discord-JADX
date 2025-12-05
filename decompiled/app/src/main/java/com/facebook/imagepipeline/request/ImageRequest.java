package com.facebook.imagepipeline.request;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.cache.common.CacheKey;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.Fn;
import p007b.p109f.p115d.p119d.Objects2;
import p007b.p109f.p115d.p121f.MediaUtils;
import p007b.p109f.p115d.p121f.MimeTypeMapWrapper;
import p007b.p109f.p115d.p127l.UriUtil;
import p007b.p109f.p161j.p169d.BytesRange;
import p007b.p109f.p161j.p169d.ImageDecodeOptions;
import p007b.p109f.p161j.p169d.Priority2;
import p007b.p109f.p161j.p169d.ResizeOptions;
import p007b.p109f.p161j.p169d.RotationOptions;
import p007b.p109f.p161j.p176k.RequestListener;
import p007b.p109f.p161j.p182q.Postprocessor;

/* loaded from: classes3.dex */
public class ImageRequest {

    /* renamed from: a */
    public static final Fn<ImageRequest, Uri> f19583a = new C10665a();

    /* renamed from: b */
    public final EnumC10666b f19584b;

    /* renamed from: c */
    public final Uri f19585c;

    /* renamed from: d */
    public final int f19586d;

    /* renamed from: e */
    public File f19587e;

    /* renamed from: f */
    public final boolean f19588f;

    /* renamed from: g */
    public final boolean f19589g;

    /* renamed from: h */
    public final boolean f19590h;

    /* renamed from: i */
    public final ImageDecodeOptions f19591i;

    /* renamed from: j */
    public final ResizeOptions f19592j;

    /* renamed from: k */
    public final RotationOptions f19593k;

    /* renamed from: l */
    public final BytesRange f19594l;

    /* renamed from: m */
    public final Priority2 f19595m;

    /* renamed from: n */
    public final EnumC10667c f19596n;

    /* renamed from: o */
    public final int f19597o;

    /* renamed from: p */
    public final boolean f19598p;

    /* renamed from: q */
    public final boolean f19599q;

    /* renamed from: r */
    public final Boolean f19600r;

    /* renamed from: s */
    public final Postprocessor f19601s;

    /* renamed from: t */
    public final RequestListener f19602t;

    /* renamed from: u */
    public final int f19603u;

    /* renamed from: com.facebook.imagepipeline.request.ImageRequest$a */
    public static class C10665a implements Fn<ImageRequest, Uri> {
    }

    /* renamed from: com.facebook.imagepipeline.request.ImageRequest$b */
    public enum EnumC10666b {
        SMALL,
        DEFAULT
    }

    /* renamed from: com.facebook.imagepipeline.request.ImageRequest$c */
    public enum EnumC10667c {
        FULL_FETCH(1),
        DISK_CACHE(2),
        ENCODED_MEMORY_CACHE(3),
        BITMAP_MEMORY_CACHE(4);

        private int mValue;

        EnumC10667c(int i) {
            this.mValue = i;
        }

        /* renamed from: f */
        public static EnumC10667c m8721f(EnumC10667c enumC10667c, EnumC10667c enumC10667c2) {
            return enumC10667c.mValue > enumC10667c2.mValue ? enumC10667c : enumC10667c2;
        }

        /* renamed from: g */
        public int m8722g() {
            return this.mValue;
        }
    }

    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.f19584b = imageRequestBuilder.f19618g;
        Uri uri = imageRequestBuilder.f19612a;
        this.f19585c = uri;
        int i = -1;
        if (uri != null) {
            if (UriUtil.m1009e(uri)) {
                i = 0;
            } else if (UriUtil.m1008d(uri)) {
                String path = uri.getPath();
                Map<String, String> map = MediaUtils.f3103a;
                int iLastIndexOf = path.lastIndexOf(46);
                String mimeTypeFromExtension = null;
                String strSubstring = (iLastIndexOf < 0 || iLastIndexOf == path.length() + (-1)) ? null : path.substring(iLastIndexOf + 1);
                if (strSubstring != null) {
                    String lowerCase = strSubstring.toLowerCase(Locale.US);
                    String str = MimeTypeMapWrapper.f3106c.get(lowerCase);
                    mimeTypeFromExtension = str == null ? MimeTypeMapWrapper.f3104a.getMimeTypeFromExtension(lowerCase) : str;
                    if (mimeTypeFromExtension == null) {
                        mimeTypeFromExtension = MediaUtils.f3103a.get(lowerCase);
                    }
                }
                i = mimeTypeFromExtension != null && mimeTypeFromExtension.startsWith("video/") ? 2 : 3;
            } else if (UriUtil.m1007c(uri)) {
                i = 4;
            } else if (ModelAuditLogEntry.CHANGE_KEY_ASSET.equals(UriUtil.m1005a(uri))) {
                i = 5;
            } else if ("res".equals(UriUtil.m1005a(uri))) {
                i = 6;
            } else if ("data".equals(UriUtil.m1005a(uri))) {
                i = 7;
            } else if ("android.resource".equals(UriUtil.m1005a(uri))) {
                i = 8;
            }
        }
        this.f19586d = i;
        this.f19588f = imageRequestBuilder.f19619h;
        this.f19589g = imageRequestBuilder.f19620i;
        this.f19590h = imageRequestBuilder.f19621j;
        this.f19591i = imageRequestBuilder.f19617f;
        this.f19592j = imageRequestBuilder.f19615d;
        RotationOptions rotationOptions = imageRequestBuilder.f19616e;
        this.f19593k = rotationOptions == null ? RotationOptions.f3721a : rotationOptions;
        this.f19594l = imageRequestBuilder.f19626o;
        this.f19595m = imageRequestBuilder.f19622k;
        this.f19596n = imageRequestBuilder.f19613b;
        int i2 = imageRequestBuilder.f19614c;
        this.f19597o = i2;
        this.f19598p = (i2 & 48) == 0 && UriUtil.m1009e(imageRequestBuilder.f19612a);
        this.f19599q = (imageRequestBuilder.f19614c & 15) == 0;
        this.f19600r = imageRequestBuilder.f19624m;
        this.f19601s = imageRequestBuilder.f19623l;
        this.f19602t = imageRequestBuilder.f19625n;
        this.f19603u = imageRequestBuilder.f19627p;
    }

    /* renamed from: a */
    public synchronized File m8719a() {
        if (this.f19587e == null) {
            this.f19587e = new File(this.f19585c.getPath());
        }
        return this.f19587e;
    }

    /* renamed from: b */
    public boolean m8720b(int i) {
        return (i & this.f19597o) == 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        if (this.f19589g != imageRequest.f19589g || this.f19598p != imageRequest.f19598p || this.f19599q != imageRequest.f19599q || !AnimatableValueParser.m520g0(this.f19585c, imageRequest.f19585c) || !AnimatableValueParser.m520g0(this.f19584b, imageRequest.f19584b) || !AnimatableValueParser.m520g0(this.f19587e, imageRequest.f19587e) || !AnimatableValueParser.m520g0(this.f19594l, imageRequest.f19594l) || !AnimatableValueParser.m520g0(this.f19591i, imageRequest.f19591i) || !AnimatableValueParser.m520g0(this.f19592j, imageRequest.f19592j) || !AnimatableValueParser.m520g0(this.f19595m, imageRequest.f19595m) || !AnimatableValueParser.m520g0(this.f19596n, imageRequest.f19596n) || !AnimatableValueParser.m520g0(Integer.valueOf(this.f19597o), Integer.valueOf(imageRequest.f19597o)) || !AnimatableValueParser.m520g0(this.f19600r, imageRequest.f19600r)) {
            return false;
        }
        if (!AnimatableValueParser.m520g0(null, null) || !AnimatableValueParser.m520g0(this.f19593k, imageRequest.f19593k) || this.f19590h != imageRequest.f19590h) {
            return false;
        }
        Postprocessor postprocessor = this.f19601s;
        CacheKey postprocessorCacheKey = postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null;
        Postprocessor postprocessor2 = imageRequest.f19601s;
        return AnimatableValueParser.m520g0(postprocessorCacheKey, postprocessor2 != null ? postprocessor2.getPostprocessorCacheKey() : null) && this.f19603u == imageRequest.f19603u;
    }

    public int hashCode() {
        Postprocessor postprocessor = this.f19601s;
        return Arrays.hashCode(new Object[]{this.f19584b, this.f19585c, Boolean.valueOf(this.f19589g), this.f19594l, this.f19595m, this.f19596n, Integer.valueOf(this.f19597o), Boolean.valueOf(this.f19598p), Boolean.valueOf(this.f19599q), this.f19591i, this.f19600r, this.f19592j, this.f19593k, postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null, null, Integer.valueOf(this.f19603u), Boolean.valueOf(this.f19590h)});
    }

    public String toString() {
        Objects2 objects2M526h2 = AnimatableValueParser.m526h2(this);
        objects2M526h2.m971c(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, this.f19585c);
        objects2M526h2.m971c("cacheChoice", this.f19584b);
        objects2M526h2.m971c("decodeOptions", this.f19591i);
        objects2M526h2.m971c("postprocessor", this.f19601s);
        objects2M526h2.m971c("priority", this.f19595m);
        objects2M526h2.m971c("resizeOptions", this.f19592j);
        objects2M526h2.m971c("rotationOptions", this.f19593k);
        objects2M526h2.m971c("bytesRange", this.f19594l);
        objects2M526h2.m971c("resizingAllowedOverride", null);
        objects2M526h2.m970b("progressiveRenderingEnabled", this.f19588f);
        objects2M526h2.m970b("localThumbnailPreviewsEnabled", this.f19589g);
        objects2M526h2.m970b("loadThumbnailOnly", this.f19590h);
        objects2M526h2.m971c("lowestPermittedRequestLevel", this.f19596n);
        objects2M526h2.m969a("cachesDisabled", this.f19597o);
        objects2M526h2.m970b("isDiskCacheEnabled", this.f19598p);
        objects2M526h2.m970b("isMemoryCacheEnabled", this.f19599q);
        objects2M526h2.m971c("decodePrefetches", this.f19600r);
        objects2M526h2.m969a("delayMs", this.f19603u);
        return objects2M526h2.toString();
    }
}
