package com.discord.widgets.hubs;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.a;
import d0.z.d.m;

/* compiled from: WidgetHubAddNameViewModel.kt */
/* loaded from: classes2.dex */
public final /* data */ class HubAddNameArgs implements Parcelable {
    public static final Parcelable.Creator<HubAddNameArgs> CREATOR = new Creator();
    private final long guildId;

    public static class Creator implements Parcelable.Creator<HubAddNameArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubAddNameArgs createFromParcel(Parcel parcel) {
            m.checkNotNullParameter(parcel, "in");
            return new HubAddNameArgs(parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ HubAddNameArgs createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubAddNameArgs[] newArray(int i) {
            return new HubAddNameArgs[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ HubAddNameArgs[] newArray(int i) {
            return newArray(i);
        }
    }

    public HubAddNameArgs(long j) {
        this.guildId = j;
    }

    public static /* synthetic */ HubAddNameArgs copy$default(HubAddNameArgs hubAddNameArgs, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = hubAddNameArgs.guildId;
        }
        return hubAddNameArgs.copy(j);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final HubAddNameArgs copy(long guildId) {
        return new HubAddNameArgs(guildId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HubAddNameArgs) && this.guildId == ((HubAddNameArgs) other).guildId;
        }
        return true;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return b.a(this.guildId);
    }

    public String toString() {
        return a.C(a.U("HubAddNameArgs(guildId="), this.guildId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
    }
}
