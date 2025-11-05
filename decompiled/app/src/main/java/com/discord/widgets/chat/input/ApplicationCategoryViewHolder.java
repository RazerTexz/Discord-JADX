package com.discord.widgets.chat.input;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.databinding.CommandCategoryItemBinding;
import com.discord.models.commands.Application;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.icon.IconUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatInputCategoriesAdapter.kt */
/* loaded from: classes2.dex */
public final class ApplicationCategoryViewHolder extends RecyclerView.ViewHolder {
    private final CommandCategoryItemBinding binding;
    private final Function1<Application, Unit> onItemSelected;

    /* compiled from: WidgetChatInputCategoriesAdapter.kt */
    /* renamed from: com.discord.widgets.chat.input.ApplicationCategoryViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Application $application;

        public AnonymousClass1(Application application) {
            this.$application = application;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ApplicationCategoryViewHolder.access$getOnItemSelected$p(ApplicationCategoryViewHolder.this).invoke(this.$application);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ApplicationCategoryViewHolder(CommandCategoryItemBinding commandCategoryItemBinding, Function1<? super Application, Unit> function1) {
        super(commandCategoryItemBinding.a);
        m.checkNotNullParameter(commandCategoryItemBinding, "binding");
        m.checkNotNullParameter(function1, "onItemSelected");
        this.binding = commandCategoryItemBinding;
        this.onItemSelected = function1;
    }

    public static final /* synthetic */ Function1 access$getOnItemSelected$p(ApplicationCategoryViewHolder applicationCategoryViewHolder) {
        return applicationCategoryViewHolder.onItemSelected;
    }

    public final void bind(Application application, boolean isSelected) {
        int themedColor;
        m.checkNotNullParameter(application, "application");
        this.binding.f2090b.setImageURI((String) null);
        SimpleDraweeView simpleDraweeView = this.binding.f2090b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.commandCategoryItemIcon");
        IconUtils.setApplicationIcon(simpleDraweeView, application);
        SimpleDraweeView simpleDraweeView2 = this.binding.f2090b;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.commandCategoryItemIcon");
        simpleDraweeView2.setSelected(isSelected);
        View view = this.binding.c.f163b;
        m.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
        view.setVisibility(isSelected ? 0 : 8);
        if (isSelected) {
            SimpleDraweeView simpleDraweeView3 = this.binding.f2090b;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.commandCategoryItemIcon");
            themedColor = ColorCompat.getThemedColor(simpleDraweeView3, R.attr.colorInteractiveActive);
        } else {
            SimpleDraweeView simpleDraweeView4 = this.binding.f2090b;
            m.checkNotNullExpressionValue(simpleDraweeView4, "binding.commandCategoryItemIcon");
            themedColor = ColorCompat.getThemedColor(simpleDraweeView4, R.attr.colorInteractiveNormal);
        }
        SimpleDraweeView simpleDraweeView5 = this.binding.f2090b;
        m.checkNotNullExpressionValue(simpleDraweeView5, "binding.commandCategoryItemIcon");
        ColorCompatKt.tintWithColor(simpleDraweeView5, themedColor);
        SimpleDraweeView simpleDraweeView6 = this.binding.f2090b;
        m.checkNotNullExpressionValue(simpleDraweeView6, "binding.commandCategoryItemIcon");
        simpleDraweeView6.setAlpha(isSelected ? 1.0f : 0.5f);
        this.itemView.setOnClickListener(new AnonymousClass1(application));
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        view2.setContentDescription(b.h(a.x(this.itemView, "itemView", "itemView.context"), R.string.command_accessibility_desc_app_item, new Object[]{application.getName()}, null, 4));
    }
}
