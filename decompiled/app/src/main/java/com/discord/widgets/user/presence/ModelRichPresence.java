package com.discord.widgets.user.presence;

import b.d.b.a.outline;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserPresence;
import com.discord.utilities.presence.PresenceUtils;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: ModelRichPresence.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelRichPresence {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Presence presence;
    private final Application primaryApplication;

    /* compiled from: ModelRichPresence.kt */
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
            Observable observableY = storeUserPresence.observePresenceForUser(userId).Y(ModelRichPresence2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeUserPresence\n      …          }\n            }");
            return observableY;
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

    /* renamed from: component1, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* renamed from: component2, reason: from getter */
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
        StringBuilder sbU = outline.U("ModelRichPresence(presence=");
        sbU.append(this.presence);
        sbU.append(", primaryApplication=");
        sbU.append(this.primaryApplication);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ ModelRichPresence(Presence presence, Application application, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(presence, (i & 2) != 0 ? null : application);
    }
}
