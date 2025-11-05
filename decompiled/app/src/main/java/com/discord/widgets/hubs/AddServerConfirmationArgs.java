package com.discord.widgets.hubs;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.a;
import d0.z.d.m;

/* compiled from: WidgetHubAddServerConfirmationDialog.kt */
/* loaded from: classes2.dex */
public final /* data */ class AddServerConfirmationArgs implements Parcelable {
    public static final Parcelable.Creator<AddServerConfirmationArgs> CREATOR = new Creator();
    private final long guildId;
    private final String hubName;

    public static class Creator implements Parcelable.Creator<AddServerConfirmationArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AddServerConfirmationArgs createFromParcel(Parcel parcel) {
            m.checkNotNullParameter(parcel, "in");
            return new AddServerConfirmationArgs(parcel.readLong(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AddServerConfirmationArgs createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AddServerConfirmationArgs[] newArray(int i) {
            return new AddServerConfirmationArgs[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AddServerConfirmationArgs[] newArray(int i) {
            return newArray(i);
        }
    }

    public AddServerConfirmationArgs(long j, String str) {
        m.checkNotNullParameter(str, "hubName");
        this.guildId = j;
        this.hubName = str;
    }

    public static /* synthetic */ AddServerConfirmationArgs copy$default(AddServerConfirmationArgs addServerConfirmationArgs, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = addServerConfirmationArgs.guildId;
        }
        if ((i & 2) != 0) {
            str = addServerConfirmationArgs.hubName;
        }
        return addServerConfirmationArgs.copy(j, str);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHubName() {
        return this.hubName;
    }

    public final AddServerConfirmationArgs copy(long guildId, String hubName) {
        m.checkNotNullParameter(hubName, "hubName");
        return new AddServerConfirmationArgs(guildId, hubName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddServerConfirmationArgs)) {
            return false;
        }
        AddServerConfirmationArgs addServerConfirmationArgs = (AddServerConfirmationArgs) other;
        return this.guildId == addServerConfirmationArgs.guildId && m.areEqual(this.hubName, addServerConfirmationArgs.hubName);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getHubName() {
        return this.hubName;
    }

    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        String str = this.hubName;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("AddServerConfirmationArgs(guildId=");
        sbU.append(this.guildId);
        sbU.append(", hubName=");
        return a.J(sbU, this.hubName, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
        parcel.writeString(this.hubName);
    }
}
