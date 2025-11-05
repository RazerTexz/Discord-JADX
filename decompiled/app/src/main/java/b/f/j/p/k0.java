package b.f.j.p;

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

/* compiled from: LocalVideoThumbnailProducer.java */
/* loaded from: classes3.dex */
public class k0 implements w0<CloseableReference<b.f.j.j.c>> {
    public final Executor a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentResolver f621b;

    /* compiled from: LocalVideoThumbnailProducer.java */
    public class a extends e1<CloseableReference<b.f.j.j.c>> {
        public final /* synthetic */ z0 o;
        public final /* synthetic */ x0 p;
        public final /* synthetic */ ImageRequest q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, z0 z0Var, x0 x0Var, String str, z0 z0Var2, x0 x0Var2, ImageRequest imageRequest) {
            super(lVar, z0Var, x0Var, str);
            this.o = z0Var2;
            this.p = x0Var2;
            this.q = imageRequest;
        }

        @Override // b.f.j.p.e1
        public void b(CloseableReference<b.f.j.j.c> closeableReference) {
            CloseableReference<b.f.j.j.c> closeableReference2 = closeableReference;
            Class<CloseableReference> cls = CloseableReference.j;
            if (closeableReference2 != null) {
                closeableReference2.close();
            }
        }

        @Override // b.f.j.p.e1
        public Map c(CloseableReference<b.f.j.j.c> closeableReference) {
            return b.f.d.d.f.of("createdThumbnail", String.valueOf(closeableReference != null));
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0027  */
        @Override // b.f.j.p.e1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public CloseableReference<b.f.j.j.c> d() throws Exception {
            String strC;
            Bitmap frameAtTime;
            int i;
            try {
                strC = k0.c(k0.this, this.q);
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                b.f.j.d.e eVar = this.q.j;
                if ((eVar != null ? eVar.a : 2048) > 96) {
                    i = 1;
                    frameAtTime = ThumbnailUtils.createVideoThumbnail(strC, i);
                } else {
                    if ((eVar != null ? eVar.f566b : 2048) <= 96) {
                        i = 3;
                    }
                    frameAtTime = ThumbnailUtils.createVideoThumbnail(strC, i);
                }
            } else {
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = k0.this.f621b.openFileDescriptor(this.q.c, "r");
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
            b.f.j.j.d dVar = new b.f.j.j.d(frameAtTime, b.f.j.b.b.a(), b.f.j.j.h.a, 0);
            this.p.d("image_format", "thumbnail");
            dVar.e(this.p.a());
            return CloseableReference.A(dVar);
        }

        @Override // b.f.j.p.e1
        public void f(Exception exc) {
            super.f(exc);
            this.o.c(this.p, "VideoThumbnailProducer", false);
            this.p.n("local");
        }

        @Override // b.f.j.p.e1
        public void g(CloseableReference<b.f.j.j.c> closeableReference) {
            CloseableReference<b.f.j.j.c> closeableReference2 = closeableReference;
            super.g(closeableReference2);
            this.o.c(this.p, "VideoThumbnailProducer", closeableReference2 != null);
            this.p.n("local");
        }
    }

    /* compiled from: LocalVideoThumbnailProducer.java */
    public class b extends e {
        public final /* synthetic */ e1 a;

        public b(k0 k0Var, e1 e1Var) {
            this.a = e1Var;
        }

        @Override // b.f.j.p.y0
        public void a() {
            this.a.a();
        }
    }

    public k0(Executor executor, ContentResolver contentResolver) {
        this.a = executor;
        this.f621b = contentResolver;
    }

    public static String c(k0 k0Var, ImageRequest imageRequest) {
        Uri uri;
        String str;
        String[] strArr;
        Objects.requireNonNull(k0Var);
        Uri uri2 = imageRequest.c;
        if (b.f.d.l.b.d(uri2)) {
            return imageRequest.a().getPath();
        }
        if (b.f.d.l.b.c(uri2)) {
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
            Cursor cursorQuery = k0Var.f621b.query(uri, new String[]{"_data"}, str, strArr, null);
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

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        z0 z0VarO = x0Var.o();
        ImageRequest imageRequestE = x0Var.e();
        x0Var.i("local", MediaStreamTrack.VIDEO_TRACK_KIND);
        a aVar = new a(lVar, z0VarO, x0Var, "VideoThumbnailProducer", z0VarO, x0Var, imageRequestE);
        x0Var.f(new b(this, aVar));
        this.a.execute(aVar);
    }
}
