package p007b.p109f.p161j.p181p;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p115d.p127l.UriUtil;
import p007b.p109f.p161j.p169d.ResizeOptions;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* JADX INFO: renamed from: b.f.j.p.f0, reason: use source file name */
/* JADX INFO: compiled from: LocalContentUriThumbnailFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class LocalContentUriThumbnailFetchProducer extends LocalFetchProducer implements ThumbnailProducer<EncodedImage2> {

    /* JADX INFO: renamed from: c */
    public static final String[] f4046c = {"_id", "_data"};

    /* JADX INFO: renamed from: d */
    public static final String[] f4047d = {"_data"};

    /* JADX INFO: renamed from: e */
    public static final Rect f4048e = new Rect(0, 0, 512, 384);

    /* JADX INFO: renamed from: f */
    public static final Rect f4049f = new Rect(0, 0, 96, 96);

    /* JADX INFO: renamed from: g */
    public final ContentResolver f4050g;

    public LocalContentUriThumbnailFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.f4050g = contentResolver;
    }

    @Override // p007b.p109f.p161j.p181p.ThumbnailProducer
    /* JADX INFO: renamed from: a */
    public boolean mo1474a(ResizeOptions resizeOptions) {
        Rect rect = f4048e;
        return AnimatableValueParser.m472S0(rect.width(), rect.height(), resizeOptions);
    }

    @Override // p007b.p109f.p161j.p181p.LocalFetchProducer
    /* JADX INFO: renamed from: d */
    public EncodedImage2 mo1428d(ImageRequest imageRequest) throws IOException {
        ResizeOptions resizeOptions;
        Cursor cursorQuery;
        EncodedImage2 encodedImage2M1475f;
        Uri uri = imageRequest.f19585c;
        if (!UriUtil.m1006b(uri) || (resizeOptions = imageRequest.f19592j) == null || (cursorQuery = this.f4050g.query(uri, f4046c, null, null, null)) == null) {
            return null;
        }
        try {
            if (!cursorQuery.moveToFirst() || (encodedImage2M1475f = m1475f(resizeOptions, cursorQuery.getLong(cursorQuery.getColumnIndex("_id")))) == null) {
                return null;
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
            int iM568s0 = 0;
            if (string != null) {
                try {
                    iM568s0 = AnimatableValueParser.m568s0(new ExifInterface(string).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1));
                } catch (IOException e) {
                    FLog.m976d(LocalContentUriThumbnailFetchProducer.class, e, "Unable to retrieve thumbnail rotation for %s", string);
                }
            }
            encodedImage2M1475f.f3894m = iM568s0;
            return encodedImage2M1475f;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // p007b.p109f.p161j.p181p.LocalFetchProducer
    /* JADX INFO: renamed from: e */
    public String mo1429e() {
        return "LocalContentUriThumbnailFetchProducer";
    }

    /* JADX INFO: renamed from: f */
    public final EncodedImage2 m1475f(ResizeOptions resizeOptions, long j) throws IOException {
        int i;
        Cursor cursorQueryMiniThumbnail;
        Rect rect = f4049f;
        if (AnimatableValueParser.m472S0(rect.width(), rect.height(), resizeOptions)) {
            i = 3;
        } else {
            Rect rect2 = f4048e;
            i = AnimatableValueParser.m472S0(rect2.width(), rect2.height(), resizeOptions) ? 1 : 0;
        }
        if (i == 0 || (cursorQueryMiniThumbnail = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.f4050g, j, i, f4047d)) == null) {
            return null;
        }
        try {
            if (cursorQueryMiniThumbnail.moveToFirst()) {
                String string = cursorQueryMiniThumbnail.getString(cursorQueryMiniThumbnail.getColumnIndex("_data"));
                Objects.requireNonNull(string);
                if (new File(string).exists()) {
                    return m1478c(new FileInputStream(string), (int) new File(string).length());
                }
            }
            return null;
        } finally {
            cursorQueryMiniThumbnail.close();
        }
    }
}
