package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: WidgetDiscoveryStageCardSpeakerBinding.java */
/* renamed from: b.a.i.g5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetDiscoveryStageCardSpeakerBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f877a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f878b;

    /* renamed from: c */
    @NonNull
    public final TextView f879c;

    public WidgetDiscoveryStageCardSpeakerBinding(@NonNull LinearLayout linearLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.f877a = linearLayout;
        this.f878b = simpleDraweeView;
        this.f879c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f877a;
    }
}
