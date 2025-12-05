package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: GuildBoostUpgradeDialogBinding.java */
/* renamed from: b.a.i.v, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildBoostUpgradeDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f1300a;

    /* renamed from: b */
    @NonNull
    public final TextView f1301b;

    /* renamed from: c */
    @NonNull
    public final ImageView f1302c;

    /* renamed from: d */
    @NonNull
    public final TextView f1303d;

    /* renamed from: e */
    @NonNull
    public final TextView f1304e;

    /* renamed from: f */
    @NonNull
    public final MaterialButton f1305f;

    public GuildBoostUpgradeDialogBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull MaterialButton materialButton) {
        this.f1300a = relativeLayout;
        this.f1301b = textView;
        this.f1302c = imageView;
        this.f1303d = textView2;
        this.f1304e = textView3;
        this.f1305f = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1300a;
    }
}
