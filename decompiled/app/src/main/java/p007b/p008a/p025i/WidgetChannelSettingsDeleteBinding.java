package p007b.p008a.p025i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.google.android.material.button.MaterialButton;

/* compiled from: WidgetChannelSettingsDeleteBinding.java */
/* renamed from: b.a.i.s4, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetChannelSettingsDeleteBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1214a;

    /* renamed from: b */
    @NonNull
    public final TextView f1215b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f1216c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f1217d;

    /* renamed from: e */
    @NonNull
    public final TextView f1218e;

    public WidgetChannelSettingsDeleteBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView2) {
        this.f1214a = linearLayout;
        this.f1215b = textView;
        this.f1216c = materialButton;
        this.f1217d = materialButton2;
        this.f1218e = textView2;
    }

    @NonNull
    /* renamed from: a */
    public static WidgetChannelSettingsDeleteBinding m206a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.widget_channel_settings_delete, (ViewGroup) null, false);
        if (z2) {
            throw null;
        }
        int i = C5419R.id.channel_settings_delete_body;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.channel_settings_delete_body);
        if (textView != null) {
            i = C5419R.id.channel_settings_delete_cancel;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.channel_settings_delete_cancel);
            if (materialButton != null) {
                i = C5419R.id.channel_settings_delete_confirm;
                MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(C5419R.id.channel_settings_delete_confirm);
                if (materialButton2 != null) {
                    i = C5419R.id.channel_settings_delete_title;
                    TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.channel_settings_delete_title);
                    if (textView2 != null) {
                        return new WidgetChannelSettingsDeleteBinding((LinearLayout) viewInflate, textView, materialButton, materialButton2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1214a;
    }
}
