package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: ViewGuildBinding.java */
/* renamed from: b.a.i.k2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewGuildBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f998a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f999b;

    /* renamed from: c */
    @NonNull
    public final TextView f1000c;

    public ViewGuildBinding(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.f998a = view;
        this.f999b = simpleDraweeView;
        this.f1000c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f998a;
    }
}
