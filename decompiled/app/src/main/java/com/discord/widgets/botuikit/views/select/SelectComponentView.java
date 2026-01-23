package com.discord.widgets.botuikit.views.select;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.api.botuikit.Component6;
import com.discord.api.botuikit.SelectComponent2;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.botuikit.SelectMessageComponent;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.botuikit.ComponentProvider;
import com.discord.widgets.botuikit.views.ComponentView;
import com.discord.widgets.botuikit.views.ComponentView2;
import com.discord.widgets.botuikit.views.ComponentViewUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.textview.MaterialTextView;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p025i.WidgetChatListBotUiSelectComponentBinding;
import p007b.p008a.p025i.WidgetChatListBotUiSelectComponentPillBinding;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: SelectComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentView extends ConstraintLayout implements ComponentView<SelectMessageComponent> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: SelectComponentView.kt */
    public static final class Companion {
        private Companion() {
        }

        public final SelectComponentView inflateComponent(Context context, ViewGroup root) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(root, "root");
            WidgetChatListBotUiSelectComponentBinding widgetChatListBotUiSelectComponentBindingM197a = WidgetChatListBotUiSelectComponentBinding.m197a(LayoutInflater.from(context).inflate(C5419R.layout.widget_chat_list_bot_ui_select_component, root, false));
            Intrinsics3.checkNotNullExpressionValue(widgetChatListBotUiSelectComponentBindingM197a, "WidgetChatListBotUiSelec…om(context), root, false)");
            SelectComponentView selectComponentView = widgetChatListBotUiSelectComponentBindingM197a.f713a;
            Intrinsics3.checkNotNullExpressionValue(selectComponentView, "WidgetChatListBotUiSelec…ntext), root, false).root");
            return selectComponentView;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.botuikit.views.select.SelectComponentView$configure$3 */
    /* JADX INFO: compiled from: SelectComponentView.kt */
    public static final class ViewOnClickListenerC72803 implements View.OnClickListener {
        public final /* synthetic */ SelectMessageComponent $component;
        public final /* synthetic */ ComponentView2 $componentActionListener;
        public final /* synthetic */ String $placeholder;

        public ViewOnClickListenerC72803(ComponentView2 componentView2, SelectMessageComponent selectMessageComponent, String str) {
            this.$componentActionListener = componentView2;
            this.$component = selectMessageComponent;
            this.$placeholder = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$componentActionListener.onSelectComponentClick(this.$component.getIndex(), this.$component.getCustomId(), this.$placeholder, this.$component.getOptions(), this.$component.getSelectedOptions(), this.$component.getMinValues(), this.$component.getMaxValues(), this.$component.getEmojiAnimationsEnabled());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public /* bridge */ /* synthetic */ void configure(MessageComponent messageComponent, ComponentProvider componentProvider, ComponentView2 componentView2) {
        configure((SelectMessageComponent) messageComponent, componentProvider, componentView2);
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public Component6 type() {
        return Component6.SELECT;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
    }

    public void configure(SelectMessageComponent component, ComponentProvider componentProvider, ComponentView2 componentActionListener) {
        Intrinsics3.checkNotNullParameter(component, "component");
        Intrinsics3.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics3.checkNotNullParameter(componentActionListener, "componentActionListener");
        WidgetChatListBotUiSelectComponentBinding widgetChatListBotUiSelectComponentBindingM197a = WidgetChatListBotUiSelectComponentBinding.m197a(this);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListBotUiSelectComponentBindingM197a, "WidgetChatListBotUiSelec…mponentBinding.bind(this)");
        String placeholder = component.getPlaceholder();
        if (placeholder == null) {
            placeholder = getResources().getString(C5419R.string.message_select_component_default_placeholder);
            Intrinsics3.checkNotNullExpressionValue(placeholder, "resources.getString(R.st…nent_default_placeholder)");
        }
        if (!(!component.getSelectedOptions().isEmpty())) {
            MaterialTextView materialTextView = widgetChatListBotUiSelectComponentBindingM197a.f717e;
            Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.selectComponentSelectionText");
            materialTextView.setVisibility(0);
            FlexboxLayout flexboxLayout = widgetChatListBotUiSelectComponentBindingM197a.f718f;
            Intrinsics3.checkNotNullExpressionValue(flexboxLayout, "binding.selectComponentSelectionsRoot");
            flexboxLayout.setVisibility(8);
            widgetChatListBotUiSelectComponentBindingM197a.f717e.setTextColor(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorInteractiveNormal));
            MaterialTextView materialTextView2 = widgetChatListBotUiSelectComponentBindingM197a.f717e;
            Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.selectComponentSelectionText");
            materialTextView2.setText(placeholder);
        } else if (component.getMaxValues() == 1) {
            MaterialTextView materialTextView3 = widgetChatListBotUiSelectComponentBindingM197a.f717e;
            Intrinsics3.checkNotNullExpressionValue(materialTextView3, "binding.selectComponentSelectionText");
            materialTextView3.setVisibility(0);
            FlexboxLayout flexboxLayout2 = widgetChatListBotUiSelectComponentBindingM197a.f718f;
            Intrinsics3.checkNotNullExpressionValue(flexboxLayout2, "binding.selectComponentSelectionsRoot");
            flexboxLayout2.setVisibility(8);
            widgetChatListBotUiSelectComponentBindingM197a.f717e.setTextColor(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorTextNormal));
            SelectComponent2 selectComponent2 = (SelectComponent2) _Collections.firstOrNull((List) component.getSelectedOptions());
            if (selectComponent2 != null) {
                MaterialTextView materialTextView4 = widgetChatListBotUiSelectComponentBindingM197a.f717e;
                Intrinsics3.checkNotNullExpressionValue(materialTextView4, "binding.selectComponentSelectionText");
                materialTextView4.setText(selectComponent2.getLabel());
                ComponentViewUtils componentViewUtils = ComponentViewUtils.INSTANCE;
                SimpleDraweeView simpleDraweeView = widgetChatListBotUiSelectComponentBindingM197a.f716d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.selectComponentSelectionIcon");
                componentViewUtils.setEmojiOrHide(simpleDraweeView, selectComponent2.getEmoji(), component.getEmojiAnimationsEnabled());
            }
        } else {
            FlexboxLayout flexboxLayout3 = widgetChatListBotUiSelectComponentBindingM197a.f718f;
            Intrinsics3.checkNotNullExpressionValue(flexboxLayout3, "binding.selectComponentSelectionsRoot");
            MaterialTextView materialTextView5 = widgetChatListBotUiSelectComponentBindingM197a.f717e;
            Intrinsics3.checkNotNullExpressionValue(materialTextView5, "binding.selectComponentSelectionText");
            materialTextView5.setVisibility(8);
            flexboxLayout3.setVisibility(0);
            flexboxLayout3.removeAllViews();
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
            for (SelectComponent2 selectComponent22 : component.getSelectedOptions()) {
                View viewInflate = layoutInflaterFrom.inflate(C5419R.layout.widget_chat_list_bot_ui_select_component_pill, (ViewGroup) null, false);
                Objects.requireNonNull(viewInflate, "rootView");
                MaterialTextView materialTextView6 = (MaterialTextView) viewInflate;
                Intrinsics3.checkNotNullExpressionValue(new WidgetChatListBotUiSelectComponentPillBinding(materialTextView6), "WidgetChatListBotUiSelec…Binding.inflate(inflater)");
                Intrinsics3.checkNotNullExpressionValue(materialTextView6, "WidgetChatListBotUiSelec…ng.inflate(inflater).root");
                materialTextView6.setText(selectComponent22.getLabel());
                flexboxLayout3.addView(materialTextView6);
            }
        }
        boolean z2 = !(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled);
        boolean z3 = component.getStateInteraction() instanceof ActionInteractionComponentState.Loading;
        TypingDots typingDots = widgetChatListBotUiSelectComponentBindingM197a.f715c;
        if (z3) {
            typingDots.m8619a(false);
        } else {
            typingDots.m8620c();
        }
        TypingDots typingDots2 = widgetChatListBotUiSelectComponentBindingM197a.f715c;
        Intrinsics3.checkNotNullExpressionValue(typingDots2, "binding.selectComponentLoading");
        typingDots2.setVisibility(z3 ^ true ? 4 : 0);
        ImageView imageView = widgetChatListBotUiSelectComponentBindingM197a.f714b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.selectComponentChevron");
        imageView.setVisibility(z3 ? 4 : 0);
        SelectComponentView selectComponentView = widgetChatListBotUiSelectComponentBindingM197a.f713a;
        Intrinsics3.checkNotNullExpressionValue(selectComponentView, "binding.root");
        ViewExtensions.setEnabledAlpha(selectComponentView, z2, 0.3f);
        widgetChatListBotUiSelectComponentBindingM197a.f713a.setOnClickListener(new ViewOnClickListenerC72803(componentActionListener, component, placeholder));
        SelectComponentView selectComponentView2 = widgetChatListBotUiSelectComponentBindingM197a.f713a;
        Intrinsics3.checkNotNullExpressionValue(selectComponentView2, "binding.root");
        selectComponentView2.setClickable(!z3 && z2);
    }
}
