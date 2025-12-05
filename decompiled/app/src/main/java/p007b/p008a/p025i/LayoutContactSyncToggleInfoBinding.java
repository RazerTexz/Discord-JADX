package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;

/* compiled from: LayoutContactSyncToggleInfoBinding.java */
/* renamed from: b.a.i.o0, reason: use source file name */
/* loaded from: classes.dex */
public final class LayoutContactSyncToggleInfoBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1094a;

    /* renamed from: b */
    @NonNull
    public final LinkifiedTextView f1095b;

    /* renamed from: c */
    @NonNull
    public final CheckedSetting f1096c;

    public LayoutContactSyncToggleInfoBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull CheckedSetting checkedSetting) {
        this.f1094a = linearLayout;
        this.f1095b = linkifiedTextView;
        this.f1096c = checkedSetting;
    }

    @NonNull
    /* renamed from: a */
    public static LayoutContactSyncToggleInfoBinding m202a(@NonNull View view) {
        int i = C5419R.id.contact_sync_discovery_info_1;
        TextView textView = (TextView) view.findViewById(C5419R.id.contact_sync_discovery_info_1);
        if (textView != null) {
            i = C5419R.id.contact_sync_discovery_info_2;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.contact_sync_discovery_info_2);
            if (linkifiedTextView != null) {
                i = C5419R.id.contact_sync_discovery_toggle;
                CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.contact_sync_discovery_toggle);
                if (checkedSetting != null) {
                    return new LayoutContactSyncToggleInfoBinding((LinearLayout) view, textView, linkifiedTextView, checkedSetting);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1094a;
    }
}
