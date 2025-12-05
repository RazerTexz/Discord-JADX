package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;

/* compiled from: GuildBoostUncancelDialogBinding.java */
/* renamed from: b.a.i.u, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildBoostUncancelDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1265a;

    /* renamed from: b */
    @NonNull
    public final TextView f1266b;

    /* renamed from: c */
    @NonNull
    public final LoadingButton f1267c;

    /* renamed from: d */
    @NonNull
    public final TextView f1268d;

    /* renamed from: e */
    @NonNull
    public final AppViewFlipper f1269e;

    /* renamed from: f */
    @NonNull
    public final TextView f1270f;

    /* renamed from: g */
    @NonNull
    public final ImageView f1271g;

    /* renamed from: h */
    @NonNull
    public final MaterialButton f1272h;

    public GuildBoostUncancelDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LoadingButton loadingButton, @NonNull TextView textView2, @NonNull AppViewFlipper appViewFlipper, @NonNull TextView textView3, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout2) {
        this.f1265a = linearLayout;
        this.f1266b = textView;
        this.f1267c = loadingButton;
        this.f1268d = textView2;
        this.f1269e = appViewFlipper;
        this.f1270f = textView3;
        this.f1271g = imageView;
        this.f1272h = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1265a;
    }
}
