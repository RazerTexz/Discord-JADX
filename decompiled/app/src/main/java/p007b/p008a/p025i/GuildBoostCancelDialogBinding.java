package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;

/* compiled from: GuildBoostCancelDialogBinding.java */
/* renamed from: b.a.i.t, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildBoostCancelDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1231a;

    /* renamed from: b */
    @NonNull
    public final TextView f1232b;

    /* renamed from: c */
    @NonNull
    public final LoadingButton f1233c;

    /* renamed from: d */
    @NonNull
    public final TextView f1234d;

    /* renamed from: e */
    @NonNull
    public final AppViewFlipper f1235e;

    /* renamed from: f */
    @NonNull
    public final TextView f1236f;

    /* renamed from: g */
    @NonNull
    public final MaterialButton f1237g;

    public GuildBoostCancelDialogBinding(@NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar, @NonNull TextView textView, @NonNull LoadingButton loadingButton, @NonNull TextView textView2, @NonNull AppViewFlipper appViewFlipper, @NonNull TextView textView3, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout2) {
        this.f1231a = linearLayout;
        this.f1232b = textView;
        this.f1233c = loadingButton;
        this.f1234d = textView2;
        this.f1235e = appViewFlipper;
        this.f1236f = textView3;
        this.f1237g = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1231a;
    }
}
