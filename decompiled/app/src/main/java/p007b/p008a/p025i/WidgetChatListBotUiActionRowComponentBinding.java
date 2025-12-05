package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.widgets.botuikit.views.ActionRowComponentView;
import com.google.android.flexbox.FlexboxLayout;

/* compiled from: WidgetChatListBotUiActionRowComponentBinding.java */
/* renamed from: b.a.i.a5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetChatListBotUiActionRowComponentBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ActionRowComponentView f679a;

    /* renamed from: b */
    @NonNull
    public final FlexboxLayout f680b;

    /* renamed from: c */
    @NonNull
    public final ViewInteractionFailedLabelBinding f681c;

    public WidgetChatListBotUiActionRowComponentBinding(@NonNull ActionRowComponentView actionRowComponentView, @NonNull FlexboxLayout flexboxLayout, @NonNull ViewInteractionFailedLabelBinding viewInteractionFailedLabelBinding) {
        this.f679a = actionRowComponentView;
        this.f680b = flexboxLayout;
        this.f681c = viewInteractionFailedLabelBinding;
    }

    @NonNull
    /* renamed from: a */
    public static WidgetChatListBotUiActionRowComponentBinding m195a(@NonNull View view) {
        int i = C5419R.id.action_row_component_view_group;
        FlexboxLayout flexboxLayout = (FlexboxLayout) view.findViewById(C5419R.id.action_row_component_view_group);
        if (flexboxLayout != null) {
            i = C5419R.id.action_row_component_view_group_error_row;
            View viewFindViewById = view.findViewById(C5419R.id.action_row_component_view_group_error_row);
            if (viewFindViewById != null) {
                int i2 = C5419R.id.view_interaction_failed_label_icon;
                ImageView imageView = (ImageView) viewFindViewById.findViewById(C5419R.id.view_interaction_failed_label_icon);
                if (imageView != null) {
                    i2 = C5419R.id.view_interaction_failed_label_message;
                    TextView textView = (TextView) viewFindViewById.findViewById(C5419R.id.view_interaction_failed_label_message);
                    if (textView != null) {
                        return new WidgetChatListBotUiActionRowComponentBinding((ActionRowComponentView) view, flexboxLayout, new ViewInteractionFailedLabelBinding((ConstraintLayout) viewFindViewById, imageView, textView));
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f679a;
    }
}
