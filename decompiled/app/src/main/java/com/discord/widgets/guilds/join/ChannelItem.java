package com.discord.widgets.guilds.join;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.guild.welcome.GuildWelcomeChannel;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
/* loaded from: classes2.dex */
public abstract class ChannelItem {
    public static final int TYPE_CHANNEL = 0;
    private final int type;

    /* compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
    public static final /* data */ class ChannelData extends ChannelItem {
        private final Function0<Unit> dismissSheet;
        private final Function2<Long, Integer, Unit> goToChannel;
        private final long guildId;
        private final int index;
        private final GuildWelcomeChannel welcomeChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ChannelData(GuildWelcomeChannel guildWelcomeChannel, Function0<Unit> function0, long j, Function2<? super Long, ? super Integer, Unit> function2, int i) {
            super(0, null);
            m.checkNotNullParameter(guildWelcomeChannel, "welcomeChannel");
            m.checkNotNullParameter(function0, "dismissSheet");
            m.checkNotNullParameter(function2, "goToChannel");
            this.welcomeChannel = guildWelcomeChannel;
            this.dismissSheet = function0;
            this.guildId = j;
            this.goToChannel = function2;
            this.index = i;
        }

        public static /* synthetic */ ChannelData copy$default(ChannelData channelData, GuildWelcomeChannel guildWelcomeChannel, Function0 function0, long j, Function2 function2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                guildWelcomeChannel = channelData.welcomeChannel;
            }
            if ((i2 & 2) != 0) {
                function0 = channelData.dismissSheet;
            }
            Function0 function02 = function0;
            if ((i2 & 4) != 0) {
                j = channelData.guildId;
            }
            long j2 = j;
            if ((i2 & 8) != 0) {
                function2 = channelData.goToChannel;
            }
            Function2 function22 = function2;
            if ((i2 & 16) != 0) {
                i = channelData.index;
            }
            return channelData.copy(guildWelcomeChannel, function02, j2, function22, i);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildWelcomeChannel getWelcomeChannel() {
            return this.welcomeChannel;
        }

        public final Function0<Unit> component2() {
            return this.dismissSheet;
        }

        /* renamed from: component3, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final Function2<Long, Integer, Unit> component4() {
            return this.goToChannel;
        }

        /* renamed from: component5, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        public final ChannelData copy(GuildWelcomeChannel welcomeChannel, Function0<Unit> dismissSheet, long guildId, Function2<? super Long, ? super Integer, Unit> goToChannel, int index) {
            m.checkNotNullParameter(welcomeChannel, "welcomeChannel");
            m.checkNotNullParameter(dismissSheet, "dismissSheet");
            m.checkNotNullParameter(goToChannel, "goToChannel");
            return new ChannelData(welcomeChannel, dismissSheet, guildId, goToChannel, index);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelData)) {
                return false;
            }
            ChannelData channelData = (ChannelData) other;
            return m.areEqual(this.welcomeChannel, channelData.welcomeChannel) && m.areEqual(this.dismissSheet, channelData.dismissSheet) && this.guildId == channelData.guildId && m.areEqual(this.goToChannel, channelData.goToChannel) && this.index == channelData.index;
        }

        public final Function0<Unit> getDismissSheet() {
            return this.dismissSheet;
        }

        public final Function2<Long, Integer, Unit> getGoToChannel() {
            return this.goToChannel;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final int getIndex() {
            return this.index;
        }

        public final GuildWelcomeChannel getWelcomeChannel() {
            return this.welcomeChannel;
        }

        public int hashCode() {
            GuildWelcomeChannel guildWelcomeChannel = this.welcomeChannel;
            int iHashCode = (guildWelcomeChannel != null ? guildWelcomeChannel.hashCode() : 0) * 31;
            Function0<Unit> function0 = this.dismissSheet;
            int iA = (b.a(this.guildId) + ((iHashCode + (function0 != null ? function0.hashCode() : 0)) * 31)) * 31;
            Function2<Long, Integer, Unit> function2 = this.goToChannel;
            return ((iA + (function2 != null ? function2.hashCode() : 0)) * 31) + this.index;
        }

        public String toString() {
            StringBuilder sbU = a.U("ChannelData(welcomeChannel=");
            sbU.append(this.welcomeChannel);
            sbU.append(", dismissSheet=");
            sbU.append(this.dismissSheet);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", goToChannel=");
            sbU.append(this.goToChannel);
            sbU.append(", index=");
            return a.B(sbU, this.index, ")");
        }
    }

    private ChannelItem(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }

    public /* synthetic */ ChannelItem(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
