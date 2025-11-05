package com.discord.widgets.channels.settings;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import d0.z.d.m;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ChannelSettings.kt */
/* loaded from: classes2.dex */
public final /* data */ class ChannelSettings {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Channel channel;
    private final boolean isMuted;
    private final String muteEndTime;

    /* compiled from: ChannelSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ChannelSettings createFromNotificationSettings(Channel channel, ModelNotificationSettings notificationSettings) {
            m.checkNotNullParameter(channel, "channel");
            m.checkNotNullParameter(notificationSettings, "notificationSettings");
            boolean zIsMuted = notificationSettings.isMuted();
            String muteEndTime = notificationSettings.getMuteEndTime();
            Iterator<ModelNotificationSettings.ChannelOverride> it = notificationSettings.getChannelOverrides().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ModelNotificationSettings.ChannelOverride next = it.next();
                m.checkNotNullExpressionValue(next, "override");
                if (next.getChannelId() == channel.getId()) {
                    zIsMuted = next.isMuted();
                    muteEndTime = next.getMuteEndTime();
                    break;
                }
            }
            return new ChannelSettings(channel, zIsMuted, muteEndTime);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ChannelSettings(Channel channel, boolean z2, String str) {
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.isMuted = z2;
        this.muteEndTime = str;
    }

    public static /* synthetic */ ChannelSettings copy$default(ChannelSettings channelSettings, Channel channel, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = channelSettings.channel;
        }
        if ((i & 2) != 0) {
            z2 = channelSettings.isMuted;
        }
        if ((i & 4) != 0) {
            str = channelSettings.muteEndTime;
        }
        return channelSettings.copy(channel, z2, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMuteEndTime() {
        return this.muteEndTime;
    }

    public final ChannelSettings copy(Channel channel, boolean isMuted, String muteEndTime) {
        m.checkNotNullParameter(channel, "channel");
        return new ChannelSettings(channel, isMuted, muteEndTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelSettings)) {
            return false;
        }
        ChannelSettings channelSettings = (ChannelSettings) other;
        return m.areEqual(this.channel, channelSettings.channel) && this.isMuted == channelSettings.isMuted && m.areEqual(this.muteEndTime, channelSettings.muteEndTime);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final String getMuteEndTime() {
        return this.muteEndTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.isMuted;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        String str = this.muteEndTime;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelSettings(channel=");
        sbU.append(this.channel);
        sbU.append(", isMuted=");
        sbU.append(this.isMuted);
        sbU.append(", muteEndTime=");
        return a.J(sbU, this.muteEndTime, ")");
    }
}
