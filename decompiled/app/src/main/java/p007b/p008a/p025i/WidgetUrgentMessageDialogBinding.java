package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;

/* compiled from: WidgetUrgentMessageDialogBinding.java */
/* renamed from: b.a.i.e6, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUrgentMessageDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f823a;

    /* renamed from: b */
    @NonNull
    public final LoadingButton f824b;

    /* renamed from: c */
    @NonNull
    public final TextView f825c;

    /* renamed from: d */
    @NonNull
    public final TextView f826d;

    public WidgetUrgentMessageDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LoadingButton loadingButton, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f823a = linearLayout;
        this.f824b = loadingButton;
        this.f825c = textView;
        this.f826d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f823a;
    }
}
