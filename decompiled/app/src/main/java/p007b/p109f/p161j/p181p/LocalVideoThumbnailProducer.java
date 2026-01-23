package p007b.p109f.p161j.p181p;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.webrtc.MediaStreamTrack;
import p007b.p109f.p115d.p119d.ImmutableMap;
import p007b.p109f.p115d.p127l.UriUtil;
import p007b.p109f.p161j.p167b.SimpleBitmapReleaser;
import p007b.p109f.p161j.p169d.ResizeOptions;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p175j.CloseableStaticBitmap;
import p007b.p109f.p161j.p175j.ImmutableQualityInfo;

/* JADX INFO: renamed from: b.f.j.p.k0, reason: use source file name */
/* JADX INFO: compiled from: LocalVideoThumbnailProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class LocalVideoThumbnailProducer implements Producer2<CloseableReference<CloseableImage>> {

    /* JADX INFO: renamed from: a */
    public final Executor f4120a;

    /* JADX INFO: renamed from: b */
    public final ContentResolver f4121b;

    /* JADX INFO: renamed from: b.f.j.p.k0$a */
    /* JADX INFO: compiled from: LocalVideoThumbnailProducer.java */
    public class a extends StatefulProducerRunnable<CloseableReference<CloseableImage>> {

        /* JADX INFO: renamed from: o */
        public final /* synthetic */ ProducerListener2 f4122o;

        /* JADX INFO: renamed from: p */
        public final /* synthetic */ ProducerContext f4123p;

        /* JADX INFO: renamed from: q */
        public final /* synthetic */ ImageRequest f4124q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer2 consumer2, ProducerListener2 producerListener2, ProducerContext producerContext, String str, ProducerListener2 producerListener22, ProducerContext producerContext2, ImageRequest imageRequest) {
            super(consumer2, producerListener2, producerContext, str);
            this.f4122o = producerListener22;
            this.f4123p = producerContext2;
            this.f4124q = imageRequest;
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* JADX INFO: renamed from: b */
        public void mo1465b(CloseableReference<CloseableImage> closeableReference) {
            CloseableReference<CloseableImage> closeableReference2 = closeableReference;
            Class<CloseableReference> cls = CloseableReference.f19438j;
            if (closeableReference2 != null) {
                closeableReference2.close();
            }
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* JADX INFO: renamed from: c */
        public Map mo1466c(CloseableReference<CloseableImage> closeableReference) {
            return ImmutableMap.m967of("createdThumbnail", String.valueOf(closeableReference != null));
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0027  */
        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* JADX INFO: renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public CloseableReference<CloseableImage> mo1467d() throws Exception {
            String strM1481c;
            Bitmap frameAtTime;
            int i;
            try {
                strM1481c = LocalVideoThumbnailProducer.m1481c(LocalVideoThumbnailProducer.this, this.f4124q);
            } catch (IllegalArgumentException unused) {
                strM1481c = null;
            }
            if (strM1481c != null) {
                ResizeOptions resizeOptions = this.f4124q.f19592j;
                if ((resizeOptions != null ? resizeOptions.f3717a : 2048) > 96) {
                    i = 1;
                    frameAtTime = ThumbnailUtils.createVideoThumbnail(strM1481c, i);
                } else {
                    if ((resizeOptions != null ? resizeOptions.f3718b : 2048) <= 96) {
                        i = 3;
                    }
                    frameAtTime = ThumbnailUtils.createVideoThumbnail(strM1481c, i);
                }
            } else {
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = LocalVideoThumbnailProducer.this.f4121b.openFileDescriptor(this.f4124q.f19585c, "r");
                    Objects.requireNonNull(parcelFileDescriptorOpenFileDescriptor);
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L);
                } catch (FileNotFoundException unused2) {
                    frameAtTime = null;
                }
            }
            if (frameAtTime == null) {
                return null;
            }
            CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(frameAtTime, SimpleBitmapReleaser.m1207a(), ImmutableQualityInfo.f3908a, 0);
            this.f4123p.mo1446d("image_format", "thumbnail");
            closeableStaticBitmap.m1335e(this.f4123p.mo1443a());
            return CloseableReference.m8632A(closeableStaticBitmap);
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* JADX INFO: renamed from: f */
        public void mo1469f(Exception exc) {
            super.mo1469f(exc);
            this.f4122o.mo1356c(this.f4123p, "VideoThumbnailProducer", false);
            this.f4123p.mo1456n("local");
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* JADX INFO: renamed from: g */
        public void mo1470g(CloseableReference<CloseableImage> closeableReference) {
            CloseableReference<CloseableImage> closeableReference2 = closeableReference;
            super.mo1470g(closeableReference2);
            this.f4122o.mo1356c(this.f4123p, "VideoThumbnailProducer", closeableReference2 != null);
            this.f4123p.mo1456n("local");
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.k0$b */
    /* JADX INFO: compiled from: LocalVideoThumbnailProducer.java */
    public class b extends BaseProducerContextCallbacks {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ StatefulProducerRunnable f4126a;

        public b(LocalVideoThumbnailProducer localVideoThumbnailProducer, StatefulProducerRunnable statefulProducerRunnable) {
            this.f4126a = statefulProducerRunnable;
        }

        @Override // p007b.p109f.p161j.p181p.ProducerContextCallbacks
        /* JADX INFO: renamed from: a */
        public void mo1438a() {
            this.f4126a.m1464a();
        }
    }

    public LocalVideoThumbnailProducer(Executor executor, ContentResolver contentResolver) {
        this.f4120a = executor;
        this.f4121b = contentResolver;
    }

    /* JADX INFO: renamed from: c */
    public static String m1481c(LocalVideoThumbnailProducer localVideoThumbnailProducer, ImageRequest imageRequest) {
        Uri uri;
        String str;
        String[] strArr;
        Objects.requireNonNull(localVideoThumbnailProducer);
        Uri uri2 = imageRequest.f19585c;
        if (UriUtil.m1008d(uri2)) {
            return imageRequest.m8719a().getPath();
        }
        if (UriUtil.m1007c(uri2)) {
            if ("com.android.providers.media.documents".equals(uri2.getAuthority())) {
                String documentId = DocumentsContract.getDocumentId(uri2);
                Objects.requireNonNull(documentId);
                Uri uri3 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                Objects.requireNonNull(uri3);
                str = "_id=?";
                uri = uri3;
                strArr = new String[]{documentId.split(":")[1]};
            } else {
                uri = uri2;
                str = null;
                strArr = null;
            }
            Cursor cursorQuery = localVideoThumbnailProducer.f4121b.query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        return cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    cursorQuery.close();
                }
            }
            if (cursorQuery != null) {
            }
        }
        return null;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* JADX INFO: renamed from: b */
    public void mo1417b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        ProducerListener2 producerListener2Mo1457o = producerContext.mo1457o();
        ImageRequest imageRequestMo1447e = producerContext.mo1447e();
        producerContext.mo1451i("local", MediaStreamTrack.VIDEO_TRACK_KIND);
        a aVar = new a(consumer2, producerListener2Mo1457o, producerContext, "VideoThumbnailProducer", producerListener2Mo1457o, producerContext, imageRequestMo1447e);
        producerContext.mo1448f(new b(this, aVar));
        this.f4120a.execute(aVar);
    }
}
