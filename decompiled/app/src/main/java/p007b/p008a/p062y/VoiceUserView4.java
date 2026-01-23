package p007b.p008a.p062y;

import android.graphics.Bitmap;
import com.discord.views.VoiceUserView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p007b.p109f.p161j.p182q.BasePostprocessor;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.y.i0, reason: use source file name */
/* JADX INFO: compiled from: VoiceUserView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceUserView4 extends BasePostprocessor {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ VoiceUserView.C7099c f2027a;

    public VoiceUserView4(VoiceUserView.C7099c c7099c) {
        this.f2027a = c7099c;
    }

    @Override // p007b.p109f.p161j.p182q.BasePostprocessor
    public void process(Bitmap bitmap) {
        if (bitmap != null) {
            Function2<? super Bitmap, ? super String, Unit> function2 = VoiceUserView.this.onBitmapLoadedListener;
            Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
            Intrinsics3.checkNotNullExpressionValue(bitmapCopy, "bitmap.copy(Bitmap.Config.ARGB_8888, false)");
            function2.invoke(bitmapCopy, this.f2027a.$newAvatarUrl);
        }
    }
}
