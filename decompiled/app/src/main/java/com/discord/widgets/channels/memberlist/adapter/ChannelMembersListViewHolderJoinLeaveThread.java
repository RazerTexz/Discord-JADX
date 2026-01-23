package com.discord.widgets.channels.memberlist.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelMembersListItemAddOrLeaveBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ChannelMembersListViewHolderJoinLeaveThread.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderJoinLeaveThread extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemAddOrLeaveBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderJoinLeaveThread$bind$1 */
    /* JADX INFO: compiled from: ChannelMembersListViewHolderJoinLeaveThread.kt */
    public static final class ViewOnClickListenerC75141 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onClicked;

        public ViewOnClickListenerC75141(Function0 function0) {
            this.$onClicked = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onClicked.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderJoinLeaveThread(WidgetChannelMembersListItemAddOrLeaveBinding widgetChannelMembersListItemAddOrLeaveBinding) {
        super(widgetChannelMembersListItemAddOrLeaveBinding.f15853a);
        Intrinsics3.checkNotNullParameter(widgetChannelMembersListItemAddOrLeaveBinding, "binding");
        this.binding = widgetChannelMembersListItemAddOrLeaveBinding;
    }

    public final void bind(Function0<Unit> onClicked, boolean isThreadJoined) {
        Intrinsics3.checkNotNullParameter(onClicked, "onClicked");
        LinearLayout linearLayout = this.binding.f15853a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        Context context = linearLayout.getContext();
        this.binding.f15853a.setOnClickListener(new ViewOnClickListenerC75141(onClicked));
        if (isThreadJoined) {
            TextView textView = this.binding.f15855c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelMembersListItemAddOrLeaveTitle");
            textView.setText(context.getString(C5419R.string.leave_thread));
            ImageView imageView = this.binding.f15854b;
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            imageView.setImageResource(DrawableCompat.getThemedDrawableRes$default(context, C5419R.attr.ic_exit_to_app, 0, 2, (Object) null));
            ImageView imageView2 = this.binding.f15854b;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.channelMembersListItemAddOrLeave");
            imageView2.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(context, C5419R.attr.colorTextDanger)));
            return;
        }
        TextView textView2 = this.binding.f15855c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelMembersListItemAddOrLeaveTitle");
        textView2.setText(context.getString(C5419R.string.join_thread));
        ImageView imageView3 = this.binding.f15854b;
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        imageView3.setImageResource(DrawableCompat.getThemedDrawableRes$default(context, C5419R.attr.ic_person_add, 0, 2, (Object) null));
        ImageView imageView4 = this.binding.f15854b;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.channelMembersListItemAddOrLeave");
        imageView4.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(context, C5419R.attr.colorInteractiveNormal)));
    }
}
