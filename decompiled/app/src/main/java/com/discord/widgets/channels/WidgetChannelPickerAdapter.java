package com.discord.widgets.channels;

import com.discord.api.channel.Channel;
import com.discord.utilities.recycler.DiffKeyProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChannelPickerAdapter.kt */
/* renamed from: com.discord.widgets.channels.ChannelPickerAdapterItem, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class WidgetChannelPickerAdapter implements DiffKeyProvider {

    /* compiled from: WidgetChannelPickerAdapter.kt */
    /* renamed from: com.discord.widgets.channels.ChannelPickerAdapterItem$ChannelItem */
    public static final /* data */ class ChannelItem extends WidgetChannelPickerAdapter {
        private final Channel channel;
        private final boolean isSelected;
        private final String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelItem(Channel channel, boolean z2) {
            super(null);
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.isSelected = z2;
            this.key = String.valueOf(channel.getId());
        }

        public static /* synthetic */ ChannelItem copy$default(ChannelItem channelItem, Channel channel, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = channelItem.channel;
            }
            if ((i & 2) != 0) {
                z2 = channelItem.isSelected;
            }
            return channelItem.copy(channel, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public final ChannelItem copy(Channel channel, boolean isSelected) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new ChannelItem(channel, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelItem)) {
                return false;
            }
            ChannelItem channelItem = (ChannelItem) other;
            return Intrinsics3.areEqual(this.channel, channelItem.channel) && this.isSelected == channelItem.isSelected;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.isSelected;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ChannelItem(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", isSelected=");
            return outline.m827O(sbM833U, this.isSelected, ")");
        }
    }

    /* compiled from: WidgetChannelPickerAdapter.kt */
    /* renamed from: com.discord.widgets.channels.ChannelPickerAdapterItem$CreateChannelItem */
    public static final class CreateChannelItem extends WidgetChannelPickerAdapter {
        public static final CreateChannelItem INSTANCE = new CreateChannelItem();
        private static final String key = "channel-picker-create-channel-item";

        private CreateChannelItem() {
            super(null);
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return key;
        }
    }

    private WidgetChannelPickerAdapter() {
    }

    public /* synthetic */ WidgetChannelPickerAdapter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
