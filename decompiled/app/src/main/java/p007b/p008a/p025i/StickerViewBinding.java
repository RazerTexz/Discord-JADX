package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.rlottie.RLottieImageView;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: StickerViewBinding.java */
/* renamed from: b.a.i.r1, reason: use source file name */
/* loaded from: classes.dex */
public final class StickerViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f1176a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f1177b;

    /* renamed from: c */
    @NonNull
    public final RLottieImageView f1178c;

    /* renamed from: d */
    @NonNull
    public final ImageView f1179d;

    public StickerViewBinding(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull RLottieImageView rLottieImageView, @NonNull ImageView imageView) {
        this.f1176a = view;
        this.f1177b = simpleDraweeView;
        this.f1178c = rLottieImageView;
        this.f1179d = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1176a;
    }
}
