package com.discord.widgets.guilds.create;

import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.a;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import d0.z.d.m;

/* compiled from: WidgetCreationIntent.kt */
/* loaded from: classes2.dex */
public final /* data */ class CreationIntentArgs implements Parcelable {
    public static final Parcelable.Creator<CreationIntentArgs> CREATOR = new Creator();
    private final WidgetGuildCreate.Options createGuildOptions;
    private final CreateGuildTrigger trigger;

    public static class Creator implements Parcelable.Creator<CreationIntentArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CreationIntentArgs createFromParcel(Parcel parcel) {
            m.checkNotNullParameter(parcel, "in");
            return new CreationIntentArgs((CreateGuildTrigger) Enum.valueOf(CreateGuildTrigger.class, parcel.readString()), WidgetGuildCreate.Options.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CreationIntentArgs createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CreationIntentArgs[] newArray(int i) {
            return new CreationIntentArgs[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CreationIntentArgs[] newArray(int i) {
            return newArray(i);
        }
    }

    public CreationIntentArgs(CreateGuildTrigger createGuildTrigger, WidgetGuildCreate.Options options) {
        m.checkNotNullParameter(createGuildTrigger, "trigger");
        m.checkNotNullParameter(options, "createGuildOptions");
        this.trigger = createGuildTrigger;
        this.createGuildOptions = options;
    }

    public static /* synthetic */ CreationIntentArgs copy$default(CreationIntentArgs creationIntentArgs, CreateGuildTrigger createGuildTrigger, WidgetGuildCreate.Options options, int i, Object obj) {
        if ((i & 1) != 0) {
            createGuildTrigger = creationIntentArgs.trigger;
        }
        if ((i & 2) != 0) {
            options = creationIntentArgs.createGuildOptions;
        }
        return creationIntentArgs.copy(createGuildTrigger, options);
    }

    /* renamed from: component1, reason: from getter */
    public final CreateGuildTrigger getTrigger() {
        return this.trigger;
    }

    /* renamed from: component2, reason: from getter */
    public final WidgetGuildCreate.Options getCreateGuildOptions() {
        return this.createGuildOptions;
    }

    public final CreationIntentArgs copy(CreateGuildTrigger trigger, WidgetGuildCreate.Options createGuildOptions) {
        m.checkNotNullParameter(trigger, "trigger");
        m.checkNotNullParameter(createGuildOptions, "createGuildOptions");
        return new CreationIntentArgs(trigger, createGuildOptions);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreationIntentArgs)) {
            return false;
        }
        CreationIntentArgs creationIntentArgs = (CreationIntentArgs) other;
        return m.areEqual(this.trigger, creationIntentArgs.trigger) && m.areEqual(this.createGuildOptions, creationIntentArgs.createGuildOptions);
    }

    public final WidgetGuildCreate.Options getCreateGuildOptions() {
        return this.createGuildOptions;
    }

    public final CreateGuildTrigger getTrigger() {
        return this.trigger;
    }

    public int hashCode() {
        CreateGuildTrigger createGuildTrigger = this.trigger;
        int iHashCode = (createGuildTrigger != null ? createGuildTrigger.hashCode() : 0) * 31;
        WidgetGuildCreate.Options options = this.createGuildOptions;
        return iHashCode + (options != null ? options.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CreationIntentArgs(trigger=");
        sbU.append(this.trigger);
        sbU.append(", createGuildOptions=");
        sbU.append(this.createGuildOptions);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.trigger.name());
        this.createGuildOptions.writeToParcel(parcel, 0);
    }
}
