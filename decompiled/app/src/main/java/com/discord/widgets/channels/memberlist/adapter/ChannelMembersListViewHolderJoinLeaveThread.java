package com.discord.widgets.channels.memberlist.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelMembersListItemAddOrLeaveBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ChannelMembersListViewHolderJoinLeaveThread.kt */
/* loaded from: classes2.dex */
public final class ChannelMembersListViewHolderJoinLeaveThread extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemAddOrLeaveBinding binding;

    /* compiled from: ChannelMembersListViewHolderJoinLeaveThread.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderJoinLeaveThread$bind$1, reason: invalid class name */
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
    public ChannelMembersListViewHolderJoinLeaveThread(WidgetChannelMembersListItemAddOrLeaveBinding widgetChannelMembersListItemAddOrLeaveBinding) {
        super(widgetChannelMembersListItemAddOrLeaveBinding.a);
        m.checkNotNullParameter(widgetChannelMembersListItemAddOrLeaveBinding, "binding");
        this.binding = widgetChannelMembersListItemAddOrLeaveBinding;
    }

    public final void bind(Function0<Unit> onClicked, boolean isThreadJoined) {
        m.checkNotNullParameter(onClicked, "onClicked");
        LinearLayout linearLayout = this.binding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        Context context = linearLayout.getContext();
        this.binding.a.setOnClickListener(new AnonymousClass1(onClicked));
        if (isThreadJoined) {
            TextView textView = this.binding.c;
            m.checkNotNullExpressionValue(textView, "binding.channelMembersListItemAddOrLeaveTitle");
            textView.setText(context.getString(R.string.leave_thread));
            ImageView imageView = this.binding.f2258b;
            m.checkNotNullExpressionValue(context, "context");
            imageView.setImageResource(DrawableCompat.getThemedDrawableRes$default(context, R.attr.ic_exit_to_app, 0, 2, (Object) null));
            ImageView imageView2 = this.binding.f2258b;
            m.checkNotNullExpressionValue(imageView2, "binding.channelMembersListItemAddOrLeave");
            imageView2.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(context, R.attr.colorTextDanger)));
            return;
        }
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.channelMembersListItemAddOrLeaveTitle");
        textView2.setText(context.getString(R.string.join_thread));
        ImageView imageView3 = this.binding.f2258b;
        m.checkNotNullExpressionValue(context, "context");
        imageView3.setImageResource(DrawableCompat.getThemedDrawableRes$default(context, R.attr.ic_person_add, 0, 2, (Object) null));
        ImageView imageView4 = this.binding.f2258b;
        m.checkNotNullExpressionValue(imageView4, "binding.channelMembersListItemAddOrLeave");
        imageView4.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(context, R.attr.colorInteractiveNormal)));
    }
}
