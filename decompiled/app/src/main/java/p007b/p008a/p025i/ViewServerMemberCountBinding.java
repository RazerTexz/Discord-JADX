package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewServerMemberCountBinding.java */
/* renamed from: b.a.i.i3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewServerMemberCountBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f952a;

    /* renamed from: b */
    @NonNull
    public final ImageView f953b;

    /* renamed from: c */
    @NonNull
    public final TextView f954c;

    /* renamed from: d */
    @NonNull
    public final ImageView f955d;

    /* renamed from: e */
    @NonNull
    public final TextView f956e;

    public ViewServerMemberCountBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull TextView textView2) {
        this.f952a = linearLayout;
        this.f953b = imageView;
        this.f954c = textView;
        this.f955d = imageView2;
        this.f956e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f952a;
    }
}
