package b.o.a.p;

import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: ImageFrameManager.java */
@RequiresApi(19)
/* loaded from: classes3.dex */
public class e extends c<Image> {
    public e(int i) {
        super(i, Image.class);
    }

    @Override // b.o.a.p.c
    public void c(@NonNull Image image, boolean z2) {
        try {
            image.close();
        } catch (Exception unused) {
        }
    }
}
