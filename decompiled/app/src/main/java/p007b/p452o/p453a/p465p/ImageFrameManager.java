package p007b.p452o.p453a.p465p;

import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.o.a.p.e, reason: use source file name */
/* JADX INFO: compiled from: ImageFrameManager.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(19)
public class ImageFrameManager extends FrameManager<Image> {
    public ImageFrameManager(int i) {
        super(i, Image.class);
    }

    @Override // p007b.p452o.p453a.p465p.FrameManager
    /* JADX INFO: renamed from: c */
    public void mo7380c(@NonNull Image image, boolean z2) {
        try {
            image.close();
        } catch (Exception unused) {
        }
    }
}
