package com.discord.widgets.user.presence;

import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserPresence;
import com.discord.utilities.presence.PresenceUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;

/* JADX INFO: compiled from: ModelRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelRichPresence {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Presence presence;
    private final Application primaryApplication;

    /* JADX INFO: compiled from: ModelRichPresence.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ Observable get$default(Companion companion, long j, StoreUserPresence storeUserPresence, int i, Object obj) {
            if ((i & 2) != 0) {
                storeUserPresence = StoreStream.INSTANCE.getPresences();
            }
            return companion.get(j, storeUserPresence);
        }

        public final Observable<ModelRichPresence> get(long userId, StoreUserPresence storeUserPresence) {
            Intrinsics3.checkNotNullParameter(storeUserPresence, "storeUserPresence");
            Observable observableM11099Y = storeUserPresence.observePresenceForUser(userId).m11099Y(ModelRichPresence2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "storeUserPresence\n      …          }\n            }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ModelRichPresence(Presence presence, Application application) {
        Intrinsics3.checkNotNullParameter(presence, "presence");
        this.presence = presence;
        this.primaryApplication = application;
    }

    public static /* synthetic */ ModelRichPresence copy$default(ModelRichPresence modelRichPresence, Presence presence, Application application, int i, Object obj) {
        if ((i & 1) != 0) {
            presence = modelRichPresence.presence;
        }
        if ((i & 2) != 0) {
            application = modelRichPresence.primaryApplication;
        }
        return modelRichPresence.copy(presence, application);
    }

    public static final Observable<ModelRichPresence> get(long j, StoreUserPresence storeUserPresence) {
        return INSTANCE.get(j, storeUserPresence);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Application getPrimaryApplication() {
        return this.primaryApplication;
    }

    public final ModelRichPresence copy(Presence presence, Application primaryApplication) {
        Intrinsics3.checkNotNullParameter(presence, "presence");
        return new ModelRichPresence(presence, primaryApplication);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelRichPresence)) {
            return false;
        }
        ModelRichPresence modelRichPresence = (ModelRichPresence) other;
        return Intrinsics3.areEqual(this.presence, modelRichPresence.presence) && Intrinsics3.areEqual(this.primaryApplication, modelRichPresence.primaryApplication);
    }

    public final Presence getPresence() {
        return this.presence;
    }

    public final Activity getPrimaryActivity() {
        return PresenceUtils.INSTANCE.getPrimaryActivity(this.presence);
    }

    public final Application getPrimaryApplication() {
        return this.primaryApplication;
    }

    public int hashCode() {
        Presence presence = this.presence;
        int iHashCode = (presence != null ? presence.hashCode() : 0) * 31;
        Application application = this.primaryApplication;
        return iHashCode + (application != null ? application.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ModelRichPresence(presence=");
        sbM833U.append(this.presence);
        sbM833U.append(", primaryApplication=");
        sbM833U.append(this.primaryApplication);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ ModelRichPresence(Presence presence, Application application, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(presence, (i & 2) != 0 ? null : application);
    }
}
