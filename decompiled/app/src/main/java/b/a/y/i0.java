package b.a.y;

import android.graphics.Bitmap;
import com.discord.views.VoiceUserView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: VoiceUserView.kt */
/* loaded from: classes2.dex */
public final class i0 extends b.f.j.q.a {
    public final /* synthetic */ VoiceUserView.c a;

    public i0(VoiceUserView.c cVar) {
        this.a = cVar;
    }

    @Override // b.f.j.q.a
    public void process(Bitmap bitmap) {
        if (bitmap != null) {
            Function2<? super Bitmap, ? super String, Unit> function2 = VoiceUserView.this.onBitmapLoadedListener;
            Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
            d0.z.d.m.checkNotNullExpressionValue(bitmapCopy, "bitmap.copy(Bitmap.Config.ARGB_8888, false)");
            function2.invoke(bitmapCopy, this.a.$newAvatarUrl);
        }
    }
}
