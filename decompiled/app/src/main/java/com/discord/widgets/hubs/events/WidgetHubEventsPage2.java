package com.discord.widgets.hubs.events;

import android.os.Parcel;
import android.os.Parcelable;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetHubEventsPage.kt */
/* renamed from: com.discord.widgets.hubs.events.HubEventsArgs, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubEventsPage2 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubEventsPage2> CREATOR = new Creator();
    private final long directoryChannelId;
    private final long guildId;

    /* renamed from: com.discord.widgets.hubs.events.HubEventsArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubEventsPage2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubEventsPage2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubEventsPage2(parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubEventsPage2 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubEventsPage2[] newArray(int i) {
            return new WidgetHubEventsPage2[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubEventsPage2[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetHubEventsPage2(long j, long j2) {
        this.guildId = j;
        this.directoryChannelId = j2;
    }

    public static /* synthetic */ WidgetHubEventsPage2 copy$default(WidgetHubEventsPage2 widgetHubEventsPage2, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetHubEventsPage2.guildId;
        }
        if ((i & 2) != 0) {
            j2 = widgetHubEventsPage2.directoryChannelId;
        }
        return widgetHubEventsPage2.copy(j, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    public final WidgetHubEventsPage2 copy(long guildId, long directoryChannelId) {
        return new WidgetHubEventsPage2(guildId, directoryChannelId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubEventsPage2)) {
            return false;
        }
        WidgetHubEventsPage2 widgetHubEventsPage2 = (WidgetHubEventsPage2) other;
        return this.guildId == widgetHubEventsPage2.guildId && this.directoryChannelId == widgetHubEventsPage2.directoryChannelId;
    }

    public final long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return C0002b.m3a(this.directoryChannelId) + (C0002b.m3a(this.guildId) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("HubEventsArgs(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", directoryChannelId=");
        return outline.m815C(sbM833U, this.directoryChannelId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
        parcel.writeLong(this.directoryChannelId);
    }
}
