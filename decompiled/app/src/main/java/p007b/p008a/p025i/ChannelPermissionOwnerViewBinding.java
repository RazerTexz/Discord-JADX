package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: ChannelPermissionOwnerViewBinding.java */
/* renamed from: b.a.i.g, reason: use source file name */
/* loaded from: classes.dex */
public final class ChannelPermissionOwnerViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f852a;

    /* renamed from: b */
    @NonNull
    public final ImageView f853b;

    /* renamed from: c */
    @NonNull
    public final TextView f854c;

    /* renamed from: d */
    @NonNull
    public final SimpleDraweeView f855d;

    /* renamed from: e */
    @NonNull
    public final TextView f856e;

    public ChannelPermissionOwnerViewBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2) {
        this.f852a = view;
        this.f853b = imageView;
        this.f854c = textView;
        this.f855d = simpleDraweeView;
        this.f856e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f852a;
    }
}
