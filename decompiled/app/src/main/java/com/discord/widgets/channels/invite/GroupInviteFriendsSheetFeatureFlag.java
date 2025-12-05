package com.discord.widgets.channels.invite;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GroupInviteFriendsSheetFeatureFlag.kt */
/* loaded from: classes2.dex */
public final class GroupInviteFriendsSheetFeatureFlag {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(GroupInviteFriendsSheetFeatureFlag2.INSTANCE);
    private final StoreExperiments storeExperiments;

    /* compiled from: GroupInviteFriendsSheetFeatureFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        public final GroupInviteFriendsSheetFeatureFlag getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = GroupInviteFriendsSheetFeatureFlag.access$getINSTANCE$cp();
            Companion companion = GroupInviteFriendsSheetFeatureFlag.INSTANCE;
            return (GroupInviteFriendsSheetFeatureFlag) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GroupInviteFriendsSheetFeatureFlag() {
        this(null, 1, null);
    }

    public GroupInviteFriendsSheetFeatureFlag(StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean isEnabled() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2020-12_invite_to_gdm", true);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }

    public /* synthetic */ GroupInviteFriendsSheetFeatureFlag(StoreExperiments storeExperiments, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments);
    }
}
