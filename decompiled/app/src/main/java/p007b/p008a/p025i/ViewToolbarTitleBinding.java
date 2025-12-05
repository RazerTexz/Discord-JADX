package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.StatusView;

/* compiled from: ViewToolbarTitleBinding.java */
/* renamed from: b.a.i.b4, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewToolbarTitleBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f707a;

    /* renamed from: b */
    @NonNull
    public final ImageView f708b;

    /* renamed from: c */
    @NonNull
    public final StatusView f709c;

    /* renamed from: d */
    @NonNull
    public final TextView f710d;

    /* renamed from: e */
    @NonNull
    public final TextView f711e;

    /* renamed from: f */
    @NonNull
    public final ImageView f712f;

    public ViewToolbarTitleBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull StatusView statusView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView2) {
        this.f707a = view;
        this.f708b = imageView;
        this.f709c = statusView;
        this.f710d = textView;
        this.f711e = textView2;
        this.f712f = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f707a;
    }
}
