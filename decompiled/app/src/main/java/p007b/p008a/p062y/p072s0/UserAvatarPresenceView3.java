package p007b.p008a.p062y.p072s0;

import android.graphics.Bitmap;
import com.discord.views.user.UserAvatarPresenceView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p007b.p109f.p161j.p182q.BasePostprocessor;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.y.s0.b, reason: use source file name */
/* JADX INFO: compiled from: UserAvatarPresenceView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAvatarPresenceView3 extends BasePostprocessor {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ UserAvatarPresenceView.C7134d f2070a;

    public UserAvatarPresenceView3(UserAvatarPresenceView.C7134d c7134d) {
        this.f2070a = c7134d;
    }

    @Override // p007b.p109f.p161j.p182q.BasePostprocessor
    public void process(Bitmap bitmap) {
        if (bitmap != null) {
            Function2<? super Bitmap, ? super String, Unit> function2 = UserAvatarPresenceView.this.onAvatarBitmapLoadedListener;
            Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
            Intrinsics3.checkNotNullExpressionValue(bitmapCopy, "bitmap.copy(Bitmap.Config.ARGB_8888, false)");
            function2.invoke(bitmapCopy, this.f2070a.$iconUrl);
        }
    }
}
