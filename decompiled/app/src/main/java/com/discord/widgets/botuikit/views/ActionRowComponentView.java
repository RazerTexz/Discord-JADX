package com.discord.widgets.botuikit.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.a5;
import b.a.i.m2;
import com.discord.R;
import com.discord.api.botuikit.ComponentType;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.models.botuikit.ActionRowMessageComponent;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.botuikit.MessageComponentUtils;
import com.discord.widgets.botuikit.ComponentProvider;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemBotComponentRowKt;
import com.google.android.flexbox.FlexboxLayout;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ActionRowComponentView.kt */
/* loaded from: classes2.dex */
public final class ActionRowComponentView extends LinearLayout implements ComponentView<ActionRowMessageComponent> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: ActionRowComponentView.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ActionRowComponentView inflateComponent(Context context, ViewGroup root) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(root, "root");
            a5 a5VarA = a5.a(LayoutInflater.from(context).inflate(R.layout.widget_chat_list_bot_ui_action_row_component, root, false));
            m.checkNotNullExpressionValue(a5VarA, "WidgetChatListBotUiActio…om(context), root, false)");
            ActionRowComponentView actionRowComponentView = a5VarA.a;
            m.checkNotNullExpressionValue(actionRowComponentView, "WidgetChatListBotUiActio…ntext), root, false).root");
            return actionRowComponentView;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionRowComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public /* bridge */ /* synthetic */ void configure(MessageComponent messageComponent, ComponentProvider componentProvider, ComponentActionListener componentActionListener) {
        configure((ActionRowMessageComponent) messageComponent, componentProvider, componentActionListener);
    }

    @Override // com.discord.widgets.botuikit.views.ComponentView
    public ComponentType type() {
        return ComponentType.ACTION_ROW;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionRowComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
    }

    public void configure(ActionRowMessageComponent component, ComponentProvider componentProvider, ComponentActionListener componentActionListener) {
        m.checkNotNullParameter(component, "component");
        m.checkNotNullParameter(componentProvider, "componentProvider");
        m.checkNotNullParameter(componentActionListener, "componentActionListener");
        a5 a5VarA = a5.a(this);
        m.checkNotNullExpressionValue(a5VarA, "WidgetChatListBotUiActio…mponentBinding.bind(this)");
        List<MessageComponent> components = component.getComponents();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(components, 10));
        int i = 0;
        for (Object obj : components) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            arrayList.add(componentProvider.getConfiguredComponentView(componentActionListener, (MessageComponent) obj, this, i));
            i = i2;
        }
        FlexboxLayout flexboxLayout = a5VarA.f78b;
        m.checkNotNullExpressionValue(flexboxLayout, "binding.actionRowComponentViewGroup");
        WidgetChatListAdapterItemBotComponentRowKt.replaceViews(flexboxLayout, u.filterNotNull(arrayList));
        ActionInteractionComponentState.Failed childError = MessageComponentUtils.INSTANCE.getChildError(component);
        m2 m2Var = a5VarA.c;
        m.checkNotNullExpressionValue(m2Var, "binding.actionRowComponentViewGroupErrorRow");
        ConstraintLayout constraintLayout = m2Var.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.actionRowComponentViewGroupErrorRow.root");
        constraintLayout.setVisibility(childError != null ? 0 : 8);
        if (childError != null) {
            String errorMessage = childError.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = getResources().getString(R.string.application_command_failed);
                m.checkNotNullExpressionValue(errorMessage, "resources.getString(R.st…plication_command_failed)");
            }
            TextView textView = a5VarA.c.f159b;
            m.checkNotNullExpressionValue(textView, "binding.actionRowCompone…ractionFailedLabelMessage");
            textView.setText(errorMessage);
        }
    }
}
