package com.discord.widgets.chat.input;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.CommandCategoryItemBinding;
import com.discord.models.commands.Application;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.icon.IconUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChatInputCategoriesAdapter.kt */
/* renamed from: com.discord.widgets.chat.input.ApplicationCategoryViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatInputCategoriesAdapter extends RecyclerView.ViewHolder {
    private final CommandCategoryItemBinding binding;
    private final Function1<Application, Unit> onItemSelected;

    /* compiled from: WidgetChatInputCategoriesAdapter.kt */
    /* renamed from: com.discord.widgets.chat.input.ApplicationCategoryViewHolder$bind$1 */
    public static final class ViewOnClickListenerC76821 implements View.OnClickListener {
        public final /* synthetic */ Application $application;

        public ViewOnClickListenerC76821(Application application) {
            this.$application = application;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatInputCategoriesAdapter.access$getOnItemSelected$p(WidgetChatInputCategoriesAdapter.this).invoke(this.$application);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatInputCategoriesAdapter(CommandCategoryItemBinding commandCategoryItemBinding, Function1<? super Application, Unit> function1) {
        super(commandCategoryItemBinding.f15018a);
        Intrinsics3.checkNotNullParameter(commandCategoryItemBinding, "binding");
        Intrinsics3.checkNotNullParameter(function1, "onItemSelected");
        this.binding = commandCategoryItemBinding;
        this.onItemSelected = function1;
    }

    public static final /* synthetic */ Function1 access$getOnItemSelected$p(WidgetChatInputCategoriesAdapter widgetChatInputCategoriesAdapter) {
        return widgetChatInputCategoriesAdapter.onItemSelected;
    }

    public final void bind(Application application, boolean isSelected) {
        int themedColor;
        Intrinsics3.checkNotNullParameter(application, "application");
        this.binding.f15019b.setImageURI((String) null);
        SimpleDraweeView simpleDraweeView = this.binding.f15019b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.commandCategoryItemIcon");
        IconUtils.setApplicationIcon(simpleDraweeView, application);
        SimpleDraweeView simpleDraweeView2 = this.binding.f15019b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.commandCategoryItemIcon");
        simpleDraweeView2.setSelected(isSelected);
        View view = this.binding.f15020c.f1066b;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
        view.setVisibility(isSelected ? 0 : 8);
        if (isSelected) {
            SimpleDraweeView simpleDraweeView3 = this.binding.f15019b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.commandCategoryItemIcon");
            themedColor = ColorCompat.getThemedColor(simpleDraweeView3, C5419R.attr.colorInteractiveActive);
        } else {
            SimpleDraweeView simpleDraweeView4 = this.binding.f15019b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.commandCategoryItemIcon");
            themedColor = ColorCompat.getThemedColor(simpleDraweeView4, C5419R.attr.colorInteractiveNormal);
        }
        SimpleDraweeView simpleDraweeView5 = this.binding.f15019b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView5, "binding.commandCategoryItemIcon");
        ColorCompat2.tintWithColor(simpleDraweeView5, themedColor);
        SimpleDraweeView simpleDraweeView6 = this.binding.f15019b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView6, "binding.commandCategoryItemIcon");
        simpleDraweeView6.setAlpha(isSelected ? 1.0f : 0.5f);
        this.itemView.setOnClickListener(new ViewOnClickListenerC76821(application));
        View view2 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
        view2.setContentDescription(FormatUtils.m216h(outline.m885x(this.itemView, "itemView", "itemView.context"), C5419R.string.command_accessibility_desc_app_item, new Object[]{application.getName()}, null, 4));
    }
}
