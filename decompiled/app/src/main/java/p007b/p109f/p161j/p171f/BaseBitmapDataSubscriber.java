package p007b.p109f.p161j.p171f;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import p007b.p109f.p129e.BaseDataSubscriber;
import p007b.p109f.p161j.p175j.CloseableBitmap;
import p007b.p109f.p161j.p175j.CloseableImage;

/* JADX INFO: renamed from: b.f.j.f.c, reason: use source file name */
/* JADX INFO: compiled from: BaseBitmapDataSubscriber.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseBitmapDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    public abstract void onNewResultImpl(Bitmap bitmap);

    @Override // p007b.p109f.p129e.BaseDataSubscriber
    public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        if (dataSource.mo1019c()) {
            CloseableReference<CloseableImage> result = dataSource.getResult();
            Bitmap bitmapMo1332f = null;
            if (result != null && (result.m8642u() instanceof CloseableBitmap)) {
                bitmapMo1332f = ((CloseableBitmap) result.m8642u()).mo1332f();
            }
            try {
                onNewResultImpl(bitmapMo1332f);
            } finally {
                Class<CloseableReference> cls = CloseableReference.f19438j;
                if (result != null) {
                    result.close();
                }
            }
        }
    }
}
