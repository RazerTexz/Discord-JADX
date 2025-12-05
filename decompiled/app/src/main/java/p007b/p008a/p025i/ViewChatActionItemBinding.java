package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewChatActionItemBinding.java */
/* renamed from: b.a.i.b2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewChatActionItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f702a;

    /* renamed from: b */
    @NonNull
    public final ImageView f703b;

    /* renamed from: c */
    @NonNull
    public final TextView f704c;

    public ViewChatActionItemBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f702a = view;
        this.f703b = imageView;
        this.f704c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f702a;
    }
}
