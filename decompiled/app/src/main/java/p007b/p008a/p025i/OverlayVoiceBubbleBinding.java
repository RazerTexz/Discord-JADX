package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: OverlayVoiceBubbleBinding.java */
/* renamed from: b.a.i.a1, reason: use source file name */
/* loaded from: classes.dex */
public final class OverlayVoiceBubbleBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final SimpleDraweeView f661a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f662b;

    public OverlayVoiceBubbleBinding(@NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2) {
        this.f661a = simpleDraweeView;
        this.f662b = simpleDraweeView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f661a;
    }
}
