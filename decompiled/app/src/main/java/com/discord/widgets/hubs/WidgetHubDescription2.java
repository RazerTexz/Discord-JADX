package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetHubDescription.kt */
/* renamed from: com.discord.widgets.hubs.DescriptionResult, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubDescription2 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubDescription2> CREATOR = new Creator();
    private final long guildId;
    private final String hubName;

    /* renamed from: com.discord.widgets.hubs.DescriptionResult$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubDescription2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubDescription2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubDescription2(parcel.readLong(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubDescription2 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubDescription2[] newArray(int i) {
            return new WidgetHubDescription2[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubDescription2[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetHubDescription2(long j, String str) {
        Intrinsics3.checkNotNullParameter(str, "hubName");
        this.guildId = j;
        this.hubName = str;
    }

    public static /* synthetic */ WidgetHubDescription2 copy$default(WidgetHubDescription2 widgetHubDescription2, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetHubDescription2.guildId;
        }
        if ((i & 2) != 0) {
            str = widgetHubDescription2.hubName;
        }
        return widgetHubDescription2.copy(j, str);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHubName() {
        return this.hubName;
    }

    public final WidgetHubDescription2 copy(long guildId, String hubName) {
        Intrinsics3.checkNotNullParameter(hubName, "hubName");
        return new WidgetHubDescription2(guildId, hubName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubDescription2)) {
            return false;
        }
        WidgetHubDescription2 widgetHubDescription2 = (WidgetHubDescription2) other;
        return this.guildId == widgetHubDescription2.guildId && Intrinsics3.areEqual(this.hubName, widgetHubDescription2.hubName);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getHubName() {
        return this.hubName;
    }

    public int hashCode() {
        int iM3a = C0002b.m3a(this.guildId) * 31;
        String str = this.hubName;
        return iM3a + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("DescriptionResult(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", hubName=");
        return outline.m822J(sbM833U, this.hubName, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
        parcel.writeString(this.hubName);
    }
}
