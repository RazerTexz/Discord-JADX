package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;

/* compiled from: ViewUsernameBinding.java */
/* renamed from: b.a.i.g4, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewUsernameBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f874a;

    /* renamed from: b */
    @NonNull
    public final TextView f875b;

    /* renamed from: c */
    @NonNull
    public final SimpleDraweeSpanTextView f876c;

    public ViewUsernameBinding(@NonNull View view, @NonNull TextView textView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView) {
        this.f874a = view;
        this.f875b = textView;
        this.f876c = simpleDraweeSpanTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f874a;
    }
}
