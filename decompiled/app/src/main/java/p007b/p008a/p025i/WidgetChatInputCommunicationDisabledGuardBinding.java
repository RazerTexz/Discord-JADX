package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;

/* compiled from: WidgetChatInputCommunicationDisabledGuardBinding.java */
/* renamed from: b.a.i.t4, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetChatInputCommunicationDisabledGuardBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f1254a;

    /* renamed from: b */
    @NonNull
    public final TextView f1255b;

    /* renamed from: c */
    @NonNull
    public final TextView f1256c;

    public WidgetChatInputCommunicationDisabledGuardBinding(@NonNull RelativeLayout relativeLayout, @NonNull CardView cardView, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f1254a = relativeLayout;
        this.f1255b = textView2;
        this.f1256c = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1254a;
    }
}
