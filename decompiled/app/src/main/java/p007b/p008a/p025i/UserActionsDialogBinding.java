package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: UserActionsDialogBinding.java */
/* renamed from: b.a.i.u1, reason: use source file name */
/* loaded from: classes.dex */
public final class UserActionsDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1280a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f1281b;

    /* renamed from: c */
    @NonNull
    public final TextView f1282c;

    /* renamed from: d */
    @NonNull
    public final TextView f1283d;

    /* renamed from: e */
    @NonNull
    public final TextView f1284e;

    /* renamed from: f */
    @NonNull
    public final TextView f1285f;

    public UserActionsDialogBinding(@NonNull LinearLayout linearLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f1280a = linearLayout;
        this.f1281b = simpleDraweeView;
        this.f1282c = textView;
        this.f1283d = textView2;
        this.f1284e = textView3;
        this.f1285f = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1280a;
    }
}
