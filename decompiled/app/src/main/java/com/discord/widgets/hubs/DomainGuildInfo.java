package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import com.discord.api.hubs.GuildInfo;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubDomains.kt */
/* loaded from: classes2.dex */
public final class DomainGuildInfo implements Parcelable {
    private final String icon;
    private final long id;
    private final String name;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<DomainGuildInfo> CREATOR = new Creator();

    /* compiled from: WidgetHubDomains.kt */
    public static final class Companion {
        private Companion() {
        }

        public final DomainGuildInfo from(GuildInfo guildInfo) {
            m.checkNotNullParameter(guildInfo, "guildInfo");
            return new DomainGuildInfo(guildInfo.getIcon(), guildInfo.getId(), guildInfo.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static class Creator implements Parcelable.Creator<DomainGuildInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DomainGuildInfo createFromParcel(Parcel parcel) {
            m.checkNotNullParameter(parcel, "in");
            return new DomainGuildInfo(parcel.readString(), parcel.readLong(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DomainGuildInfo createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DomainGuildInfo[] newArray(int i) {
            return new DomainGuildInfo[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DomainGuildInfo[] newArray(int i) {
            return newArray(i);
        }
    }

    public DomainGuildInfo(String str, long j, String str2) {
        m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.icon = str;
        this.id = j;
        this.name = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.icon);
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
    }
}
