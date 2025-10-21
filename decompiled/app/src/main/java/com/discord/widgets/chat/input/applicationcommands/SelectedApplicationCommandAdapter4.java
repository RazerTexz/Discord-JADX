package com.discord.widgets.chat.input.applicationcommands;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.ViewAppcommandsOptionheadingListitemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.Intrinsics3;

/* compiled from: SelectedApplicationCommandAdapter.kt */
/* renamed from: com.discord.widgets.chat.input.applicationcommands.SelectedAppCommandSectionHeadingAdapterItem, reason: use source file name */
/* loaded from: classes2.dex */
public final class SelectedApplicationCommandAdapter4 extends MGRecyclerViewHolder<SelectedApplicationCommandAdapter, SelectedApplicationCommandAdapter8> {
    private final ViewAppcommandsOptionheadingListitemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectedApplicationCommandAdapter4(SelectedApplicationCommandAdapter selectedApplicationCommandAdapter) {
        super(R.layout.view_appcommands_optionheading_listitem, selectedApplicationCommandAdapter);
        Intrinsics3.checkNotNullParameter(selectedApplicationCommandAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.appcommands_optionheading_title;
        TextView textView = (TextView) view.findViewById(R.id.appcommands_optionheading_title);
        if (textView != null) {
            i = R.id.divider;
            View viewFindViewById = view.findViewById(R.id.divider);
            if (viewFindViewById != null) {
                ViewAppcommandsOptionheadingListitemBinding viewAppcommandsOptionheadingListitemBinding = new ViewAppcommandsOptionheadingListitemBinding((ConstraintLayout) view, textView, viewFindViewById);
                Intrinsics3.checkNotNullExpressionValue(viewAppcommandsOptionheadingListitemBinding, "ViewAppcommandsOptionhea…temBinding.bind(itemView)");
                this.binding = viewAppcommandsOptionheadingListitemBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, SelectedApplicationCommandAdapter8 selectedApplicationCommandAdapter8) {
        onConfigure2(i, selectedApplicationCommandAdapter8);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, SelectedApplicationCommandAdapter8 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        TextView textView = this.binding.f2171b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.appcommandsOptionheadingTitle");
        textView.setText(data.getHeading());
    }
}
