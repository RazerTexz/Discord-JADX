package p007b.p452o.p453a.p465p;

import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: ImageFrameManager.java */
@RequiresApi(19)
/* renamed from: b.o.a.p.e, reason: use source file name */
/* loaded from: classes3.dex */
public class ImageFrameManager extends FrameManager<Image> {
    public ImageFrameManager(int i) {
        super(i, Image.class);
    }

    @Override // p007b.p452o.p453a.p465p.FrameManager
    /* renamed from: c */
    public void mo7380c(@NonNull Image image, boolean z2) {
        try {
            image.close();
        } catch (Exception unused) {
        }
    }
}
