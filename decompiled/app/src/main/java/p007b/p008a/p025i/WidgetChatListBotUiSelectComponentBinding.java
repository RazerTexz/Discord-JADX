package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.botuikit.views.select.SelectComponentView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.textview.MaterialTextView;

/* compiled from: WidgetChatListBotUiSelectComponentBinding.java */
/* renamed from: b.a.i.b5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetChatListBotUiSelectComponentBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final SelectComponentView f713a;

    /* renamed from: b */
    @NonNull
    public final ImageView f714b;

    /* renamed from: c */
    @NonNull
    public final TypingDots f715c;

    /* renamed from: d */
    @NonNull
    public final SimpleDraweeView f716d;

    /* renamed from: e */
    @NonNull
    public final MaterialTextView f717e;

    /* renamed from: f */
    @NonNull
    public final FlexboxLayout f718f;

    public WidgetChatListBotUiSelectComponentBinding(@NonNull SelectComponentView selectComponentView, @NonNull ImageView imageView, @NonNull TypingDots typingDots, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialTextView materialTextView, @NonNull FlexboxLayout flexboxLayout) {
        this.f713a = selectComponentView;
        this.f714b = imageView;
        this.f715c = typingDots;
        this.f716d = simpleDraweeView;
        this.f717e = materialTextView;
        this.f718f = flexboxLayout;
    }

    @NonNull
    /* renamed from: a */
    public static WidgetChatListBotUiSelectComponentBinding m197a(@NonNull View view) {
        int i = C5419R.id.select_component_chevron;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.select_component_chevron);
        if (imageView != null) {
            i = C5419R.id.select_component_loading;
            TypingDots typingDots = (TypingDots) view.findViewById(C5419R.id.select_component_loading);
            if (typingDots != null) {
                i = C5419R.id.select_component_selection_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.select_component_selection_icon);
                if (simpleDraweeView != null) {
                    i = C5419R.id.select_component_selection_text;
                    MaterialTextView materialTextView = (MaterialTextView) view.findViewById(C5419R.id.select_component_selection_text);
                    if (materialTextView != null) {
                        i = C5419R.id.select_component_selections_root;
                        FlexboxLayout flexboxLayout = (FlexboxLayout) view.findViewById(C5419R.id.select_component_selections_root);
                        if (flexboxLayout != null) {
                            return new WidgetChatListBotUiSelectComponentBinding((SelectComponentView) view, imageView, typingDots, simpleDraweeView, materialTextView, flexboxLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f713a;
    }
}
