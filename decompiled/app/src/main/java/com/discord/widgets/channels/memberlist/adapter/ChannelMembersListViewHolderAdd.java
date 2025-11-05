package com.discord.widgets.channels.memberlist.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelMembersListItemAddOrLeaveBinding;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ChannelMembersListViewHolderAdd.kt */
/* loaded from: classes2.dex */
public final class ChannelMembersListViewHolderAdd extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemAddOrLeaveBinding binding;

    /* compiled from: ChannelMembersListViewHolderAdd.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderAdd$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onClicked;

        public AnonymousClass1(Function0 function0) {
            this.$onClicked = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onClicked.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderAdd(WidgetChannelMembersListItemAddOrLeaveBinding widgetChannelMembersListItemAddOrLeaveBinding) {
        super(widgetChannelMembersListItemAddOrLeaveBinding.a);
        m.checkNotNullParameter(widgetChannelMembersListItemAddOrLeaveBinding, "binding");
        this.binding = widgetChannelMembersListItemAddOrLeaveBinding;
    }

    public final void bind(Function0<Unit> onClicked, @StringRes int title) {
        m.checkNotNullParameter(onClicked, "onClicked");
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.channelMembersListItemAddOrLeaveTitle");
        LinearLayout linearLayout = this.binding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        textView.setText(linearLayout.getContext().getText(title));
        this.binding.f2258b.setImageResource(R.drawable.ic_add_person_16dp);
        this.binding.a.setOnClickListener(new AnonymousClass1(onClicked));
    }
}
