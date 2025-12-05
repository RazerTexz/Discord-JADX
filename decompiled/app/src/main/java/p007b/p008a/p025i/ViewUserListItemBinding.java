package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: ViewUserListItemBinding.java */
/* renamed from: b.a.i.d4, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewUserListItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f783a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f784b;

    /* renamed from: c */
    @NonNull
    public final TextView f785c;

    /* renamed from: d */
    @NonNull
    public final TextView f786d;

    /* renamed from: e */
    @NonNull
    public final StatusView f787e;

    public ViewUserListItemBinding(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull StatusView statusView) {
        this.f783a = view;
        this.f784b = simpleDraweeView;
        this.f785c = textView;
        this.f786d = textView2;
        this.f787e = statusView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f783a;
    }
}
