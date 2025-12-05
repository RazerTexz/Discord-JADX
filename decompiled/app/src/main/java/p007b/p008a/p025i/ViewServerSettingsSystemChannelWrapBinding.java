package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* compiled from: ViewServerSettingsSystemChannelWrapBinding.java */
/* renamed from: b.a.i.l3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewServerSettingsSystemChannelWrapBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1025a;

    /* renamed from: b */
    @NonNull
    public final TextView f1026b;

    /* renamed from: c */
    @NonNull
    public final CheckedSetting f1027c;

    /* renamed from: d */
    @NonNull
    public final CheckedSetting f1028d;

    /* renamed from: e */
    @NonNull
    public final CheckedSetting f1029e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f1030f;

    public ViewServerSettingsSystemChannelWrapBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull LinearLayout linearLayout2) {
        this.f1025a = linearLayout;
        this.f1026b = textView;
        this.f1027c = checkedSetting;
        this.f1028d = checkedSetting2;
        this.f1029e = checkedSetting3;
        this.f1030f = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1025a;
    }
}
