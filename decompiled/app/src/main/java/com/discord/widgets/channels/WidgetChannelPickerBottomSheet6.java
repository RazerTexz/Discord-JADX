package com.discord.widgets.channels;

import android.os.Bundle;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment2;
import com.discord.api.channel.ChannelUtils;
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.widgets.channels.WidgetChannelPickerAdapter;
import com.discord.widgets.channels.WidgetChannelPickerAdapter3;
import com.discord.widgets.channels.WidgetChannelPickerBottomSheet;
import d0.Tuples;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetChannelPickerBottomSheet.kt */
/* renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheet$itemClickListener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheet6 implements WidgetChannelPickerAdapter3.OnItemClickListener {
    public final /* synthetic */ WidgetChannelPickerBottomSheet this$0;

    public WidgetChannelPickerBottomSheet6(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        this.this$0 = widgetChannelPickerBottomSheet;
    }

    @Override // com.discord.widgets.channels.WidgetChannelPickerAdapter3.OnItemClickListener
    public void onChannelItemClick(WidgetChannelPickerAdapter.ChannelItem channelItem) {
        Intrinsics3.checkNotNullParameter(channelItem, "channelItem");
        String string = WidgetChannelPickerBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getString("INTENT_EXTRA_REQUEST_CODE", "");
        WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet = this.this$0;
        Intrinsics3.checkNotNullExpressionValue(string, "requestCode");
        Fragment2.setFragmentResult(widgetChannelPickerBottomSheet, string, Bundle2.bundleOf(Tuples.to("RESULT_EXTRA_CHANNEL_ID", Long.valueOf(channelItem.getChannel().getId())), Tuples.to("RESULT_EXTRA_CHANNEL_NAME", ChannelUtils.c(channelItem.getChannel())), Tuples.to("RESULT_EXTRA_CHANNEL_ICON_RES_ID", Integer.valueOf(GuildChannelIconUtils2.guildChannelIcon(channelItem.getChannel()))), Tuples.to("RESULT_EXTRA_SELECTION_TYPE", Integer.valueOf(WidgetChannelPickerBottomSheet.SelectionType.CHANNEL.ordinal()))));
        this.this$0.dismiss();
    }

    @Override // com.discord.widgets.channels.WidgetChannelPickerAdapter3.OnItemClickListener
    public void onCreateChannelClick() {
        String string = WidgetChannelPickerBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getString("INTENT_EXTRA_REQUEST_CODE", "");
        WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet = this.this$0;
        Intrinsics3.checkNotNullExpressionValue(string, "requestCode");
        Bundle bundle = new Bundle();
        bundle.putInt("RESULT_EXTRA_SELECTION_TYPE", WidgetChannelPickerBottomSheet.SelectionType.CREATE_CHANNEL.ordinal());
        Fragment2.setFragmentResult(widgetChannelPickerBottomSheet, string, bundle);
        this.this$0.dismiss();
    }
}
