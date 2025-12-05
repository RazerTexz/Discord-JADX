package com.discord.widgets.guild_role_subscriptions.setup;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.databinding.ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding;
import com.google.android.material.radiobutton.MaterialRadioButton;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildRoleSubscriptionPlanFormatRadioButton.kt */
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionPlanFormatRadioButton extends ConstraintLayout implements Checkable {
    private static final int ENTIRE_SERVER_FORMAT_TYPE = 0;
    private static final int SOME_CHANNELS_FORMAT_TYPE = 1;
    private final ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionPlanFormatRadioButton(Context context) throws Resources.NotFoundException {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding viewGuildRoleSubscriptionPlanFormatRadioButtonBindingM8398a = ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding.m8398a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionPlanFormatRadioButtonBindingM8398a, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionPlanFormatRadioButtonBindingM8398a;
        initialize$default(this, null, 1, null);
    }

    private final void configureUI(int formatType) {
        if (formatType == 0) {
            this.binding.f15489d.setText(C5419R.string.guild_role_subscription_format_all_channels_name);
            this.binding.f15488c.setText(C5419R.string.guild_role_subscription_format_all_channels_description);
            this.binding.f15490e.setImageResource(C5419R.drawable.ic_key_24dp);
        } else {
            if (formatType != 1) {
                return;
            }
            this.binding.f15489d.setText(C5419R.string.guild_role_subscription_format_some_channels_name);
            this.binding.f15488c.setText(C5419R.string.guild_role_subscription_format_some_channels_description);
            this.binding.f15490e.setImageResource(C5419R.drawable.ic_channel_text);
        }
    }

    private final void initialize(AttributeSet attrs) throws Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(C5419R.dimen.guild_role_subscription_setup_default_padding);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setBackground(ContextCompat.getDrawable(getContext(), C5419R.drawable.bg_guild_role_subscription_plan_format_radio_button));
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        int[] iArr = C5419R.a.GuildRoleSubscriptionPlanFormatRadioButton;
        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.GuildRoleSub…tionPlanFormatRadioButton");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        configureUI(typedArrayObtainStyledAttributes.getInt(0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void initialize$default(GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton, AttributeSet attributeSet, int i, Object obj) throws Resources.NotFoundException {
        if ((i & 1) != 0) {
            attributeSet = null;
        }
        guildRoleSubscriptionPlanFormatRadioButton.initialize(attributeSet);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        MaterialRadioButton materialRadioButton = this.binding.f15487b;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.guildRoleSubscriptionPlanFormatButton");
        return materialRadioButton.isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        setSelected(checked);
        ImageView imageView = this.binding.f15490e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildRoleSubscriptionPlanFormatImage");
        imageView.setSelected(checked);
        MaterialRadioButton materialRadioButton = this.binding.f15487b;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.guildRoleSubscriptionPlanFormatButton");
        materialRadioButton.setChecked(checked);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isSelected());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionPlanFormatRadioButton(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding viewGuildRoleSubscriptionPlanFormatRadioButtonBindingM8398a = ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding.m8398a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionPlanFormatRadioButtonBindingM8398a, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionPlanFormatRadioButtonBindingM8398a;
        initialize(attributeSet);
    }

    public /* synthetic */ GuildRoleSubscriptionPlanFormatRadioButton(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionPlanFormatRadioButton(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding viewGuildRoleSubscriptionPlanFormatRadioButtonBindingM8398a = ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding.m8398a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionPlanFormatRadioButtonBindingM8398a, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionPlanFormatRadioButtonBindingM8398a;
        initialize(attributeSet);
    }

    public /* synthetic */ GuildRoleSubscriptionPlanFormatRadioButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
