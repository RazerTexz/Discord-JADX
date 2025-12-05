package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* compiled from: WidgetPlatformRichPresenceBinding.java */
/* renamed from: b.a.i.t5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetPlatformRichPresenceBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1257a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f1258b;

    /* renamed from: c */
    @NonNull
    public final TextView f1259c;

    /* renamed from: d */
    @NonNull
    public final SimpleDraweeView f1260d;

    /* renamed from: e */
    @NonNull
    public final SimpleDraweeView f1261e;

    /* renamed from: f */
    @NonNull
    public final MaterialButton f1262f;

    /* renamed from: g */
    @NonNull
    public final TextView f1263g;

    /* renamed from: h */
    @NonNull
    public final TextView f1264h;

    public WidgetPlatformRichPresenceBinding(@NonNull LinearLayout linearLayout, @NonNull Barrier barrier, @NonNull Space space, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull MaterialButton materialButton, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f1257a = linearLayout;
        this.f1258b = linearLayout2;
        this.f1259c = textView;
        this.f1260d = simpleDraweeView;
        this.f1261e = simpleDraweeView2;
        this.f1262f = materialButton;
        this.f1263g = textView2;
        this.f1264h = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1257a;
    }
}
