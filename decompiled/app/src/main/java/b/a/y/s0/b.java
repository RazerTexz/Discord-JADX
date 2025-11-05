package b.a.y.s0;

import android.graphics.Bitmap;
import com.discord.views.user.UserAvatarPresenceView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: UserAvatarPresenceView.kt */
/* loaded from: classes2.dex */
public final class b extends b.f.j.q.a {
    public final /* synthetic */ UserAvatarPresenceView.d a;

    public b(UserAvatarPresenceView.d dVar) {
        this.a = dVar;
    }

    @Override // b.f.j.q.a
    public void process(Bitmap bitmap) {
        if (bitmap != null) {
            Function2<? super Bitmap, ? super String, Unit> function2 = UserAvatarPresenceView.this.onAvatarBitmapLoadedListener;
            Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
            m.checkNotNullExpressionValue(bitmapCopy, "bitmap.copy(Bitmap.Config.ARGB_8888, false)");
            function2.invoke(bitmapCopy, this.a.$iconUrl);
        }
    }
}
