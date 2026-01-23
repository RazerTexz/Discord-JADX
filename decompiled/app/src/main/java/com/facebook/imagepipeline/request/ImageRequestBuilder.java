package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p109f.p115d.p127l.UriUtil;
import p007b.p109f.p161j.p169d.BytesRange;
import p007b.p109f.p161j.p169d.ImageDecodeOptions;
import p007b.p109f.p161j.p169d.Priority2;
import p007b.p109f.p161j.p169d.ResizeOptions;
import p007b.p109f.p161j.p169d.RotationOptions;
import p007b.p109f.p161j.p176k.RequestListener;
import p007b.p109f.p161j.p182q.Postprocessor;

/* JADX INFO: loaded from: classes3.dex */
public class ImageRequestBuilder {

    /* JADX INFO: renamed from: n */
    public RequestListener f19625n;

    /* JADX INFO: renamed from: p */
    public int f19627p;

    /* JADX INFO: renamed from: a */
    public Uri f19612a = null;

    /* JADX INFO: renamed from: b */
    public ImageRequest.EnumC10667c f19613b = ImageRequest.EnumC10667c.FULL_FETCH;

    /* JADX INFO: renamed from: c */
    public int f19614c = 0;

    /* JADX INFO: renamed from: d */
    public ResizeOptions f19615d = null;

    /* JADX INFO: renamed from: e */
    public RotationOptions f19616e = null;

    /* JADX INFO: renamed from: f */
    public ImageDecodeOptions f19617f = ImageDecodeOptions.f3706a;

    /* JADX INFO: renamed from: g */
    public ImageRequest.EnumC10666b f19618g = ImageRequest.EnumC10666b.DEFAULT;

    /* JADX INFO: renamed from: h */
    public boolean f19619h = false;

    /* JADX INFO: renamed from: i */
    public boolean f19620i = false;

    /* JADX INFO: renamed from: j */
    public boolean f19621j = false;

    /* JADX INFO: renamed from: k */
    public Priority2 f19622k = Priority2.HIGH;

    /* JADX INFO: renamed from: l */
    public Postprocessor f19623l = null;

    /* JADX INFO: renamed from: m */
    public Boolean f19624m = null;

    /* JADX INFO: renamed from: o */
    public BytesRange f19626o = null;

    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super(outline.m883w("Invalid request builder: ", str));
        }
    }

    /* JADX INFO: renamed from: b */
    public static ImageRequestBuilder m8723b(Uri uri) {
        ImageRequestBuilder imageRequestBuilder = new ImageRequestBuilder();
        Objects.requireNonNull(uri);
        imageRequestBuilder.f19612a = uri;
        return imageRequestBuilder;
    }

    /* JADX INFO: renamed from: a */
    public ImageRequest m8724a() {
        Uri uri = this.f19612a;
        if (uri == null) {
            throw new BuilderException("Source must be set!");
        }
        if ("res".equals(UriUtil.m1005a(uri))) {
            if (!this.f19612a.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.f19612a.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.f19612a.getPath().substring(1));
            } catch (NumberFormatException unused) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (!ModelAuditLogEntry.CHANGE_KEY_ASSET.equals(UriUtil.m1005a(this.f19612a)) || this.f19612a.isAbsolute()) {
            return new ImageRequest(this);
        }
        throw new BuilderException("Asset URI path must be absolute.");
    }
}
