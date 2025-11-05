package com.discord.widgets.botuikit.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.discord.R;
import com.discord.api.botuikit.ButtonStyle;
import com.discord.api.botuikit.ComponentEmoji;
import com.discord.api.botuikit.ComponentType;
import com.discord.databinding.WidgetChatListBotUiButtonComponentBinding;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.models.botuikit.ButtonMessageComponent;
import com.discord.models.botuikit.MessageComponent;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.botuikit.ComponentProvider;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ButtonComponentView.kt */
/* loaded from: classes2.dex */
public final class ButtonComponentView extends ConstraintLayout implements ComponentView<ButtonMessageComponent> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: ButtonComponentView.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ButtonComponentView inflateComponent(Context context, ViewGroup root) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(root, "root");
            WidgetChatListBotUiButtonComponentBinding widgetChatListBotUiButtonComponentBindingA = WidgetChatListBotUiButtonComponentBinding.a(LayoutInflater.from(context).inflate(R.layout.widget_chat_list_bot_ui_button_component, root, false));
            m.checkNotNullExpressionValue(widgetChatListBotUiButtonComponentBindingA, "WidgetChatListBotUiButto…om(context), root, false)");
            ButtonComponentView buttonComponentView = widgetChatListBotUiButtonComponentBindingA.a;
            m.checkNotNullExpressionValue(buttonComponentView, "WidgetChatListBotUiButto…ntext), root, false).root");
            return buttonComponentView;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ButtonStyle.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            iArr[ButtonStyle.UNKNOWN.ordinal()] = 1;
            iArr[ButtonStyle.PRIMARY.ordinal()] = 2;
            iArr[ButtonStyle.SECONDARY.ordinal()] = 3;
            iArr[ButtonStyle.LINK.ordinal()] = 4;
            iArr[ButtonStyle.DANGER.ordinal()] = 5;
            iArr[ButtonStyle.SUCCESS.ordinal()] = 6;
        }
    }

    /* compiled from: ButtonComponentView.kt */
    /* renamed from: com.discord.widgets.botuikit.views.ButtonComponentView$configure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetChatListBotUiButtonComponentBinding $binding;
        public final /* synthetic */ ButtonMessageComponent $component;
        public final /* synthetic */ ComponentActionListener $componentActionListener;

        public AnonymousClass1(ButtonMessageComponent buttonMessageComponent, WidgetChatListBotUiButtonComponentBinding widgetChatListBotUiButtonComponentBinding, ComponentActionListener componentActionListener) {
            this.$component = buttonMessageComponent;
            this.$binding = widgetChatListBotUiButtonComponentBinding;
            this.$componentActionListener = componentActionListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$component.getUrl() == null) {
                if (this.$component.getCustomId() != null) {
                    this.$componentActionListener.onButtonComponentClick(this.$component.getIndex(), this.$component.getCustomId());
                }
            } else {
                MaterialButton materialButton = this.$binding.f2344b;
                m.checkNotNullExpressionValue(materialButton, "binding.button");
                Context context = materialButton.getContext();
                m.checkNotNullExpressionValue(context, "binding.button.context");
                UriHandler.handleOrUntrusted$default(context, this.$component.getUrl(), null, 4, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
    }

    private final void configureEmoji(SimpleDraweeView emojiView, ComponentEmoji emoji, boolean isLoading, boolean emojiAnimationsEnabled) {
        if (emoji == null || !isLoading) {
            ComponentViewUtils.INSTANCE.setEmojiOrHide(emojiView, emoji, emojiAnimationsEnabled);
        } else {
            emojiView.setVisibility(4);
        }
    }

    private final void configureLabelPadding(TextView label, ButtonMessageComponent messageComponent) {
        if (messageComponent.getLabel() == null) {
            label.setPadding(0, 0, (ButtonComponentViewKt.hasEmoji(messageComponent) && ButtonComponentViewKt.hasIcon(messageComponent)) ? DimenUtils.dpToPixels(8) : DimenUtils.dpToPixels(16), 0);
        } else {
            label.setPadding(ButtonComponentViewKt.hasEmoji(messageComponent) ? DimenUtils.dpToPixels(8) : DimenUtils.dpToPixels(16), 0, ButtonComponentViewKt.hasIcon(messageComponent) ? DimenUtils.dpToPixels(8) : DimenUtils.dpToPixels(16), 0);
        }
    }

    private final void configureLinkIcon(ImageView icon, boolean showIcon) {
        icon.setVisibility(showIcon ? 0 : 8);
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public /* bridge */ /* synthetic */ void configure(MessageComponent messageComponent, ComponentProvider componentProvider, ComponentActionListener componentActionListener) {
        configure((ButtonMessageComponent) messageComponent, componentProvider, componentActionListener);
    }

    public final void configureStyle(Button button, ButtonStyle style) {
        m.checkNotNullParameter(button, "button");
        m.checkNotNullParameter(style, "style");
        int iOrdinal = style.ordinal();
        int i = R.color.uikit_btn_bg_color_selector_secondary;
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                i = R.color.uikit_btn_bg_color_selector_brand;
            } else if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    i = R.color.uikit_btn_bg_color_selector_green;
                } else if (iOrdinal == 4) {
                    i = R.color.uikit_btn_bg_color_selector_red;
                } else if (iOrdinal != 5) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        Resources resources = getResources();
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        ViewCompat.setBackgroundTintList(button, ResourcesCompat.getColorStateList(resources, i, context.getTheme()));
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public ComponentType type() {
        return ComponentType.BUTTON;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ButtonComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
    }

    public void configure(ButtonMessageComponent component, ComponentProvider componentProvider, ComponentActionListener componentActionListener) {
        m.checkNotNullParameter(component, "component");
        m.checkNotNullParameter(componentProvider, "componentProvider");
        m.checkNotNullParameter(componentActionListener, "componentActionListener");
        WidgetChatListBotUiButtonComponentBinding widgetChatListBotUiButtonComponentBindingA = WidgetChatListBotUiButtonComponentBinding.a(this);
        m.checkNotNullExpressionValue(widgetChatListBotUiButtonComponentBindingA, "WidgetChatListBotUiButto…mponentBinding.bind(this)");
        MaterialButton materialButton = widgetChatListBotUiButtonComponentBindingA.f2344b;
        m.checkNotNullExpressionValue(materialButton, "binding.button");
        configureStyle(materialButton, component.getStyle());
        SimpleDraweeView simpleDraweeView = widgetChatListBotUiButtonComponentBindingA.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.emoji");
        configureEmoji(simpleDraweeView, component.getEmoji(), component.getStateInteraction() instanceof ActionInteractionComponentState.Loading, component.getEmojiAnimationsEnabled());
        AppCompatImageView appCompatImageView = widgetChatListBotUiButtonComponentBindingA.e;
        m.checkNotNullExpressionValue(appCompatImageView, "binding.linkIcon");
        configureLinkIcon(appCompatImageView, component.getStyle() == ButtonStyle.LINK);
        MaterialTextView materialTextView = widgetChatListBotUiButtonComponentBindingA.d;
        m.checkNotNullExpressionValue(materialTextView, "binding.label");
        configureLabelPadding(materialTextView, component);
        MaterialTextView materialTextView2 = widgetChatListBotUiButtonComponentBindingA.d;
        m.checkNotNullExpressionValue(materialTextView2, "binding.label");
        ViewExtensions.setEnabledAlpha(materialTextView2, !(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled), 0.5f);
        SimpleDraweeView simpleDraweeView2 = widgetChatListBotUiButtonComponentBindingA.c;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.emoji");
        ViewExtensions.setEnabledAlpha$default(simpleDraweeView2, !(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled), 0.0f, 2, null);
        AppCompatImageView appCompatImageView2 = widgetChatListBotUiButtonComponentBindingA.e;
        m.checkNotNullExpressionValue(appCompatImageView2, "binding.linkIcon");
        ViewExtensions.setEnabledAlpha$default(appCompatImageView2, !(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled), 0.0f, 2, null);
        MaterialButton materialButton2 = widgetChatListBotUiButtonComponentBindingA.f2344b;
        m.checkNotNullExpressionValue(materialButton2, "binding.button");
        materialButton2.setEnabled(!(component.getStateInteraction() instanceof ActionInteractionComponentState.Disabled));
        MaterialTextView materialTextView3 = widgetChatListBotUiButtonComponentBindingA.d;
        m.checkNotNullExpressionValue(materialTextView3, "binding.label");
        materialTextView3.setText(component.getLabel());
        MaterialTextView materialTextView4 = widgetChatListBotUiButtonComponentBindingA.d;
        m.checkNotNullExpressionValue(materialTextView4, "binding.label");
        materialTextView4.setVisibility(component.getStateInteraction() instanceof ActionInteractionComponentState.Loading ? 4 : 0);
        widgetChatListBotUiButtonComponentBindingA.f2344b.setOnClickListener(new AnonymousClass1(component, widgetChatListBotUiButtonComponentBindingA, componentActionListener));
        TypingDots typingDots = widgetChatListBotUiButtonComponentBindingA.f;
        m.checkNotNullExpressionValue(typingDots, "binding.loadingDots");
        typingDots.setVisibility(component.getStateInteraction() instanceof ActionInteractionComponentState.Loading ? 0 : 8);
        if (component.getStateInteraction() instanceof ActionInteractionComponentState.Loading) {
            widgetChatListBotUiButtonComponentBindingA.f.a(false);
            MaterialButton materialButton3 = widgetChatListBotUiButtonComponentBindingA.f2344b;
            m.checkNotNullExpressionValue(materialButton3, "binding.button");
            materialButton3.setClickable(false);
            return;
        }
        widgetChatListBotUiButtonComponentBindingA.f.c();
        MaterialButton materialButton4 = widgetChatListBotUiButtonComponentBindingA.f2344b;
        m.checkNotNullExpressionValue(materialButton4, "binding.button");
        materialButton4.setClickable(true);
    }
}
