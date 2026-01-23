package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.t4, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatInputCommunicationDisabledGuardBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatInputCommunicationDisabledGuardBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f1254a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1255b;

    /* JADX INFO: renamed from: c */
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
