package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* compiled from: ViewServerSettingsUploadBannerBinding.java */
/* renamed from: b.a.i.n3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewServerSettingsUploadBannerBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1077a;

    /* renamed from: b */
    @NonNull
    public final ViewServerSettingsUploadBannerAnimatedUpsellBinding f1078b;

    /* renamed from: c */
    @NonNull
    public final FrameLayout f1079c;

    /* renamed from: d */
    @NonNull
    public final TextView f1080d;

    /* renamed from: e */
    @NonNull
    public final SimpleDraweeView f1081e;

    /* renamed from: f */
    @NonNull
    public final FloatingActionButton f1082f;

    /* renamed from: g */
    @NonNull
    public final LinkifiedTextView f1083g;

    /* renamed from: h */
    @NonNull
    public final TextView f1084h;

    /* renamed from: i */
    @NonNull
    public final TextView f1085i;

    public ViewServerSettingsUploadBannerBinding(@NonNull LinearLayout linearLayout, @NonNull ViewServerSettingsUploadBannerAnimatedUpsellBinding viewServerSettingsUploadBannerAnimatedUpsellBinding, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull FloatingActionButton floatingActionButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f1077a = linearLayout;
        this.f1078b = viewServerSettingsUploadBannerAnimatedUpsellBinding;
        this.f1079c = frameLayout;
        this.f1080d = textView;
        this.f1081e = simpleDraweeView;
        this.f1082f = floatingActionButton;
        this.f1083g = linkifiedTextView;
        this.f1084h = textView2;
        this.f1085i = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1077a;
    }
}
