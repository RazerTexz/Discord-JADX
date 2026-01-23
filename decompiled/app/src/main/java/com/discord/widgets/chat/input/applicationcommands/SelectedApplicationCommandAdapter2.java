package com.discord.widgets.chat.input.applicationcommands;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.ViewAppcommandsOptionparamListitemBinding;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.applicationcommands.SelectedAppCommandOptionAdapterItem, reason: use source file name */
/* JADX INFO: compiled from: SelectedApplicationCommandAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectedApplicationCommandAdapter2 extends MGRecyclerViewHolder<SelectedApplicationCommandAdapter, SelectedApplicationCommandAdapter8> {
    private final ViewAppcommandsOptionparamListitemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectedApplicationCommandAdapter2(SelectedApplicationCommandAdapter selectedApplicationCommandAdapter) {
        super(C5419R.layout.view_appcommands_optionparam_listitem, selectedApplicationCommandAdapter);
        Intrinsics3.checkNotNullParameter(selectedApplicationCommandAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(C5419R.id.appcommands_optiontitle_title);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.appcommands_optiontitle_title)));
        }
        ViewAppcommandsOptionparamListitemBinding viewAppcommandsOptionparamListitemBinding = new ViewAppcommandsOptionparamListitemBinding((FrameLayout) view, textView);
        Intrinsics3.checkNotNullExpressionValue(viewAppcommandsOptionparamListitemBinding, "ViewAppcommandsOptionpar…temBinding.bind(itemView)");
        this.binding = viewAppcommandsOptionparamListitemBinding;
    }

    public static final /* synthetic */ SelectedApplicationCommandAdapter access$getAdapter$p(SelectedApplicationCommandAdapter2 selectedApplicationCommandAdapter2) {
        return (SelectedApplicationCommandAdapter) selectedApplicationCommandAdapter2.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, SelectedApplicationCommandAdapter8 selectedApplicationCommandAdapter8) {
        onConfigure2(i, selectedApplicationCommandAdapter8);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, SelectedApplicationCommandAdapter8 data) {
        int themedColor;
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ApplicationCommandOption option = data.getOption();
        if (option != null) {
            TextView textView = this.binding.f15370b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.appcommandsOptiontitleTitle");
            textView.setText(option.getName());
            int i = data.getHighlighted() ? C5419R.drawable.drawable_bg_command_param_highlight : C5419R.drawable.drawable_bg_command_param_normal;
            if (data.getHighlighted()) {
                TextView textView2 = this.binding.f15370b;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.appcommandsOptiontitleTitle");
                themedColor = ColorCompat.getThemedColor(textView2, C5419R.attr.colorHeaderPrimary);
            } else if (data.getError()) {
                TextView textView3 = this.binding.f15370b;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.appcommandsOptiontitleTitle");
                themedColor = ColorCompat.getColor(textView3, C5419R.color.status_red_500);
            } else {
                TextView textView4 = this.binding.f15370b;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.appcommandsOptiontitleTitle");
                themedColor = ColorCompat.getThemedColor(textView4, C5419R.attr.colorHeaderPrimary);
            }
            if (!data.getCompleted() || data.getHighlighted()) {
                TextView textView5 = this.binding.f15370b;
                Intrinsics3.checkNotNullExpressionValue(textView5, "binding.appcommandsOptiontitleTitle");
                textView5.setAlpha(1.0f);
            } else {
                TextView textView6 = this.binding.f15370b;
                Intrinsics3.checkNotNullExpressionValue(textView6, "binding.appcommandsOptiontitleTitle");
                textView6.setAlpha(0.5f);
            }
            this.binding.f15370b.setBackgroundResource(i);
            this.binding.f15370b.setTextColor(themedColor);
            this.itemView.setOnClickListener(new SelectedApplicationCommandAdapter3(option, this, data));
        }
    }
}
