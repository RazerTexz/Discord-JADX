package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewChatUploadBinding.java */
/* renamed from: b.a.i.c2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewChatUploadBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f738a;

    /* renamed from: b */
    @NonNull
    public final TextView f739b;

    /* renamed from: c */
    @NonNull
    public final ImageView f740c;

    /* renamed from: d */
    @NonNull
    public final TextView f741d;

    public ViewChatUploadBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView2) {
        this.f738a = constraintLayout;
        this.f739b = textView;
        this.f740c = imageView2;
        this.f741d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f738a;
    }
}
